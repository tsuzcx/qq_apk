package com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl;

import android.text.Editable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.AtFriendsSpan;
import com.tencent.biz.pubaccount.readinjoy.biu.BiuNicknameSpan;
import com.tencent.biz.pubaccount.readinjoy.comment.base.model.CommentArgumentModel;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJFeedsType;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

class QQPublishCommentBridgeImpl$BiuCommentHelper
{
  private QQPublishCommentBridgeImpl$BiuCommentHelper(QQPublishCommentBridgeImpl paramQQPublishCommentBridgeImpl) {}
  
  private void a(String paramString1, String paramString2, @NotNull Editable paramEditable, @NotNull ArrayList<QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo> paramArrayList, @NotNull BiuNicknameSpan[] paramArrayOfBiuNicknameSpan)
  {
    int i = 0;
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll(Arrays.asList(paramArrayOfBiuNicknameSpan));
    Collections.sort((List)localObject, new QQPublishCommentBridgeImpl.BiuCommentHelper.BiuSpanComparator(this, paramEditable));
    long l = 0L;
    localObject = ((ArrayList)localObject).iterator();
    int j = 0;
    BiuNicknameSpan localBiuNicknameSpan;
    int k;
    if (((Iterator)localObject).hasNext())
    {
      localBiuNicknameSpan = (BiuNicknameSpan)((Iterator)localObject).next();
      k = paramEditable.getSpanStart(localBiuNicknameSpan);
    }
    label320:
    for (;;)
    {
      try
      {
        paramArrayOfBiuNicknameSpan = paramEditable.subSequence(j, k).toString();
        if (paramArrayOfBiuNicknameSpan != null)
        {
          paramArrayOfBiuNicknameSpan = Utils.a(paramArrayOfBiuNicknameSpan, paramString1).replaceAll("\n|\r\n", "");
          if (j != 0) {
            break label320;
          }
          paramArrayOfBiuNicknameSpan = paramArrayOfBiuNicknameSpan.substring(paramArrayOfBiuNicknameSpan.indexOf(paramArrayOfBiuNicknameSpan.trim()));
          paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, paramString2, l, EmotionCodecUtils.a(Utils.b(paramArrayOfBiuNicknameSpan, paramString1)), i));
        }
        if ((localBiuNicknameSpan instanceof AtFriendsSpan))
        {
          i = 1;
          j = paramEditable.getSpanEnd(localBiuNicknameSpan);
          paramString2 = localBiuNicknameSpan.jdField_a_of_type_JavaLangString;
          l = localBiuNicknameSpan.jdField_a_of_type_Long;
        }
      }
      catch (Exception paramArrayOfBiuNicknameSpan)
      {
        paramArrayOfBiuNicknameSpan.printStackTrace();
        paramArrayOfBiuNicknameSpan = null;
        continue;
        i = 0;
        continue;
      }
      try
      {
        paramEditable = paramEditable.subSequence(j, paramEditable.length()).toString();
        if (paramEditable != null)
        {
          paramEditable = Utils.a(paramEditable, paramString1).replaceAll("\n|\r\n", "");
          paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, paramString2, l, EmotionCodecUtils.a(Utils.b(paramEditable.substring(0, paramEditable.indexOf(paramEditable.trim()) + paramEditable.trim().length()), paramString1)), i));
        }
        return;
      }
      catch (Exception paramEditable)
      {
        for (;;)
        {
          paramEditable.printStackTrace();
          paramEditable = null;
        }
      }
    }
  }
  
  private void a(@NotNull ArrayList<QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo> paramArrayList)
  {
    if ((QQPublishCommentBridgeImpl.a(this.a).a != null) && (QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo != null) && (QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo.a != null) && (QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilList != null))
    {
      List localList = QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo.a.jdField_a_of_type_JavaUtilList;
      int j = localList.size();
      int i = 0;
      if (i < j)
      {
        SocializeFeedsInfo.BiuCommentInfo localBiuCommentInfo = (SocializeFeedsInfo.BiuCommentInfo)localList.get(i);
        if (localBiuCommentInfo == null) {}
        for (;;)
        {
          i += 1;
          break;
          paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, String.valueOf(localBiuCommentInfo.mUin), localBiuCommentInfo.mFeedId.longValue(), localBiuCommentInfo.mBiuComment, localBiuCommentInfo.mOpType));
        }
      }
    }
  }
  
  private boolean a(String paramString, @NotNull Editable paramEditable, @NotNull ArrayList<QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo> paramArrayList)
  {
    if ((!TextUtils.isEmpty(QQPublishCommentBridgeImpl.a(this.a).jdField_e_of_type_JavaLangString)) && (!TextUtils.isEmpty(QQPublishCommentBridgeImpl.a(this.a).jdField_f_of_type_JavaLangString)) && (QQPublishCommentBridgeImpl.a(this.a).a != null)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2;
      String str1;
      String str2;
      if ((RIJFeedsType.e(QQPublishCommentBridgeImpl.a(this.a).a)) && (QQPublishCommentBridgeImpl.a(this.a).d == 1))
      {
        bool2 = true;
        str1 = UUID.randomUUID().toString();
        str2 = Utils.a(paramEditable.toString(), str1).trim();
        if (!TextUtils.isEmpty(str2)) {
          break label240;
        }
        paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, paramString, 0L, ""));
      }
      label240:
      for (boolean bool3 = true;; bool3 = a(paramArrayList, paramString, paramEditable, str2, str1, bool1, bool2))
      {
        if (bool1)
        {
          QQPublishCommentBridgeImpl.a(this.a).jdField_e_of_type_JavaLangString = (": " + QQPublishCommentBridgeImpl.a(this.a).jdField_e_of_type_JavaLangString);
          paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, QQPublishCommentBridgeImpl.a(this.a).jdField_f_of_type_JavaLangString, QQPublishCommentBridgeImpl.a(this.a).a.mFeedId, QQPublishCommentBridgeImpl.a(this.a).jdField_e_of_type_JavaLangString, 0));
        }
        if (bool2) {
          a(paramArrayList);
        }
        return bool3;
        bool2 = false;
        break;
      }
    }
  }
  
  private boolean a(@NotNull ArrayList<QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo> paramArrayList, String paramString1, @NotNull Editable paramEditable, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    BiuNicknameSpan[] arrayOfBiuNicknameSpan = (BiuNicknameSpan[])paramEditable.getSpans(0, paramEditable.length(), BiuNicknameSpan.class);
    if ((arrayOfBiuNicknameSpan == null) || (arrayOfBiuNicknameSpan.length <= 0))
    {
      paramString2 = EmotionCodecUtils.a(Utils.b(paramString2.replaceAll("\n|\r\n", ""), paramString3));
      if (!paramBoolean1)
      {
        paramEditable = paramString2;
        if (!paramBoolean2) {}
      }
      else
      {
        paramEditable = paramString2 + "//";
      }
      paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, paramString1, 0L, "：" + paramEditable));
      return true;
    }
    a(paramString3, paramString1, paramEditable, paramArrayList, arrayOfBiuNicknameSpan);
    return false;
  }
  
  JSONObject a(Editable paramEditable)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      if ((QQPublishCommentBridgeImpl.a(this.a).a != null) && (QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo != null) && (QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo.a != null))
      {
        localJSONObject1.put("mOriFeedType", QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo.a.b);
        localJSONObject1.put("mOriFeedId", QQPublishCommentBridgeImpl.a(this.a).a.mSocialFeedInfo.a.jdField_a_of_type_JavaLangLong);
      }
      localJSONObject1.put("biuSrc", QQPublishCommentBridgeImpl.a(this.a).jdField_e_of_type_Int);
      localJSONObject1.put("feedtype", QQPublishCommentBridgeImpl.a(this.a).jdField_f_of_type_Int);
      ArrayList localArrayList = new ArrayList();
      a(localArrayList, paramEditable);
      paramEditable = new JSONArray();
      int i = 0;
      while (i < localArrayList.size())
      {
        QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo localUserBiuInfo = (QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo)localArrayList.get(i);
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("biu_info_comment", localUserBiuInfo.b);
        localJSONObject2.put("biu_feedid", new Long(localUserBiuInfo.jdField_a_of_type_Long));
        localJSONObject2.put("biu_optype", localUserBiuInfo.jdField_a_of_type_Int);
        localJSONObject2.put("biu_uin", localUserBiuInfo.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("biu_nickname", localUserBiuInfo.jdField_a_of_type_JavaLangCharSequence);
        paramEditable.put(localJSONObject2);
        i += 1;
      }
      localJSONObject1.put("biuinfo", paramEditable);
      return localJSONObject1;
    }
    catch (Exception paramEditable)
    {
      paramEditable.printStackTrace();
    }
    return null;
  }
  
  protected boolean a(ArrayList<QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo> paramArrayList, Editable paramEditable)
  {
    String str = "0";
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      str = ((QQAppInterface)localAppRuntime).getCurrentAccountUin();
    }
    if ((paramEditable == null) || (TextUtils.isEmpty(paramEditable.toString())))
    {
      paramArrayList.add(new QQPublishCommentBridgeImpl.BiuCommentHelper.UserBiuInfo(this, str, 0L, ""));
      return false;
    }
    return a(str, paramEditable, paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.base.bridgeimpl.QQPublishCommentBridgeImpl.BiuCommentHelper
 * JD-Core Version:    0.7.0.1
 */