package com.tencent.mobileqq.apollo;

import amsx;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class ApolloManager$16
  implements Runnable
{
  public ApolloManager$16(amsx paramamsx, DrawerPushItem paramDrawerPushItem) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    synchronized (amsx.a(this.this$0))
    {
      if ((amsx.a(this.this$0) != null) && (this.a != null) && (amsx.a(this.this$0).contains(this.a))) {
        amsx.a(this.this$0).remove(this.a);
      }
      if (amsx.a(this.this$0) != null)
      {
        amsx.a(this.this$0).remove(this.a);
        amsx.a(this.this$0).close();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.16
 * JD-Core Version:    0.7.0.1
 */