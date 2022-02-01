package com.tencent.biz.subscribe.baseUI;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.subscribe.part.ExtraInfoInterface;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public abstract class BaseWidgetView<T>
  extends FrameLayout
  implements ExtraInfoInterface
{
  protected int a;
  protected int b;
  private SparseArray<Long> c = new SparseArray();
  private HashMap<Integer, BaseWidgetView.ItemPreClickListener> d = new HashMap();
  private T e;
  private WeakReference<Activity> f;
  private ExtraTypeInfo g;
  private BaseWidgetView.IInteractor h;
  private Handler i;
  
  public BaseWidgetView(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public BaseWidgetView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    c(paramContext, paramInt);
  }
  
  public BaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
    c(paramContext, getViewType());
  }
  
  private void a(View paramView, BaseWidgetView.ItemPreClickListener paramItemPreClickListener)
  {
    if (paramView != null) {
      this.d.put(Integer.valueOf(paramView.getId()), paramItemPreClickListener);
    }
  }
  
  private void c(Context paramContext, int paramInt)
  {
    this.b = paramInt;
    a(paramContext, paramInt);
    if (getLayoutId() != 0) {
      LayoutInflater.from(paramContext).inflate(getLayoutId(), this, true);
    }
    a(paramContext, this);
    if (f() != null) {
      f().setOnClickListener(new BaseWidgetView.1(this));
    }
    b(paramContext, paramInt);
  }
  
  protected void a(Context paramContext, int paramInt) {}
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet) {}
  
  protected abstract void a(Context paramContext, View paramView);
  
  protected abstract void a(T paramT);
  
  public void a(T paramT, int paramInt) {}
  
  protected boolean a(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    long l = System.currentTimeMillis();
    if (l - ((Long)this.c.get(paramView.getId(), Long.valueOf(-1L))).longValue() > 800L)
    {
      this.c.put(paramView.getId(), Long.valueOf(l));
      return false;
    }
    return true;
  }
  
  protected void b(Context paramContext, int paramInt) {}
  
  protected void b(View paramView)
  {
    if ((paramView != null) && (this.d.get(Integer.valueOf(paramView.getId())) != null)) {
      ((BaseWidgetView.ItemPreClickListener)this.d.get(Integer.valueOf(paramView.getId()))).a();
    }
  }
  
  protected View f()
  {
    return null;
  }
  
  public void g() {}
  
  public T getData()
  {
    return this.e;
  }
  
  public int getDataPosInList()
  {
    return this.a;
  }
  
  public ExtraTypeInfo getExtraTypeInfo()
  {
    return this.g;
  }
  
  public Activity getHostActivity()
  {
    WeakReference localWeakReference = this.f;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  public BaseWidgetView.IInteractor getInteractor()
  {
    return this.h;
  }
  
  protected abstract int getLayoutId();
  
  public Handler getMainHandler()
  {
    if (this.i == null) {
      this.i = new Handler(Looper.getMainLooper());
    }
    return this.i;
  }
  
  protected View.OnClickListener getOnClickLister()
  {
    return null;
  }
  
  public int getViewType()
  {
    return this.b;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    getMainHandler().removeCallbacksAndMessages(null);
  }
  
  public void setData(T paramT)
  {
    this.e = paramT;
    a(paramT);
  }
  
  public void setData(T paramT, int paramInt)
  {
    this.e = paramT;
    a(paramT, paramInt);
  }
  
  public void setDataPosInList(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.g = paramExtraTypeInfo;
  }
  
  public void setHostActivity(Activity paramActivity)
  {
    this.f = new WeakReference(paramActivity);
  }
  
  public void setInteractor(BaseWidgetView.IInteractor paramIInteractor)
  {
    this.h = paramIInteractor;
  }
  
  public void setPreClickListener(View paramView, BaseWidgetView.ItemPreClickListener paramItemPreClickListener)
  {
    a(paramView, paramItemPreClickListener);
  }
  
  public void setPreClickListener(BaseWidgetView.ItemPreClickListener paramItemPreClickListener)
  {
    a(f(), paramItemPreClickListener);
  }
  
  public void setViewType(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.baseUI.BaseWidgetView
 * JD-Core Version:    0.7.0.1
 */