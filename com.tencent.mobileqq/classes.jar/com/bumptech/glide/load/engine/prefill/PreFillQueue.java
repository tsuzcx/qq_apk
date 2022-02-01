package com.bumptech.glide.load.engine.prefill;

import java.util.List;
import java.util.Map;

final class PreFillQueue
{
  private final Map<PreFillType, Integer> a;
  private final List<PreFillType> b;
  private int c;
  private int d;
  
  public PreFillType a()
  {
    PreFillType localPreFillType = (PreFillType)this.b.get(this.d);
    Integer localInteger = (Integer)this.a.get(localPreFillType);
    if (localInteger.intValue() == 1)
    {
      this.a.remove(localPreFillType);
      this.b.remove(this.d);
    }
    else
    {
      this.a.put(localPreFillType, Integer.valueOf(localInteger.intValue() - 1));
    }
    this.c -= 1;
    int i;
    if (this.b.isEmpty()) {
      i = 0;
    } else {
      i = (this.d + 1) % this.b.size();
    }
    this.d = i;
    return localPreFillType;
  }
  
  public boolean b()
  {
    return this.c == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.load.engine.prefill.PreFillQueue
 * JD-Core Version:    0.7.0.1
 */