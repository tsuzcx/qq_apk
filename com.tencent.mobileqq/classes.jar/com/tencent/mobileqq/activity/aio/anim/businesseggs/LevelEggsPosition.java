package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class LevelEggsPosition
{
  public int a;
  public int b;
  public List<Point> c = new ArrayList();
  
  public LevelEggsPosition(String paramString)
  {
    a(paramString);
  }
  
  private Point b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.split(",");
    if (paramString.length != 2) {
      return null;
    }
    double d1 = Double.parseDouble(paramString[0]);
    double d2 = Double.parseDouble(paramString[1]);
    return new Point((int)d1, (int)d2);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = paramString.split(";");
    int j = paramString.length;
    int i = 1;
    if (j > 1)
    {
      Point localPoint = b(paramString[0]);
      if (localPoint == null) {
        return;
      }
      this.a = localPoint.x;
      this.b = localPoint.y;
      while (i < paramString.length)
      {
        localPoint = b(paramString[i]);
        if (localPoint != null) {
          this.c.add(localPoint);
        }
        i += 1;
      }
    }
    QLog.e("LevelEggsPosition", 1, "[parse] error position length < 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.LevelEggsPosition
 * JD-Core Version:    0.7.0.1
 */