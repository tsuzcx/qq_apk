package com.tencent.avbiz;

import java.util.Comparator;

class AVBizPriorityManager$1
  implements Comparator<AVBusiness>
{
  AVBizPriorityManager$1(AVBizPriorityManager paramAVBizPriorityManager) {}
  
  public int a(AVBusiness paramAVBusiness1, AVBusiness paramAVBusiness2)
  {
    if (paramAVBusiness1.equals(paramAVBusiness2)) {
      return 0;
    }
    if (paramAVBusiness1.a(paramAVBusiness2)) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.AVBizPriorityManager.1
 * JD-Core Version:    0.7.0.1
 */