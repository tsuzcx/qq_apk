package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class ContentFrameLayout
  extends FrameLayout
{
  private ContentFrameLayout.OnAttachListener mAttachListener;
  private final Rect mDecorPadding = new Rect();
  private TypedValue mFixedHeightMajor;
  private TypedValue mFixedHeightMinor;
  private TypedValue mFixedWidthMajor;
  private TypedValue mFixedWidthMinor;
  private TypedValue mMinWidthMajor;
  private TypedValue mMinWidthMinor;
  
  public ContentFrameLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContentFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContentFrameLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void dispatchFitSystemWindows(Rect paramRect)
  {
    fitSystemWindows(paramRect);
  }
  
  public TypedValue getFixedHeightMajor()
  {
    if (this.mFixedHeightMajor == null) {
      this.mFixedHeightMajor = new TypedValue();
    }
    return this.mFixedHeightMajor;
  }
  
  public TypedValue getFixedHeightMinor()
  {
    if (this.mFixedHeightMinor == null) {
      this.mFixedHeightMinor = new TypedValue();
    }
    return this.mFixedHeightMinor;
  }
  
  public TypedValue getFixedWidthMajor()
  {
    if (this.mFixedWidthMajor == null) {
      this.mFixedWidthMajor = new TypedValue();
    }
    return this.mFixedWidthMajor;
  }
  
  public TypedValue getFixedWidthMinor()
  {
    if (this.mFixedWidthMinor == null) {
      this.mFixedWidthMinor = new TypedValue();
    }
    return this.mFixedWidthMinor;
  }
  
  public TypedValue getMinWidthMajor()
  {
    if (this.mMinWidthMajor == null) {
      this.mMinWidthMajor = new TypedValue();
    }
    return this.mMinWidthMajor;
  }
  
  public TypedValue getMinWidthMinor()
  {
    if (this.mMinWidthMinor == null) {
      this.mMinWidthMinor = new TypedValue();
    }
    return this.mMinWidthMinor;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ContentFrameLayout.OnAttachListener localOnAttachListener = this.mAttachListener;
    if (localOnAttachListener != null) {
      localOnAttachListener.onAttachedFromWindow();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ContentFrameLayout.OnAttachListener localOnAttachListener = this.mAttachListener;
    if (localOnAttachListener != null) {
      localOnAttachListener.onDetachedFromWindow();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    DisplayMetrics localDisplayMetrics = getContext().getResources().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    int n = 1;
    if (i < j) {
      i = 1;
    } else {
      i = 0;
    }
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    TypedValue localTypedValue;
    float f;
    if (i1 == -2147483648)
    {
      if (i != 0) {
        localTypedValue = this.mFixedWidthMinor;
      } else {
        localTypedValue = this.mFixedWidthMajor;
      }
      if ((localTypedValue != null) && (localTypedValue.type != 0))
      {
        if (localTypedValue.type == 5) {}
        for (f = localTypedValue.getDimension(localDisplayMetrics);; f = localTypedValue.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels))
        {
          j = (int)f;
          break label155;
          if (localTypedValue.type != 6) {
            break;
          }
        }
        j = 0;
        label155:
        if (j > 0)
        {
          k = View.MeasureSpec.makeMeasureSpec(Math.min(j - (this.mDecorPadding.left + this.mDecorPadding.right), View.MeasureSpec.getSize(paramInt1)), 1073741824);
          paramInt1 = 1;
          break label202;
        }
      }
    }
    int k = paramInt1;
    paramInt1 = 0;
    label202:
    j = paramInt2;
    if (m == -2147483648)
    {
      if (i != 0) {
        localTypedValue = this.mFixedHeightMajor;
      } else {
        localTypedValue = this.mFixedHeightMinor;
      }
      j = paramInt2;
      if (localTypedValue != null)
      {
        j = paramInt2;
        if (localTypedValue.type != 0)
        {
          if (localTypedValue.type == 5) {}
          for (f = localTypedValue.getDimension(localDisplayMetrics);; f = localTypedValue.getFraction(localDisplayMetrics.heightPixels, localDisplayMetrics.heightPixels))
          {
            m = (int)f;
            break label309;
            if (localTypedValue.type != 6) {
              break;
            }
          }
          m = 0;
          label309:
          j = paramInt2;
          if (m > 0) {
            j = View.MeasureSpec.makeMeasureSpec(Math.min(m - (this.mDecorPadding.top + this.mDecorPadding.bottom), View.MeasureSpec.getSize(paramInt2)), 1073741824);
          }
        }
      }
    }
    super.onMeasure(k, j);
    m = getMeasuredWidth();
    k = View.MeasureSpec.makeMeasureSpec(m, 1073741824);
    if ((paramInt1 == 0) && (i1 == -2147483648))
    {
      if (i != 0) {
        localTypedValue = this.mMinWidthMinor;
      } else {
        localTypedValue = this.mMinWidthMajor;
      }
      if ((localTypedValue != null) && (localTypedValue.type != 0))
      {
        if (localTypedValue.type == 5) {}
        for (f = localTypedValue.getDimension(localDisplayMetrics);; f = localTypedValue.getFraction(localDisplayMetrics.widthPixels, localDisplayMetrics.widthPixels))
        {
          paramInt1 = (int)f;
          break label472;
          if (localTypedValue.type != 6) {
            break;
          }
        }
        paramInt1 = 0;
        label472:
        paramInt2 = paramInt1;
        if (paramInt1 > 0) {
          paramInt2 = paramInt1 - (this.mDecorPadding.left + this.mDecorPadding.right);
        }
        if (m < paramInt2)
        {
          paramInt2 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
          paramInt1 = n;
          break label520;
        }
      }
    }
    paramInt1 = 0;
    paramInt2 = k;
    label520:
    if (paramInt1 != 0) {
      super.onMeasure(paramInt2, j);
    }
  }
  
  public void setAttachListener(ContentFrameLayout.OnAttachListener paramOnAttachListener)
  {
    this.mAttachListener = paramOnAttachListener;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public void setDecorPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mDecorPadding.set(paramInt1, paramInt2, paramInt3, paramInt4);
    if (ViewCompat.isLaidOut(this)) {
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ContentFrameLayout
 * JD-Core Version:    0.7.0.1
 */