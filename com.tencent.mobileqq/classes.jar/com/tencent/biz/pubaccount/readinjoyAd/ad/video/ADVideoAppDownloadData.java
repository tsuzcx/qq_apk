package com.tencent.biz.pubaccount.readinjoyAd.ad.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ADVideoAppDownloadData
{
  public int a;
  public VideoInfo.GameAdComData a;
  public AdvertisementInfo a;
  public AdData a;
  public WadlParams a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g = "";
  public String h = "";
  public String i;
  public String j;
  
  public ADVideoAppDownloadData()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
  }
  
  /* Error */
  public static ADVideoAppDownloadData a(VideoInfo.GameAdComData paramGameAdComData)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: getfield 44	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:t	Ljava/lang/String;
    //   10: ifnull +185 -> 195
    //   13: new 46	org/json/JSONObject
    //   16: dup
    //   17: aload_0
    //   18: getfield 44	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:t	Ljava/lang/String;
    //   21: invokespecial 49	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload_0
    //   26: new 51	com/tencent/biz/pubaccount/VideoInfo$GameAdDownloadInfo
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 54	com/tencent/biz/pubaccount/VideoInfo$GameAdDownloadInfo:<init>	(Lorg/json/JSONObject;)V
    //   34: putfield 57	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:a	Lcom/tencent/biz/pubaccount/VideoInfo$GameAdDownloadInfo;
    //   37: new 2	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData
    //   40: dup
    //   41: invokespecial 58	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData:<init>	()V
    //   44: astore_1
    //   45: aload_1
    //   46: aload_0
    //   47: getfield 59	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:g	Ljava/lang/String;
    //   50: putfield 61	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   53: aload_1
    //   54: aload_0
    //   55: getfield 63	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:d	Ljava/lang/String;
    //   58: putfield 64	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData:d	Ljava/lang/String;
    //   61: aload_1
    //   62: aload_0
    //   63: getfield 66	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:c	Ljava/lang/String;
    //   66: putfield 68	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData:e	Ljava/lang/String;
    //   69: aload_1
    //   70: aload_2
    //   71: ldc 70
    //   73: invokevirtual 74	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: putfield 75	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData:c	Ljava/lang/String;
    //   79: aload_1
    //   80: iconst_0
    //   81: putfield 77	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData:jdField_b_of_type_Int	I
    //   84: aload_1
    //   85: iconst_0
    //   86: putfield 27	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData:jdField_a_of_type_Int	I
    //   89: aload_1
    //   90: iconst_1
    //   91: putfield 79	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData:jdField_a_of_type_Boolean	Z
    //   94: aload_1
    //   95: aload_0
    //   96: putfield 81	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData:jdField_a_of_type_ComTencentBizPubaccountVideoInfo$GameAdComData	Lcom/tencent/biz/pubaccount/VideoInfo$GameAdComData;
    //   99: new 46	org/json/JSONObject
    //   102: dup
    //   103: aload_0
    //   104: getfield 84	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:C	Ljava/lang/String;
    //   107: invokespecial 49	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   110: astore_2
    //   111: aload_1
    //   112: aload_2
    //   113: ldc 86
    //   115: ldc 29
    //   117: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   120: putfield 33	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData:h	Ljava/lang/String;
    //   123: aload_1
    //   124: aload_2
    //   125: ldc 91
    //   127: ldc 29
    //   129: invokevirtual 89	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 31	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData:g	Ljava/lang/String;
    //   135: aload_1
    //   136: aload_0
    //   137: getfield 94	com/tencent/biz/pubaccount/VideoInfo$GameAdComData:v	Ljava/lang/String;
    //   140: putfield 96	com/tencent/biz/pubaccount/readinjoyAd/ad/video/ADVideoAppDownloadData:j	Ljava/lang/String;
    //   143: aload_1
    //   144: areturn
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_0
    //   148: aload_0
    //   149: astore_1
    //   150: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   153: ifeq -10 -> 143
    //   156: ldc 104
    //   158: iconst_1
    //   159: new 106	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   166: ldc 109
    //   168: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: aload_2
    //   172: invokevirtual 117	org/json/JSONException:toString	()Ljava/lang/String;
    //   175: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: aload_0
    //   185: astore_1
    //   186: goto -43 -> 143
    //   189: astore_2
    //   190: aload_1
    //   191: astore_0
    //   192: goto -44 -> 148
    //   195: aconst_null
    //   196: astore_1
    //   197: goto -54 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramGameAdComData	VideoInfo.GameAdComData
    //   44	153	1	localObject	Object
    //   24	101	2	localJSONObject	JSONObject
    //   145	27	2	localJSONException1	JSONException
    //   189	1	2	localJSONException2	JSONException
    // Exception table:
    //   from	to	target	type
    //   6	45	145	org/json/JSONException
    //   45	143	189	org/json/JSONException
  }
  
  public static ADVideoAppDownloadData a(AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean)
  {
    Object localObject2 = null;
    if (paramAdvertisementInfo == null) {
      return localObject2;
    }
    for (;;)
    {
      try
      {
        if (ReadInJoyAdUtils.a(paramAdvertisementInfo) != 2) {
          continue;
        }
        localObject3 = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
        localObject1 = new ADVideoAppDownloadData();
        localObject2 = localObject1;
      }
      catch (JSONException localJSONException2)
      {
        Object localObject3;
        JSONObject localJSONObject;
        Object localObject1 = null;
        continue;
        localObject1 = null;
        continue;
        localObject1 = "";
        continue;
      }
      try
      {
        ((ADVideoAppDownloadData)localObject1).jdField_a_of_type_Boolean = true;
        localObject2 = localObject1;
        ((ADVideoAppDownloadData)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject3).optString("game_app_id");
        localObject2 = localObject1;
        ((ADVideoAppDownloadData)localObject1).d = ((JSONObject)localObject3).optString("game_pkg_name");
        localObject2 = localObject1;
        ((ADVideoAppDownloadData)localObject1).e = ((JSONObject)localObject3).optString("game_app_name");
        localObject2 = localObject1;
        ((ADVideoAppDownloadData)localObject1).c = ((JSONObject)localObject3).optString("game_apk_url");
        localObject2 = localObject1;
        ((ADVideoAppDownloadData)localObject1).g = ((JSONObject)localObject3).optString("game_adtag");
        localObject2 = localObject1;
        ((ADVideoAppDownloadData)localObject1).h = ((JSONObject)localObject3).optString("__ADSTR__");
        localObject2 = localObject1;
        ((ADVideoAppDownloadData)localObject1).jdField_b_of_type_Int = 0;
        localObject2 = localObject1;
        ((ADVideoAppDownloadData)localObject1).jdField_a_of_type_Int = 0;
        localObject2 = localObject1;
        ((ADVideoAppDownloadData)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
        localObject2 = localObject1;
        if (paramAdvertisementInfo.mAdExt == null) {
          continue;
        }
        localObject2 = localObject1;
        localJSONObject = new JSONObject(paramAdvertisementInfo.mAdExt);
        localObject2 = localObject1;
        localObject3 = new ADVideoAppDownloadData();
      }
      catch (JSONException localJSONException3)
      {
        localObject1 = localJSONException1;
        continue;
        continue;
      }
      try
      {
        ((ADVideoAppDownloadData)localObject3).jdField_a_of_type_JavaLangString = localJSONObject.optString("appid");
        if (!paramBoolean) {
          continue;
        }
        localObject1 = paramAdvertisementInfo.mAdRl;
        ((ADVideoAppDownloadData)localObject3).jdField_b_of_type_JavaLangString = ((String)localObject1);
        ((ADVideoAppDownloadData)localObject3).d = localJSONObject.optString("pkg_name");
        ((ADVideoAppDownloadData)localObject3).e = localJSONObject.optString("appname");
        if ((paramAdvertisementInfo.mAdvertisementExtInfo == null) || (paramAdvertisementInfo.mAdvertisementExtInfo.j != 32)) {
          continue;
        }
        if (!TextUtils.isEmpty(((ADVideoAppDownloadData)localObject3).jdField_b_of_type_JavaLangString)) {
          continue;
        }
        localObject1 = localJSONObject.optString("pkgurl");
        ((ADVideoAppDownloadData)localObject3).c = ((String)localObject1);
        ((ADVideoAppDownloadData)localObject3).jdField_b_of_type_Int = 0;
        ((ADVideoAppDownloadData)localObject3).jdField_a_of_type_Int = 0;
        ((ADVideoAppDownloadData)localObject3).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = paramAdvertisementInfo;
        localObject1 = localObject3;
        if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdVia))
        {
          ((ADVideoAppDownloadData)localObject3).f = paramAdvertisementInfo.mAdVia;
          localObject1 = localObject3;
        }
      }
      catch (JSONException localJSONException1)
      {
        localObject1 = localObject3;
        localObject3 = localJSONException1;
        ((JSONException)localObject3).printStackTrace();
        QLog.d("ADVideoAppDownloadData", 1, "getADVideoAppDownloadData exception :" + ((JSONException)localObject3).toString());
        continue;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        break;
      }
      ((ADVideoAppDownloadData)localObject1).j = paramAdvertisementInfo.mAdBtnTxt;
      return localObject1;
      localObject1 = paramAdvertisementInfo.mAdDownloadApiUrl;
      continue;
      localObject2 = localJSONObject.optString("pkgurl");
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = localJSONObject.optString("apk_url");
      }
      ((ADVideoAppDownloadData)localObject3).c = ((String)localObject1);
    }
  }
  
  public static ADVideoAppDownloadData a(AdvertisementSoftInfo paramAdvertisementSoftInfo, int paramInt)
  {
    boolean bool = false;
    if (paramAdvertisementSoftInfo == null) {
      return null;
    }
    ADVideoAppDownloadData localADVideoAppDownloadData = new ADVideoAppDownloadData();
    localADVideoAppDownloadData.jdField_a_of_type_JavaLangString = paramAdvertisementSoftInfo.p;
    localADVideoAppDownloadData.jdField_b_of_type_JavaLangString = paramAdvertisementSoftInfo.r;
    localADVideoAppDownloadData.d = paramAdvertisementSoftInfo.o;
    localADVideoAppDownloadData.e = paramAdvertisementSoftInfo.q;
    localADVideoAppDownloadData.c = paramAdvertisementSoftInfo.r;
    localADVideoAppDownloadData.g = paramAdvertisementSoftInfo.v;
    localADVideoAppDownloadData.h = paramAdvertisementSoftInfo.w;
    localADVideoAppDownloadData.jdField_b_of_type_Int = 0;
    localADVideoAppDownloadData.jdField_a_of_type_Int = 0;
    if (paramInt != 0) {
      bool = true;
    }
    localADVideoAppDownloadData.jdField_a_of_type_Boolean = bool;
    localADVideoAppDownloadData.j = paramAdvertisementSoftInfo.L;
    return localADVideoAppDownloadData;
  }
  
  public static String a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramVideoAdInfo.r != null)
        {
          paramVideoAdInfo = new JSONObject(paramVideoAdInfo.r).optString("pkg_name");
          return paramVideoAdInfo;
        }
      }
      catch (JSONException paramVideoAdInfo)
      {
        paramVideoAdInfo.printStackTrace();
        QLog.d("ADVideoAppDownloadData", 1, "getADVideoAppDownloadData exception :" + paramVideoAdInfo.toString());
      }
    }
    return null;
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(this.c);
  }
  
  public boolean a(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    return (paramADVideoAppDownloadData != null) && (paramADVideoAppDownloadData.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString)) && (paramADVideoAppDownloadData.d.equals(this.d)) && (paramADVideoAppDownloadData.jdField_b_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean b()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.d)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (ADVideoAppDownloadData)paramObject;
      if (this.c != null)
      {
        if (this.c.equals(paramObject.c)) {}
      }
      else {
        while (paramObject.c != null) {
          return false;
        }
      }
      if (this.d != null) {
        return this.d.equals(paramObject.d);
      }
    } while (paramObject.d == null);
    return false;
  }
  
  public int hashCode()
  {
    int m = 0;
    if (this.c != null) {}
    for (int k = this.c.hashCode();; k = 0)
    {
      if (this.d != null) {
        m = this.d.hashCode();
      }
      return k * 31 + m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData
 * JD-Core Version:    0.7.0.1
 */