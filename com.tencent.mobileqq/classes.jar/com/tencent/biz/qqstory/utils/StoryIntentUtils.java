package com.tencent.biz.qqstory.utils;

import android.content.Intent;
import android.os.Bundle;

public class StoryIntentUtils
{
  public static Intent a(Intent paramIntent, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return paramIntent;
    }
    if (paramBundle.containsKey("ignorePersonalPublish")) {
      paramIntent.putExtra("ignorePersonalPublish", paramBundle.getBoolean("ignorePersonalPublish"));
    }
    paramIntent.putExtra("shareGroupType", paramBundle.getString("shareGroupType"));
    paramIntent.putExtra("shareGroupId", paramBundle.getString("shareGroupId"));
    paramIntent.putExtra("shareGroupName", paramBundle.getString("shareGroupName"));
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.StoryIntentUtils
 * JD-Core Version:    0.7.0.1
 */