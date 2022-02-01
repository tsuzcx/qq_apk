package com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ChatLayoutListenerController
  implements IChatLayoutListenerController
{
  public static int a = 1;
  public static int b = 2;
  public static int c = 3;
  private HashMap<Integer, List<IChatLayoutListener>> d;
  
  public void a(int paramInt, IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((HashMap)localObject).isEmpty()) {
        return;
      }
      localObject = (List)this.d.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((IChatLayoutListener)((Iterator)localObject).next()).a(paramInt, paramChatLayoutListenerInfo);
        }
      }
    }
  }
  
  public void a(int paramInt, IChatLayoutListener paramIChatLayoutListener)
  {
    if (this.d == null) {
      this.d = new HashMap();
    }
    List localList = (List)this.d.get(Integer.valueOf(paramInt));
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.d.put(Integer.valueOf(paramInt), localObject);
    }
    ((List)localObject).add(paramIChatLayoutListener);
  }
  
  public void b(int paramInt, IChatLayoutListener paramIChatLayoutListener)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (((HashMap)localObject).isEmpty()) {
        return;
      }
      localObject = (List)this.d.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        if (((List)localObject).isEmpty()) {
          return;
        }
        ((List)localObject).remove(paramIChatLayoutListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutListenerController
 * JD-Core Version:    0.7.0.1
 */