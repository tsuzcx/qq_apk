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
    if ((paramContainer == null) || (paramTemplateBean2 == null))
    {
      LogUtil.QLog.i(TAG, 1, "[bindDynamicValueWithoutRecursion], container or newTemplateBean is null.");
      return;
    }
    long l1 = System.currentTimeMillis();
    Map localMap1 = paramContainer.getViewIdMapping();
    Map localMap2 = paramTemplateBean2.getViewDataBinding();
    HashSet localHashSet = new HashSet();
    if (paramTemplateBean1 != null) {}
    for (paramTemplateBean1 = paramTemplateBean1.getViewDataBinding();; paramTemplateBean1 = null)
    {
      if ((localHashSet != null) && (localMap1 != null)) {
        localHashSet.addAll(localMap1.keySet());
      }
      Iterator localIterator = localMap2.keySet().iterator();
      label150:
      label425:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        long l2 = System.currentTimeMillis();
        ViewBean localViewBean2 = (ViewBean)localMap2.get(str);
        ViewBean localViewBean1;
        ViewBase localViewBase;
        int i;
        if (paramTemplateBean1 != null)
        {
          localViewBean1 = (ViewBean)paramTemplateBean1.get(str);
          if (localHashSet != null) {
            localHashSet.remove(str);
          }
          localViewBase = (ViewBase)localMap1.get(str);
          if ((str == null) || (localViewBase == null) || (localViewBean2 == null) || ((localViewBean1 != null) && (localViewBean2.valueBean.dynamicValue.equals(localViewBean1.valueBean.dynamicValue)))) {
            break label325;
          }
          i = 1;
          label225:
          if (i == 0) {
            break label330;
          }
          localViewBean2.setVisible(true);
          localViewBase.bindDynamicValue(localViewBean2);
          LogUtil.QLog.d(TAG, 1, "bindDynamicValueWithoutRecursion | [ viewId = " + str + " value changed ] newValue: " + localViewBean2.valueBean.dynamicValue + "; cost " + (System.currentTimeMillis() - l2) + "ms");
        }
        for (;;)
        {
          if (localViewBase == null) {
            break label425;
          }
          localViewBase.setVisibility(0);
          break;
          localViewBean1 = null;
          break label150;
          label325:
          i = 0;
          break label225;
          label330:
          if (localViewBean2 != null)
          {
            LogUtil.QLog.i(TAG, 1, "[bindDynamicValueWithoutRecursion] skip: " + localViewBean2.valueBean.dynamicValue + " viewId = " + str);
            LogUtil.QLog.d(TAG, 2, "bindDynamicValueWithoutRecursion | [ viewId = " + str + " value not changed ] cost " + (System.currentTimeMillis() - l2) + "ms");
          }
        }
      }
      if (localHashSet != null)
      {
        paramTemplateBean1 = localHashSet.iterator();
        while (paramTemplateBean1.hasNext()) {
          ((ViewBase)localMap1.get((String)paramTemplateBean1.next())).setVisibility(8);
        }
      }
      LogUtil.QLog.d(TAG, 2, "bindDynamicValueWithoutRecursion_____ " + paramTemplateBean2.getStyleName() + " cost " + (System.currentTimeMillis() - l1) + "ms");
      paramTemplateBean1 = paramContainer.getVirtualView();
      if (paramTemplateBean1 == null) {
        break;
      }
      paramTemplateBean2 = paramTemplateBean1.getComLayoutParams();
      if (paramTemplateBean2 == null) {
        break;
      }
      paramTemplateBean1 = paramContainer.getLayoutParams();
      if (paramTemplateBean1 == null) {
        paramTemplateBean1 = new ViewGroup.MarginLayoutParams(paramTemplateBean2.mLayoutWidth, paramTemplateBean2.mLayoutHeight);
      }
      for (;;)
      {
        if ((paramTemplateBean1 instanceof ViewGroup.MarginLayoutParams))
        {
          ((ViewGroup.MarginLayoutParams)paramTemplateBean1).leftMargin = paramTemplateBean2.mLayoutMarginLeft;
          ((ViewGroup.MarginLayoutParams)paramTemplateBean1).topMargin = paramTemplateBean2.mLayoutMarginTop;
          ((ViewGroup.MarginLayoutParams)paramTemplateBean1).rightMargin = paramTemplateBean2.mLayoutMarginRight;
          ((ViewGroup.MarginLayoutParams)paramTemplateBean1).bottomMargin = paramTemplateBean2.mLayoutMarginBottom;
        }
        paramContainer.setLayoutParams(paramTemplateBean1);
        return;
        paramTemplateBean1.width = paramTemplateBean2.mLayoutWidth;
        paramTemplateBean1.height = paramTemplateBean2.mLayoutHeight;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.BindDataUtil
 * JD-Core Version:    0.7.0.1
 */