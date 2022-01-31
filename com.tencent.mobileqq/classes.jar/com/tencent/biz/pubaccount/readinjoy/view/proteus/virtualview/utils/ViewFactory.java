package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.ViewBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.LinearLayout.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.RelativeLayout.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeLinearLayout.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.layout.helper.nativelayout.NativeRelativeLayout.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.BoringView.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.button.NativeButton.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.NativeImage.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText.Builder;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.RichNativeText.Builder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ViewFactory
{
  private static final ViewBase.IBuilder NORMAL_BUILDER = new BoringView.Builder();
  private static final String TAG = "ViewFactory";
  private static boolean isShowViewIdInDesc = false;
  private HashMap<String, ViewBase.IBuilder> mBuilders = new HashMap();
  
  public ViewFactory()
  {
    registerViewBuilder("LinearLayout", new LinearLayout.Builder());
    registerViewBuilder("UILabel", new NativeText.Builder());
    registerViewBuilder("ReadInjoyAsynImageView", new NativeImage.Builder());
    registerViewBuilder("UIImageView", new NativeImage.Builder());
    registerViewBuilder("ReadInjoyAsynImageIcon", new NativeImage.Builder());
    registerViewBuilder("UIView", new BoringView.Builder());
    registerViewBuilder("RelativeLayout", new RelativeLayout.Builder());
    registerViewBuilder("UIButton", new NativeButton.Builder());
    registerViewBuilder("NativeLinearLayout", new NativeLinearLayout.Builder());
    registerViewBuilder("NativeRelativeLayout", new NativeRelativeLayout.Builder());
    registerViewBuilder("PTSRichTextView", new RichNativeText.Builder());
  }
  
  private ViewBase createView(VafContext paramVafContext, String paramString)
  {
    paramString = getViewBuilder(paramString);
    if (paramString != null) {
      return paramString.build(paramVafContext);
    }
    return NORMAL_BUILDER.build(paramVafContext);
  }
  
  public static void findClickableViewListener(ViewBase paramViewBase, ViewFactory.FoundClickableViewListener paramFoundClickableViewListener)
  {
    if (paramViewBase == null) {}
    for (;;)
    {
      return;
      if (paramViewBase.getClickEvnet() != null) {
        paramFoundClickableViewListener.onFound(paramViewBase);
      }
      if ((paramViewBase instanceof Layout))
      {
        paramViewBase = ((Layout)paramViewBase).getSubViews();
        if (paramViewBase != null)
        {
          paramViewBase = paramViewBase.iterator();
          while (paramViewBase.hasNext()) {
            findClickableViewListener((ViewBase)paramViewBase.next(), paramFoundClickableViewListener);
          }
        }
      }
    }
  }
  
  private ViewBase.IBuilder getViewBuilder(String paramString)
  {
    return (ViewBase.IBuilder)this.mBuilders.get(paramString);
  }
  
  public static void setIsShowViewIdInDesc(boolean paramBoolean)
  {
    isShowViewIdInDesc = paramBoolean;
  }
  
  ViewBase constructViewBaseTree(VafContext paramVafContext, ViewBase paramViewBase, ViewBean paramViewBean, Map<String, ViewBase> paramMap)
  {
    ViewBase localViewBase = createView(paramVafContext, paramViewBean.viewType);
    if (localViewBase != null)
    {
      paramMap.put(paramViewBean.viewId, localViewBase);
      localViewBase.setName(paramViewBean.viewId);
      View localView = localViewBase.getNativeView();
      if ((isShowViewIdInDesc) && (localView != null)) {
        localView.setContentDescription(paramViewBean.viewId);
      }
      if (paramViewBase != null) {}
      for (paramViewBase = ((Layout)paramViewBase).generateParams();; paramViewBase = new Layout.Params())
      {
        localViewBase.setComLayoutParams(paramViewBase);
        localViewBase.bindNormalValue(paramViewBean);
        if (LogUtils.shouldLog()) {
          LogUtils.d("ViewFactory", "[constructViewBaseTree] make [" + paramViewBean.viewType + ", " + paramViewBean.viewId + "]");
        }
        if ((paramViewBean.children == null) || (!(localViewBase instanceof Layout))) {
          break;
        }
        if (LogUtils.shouldLog()) {
          LogUtils.d("ViewFactory", "[constructViewBaseTree] add children for [" + paramViewBean.viewType + ", " + paramViewBean.viewId + "], expected children count: " + paramViewBean.children.length);
        }
        paramViewBase = paramViewBean.children;
        int j = paramViewBase.length;
        int i = 0;
        while (i < j)
        {
          paramViewBean = constructViewBaseTree(paramVafContext, localViewBase, paramViewBase[i], paramMap);
          ((Layout)localViewBase).addView(paramViewBean);
          i += 1;
        }
      }
    }
    return localViewBase;
  }
  
  public Container inflate(VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    if (paramTemplateBean == null) {
      return null;
    }
    if (LogUtils.shouldLog()) {
      LogUtils.d("ViewFactory", "[inflate] " + paramTemplateBean.getStyleName());
    }
    Container localContainer = onCreateContainer(paramVafContext);
    paramVafContext = constructViewBaseTree(paramVafContext, null, paramTemplateBean.getViewBean(), localContainer.getViewIdMapping());
    if (paramVafContext != null)
    {
      localContainer.setVirtualView(paramVafContext);
      localContainer.attachViews();
      if (LogUtils.shouldLog())
      {
        LogUtils.d("ViewFactory", "[inflate] hierarchy after inflation: ");
        LogUtils.logViewBaseHierarchy(paramVafContext, "ViewFactory");
      }
      return localContainer;
    }
    LogUtil.QLog.d("ViewFactory", 2, "inflate: fail to inflate, vb is null");
    return null;
  }
  
  public void init(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    Utils.init(paramContext.density, paramContext.widthPixels);
  }
  
  protected Container onCreateContainer(VafContext paramVafContext)
  {
    return new Container(paramVafContext.getContext());
  }
  
  public void registerViewBuilder(String paramString, ViewBase.IBuilder paramIBuilder)
  {
    this.mBuilders.put(paramString, paramIBuilder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory
 * JD-Core Version:    0.7.0.1
 */