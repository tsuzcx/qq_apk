package com.tencent.mobileqq.activity.aio.item;

import java.util.ArrayList;
import java.util.HashMap;
import vfh;

class StructingMsgItemBuilder$CacheMap
  extends HashMap
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(vfh paramvfh)
  {
    if (paramvfh == null) {
      return;
    }
    get(paramvfh.a).add(paramvfh);
  }
  
  public ArrayList get(String paramString)
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
  
  public void remove(vfh paramvfh)
  {
    if ((paramvfh == null) || (paramvfh.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramvfh.a);
      localArrayList.remove(paramvfh);
    } while (!localArrayList.isEmpty());
    remove(paramvfh.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */