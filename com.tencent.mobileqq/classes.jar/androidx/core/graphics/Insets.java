package androidx.core.graphics;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;

public final class Insets
{
  @NonNull
  public static final Insets NONE = new Insets(0, 0, 0, 0);
  public final int bottom;
  public final int left;
  public final int right;
  public final int top;
  
  private Insets(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.left = paramInt1;
    this.top = paramInt2;
    this.right = paramInt3;
    this.bottom = paramInt4;
  }
  
  @NonNull
  public static Insets of(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramInt3 == 0) && (paramInt4 == 0)) {
      return NONE;
    }
    return new Insets(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @NonNull
  public static Insets of(@NonNull Rect paramRect)
  {
    return of(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
  }
  
  @NonNull
  @RequiresApi(api=29)
  public static Insets toCompatInsets(@NonNull android.graphics.Insets paramInsets)
  {
    return of(paramInsets.left, paramInsets.top, paramInsets.right, paramInsets.bottom);
  }
  
  @Deprecated
  @NonNull
  @RequiresApi(api=29)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static Insets wrap(@NonNull android.graphics.Insets paramInsets)
  {
    return toCompatInsets(paramInsets);
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
      paramObject = (Insets)paramObject;
      if (this.bottom != paramObject.bottom) {
        return false;
      }
      if (this.left != paramObject.left) {
        return false;
      }
      if (this.right != paramObject.right) {
        return false;
      }
      return this.top == paramObject.top;
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((this.left * 31 + this.top) * 31 + this.right) * 31 + this.bottom;
  }
  
  @NonNull
  @RequiresApi(api=29)
  public android.graphics.Insets toPlatformInsets()
  {
    return android.graphics.Insets.of(this.left, this.top, this.right, this.bottom);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Insets{left=");
    localStringBuilder.append(this.left);
    localStringBuilder.append(", top=");
    localStringBuilder.append(this.top);
    localStringBuilder.append(", right=");
    localStringBuilder.append(this.right);
    localStringBuilder.append(", bottom=");
    localStringBuilder.append(this.bottom);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.graphics.Insets
 * JD-Core Version:    0.7.0.1
 */