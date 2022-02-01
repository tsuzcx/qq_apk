package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class EcshopCacheTool$1
  implements Runnable
{
  EcshopCacheTool$1(EcshopCacheTool paramEcshopCacheTool) {}
  
  public void run()
  {
    Object localObject = this.this$0.a.rawQuery(Friends.class, " SELECT * FROM Friends ", new String[0]);
    this.this$0.b = new HashMap();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Friends localFriends = (Friends)((Iterator)localObject).next();
        this.this$0.b.put(localFriends.uin, localFriends);
      }
    }
    if ((this.this$0.h != null) && (this.this$0.h.k != null)) {
      this.this$0.h.getQBaseActivity().runOnUiThread(new EcshopCacheTool.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopCacheTool.1
 * JD-Core Version:    0.7.0.1
 */