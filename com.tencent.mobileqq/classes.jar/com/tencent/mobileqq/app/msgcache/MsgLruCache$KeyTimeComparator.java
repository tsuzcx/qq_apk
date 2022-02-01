package com.tencent.mobileqq.app.msgcache;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;
import java.util.List;

class MsgLruCache$KeyTimeComparator
  implements Comparator<String>
{
  private MsgLruCache$KeyTimeComparator(MsgLruCache paramMsgLruCache) {}
  
  public int a(String paramString1, String paramString2)
  {
    paramString1 = this.a.getOriginal(paramString1);
    paramString2 = this.a.getOriginal(paramString2);
    if (paramString1 != null)
    {
      if (paramString1.isEmpty()) {
        return 1;
      }
      if (paramString2 != null)
      {
        if (paramString2.isEmpty()) {
          return -1;
        }
        long l1 = ((MessageRecord)paramString1.get(paramString1.size() - 1)).time;
        long l2 = ((MessageRecord)paramString2.get(paramString2.size() - 1)).time;
        if (l1 > l2) {
          return 1;
        }
        if (l1 == l2) {
          return 0;
        }
      }
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgcache.MsgLruCache.KeyTimeComparator
 * JD-Core Version:    0.7.0.1
 */