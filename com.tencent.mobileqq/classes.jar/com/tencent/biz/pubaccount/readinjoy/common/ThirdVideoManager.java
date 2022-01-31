package com.tencent.biz.pubaccount.readinjoy.common;

import android.os.Build.VERSION;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.readinjoy.struct.VidUrl;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoGetUrlReportData;
import com.tencent.mobileqq.ac.ArticleCenter.GetUrlByVidRequest;
import com.tencent.mobileqq.ac.ArticleCenter.GetVidByUrlRequest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import llf;
import llh;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class ThirdVideoManager
{
  private static MQLruCache jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache(120);
  private static volatile ThirdVideoManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVideoManager;
  public Long a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private ThirdVideoManager()
  {
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  }
  
  public static ThirdVideoManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVideoManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVideoManager == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVideoManager = new ThirdVideoManager();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonThirdVideoManager;
    }
    finally {}
  }
  
  public static VidUrl a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    VidUrl localVidUrl;
    do
    {
      return paramString;
      localVidUrl = (VidUrl)jdField_a_of_type_AndroidSupportV4UtilMQLruCache.get(paramString);
      if (localVidUrl == null) {
        break;
      }
      paramString = localVidUrl;
    } while (localVidUrl.a(NetConnInfoCenter.getServerTime()));
    return null;
  }
  
  private String a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("IMEI", DeviceInfoUtil.a());
      ((JSONObject)localObject).put("IMSI", DeviceInfoUtil.b());
      ((JSONObject)localObject).put("CpuFrequency", DeviceInfoUtil.a());
      ((JSONObject)localObject).put("CpuNum", DeviceInfoUtil.b());
      ((JSONObject)localObject).put("CpuType", DeviceInfoUtil.h());
      ((JSONObject)localObject).put("OsInfo", DeviceInfoUtil.a());
      ((JSONObject)localObject).put("DeviceModel", DeviceInfoUtil.e());
      ((JSONObject)localObject).put("DeviceOS", DeviceInfoUtil.f());
      ((JSONObject)localObject).put("ManufactureInfo", DeviceInfoUtil.i());
      ((JSONObject)localObject).put("Sdkversion", Build.VERSION.SDK_INT);
      ((JSONObject)localObject).put("QQVersion", DeviceInfoUtil.d());
      ((JSONObject)localObject).put("TotalRam", DeviceInfoUtil.e());
      ((JSONObject)localObject).put("AvailRam", DeviceInfoUtil.f());
      long[] arrayOfLong = DeviceInfoUtil.a();
      ((JSONObject)localObject).put("TotalRom", arrayOfLong[0]);
      ((JSONObject)localObject).put("AvailRom", arrayOfLong[1]);
      ((JSONObject)localObject).put("platform", 1);
      this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).toString();
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.TAG", 2, "deviceInfoDetail: " + this.jdField_a_of_type_JavaLangString);
      }
      localObject = this.jdField_a_of_type_JavaLangString;
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.TAG", 2, "deviceInfo  JSONException" + localJSONException);
      }
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    paramString = a(paramString);
    if (paramString != null) {
      return paramString.jdField_b_of_type_JavaLangString;
    }
    return "";
  }
  
  public static void a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.TAG", 2, "cache setVidUrl vid : " + paramString1 + " url:" + paramString2);
    }
    VidUrl localVidUrl = new VidUrl();
    localVidUrl.jdField_b_of_type_JavaLangString = paramString2;
    localVidUrl.jdField_a_of_type_JavaLangString = paramString1;
    localVidUrl.jdField_a_of_type_Long = paramLong;
    localVidUrl.jdField_a_of_type_Boolean = paramBoolean;
    jdField_a_of_type_AndroidSupportV4UtilMQLruCache.put(paramString1, localVidUrl);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    a(paramString1, paramString2, NetConnInfoCenter.getServerTime(), paramBoolean);
  }
  
  public static String[] a(String paramString)
  {
    String[] arrayOfString = new String[2];
    if (!TextUtils.isEmpty(paramString))
    {
      try
      {
        Object localObject = new URL(paramString);
        String str1 = ((URL)localObject).getHost();
        if (!TextUtils.isEmpty(str1))
        {
          String str2 = InnerDns.a().a(str1, 1006);
          if (!TextUtils.isEmpty(str2))
          {
            localObject = ((URL)localObject).getProtocol() + "://" + str2 + "/" + ((URL)localObject).getFile();
            if (((String)localObject).indexOf("&") < 0) {
              str1 = (String)localObject + "?txhost=" + str1;
            } else {
              str1 = (String)localObject + "&txhost=" + str1;
            }
          }
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        if ((QLog.isColorLevel()) && (localMalformedURLException != null)) {
          QLog.d("Q.readinjoy.video.TAG", 2, "replaceDomain2Ip MalformedURLException:" + localMalformedURLException.getMessage());
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.TAG", 2, "replaceDomain2Ip url:" + paramString);
      }
      arrayOfString[0] = paramString;
      return arrayOfString;
    }
    arrayOfString[0] = localMalformedURLException;
    arrayOfString[1] = paramString;
    return arrayOfString;
  }
  
  public void a(String paramString, ThirdVideoManager.UrlToUUIDCallback paramUrlToUUIDCallback)
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if ((localAppRuntime == null) || (localAppRuntime.getApplication() == null))
    {
      if (paramUrlToUUIDCallback != null) {
        paramUrlToUUIDCallback.a(paramString, "");
      }
      return;
    }
    long l = System.currentTimeMillis();
    NewIntent localNewIntent = new NewIntent(localAppRuntime.getApplication(), PublicAccountServlet.class);
    localNewIntent.putExtra("cmd", "PubAccountArticleCenter.GetVidByUrl");
    ArticleCenter.GetVidByUrlRequest localGetVidByUrlRequest = new ArticleCenter.GetVidByUrlRequest();
    ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramString);
    localGetVidByUrlRequest.url.set(localByteStringMicro);
    localGetVidByUrlRequest.mv.set(ByteStringMicro.copyFromUtf8("7.6.0,3,3525"));
    localNewIntent.putExtra("data", localGetVidByUrlRequest.toByteArray());
    localNewIntent.setObserver(new llh(this, l, localNewIntent, paramUrlToUUIDCallback, paramString));
    localAppRuntime.startServlet(localNewIntent);
  }
  
  public void a(String paramString1, String paramString2, ThirdVideoManager.UUIDToUrlCallback paramUUIDToUrlCallback)
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.a();
    if ((localAppRuntime == null) || (localAppRuntime.getApplication() == null) || (TextUtils.isEmpty(paramString2)))
    {
      if (paramUUIDToUrlCallback != null) {
        paramUUIDToUrlCallback.a("", paramString1, 0, false);
      }
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      if (paramUUIDToUrlCallback != null) {
        paramUUIDToUrlCallback.a("", paramString1, 0, false);
      }
      paramString2 = new VideoGetUrlReportData();
      paramString2.jdField_a_of_type_Boolean = false;
      paramString2.jdField_a_of_type_JavaLangString = paramString1;
      paramString2.jdField_a_of_type_Long = 0L;
      paramString2.jdField_b_of_type_Long = -4L;
      paramString2.jdField_b_of_type_JavaLangString = "vid is null";
      paramString2.jdField_b_of_type_Boolean = false;
      ReadInJoyUtils.c(localAppRuntime.getApplication(), ReadInJoyUtils.a(), true, paramString2.a());
      return;
    }
    Object localObject2 = a(paramString1);
    Object localObject1;
    boolean bool;
    if (localObject2 != null)
    {
      localObject1 = ((VidUrl)localObject2).jdField_b_of_type_JavaLangString;
      bool = ((VidUrl)localObject2).jdField_a_of_type_Boolean;
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.video.TAG", 2, "cache hit,  getUrlByVid vid : " + paramString1 + " url:" + (String)localObject1);
        }
        if (paramUUIDToUrlCallback == null) {
          break;
        }
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
        paramUUIDToUrlCallback.a((String)localObject1, paramString1, 0, bool);
        return;
      }
      long l = System.currentTimeMillis();
      localObject1 = new NewIntent(localAppRuntime.getApplication(), PublicAccountServlet.class);
      ((NewIntent)localObject1).putExtra("cmd", paramString2);
      localObject2 = new ArticleCenter.GetUrlByVidRequest();
      ByteStringMicro localByteStringMicro = ByteStringMicro.copyFromUtf8(paramString1);
      ((ArticleCenter.GetUrlByVidRequest)localObject2).vid.set(localByteStringMicro);
      ((ArticleCenter.GetUrlByVidRequest)localObject2).mv.set(ByteStringMicro.copyFromUtf8("7.6.0,3,3525"));
      int i = NetUtil.a(null);
      ((ArticleCenter.GetUrlByVidRequest)localObject2).net_type.set(i);
      ((ArticleCenter.GetUrlByVidRequest)localObject2).video_type.set(0);
      ((ArticleCenter.GetUrlByVidRequest)localObject2).mobile_detail_info.set(ByteStringMicro.copyFromUtf8(a()));
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.TAG", 2, "sendUUIDToUrlRequest netType : " + i + ", vid : " + paramString1);
      }
      ((NewIntent)localObject1).putExtra("data", ((ArticleCenter.GetUrlByVidRequest)localObject2).toByteArray());
      ((NewIntent)localObject1).setObserver(new llf(this, (NewIntent)localObject1, l, paramUUIDToUrlCallback, paramString1, paramString2, localAppRuntime));
      localAppRuntime.startServlet((NewIntent)localObject1);
      return;
      bool = false;
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ThirdVideoManager
 * JD-Core Version:    0.7.0.1
 */