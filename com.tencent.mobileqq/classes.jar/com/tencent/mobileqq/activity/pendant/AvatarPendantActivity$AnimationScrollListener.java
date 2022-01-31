package com.tencent.mobileqq.activity.pendant;

import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import wpt;

public class AvatarPendantActivity$AnimationScrollListener
  implements AbsListView.OnScrollListener
{
  public AvatarPendantActivity$AnimationScrollListener(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      ((AvatarPendantManager)this.b.app.getManager(45)).a(this.b.jdField_a_of_type_Long).a(false);
    }
    for (;;)
    {
      this.b.r = paramInt;
      if (paramInt != 0) {
        break label127;
      }
      if (!this.b.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a) {
        break;
      }
      this.b.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new wpt(this), 80L);
      return;
      ((AvatarPendantManager)this.b.app.getManager(45)).a(this.b.jdField_a_of_type_Long).a(true);
    }
    URLDrawable.resume();
    this.b.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.notifyDataSetChanged();
    return;
    label127:
    URLDrawable.pause();
    this.b.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a = true;
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.AnimationScrollListener
 * JD-Core Version:    0.7.0.1
 */