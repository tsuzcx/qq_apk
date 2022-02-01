package com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class HongBaoScenesRecommendItem
  extends ScenesRecommendItem
{
  int a = 100;
  
  public HongBaoScenesRecommendItem(ScenesRecommendItem.ScenesRecConfigItem paramScenesRecConfigItem)
  {
    super(paramScenesRecConfigItem);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has("moneylimit"))) {
      try
      {
        this.a = paramJSONObject.getInt("moneylimit");
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    BaseApplication.getContext().getSharedPreferences("MOBILEQQ HONGBAO_SCENESRECOMMEND_INFO", 4).edit().putInt("HONGBAO_SCENES_MONEY_LIMIT", this.a).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.HongBaoScenesRecommendItem
 * JD-Core Version:    0.7.0.1
 */