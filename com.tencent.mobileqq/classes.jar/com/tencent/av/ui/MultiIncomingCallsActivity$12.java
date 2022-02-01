package com.tencent.av.ui;

import android.text.TextUtils;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;

class MultiIncomingCallsActivity$12
  extends GAudioUIObserver
{
  MultiIncomingCallsActivity$12(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  protected void a(long paramLong, int paramInt)
  {
    long l = QQAudioHelper.d();
    String str = this.b.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroyInviteUI, groupId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mIsDoubleVideoMeeting[");
    localStringBuilder.append(this.b.x);
    localStringBuilder.append("], mPeerUin[");
    localStringBuilder.append(this.b.u);
    localStringBuilder.append("], mGroupId[");
    localStringBuilder.append(this.b.b);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.b.x)
    {
      if (TextUtils.equals(this.b.u, String.valueOf(paramLong)))
      {
        this.b.b("onDestroyInviteUI_DoubleVideoMeeting");
        this.b.a(l, paramInt);
      }
    }
    else if ((this.b.b == paramLong) || (0L == paramLong)) {
      this.b.b("onDestroyInviteUI");
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    if ((this.b.b == paramLong) && (this.b.D.equals(paramString))) {
      this.b.finish();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.b.l);
      ((StringBuilder)localObject).append(".troopgroup_vedio.invite");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("groupId:");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", memUin:");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",invitedId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", mInviterUin:");
      localStringBuilder.append(this.b.c);
      localStringBuilder.append(", mGroupId:");
      localStringBuilder.append(this.b.b);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((paramLong2 == this.b.c) && (paramLong1 == this.b.b)) {
      this.b.finish();
    }
  }
  
  protected void d(long paramLong)
  {
    this.b.b("notifyCloseAllGroupVideoInviteMsgBox");
    this.b.finish();
  }
  
  protected void e(long paramLong)
  {
    if (this.b.b == paramLong)
    {
      this.b.b("notifyCloseGroupVideoInviteMsgBox");
      this.b.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.12
 * JD-Core Version:    0.7.0.1
 */