package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyDailyPullToZoomHeaderXListView
  extends ReadInJoyDailyXListView
{
  private ImageView a;
  private int i;
  private int j;
  
  public ReadInJoyDailyPullToZoomHeaderXListView(Context paramContext)
  {
    this(paramContext, null);
    k();
  }
  
  public ReadInJoyDailyPullToZoomHeaderXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    k();
  }
  
  public ReadInJoyDailyPullToZoomHeaderXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    k();
  }
  
  private void k()
  {
    this.i = ((int)(getResources().getDisplayMetrics().density * 200.0F));
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyDailyPullToZoo", 2, String.format("init mMaxOverScrollY=%s", new Object[] { Integer.valueOf(this.i) }));
    }
  }
  
  private void l()
  {
    int k = 0;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    if ((this.a != null) && (this.j > 0))
    {
      m = getScrollY();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyDailyPullToZoo", 2, String.format("updateHeaderImage scrollY=%s", new Object[] { Integer.valueOf(m) }));
      }
      n = this.a.getLeft();
      i1 = this.a.getTop();
      i2 = this.a.getRight();
      i3 = this.a.getBottom();
      if (m < 0) {
        break label108;
      }
    }
    for (;;)
    {
      if (k != i1) {
        this.a.layout(n, k, i2, i3);
      }
      return;
      label108:
      k = m;
    }
  }
  
  public void computeScroll()
  {
    l();
    super.computeScroll();
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ViewGroup localViewGroup;
    if ((this.a != null) && (this.j == 0))
    {
      this.j = this.a.getHeight();
      localViewGroup = (ViewGroup)this.a.getParent();
    }
    for (;;)
    {
      if (localViewGroup != null)
      {
        localViewGroup.setClipChildren(false);
        localViewGroup.setClipToPadding(false);
        if (localViewGroup != this) {}
      }
      else
      {
        return;
      }
      try
      {
        localViewGroup = (ViewGroup)localViewGroup.getParent();
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyDailyPullToZoo", 2, "onLayout setClipChildren fail!", localException);
        }
        Object localObject = null;
      }
    }
  }
  
  public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, this.i, paramBoolean);
  }
  
  public void setHeaderImage(ImageView paramImageView)
  {
    this.a = paramImageView;
    this.j = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDailyPullToZoomHeaderXListView
 * JD-Core Version:    0.7.0.1
 */