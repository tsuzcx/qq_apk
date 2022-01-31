package com.tencent.mobileqq.activity.aio.item;

import aeby;
import java.util.ArrayList;
import java.util.HashMap;

public class StructingMsgItemBuilder$CacheMap
  extends HashMap<String, ArrayList<aeby>>
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(aeby paramaeby)
  {
    if (paramaeby == null) {
      return;
    }
    get(paramaeby.a).add(paramaeby);
  }
  
  public ArrayList<aeby> get(String paramString)
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
  
  public void remove(aeby paramaeby)
  {
    if ((paramaeby == null) || (paramaeby.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramaeby.a);
      localArrayList.remove(paramaeby);
    } while (!localArrayList.isEmpty());
    remove(paramaeby.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */