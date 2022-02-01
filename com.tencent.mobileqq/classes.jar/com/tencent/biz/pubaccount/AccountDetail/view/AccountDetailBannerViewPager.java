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
  private final int a = 2000;
  private List<ViewPager.OnPageChangeListener> b;
  private AccountDetailBannerIndicator c;
  private int d = 0;
  private boolean e = false;
  private MqqHandler f = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private final int g = 1;
  private ViewPager.OnPageChangeListener h = new AccountDetailBannerViewPager.1(this);
  
  public AccountDetailBannerViewPager(Context paramContext)
  {
    super(paramContext);
    super.setOnPageChangeListener(this.h);
  }
  
  public AccountDetailBannerViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setOnPageChangeListener(this.h);
  }
  
  public void addOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    this.b.add(paramOnPageChangeListener);
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
    this.f.removeMessages(1);
    if (this.d == 0)
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
    this.f.sendEmptyMessageDelayed(1, 2000L);
    return true;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d == 1) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.d == 1) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    if (this.e) {
      if ((paramMotionEvent.getActionMasked() != 0) && (paramMotionEvent.getActionMasked() != 2))
      {
        if (paramMotionEvent.getActionMasked() == 1)
        {
          this.f.sendEmptyMessageDelayed(1, 2000L);
          if (QLog.isDevelopLevel()) {
            QLog.d("AccountDetailBannerViewPager", 2, "onTouchEvent->startAutoScroll");
          }
        }
      }
      else
      {
        this.f.removeMessages(1);
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
      this.e = true;
      this.f.sendEmptyMessageDelayed(1, 2000L);
      if (QLog.isDevelopLevel()) {
        QLog.d("AccountDetailBannerViewPager", 2, "setAdapter->startAutoScroll");
      }
    }
    else
    {
      this.e = false;
    }
  }
  
  public void setIndicator(AccountDetailBannerIndicator paramAccountDetailBannerIndicator)
  {
    this.c = paramAccountDetailBannerIndicator;
  }
  
  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    throw new RuntimeException("please use addOnPageChangeListener instead");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailBannerViewPager
 * JD-Core Version:    0.7.0.1
 */