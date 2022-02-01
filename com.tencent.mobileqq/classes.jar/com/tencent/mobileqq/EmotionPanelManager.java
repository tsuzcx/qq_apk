package com.tencent.mobileqq;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

public class EmotionPanelManager
{
  private ConcurrentHashMap<String, EmotionInjectionInfo> a;
  
  public static EmotionPanelManager a()
  {
    return EmotionPanelManager.SingletonPatternHolder.a();
  }
  
  public EmotionInjectionInfo a(String paramString)
  {
    if (this.a != null) {
      return (EmotionInjectionInfo)this.a.get(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }
  
  public void a(String paramString, EmotionInjectionInfo paramEmotionInjectionInfo)
  {
    if ((paramEmotionInjectionInfo == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      if (this.a == null) {
        this.a = new ConcurrentHashMap();
      }
    } while (this.a.containsKey(paramString));
    this.a.put(paramString, paramEmotionInjectionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.EmotionPanelManager
 * JD-Core Version:    0.7.0.1
 */