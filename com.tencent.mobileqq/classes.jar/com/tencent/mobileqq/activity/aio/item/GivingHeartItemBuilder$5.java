package com.tencent.mobileqq.activity.aio.item;

import afuf;
import agsm;
import ahcw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GivingHeartItemBuilder$5
  implements Runnable
{
  public GivingHeartItemBuilder$5(agsm paramagsm) {}
  
  public void run()
  {
    Object localObject = ahcw.a(this.this$0.b, agsm.a(this.this$0));
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        afuf localafuf = (afuf)((Iterator)localObject).next();
        agsm.a(this.this$0).put(Integer.valueOf(localafuf.b), Integer.valueOf(localafuf.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */