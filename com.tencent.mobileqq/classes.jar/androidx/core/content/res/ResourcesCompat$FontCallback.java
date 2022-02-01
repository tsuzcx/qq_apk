package androidx.core.content.res;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public abstract class ResourcesCompat$FontCallback
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public final void callbackFailAsync(int paramInt, @Nullable Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    localHandler.post(new ResourcesCompat.FontCallback.2(this, paramInt));
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public final void callbackSuccessAsync(Typeface paramTypeface, @Nullable Handler paramHandler)
  {
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = new Handler(Looper.getMainLooper());
    }
    localHandler.post(new ResourcesCompat.FontCallback.1(this, paramTypeface));
  }
  
  public abstract void onFontRetrievalFailed(int paramInt);
  
  public abstract void onFontRetrieved(@NonNull Typeface paramTypeface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.content.res.ResourcesCompat.FontCallback
 * JD-Core Version:    0.7.0.1
 */