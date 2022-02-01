package com.tencent.biz.qqstory.troop;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.config.CommonConfigBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopDynamicConfig
  extends CommonConfigBase
{
  public boolean a;
  
  public TroopDynamicConfig(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public String a()
  {
    return "key_for_troop_dynamic";
  }
  
  public void a(String paramString)
  {
    boolean bool = true;
    this.a = true;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).getInt("isShowTroopDynamic") != 1) {
          break label56;
        }
        this.a = bool;
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("readQuickShotShareToStoryConfig", 2, paramString.getMessage());
      return;
      label56:
      bool = false;
    }
  }
  
  public String b()
  {
    return "key_for_troop_dynamic_version";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.TroopDynamicConfig
 * JD-Core Version:    0.7.0.1
 */