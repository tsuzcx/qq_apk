package com.tencent.mobileqq.activity.aio.item;

import java.util.ArrayList;
import java.util.HashMap;

class StructingMsgItemBuilder$CacheMap
  extends HashMap<String, ArrayList<StructingMsgItemBuilder.ViewWrapper>>
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(StructingMsgItemBuilder.ViewWrapper paramViewWrapper)
  {
    if (paramViewWrapper == null) {
      return;
    }
    get(paramViewWrapper.a).add(paramViewWrapper);
  }
  
  public ArrayList<StructingMsgItemBuilder.ViewWrapper> get(String paramString)
  {
    ArrayList localArrayList2 = (ArrayList)super.get(paramString);
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      put(paramString, localArrayList1);
    }
    return localArrayList1;
  }
  
  public void remove(StructingMsgItemBuilder.ViewWrapper paramViewWrapper)
  {
    if ((paramViewWrapper == null) || (paramViewWrapper.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramViewWrapper.a);
      localArrayList.remove(paramViewWrapper);
    } while (!localArrayList.isEmpty());
    remove(paramViewWrapper.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */