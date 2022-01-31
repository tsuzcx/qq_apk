package com.tencent.biz.subscribe.baseUI;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import xzb;
import xzc;
import xzd;

public abstract class BaseWidgetView<T>
  extends FrameLayout
{
  private int jdField_a_of_type_Int;
  private SparseArray<Long> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private T jdField_a_of_type_JavaLangObject;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<Integer, xzd> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private xzc jdField_a_of_type_Xzc;
  public int b;
  
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
    c(paramContext, d());
  }
  
  private void a(View paramView, xzd paramxzd)
  {
    if (paramView != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramView.getId()), paramxzd);
    }
  }
  
  private void c(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    b(paramContext, paramInt);
    if (a() != 0) {
      LayoutInflater.from(paramContext).inflate(a(), this, true);
    }
    a(paramContext, this);
    if (a() != null) {
      a().setOnClickListener(new xzb(this));
    }
    a(paramContext, paramInt);
  }
  
  protected abstract int a();
  
  public Activity a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public View.OnClickListener a()
  {
    return null;
  }
  
  public View a()
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
  
  public xzc a()
  {
    return this.jdField_a_of_type_Xzc;
  }
  
  public void a() {}
  
  protected void a(Context paramContext, int paramInt) {}
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet) {}
  
  protected abstract void a(Context paramContext, View paramView);
  
  protected abstract void a(T paramT);
  
  public void a(T paramT, int paramInt) {}
  
  public boolean a(View paramView)
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
  
  protected void b(Context paramContext, int paramInt) {}
  
  public void b(View paramView)
  {
    if ((paramView != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId())) != null)) {
      ((xzd)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()))).a();
    }
  }
  
  public int c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.jdField_a_of_type_Int;
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
    this.b = paramInt;
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setHostActivity(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void setInteractor(xzc paramxzc)
  {
    this.jdField_a_of_type_Xzc = paramxzc;
  }
  
  public void setPreClickListener(View paramView, xzd paramxzd)
  {
    a(paramView, paramxzd);
  }
  
  public void setPreClickListener(xzd paramxzd)
  {
    a(a(), paramxzd);
  }
  
  public void setViewType(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.baseUI.BaseWidgetView
 * JD-Core Version:    0.7.0.1
 */