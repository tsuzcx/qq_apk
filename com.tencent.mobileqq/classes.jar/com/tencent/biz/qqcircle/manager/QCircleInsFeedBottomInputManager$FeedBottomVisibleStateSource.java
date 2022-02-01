package com.tencent.biz.qqcircle.manager;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class QCircleInsFeedBottomInputManager$FeedBottomVisibleStateSource
{
  private final Map<String, Integer> a = new ConcurrentHashMap();
  
  public int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("FeedBottomVisibleStateSource", 1, "[QCFE] obtainInsFeedVisible feed id not is empty.");
      return 8;
    }
    if (!this.a.containsKey(paramString)) {
      return 8;
    }
    paramString = (Integer)this.a.get(paramString);
    if (paramString == null) {
      return 8;
    }
    return paramString.intValue();
  }
  
  public void a()
  {
    this.a.clear();
  }
  
  public void a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w("FeedBottomVisibleStateSource", 1, "[QCFE] putFeedInsVisible feed id not is empty.");
      return;
    }
    this.a.put(paramString, Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.manager.QCircleInsFeedBottomInputManager.FeedBottomVisibleStateSource
 * JD-Core Version:    0.7.0.1
 */