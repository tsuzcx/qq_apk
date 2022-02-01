package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import android.text.TextUtils;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Map;

public class DoubleShortVideoFontSizeConfigHandler
  extends SimpleConfigHandler
{
  public static String a()
  {
    return (String)ReadInJoyHelper.a("double_short_video_font_size", "14");
  }
  
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("DoubleShortVideoFontSize", 2, "[onReceiveConfig] " + paramString);
    paramString = AladdinParseUtils.a(paramString);
    try
    {
      paramString = (String)paramString.get("double_videocard_textsize");
      if (!TextUtils.isEmpty(paramString)) {
        ReadInJoyHelper.a("double_short_video_font_size", paramString);
      }
      label63:
      return true;
    }
    catch (Exception paramString)
    {
      break label63;
    }
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    ReadInJoyHelper.a("double_short_video_font_size", "14");
    if (QLog.isColorLevel()) {
      QLog.d("DoubleShortVideoFontSize", 2, "font size: " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.DoubleShortVideoFontSizeConfigHandler
 * JD-Core Version:    0.7.0.1
 */