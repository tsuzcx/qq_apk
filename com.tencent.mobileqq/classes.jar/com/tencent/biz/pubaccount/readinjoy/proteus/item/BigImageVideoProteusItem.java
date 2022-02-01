package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoyLargeVideoCell;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.AccountShowUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

public class BigImageVideoProteusItem
  implements ProteusItem
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return ReadInJoyLargeVideoCell.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    Object localObject2 = null;
    ViewBase localViewBase = paramContainer.getVirtualView();
    if ((NetworkState.isWifiConn()) || (Aladdin.getConfig(299).getIntegerFromString("rij_main_feeds_tips_off", 0) == 1))
    {
      localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
      if (localObject1 != null) {
        ((ViewBase)localObject1).setVisibility(0);
      }
      localObject1 = localViewBase.findViewBaseByName("id_video_bg");
      if (localObject1 != null) {
        ((ViewBase)localObject1).setVisibility(8);
      }
      ReadInJoyDisplayUtils.a(false, localViewBase, null);
      if (paramIReadInJoyModel != null)
      {
        localObject1 = paramIReadInJoyModel.a();
        if ((localObject1 != null) && (((BaseArticleInfo)localObject1).isAccountShown)) {
          AccountShowUtils.a(paramContainer, paramIReadInJoyModel);
        }
      }
      paramContainer = localObject2;
      if (paramIReadInJoyModel != null) {
        paramContainer = paramIReadInJoyModel.a();
      }
      MultiVideoHelper.a(paramContainer, BaseActivity.sTopActivity);
      return;
    }
    Object localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
    if (localObject1 != null) {
      ((ViewBase)localObject1).setVisibility(8);
    }
    localObject1 = localViewBase.findViewBaseByName("id_video_bg");
    if (localObject1 != null) {
      ((ViewBase)localObject1).setVisibility(0);
    }
    NativeText localNativeText = (NativeText)localViewBase.findViewBaseByName("id_video_paly_text");
    String str;
    if (localNativeText != null)
    {
      str = HardCodeUtil.a(2131701179);
      if (CUKingCardHelper.a() == 1)
      {
        localObject1 = HardCodeUtil.a(2131701180);
        label210:
        localNativeText.setText((CharSequence)localObject1);
      }
    }
    else
    {
      if (paramIReadInJoyModel == null) {
        break label303;
      }
    }
    label303:
    for (localObject1 = paramIReadInJoyModel.a();; localObject1 = null)
    {
      ReadInJoyDisplayUtils.a(localViewBase, (BaseArticleInfo)localObject1);
      break;
      localObject1 = str;
      if (paramIReadInJoyModel == null) {
        break label210;
      }
      localObject1 = str;
      if (paramIReadInJoyModel.a().mXGFileSize <= 0L) {
        break label210;
      }
      localObject1 = VideoFeedsHelper.b(paramIReadInJoyModel.a().mXGFileSize) + HardCodeUtil.a(2131701178);
      break label210;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    paramContainer = paramIReadInJoyModel.a();
    switch (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()))
    {
    default: 
      return false;
    }
    paramViewBase.setOnClickListener(new BigImageVideoProteusItem.1(this, paramContainer, paramIReadInJoyModel, paramViewBase));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.BigImageVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */