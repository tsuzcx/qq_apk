package com.tencent.mobileqq.activity.contact.troop;

import java.util.HashMap;

class TroopActivity$1
  implements ShowExternalTroopListActivity.IShowExternalTroopDataChangedCallBack
{
  TroopActivity$1(TroopActivity paramTroopActivity) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    if ((this.a.a.containsKey(paramString)) && (((Boolean)this.a.a.get(paramString)).booleanValue() != paramBoolean))
    {
      this.a.a.remove(paramString);
      return;
    }
    this.a.a.put(paramString, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopActivity.1
 * JD-Core Version:    0.7.0.1
 */