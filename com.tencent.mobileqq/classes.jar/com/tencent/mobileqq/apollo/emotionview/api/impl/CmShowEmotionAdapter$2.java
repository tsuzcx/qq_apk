package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.apollo.listener.ApolloRspCallback;

class CmShowEmotionAdapter$2
  implements ApolloRspCallback
{
  CmShowEmotionAdapter$2(CmShowEmotionAdapter paramCmShowEmotionAdapter) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    CmShowEmotionAdapter.a(this.a).removeCallbacks(CmShowEmotionAdapter.a(this.a));
    CmShowEmotionAdapter.a(this.a).post(new CmShowEmotionAdapter.2.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.2
 * JD-Core Version:    0.7.0.1
 */