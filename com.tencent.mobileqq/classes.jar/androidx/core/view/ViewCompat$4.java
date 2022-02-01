package androidx.core.view;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.RequiresApi;

final class ViewCompat$4
  extends ViewCompat.AccessibilityViewProperty<CharSequence>
{
  ViewCompat$4(int paramInt1, Class paramClass, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramClass, paramInt2, paramInt3);
  }
  
  @RequiresApi(28)
  CharSequence frameworkGet(View paramView)
  {
    return paramView.getAccessibilityPaneTitle();
  }
  
  @RequiresApi(28)
  void frameworkSet(View paramView, CharSequence paramCharSequence)
  {
    paramView.setAccessibilityPaneTitle(paramCharSequence);
  }
  
  boolean shouldUpdate(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    return !TextUtils.equals(paramCharSequence1, paramCharSequence2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.ViewCompat.4
 * JD-Core Version:    0.7.0.1
 */