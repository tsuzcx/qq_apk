package com.tencent.mobileqq.activity.aio.helper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.panel.PanelListener;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopClassInfoTipsBar;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopSurveyBar;
import com.tencent.mobileqq.activity.aio.tips.HomeworkTroopTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.mobileqq.troop.groupclass.TroopAioClassController;
import com.tencent.mobileqq.troop.groupclass.TroopClassControllerManager;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.utils.SoLibraryChecker;
import com.tencent.qphone.base.util.QLog;

public class HWTroopClassInfoTipsHelper
  implements OnFinishListener, ILifeCycleHelper, PanelListener
{
  BroadcastReceiver a;
  public HomeworkTroopTipsBar b;
  public boolean c;
  public BaseActivity d;
  public HomeworkTroopClassInfoTipsBar e;
  private final TroopChatPie f;
  private QQAppInterface g;
  private SessionInfo h;
  private TipsManager i;
  private HomeworkTroopSurveyBar j;
  private TroopClassControllerManager k;
  private TroopObserver l = new HWTroopClassInfoTipsHelper.1(this);
  private TroopPushObserver m = new HWTroopClassInfoTipsHelper.2(this);
  
  public HWTroopClassInfoTipsHelper(TroopChatPie paramTroopChatPie)
  {
    this.f = paramTroopChatPie;
    this.g = paramTroopChatPie.d;
    this.h = paramTroopChatPie.ah;
    this.d = paramTroopChatPie.f;
    this.f.bv().d().a(this);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      TroopChatPie localTroopChatPie = this.f;
      if ((localTroopChatPie != null) && (localTroopChatPie.ah != null))
      {
        if (!paramString.equals(this.f.ah.b)) {
          return;
        }
        b();
      }
    }
  }
  
  private void e()
  {
    this.g.addObserver(this.m);
    this.g.addObserver(this.l);
    f();
  }
  
  private void f()
  {
    Object localObject = this.d;
    if (localObject != null) {
      localObject = ((BaseActivity)localObject).getIntent();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      int n = 0;
      Boolean localBoolean = Boolean.valueOf(((Intent)localObject).getBooleanExtra("isFromContactTab", false));
      int i1 = ((Intent)localObject).getIntExtra("aio_msg_source", -1);
      if ((i1 == 0) || (i1 == 1) || (localBoolean.booleanValue())) {
        n = 1;
      }
      if (n != 0)
      {
        localObject = ((Intent)localObject).getStringExtra("uin");
        if (localObject != null)
        {
          TroopManager localTroopManager = (TroopManager)this.g.getManager(QQManagerFactory.TROOP_MANAGER);
          TroopInfo localTroopInfo = localTroopManager.f((String)localObject);
          if ((localTroopInfo != null) && (localTroopInfo.isOwnerOrAdmin(this.g.getCurrentAccountUin())) && (localTroopManager.aa((String)localObject)) && (localTroopInfo.isNotSetTroopClassInfo()) && (this.d != null))
          {
            n = localTroopManager.C((String)localObject);
            if (n < 3)
            {
              if (localBoolean.booleanValue()) {
                HWTroopUtils.a(this.d, localTroopInfo.troopuin, HWTroopUtils.b);
              } else {
                HWTroopUtils.a(this.d, localTroopInfo.troopuin, HWTroopUtils.a);
              }
              localTroopManager.a((String)localObject, n + 1);
              ReportController.b(this.g, "P_CliOper", "Grp_edu", "", "Grp_data", "classinfo_Clk", 0, 0, localTroopInfo.troopuin, "", "", "");
            }
          }
        }
      }
    }
  }
  
  private void g()
  {
    if (this.c)
    {
      TroopClassControllerManager localTroopClassControllerManager = this.k;
      if (localTroopClassControllerManager != null)
      {
        localTroopClassControllerManager.a(true);
        this.c = false;
      }
    }
  }
  
  private void h()
  {
    Object localObject = this.d.getIntent();
    if (localObject == null) {
      return;
    }
    String str = ((Intent)localObject).getStringExtra("uin");
    int n = ((Intent)localObject).getIntExtra("uintype", -1);
    if ((this.h.b != null) && ((!this.h.b.equals(str)) || (this.h.a != n))) {
      n = 1;
    } else {
      n = 0;
    }
    if (n != 0)
    {
      localObject = this.k;
      if ((localObject != null) && (((TroopClassControllerManager)localObject).a != null))
      {
        this.k.a.b();
        this.k.a = null;
      }
    }
  }
  
  private void i()
  {
    this.g.removeObserver(this.m);
    this.g.removeObserver(this.l);
    l();
    try
    {
      if (this.a != null)
      {
        this.f.e.unregisterReceiver(this.a);
        this.a = null;
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnDestroy unregisterReceiver, e:");
        localStringBuilder.append(localException.getMessage());
        QLog.e("HWTroopClassInfoTipsHelper", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void j()
  {
    if (((TroopManager)this.g.getManager(QQManagerFactory.TROOP_MANAGER)).aa(this.h.b))
    {
      new SoLibraryChecker(this.f.e, "3171", "libWXVoice.so", "WXVoice").a();
      if (this.a == null) {
        this.a = new HWTroopClassInfoTipsHelper.3(this);
      }
    }
    try
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      this.f.e.registerReceiver(this.a, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
    }
    catch (Exception localException)
    {
      label109:
      break label109;
    }
    QLog.e("HWTroopClassInfoTipsHelper", 1, "register homework receiver exception.");
    HomeworkTroopController.b(this.g, this.h.b);
  }
  
  private void k()
  {
    if (this.k == null) {
      this.k = ((TroopClassControllerManager)this.g.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER));
    }
    TroopInfo localTroopInfo = ((TroopManager)this.g.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.h.b);
    if (localTroopInfo != null) {
      this.k.a(localTroopInfo.dwGroupClassExt, true, this.f, this.h.b);
    }
  }
  
  private void l()
  {
    TroopClassControllerManager localTroopClassControllerManager = this.k;
    if (localTroopClassControllerManager != null) {
      localTroopClassControllerManager.b();
    }
  }
  
  public TroopClassControllerManager a()
  {
    if (this.k == null) {
      this.k = ((TroopClassControllerManager)this.g.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER));
    }
    return this.k;
  }
  
  public void a(TipsManager paramTipsManager, boolean paramBoolean)
  {
    if (this.b == null) {
      this.b = new HomeworkTroopTipsBar(this.f.f, this.f.ah, this.f.d.getCurrentAccountUin());
    }
    this.b.a(paramTipsManager, paramBoolean);
  }
  
  public boolean a(TipsManager paramTipsManager)
  {
    HomeworkTroopTipsBar localHomeworkTroopTipsBar = this.b;
    return (localHomeworkTroopTipsBar != null) && (localHomeworkTroopTipsBar.a(paramTipsManager));
  }
  
  public boolean a(boolean paramBoolean)
  {
    return false;
  }
  
  public void b()
  {
    if (this.f != null)
    {
      Object localObject = this.h;
      if (localObject != null)
      {
        if (TextUtils.isEmpty(((SessionInfo)localObject).b)) {
          return;
        }
        localObject = (TroopManager)this.g.getManager(QQManagerFactory.TROOP_MANAGER);
        TroopInfo localTroopInfo = ((TroopManager)localObject).f(this.h.b);
        if (localTroopInfo == null) {
          return;
        }
        if (this.k == null) {
          this.k = ((TroopClassControllerManager)this.g.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER));
        }
        if ((localTroopInfo.isOwnerOrAdmin(this.g.getCurrentAccountUin())) && (((TroopManager)localObject).aa(this.h.b)) && (localTroopInfo.isNotSetTroopClassInfo()))
        {
          localObject = this.k;
          if (localObject != null)
          {
            ((TroopClassControllerManager)localObject).a = ((TroopClassControllerManager)localObject).a(this.f, this.h.b);
            if (!(this.k.a instanceof HomeworkTroopController)) {
              return;
            }
            ((HomeworkTroopController)this.k.a).c(this.f);
            return;
          }
        }
        if (this.e != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("HWTroopClassInfoTipsHelper", 2, "mHomeworkTroopClassInfoChangedReceiver dismissTipsBar.");
          }
          localObject = this.f;
          if (localObject != null) {
            this.i = ((TroopChatPie)localObject).ca();
          }
          localObject = this.i;
          if (localObject != null) {
            this.e.a((TipsManager)localObject, false);
          }
        }
      }
    }
  }
  
  public int bM_()
  {
    return 0;
  }
  
  public void d()
  {
    if (((FullScreenInputHelper)this.f.bv().d().a(24)).e()) {
      return;
    }
    if (this.j == null)
    {
      QQAppInterface localQQAppInterface = this.g;
      this.j = new HomeworkTroopSurveyBar(localQQAppInterface, this.d, this.h, localQQAppInterface.getCurrentAccountUin());
    }
    if (this.i == null) {
      this.i = this.f.ca();
    }
    this.j.a(this.i);
  }
  
  public boolean d(int paramInt)
  {
    return false;
  }
  
  public void e(int paramInt)
  {
    if (paramInt == 0)
    {
      TroopClassControllerManager localTroopClassControllerManager = this.k;
      if (localTroopClassControllerManager != null) {
        localTroopClassControllerManager.c();
      }
    }
  }
  
  public String getTag()
  {
    return "HWTroopClassInfoTipsHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 10, 8, 15, 6 };
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 6)
      {
        if (paramInt != 8)
        {
          if (paramInt != 10)
          {
            if (paramInt != 15) {
              return;
            }
            i();
            return;
          }
          g();
          return;
        }
        k();
        j();
        b();
        d();
        return;
      }
      h();
      return;
    }
    e();
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    TroopClassControllerManager localTroopClassControllerManager = this.k;
    if (localTroopClassControllerManager != null) {
      localTroopClassControllerManager.a();
    }
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HWTroopClassInfoTipsHelper
 * JD-Core Version:    0.7.0.1
 */