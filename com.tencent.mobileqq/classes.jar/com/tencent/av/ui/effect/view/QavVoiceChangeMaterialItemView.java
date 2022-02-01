package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavListItemBase.IClickCallback;
import com.tencent.av.ui.QavListItemBase.ItemInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class QavVoiceChangeMaterialItemView
  extends QavListItemBase
{
  Context e;
  ImageView f = null;
  ImageView g;
  TextView h;
  
  public QavVoiceChangeMaterialItemView(Context paramContext)
  {
    super(paramContext);
    this.e = paramContext;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    ((LayoutInflater)this.e.getSystemService("layout_inflater")).inflate(2131625829, this);
    this.f = ((ImageView)findViewById(2131441060));
    this.g = ((ImageView)findViewById(2131441174));
    this.h = ((TextView)findViewById(2131441062));
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
    setHighlight(paramBoolean1, "0".equals(paramItemInfo.a));
    if (paramItemInfo.n)
    {
      this.h.setVisibility(0);
      paramIClickCallback = this.h;
      if (TextUtils.isEmpty(paramItemInfo.c)) {
        paramItemInfo = " ";
      } else {
        paramItemInfo = paramItemInfo.c;
      }
      paramIClickCallback.setText(paramItemInfo);
      return;
    }
    this.h.setVisibility(8);
  }
  
  public void b(int paramInt1, int paramInt2) {}
  
  public void setHighlight(boolean paramBoolean)
  {
    ImageView localImageView = this.g;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  public void setHighlight(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      this.g.setImageResource(2130843101);
      if (paramBoolean1) {
        localObject = null;
      } else {
        localObject = getResources().getDrawable(2130843209);
      }
      this.f.setImageDrawable((Drawable)localObject);
    }
    else
    {
      this.g.setImageResource(2130843103);
    }
    Object localObject = this.g;
    int i;
    if (paramBoolean1) {
      i = 0;
    } else {
      i = 8;
    }
    ((ImageView)localObject).setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.view.QavVoiceChangeMaterialItemView
 * JD-Core Version:    0.7.0.1
 */