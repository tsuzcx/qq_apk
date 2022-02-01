package com.tencent.biz.qqstory.shareGroup.infocard;

import com.tencent.biz.qqstory.model.QQStoryActivityManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QQStoryShareGroupProfileActivity$1
  implements Runnable
{
  QQStoryShareGroupProfileActivity$1(QQStoryShareGroupProfileActivity paramQQStoryShareGroupProfileActivity) {}
  
  public void run()
  {
    Object localObject = (QQStoryActivityManager)SuperManager.a(18);
    ArrayList localArrayList = ((QQStoryActivityManager)localObject).c(this.this$0);
    int i = localArrayList.size();
    if (i >= 4)
    {
      ((QQStoryActivityManager)localObject).a(((Integer)localArrayList.get(0)).intValue() + 1, ((Integer)localArrayList.get(i - 1)).intValue());
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("QQStoryShareGroupProfileActivity activity stack full, size = ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", start clear!");
        QLog.d("zivonchen", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.infocard.QQStoryShareGroupProfileActivity.1
 * JD-Core Version:    0.7.0.1
 */