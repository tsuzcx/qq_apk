package com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ChatLayoutListenerController
  implements IChatLayoutListenerController
{
  public static int a;
  public static int b = 2;
  public static int c = 3;
  private HashMap<Integer, List<IChatLayoutListener>> a;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  public void a(int paramInt, IChatLayoutListener.ChatLayoutListenerInfo paramChatLayoutListenerInfo)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {}
    for (;;)
    {
      return;
      Object localObject = (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((IChatLayoutListener)((Iterator)localObject).next()).a(paramInt, paramChatLayoutListenerInfo);
        }
      }
    }
  }
  
  public void a(int paramInt, IChatLayoutListener paramIChatLayoutListener)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    }
    List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localObject);
    }
    ((List)localObject).add(paramIChatLayoutListener);
  }
  
  public void b(int paramInt, IChatLayoutListener paramIChatLayoutListener)
  {
    if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {}
    List localList;
    do
    {
      return;
      localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    } while ((localList == null) || (localList.isEmpty()));
    localList.remove(paramIChatLayoutListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutListenerController
 * JD-Core Version:    0.7.0.1
 */