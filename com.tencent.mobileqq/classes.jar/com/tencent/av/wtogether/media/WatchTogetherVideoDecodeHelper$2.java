package com.tencent.av.wtogether.media;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.videocodec.mediacodec.encoder.EglHandlerThread;
import java.util.concurrent.Callable;

final class WatchTogetherVideoDecodeHelper$2
  implements Callable<WatchTogetherVideoDecodeHelper>
{
  WatchTogetherVideoDecodeHelper$2(Handler paramHandler, EglHandlerThread paramEglHandlerThread) {}
  
  @Nullable
  public WatchTogetherVideoDecodeHelper a()
  {
    try
    {
      WatchTogetherVideoDecodeHelper localWatchTogetherVideoDecodeHelper = new WatchTogetherVideoDecodeHelper(this.a, this.b, null);
      return localWatchTogetherVideoDecodeHelper;
    }
    catch (RuntimeException localRuntimeException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.2
 * JD-Core Version:    0.7.0.1
 */