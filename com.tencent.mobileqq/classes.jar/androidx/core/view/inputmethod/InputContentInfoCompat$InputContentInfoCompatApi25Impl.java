package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(25)
final class InputContentInfoCompat$InputContentInfoCompatApi25Impl
  implements InputContentInfoCompat.InputContentInfoCompatImpl
{
  @NonNull
  final InputContentInfo mObject;
  
  InputContentInfoCompat$InputContentInfoCompatApi25Impl(@NonNull Uri paramUri1, @NonNull ClipDescription paramClipDescription, @Nullable Uri paramUri2)
  {
    this.mObject = new InputContentInfo(paramUri1, paramClipDescription, paramUri2);
  }
  
  InputContentInfoCompat$InputContentInfoCompatApi25Impl(@NonNull Object paramObject)
  {
    this.mObject = ((InputContentInfo)paramObject);
  }
  
  @NonNull
  public Uri getContentUri()
  {
    return this.mObject.getContentUri();
  }
  
  @NonNull
  public ClipDescription getDescription()
  {
    return this.mObject.getDescription();
  }
  
  @Nullable
  public Object getInputContentInfo()
  {
    return this.mObject;
  }
  
  @Nullable
  public Uri getLinkUri()
  {
    return this.mObject.getLinkUri();
  }
  
  public void releasePermission()
  {
    this.mObject.releasePermission();
  }
  
  public void requestPermission()
  {
    this.mObject.requestPermission();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.inputmethod.InputContentInfoCompat.InputContentInfoCompatApi25Impl
 * JD-Core Version:    0.7.0.1
 */