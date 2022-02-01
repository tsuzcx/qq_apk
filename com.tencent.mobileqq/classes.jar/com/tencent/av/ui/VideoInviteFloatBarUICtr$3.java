package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.GAudioFriends;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.av.utils.TraeHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoInviteFloatBarUICtr$3
  extends GAudioUIObserver
{
  VideoInviteFloatBarUICtr$3(VideoInviteFloatBarUICtr paramVideoInviteFloatBarUICtr) {}
  
  public void a(long paramLong, int paramInt)
  {
    super.a(paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onDestroyInviteUI-->reason=" + paramInt);
    }
    if ((this.a.jdField_a_of_type_Long == paramLong) || (0L == paramLong)) {
      this.a.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "onCreateRoomSuc-->GroupID=" + paramLong2);
    }
    this.a.jdField_a_of_type_ComTencentAvAppSessionInfo.an = true;
    if (this.a.jdField_b_of_type_Int == 1) {
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(paramLong2);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "notifyCloseGroupVideoInviteMsgBoxByInviteId-->groupId=" + paramLong);
    }
    if ((this.a.jdField_a_of_type_Long == paramLong) && (this.a.e.equals(paramString))) {
      this.a.a();
    }
  }
  
  public void a(long paramLong, ArrayList<VideoController.GAudioFriends> paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      if (String.valueOf(((VideoController.GAudioFriends)paramArrayList.next()).jdField_a_of_type_Long).equalsIgnoreCase(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getAccount())) {
        this.a.a();
      }
    }
  }
  
  public void b()
  {
    super.b();
    this.a.a(false);
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("VideoInviteFloatBarUICtr", 1, "onEnterRoomSuc, groupId[" + paramLong2 + "], seq[" + paramLong1 + "]");
    }
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new VideoInviteFloatBarUICtr.3.1(this, paramLong2), 500L);
    this.a.jdField_a_of_type_ComTencentAvVideoController.b();
    SmallScreenActivityPlugin.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface).a(paramLong1, false);
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoInviteFloatBar.c();
    }
    TraeHelper.a().a(this.a.f);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_b_of_type_JavaLangRunnable, 1000L);
  }
  
  public void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr.troopgroup_vedio.invite", 2, "groupId:" + paramLong1 + ", memUin:" + paramLong2 + ",invitedId:" + paramString + ", mInviterUin:" + this.a.jdField_b_of_type_Long + ", mGroupId:" + this.a.jdField_a_of_type_Long);
    }
    if ((paramLong2 == this.a.jdField_b_of_type_Long) && (paramLong1 == this.a.jdField_a_of_type_Long)) {
      this.a.a();
    }
  }
  
  public void d(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "notifyCloseAllGroupVideoInviteMsgBox-->notifyByGroupId=" + paramLong);
    }
    if (this.a.jdField_a_of_type_Long != paramLong) {}
    this.a.a();
  }
  
  public void e(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInviteFloatBarUICtr", 2, "notifyCloseGroupVideoInviteMsgBox-->groupId=" + paramLong);
    }
    if (this.a.jdField_a_of_type_Long == paramLong) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteFloatBarUICtr.3
 * JD-Core Version:    0.7.0.1
 */