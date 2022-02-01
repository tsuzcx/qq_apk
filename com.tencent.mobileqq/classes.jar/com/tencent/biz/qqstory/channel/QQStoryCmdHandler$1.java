package com.tencent.biz.qqstory.channel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class QQStoryCmdHandler$1
  extends SimpleJob<Void>
{
  QQStoryCmdHandler$1(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = ((StoryConfigManager)SuperManager.a(10)).a();
    if (!TextUtils.isEmpty(paramJobContext)) {
      this.a.a(paramJobContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler.1
 * JD-Core Version:    0.7.0.1
 */