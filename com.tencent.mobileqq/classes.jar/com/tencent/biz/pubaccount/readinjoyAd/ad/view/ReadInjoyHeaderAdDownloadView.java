package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class ReadInjoyHeaderAdDownloadView
  extends FrameLayout
{
  private int a;
  private int b;
  private int c;
  private ReadInjoyHeaderAdDownloadView.SimpleRoundProgress d;
  private ImageView e;
  private ImageView f;
  private int g;
  
  public ReadInjoyHeaderAdDownloadView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ReadInjoyHeaderAdDownloadView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ReadInjoyHeaderAdDownloadView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.d = new ReadInjoyHeaderAdDownloadView.SimpleRoundProgress(paramContext);
    this.d.b = Color.parseColor("#99FFFFFF");
    this.d.d = Color.parseColor("#FFFFFFFF");
    this.d.c = AIOUtils.b(2.0F, paramContext.getResources());
    this.d.e = AIOUtils.b(2.0F, paramContext.getResources());
    this.d.f = AIOUtils.b(9.0F, paramContext.getResources());
    Object localObject = this.d;
    ((ReadInjoyHeaderAdDownloadView.SimpleRoundProgress)localObject).g = 100;
    ((ReadInjoyHeaderAdDownloadView.SimpleRoundProgress)localObject).i = 270;
    ((ReadInjoyHeaderAdDownloadView.SimpleRoundProgress)localObject).h = 0;
    ((ReadInjoyHeaderAdDownloadView.SimpleRoundProgress)localObject).j = 65;
    localObject = new FrameLayout.LayoutParams(-1, -1);
    addView(this.d, (ViewGroup.LayoutParams)localObject);
    this.e = new ImageView(paramContext);
    this.c = 2130842775;
    this.e.setImageResource(this.c);
    localObject = new FrameLayout.LayoutParams(AIOUtils.b(13.0F, getResources()), AIOUtils.b(16.0F, getResources()));
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    addView(this.e, (ViewGroup.LayoutParams)localObject);
    this.f = new ImageView(paramContext);
    this.b = 2130842777;
    this.f.setImageResource(this.b);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.f, paramContext);
    this.g = 0;
    a(0, 0);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.d.setVisibility(8);
    paramInt1 = this.a;
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1)
      {
        if (paramInt1 != 2)
        {
          if (paramInt1 != 4) {
            return;
          }
          if (getPaddingTop() != 0) {
            setPadding(0, 0, 0, 0);
          }
          this.d.setVisibility(0);
          this.d.setPaused(true);
          this.d.setProgress(paramInt2);
          this.e.setVisibility(8);
          return;
        }
        paramInt1 = getPaddingTop();
        paramInt2 = this.g;
        if (paramInt1 != paramInt2) {
          setPadding(paramInt2, paramInt2, paramInt2, paramInt2);
        }
        this.f.setVisibility(8);
        this.e.setVisibility(8);
        return;
      }
      if (getPaddingTop() != 0) {
        setPadding(0, 0, 0, 0);
      }
      setPadding(0, 0, 0, 0);
      this.d.setVisibility(0);
      this.d.setPaused(false);
      this.d.setProgress(paramInt2);
      this.e.setVisibility(0);
      return;
    }
    paramInt1 = getPaddingTop();
    paramInt2 = this.g;
    if (paramInt1 != paramInt2) {
      setPadding(paramInt2, paramInt2, paramInt2, paramInt2);
    }
    setPadding(0, 0, 0, 0);
    this.e.setVisibility(0);
  }
  
  public int getState()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView
 * JD-Core Version:    0.7.0.1
 */