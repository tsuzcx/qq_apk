package com.tencent.mobileqq.apollo;

import aknx;
import awgf;
import com.tencent.mobileqq.DrawerPushItem;
import java.util.List;

public class ApolloManager$16
  implements Runnable
{
  public ApolloManager$16(aknx paramaknx, DrawerPushItem paramDrawerPushItem) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    synchronized (aknx.a(this.this$0))
    {
      if ((aknx.a(this.this$0) != null) && (this.a != null) && (aknx.a(this.this$0).contains(this.a))) {
        aknx.a(this.this$0).remove(this.a);
      }
      if (aknx.a(this.this$0) != null)
      {
        aknx.a(this.this$0).b(this.a);
        aknx.a(this.this$0).a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.16
 * JD-Core Version:    0.7.0.1
 */