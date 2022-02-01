package com.tencent.mobileqq.activity.aio.core;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoObserver;
import com.tencent.qphone.base.util.QLog;

class FriendChatPie$13
  extends IntimateInfoObserver
{
  FriendChatPie$13(FriendChatPie paramFriendChatPie) {}
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.ah.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.c, 2, "onBandIntimateRelationship");
      }
      this.a.bz();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, this.a.ah.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.c, 2, "onUpdateIntimateRelationship");
      }
      this.a.bz();
    }
  }
  
  protected void a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (TextUtils.equals(paramString, this.a.ah.b)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.a.c, 2, "onDisbandIntimateRelationship");
      }
      this.a.bz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.13
 * JD-Core Version:    0.7.0.1
 */