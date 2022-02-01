package com.tencent.mobileqq.activity.aio.item;

import ahto;
import java.util.ArrayList;
import java.util.HashMap;

public class StructingMsgItemBuilder$CacheMap
  extends HashMap<String, ArrayList<ahto>>
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(ahto paramahto)
  {
    if (paramahto == null) {
      return;
    }
    get(paramahto.a).add(paramahto);
  }
  
  public ArrayList<ahto> get(String paramString)
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
  
  public void remove(ahto paramahto)
  {
    if ((paramahto == null) || (paramahto.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramahto.a);
      localArrayList.remove(paramahto);
    } while (!localArrayList.isEmpty());
    remove(paramahto.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */