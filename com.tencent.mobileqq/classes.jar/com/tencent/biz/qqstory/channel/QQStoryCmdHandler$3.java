package com.tencent.biz.qqstory.channel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;

class QQStoryCmdHandler$3
  extends Job<Object, Object, Object>
{
  QQStoryCmdHandler$3(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString, NetworkRequest paramNetworkRequest)
  {
    super(paramString);
  }
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    this.a.d().a(880001, "no network", null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler.3
 * JD-Core Version:    0.7.0.1
 */