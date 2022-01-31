package com.tencent.biz.pubaccount.readinjoy.view.headers.question;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import bhqx;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.RollViewPager;
import rcl;
import rcm;

public class ReadInJoyQuestionBannerViewPager
  extends RollViewPager
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private ReadInJoyQuestionBannerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerAdapter;
  protected boolean a;
  private boolean b = true;
  private boolean c;
  
  public ReadInJoyQuestionBannerViewPager(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyQuestionBannerViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new rcm(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerAdapter = new ReadInJoyQuestionBannerAdapter(this.jdField_a_of_type_AndroidContentContext, this);
    setOnPageChangeListener(new ReadInJoyQuestionBannerViewPager.RollerChangeListener(this));
    setOnTouchStateChangeListener(new rcl(this));
    setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerAdapter);
    bhqx localbhqx = new bhqx(this.jdField_a_of_type_AndroidContentContext, new LinearInterpolator());
    localbhqx.a(400);
    localbhqx.a(this);
  }
  
  private void b()
  {
    this.b = false;
    if (this.c)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 4000L);
    }
  }
  
  private void c()
  {
    this.b = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.c = true;
    if (!this.b)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 4000L);
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.c = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.question.ReadInJoyQuestionBannerViewPager
 * JD-Core Version:    0.7.0.1
 */