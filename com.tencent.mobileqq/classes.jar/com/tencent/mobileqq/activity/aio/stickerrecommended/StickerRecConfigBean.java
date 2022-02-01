package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class StickerRecConfigBean
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  
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
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecConfigBean
 * JD-Core Version:    0.7.0.1
 */