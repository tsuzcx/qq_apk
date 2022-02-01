package com.tencent.mobileqq.apollo.emotionview.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.apollo.listener.ApolloRspCallback;

class CmShowEmotionAdapter$4
  implements ApolloRspCallback
{
  CmShowEmotionAdapter$4(CmShowEmotionAdapter paramCmShowEmotionAdapter) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    CmShowEmotionAdapter.d(this.a).removeCallbacks(CmShowEmotionAdapter.c(this.a));
    CmShowEmotionAdapter.d(this.a).post(new CmShowEmotionAdapter.4.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.4
 * JD-Core Version:    0.7.0.1
 */