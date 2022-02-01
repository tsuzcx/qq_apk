package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import java.util.List;

class ClassificationSearchActivity$9
  extends ReadInJoyObserver
{
  ClassificationSearchActivity$9(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void f(boolean paramBoolean, List<ChannelInfo> paramList)
  {
    if (paramBoolean)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.a.c.clear();
        this.a.c.addAll(paramList);
      }
      ClassificationSearchActivity.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.9
 * JD-Core Version:    0.7.0.1
 */