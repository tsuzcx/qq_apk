package com.tencent.biz.pubaccount.readinjoyAd.ad.proteus;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.adsmallgame.IAdMiniGamePts;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.data.ReadInJoyAdTripleImgGameCell;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.repo.ad.SmallMiniGameInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class AdQQMiniGameTripleImgProteusItem
  implements IAdMiniGamePts, ProteusItem
{
  private ViewBase a;
  private int b;
  private IReadInJoyModel c;
  private ViewBase d;
  private boolean e;
  private String f;
  private String g;
  
  private void a(ViewBase paramViewBase, boolean paramBoolean)
  {
    if (paramViewBase != null)
    {
      AdMiniGameGuideManager.a.a(paramViewBase, paramBoolean, this.c.k(), this.b);
      if (!paramBoolean) {
        ThreadManager.getUIHandler().post(new AdQQMiniGameTripleImgProteusItem.1(this));
      }
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (!TextUtils.isEmpty(paramAbsBaseArticleInfo.smallGameData)) && (paramAbsBaseArticleInfo.mSmallMiniGameInfo != null))
    {
      this.e = (TextUtils.isEmpty(paramAbsBaseArticleInfo.mSmallMiniGameInfo.w) ^ true);
      this.f = paramAbsBaseArticleInfo.mSmallMiniGameInfo.v;
      this.g = paramAbsBaseArticleInfo.mSmallMiniGameInfo.m;
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdTripleImgGameCell.a(paramAbsBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    this.c = paramIReadInJoyModel;
    this.b = paramInt2;
    a(paramIReadInJoyModel.k());
    AdMiniGameGuideManager.a.a(this);
    paramContainer = paramContainer.getVirtualView();
    this.a = paramContainer.findViewBaseByName("id_img_container");
    this.d = paramContainer.findViewBaseByName("id_game_follow_btn");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("anim move tripe::animMove::");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("guide ");
      localStringBuilder.append(this.e);
      localStringBuilder.append("gameId");
      localStringBuilder.append(this.g);
      QLog.d("minigame", 2, localStringBuilder.toString());
    }
    if (!this.e) {
      return;
    }
    if ((paramString != null) && (paramString.equals(this.g))) {
      a(this.a, paramBoolean);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameTripleImgProteusItem
 * JD-Core Version:    0.7.0.1
 */