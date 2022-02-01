package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavListItemBase.IClickCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;

public class QavEffectAvatar2dItemView
  extends QavListItemBase
{
  TextView e;
  ImageView f;
  CircleProgressWithBg g;
  ImageView h;
  ImageView i;
  RelativeLayout j;
  
  public QavEffectAvatar2dItemView(Context paramContext)
  {
    super(paramContext);
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
    ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(2131625722, this);
    int k = this.b.getResources().getColor(2131168464);
    int m = getResources().getColor(2131165591);
    this.j = ((RelativeLayout)findViewById(2131441225));
    this.f = ((ImageView)findViewById(2131441060));
    this.i = ((ImageView)findViewById(2131441174));
    this.h = ((ImageView)findViewById(2131441056));
    this.g = ((CircleProgressWithBg)findViewById(2131441063));
    this.e = ((TextView)findViewById(2131441062));
    this.h.setImageResource(2130847666);
    b(paramInt1, paramInt2);
    this.g.setStrokeWidth(1.6F);
    this.g.setBgAndProgressColor(100, k, 100, m);
    this.f.setOnClickListener(this);
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
      if (this.j.getVisibility() != 4) {
        this.j.setVisibility(4);
      }
      return;
    }
    if (this.j.getVisibility() != 0) {
      this.j.setVisibility(0);
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
    if ((!paramItemInfo.d) && (!paramItemInfo.a.equals("0"))) {
      this.h.setVisibility(0);
    } else {
      this.h.setVisibility(8);
    }
    this.g.setVisibility(8);
    if ((paramItemInfo.f == 7) && ("0".equals(paramItemInfo.a))) {
      setHighlight(false);
    } else {
      setHighlight(paramBoolean1, "0".equals(paramItemInfo.a));
    }
    if (paramItemInfo.n)
    {
      this.e.setVisibility(0);
      paramIClickCallback = this.e;
      if (TextUtils.isEmpty(paramItemInfo.l)) {
        paramItemInfo = " ";
      } else {
        paramItemInfo = paramItemInfo.l;
      }
      paramIClickCallback.setText(paramItemInfo);
      return;
    }
    this.e.setVisibility(8);
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void setHighlight(boolean paramBoolean)
  {
    ImageView localImageView = this.i;
    int k;
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    localImageView.setVisibility(k);
  }
  
  public void setHighlight(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.i.setImageDrawable(getResources().getDrawable(2130843098));
      if (paramBoolean1) {
        localObject = null;
      } else {
        localObject = getResources().getDrawable(2130843205);
      }
      this.f.setImageDrawable((Drawable)localObject);
    }
    else
    {
      this.i.setImageDrawable(getResources().getDrawable(2130843099));
    }
    Object localObject = this.i;
    int k;
    if (paramBoolean1) {
      k = 0;
    } else {
      k = 8;
    }
    ((ImageView)localObject).setVisibility(k);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.view.QavEffectAvatar2dItemView
 * JD-Core Version:    0.7.0.1
 */