package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.FrameLayout.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeLinearLayout.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeRelativeLayout.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.BoringView.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.NativeImage.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText.Builder;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ViewFactory
{
  private HashMap a = new HashMap();
  
  public ViewFactory()
  {
    a("LinearLayout", new LinearLayout.Builder());
    a("UILabel", new NativeText.Builder());
    a("ReadInjoyAsynImageView", new NativeImage.Builder());
    a("UIImageView", new NativeImage.Builder());
    a("UIView", new BoringView.Builder());
    a("RelativeLayout", new RelativeLayout.Builder());
    a("FrameLayout", new FrameLayout.Builder());
    a("FrameLayout", new FrameLayout.Builder());
    a("UIButton", new NativeButton.Builder());
    a("NativeLinearLayout", new NativeLinearLayout.Builder());
    a("NativeRelativeLayout", new NativeRelativeLayout.Builder());
  }
  
  private ViewBase.IBuilder a(String paramString)
  {
    return (ViewBase.IBuilder)this.a.get(paramString);
  }
  
  private ViewBase a(VafContext paramVafContext, ViewBase paramViewBase, ViewBean paramViewBean)
  {
    ViewBase localViewBase = a(paramVafContext, paramViewBean.b);
    if (localViewBase != null)
    {
      localViewBase.b(paramViewBean.jdField_a_of_type_JavaLangString);
      if (paramViewBase != null) {}
      for (paramViewBase = ((Layout)paramViewBase).a();; paramViewBase = new Layout.Params())
      {
        localViewBase.a(paramViewBase);
        localViewBase.a(paramViewBean);
        if ((paramViewBean.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean == null) || (!(localViewBase instanceof Layout))) {
          break;
        }
        paramViewBase = paramViewBean.jdField_a_of_type_ArrayOfComTencentBizPubaccountReadinjoyViewProteusBeanViewBean;
        int j = paramViewBase.length;
        int i = 0;
        while (i < j)
        {
          paramViewBean = a(paramVafContext, localViewBase, paramViewBase[i]);
          ((Layout)localViewBase).a(paramViewBean);
          i += 1;
        }
      }
    }
    return localViewBase;
  }
  
  @Nullable
  private ViewBase a(VafContext paramVafContext, String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.a(paramVafContext);
    }
    return null;
  }
  
  public static void a(ViewBase paramViewBase, ViewFactory.FoundClickableViewListener paramFoundClickableViewListener)
  {
    if (paramViewBase == null) {}
    for (;;)
    {
      return;
      if (paramViewBase.b()) {
        paramFoundClickableViewListener.a(paramViewBase);
      }
      if ((paramViewBase instanceof Layout))
      {
        paramViewBase = ((Layout)paramViewBase).a();
        if (paramViewBase != null)
        {
          paramViewBase = paramViewBase.iterator();
          while (paramViewBase.hasNext()) {
            a((ViewBase)paramViewBase.next(), paramFoundClickableViewListener);
          }
        }
      }
    }
  }
  
  public Container a(VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    if (paramTemplateBean == null) {
      return null;
    }
    paramTemplateBean = a(paramVafContext, null, paramTemplateBean.a());
    if (paramTemplateBean != null)
    {
      paramVafContext = new Container(paramVafContext.a());
      paramVafContext.setVirtualView(paramTemplateBean);
      paramVafContext.a();
      return paramVafContext;
    }
    QLog.d("ViewFactory", 2, "inflate: fail to inflate, vb is null");
    return null;
  }
  
  public void a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    Utils.a(paramContext.density, paramContext.widthPixels);
  }
  
  public void a(String paramString, ViewBase.IBuilder paramIBuilder)
  {
    this.a.put(paramString, paramIBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory
 * JD-Core Version:    0.7.0.1
 */