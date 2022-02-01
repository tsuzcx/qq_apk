package com.tencent.biz.qqstory.settings;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class QQStoryFriendSettingDelegate$4
  extends ProtoUtils.TroopProtocolObserver
{
  QQStoryFriendSettingDelegate$4(QQStoryFriendSettingDelegate paramQQStoryFriendSettingDelegate, boolean paramBoolean) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      this.b.a(5, this.a ^ true);
      paramArrayOfByte = this.b;
      paramArrayOfByte.a(0, paramArrayOfByte.c.getString(2131917575));
      return;
    }
    ((QQStoryManager)this.b.c.app.getManager(QQManagerFactory.QQSTORY_MANAGER)).c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettingDelegate.4
 * JD-Core Version:    0.7.0.1
 */