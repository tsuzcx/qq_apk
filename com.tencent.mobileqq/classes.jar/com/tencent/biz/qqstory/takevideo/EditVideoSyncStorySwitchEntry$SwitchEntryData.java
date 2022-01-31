package com.tencent.biz.qqstory.takevideo;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class EditVideoSyncStorySwitchEntry$SwitchEntryData
{
  public boolean a;
  public boolean b;
  public boolean c;
  
  public EditVideoSyncStorySwitchEntry$SwitchEntryData(EditVideoSyncStorySwitchEntry paramEditVideoSyncStorySwitchEntry, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        if (paramJSONObject.optInt("show") == 1)
        {
          bool1 = true;
          this.jdField_a_of_type_Boolean = bool1;
          if (paramJSONObject.optInt("initOpen") != 1) {
            continue;
          }
          bool1 = true;
          this.b = bool1;
          if (paramJSONObject.optInt("reset") != 1) {
            continue;
          }
          bool1 = bool2;
          this.c = bool1;
          return;
        }
      }
      catch (NullPointerException paramEditVideoSyncStorySwitchEntry)
      {
        boolean bool1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("zivonchen", 2, QLog.getStackTraceString(paramEditVideoSyncStorySwitchEntry));
      }
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public EditVideoSyncStorySwitchEntry$SwitchEntryData(EditVideoSyncStorySwitchEntry paramEditVideoSyncStorySwitchEntry, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    for (;;)
    {
      try
      {
        paramEditVideoSyncStorySwitchEntry = new JSONObject();
        if (paramBoolean1)
        {
          i = 1;
          paramEditVideoSyncStorySwitchEntry.put("show", i);
          if (!paramBoolean2) {
            continue;
          }
          i = 1;
          paramEditVideoSyncStorySwitchEntry.put("initOpen", i);
          if (!paramBoolean3) {
            continue;
          }
          i = j;
          paramEditVideoSyncStorySwitchEntry.put("reset", i);
          return;
        }
      }
      catch (JSONException paramEditVideoSyncStorySwitchEntry)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("zivonchen", 2, QLog.getStackTraceString(paramEditVideoSyncStorySwitchEntry));
      }
      i = 0;
      continue;
      i = 0;
      continue;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoSyncStorySwitchEntry.SwitchEntryData
 * JD-Core Version:    0.7.0.1
 */