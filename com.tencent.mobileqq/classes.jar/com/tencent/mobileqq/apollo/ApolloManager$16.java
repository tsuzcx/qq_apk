package com.tencent.mobileqq.apollo;

import akji;
import awbw;
import com.tencent.mobileqq.DrawerPushItem;
import java.util.List;

public class ApolloManager$16
  implements Runnable
{
  public ApolloManager$16(akji paramakji, DrawerPushItem paramDrawerPushItem) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    synchronized (akji.a(this.this$0))
    {
      if ((akji.a(this.this$0) != null) && (this.a != null) && (akji.a(this.this$0).contains(this.a))) {
        akji.a(this.this$0).remove(this.a);
      }
      if (akji.a(this.this$0) != null)
      {
        akji.a(this.this$0).b(this.a);
        akji.a(this.this$0).a();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.16
 * JD-Core Version:    0.7.0.1
 */