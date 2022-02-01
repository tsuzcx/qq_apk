package com.tencent.biz.subscribe.baseUI;

import aafy;
import aafz;
import aaga;
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

public abstract class BaseWidgetView<T>
  extends FrameLayout
{
  private aafz jdField_a_of_type_Aafz;
  private SparseArray<Long> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private T jdField_a_of_type_JavaLangObject;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<Integer, aaga> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public int c;
  protected int d;
  
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
    c(paramContext, c());
  }
  
  private void a(View paramView, aaga paramaaga)
  {
    if (paramView != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramView.getId()), paramaaga);
    }
  }
  
  private void c(Context paramContext, int paramInt)
  {
    this.d = paramInt;
    a(paramContext, paramInt);
    if (a() != 0) {
      LayoutInflater.from(paramContext).inflate(a(), this, true);
    }
    a(paramContext, this);
    if (b() != null) {
      b().setOnClickListener(new aafy(this));
    }
    b(paramContext, paramInt);
  }
  
  protected abstract int a();
  
  public aafz a()
  {
    return this.jdField_a_of_type_Aafz;
  }
  
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
  
  public View b()
  {
    return null;
  }
  
  public void b() {}
  
  protected void b(Context paramContext, int paramInt) {}
  
  public void b(View paramView)
  {
    if ((paramView != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId())) != null)) {
      ((aaga)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()))).a();
    }
  }
  
  public int c()
  {
    return this.d;
  }
  
  public int f()
  {
    return this.c;
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
    this.c = paramInt;
  }
  
  public void setExtraTypeInfo(ExtraTypeInfo paramExtraTypeInfo)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = paramExtraTypeInfo;
  }
  
  public void setHostActivity(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
  }
  
  public void setInteractor(aafz paramaafz)
  {
    this.jdField_a_of_type_Aafz = paramaafz;
  }
  
  public void setPreClickListener(aaga paramaaga)
  {
    a(b(), paramaaga);
  }
  
  public void setPreClickListener(View paramView, aaga paramaaga)
  {
    a(paramView, paramaaga);
  }
  
  public void setViewType(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.baseUI.BaseWidgetView
 * JD-Core Version:    0.7.0.1
 */