package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.VideoViewInfo;
import com.tencent.av.tips.TipsUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class DoubleVideoMeetingCtrlUI$1
  extends GAudioUIObserver
{
  DoubleVideoMeetingCtrlUI$1(DoubleVideoMeetingCtrlUI paramDoubleVideoMeetingCtrlUI) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.d, 2, "onGAudioInviteResp");
    }
    AVActivity localAVActivity = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localAVActivity != null) && (!localAVActivity.isFinishing())) {
      localAVActivity.runOnUiThread(new DoubleVideoMeetingCtrlUI.1.1(this));
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.d, 2, "onDestory UI-->relationId = " + paramLong);
    }
    if (this.a.jdField_a_of_type_Long == paramLong) {
      this.a.b(true);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.d, 2, "onDestroyInviteUI-->GroupId = " + paramLong);
    }
    if (paramLong == this.a.jdField_a_of_type_Long)
    {
      super.a(paramLong);
      this.a.b(true);
    }
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, long paramLong3, long paramLong4, int paramInt2)
  {
    if (this.a.h()) {}
    label381:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.w(this.a.d, 1, "onGaOperationResult, result[" + paramInt1 + "], uin[" + paramLong2 + "], info[" + paramLong3 + "], groupId[" + paramLong4 + "], relationType[" + paramInt2 + "], mCameraNum[" + this.a.q + "], seq[" + paramLong1 + "]");
      }
      SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
      switch (paramInt1)
      {
      case 93: 
      case 94: 
      case 95: 
      case 97: 
      case 98: 
      default: 
        return;
      case 90: 
        if (paramLong3 == 3L) {
          if (this.a.jdField_a_of_type_ComTencentAvUiQavPanel != null)
          {
            if (this.a.q <= 1) {
              break label381;
            }
            this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374085, 0);
          }
        }
        break;
      case 96: 
        for (;;)
        {
          if ((!localSessionInfo.j) || (this.a.c))
          {
            this.a.c = false;
            this.a.j(paramLong1);
            paramInt1 = localSessionInfo.a(this.a.jdField_b_of_type_Long, 1);
            boolean bool = false;
            if (paramInt1 != -1) {
              bool = ((VideoViewInfo)localSessionInfo.c.get(paramInt1)).a;
            }
            this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(105), Boolean.valueOf(bool), Long.valueOf(paramLong1) });
          }
          DoubleVideoMeetingCtrlUI.a(this.a, paramLong1);
          return;
          if ((paramLong3 != 1L) || (localSessionInfo.ar)) {
            break;
          }
          this.a.e("onGaOperationResult->REQUEST_VIDEO_SUC");
          this.a.a(paramLong1, localSessionInfo.c);
          return;
          this.a.jdField_a_of_type_ComTencentAvUiQavPanel.setViewVisibility(2131374085, 8);
        }
      }
    } while ((paramLong3 == 2L) || (paramLong3 != 4L));
    return;
    this.a.c(paramLong1, true);
    this.a.o(paramLong1);
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(106), Long.valueOf(paramLong1) });
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.d, 2, "onCreateRoomSuc-->relationId = " + paramLong2);
    }
    if (paramLong2 != this.a.jdField_a_of_type_Long) {
      return;
    }
    this.a.a(paramLong1, true);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.a.d, 1, "onMemberVideoOut, groupId[" + paramLong2 + "], friendUin[" + paramLong3 + "], videoSrcType[" + paramInt + "], seq[" + paramLong1 + "]");
    }
    this.a.a(paramLong1, paramLong2, paramLong3, 2);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.d, 1, "onMemberLeave, groupId[" + paramLong1 + "], friendUin[" + paramLong2 + "], isQQUser[" + paramBoolean + "], seq[" + l + "]");
    }
    this.a.a(l, paramLong1, paramLong2, 6);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.d, 1, "onMemberJoin, groupId[" + paramLong1 + "], friendUin[" + paramLong2 + "], isRfresh[" + paramBoolean1 + "], isQQUser[" + paramBoolean2 + "], seq[" + l + "]");
    }
    if (paramLong2 == this.a.jdField_a_of_type_Long)
    {
      this.a.jdField_a_of_type_ComTencentAvVideoController.a().ag = 1;
      this.a.a(l, paramLong1, paramLong2, 5);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt) {}
  
  public void b(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.d, 2, "EnterRoomSuc-->GroupId = " + paramLong2);
    }
    if (paramLong2 == this.a.jdField_a_of_type_Long) {
      this.a.B(paramLong1);
    }
    this.a.a(paramLong1, false);
  }
  
  public void b(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.d, 1, "onGaMemberShareSrcInOrOut, groupId[" + paramLong1 + "], groupId[" + paramLong1 + "], bIn[" + paramBoolean1 + "], isPPT[" + paramBoolean2 + "], seq[" + l + "]");
    }
    if (paramBoolean1) {
      this.a.a(l, paramLong1, paramLong2, 3);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_Boolean = paramBoolean2;
      return;
      this.a.a(l, paramLong1, paramLong2, 4);
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentAvVideoController == null) {
      return;
    }
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.d, 1, "onFirstFrameDataComeIn, uin[" + paramLong + "], videoSrcType[" + paramInt + "], seq[" + l + "]");
    }
    paramInt = this.a.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, paramInt);
    if ((paramInt != -1) && (((VideoViewInfo)this.a.jdField_a_of_type_ComTencentAvVideoController.a().c.get(paramInt)).a))
    {
      TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1036);
      TipsUtil.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1037);
    }
    DoubleVideoMeetingCtrlUI.b(this.a, l);
    this.a.f("OnFirstFrameDataComeIn");
  }
  
  public void c(long paramLong1, long paramLong2)
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w(this.a.d, 1, "onMemberVideoIn, groupId[" + paramLong1 + "], friendUin[" + paramLong2 + "], seq[" + l + "]");
    }
    this.a.a(l, paramLong1, paramLong2, 1);
  }
  
  public void d(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVShare", 2, "onMeetingNotifyTimeout, relationId[" + paramLong2 + "]");
    }
    SessionInfo localSessionInfo = this.a.jdField_a_of_type_ComTencentAvVideoController.a();
    if ((paramLong2 == this.a.jdField_a_of_type_Long) && (localSessionInfo.g == paramLong2)) {
      this.a.a(paramLong1, localSessionInfo, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoMeetingCtrlUI.1
 * JD-Core Version:    0.7.0.1
 */