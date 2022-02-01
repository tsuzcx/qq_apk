package com.tencent.mobileqq.activity.aio.item;

import ahip;
import java.util.ArrayList;
import java.util.HashMap;

public class StructingMsgItemBuilder$CacheMap
  extends HashMap<String, ArrayList<ahip>>
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(ahip paramahip)
  {
    if (paramahip == null) {
      return;
    }
    get(paramahip.a).add(paramahip);
  }
  
  public ArrayList<ahip> get(String paramString)
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
  
  public void remove(ahip paramahip)
  {
    if ((paramahip == null) || (paramahip.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramahip.a);
      localArrayList.remove(paramahip);
    } while (!localArrayList.isEmpty());
    remove(paramahip.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */