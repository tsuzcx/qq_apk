package com.tencent.mobileqq.activity.aio.item;

import acye;
import adqe;
import adwj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GivingHeartItemBuilder$5
  implements Runnable
{
  public GivingHeartItemBuilder$5(adqe paramadqe) {}
  
  public void run()
  {
    Object localObject = adwj.a(this.this$0.b, adqe.a(this.this$0));
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        acye localacye = (acye)((Iterator)localObject).next();
        adqe.a(this.this$0).put(Integer.valueOf(localacye.b), Integer.valueOf(localacye.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */