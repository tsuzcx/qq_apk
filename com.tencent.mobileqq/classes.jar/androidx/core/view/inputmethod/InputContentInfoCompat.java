package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class InputContentInfoCompat
{
  private final InputContentInfoCompat.InputContentInfoCompatImpl mImpl;
  
  public InputContentInfoCompat(@NonNull Uri paramUri1, @NonNull ClipDescription paramClipDescription, @Nullable Uri paramUri2)
  {
    if (Build.VERSION.SDK_INT >= 25)
    {
      this.mImpl = new InputContentInfoCompat.InputContentInfoCompatApi25Impl(paramUri1, paramClipDescription, paramUri2);
      return;
    }
    this.mImpl = new InputContentInfoCompat.InputContentInfoCompatBaseImpl(paramUri1, paramClipDescription, paramUri2);
  }
  
  private InputContentInfoCompat(@NonNull InputContentInfoCompat.InputContentInfoCompatImpl paramInputContentInfoCompatImpl)
  {
    this.mImpl = paramInputContentInfoCompatImpl;
  }
  
  @Nullable
  public static InputContentInfoCompat wrap(@Nullable Object paramObject)
  {
    if (paramObject == null) {}
    while (Build.VERSION.SDK_INT < 25) {
      return null;
    }
    return new InputContentInfoCompat(new InputContentInfoCompat.InputContentInfoCompatApi25Impl(paramObject));
  }
  
  @NonNull
  public Uri getContentUri()
  {
    return this.mImpl.getContentUri();
  }
  
  @NonNull
  public ClipDescription getDescription()
  {
    return this.mImpl.getDescription();
  }
  
  @Nullable
  public Uri getLinkUri()
  {
    return this.mImpl.getLinkUri();
  }
  
  public void releasePermission()
  {
    this.mImpl.releasePermission();
  }
  
  public void requestPermission()
  {
    this.mImpl.requestPermission();
  }
  
  @Nullable
  public Object unwrap()
  {
    return this.mImpl.getInputContentInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.view.inputmethod.InputContentInfoCompat
 * JD-Core Version:    0.7.0.1
 */