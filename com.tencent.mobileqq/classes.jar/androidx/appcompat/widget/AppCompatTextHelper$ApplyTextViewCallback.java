package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import java.lang.ref.WeakReference;

class AppCompatTextHelper$ApplyTextViewCallback
  extends ResourcesCompat.FontCallback
{
  private final int mFontWeight;
  private final WeakReference<AppCompatTextHelper> mParent;
  private final int mStyle;
  
  AppCompatTextHelper$ApplyTextViewCallback(@NonNull AppCompatTextHelper paramAppCompatTextHelper, int paramInt1, int paramInt2)
  {
    this.mParent = new WeakReference(paramAppCompatTextHelper);
    this.mFontWeight = paramInt1;
    this.mStyle = paramInt2;
  }
  
  public void onFontRetrievalFailed(int paramInt) {}
  
  public void onFontRetrieved(@NonNull Typeface paramTypeface)
  {
    AppCompatTextHelper localAppCompatTextHelper = (AppCompatTextHelper)this.mParent.get();
    if (localAppCompatTextHelper == null) {
      return;
    }
    Typeface localTypeface = paramTypeface;
    if (Build.VERSION.SDK_INT >= 28)
    {
      int i = this.mFontWeight;
      localTypeface = paramTypeface;
      if (i != -1)
      {
        boolean bool;
        if ((this.mStyle & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        }
        localTypeface = Typeface.create(paramTypeface, i, bool);
      }
    }
    localAppCompatTextHelper.runOnUiThread(new AppCompatTextHelper.ApplyTextViewCallback.TypefaceApplyCallback(this, this.mParent, localTypeface));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextHelper.ApplyTextViewCallback
 * JD-Core Version:    0.7.0.1
 */