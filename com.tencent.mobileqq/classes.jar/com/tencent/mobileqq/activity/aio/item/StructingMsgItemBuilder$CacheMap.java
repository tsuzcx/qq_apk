package com.tencent.mobileqq.activity.aio.item;

import aebw;
import java.util.ArrayList;
import java.util.HashMap;

public class StructingMsgItemBuilder$CacheMap
  extends HashMap<String, ArrayList<aebw>>
{
  private static final long serialVersionUID = -7873031099646660622L;
  
  public void add(aebw paramaebw)
  {
    if (paramaebw == null) {
      return;
    }
    get(paramaebw.a).add(paramaebw);
  }
  
  public ArrayList<aebw> get(String paramString)
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
  
  public void remove(aebw paramaebw)
  {
    if ((paramaebw == null) || (paramaebw.a == null)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = get(paramaebw.a);
      localArrayList.remove(paramaebw);
    } while (!localArrayList.isEmpty());
    remove(paramaebw.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.CacheMap
 * JD-Core Version:    0.7.0.1
 */