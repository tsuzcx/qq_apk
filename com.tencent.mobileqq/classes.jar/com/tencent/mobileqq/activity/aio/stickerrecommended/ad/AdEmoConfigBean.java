package com.tencent.mobileqq.activity.aio.stickerrecommended.ad;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class AdEmoConfigBean
{
  public JSONObject a = new JSONObject();
  
  public static AdEmoConfigBean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        AdEmoConfigBean localAdEmoConfigBean = new AdEmoConfigBean();
        localAdEmoConfigBean.a = paramString;
        return localAdEmoConfigBean;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdEmoConfigBean", 2, paramString.getMessage());
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.ad.AdEmoConfigBean
 * JD-Core Version:    0.7.0.1
 */