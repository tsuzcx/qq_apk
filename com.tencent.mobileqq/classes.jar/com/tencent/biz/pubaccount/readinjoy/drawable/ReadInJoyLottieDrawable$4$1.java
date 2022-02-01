package com.tencent.biz.pubaccount.readinjoy.drawable;

import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.util.LruCache;
import com.tencent.mobileqq.dinifly.LottieComposition;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import java.io.File;

class ReadInJoyLottieDrawable$4$1
  implements OnCompositionLoadedListener
{
  ReadInJoyLottieDrawable$4$1(ReadInJoyLottieDrawable.4 param4) {}
  
  public void onCompositionLoaded(@Nullable LottieComposition paramLottieComposition)
  {
    if (paramLottieComposition != null)
    {
      ReadInJoyLottieDrawable.a().put(this.a.jdField_a_of_type_JavaIoFile.getAbsolutePath(), paramLottieComposition);
      ReadInJoyLottieDrawable.a(this.a.this$0).post(this.a.jdField_a_of_type_JavaLangRunnable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.drawable.ReadInJoyLottieDrawable.4.1
 * JD-Core Version:    0.7.0.1
 */