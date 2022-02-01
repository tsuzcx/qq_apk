package com.tencent.mobileqq.activity.aio.item;

import afda;
import afzw;
import agkg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GivingHeartItemBuilder$5
  implements Runnable
{
  public GivingHeartItemBuilder$5(afzw paramafzw) {}
  
  public void run()
  {
    Object localObject = agkg.a(this.this$0.b, afzw.a(this.this$0));
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        afda localafda = (afda)((Iterator)localObject).next();
        afzw.a(this.this$0).put(Integer.valueOf(localafda.b), Integer.valueOf(localafda.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */