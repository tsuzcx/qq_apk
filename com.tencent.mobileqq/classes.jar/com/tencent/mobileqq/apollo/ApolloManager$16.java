package com.tencent.mobileqq.apollo;

import aifg;
import atmp;
import com.tencent.mobileqq.DrawerPushItem;
import java.util.List;

public class ApolloManager$16
  implements Runnable
{
  public ApolloManager$16(aifg paramaifg, DrawerPushItem paramDrawerPushItem) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    synchronized (aifg.a(this.this$0))
    {
      if ((aifg.a(this.this$0) != null) && (this.a != null) && (aifg.a(this.this$0).contains(this.a))) {
        aifg.a(this.this$0).remove(this.a);
      }
      if (aifg.a(this.this$0) != null)
      {
        aifg.a(this.this$0).b(this.a);
        aifg.a(this.this$0).a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.16
 * JD-Core Version:    0.7.0.1
 */