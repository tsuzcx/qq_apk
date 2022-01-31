package com.tencent.mobileqq.activity.aio.item;

import java.util.ArrayList;
import java.util.HashMap;
import vnl;

class StructingMsgItemBuilder$CacheMap
  extends HashMap
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(vnl paramvnl)
  {
    if (paramvnl == null) {
      return;
    }
    get(paramvnl.a).add(paramvnl);
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
  
  public void remove(vnl paramvnl)
  {
    if ((paramvnl == null) || (paramvnl.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramvnl.a);
      localArrayList.remove(paramvnl);
    } while (!localArrayList.isEmpty());
    remove(paramvnl.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */