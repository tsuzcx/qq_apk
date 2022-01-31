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
import wkm;
import wkn;

public abstract class BaseWidgetView<T>
  extends FrameLayout
{
  public int a;
  private SparseArray<Long> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private T jdField_a_of_type_JavaLangObject;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private HashMap<Integer, wkn> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private int b;
  
  public BaseWidgetView(@NonNull Context paramContext)
  {
    this(paramContext, 0);
  }
  
  public BaseWidgetView(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext);
    a(paramContext, paramInt);
  }
  
  public BaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseWidgetView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
    a(paramContext, b());
  }
  
  private void a(Context paramContext, int paramInt)
  {
    this.b = paramInt;
    if (a() != 0)
    {
      View localView = LayoutInflater.from(paramContext).inflate(a(), this, false);
      addView(localView);
      a(paramContext, localView);
    }
    for (;;)
    {
      if (a() != null) {
        a().setOnClickListener(new wkm(this));
      }
      return;
      a(paramContext, this);
    }
  }
  
  private void a(View paramView, wkn paramwkn)
  {
    if (paramView != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramView.getId()), paramwkn);
    }
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
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet) {}
  
  protected abstract void a(Context paramContext, View paramView);
  
  protected abstract void a(T paramT);
  
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
  
  public int b()
  {
    return this.b;
  }
  
  public void b(View paramView)
  {
    if ((paramView != null) && (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId())) != null)) {
      ((wkn)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()))).a();
    }
  }
  
  public void setData(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    a(paramT);
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
  
  public void setPreClickListener(View paramView, wkn paramwkn)
  {
    a(paramView, paramwkn);
  }
  
  public void setPreClickListener(wkn paramwkn)
  {
    a(a(), paramwkn);
  }
  
  public void setViewType(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.baseUI.BaseWidgetView
 * JD-Core Version:    0.7.0.1
 */