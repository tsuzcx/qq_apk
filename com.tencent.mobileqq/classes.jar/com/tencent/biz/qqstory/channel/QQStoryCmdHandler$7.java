package com.tencent.biz.qqstory.channel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class QQStoryCmdHandler$7
  extends SimpleJob<Void>
{
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = new Bundle();
    paramJobContext.putInt("data_error_code", 0);
    paramJobContext.putLong("start_time", System.currentTimeMillis());
    paramJobContext.putByteArray("data", this.a);
    QQStoryCmdHandler.a(this.c, this.b, this.a, paramJobContext);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.channel.QQStoryCmdHandler.7
 * JD-Core Version:    0.7.0.1
 */