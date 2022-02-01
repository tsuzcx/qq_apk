package com.tencent.luggage.ui;

import android.widget.TextView;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/ui/WxaPreviewImageUI$onCreate$3", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "p0", "", "onPageScrolled", "p1", "", "p2", "onPageSelected", "position", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class WxaPreviewImageUI$f
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    TextView localTextView = WxaPreviewImageUI.c(this.a);
    if (localTextView != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt + 1);
      localStringBuilder.append('/');
      Object localObject = WxaPreviewImageUI.a(this.a);
      if (localObject != null) {
        localObject = Integer.valueOf(((ArrayList)localObject).size());
      } else {
        localObject = null;
      }
      localStringBuilder.append(localObject);
      localTextView.setText((CharSequence)localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.WxaPreviewImageUI.f
 * JD-Core Version:    0.7.0.1
 */