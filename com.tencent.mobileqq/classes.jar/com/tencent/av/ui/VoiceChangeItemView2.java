package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.av.ui.effect.view.EffectMaterialImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class VoiceChangeItemView2
  extends QavListItemBase
{
  Context e;
  EffectMaterialImageView f = null;
  ImageView g = null;
  
  public VoiceChangeItemView2(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ((LayoutInflater)this.e.getSystemService("layout_inflater")).inflate(2131625828, this);
    this.f = ((EffectMaterialImageView)findViewById(2131441060));
    this.g = ((ImageView)findViewById(2131449968));
    this.f.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, QavListItemBase.ItemInfo paramItemInfo, QavListItemBase.IClickCallback paramIClickCallback)
  {
    super.a(paramInt, paramIClickCallback);
    setId(paramInt);
    setTag(paramItemInfo);
    if (!TextUtils.isEmpty(paramItemInfo.b))
    {
      paramIClickCallback = URLDrawable.URLDrawableOptions.obtain();
      paramIClickCallback = URLDrawable.getDrawable(paramItemInfo.b, paramIClickCallback);
      this.f.setImageDrawable(paramIClickCallback);
    }
    paramInt = paramItemInfo.g;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          this.g.setVisibility(8);
        }
        else
        {
          this.g.setImageResource(2130843330);
          this.g.setVisibility(0);
        }
      }
      else
      {
        this.g.setImageResource(2130843330);
        this.g.setVisibility(0);
      }
    }
    else
    {
      this.g.setImageResource(2130843330);
      this.g.setVisibility(0);
    }
    setHighlight(paramBoolean1);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    Object localObject = findViewById(2131449966);
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    ((View)localObject).setLayoutParams(localLayoutParams);
    if ((this.f != null) && (paramInt1 < getResources().getDimensionPixelSize(2131298440)))
    {
      localObject = this.f.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = paramInt1;
      ((ViewGroup.LayoutParams)localObject).height = paramInt1;
      this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setHighlight(boolean paramBoolean)
  {
    this.f.setHighlight(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VoiceChangeItemView2
 * JD-Core Version:    0.7.0.1
 */