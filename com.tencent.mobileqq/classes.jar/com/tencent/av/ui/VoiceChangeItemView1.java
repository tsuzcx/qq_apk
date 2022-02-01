package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.ui.effect.view.EffectMaterialImageView;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class VoiceChangeItemView1
  extends RelativeLayout
  implements View.OnClickListener
{
  Context a;
  int b;
  VoiceChangeItemView1.ICallback c;
  EffectMaterialImageView d = null;
  ImageView e = null;
  TextView f = null;
  int g = -16777216;
  VoiceChangeData.VoiceInfo h = null;
  
  public VoiceChangeItemView1(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public void a()
  {
    ((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2131625827, this);
    this.d = ((EffectMaterialImageView)findViewById(2131449963));
    this.e = ((ImageView)findViewById(2131449968));
    this.f = ((TextView)findViewById(2131449967));
    ViewGroup.LayoutParams localLayoutParams = this.d.getLayoutParams();
    int i = AIOUtils.b(65.0F, getResources());
    localLayoutParams.width = i;
    localLayoutParams.height = i;
    this.d.setLayoutParams(localLayoutParams);
    setOnClickListener(this);
  }
  
  public void a(int paramInt1, VoiceChangeData.VoiceInfo paramVoiceInfo, boolean paramBoolean, int paramInt2, VoiceChangeItemView1.ICallback paramICallback)
  {
    this.b = paramInt1;
    this.c = paramICallback;
    this.g = paramInt2;
    this.h = paramVoiceInfo;
    if (paramVoiceInfo.d == 0)
    {
      paramICallback = this.d.getResources();
      if (this.g == -16777216) {
        paramICallback = TintStateDrawable.a(paramICallback, 2130843204, 2131166728);
      } else {
        paramICallback = TintStateDrawable.a(paramICallback, 2130843204, 2131166770);
      }
      this.d.setImageDrawable(paramICallback);
    }
    else if (!TextUtils.isEmpty(paramVoiceInfo.b))
    {
      paramICallback = URLDrawable.URLDrawableOptions.obtain();
      paramInt1 = AIOUtils.b(60.0F, getResources());
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131166580));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt1, paramInt1);
      paramICallback.mRequestWidth = paramInt1;
      paramICallback.mRequestHeight = paramInt1;
      paramICallback.mFailedDrawable = localGradientDrawable;
      paramICallback.mLoadingDrawable = localGradientDrawable;
      paramICallback = URLDrawable.getDrawable(paramVoiceInfo.b, paramICallback);
      paramICallback.setTag(URLDrawableDecodeHandler.a(paramInt1, paramInt1));
      paramICallback.setDecodeHandler(URLDrawableDecodeHandler.b);
      this.d.setImageDrawable(paramICallback);
    }
    paramInt1 = paramVoiceInfo.e;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3)
        {
          this.e.setVisibility(8);
        }
        else
        {
          this.e.setImageResource(2130843330);
          this.e.setVisibility(0);
        }
      }
      else
      {
        this.e.setImageResource(2130843330);
        this.e.setVisibility(0);
      }
    }
    else
    {
      this.e.setImageResource(2130843330);
      this.e.setVisibility(0);
    }
    this.f.setText(paramVoiceInfo.a);
    this.f.setTextColor(this.g);
    setHighlight(paramBoolean);
    paramICallback = new StringBuilder();
    paramICallback.append(paramVoiceInfo.a);
    paramICallback.append(HardCodeUtil.a(2131913768));
    setContentDescription(paramICallback.toString());
  }
  
  public int getPosition()
  {
    return this.b;
  }
  
  public void onClick(View paramView)
  {
    VoiceChangeItemView1.ICallback localICallback = this.c;
    if (localICallback != null) {
      localICallback.a(this, this.b);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.d.dispatchTouchEvent(paramMotionEvent);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    Object localObject = this.h;
    if ((localObject != null) && (((VoiceChangeData.VoiceInfo)localObject).d == 0)) {
      this.d.setSelected(paramBoolean);
    } else {
      this.d.setHighlight(paramBoolean);
    }
    localObject = this.f;
    int i;
    if (paramBoolean) {
      i = -15550475;
    } else {
      i = this.g;
    }
    ((TextView)localObject).setTextColor(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeItemView1
 * JD-Core Version:    0.7.0.1
 */