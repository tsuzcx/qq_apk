package com.tencent.mobileqq.app.asyncdb.cache;

import com.tencent.mobileqq.persistence.Entity;
import java.util.Comparator;
import java.util.Map.Entry;

class RoamDateCache$1
  implements Comparator<Map.Entry<String, Entity>>
{
  RoamDateCache$1(RoamDateCache paramRoamDateCache) {}
  
  public int a(Map.Entry<String, Entity> paramEntry1, Map.Entry<String, Entity> paramEntry2)
  {
    paramEntry1 = ((String)paramEntry1.getKey()).split("&")[1];
    int i = Integer.parseInt(paramEntry1.split("-")[0]);
    int j = Integer.parseInt(paramEntry1.split("-")[1]);
    paramEntry1 = ((String)paramEntry2.getKey()).split("&")[1];
    int k = Integer.parseInt(paramEntry1.split("-")[0]);
    int m = Integer.parseInt(paramEntry1.split("-")[1]);
    if (i > k) {
      return 1;
    }
    if (i == k) {
      return j - m;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.asyncdb.cache.RoamDateCache.1
 * JD-Core Version:    0.7.0.1
 */