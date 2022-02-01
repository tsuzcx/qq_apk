package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class StickerRecConfigBean
{
  private boolean a;
  private int b;
  
  public static StickerRecConfigBean a(String paramString)
  {
    StickerRecConfigBean localStickerRecConfigBean = new StickerRecConfigBean();
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        if ((paramString.has("useRecommendedSticker")) && (paramString.has("maxMatchLength")))
        {
          localStickerRecConfigBean.a(paramString.getBoolean("useRecommendedSticker"));
          localStickerRecConfigBean.a(paramString.getInt("maxMatchLength"));
          return localStickerRecConfigBean;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d("StickerRecConfigBean", 2, paramString.getMessage());
        }
      }
    }
    return localStickerRecConfigBean;
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecConfigBean
 * JD-Core Version:    0.7.0.1
 */