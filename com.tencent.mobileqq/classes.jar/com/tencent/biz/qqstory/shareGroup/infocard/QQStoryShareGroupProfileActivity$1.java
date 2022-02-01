package com.tencent.biz.qqstory.shareGroup.infocard;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import wsv;
import wth;

class QQStoryShareGroupProfileActivity$1
  implements Runnable
{
  QQStoryShareGroupProfileActivity$1(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity) {}
  
  public void run()
  {
    wsv localwsv = (wsv)wth.a(18);
    ArrayList localArrayList = localwsv.a(this.this$0);
    int i = localArrayList.size();
    if (i >= 4)
    {
      localwsv.a(((Integer)localArrayList.get(0)).intValue() + 1, ((Integer)localArrayList.get(i - 1)).intValue());
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "QQStoryShareGroupProfileActivity activity stack full, size = " + i + ", start clear!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.1
 * JD-Core Version:    0.7.0.1
 */