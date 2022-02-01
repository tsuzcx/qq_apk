package com.tencent.biz.pubaccount.api.impl;

import android.text.TextUtils;
import com.tencent.biz.common.report.BnrReport;
import com.tencent.biz.pubaccount.util.Encrypt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.ThreeDes;

public class PublicAccountJavascriptInterfaceImpl$TimedOnLocationListener
  extends SosoInterfaceOnLocationListener
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  long jdField_c_of_type_Long;
  boolean jdField_c_of_type_Boolean;
  boolean d;
  
  private PublicAccountJavascriptInterfaceImpl$TimedOnLocationListener(PublicAccountJavascriptInterfaceImpl paramPublicAccountJavascriptInterfaceImpl, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, String paramString)
  {
    super(paramInt1, paramBoolean1 ^ true, true, paramLong2, true, false, "webview");
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Boolean = paramBoolean3;
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.d = paramBoolean2;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_b_of_type_Long = paramLong1;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Long = paramLong2;
  }
  
  public PublicAccountJavascriptInterfaceImpl$TimedOnLocationListener(PublicAccountJavascriptInterfaceImpl paramPublicAccountJavascriptInterfaceImpl, int paramInt, String paramString, long paramLong)
  {
    this(paramPublicAccountJavascriptInterfaceImpl, paramInt, -1L, paramLong, false, false, 0, false, paramString);
  }
  
  public PublicAccountJavascriptInterfaceImpl$TimedOnLocationListener(PublicAccountJavascriptInterfaceImpl paramPublicAccountJavascriptInterfaceImpl, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, long paramLong)
  {
    this(paramPublicAccountJavascriptInterfaceImpl, paramInt1, 10000L, paramLong, true, paramBoolean1, paramInt2, paramBoolean2, paramString);
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onConsecutiveFailure: errCode=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", failCount=");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("PAjs.location", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 * 2000 >= this.jdField_b_of_type_Long)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-2", "{type:1, data:null}" });
      localObject = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 3, this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.getNetworkType(), (String)localObject, "", "");
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this);
    }
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onLocationFinish: errCode=");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", info=");
      ((StringBuilder)localObject1).append(paramSosoLbsInfo);
      ((StringBuilder)localObject1).append(", isActive=");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject1).append(", reqRawData=");
      ((StringBuilder)localObject1).append(this.jdField_c_of_type_Boolean);
      QLog.d("PAjs.location", 2, ((StringBuilder)localObject1).toString());
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      if (paramInt == 0)
      {
        double d1 = paramSosoLbsInfo.mLocation.mLat02;
        double d2 = paramSosoLbsInfo.mLocation.mLon02;
        if (this.jdField_b_of_type_Boolean)
        {
          paramSosoLbsInfo = this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl;
          localObject1 = this.jdField_a_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("{type:2, lat:");
          ((StringBuilder)localObject2).append(d1);
          ((StringBuilder)localObject2).append(", lon:");
          ((StringBuilder)localObject2).append(d2);
          ((StringBuilder)localObject2).append("}");
          paramSosoLbsInfo.callJs((String)localObject1, new String[] { "0", ((StringBuilder)localObject2).toString() });
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.format("'%1$f,%2$f'", new Object[] { Double.valueOf(d2), Double.valueOf(d1) }) });
        }
        paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.getNetworkType(), paramSosoLbsInfo, "", "");
        return;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-1", "{}" });
      paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getloc", 0, 1, this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.getNetworkType(), paramSosoLbsInfo, "", "");
      return;
    }
    Object localObject2 = null;
    if (paramSosoLbsInfo != null) {
      localObject1 = paramSosoLbsInfo.rawData;
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      if (this.d) {
        try
        {
          paramSosoLbsInfo = ThreeDes.a(PublicAccountJavascriptInterfaceImpl.access$400(this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl, (byte[])localObject1), "nbyvie");
        }
        catch (Exception paramSosoLbsInfo)
        {
          paramSosoLbsInfo.printStackTrace();
        }
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_Int != 1) {
          break label1045;
        }
        bool = true;
        paramSosoLbsInfo = Base64Util.encodeToString(Encrypt.a(bool, Encrypt.a((byte[])localObject1), "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCrkUA+dDEQT52svdheRw04+xrExuTvNj3g7pjcyUkH3+86FiYNhHtyWJc11BywUZ2Ey3RomCyTb/szl5qQEJqR7UC5z4mhLrhgXlbRI0BgmI/LhaMRsfskGM7ziyQ2ZpS0qbHX2xoum6ou/541/VePIwmcnIk6eWUx6GYnA4euZQIDAQAB"), 2);
      }
      catch (Exception localException)
      {
        paramSosoLbsInfo = (SosoLbsInfo)localObject2;
        if (this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.mRuntime != null) {
          paramSosoLbsInfo = this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.mRuntime.a();
        }
        if (paramSosoLbsInfo != null) {
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, paramSosoLbsInfo.getAccount(), localException.getMessage(), "", "");
        }
      }
      paramSosoLbsInfo = "";
      boolean bool = TextUtils.isEmpty(paramSosoLbsInfo) ^ true;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onLocationFinish: success=");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(", mUseFallback=");
        ((StringBuilder)localObject2).append(this.jdField_b_of_type_Boolean);
        QLog.d("PAjs.location", 2, ((StringBuilder)localObject2).toString());
      }
      if (bool)
      {
        this.jdField_a_of_type_Boolean = false;
        localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl;
        String str = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{type:1, decrypt_padding:");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append(",data:\"");
        localStringBuilder.append(paramSosoLbsInfo);
        localStringBuilder.append("\"}");
        ((PublicAccountJavascriptInterfaceImpl)localObject2).callJs(str, new String[] { "0", localStringBuilder.toString() });
        paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.getNetworkType(), paramSosoLbsInfo, "", "");
        if (localObject1 != null)
        {
          paramSosoLbsInfo = this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.mRuntime.a();
          if (paramSosoLbsInfo != null)
          {
            paramSosoLbsInfo = paramSosoLbsInfo.getUrl();
            if ((!TextUtils.isEmpty(paramSosoLbsInfo)) && (paramSosoLbsInfo.contains("_bid=108"))) {
              BnrReport.a(null, 81, "", 0, 0, Base64Util.encodeToString((byte[])localObject1, 2), "", "", "");
            }
          }
        }
      }
      else
      {
        if ((this.jdField_b_of_type_Boolean) && (paramInt != -10000) && (paramInt != 2))
        {
          this.jdField_a_of_type_Boolean = false;
          long l1 = System.currentTimeMillis() - this.jdField_a_of_type_Long;
          long l2 = this.jdField_b_of_type_Long - l1;
          if (l2 > 0L)
          {
            l1 = this.jdField_c_of_type_Long - l1;
            if (l1 < 0L) {
              l1 = 0L;
            }
            ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new TimedOnLocationListener(this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl, 0, l2, l1, false, false, 0, true, this.jdField_a_of_type_JavaLangString));
          }
          else
          {
            this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-1", "{}" });
          }
          paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 2, this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.getNetworkType(), paramSosoLbsInfo, "", "");
          return;
        }
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "-1", "{}" });
        paramSosoLbsInfo = Long.toString(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "getlocation", "getdata", 0, 1, this.jdField_a_of_type_ComTencentBizPubaccountApiImplPublicAccountJavascriptInterfaceImpl.getNetworkType(), paramSosoLbsInfo, "", "");
      }
      return;
      label1045:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.TimedOnLocationListener
 * JD-Core Version:    0.7.0.1
 */