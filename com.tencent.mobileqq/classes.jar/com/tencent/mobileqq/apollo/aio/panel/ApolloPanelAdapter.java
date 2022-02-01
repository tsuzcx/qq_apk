package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ApolloPanelAdapter
  extends PagerAdapter
{
  public BaseChatPie a;
  Context b;
  SessionInfo c;
  private List<ApolloViewBinder> d;
  
  public ApolloPanelAdapter(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public void a(SessionInfo paramSessionInfo)
  {
    this.c = paramSessionInfo;
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public void a(List<ApolloViewBinder> paramList)
  {
    this.d = paramList;
    super.notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (paramObject != null)
    {
      if (paramViewGroup == null) {
        return;
      }
      paramViewGroup.removeView((View)paramObject);
    }
  }
  
  public int getCount()
  {
    List localList = this.d;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("instantiateItem position = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("[cmshow]ApolloPanelAdapter", 2, ((StringBuilder)localObject).toString());
    }
    ApolloViewBinder localApolloViewBinder = null;
    Object localObject = localApolloViewBinder;
    if (paramInt >= 0)
    {
      localObject = localApolloViewBinder;
      if (paramInt < this.d.size())
      {
        localApolloViewBinder = (ApolloViewBinder)this.d.get(paramInt);
        localObject = localApolloViewBinder.i();
        localApolloViewBinder.a(this.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelAdapter
 * JD-Core Version:    0.7.0.1
 */