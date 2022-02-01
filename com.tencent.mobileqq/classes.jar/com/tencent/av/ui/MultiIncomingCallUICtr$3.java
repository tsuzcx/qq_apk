package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;

class MultiIncomingCallUICtr$3
  extends GAudioUIObserver
{
  MultiIncomingCallUICtr$3(MultiIncomingCallUICtr paramMultiIncomingCallUICtr) {}
  
  protected void a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (this.a.jdField_b_of_type_Boolean)
    {
      long l = AudioHelper.b();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestroyInviteUI, groupId[");
        localStringBuilder.append(paramLong);
        localStringBuilder.append("], mPeerUin[");
        localStringBuilder.append(this.a.jdField_c_of_type_JavaLangString);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(l);
        localStringBuilder.append("]");
        QLog.w("MultiIncomingCallUICtr", 1, localStringBuilder.toString());
      }
      if ((this.a.jdField_c_of_type_JavaLangString != null) && (this.a.jdField_c_of_type_JavaLangString.equals(String.valueOf(paramLong))))
      {
        this.a.a(l, paramInt);
        this.a.a();
      }
    }
    else if ((this.a.jdField_a_of_type_Long == paramLong) || (0L == paramLong))
    {
      this.a.a();
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroyInviteUI, groupId:");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", reason:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", mGroupId:");
      localStringBuilder.append(this.a.jdField_a_of_type_Long);
      QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateRoomSuc-->GroupID=");
      localStringBuilder.append(paramLong2);
      QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
    }
    this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.ab = true;
    if (this.a.jdField_b_of_type_Int == 1) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramLong2);
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyCloseGroupVideoInviteMsgBoxByInviteId-->GroupID=");
      localStringBuilder.append(paramLong);
      QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
    }
    if ((this.a.jdField_a_of_type_Long == paramLong) && (this.a.e.equals(paramString))) {
      this.a.a();
    }
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterRoomSuc, groupId[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.w("MultiIncomingCallUICtr", 1, localStringBuilder.toString());
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiIncomingCallUICtr.3.1(this, paramLong2), 500L);
    this.a.f();
    SmallScreenActivityPlugin.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(paramLong1, false);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c();
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_c_of_type_JavaLangRunnable, 1000L);
    TraeHelper.a().a(this.a.f);
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("groupId:");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", memUin:");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",invitedId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mInviterUin:");
      localStringBuilder.append(this.a.jdField_b_of_type_Long);
      localStringBuilder.append(", mGroupId:");
      localStringBuilder.append(this.a.jdField_a_of_type_Long);
      QLog.d("MultiIncomingCallUICtr.troopgroup_vedio.invite", 2, localStringBuilder.toString());
    }
    if ((paramLong2 == this.a.jdField_b_of_type_Long) && (paramLong1 == this.a.jdField_a_of_type_Long)) {
      this.a.a();
    }
  }
  
  protected void d(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyCloseAllGroupVideoInviteMsgBox-->GroupID=");
      localStringBuilder.append(paramLong);
      QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
    }
    if (this.a.jdField_a_of_type_Long != paramLong) {
      this.a.b(0);
    }
    this.a.a();
  }
  
  protected void e(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyCloseGroupVideoInviteMsgBox-->GroupID=");
      localStringBuilder.append(paramLong);
      QLog.d("MultiIncomingCallUICtr", 2, localStringBuilder.toString());
    }
    if (this.a.jdField_a_of_type_Long == paramLong) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr.3
 * JD-Core Version:    0.7.0.1
 */