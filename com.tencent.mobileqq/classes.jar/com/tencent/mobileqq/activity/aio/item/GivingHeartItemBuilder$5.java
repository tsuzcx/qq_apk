package com.tencent.mobileqq.activity.aio.item;

import agki;
import ahdk;
import ahnt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GivingHeartItemBuilder$5
  implements Runnable
{
  public GivingHeartItemBuilder$5(ahdk paramahdk) {}
  
  public void run()
  {
    Object localObject = ahnt.a(this.this$0.b, ahdk.a(this.this$0));
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        agki localagki = (agki)((Iterator)localObject).next();
        ahdk.a(this.this$0).put(Integer.valueOf(localagki.b), Integer.valueOf(localagki.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */