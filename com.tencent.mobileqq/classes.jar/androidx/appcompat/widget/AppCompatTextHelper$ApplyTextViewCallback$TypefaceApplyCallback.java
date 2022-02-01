package androidx.appcompat.widget;

import android.graphics.Typeface;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;

class AppCompatTextHelper$ApplyTextViewCallback$TypefaceApplyCallback
  implements Runnable
{
  private final WeakReference<AppCompatTextHelper> mParent;
  private final Typeface mTypeface;
  
  AppCompatTextHelper$ApplyTextViewCallback$TypefaceApplyCallback(WeakReference<AppCompatTextHelper> paramWeakReference, @NonNull Typeface paramTypeface)
  {
    this.mParent = paramTypeface;
    Object localObject;
    this.mTypeface = localObject;
  }
  
  public void run()
  {
    AppCompatTextHelper localAppCompatTextHelper = (AppCompatTextHelper)this.mParent.get();
    if (localAppCompatTextHelper == null) {
      return;
    }
    localAppCompatTextHelper.setTypefaceByCallback(this.mTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextHelper.ApplyTextViewCallback.TypefaceApplyCallback
 * JD-Core Version:    0.7.0.1
 */