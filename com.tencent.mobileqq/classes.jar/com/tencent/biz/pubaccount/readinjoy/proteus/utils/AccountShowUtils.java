package com.tencent.biz.pubaccount.readinjoy.proteus.utils;

import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.AvatarView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInjoyTextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class AccountShowUtils
{
  public static void a(Container paramContainer, IReadInJoyModel paramIReadInJoyModel)
  {
    a(paramContainer, paramIReadInJoyModel, "id_nickname");
  }
  
  public static void a(Container paramContainer, IReadInJoyModel paramIReadInJoyModel, String paramString)
  {
    ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
    paramContainer = paramContainer.getVirtualView();
    AvatarView localAvatarView = (AvatarView)paramContainer.findViewBaseByName("id_partner_info_avator");
    if (localAvatarView != null) {
      localAvatarView.a(paramIReadInJoyModel);
    }
    paramContainer = (ReadInjoyTextView)paramContainer.findViewBaseByName(paramString);
    if (paramContainer != null)
    {
      long l = 0L;
      if (localArticleInfo.mPartnerAccountInfo != null) {
        l = localArticleInfo.mPartnerAccountInfo.uint64_uin.get();
      }
      paramContainer.a(l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.utils.AccountShowUtils
 * JD-Core Version:    0.7.0.1
 */