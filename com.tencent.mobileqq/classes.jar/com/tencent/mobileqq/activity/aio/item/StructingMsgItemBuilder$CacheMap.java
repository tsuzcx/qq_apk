package com.tencent.mobileqq.activity.aio.item;

import ahke;
import java.util.ArrayList;
import java.util.HashMap;

public class StructingMsgItemBuilder$CacheMap
  extends HashMap<String, ArrayList<ahke>>
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(ahke paramahke)
  {
    if (paramahke == null) {
      return;
    }
    get(paramahke.a).add(paramahke);
  }
  
  public ArrayList<ahke> get(String paramString)
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
  
  public void remove(ahke paramahke)
  {
    if ((paramahke == null) || (paramahke.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramahke.a);
      localArrayList.remove(paramahke);
    } while (!localArrayList.isEmpty());
    remove(paramahke.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */