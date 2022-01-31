package com.tencent.biz.pubaccount.AccountDetail.view;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import bhsl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import nij;

public class AccountDetailBannerViewPager
  extends ViewPager
  implements Handler.Callback
{
  private final int jdField_a_of_type_Int = 2000;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new nij(this);
  private AccountDetailBannerIndicator jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailBannerIndicator;
  private List<ViewPager.OnPageChangeListener> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bhsl(Looper.getMainLooper(), this, true);
  private boolean jdField_a_of_type_Boolean;
  private int b = 0;
  private final int c = 1;
  
  public AccountDetailBannerViewPager(Context paramContext)
  {
    super(paramContext);
    super.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
  }
  
  public AccountDetailBannerViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AccountDetailBannerViewPager", 2, "handleMessage->" + paramMessage.what);
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    if (this.b == 0)
    {
      int i = getCurrentItem() + 1;
      setCurrentItem(i, true);
      if (QLog.isDevelopLevel()) {
        QLog.d("AccountDetailBannerViewPager", 2, "setCurrentItem->" + i);
      }
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 2000L);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b == 1) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b == 1) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if ((paramMotionEvent.getActionMasked() != 0) && (paramMotionEvent.getActionMasked() != 2)) {
        break label68;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
      if (QLog.isDevelopLevel()) {
        QLog.d("AccountDetailBannerViewPager", 2, "onTouchEvent->stopAutoScroll");
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      label68:
      if (paramMotionEvent.getActionMasked() == 1)
      {
        this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 2000L);
        if (QLog.isDevelopLevel()) {
          QLog.d("AccountDetailBannerViewPager", 2, "onTouchEvent->startAutoScroll");
        }
      }
    }
  }
  
  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    super.setAdapter(paramPagerAdapter);
    if ((getAdapter() != null) && (getAdapter().getCount() > 1))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 2000L);
      if (QLog.isDevelopLevel()) {
        QLog.d("AccountDetailBannerViewPager", 2, "setAdapter->startAutoScroll");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void setIndicator(AccountDetailBannerIndicator paramAccountDetailBannerIndicator)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailBannerIndicator = paramAccountDetailBannerIndicator;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    throw new RuntimeException("please use addOnPageChangeListener instead");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailBannerViewPager
 * JD-Core Version:    0.7.0.1
 */