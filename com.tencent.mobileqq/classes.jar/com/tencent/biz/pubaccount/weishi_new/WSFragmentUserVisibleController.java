package com.tencent.biz.pubaccount.weishi_new;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.Iterator;
import java.util.List;

public class WSFragmentUserVisibleController
{
  private final String a;
  private boolean b;
  private final Fragment c;
  private final WSFragmentUserVisibleController.UserVisibleCallback d;
  private List<WSFragmentUserVisibleController.OnUserVisibleListener> e;
  
  public WSFragmentUserVisibleController(Fragment paramFragment, WSFragmentUserVisibleController.UserVisibleCallback paramUserVisibleCallback)
  {
    this.c = paramFragment;
    this.d = paramUserVisibleCallback;
    this.a = paramFragment.getClass().getSimpleName();
  }
  
  private void a(List<Fragment> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Fragment localFragment = (Fragment)paramList.next();
      if ((localFragment instanceof WSFragmentUserVisibleController.UserVisibleCallback))
      {
        WSFragmentUserVisibleController.UserVisibleCallback localUserVisibleCallback = (WSFragmentUserVisibleController.UserVisibleCallback)localFragment;
        if (localUserVisibleCallback.aW_())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a);
          localStringBuilder.append(": setUserVisibleHint, show child ");
          localStringBuilder.append(localFragment.getClass().getSimpleName());
          WSLog.e("UserVisibleController", localStringBuilder.toString());
          localUserVisibleCallback.c(false);
          localFragment.setUserVisibleHint(true);
        }
      }
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.e;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.e.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((WSFragmentUserVisibleController.OnUserVisibleListener)((Iterator)localObject).next()).a(paramBoolean1, paramBoolean2);
      }
    }
  }
  
  private void b(List<Fragment> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Fragment localFragment = (Fragment)paramList.next();
      if ((localFragment instanceof WSFragmentUserVisibleController.UserVisibleCallback))
      {
        WSFragmentUserVisibleController.UserVisibleCallback localUserVisibleCallback = (WSFragmentUserVisibleController.UserVisibleCallback)localFragment;
        if (localFragment.getUserVisibleHint())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.a);
          localStringBuilder.append(": setUserVisibleHint, hidden child ");
          localStringBuilder.append(localFragment.getClass().getSimpleName());
          WSLog.e("UserVisibleController", localStringBuilder.toString());
          localUserVisibleCallback.c(true);
          localFragment.setUserVisibleHint(false);
        }
      }
    }
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(": activityCreated, userVisibleHint=");
    ((StringBuilder)localObject).append(this.c.getUserVisibleHint());
    WSLog.e("UserVisibleController", ((StringBuilder)localObject).toString());
    if (this.c.getUserVisibleHint())
    {
      localObject = this.c.getParentFragment();
      if ((localObject != null) && (!((Fragment)localObject).getUserVisibleHint()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a);
        localStringBuilder.append(": activityCreated, parent ");
        localStringBuilder.append(localObject.getClass().getSimpleName());
        localStringBuilder.append(" is hidden, therefore hidden self");
        WSLog.e("UserVisibleController", localStringBuilder.toString());
        this.d.c(true);
        this.d.d(false);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramBoolean)
    {
      localObject = this.c.getParentFragment();
      if ((localObject != null) && (!((Fragment)localObject).getUserVisibleHint()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.a);
        localStringBuilder.append(": setUserVisibleHint, parent ");
        localStringBuilder.append(localObject.getClass().getSimpleName());
        localStringBuilder.append(" is hidden, therefore hidden self");
        WSLog.e("UserVisibleController", localStringBuilder.toString());
        this.d.c(true);
        this.d.d(false);
        return;
      }
    }
    if (this.c.isResumed())
    {
      this.d.a(paramBoolean, false);
      a(paramBoolean, false);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      if (paramBoolean) {
        localObject = ": visibleToUser";
      } else {
        localObject = ": hiddenToUser";
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" on setUserVisibleHint");
      WSLog.e("UserVisibleController", localStringBuilder.toString());
    }
    if (this.c.getActivity() != null)
    {
      localObject = this.c.getChildFragmentManager().getFragments();
      if (((List)localObject).size() <= 0) {
        return;
      }
      if (paramBoolean)
      {
        a((List)localObject);
        return;
      }
      b((List)localObject);
    }
  }
  
  public void b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(": resume, userVisibleHint=");
    localStringBuilder.append(this.c.getUserVisibleHint());
    WSLog.e("UserVisibleController", localStringBuilder.toString());
    if (this.c.getUserVisibleHint())
    {
      this.d.a(true, true);
      a(true, true);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(": visibleToUser on resume");
      WSLog.e("UserVisibleController", localStringBuilder.toString());
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(": pause, userVisibleHint=");
    localStringBuilder.append(this.c.getUserVisibleHint());
    WSLog.e("UserVisibleController", localStringBuilder.toString());
    if (this.c.getUserVisibleHint())
    {
      this.d.a(false, true);
      a(false, true);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(": hiddenToUser on pause");
      WSLog.e("UserVisibleController", localStringBuilder.toString());
    }
  }
  
  public boolean d()
  {
    return (this.c.isResumed()) && (this.c.getUserVisibleHint());
  }
  
  public boolean e()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFragmentUserVisibleController
 * JD-Core Version:    0.7.0.1
 */