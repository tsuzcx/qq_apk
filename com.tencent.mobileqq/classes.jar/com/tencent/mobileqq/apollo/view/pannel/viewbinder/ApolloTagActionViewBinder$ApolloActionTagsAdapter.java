package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloTagButtonData;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.List;

class ApolloTagActionViewBinder$ApolloActionTagsAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ApolloTagButtonData jdField_a_of_type_ComTencentMobileqqDataApolloTagButtonData = new ApolloTagButtonData(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloTagActionViewBinder.a, false);
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private List<ApolloTagButtonData> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  
  public ApolloTagActionViewBinder$ApolloActionTagsAdapter(Context paramContext, List<ApolloTagButtonData> paramList, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramList;
    this.jdField_a_of_type_JavaUtilList = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramBoolean;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramList.getSystemService("layout_inflater"));
    this.jdField_a_of_type_JavaUtilList.add(0, this.jdField_a_of_type_ComTencentMobileqqDataApolloTagButtonData);
    boolean bool;
    this.jdField_a_of_type_Boolean = bool;
  }
  
  private HashMap<String, String> a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      ApolloDtReportUtil.DtReportParamsBuilder localDtReportParamsBuilder = new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)).b(ApolloDtReportUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a));
      if (this.jdField_a_of_type_Boolean) {}
      for (int i = 1;; i = 0) {
        return localDtReportParamsBuilder.c(i).a(paramString).a();
      }
    }
    return null;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ApolloDtReportUtil.a("aio", "tagpage", "tagexpose", this.jdField_a_of_type_JavaUtilHashMap);
      ApolloDtReportUtil.a("aio", "tagpage", "tagclick", this.jdField_a_of_type_JavaUtilHashMap);
      return;
    }
    ApolloDtReportUtil.a("aio", "tagpage", "qxtagclick", this.jdField_a_of_type_JavaUtilHashMap);
  }
  
  public Drawable a(int paramInt1, int paramInt2)
  {
    if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
      return ViewUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165887), ViewUtils.a(paramInt2));
    }
    return ViewUtils.a(paramInt1, ViewUtils.a(paramInt2));
  }
  
  public ApolloTagButtonData a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (ApolloTagButtonData)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558716, paramViewGroup, false);
    }
    for (;;)
    {
      Button localButton = (Button)paramView.findViewById(2131364161);
      Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838560);
      localDrawable.setBounds(0, 0, localDrawable.getMinimumWidth(), localDrawable.getMinimumHeight());
      int i = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167338);
      int j = this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166980);
      localButton.setCompoundDrawables(null, null, null, null);
      localButton.setText(((ApolloTagButtonData)this.jdField_a_of_type_JavaUtilList.get(paramInt)).tag);
      localButton.setContentDescription(((ApolloTagButtonData)this.jdField_a_of_type_JavaUtilList.get(paramInt)).tag);
      localButton.setBackgroundDrawable(a(i, 14));
      if (ThemeUtil.isNowThemeIsNight(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null)) {
        localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131165888));
      }
      for (;;)
      {
        localButton.setOnClickListener(new ApolloTagActionViewBinder.ApolloActionTagsAdapter.1(this, localButton, paramInt));
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
        if (((ApolloTagButtonData)this.jdField_a_of_type_JavaUtilList.get(paramInt)).isSelected)
        {
          localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166981));
          localButton.setBackgroundDrawable(a(j, 14));
          localButton.setCompoundDrawables(localDrawable, null, null, null);
        }
        else
        {
          localButton.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167339));
          localButton.setBackgroundDrawable(a(i, 14));
          localButton.setCompoundDrawables(null, null, null, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.ApolloActionTagsAdapter
 * JD-Core Version:    0.7.0.1
 */