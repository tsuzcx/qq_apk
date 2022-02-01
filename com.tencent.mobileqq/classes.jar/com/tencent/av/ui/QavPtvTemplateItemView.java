package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.ui.effect.view.EffectMaterialImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.widget.CircleProgress;

public class QavPtvTemplateItemView
  extends QavListItemBase
{
  TextView e;
  EffectMaterialImageView f;
  CircleProgress g;
  ImageView h;
  RelativeLayout i;
  public boolean j = false;
  
  public QavPtvTemplateItemView(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 100)
    {
      if (this.g.getVisibility() != 8) {
        this.g.setVisibility(8);
      }
      this.h.setVisibility(8);
      return;
    }
    if (paramInt < 0)
    {
      if (this.g.getVisibility() != 8) {
        this.g.setVisibility(8);
      }
      this.h.setVisibility(0);
      return;
    }
    if (this.g.getVisibility() != 0) {
      this.g.setVisibility(0);
    }
    this.g.setProgress(paramInt);
    this.h.setVisibility(8);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2131625803, this);
    int n = getResources().getColor(2131167993);
    int k;
    int m;
    if (!this.j)
    {
      k = getResources().getColor(2131165591);
      m = 2130847666;
    }
    else
    {
      k = getResources().getColor(2131166815);
      m = 2130847667;
    }
    this.i = ((RelativeLayout)findViewById(2131441225));
    this.f = ((EffectMaterialImageView)findViewById(2131441060));
    this.h = ((ImageView)findViewById(2131441056));
    this.g = ((CircleProgress)findViewById(2131441063));
    this.e = ((TextView)findViewById(2131441062));
    this.h.setImageResource(m);
    b(paramInt1, paramInt2);
    this.g.setStrokeWidth(1.6F);
    this.g.setBgAndProgressColor(30, n, 100, k);
    this.f.setOnClickListener(this);
    if (this.j)
    {
      if ((this.i.getParent() instanceof LinearLayout)) {
        ((LinearLayout)this.i.getParent()).setGravity(83);
      }
      this.f.setDimmedColor(-47980);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IClickCallback paramIClickCallback)
  {
    if (paramItemInfo == null) {
      return;
    }
    super.a(paramInt, paramIClickCallback);
    setId(paramInt);
    setTag(paramItemInfo);
    this.f.setTag(paramItemInfo);
    if (TextUtils.isEmpty(paramItemInfo.a))
    {
      if (this.i.getVisibility() != 4) {
        this.i.setVisibility(4);
      }
      return;
    }
    if (this.i.getVisibility() != 0) {
      this.i.setVisibility(0);
    }
    if ("0".equals(paramItemInfo.a))
    {
      if (!TextUtils.isEmpty(paramItemInfo.b)) {
        paramInt = Integer.valueOf(paramItemInfo.b).intValue();
      } else {
        paramInt = 0;
      }
      if (paramInt > 0) {
        this.f.setImageResource(paramInt);
      } else {
        this.f.setImageResource(2130853309);
      }
    }
    else if (!TextUtils.isEmpty(paramItemInfo.b))
    {
      paramIClickCallback = URLDrawable.URLDrawableOptions.obtain();
      paramInt = getResources().getDimensionPixelSize(2131298440);
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setColor(getResources().getColor(2131166580));
      localGradientDrawable.setShape(1);
      localGradientDrawable.setSize(paramInt, paramInt);
      paramIClickCallback.mRequestWidth = paramInt;
      paramIClickCallback.mRequestHeight = paramInt;
      paramIClickCallback.mFailedDrawable = localGradientDrawable;
      paramIClickCallback.mLoadingDrawable = localGradientDrawable;
      paramIClickCallback = URLDrawable.getDrawable(paramItemInfo.b, paramIClickCallback);
      paramIClickCallback.setTag(URLDrawableDecodeHandler.a(paramInt, paramInt));
      if (paramBoolean2) {
        paramIClickCallback.setDecodeHandler(URLDrawableDecodeHandler.b);
      }
      this.f.setImageDrawable(paramIClickCallback);
    }
    if ((paramItemInfo.f != 4) && (paramItemInfo.f != 5)) {
      this.f.setCircle(false);
    } else {
      this.f.setCircle(true);
    }
    if ((!paramItemInfo.d) && (!paramItemInfo.a.equals("0"))) {
      this.h.setVisibility(0);
    } else {
      this.h.setVisibility(8);
    }
    this.g.setVisibility(8);
    setDimmed(paramItemInfo.h);
    setHighlight(paramBoolean1);
    if (paramItemInfo.n)
    {
      this.e.setVisibility(0);
      paramIClickCallback = this.e;
      if (TextUtils.isEmpty(paramItemInfo.c)) {
        paramItemInfo = " ";
      } else {
        paramItemInfo = paramItemInfo.c;
      }
      paramIClickCallback.setText(paramItemInfo);
      return;
    }
    this.e.setVisibility(8);
  }
  
  public void a(QavListItemBase.ItemInfo paramItemInfo, int paramInt)
  {
    paramInt %= 2;
    if (paramInt == 0) {
      this.i.setBackgroundColor(Color.argb(255, 224, 176, 216));
    } else {
      this.i.setBackgroundColor(Color.argb(155, 224, 176, 216));
    }
    if (!this.j) {
      this.f.setBackgroundColor(Color.argb(255, 168, 168, 236));
    } else {
      this.f.setBackgroundColor(getResources().getColor(2131166815));
    }
    if ((paramItemInfo != null) && ("0".equals(paramItemInfo.a)))
    {
      setBackgroundColor(-16711681);
      return;
    }
    if (paramInt == 0)
    {
      setBackgroundColor(-7829368);
      return;
    }
    setBackgroundColor(-3355444);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    View localView = findViewById(2131441226);
    ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localView.setLayoutParams(localLayoutParams);
  }
  
  public int getPosition()
  {
    return this.a;
  }
  
  public void setDimmed(boolean paramBoolean)
  {
    this.f.setDimmed(paramBoolean);
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    this.f.setHighlight(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavPtvTemplateItemView
 * JD-Core Version:    0.7.0.1
 */