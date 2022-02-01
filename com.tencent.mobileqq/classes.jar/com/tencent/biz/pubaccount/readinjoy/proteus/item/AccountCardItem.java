package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ProteusItemDataBuilder;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.Util;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ArticleCommentView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.BindViewHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import org.json.JSONObject;

public class AccountCardItem
  implements ProteusItem
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    long l2 = 0L;
    if (paramBaseArticleInfo == null) {
      return null;
    }
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.a != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.a.a;
      }
    }
    return new ProteusItemDataBuilder().a(paramBaseArticleInfo).b(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).j(paramBaseArticleInfo).k(paramBaseArticleInfo).C(paramBaseArticleInfo).q(paramBaseArticleInfo).r(paramBaseArticleInfo).v(paramBaseArticleInfo).w(paramBaseArticleInfo).A(paramBaseArticleInfo).B(paramBaseArticleInfo).a("ReadInjoy_original_cell").F(paramBaseArticleInfo).E(paramBaseArticleInfo).H(paramBaseArticleInfo).I(paramBaseArticleInfo).a();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    paramContainer = paramContainer.getVirtualView();
    BindViewHelper.f(paramContainer, paramIReadInJoyModel);
    ArticleCommentView localArticleCommentView = (ArticleCommentView)paramContainer.findViewBaseByName("id_article_comment");
    if (localArticleCommentView != null) {
      localArticleCommentView.a(paramIReadInJoyModel);
    }
    BindViewHelper.a(paramContainer, paramIReadInJoyModel.a());
    Util.a(paramContainer, paramIReadInJoyModel);
    BindViewHelper.c(paramContainer, paramIReadInJoyModel);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.AccountCardItem
 * JD-Core Version:    0.7.0.1
 */