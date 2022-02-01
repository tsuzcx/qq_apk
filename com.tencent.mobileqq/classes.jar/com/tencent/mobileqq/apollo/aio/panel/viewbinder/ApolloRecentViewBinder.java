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
  
  public View a()
  {
    int i = this.k;
    if (i != 0)
    {
      if (i != 2) {
        return new ApolloLinearLayout(this.i, null, this.l, this.q, this.a);
      }
      return LayoutInflater.from(this.i).inflate(2131624177, null);
    }
    return new ApolloLinearLayout(this.i, null, this.l, this.q, this.a);
  }
  
  public void a(View paramView, int paramInt)
  {
    try
    {
      int i = this.k;
      if (i != 0) {
        return;
      }
      Object localObject1 = this.o;
      if (localObject1 == null) {
        return;
      }
      int m = this.q;
      int n = this.a;
      int j = 0;
      i = 0;
      while (j < this.a)
      {
        localObject1 = (LinearLayout)((ApolloLinearLayout)paramView).getChildAt(j);
        int k = 0;
        while (k < this.q)
        {
          Object localObject2 = ((LinearLayout)localObject1).getChildAt(k);
          ApolloLinearLayout.ViewHolder localViewHolder = (ApolloLinearLayout.ViewHolder)((View)localObject2).getTag();
          int i1 = m * n * paramInt + i;
          if (i1 >= this.o.size())
          {
            ((View)localObject2).setContentDescription(null);
            ((View)localObject2).setOnClickListener(null);
            return;
          }
          localObject2 = ((ApolloInfo)this.o.get(i1)).mAction;
          localViewHolder.b.setVisibility(0);
          localViewHolder.b.setBackgroundDrawable(((ApolloInfo)this.o.get(i1)).getPanelDrawable(this.i, this.i.getResources().getDisplayMetrics().density));
          if ((localObject2 != null) && (((ApolloActionData)localObject2).actionName != null)) {
            localViewHolder.c.setText(((ApolloActionData)localObject2).actionName);
          }
          localViewHolder.j = ((ApolloInfo)this.o.get(i1));
          localViewHolder.j.mBinderType = 1;
          i += 1;
          k += 1;
        }
        j += 1;
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
      if (CmShowAioMatcherImpl.judgeSupported(paramSessionInfo.a, 1)) {
        localList = ((ApolloRecentManager)localObject).a;
      } else if (CmShowAioMatcherImpl.judgeSupported(paramSessionInfo.a, 2)) {
        localList = ((ApolloRecentManager)localObject).b;
      }
      if ((localList != null) && (localList.size() != 0))
      {
        if (this.o != null) {
          this.o.clear();
        } else {
          this.o = new ArrayList();
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
            this.o.add(localObject);
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
    this.i = null;
  }
  
  public int c()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloRecentViewBinder
 * JD-Core Version:    0.7.0.1
 */