package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.ContainerWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.ContainerWithHotReload.OnReflateListener;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload;

public class ViewFactorWithHotReload
  extends ViewFactory
{
  private static final String TAG = "ViewFactorWithHotReload";
  
  public Container inflate(VafContext paramVafContext, TemplateBean paramTemplateBean)
  {
    if (ProteusParserWithHotReload.getInstance().isSupportHotReload())
    {
      paramVafContext = (ContainerWithHotReload)super.inflate(paramVafContext, paramTemplateBean);
      if ((paramVafContext != null) && (paramTemplateBean != null)) {
        paramVafContext.setTemplateBean(paramTemplateBean);
      }
      return paramVafContext;
    }
    return super.inflate(paramVafContext, paramTemplateBean);
  }
  
  protected Container onCreateContainer(VafContext paramVafContext)
  {
    if (ProteusParserWithHotReload.getInstance().isSupportHotReload())
    {
      ContainerWithHotReload localContainerWithHotReload = new ContainerWithHotReload(paramVafContext.getContext());
      localContainerWithHotReload.setVafContext(paramVafContext);
      return localContainerWithHotReload;
    }
    return super.onCreateContainer(paramVafContext);
  }
  
  public void reflate(VafContext paramVafContext, TemplateBean paramTemplateBean, ContainerWithHotReload paramContainerWithHotReload)
  {
    if (paramTemplateBean == null) {
      return;
    }
    if (LogUtils.shouldLog()) {
      LogUtils.d("ViewFactorWithHotReload", "[inflate] " + paramTemplateBean.getStyleName());
    }
    if (paramContainerWithHotReload == null)
    {
      paramContainerWithHotReload = (ContainerWithHotReload)onCreateContainer(paramVafContext);
      label51:
      paramContainerWithHotReload.setTemplateBean(paramTemplateBean);
      paramVafContext = constructViewBaseTree(paramVafContext, null, paramTemplateBean.getViewBean(), paramContainerWithHotReload.getViewIdMapping());
      if (paramVafContext == null) {
        break label126;
      }
      paramContainerWithHotReload.setVirtualView(paramVafContext);
      paramContainerWithHotReload.attachViews();
      if (LogUtils.shouldLog())
      {
        LogUtils.d("ViewFactorWithHotReload", "[inflate] hierarchy after inflation: ");
        LogUtils.logViewBaseHierarchy(paramVafContext, "ViewFactorWithHotReload");
      }
    }
    for (;;)
    {
      paramVafContext = paramContainerWithHotReload.getOnReflateListener();
      if (paramVafContext == null) {
        break;
      }
      paramVafContext.onReflate();
      return;
      paramContainerWithHotReload.removeAllViews();
      break label51;
      label126:
      LogUtil.QLog.d("ViewFactorWithHotReload", 2, "inflate: fail to inflate, vb is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactorWithHotReload
 * JD-Core Version:    0.7.0.1
 */