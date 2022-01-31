package com.tencent.biz.pubaccount.readinjoy.comment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import liu;
import liv;
import liw;
import lix;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONObject;

public class NativeCommentServlet
{
  public static int a;
  public static String a;
  public static int b;
  public static String b;
  public static String c;
  public static String d;
  public static String e;
  
  static
  {
    jdField_a_of_type_JavaLangString = "NativeCommentServlet";
    jdField_b_of_type_JavaLangString = "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_create";
    c = "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_fetch";
    d = "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_delete";
    e = "MQUpdateSvc_com_qq_mp.web.tcpproxy.comment_like";
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 1;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArticleInfo paramArticleInfo, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, NativeCommentServlet.CommentObserver paramCommentObserver)
  {
    if ((paramArticleInfo == null) || (paramCommentObserver == null)) {
      return;
    }
    for (;;)
    {
      JSONObject localJSONObject;
      try
      {
        if (((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 5)) && (!ReadInJoyUtils.a(paramArticleInfo))) {
          break label344;
        }
        str = paramArticleInfo.innerUniqueID;
        if (paramInt1 != 1) {
          break label398;
        }
        localJSONObject = new JSONObject("{\"cmd\":[\"articleInfo\", \"commentList\"]}");
        new ArrayList();
        localJSONObject.put("article_id", String.valueOf(str));
        localJSONObject.put("src", 20);
        localJSONObject.put("uuid", paramString1);
        localJSONObject.put("native_version", DeviceInfoUtil.a(BaseApplicationImpl.getContext()));
        if (!TextUtils.isEmpty(paramString2)) {
          localJSONObject.put("comment_id", paramString2);
        }
        localJSONObject.put("page", paramInt2);
        localJSONObject.put("perpage", paramInt3);
        localJSONObject.put("content_src", paramInt4);
        paramString2 = localJSONObject.toString();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "fetchCommentList info:" + paramString2);
        }
        if (TextUtils.isEmpty(paramString2)) {
          break;
        }
        paramString1 = new WebSsoBody.WebSsoRequestBody();
        paramString1.data.set(paramString2);
        paramString2 = new NewIntent(paramQQAppInterface.getApplication(), PublicAccountServlet.class);
        paramString2.putExtra("cmd", c);
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(new liu(paramCommentObserver, paramArticleInfo));
        paramQQAppInterface.startServlet(paramString2);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramCommentObserver.a(paramArticleInfo, -1, "request error");
        paramQQAppInterface.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "fetchCommentList error info:" + paramQQAppInterface.getLocalizedMessage());
      return;
      label344:
      if ((ReadInJoyDeliverBiuActivity.a(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null))
      {
        if (ReadInJoyDeliverBiuActivity.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
          str = paramArticleInfo.innerUniqueID;
        }
      }
      else
      {
        str = String.valueOf(paramArticleInfo.mArticleID);
        continue;
        localJSONObject = new JSONObject("{\"cmd\":[\"articleInfo\", \"subCommentList\"]}");
        continue;
      }
      label398:
      String str = "";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArticleInfo paramArticleInfo, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, NativeCommentServlet.CommentLikeObserver paramCommentLikeObserver)
  {
    if ((paramArticleInfo == null) || (paramCommentLikeObserver == null)) {
      return;
    }
    for (;;)
    {
      String str;
      try
      {
        localJSONObject = new JSONObject();
        str = "";
        if (((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (ReadInJoyUtils.a(paramArticleInfo)))
        {
          str = paramArticleInfo.innerUniqueID;
          localJSONObject.put("article_id", str);
          localJSONObject.put("type", paramInt1);
          localJSONObject.put("comment_id", paramString2);
          if (paramInt1 == 2) {
            localJSONObject.put("sub_id", paramString3);
          }
          localJSONObject.put("like", paramInt2);
          localJSONObject.put("native_version", DeviceInfoUtil.a(BaseApplicationImpl.getContext()));
          localJSONObject.put("src", 20);
          localJSONObject.put("uuid", paramString1);
          l1 = 0L;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        JSONObject localJSONObject;
        long l1;
        long l2;
        paramCommentLikeObserver.a(paramArticleInfo, paramString2, -1, "request error");
        paramQQAppInterface.printStackTrace();
      }
      try
      {
        l2 = Long.parseLong(paramString4);
        l1 = l2;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        continue;
      }
      localJSONObject.put("to_uin", l1);
      localJSONObject.put("content_src", paramInt3);
      paramString4 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "commentLike info:" + paramString4);
      }
      if (TextUtils.isEmpty(paramString4)) {
        break;
      }
      paramString1 = new WebSsoBody.WebSsoRequestBody();
      paramString1.data.set(paramString4);
      paramString4 = new NewIntent(paramQQAppInterface.getApplication(), PublicAccountServlet.class);
      paramString4.putExtra("cmd", e);
      paramString4.putExtra("data", paramString1.toByteArray());
      paramString4.setObserver(new lix(paramInt1, paramCommentLikeObserver, paramArticleInfo, paramString2, paramString3));
      paramQQAppInterface.startServlet(paramString4);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "commentLike error info:" + paramQQAppInterface.getLocalizedMessage());
      return;
      if ((ReadInJoyDeliverBiuActivity.a(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null))
      {
        if (ReadInJoyDeliverBiuActivity.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
          str = paramArticleInfo.innerUniqueID;
        }
      }
      else {
        str = String.valueOf(paramArticleInfo.mArticleID);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArticleInfo paramArticleInfo, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, int paramInt2, ArticleCommentModule.DeleteCommentObserver paramDeleteCommentObserver)
  {
    if ((paramArticleInfo == null) || (paramDeleteCommentObserver == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        paramString3 = "";
        if (((paramArticleInfo.mFeedType != 1) || (paramArticleInfo.mSocialFeedInfo == null) || (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int != 5)) && (!ReadInJoyUtils.a(paramArticleInfo))) {
          break label337;
        }
        paramString3 = paramArticleInfo.innerUniqueID;
        localJSONObject.put("article_id", paramString3);
        localJSONObject.put("comment_id", paramString2);
        localJSONObject.put("type", paramInt1);
        localJSONObject.put("native_version", DeviceInfoUtil.a(BaseApplicationImpl.getContext()));
        if (paramInt1 == 2) {
          localJSONObject.put("sub_id", paramString4);
        }
        localJSONObject.put("src", 20);
        localJSONObject.put("uuid", paramString1);
        localJSONObject.put("content_src", paramInt2);
        paramString3 = localJSONObject.toString();
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "deleteComment info:" + paramString3);
        }
        if (TextUtils.isEmpty(paramString3)) {
          break;
        }
        paramString1 = new WebSsoBody.WebSsoRequestBody();
        paramString1.data.set(paramString3);
        paramString3 = new NewIntent(paramQQAppInterface.getApplication(), PublicAccountServlet.class);
        paramString3.putExtra("cmd", d);
        paramString3.putExtra("data", paramString1.toByteArray());
        paramString3.setObserver(new liw(paramDeleteCommentObserver, paramArticleInfo, paramInt1, paramString2, paramString4));
        paramQQAppInterface.startServlet(paramString3);
        return;
      }
      catch (Exception paramQQAppInterface)
      {
        paramDeleteCommentObserver.a(paramArticleInfo, paramString2, paramString4, -1, "request error");
        paramQQAppInterface.printStackTrace();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "createComment error info:" + paramQQAppInterface.getLocalizedMessage());
      return;
      label337:
      if ((ReadInJoyDeliverBiuActivity.a(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null))
      {
        if (ReadInJoyDeliverBiuActivity.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
          paramString3 = paramArticleInfo.innerUniqueID;
        }
      }
      else
      {
        long l = paramArticleInfo.mArticleID;
        paramString3 = String.valueOf(l);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ArticleInfo paramArticleInfo, String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, JSONArray paramJSONArray, int paramInt2, int paramInt3, String paramString5, String paramString6, NativeCommentServlet.CreateCommentObserver paramCreateCommentObserver)
  {
    if ((paramArticleInfo == null) || (paramCreateCommentObserver == null)) {
      return;
    }
    String str = "";
    for (;;)
    {
      try
      {
        if (((paramArticleInfo.mFeedType == 1) && (paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Int == 5)) || (ReadInJoyUtils.a(paramArticleInfo)))
        {
          str = paramArticleInfo.innerUniqueID;
          localJSONObject = new JSONObject();
          localJSONObject.put("article_id", String.valueOf(str));
          localJSONObject.put("comment_val", paramString3);
          localJSONObject.put("type", paramInt1);
          localJSONObject.put("comment_id", paramString2);
          localJSONObject.put("native_version", DeviceInfoUtil.a(BaseApplicationImpl.getContext()));
          if ((paramInt1 == 2) && (!TextUtils.isEmpty(paramString4))) {
            localJSONObject.put("to", paramString4);
          }
          if ((paramInt1 == 2) && (!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString5))) {
            localJSONObject.put("to_sub_id", paramString5);
          }
          boolean bool = TextUtils.isEmpty(paramString6);
          if (!bool) {
            l1 = 0L;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        JSONObject localJSONObject;
        long l1;
        long l2;
        paramCreateCommentObserver.a(paramArticleInfo, paramString2, -1, "request error");
        paramQQAppInterface.printStackTrace();
      }
      try
      {
        l2 = Long.parseLong(paramString6);
        l1 = l2;
      }
      catch (Exception paramString4)
      {
        paramString4.printStackTrace();
        continue;
      }
      localJSONObject.put("to_uin", l1);
      localJSONObject.put("src", 20);
      localJSONObject.put("uuid", paramString1);
      localJSONObject.put("content_src", paramInt3);
      if (paramJSONArray != null) {
        localJSONObject.put("gif_list", paramJSONArray);
      }
      paramString4 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createComment info:" + paramString4);
      }
      if (TextUtils.isEmpty(paramString4)) {
        break;
      }
      paramString1 = new WebSsoBody.WebSsoRequestBody();
      paramString1.data.set(paramString4);
      paramString4 = new NewIntent(paramQQAppInterface.getApplication(), PublicAccountServlet.class);
      paramString4.putExtra("cmd", jdField_b_of_type_JavaLangString);
      paramString4.putExtra("data", paramString1.toByteArray());
      paramString4.setObserver(new liv(paramCreateCommentObserver, paramArticleInfo, paramInt1, paramString2, paramString3, paramJSONArray, paramInt2));
      paramQQAppInterface.startServlet(paramString4);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "createComment error info:" + paramQQAppInterface.getLocalizedMessage());
      return;
      if ((ReadInJoyDeliverBiuActivity.a(paramArticleInfo)) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null))
      {
        if (ReadInJoyDeliverBiuActivity.a(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int)) {
          str = paramArticleInfo.innerUniqueID;
        }
      }
      else {
        str = String.valueOf(paramArticleInfo.mArticleID);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet
 * JD-Core Version:    0.7.0.1
 */