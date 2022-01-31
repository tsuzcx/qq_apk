package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ValueBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
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
    long l1 = System.currentTimeMillis();
    Map localMap1 = paramContainer.getViewIdMapping();
    Map localMap2 = paramTemplateBean2.getViewDataBinding();
    HashSet localHashSet = new HashSet();
    if (paramTemplateBean1 != null) {}
    for (paramContainer = paramTemplateBean1.getViewDataBinding();; paramContainer = null)
    {
      if ((localHashSet != null) && (localMap1 != null)) {
        localHashSet.addAll(localMap1.keySet());
      }
      Iterator localIterator = localMap2.keySet().iterator();
      label131:
      label403:
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        long l2 = System.currentTimeMillis();
        ViewBean localViewBean = (ViewBean)localMap2.get(str);
        ViewBase localViewBase;
        int i;
        if (paramContainer != null)
        {
          paramTemplateBean1 = (ViewBean)paramContainer.get(str);
          if (localHashSet != null) {
            localHashSet.remove(str);
          }
          localViewBase = (ViewBase)localMap1.get(str);
          if ((str == null) || (localViewBase == null) || (localViewBean == null) || ((paramTemplateBean1 != null) && (localViewBean.valueBean.dynamicValue.equals(paramTemplateBean1.valueBean.dynamicValue)))) {
            break label303;
          }
          i = 1;
          label204:
          if (i == 0) {
            break label308;
          }
          localViewBean.setVisible(true);
          localViewBase.bindDynamicValue(localViewBean);
          LogUtil.QLog.d(TAG, 1, "bindDynamicValueWithoutRecursion | [ viewId = " + str + " value changed ] newValue: " + localViewBean.valueBean.dynamicValue + "; cost " + (System.currentTimeMillis() - l2) + "ms");
        }
        for (;;)
        {
          if (localViewBase == null) {
            break label403;
          }
          localViewBase.setVisibility(0);
          break;
          paramTemplateBean1 = null;
          break label131;
          label303:
          i = 0;
          break label204;
          label308:
          if (localViewBean != null)
          {
            LogUtil.QLog.i(TAG, 1, "[bindDynamicValueWithoutRecursion] skip: " + localViewBean.valueBean.dynamicValue + " viewId = " + str);
            LogUtil.QLog.d(TAG, 2, "bindDynamicValueWithoutRecursion | [ viewId = " + str + " value not changed ] cost " + (System.currentTimeMillis() - l2) + "ms");
          }
        }
      }
      if (localHashSet != null)
      {
        paramContainer = localHashSet.iterator();
        while (paramContainer.hasNext()) {
          ((ViewBase)localMap1.get((String)paramContainer.next())).setVisibility(8);
        }
      }
      LogUtil.QLog.d(TAG, 2, "bindDynamicValueWithoutRecursion_____ " + paramTemplateBean2.getStyleName() + " cost " + (System.currentTimeMillis() - l1) + "ms");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.BindDataUtil
 * JD-Core Version:    0.7.0.1
 */