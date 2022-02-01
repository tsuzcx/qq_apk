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
import com.tencent.image.AbstractGifImage;
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
    if (i != 0)
    {
      if (TextUtils.isEmpty(((ZhituPicData)this.jdField_a_of_type_JavaUtilList.get(i - 1)).jdField_d_of_type_JavaLangString)) {
        return;
      }
      if (i > this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Int = i;
        ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a).a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaLangString);
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ZhituPicAdapter setPicItemCount: picCount = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",mReqKey = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",this.mReqKey =");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.i("ZhituManager", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    int i = 0;
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
    if (paramZhituPicData != null)
    {
      int i = paramZhituPicData.jdField_a_of_type_Int;
      if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size()))
      {
        ZhituPicData localZhituPicData = (ZhituPicData)this.jdField_a_of_type_JavaUtilList.get(i);
        localZhituPicData.a(paramZhituPicData);
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() != 1) && (localZhituPicData.jdField_d_of_type_Boolean))
        {
          if ((ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) != null) && (ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView) != localZhituPicData)) {
            ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).jdField_d_of_type_Boolean = false;
          }
          ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, localZhituPicData);
        }
      }
      notifyDataSetChanged();
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() != 1) && (i == 0))
      {
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).setEnabled(true);
        ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView).setVisibility(0);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = ZhituPanelView.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[ZhituPicAdapter]-setEmptyAndShowMsg, errorMsg is ");
      localStringBuilder.append(paramString);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131381344);
      if (localObject != null)
      {
        this.jdField_a_of_type_Boolean = false;
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(paramString);
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
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (TextView)((View)localObject).findViewById(2131381344);
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
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      j = 0;
    } else {
      j = localList.size();
    }
    int i = j;
    if (this.jdField_a_of_type_Boolean) {
      i = j + 1;
    }
    int j = i;
    if (this.jdField_a_of_type_AndroidViewView != null) {
      j = i + 1;
    }
    return j;
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
    if ((getItemViewType(paramInt) != 3) && ((paramViewHolder instanceof ZhituPanelView.ZhituViewHolder)))
    {
      int i;
      if (this.jdField_a_of_type_AndroidViewView == null) {
        i = paramInt;
      } else {
        i = paramInt - 1;
      }
      ZhituPanelView.ZhituViewHolder localZhituViewHolder = (ZhituPanelView.ZhituViewHolder)paramViewHolder;
      ZhituPicData localZhituPicData = (ZhituPicData)this.jdField_a_of_type_JavaUtilList.get(i);
      localZhituViewHolder.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localZhituPicData);
      localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      localZhituViewHolder.jdField_a_of_type_AndroidWidgetRadioButton.setChecked(localZhituPicData.jdField_d_of_type_Boolean);
      Object localObject3;
      Object localObject1;
      Object localObject2;
      StringBuilder localStringBuilder;
      if (localZhituPicData.jdField_a_of_type_Boolean)
      {
        localObject3 = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a).b(localZhituPicData);
        localObject1 = ZhituManager.a((String)localObject3);
        localObject2 = localObject1;
        if (localObject1 == null)
        {
          ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a).c(localZhituPicData);
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            localObject2 = ZhituPanelView.b();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("get gif image from cache fail, ");
            localStringBuilder.append((String)localObject3);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
            localObject2 = localObject1;
          }
        }
      }
      else
      {
        localObject2 = null;
      }
      localZhituViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.a() == 1)
      {
        if ((localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (localObject2 == null))
        {
          localObject1 = ZhituPanelView.b();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("ZhituTest has no drawable data is ");
          ((StringBuilder)localObject2).append(localZhituPicData.toString());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView));
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
        }
        else
        {
          localObject1 = ZhituPanelView.b();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("ZhituTest has a drawable data is ");
          ((StringBuilder)localObject3).append(localZhituPicData.toString());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          localObject1 = localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
          localObject3 = localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localZhituPicData.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(localZhituPicData.jdField_e_of_type_JavaLangString);
          ((BubbleImageView)localObject3).setTag(localStringBuilder.toString());
          if (localObject2 != null) {
            localObject1 = new GifDrawable((AbstractGifImage)localObject2);
          }
          localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject1);
          localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
      else if ((localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (localObject2 == null))
      {
        localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView));
        localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        localZhituViewHolder.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(8);
      }
      else
      {
        localZhituViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setMinimumWidth(0);
        localObject3 = localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localObject1 = localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localZhituPicData.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(localZhituPicData.jdField_e_of_type_JavaLangString);
        ((BubbleImageView)localObject1).setTag(localStringBuilder.toString());
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
        if (localObject2 != null) {
          localObject1 = new GifDrawable((AbstractGifImage)localObject2);
        }
        localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject1);
        localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
        localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        localZhituViewHolder.jdField_a_of_type_AndroidWidgetRadioButton.setVisibility(0);
      }
      localZhituViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView);
      if ((localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData != null) && (!localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData.jdField_a_of_type_Boolean))
      {
        ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a).b(localZhituPicData);
        localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData.jdField_a_of_type_Boolean = true;
      }
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramViewHolder, paramInt, getItemId(paramInt));
  }
  
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return null;
        }
        return new ZhituPanelView.LoadFootViewHolder(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, this.jdField_a_of_type_AndroidViewView);
      }
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getContext()).inflate(2131563088, paramViewGroup, false);
      paramViewGroup = new ZhituPanelView.LoadFootViewHolder(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramViewGroup);
    }
    else
    {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getContext()).inflate(2131563089, paramViewGroup, false);
      paramViewGroup = new ZhituPanelView.ZhituViewHolder(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramViewGroup);
    }
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.ZhituPanelAdapter
 * JD-Core Version:    0.7.0.1
 */