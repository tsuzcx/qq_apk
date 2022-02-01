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
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private CertifiedAccountMeta.StUser jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser;
  private ArrayList<View> jdField_a_of_type_JavaUtilArrayList;
  
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
    this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser = paramStUser;
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramView)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramView);
    }
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void flingRToL()
  {
    if (this.mTopLayout != null)
    {
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser != null)
      {
        SubscribeLaucher.a(this.mTopLayout.getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StUser);
        return;
      }
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
        SubscribeLaucher.a(this.mTopLayout.getContext(), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.GestureToLaunchPageHelper
 * JD-Core Version:    0.7.0.1
 */