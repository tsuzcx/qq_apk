package androidx.appcompat.widget;

import android.text.StaticLayout.Builder;
import android.widget.TextView;
import androidx.annotation.RequiresApi;

@RequiresApi(29)
class AppCompatTextViewAutoSizeHelper$Impl29
  extends AppCompatTextViewAutoSizeHelper.Impl23
{
  void computeAndSetTextDirection(StaticLayout.Builder paramBuilder, TextView paramTextView)
  {
    paramBuilder.setTextDirection(paramTextView.getTextDirectionHeuristic());
  }
  
  boolean isHorizontallyScrollable(TextView paramTextView)
  {
    return paramTextView.isHorizontallyScrollable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl29
 * JD-Core Version:    0.7.0.1
 */