package com.tencent.mobileqq.activity.aio.item;

import agpz;
import java.util.ArrayList;
import java.util.HashMap;

public class StructingMsgItemBuilder$CacheMap
  extends HashMap<String, ArrayList<agpz>>
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(agpz paramagpz)
  {
    if (paramagpz == null) {
      return;
    }
    get(paramagpz.a).add(paramagpz);
  }
  
  public ArrayList<agpz> get(String paramString)
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
  
  public void remove(agpz paramagpz)
  {
    if ((paramagpz == null) || (paramagpz.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramagpz.a);
      localArrayList.remove(paramagpz);
    } while (!localArrayList.isEmpty());
    remove(paramagpz.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */