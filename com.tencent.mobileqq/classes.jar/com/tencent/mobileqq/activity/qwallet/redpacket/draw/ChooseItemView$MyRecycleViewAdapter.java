package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class ChooseItemView$MyRecycleViewAdapter
  extends RecyclerView.Adapter<ChooseItemView.MyHolder>
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ChooseItemView.ItemInfo jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView$ItemInfo;
  private String jdField_a_of_type_JavaLangString;
  private List<List<ChooseItemView.ItemInfo>> jdField_a_of_type_JavaUtilList;
  
  ChooseItemView$MyRecycleViewAdapter(@NonNull List<List<ChooseItemView.ItemInfo>> paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private View a(Context paramContext)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setTextSize(1, 13.0F);
    localTextView.setGravity(16);
    int i = DisplayUtil.a(paramContext, 13.0F);
    localTextView.setPadding(i, 0, i, 0);
    localTextView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    QWalletTools.a(localTextView, 0.6F);
    localTextView.setLayoutParams(new RelativeLayout.LayoutParams(-2, DisplayUtil.a(paramContext, 30.0F)));
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    Object localObject = new LinearLayout.LayoutParams(-2, DisplayUtil.a(paramContext, 30.0F));
    ((LinearLayout.LayoutParams)localObject).leftMargin = DisplayUtil.a(paramContext, 12.0F);
    localRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localRelativeLayout.addView(localTextView);
    localTextView.setId(2131375373);
    localObject = new View(paramContext);
    ((View)localObject).setBackgroundResource(2130847718);
    ((View)localObject).setVisibility(8);
    localRelativeLayout.addView((View)localObject);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
    localLayoutParams.width = DisplayUtil.a(paramContext, 9.2F);
    localLayoutParams.height = DisplayUtil.a(paramContext, 8.9F);
    localLayoutParams.addRule(7, 2131375373);
    localLayoutParams.addRule(6, 2131375373);
    localRelativeLayout.setTag(2131375269, localTextView);
    localRelativeLayout.setTag(2131375270, localObject);
    return localRelativeLayout;
  }
  
  private void a(View paramView, ChooseItemView.ItemInfo paramItemInfo)
  {
    TextView localTextView = (TextView)paramView.getTag(2131375269);
    paramView = (View)paramView.getTag(2131375270);
    localTextView.setText(paramItemInfo.jdField_a_of_type_JavaLangString);
    int i;
    if (paramItemInfo.jdField_a_of_type_Boolean)
    {
      i = 0;
      paramView.setVisibility(i);
      if ((!paramItemInfo.b) && ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equals(paramItemInfo.jdField_a_of_type_JavaLangString)))) {
        break label108;
      }
      localTextView.setTextColor(-1);
      localTextView.setBackgroundResource(2130847655);
      this.jdField_a_of_type_JavaLangString = "";
    }
    for (;;)
    {
      localTextView.setTag(2131375272, paramItemInfo);
      return;
      i = 4;
      break;
      label108:
      localTextView.setTextColor(-16578534);
      localTextView.setBackgroundResource(2130847654);
    }
  }
  
  public ChooseItemView.MyHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramViewGroup.getContext());
    localLinearLayout.setOrientation(0);
    localLinearLayout.setGravity(16);
    paramInt = DisplayUtil.a(paramViewGroup.getContext(), 6.0F);
    localLinearLayout.setPadding(0, paramInt, 0, paramInt);
    return new ChooseItemView.MyHolder(localLinearLayout);
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView$ItemInfo != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView$ItemInfo.b = false;
    }
    paramView = (ChooseItemView.ItemInfo)paramView.getTag(2131375272);
    paramView.b = true;
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView$ItemInfo = paramView;
    notifyDataSetChanged();
  }
  
  public void a(ChooseItemView.MyHolder paramMyHolder, int paramInt)
  {
    List localList = (List)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    LinearLayout localLinearLayout = paramMyHolder.a;
    while (localLinearLayout.getChildCount() < localList.size()) {
      localLinearLayout.addView(a(localLinearLayout.getContext()));
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (i >= localList.size()) {
        break;
      }
      ChooseItemView.ItemInfo localItemInfo = (ChooseItemView.ItemInfo)localList.get(i);
      View localView = localLinearLayout.getChildAt(i);
      a(localView, localItemInfo);
      localView.setVisibility(0);
      i += 1;
    }
    while (j < localLinearLayout.getChildCount())
    {
      localLinearLayout.getChildAt(j).setVisibility(8);
      j += 1;
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramMyHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
  
  public void a(@NonNull List<List<ChooseItemView.ItemInfo>> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView$ItemInfo != null)
    {
      paramList = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramList.hasNext())
      {
        Iterator localIterator = ((List)paramList.next()).iterator();
        while (localIterator.hasNext())
        {
          ChooseItemView.ItemInfo localItemInfo = (ChooseItemView.ItemInfo)localIterator.next();
          if (TextUtils.equals(localItemInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView$ItemInfo.jdField_a_of_type_JavaLangString))
          {
            localItemInfo.b = true;
            this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawChooseItemView$ItemInfo = localItemInfo;
          }
        }
      }
    }
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.ChooseItemView.MyRecycleViewAdapter
 * JD-Core Version:    0.7.0.1
 */