package com.tencent.biz.qqcircle.publish.activity;

import com.tencent.biz.qqcircle.publish.util.FileUtil;
import java.util.Iterator;
import java.util.List;

final class QCircleSavePart$1
  implements Runnable
{
  QCircleSavePart$1(List paramList, String paramString) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("QQCircle_");
      ((StringBuilder)localObject).append(String.valueOf(System.currentTimeMillis()));
      ((StringBuilder)localObject).append(str.substring(str.lastIndexOf(".")));
      localObject = ((StringBuilder)localObject).toString();
      FileUtil.a(str, this.b, (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.activity.QCircleSavePart.1
 * JD-Core Version:    0.7.0.1
 */