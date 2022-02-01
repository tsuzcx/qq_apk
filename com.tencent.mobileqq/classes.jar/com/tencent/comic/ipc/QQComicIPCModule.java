package com.tencent.comic.ipc;

import android.os.Bundle;
import com.tencent.comic.VipComicJumpActivity;
import com.tencent.comic.VipComicSoHelper;
import com.tencent.comic.hippy.BoodoHippyBirdge;
import com.tencent.comic.utils.AppHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.redtouch.RedTouchUtils;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QQComicIPCModule
  extends QIPCModule
{
  private static QQComicIPCModule b;
  QQComicIPCModule.ComicConfigCallback a;
  
  public QQComicIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static QQComicIPCModule a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new QQComicIPCModule("QQComicIPCModule");
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(int paramInt)
  {
    ThreadManagerV2.excute(new QQComicIPCModule.2(this, paramInt), 64, null, false);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("action = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("QQComicIPCModule", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBundle == null)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("QQComicIPCModule Err params = null, action = ");
      paramBundle.append(paramString);
      QLog.d("QQComicIPCModule", 2, paramBundle.toString());
      return null;
    }
    Object localObject = AppHelper.b();
    if (!(localObject instanceof BaseQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicIPCModule", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    localObject = (AppInterface)localObject;
    if ("getIpExpressionConfig".equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicIPCModule", 2, " ACTION_GET_IP_EXPRESSION_CONFIGgetIpExpressionConfig");
      }
      a(paramInt);
      return null;
    }
    if ("isLebaItemOpen".equals(paramString))
    {
      paramInt = paramBundle.getInt("appId", -1);
      paramString = ((IRedTouchManager)((AppInterface)localObject).getRuntimeService(IRedTouchManager.class, "")).requestSettingInfoList().iterator();
      while (paramString.hasNext())
      {
        paramBundle = (BusinessInfoCheckUpdate.AppSetting)paramString.next();
        if (paramBundle.appid.get() == paramInt)
        {
          bool = paramBundle.setting.get();
          break label229;
        }
      }
      boolean bool = false;
      label229:
      paramString = new Bundle();
      paramString.putBoolean("isLebaItemOpen", bool);
      return EIPCResult.createResult(0, paramString);
    }
    if ("getRedTouchInfo".equals(paramString))
    {
      paramString = (IRedTouchManager)((AppInterface)localObject).getRuntimeService(IRedTouchManager.class, "");
      localObject = paramBundle.getStringArrayList("pathList");
      if ((paramString != null) && (localObject != null))
      {
        paramBundle = new ArrayList();
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          BusinessInfoCheckUpdate.AppInfo localAppInfo = paramString.getAppInfoByPath((String)((Iterator)localObject).next());
          if (localAppInfo != null) {
            paramBundle.add(RedTouchUtils.a(localAppInfo));
          }
        }
        paramString = new Bundle();
        paramString.putParcelableArrayList("redTouchInfoList", paramBundle);
        return EIPCResult.createResult(0, paramString);
      }
    }
    else
    {
      if ("reportRedTouchClick".equals(paramString))
      {
        paramString = (IRedTouchManager)((AppInterface)localObject).getRuntimeService(IRedTouchManager.class, "");
        paramBundle = paramBundle.getString("path");
        if ((paramString == null) || (paramBundle == null)) {
          break label676;
        }
        paramString.onRedTouchItemClick(paramBundle);
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("service_type", 2);
          ((JSONObject)localObject).put("act_id", 1002);
          paramString.onReportBusinessRedTouch(paramString.getAppInfoByPath(paramBundle), ((JSONObject)localObject).toString());
          return null;
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          return null;
        }
      }
      if ("initPluginBeforeEnter".equals(paramString))
      {
        VipComicJumpActivity.initPluginBeforeEnter((AppInterface)localObject, paramBundle.getBoolean("doLoadModule"));
        return null;
      }
      if ("check_qqcomic_plugin".equals(paramString))
      {
        BoodoHippyBirdge.checkPluginInstall(AppHelper.a(), (AppRuntime)localObject, new QQComicIPCModule.1(this, paramInt));
        return null;
      }
      if ("launch_qqcomic_hippy".equals(paramString))
      {
        if (QLog.isColorLevel())
        {
          QLog.d("QQComicIPCModule", 2, "ACTION_LAUNCH_QQCOMIC_HIPPY launchHippyPage");
          return null;
        }
      }
      else if ("getComicConfig".equals(paramString))
      {
        paramString = (IVasQuickUpdateService)((AppInterface)localObject).getRuntimeService(IVasQuickUpdateService.class, "");
        if ((paramInt > 0) && (paramString != null))
        {
          if (this.a == null) {
            this.a = new QQComicIPCModule.ComicConfigCallback(this, paramInt);
          }
          paramString.addCallBacker(this.a);
        }
        paramString = VasUpdateUtil.a((AppRuntime)localObject, "vipComic_config_v2.json", true, null);
        if (paramString != null)
        {
          paramBundle = new Bundle();
          paramBundle.putString("config_json", paramString.toString());
          paramString = EIPCResult.createResult(0, paramBundle);
          if (paramInt > 0)
          {
            callbackResult(paramInt, paramString);
            return null;
          }
          return paramString;
        }
      }
      else if ("getPlayerSo".equals(paramString))
      {
        VipComicSoHelper.a((AppRuntime)localObject);
      }
    }
    label676:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ipc.QQComicIPCModule
 * JD-Core Version:    0.7.0.1
 */