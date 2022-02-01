package com.tencent.comic.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.comic.VipComicHelper;
import com.tencent.comic.VipComicJumpActivity;
import com.tencent.comic.VipComicJumpActivity.ComicParam;
import com.tencent.comic.VipComicProxyActivity;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.comic.data.VipComicDataHelper;
import com.tencent.comic.ipc.QQComicIPCModule;
import com.tencent.comic.utils.FirstInObservable;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.comic.utils.VipComicSecurityFileHelper;
import com.tencent.comic.utils.VipComicUrlHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import mqq.app.AppRuntime;
import mqq.app.ISecurityFileHelper;

public class QQComicUtilImpl
  implements IQQComicUtil
{
  public static final String TAG = "QQComicUtilImpl";
  
  public String addParamToUrl(String paramString1, String paramString2)
  {
    return VipComicUrlHelper.a(paramString1, paramString2);
  }
  
  public void fetchReportInfo(Intent paramIntent, boolean paramBoolean)
  {
    int i = paramIntent.getIntExtra("reportSourceFrom", 0);
    Object localObject;
    if (i != 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("");
      VipComicDataHelper.a = ((StringBuilder)localObject).toString();
      if ((!TextUtils.isEmpty(VipComicDataHelper.a)) && (!"NULL".equalsIgnoreCase(VipComicDataHelper.a)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[webFragment] from is ");
          ((StringBuilder)localObject).append(VipComicDataHelper.a);
          QLog.d("QQComicUtilImpl", 2, ((StringBuilder)localObject).toString());
        }
      }
      else {
        QLog.e("QQComicUtilImpl", 1, "[webFragment] from is null");
      }
      if (paramBoolean) {
        localObject = paramIntent.getStringExtra("url");
      }
    }
    try
    {
      localObject = new URL((String)localObject);
      VipComicDataHelper.c = ((URL)localObject).getPath().substring(((URL)localObject).getPath().lastIndexOf("/") + 1);
      label167:
      VipComicDataHelper.b = paramIntent.getStringExtra("reportActionFrom");
      VipComicDataHelper.a();
      return;
    }
    catch (Exception localException)
    {
      break label167;
    }
  }
  
  public String getActionId()
  {
    return VipComicDataHelper.b;
  }
  
  public Intent getBackgroundQQComicIntent(AppRuntime paramAppRuntime)
  {
    VipComicJumpActivity.ComicParam localComicParam = new VipComicJumpActivity.ComicParam();
    localComicParam.jdField_a_of_type_Int = -1001;
    localComicParam.jdField_a_of_type_Long = System.currentTimeMillis();
    return VipComicJumpActivity.getBackgroundQQComicIntent(paramAppRuntime, localComicParam);
  }
  
  public Class getComicJumpActivityClass()
  {
    return VipComicJumpActivity.class;
  }
  
  public ISecurityFileHelper getComicSecurityFileHelper()
  {
    return new VipComicSecurityFileHelper();
  }
  
  public QIPCModule getIpcModule()
  {
    return QQComicIPCModule.a();
  }
  
  public Class<? extends Activity> getProxyActivityClass(String paramString)
  {
    return VipComicProxyActivity.a(paramString);
  }
  
  public String getUrl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return VipComicJumpActivity.getUrl(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  public boolean handleParam(AppRuntime paramAppRuntime, Activity paramActivity, Intent paramIntent)
  {
    VipComicJumpActivity.ComicParam localComicParam = new VipComicJumpActivity.ComicParam();
    if (paramIntent != null) {
      localComicParam = VipComicJumpActivity.parseParam(paramIntent);
    }
    return VipComicJumpActivity.handleParam(paramAppRuntime, paramActivity, localComicParam);
  }
  
  public void initMagnifierSDK(AppRuntime paramAppRuntime)
  {
    VipComicHelper.a(paramAppRuntime);
  }
  
  public boolean initPluginBeforeEnter(AppInterface paramAppInterface, Activity paramActivity, Intent paramIntent)
  {
    if (VipComicJumpActivity.handleParam(paramAppInterface, paramActivity, VipComicJumpActivity.parseParam(paramIntent)))
    {
      VipComicJumpActivity.initPluginBeforeEnter(paramAppInterface, true);
      return true;
    }
    return false;
  }
  
  public void initUrlMap(Intent paramIntent)
  {
    VipComicUrlHelper.a(paramIntent);
  }
  
  public boolean isVideoUrl(String paramString, Intent paramIntent)
  {
    return VipComicHelper.a(paramString, paramIntent);
  }
  
  public void notifyFirstInObservableChanged(Context paramContext)
  {
    if (QQComicPluginBridge.a != null) {
      QQComicPluginBridge.a.a(paramContext);
    }
  }
  
  public void openQQBrowserActivityForComic(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    VipComicHelper.a(paramActivity, paramIntent, paramInt);
  }
  
  public void preloadQQBoodoComic(AppRuntime paramAppRuntime)
  {
    VipComicJumpActivity.preloadQQBoodoComic(paramAppRuntime);
  }
  
  public void reportClickEventTo644(AppInterface paramAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    arrayOfString[2] = "";
    arrayOfString[3] = "";
    if (paramVarArgs != null)
    {
      int j = paramVarArgs.length;
      int k = arrayOfString.length;
      int i = 0;
      while ((i < j) && (i < k))
      {
        if (!TextUtils.isEmpty(paramVarArgs[i])) {
          arrayOfString[i] = paramVarArgs[i];
        }
        i += 1;
      }
    }
    boolean bool = paramAppInterface instanceof BaseQQAppInterface;
    paramVarArgs = "UNKNOWN";
    if (bool)
    {
      if (TextUtils.isEmpty(paramString1)) {
        paramString1 = paramVarArgs;
      }
      ReportController.b(paramAppInterface, "P_CliOper", paramString1, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
      return;
    }
    if (paramAppInterface != null)
    {
      if (TextUtils.isEmpty(paramString1)) {
        paramString1 = paramVarArgs;
      }
      ReportController.b(paramAppInterface, "P_CliOper", paramString1, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
      return;
    }
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "UNKNOWN";
    }
    ReportController.b(null, "P_CliOper", paramString1, "", paramString2, paramString3, paramInt1, paramInt2, arrayOfString[0], arrayOfString[1], arrayOfString[2], arrayOfString[3]);
  }
  
  public void setDefaultComicTab(String paramString)
  {
    VipComicHelper.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicUtilImpl
 * JD-Core Version:    0.7.0.1
 */