package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ReadInJoyAdLargeVideoGameCell;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItem;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoyAd.ad.adsmallgame.IAdMiniGamePts;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class AdQQMiniGameVideoProteusItem
  implements ProteusItem, IAdMiniGamePts
{
  private int jdField_a_of_type_Int;
  private IReadInJoyModel jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel;
  private ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private ViewBase jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private String jdField_b_of_type_JavaLangString;
  
  private void a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo != null) && (!TextUtils.isEmpty(paramArticleInfo.smallGameData)) && (paramArticleInfo.mSmallMiniGameInfo != null)) {
      if (TextUtils.isEmpty(paramArticleInfo.mSmallMiniGameInfo.t)) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_JavaLangString = paramArticleInfo.mSmallMiniGameInfo.s;
      this.jdField_b_of_type_JavaLangString = paramArticleInfo.mSmallMiniGameInfo.j;
      return;
    }
  }
  
  private void a(ViewBase paramViewBase, boolean paramBoolean)
  {
    if (paramViewBase != null)
    {
      AdMiniGameGuideManager.a.a(paramViewBase, paramBoolean, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel.a(), this.jdField_a_of_type_Int);
      if (!paramBoolean) {
        ThreadManager.getUIHandler().post(new AdQQMiniGameVideoProteusItem.1(this));
      }
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    return ReadInJoyAdLargeVideoGameCell.a(paramBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    boolean bool = true;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelIReadInJoyModel = paramIReadInJoyModel;
    this.jdField_a_of_type_Int = paramInt2;
    a(paramIReadInJoyModel.a());
    AdMiniGameGuideManager.a.a(this);
    paramContainer = paramContainer.getVirtualView();
    ViewBase localViewBase = paramContainer.findViewBaseByName("id_large_video_icon");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = paramContainer.findViewBaseByName("id_game_follow_btn");
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase = paramContainer.findViewBaseByName("id_img_container");
    if (localViewBase != null) {
      localViewBase.setVisibility(0);
    }
    if (ReadInJoyAdUtils.j(paramIReadInJoyModel.a()))
    {
      paramIReadInJoyModel = paramContainer.findViewBaseByName("id_large_video_cover");
      if (paramIReadInJoyModel != null) {
        paramIReadInJoyModel.setVisibility(8);
      }
      paramIReadInJoyModel = paramContainer.findViewBaseByName("id_video_bg");
      if (paramIReadInJoyModel != null) {
        paramIReadInJoyModel.setVisibility(8);
      }
      paramContainer = (NativeText)paramContainer.findViewBaseByName("id_video_paly_text");
      if (paramContainer != null) {
        paramContainer.setVisibility(8);
      }
      if (localViewBase != null) {
        localViewBase.setVisibility(8);
      }
    }
    label306:
    do
    {
      do
      {
        return;
      } while (!ReadInJoyAdUtils.h(paramIReadInJoyModel.a()));
      if (Aladdin.getConfig(318).getIntegerFromString("small_game_large_card_new_style", 0) == 1) {}
      for (;;)
      {
        QLog.d("AdQQMiniGameVideoProteusItem", 2, "small game card is new style:" + bool);
        if ((!bool) || (paramIReadInJoyModel.a() == null) || (paramIReadInJoyModel.a().mSmallMiniGameInfo == null) || (TextUtils.isEmpty(paramIReadInJoyModel.a().mSmallMiniGameInfo.d))) {
          break label306;
        }
        if (localViewBase != null) {
          localViewBase.setVisibility(8);
        }
        paramIReadInJoyModel = paramContainer.findViewBaseByName("id_video_bg");
        if (paramIReadInJoyModel != null) {
          paramIReadInJoyModel.setVisibility(0);
        }
        paramContainer = (NativeText)paramContainer.findViewBaseByName("id_video_paly_text");
        if (paramContainer == null) {
          break;
        }
        paramContainer.setVisibility(0);
        return;
        bool = false;
      }
      paramIReadInJoyModel = paramContainer.findViewBaseByName("id_video_bg");
      if (paramIReadInJoyModel != null) {
        paramIReadInJoyModel.setVisibility(8);
      }
      paramContainer = (NativeText)paramContainer.findViewBaseByName("id_video_paly_text");
    } while (paramContainer == null);
    paramContainer.setVisibility(8);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("minigame", 2, "anim move video::animMove::" + paramBoolean + "guide " + this.jdField_a_of_type_Boolean + "gameId" + this.jdField_b_of_type_JavaLangString);
    }
    if (!this.jdField_a_of_type_Boolean) {}
    while ((paramString == null) || (!paramString.equals(this.jdField_b_of_type_JavaLangString))) {
      return;
    }
    a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, paramBoolean);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */