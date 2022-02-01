package com.tencent.biz.pubaccount.readinjoy.comment;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.comment.base.ReadInJoyCommentEntrance;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.MediaData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.CommentGuideConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.Utils;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentUtils
{
  private static final Pattern a = Pattern.compile("\n|\r\n");
  
  private static SpannableString a(String paramString1, String paramString2, String paramString3)
  {
    SpannableString localSpannableString = new SpannableString(paramString1);
    int i = paramString1.lastIndexOf(paramString2);
    int j = paramString2.length();
    if ((i < 0) || (TextUtils.isEmpty(paramString3))) {
      return localSpannableString;
    }
    localSpannableString.setSpan(new ReadInJoyCommentUtils.7(paramString3), i, j + i, 33);
    return localSpannableString;
  }
  
  public static Pair<Integer, Integer> a(ArticleInfo paramArticleInfo, CommonCommentData paramCommonCommentData)
  {
    int j = 20;
    int i;
    if ((paramCommonCommentData != null) && (paramCommonCommentData.getAdTag() != -1))
    {
      j = paramCommonCommentData.getAdTag();
      i = paramCommonCommentData.getAdTag();
    }
    for (;;)
    {
      return new Pair(Integer.valueOf(i), Integer.valueOf(j));
      if (paramArticleInfo != null)
      {
        if (((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (RIJFeedsType.a(paramArticleInfo)))
        {
          i = 2;
          continue;
        }
        if ((ReadInJoyDeliverBiuActivity.b(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null))
        {
          if (ReadInJoyDeliverBiuActivity.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
            i = 9;
          }
        }
        else if (paramArticleInfo.mIsGallery != 0)
        {
          j = 10;
          i = 17;
          continue;
        }
      }
      j = 19;
      i = 4;
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return "";
    }
    if (((RIJItemViewType.g(paramArticleInfo)) || (RIJItemViewType.i(paramArticleInfo))) && (paramArticleInfo.mSocialFeedInfo != null)) {
      return String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
    }
    return paramArticleInfo.mSubscribeID;
  }
  
  public static String a(String paramString)
  {
    return ReadInJoyConstants.g + Base64Util.encodeToString(paramString.getBytes(), 2);
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || ((!TextUtils.isEmpty(paramString)) && (paramString.length() <= paramInt))) {
      return paramString;
    }
    if (!TextUtils.isEmpty(paramString)) {
      return paramString.substring(0, paramInt) + "...";
    }
    return "";
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    String str2 = UUID.randomUUID().toString();
    String str1 = Utils.a(paramString, str2);
    paramString = str1;
    if (paramBoolean) {
      paramString = str1.trim();
    }
    if (paramString.length() <= 0) {
      return "";
    }
    return EmotionCodecUtils.a(Utils.b(a.matcher(paramString).replaceAll(""), str2));
  }
  
  private static void a()
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(ReadInJoyUtils.a()), "0X800B99A", "0X800B99A", 0, 0, "", "", "", "", false);
  }
  
  public static void a(long paramLong, boolean paramBoolean)
  {
    ArticleInfo localArticleInfo = ReadInJoyLogicEngine.a().a(0, paramLong);
    SocializeFeedsInfo localSocializeFeedsInfo;
    if ((localArticleInfo != null) && (localArticleInfo.mSocialFeedInfo != null))
    {
      if (!paramBoolean) {
        break label68;
      }
      localSocializeFeedsInfo = localArticleInfo.mSocialFeedInfo;
    }
    for (localSocializeFeedsInfo.d += 1;; localSocializeFeedsInfo.d -= 1)
    {
      localArticleInfo.invalidateProteusTemplateBean();
      ReadInJoyLogicEngine.a().c(localArticleInfo);
      ThreadManager.getUIHandler().post(new ReadInJoyCommentUtils.3());
      return;
      label68:
      localSocializeFeedsInfo = localArticleInfo.mSocialFeedInfo;
    }
  }
  
  public static void a(Activity paramActivity, ReadInJoyCommentUtils.CustomDialogClickListener paramCustomDialogClickListener)
  {
    if (paramActivity == null) {
      return;
    }
    Object localObject2 = Aladdin.getConfig(430);
    Object localObject1 = ((AladdinConfig)localObject2).getString("comment_dirty_word_content", paramActivity.getString(2131718140));
    String str1 = ((AladdinConfig)localObject2).getString("comment_dirty_word_hyperlink_text", paramActivity.getString(2131718141));
    String str4 = ((AladdinConfig)localObject2).getString("comment_dirty_word_hyperlink_url", "");
    localObject2 = paramActivity.getString(2131718144);
    String str2 = paramActivity.getString(2131718143);
    String str3 = paramActivity.getString(2131718142);
    localObject1 = a((String)localObject1, str1, str4);
    paramActivity = DialogUtil.a(paramActivity, 230).setTitle((String)localObject2).setMessageWithoutAutoLink((CharSequence)localObject1).setPositiveButton(str2, new ReadInJoyCommentUtils.6(paramCustomDialogClickListener)).setNegativeButton(str3, new ReadInJoyCommentUtils.5(paramCustomDialogClickListener));
    a(paramActivity);
    paramActivity.show();
    a();
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, CommentInfo paramCommentInfo, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2, ReadInJoyCommentUtils.CommentComponetEventListener paramCommentComponetEventListener, int paramInt2)
  {
    RIJUserLevelModule.a().a(paramActivity, 3, new ReadInJoyCommentUtils.1(paramActivity, paramArticleInfo, paramCommentInfo, paramInt1, paramString1, paramString2, paramBoolean1, paramString3, paramBoolean2, paramCommentComponetEventListener, paramInt2));
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, BaseCommentData paramBaseCommentData, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, ReadInJoyCommentUtils.CommentComponetEventListener paramCommentComponetEventListener, int paramInt2)
  {
    a(paramActivity, paramArticleInfo, paramBaseCommentData, paramInt1, paramString1, paramString2, paramBoolean, paramCommentComponetEventListener, paramInt2, true);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, BaseCommentData paramBaseCommentData, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, ReadInJoyCommentUtils.CommentComponetEventListener paramCommentComponetEventListener, int paramInt2, boolean paramBoolean2)
  {
    if (paramActivity == null)
    {
      QLog.d("ReadInJoyCommentUtils", 1, "openCommentComponentNew | activity is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("arg_comment_enable_anonymous", false);
    localIntent.putExtra("arg_comment_placeholder", paramString1);
    localIntent.putExtra("arg_comment_default_txt", paramString2);
    localIntent.putExtra("arg_comment_max_length", -1);
    localIntent.putExtra("arg_comment_open_at", false);
    localIntent.putExtra("arg_comment_gif_switch", false);
    localIntent.putExtra("arg_comment_zhitu_switch", false);
    localIntent.putExtra("arg_comment_transparent_bg", paramBoolean1);
    localIntent.putExtra("comment_native", true);
    localIntent.putExtra("comment_reply_second", paramBaseCommentData instanceof SubCommentData);
    localIntent.putExtra("click_comment_edit_src", paramInt2);
    localIntent.putExtra("comment_article_info", paramArticleInfo);
    localIntent.putExtra("biu_src", paramInt1);
    QLog.d("ReadInJoyCommentUtils", 2, "openCommentComponent | comment_placeholder after decode: " + paramString1);
    paramInt2 = 2;
    if (paramBaseCommentData != null)
    {
      localIntent.putExtra("comment_id", paramBaseCommentData.commentId);
      localIntent.putExtra("first_comment_uin", paramBaseCommentData.uin);
      paramString1 = paramBaseCommentData.getWholeStringContent();
      paramString2 = paramBaseCommentData.uin;
      localIntent.putExtra("comment_val", paramString1);
      localIntent.putExtra("comment_author_uin", paramString2);
      if ((paramBaseCommentData != null) && (paramBaseCommentData.mediaDataList != null) && (paramBaseCommentData.mediaDataList.size() > 0) && (((BaseCommentData.MediaData)paramBaseCommentData.mediaDataList.get(0)).e != 0)) {
        localIntent.putExtra("comment_can_biu", false);
      }
      if ((paramBaseCommentData.commentLinkDataList != null) && (!paramBaseCommentData.commentLinkDataList.isEmpty())) {
        break label437;
      }
    }
    label437:
    for (paramInt2 = 0;; paramInt2 = 1)
    {
      localIntent.putExtra("comment_to_reply_contain_link", paramInt2);
      if (paramArticleInfo != null) {
        localIntent.putExtra("feedsType", paramArticleInfo.mFeedType);
      }
      if ((paramBaseCommentData instanceof SubCommentData)) {
        localIntent.putExtra("comment_reply_second_uin", paramBaseCommentData.uin);
      }
      if (paramInt1 == 2) {
        localIntent.putExtra("comment_is_show_pic", CommentGuideConfigHandler.a());
      }
      localIntent.putExtra("arg_ad_show_biu", paramBoolean2);
      ReadInJoyCommentEntrance.a(paramActivity, localIntent, 117);
      if (paramCommentComponetEventListener == null) {
        break;
      }
      paramCommentComponetEventListener.a();
      return;
    }
  }
  
  public static void a(ArticleInfo paramArticleInfo, CommentInfo paramCommentInfo, boolean paramBoolean)
  {
    if ((paramArticleInfo == null) || (paramCommentInfo == null)) {
      QLog.d("ReadInJoyCommentUtils", 2, "localUpdateCommentData: articleInfo or commentInfo is null");
    }
    do
    {
      return;
      long l = paramArticleInfo.mRecommendSeq;
      paramArticleInfo = ReadInJoyLogicEngine.a().a((int)paramArticleInfo.mChannelID, l);
    } while (paramArticleInfo == null);
    if (!paramBoolean)
    {
      paramCommentInfo = paramArticleInfo.mSocialFeedInfo;
      paramCommentInfo.d += 1;
    }
    paramArticleInfo.invalidateProteusTemplateBean();
    ThreadManager.getUIHandler().post(new ReadInJoyCommentUtils.2());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent, int paramInt)
  {
    if (paramIntent == null)
    {
      QQToast.a(BaseApplication.getContext(), 1, BaseApplication.getContext().getString(2131718159), 0).a();
      QLog.d("ReadInJoyCommentUtils", 2, "comment result intent data is null");
    }
    ArticleInfo localArticleInfo;
    boolean bool;
    do
    {
      return;
      paramQQAppInterface = paramIntent.getStringExtra("arg_result_json");
      localArticleInfo = (ArticleInfo)paramIntent.getParcelableExtra("comment_article_info");
      bool = paramIntent.getBooleanExtra("comment_gallery_channel", false);
    } while ((paramInt != -1) && (paramInt != 1699));
    if ((localArticleInfo != null) && (bool))
    {
      ReadInJoyCommentDataManager.a(localArticleInfo, 0).d(paramQQAppInterface);
      ReadInJoyCommentDataManager.a(localArticleInfo);
      return;
    }
    ReadInJoyLogicEngine.a().a(localArticleInfo, paramQQAppInterface);
  }
  
  private static void a(QQCustomDialog paramQQCustomDialog)
  {
    paramQQCustomDialog.getBtnight().setTextColor(Color.parseColor("#00CAFC"));
    paramQQCustomDialog.getBtnight().getPaint().setFakeBoldText(true);
    paramQQCustomDialog.getBtnLeft().getPaint().setFakeBoldText(true);
    paramQQCustomDialog.getTitleTextView().getPaint().setFakeBoldText(true);
  }
  
  public static void a(String paramString, Context paramContext)
  {
    a(paramString, paramContext, null);
  }
  
  public static void a(String paramString, Context paramContext, ArticleInfo paramArticleInfo)
  {
    if (paramContext == null) {
      return;
    }
    paramString = ReadinjoyReportUtils.a(paramArticleInfo, ReadInJoyConstants.g + Base64Util.encodeToString(paramString.getBytes(), 2), ReadinjoyReportUtils.g);
    ReadInJoyUtils.a(paramContext, paramString);
    QLog.d("ReadInJoyCommentUtils", 1, "personal url =" + paramString);
  }
  
  public static void a(String paramString, ArticleInfo paramArticleInfo, RIJTransMergeKanDianReport.ReportR5Builder paramReportR5Builder)
  {
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, a(paramArticleInfo), paramString, paramString, 0, 0, String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), paramArticleInfo.innerUniqueID, paramReportR5Builder.a(), false);
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramString == null) || (paramContext == null)) {
      return false;
    }
    paramContext = (ClipboardManager)paramContext.getSystemService("clipboard");
    if (paramContext.hasPrimaryClip())
    {
      paramContext = paramContext.getPrimaryClip();
      if ((paramContext != null) && (paramContext.getItemCount() > 0))
      {
        paramContext = paramContext.getItemAt(0);
        if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.getText())))
        {
          paramContext = String.valueOf(paramContext.getText());
          paramString = new QQText(EmotionCodecUtils.b(paramString), 7, 18).toString();
          if (!TextUtils.isEmpty(paramContext)) {
            return paramContext.contains(paramString);
          }
        }
      }
    }
    return false;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, String paramString)
  {
    if (paramArticleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentUtils", 2, " marticleinfo=null");
      }
      return false;
    }
    SocializeFeedsInfo localSocializeFeedsInfo = new SocializeFeedsInfo();
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo();
    ArrayList localArrayList = new ArrayList();
    int j;
    int k;
    int i;
    try
    {
      paramString = new JSONObject(paramString).getJSONObject("biu_info");
      j = paramString.optInt("biuSrc");
      k = paramString.optInt("feedtype");
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null))
      {
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b;
        localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong;
      }
      paramString = paramString.optJSONArray("biuinfo");
      i = 0;
      if (i < paramString.length())
      {
        paramString.getJSONObject(i);
        localObject = paramString.getJSONObject(i).optString("biu_uin");
        if ((paramString.getJSONObject(i).opt("biu_feedid") instanceof Integer)) {}
        for (long l = ((Integer)paramString.getJSONObject(i).opt("biu_feedid")).intValue();; l = ((Long)paramString.getJSONObject(i).opt("biu_feedid")).longValue())
        {
          localObject = new ReadInJoyCommentUtils.UserBiuInfo((String)localObject, l, paramString.getJSONObject(i).optString("biu_info_comment"));
          ((ReadInJoyCommentUtils.UserBiuInfo)localObject).jdField_a_of_type_Int = paramString.getJSONObject(i).optInt("biu_optype");
          ((ReadInJoyCommentUtils.UserBiuInfo)localObject).jdField_a_of_type_JavaLangCharSequence = paramString.getJSONObject(i).optString("biu_nickname");
          localArrayList.add(localObject);
          i += 1;
          break;
        }
      }
      if (!QLog.isColorLevel()) {
        break label379;
      }
    }
    catch (Exception paramArticleInfo)
    {
      return false;
    }
    paramString = new StringBuilder("onDeliver deliverList:\n");
    Object localObject = localArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      paramString.append(((ReadInJoyCommentUtils.UserBiuInfo)((Iterator)localObject).next()).toString()).append("\n");
    }
    QLog.d("ReadInJoyCommentUtils", 2, paramString.toString());
    label379:
    if ((paramArticleInfo != null) && (localArrayList.size() > 0))
    {
      i = 1;
      for (;;)
      {
        if (i < localArrayList.size())
        {
          localObject = (ReadInJoyCommentUtils.UserBiuInfo)localArrayList.get(i);
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo();
          try
          {
            localBiuCommentInfo.mUin = Long.valueOf(((ReadInJoyCommentUtils.UserBiuInfo)localObject).jdField_a_of_type_JavaLangString);
            if (((ReadInJoyCommentUtils.UserBiuInfo)localObject).b == null)
            {
              paramString = "";
              localBiuCommentInfo.mBiuComment = paramString;
              localBiuCommentInfo.mOpType = ((ReadInJoyCommentUtils.UserBiuInfo)localObject).jdField_a_of_type_Int;
              localBiuCommentInfo.mFeedId = Long.valueOf(((ReadInJoyCommentUtils.UserBiuInfo)localObject).jdField_a_of_type_Long);
              localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo);
              i += 1;
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              localBiuCommentInfo.mUin = Long.valueOf(0L);
              continue;
              paramString = ((ReadInJoyCommentUtils.UserBiuInfo)localObject).b.toString();
            }
          }
        }
      }
      ReadInJoyLogicEngine.a().a(ReadInJoyUtils.a(), paramArticleInfo.mFeedId, localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo, 0L, ((ReadInJoyCommentUtils.UserBiuInfo)localArrayList.get(0)).b.toString(), paramArticleInfo.mArticleID, paramArticleInfo.mRecommendSeq, j, paramArticleInfo.innerUniqueID, k, paramArticleInfo);
    }
    return true;
  }
  
  private static void b(int paramInt)
  {
    Object localObject1 = "";
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("os", 1);
      ((JSONObject)localObject2).put("version", VideoReporter.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).put("place", paramInt);
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.d("ReadInJoyCommentUtils", 2, localJSONException.getMessage());
      }
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(ReadInJoyUtils.a()), "0X800B99B", "0X800B99B", 0, 0, "", "", "", (String)localObject1, false);
  }
  
  public static void b(Activity paramActivity, ArticleInfo paramArticleInfo, CommentInfo paramCommentInfo, int paramInt1, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2, ReadInJoyCommentUtils.CommentComponetEventListener paramCommentComponetEventListener, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("arg_comment_enable_anonymous", false);
    localIntent.putExtra("arg_comment_placeholder", paramString1);
    localIntent.putExtra("arg_comment_default_txt", paramString2);
    localIntent.putExtra("arg_comment_max_length", -1);
    localIntent.putExtra("arg_comment_open_at", false);
    localIntent.putExtra("arg_comment_gif_switch", false);
    localIntent.putExtra("arg_comment_zhitu_switch", false);
    localIntent.putExtra("arg_comment_transparent_bg", paramBoolean2);
    localIntent.putExtra("comment_native", true);
    localIntent.putExtra("comment_reply_second", paramBoolean1);
    localIntent.putExtra("click_comment_edit_src", paramInt2);
    if (paramCommentInfo != null)
    {
      localIntent.putExtra("comment_id", paramCommentInfo.commentId);
      localIntent.putExtra("first_comment_uin", paramCommentInfo.authorUin);
    }
    localIntent.putExtra("comment_article_info", paramArticleInfo);
    if (paramCommentInfo != null)
    {
      paramString1 = paramCommentInfo.commentContent;
      paramCommentInfo = paramCommentInfo.authorUin;
      localIntent.putExtra("comment_val", paramString1);
      localIntent.putExtra("comment_author_uin", paramCommentInfo);
    }
    localIntent.putExtra("biu_src", paramInt1);
    if (paramArticleInfo != null) {
      localIntent.putExtra("feedsType", paramArticleInfo.mFeedType);
    }
    if (paramBoolean1) {
      localIntent.putExtra("comment_reply_second_uin", paramString3);
    }
    if ((paramArticleInfo instanceof AdvertisementInfo)) {
      localIntent.putExtra("arg_ad_show_biu", false);
    }
    ReadInJoyCommentEntrance.a(paramActivity, localIntent, 117);
    if (paramCommentComponetEventListener != null) {
      paramCommentComponetEventListener.a();
    }
  }
  
  public static void b(String paramString, Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      do
      {
        return;
      } while ((!paramString.startsWith("http")) && (!paramString.startsWith("https")));
      ReadInJoyUtils.a(paramContext, paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyCommentUtils", 2, "personal url =" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils
 * JD-Core Version:    0.7.0.1
 */