package com.google.android.exoplayer2;

import android.util.Log;

class ExoPlayerImplInternal$1
  implements Runnable
{
  ExoPlayerImplInternal$1(ExoPlayerImplInternal paramExoPlayerImplInternal, PlayerMessage paramPlayerMessage) {}
  
  public void run()
  {
    try
    {
      ExoPlayerImplInternal.access$400(this.this$0, this.val$message);
      return;
    }
    catch (ExoPlaybackException localExoPlaybackException)
    {
      Log.e("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", localExoPlaybackException);
      throw new RuntimeException(localExoPlaybackException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.ExoPlayerImplInternal.1
 * JD-Core Version:    0.7.0.1
 */