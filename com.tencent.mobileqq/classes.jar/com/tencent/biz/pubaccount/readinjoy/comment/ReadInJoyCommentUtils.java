package com.tencent.biz.pubaccount.readinjoy.comment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ljy;
import ljz;
import lka;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentUtils
{
  public static String a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return "";
    }
    if ((ReadInJoyBaseAdapter.f(paramArticleInfo)) || (ReadInJoyBaseAdapter.g(paramArticleInfo))) {
      return String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.a);
    }
    return paramArticleInfo.mSubscribeID;
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt, String paramString)
  {
    int i = 1;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("algorithm_id", paramArticleInfo.mAlgorithmID);
        if (paramInt == 1)
        {
          localJSONObject.put("puin_type", 1);
          localJSONObject.put("source", ReadInJoyUtils.d());
          localJSONObject.put("kandian_mode", ReadInJoyUtils.e());
          localJSONObject.put("comment_id", paramString);
          localJSONObject.put("mp_article_id", paramArticleInfo.mArticleID);
          localJSONObject.put("entry", paramInt);
          return localJSONObject.toString();
        }
        if (paramInt == 2) {
          if (paramArticleInfo.mAccountLess == 0) {
            localJSONObject.put("puin_type", i);
          } else {
            i = 2;
          }
        }
      }
      catch (JSONException paramArticleInfo)
      {
        paramArticleInfo.printStackTrace();
        return "";
      }
    }
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      paramArticleInfo = new JSONObject(a(paramArticleInfo, paramInt1, paramString));
      paramArticleInfo.put("comment_number", paramInt2);
      paramArticleInfo = paramArticleInfo.toString();
      return paramArticleInfo;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return "";
  }
  
  public static String a(ArticleInfo paramArticleInfo, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    try
    {
      paramArticleInfo = new JSONObject(a(paramArticleInfo, paramInt1, paramString));
      if (paramInt2 < 2) {
        paramArticleInfo.put("comment_level", paramInt2);
      }
      if (paramInt3 < 3) {
        paramArticleInfo.put("actionsheet_choose", paramInt3);
      }
      paramArticleInfo = paramArticleInfo.toString();
      return paramArticleInfo;
    }
    catch (JSONException paramArticleInfo)
    {
      paramArticleInfo.printStackTrace();
    }
    return "";
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, CommentInfo paramCommentInfo, int paramInt, String paramString1, String paramString2, boolean paramBoolean1, String paramString3, boolean paramBoolean2)
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
    if (paramCommentInfo != null)
    {
      localIntent.putExtra("comment_id", paramCommentInfo.commentId);
      localIntent.putExtra("first_comment_uin", paramCommentInfo.authorUin);
    }
    localIntent.putExtra("comment_articleid", paramArticleInfo);
    if (paramCommentInfo != null)
    {
      paramString1 = paramCommentInfo.commentContent;
      paramCommentInfo = paramCommentInfo.authorUin;
      localIntent.putExtra("comment_val", paramString1);
      localIntent.putExtra("comment_author_uin", paramCommentInfo);
    }
    localIntent.putExtra("biu_src", paramInt);
    if (paramArticleInfo != null) {
      localIntent.putExtra("feedsType", paramArticleInfo.mFeedType);
    }
    if (paramBoolean1) {
      localIntent.putExtra("comment_reply_second_uin", paramString3);
    }
    PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicTransFragmentActivity.class, ReadInJoyCommentComponentFragment.class, 117);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArticleCommentModule paramArticleCommentModule, CommentInfo paramCommentInfo1, ImageView paramImageView, TextView paramTextView, int paramInt1, CommentInfo paramCommentInfo2, ArticleInfo paramArticleInfo, boolean paramBoolean, String paramString, int paramInt2, ReadInJoySecondCommentListAdapter.SecondCommentOperationCallback paramSecondCommentOperationCallback)
  {
    if ((paramArticleCommentModule == null) || (paramCommentInfo1 == null)) {
      return;
    }
    String str;
    label82:
    label91:
    long l;
    if (paramCommentInfo1.liked)
    {
      if (paramCommentInfo1.likeCount > 999)
      {
        paramTextView.setText("999+");
        paramImageView.setImageResource(2130840725);
        paramTextView.setTextColor(Color.parseColor("#9D9D9D"));
        str = System.currentTimeMillis() + "";
        if (paramCommentInfo2 != null) {
          break label258;
        }
        paramImageView = paramCommentInfo1.commentId;
        if (paramCommentInfo2 != null) {
          break label267;
        }
        paramTextView = "";
        paramArticleCommentModule.commentLike(paramQQAppInterface, str, paramInt1, paramImageView, paramTextView, 0, paramString, paramInt2, new ljy(paramInt1, paramSecondCommentOperationCallback));
        if (paramCommentInfo1 != null)
        {
          paramCommentInfo1.likeCount -= 1;
          paramCommentInfo1.liked = false;
        }
        if ((paramInt1 != 1) || (paramCommentInfo2 != null)) {
          break label276;
        }
        paramArticleCommentModule = "0X800900F";
        label153:
        paramImageView = a(paramArticleInfo);
        l = paramArticleInfo.mArticleID;
        paramInt2 = paramArticleInfo.mStrategyId;
        paramTextView = paramArticleInfo.innerUniqueID;
        if (!paramBoolean) {
          break label283;
        }
      }
      label258:
      label267:
      label276:
      label283:
      for (paramInt1 = 2;; paramInt1 = 1)
      {
        PublicAccountReportUtils.a(paramQQAppInterface, paramImageView, paramArticleCommentModule, paramArticleCommentModule, 0, 0, String.valueOf(l), String.valueOf(paramInt2), paramTextView, a(paramArticleInfo, paramInt1, paramCommentInfo1.commentId), false);
        return;
        if (paramCommentInfo1.likeCount - 1 < 0) {}
        for (int i = 0;; i = paramCommentInfo1.likeCount - 1)
        {
          paramTextView.setText(String.valueOf(i));
          break;
        }
        paramImageView = paramCommentInfo2.commentId;
        break label82;
        paramTextView = paramCommentInfo1.commentId;
        break label91;
        paramArticleCommentModule = "0X8009016";
        break label153;
      }
    }
    if (paramCommentInfo1.likeCount > 999)
    {
      paramTextView.setText("999+");
      paramImageView.setImageResource(2130840726);
      paramTextView.setTextColor(Color.parseColor("#07D0B0"));
      str = System.currentTimeMillis() + "";
      if (paramCommentInfo2 != null) {
        break label532;
      }
      paramImageView = paramCommentInfo1.commentId;
      label357:
      if (paramCommentInfo2 != null) {
        break label541;
      }
      paramTextView = "";
      label366:
      paramArticleCommentModule.commentLike(paramQQAppInterface, str, paramInt1, paramImageView, paramTextView, 1, paramString, paramInt2, new ljz(paramInt1, paramSecondCommentOperationCallback));
      if (paramCommentInfo1 != null)
      {
        paramCommentInfo1.likeCount += 1;
        paramCommentInfo1.liked = true;
      }
      if ((paramInt1 != 1) || (paramCommentInfo2 != null)) {
        break label550;
      }
      paramArticleCommentModule = "0X800900E";
      label428:
      paramImageView = a(paramArticleInfo);
      l = paramArticleInfo.mArticleID;
      paramInt2 = paramArticleInfo.mStrategyId;
      paramTextView = paramArticleInfo.innerUniqueID;
      if (!paramBoolean) {
        break label557;
      }
    }
    label532:
    label541:
    label550:
    label557:
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      PublicAccountReportUtils.a(paramQQAppInterface, paramImageView, paramArticleCommentModule, paramArticleCommentModule, 0, 0, String.valueOf(l), String.valueOf(paramInt2), paramTextView, a(paramArticleInfo, paramInt1, paramCommentInfo1.commentId), false);
      return;
      if (paramCommentInfo1.likeCount < 0)
      {
        paramTextView.setText("0");
        break;
      }
      paramTextView.setText(String.valueOf(paramCommentInfo1.likeCount + 1));
      break;
      paramImageView = paramCommentInfo2.commentId;
      break label357;
      paramTextView = paramCommentInfo1.commentId;
      break label366;
      paramArticleCommentModule = "0X8009015";
      break label428;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArticleInfo paramArticleInfo, int paramInt1, String paramString1, String paramString2, boolean paramBoolean, ArticleCommentModule paramArticleCommentModule, int paramInt2, ReadInJoyCommentUtils.CreateCommentInterface paramCreateCommentInterface)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyCommentUtils", 2, "result is null");
      }
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject(paramString2);
        str2 = new String(Base64Util.decode(((JSONObject)localObject).getString("comment"), 0));
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyCommentUtils", 2, "comment = " + str2);
        }
        localJSONArray = ((JSONObject)localObject).optJSONArray("picInfoList");
        if ((TextUtils.isEmpty(str2)) && (localJSONArray == null)) {
          break;
        }
        paramString2 = null;
        str1 = null;
        if (((JSONObject)localObject).optBoolean("isSecondReply"))
        {
          paramString2 = ((JSONObject)localObject).optString("replyUin");
          str1 = ((JSONObject)localObject).optString("commentId");
        }
        localObject = ((JSONObject)localObject).optString("commentUin");
        if (!paramBoolean) {
          break label208;
        }
        paramArticleInfo = paramArticleCommentModule;
      }
      catch (JSONException paramQQAppInterface)
      {
        Object localObject;
        String str2;
        JSONArray localJSONArray;
        String str1;
        paramQQAppInterface.printStackTrace();
        return;
      }
      paramArticleInfo.createComment(paramQQAppInterface, paramInt1, paramString1, str2, paramString2, localJSONArray, 1, paramInt2, str1, (String)localObject, new lka(paramCreateCommentInterface));
      return;
      label208:
      paramArticleInfo = new ArticleCommentModule(paramArticleInfo, paramInt1, "", System.currentTimeMillis() + "");
      while (paramInt1 != 1) {
        break;
      }
      paramString1 = null;
    }
  }
  
  public static void a(String paramString, Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramString = ReadInJoyConstants.f + Base64Util.encodeToString(paramString.getBytes(), 2);
      ReadInJoyUtils.a(paramContext, paramString);
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyCommentUtils", 2, "personal url =" + paramString);
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
    localSocializeFeedsInfo.getClass();
    localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo(localSocializeFeedsInfo);
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
      paramString = paramString.getJSONArray("biuinfo");
      i = 0;
      while (i < paramString.length())
      {
        paramString.getJSONObject(i);
        localObject = new ReadInJoyCommentUtils.UserBiuInfo(paramString.getJSONObject(i).optString("biu_uin"), paramString.getJSONObject(i).optLong("biu_feedid"), paramString.getJSONObject(i).optString("biu_info_comment"));
        ((ReadInJoyCommentUtils.UserBiuInfo)localObject).jdField_a_of_type_Int = paramString.getJSONObject(i).optInt("biu_optype");
        ((ReadInJoyCommentUtils.UserBiuInfo)localObject).jdField_a_of_type_JavaLangCharSequence = paramString.getJSONObject(i).optString("biu_nickname");
        localArrayList.add(localObject);
        i += 1;
      }
      if (!QLog.isColorLevel()) {
        break label333;
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
    label333:
    if ((paramArticleInfo != null) && (localArrayList.size() > 0))
    {
      i = localArrayList.size() - 1;
      for (;;)
      {
        if (i > 0)
        {
          localObject = (ReadInJoyCommentUtils.UserBiuInfo)localArrayList.get(i);
          localSocializeFeedsInfo.getClass();
          SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = new SocializeFeedsInfo.BiuCommentInfo(localSocializeFeedsInfo);
          try
          {
            localBiuCommentInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(((ReadInJoyCommentUtils.UserBiuInfo)localObject).jdField_a_of_type_JavaLangString);
            if (((ReadInJoyCommentUtils.UserBiuInfo)localObject).b == null)
            {
              paramString = "";
              localBiuCommentInfo.jdField_a_of_type_JavaLangString = paramString;
              localBiuCommentInfo.c = ((ReadInJoyCommentUtils.UserBiuInfo)localObject).jdField_a_of_type_Int;
              localBiuCommentInfo.b = Long.valueOf(0L);
              localSocializeFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localBiuCommentInfo);
              i -= 1;
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              localBiuCommentInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentUtils
 * JD-Core Version:    0.7.0.1
 */