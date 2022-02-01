package com.tencent.mobileqq.activity.contact.addcontact;

import android.widget.RelativeLayout;
import com.tencent.mobileqq.adapter.MayKnowAdapter.OnRecommendsCanceledListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.SwipListView;

class AddContactsView$3
  implements MayKnowAdapter.OnRecommendsCanceledListener
{
  AddContactsView$3(AddContactsView paramAddContactsView) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onAllRecommendsCaneled");
    }
    this.a.k.setVisibility(8);
    this.a.l.setVisibility(8);
    this.a.p.setVisibility(8);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AddContactsView", 2, "onRecommendsAvailable");
    }
    this.a.k.setVisibility(0);
    this.a.l.setVisibility(0);
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.AddContactsView.3
 * JD-Core Version:    0.7.0.1
 */