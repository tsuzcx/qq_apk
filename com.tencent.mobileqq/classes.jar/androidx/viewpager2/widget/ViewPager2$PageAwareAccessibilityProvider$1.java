package androidx.viewpager2.widget;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments;

class ViewPager2$PageAwareAccessibilityProvider$1
  implements AccessibilityViewCommand
{
  ViewPager2$PageAwareAccessibilityProvider$1(ViewPager2.PageAwareAccessibilityProvider paramPageAwareAccessibilityProvider) {}
  
  public boolean perform(@NonNull View paramView, @Nullable AccessibilityViewCommand.CommandArguments paramCommandArguments)
  {
    paramView = (ViewPager2)paramView;
    this.this$1.setCurrentItemFromAccessibilityCommand(paramView.getCurrentItem() + 1);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.viewpager2.widget.ViewPager2.PageAwareAccessibilityProvider.1
 * JD-Core Version:    0.7.0.1
 */