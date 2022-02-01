package com.tencent.mobileqq.activity.pendant;

import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

public class AvatarPendantActivity$AnimationScrollListener
  implements AbsListView.OnScrollListener
{
  public AvatarPendantActivity$AnimationScrollListener(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      ((AvatarPendantManager)this.b.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.b.jdField_a_of_type_Long).a(false);
    } else {
      ((AvatarPendantManager)this.b.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.b.jdField_a_of_type_Long).a(true);
    }
    paramAbsListView = this.b;
    paramAbsListView.u = paramInt;
    if (paramInt == 0)
    {
      if (paramAbsListView.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a)
      {
        this.b.jdField_a_of_type_ComTencentWidgetXListView.postDelayed(new AvatarPendantActivity.AnimationScrollListener.1(this), 80L);
        return;
      }
      URLDrawable.resume();
      this.b.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.notifyDataSetChanged();
      return;
    }
    URLDrawable.pause();
    this.b.jdField_a_of_type_ComTencentMobileqqAdapterAvatarPendantAdapter.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.AnimationScrollListener
 * JD-Core Version:    0.7.0.1
 */