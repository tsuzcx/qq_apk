package com.tencent.biz.qqstory.settings;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;

class QQStoryFriendSettingDelegate$5
  extends ProtoUtils.TroopProtocolObserver
{
  QQStoryFriendSettingDelegate$5(QQStoryFriendSettingDelegate paramQQStoryFriendSettingDelegate, boolean paramBoolean) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      this.b.a(7, this.a ^ true);
      paramArrayOfByte = this.b;
      paramArrayOfByte.a(0, paramArrayOfByte.c.getString(2131917575));
      return;
    }
    ((StoryConfigManager)SuperManager.a(10)).d("story_publish_flag_compress", Boolean.valueOf(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.settings.QQStoryFriendSettingDelegate.5
 * JD-Core Version:    0.7.0.1
 */