package com.tencent.mobileqq.activity.chathistory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.mobileqq.widget.datepicker.CalendarDay;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedList;
import java.util.List;

class TroopMemberHistoryFragment$TroopMemberChatHisListAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<TroopMemberHistoryFragment.MsgItemEntity> jdField_a_of_type_JavaUtilList = new LinkedList();
  
  TroopMemberHistoryFragment$TroopMemberChatHisListAdapter(TroopMemberHistoryFragment paramTroopMemberHistoryFragment, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  boolean a(long paramLong1, long paramLong2)
  {
    CalendarDay localCalendarDay1 = new CalendarDay(paramLong1 * 1000L);
    CalendarDay localCalendarDay2 = new CalendarDay(paramLong2 * 1000L);
    return (localCalendarDay1.year == localCalendarDay2.year) && (localCalendarDay1.month == localCalendarDay2.month) && (localCalendarDay1.day == localCalendarDay2.day);
  }
  
  boolean a(List<TroopMemberHistoryFragment.MsgItemEntity> paramList)
  {
    int j = paramList.size();
    int i = 0;
    long l2;
    for (long l1 = 0L; i < j; l1 = l2)
    {
      TroopMemberHistoryFragment.MsgItemEntity localMsgItemEntity = (TroopMemberHistoryFragment.MsgItemEntity)paramList.get(i);
      l2 = localMsgItemEntity.jdField_a_of_type_Long;
      if ((l1 == 0L) || (!a(l1, l2))) {
        localMsgItemEntity.jdField_a_of_type_Boolean = true;
      }
      this.jdField_a_of_type_JavaUtilList.add(localMsgItemEntity);
      i += 1;
    }
    return true;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopMemberHistoryFragment.ItemViewHolder localItemViewHolder;
    TroopMemberHistoryFragment.MsgItemEntity localMsgItemEntity;
    Object localObject;
    RelativeLayout.LayoutParams localLayoutParams;
    int i;
    if (paramView == null)
    {
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2131559463, null);
      localItemViewHolder = new TroopMemberHistoryFragment.ItemViewHolder();
      localItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView = ((ColorNickTextView)paramView.findViewById(2131379092));
      localItemViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379094));
      localItemViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131368603));
      localItemViewHolder.b = ((TextView)paramView.findViewById(2131370043));
      localItemViewHolder.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370465);
      localItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131379954));
      paramView.setTag(localItemViewHolder);
      localMsgItemEntity = (TroopMemberHistoryFragment.MsgItemEntity)getItem(paramInt);
      localItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMsgItemEntity.jdField_a_of_type_JavaLangCharSequence);
      localItemViewHolder.b.setText(localMsgItemEntity.a());
      localObject = new ColorNickText(ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.b, localMsgItemEntity.jdField_a_of_type_JavaLangString), 16).a();
      localItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView.setText((CharSequence)localObject);
      ColorNickManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localItemViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetColorNickTextView, (Spannable)localObject);
      localObject = FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, localMsgItemEntity.jdField_a_of_type_JavaLangString);
      localItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
      localObject = (RelativeLayout.LayoutParams)localItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
      localLayoutParams = (RelativeLayout.LayoutParams)localItemViewHolder.b.getLayoutParams();
      if (!localMsgItemEntity.jdField_a_of_type_Boolean) {
        break label456;
      }
      localItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      localItemViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (paramInt != 0) {
        break label436;
      }
      i = ViewUtils.a(3.0F);
      label301:
      ((RelativeLayout.LayoutParams)localObject).topMargin = i;
      if (paramInt != 0) {
        break label446;
      }
      i = ViewUtils.a(3.0F);
    }
    label319:
    for (localLayoutParams.topMargin = i;; localLayoutParams.topMargin = 0)
    {
      localItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localItemViewHolder.b.setLayoutParams(localLayoutParams);
      localItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(Integer.valueOf(paramInt));
      localItemViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramView.setContentDescription(localMsgItemEntity.jdField_a_of_type_JavaLangCharSequence + " " + localMsgItemEntity.a());
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localItemViewHolder = (TroopMemberHistoryFragment.ItemViewHolder)paramView.getTag();
      break;
      i = ViewUtils.a(9.0F);
      break label301;
      i = ViewUtils.a(9.0F);
      break label319;
      label456:
      localItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      localItemViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.TroopMemberChatHisListAdapter
 * JD-Core Version:    0.7.0.1
 */