package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantCore;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qassistant.data.VoicePttInfo;
import com.tencent.mobileqq.qassistant.listener.IPanelEventListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceCommandListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceVadListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class VoiceMessageHelper
  implements Handler.Callback, ILifeCycleHelper, IPanelEventListener, IVoiceCommandListener, IVoiceVadListener
{
  private BaseChatPie a;
  private IVoiceAssistantCore b;
  private boolean c = false;
  private String d;
  private String e;
  private String f;
  private Handler g;
  private volatile int h;
  private int i = 120;
  private volatile int j;
  private volatile boolean k;
  private volatile boolean l;
  
  public VoiceMessageHelper(BaseChatPie paramBaseChatPie)
  {
    if (((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getWakeManagerEnable())
    {
      this.a = paramBaseChatPie;
      if ((paramBaseChatPie != null) && (paramBaseChatPie.d != null))
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localAppRuntime != null) {
          this.b = ((IVoiceAssistantCore)localAppRuntime.getRuntimeService(IVoiceAssistantCore.class, ""));
        }
      }
      this.g = new Handler(Looper.getMainLooper(), this);
      this.d = BaseApplicationImpl.getContext().getString(2131917965);
      this.e = BaseApplicationImpl.getContext().getString(2131917943);
      this.f = BaseApplicationImpl.getContext().getString(2131917968);
      if ((paramBaseChatPie != null) && (paramBaseChatPie.d != null))
      {
        if (VasUtil.b(paramBaseChatPie.d).getVipStatus().isSVip())
        {
          this.i = 300;
          return;
        }
        if (VasUtil.b(paramBaseChatPie.d).getVipStatus().isVip()) {
          this.i = 180;
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("VoiceMessageHelper", 2, "VoiceMessageHelper not allow");
    }
  }
  
  private String a(int paramInt)
  {
    int m = paramInt / 60;
    StringBuffer localStringBuffer = new StringBuffer();
    if (m > 0)
    {
      localStringBuffer.append(m);
      localStringBuffer.append("'");
    }
    localStringBuffer.append(paramInt % 60);
    localStringBuffer.append("\"");
    return localStringBuffer.toString();
  }
  
  private void a(int paramInt, long paramLong)
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(paramInt);
      this.g.sendMessageDelayed((Message)localObject, paramLong);
    }
  }
  
  private void a(IPanelEventListener paramIPanelEventListener)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.b;
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.setPanelEventListener(paramIPanelEventListener);
    }
  }
  
  private void a(IVoiceCommandListener paramIVoiceCommandListener)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.b;
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.setVoiceCommandListener(paramIVoiceCommandListener);
    }
  }
  
  private void a(IVoiceVadListener paramIVoiceVadListener)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.b;
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.setVoiceVadListener(paramIVoiceVadListener);
    }
  }
  
  private static void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(paramString1, 2, paramString2);
    }
  }
  
  private void h()
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.b;
    if (localIVoiceAssistantCore != null)
    {
      localIVoiceAssistantCore.onVoiceMessageCallBack(3, null);
      i();
      j();
      a(null);
      this.b.executeCommand(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).buildShowResendViewCommand());
      ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportSureSendMessage(3);
    }
  }
  
  private void i()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (this.a == null) {
        return;
      }
      localObject = ((IVoiceAssistantCore)localObject).getVoicePttInfo();
      if (localObject == null)
      {
        a("VoiceMessageHelper", "setPtt getVoicePttInfo is null");
        return;
      }
      File localFile = new File(((VoicePttInfo)localObject).a);
      if (!TextUtils.isEmpty(((VoicePttInfo)localObject).a))
      {
        if (!localFile.exists()) {
          return;
        }
        double d1 = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getMillisecond(16000, 2, 2, localFile.length());
        a("VoiceMessageHelper", String.format("send ptt, voice path:%s, \nvoice len:%s, duration:%s, f duration:%s", new Object[] { ((VoicePttInfo)localObject).a, Long.valueOf(localFile.length()), Long.valueOf(((VoicePttInfo)localObject).b), Double.valueOf(d1) }));
        ((AudioPanelAioHelper)this.a.q(128)).a(((VoicePttInfo)localObject).a, 6, (int)((VoicePttInfo)localObject).b, ((VoicePttInfo)localObject).c, 0, true, 0);
      }
    }
  }
  
  private void j()
  {
    this.l = true;
    this.j = 0;
    this.h = 0;
    Handler localHandler = this.g;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private void k()
  {
    this.c = true;
    j();
    IVoiceAssistantCore localIVoiceAssistantCore = this.b;
    if (localIVoiceAssistantCore != null)
    {
      if (localIVoiceAssistantCore.isVoicePanelShow())
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceMessageHelper", 2, "dealCreate PanelShow");
        }
        a(this);
        a(this);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("VoiceMessageHelper", 2, "dealCreate Panel not show");
      }
      a(this);
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceMessageHelper", 2, "dealDestroy");
    }
    this.c = false;
    j();
    a(null);
    a(null);
    a(null);
  }
  
  public void a()
  {
    if (this.c)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMessageHelper", 2, "onEnterPanel");
      }
      j();
      a(this);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool1 = this.l;
    boolean bool2 = false;
    if (bool1)
    {
      this.k = paramBoolean;
      this.l = false;
      return;
    }
    bool1 = bool2;
    if (this.k)
    {
      bool1 = bool2;
      if (paramBoolean) {
        bool1 = true;
      }
    }
    this.k = bool1;
  }
  
  public void b()
  {
    j();
    a(null);
    a(null);
  }
  
  public void c()
  {
    j();
    a(null);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceMessageHelper", 2, "onResendRecord");
    }
    j();
    a(this);
    a(this);
    g();
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceMessageHelper", 2, "onSureSend");
    }
    i();
    j();
    a(null);
  }
  
  public void f()
  {
    if (this.b != null)
    {
      Object localObject = this.a;
      if ((localObject != null) && (((BaseChatPie)localObject).C != null)) {
        localObject = String.format(BaseApplicationImpl.getContext().getString(2131916255), new Object[] { this.a.C.getText().toString() });
      } else {
        localObject = "";
      }
      this.b.executeCommand(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).buildShowSelectViewCommand((String)localObject, null));
    }
  }
  
  public void g()
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.b;
    if ((localIVoiceAssistantCore != null) && (localIVoiceAssistantCore.isVoicePanelShow()))
    {
      j();
      a(1, 1000L);
    }
  }
  
  public String getTag()
  {
    return "VoiceMessageHelper";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    paramMessage = this.b;
    if ((paramMessage != null) && (paramMessage.isVoicePanelShow()))
    {
      if (this.h > 0)
      {
        this.h += 1;
        int m = this.h;
        int n = this.i;
        if (m > n)
        {
          h();
          return false;
        }
        if (n - this.h <= 10)
        {
          this.b.executeCommand(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).buildShowRecordViewCommand(a(this.i - this.h), this.f, this.e));
          this.b.startPanelTipsAnimation();
          m = 1;
        }
        else
        {
          m = 0;
        }
        if (this.k)
        {
          this.j += 1;
          if (this.j > 3)
          {
            h();
            return false;
          }
        }
        else
        {
          this.j = 0;
        }
        if (m == 0) {
          this.b.executeCommand(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).buildShowRecordViewCommand(a(this.h), this.d, this.e));
        }
      }
      else if (this.h == 0)
      {
        this.h += 1;
        this.b.onVoiceMessageCallBack(1, null);
        this.b.executeCommand(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).buildShowRecordViewCommand(a(this.h), this.d, this.e));
      }
      this.l = true;
      paramMessage = this.g;
      if (paramMessage != null)
      {
        paramMessage.removeMessages(1);
        a(1, 1000L);
      }
    }
    return false;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getWakeManagerEnable())
    {
      if (paramInt != 4)
      {
        if (paramInt != 15) {
          return;
        }
        l();
        return;
      }
      k();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.VoiceMessageHelper
 * JD-Core Version:    0.7.0.1
 */