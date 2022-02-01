package com.tencent.biz.qqstory.base.preload;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class PlayingListPreloader$1
  extends SimpleJob
{
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object[] paramArrayOfObject)
  {
    PlayingListPreloader.a(this.c, this.a, this.b);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PlayingListPreloader.1
 * JD-Core Version:    0.7.0.1
 */