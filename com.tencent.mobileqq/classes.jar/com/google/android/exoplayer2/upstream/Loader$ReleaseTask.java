package com.google.android.exoplayer2.upstream;

final class Loader$ReleaseTask
  implements Runnable
{
  private final Loader.ReleaseCallback callback;
  
  public Loader$ReleaseTask(Loader.ReleaseCallback paramReleaseCallback)
  {
    this.callback = paramReleaseCallback;
  }
  
  public void run()
  {
    this.callback.onLoaderReleased();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.upstream.Loader.ReleaseTask
 * JD-Core Version:    0.7.0.1
 */