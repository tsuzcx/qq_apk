package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.activity.aio.PokePanel.PokeData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

class GivingHeartItemBuilder$5
  implements Runnable
{
  GivingHeartItemBuilder$5(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  public void run()
  {
    Object localObject = PokeItemHelper.a(this.this$0.b, GivingHeartItemBuilder.a(this.this$0));
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PokePanel.PokeData localPokeData = (PokePanel.PokeData)((Iterator)localObject).next();
        GivingHeartItemBuilder.a(this.this$0).put(Integer.valueOf(localPokeData.b), Integer.valueOf(localPokeData.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */