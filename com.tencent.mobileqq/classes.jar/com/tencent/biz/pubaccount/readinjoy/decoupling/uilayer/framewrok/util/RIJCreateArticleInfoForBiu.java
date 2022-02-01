package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class RIJCreateArticleInfoForBiu
{
  public static Intent a(Intent paramIntent, ArticleInfo paramArticleInfo, int paramInt1, String paramString1, long paramLong, String paramString2, int paramInt2, int paramInt3)
  {
    if (paramIntent == null) {
      return paramIntent;
    }
    new ArticleInfo();
    ArticleInfo localArticleInfo = paramArticleInfo.clone();
    if (paramArticleInfo.mSocialFeedInfo != null) {
      localArticleInfo.mSocialFeedInfo = paramArticleInfo.mSocialFeedInfo.a();
    }
    if (localArticleInfo.mSocialFeedInfo == null) {
      localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
    }
    if (localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo == null) {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo();
    }
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramArticleInfo = new SocializeFeedsInfo.BiuCommentInfo();
    paramArticleInfo.mUin = Long.valueOf(paramLong);
    if ((paramLong > 0L) && (!TextUtils.isEmpty(paramString1))) {
      paramArticleInfo.mOrigBiuComment = (": " + paramString1);
    }
    ReadInJoyUserInfoModule.a(paramLong, paramString2);
    paramArticleInfo.mFeedsType = localArticleInfo.mFeedType;
    paramArticleInfo.mOpType = paramInt2;
    paramArticleInfo.mFeedId = Long.valueOf(localArticleInfo.mFeedId);
    QLog.d("RIJCreateArticleInfoForBiu", 2, "biuCommentInfo " + paramArticleInfo.toString());
    localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(paramArticleInfo);
    paramIntent.putExtra("arg_article_info", localArticleInfo);
    paramIntent.putExtra("biu_rowkey", localArticleInfo.innerUniqueID);
    paramIntent.putExtra("feedsType", localArticleInfo.mFeedType);
    paramIntent.putExtra("arg_from_type", paramInt3);
    paramIntent.putExtra("biu_src", paramInt1);
    paramIntent.putExtra("feed_id", localArticleInfo.mFeedId);
    paramIntent.putExtra("feedsType", localArticleInfo.mFeedType);
    QLog.d("RIJCreateArticleInfoForBiu", 2, "readytoJump  biuType: " + paramInt1 + "feed_id : " + localArticleInfo.mFeedId + "feeds_type : " + localArticleInfo.mFeedType + "articleID : " + localArticleInfo.mArticleID);
    return paramIntent;
  }
  
  public static ArticleInfo a(String paramString)
  {
    ArticleInfo localArticleInfo = new ArticleInfo();
    Object localObject5;
    long l1;
    Object localObject6;
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        localObject5 = new JSONObject(paramString);
        if (QLog.isColorLevel()) {
          QLog.i("RIJCreateArticleInfoForBiu", 2, "web json:" + ((JSONObject)localObject5).toString());
        }
        localObject3 = ((JSONObject)localObject5).optString("title");
        localObject1 = ((JSONObject)localObject5).optString("sourceName");
        l2 = 0L;
        l3 = 0L;
        l7 = 0L;
        l11 = 0L;
      }
      catch (Exception paramString)
      {
        Object localObject3;
        long l11;
        long l8;
        long l9;
        long l10;
        if (QLog.isColorLevel()) {
          QLog.i("RIJCreateArticleInfoForBiu", 2, "Exception error=" + paramString.getMessage());
        }
        return localArticleInfo;
      }
      for (;;)
      {
        try
        {
          paramString = new String(Base64Util.decode((String)localObject3, 0));
        }
        catch (Exception localException3)
        {
          Object localObject4;
          paramString = (String)localObject1;
          l6 = l7;
          localObject1 = localObject4;
          break;
          if (j == 4) {
            continue;
          }
          if (j != 5) {
            continue;
          }
          continue;
        }
        try
        {
          localObject3 = new String(Base64Util.decode((String)localObject1, 0));
          l6 = l7;
          l5 = l3;
          l4 = l2;
        }
        catch (Exception localException1)
        {
          localObject4 = paramString;
          paramString = (String)localObject1;
          l6 = l7;
          localObject1 = localObject4;
          break;
        }
      }
      try
      {
        localObject1 = ((JSONObject)localObject5).optString("feedsId");
        l1 = l2;
        l6 = l7;
        l5 = l3;
        l4 = l2;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l6 = l7;
          l5 = l3;
          l4 = l2;
          l1 = new BigInteger((String)localObject1).longValue();
        }
        l6 = l7;
        l5 = l3;
        l4 = l1;
        localObject1 = ((JSONObject)localObject5).optString("ariticleId");
        l2 = l3;
        l6 = l7;
        l5 = l3;
        l4 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l6 = l7;
          l5 = l3;
          l4 = l1;
          l2 = new BigInteger((String)localObject1).longValue();
        }
        l6 = l7;
        l5 = l2;
        l4 = l1;
        localObject1 = ((JSONObject)localObject5).optString("originFeedsId");
        l3 = l7;
        l6 = l7;
        l5 = l2;
        l4 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          l6 = l7;
          l5 = l2;
          l4 = l1;
          l3 = new BigInteger((String)localObject1).longValue();
        }
        l6 = l3;
        l5 = l2;
        l4 = l1;
        localObject6 = ((JSONObject)localObject5).optString("businessId");
        l7 = l11;
        localObject2 = localObject3;
        l8 = l3;
        l9 = l2;
        l10 = l1;
        localObject1 = paramString;
        l6 = l3;
        l5 = l2;
        l4 = l1;
        if (!TextUtils.isEmpty((CharSequence)localObject6))
        {
          l6 = l3;
          l5 = l2;
          l4 = l1;
          l7 = new BigInteger((String)localObject6).longValue();
          localObject1 = paramString;
          l10 = l1;
          l9 = l2;
          l8 = l3;
          localObject2 = localObject3;
        }
        l1 = ((JSONObject)localObject5).optLong("originFeedsType", 1L);
        paramString = ((JSONObject)localObject5).optString("picurl");
        i = ((JSONObject)localObject5).optInt("duration");
        ((JSONObject)localObject5).optString("callback");
        localObject3 = new String(Base64Util.decode(((JSONObject)localObject5).optString("accountDesc"), 0));
        j = ((JSONObject)localObject5).optInt("feedsType", 1);
        localArticleInfo.mArticleID = l9;
        localArticleInfo.mTitle = ((String)localObject1);
        localArticleInfo.mSubscribeName = ((String)localObject2);
        localArticleInfo.mFirstPagePicUrl = paramString;
        localArticleInfo.mVideoDuration = i;
        localArticleInfo.mFeedId = l10;
        localArticleInfo.mFeedType = j;
        localArticleInfo.mSummary = ((String)localObject3);
        localArticleInfo.businessId = l7;
        paramString = ((JSONObject)localObject5).getJSONArray("biuLevelList");
        localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaLangLong = Long.valueOf(l8);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b = Long.valueOf(l1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
        if (paramString == null) {
          break label897;
        }
        i = 0;
        if (i >= paramString.length()) {
          break label897;
        }
        localObject2 = new SocializeFeedsInfo.BiuCommentInfo();
        localObject3 = paramString.getJSONObject(i);
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).mUin = Long.valueOf(((JSONObject)localObject3).optLong("uin"));
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).mOrigBiuComment = ((JSONObject)localObject3).optString("comment");
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).mBiuTime = ((JSONObject)localObject3).optInt("biuTime");
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).mFeedsType = ((JSONObject)localObject3).optInt("feeds_type", 1);
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).mOpType = ((JSONObject)localObject3).optInt("op_type");
      }
      catch (Exception localException2)
      {
        localObject1 = paramString;
        paramString = (String)localObject4;
        l3 = l5;
        l2 = l4;
        continue;
      }
      try
      {
        localObject3 = ((JSONObject)localObject3).optString("feedsId");
        if (!TextUtils.isEmpty((CharSequence)localObject3)) {
          ((SocializeFeedsInfo.BiuCommentInfo)localObject2).mFeedId = Long.valueOf(new BigInteger((String)localObject3).longValue());
        }
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).mOrigBiuComment = new String(Base64Util.decode(((SocializeFeedsInfo.BiuCommentInfo)localObject2).mOrigBiuComment, 0));
        ((SocializeFeedsInfo.BiuCommentInfo)localObject2).mBiuComment = ((SocializeFeedsInfo.BiuCommentInfo)localObject2).mOrigBiuComment;
      }
      catch (Exception localException4)
      {
        localException4.printStackTrace();
        continue;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localObject2);
      i += 1;
      continue;
      ((Exception)localObject2).printStackTrace();
      l7 = l11;
      localObject2 = paramString;
      l8 = l6;
      l9 = l3;
      l10 = l2;
    }
    label897:
    paramString = ((JSONObject)localObject5).optJSONObject("ugcInfo");
    if ((paramString != null) && ((j == 4) || (j == 5) || ((j == 1) && ((l1 == 4L) || (l1 == 5L)))))
    {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo = new SocializeFeedsInfo.UGCFeedsInfo();
      j = paramString.optInt("ugcType", 0);
      localObject2 = paramString.optString("ugcComment");
      localObject4 = paramString.optJSONArray("ugcAtLevelList");
      if (localObject4 != null)
      {
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo = new SocializeFeedsInfo.BiuInfo();
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList = new ArrayList();
        i = 0;
        for (;;)
        {
          if (i >= ((JSONArray)localObject4).length()) {
            break label1231;
          }
          localObject5 = new SocializeFeedsInfo.BiuCommentInfo();
          localObject6 = ((JSONArray)localObject4).getJSONObject(i);
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).mUin = Long.valueOf(((JSONObject)localObject6).optLong("uin"));
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).mOrigBiuComment = ((JSONObject)localObject6).optString("comment");
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).mBiuTime = ((JSONObject)localObject6).optInt("biuTime");
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).mFeedsType = ((JSONObject)localObject6).optInt("feeds_type", 1);
          ((SocializeFeedsInfo.BiuCommentInfo)localObject5).mOpType = ((JSONObject)localObject6).optInt("op_type");
          try
          {
            localObject6 = ((JSONObject)localObject6).optString("feedsId");
            if (!TextUtils.isEmpty((CharSequence)localObject6)) {
              ((SocializeFeedsInfo.BiuCommentInfo)localObject5).mFeedId = Long.valueOf(new BigInteger((String)localObject6).longValue());
            }
            ((SocializeFeedsInfo.BiuCommentInfo)localObject5).mOrigBiuComment = new String(Base64Util.decode(((SocializeFeedsInfo.BiuCommentInfo)localObject5).mOrigBiuComment, 0));
            ((SocializeFeedsInfo.BiuCommentInfo)localObject5).mBiuComment = ((SocializeFeedsInfo.BiuCommentInfo)localObject5).mOrigBiuComment;
          }
          catch (Exception localException5)
          {
            for (;;)
            {
              localException5.printStackTrace();
            }
          }
          localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.jdField_a_of_type_JavaUtilList.add(localObject5);
          i += 1;
        }
      }
      label1231:
      localArticleInfo.mTitle = new String(Base64Util.decode((String)localObject2, 0));
      localArticleInfo.mSummary = "";
      if ((j != 3) && (j != 2)) {
        break label1571;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      localObject1 = new SocializeFeedsInfo.UGCPicInfo();
      paramString = paramString.optJSONArray("ugcPicInfo");
      if ((paramString != null) && (paramString.length() > 0))
      {
        ((SocializeFeedsInfo.UGCPicInfo)localObject1).c = paramString.getJSONObject(0).optString("ugcPicUrl");
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
      }
    }
    for (;;)
    {
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Int = j;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_JavaLangString = localArticleInfo.mTitle;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaLangString = "";
      localArticleInfo.mSocialFeedInfo.c = "";
      localArticleInfo.mSocialFeedInfo.b = "";
      return localArticleInfo;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b = new ArrayList();
      localObject2 = new SocializeFeedsInfo.UGCVideoInfo();
      paramString = paramString.optJSONObject("ugcVideoInfo");
      if (paramString != null)
      {
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).d = paramString.optString("ugcVideoCoverUrl");
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).a = paramString.optInt("ugcVideoDuration");
        ((SocializeFeedsInfo.UGCVideoInfo)localObject2).e = ((String)localObject1);
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.add(localObject2);
        continue;
        if (j == 1) {
          localArticleInfo.mFirstPagePicUrl = "";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJCreateArticleInfoForBiu
 * JD-Core Version:    0.7.0.1
 */