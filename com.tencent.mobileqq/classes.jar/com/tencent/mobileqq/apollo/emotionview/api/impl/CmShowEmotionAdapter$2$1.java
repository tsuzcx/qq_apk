package com.tencent.mobileqq.apollo.emotionview.api.impl;

import java.util.List;

class CmShowEmotionAdapter$2$1
  implements Runnable
{
  CmShowEmotionAdapter$2$1(CmShowEmotionAdapter.2 param2, List paramList) {}
  
  public void run()
  {
    CmShowEmotionAdapter.a(this.b.a).clear();
    CmShowEmotionAdapter.a(this.b.a).addAll(this.a);
    this.b.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.emotionview.api.impl.CmShowEmotionAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */