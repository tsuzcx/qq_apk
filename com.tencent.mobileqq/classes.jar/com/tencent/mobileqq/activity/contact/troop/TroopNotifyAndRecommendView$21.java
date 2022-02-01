package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.recommendtroop.base.ViewHolder;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;

class TroopNotifyAndRecommendView$21
  extends SuspiciousAdapter<MessageRecord>
{
  TroopNotifyAndRecommendView$21(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public ViewHolder a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = new SwipRightMenuBuilder.SwipItemBaseHolder();
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopDelMenuBuilder.a(paramContext, paramInt, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject);
    paramContext = new SuspiciousHolder(paramContext, paramViewGroup);
    paramContext.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder$SwipItemBaseHolder = ((SwipRightMenuBuilder.SwipItemBaseHolder)localObject);
    localObject = new NotificationAdapter.ApplicantHolder();
    ((NotificationAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131374118);
    ((NotificationAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((NotificationAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131374131));
    ((NotificationAdapter.ApplicantHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)((NotificationAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131374132));
    ((NotificationAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)((NotificationAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131374128));
    ((NotificationAdapter.ApplicantHolder)localObject).c = ((TextView)((NotificationAdapter.ApplicantHolder)localObject).jdField_a_of_type_AndroidViewView.findViewById(2131374127));
    paramContext.jdField_a_of_type_ComTencentMobileqqActivityContactTroopNotificationAdapter$ApplicantHolder = ((NotificationAdapter.ApplicantHolder)localObject);
    paramContext.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131374134));
    paramContext.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131374117));
    paramContext.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131374125));
    paramContext.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131374138));
    paramContext.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131374123));
    paramContext.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131374135));
    paramContext.c = ((TextView)paramViewGroup.findViewById(2131374137));
    paramContext.d = ((TextView)paramViewGroup.findViewById(2131374124));
    paramContext.jdField_a_of_type_AndroidWidgetButton = ((Button)paramViewGroup.findViewById(2131374133));
    paramContext.jdField_a_of_type_ComTencentMobileqqWidgetShaderAnimLayout = ((ShaderAnimLayout)paramViewGroup.findViewById(2131379998));
    paramViewGroup = (Button)paramViewGroup.findViewById(2131379997);
    TroopSuspiciousHelper.a(paramContext.jdField_a_of_type_AndroidWidgetLinearLayout, false);
    return paramContext;
  }
  
  protected void a(ViewHolder paramViewHolder, MessageRecord paramMessageRecord, int paramInt)
  {
    if (!(paramViewHolder instanceof SuspiciousHolder)) {
      return;
    }
    SuspiciousHolder localSuspiciousHolder = (SuspiciousHolder)paramViewHolder;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopDelMenuBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramViewHolder.itemView, paramInt, paramMessageRecord, localSuspiciousHolder.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder$SwipItemBaseHolder, new TroopNotifyAndRecommendView.21.1(this), this.d);
    TroopNotifyAndRecommendView.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopTroopNotifyAndRecommendView, paramViewHolder, paramMessageRecord, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.21
 * JD-Core Version:    0.7.0.1
 */