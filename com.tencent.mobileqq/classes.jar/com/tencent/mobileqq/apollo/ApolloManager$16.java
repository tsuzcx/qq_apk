package com.tencent.mobileqq.apollo;

import amme;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class ApolloManager$16
  implements Runnable
{
  public ApolloManager$16(amme paramamme, DrawerPushItem paramDrawerPushItem) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    synchronized (amme.a(this.this$0))
    {
      if ((amme.a(this.this$0) != null) && (this.a != null) && (amme.a(this.this$0).contains(this.a))) {
        amme.a(this.this$0).remove(this.a);
      }
      if (amme.a(this.this$0) != null)
      {
        amme.a(this.this$0).remove(this.a);
        amme.a(this.this$0).close();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.16
 * JD-Core Version:    0.7.0.1
 */