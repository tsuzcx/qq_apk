package com.tencent.mobileqq;

import android.text.TextUtils;
import com.tencent.mobileqq.config.business.EmoticonTabSortConfMapping;
import com.tencent.mobileqq.emoticon.EmotionInjectionInfo;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EmotionPanelInjectionInfoManager
{
  private ConcurrentHashMap<String, EmotionInjectionInfo> a;
  
  public EmotionInjectionInfo a(int paramInt)
  {
    String str = EmoticonTabSortConfMapping.a(paramInt);
    ConcurrentHashMap localConcurrentHashMap = this.a;
    if ((localConcurrentHashMap != null) && (str != null)) {
      return (EmotionInjectionInfo)localConcurrentHashMap.get(str);
    }
    return null;
  }
  
  public EmotionInjectionInfo a(String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = this.a;
    if ((localConcurrentHashMap != null) && (paramString != null)) {
      return (EmotionInjectionInfo)localConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public Map<String, EmotionInjectionInfo> a()
  {
    return this.a;
  }
  
  public void a(String paramString, EmotionInjectionInfo paramEmotionInjectionInfo)
  {
    if (paramEmotionInjectionInfo != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (this.a == null) {
        this.a = new ConcurrentHashMap();
      }
      if (!this.a.containsKey(paramString)) {
        this.a.put(paramString, paramEmotionInjectionInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.EmotionPanelInjectionInfoManager
 * JD-Core Version:    0.7.0.1
 */