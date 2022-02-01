package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.AladdinParseUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Map;

public class VideoSingleModeConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    super.onReceiveConfig(paramInt1, paramInt2, paramString);
    QLog.d("VideoSingleModeConfigHandler", 2, "[onReceiveConfig] " + paramString);
    paramString = AladdinParseUtils.a(paramString);
    if ((String)paramString.get("readinjoy_single_video_switch") != null) {
      ReadInJoyHelper.a((String)paramString.get("readinjoy_single_video_switch"));
    }
    return true;
  }
  
  public void onWipeConfig(int paramInt)
  {
    super.onWipeConfig(paramInt);
    ReadInJoyHelper.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.VideoSingleModeConfigHandler
 * JD-Core Version:    0.7.0.1
 */