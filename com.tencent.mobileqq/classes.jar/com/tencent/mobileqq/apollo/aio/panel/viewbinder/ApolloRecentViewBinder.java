package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.utils.ApolloRecentManager;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.ApolloLinearLayout.ViewHolder;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class ApolloRecentViewBinder
  extends ApolloViewBinder
{
  public int a;
  
  public int a()
  {
    return 1;
  }
  
  public View a()
  {
    int i = this.b;
    if (i != 0)
    {
      if (i != 2) {
        return new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.c, this.f, this.jdField_a_of_type_Int);
      }
      return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558613, null);
    }
    return new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.c, this.f, this.jdField_a_of_type_Int);
  }
  
  public void a(View paramView, int paramInt)
  {
    try
    {
      if (this.b == 0)
      {
        int m = this.f;
        int n = this.jdField_a_of_type_Int;
        int j = 0;
        int i = 0;
        while (j < this.jdField_a_of_type_Int)
        {
          LinearLayout localLinearLayout = (LinearLayout)((ApolloLinearLayout)paramView).getChildAt(j);
          int k = 0;
          while (k < this.f)
          {
            Object localObject = localLinearLayout.getChildAt(k);
            ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)((View)localObject).getTag();
            int i1 = m * n * paramInt + i;
            List localList = this.jdField_a_of_type_JavaUtilList;
            if (localList == null) {
              return;
            }
            if (i1 < this.jdField_a_of_type_JavaUtilList.size())
            {
              localObject = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).mAction;
              localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
              localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).getPanelDrawable(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
              if ((localObject != null) && (((ApolloActionData)localObject).actionName != null)) {
                localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((ApolloActionData)localObject).actionName);
              }
              localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(i1));
              localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo.mBinderType = 1;
            }
            else
            {
              ((View)localObject).setContentDescription(null);
              ((View)localObject).setOnClickListener(null);
            }
            i += 1;
            k += 1;
          }
          j += 1;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramView;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    List localList = null;
    try
    {
      Object localObject = (ApolloRecentManager)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_RECENTMANAGER);
      if (localObject == null) {
        return false;
      }
      if (CmShowAioMatcherImpl.judgeSupported(paramSessionInfo.jdField_a_of_type_Int, 1)) {
        localList = ((ApolloRecentManager)localObject).jdField_a_of_type_JavaUtilList;
      } else if (CmShowAioMatcherImpl.judgeSupported(paramSessionInfo.jdField_a_of_type_Int, 2)) {
        localList = ((ApolloRecentManager)localObject).b;
      }
      if ((localList != null) && (localList.size() != 0))
      {
        if (this.jdField_a_of_type_JavaUtilList != null) {
          this.jdField_a_of_type_JavaUtilList.clear();
        } else {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        int i = localList.size();
        i -= 1;
        while (i >= 0)
        {
          if (paramQQAppInterface == null) {
            return false;
          }
          paramSessionInfo = new ApolloActionData();
          localObject = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
          if (localObject != null)
          {
            localObject = ((ApolloDaoManagerServiceImpl)localObject).findActionById(((ApolloActionRecentData)localList.get(i)).actionId);
            paramSessionInfo = (SessionInfo)localObject;
            if (localObject == null) {}
          }
          else
          {
            localObject = new ApolloMainInfo(paramQQAppInterface.getCurrentUin());
            ((ApolloMainInfo)localObject).mAction = paramSessionInfo;
            ((ApolloMainInfo)localObject).mBinderType = 1;
            this.jdField_a_of_type_JavaUtilList.add(localObject);
          }
          i -= 1;
        }
        return true;
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramQQAppInterface;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloRecentViewBinder
 * JD-Core Version:    0.7.0.1
 */