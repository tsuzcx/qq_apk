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
  private List<TroopMemberHistoryFragment.MsgItemEntity> b = new LinkedList();
  private Context c;
  
  TroopMemberHistoryFragment$TroopMemberChatHisListAdapter(TroopMemberHistoryFragment paramTroopMemberHistoryFragment, Context paramContext)
  {
    this.c = paramContext;
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
      l2 = localMsgItemEntity.b;
      if ((l1 == 0L) || (!a(l1, l2))) {
        localMsgItemEntity.g = true;
      }
      this.b.add(localMsgItemEntity);
      i += 1;
    }
    return true;
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.c, 2131625303, null);
      localObject1 = new TroopMemberHistoryFragment.ItemViewHolder();
      ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).b = ((ColorNickTextView)paramView.findViewById(2131447063));
      ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).c = ((TextView)paramView.findViewById(2131447065));
      ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).a = ((ImageView)paramView.findViewById(2131435219));
      ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).d = ((TextView)paramView.findViewById(2131436844));
      ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).e = paramView.findViewById(2131437286);
      ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).f = ((RelativeLayout)paramView.findViewById(2131448020));
      paramView.setTag(localObject1);
    }
    else
    {
      localObject1 = (TroopMemberHistoryFragment.ItemViewHolder)paramView.getTag();
    }
    TroopMemberHistoryFragment.MsgItemEntity localMsgItemEntity = (TroopMemberHistoryFragment.MsgItemEntity)getItem(paramInt);
    ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).c.setText(localMsgItemEntity.c);
    ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).d.setText(localMsgItemEntity.a());
    Object localObject2 = new ColorNickText(ContactUtils.b(this.a.n, this.a.d, localMsgItemEntity.a), 16).b();
    ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).b.setText((CharSequence)localObject2);
    ColorNickManager.a(this.a.n, ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).b, (Spannable)localObject2);
    localObject2 = FaceDrawable.getFaceDrawable(this.a.n, 1, localMsgItemEntity.a);
    ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).a.setImageDrawable((Drawable)localObject2);
    localObject2 = (RelativeLayout.LayoutParams)((TroopMemberHistoryFragment.ItemViewHolder)localObject1).a.getLayoutParams();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((TroopMemberHistoryFragment.ItemViewHolder)localObject1).d.getLayoutParams();
    if (localMsgItemEntity.g)
    {
      ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).a.setVisibility(0);
      ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).e.setVisibility(0);
      int i;
      if (paramInt == 0) {
        i = ViewUtils.dip2px(3.0F);
      } else {
        i = ViewUtils.dip2px(9.0F);
      }
      ((RelativeLayout.LayoutParams)localObject2).topMargin = i;
      if (paramInt == 0) {
        i = ViewUtils.dip2px(3.0F);
      } else {
        i = ViewUtils.dip2px(9.0F);
      }
      localLayoutParams.topMargin = i;
    }
    else
    {
      ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).a.setVisibility(4);
      ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).e.setVisibility(8);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
      localLayoutParams.topMargin = 0;
    }
    ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).a.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).d.setLayoutParams(localLayoutParams);
    ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).f.setTag(Integer.valueOf(paramInt));
    ((TroopMemberHistoryFragment.ItemViewHolder)localObject1).f.setOnClickListener(this.a.q);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(localMsgItemEntity.c);
    ((StringBuilder)localObject1).append(" ");
    ((StringBuilder)localObject1).append(localMsgItemEntity.a());
    paramView.setContentDescription(((StringBuilder)localObject1).toString());
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment.TroopMemberChatHisListAdapter
 * JD-Core Version:    0.7.0.1
 */