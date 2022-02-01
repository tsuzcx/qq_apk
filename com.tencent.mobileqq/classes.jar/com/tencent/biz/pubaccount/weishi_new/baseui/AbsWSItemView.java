package com.tencent.biz.pubaccount.weishi_new.baseui;

import android.content.Context;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.ViewStub;
import com.tencent.biz.pubaccount.weishi_new.drama.holder.controller.AbsWSDramaUIGroup;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class AbsWSItemView<T>
  implements IWSItemView<T>
{
  protected Context a;
  protected View a;
  public T a;
  private final Map<String, AbsWsUIGroup<T>> a;
  
  public AbsWSItemView(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewView = paramView;
    b();
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue()).d();
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue()).b(paramInt);
      }
    }
  }
  
  protected void a(@IdRes int paramInt, AbsWsUIGroup<T> paramAbsWsUIGroup)
  {
    paramAbsWsUIGroup.a((ViewStub)this.jdField_a_of_type_AndroidViewView.findViewById(paramInt));
    this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(paramAbsWsUIGroup.hashCode()), paramAbsWsUIGroup);
  }
  
  public void a(T paramT)
  {
    this.jdField_a_of_type_JavaLangObject = paramT;
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue()).a(paramT);
      }
    }
  }
  
  public void b(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilMap;
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        AbsWsUIGroup localAbsWsUIGroup = (AbsWsUIGroup)((Map.Entry)((Iterator)localObject).next()).getValue();
        if ((localAbsWsUIGroup instanceof AbsWSDramaUIGroup)) {
          ((AbsWSDramaUIGroup)localAbsWsUIGroup).c(paramInt);
        }
      }
    }
  }
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.baseui.AbsWSItemView
 * JD-Core Version:    0.7.0.1
 */