package com.tencent.biz.qqstory.settings;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class QQStoryFriendSettingDelegate$3
  extends ProtoUtils.TroopProtocolObserver
{
  QQStoryFriendSettingDelegate$3(QQStoryFriendSettingDelegate paramQQStoryFriendSettingDelegate, boolean paramBoolean) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      paramArrayOfByte = this.a;
      if (!this.b) {}
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte.a(3, bool);
        this.a.a(0, this.a.a.getString(2131720237));
        return;
      }
    }
    ((QQStoryManager)this.a.a.app.getManager(QQManagerFactory.QQSTORY_MANAGER)).b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettingDelegate.3
 * JD-Core Version:    0.7.0.1
 */