package com.tencent.biz.videostory.config.processor;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class VSWaterMarkConfBean
{
  String a = "";
  
  public static VSWaterMarkConfBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.videostory.capture", 2, "config TextUtils.isEmpty(config) return");
      }
      return null;
    }
    VSWaterMarkConfBean localVSWaterMarkConfBean = new VSWaterMarkConfBean();
    localVSWaterMarkConfBean.a(paramString);
    return localVSWaterMarkConfBean;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.config.processor.VSWaterMarkConfBean
 * JD-Core Version:    0.7.0.1
 */