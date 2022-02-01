package com.tencent.av.ui.funchat.record;

import android.util.LruCache;

class PCMLoader$1
  extends LruCache<String, PCMLoader.PCMData>
{
  PCMLoader$1(PCMLoader paramPCMLoader, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, PCMLoader.PCMData paramPCMData)
  {
    if (paramPCMData == null) {
      return 0;
    }
    return paramPCMData.a.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.PCMLoader.1
 * JD-Core Version:    0.7.0.1
 */