package com.tencent.mobileqq.activity;

import MQQ.MenumItem;
import bhze;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class QQSettingMe$22
  implements Runnable
{
  QQSettingMe$22(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    Map localMap = QQSettingMe.a(this.this$0).a(this.this$0.a);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      QQSettingMe.a(this.this$0, QQSettingMe.a(this.this$0).b(localInteger), (MenumItem)localMap.get(localInteger));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.22
 * JD-Core Version:    0.7.0.1
 */