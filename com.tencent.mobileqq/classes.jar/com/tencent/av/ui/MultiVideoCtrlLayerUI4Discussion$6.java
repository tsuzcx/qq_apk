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
      String str = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInviteUserNotice --> Count = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ,firstName = ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (this.b.al != null)
    {
      if (QAVHrMeeting.b(this.b.al.f(String.valueOf(this.b.j)))) {
        paramString = this.b.am.a(this.b.al.getCurrentAccountUin(), String.valueOf(this.b.j), this.b.h);
      }
      this.b.V.a(paramInt, paramString);
      this.b.al.a().postDelayed(this.b.V, 500L);
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (this.b.V()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreateRoomSuc, groupId[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], isVideo[");
      localStringBuilder.append(this.b.H);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    int i;
    if (this.b.H) {
      i = 2;
    } else {
      i = 1;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.am.ap());
    ((StringBuilder)localObject).append("");
    MultiVideoRichActionReportCollection.a(i, ((StringBuilder)localObject).toString());
    if (this.b.H) {
      i = 4;
    } else {
      i = 3;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.am.ap());
    ((StringBuilder)localObject).append("");
    VoiceChangeDataReport.a(i, ((StringBuilder)localObject).toString());
    this.b.M();
    this.b.t(paramLong1);
    this.b.aR.c(true);
    this.b.aR.b(true);
    this.b.aR.a();
    this.b.am.k().bv = true;
    this.b.a(true, paramLong2);
  }
  
  protected void a(String paramString, String[] paramArrayOfString)
  {
    super.a(paramString, paramArrayOfString);
    long l = this.b.al.f(String.valueOf(this.b.j));
    if (QLog.isColorLevel())
    {
      String str1 = this.b.am.a(paramString, String.valueOf(this.b.j), this.b.h);
      String str2 = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOtherMemberInvited --> l= ");
      localStringBuilder.append(String.valueOf(l));
      localStringBuilder.append("inviterName=");
      localStringBuilder.append(str1);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    if (QAVHrMeeting.b(l))
    {
      this.b.b(paramString, paramArrayOfString);
      return;
    }
    this.b.a(paramString, paramArrayOfString);
  }
  
  protected void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.b.X, 2, "onServiceConnected");
    }
    super.b();
    if (this.b.j != 0L)
    {
      int i = this.b.g;
      Object localObject = String.valueOf(this.b.j);
      this.b.al.b(i, (String)localObject);
      if ((this.b.f == 0) && (this.b.am != null))
      {
        Intent localIntent = this.b.P();
        if ((localIntent == null) || (!localIntent.hasExtra("invitelist")))
        {
          localObject = this.b.al.g((String)localObject);
          if (localObject != null)
          {
            this.b.am.a((long[])localObject);
            this.b.am.a((long[])localObject, false);
          }
        }
      }
    }
  }
  
  protected void b(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInviteSomeoneEnter, firstUin[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], length[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    super.b(paramLong, paramInt);
    Object localObject = this.b;
    ((MultiVideoCtrlLayerUI4Discussion)localObject).m = paramInt;
    ((MultiVideoCtrlLayerUI4Discussion)localObject).a(paramLong, 68, true, -1, 0);
  }
  
  protected void b(long paramLong, int paramInt1, int paramInt2)
  {
    this.b.b(paramLong, paramInt1, paramInt2);
  }
  
  protected void b(long paramLong1, long paramLong2)
  {
    if (this.b.V()) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = this.b.X;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterRoomSuc, groupId[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("]");
      QLog.w((String)localObject, 1, localStringBuilder.toString());
    }
    int i;
    if (this.b.H) {
      i = 4;
    } else {
      i = 3;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.am.ap());
    ((StringBuilder)localObject).append("");
    VoiceChangeDataReport.a(i, ((StringBuilder)localObject).toString());
    if (this.b.H) {
      i = 2;
    } else {
      i = 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.b.am.ap());
    ((StringBuilder)localObject).append("");
    MultiVideoRichActionReportCollection.a(i, ((StringBuilder)localObject).toString());
    this.b.M();
    this.b.t(paramLong1);
    this.b.aR.c(true);
    this.b.aR.b(true);
    this.b.aR.a();
    this.b.al.a().postDelayed(new MultiVideoCtrlLayerUI4Discussion.AutoCheckVideoRunnable(this.b), 500L);
    this.b.O();
    this.b.a(false, paramLong2);
    this.b.f(paramLong1, 16777215);
    this.b.S();
  }
  
  protected void d()
  {
    if (this.b.h != 2) {
      return;
    }
    this.b.f(0L, 16777215);
  }
  
  protected void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d(this.b.X, 2, "onUpdatePstnInfo --> Start");
    }
    AVActivity localAVActivity = (AVActivity)this.b.ak.get();
    if (localAVActivity != null)
    {
      localAVActivity.runOnUiThread(new MultiVideoCtrlLayerUI4Discussion.6.1(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.b.X, 2, "onUpdatePstnInfo-->Can not get AVActivity");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.6
 * JD-Core Version:    0.7.0.1
 */