package com.tencent.featuretoggle.hltxkg.common.c.b.a;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

final class c
  extends LinkedHashMap<String, String>
{
  c(b paramb, int paramInt, float paramFloat, boolean paramBoolean)
  {
    super(8, 1.0F, true);
  }
  
  protected final boolean removeEldestEntry(Map.Entry<String, String> paramEntry)
  {
    return size() > 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.c.b.a.c
 * JD-Core Version:    0.7.0.1
 */