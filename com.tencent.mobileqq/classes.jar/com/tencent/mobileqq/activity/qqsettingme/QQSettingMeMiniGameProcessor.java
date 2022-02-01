package com.tencent.mobileqq.activity.qqsettingme;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeMiniGameBean;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class QQSettingMeMiniGameProcessor
  extends QQSettingMeBaseMenuProcessor
{
  public final MutableLiveData<QQSettingMeMiniGameBean> b = new MutableLiveData();
  
  private String a(String paramString, BusinessInfoCheckUpdate.AppInfo paramAppInfo)
  {
    paramString = new StringBuilder(paramString);
    if ((paramAppInfo != null) && (paramAppInfo.buffer != null))
    {
      paramAppInfo = paramAppInfo.buffer.get();
      if (!TextUtils.isEmpty(paramAppInfo)) {
        try
        {
          paramAppInfo = new JSONObject(paramAppInfo);
          String str = paramAppInfo.getString("trace_id");
          int i = paramAppInfo.getInt("trace_num");
          int j = paramAppInfo.getInt("ad_id");
          paramString.append("&");
          paramString.append("trace_id=");
          paramString.append(str);
          paramString.append("&");
          paramString.append("trace_num=");
          paramString.append(i);
          paramString.append("&");
          paramString.append("trace_detail=");
          paramAppInfo = new StringBuilder();
          paramAppInfo.append("trace_detail_ad_id=");
          paramAppInfo.append(j);
          paramString.append(URLEncoder.encode(paramAppInfo.toString(), "UTF-8"));
        }
        catch (Exception paramAppInfo)
        {
          QLog.d("QQSettingRedesign", 1, "getMyMiniGameJumpUrl failed", paramAppInfo);
        }
      }
    }
    return paramString.toString();
  }
  
  public void a(View paramView)
  {
    paramView = QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameJumpUrl", "mqqapi://miniapp/open?_atype=0&_mappid=1108291530&_mvid=&_path=pages%2Fgame-list%2Fgame-list.html%3Fmode%3Dchouti&_vt=3&via=2066&_sig=676003338");
    if (!TextUtils.isEmpty(paramView)) {
      if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramView))
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(this.d, a(paramView, (BusinessInfoCheckUpdate.AppInfo)this.a.getValue()), 2066, null);
      }
      else
      {
        localObject = new Intent(this.d, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        this.d.startActivity((Intent)localObject);
      }
    }
    paramView = (IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "");
    int i = 1;
    Object localObject = paramView.getAppInfo(1, String.valueOf(100077));
    if ((localObject == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get() == 0)) {
      i = 0;
    }
    ReportController.b(this.c, "dc00898", "", "", "0X800ACDD", "0X800ACDD", 0, i, "", "", "", "");
    if (i != 0) {
      paramView.reportLevelOneRedInfo(100077, 31);
    }
  }
  
  public void a(QQSettingMe paramQQSettingMe)
  {
    super.a(paramQQSettingMe);
    this.b.observe(this.e, new QQSettingMeMiniGameProcessor.1(this, paramQQSettingMe));
  }
  
  public void a(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    super.a(((IRedTouchManager)this.c.getRuntimeService(IRedTouchManager.class, "")).getAppInfo(1, String.valueOf(100077)), paramBoolean);
  }
  
  public String b()
  {
    return "d_minigame";
  }
  
  protected void b(BusinessInfoCheckUpdate.AppInfo paramAppInfo, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void d()
  {
    super.d();
    i();
  }
  
  public void h()
  {
    i();
  }
  
  public void i()
  {
    QQSettingMeMiniGameBean localQQSettingMeMiniGameBean = new QQSettingMeMiniGameBean();
    localQQSettingMeMiniGameBean.a = QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameEnable", 1);
    localQQSettingMeMiniGameBean.b = QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameIconUrl", "");
    localQQSettingMeMiniGameBean.c = QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameNameText", "");
    this.b.setValue(localQQSettingMeMiniGameBean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeMiniGameProcessor
 * JD-Core Version:    0.7.0.1
 */