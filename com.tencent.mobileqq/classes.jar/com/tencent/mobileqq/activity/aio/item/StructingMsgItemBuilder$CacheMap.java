package com.tencent.mobileqq.activity.aio.item;

import adqz;
import java.util.ArrayList;
import java.util.HashMap;

public class StructingMsgItemBuilder$CacheMap
  extends HashMap<String, ArrayList<adqz>>
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(adqz paramadqz)
  {
    if (paramadqz == null) {
      return;
    }
    get(paramadqz.a).add(paramadqz);
  }
  
  public ArrayList<adqz> get(String paramString)
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
  
  public void remove(adqz paramadqz)
  {
    if ((paramadqz == null) || (paramadqz.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramadqz.a);
      localArrayList.remove(paramadqz);
    } while (!localArrayList.isEmpty());
    remove(paramadqz.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */