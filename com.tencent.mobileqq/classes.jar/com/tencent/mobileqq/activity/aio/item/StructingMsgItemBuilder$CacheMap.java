package com.tencent.mobileqq.activity.aio.item;

import java.util.ArrayList;
import java.util.HashMap;
import vij;

class StructingMsgItemBuilder$CacheMap
  extends HashMap
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(vij paramvij)
  {
    if (paramvij == null) {
      return;
    }
    get(paramvij.a).add(paramvij);
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
  
  public void remove(vij paramvij)
  {
    if ((paramvij == null) || (paramvij.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramvij.a);
      localArrayList.remove(paramvij);
    } while (!localArrayList.isEmpty());
    remove(paramvij.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */