package com.tencent.mobileqq.apollo;

import airx;
import aukp;
import com.tencent.mobileqq.DrawerPushItem;
import java.util.List;

public class ApolloManager$16
  implements Runnable
{
  public ApolloManager$16(airx paramairx, DrawerPushItem paramDrawerPushItem) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    synchronized (airx.a(this.this$0))
    {
      if ((airx.a(this.this$0) != null) && (this.a != null) && (airx.a(this.this$0).contains(this.a))) {
        airx.a(this.this$0).remove(this.a);
      }
      if (airx.a(this.this$0) != null)
      {
        airx.a(this.this$0).b(this.a);
        airx.a(this.this$0).a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.16
 * JD-Core Version:    0.7.0.1
 */