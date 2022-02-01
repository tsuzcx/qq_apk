package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class AccountDetailBannerViewPager
  extends ViewPager
  implements Handler.Callback
{
  private final int jdField_a_of_type_Int = 2000;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = new AccountDetailBannerViewPager.1(this);
  private AccountDetailBannerIndicator jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailBannerIndicator;
  private List<ViewPager.OnPageChangeListener> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private boolean jdField_a_of_type_Boolean = false;
  private int b = 0;
  private final int c = 1;
  
  public AccountDetailBannerViewPager(Context paramContext)
  {
    super(paramContext);
    super.setOnPageChangeListener(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener);
  }
  
  public AccountDetailBannerViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnPageChangeListener(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener);
  }
  
  public void addOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramOnPageChangeListener);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMessage->");
      localStringBuilder.append(paramMessage.what);
      QLog.d("AccountDetailBannerViewPager", 2, localStringBuilder.toString());
    }
    if (paramMessage.what != 1) {
      return false;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    if (this.b == 0)
    {
      int i = getCurrentItem() + 1;
      setCurrentItem(i, true);
      if (QLog.isDevelopLevel())
      {
        paramMessage = new StringBuilder();
        paramMessage.append("setCurrentItem->");
        paramMessage.append(i);
        QLog.d("AccountDetailBannerViewPager", 2, paramMessage.toString());
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
    if (this.jdField_a_of_type_Boolean) {
      if ((paramMotionEvent.getActionMasked() != 0) && (paramMotionEvent.getActionMasked() != 2))
      {
        if (paramMotionEvent.getActionMasked() == 1)
        {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, 2000L);
          if (QLog.isDevelopLevel()) {
            QLog.d("AccountDetailBannerViewPager", 2, "onTouchEvent->startAutoScroll");
          }
        }
      }
      else
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
        if (QLog.isDevelopLevel()) {
          QLog.d("AccountDetailBannerViewPager", 2, "onTouchEvent->stopAutoScroll");
        }
      }
    }
    return super.onTouchEvent(paramMotionEvent);
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
    }
    else
    {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void setIndicator(AccountDetailBannerIndicator paramAccountDetailBannerIndicator)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountAccountdetailViewAccountDetailBannerIndicator = paramAccountDetailBannerIndicator;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    throw new RuntimeException("please use addOnPageChangeListener instead");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailBannerViewPager
 * JD-Core Version:    0.7.0.1
 */