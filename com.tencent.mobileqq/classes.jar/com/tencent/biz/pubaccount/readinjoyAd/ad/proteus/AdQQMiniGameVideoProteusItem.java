package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.biz.pubaccount.readinjoyAd.ad.adsmallgame.IAdMiniGamePts;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInJoyAdLargeVideoGameCell;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class AdQQMiniGameVideoProteusItem
  implements IAdMiniGamePts, ProteusItem
{
  private int jdField_a_of_type_Int;
  private ViewBase jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private IReadInJoyModel jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private ViewBase jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase;
  private String jdField_b_of_type_JavaLangString;
  
  private void a(ViewBase paramViewBase, boolean paramBoolean)
  {
    if (paramViewBase != null)
    {
      AdMiniGameGuideManager.a.a(paramViewBase, paramBoolean, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel.a(), this.jdField_a_of_type_Int);
      if (!paramBoolean) {
        ThreadManager.getUIHandler().post(new AdQQMiniGameVideoProteusItem.1(this));
      }
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.smallGameData)) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo != null))
    {
      this.jdField_a_of_type_Boolean = (TextUtils.isEmpty(paramAbsBaseArticleInfo.mSmallMiniGameInfo.t) ^ true);
      this.jdField_a_of_type_JavaLangString = paramAbsBaseArticleInfo.mSmallMiniGameInfo.s;
      this.jdField_b_of_type_JavaLangString = paramAbsBaseArticleInfo.mSmallMiniGameInfo.j;
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdLargeVideoGameCell.a(paramAbsBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityApiIReadInJoyModel = paramIReadInJoyModel;
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
    else if (ReadInJoyAdUtils.h(paramIReadInJoyModel.a()))
    {
      paramInt1 = Aladdin.getConfig(318).getIntegerFromString("small_game_large_card_new_style", 0);
      boolean bool = true;
      if (paramInt1 != 1) {
        bool = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("small game card is new style:");
      localStringBuilder.append(bool);
      QLog.d("AdQQMiniGameVideoProteusItem", 2, localStringBuilder.toString());
      if ((bool) && (paramIReadInJoyModel.a() != null) && (paramIReadInJoyModel.a().mSmallMiniGameInfo != null) && (!TextUtils.isEmpty(paramIReadInJoyModel.a().mSmallMiniGameInfo.d)))
      {
        if (localViewBase != null) {
          localViewBase.setVisibility(8);
        }
        paramIReadInJoyModel = paramContainer.findViewBaseByName("id_video_bg");
        if (paramIReadInJoyModel != null) {
          paramIReadInJoyModel.setVisibility(0);
        }
        paramContainer = (NativeText)paramContainer.findViewBaseByName("id_video_paly_text");
        if (paramContainer != null) {
          paramContainer.setVisibility(0);
        }
      }
      else
      {
        paramIReadInJoyModel = paramContainer.findViewBaseByName("id_video_bg");
        if (paramIReadInJoyModel != null) {
          paramIReadInJoyModel.setVisibility(8);
        }
        paramContainer = (NativeText)paramContainer.findViewBaseByName("id_video_paly_text");
        if (paramContainer != null) {
          paramContainer.setVisibility(8);
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("anim move video::animMove::");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("guide ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append("gameId");
      localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
      QLog.d("minigame", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if ((paramString != null) && (paramString.equals(this.jdField_b_of_type_JavaLangString))) {
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreViewBase, paramBoolean);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */