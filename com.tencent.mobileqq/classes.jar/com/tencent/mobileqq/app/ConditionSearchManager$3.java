package com.tencent.mobileqq.app;

import alpy;
import alqc;
import java.util.Iterator;
import java.util.LinkedList;

public class ConditionSearchManager$3
  implements Runnable
{
  public ConditionSearchManager$3(alpy paramalpy, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.b = false;
    if (this.this$0.a != null)
    {
      Object localObject = new LinkedList();
      ((LinkedList)localObject).addAll(this.this$0.a);
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((alqc)((Iterator)localObject).next()).a(1, this.a);
      }
    }
    if ((this.a) && (this.this$0.c)) {
      this.this$0.a(this.this$0.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.3
 * JD-Core Version:    0.7.0.1
 */