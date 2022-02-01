package androidx.core.view;

import android.view.View;
import androidx.annotation.RequiresApi;

class ViewCompat$5
  extends ViewCompat.AccessibilityViewProperty<Boolean>
{
  ViewCompat$5(int paramInt1, Class paramClass, int paramInt2)
  {
    super(paramInt1, paramClass, paramInt2);
  }
  
  @RequiresApi(28)
  Boolean frameworkGet(View paramView)
  {
    return Boolean.valueOf(paramView.isAccessibilityHeading());
  }
  
  @RequiresApi(28)
  void frameworkSet(View paramView, Boolean paramBoolean)
  {
    paramView.setAccessibilityHeading(paramBoolean.booleanValue());
  }
  
  boolean shouldUpdate(Boolean paramBoolean1, Boolean paramBoolean2)
  {
    return booleanNullToFalseEquals(paramBoolean1, paramBoolean2) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.ViewCompat.5
 * JD-Core Version:    0.7.0.1
 */