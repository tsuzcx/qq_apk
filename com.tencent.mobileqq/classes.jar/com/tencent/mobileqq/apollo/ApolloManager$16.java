package com.tencent.mobileqq.apollo;

import alnr;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class ApolloManager$16
  implements Runnable
{
  public ApolloManager$16(alnr paramalnr, DrawerPushItem paramDrawerPushItem) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    synchronized (alnr.a(this.this$0))
    {
      if ((alnr.a(this.this$0) != null) && (this.a != null) && (alnr.a(this.this$0).contains(this.a))) {
        alnr.a(this.this$0).remove(this.a);
      }
      if (alnr.a(this.this$0) != null)
      {
        alnr.a(this.this$0).remove(this.a);
        alnr.a(this.this$0).close();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.16
 * JD-Core Version:    0.7.0.1
 */