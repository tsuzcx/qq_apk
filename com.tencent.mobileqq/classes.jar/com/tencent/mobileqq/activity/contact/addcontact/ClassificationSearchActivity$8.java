package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.biz.lebasearch.SearchProtocol.SearchObserver;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ClassificationSearchActivity$8
  extends SearchProtocol.SearchObserver
{
  ClassificationSearchActivity$8(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void a(int paramInt, List<SearchProtocol.WordItem> paramList)
  {
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClassificationSearchActivity", 2, "hot words size: " + paramList.size());
      }
      this.a.b = paramList;
      ClassificationSearchActivity.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.8
 * JD-Core Version:    0.7.0.1
 */