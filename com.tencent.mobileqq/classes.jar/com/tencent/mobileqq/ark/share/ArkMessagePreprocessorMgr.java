package com.tencent.mobileqq.ark.share;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ArkMessagePreprocessorMgr
{
  private final HashMap<String, IArkMessagePreprocessor> a = new HashMap();
  
  public IArkMessagePreprocessor a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkMessagePreprocessorMgr", 2, "AAShare.getPreprocessor in valid param");
      }
      return null;
    }
    synchronized (this.a)
    {
      paramString = (IArkMessagePreprocessor)this.a.get(paramString);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.share.ArkMessagePreprocessorMgr
 * JD-Core Version:    0.7.0.1
 */