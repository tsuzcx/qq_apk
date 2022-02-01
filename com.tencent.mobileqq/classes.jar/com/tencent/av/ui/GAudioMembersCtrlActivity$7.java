package com.tencent.av.ui;

import com.tencent.av.app.GAudioUIObserver;
import com.tencent.avcore.jni.data.AVUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class GAudioMembersCtrlActivity$7
  extends GAudioUIObserver
{
  GAudioMembersCtrlActivity$7(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  protected void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "onDestroyUI");
    }
    this.b.finish();
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGAudioMemberMicChanged-->uin=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",isMicOff=");
      localStringBuilder.append(paramBoolean);
      QLog.e("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
    }
    GAudioMembersCtrlActivity.c(this.b, new GAudioMembersCtrlActivity.7.3(this, paramLong, paramInt1, paramInt2, paramBoolean));
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (this.b.d != paramLong1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMemberJoin,wrong group uin.GroupUin = ");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(" ,mGroupId = ");
        localStringBuilder.append(this.b.d);
        localStringBuilder.append(" ,isQQUser = ");
        localStringBuilder.append(paramBoolean);
        QLog.e("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
      }
      return;
    }
    super.a(paramLong1, paramLong2, paramBoolean);
    this.b.a(paramLong2, 1, true, 71);
  }
  
  protected void a(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.a(paramLong1, paramLong2, paramBoolean1, paramBoolean2);
    if (this.b.d != paramLong1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onMemberJoin,wrong group uin.GroupUin = ");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(" ,mGroupId = ");
        localStringBuilder.append(this.b.d);
        localStringBuilder.append(" ,isQQUser = ");
        localStringBuilder.append(paramBoolean2);
        QLog.e("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
      }
      return;
    }
    this.b.a(paramLong2, 0, paramBoolean1, 70);
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGAudioRoomMicModeChanged-->uin=");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(",isRoomMicOff=");
      localStringBuilder.append(paramBoolean1);
      QLog.e("GAudioMembersCtrlActivity", 2, localStringBuilder.toString());
    }
    GAudioMembersCtrlActivity.b(this.b, new GAudioMembersCtrlActivity.7.2(this));
  }
  
  protected void a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    super.a(paramLong, paramBoolean1, paramBoolean2, paramInt);
    if (paramBoolean1) {
      paramInt = 42;
    } else {
      paramInt = 43;
    }
    this.b.a(paramLong, 2, paramBoolean2, paramInt);
  }
  
  protected void a(ArrayList<AVUserInfo> paramArrayList)
  {
    GAudioMembersCtrlActivity.d(this.b, new GAudioMembersCtrlActivity.7.4(this, paramArrayList));
  }
  
  protected void b(long paramLong, boolean paramBoolean)
  {
    this.b.c.b(paramLong, paramBoolean);
  }
  
  protected void c(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    this.b.finish();
  }
  
  protected void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("GAudioMembersCtrlActivity", 2, "onUpdatePstnInfo --> Start");
    }
    GAudioMembersCtrlActivity.a(this.b, new GAudioMembersCtrlActivity.7.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.7
 * JD-Core Version:    0.7.0.1
 */