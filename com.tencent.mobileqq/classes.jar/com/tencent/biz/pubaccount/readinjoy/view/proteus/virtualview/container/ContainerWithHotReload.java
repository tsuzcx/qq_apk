package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.BaseTemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.IHotReloadChangedObserver;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.BindDataUtil;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.LogUtil.QLog;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactorWithHotReload;
import java.io.IOException;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;

public class ContainerWithHotReload
  extends Container
  implements ProteusParserWithHotReload.IHotReloadChangedObserver
{
  private ContainerWithHotReload.OnReflateListener mOnReflateListener;
  private TemplateBean mTemplateBean;
  private VafContext mVafContext;
  
  public ContainerWithHotReload(Context paramContext)
  {
    super(paramContext);
  }
  
  private void trySetLayoutParamsMargin(ViewGroup.LayoutParams paramLayoutParams, Layout.Params paramParams)
  {
    try
    {
      Field localField1 = paramLayoutParams.getClass().getField("leftMargin");
      Field localField2 = paramLayoutParams.getClass().getField("rightMargin");
      Field localField3 = paramLayoutParams.getClass().getField("topMargin");
      Field localField4 = paramLayoutParams.getClass().getField("bottomMargin");
      localField1.setAccessible(true);
      localField2.setAccessible(true);
      localField3.setAccessible(true);
      localField4.setAccessible(true);
      localField1.set(paramLayoutParams, Integer.valueOf(paramParams.mLayoutMarginLeft));
      localField2.set(paramLayoutParams, Integer.valueOf(paramParams.mLayoutMarginRight));
      localField3.set(paramLayoutParams, Integer.valueOf(paramParams.mLayoutMarginTop));
      localField4.set(paramLayoutParams, Integer.valueOf(paramParams.mLayoutMarginBottom));
      return;
    }
    catch (Exception paramLayoutParams)
    {
      LogUtil.QLog.e("readinjoy.proteus", 2, " there is no margin field in layout params: " + paramLayoutParams.toString());
    }
  }
  
  public ContainerWithHotReload.OnReflateListener getOnReflateListener()
  {
    return this.mOnReflateListener;
  }
  
  public TemplateBean getTemplateBean()
  {
    return this.mTemplateBean;
  }
  
  public VafContext getVafContext()
  {
    return this.mVafContext;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ProteusParserWithHotReload.getInstance().addHotReloadChangedObserver(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ProteusParserWithHotReload.getInstance().removeHotReloadChangedObserver(this);
  }
  
  public void onHotReloadChanged(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1.equals(this.mTemplateBean.getStyleName())) {}
    try
    {
      refresh(paramString1, this);
      return;
    }
    catch (JSONException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public void refresh(String paramString, ContainerWithHotReload paramContainerWithHotReload)
  {
    Object localObject1 = paramContainerWithHotReload.getVafContext();
    paramString = ((VafContext)localObject1).getTemplateFactory().getTemplate(paramString);
    Object localObject2 = paramContainerWithHotReload.getTemplateBean().getData();
    if (localObject2 != null) {
      paramString.bindData((JSONObject)localObject2);
    }
    localObject2 = ((VafContext)localObject1).getViewFactory();
    if ((localObject2 instanceof ViewFactorWithHotReload)) {
      ((ViewFactorWithHotReload)localObject2).reflate((VafContext)localObject1, paramString, paramContainerWithHotReload);
    }
    BindDataUtil.bindDynamicValueWithoutRecursion(paramContainerWithHotReload, null, paramString);
    paramString = paramContainerWithHotReload.getLayoutParams();
    localObject1 = paramContainerWithHotReload.getVirtualView().getComLayoutParams();
    paramString.width = ((Layout.Params)localObject1).mLayoutWidth;
    paramString.height = ((Layout.Params)localObject1).mLayoutHeight;
    trySetLayoutParamsMargin(paramString, (Layout.Params)localObject1);
    if (paramContainerWithHotReload.getParent() != null)
    {
      paramContainerWithHotReload.getParent().requestLayout();
      ((View)paramContainerWithHotReload.getParent()).invalidate();
    }
  }
  
  public void setOnReflateListener(ContainerWithHotReload.OnReflateListener paramOnReflateListener)
  {
    this.mOnReflateListener = paramOnReflateListener;
  }
  
  public void setTemplateBean(TemplateBean paramTemplateBean)
  {
    this.mTemplateBean = paramTemplateBean;
  }
  
  public void setVafContext(VafContext paramVafContext)
  {
    this.mVafContext = paramVafContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.ContainerWithHotReload
 * JD-Core Version:    0.7.0.1
 */