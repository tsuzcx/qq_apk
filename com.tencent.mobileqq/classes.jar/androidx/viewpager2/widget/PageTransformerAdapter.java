package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Locale;

final class PageTransformerAdapter
  extends ViewPager2.OnPageChangeCallback
{
  private final LinearLayoutManager mLayoutManager;
  private ViewPager2.PageTransformer mPageTransformer;
  
  PageTransformerAdapter(LinearLayoutManager paramLinearLayoutManager)
  {
    this.mLayoutManager = paramLinearLayoutManager;
  }
  
  ViewPager2.PageTransformer getPageTransformer()
  {
    return this.mPageTransformer;
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.mPageTransformer == null) {
      return;
    }
    paramFloat = -paramFloat;
    paramInt2 = 0;
    while (paramInt2 < this.mLayoutManager.getChildCount())
    {
      View localView = this.mLayoutManager.getChildAt(paramInt2);
      if (localView != null)
      {
        float f = this.mLayoutManager.getPosition(localView) - paramInt1;
        this.mPageTransformer.transformPage(localView, f + paramFloat);
        paramInt2 += 1;
      }
      else
      {
        throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(this.mLayoutManager.getChildCount()) }));
      }
    }
  }
  
  public void onPageSelected(int paramInt) {}
  
  void setPageTransformer(@Nullable ViewPager2.PageTransformer paramPageTransformer)
  {
    this.mPageTransformer = paramPageTransformer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.widget.PageTransformerAdapter
 * JD-Core Version:    0.7.0.1
 */