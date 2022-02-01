package androidx.appcompat.widget;

import android.text.StaticLayout.Builder;
import android.widget.TextView;

class AppCompatTextViewAutoSizeHelper$Impl
{
  void computeAndSetTextDirection(StaticLayout.Builder paramBuilder, TextView paramTextView) {}
  
  boolean isHorizontallyScrollable(TextView paramTextView)
  {
    return ((Boolean)AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(paramTextView, "getHorizontallyScrolling", Boolean.valueOf(false))).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
 * JD-Core Version:    0.7.0.1
 */