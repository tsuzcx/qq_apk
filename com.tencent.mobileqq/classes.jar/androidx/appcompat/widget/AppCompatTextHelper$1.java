package androidx.appcompat.widget;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat.FontCallback;
import java.lang.ref.WeakReference;

class AppCompatTextHelper$1
  extends ResourcesCompat.FontCallback
{
  AppCompatTextHelper$1(AppCompatTextHelper paramAppCompatTextHelper, int paramInt1, int paramInt2, WeakReference paramWeakReference) {}
  
  public void onFontRetrievalFailed(int paramInt) {}
  
  public void onFontRetrieved(@NonNull Typeface paramTypeface)
  {
    Typeface localTypeface = paramTypeface;
    if (Build.VERSION.SDK_INT >= 28)
    {
      int i = this.val$fontWeight;
      localTypeface = paramTypeface;
      if (i != -1)
      {
        boolean bool;
        if ((this.val$style & 0x2) != 0) {
          bool = true;
        } else {
          bool = false;
        }
        localTypeface = Typeface.create(paramTypeface, i, bool);
      }
    }
    this.this$0.onAsyncTypefaceReceived(this.val$textViewWeak, localTypeface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatTextHelper.1
 * JD-Core Version:    0.7.0.1
 */