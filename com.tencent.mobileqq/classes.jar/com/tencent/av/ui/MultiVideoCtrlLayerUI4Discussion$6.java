package com.tencent.av.ui;

import android.content.Intent;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.SensorHelper;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class MultiVideoCtrlLayerUI4Discussion$6
  extends GAudioUIObserver
{
  MultiVideoCtrlLayerUI4Discussion$6(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion) {}
  
  protected void a(int paramInt, String paramString)
  {
    super.a(paramInt, paramString);
    if (QLog.isColorLevel())
    {
      String str = this.a.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInviteUserNotice --> Count = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ,firstName = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      if (QAVHrMeeting.b(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.a.b)))) {
        paramString = this.a.jdField_a_of_type_ComTencentAvVideoController.a(this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin(), String.valueOf(this.a.b), this.a.jdField_e_of_type_Int);
      }
      this.a.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable.a(paramInt, paramString);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.a.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase$InviteUserNoticeRunnable, 500L);
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (this.a.h()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.a.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateRoomSuc, groupId[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], isVideo[");
      localStringBuilder.append(this.a.jdField_e_of_type_Boolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    int i;
    if (this.a.jdField_e_of_type_Boolean) {
      i = 2;
    } else {
      i = 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvVideoController.d());
    ((StringBuilder)localObject).append("");
    MultiVideoRichActionReportCollection.a(i, ((StringBuilder)localObject).toString());
    if (this.a.jdField_e_of_type_Boolean) {
      i = 4;
    } else {
      i = 3;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvVideoController.d());
    ((StringBuilder)localObject).append("");
    VoiceChangeDataReport.a(i, ((StringBuilder)localObject).toString());
    this.a.z();
    this.a.q(paramLong1);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a();
    this.a.jdField_a_of_type_ComTencentAvVideoController.a().ab = true;
    this.a.a(true, paramLong2);
  }
  
  protected void a(String paramString, String[] paramArrayOfString)
  {
    super.a(paramString, paramArrayOfString);
    long l = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(String.valueOf(this.a.b));
    if (QLog.isColorLevel())
    {
      String str1 = this.a.jdField_a_of_type_ComTencentAvVideoController.a(paramString, String.valueOf(this.a.b), this.a.jdField_e_of_type_Int);
      String str2 = this.a.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOtherMemberInvited --> l= ");
      localStringBuilder.append(String.valueOf(l));
      localStringBuilder.append("inviterName=");
      localStringBuilder.append(str1);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    if (QAVHrMeeting.b(l))
    {
      this.a.b(paramString, paramArrayOfString);
      return;
    }
    this.a.a(paramString, paramArrayOfString);
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_d_of_type_JavaLangString, 2, "onServiceConnected");
    }
    super.b();
    if (this.a.b != 0L)
    {
      int i = this.a.jdField_d_of_type_Int;
      Object localObject = String.valueOf(this.a.b);
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(i, (String)localObject);
      if ((this.a.c == 0) && (this.a.jdField_a_of_type_ComTencentAvVideoController != null))
      {
        Intent localIntent = this.a.a();
        if ((localIntent == null) || (!localIntent.hasExtra("invitelist")))
        {
          localObject = this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a((String)localObject);
          if (localObject != null)
          {
            this.a.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject);
            this.a.jdField_a_of_type_ComTencentAvVideoController.a((long[])localObject, false);
          }
        }
      }
    }
  }
  
  protected void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.a.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInviteSomeoneEnter, firstUin[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], length[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    super.b(paramLong, paramInt);
    Object localObject = this.a;
    ((MultiVideoCtrlLayerUI4Discussion)localObject).g = paramInt;
    ((MultiVideoCtrlLayerUI4Discussion)localObject).a(paramLong, 68, true, -1, 0);
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    this.a.b(paramLong, paramInt1, paramInt2);
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (this.a.h()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.a.jdField_d_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterRoomSuc, groupId[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    int i;
    if (this.a.jdField_e_of_type_Boolean) {
      i = 4;
    } else {
      i = 3;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvVideoController.d());
    ((StringBuilder)localObject).append("");
    VoiceChangeDataReport.a(i, ((StringBuilder)localObject).toString());
    if (this.a.jdField_e_of_type_Boolean) {
      i = 2;
    } else {
      i = 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a.jdField_a_of_type_ComTencentAvVideoController.d());
    ((StringBuilder)localObject).append("");
    MultiVideoRichActionReportCollection.a(i, ((StringBuilder)localObject).toString());
    this.a.z();
    this.a.q(paramLong1);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.c(true);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.b(true);
    this.a.jdField_a_of_type_ComTencentAvUtilsSensorHelper.a();
    this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(new MultiVideoCtrlLayerUI4Discussion.AutoCheckVideoRunnable(this.a), 500L);
    this.a.B();
    this.a.a(false, paramLong2);
    this.a.i(paramLong1, 16777215);
    this.a.E();
  }
  
  protected void d()
  {
    if (this.a.jdField_e_of_type_Int != 2) {
      return;
    }
    this.a.i(0L, 16777215);
  }
  
  protected void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_d_of_type_JavaLangString, 2, "onUpdatePstnInfo --> Start");
    }
    AVActivity localAVActivity = (AVActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localAVActivity != null)
    {
      localAVActivity.runOnUiThread(new MultiVideoCtrlLayerUI4Discussion.6.1(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.a.jdField_d_of_type_JavaLangString, 2, "onUpdatePstnInfo-->Can not get AVActivity");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.6
 * JD-Core Version:    0.7.0.1
 */