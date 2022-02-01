package androidx.core.text;

import androidx.annotation.NonNull;
import java.util.concurrent.Callable;

class PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback
  implements Callable<PrecomputedTextCompat>
{
  private PrecomputedTextCompat.Params mParams;
  private CharSequence mText;
  
  PrecomputedTextCompat$PrecomputedTextFutureTask$PrecomputedTextCallback(@NonNull PrecomputedTextCompat.Params paramParams, @NonNull CharSequence paramCharSequence)
  {
    this.mParams = paramParams;
    this.mText = paramCharSequence;
  }
  
  public PrecomputedTextCompat call()
  {
    return PrecomputedTextCompat.create(this.mText, this.mParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.text.PrecomputedTextCompat.PrecomputedTextFutureTask.PrecomputedTextCallback
 * JD-Core Version:    0.7.0.1
 */