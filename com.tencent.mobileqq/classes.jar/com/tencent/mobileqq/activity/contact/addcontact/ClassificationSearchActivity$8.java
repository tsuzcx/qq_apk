package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.mobileqq.kandian.biz.search.entity.WordItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ClassificationSearchActivity$8
  extends SearchProtocol.SearchObserver
{
  ClassificationSearchActivity$8(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void a(int paramInt, List<WordItem> paramList)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hot words size: ");
        ((StringBuilder)localObject).append(paramList.size());
        QLog.d("ClassificationSearchActivity", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.a;
      ((ClassificationSearchActivity)localObject).u = paramList;
      ClassificationSearchActivity.a((ClassificationSearchActivity)localObject, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.8
 * JD-Core Version:    0.7.0.1
 */