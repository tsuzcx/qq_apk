package com.tencent.biz.qqcircle.utils;

import android.graphics.drawable.Drawable;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.HashMap;
import java.util.Map;

public class QCircleDrawableCacheUtils
{
  private static final Map<Integer, Drawable> a = new HashMap();
  
  public static Drawable a(int paramInt)
  {
    Object localObject = a;
    if (localObject == null) {
      return QCircleSkinHelper.getInstance().getDrawable(paramInt);
    }
    Drawable localDrawable = (Drawable)((Map)localObject).get(Integer.valueOf(paramInt));
    localObject = localDrawable;
    if (localDrawable == null)
    {
      localDrawable = QCircleSkinHelper.getInstance().getDrawable(paramInt);
      localObject = localDrawable;
      if (localDrawable != null)
      {
        a.put(Integer.valueOf(paramInt), localDrawable);
        localObject = localDrawable;
      }
    }
    return localObject;
  }
  
  public static void a()
  {
    Map localMap = a;
    if (localMap != null) {
      localMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleDrawableCacheUtils
 * JD-Core Version:    0.7.0.1
 */