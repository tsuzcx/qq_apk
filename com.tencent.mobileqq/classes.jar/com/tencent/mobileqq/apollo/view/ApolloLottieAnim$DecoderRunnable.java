package com.tencent.mobileqq.apollo.view;

import java.lang.ref.WeakReference;

class ApolloLottieAnim$DecoderRunnable
  implements Runnable
{
  private boolean mAutoPlay;
  private String mLocalFilePath;
  private WeakReference<ApolloLottieAnim> mLottieAnimRef;
  private String mZipUrl;
  
  public void run()
  {
    if ((this.mLottieAnimRef != null) && (this.mLottieAnimRef.get() != null)) {
      ApolloLottieAnim.access$200((ApolloLottieAnim)this.mLottieAnimRef.get(), this.mZipUrl, this.mLocalFilePath, this.mAutoPlay);
    }
  }
  
  public void setZipData(ApolloLottieAnim paramApolloLottieAnim, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mZipUrl = paramString1;
    this.mLocalFilePath = paramString2;
    this.mAutoPlay = paramBoolean;
    this.mLottieAnimRef = new WeakReference(paramApolloLottieAnim);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLottieAnim.DecoderRunnable
 * JD-Core Version:    0.7.0.1
 */