package com.tencent.biz.qqstory.channel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.Map;

class QQStoryCmdHandler$5
  extends SimpleJob<Void>
{
  QQStoryCmdHandler$5(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString, Bundle paramBundle, byte[] paramArrayOfByte)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    int i = this.a.getInt("storySeq");
    paramJobContext = (NetworkRequest)QQStoryCmdHandler.b(this.c).remove(Integer.valueOf(i));
    if (paramJobContext == null)
    {
      SLog.d("Q.qqstory.net:QQStoryCmdHandler", "can't find request");
      return null;
    }
    QQStoryCmdHandler.a(this.c, paramJobContext, this.b, this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler.5
 * JD-Core Version:    0.7.0.1
 */