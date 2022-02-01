package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.msgbox.RIJMsgBoxUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.BasePopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.RIJPopupAutomator;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianMsgBoxRedPntInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;

public class RIJMsgBoxPopupStep
  extends BasePopupStep
{
  private Activity a;
  
  public RIJMsgBoxPopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJMsgBoxPopupStep");
    this.a = paramActivity;
  }
  
  private void a(Activity paramActivity, int paramInt, String paramString, long paramLong)
  {
    if (paramActivity == null)
    {
      QLog.e("RIJMsgBoxPopupStep", 1, "openMsgBoxPage failed, activity = null");
      return;
    }
    paramActivity.getWindow().getDecorView().postDelayed(new RIJMsgBoxPopupStep.1(this, paramActivity, paramInt, paramString), paramLong);
    i();
  }
  
  private boolean a(int paramInt)
  {
    QLog.d("RIJMsgBoxPopupStep", 2, "checkIfShowMsgBoxWithFloatingWindow | launchFrom : " + paramInt);
    if (paramInt != 5) {
      return false;
    }
    Object localObject = ((KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    if ((localObject == null) || (((KandianMsgBoxRedPntInfo)localObject).mMsgCnt <= 0))
    {
      QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | no msg");
      return false;
    }
    boolean bool = ((Boolean)ReadInJoyHelper.a("sp_key_kandian_msg_box_show_float_window", Boolean.valueOf(false))).booleanValue();
    QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | sp showFloatingWin " + bool);
    localObject = Aladdin.getConfig(262);
    if (localObject != null) {
      if (((AladdinConfig)localObject).getIntegerFromString("kandian_msg_box_popup_window_cfg", 0) == 1)
      {
        bool = true;
        ReadInJoyHelper.a("sp_key_kandian_msg_box_show_float_window", Boolean.valueOf(bool));
        QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | aladdin cfg showFloatingWin " + bool);
      }
    }
    for (;;)
    {
      QLog.d("RIJMsgBoxPopupStep", 1, "checkIfShowMsgBoxWithFloatingWindow | showFloatingWindow " + bool);
      if (bool)
      {
        a(this.a, 6, "", 0L);
        if (this.a != null)
        {
          localObject = RIJJumpUtils.a(this.a);
          if (localObject != null) {
            ((RIJTabFrameBase)localObject).b(32);
          }
        }
      }
      return bool;
      bool = false;
      break;
    }
  }
  
  private void i()
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    KandianMsgBoxRedPntInfo localKandianMsgBoxRedPntInfo = localKandianMergeManager.a();
    if (localKandianMsgBoxRedPntInfo != null)
    {
      localKandianMsgBoxRedPntInfo.isRead = true;
      localKandianMergeManager.l();
      ThreadManagerV2.excute(new RIJMsgBoxPopupStep.2(this, localKandianMsgBoxRedPntInfo, localKandianMergeManager), 64, null, false);
    }
  }
  
  public void g()
  {
    int i = 1;
    Object localObject = this.a.getIntent();
    boolean bool1 = false;
    boolean bool2 = false;
    String str;
    QQAppInterface localQQAppInterface;
    if (((Intent)localObject).hasExtra("notification_message_id"))
    {
      str = ((Intent)localObject).getStringExtra("notification_message_id");
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((RIJMsgBoxUtils.b() == 2) && (RIJAladdinUtils.c() == 2))
      {
        if (str.isEmpty()) {
          break label198;
        }
        ((KandianMergeManager)localQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(2, str);
      }
    }
    for (;;)
    {
      ((Intent)localObject).removeExtra("notification_message_id");
      if (RIJAladdinUtils.c() != 1)
      {
        bool1 = bool2;
        if (RIJMsgBoxUtils.b() == 2) {}
      }
      else
      {
        a(this.a, 5, str, 200L);
        bool1 = true;
      }
      localObject = new RIJTransMergeKanDianReport.ReportR5Builder().a("uin", localQQAppInterface.getCurrentAccountUin()).a("push_type", Integer.valueOf(9));
      if (bool1) {
        i = 3;
      }
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a("load_mode", Integer.valueOf(i));
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X80081DB", ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).a());
      a(bool1);
      return;
      label198:
      QLog.i("RIJMsgBoxPopupStep", 1, "readInJoy lock push, notificationMessageId is empty");
    }
  }
  
  public void h()
  {
    int i = this.a.getIntent().getIntExtra("launch_from", 5);
    if ((((KandianMergeManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).e() > 0) && (a(i))) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJMsgBoxPopupStep
 * JD-Core Version:    0.7.0.1
 */