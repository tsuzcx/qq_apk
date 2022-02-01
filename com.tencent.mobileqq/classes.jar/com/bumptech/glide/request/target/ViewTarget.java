package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Preconditions;

public abstract class ViewTarget<T extends View, Z>
  extends BaseTarget<Z>
{
  private static boolean b;
  @Nullable
  private static Integer c;
  protected final T a;
  private final ViewTarget.SizeDeterminer d;
  @Nullable
  private View.OnAttachStateChangeListener e;
  private boolean f;
  private boolean g;
  
  public ViewTarget(@NonNull T paramT)
  {
    this.a = ((View)Preconditions.a(paramT));
    this.d = new ViewTarget.SizeDeterminer(paramT);
  }
  
  private void a(@Nullable Object paramObject)
  {
    Integer localInteger = c;
    if (localInteger == null)
    {
      b = true;
      this.a.setTag(paramObject);
      return;
    }
    this.a.setTag(localInteger.intValue(), paramObject);
  }
  
  private void i()
  {
    View.OnAttachStateChangeListener localOnAttachStateChangeListener = this.e;
    if (localOnAttachStateChangeListener != null)
    {
      if (this.g) {
        return;
      }
      this.a.addOnAttachStateChangeListener(localOnAttachStateChangeListener);
      this.g = true;
    }
  }
  
  private void j()
  {
    View.OnAttachStateChangeListener localOnAttachStateChangeListener = this.e;
    if (localOnAttachStateChangeListener != null)
    {
      if (!this.g) {
        return;
      }
      this.a.removeOnAttachStateChangeListener(localOnAttachStateChangeListener);
      this.g = false;
    }
  }
  
  @Nullable
  private Object k()
  {
    Integer localInteger = c;
    if (localInteger == null) {
      return this.a.getTag();
    }
    return this.a.getTag(localInteger.intValue());
  }
  
  @Nullable
  public Request a()
  {
    Object localObject = k();
    if (localObject != null)
    {
      if ((localObject instanceof Request)) {
        return (Request)localObject;
      }
      throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }
    return null;
  }
  
  @CallSuper
  public void a(@Nullable Drawable paramDrawable)
  {
    super.a(paramDrawable);
    this.d.b();
    if (!this.f) {
      j();
    }
  }
  
  public void a(@Nullable Request paramRequest)
  {
    a(paramRequest);
  }
  
  @CallSuper
  public void a(@NonNull SizeReadyCallback paramSizeReadyCallback)
  {
    this.d.a(paramSizeReadyCallback);
  }
  
  @CallSuper
  public void b(@Nullable Drawable paramDrawable)
  {
    super.b(paramDrawable);
    i();
  }
  
  @CallSuper
  public void b(@NonNull SizeReadyCallback paramSizeReadyCallback)
  {
    this.d.b(paramSizeReadyCallback);
  }
  
  void f()
  {
    Request localRequest = a();
    if ((localRequest != null) && (localRequest.d())) {
      localRequest.a();
    }
  }
  
  void g()
  {
    Request localRequest = a();
    if ((localRequest != null) && (!localRequest.h()) && (!localRequest.d()))
    {
      this.f = true;
      localRequest.b();
      this.f = false;
    }
  }
  
  @NonNull
  public T h()
  {
    return this.a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Target for: ");
    localStringBuilder.append(this.a);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.target.ViewTarget
 * JD-Core Version:    0.7.0.1
 */