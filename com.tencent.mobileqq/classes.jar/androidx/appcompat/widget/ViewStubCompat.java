package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R.styleable;
import java.lang.ref.WeakReference;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewStubCompat
  extends View
{
  private ViewStubCompat.OnInflateListener mInflateListener;
  private int mInflatedId;
  private WeakReference<View> mInflatedViewRef;
  private LayoutInflater mInflater;
  private int mLayoutResource = 0;
  
  public ViewStubCompat(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewStubCompat(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewStubCompat, paramInt, 0);
    this.mInflatedId = paramContext.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
    this.mLayoutResource = paramContext.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
    setId(paramContext.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
    paramContext.recycle();
    setVisibility(8);
    setWillNotDraw(true);
  }
  
  protected void dispatchDraw(Canvas paramCanvas) {}
  
  @SuppressLint({"MissingSuperCall"})
  public void draw(Canvas paramCanvas) {}
  
  public int getInflatedId()
  {
    return this.mInflatedId;
  }
  
  public LayoutInflater getLayoutInflater()
  {
    return this.mInflater;
  }
  
  public int getLayoutResource()
  {
    return this.mLayoutResource;
  }
  
  public View inflate()
  {
    Object localObject1 = getParent();
    if ((localObject1 instanceof ViewGroup))
    {
      if (this.mLayoutResource != 0)
      {
        Object localObject2 = (ViewGroup)localObject1;
        localObject1 = this.mInflater;
        if (localObject1 == null) {
          localObject1 = LayoutInflater.from(getContext());
        }
        localObject1 = ((LayoutInflater)localObject1).inflate(this.mLayoutResource, (ViewGroup)localObject2, false);
        int i = this.mInflatedId;
        if (i != -1) {
          ((View)localObject1).setId(i);
        }
        i = ((ViewGroup)localObject2).indexOfChild(this);
        ((ViewGroup)localObject2).removeViewInLayout(this);
        ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
        if (localLayoutParams != null) {
          ((ViewGroup)localObject2).addView((View)localObject1, i, localLayoutParams);
        } else {
          ((ViewGroup)localObject2).addView((View)localObject1, i);
        }
        this.mInflatedViewRef = new WeakReference(localObject1);
        localObject2 = this.mInflateListener;
        if (localObject2 != null) {
          ((ViewStubCompat.OnInflateListener)localObject2).onInflate(this, (View)localObject1);
        }
        return localObject1;
      }
      throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    }
    throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(0, 0);
  }
  
  public void setInflatedId(int paramInt)
  {
    this.mInflatedId = paramInt;
  }
  
  public void setLayoutInflater(LayoutInflater paramLayoutInflater)
  {
    this.mInflater = paramLayoutInflater;
  }
  
  public void setLayoutResource(int paramInt)
  {
    this.mLayoutResource = paramInt;
  }
  
  public void setOnInflateListener(ViewStubCompat.OnInflateListener paramOnInflateListener)
  {
    this.mInflateListener = paramOnInflateListener;
  }
  
  public void setVisibility(int paramInt)
  {
    Object localObject = this.mInflatedViewRef;
    if (localObject != null)
    {
      localObject = (View)((WeakReference)localObject).get();
      if (localObject != null)
      {
        ((View)localObject).setVisibility(paramInt);
        return;
      }
      throw new IllegalStateException("setVisibility called on un-referenced view");
    }
    super.setVisibility(paramInt);
    if ((paramInt == 0) || (paramInt == 4)) {
      inflate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ViewStubCompat
 * JD-Core Version:    0.7.0.1
 */