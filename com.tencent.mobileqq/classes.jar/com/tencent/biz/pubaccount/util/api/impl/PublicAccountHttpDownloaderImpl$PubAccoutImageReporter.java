package com.tencent.biz.pubaccount.util.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.dns.BaseInnerDns;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class PublicAccountHttpDownloaderImpl$PubAccoutImageReporter
{
  public int a;
  private long jdField_a_of_type_Long;
  private BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  private final String jdField_a_of_type_JavaLangString;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private Map<String, String> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "2909288299" };
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  
  public PublicAccountHttpDownloaderImpl$PubAccoutImageReporter(PublicAccountHttpDownloaderImpl paramPublicAccountHttpDownloaderImpl, BaseApplicationImpl paramBaseApplicationImpl, int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    this.jdField_b_of_type_Int = a();
    paramPublicAccountHttpDownloaderImpl = new StringBuilder();
    paramPublicAccountHttpDownloaderImpl.append("PubAccountHttpDownloader.");
    paramPublicAccountHttpDownloaderImpl.append(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_JavaLangString = paramPublicAccountHttpDownloaderImpl.toString();
  }
  
  private void a(NetResp paramNetResp)
  {
    if (paramNetResp != null)
    {
      if (paramNetResp.mRespProperties != null)
      {
        paramNetResp = (String)paramNetResp.mRespProperties.get("param_rspHeader");
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("resp: ");
        localStringBuilder.append(paramNetResp);
        QLog.d(str, 1, localStringBuilder.toString());
        return;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "esp headers: empty");
      return;
    }
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "resp is null");
  }
  
  private boolean a(String paramString)
  {
    if (paramString != null)
    {
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      int k = arrayOfString.length;
      int j = 0;
      while (j < k)
      {
        if (paramString.equals(arrayOfString[j])) {
          return true;
        }
        j += 1;
      }
    }
    return false;
  }
  
  public int a()
  {
    try
    {
      this.jdField_a_of_type_Int += 1;
      int j = this.jdField_a_of_type_Int;
      return j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public URLDrawableHandler a(URLDrawableHandler paramURLDrawableHandler)
  {
    return new PublicAccountHttpDownloaderImpl.PubAccoutImageReporter.WrapURLDrawableHandler(this, paramURLDrawableHandler, this);
  }
  
  public void a()
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_d_of_type_JavaLangString = null;
  }
  
  public void a(int paramInt, DownloadParams paramDownloadParams)
  {
    boolean bool = this.jdField_a_of_type_JavaUtilMap.containsKey("puin");
    HashMap localHashMap = null;
    Object localObject3;
    if (bool)
    {
      localObject1 = (String)this.jdField_a_of_type_JavaUtilMap.get("puin");
      paramDownloadParams = (String)this.jdField_a_of_type_JavaUtilMap.get("msgid");
    }
    else if ((paramDownloadParams.mExtraInfo != null) && ((paramDownloadParams.mExtraInfo instanceof MessageRecord)))
    {
      localObject3 = (MessageRecord)paramDownloadParams.mExtraInfo;
      localObject2 = ((MessageRecord)localObject3).frienduin;
      if ((localObject3 instanceof MessageForStructing))
      {
        paramDownloadParams = (MessageForStructing)localObject3;
        if (paramDownloadParams.structingMsg != null)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append(paramDownloadParams.structingMsg.msgId);
          paramDownloadParams = ((StringBuilder)localObject1).toString();
          localObject1 = localObject2;
          break label235;
        }
      }
      localObject1 = localObject2;
      paramDownloadParams = localHashMap;
      if ((localObject3 instanceof MessageForPubAccount))
      {
        localObject3 = (MessageForPubAccount)localObject3;
        localObject1 = localObject2;
        paramDownloadParams = localHashMap;
        if (((MessageForPubAccount)localObject3).mPAMessage != null)
        {
          paramDownloadParams = new StringBuilder();
          paramDownloadParams.append("");
          paramDownloadParams.append(((MessageForPubAccount)localObject3).mPAMessage.mMsgId);
          paramDownloadParams = paramDownloadParams.toString();
          localObject1 = localObject2;
        }
      }
    }
    else
    {
      localObject1 = null;
      paramDownloadParams = localHashMap;
    }
    label235:
    if (a((String)localObject1)) {
      return;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getRuntime();
    if ((localObject2 != null) && ((localObject2 instanceof QQAppInterface)))
    {
      localObject2 = (QQAppInterface)localObject2;
      if (localObject1 != null)
      {
        int j = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getAccountType((AppInterface)localObject2, (String)localObject1);
        if (j != -5)
        {
          if (j != -4)
          {
            if (j != -3)
            {
              if (j != -1)
              {
                if (this.jdField_c_of_type_Int == 0) {
                  return;
                }
                j = 0;
              }
              else
              {
                j = 1;
              }
            }
            else {
              j = 3;
            }
          }
          else {
            j = 2;
          }
        }
        else {
          j = 4;
        }
        localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(j);
        localHashMap.put("param_acc_type", ((StringBuilder)localObject3).toString());
        this.jdField_a_of_type_JavaUtilHashMap.put("param_puin", localObject1);
      }
      localObject1 = ((QQAppInterface)localObject2).getCurrentAccountUin();
      if (localObject1 != null) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_uin", localObject1);
      }
    }
    if (paramDownloadParams != null) {
      this.jdField_a_of_type_JavaUtilHashMap.put("param_msgid", paramDownloadParams);
    }
    paramDownloadParams = this.jdField_a_of_type_JavaUtilHashMap;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramInt);
    paramDownloadParams.put("AttemptCount", ((StringBuilder)localObject1).toString());
    this.jdField_a_of_type_JavaUtilHashMap.put("picFormat", this.e);
    this.jdField_a_of_type_JavaUtilHashMap.put("netType", this.h);
    this.jdField_a_of_type_JavaUtilHashMap.put("plateform", this.g);
    this.jdField_a_of_type_JavaUtilHashMap.put("pixDensity", this.i);
    paramDownloadParams = InnerDns.getInstance().reqDnsForIpList(this.jdField_c_of_type_JavaLangString, 1009);
    if (paramDownloadParams != null) {
      paramDownloadParams = TextUtils.join(",", paramDownloadParams);
    } else {
      paramDownloadParams = "";
    }
    this.jdField_a_of_type_JavaUtilHashMap.put("IPs", paramDownloadParams);
    this.jdField_a_of_type_JavaUtilHashMap.put("ServerIP", "");
    this.jdField_a_of_type_JavaUtilHashMap.put("OriginURL", this.jdField_b_of_type_JavaLangString);
    localObject1 = this.jdField_a_of_type_JavaUtilHashMap;
    if (this.jdField_a_of_type_Boolean) {
      paramDownloadParams = String.valueOf(1);
    } else {
      paramDownloadParams = String.valueOf(0);
    }
    ((HashMap)localObject1).put("Success", paramDownloadParams);
    this.jdField_a_of_type_JavaUtilHashMap.put("TotalTime", Long.toString(this.jdField_b_of_type_Long));
    this.jdField_a_of_type_JavaUtilHashMap.put("picType", this.f);
    this.jdField_a_of_type_JavaUtilHashMap.put("ReceivedBytes", String.valueOf(this.jdField_c_of_type_Long));
    this.jdField_a_of_type_JavaUtilHashMap.put("ErrorReason", this.jdField_d_of_type_JavaLangString);
    paramDownloadParams = this.jdField_a_of_type_JavaUtilHashMap;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_d_of_type_Int);
    ((StringBuilder)localObject1).append("");
    paramDownloadParams.put("param_FailCode", ((StringBuilder)localObject1).toString());
    this.jdField_a_of_type_JavaUtilHashMap.put("Speed", Float.toString((float)this.jdField_c_of_type_Long / ((float)this.jdField_b_of_type_Long / 1000.0F)));
    paramInt = this.jdField_c_of_type_Int;
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            if (paramInt != 4) {
              paramDownloadParams = "actSubscriptionUnkonw";
            }
          }
        }
      }
    }
    for (;;)
    {
      break;
      paramDownloadParams = "actNativeWebImage";
      continue;
      paramDownloadParams = "actKandianImage";
      continue;
      paramDownloadParams = "actSubscriptionDetail";
      continue;
      paramDownloadParams = "actSubscriptionFolder";
      continue;
      paramDownloadParams = "actSubscriptionAIO";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("reportTag:");
    ((StringBuilder)localObject1).append(paramDownloadParams);
    ((StringBuilder)localObject1).append(", success:");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
    ((StringBuilder)localObject1).append(", time:");
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_Long);
    ((StringBuilder)localObject1).append(", size:");
    ((StringBuilder)localObject1).append(this.jdField_c_of_type_Long);
    ((StringBuilder)localObject1).append(", url:");
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(", exInfo:");
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilHashMap.toString());
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, ((StringBuilder)localObject1).toString());
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, paramDownloadParams, this.jdField_a_of_type_Boolean, this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_a_of_type_JavaUtilHashMap, "", true);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_d_of_type_Int == 0) {
      this.jdField_d_of_type_Int = paramInt;
    }
    this.jdField_d_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void a(DownloadParams paramDownloadParams, Map<String, String> paramMap)
  {
    long l = NetworkCenter.getInstance().getNetType();
    this.h = "None";
    if ((l > 0L) && (l < AppConstants.NET_TYPE_NAME.length)) {
      this.h = AppConstants.NET_TYPE_NAME[((int)l)];
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ANDROID.MOBILE-");
    ((StringBuilder)localObject).append(Build.MODEL);
    ((StringBuilder)localObject).append(".SDK-");
    ((StringBuilder)localObject).append(Build.VERSION.SDK);
    this.g = ((StringBuilder)localObject).toString();
    localObject = BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDisplayMetrics();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((DisplayMetrics)localObject).widthPixels);
    localStringBuilder.append("*");
    localStringBuilder.append(((DisplayMetrics)localObject).heightPixels);
    this.i = localStringBuilder.toString();
    this.jdField_b_of_type_JavaLangString = paramDownloadParams.urlStr;
    this.jdField_c_of_type_JavaLangString = paramDownloadParams.url.getHost();
    this.e = "none";
    int j = this.jdField_b_of_type_JavaLangString.lastIndexOf("/");
    if (j != -1)
    {
      j += 1;
      if ((j <= this.jdField_b_of_type_JavaLangString.length()) && (j < this.jdField_b_of_type_JavaLangString.length()))
      {
        this.e = this.jdField_b_of_type_JavaLangString.substring(j);
        j = this.e.indexOf("?");
        if (j != -1) {
          this.e = this.e.substring(0, j);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public void a(NetResp paramNetResp, String paramString)
  {
    a(paramNetResp);
    if (paramNetResp != null)
    {
      this.f = "none";
      paramString = (String)paramNetResp.mRespProperties.get("Content-Type");
      if ((paramString != null) && (paramString.startsWith("image/"))) {
        this.f = paramString.replace("image/", "");
      }
      this.jdField_c_of_type_Long = paramNetResp.mTotalFileLen;
      return;
    }
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_b_of_type_Long = (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountHttpDownloaderImpl.PubAccoutImageReporter
 * JD-Core Version:    0.7.0.1
 */