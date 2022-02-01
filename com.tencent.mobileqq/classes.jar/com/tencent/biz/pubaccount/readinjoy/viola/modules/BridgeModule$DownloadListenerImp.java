package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class BridgeModule$DownloadListenerImp
  implements DownloadListener
{
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public BridgeModule$DownloadListenerImp(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  private String a(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      return paramDownloadInfo.d;
    }
    return "";
  }
  
  private String b(DownloadInfo paramDownloadInfo)
  {
    if (paramDownloadInfo != null) {
      return paramDownloadInfo.e;
    }
    return "";
  }
  
  public void installSucceed(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("type", 6);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.b, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("BridgeModule", 2, "downloadApk installSucceed, packageName = " + paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ViolaLogUtils.e("downloadApk", "installSucceed error:" + paramString1.getMessage());
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", 3);
      if ((paramDownloadInfo != null) && (this.jdField_a_of_type_JavaLangString.equals(paramDownloadInfo.d))) {
        localJSONObject.put("data", paramDownloadInfo.f);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.b, localJSONObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("onDownloadCancel", "onDownloadError error:" + localException.getMessage());
        localException.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModule", 2, "downloadApk onDownloadCancel, url = " + a(paramDownloadInfo) + " , packageName = " + b(paramDownloadInfo));
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      paramString = new JSONObject();
      paramString.put("type", 4);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.b, paramString);
      if (QLog.isColorLevel()) {
        QLog.d("BridgeModule", 2, "downloadApk onDownloadError, url = " + a(paramDownloadInfo) + " , packageName = " + b(paramDownloadInfo));
      }
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ViolaLogUtils.e("downloadApk", "onDownloadError error:" + paramString.getMessage());
        paramString.printStackTrace();
      }
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", 2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.b, localJSONObject);
      if (QLog.isColorLevel()) {
        QLog.d("BridgeModule", 2, "downloadApk onDownloadFinish, url = " + a(paramDownloadInfo) + " , packageName = " + b(paramDownloadInfo));
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("downloadApk", "onDownloadFinish error:" + localException.getMessage());
        localException.printStackTrace();
      }
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("type", 5);
      if ((paramDownloadInfo != null) && (this.jdField_a_of_type_JavaLangString.equals(paramDownloadInfo.d))) {
        localJSONObject.put("data", paramDownloadInfo.f);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.b, localJSONObject);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ViolaLogUtils.e("onDownloadPause", "onDownloadPause error:" + localException.getMessage());
        localException.printStackTrace();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModule", 2, "downloadApk onDownloadPause, url = " + a(paramDownloadInfo) + " , packageName = " + b(paramDownloadInfo));
    }
  }
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    paramList = paramList.iterator();
    for (;;)
    {
      if (paramList.hasNext())
      {
        DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
        if (this.jdField_a_of_type_JavaLangString.equals(localDownloadInfo.d)) {}
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("type", 1);
          localJSONObject.put("data", localDownloadInfo.f);
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.b, localJSONObject);
          if (QLog.isColorLevel()) {
            QLog.d("BridgeModule", 2, "downloadApk onDownloadUpdate, url = " + localDownloadInfo.d + " , packageName = " + localDownloadInfo.e + " process = " + localDownloadInfo.f);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            ViolaLogUtils.e("downloadApk", "onDownloadFinish error:" + localException.getMessage());
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModule", 2, "downloadApk onDownloadWait, url = " + a(paramDownloadInfo) + " , packageName = " + b(paramDownloadInfo));
    }
  }
  
  public void packageReplaced(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("type", 6);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule.invokeCallJS(this.b, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("BridgeModule", 2, "downloadApk packageReplaced, packageName = " + paramString2);
      }
      return;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        ViolaLogUtils.e("downloadApk", "packageReplaced error:" + paramString1.getMessage());
      }
    }
  }
  
  public void uninstallSucceed(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BridgeModule", 2, "downloadApk uninstallSucceed, packageName = " + paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.DownloadListenerImp
 * JD-Core Version:    0.7.0.1
 */