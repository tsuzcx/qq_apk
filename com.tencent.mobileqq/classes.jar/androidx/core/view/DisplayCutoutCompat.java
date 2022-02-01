package androidx.core.view;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import androidx.annotation.RequiresApi;
import java.util.List;

public final class DisplayCutoutCompat
{
  private final Object mDisplayCutout;
  
  public DisplayCutoutCompat(Rect paramRect, List<Rect> paramList)
  {
    this(paramRect);
  }
  
  private DisplayCutoutCompat(Object paramObject)
  {
    this.mDisplayCutout = paramObject;
  }
  
  static DisplayCutoutCompat wrap(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    return new DisplayCutoutCompat(paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (DisplayCutoutCompat)paramObject;
      Object localObject = this.mDisplayCutout;
      if (localObject == null) {
        return paramObject.mDisplayCutout == null;
      }
      return localObject.equals(paramObject.mDisplayCutout);
    }
    return false;
  }
  
  public List<Rect> getBoundingRects()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getBoundingRects();
    }
    return null;
  }
  
  public int getSafeInsetBottom()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetBottom();
    }
    return 0;
  }
  
  public int getSafeInsetLeft()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetLeft();
    }
    return 0;
  }
  
  public int getSafeInsetRight()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetRight();
    }
    return 0;
  }
  
  public int getSafeInsetTop()
  {
    if (Build.VERSION.SDK_INT >= 28) {
      return ((DisplayCutout)this.mDisplayCutout).getSafeInsetTop();
    }
    return 0;
  }
  
  public int hashCode()
  {
    Object localObject = this.mDisplayCutout;
    if (localObject == null) {
      return 0;
    }
    return localObject.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DisplayCutoutCompat{");
    localStringBuilder.append(this.mDisplayCutout);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  @RequiresApi(api=28)
  DisplayCutout unwrap()
  {
    return (DisplayCutout)this.mDisplayCutout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.view.DisplayCutoutCompat
 * JD-Core Version:    0.7.0.1
 */