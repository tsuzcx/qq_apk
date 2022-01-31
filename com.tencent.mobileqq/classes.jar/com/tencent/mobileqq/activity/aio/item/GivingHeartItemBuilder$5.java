package com.tencent.mobileqq.activity.aio.item;

import acyh;
import adqg;
import adwl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GivingHeartItemBuilder$5
  implements Runnable
{
  public GivingHeartItemBuilder$5(adqg paramadqg) {}
  
  public void run()
  {
    Object localObject = adwl.a(this.this$0.b, adqg.a(this.this$0));
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        acyh localacyh = (acyh)((Iterator)localObject).next();
        adqg.a(this.this$0).put(Integer.valueOf(localacyh.b), Integer.valueOf(localacyh.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */