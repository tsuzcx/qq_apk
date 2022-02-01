package com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.image.RIJPreloadImage;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView.OnDrawCompleteListener;
import com.tencent.widget.ListView;

public class RIJDataManager$OnDrawCompleteListener
  implements ReadInJoyBaseListView.OnDrawCompleteListener
{
  RIJDataManager a;
  
  RIJDataManager$OnDrawCompleteListener(RIJDataManager paramRIJDataManager1, RIJDataManager paramRIJDataManager2)
  {
    this.a = paramRIJDataManager2;
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    if (!this.b.a().c()) {
      return;
    }
    this.b.a().e(false);
    this.b.a().a().a(paramReadInJoyBaseListView);
    this.b.a().a().a(this.b.a().a().a().getLastVisiblePosition() + 1, this.b.a().a().a(), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.data.RIJDataManager.OnDrawCompleteListener
 * JD-Core Version:    0.7.0.1
 */