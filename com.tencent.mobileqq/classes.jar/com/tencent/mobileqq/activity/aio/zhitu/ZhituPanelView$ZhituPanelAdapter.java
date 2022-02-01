package com.tencent.mobileqq.activity.aio.zhitu;

import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ZhituPanelView$ZhituPanelAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  public int a;
  public View a;
  public String a;
  public List<ZhituPicData> a;
  public boolean a;
  public List<ZhituPicData> b = new ArrayList();
  
  public ZhituPanelView$ZhituPanelAdapter(ZhituPanelView paramZhituPanelView)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    int i = 0;
    while (i < ZhituPanelView.jdField_a_of_type_Int)
    {
      this.b.add(new ZhituPicData());
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(this.b);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ZhituPanelView.b(), 2, "loadMorePic");
    }
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if ((i == 0) || (TextUtils.isEmpty(((ZhituPicData)this.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_d_of_type_JavaLangString))) {}
    while (i <= this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = i;
    ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a).a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(int paramInt, String paramString)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("ZhituManager", 2, "ZhituPicAdapter setPicItemCount: picCount = " + paramInt + ",mReqKey = " + paramString + ",this.mReqKey =" + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (paramInt > 0)
    {
      if (!paramString.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a, "dc00898", "", "", "0X8008C71", "0X8008C71", ZhituManager.a(ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a).a()), 0, "", "", "", "");
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      while (i < paramInt)
      {
        this.jdField_a_of_type_JavaUtilList.add(new ZhituPicData());
        i += 1;
      }
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_Boolean = true;
      notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    notifyItemInserted(0);
  }
  
  public void a(ZhituPicData paramZhituPicData)
  {
    int i;
    ZhituPicData localZhituPicData;
    if (paramZhituPicData != null)
    {
      i = paramZhituPicData.jdField_a_of_type_Int;
      if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
      {
        localZhituPicData = (ZhituPicData)this.jdField_a_of_type_JavaUtilList.get(i);
        localZhituPicData.a(paramZhituPicData);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() != 1) {
          break label98;
        }
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() != 1) && (i == 0))
      {
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).setEnabled(true);
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).setVisibility(0);
      }
      return;
      label98:
      if (localZhituPicData.jdField_d_of_type_Boolean)
      {
        if ((ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) != null) && (ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) != localZhituPicData)) {
          ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).jdField_d_of_type_Boolean = false;
        }
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, localZhituPicData);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ZhituPanelView.b(), 2, "[ZhituPicAdapter]-setEmptyAndShowMsg, errorMsg is " + paramString);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131382140);
      if (localTextView != null)
      {
        this.jdField_a_of_type_Boolean = false;
        localTextView.setVisibility(0);
        localTextView.setText(paramString);
        paramString = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        paramString.height = -1;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramString);
      }
    }
    notifyDataSetChanged();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(ZhituPanelView.b(), 2, "[ZhituPicAdapter]-resetData");
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      Object localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131382140);
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(8);
        localObject = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = -2;
        this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
    this.jdField_a_of_type_JavaUtilList.addAll(this.b);
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
    notifyDataSetChanged();
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int j = 0;; j = this.jdField_a_of_type_JavaUtilList.size())
    {
      int i = j;
      if (this.jdField_a_of_type_Boolean) {
        i = j + 1;
      }
      j = i;
      if (this.jdField_a_of_type_AndroidViewView != null) {
        j = i + 1;
      }
      return j;
    }
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (paramInt == 0)) {
      return 3;
    }
    if ((this.jdField_a_of_type_Boolean) && (paramInt + 1 == getItemCount())) {
      return 2;
    }
    return 1;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new ZhituPanelView.ZhituPanelAdapter.1(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (getItemViewType(paramInt) == 3) {}
    while (!(paramViewHolder instanceof ZhituPanelView.ZhituViewHolder))
    {
      EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
      return;
    }
    int i;
    label39:
    ZhituPanelView.ZhituViewHolder localZhituViewHolder;
    ZhituPicData localZhituPicData;
    Object localObject3;
    Object localObject1;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      i = paramInt;
      localZhituViewHolder = (ZhituPanelView.ZhituViewHolder)paramViewHolder;
      localZhituPicData = (ZhituPicData)this.jdField_a_of_type_JavaUtilList.get(i);
      localZhituViewHolder.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localZhituPicData);
      localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localZhituViewHolder.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(localZhituPicData.jdField_d_of_type_Boolean);
      if (!localZhituPicData.jdField_a_of_type_Boolean) {
        break label707;
      }
      localObject3 = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a).b(localZhituPicData);
      localObject1 = ZhituManager.a((String)localObject3);
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a).c(localZhituPicData);
        localObject2 = localObject1;
        if (QLog.isColorLevel()) {
          QLog.d(ZhituPanelView.b(), 2, "get gif image from cache fail, " + (String)localObject3);
        }
      }
    }
    label701:
    label704:
    label707:
    for (Object localObject2 = localObject1;; localObject2 = null)
    {
      localZhituViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() == 1) {
        if ((localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (localObject2 != null))
        {
          QLog.d(ZhituPanelView.b(), 2, "ZhituTest has a drawable data is " + localZhituPicData.toString());
          localObject1 = localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(localZhituPicData.jdField_a_of_type_JavaLangString + localZhituPicData.jdField_e_of_type_JavaLangString);
          if (localObject2 == null) {
            break label704;
          }
          localObject1 = new GifDrawable(localObject2);
        }
      }
      for (;;)
      {
        localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject1);
        localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
        localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        for (;;)
        {
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView);
          if ((localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData == null) || (localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData.jdField_a_of_type_Boolean)) {
            break;
          }
          ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a).b(localZhituPicData);
          localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData.jdField_a_of_type_Boolean = true;
          break;
          i = paramInt - 1;
          break label39;
          QLog.d(ZhituPanelView.b(), 2, "ZhituTest has no drawable data is " + localZhituPicData.toString());
          localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView));
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
        }
        if ((localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (localObject2 != null))
        {
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setMinimumWidth(0);
          localObject3 = localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(localZhituPicData.jdField_a_of_type_JavaLangString + localZhituPicData.jdField_e_of_type_JavaLangString);
          localObject1 = localObject3;
          if (!localZhituPicData.jdField_d_of_type_Boolean)
          {
            localObject1 = localObject3;
            if (!localZhituPicData.jdField_e_of_type_Boolean)
            {
              localObject1 = localObject3;
              if (localZhituPicData.b != null) {
                localObject1 = localZhituPicData.b;
              }
            }
          }
          if (localObject2 == null) {
            break label701;
          }
          localObject1 = new GifDrawable(localObject2);
        }
        for (;;)
        {
          localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject1);
          localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(0);
          break;
          localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView));
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
          break;
        }
      }
    }
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getContext()).inflate(2131563265, paramViewGroup, false);
      return new ZhituPanelView.ZhituViewHolder(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramViewGroup);
    case 2: 
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getContext()).inflate(2131563264, paramViewGroup, false);
      return new ZhituPanelView.LoadFootViewHolder(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramViewGroup);
    }
    return new ZhituPanelView.LoadFootViewHolder(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, this.jdField_a_of_type_AndroidViewView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.ZhituPanelAdapter
 * JD-Core Version:    0.7.0.1
 */