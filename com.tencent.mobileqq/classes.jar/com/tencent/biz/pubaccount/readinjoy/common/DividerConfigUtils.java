package com.tencent.biz.pubaccount.readinjoy.common;

import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public class DividerConfigUtils
{
  private static final int a = Utils.rp2px(10.0D);
  
  private static int a(TemplateBean paramTemplateBean)
  {
    if (paramTemplateBean == null)
    {
      QLog.i("DividerConfigUtils", 1, "templateBean TYPE_UNKNOWN == null");
      return -1;
    }
    if (paramTemplateBean.findViewById("id_separator_normal_bottom") != null) {
      return 1;
    }
    if (paramTemplateBean.findViewById("id_separator_special_bottom_space") != null) {
      return 2;
    }
    QLog.i("DividerConfigUtils", 1, "getViewType TYPE_UNKNOWN" + paramTemplateBean);
    return -1;
  }
  
  private static int a(ViewBase paramViewBase, boolean paramBoolean)
  {
    if (paramViewBase == null) {
      return 0;
    }
    Layout.Params localParams = paramViewBase.getComLayoutParams();
    int i = localParams.mLayoutHeight;
    if (paramBoolean) {}
    for (localParams.mLayoutHeight = a;; localParams.mLayoutHeight = 0)
    {
      paramViewBase.setComLayoutParams(localParams);
      return localParams.mLayoutHeight - i;
    }
  }
  
  public static boolean a(Container paramContainer, IReadInJoyModel paramIReadInJoyModel)
  {
    int i = 0;
    if ((paramContainer == null) || (paramIReadInJoyModel == null)) {}
    Object localObject;
    int j;
    do
    {
      do
      {
        do
        {
          return false;
          localObject = paramIReadInJoyModel.a();
        } while (localObject == null);
        j = paramIReadInJoyModel.g();
        paramIReadInJoyModel = ((ReadInJoyBaseAdapter)localObject).b(j);
        localObject = ((ReadInJoyBaseAdapter)localObject).b(j + 1);
      } while ((paramIReadInJoyModel == null) || (localObject == null));
      j = a(paramIReadInJoyModel.mProteusTemplateBean);
    } while (j == -1);
    int k = a(((BaseArticleInfo)localObject).mProteusTemplateBean);
    QLog.i("DividerConfigUtils", 1, "topType:" + j + " nextType:" + k);
    if (k < 0) {
      QLog.i("DividerConfigUtils", 1, "nextArticleInfo:" + ((BaseArticleInfo)localObject).mProteusTemplateBean);
    }
    paramIReadInJoyModel = paramContainer.getVirtualView();
    switch (j)
    {
    }
    for (;;)
    {
      localObject = paramIReadInJoyModel.getComLayoutParams();
      if (((Layout.Params)localObject).mLayoutHeight >= 0) {
        ((Layout.Params)localObject).mLayoutHeight = (i + ((Layout.Params)localObject).mLayoutHeight);
      }
      paramIReadInJoyModel = paramIReadInJoyModel.getComLayoutParams();
      paramContainer.setLayoutParams(new RelativeLayout.LayoutParams(paramIReadInJoyModel.mLayoutWidth, paramIReadInJoyModel.mLayoutHeight));
      return true;
      localObject = paramIReadInJoyModel.findViewBaseByName("id_separator_normal_bottom");
      switch (k)
      {
      default: 
        i = b((ViewBase)localObject, true);
        break;
      case 2: 
        i = b((ViewBase)localObject, false);
        continue;
        localObject = paramIReadInJoyModel.findViewBaseByName("id_separator_special_bottom_space");
        switch (k)
        {
        default: 
          i = a((ViewBase)localObject, false);
          break;
        case 2: 
          i = a((ViewBase)localObject, true);
        }
        break;
      }
    }
  }
  
  private static int b(ViewBase paramViewBase, boolean paramBoolean)
  {
    if (paramViewBase == null) {
      return 0;
    }
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      paramViewBase.setVisibility(i);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.DividerConfigUtils
 * JD-Core Version:    0.7.0.1
 */