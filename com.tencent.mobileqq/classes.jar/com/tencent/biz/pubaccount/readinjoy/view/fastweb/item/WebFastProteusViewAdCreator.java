package com.tencent.biz.pubaccount.readinjoy.view.fastweb.item;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebRecommendAdService;
import com.tencent.mobileqq.kandian.biz.fastweb.IStateChangeListener;
import com.tencent.mobileqq.kandian.biz.fastweb.entity.BaseItemViewHolder;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

public class WebFastProteusViewAdCreator
  implements IStateChangeListener, ItemCreator
{
  private VafContext a;
  private Context b;
  
  private void a(Container paramContainer)
  {
    if (paramContainer != null)
    {
      ViewBase localViewBase = paramContainer.getVirtualView();
      if (localViewBase != null)
      {
        paramContainer = localViewBase.findViewBaseByName("id_large_video_icon");
        localViewBase = localViewBase.findViewBaseByName("id_video_bg");
        boolean bool = NetworkState.isWifiConn();
        int i = 0;
        int j = 8;
        if (!bool)
        {
          i = 8;
          j = 0;
        }
        if (paramContainer != null) {
          paramContainer.setVisibility(i);
        }
        if (localViewBase != null) {
          localViewBase.setVisibility(j);
        }
      }
    }
  }
  
  private void a(Container paramContainer, RecommendAdData paramRecommendAdData)
  {
    if (paramContainer != null)
    {
      paramContainer = paramContainer.getVirtualView();
      if (paramContainer != null)
      {
        Object localObject = paramContainer.findViewBaseByName("id_recommend_title");
        if ((localObject != null) && (((ViewBase)localObject).getNativeView() != null) && ((((ViewBase)localObject).getNativeView() instanceof NativeTextImp)))
        {
          localObject = (NativeTextImp)((ViewBase)localObject).getNativeView();
          ((NativeTextImp)localObject).setLines(2);
          ((NativeTextImp)localObject).setGravity(51);
        }
        localObject = paramContainer.findViewBaseByName("id_recommend_category_download");
        if ((localObject != null) && (((ViewBase)localObject).getNativeView() != null) && ((((ViewBase)localObject).getNativeView() instanceof NativeTextImp)) && (paramRecommendAdData.s == 12) && (!TextUtils.isEmpty(paramRecommendAdData.t)))
        {
          localObject = (NativeTextImp)((ViewBase)localObject).getNativeView();
          if ((localObject != null) && (!paramRecommendAdData.ad))
          {
            ((NativeTextImp)localObject).setVisibility(8);
            return;
          }
          if (localObject != null) {
            if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(BaseApplicationImpl.getContext(), paramRecommendAdData.t)) {
              ((NativeTextImp)localObject).setText("立即打开");
            } else {
              ((NativeTextImp)localObject).setText("立即下载");
            }
          }
        }
        if (TextUtils.isEmpty(paramRecommendAdData.ah))
        {
          paramContainer = paramContainer.findViewBaseByName("id_recommend_account_name");
          if (paramContainer == null) {
            return;
          }
          paramContainer.getComLayoutParams().mLayoutMarginLeft = AIOUtils.b(16.0F, this.b.getResources());
        }
      }
    }
  }
  
  public BaseItemViewHolder a(Context paramContext, BaseData paramBaseData, ViewGroup paramViewGroup)
  {
    if (this.a == null)
    {
      this.a = new ReadInjoyContext();
      this.a.setContext(paramContext);
      ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).initAdapterProteus(this.a, "native_article");
    }
    if (this.b == null) {
      this.b = paramContext;
    }
    ProteusItemData localProteusItemData = (ProteusItemData)paramBaseData;
    paramViewGroup = null;
    String str;
    try
    {
      Object localObject1 = this.a.getViewFactory().inflate(this.a, localProteusItemData.bd);
      paramViewGroup = (ViewGroup)localObject1;
      localObject2 = ((Container)localObject1).getVirtualView();
      paramViewGroup = (ViewGroup)localObject1;
      ((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).bindDynamicValue((ViewBase)localObject2, localProteusItemData.bd.getViewBean());
      paramViewGroup = (ViewGroup)localObject1;
      localObject2 = localProteusItemData.bb.toString();
      paramViewGroup = (ViewGroup)localObject1;
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("error!! msg=");
      ((StringBuilder)localObject2).append(localException.toString());
      str = ((StringBuilder)localObject2).toString();
    }
    boolean bool = false;
    Object localObject2 = paramViewGroup;
    if (paramViewGroup == null)
    {
      localObject2 = new View(paramContext);
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("createViewHolder viewIsNull=");
      paramContext.append(bool);
      paramContext.append("  proteusData=");
      paramContext.append(str);
      QLog.d("WebFastProteusViewAdCreator", 1, paramContext.toString());
    }
    if (paramBaseData != null) {
      paramContext = paramBaseData.aQ;
    }
    return new WebFastProteusViewAdCreator.ProteusItemViewHolder(this, (View)localObject2, localProteusItemData);
  }
  
  public void a() {}
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public boolean a(BaseData paramBaseData)
  {
    return paramBaseData.aP == 9;
  }
  
  public int b(BaseData paramBaseData)
  {
    if ((paramBaseData instanceof RecommendAdData)) {
      return 9;
    }
    return -1;
  }
  
  public void b()
  {
    ((IRIJFastWebRecommendAdService)QRoute.api(IRIJFastWebRecommendAdService.class)).onResume();
  }
  
  public void c() {}
  
  public void d()
  {
    ((IRIJFastWebRecommendAdService)QRoute.api(IRIJFastWebRecommendAdService.class)).onDestroy();
  }
  
  public void e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastProteusViewAdCreator
 * JD-Core Version:    0.7.0.1
 */