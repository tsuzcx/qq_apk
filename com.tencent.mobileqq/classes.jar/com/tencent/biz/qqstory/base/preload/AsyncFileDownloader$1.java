package com.tencent.biz.qqstory.base.preload;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.async.Job;
import com.tribe.async.async.JobContext;
import java.util.Map;

class AsyncFileDownloader$1
  extends Job<Object, Object, Object>
{
  AsyncFileDownloader$1(AsyncFileDownloader paramAsyncFileDownloader, String paramString, DownloadTask paramDownloadTask)
  {
    super(paramString);
  }
  
  protected Object doInBackground(@NonNull JobContext paramJobContext, @Nullable Object... paramVarArgs)
  {
    this.a.n.a(this.a);
    this.b.e = this.a.a;
    this.b.d.put(this.a.a, this.a);
    return null;
  }
  
  public int getJobType()
  {
    return 16;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.AsyncFileDownloader.1
 * JD-Core Version:    0.7.0.1
 */