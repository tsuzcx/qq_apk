package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.StateSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadInJoyNavigationAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public final int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ReadInJoyNavigationAdapter.ChannelButtonListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter$ChannelButtonListener;
  private List<ChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  public int b = -13879999;
  public int c = -723466;
  
  public ReadInJoyNavigationAdapter(Context paramContext)
  {
    this.jdField_a_of_type_Int = -9387998;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private List<ChannelCoverInfo> a(List<ChannelCoverInfo> paramList)
  {
    Object localObject = paramList;
    if (paramList != null)
    {
      localObject = paramList;
      if (paramList.size() > 28) {
        localObject = paramList.subList(0, 28);
      }
    }
    return localObject;
  }
  
  private void a(View paramView, int paramInt)
  {
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    localGradientDrawable1.setShape(0);
    localGradientDrawable1.setCornerRadius(ViewUtils.a(17.0F));
    localGradientDrawable1.setColor(-723466);
    localGradientDrawable1.setStroke(1, paramInt);
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    localGradientDrawable2.setShape(0);
    localGradientDrawable2.setCornerRadius(ViewUtils.a(17.0F));
    localGradientDrawable2.setColor(-2697514);
    localGradientDrawable2.setStroke(1, paramInt);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
    localStateListDrawable.addState(StateSet.WILD_CARD, localGradientDrawable1);
    paramView.setBackgroundDrawable(localStateListDrawable);
  }
  
  public void a(ReadInJoyNavigationAdapter.ChannelButtonListener paramChannelButtonListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter$ChannelButtonListener = paramChannelButtonListener;
  }
  
  public void a(List<ChannelCoverInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(a(paramList));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNavigationAdapter", 2, new Object[] { "mChannels size: ", Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) });
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
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
    View localView;
    Object localObject;
    int i;
    if (paramView == null)
    {
      paramView = new ReadInJoyNavigationAdapter.ViewHolder(this, null);
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560354, paramViewGroup, false);
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131365255);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131378870));
      localView.setTag(paramView);
      localObject = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localObject != null)
      {
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((ChannelCoverInfo)localObject).mChannelCoverName);
        int j = 5;
        i = 12;
        if (DeviceInfoUtil.m() < 1080L)
        {
          j = 4;
          i = 11;
        }
        if (paramView.jdField_a_of_type_AndroidWidgetTextView.length() < j) {
          break label306;
        }
      }
    }
    for (;;)
    {
      float f = FontSettingManager.getFontLevel() / 16.0F;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextSize(i / f);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setTextColor(((ChannelCoverInfo)localObject).mFontColor);
      a(paramView.jdField_a_of_type_AndroidViewView, this.c);
      if (!TextUtils.isEmpty(((ChannelCoverInfo)localObject).mIconUrl)) {}
      for (;;)
      {
        if (!((ChannelCoverInfo)localObject).isReport)
        {
          ((ChannelCoverInfo)localObject).isReport = true;
          ChannelCoverView.a("0X8007F01", (ChannelCoverInfo)localObject, ChannelCoverView.b);
        }
        paramView.jdField_a_of_type_AndroidViewView.setTag(localObject);
        paramView.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        localObject = (ReadInJoyNavigationAdapter.ViewHolder)paramView.getTag();
        localView = paramView;
        paramView = (View)localObject;
        break;
        paramView.jdField_a_of_type_AndroidViewView.setPadding(ViewUtils.a(8.0F), 0, ViewUtils.a(8.0F), 0);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
      }
      label306:
      i = 14;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNavigationAdapter", 2, "click container");
    }
    ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramView.getTag();
    Object localObject;
    if (localChannelCoverInfo != null)
    {
      if (!TextUtils.isEmpty(localChannelCoverInfo.mChannelJumpUrl)) {
        break label261;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("param_key_ariticle_id", Long.valueOf(localChannelCoverInfo.mArticleId));
      ((HashMap)localObject).put("param_key_channel_cover_style", Integer.valueOf(localChannelCoverInfo.mChannelCoverStyle));
      ReadInJoyActivityHelper.a(this.jdField_a_of_type_AndroidContentContext, localChannelCoverInfo.mChannelCoverId, localChannelCoverInfo.mChannelCoverName, localChannelCoverInfo.mChannelType, 4, (Map)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNavigationAdapter", 2, "launchChannelActivity info.mArticleId:" + localChannelCoverInfo.mArticleId + " info.mChannelCoverStyle: " + localChannelCoverInfo.mChannelCoverStyle + " info.mChannelCoverId:" + localChannelCoverInfo.mChannelCoverId + " info.mChannelCoverName:" + localChannelCoverInfo.mChannelCoverName + " info.mChannelType: " + localChannelCoverInfo.mChannelType);
      }
    }
    label261:
    label360:
    for (;;)
    {
      ChannelCoverView.a("0X8007F02", localChannelCoverInfo, ChannelCoverView.b);
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter$ChannelButtonListener == null) || (!(paramView.getTag() instanceof ChannelCoverInfo))) {
        break;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyNavigationAdapter$ChannelButtonListener.a((ChannelCoverInfo)paramView.getTag());
      break;
      if (ViolaAccessHelper.b(localChannelCoverInfo.mChannelJumpUrl)) {
        ViolaAccessHelper.a(this.jdField_a_of_type_AndroidContentContext, "", localChannelCoverInfo.mChannelJumpUrl, null);
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label360;
        }
        QLog.d("ReadInJoyNavigationAdapter", 2, "info.mChannelJumpUrl:" + localChannelCoverInfo.mChannelJumpUrl);
        break;
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", localChannelCoverInfo.mChannelJumpUrl);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationAdapter
 * JD-Core Version:    0.7.0.1
 */