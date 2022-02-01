package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.core.util.Preconditions;
import androidx.recyclerview.widget.RecyclerView;

public final class MarginPageTransformer
  implements ViewPager2.PageTransformer
{
  private final int mMarginPx;
  
  public MarginPageTransformer(@Px int paramInt)
  {
    Preconditions.checkArgumentNonnegative(paramInt, "Margin must be non-negative");
    this.mMarginPx = paramInt;
  }
  
  private ViewPager2 requireViewPager(@NonNull View paramView)
  {
    paramView = paramView.getParent();
    ViewParent localViewParent = paramView.getParent();
    if (((paramView instanceof RecyclerView)) && ((localViewParent instanceof ViewPager2))) {
      return (ViewPager2)localViewParent;
    }
    throw new IllegalStateException("Expected the page view to be managed by a ViewPager2 instance.");
  }
  
  public void transformPage(@NonNull View paramView, float paramFloat)
  {
    ViewPager2 localViewPager2 = requireViewPager(paramView);
    float f = this.mMarginPx * paramFloat;
    if (localViewPager2.getOrientation() == 0)
    {
      paramFloat = f;
      if (localViewPager2.isRtl()) {
        paramFloat = -f;
      }
      paramView.setTranslationX(paramFloat);
      return;
    }
    paramView.setTranslationY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.viewpager2.widget.MarginPageTransformer
 * JD-Core Version:    0.7.0.1
 */