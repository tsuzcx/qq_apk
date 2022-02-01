package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BindDataUtil
{
  private static String TAG = "BindDataUtil";
  
  public static void bindDynamicValueWithoutRecursion(Container paramContainer, TemplateBean paramTemplateBean1, TemplateBean paramTemplateBean2)
  {
    if ((paramContainer != null) && (paramTemplateBean2 != null))
    {
      long l1 = System.currentTimeMillis();
      Map localMap = paramContainer.getViewIdMapping();
      Object localObject1 = paramTemplateBean2.getViewDataBinding();
      HashSet localHashSet = new HashSet();
      if (paramTemplateBean1 != null) {
        paramTemplateBean1 = paramTemplateBean1.getViewDataBinding();
      } else {
        paramTemplateBean1 = null;
      }
      if (localMap != null) {
        localHashSet.addAll(localMap.keySet());
      }
      Iterator localIterator = ((Map)localObject1).keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        long l2 = System.currentTimeMillis();
        Object localObject3 = (ViewBean)((Map)localObject1).get(str);
        Object localObject2;
        if (paramTemplateBean1 != null) {
          localObject2 = (ViewBean)paramTemplateBean1.get(str);
        } else {
          localObject2 = null;
        }
        localHashSet.remove(str);
        ViewBase localViewBase = (ViewBase)localMap.get(str);
        int i;
        if ((str != null) && (localViewBase != null) && (localObject3 != null) && ((localObject2 == null) || (!((ViewBean)localObject3).valueBean.dynamicValue.equals(((ViewBean)localObject2).valueBean.dynamicValue)))) {
          i = 1;
        } else {
          i = 0;
        }
        StringBuilder localStringBuilder;
        if (i != 0)
        {
          ((ViewBean)localObject3).setVisible(true);
          localViewBase.bindDynamicValue((ViewBean)localObject3);
          localObject2 = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("bindDynamicValueWithoutRecursion | [ viewId = ");
          localStringBuilder.append(str);
          localStringBuilder.append(" value changed ] newValue: ");
          localStringBuilder.append(((ViewBean)localObject3).valueBean.dynamicValue);
          localStringBuilder.append("; cost ");
          localStringBuilder.append(System.currentTimeMillis() - l2);
          localStringBuilder.append("ms");
          LogUtil.QLog.d((String)localObject2, 1, localStringBuilder.toString());
        }
        else if (localObject3 != null)
        {
          localObject2 = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[bindDynamicValueWithoutRecursion] skip: ");
          localStringBuilder.append(((ViewBean)localObject3).valueBean.dynamicValue);
          localStringBuilder.append(" viewId = ");
          localStringBuilder.append(str);
          LogUtil.QLog.i((String)localObject2, 1, localStringBuilder.toString());
          localObject2 = TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("bindDynamicValueWithoutRecursion | [ viewId = ");
          ((StringBuilder)localObject3).append(str);
          ((StringBuilder)localObject3).append(" value not changed ] cost ");
          ((StringBuilder)localObject3).append(System.currentTimeMillis() - l2);
          ((StringBuilder)localObject3).append("ms");
          LogUtil.QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        if (localViewBase != null) {
          localViewBase.setVisibility(0);
        }
      }
      paramTemplateBean1 = localHashSet.iterator();
      while (paramTemplateBean1.hasNext()) {
        ((ViewBase)localMap.get((String)paramTemplateBean1.next())).setVisibility(8);
      }
      paramTemplateBean1 = TAG;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bindDynamicValueWithoutRecursion_____ ");
      ((StringBuilder)localObject1).append(paramTemplateBean2.getStyleName());
      ((StringBuilder)localObject1).append(" cost ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis() - l1);
      ((StringBuilder)localObject1).append("ms");
      LogUtil.QLog.d(paramTemplateBean1, 2, ((StringBuilder)localObject1).toString());
      paramTemplateBean1 = paramContainer.getVirtualView();
      if (paramTemplateBean1 == null) {
        return;
      }
      paramTemplateBean2 = paramTemplateBean1.getComLayoutParams();
      if (paramTemplateBean2 == null) {
        return;
      }
      paramTemplateBean1 = paramContainer.getLayoutParams();
      if (paramTemplateBean1 == null)
      {
        paramTemplateBean1 = new ViewGroup.MarginLayoutParams(paramTemplateBean2.mLayoutWidth, paramTemplateBean2.mLayoutHeight);
      }
      else
      {
        paramTemplateBean1.width = paramTemplateBean2.mLayoutWidth;
        paramTemplateBean1.height = paramTemplateBean2.mLayoutHeight;
      }
      if ((paramTemplateBean1 instanceof ViewGroup.MarginLayoutParams))
      {
        localObject1 = (ViewGroup.MarginLayoutParams)paramTemplateBean1;
        ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = paramTemplateBean2.mLayoutMarginLeft;
        ((ViewGroup.MarginLayoutParams)localObject1).topMargin = paramTemplateBean2.mLayoutMarginTop;
        ((ViewGroup.MarginLayoutParams)localObject1).rightMargin = paramTemplateBean2.mLayoutMarginRight;
        ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = paramTemplateBean2.mLayoutMarginBottom;
      }
      paramContainer.setLayoutParams(paramTemplateBean1);
      return;
    }
    LogUtil.QLog.i(TAG, 1, "[bindDynamicValueWithoutRecursion], container or newTemplateBean is null.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.BindDataUtil
 * JD-Core Version:    0.7.0.1
 */