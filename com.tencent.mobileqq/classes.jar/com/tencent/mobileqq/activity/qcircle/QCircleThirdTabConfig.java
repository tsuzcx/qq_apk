package com.tencent.mobileqq.activity.qcircle;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl;
import com.tencent.mobileqq.automator.api.IAutomatorApi;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import mqq.app.AppRuntime;
import qqcircle.QQCircleSwitch.StSwitch;

public class QCircleThirdTabConfig
{
  private static volatile QCircleThirdTabConfig jdField_a_of_type_ComTencentMobileqqActivityQcircleQCircleThirdTabConfig;
  private volatile boolean jdField_a_of_type_Boolean;
  
  public static QCircleThirdTabConfig a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQcircleQCircleThirdTabConfig == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityQcircleQCircleThirdTabConfig == null) {
          jdField_a_of_type_ComTencentMobileqqActivityQcircleQCircleThirdTabConfig = new QCircleThirdTabConfig();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqActivityQcircleQCircleThirdTabConfig;
  }
  
  private FeedCloudCommon.Entry a(String paramString1, String paramString2)
  {
    FeedCloudCommon.Entry localEntry = new FeedCloudCommon.Entry();
    if (paramString1 != null) {
      localEntry.key.set(paramString1);
    }
    if (paramString2 != null) {
      localEntry.value.set(paramString2);
    }
    return localEntry;
  }
  
  private String a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (bool) {
      return "";
    }
    String[] arrayOfString = paramString.split("\\.");
    paramString = str;
    if (arrayOfString.length == 2) {
      paramString = arrayOfString[1];
    }
    return paramString;
  }
  
  private void a(String paramString, List paramList)
  {
    ((IQCircleReportApi)QRoute.api(IQCircleReportApi.class)).reportQualityEvent(paramString, paramList, false);
  }
  
  private void a(List<QQCircleSwitch.StSwitch> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCircleSwitch.StSwitch localStSwitch = (QQCircleSwitch.StSwitch)paramList.next();
      String str = a(localStSwitch.key.get());
      QzoneConfig.getInstance().updateOneConfig("qqcircle", str, localStSwitch.value.get());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key:");
      localStringBuilder.append(str);
      localStringBuilder.append(" value: ");
      localStringBuilder.append(localStSwitch.value.get());
      QLog.d("QCircleThirdTabConfig", 1, localStringBuilder.toString());
    }
  }
  
  private void a(CountDownLatch paramCountDownLatch)
  {
    a("EVENT_FETCH_QCIRCLE_THIRD_TAB_CONFIG", Arrays.asList(new FeedCloudCommon.Entry[] { a("ret_code", "1") }));
    long l = System.currentTimeMillis();
    VSNetworkHelper.getInstance().sendRequest(new QCircleThirdTabConfig.QCircleTabBucketRequest(), new QCircleThirdTabConfig.2(this, l, paramCountDownLatch));
  }
  
  private void a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void b()
  {
    a(true);
    this.jdField_a_of_type_Boolean = true;
    QCircleInjectImpl.c();
  }
  
  private boolean b()
  {
    long l = System.currentTimeMillis();
    if (!c()) {
      return true;
    }
    Object localObject = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_bottom_tab_switch");
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("has local Record mainTabSwitch:");
      localStringBuilder.append((String)localObject);
      QLog.d("QCircleThirdTabConfig", 1, localStringBuilder.toString());
      return true;
    }
    localObject = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_main_tab");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("has local Record mainTabSwitch:");
      localStringBuilder.append((String)localObject);
      QLog.d("QCircleThirdTabConfig", 1, localStringBuilder.toString());
      return true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("there is no record queryTime:");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
    QLog.d("QCircleThirdTabConfig", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  private boolean c()
  {
    boolean bool = ((IAutomatorApi)QRoute.api(IAutomatorApi.class)).isFirstLaunchNew();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isFirstLaunchNew:");
    localStringBuilder.append(bool);
    QLog.d("QCircleThirdTabConfig", 1, localStringBuilder.toString());
    return bool;
  }
  
  public void a()
  {
    QLog.d("QCircleThirdTabConfig", 1, "onMainDestroy");
  }
  
  public void a(AppRuntime paramAppRuntime, Class<?> paramClass)
  {
    if (!c()) {
      return;
    }
    RFThreadManager.getSerialThreadHandler().post(new QCircleThirdTabConfig.1(this, paramAppRuntime));
  }
  
  public boolean a()
  {
    if ((c()) && (!this.jdField_a_of_type_Boolean))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("canShowShowKanDianTab（):isFirstLaunchNew and hasNotify:");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("QCircleThirdTabConfig", 1, localStringBuilder.toString());
      return false;
    }
    boolean bool1 = StudyModeManager.a();
    boolean bool2 = QzoneConfig.isShowQQCircleMainTabEntrance(StudyModeManager.a());
    int i = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_entrance_on_main_tab", 0);
    int j = QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_show_bottom_tab_switch", 0);
    boolean bool3 = ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowKandianTab();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showKanDian？");
    localStringBuilder.append(bool3);
    localStringBuilder.append(" valueShowEntranceOnMainTab:");
    localStringBuilder.append(i);
    localStringBuilder.append(" valueShowEntranceOnBottomTab:");
    localStringBuilder.append(j);
    localStringBuilder.append(" isStudyModeSwitch:");
    localStringBuilder.append(bool1);
    localStringBuilder.append(" showQCircle?");
    localStringBuilder.append(bool2);
    QLog.d("QCircleThirdTabConfig", 1, localStringBuilder.toString());
    return bool3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig
 * JD-Core Version:    0.7.0.1
 */