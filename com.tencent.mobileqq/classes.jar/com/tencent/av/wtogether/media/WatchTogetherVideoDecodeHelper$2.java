package com.tencent.av.wtogether.media;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.richmedia.mediacodec.encoder.EglHandlerThread;
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
      WatchTogetherVideoDecodeHelper localWatchTogetherVideoDecodeHelper = new WatchTogetherVideoDecodeHelper(this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecEncoderEglHandlerThread, null);
      return localWatchTogetherVideoDecodeHelper;
    }
    catch (RuntimeException localRuntimeException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.media.WatchTogetherVideoDecodeHelper.2
 * JD-Core Version:    0.7.0.1
 */