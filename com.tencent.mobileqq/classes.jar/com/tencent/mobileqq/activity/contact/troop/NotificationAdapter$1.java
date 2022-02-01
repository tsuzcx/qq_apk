package com.tencent.mobileqq.activity.contact.troop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class NotificationAdapter$1
  implements View.OnClickListener
{
  NotificationAdapter$1(NotificationAdapter paramNotificationAdapter) {}
  
  public void onClick(View paramView)
  {
    NotificationAdapter.ViewHolder localViewHolder = (NotificationAdapter.ViewHolder)paramView.getTag();
    if ((localViewHolder == null) || (!(localViewHolder instanceof NotificationAdapter.ViewHolder))) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.a();
      View localView = (View)paramView.getParent();
      if ((localView instanceof ShaderAnimLayout)) {
        ((ShaderAnimLayout)localView).d();
      }
      NotificationAdapter.a(this.a, localViewHolder.a);
      this.a.jdField_a_of_type_JavaUtilList.add(NotificationAdapter.a(this.a).remove(this.a.getCount() - localViewHolder.b - 1));
      this.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.NotificationAdapter.1
 * JD-Core Version:    0.7.0.1
 */