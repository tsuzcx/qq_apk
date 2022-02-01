package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.app.DiscussionObserver;
import java.util.ArrayList;
import java.util.Iterator;

class SystemMsgListView$5
  extends DiscussionObserver
{
  SystemMsgListView$5(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, ArrayList<String> paramArrayList)
  {
    if (paramBoolean) {
      SystemMsgListView.a(this.a).b(paramLong);
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      if (!(paramObject instanceof ArrayList)) {
        break label76;
      }
    }
    label76:
    for (paramObject = (ArrayList)paramObject;; paramObject = null)
    {
      if ((paramObject != null) && (paramObject.size() > 0))
      {
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          Object localObject = paramObject.next();
          if ((localObject instanceof Long)) {
            SystemMsgListView.a(this.a).b(((Long)localObject).longValue());
          }
        }
      }
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {}
    try
    {
      long l = Long.parseLong(paramString);
      SystemMsgListView.a(this.a).b(l);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView.5
 * JD-Core Version:    0.7.0.1
 */