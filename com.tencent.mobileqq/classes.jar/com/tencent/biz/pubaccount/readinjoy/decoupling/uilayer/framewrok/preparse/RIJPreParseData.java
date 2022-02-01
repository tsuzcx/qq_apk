package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDisplayUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteDataParser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.PGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCPicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVideoInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class RIJPreParseData
{
  public static Pair<Integer, Integer> a(Pair<Integer, Integer>[] paramArrayOfPair, int paramInt1, int paramInt2)
  {
    int j = paramArrayOfPair.length;
    double d2 = 1.0D * paramInt2 / paramInt1;
    double d1 = 1.7976931348623157E+308D;
    Pair<Integer, Integer> localPair = null;
    int i = 0;
    double d3;
    double d4;
    if (i < j)
    {
      d3 = 1.0D * ((Integer)paramArrayOfPair[i].second).intValue() / ((Integer)paramArrayOfPair[i].first).intValue();
      d4 = Math.abs(d3 - d2);
      if (d4 < d1)
      {
        d1 = Math.abs(d3 - d2);
        localPair = paramArrayOfPair[i];
      }
    }
    for (;;)
    {
      i += 1;
      break;
      if ((d4 == d1) && (localPair != null))
      {
        int k = Math.abs(((Integer)localPair.second).intValue() - paramInt2);
        int m = Math.abs(((Integer)localPair.first).intValue() - paramInt1);
        int n = Math.abs(((Integer)paramArrayOfPair[i].second).intValue() - paramInt2);
        if (k + m > Math.abs(((Integer)paramArrayOfPair[i].first).intValue() - paramInt1) + n)
        {
          d1 = Math.abs(d3 - d2);
          localPair = paramArrayOfPair[i];
          continue;
          return localPair;
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.getFile();
    }
    return null;
  }
  
  @Deprecated
  public static String a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!ReadInJoyHelper.b(RIJQQAppInterfaceUtil.a())) {
      if (QLog.isColorLevel()) {
        QLog.d("RIJPreParseData", 2, "smart crop switch is false ! url : " + paramString);
      }
    }
    Pair localPair;
    do
    {
      return paramString;
      localPair = a(ReadInJoyConstants.a, paramInt2, paramInt1);
    } while (localPair == null);
    if (QLog.isColorLevel()) {
      QLog.d("RIJPreParseData", 2, "the picture size : w : " + paramInt2 + " h : " + paramInt1 + ", select scale : " + localPair.first + ":" + localPair.second + " from : " + paramInt3);
    }
    Object localObject = paramString.split("/");
    localObject = localObject[(localObject.length - 1)];
    return paramString.replace("_open/" + (String)localObject, "_open_" + localPair.first + "_" + localPair.second + "/" + (String)localObject);
  }
  
  public static String a(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    paramString = a(paramString);
    Object localObject2;
    long l2;
    Object localObject1;
    if ((paramString != null) && (paramString.length() > 0))
    {
      localObject2 = paramString.optJSONObject(0);
      if (localObject2 != null)
      {
        String str2 = ((JSONObject)localObject2).optString("vid");
        int k = ((JSONObject)localObject2).optInt("duration");
        String str3 = ((JSONObject)localObject2).optString("thirdIcon");
        String str4 = ((JSONObject)localObject2).optString("thirdName");
        String str5 = ((JSONObject)localObject2).optString("thirdAction");
        String str6 = ((JSONObject)localObject2).optString("innerUniqueID");
        String str7 = ((JSONObject)localObject2).optString("width", "0");
        String str8 = ((JSONObject)localObject2).optString("height", "0");
        int j = ((JSONObject)localObject2).optInt("busiType");
        int i = j;
        if (j == 0) {
          i = 1;
        }
        String str9 = ((JSONObject)localObject2).optString("third_uin", "");
        String str10 = ((JSONObject)localObject2).optString("third_uin_name", "");
        paramString = "0";
        String str1 = "";
        l2 = 0L;
        if (!RIJItemViewType.j(paramBaseArticleInfo)) {
          paramString = String.valueOf(((JSONObject)localObject2).optLong("file_size"));
        }
        paramBaseArticleInfo = str1;
        localObject1 = paramString;
        for (;;)
        {
          try
          {
            JSONArray localJSONArray = ((JSONObject)localObject2).optJSONArray("video_info");
            localObject3 = str1;
            l1 = l2;
            localObject2 = paramString;
            if (localJSONArray != null)
            {
              j = 0;
              localObject3 = str1;
              l1 = l2;
              localObject2 = paramString;
              paramBaseArticleInfo = str1;
              localObject1 = paramString;
              if (j < localJSONArray.length())
              {
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                JSONObject localJSONObject = localJSONArray.optJSONObject(j);
                if (localJSONObject == null) {
                  continue;
                }
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                int m = localJSONObject.optInt("network_type");
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                l1 = localJSONObject.optLong("file_size");
                if (m != 2) {
                  continue;
                }
                paramBaseArticleInfo = str1;
                localObject1 = paramString;
                localObject2 = String.valueOf(l1);
                paramBaseArticleInfo = str1;
                localObject1 = localObject2;
                localObject3 = localJSONObject.optString("url", "");
                paramBaseArticleInfo = (BaseArticleInfo)localObject3;
                localObject1 = localObject2;
                l1 = localJSONObject.optLong("url_expire_time");
              }
            }
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            Object localObject3 = paramBaseArticleInfo;
            long l1 = l2;
            localObject2 = localObject1;
            continue;
          }
          return str2 + ";" + k + ";" + str3 + ";" + str4 + ";" + str5 + ";" + str6 + ";" + i + ";" + str7 + ";" + str8 + ";" + str9 + ";" + str10 + ";" + (String)localObject2 + ";" + (String)localObject3 + ";" + l1;
          j += 1;
        }
      }
    }
    return null;
  }
  
  public static URL a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    paramBaseArticleInfo = a(paramString);
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.length() > 0))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.optJSONObject(0);
      if (paramBaseArticleInfo != null) {
        try
        {
          paramBaseArticleInfo = paramBaseArticleInfo.optString("picture");
          paramBaseArticleInfo = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramBaseArticleInfo, 3);
          return paramBaseArticleInfo;
        }
        catch (Exception paramBaseArticleInfo)
        {
          QLog.e("RIJPreParseData", 1, new Object[] { "getReadinjoyVideoConvelFromJson", QLog.getStackTraceString(paramBaseArticleInfo) });
        }
      }
    }
    return null;
  }
  
  public static URL a(String paramString)
  {
    return a(paramString, true);
  }
  
  public static URL a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (!paramBoolean) {
      try
      {
        paramString = new URL(paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        QLog.e("RIJPreParseData", 1, new Object[] { "convertString2URL", QLog.getStackTraceString(paramString) });
        return null;
      }
    }
    return ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramString, 3);
  }
  
  public static URL a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (a(paramString)) {
      if (!paramBoolean1) {
        break label57;
      }
    }
    label57:
    for (localObject = ReadInJoyDisplayUtils.e();; localObject = ReadInJoyDisplayUtils.a())
    {
      localObject = a(paramString, ((Integer)((Pair)localObject).second).intValue(), ((Integer)((Pair)localObject).first).intValue(), 3);
      return a((String)localObject);
    }
  }
  
  private static JSONArray a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      try
      {
        paramString = (JSONObject)new JSONTokener(paramString).nextValue();
        if ((paramString != null) && (!TextUtils.isEmpty(paramString.toString())))
        {
          paramString = paramString.optJSONArray("videos");
          if (paramString != null)
          {
            int i = paramString.length();
            if (i >= 1) {
              continue;
            }
          }
          return null;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("RIJPreParseData", 1, new Object[] { "getVideoJsonArray", QLog.getStackTraceString(paramString) });
        return null;
      }
    }
    return null;
  }
  
  private static JSONObject a(String paramString)
  {
    paramString = a(paramString);
    if ((paramString == null) || (paramString.length() <= 0)) {
      return null;
    }
    return paramString.optJSONObject(0);
  }
  
  public static void a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    PTSLiteDataParser.a(paramArticleInfo);
    for (;;)
    {
      JSONObject localJSONObject;
      String str;
      try
      {
        localJSONObject = new JSONObject(paramArticleInfo.proteusItemsData);
        QLog.d("RIJPreParseData", 2, new Object[] { "mArticleInfo.proteusItemsData = ", paramArticleInfo.proteusItemsData });
        Iterator localIterator = localJSONObject.keys();
        if (!localIterator.hasNext()) {
          break;
        }
        str = (String)localIterator.next();
        if ("id_super_topic".equals(str))
        {
          paramArticleInfo.isSuperTopic = true;
          return;
        }
      }
      catch (JSONException paramArticleInfo)
      {
        QLog.d("RIJPreParseData", 2, new Object[] { "preParseProteusItemData", QLog.getStackTraceString(paramArticleInfo) });
        return;
      }
      a(str, localJSONObject, paramArticleInfo);
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a.size() > 0))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.a.iterator();
      while (paramBaseArticleInfo.hasNext())
      {
        SocializeFeedsInfo.UGCPicInfo localUGCPicInfo = (SocializeFeedsInfo.UGCPicInfo)paramBaseArticleInfo.next();
        if (localUGCPicInfo != null)
        {
          localUGCPicInfo.b = a(localUGCPicInfo.b);
          localUGCPicInfo.c = a(localUGCPicInfo.c);
        }
      }
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return;
    }
    paramBaseArticleInfo.setFirstFrameUrl(a(paramString.optString("first_frame")));
  }
  
  private static void a(String paramString, JSONObject paramJSONObject, ArticleInfo paramArticleInfo)
  {
    if ("mini_program_name".equals(paramString)) {
      paramArticleInfo.miniProgramName = paramJSONObject.optString("mini_program_name");
    }
    if ("movie_name".equals(paramString)) {
      paramArticleInfo.miniAppMovieName = paramJSONObject.optString("movie_name");
    }
    if ("exRowkey".equals(paramString)) {
      paramArticleInfo.miniRowKey = paramJSONObject.optString("exRowkey");
    }
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return false;
    }
    if ((paramBaseArticleInfo.mFeedType == 0) && (paramBaseArticleInfo.mIsGallery > 0) && (paramBaseArticleInfo.mGalleryFeedsInfo != null))
    {
      int i = paramBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
      if ((i == 3) || (i == 2) || (i == 1))
      {
        paramBaseArticleInfo.mIsGalleryChannel = true;
        return true;
      }
    }
    paramBaseArticleInfo.mIsGalleryChannel = false;
    return false;
  }
  
  @Deprecated
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return false;
        paramString = paramString.split("/");
      } while (paramString.length < 2);
      paramString = paramString[(paramString.length - 2)].split("_");
    } while (paramString.length < 1);
    return "open".equals(paramString[(paramString.length - 1)]);
  }
  
  public static URL[] a(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramString = (JSONObject)new JSONTokener(paramString).nextValue();
        if ((paramString == null) || (paramString.length() <= 0)) {
          break label247;
        }
        JSONArray localJSONArray = paramString.optJSONArray("pictures");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          URL[] arrayOfURL = new URL[localJSONArray.length()];
          paramString = ReadInJoyDisplayUtils.a();
          if (a(paramBaseArticleInfo))
          {
            i = paramBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get();
            if (i == 2)
            {
              paramString = ReadInJoyDisplayUtils.b();
              break label249;
              if (i < localJSONArray.length())
              {
                String str = localJSONArray.optJSONObject(i).optString("picture");
                if (TextUtils.isEmpty(str)) {
                  break label254;
                }
                paramBaseArticleInfo = str;
                if (a(str)) {
                  paramBaseArticleInfo = a(str, ((Integer)paramString.second).intValue(), ((Integer)paramString.first).intValue(), 1);
                }
                arrayOfURL[i] = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramBaseArticleInfo, 3);
                break label254;
              }
            }
            else
            {
              if (i == 3)
              {
                paramString = ReadInJoyDisplayUtils.d();
                break label249;
              }
              if (i != 1) {
                break label244;
              }
              paramString = ReadInJoyDisplayUtils.c();
              break label249;
            }
            return arrayOfURL;
          }
        }
        else
        {
          return null;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("RIJPreParseData", 1, new Object[] { "getReadinjoyFeedsPicturesFromJson", QLog.getStackTraceString(paramString) });
        return null;
      }
      label244:
      break label249;
      label247:
      return null;
      label249:
      int i = 0;
      continue;
      label254:
      i += 1;
    }
  }
  
  public static URL b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = paramString;
    if (a(paramString))
    {
      localObject = ReadInJoyDisplayUtils.c();
      localObject = a(paramString, ((Integer)((Pair)localObject).second).intValue(), ((Integer)((Pair)localObject).first).intValue(), 3);
    }
    return a((String)localObject);
  }
  
  public static void b(BaseArticleInfo paramBaseArticleInfo)
  {
    for (;;)
    {
      try
      {
        if ((paramBaseArticleInfo.mDislikeInfos == null) || (paramBaseArticleInfo.mDislikeInfos.size() <= 0)) {
          paramBaseArticleInfo.mDislikeInfos = DislikeInfo.a(paramBaseArticleInfo.mDiskLikeInfoString);
        }
        paramBaseArticleInfo.mPictures = a(paramBaseArticleInfo.mJsonPictureList, paramBaseArticleInfo);
        if ((RIJItemViewType.h(paramBaseArticleInfo)) && (!RIJItemViewType.l(paramBaseArticleInfo)))
        {
          paramBaseArticleInfo.mSinglePicture = a(((TopicRecommendFeedsInfo.TopicRecommendInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.a.get(0)).d, true, true);
          if (!TextUtils.isEmpty(paramBaseArticleInfo.mFirstPagePicUrl)) {
            paramBaseArticleInfo.mFirstPagePicUrl = a(paramBaseArticleInfo.mFirstPagePicUrl);
          }
          if (paramBaseArticleInfo.mVideoCoverUrl != null) {
            paramBaseArticleInfo.mVideoCoverUrl = ((IPublicAccountHttpDownloader)QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(paramBaseArticleInfo.mVideoCoverUrl.toString(), 3);
          }
          if (QLog.isColorLevel()) {
            QLog.d("RIJPreParseData", 2, "preParseArticleJsonParam mJsonVideoList = " + paramBaseArticleInfo.mJsonVideoList);
          }
          if (TextUtils.isEmpty(paramBaseArticleInfo.mJsonVideoList)) {
            break label616;
          }
          if (QLog.isColorLevel()) {
            QLog.d("RIJPreParseData", 2, "preParseArticleJsonParam article.mArticleID:" + paramBaseArticleInfo.mArticleID + " article.mTitle:" + paramBaseArticleInfo.mTitle + " article.mSummary:" + paramBaseArticleInfo.mSummary + "mJsonVideoList:" + paramBaseArticleInfo.mJsonVideoList);
          }
          paramBaseArticleInfo.mVideoCoverUrl = a(paramBaseArticleInfo, paramBaseArticleInfo.mJsonVideoList);
          localObject = a(paramBaseArticleInfo.mJsonVideoList, paramBaseArticleInfo);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = ((String)localObject).split(";");
            paramBaseArticleInfo.mVideoVid = localObject[0];
            paramBaseArticleInfo.mVideoDuration = Integer.valueOf(localObject[1]).intValue();
            paramBaseArticleInfo.thirdIcon = localObject[2];
            paramBaseArticleInfo.thirdName = localObject[3];
            paramBaseArticleInfo.thirdAction = localObject[4];
            if ((paramBaseArticleInfo.mFeedType != 3) && (TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID))) {
              paramBaseArticleInfo.innerUniqueID = localObject[5];
            }
            paramBaseArticleInfo.busiType = Integer.valueOf(localObject[6]).intValue();
            paramBaseArticleInfo.mVideoJsonWidth = Integer.valueOf(localObject[7]).intValue();
            paramBaseArticleInfo.mVideoJsonHeight = Integer.valueOf(localObject[8]).intValue();
            paramBaseArticleInfo.thirdUin = localObject[9];
            paramBaseArticleInfo.thirdUinName = localObject[10];
            paramBaseArticleInfo.mXGFileSize = Long.valueOf(localObject[11]).longValue();
            paramBaseArticleInfo.mThirdVideoURL = localObject[12];
            paramBaseArticleInfo.mThirdVideoURLExpireTime = Long.valueOf(localObject[13]).longValue();
          }
          a(paramBaseArticleInfo, paramBaseArticleInfo.mJsonVideoList);
          return;
        }
        if (((paramBaseArticleInfo instanceof ArticleInfo)) && ((RIJItemViewType.a((ArticleInfo)paramBaseArticleInfo)) || (RIJItemViewType.f((ArticleInfo)paramBaseArticleInfo))))
        {
          paramBaseArticleInfo.mSinglePicture = a(paramBaseArticleInfo.mFirstPagePicUrl, RIJItemViewType.g((ArticleInfo)paramBaseArticleInfo), true);
          a(paramBaseArticleInfo);
          c(paramBaseArticleInfo);
          continue;
        }
        if (!a(paramBaseArticleInfo)) {
          break;
        }
      }
      catch (Exception paramBaseArticleInfo)
      {
        QLog.e("RIJPreParseData", 1, new Object[] { "preParseArticleJsonParam", QLog.getStackTraceString(paramBaseArticleInfo) });
        return;
      }
      if (paramBaseArticleInfo.mGalleryFeedsInfo.enum_article_style.get() != 1) {
        break;
      }
      paramBaseArticleInfo.mSinglePicture = b(paramBaseArticleInfo.mFirstPagePicUrl, RIJItemViewType.g((ArticleInfo)paramBaseArticleInfo), true);
    }
    Object localObject = paramBaseArticleInfo.mFirstPagePicUrl;
    boolean bool2 = paramBaseArticleInfo.mShowBigPicture;
    if (paramBaseArticleInfo.mVideoType == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramBaseArticleInfo.mSinglePicture = a((String)localObject, bool2, bool1);
      break;
      label616:
      if (((paramBaseArticleInfo instanceof ArticleInfo)) && (!RIJItemViewType.q((ArticleInfo)paramBaseArticleInfo))) {
        paramBaseArticleInfo.busiType = ((SocializeFeedsInfo.UGCVideoInfo)paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.b.get(0)).f;
      }
      return;
    }
  }
  
  private static void c(BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a != null) && (paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.size() > 0))
    {
      paramBaseArticleInfo = paramBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$PGCFeedsInfo.a.iterator();
      while (paramBaseArticleInfo.hasNext())
      {
        SocializeFeedsInfo.PGCPicInfo localPGCPicInfo = (SocializeFeedsInfo.PGCPicInfo)paramBaseArticleInfo.next();
        if (localPGCPicInfo != null)
        {
          localPGCPicInfo.b = a(localPGCPicInfo.b);
          localPGCPicInfo.c = a(localPGCPicInfo.c);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData
 * JD-Core Version:    0.7.0.1
 */