package com.tencent.mobileqq.app.msgcache;

import java.util.Comparator;
import java.util.Map.Entry;

class MsgLruCache$1
  implements Comparator<Map.Entry<String, Integer>>
{
  MsgLruCache$1(MsgLruCache paramMsgLruCache) {}
  
  public int a(Map.Entry<String, Integer> paramEntry1, Map.Entry<String, Integer> paramEntry2)
  {
    if (((Integer)paramEntry1.getValue()).intValue() < ((Integer)paramEntry2.getValue()).intValue()) {
      return 1;
    }
    if (paramEntry1.getValue() == paramEntry2.getValue()) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgcache.MsgLruCache.1
 * JD-Core Version:    0.7.0.1
 */