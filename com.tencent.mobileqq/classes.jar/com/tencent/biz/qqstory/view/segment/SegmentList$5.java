package com.tencent.biz.qqstory.view.segment;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class SegmentList$5
  extends SimpleJob
{
  SegmentList$5(SegmentList paramSegmentList, String paramString)
  {
    super(paramString);
  }
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object[] paramArrayOfObject)
  {
    this.a.a.f();
    if (SegmentList.a(this.a)) {
      return null;
    }
    SegmentList.a(this.a).sendMessage(SegmentList.a(this.a).obtainMessage(2));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.segment.SegmentList.5
 * JD-Core Version:    0.7.0.1
 */