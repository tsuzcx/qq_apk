package com.tencent.mobileqq.activity.aio.item;

import acno;
import adfe;
import adll;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GivingHeartItemBuilder$5
  implements Runnable
{
  public GivingHeartItemBuilder$5(adfe paramadfe) {}
  
  public void run()
  {
    Object localObject = adll.a(this.this$0.b, adfe.a(this.this$0));
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        acno localacno = (acno)((Iterator)localObject).next();
        adfe.a(this.this$0).put(Integer.valueOf(localacno.b), Integer.valueOf(localacno.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */