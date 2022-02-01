package com.tencent.biz.qqcircle.beans;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class QCircleTabInfo
{
  public QQCircleFeedBase.StTabInfo a;
  private boolean b = false;
  
  public QCircleTabInfo(QQCircleFeedBase.StTabInfo paramStTabInfo)
  {
    this.a = paramStTabInfo;
  }
  
  public static QCircleTabInfo a(QQCircleFeedBase.StTabInfo paramStTabInfo)
  {
    return new QCircleTabInfo(paramStTabInfo);
  }
  
  public int a()
  {
    return this.a.tabType.get();
  }
  
  public String b()
  {
    return this.a.tabName.get();
  }
  
  public int c()
  {
    int j = a();
    int i = 6;
    if (j != 1)
    {
      if (j != 2)
      {
        if (j != 3)
        {
          if (j != 4)
          {
            if (j != 6) {
              return 0;
            }
            return 10;
          }
          return 5;
        }
      }
      else {
        return 4;
      }
    }
    else {
      i = 1;
    }
    return i;
  }
  
  public String d()
  {
    return this.a.attachInfo.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.QCircleTabInfo
 * JD-Core Version:    0.7.0.1
 */