package com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets;

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
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.views.RoundBorderImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.MessageProgressView;

public class StoryMsgNodeFrameLayout
  extends FrameLayout
  implements URLDrawable.URLDrawableListener
{
  public RoundBorderImageView a;
  public int b = AIOUtils.b(77.0F, getResources());
  public int c = AIOUtils.b(58.0F, getResources());
  public ImageView d;
  public MessageProgressView e;
  public TextView f;
  public View g;
  public View h;
  public ImageView i;
  public int j;
  public int k;
  public TextView l;
  @StoryMsgNodeFrameLayout.DisplayState
  public int m = -1;
  private Handler n;
  private Runnable o = new StoryMsgNodeFrameLayout.1(this);
  
  public StoryMsgNodeFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StoryMsgNodeFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    if (paramInt <= 0)
    {
      setCornerMarkVisible(8);
      return;
    }
    if (paramInt < 10)
    {
      localLayoutParams = this.f.getLayoutParams();
      localLayoutParams.width = UIUtils.a(getContext(), 10.0F);
      this.f.setLayoutParams(localLayoutParams);
      this.f.setBackgroundResource(2130848409);
      this.f.setText(String.valueOf(paramInt));
      return;
    }
    if (paramInt < 100)
    {
      localLayoutParams = this.f.getLayoutParams();
      localLayoutParams.width = UIUtils.a(getContext(), 14.0F);
      this.f.setLayoutParams(localLayoutParams);
      this.f.setBackgroundResource(2130848410);
      this.f.setText(String.valueOf(paramInt));
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.f.getLayoutParams();
    localLayoutParams.width = UIUtils.a(getContext(), 19.0F);
    this.f.setLayoutParams(localLayoutParams);
    this.f.setBackgroundResource(2130848411);
    this.f.setText("99+");
  }
  
  private boolean b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    SLog.a("StoryMsgNodeFrameLayout", "checkNeedShowRedPoint, uid:%s, feedId:%s, redPoint:%s", Long.valueOf(paramMsgTabNodeInfo.c), paramMsgTabNodeInfo.o, Boolean.valueOf(paramMsgTabNodeInfo.B));
    return paramMsgTabNodeInfo.B;
  }
  
  public void a()
  {
    SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation()");
    this.e.setVisibility(0);
    this.n.post(this.o);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
    this.a.setSegmentCount(this.j, this.k);
  }
  
  public void a(Context paramContext)
  {
    inflate(paramContext, 2131629674, this);
    this.a = ((RoundBorderImageView)findViewById(2131438934));
    this.d = ((ImageView)findViewById(2131438931));
    this.l = ((TextView)findViewById(2131438936));
    this.f = ((TextView)findViewById(2131438930));
    this.h = findViewById(2131438937);
    this.g = findViewById(2131438935);
    this.i = ((ImageView)findViewById(2131438933));
    this.e = ((MessageProgressView)findViewById(2131438932));
    this.e.setRadius(this.a.a, false);
    this.e.setBreathingCircleRadius(16.0F);
    this.e.setShowCorner(false);
    this.e.setDrawStatus(1);
    setDisplayState(0);
    this.n = new Handler(Looper.getMainLooper());
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i3 = paramMsgTabNodeInfo.b;
    int i2 = 0;
    int i1 = 0;
    switch (i3)
    {
    case 8: 
    default: 
      setCornerMarkVisible(8);
      this.i.setVisibility(8);
      return;
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
      setCornerMarkVisible(8);
      localImageView = this.i;
      if (!b(paramMsgTabNodeInfo)) {
        i1 = 8;
      }
      localImageView.setVisibility(i1);
      return;
    }
    setCornerMarkVisible(0);
    a(paramMsgTabNodeInfo.i);
    ImageView localImageView = this.i;
    if (b(paramMsgTabNodeInfo)) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    localImageView.setVisibility(i1);
  }
  
  public void b()
  {
    SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation()");
    this.e.setAnimProgress(100, QQStoryContext.a().i());
    this.e.setAnimRunnableListener(new StoryMsgNodeFrameLayout.2(this));
    this.n.removeCallbacksAndMessages(null);
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadFialed!");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadFialed!");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadCanceled!");
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation load onLoadSuccessed!");
    if ((paramURLDrawable.getCurrDrawable() instanceof GifDrawable))
    {
      SLog.b("StoryMsgNodeFrameLayoutVASH", "startUploadingAnimation reset drawable!");
      AbstractGifImage.resumeAll();
    }
  }
  
  protected void setCornerMarkVisible(int paramInt)
  {
    this.g.setVisibility(paramInt);
    this.h.setVisibility(paramInt);
    this.f.setVisibility(paramInt);
  }
  
  public void setDisplayState(@StoryMsgNodeFrameLayout.DisplayState int paramInt)
  {
    if (paramInt == this.m) {
      return;
    }
    int i1 = AIOUtils.b(56.0F, getResources());
    this.a.a(false);
    switch (paramInt)
    {
    default: 
      break;
    case 6: 
      this.a.a();
      this.a.setVisibility(0);
      this.d.setVisibility(8);
      break;
    case 5: 
      this.a.setVisibility(8);
      this.d.setImageResource(2130848431);
      this.d.setVisibility(0);
      break;
    case 4: 
      this.a.setVisibility(0);
      this.a.setImageResource(2130848433);
      this.a.a();
      this.d.setVisibility(8);
      break;
    case 3: 
      this.a.setImageResource(2130848433);
      this.a.a(1.0F);
      this.a.a();
      this.a.setVisibility(0);
      this.d.setVisibility(8);
      break;
    case 2: 
      this.a.a();
      this.a.setVisibility(0);
      this.d.setVisibility(8);
      break;
    case 1: 
      this.a.setBadgeIcon(2130848430, true);
      this.a.a(true);
      this.a.setVisibility(0);
      this.d.setVisibility(8);
      break;
    case 0: 
      this.a.a();
      this.a.setVisibility(0);
      this.d.setVisibility(8);
    }
    if (i1 != this.c)
    {
      RelativeLayout.LayoutParams localLayoutParams2 = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new RelativeLayout.LayoutParams(i1, this.b);
      }
      localLayoutParams1.width = i1;
      localLayoutParams1.height = this.b;
      this.a.setLayoutParams(localLayoutParams1);
      this.c = i1;
    }
  }
  
  public void setNodeName(String paramString, @DrawableRes int paramInt)
  {
    this.l.setText(paramString);
    if (paramInt != 0) {
      this.l.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(paramInt), null);
    } else {
      this.l.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
    paramInt = getContext().getResources().getColor(2131168001);
    this.l.setTextColor(paramInt);
  }
  
  public void setNodeName(String paramString1, String paramString2)
  {
    this.l.setText(paramString1);
    paramString1 = URLDrawableHelper.getLoadingDrawable();
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramString1;
    localURLDrawableOptions.mFailedDrawable = paramString1;
    localURLDrawableOptions.mUseAutoScaleParams = false;
    localURLDrawableOptions.mRequestWidth = UIUtils.a(getContext(), 12.0F);
    localURLDrawableOptions.mRequestHeight = UIUtils.a(getContext(), 12.0F);
    paramString1 = URLDrawable.getDrawable(paramString2, localURLDrawableOptions);
    this.l.setCompoundDrawablesWithIntrinsicBounds(null, null, paramString1, null);
    int i1 = getContext().getResources().getColor(2131168001);
    this.l.setTextColor(i1);
  }
  
  public void setNodeName(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setNodeName(paramString, 2130848434);
      return;
    }
    setNodeName(paramString, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.roundwithdashdemo2018.widgets.StoryMsgNodeFrameLayout
 * JD-Core Version:    0.7.0.1
 */