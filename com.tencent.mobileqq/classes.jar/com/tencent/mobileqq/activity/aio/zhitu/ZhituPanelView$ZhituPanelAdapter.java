package com.tencent.mobileqq.activity.aio.zhitu;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.image.GifDrawable;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import wjo;

public class ZhituPanelView$ZhituPanelAdapter
  extends RecyclerView.Adapter
{
  public int a;
  public String a;
  public List a;
  public boolean a;
  public List b = new ArrayList();
  
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
      QLog.d(ZhituPanelView.a(), 2, "loadMorePic");
    }
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (TextUtils.isEmpty(((ZhituPicData)this.jdField_a_of_type_JavaUtilList.get(i - 1)).d)) {}
    while (i <= this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = i;
    ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).a(this.jdField_a_of_type_JavaUtilList.size(), this.jdField_a_of_type_JavaLangString);
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (this.jdField_a_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramInt + 1 == getItemCount())) {
      return 2;
    }
    return 1;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    ((GridLayoutManager)paramRecyclerView.getLayoutManager()).setSpanSizeLookup(new wjo(this));
  }
  
  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    ZhituPanelView.ZhituViewHolder localZhituViewHolder;
    ZhituPicData localZhituPicData;
    Object localObject;
    if ((paramViewHolder instanceof ZhituPanelView.ZhituViewHolder))
    {
      localZhituViewHolder = (ZhituPanelView.ZhituViewHolder)paramViewHolder;
      localZhituPicData = (ZhituPicData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      localZhituViewHolder.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localZhituPicData);
      localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      if (!localZhituPicData.jdField_a_of_type_Boolean) {
        break label363;
      }
      String str = ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).b(localZhituPicData);
      localObject = ZhituManager.a(str);
      paramViewHolder = (RecyclerView.ViewHolder)localObject;
      if (localObject == null)
      {
        ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).c(localZhituPicData);
        paramViewHolder = (RecyclerView.ViewHolder)localObject;
        if (QLog.isColorLevel()) {
          QLog.d(ZhituPanelView.a(), 2, "get gif image from cache fail, " + str);
        }
      }
    }
    label358:
    label363:
    for (paramViewHolder = (RecyclerView.ViewHolder)localObject;; paramViewHolder = null)
    {
      localZhituViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().height = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView);
      if ((localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (paramViewHolder != null))
      {
        localZhituViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setMinimumWidth(0);
        localObject = localZhituPicData.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setTag(localZhituPicData.jdField_a_of_type_JavaLangString + localZhituPicData.e);
        if (paramViewHolder == null) {
          break label358;
        }
      }
      for (paramViewHolder = new GifDrawable(paramViewHolder);; paramViewHolder = (RecyclerView.ViewHolder)localObject)
      {
        localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(paramViewHolder);
        localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setBackgroundDrawable(null);
        localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        for (;;)
        {
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams().width = ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView);
          if ((localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData != null) && (!localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData.jdField_a_of_type_Boolean))
          {
            ZhituManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a).b(localZhituPicData);
            localZhituPicData.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituReportData.jdField_a_of_type_Boolean = true;
          }
          return;
          localZhituViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(ZhituPanelView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView));
          localZhituViewHolder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
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
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getContext()).inflate(2130971778, paramViewGroup, false);
      return new ZhituPanelView.ZhituViewHolder(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramViewGroup);
    }
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView.getContext()).inflate(2130971777, paramViewGroup, false);
    return new ZhituPanelView.LoadFootViewHolder(this.jdField_a_of_type_ComTencentMobileqqActivityAioZhituZhituPanelView, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituPanelView.ZhituPanelAdapter
 * JD-Core Version:    0.7.0.1
 */