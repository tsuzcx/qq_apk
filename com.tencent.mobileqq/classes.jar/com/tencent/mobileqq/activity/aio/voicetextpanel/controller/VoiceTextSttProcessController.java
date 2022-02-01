package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextSttListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextInfoState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextSttState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextUIState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextEditViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSendViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.utils.ReportUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RecordParams.RecorderParam;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class VoiceTextSttProcessController
  implements VoiceTextSttListener
{
  private AppRuntime a;
  private BaseAIOContext b;
  private BaseSessionInfo c;
  private RecordParams.RecorderParam d;
  private String e;
  private String f;
  private int g;
  private VoiceTextPanel h;
  private Handler i;
  private VoiceTextSendViewHelper j;
  private VoiceTextEditViewHelper k;
  private VoiceTextStateModel l;
  private VoiceTextSttQueryController m;
  private INetInfoHandler n = new VoiceTextSttProcessController.1(this);
  
  public VoiceTextSttProcessController(VoiceTextStateModel paramVoiceTextStateModel, AppRuntime paramAppRuntime, VoiceTextPanel paramVoiceTextPanel)
  {
    this.a = paramAppRuntime;
    this.h = paramVoiceTextPanel;
    this.l = paramVoiceTextStateModel;
    this.j = new VoiceTextSendViewHelper(paramVoiceTextStateModel, paramAppRuntime, paramAppRuntime.getApp().getSharedPreferences("check_update_sp_key", 0));
    this.i = new Handler(Looper.getMainLooper());
    this.k = new VoiceTextEditViewHelper(paramVoiceTextStateModel, paramAppRuntime, this.i);
    this.m = new VoiceTextSttQueryController();
  }
  
  private void a(boolean paramBoolean)
  {
    this.j.a(paramBoolean);
  }
  
  private void l()
  {
    if (this.l.e().b())
    {
      ReportUtils.a("0X800A1DA", 3, 0);
      return;
    }
    ReportUtils.a("0X800A1DA", 2, 0);
  }
  
  private void m()
  {
    if (this.l.c().d())
    {
      this.d.i = this.l.d().b();
      if ((this.d.i != null) && (this.d.i.length() > 150))
      {
        RecordParams.RecorderParam localRecorderParam = this.d;
        localRecorderParam.i = localRecorderParam.i.substring(0, 150);
      }
    }
  }
  
  private void n()
  {
    if ((this.l.c().a()) || (this.l.c().b()))
    {
      QQToast.makeText(this.h.getContext(), HardCodeUtil.a(2131913775), 0).show(this.h.getContext().getResources().getDimensionPixelSize(2131299920));
      f();
      this.k.l();
      this.m.b();
      this.k.a(this.l.d().b());
      this.l.c().a(5);
    }
  }
  
  private void o()
  {
    if (!StringUtil.isEmpty(this.l.d().b()))
    {
      this.l.c().a(2);
      if (!this.j.g()) {
        a(true);
      }
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextSttProcessController", 2, "sendRequest  net unAvailable");
    }
    QQToast.makeText(this.h.getContext(), HardCodeUtil.a(2131913774), 0).show(this.h.getContext().getResources().getDimensionPixelSize(2131299920));
    f();
    this.l.c().a(5);
  }
  
  public void a()
  {
    this.j.a(this.h);
    this.k.a(this.h);
  }
  
  public void a(int paramInt)
  {
    QQToast.makeText(this.h.getContext(), HardCodeUtil.a(2131913775), 0).show(this.h.getContext().getResources().getDimensionPixelSize(2131299920));
    f();
    this.k.l();
    this.m.b();
    this.k.a(this.l.d().b());
    this.l.c().a(5);
  }
  
  public void a(BaseAIOContext paramBaseAIOContext, BaseSessionInfo paramBaseSessionInfo, RecordParams.RecorderParam paramRecorderParam, int paramInt, String paramString1, String paramString2)
  {
    this.e = paramString2;
    this.b = paramBaseAIOContext;
    this.f = paramString1;
    this.c = paramBaseSessionInfo;
    this.d = paramRecorderParam;
    this.g = paramInt;
    this.j.a(this.h.getVoiceTextUserOpListener());
    this.k.a(this.h.getVoiceTextUserOpListener());
    this.m.a(paramString1, this.a, this, paramBaseSessionInfo.a, paramBaseSessionInfo.b);
  }
  
  public void a(String paramString)
  {
    if ((!this.l.c().c()) && (!this.l.c().f()))
    {
      this.l.d().b(paramString);
      o();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextSttProcessController", 2, "updateText has finish");
    }
  }
  
  public void b()
  {
    this.k.i();
  }
  
  public void b(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      a(false);
    } else {
      a(true);
    }
    this.j.a();
  }
  
  public void c()
  {
    this.l.c().a(3);
    this.k.l();
    this.i.post(new VoiceTextSttProcessController.2(this));
  }
  
  public void d()
  {
    this.l.c().a(4);
  }
  
  public void e()
  {
    if (this.f == null) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.h.getContext()))
    {
      p();
      return;
    }
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).setIsInVoiceTxt(true);
    ReportUtils.a("0X800A1D7", 0, 0);
    AppNetConnInfo.registerConnectionChangeReceiver(this.h.getContext(), this.n);
    this.l.c().a(1);
    this.m.a(this.e);
    this.k.k();
  }
  
  public void f()
  {
    this.j.h();
    this.k.h().setFocusableInTouchMode(true);
  }
  
  public void g()
  {
    this.k.g();
    this.m.a();
  }
  
  public void h()
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
      this.n = null;
    }
    localObject = this.i;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacks(null);
    }
    g();
    this.k.l();
  }
  
  public void i()
  {
    g();
    this.k.f();
    this.j.f();
  }
  
  public void j()
  {
    if ((this.l.e().d()) && (this.l.e().c()))
    {
      m();
      int i1;
      if (this.l.c().d()) {
        i1 = 2;
      } else {
        i1 = 1;
      }
      ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).sendVoiceAndTxt(this.b, this.e, 5, this.g, this.d, 0, false, i1);
      ReportUtils.a("0X800A1DA", 1, 0);
      return;
    }
    ((IVoice2TxtTmpApi)QRoute.api(IVoice2TxtTmpApi.class)).sendTxt(this.a, this.c, this.l.a(), this.h.getContext());
    l();
  }
  
  public void k()
  {
    this.j.b();
    this.k.b();
    this.i.removeCallbacks(null);
    this.m.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController
 * JD-Core Version:    0.7.0.1
 */