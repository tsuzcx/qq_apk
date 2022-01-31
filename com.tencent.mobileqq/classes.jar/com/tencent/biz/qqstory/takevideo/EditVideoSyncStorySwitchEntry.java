package com.tencent.biz.qqstory.takevideo;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoSyncStorySwitchEntry
{
  public EditVideoSyncStorySwitchEntry.SwitchEntryData a = new EditVideoSyncStorySwitchEntry.SwitchEntryData(this, false, false, false);
  public EditVideoSyncStorySwitchEntry.SwitchEntryData b = new EditVideoSyncStorySwitchEntry.SwitchEntryData(this, false, false, false);
  
  public EditVideoSyncStorySwitchEntry(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.a = new EditVideoSyncStorySwitchEntry.SwitchEntryData(this, paramString.optJSONObject("group"));
      this.b = new EditVideoSyncStorySwitchEntry.SwitchEntryData(this, paramString.optJSONObject("discuss"));
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("zivonchen", 2, QLog.getStackTraceString(paramString));
      return;
    }
    catch (NullPointerException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("zivonchen", 2, QLog.getStackTraceString(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSyncStorySwitchEntry
 * JD-Core Version:    0.7.0.1
 */