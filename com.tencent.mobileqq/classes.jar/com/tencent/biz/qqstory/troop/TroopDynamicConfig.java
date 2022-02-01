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
  public boolean d;
  
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
    this.d = true;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).getInt("isShowTroopDynamic") == 1)
        {
          this.d = bool;
          return;
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("readQuickShotShareToStoryConfig", 2, paramString.getMessage());
        }
        return;
      }
      bool = false;
    }
  }
  
  public String b()
  {
    return "key_for_troop_dynamic_version";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.TroopDynamicConfig
 * JD-Core Version:    0.7.0.1
 */