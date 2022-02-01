package com.tencent.biz.qqstory.takevideo;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.mobileqq.activity.contacts.base.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

class EditVideoPoi$2
  implements OverScrollViewListener
{
  EditVideoPoi$2(EditVideoPoi paramEditVideoPoi) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.c(l);
      return;
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.b(l);
      return;
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    paramListView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.jdField_a_of_type_Long == 0L)
    {
      l = System.currentTimeMillis();
      paramListView.a(l);
      if (!NetworkUtil.g(this.a.a())) {
        break label118;
      }
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession != null) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.a();
      }
      this.a.g();
      new Handler(Looper.getMainLooper()).postDelayed(new EditVideoPoi.2.1(this), 300L);
    }
    for (;;)
    {
      ((Contacts.OverScrollViewTag)paramView.getTag()).a = true;
      return true;
      l = this.a.jdField_a_of_type_Long;
      break;
      label118:
      new Handler(Looper.getMainLooper()).postDelayed(new EditVideoPoi.2.2(this), 300L);
    }
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPoi.2
 * JD-Core Version:    0.7.0.1
 */