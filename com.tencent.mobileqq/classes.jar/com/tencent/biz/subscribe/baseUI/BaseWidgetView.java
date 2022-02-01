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
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray<Long> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private BaseWidgetView.IInteractor jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$IInteractor;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private T jdField_a_of_type_JavaLangObject;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<Integer, BaseWidgetView.ItemPreClickListener> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected int b;
  
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
    c(paramContext, b());
  }
  
  private void a(View paramView, BaseWidgetView.ItemPreClickListener paramItemPreClickListener)
  {
    if (paramView != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramView.getId()), paramItemPreClickListener);
    }
  }
  
  private void c(Context paramContext, int paramInt)
  {
    this.b = paramInt;
    a(paramContext, paramInt);
    if (a() != 0) {
      LayoutInflater.from(paramContext).inflate(a(), this, true);
    }
    a(paramContext, this);
    if (a() != null) {
      a().setOnClickListener(new BaseWidgetView.1(this));
    }
    b(paramContext, paramInt);
  }
  
  protected abstract int a();
  
  public Activity a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      return (Activity)localWeakReference.get();
    }
    return null;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  protected View.OnClickListener a()
  {
    return null;
  }
  
  protected View a()
  {
    return null;
  }
  
  public ExtraTypeInfo a()
  {
    return this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  }
  
  public T a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a(Context paramContext, int paramInt) {}
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet) {}
  
  protected abstract void a(Context paramContext, View paramView);
  
  protected void a(View paramView)
  {
    if ((paramView != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId())) != null)) {
      ((BaseWidgetView.ItemPreClickListener)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()))).a();
    }
  }
  
  protected abstract void a(T paramT);
  
  public void a(T paramT, int paramInt) {}
  
  protected boolean a(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    long l = System.currentTimeMillis();
    if (l - ((Long)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramView.getId(), Long.valueOf(-1L))).longValue() > 800L)
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramView.getId(), Long.valueOf(l));
      return false;
    }
    return true;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b() {}
  
  protected void b(Context paramContext, int paramInt) {}
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a().removeCallbacksAndMessages(null);
  }
  
  public void setData(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a(paramT);
  }
  
  public void setData(T paramT, int paramInt)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a(paramT, paramInt);
  }
  
  public void setDataPosInList(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setHostActivity(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void setInteractor(BaseWidgetView.IInteractor paramIInteractor)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIBaseWidgetView$IInteractor = paramIInteractor;
  }
  
  public void setPreClickListener(View paramView, BaseWidgetView.ItemPreClickListener paramItemPreClickListener)
  {
    a(paramView, paramItemPreClickListener);
  }
  
  public void setPreClickListener(BaseWidgetView.ItemPreClickListener paramItemPreClickListener)
  {
    a(a(), paramItemPreClickListener);
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