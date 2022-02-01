package androidx.core.text;

import androidx.annotation.NonNull;
import java.util.concurrent.FutureTask;

class PrecomputedTextCompat$PrecomputedTextFutureTask
  extends FutureTask<PrecomputedTextCompat>
{
  PrecomputedTextCompat$PrecomputedTextFutureTask(@NonNull PrecomputedTextCompat.Params paramParams, @NonNull CharSequence paramCharSequence)
  {
    super(new PrecomputedTextCompat.PrecomputedTextFutureTask.PrecomputedTextCallback(paramParams, paramCharSequence));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.text.PrecomputedTextCompat.PrecomputedTextFutureTask
 * JD-Core Version:    0.7.0.1
 */