package androidx.appcompat.widget;

import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.widget.TextView;
import androidx.annotation.RequiresApi;

@RequiresApi(23)
class AppCompatTextViewAutoSizeHelper$Impl23
  extends AppCompatTextViewAutoSizeHelper.Impl
{
  void computeAndSetTextDirection(StaticLayout.Builder paramBuilder, TextView paramTextView)
  {
    paramBuilder.setTextDirection((TextDirectionHeuristic)AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(paramTextView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23
 * JD-Core Version:    0.7.0.1
 */