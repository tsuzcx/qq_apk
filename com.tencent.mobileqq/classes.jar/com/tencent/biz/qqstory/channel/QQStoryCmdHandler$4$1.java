package com.tencent.biz.qqstory.channel;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;

class QQStoryCmdHandler$4$1
  extends Job<Object, Object, Object>
{
  QQStoryCmdHandler$4$1(QQStoryCmdHandler.4 param4, String paramString, QQStoryCmdHandler.IllegalUinException paramIllegalUinException)
  {
    super(paramString);
  }
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    SLog.d("Q.qqstory.net:QQStoryCmdHandler", "uin convert error");
    this.b.a.d().a(880002, this.a.getMessage(), null);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler.4.1
 * JD-Core Version:    0.7.0.1
 */