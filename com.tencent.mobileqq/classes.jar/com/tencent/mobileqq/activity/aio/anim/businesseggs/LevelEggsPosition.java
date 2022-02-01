package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.graphics.Point;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class LevelEggsPosition
{
  public int a;
  public List<Point> a;
  public int b;
  
  public LevelEggsPosition(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(paramString);
  }
  
  private Point a(String paramString)
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
      Point localPoint = a(paramString[0]);
      if (localPoint == null) {
        return;
      }
      this.jdField_a_of_type_Int = localPoint.x;
      this.b = localPoint.y;
      while (i < paramString.length)
      {
        localPoint = a(paramString[i]);
        if (localPoint != null) {
          this.jdField_a_of_type_JavaUtilList.add(localPoint);
        }
        i += 1;
      }
    }
    QLog.e("LevelEggsPosition", 1, "[parse] error position length < 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.LevelEggsPosition
 * JD-Core Version:    0.7.0.1
 */