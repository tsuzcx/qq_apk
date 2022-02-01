package com.tencent.biz.subscribe.utils;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import java.util.ArrayList;

public class GestureToLaunchPageHelper
  extends FlingGestureHandler
{
  private CertifiedAccountMeta.StFeed a;
  private CertifiedAccountMeta.StUser b;
  private ArrayList<View> c;
  
  public GestureToLaunchPageHelper(Activity paramActivity)
  {
    super(paramActivity);
    paramActivity = new TopGestureLayout(paramActivity);
    paramActivity.setInterceptScrollRLFlag(true);
    setTopLayout(paramActivity);
    if (this.mTopLayout != null)
    {
      paramActivity = new Rect();
      this.mTopLayout.setInterceptTouchEventListener(new GestureToLaunchPageHelper.1(this, paramActivity));
    }
    onStart();
  }
  
  public void a(CertifiedAccountMeta.StUser paramStUser)
  {
    this.b = paramStUser;
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.c == null) {
      this.c = new ArrayList();
    }
    if (!this.c.contains(paramView)) {
      this.c.add(paramView);
    }
  }
  
  protected boolean canWrapContent()
  {
    return true;
  }
  
  public void flingRToL()
  {
    if (this.mTopLayout != null)
    {
      if (this.b != null)
      {
        SubscribeLaucher.a(this.mTopLayout.getContext(), this.b);
        return;
      }
      if (this.a != null) {
        SubscribeLaucher.a(this.mTopLayout.getContext(), this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.GestureToLaunchPageHelper
 * JD-Core Version:    0.7.0.1
 */