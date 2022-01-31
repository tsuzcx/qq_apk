package com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets;

import aepi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bayu;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.MessageProgressView;
import uyg;
import vad;
import wxe;
import xsm;

public class StoryMsgNodeFrameLayout
  extends FrameLayout
  implements URLDrawable.URLDrawableListener
{
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  public View a;
  public ImageView a;
  public TextView a;
  public RoundBorderImageView a;
  public MessageProgressView a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new StoryMsgNodeFrameLayout.1(this);
  public int b;
  public View b;
  public ImageView b;
  public TextView b;
  public int c;
  public int d;
  public int e = -1;
  
  public StoryMsgNodeFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryMsgNodeFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = aepi.a(77.0F, getResources());
    this.jdField_b_of_type_Int = aepi.a(58.0F, getResources());
    a(paramContext);
  }
  
  private boolean a(uyg paramuyg)
  {
    wxe.a("StoryMsgNodeFrameLayout", "checkNeedShowRedPoint, uid:%s, feedId:%s, redPoint:%s", Long.valueOf(paramuyg.jdField_b_of_type_Long), paramuyg.f, Boolean.valueOf(paramuyg.c));
    return paramuyg.c;
  }
  
  private void b(int paramInt)
  {
    if (paramInt <= 0)
    {
      a(8);
      return;
    }
    if (paramInt < 10)
    {
      localLayoutParams = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.width = xsm.a(getContext(), 10.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846176);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
      return;
    }
    if (paramInt < 100)
    {
      localLayoutParams = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      localLayoutParams.width = xsm.a(getContext(), 14.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846177);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.width = xsm.a(getContext(), 19.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846178);
    this.jdField_a_of_type_AndroidWidgetTextView.setText("99+");
  }
  
  public void a()
  {
    wxe.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation()");
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setVisibility(0);
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(paramInt);
    this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setSegmentCount(this.c, this.d);
  }
  
  public void a(Context paramContext)
  {
    inflate(paramContext, 2131562840, this);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView = ((RoundBorderImageView)findViewById(2131370814));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370811));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370816));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370810));
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370817);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370815);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370813));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView = ((MessageProgressView)findViewById(2131370812));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setRadius(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.jdField_a_of_type_Int, false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setBreathingCircleRadius(16.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setShowCorner(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setDrawStatus(1);
    setDisplayState(0);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  public void a(uyg paramuyg)
  {
    int j = 0;
    int i = 0;
    switch (paramuyg.jdField_a_of_type_Int)
    {
    case 8: 
    default: 
      a(8);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      return;
    case 6: 
    case 7: 
      a(0);
      b(paramuyg.jdField_b_of_type_Int);
      localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
      if (a(paramuyg)) {}
      for (;;)
      {
        localImageView.setVisibility(i);
        return;
        i = 8;
      }
    }
    a(8);
    ImageView localImageView = this.jdField_b_of_type_AndroidWidgetImageView;
    if (a(paramuyg)) {}
    for (i = j;; i = 8)
    {
      localImageView.setVisibility(i);
      return;
    }
  }
  
  public void b()
  {
    wxe.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation()");
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimProgress(100, QQStoryContext.a().b());
    this.jdField_a_of_type_ComTencentMobileqqWidgetMessageProgressView.setAnimRunnableListener(new vad(this));
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    wxe.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadFialed!");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    wxe.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadFialed!");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    wxe.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadCanceled!");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    wxe.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadSuccessed!");
    if ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))
    {
      wxe.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation reset drawable!");
      AbstractGifImage.resumeAll();
    }
  }
  
  public void setDisplayState(int paramInt)
  {
    if (paramInt == this.e) {}
    for (;;)
    {
      return;
      int i = aepi.a(56.0F, getResources());
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a(false);
      switch (paramInt)
      {
      }
      while (i != this.jdField_b_of_type_Int)
      {
        RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.getLayoutParams();
        RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
        if (localLayoutParams2 == null) {
          localLayoutParams1 = new RelativeLayout.LayoutParams(i, this.jdField_a_of_type_Int);
        }
        localLayoutParams1.width = i;
        localLayoutParams1.height = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setLayoutParams(localLayoutParams1);
        this.jdField_b_of_type_Int = i;
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a();
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setBadgeIcon(2130846197, true);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a(true);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a();
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setImageResource(2130846200);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a(1.0F);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a();
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setImageResource(2130846200);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a();
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846198);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        continue;
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.a();
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeRoundwithdashdemo2018ViewsRoundBorderImageView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
  }
  
  public void setNodeName(String paramString, @DrawableRes int paramInt)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
    if (paramInt != 0) {
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(paramInt), null);
    }
    for (;;)
    {
      paramInt = getContext().getResources().getColor(2131166910);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramInt);
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
  }
  
  public void setNodeName(String paramString1, String paramString2)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
    paramString1 = bayu.b();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramString1;
    localURLDrawableOptions.mFailedDrawable = paramString1;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    localURLDrawableOptions.mRequestWidth = xsm.a(getContext(), 12.0F);
    localURLDrawableOptions.mRequestHeight = xsm.a(getContext(), 12.0F);
    paramString1 = URLDrawable.getDrawable(paramString2, localURLDrawableOptions);
    this.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, paramString1, null);
    int i = getContext().getResources().getColor(2131166910);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
  }
  
  public void setNodeName(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setNodeName(paramString, 2130846201);
      return;
    }
    setNodeName(paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout
 * JD-Core Version:    0.7.0.1
 */