package com.tencent.mobileqq.apollo.view.pannel;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloViewBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ApolloPanelAdapter
  extends PagerAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  public BaseChatPie a;
  private List<ApolloViewBinder> jdField_a_of_type_JavaUtilList;
  
  public ApolloPanelAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public void a(List<ApolloViewBinder> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if ((paramObject == null) || (paramViewGroup == null)) {
      return;
    }
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanelAdapter", 2, "instantiateItem position = " + paramInt);
    }
    ApolloViewBinder localApolloViewBinder = null;
    Object localObject = localApolloViewBinder;
    if (paramInt >= 0)
    {
      localObject = localApolloViewBinder;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        localApolloViewBinder = (ApolloViewBinder)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localObject = localApolloViewBinder.c();
        localApolloViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      }
    }
    if ((localObject != null) && (((View)localObject).getParent() != paramViewGroup) && (paramInt < getCount())) {
      paramViewGroup.addView((View)localObject);
    }
    return localObject;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanelAdapter
 * JD-Core Version:    0.7.0.1
 */