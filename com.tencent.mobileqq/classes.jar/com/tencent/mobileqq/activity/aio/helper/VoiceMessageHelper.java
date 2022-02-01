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
  private volatile int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private IVoiceAssistantCore jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 120;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  
  public VoiceMessageHelper(BaseChatPie paramBaseChatPie)
  {
    if (((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).getWakeManagerEnable())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
      if ((paramBaseChatPie != null) && (paramBaseChatPie.a != null))
      {
        AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (localAppRuntime != null) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore = ((IVoiceAssistantCore)localAppRuntime.getRuntimeService(IVoiceAssistantCore.class, ""));
        }
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131720330);
      this.jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131720308);
      this.jdField_c_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131720333);
      if ((paramBaseChatPie != null) && (paramBaseChatPie.a != null))
      {
        if (VasUtil.a(paramBaseChatPie.a).getVipStatus().isSVip())
        {
          this.jdField_b_of_type_Int = 300;
          return;
        }
        if (VasUtil.a(paramBaseChatPie.a).getVipStatus().isVip()) {
          this.jdField_b_of_type_Int = 180;
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
    int i = paramInt / 60;
    StringBuffer localStringBuffer = new StringBuffer();
    if (i > 0)
    {
      localStringBuffer.append(i);
      localStringBuffer.append("'");
    }
    localStringBuffer.append(paramInt % 60);
    localStringBuffer.append("\"");
    return localStringBuffer.toString();
  }
  
  private void a(int paramInt, long paramLong)
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null)
    {
      localObject = ((Handler)localObject).obtainMessage(paramInt);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, paramLong);
    }
  }
  
  private void a(IPanelEventListener paramIPanelEventListener)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.setPanelEventListener(paramIPanelEventListener);
    }
  }
  
  private void a(IVoiceCommandListener paramIVoiceCommandListener)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
    if (localIVoiceAssistantCore != null) {
      localIVoiceAssistantCore.setVoiceCommandListener(paramIVoiceCommandListener);
    }
  }
  
  private void a(IVoiceVadListener paramIVoiceVadListener)
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
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
    IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
    if (localIVoiceAssistantCore != null)
    {
      localIVoiceAssistantCore.onVoiceMessageCallBack(3, null);
      i();
      j();
      a(null);
      this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.executeCommand(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).buildShowResendViewCommand());
      ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).reportSureSendMessage(3);
    }
  }
  
  private void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
        return;
      }
      localObject = ((IVoiceAssistantCore)localObject).getVoicePttInfo();
      if (localObject == null)
      {
        a("VoiceMessageHelper", "setPtt getVoicePttInfo is null");
        return;
      }
      File localFile = new File(((VoicePttInfo)localObject).jdField_a_of_type_JavaLangString);
      if (!TextUtils.isEmpty(((VoicePttInfo)localObject).jdField_a_of_type_JavaLangString))
      {
        if (!localFile.exists()) {
          return;
        }
        double d = ((IQQRecorderUtils)QRoute.api(IQQRecorderUtils.class)).getMillisecond(16000, 2, 2, localFile.length());
        a("VoiceMessageHelper", String.format("send ptt, voice path:%s, \nvoice len:%s, duration:%s, f duration:%s", new Object[] { ((VoicePttInfo)localObject).jdField_a_of_type_JavaLangString, Long.valueOf(localFile.length()), Long.valueOf(((VoicePttInfo)localObject).jdField_a_of_type_Long), Double.valueOf(d) }));
        ((AudioPanelAioHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(128)).a(((VoicePttInfo)localObject).jdField_a_of_type_JavaLangString, 6, (int)((VoicePttInfo)localObject).jdField_a_of_type_Long, ((VoicePttInfo)localObject).jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam, 0, true, 0);
      }
    }
  }
  
  private void j()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_Boolean = true;
    j();
    IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
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
    this.jdField_a_of_type_Boolean = false;
    j();
    a(null);
    a(null);
    a(null);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
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
    boolean bool1 = this.jdField_c_of_type_Boolean;
    boolean bool2 = false;
    if (bool1)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    bool1 = bool2;
    if (this.jdField_b_of_type_Boolean)
    {
      bool1 = bool2;
      if (paramBoolean) {
        bool1 = true;
      }
    }
    this.jdField_b_of_type_Boolean = bool1;
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
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore != null)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
      if ((localObject != null) && (((BaseChatPie)localObject).e != null)) {
        localObject = String.format(BaseApplicationImpl.getContext().getString(2131718749), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e.getText().toString() });
      } else {
        localObject = "";
      }
      this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.executeCommand(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).buildShowSelectViewCommand((String)localObject, null));
    }
  }
  
  public void g()
  {
    IVoiceAssistantCore localIVoiceAssistantCore = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
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
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore;
    if ((paramMessage != null) && (paramMessage.isVoicePanelShow()))
    {
      if (this.jdField_a_of_type_Int > 0)
      {
        this.jdField_a_of_type_Int += 1;
        int i = this.jdField_a_of_type_Int;
        int j = this.jdField_b_of_type_Int;
        if (i > j)
        {
          h();
          return false;
        }
        if (j - this.jdField_a_of_type_Int <= 10)
        {
          this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.executeCommand(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).buildShowRecordViewCommand(a(this.jdField_b_of_type_Int - this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
          this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.startPanelTipsAnimation();
          i = 1;
        }
        else
        {
          i = 0;
        }
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_c_of_type_Int += 1;
          if (this.jdField_c_of_type_Int > 3)
          {
            h();
            return false;
          }
        }
        else
        {
          this.jdField_c_of_type_Int = 0;
        }
        if (i == 0) {
          this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.executeCommand(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).buildShowRecordViewCommand(a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
        }
      }
      else if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_a_of_type_Int += 1;
        this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.onVoiceMessageCallBack(1, null);
        this.jdField_a_of_type_ComTencentMobileqqQassistantApiIVoiceAssistantCore.executeCommand(((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).buildShowRecordViewCommand(a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
      }
      this.jdField_c_of_type_Boolean = true;
      paramMessage = this.jdField_a_of_type_AndroidOsHandler;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.VoiceMessageHelper
 * JD-Core Version:    0.7.0.1
 */