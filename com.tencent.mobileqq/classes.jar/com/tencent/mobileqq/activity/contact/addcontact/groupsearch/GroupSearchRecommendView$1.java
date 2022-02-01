package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.app.Activity;
import com.tencent.biz.addContactTroopView.AddContactTroopHandler.IGetPopClassAndSearchCB;

class GroupSearchRecommendView$1
  implements AddContactTroopHandler.IGetPopClassAndSearchCB
{
  GroupSearchRecommendView$1(GroupSearchRecommendView paramGroupSearchRecommendView) {}
  
  public void a()
  {
    if ((this.a.a != null) && (this.a.a.b() != null))
    {
      if (this.a.a.b().isFinishing()) {
        return;
      }
      GroupSearchRecommendView.b(this.a).sendEmptyMessage(2);
    }
  }
  
  public void b()
  {
    if ((this.a.a != null) && (this.a.a.b() != null))
    {
      if (this.a.a.b().isFinishing()) {
        return;
      }
      GroupSearchRecommendView.b(this.a).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView.1
 * JD-Core Version:    0.7.0.1
 */