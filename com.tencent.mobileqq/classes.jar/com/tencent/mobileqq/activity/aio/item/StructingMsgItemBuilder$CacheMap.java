package com.tencent.mobileqq.activity.aio.item;

import afyk;
import java.util.ArrayList;
import java.util.HashMap;

public class StructingMsgItemBuilder$CacheMap
  extends HashMap<String, ArrayList<afyk>>
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(afyk paramafyk)
  {
    if (paramafyk == null) {
      return;
    }
    get(paramafyk.a).add(paramafyk);
  }
  
  public ArrayList<afyk> get(String paramString)
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
  
  public void remove(afyk paramafyk)
  {
    if ((paramafyk == null) || (paramafyk.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramafyk.a);
      localArrayList.remove(paramafyk);
    } while (!localArrayList.isEmpty());
    remove(paramafyk.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */