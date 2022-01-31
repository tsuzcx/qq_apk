package com.tencent.mobileqq.activity.aio.item;

import aepr;
import afij;
import afsw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GivingHeartItemBuilder$5
  implements Runnable
{
  public GivingHeartItemBuilder$5(afij paramafij) {}
  
  public void run()
  {
    Object localObject = afsw.a(this.this$0.b, afij.a(this.this$0));
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aepr localaepr = (aepr)((Iterator)localObject).next();
        afij.a(this.this$0).put(Integer.valueOf(localaepr.b), Integer.valueOf(localaepr.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */