package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.ae.view.AEDownLoadingView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class MaterialViewHolder
  extends RecyclerView.ViewHolder
{
  public URLImageView a;
  public ImageView b;
  public ImageView c;
  public ImageView d;
  public AEDownLoadingView e;
  public RelativeLayout f;
  private int g = 0;
  private Context h;
  
  public MaterialViewHolder(View paramView)
  {
    super(paramView);
    this.a = ((URLImageView)paramView.findViewById(2063991486));
    this.b = ((ImageView)paramView.findViewById(2063991419));
    this.c = ((ImageView)paramView.findViewById(2063991019));
    this.d = ((ImageView)paramView.findViewById(2063991502));
    this.e = ((AEDownLoadingView)paramView.findViewById(2063991328));
    this.f = ((RelativeLayout)paramView.findViewById(2063991619));
  }
  
  private static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 0;
    }
    return 8;
  }
  
  private void a(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.b.setVisibility(8);
    this.c.setVisibility(8);
    this.d.setVisibility(8);
    this.f.setVisibility(8);
  }
  
  private void b(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.b.setVisibility(8);
    c(paramAEMaterialMetaData);
    e(paramAEMaterialMetaData);
    this.f.setVisibility(a(paramAEMaterialMetaData.u));
  }
  
  private void c(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.a())
    {
      this.c.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    if (paramAEMaterialMetaData.A)
    {
      this.c.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    if (paramAEMaterialMetaData.B)
    {
      this.c.setVisibility(8);
      this.e.setVisibility(0);
      this.e.setProgress(paramAEMaterialMetaData.C);
      return;
    }
    this.c.setVisibility(0);
    this.c.setImageResource(2063925646);
    this.e.setVisibility(8);
  }
  
  private void d(AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.b.setVisibility(0);
    this.b.setImageResource(2063925330);
    c(paramAEMaterialMetaData);
    e(paramAEMaterialMetaData);
    this.f.setVisibility(a(paramAEMaterialMetaData.u));
  }
  
  private void e(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (paramAEMaterialMetaData.a())
    {
      this.d.setVisibility(0);
      this.d.setImageResource(2130847606);
      return;
    }
    if (paramAEMaterialMetaData.b())
    {
      this.d.setVisibility(0);
      this.d.setImageResource(paramAEMaterialMetaData.c());
      return;
    }
    this.d.setVisibility(8);
  }
  
  private void f(AEMaterialMetaData paramAEMaterialMetaData)
  {
    int i = this.g;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          a(paramAEMaterialMetaData);
          return;
        }
        d(paramAEMaterialMetaData);
        g(paramAEMaterialMetaData);
        return;
      }
      b(paramAEMaterialMetaData);
      g(paramAEMaterialMetaData);
      return;
    }
    a(paramAEMaterialMetaData);
  }
  
  private void g(AEMaterialMetaData paramAEMaterialMetaData)
  {
    if (TextUtils.isEmpty(paramAEMaterialMetaData.q)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = AIOUtils.b(60.0F, this.h.getResources());
    Drawable localDrawable = this.h.getResources().getDrawable(2063925645);
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mRetryCount = 3;
    paramAEMaterialMetaData = URLDrawable.getDrawable(paramAEMaterialMetaData.q, localURLDrawableOptions);
    if (paramAEMaterialMetaData.getStatus() == 2) {
      paramAEMaterialMetaData.restartDownload();
    }
    this.a.setImageDrawable(paramAEMaterialMetaData);
  }
  
  public void a(int paramInt, AEMaterialMetaData paramAEMaterialMetaData)
  {
    this.g = paramInt;
    f(paramAEMaterialMetaData);
  }
  
  public void a(Context paramContext)
  {
    this.h = paramContext;
    int i = AIOUtils.b(6.0F, paramContext.getResources());
    int j = AIOUtils.b(2.0F, paramContext.getResources());
    int k = AIOUtils.b(16.0F, paramContext.getResources());
    this.e.setBgCorner(k / 2);
    this.e.setMinimumHeight(k);
    this.e.setMinimumWidth(k);
    this.e.setProgressSizeAndMode(i, j, false);
    this.e.setBgColor(-1);
    this.e.setProgressColor(-16725252);
    this.e.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.MaterialViewHolder
 * JD-Core Version:    0.7.0.1
 */