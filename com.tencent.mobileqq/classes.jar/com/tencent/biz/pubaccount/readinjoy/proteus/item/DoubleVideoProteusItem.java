package com.tencent.biz.pubaccount.readinjoy.proteus.item;

import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.RIJJsonUtils;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.proteus.data.Util;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.AccountShowUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.RIJPBFieldUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiVideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoHelper;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.util.FluencyOptUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PartnerAccountInfo;

public class DoubleVideoProteusItem
  implements ProteusItem
{
  private Boolean a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase, int paramInt1, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, BaseArticleInfo paramBaseArticleInfo3, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return Boolean.valueOf(false);
    case 1130: 
      b(paramViewBase, paramBaseArticleInfo2);
      a(paramIReadInJoyModel, paramViewBase, paramBaseArticleInfo2, paramInt2);
      return Boolean.valueOf(true);
    case 1131: 
      a(paramViewBase, paramBaseArticleInfo3);
      a(paramIReadInJoyModel, paramViewBase, (ArticleInfo)paramBaseArticleInfo2, paramBaseArticleInfo3, paramInt2);
      return Boolean.valueOf(true);
    case 1164: 
    case 1165: 
      b(paramIReadInJoyModel, paramViewBase, paramInt1, paramBaseArticleInfo2, paramBaseArticleInfo3);
      return Boolean.valueOf(true);
    case 1166: 
    case 1167: 
      a(paramIReadInJoyModel, paramViewBase, paramInt1, paramBaseArticleInfo2, paramBaseArticleInfo3);
      return Boolean.valueOf(true);
    }
    a(paramIReadInJoyModel, paramViewBase, paramBaseArticleInfo1);
    return Boolean.valueOf(true);
  }
  
  private Map<String, Object> a(TemplateBean paramTemplateBean, ViewBase paramViewBase)
  {
    if ((paramTemplateBean == null) || (paramViewBase == null)) {
      return null;
    }
    return paramTemplateBean.getDataAttribute(paramViewBase.getName());
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase, int paramInt, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2)
  {
    paramViewBase.setOnClickListener(new DoubleVideoProteusItem.1(this, paramInt, paramIReadInJoyModel, paramBaseArticleInfo1, paramBaseArticleInfo2));
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase, ArticleInfo paramArticleInfo, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    paramViewBase.setOnClickListener(new DoubleVideoProteusItem.4(this, paramIReadInJoyModel, paramInt, paramBaseArticleInfo, paramArticleInfo));
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase, BaseArticleInfo paramBaseArticleInfo)
  {
    paramViewBase.setOnClickListener(new DoubleVideoProteusItem.3(this, paramBaseArticleInfo, paramIReadInJoyModel));
  }
  
  private void a(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    paramViewBase.setOnClickListener(new DoubleVideoProteusItem.5(this, paramIReadInJoyModel, paramInt, paramBaseArticleInfo));
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramBaseArticleInfo == null)) {
      return;
    }
    if (paramBaseArticleInfo.subscriptLocation != 0)
    {
      QLog.d("DoubleVideoProteusItem", 2, "bindRightSubscriptInfo | wrong position");
      return;
    }
    RIJJsonUtils.a(paramJSONObject, "right_mark_text", paramBaseArticleInfo.subscriptWording);
    RIJJsonUtils.a(paramJSONObject, "right_mark_color", paramBaseArticleInfo.subscriptWordingColor);
    RIJJsonUtils.a(paramJSONObject, "right_mark_backgroundcolor", paramBaseArticleInfo.subscriptBgColor);
    paramJSONObject.put("right_corner_mark", paramBaseArticleInfo.subscriptType);
  }
  
  private void a(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
  {
    Object localObject;
    if (paramBaseArticleInfo != null)
    {
      int i = paramBaseArticleInfo.getCommentCount();
      if (i <= 0) {
        break label431;
      }
      localObject = VideoFeedsHelper.e(i);
      if (paramBoolean)
      {
        paramJSONObject.put("right_comment_count", localObject);
        paramJSONObject.put("right_play_count", VideoFeedsHelper.c(paramBaseArticleInfo.mVideoPlayCount));
        paramJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
        paramJSONObject.put("comment_icon", "comment_icon_white");
      }
      if ((paramBaseArticleInfo.richTitleInfoList != null) && (paramBaseArticleInfo.richTitleInfoList.size() > 0)) {
        break label439;
      }
      paramJSONObject.put("right_article_title", paramBaseArticleInfo.mTitle);
      paramJSONObject.put("right_title_num", ReadInJoyHelper.e() + "");
      paramJSONObject.put("title_num", ReadInJoyHelper.e() + "");
      label151:
      if ((!paramBaseArticleInfo.isUseGif) || (!NetworkUtil.h(BaseApplicationImpl.getContext()))) {
        break label454;
      }
      paramBoolean = true;
      label169:
      paramBaseArticleInfo.isShowGif = paramBoolean;
      if (!paramBaseArticleInfo.isShowGif) {
        break label459;
      }
      paramJSONObject.put("right_cover_gif", paramBaseArticleInfo.gifCoverUrl);
      paramJSONObject.put("right_cover_url", paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
    }
    for (;;)
    {
      if ((paramBaseArticleInfo.isAccountShown) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
      {
        long l = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
        paramJSONObject.put("right_account_uin", l + "");
        localObject = RIJPBFieldUtils.b(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramJSONObject.put("right_account_small_icon_url", localObject);
        }
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoArticleSubsColor))
      {
        paramJSONObject.put("right_item_subscript_text", paramBaseArticleInfo.mVideoArticleSubsText);
        String str = paramBaseArticleInfo.mVideoArticleSubsColor;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "#00a5e0";
        }
        paramJSONObject.put("right_item_subscript_bg_color", localObject);
      }
      a(paramBaseArticleInfo, paramJSONObject);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.smallGameData))
      {
        paramJSONObject.put("right_comment_count", ReadInJoyAdUtils.a(paramBaseArticleInfo.mCommentCount, HardCodeUtil.a(2131702139)));
        paramJSONObject.put("right_play_count", HardCodeUtil.a(2131699885));
        localObject = new JSONObject();
        ((JSONObject)localObject).put("play_icon", "readinjoy_ad_small_game");
        paramJSONObject.put("id_right_play_icon", localObject);
      }
      paramBaseArticleInfo.isTwoItem = true;
      return;
      label431:
      localObject = "0";
      break;
      label439:
      Util.a(paramBaseArticleInfo, paramJSONObject, "right_rich_text_line", "right_rich_text_info", true);
      break label151;
      label454:
      paramBoolean = false;
      break label169;
      label459:
      localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile();
      paramJSONObject.put("right_cover_image_url", localObject);
      FluencyOptUtils.a.a((String)localObject);
    }
  }
  
  private void a(ViewBase paramViewBase, BaseArticleInfo paramBaseArticleInfo)
  {
    View localView;
    RIJDtParamBuilder localRIJDtParamBuilder;
    if (("id_right_item_cover_imageview".equals(paramViewBase.getViewId())) || ("id_right_item_gif_imageview".equals(paramViewBase.getViewId())))
    {
      VideoReport.setElementExposePolicy(paramViewBase.getNativeView(), ExposurePolicy.REPORT_FIRST);
      VideoReport.setElementEndExposePolicy(paramViewBase.getNativeView(), EndExposurePolicy.REPORT_ALL);
      VideoReport.setElementId(paramViewBase.getNativeView(), "card");
      localView = paramViewBase.getNativeView();
      localRIJDtParamBuilder = new RIJDtParamBuilder().a(Long.valueOf(paramBaseArticleInfo.mChannelID));
      if (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)) {
        break label121;
      }
    }
    label121:
    for (String str = "null";; str = paramBaseArticleInfo.innerUniqueID)
    {
      VideoReport.setElementParams(localView, localRIJDtParamBuilder.e(str).a());
      VideoReport.setElementReuseIdentifier(paramViewBase.getNativeView(), paramBaseArticleInfo.innerUniqueID);
      return;
    }
  }
  
  private void b(IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase, int paramInt, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2)
  {
    paramViewBase.setOnClickListener(new DoubleVideoProteusItem.2(this, paramInt, paramIReadInJoyModel, paramBaseArticleInfo1, paramBaseArticleInfo2));
  }
  
  private void b(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      if (ReadInJoyAdUtils.k(paramBaseArticleInfo1)) {
        try
        {
          paramJSONObject.remove("play_icon");
          paramJSONObject.remove("comment_icon");
          JSONObject localJSONObject1 = new JSONObject();
          localJSONObject1.put("play_icon", "ReadInJoy/video_play_icon.png");
          paramJSONObject.put("id_left_play_icon", localJSONObject1);
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("comment_icon", "comment_icon_white");
          paramJSONObject.put("id_left_comment_icon", localJSONObject2);
          new JSONObject().put("play_icon", "ReadInJoy/video_play_icon.png");
          paramJSONObject.put("id_right_play_icon", localJSONObject1);
          new JSONObject().put("comment_icon", "comment_icon_white");
          paramJSONObject.put("id_right_comment_icon", localJSONObject2);
          if (ReadInJoyAdUtils.l(paramBaseArticleInfo1))
          {
            paramBaseArticleInfo1 = ReadInJoyAdUtils.a(paramBaseArticleInfo1.mCommentCount, HardCodeUtil.a(2131702139));
            paramJSONObject.put("left_play_count", HardCodeUtil.a(2131699885) + " " + paramBaseArticleInfo1);
            paramBaseArticleInfo1 = new JSONObject();
            paramBaseArticleInfo1.put("play_icon", "readinjoy_ad_small_game");
            paramJSONObject.put("id_left_play_icon", paramBaseArticleInfo1);
            paramJSONObject.remove("id_left_comment_icon");
            paramJSONObject.remove("left_comment_count");
          }
          if (ReadInJoyAdUtils.l(paramBaseArticleInfo2))
          {
            paramBaseArticleInfo1 = ReadInJoyAdUtils.a(paramBaseArticleInfo2.mCommentCount, HardCodeUtil.a(2131702139));
            paramJSONObject.put("right_play_count", HardCodeUtil.a(2131699885) + " " + paramBaseArticleInfo1);
            paramBaseArticleInfo1 = new JSONObject();
            paramBaseArticleInfo1.put("play_icon", "readinjoy_ad_small_game");
            paramJSONObject.put("id_right_play_icon", paramBaseArticleInfo1);
            paramJSONObject.remove("id_right_comment_icon");
            paramJSONObject.remove("right_comment_count");
            return;
          }
        }
        catch (Exception paramBaseArticleInfo1)
        {
          QLog.d("DoubleVideoProteusItem", 2, "small game json error" + paramBaseArticleInfo1.getMessage());
        }
      }
    }
  }
  
  private void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramBaseArticleInfo == null)) {
      return;
    }
    if (paramBaseArticleInfo.subscriptLocation != 0)
    {
      QLog.d("DoubleVideoProteusItem", 2, "bindLeftSubscriptInfo | wrong position");
      return;
    }
    RIJJsonUtils.a(paramJSONObject, "left_mark_text", paramBaseArticleInfo.subscriptWording);
    RIJJsonUtils.a(paramJSONObject, "left_mark_color", paramBaseArticleInfo.subscriptWordingColor);
    RIJJsonUtils.a(paramJSONObject, "left_mark_backgroundcolor", paramBaseArticleInfo.subscriptBgColor);
    paramJSONObject.put("left_corner_mark", paramBaseArticleInfo.subscriptType);
  }
  
  private void b(BaseArticleInfo paramBaseArticleInfo, JSONObject paramJSONObject, boolean paramBoolean)
  {
    Object localObject;
    if (paramBaseArticleInfo != null)
    {
      int i = paramBaseArticleInfo.getCommentCount();
      if (i <= 0) {
        break label431;
      }
      localObject = VideoFeedsHelper.e(i);
      if (paramBoolean)
      {
        paramJSONObject.put("left_comment_count", localObject);
        paramJSONObject.put("left_play_count", VideoFeedsHelper.c(paramBaseArticleInfo.mVideoPlayCount));
        paramJSONObject.put("play_icon", "ReadInJoy/video_play_icon.png");
        paramJSONObject.put("comment_icon", "comment_icon_white");
      }
      if ((paramBaseArticleInfo.richTitleInfoList != null) && (paramBaseArticleInfo.richTitleInfoList.size() > 0)) {
        break label439;
      }
      paramJSONObject.put("left_article_title", paramBaseArticleInfo.mTitle);
      paramJSONObject.put("left_title_num", ReadInJoyHelper.e() + "");
      paramJSONObject.put("title_num", ReadInJoyHelper.e() + "");
      label155:
      if ((!paramBaseArticleInfo.isUseGif) || (!NetworkUtil.h(BaseApplicationImpl.getContext()))) {
        break label454;
      }
      paramBoolean = true;
      label173:
      paramBaseArticleInfo.isShowGif = paramBoolean;
      if (!paramBaseArticleInfo.isShowGif) {
        break label459;
      }
      paramJSONObject.put("left_cover_gif", paramBaseArticleInfo.gifCoverUrl);
      paramJSONObject.put("left_cover_url", paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile());
    }
    for (;;)
    {
      if ((paramBaseArticleInfo.isAccountShown) && (paramBaseArticleInfo.mPartnerAccountInfo != null))
      {
        long l = paramBaseArticleInfo.mPartnerAccountInfo.uint64_uin.get();
        paramJSONObject.put("left_account_uin", l + "");
        localObject = RIJPBFieldUtils.b(paramBaseArticleInfo.mPartnerAccountInfo.bytes_v_icon_url);
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          paramJSONObject.put("left_account_small_icon_url", localObject);
        }
      }
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mVideoArticleSubsColor))
      {
        paramJSONObject.put("left_item_subscript_text", paramBaseArticleInfo.mVideoArticleSubsText);
        String str = paramBaseArticleInfo.mVideoArticleSubsColor;
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = "#00a5e0";
        }
        paramJSONObject.put("left_item_subscript_bg_color", localObject);
      }
      b(paramBaseArticleInfo, paramJSONObject);
      if (!TextUtils.isEmpty(paramBaseArticleInfo.smallGameData))
      {
        paramJSONObject.put("left_comment_count", ReadInJoyAdUtils.a(paramBaseArticleInfo.mCommentCount, HardCodeUtil.a(2131702139)));
        paramJSONObject.put("left_play_count", HardCodeUtil.a(2131699885));
        paramBaseArticleInfo = new JSONObject();
        paramBaseArticleInfo.put("play_icon", "readinjoy_ad_small_game");
        paramJSONObject.put("id_left_play_icon", paramBaseArticleInfo);
      }
      return;
      label431:
      localObject = "0";
      break;
      label439:
      Util.a(paramBaseArticleInfo, paramJSONObject, "left_rich_text_line", "left_rich_text_info", true);
      break label155;
      label454:
      paramBoolean = false;
      break label173;
      label459:
      localObject = paramBaseArticleInfo.getVideoCoverUrlWithSmartCut(true).getFile();
      paramJSONObject.put("left_cover_image_url", localObject);
      FluencyOptUtils.a.a((String)localObject);
    }
  }
  
  private void b(ViewBase paramViewBase, BaseArticleInfo paramBaseArticleInfo)
  {
    View localView;
    RIJDtParamBuilder localRIJDtParamBuilder;
    if (("id_left_item_cover_imageview".equals(paramViewBase.getViewId())) || ("id_left_item_gif_imageview".equals(paramViewBase.getViewId())))
    {
      VideoReport.setElementExposePolicy(paramViewBase.getNativeView(), ExposurePolicy.REPORT_FIRST);
      VideoReport.setElementEndExposePolicy(paramViewBase.getNativeView(), EndExposurePolicy.REPORT_ALL);
      VideoReport.setElementId(paramViewBase.getNativeView(), "card");
      localView = paramViewBase.getNativeView();
      localRIJDtParamBuilder = new RIJDtParamBuilder().a(Long.valueOf(paramBaseArticleInfo.mChannelID));
      if (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)) {
        break label121;
      }
    }
    label121:
    for (String str = "null";; str = paramBaseArticleInfo.innerUniqueID)
    {
      VideoReport.setElementParams(localView, localRIJDtParamBuilder.e(str).a());
      VideoReport.setElementReuseIdentifier(paramViewBase.getNativeView(), paramBaseArticleInfo.innerUniqueID);
      return;
    }
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject1;
    JSONObject localJSONObject;
    boolean bool;
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSubArtilceList != null) && (paramBaseArticleInfo.mSubArtilceList.size() > 0))
    {
      localObject1 = (ArticleInfo)paramBaseArticleInfo.mSubArtilceList.get(0);
      localJSONObject = new JSONObject();
      bool = ReadInJoyHelper.u();
    }
    for (;;)
    {
      try
      {
        b(paramBaseArticleInfo, localJSONObject, bool);
        a((BaseArticleInfo)localObject1, localJSONObject, bool);
        a(paramBaseArticleInfo, (BaseArticleInfo)localObject1, localJSONObject);
        b(paramBaseArticleInfo, (BaseArticleInfo)localObject1, localJSONObject);
        if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.multiVideoColumnInfo == null)) {
          continue;
        }
        localObject2 = Integer.valueOf(paramBaseArticleInfo.multiVideoColumnInfo.a);
        localJSONObject.put("column_id_1", localObject2);
        if ((localObject1 == null) || (((BaseArticleInfo)localObject1).multiVideoColumnInfo == null)) {
          continue;
        }
        localObject1 = Integer.valueOf(((BaseArticleInfo)localObject1).multiVideoColumnInfo.a);
        localJSONObject.put("column_id_2", localObject1);
        localJSONObject.put("style_ID", "ReadInjoy_double_video_cell");
      }
      catch (Exception localException)
      {
        Object localObject2;
        QLog.d("DoubleVideoProteusItem", 2, localException.getMessage());
        continue;
      }
      Util.a(localJSONObject, paramBaseArticleInfo);
      return localJSONObject;
      localObject1 = null;
      break;
      localObject2 = "";
      continue;
      localObject1 = "";
    }
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ArticleInfo localArticleInfo2 = paramIReadInJoyModel.a();
    if (localArticleInfo2 != null) {
      if ((localArticleInfo2 == null) || (localArticleInfo2.mSubArtilceList == null) || (localArticleInfo2.mSubArtilceList.size() <= 0)) {
        break label118;
      }
    }
    label118:
    for (ArticleInfo localArticleInfo1 = (ArticleInfo)localArticleInfo2.mSubArtilceList.get(0);; localArticleInfo1 = null)
    {
      if ((localArticleInfo2 != null) && (localArticleInfo2.isAccountShown)) {
        AccountShowUtils.a(paramContainer, paramIReadInJoyModel, "id_left_account_name");
      }
      if ((localArticleInfo1 != null) && (localArticleInfo1.isAccountShown)) {
        AccountShowUtils.a(paramContainer, paramIReadInJoyModel, "id_right_account_name");
      }
      if (paramContainer != null)
      {
        MultiVideoHelper.a(localArticleInfo2, BaseActivity.sTopActivity);
        MultiVideoHelper.a(localArticleInfo1, BaseActivity.sTopActivity);
      }
      return;
    }
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, JSONObject paramJSONObject)
  {
    VideoColumnInfo localVideoColumnInfo;
    if ((paramBaseArticleInfo1 != null) && (paramBaseArticleInfo1.columnEntrances != null) && (!paramBaseArticleInfo1.columnEntrances.isEmpty()) && (paramBaseArticleInfo2 != null) && (paramBaseArticleInfo2.columnEntrances != null) && (!paramBaseArticleInfo2.columnEntrances.isEmpty()))
    {
      localVideoColumnInfo = (VideoColumnInfo)paramBaseArticleInfo1.columnEntrances.get(0);
      paramBaseArticleInfo2 = (VideoColumnInfo)paramBaseArticleInfo2.columnEntrances.get(0);
      if ((localVideoColumnInfo != null) && (paramBaseArticleInfo2 != null))
      {
        if ((localVideoColumnInfo.a == 0) || (localVideoColumnInfo.a != paramBaseArticleInfo2.a)) {
          break label110;
        }
        Util.an(paramBaseArticleInfo1, paramJSONObject);
      }
    }
    label110:
    do
    {
      return;
      if (localVideoColumnInfo.a != 0)
      {
        paramJSONObject.put("column_tips_left", "栏目");
        paramJSONObject.put("column_name_left", localVideoColumnInfo.b);
        paramJSONObject.put("readinjoy_column_icon_left", "readinjoy_column_icon_white");
      }
    } while (paramBaseArticleInfo2.a == 0);
    paramJSONObject.put("column_tips_right", "栏目");
    paramJSONObject.put("column_name_right", paramBaseArticleInfo2.b);
    paramJSONObject.put("readinjoy_column_icon_right", "readinjoy_column_icon_white");
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    int i = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
    ArticleInfo localArticleInfo = paramIReadInJoyModel.a();
    if ((localArticleInfo != null) && (localArticleInfo.mSubArtilceList != null) && (localArticleInfo.mSubArtilceList.size() > 0)) {}
    for (paramContainer = (ArticleInfo)localArticleInfo.mSubArtilceList.get(0); (localArticleInfo == null) || (paramContainer == null); paramContainer = null) {
      return false;
    }
    if (localArticleInfo.mProteusTemplateBean != null) {
      paramContainer.mProteusTemplateBean = localArticleInfo.mProteusTemplateBean;
    }
    return a(paramIReadInJoyModel, paramViewBase, i, localArticleInfo, localArticleInfo, paramContainer, paramInt).booleanValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.item.DoubleVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */