package com.tencent.mobileqq.activity.contact.addcontact;

import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import java.util.List;

class ClassificationSearchActivity$9
  extends ReadInJoyObserver
{
  ClassificationSearchActivity$9(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void a(boolean paramBoolean, List<ChannelInfo> paramList)
  {
    if (paramBoolean)
    {
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.a.v.clear();
        this.a.v.addAll(paramList);
      }
      ClassificationSearchActivity.b(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.9
 * JD-Core Version:    0.7.0.1
 */