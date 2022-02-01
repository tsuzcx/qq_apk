package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloActionRecentData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloMainInfo;
import com.tencent.mobileqq.apollo.utils.ApolloRecentManager;
import com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout;
import com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout.ViewHolder;
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
    switch (this.b)
    {
    case 1: 
    default: 
      return new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.c, this.f, this.jdField_a_of_type_Int);
    case 0: 
      return new ApolloLinearLayout(this.jdField_a_of_type_AndroidContentContext, null, this.c, this.f, this.jdField_a_of_type_Int);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558714, null);
  }
  
  public void a(View paramView, int paramInt)
  {
    for (;;)
    {
      int j;
      int i;
      int k;
      try
      {
        Object localObject;
        ApolloLinearLayout.ViewHolder localViewHolder;
        int i1;
        if (this.b == 0)
        {
          int m = this.f;
          int n = this.jdField_a_of_type_Int;
          j = 0;
          i = 0;
          if (j < this.jdField_a_of_type_Int)
          {
            LinearLayout localLinearLayout = (LinearLayout)((ApolloLinearLayout)paramView).getChildAt(j);
            k = 0;
            if (k >= this.f) {
              break label266;
            }
            localObject = localLinearLayout.getChildAt(k);
            localViewHolder = (ApolloLinearLayout.ViewHolder)((View)localObject).getTag();
            i1 = m * n * paramInt + i;
            List localList = this.jdField_a_of_type_JavaUtilList;
            if (localList != null) {
              continue;
            }
          }
        }
        return;
        if (i1 < this.jdField_a_of_type_JavaUtilList.size())
        {
          localObject = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).mAction;
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(i1)).getPanelDrawable(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density));
          if ((localObject != null) && (((ApolloActionData)localObject).actionName != null)) {
            localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(((ApolloActionData)localObject).actionName);
          }
          localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo = ((ApolloInfo)this.jdField_a_of_type_JavaUtilList.get(i1));
          localViewHolder.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mBinderType = 1;
        }
        else
        {
          ((View)localObject).setContentDescription(null);
          ((View)localObject).setOnClickListener(null);
        }
      }
      finally {}
      label266:
      j += 1;
      continue;
      k += 1;
      i += 1;
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    boolean bool;
    if (paramQQAppInterface == null) {
      bool = false;
    }
    Object localObject1;
    label54:
    int i;
    for (;;)
    {
      return bool;
      try
      {
        localObject1 = (ApolloRecentManager)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_RECENTMANAGER);
        if (localObject1 == null)
        {
          bool = false;
        }
        else
        {
          if (CmShowAioMatcher.a(paramSessionInfo.jdField_a_of_type_Int, 1)) {}
          for (paramSessionInfo = ((ApolloRecentManager)localObject1).jdField_a_of_type_JavaUtilList;; paramSessionInfo = ((ApolloRecentManager)localObject1).b)
          {
            if (paramSessionInfo == null) {
              break label248;
            }
            if (paramSessionInfo.size() != 0) {
              break;
            }
            break label248;
            if (!CmShowAioMatcher.a(paramSessionInfo.jdField_a_of_type_Int, 2)) {
              break label243;
            }
          }
          if (this.jdField_a_of_type_JavaUtilList != null) {
            this.jdField_a_of_type_JavaUtilList.clear();
          }
          for (;;)
          {
            i = paramSessionInfo.size() - 1;
            break;
            this.jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          localObject1 = new ApolloActionData();
        }
      }
      finally {}
    }
    label137:
    Object localObject2 = (ApolloDaoManagerServiceImpl)paramQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    if (localObject2 != null)
    {
      localObject2 = ((ApolloDaoManagerServiceImpl)localObject2).findActionById(((ApolloActionRecentData)paramSessionInfo.get(i)).actionId);
      localObject1 = localObject2;
      if (localObject2 == null) {}
    }
    for (;;)
    {
      localObject2 = new ApolloMainInfo(paramQQAppInterface.getCurrentUin());
      ((ApolloMainInfo)localObject2).mAction = ((ApolloActionData)localObject1);
      ((ApolloMainInfo)localObject2).mBinderType = 1;
      this.jdField_a_of_type_JavaUtilList.add(localObject2);
      label273:
      for (;;)
      {
        bool = true;
        break;
        label243:
        paramSessionInfo = null;
        break label54;
        label248:
        bool = false;
        break;
        for (;;)
        {
          if (i < 0) {
            break label273;
          }
          if (paramQQAppInterface != null) {
            break label137;
          }
          bool = false;
          break;
          i -= 1;
        }
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloRecentViewBinder
 * JD-Core Version:    0.7.0.1
 */