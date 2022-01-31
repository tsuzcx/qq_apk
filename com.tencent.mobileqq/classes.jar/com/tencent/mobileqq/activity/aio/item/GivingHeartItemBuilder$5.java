package com.tencent.mobileqq.activity.aio.item;

import aeug;
import afmy;
import afxl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class GivingHeartItemBuilder$5
  implements Runnable
{
  public GivingHeartItemBuilder$5(afmy paramafmy) {}
  
  public void run()
  {
    Object localObject = afxl.a(this.this$0.b, afmy.a(this.this$0));
    if (((ArrayList)localObject).size() > 0)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aeug localaeug = (aeug)((Iterator)localObject).next();
        afmy.a(this.this$0).put(Integer.valueOf(localaeug.b), Integer.valueOf(localaeug.c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */