package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.ProteusItemDataBuilder;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.Util;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.ArticleCommentView;
import com.tencent.biz.pubaccount.readinjoy.proteus.view.helper.BindViewHelper;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.image.ImageBase;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.ColumnTopicInfo;

public class CommentBiuProteusItem
  implements ProteusItem
{
  private void a(View paramView, Activity paramActivity, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((paramView == null) || (paramActivity == null)) {
      return;
    }
    paramView.setAlpha(1.0F);
    QLog.d("CommentBiuProteusItem", 2, "bindView | start CommentBiu Header Anim");
    Animation localAnimation1 = AnimationUtils.loadAnimation(paramActivity, 2130772325);
    Animation localAnimation2 = AnimationUtils.loadAnimation(paramActivity, 2130772326);
    localAnimation1.setFillAfter(true);
    localAnimation1.setAnimationListener(new CommentBiuProteusItem.1(this, paramView, localAnimation2));
    localAnimation2.setAnimationListener(new CommentBiuProteusItem.2(this, paramView, paramBoolean, paramActivity, paramArticleInfo));
    paramView.startAnimation(localAnimation1);
    ReadInJoyLogicEngine.a().a(paramArticleInfo);
  }
  
  private static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    try
    {
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mFirstPagePicUrl)) {
        paramJSONObject.put("middle_content_cover_img_url", paramBaseArticleInfo.mFirstPagePicUrl);
      }
      for (;;)
      {
        if (!TextUtils.isEmpty(paramBaseArticleInfo.mTitle)) {
          paramJSONObject.put("middle_content_txt", paramBaseArticleInfo.mTitle);
        }
        QLog.d("CommentBiuProteusItem", 1, "coverImgUrl=" + paramBaseArticleInfo.mFirstPagePicUrl + ", middle_content_txt=" + paramBaseArticleInfo.mTitle);
        return;
        paramJSONObject.put("middle_content_cover_default_img", "article_no_img");
      }
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.d("CommentBiuProteusItem", 1, "getImageDatmiddle_content_cover_img_urlaJson error, msg=" + paramBaseArticleInfo);
    }
  }
  
  private static void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    if (RIJFeedsType.y(paramBaseArticleInfo)) {
      b(paramBaseArticleInfo, paramJSONObject, paramMobileQQ);
    }
    for (;;)
    {
      QLog.d("CommentBiuProteusItem", 2, "getVideoDataJson | isSmallVideoType " + RIJFeedsType.y(paramBaseArticleInfo) + " ; " + paramJSONObject.toString());
      return;
      c(paramBaseArticleInfo, paramJSONObject, paramMobileQQ);
    }
  }
  
  private void a(Container paramContainer, IReadInJoyModel paramIReadInJoyModel)
  {
    ViewBase localViewBase2 = paramContainer.getVirtualView();
    ViewBase localViewBase1 = localViewBase2.findViewBaseByName("id_middle_body_wrapper");
    localViewBase2 = localViewBase2.findViewBaseByName("id_middle_body_container");
    if (localViewBase1 != null) {
      localViewBase1.setOnClickListener(new CommentBiuProteusItem.3(this, paramIReadInJoyModel, paramContainer));
    }
    if (localViewBase2 != null) {
      localViewBase2.setOnClickListener(new CommentBiuProteusItem.4(this, paramIReadInJoyModel, paramContainer));
    }
  }
  
  private static void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    for (;;)
    {
      try
      {
        Object localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true);
        if (localObject == null) {
          break label274;
        }
        str = ((URL)localObject).getPath();
        paramJSONObject.put("id_small_video_container", new JSONObject());
        paramJSONObject.put("small_video_image_url", str);
        paramJSONObject.put("comment_small_video_duration", ReadInJoyDisplayUtils.a(paramBaseArticleInfo.mVideoDuration));
        paramJSONObject.put("small_video_title", paramBaseArticleInfo.mTitle);
        paramJSONObject.put("comment_small_original_label", "原视频");
        if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo != null))
        {
          localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo.str_title.get();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramJSONObject.put("column_title", localObject);
            if (paramMobileQQ != null) {
              paramJSONObject.put("column_name_text", paramMobileQQ.getString(2131718132));
            }
            paramJSONObject.put("column_title_icon", "column_icon.png");
          }
          QLog.d("CommentBiuProteusItem", 1, "columnTitle =" + (String)localObject + ",imgUrl=" + str + ",duration=" + paramBaseArticleInfo.mVideoDuration);
          return;
        }
        if ((paramBaseArticleInfo.columnEntrances != null) && (paramBaseArticleInfo.columnEntrances.size() > 0))
        {
          localObject = (VideoColumnInfo)paramBaseArticleInfo.columnEntrances.get(0);
          if (((VideoColumnInfo)localObject).a != 0)
          {
            localObject = ((VideoColumnInfo)localObject).b;
            continue;
          }
        }
        localObject = null;
      }
      catch (Exception paramBaseArticleInfo)
      {
        QLog.d("CommentBiuProteusItem", 1, "getImageDataJson error, msg=" + paramBaseArticleInfo);
        return;
      }
      continue;
      label274:
      String str = null;
    }
  }
  
  private static void c(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    for (;;)
    {
      try
      {
        Object localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(false);
        if (localObject == null) {
          break label279;
        }
        str = ((URL)localObject).getPath();
        paramJSONObject.put("id_big_video_container", new JSONObject());
        paramJSONObject.put("big_video_image_url", str);
        paramJSONObject.put("comment_big_video_duration", ReadInJoyDisplayUtils.a(paramBaseArticleInfo.mVideoDuration));
        paramJSONObject.put("big_video_title", paramBaseArticleInfo.mTitle);
        paramJSONObject.put("comment_big_original_label", "原视频");
        if ((paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo != null))
        {
          localObject = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_TencentImOidbArticlesummaryArticlesummary$ColumnTopicInfo.str_title.get();
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            paramJSONObject.put("column_title", localObject);
            if (paramMobileQQ != null) {
              paramJSONObject.put("column_name_text", paramMobileQQ.getString(2131718132));
            }
            paramJSONObject.put("column_title_icon", "column_icon.png");
          }
          QLog.d("CommentBiuProteusItem", 1, "columnTitle =" + (String)localObject + ",imgUrl=" + str + ",duration=" + paramBaseArticleInfo.mVideoDuration);
          return;
        }
        if ((paramBaseArticleInfo.columnEntrances != null) && (paramBaseArticleInfo.columnEntrances.size() > 0))
        {
          localObject = (VideoColumnInfo)paramBaseArticleInfo.columnEntrances.get(0);
          if (((VideoColumnInfo)localObject).a != 0)
          {
            localObject = ((VideoColumnInfo)localObject).b;
            continue;
          }
        }
        localObject = null;
      }
      catch (Exception paramBaseArticleInfo)
      {
        QLog.d("CommentBiuProteusItem", 1, "getImageDataJson error, msg=" + paramBaseArticleInfo);
        return;
      }
      continue;
      label279:
      String str = null;
    }
  }
  
  private static void d(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, MobileQQ paramMobileQQ)
  {
    int j = 0;
    try
    {
      int i;
      if ((paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null)) {
        i = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.size();
      }
      for (;;)
      {
        if ((i > 0) && (paramMobileQQ != null)) {
          paramJSONObject.put("count_text", i + paramMobileQQ.getString(2131718149));
        }
        QLog.d("CommentBiuProteusItem", 1, "getShortContentDataJson,count=" + i);
        return;
        i = j;
        if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null)
        {
          i = j;
          if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a != null) {
            i = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a.size();
          }
        }
      }
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.d("CommentBiuProteusItem", 1, "getImageDataJson error, msg=" + paramBaseArticleInfo);
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mSocialFeedInfo == null))
    {
      QLog.d("CommentBiuProteusItem", 1, "getDataJson error!");
      return localJSONObject;
    }
    Object localObject2 = ReadInJoyUtils.a();
    Object localObject1 = null;
    if (localObject2 != null) {
      localObject1 = ((AppRuntime)localObject2).getApplication();
    }
    localObject2 = new ProteusItemDataBuilder();
    long l2 = 0L;
    long l1 = l2;
    if (paramBaseArticleInfo.mSocialFeedInfo != null)
    {
      l1 = l2;
      if (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        l1 = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a;
      }
    }
    ((ProteusItemDataBuilder)localObject2).v(paramBaseArticleInfo).a("RIJ_biucomment_with_social_header").n(paramBaseArticleInfo).f(paramBaseArticleInfo).g(paramBaseArticleInfo).i(paramBaseArticleInfo).b(paramBaseArticleInfo).h(paramBaseArticleInfo).k(paramBaseArticleInfo).C(paramBaseArticleInfo).r(paramBaseArticleInfo).w(paramBaseArticleInfo).u(paramBaseArticleInfo).a(paramBaseArticleInfo, l1).a(paramBaseArticleInfo, HardCodeUtil.a(2131718133));
    Util.a(paramBaseArticleInfo, localJSONObject);
    Util.x(paramBaseArticleInfo, localJSONObject);
    if ("RIJ_biucomment_without_social_header".equals("RIJ_biucomment_with_social_header")) {
      ((ProteusItemDataBuilder)localObject2).b(paramBaseArticleInfo, "id_bottom_dislike_button");
    }
    while ((paramBaseArticleInfo.isPGCShortContent()) || (RIJFeedsType.x(paramBaseArticleInfo)))
    {
      localJSONObject = ((ProteusItemDataBuilder)localObject2).o(paramBaseArticleInfo).a();
      d(paramBaseArticleInfo, localJSONObject, (MobileQQ)localObject1);
      return localJSONObject;
      ((ProteusItemDataBuilder)localObject2).j(paramBaseArticleInfo);
    }
    if (RIJFeedsType.z(paramBaseArticleInfo))
    {
      localJSONObject = ((ProteusItemDataBuilder)localObject2).o(paramBaseArticleInfo).a();
      a(paramBaseArticleInfo, localJSONObject, (MobileQQ)localObject1);
      return localJSONObject;
    }
    if (RIJFeedsType.w(paramBaseArticleInfo))
    {
      localObject1 = ((ProteusItemDataBuilder)localObject2).a();
      a(paramBaseArticleInfo, (JSONObject)localObject1);
      return localObject1;
    }
    localObject1 = new JSONObject();
    QLog.d("CommentBiuProteusItem", 1, "error! no type find!,info=" + paramBaseArticleInfo);
    return localObject1;
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    try
    {
      ViewBase localViewBase = paramContainer.getVirtualView();
      Object localObject = (ImageBase)localViewBase.findViewBaseByName("id_background_imageView");
      if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.a() != null) && (paramIReadInJoyModel.a().showBreathAnimation) && (paramIReadInJoyModel.a() != null) && (paramIReadInJoyModel.a().getCurActivity() != null)) {
        a(((ImageBase)localObject).getNativeView(), paramIReadInJoyModel.a().getCurActivity(), paramIReadInJoyModel.a(), true);
      }
      localObject = (ArticleCommentView)localViewBase.findViewBaseByName("id_biu_comment");
      if ((localObject != null) && (paramIReadInJoyModel != null)) {
        ((ArticleCommentView)localObject).a(paramIReadInJoyModel);
      }
      BindViewHelper.f(localViewBase, paramIReadInJoyModel);
      if (paramIReadInJoyModel != null) {
        BindViewHelper.a(localViewBase, paramIReadInJoyModel.a());
      }
      BindViewHelper.a(localViewBase, paramIReadInJoyModel);
      Util.a(localViewBase, paramIReadInJoyModel);
      a(paramContainer, paramIReadInJoyModel);
      if (paramIReadInJoyModel != null)
      {
        paramContainer = paramIReadInJoyModel.a();
        if ((paramContainer != null) && (!paramContainer.isPGCShortContent()) && (!RIJFeedsType.z(paramContainer)))
        {
          boolean bool = RIJFeedsType.x(paramContainer);
          if (!bool) {}
        }
      }
      return;
    }
    catch (Exception paramContainer)
    {
      QLog.d("CommentBiuProteusItem", 1, "bindView error!,msg= " + paramContainer);
    }
  }
  
  public void a(IReadInJoyModel paramIReadInJoyModel, Container paramContainer)
  {
    QLog.d("CommentBiuProteusItem", 1, "middlewrapper click");
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.a() != null) && (paramContainer != null) && (paramIReadInJoyModel.a() != null))
    {
      RIJJumpUtils.b(paramIReadInJoyModel.a().a(), paramIReadInJoyModel.a());
      RIJJumpUtils.a(paramIReadInJoyModel.a().a(), paramIReadInJoyModel.a(), paramIReadInJoyModel.a(), paramIReadInJoyModel.e());
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.CommentBiuProteusItem
 * JD-Core Version:    0.7.0.1
 */