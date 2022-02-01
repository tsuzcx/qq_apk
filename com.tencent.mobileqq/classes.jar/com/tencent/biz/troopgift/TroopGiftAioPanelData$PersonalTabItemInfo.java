package com.tencent.biz.troopgift;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopGiftAioPanelData$PersonalTabItemInfo
{
  public String a = null;
  public ArrayList<Integer> b;
  public ArrayList<Object> c;
  
  public TroopGiftAioPanelData$PersonalTabItemInfo(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.has("name")) {
        this.a = paramJSONObject.optString("name");
      }
      if (paramJSONObject.has("packageIDs"))
      {
        paramJSONObject = paramJSONObject.optJSONArray("packageIDs");
        int j = paramJSONObject.length();
        this.b = new ArrayList();
        this.c = new ArrayList();
        int i = 0;
        while (i < j)
        {
          this.b.add(Integer.valueOf(paramJSONObject.getInt(i)));
          i += 1;
        }
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopGiftAioPanelData", 2, "PersonalTabItemInfo json:", paramJSONObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioPanelData.PersonalTabItemInfo
 * JD-Core Version:    0.7.0.1
 */