package com.tencent.biz.pubaccount.readinjoy.comment;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.AccountLevelInfo;
import com.tencent.biz.pubaccount.readinjoy.comment.data.BaseCommentData.MediaData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ExposedSubCommentViewItem;
import com.tencent.biz.pubaccount.readinjoy.comment.data.ReadInJoyCommentDataManager;
import com.tencent.biz.pubaccount.readinjoy.comment.data.SubCommentData;
import com.tencent.biz.pubaccount.readinjoy.comment.topic.RIJCommentTopicUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyTimeUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.comment.RIJMedalUtils;
import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.factory.TemplateFactory;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.ViewFactory;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xc46.oidb_cmd0xc46.ActivityLevel;

public class CommentProteusUtil
{
  public static final String a = HardCodeUtil.a(2131702245);
  public static final String b;
  public static final String c = HardCodeUtil.a(2131702244);
  
  static
  {
    jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131702246);
  }
  
  public static float a()
  {
    try
    {
      f = ((Float)ReadInJoyHelper.a("readinjoy_font_size_ratio_sp", Float.valueOf(1.0F))).floatValue();
      QLog.d("CommentProteusUtil", 1, "getCustomTextSizeRatio | error! msg=" + localException1);
    }
    catch (Exception localException1)
    {
      try
      {
        QLog.d("CommentProteusUtil", 1, "getCustomTextSizeRatio | text size ratio " + f);
        return f;
      }
      catch (Exception localException2)
      {
        float f;
        break label46;
      }
      localException1 = localException1;
      f = 1.0F;
    }
    label46:
    return f;
  }
  
  public static SubCommentData a(CommentViewItem paramCommentViewItem, int paramInt)
  {
    if (paramInt < 0) {
      return null;
    }
    if ((paramCommentViewItem != null) && ((paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)))
    {
      paramCommentViewItem = (CommentData)paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
      if ((paramCommentViewItem.subCommentList != null) && (paramCommentViewItem.subCommentList.size() > paramInt)) {
        return (SubCommentData)paramCommentViewItem.subCommentList.get(paramInt);
      }
    }
    return null;
  }
  
  public static TemplateBean a(VafContext paramVafContext, CommentViewItem paramCommentViewItem, int paramInt, boolean paramBoolean, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter)
  {
    TraceUtils.traceBegin("CommentProteusUtil.getTemplateBean");
    TemplateFactory localTemplateFactory1;
    if (paramVafContext == null)
    {
      TemplateFactory localTemplateFactory2 = TemplateFactory.a("comment_feeds", true);
      localTemplateFactory1 = localTemplateFactory2;
      if (localTemplateFactory2 == null) {
        return null;
      }
    }
    else
    {
      localTemplateFactory1 = (TemplateFactory)paramVafContext.getTemplateFactory();
    }
    if (localTemplateFactory1 != null) {}
    for (;;)
    {
      try
      {
        paramVafContext = localTemplateFactory1.getTemplateBean(a(paramReadinjoyCommentListBaseAdapter, paramVafContext, paramCommentViewItem, paramInt, paramBoolean));
        try
        {
          TraceUtils.traceEnd();
          return paramVafContext;
        }
        catch (JSONException paramCommentViewItem) {}
      }
      catch (JSONException paramCommentViewItem)
      {
        paramVafContext = null;
        continue;
      }
      paramCommentViewItem.printStackTrace();
      return paramVafContext;
      paramVafContext = null;
    }
  }
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String[] arrayOfString1;
    do
    {
      return paramString;
      arrayOfString1 = paramString.split("\\?");
    } while (arrayOfString1.length != 2);
    String[] arrayOfString2 = arrayOfString1[1].split("&");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < arrayOfString2.length)
    {
      String[] arrayOfString3 = arrayOfString2[i].split("=");
      if (arrayOfString3.length == 2) {
        if (i == arrayOfString2.length - 1) {
          break label156;
        }
      }
      label156:
      for (paramString = "&";; paramString = "")
      {
        if ("appSchema".equalsIgnoreCase(arrayOfString3[0])) {
          arrayOfString2[i] = (arrayOfString3[0] + "=" + b(arrayOfString3[1]));
        }
        localStringBuilder.append(arrayOfString2[i] + paramString);
        i += 1;
        break;
      }
    }
    paramString = arrayOfString1[0] + "?" + localStringBuilder.toString();
    QLog.d("CommentProteusUtil", 2, "checkJumpAppSchema | jumpSchema : " + paramString);
    return paramString;
  }
  
  private static List<String> a(CommentViewItem paramCommentViewItem)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramCommentViewItem == null) || (paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList == null)) {
      return localArrayList;
    }
    paramCommentViewItem = paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.mediaDataList;
    if (paramCommentViewItem.size() > 0)
    {
      paramCommentViewItem = paramCommentViewItem.iterator();
      while (paramCommentViewItem.hasNext())
      {
        BaseCommentData.MediaData localMediaData = (BaseCommentData.MediaData)paramCommentViewItem.next();
        if ((localMediaData.jdField_e_of_type_Int == 1) || (localMediaData.jdField_e_of_type_Int == 2)) {
          localArrayList.add(localMediaData.jdField_b_of_type_JavaLangString);
        } else if (localMediaData.jdField_e_of_type_Int == 3) {
          localArrayList.add(localMediaData.d);
        }
      }
    }
    QLog.d("CommentProteusUtil", 2, "getPicUrlList | pathsize " + localArrayList.size());
    return localArrayList;
  }
  
  public static JSONObject a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, VafContext paramVafContext, CommentViewItem paramCommentViewItem, int paramInt, boolean paramBoolean)
  {
    JSONObject localJSONObject2 = new JSONObject();
    if (paramCommentViewItem == null) {
      return localJSONObject2;
    }
    JSONObject localJSONObject1 = localJSONObject2;
    switch (paramInt)
    {
    default: 
      localJSONObject1 = localJSONObject2;
    }
    for (;;)
    {
      a(paramCommentViewItem, localJSONObject1);
      return localJSONObject1;
      localJSONObject1 = a(paramReadinjoyCommentListBaseAdapter, paramVafContext, paramCommentViewItem, paramBoolean);
      continue;
      localJSONObject1 = b(paramCommentViewItem);
      continue;
      localJSONObject1 = a(paramCommentViewItem);
      continue;
      localJSONObject1 = a(paramCommentViewItem, paramReadinjoyCommentListBaseAdapter);
    }
  }
  
  private static JSONObject a(@NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, VafContext paramVafContext, CommentViewItem paramCommentViewItem, boolean paramBoolean)
  {
    BaseCommentData localBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    if ((localBaseCommentData == null) || (localBaseCommentData.getWholeStringContent() == null) || (paramCommentViewItem.jdField_a_of_type_JavaLangCharSequence == null)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_cell");
    a(localJSONObject, localBaseCommentData, paramReadinjoyCommentListBaseAdapter);
    a(localJSONObject, paramCommentViewItem);
    a(localJSONObject, localBaseCommentData, paramBoolean);
    a(paramReadinjoyCommentListBaseAdapter, localJSONObject, localBaseCommentData);
    a(localJSONObject, paramCommentViewItem, paramBoolean);
    a(paramVafContext, localJSONObject, paramCommentViewItem, localBaseCommentData);
    a(localJSONObject, localBaseCommentData);
    b(localJSONObject, localBaseCommentData);
    QLog.d("CommentProteusUtil", 2, "getCommentDataJson | comment data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {}
    do
    {
      return null;
      paramCommentViewItem = paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (paramCommentViewItem == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_banner");
    localJSONObject.put("operation_banner_icon", "rij_icon_notify");
    localJSONObject.put("operation_banner_title", paramCommentViewItem.getWholeStringContent());
    QLog.d("CommentProteusUtil", 2, "comment banner data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static JSONObject a(CommentViewItem paramCommentViewItem, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter)
  {
    Object localObject = ReadInJoyCommentDataManager.a(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo);
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    int i;
    long l1;
    if ((localObject != null) && (paramReadinjoyCommentListBaseAdapter != null))
    {
      long l2 = ((ReadInJoyCommentDataManager)localObject).a(paramReadinjoyCommentListBaseAdapter.b());
      i = j;
      l1 = l2;
      if (paramReadinjoyCommentListBaseAdapter != null)
      {
        i = j;
        l1 = l2;
        if (paramReadinjoyCommentListBaseAdapter.b() == 6)
        {
          i = 0;
          l1 = l2;
        }
      }
    }
    for (;;)
    {
      if (paramCommentViewItem.jdField_a_of_type_Int == 2) {
        paramReadinjoyCommentListBaseAdapter = "rij_new_comment_title_icon";
      }
      for (paramCommentViewItem = "rij_comment_menu_new_icon";; paramCommentViewItem = "rij_comment_menu_hot_icon")
      {
        if (l1 > 0L) {}
        for (localObject = "（" + l1 + "）";; localObject = "")
        {
          localJSONObject.put("style_ID", "ReadInJoy_comment_title");
          localJSONObject.put("comment_title", c);
          localJSONObject.put("comment_count", localObject);
          localJSONObject.put("comment_title_icon_url", paramReadinjoyCommentListBaseAdapter);
          if (i != 0)
          {
            paramReadinjoyCommentListBaseAdapter = new JSONObject();
            paramReadinjoyCommentListBaseAdapter.put("commnet_menu_icon_url", paramCommentViewItem);
            paramReadinjoyCommentListBaseAdapter.put("rij_comment_type_choose_highlight", paramCommentViewItem);
            localJSONObject.put("id_comment_type_choose_icon", paramReadinjoyCommentListBaseAdapter);
          }
          QLog.d("CommentProteusUtil", 2, "getCommentTitleJsonNew | comment title json str : " + localJSONObject.toString());
          return localJSONObject;
        }
        paramReadinjoyCommentListBaseAdapter = "rij_hot_comment_title_icon";
      }
      l1 = 0L;
      i = j;
    }
  }
  
  @VisibleForTesting
  static JSONObject a(CommentViewItem paramCommentViewItem, JSONObject paramJSONObject)
  {
    if ((paramCommentViewItem == null) || (paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {}
    while (!(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
      return paramJSONObject;
    }
    List localList = ((CommentData)paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).subCommentList;
    int k;
    int i;
    if ((localList != null) && (localList.size() > 0))
    {
      k = localList.size();
      i = 0;
    }
    SubCommentData localSubCommentData;
    for (;;)
    {
      if ((i >= k) || (i >= 2))
      {
        QLog.d("CommentProteusUtil", 2, "bindExposeSubCommentData : " + paramJSONObject.toString());
        return paramJSONObject;
      }
      localSubCommentData = (SubCommentData)localList.get(i);
      if (localSubCommentData != null) {
        break;
      }
      i += 1;
    }
    String str15 = ReadInJoyConstants.g + Base64Util.encodeToString(localSubCommentData.uin.getBytes(), 2);
    int j;
    label171:
    String str1;
    label180:
    String str2;
    label189:
    String str3;
    label198:
    String str4;
    label207:
    String str5;
    label216:
    String str6;
    label225:
    String str7;
    label234:
    String str8;
    label243:
    String str9;
    label252:
    String str10;
    label261:
    String str11;
    label270:
    String str12;
    label279:
    String str13;
    label288:
    String str14;
    if (i == 0)
    {
      j = 1;
      if (j == 0) {
        break label593;
      }
      str1 = "subcomment_one";
      if (j == 0) {
        break label601;
      }
      str2 = "subcomment_one_text_line";
      if (j == 0) {
        break label609;
      }
      str3 = "subcomment_one_more_url";
      if (j == 0) {
        break label617;
      }
      str4 = "subcomment_one_nick_url";
      if (j == 0) {
        break label625;
      }
      str5 = "subcomment_one_nick_name";
      if (j == 0) {
        break label633;
      }
      str6 = "subcomment_one_tag_icon_path";
      if (j == 0) {
        break label641;
      }
      str7 = "subcomment_one_tag_icon_width";
      if (j == 0) {
        break label649;
      }
      str8 = "subcomment_one_reply";
      if (j == 0) {
        break label657;
      }
      str9 = "subcomment_one_to_nick_url";
      if (j == 0) {
        break label665;
      }
      str10 = "subcomment_one_to_nick_name";
      if (j == 0) {
        break label673;
      }
      str11 = "subcomment_one_rpt_data_info";
      if (j == 0) {
        break label681;
      }
      str12 = "author_like_one_text";
      if (j == 0) {
        break label689;
      }
      str13 = "subcomment_one_ratio";
      if (j == 0) {
        break label697;
      }
      str14 = "subcomment_one_text";
      label297:
      paramJSONObject.put(str1, new ExposedSubCommentViewItem(paramCommentViewItem, localSubCommentData));
      paramJSONObject.put(str2, localSubCommentData.secondMaxLine);
      paramJSONObject.put(str3, "more-" + localSubCommentData.parentCommentId + ":" + localSubCommentData.commentId);
      paramJSONObject.put(str4, str15);
      paramJSONObject.put(str5, localSubCommentData.nickName);
      paramJSONObject.put(str13, a());
      if (!localSubCommentData.isAuthorReply()) {
        break label705;
      }
      paramJSONObject.put(str6, "readinjoy_comment_author_tag");
      paramJSONObject.put(str7, "40px");
    }
    for (;;)
    {
      if ((localSubCommentData.hasTarget()) && (!TextUtils.isEmpty(localSubCommentData.repliedUserNickname)))
      {
        str1 = ReadInJoyConstants.g + Base64Util.encodeToString(localSubCommentData.repliedUserUin.getBytes(), 2);
        paramJSONObject.put(str8, HardCodeUtil.a(2131718580));
        paramJSONObject.put(str9, str1);
        paramJSONObject.put(str10, localSubCommentData.repliedUserNickname);
      }
      RIJCommentTopicUtil.a(localSubCommentData, paramJSONObject, str11, true);
      paramJSONObject.put(str14, " : " + localSubCommentData.getWholeStringContent());
      if ((localList == null) || (localSubCommentData == null) || (!localSubCommentData.isAuthorLike)) {
        break;
      }
      paramJSONObject.put(str12, "作者赞过");
      break;
      j = 0;
      break label171;
      label593:
      str1 = "subcomment_two";
      break label180;
      label601:
      str2 = "subcomment_two_text_line";
      break label189;
      label609:
      str3 = "subcomment_two_more_url";
      break label198;
      label617:
      str4 = "subcomment_two_nick_url";
      break label207;
      label625:
      str5 = "subcomment_two_nick_name";
      break label216;
      label633:
      str6 = "subcomment_two_tag_icon_path";
      break label225;
      label641:
      str7 = "subcomment_two_tag_icon_width";
      break label234;
      label649:
      str8 = "subcomment_two_reply";
      break label243;
      label657:
      str9 = "subcomment_two_to_nick_url";
      break label252;
      label665:
      str10 = "subcomment_two_to_nick_name";
      break label261;
      label673:
      str11 = "subcomment_two_rpt_data_info";
      break label270;
      label681:
      str12 = "author_like_two_text";
      break label279;
      label689:
      str13 = "subcomment_two_ratio";
      break label288;
      label697:
      str14 = "subcomment_two_text";
      break label297;
      label705:
      if (localSubCommentData.isFollowing)
      {
        paramJSONObject.put(str6, "readinjoy_comment_follow_tag");
        paramJSONObject.put(str7, "51px");
      }
    }
  }
  
  public static void a(ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem)
  {
    if (paramReadinjoyCommentListBaseAdapter == null) {
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(paramReadinjoyCommentListBaseAdapter.a(), 230);
    paramReadinjoyCommentListBaseAdapter = new CommentProteusUtil.2(paramReadinjoyCommentListBaseAdapter, paramCommentViewItem);
    localQQCustomDialog.setMessage(ReadInJoyCommentHelper.a());
    localQQCustomDialog.setNegativeButton("取消", paramReadinjoyCommentListBaseAdapter);
    localQQCustomDialog.setPositiveButton("确定", paramReadinjoyCommentListBaseAdapter);
    localQQCustomDialog.setOnCancelListener(null);
    localQQCustomDialog.show();
  }
  
  private static void a(@NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, @NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    if (paramBaseCommentData.isAuthorLike) {
      paramJSONObject.put("author_like_text", "作者赞过");
    }
    if (((paramBaseCommentData instanceof CommentData)) && (paramBaseCommentData.isAwesome())) {
      paramJSONObject.put("awsome_postmark_img", "awsome_postmark");
    }
    if ((paramBaseCommentData.isAuthorSticky) && (paramReadinjoyCommentListBaseAdapter.b() == 3))
    {
      paramJSONObject.put("top_img_path", "rij_comment_sticky_icon");
      paramJSONObject.put("top_margin_text", " ");
    }
    if (paramBaseCommentData.medalInfo != null) {
      RIJMedalUtils.a(paramJSONObject, paramBaseCommentData.medalInfo);
    }
  }
  
  private static void a(CommentViewItem paramCommentViewItem, JSONObject paramJSONObject)
  {
    if ((paramCommentViewItem == null) || (paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData == null) || (paramJSONObject == null)) {
      return;
    }
    paramCommentViewItem = paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.styleData;
    QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData : " + paramCommentViewItem + " dataJson : " + paramJSONObject.toString());
    if (TextUtils.isEmpty(paramCommentViewItem))
    {
      QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | styleData is null");
      return;
    }
    try
    {
      paramCommentViewItem = new JSONObject(paramCommentViewItem);
      if (paramCommentViewItem != null)
      {
        Iterator localIterator = paramCommentViewItem.keys();
        while ((localIterator != null) && (localIterator.hasNext()))
        {
          String str = (String)localIterator.next();
          paramJSONObject.put(str, paramCommentViewItem.get(str));
        }
      }
      return;
    }
    catch (JSONException paramCommentViewItem)
    {
      paramCommentViewItem.printStackTrace();
      QLog.d("CommentProteusUtil", 2, "bindDynamicStyleData | commentDataJson " + paramJSONObject.toString());
    }
  }
  
  public static void a(Container paramContainer, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, CommentViewItem paramCommentViewItem)
  {
    if ((paramContainer == null) || (paramCommentViewItem == null) || (paramReadinjoyCommentListBaseAdapter == null)) {
      return;
    }
    ViewFactory.findClickableViewListener(paramContainer.getVirtualView(), new CommentProteusUtil.1(paramContainer, paramReadinjoyCommentListBaseAdapter, paramCommentViewItem));
  }
  
  public static void a(VafContext paramVafContext, Container paramContainer, TemplateBean paramTemplateBean, ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramContainer == null) || (paramTemplateBean == null) || (paramReadinjoyCommentListBaseAdapter == null)) {
      return;
    }
    try
    {
      TraceUtils.traceBegin("CommentProteusUtil.bindData");
      ProteusSupportUtil.a(paramContainer, null, paramTemplateBean);
      if (paramTemplateBean.getViewBean() != null)
      {
        paramVafContext = a(paramReadinjoyCommentListBaseAdapter, paramVafContext, (CommentViewItem)paramReadinjoyCommentListBaseAdapter.getItem(paramInt1), paramInt2, paramBoolean);
        if (paramVafContext != null)
        {
          paramVafContext.put("ratio", a());
          paramTemplateBean.bindData(paramVafContext);
          a(paramContainer, paramReadinjoyCommentListBaseAdapter, (CommentViewItem)paramReadinjoyCommentListBaseAdapter.getItem(paramInt1));
        }
      }
      TraceUtils.traceEnd();
      return;
    }
    catch (JSONException paramVafContext)
    {
      QLog.d("CommentProteusUtil", 2, "bindData " + paramVafContext.getMessage());
    }
  }
  
  private static void a(@NotNull VafContext paramVafContext, @NotNull JSONObject paramJSONObject, @NotNull CommentViewItem paramCommentViewItem, @NotNull BaseCommentData paramBaseCommentData)
  {
    float f1 = 113.0F;
    float f2 = 89.0F;
    if ((paramVafContext != null) && (paramVafContext.getContext() != null) && (paramVafContext.getContext().getResources() != null) && (paramBaseCommentData.mediaDataList != null) && (paramBaseCommentData.mediaDataList.size() > 0))
    {
      paramVafContext = (BaseCommentData.MediaData)paramBaseCommentData.mediaDataList.get(0);
      int i = paramVafContext.jdField_e_of_type_Int;
      QLog.d("CommentProteusUtil", 2, "mediaData type is " + i);
      float f3 = paramVafContext.jdField_a_of_type_Int;
      f3 = paramVafContext.jdField_b_of_type_Int;
      if (paramVafContext.jdField_a_of_type_Int >= paramVafContext.jdField_b_of_type_Int) {
        break label273;
      }
      paramCommentViewItem = a(paramCommentViewItem);
      paramJSONObject.put("thumHeight", "" + f1);
      paramJSONObject.put("thumWidth", "" + f2);
      paramJSONObject.put("media_thumimg_url", paramVafContext.jdField_e_of_type_JavaLangString);
      if ((paramCommentViewItem == null) || (paramCommentViewItem.size() <= 0)) {
        break label305;
      }
      paramVafContext = (String)paramCommentViewItem.get(0);
      label219:
      paramJSONObject.put("pic_url", paramVafContext);
      paramVafContext = "";
      switch (i)
      {
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramVafContext)) {
        paramJSONObject.put("media_type_str", paramVafContext);
      }
      return;
      label273:
      if (paramVafContext.jdField_a_of_type_Int > paramVafContext.jdField_b_of_type_Int)
      {
        f2 = 113.0F;
        f1 = 89.0F;
        break;
      }
      f1 = 89.0F;
      break;
      label305:
      paramVafContext = "";
      break label219;
      paramVafContext = HardCodeUtil.a(2131702243);
      continue;
      paramVafContext = HardCodeUtil.a(2131702250);
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    if (!TextUtils.isEmpty(paramBaseCommentData.flowGuidePtsData)) {}
    try
    {
      paramBaseCommentData = new JSONObject(paramBaseCommentData.flowGuidePtsData);
      paramJSONObject.put("diversion_view_color", paramBaseCommentData.optString("diversion_view_color"));
      paramJSONObject.put("diversion_app_icon", paramBaseCommentData.optString("diversion_app_icon"));
      paramJSONObject.put("app_wording", paramBaseCommentData.optString("app_wording"));
      paramJSONObject.put("diversion_font_color", paramBaseCommentData.optString("diversion_font_color"));
      paramJSONObject.put("jump_schema", a(paramBaseCommentData.optString("app_schema")));
      return;
    }
    catch (Exception paramJSONObject)
    {
      QLog.d("CommentProteusUtil", 2, paramJSONObject.getMessage());
    }
  }
  
  @VisibleForTesting
  static void a(@NotNull JSONObject paramJSONObject, @Nullable BaseCommentData paramBaseCommentData, @NotNull ReadinjoyCommentListBaseAdapter paramReadinjoyCommentListBaseAdapter)
  {
    ArticleInfo localArticleInfo = paramReadinjoyCommentListBaseAdapter.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (TextUtils.isEmpty(paramBaseCommentData.avatar))
    {
      paramJSONObject.put("avator_url", "default_comment_avatar");
      QLog.d("CommentProteusUtil", 2, "getCommentDataJson | isStar " + paramBaseCommentData.isStar() + " isApproved " + paramBaseCommentData.isApproved());
      if (paramBaseCommentData.isStar()) {
        paramJSONObject.put("rij_comment_avatar_borders", "rij_comment_avatar_borders");
      }
      if (paramBaseCommentData.isAuthorReply()) {
        paramJSONObject.put("author_header_flag_one", HardCodeUtil.a(2131702255));
      }
      if (!TextUtils.isEmpty(paramBaseCommentData.userTitle)) {
        paramJSONObject.put("comment_describe", paramBaseCommentData.userTitle);
      }
      String str2 = ReadInJoyCommentUtils.a(paramBaseCommentData.nickName, 10);
      String str1 = str2;
      if (str2 == null) {
        str1 = HardCodeUtil.a(2131709264);
      }
      paramJSONObject.put("nickname", str1);
      if ((paramBaseCommentData.isFollowing) && (!paramBaseCommentData.isAuthorReply())) {
        paramJSONObject.put("author_header_follow_flag", "我的关注");
      }
      if ((paramBaseCommentData.shouldShowFollowButton) && (paramReadinjoyCommentListBaseAdapter.b() == 3))
      {
        if (a(localArticleInfo)) {
          break label368;
        }
        paramJSONObject.put("follow_btn_show", "0");
        label224:
        ReadinjoyReportUtils.b(localArticleInfo, ReadinjoyReportUtils.g, true, paramBaseCommentData.commentId);
      }
      if (!paramJSONObject.has("follow_btn_show"))
      {
        if (!TextUtils.isEmpty(paramBaseCommentData.avatarPendantUrl)) {
          paramJSONObject.put("rij_comment_avatar_pendant", paramBaseCommentData.avatarPendantUrl);
        }
        if ((paramBaseCommentData.accountLevelInfo == null) || (!paramBaseCommentData.accountLevelInfo.a()) || (TextUtils.isEmpty(paramBaseCommentData.accountLevelInfo.a))) {
          break label382;
        }
        paramJSONObject.put("rij_comment_v", paramBaseCommentData.accountLevelInfo.a);
      }
    }
    for (;;)
    {
      if ((paramBaseCommentData.activityLevel != null) && (paramBaseCommentData.activityLevel.icon.has())) {
        paramJSONObject.put("activity_level_icon_url", paramBaseCommentData.activityLevel.icon.get());
      }
      return;
      paramJSONObject.put("avator_url", paramBaseCommentData.avatar);
      break;
      label368:
      paramJSONObject.put("follow_btn_show", "1");
      break label224;
      label382:
      if (paramBaseCommentData.isApproved()) {
        paramJSONObject.put("rij_comment_v", "rij_comment_v");
      }
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData, boolean paramBoolean)
  {
    long l2 = paramBaseCommentData.commentTime;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = System.currentTimeMillis();
    }
    paramJSONObject.put("time", ReadInJoyTimeUtils.a(l1, true));
    JSONObject localJSONObject = new JSONObject();
    c(localJSONObject, paramBaseCommentData);
    if ((paramBaseCommentData instanceof CommentData))
    {
      if (paramBoolean)
      {
        paramBaseCommentData = (CommentData)paramBaseCommentData;
        if (paramBaseCommentData.subCommentNum > 0)
        {
          paramJSONObject.put("reply_count", ReadInJoyHelper.a(paramBaseCommentData.subCommentNum, 99989500L, "9999万+", "0") + HardCodeUtil.a(2131702249));
          paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
          paramJSONObject.put("reply_count_none", "");
          paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
          paramJSONObject.put("id_reply_comment_button", localJSONObject);
          return;
        }
        paramJSONObject.put("reply_count_none", HardCodeUtil.a(2131702256));
        paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
        paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
        paramJSONObject.remove("reply_count");
        paramJSONObject.put("id_reply_comment_null_button", localJSONObject);
        return;
      }
      paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
      return;
    }
    paramJSONObject.put("reply_count_none", HardCodeUtil.a(2131702253));
    paramJSONObject.put("id_comment_tail_center_dot", new JSONObject());
    paramJSONObject.put("id_comment_tail_3_dot", new JSONObject());
    paramJSONObject.remove("reply_count");
    paramJSONObject.put("id_reply_comment_null_button", localJSONObject);
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull CommentViewItem paramCommentViewItem)
  {
    paramJSONObject.put("commentModel", paramCommentViewItem);
    String str;
    if (paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData != null)
    {
      paramJSONObject.put("comment_text", paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.getWholeStringContent());
      RIJCommentTopicUtil.a(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData, paramJSONObject, "rpt_data_info", false);
      if (paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.hasLinkData()) {
        paramJSONObject.put("commentLinkModel", paramCommentViewItem);
      }
      paramJSONObject.put("ratio", a());
      str = null;
      if (!(paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof CommentData)) {
        break label230;
      }
      str = "more-" + paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.commentId;
    }
    for (;;)
    {
      paramJSONObject.put("comment_text_more_url", str);
      paramJSONObject.put("comment_text_line", paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData.maxLine);
      if ((paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData))
      {
        paramCommentViewItem = (SubCommentData)paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
        if (paramCommentViewItem.hasTarget())
        {
          paramJSONObject.put("reply_normal_text", "回复 ");
          if (!TextUtils.isEmpty(paramCommentViewItem.repliedUserNickname))
          {
            paramJSONObject.put("reply_highLight_text", paramCommentViewItem.repliedUserNickname + "：");
            paramJSONObject.put("jump_url", ReadInJoyCommentUtils.a(paramCommentViewItem.repliedUserUin));
          }
        }
      }
      return;
      label230:
      if ((paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData instanceof SubCommentData)) {
        str = "more-" + ((SubCommentData)paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).parentCommentId + ":" + ((SubCommentData)paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData).commentId;
      }
    }
  }
  
  private static void a(@NotNull JSONObject paramJSONObject, @NotNull CommentViewItem paramCommentViewItem, boolean paramBoolean)
  {
    if ((paramCommentViewItem.a()) && (paramBoolean)) {
      paramJSONObject.put("comment_model", paramCommentViewItem);
    }
    if (paramBoolean) {
      a(paramCommentViewItem, paramJSONObject);
    }
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSubscribeID != null)) {
      return FollowListInfoModule.a(paramBaseArticleInfo.mSubscribeID);
    }
    return false;
  }
  
  private static String b(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "utf-8");
      StringBuilder localStringBuilder = new StringBuilder(str);
      if (!str.contains("title")) {
        localStringBuilder.append("&title=");
      }
      if (!str.contains("videoId")) {
        localStringBuilder.append("&videoId=");
      }
      if (!str.contains("coverPath")) {
        localStringBuilder.append("&coverPath=");
      }
      if (!str.contains("width")) {
        localStringBuilder.append("&width=");
      }
      if (!str.contains("height")) {
        localStringBuilder.append("&height=");
      }
      str = URLEncoder.encode(localStringBuilder.toString(), "utf-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return paramString;
  }
  
  private static JSONObject b(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {}
    BaseCommentData localBaseCommentData;
    do
    {
      return null;
      localBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentDataBaseCommentData;
    } while (localBaseCommentData == null);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("style_ID", "ReadInJoy_comment_operation_cell");
    localJSONObject.put("avator_url", localBaseCommentData.avatar);
    localJSONObject.put("nickname", localBaseCommentData.nickName);
    localJSONObject.put("commentModel", paramCommentViewItem);
    localJSONObject.put("operation_img_url", localBaseCommentData.activityPicUrl);
    QLog.d("CommentProteusUtil", 2, "comment activity data json str : " + localJSONObject.toString());
    return localJSONObject;
  }
  
  private static void b(@NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("puin", paramBaseCommentData.uin);
    c(localJSONObject1, paramBaseCommentData);
    JSONObject localJSONObject2 = new JSONObject();
    if (paramBaseCommentData.isLiked()) {}
    for (Object localObject = "click_like_comment";; localObject = "cancel_like_comment")
    {
      localJSONObject2.put("comment_like_actionid", localObject);
      c(localJSONObject2, paramBaseCommentData);
      localObject = new JSONObject();
      c((JSONObject)localObject, paramBaseCommentData);
      paramJSONObject.put("id_comment_avator", localJSONObject1);
      paramJSONObject.put("id_like_button", localJSONObject2);
      paramJSONObject.put("id_first_comment_view", localObject);
      return;
    }
  }
  
  private static void c(@NotNull JSONObject paramJSONObject, @NotNull BaseCommentData paramBaseCommentData)
  {
    String str2 = "";
    String str3;
    if ((paramBaseCommentData instanceof SubCommentData))
    {
      str3 = ((SubCommentData)paramBaseCommentData).parentCommentId;
      str2 = paramBaseCommentData.commentId;
    }
    for (String str1 = "second_level";; str1 = "first_level")
    {
      paramJSONObject.put("rowkey", paramBaseCommentData.rowKey);
      paramJSONObject.put("comment_id", str3);
      paramJSONObject.put("sub_comment_id", str2);
      paramJSONObject.put("comment_type", str1);
      return;
      str3 = paramBaseCommentData.commentId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.CommentProteusUtil
 * JD-Core Version:    0.7.0.1
 */