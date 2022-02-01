package com.tencent.mobileqq.activity.recent;

import android.text.TextUtils;
import com.tencent.mobileqq.imcore.proxy.IMCoreConstantsRoute.RecentConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public final class RecentDataListManager$CacheController
{
  private final ConcurrentHashMap<String, RecentBaseData> a = new ConcurrentHashMap(IMCoreConstantsRoute.RecentConstants.a + 10);
  
  public RecentBaseData a(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = (RecentBaseData)this.a.get(paramString);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, paramString.toString());
      }
    }
    return null;
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(RecentBaseData paramRecentBaseData, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramRecentBaseData != null)) {
      this.a.put(paramString, paramRecentBaseData);
    }
  }
  
  public void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.remove(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentDataListManager.CacheController
 * JD-Core Version:    0.7.0.1
 */