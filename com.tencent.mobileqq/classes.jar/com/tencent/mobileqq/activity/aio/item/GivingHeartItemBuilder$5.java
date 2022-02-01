package com.tencent.mobileqq.activity.aio.item;

import agao;
import agtx;
import aheh;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GivingHeartItemBuilder$5
  implements Runnable
{
  public GivingHeartItemBuilder$5(agtx paramagtx) {}
  
  public void run()
  {
    Object localObject = aheh.a(this.this$0.b, agtx.a(this.this$0));
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        agao localagao = (agao)((Iterator)localObject).next();
        agtx.a(this.this$0).put(Integer.valueOf(localagao.b), Integer.valueOf(localagao.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */