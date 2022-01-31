package com.tencent.mobileqq.activity.aio.item;

import agcz;
import java.util.ArrayList;
import java.util.HashMap;

public class StructingMsgItemBuilder$CacheMap
  extends HashMap<String, ArrayList<agcz>>
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(agcz paramagcz)
  {
    if (paramagcz == null) {
      return;
    }
    get(paramagcz.a).add(paramagcz);
  }
  
  public ArrayList<agcz> get(String paramString)
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
  
  public void remove(agcz paramagcz)
  {
    if ((paramagcz == null) || (paramagcz.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramagcz.a);
      localArrayList.remove(paramagcz);
    } while (!localArrayList.isEmpty());
    remove(paramagcz.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */