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
    long l = QQAudioHelper.b();
    String str = this.a.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroyInviteUI, groupId[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mIsDoubleVideoMeeting[");
    localStringBuilder.append(this.a.jdField_a_of_type_Boolean);
    localStringBuilder.append("], mPeerUin[");
    localStringBuilder.append(this.a.c);
    localStringBuilder.append("], mGroupId[");
    localStringBuilder.append(this.a.jdField_a_of_type_Long);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.a.jdField_a_of_type_Boolean)
    {
      if (TextUtils.equals(this.a.c, String.valueOf(paramLong)))
      {
        this.a.b("onDestroyInviteUI_DoubleVideoMeeting");
        this.a.a(l, paramInt);
      }
    }
    else if ((this.a.jdField_a_of_type_Long == paramLong) || (0L == paramLong)) {
      this.a.b("onDestroyInviteUI");
    }
  }
  
  protected void a(long paramLong, String paramString)
  {
    if ((this.a.jdField_a_of_type_Long == paramLong) && (this.a.e.equals(paramString))) {
      this.a.finish();
    }
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.a.jdField_b_of_type_JavaLangString);
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
      localStringBuilder.append(this.a.jdField_b_of_type_Long);
      localStringBuilder.append(", mGroupId:");
      localStringBuilder.append(this.a.jdField_a_of_type_Long);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((paramLong2 == this.a.jdField_b_of_type_Long) && (paramLong1 == this.a.jdField_a_of_type_Long)) {
      this.a.finish();
    }
  }
  
  protected void d(long paramLong)
  {
    this.a.b("notifyCloseAllGroupVideoInviteMsgBox");
    this.a.finish();
  }
  
  protected void e(long paramLong)
  {
    if (this.a.jdField_a_of_type_Long == paramLong)
    {
      this.a.b("notifyCloseGroupVideoInviteMsgBox");
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiIncomingCallsActivity.12
 * JD-Core Version:    0.7.0.1
 */