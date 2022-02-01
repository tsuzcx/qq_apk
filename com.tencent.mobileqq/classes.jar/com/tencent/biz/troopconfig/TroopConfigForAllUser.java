package com.tencent.biz.troopconfig;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.common.config.CommonConfigBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopConfigForAllUser
  extends CommonConfigBase
{
  public boolean d;
  
  public TroopConfigForAllUser(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public String a()
  {
    return "key_for_troop_config_for_all_cfg";
  }
  
  public void a(String paramString)
  {
    boolean bool = true;
    this.d = true;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("isShow3kTroopTips") == 1)
        {
          this.d = bool;
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopConfigForAllUser", 2, paramString.getMessage());
        }
        return;
      }
      bool = false;
    }
  }
  
  public String b()
  {
    return "key_for_troop_config_for_all_cfg_version";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopconfig.TroopConfigForAllUser
 * JD-Core Version:    0.7.0.1
 */