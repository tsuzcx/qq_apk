package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class MultiIncomingCallUICtr$3
  extends GAudioUIObserver
{
  MultiIncomingCallUICtr$3(MultiIncomingCallUICtr paramMultiIncomingCallUICtr) {}
  
  public void a(long paramLong, int paramInt)
  {
    if (this.a.jdField_b_of_type_Boolean)
    {
      long l = AudioHelper.b();
      if (QLog.isColorLevel()) {
        QLog.w("MultiIncomingCallUICtr", 1, "onDestroyInviteUI, groupId[" + paramLong + "], mPeerUin[" + this.a.jdField_c_of_type_JavaLangString + "], seq[" + l + "]");
      }
      if ((this.a.jdField_c_of_type_JavaLangString != null) && (this.a.jdField_c_of_type_JavaLangString.equals(String.valueOf(paramLong))))
      {
        this.a.a(l, paramInt);
        this.a.a();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiIncomingCallUICtr", 2, "onDestroyInviteUI, groupId:" + paramLong + ", reason:" + paramInt + ", mGroupId:" + this.a.jdField_a_of_type_Long);
      }
      return;
      if ((this.a.jdField_a_of_type_Long == paramLong) || (0L == paramLong)) {
        this.a.a();
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "onCreateRoomSuc-->GroupID=" + paramLong2);
    }
    this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.an = true;
    if (this.a.jdField_b_of_type_Int == 1) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramLong2);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "notifyCloseGroupVideoInviteMsgBoxByInviteId-->GroupID=" + paramLong);
    }
    if ((this.a.jdField_a_of_type_Long == paramLong) && (this.a.e.equals(paramString))) {
      this.a.a();
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("MultiIncomingCallUICtr", 1, "onEnterRoomSuc, groupId[" + paramLong2 + "], seq[" + paramLong1 + "]");
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
  
  public void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr.troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.a.jdField_b_of_type_Long + ", mGroupId:" + this.a.jdField_a_of_type_Long);
    }
    if ((paramLong2 == this.a.jdField_b_of_type_Long) && (paramLong1 == this.a.jdField_a_of_type_Long)) {
      this.a.a();
    }
  }
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "notifyCloseAllGroupVideoInviteMsgBox-->GroupID=" + paramLong);
    }
    if (this.a.jdField_a_of_type_Long != paramLong) {
      this.a.b(0);
    }
    this.a.a();
  }
  
  public void e(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiIncomingCallUICtr", 2, "notifyCloseGroupVideoInviteMsgBox-->GroupID=" + paramLong);
    }
    if (this.a.jdField_a_of_type_Long == paramLong) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallUICtr.3
 * JD-Core Version:    0.7.0.1
 */