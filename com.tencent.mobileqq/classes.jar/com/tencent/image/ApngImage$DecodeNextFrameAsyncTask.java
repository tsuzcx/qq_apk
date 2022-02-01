package com.tencent.image;

import android.os.AsyncTask;

class ApngImage$DecodeNextFrameAsyncTask
  extends AsyncTask<Void, Void, Object>
{
  long nextFrameDrawingTime;
  
  public ApngImage$DecodeNextFrameAsyncTask(ApngImage paramApngImage, long paramLong)
  {
    this.nextFrameDrawingTime = paramLong;
  }
  
  protected Object doInBackground(Void... paramVarArgs)
  {
    try
    {
      boolean bool = this.this$0.getNextFrame();
      this.this$0.onDecodeNextFrameSuccessed(bool, this.nextFrameDrawingTime);
      return null;
    }
    catch (Throwable paramVarArgs) {}
    return paramVarArgs;
  }
  
  protected void onCancelled()
  {
    this.this$0.onDecodeNextFrameCanceled();
  }
  
  protected void onPostExecute(Object paramObject)
  {
    if ((paramObject instanceof Throwable)) {
      this.this$0.onDecodeNextFrameFailed((Throwable)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image.ApngImage.DecodeNextFrameAsyncTask
 * JD-Core Version:    0.7.0.1
 */