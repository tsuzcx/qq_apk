package com.tencent.mobileqq.app.automator.step;

import afce;
import ajed;
import aome;
import awao;
import axam;
import bace;
import bbfc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.openapi.OpenApiManager;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mnf;

public class ActiveAccount
  extends AsyncStep
{
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onInitState: " + this.a.app.getAccount());
    }
    this.a.jdField_a_of_type_Long = System.currentTimeMillis();
    this.a.jdField_a_of_type_AndroidContentSharedPreferences = this.a.app.getApp().getSharedPreferences("acc_info" + this.a.app.getAccount(), 0);
    Object localObject = this.a.app;
    ThemeUtil.initTheme((QQAppInterface)localObject);
    ((QQAppInterface)localObject).a(true);
    axam.a((QQAppInterface)localObject);
    ((QQAppInterface)localObject).b();
    aome.a().b();
    UnifiedMonitor.a().a();
    OpenApiManager.getInstance().onRuntimeActive((QQAppInterface)localObject);
    if (afce.a(((QQAppInterface)localObject).getCurrentAccountUin()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "addSystemMsgSeq:0");
      }
      ((QQAppInterface)localObject).a().e("last_group_seq", 0L);
      ((QQAppInterface)localObject).a().e("last_group_suspicious_seq", 0L);
      afce.a(((QQAppInterface)localObject).getCurrentAccountUin(), false);
      ((QQAppInterface)localObject).a().e("last_friend_seq_47", 0L);
    }
    if (mnf.a != null) {
      mnf.a().a();
    }
    if ((((QQAppInterface)localObject).a(107) instanceof bbfc)) {
      ((bbfc)((QQAppInterface)localObject).a(107)).a();
    }
    localObject = new File(ajed.aU);
    if (!bace.a(ajed.aU)) {
      ((File)localObject).mkdirs();
    }
    CleanCache.a(ajed.aU);
    return 7;
  }
  
  public void a() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.ActiveAccount
 * JD-Core Version:    0.7.0.1
 */