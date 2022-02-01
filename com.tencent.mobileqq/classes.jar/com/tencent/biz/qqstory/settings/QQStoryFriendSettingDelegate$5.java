package com.tencent.biz.qqstory.settings;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;

class QQStoryFriendSettingDelegate$5
  extends ProtoUtils.TroopProtocolObserver
{
  QQStoryFriendSettingDelegate$5(QQStoryFriendSettingDelegate paramQQStoryFriendSettingDelegate, boolean paramBoolean) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      paramArrayOfByte = this.a;
      if (!this.b) {}
      for (boolean bool = true;; bool = false)
      {
        paramArrayOfByte.a(7, bool);
        this.a.a(0, this.a.a.getString(2131720237));
        return;
      }
    }
    ((StoryConfigManager)SuperManager.a(10)).b("story_publish_flag_compress", Boolean.valueOf(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettingDelegate.5
 * JD-Core Version:    0.7.0.1
 */