package com.tencent.mobileqq.apollo.store.openbox;

import aldt;
import aliu;
import android.content.Context;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bdgk;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import java.io.File;

public class StolenCountView
  extends RelativeLayout
{
  private URLImageView a;
  private URLImageView b;
  
  public StolenCountView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private void a()
  {
    if (!new File(aliu.k + "boxcard/apollo_stolen_count_1.png").exists()) {
      aldt.a("apollo_stolen_count_1.png", null, aldt.a("apollo_stolen_count_1.png")).startDownload();
    }
    if (!new File(aliu.k + "boxcard/apollo_stolen_count_2.png").exists()) {
      aldt.a("apollo_stolen_count_2.png", null, aldt.a("apollo_stolen_count_2.png")).startDownload();
    }
    if (!new File(aliu.k + "boxcard/apollo_stolen_count_3.png").exists()) {
      aldt.a("apollo_stolen_count_3.png", null, aldt.a("apollo_stolen_count_3.png")).startDownload();
    }
    if (!new File(aliu.k + "boxcard/apollo_stolen_count_4.png").exists()) {
      aldt.a("apollo_stolen_count_4.png", null, aldt.a("apollo_stolen_count_4.png")).startDownload();
    }
  }
  
  private void a(Context paramContext)
  {
    a();
    this.b = new URLImageView(paramContext);
    int j = (int)((float)bdgk.i() * 0.97F);
    int i = (int)((float)bdgk.i() * 0.192F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, i);
    localLayoutParams.addRule(13);
    URLDrawable localURLDrawable = aldt.a("apollo_stolen_count_bg.png", null, aldt.a("apollo_stolen_count_bg.png"));
    localURLDrawable.startDownload();
    this.b.setImageDrawable(localURLDrawable);
    this.b.setAlpha(0);
    super.addView(this.b, localLayoutParams);
    j = (int)((float)bdgk.i() * 0.738F);
    this.a = new URLImageView(paramContext);
    paramContext = new RelativeLayout.LayoutParams(j, i);
    this.a.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    paramContext.addRule(13);
    super.addView(this.a, paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.StolenCountView
 * JD-Core Version:    0.7.0.1
 */