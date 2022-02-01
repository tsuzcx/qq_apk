package com.tencent.mobileqq.activity.aio.helper;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qassistant.audio.VoicePttInfo;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.VoiceAssistantManager;
import com.tencent.mobileqq.qassistant.listener.IPanelEventListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceCommandListener;
import com.tencent.mobileqq.qassistant.listener.IVoiceVadListener;
import com.tencent.mobileqq.qassistant.util.CommandUtils;
import com.tencent.mobileqq.qassistant.util.ReportUtils;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class VoiceMessageHelper
  implements Handler.Callback, ILifeCycleHelper, IPanelEventListener, IVoiceCommandListener, IVoiceVadListener
{
  private volatile int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private VoiceAssistantManager jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager;
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
    if (WakeManager.a().b())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
      if ((paramBaseChatPie != null) && (paramBaseChatPie.a != null)) {
        this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager = ((VoiceAssistantManager)paramBaseChatPie.a.getManager(QQManagerFactory.VOICE_ASSISTANT_MANAGER));
      }
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131720615);
      this.jdField_b_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131720593);
      this.jdField_c_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131720618);
      if ((paramBaseChatPie != null) && (paramBaseChatPie.a != null))
      {
        if (!VipUtils.b(paramBaseChatPie.a)) {
          break label137;
        }
        this.jdField_b_of_type_Int = 300;
      }
    }
    label137:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!VipUtils.c(paramBaseChatPie.a));
      this.jdField_b_of_type_Int = 180;
      return;
    }
    QLog.d("VoiceMessageHelper", 2, "VoiceMessageHelper not allow");
  }
  
  private String a(int paramInt)
  {
    int i = paramInt / 60;
    StringBuffer localStringBuffer = new StringBuffer();
    if (i > 0) {
      localStringBuffer.append(i).append("'");
    }
    localStringBuffer.append(paramInt % 60).append("\"");
    return localStringBuffer.toString();
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(paramInt);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, paramLong);
    }
  }
  
  private void a(IPanelEventListener paramIPanelEventListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(paramIPanelEventListener);
    }
  }
  
  private void a(IVoiceCommandListener paramIVoiceCommandListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(paramIVoiceCommandListener);
    }
  }
  
  private void a(IVoiceVadListener paramIVoiceVadListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(paramIVoiceVadListener);
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(3, null);
      i();
      j();
      a(null);
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(CommandUtils.b());
      ReportUtils.b(3);
    }
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null)) {}
    VoicePttInfo localVoicePttInfo;
    File localFile;
    do
    {
      return;
      localVoicePttInfo = this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a();
      if (localVoicePttInfo == null)
      {
        AssistantUtils.a("VoiceMessageHelper", "setPtt getVoicePttInfo is null");
        return;
      }
      localFile = new File(localVoicePttInfo.jdField_a_of_type_JavaLangString);
    } while ((TextUtils.isEmpty(localVoicePttInfo.jdField_a_of_type_JavaLangString)) || (!localFile.exists()));
    double d = QQRecorder.a(localFile.length(), 16000);
    AssistantUtils.a("VoiceMessageHelper", String.format("send ptt, voice path:%s, \nvoice len:%s, duration:%s, f duration:%s", new Object[] { localVoicePttInfo.jdField_a_of_type_JavaLangString, Long.valueOf(localFile.length()), Long.valueOf(localVoicePttInfo.jdField_a_of_type_Long), Double.valueOf(d) }));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(localVoicePttInfo.jdField_a_of_type_JavaLangString, 6, (int)localVoicePttInfo.jdField_a_of_type_Long, localVoicePttInfo.jdField_a_of_type_ComTencentMobileqqUtilsRecordParams$RecorderParam, 0, true, 0);
  }
  
  private void j()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_Boolean = true;
    j();
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.c()) {
        break label57;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMessageHelper", 2, "dealCreate PanelShow");
      }
      a(this);
      a(this);
    }
    for (;;)
    {
      a(this);
      return;
      label57:
      if (QLog.isColorLevel()) {
        QLog.d("VoiceMessageHelper", 2, "dealCreate Panel not show");
      }
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
    boolean bool2 = false;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_c_of_type_Boolean = false;
      return;
    }
    boolean bool1 = bool2;
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
    if (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null)
    {
      String str2 = "";
      String str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e != null) {
          str1 = String.format(BaseApplicationImpl.getContext().getString(2131719033), new Object[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.e.getText().toString() });
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(CommandUtils.a(str1, null));
    }
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager != null) && (this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.c()))
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
    switch (paramMessage.what)
    {
    }
    do
    {
      return false;
    } while ((this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.c()));
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_a_of_type_Int > this.jdField_b_of_type_Int)
      {
        h();
        return false;
      }
      if (this.jdField_b_of_type_Int - this.jdField_a_of_type_Int > 10) {
        break label282;
      }
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(CommandUtils.a(a(this.jdField_b_of_type_Int - this.jdField_a_of_type_Int), this.jdField_c_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.b();
    }
    label282:
    for (int i = 1;; i = 0)
    {
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
        this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(CommandUtils.a(a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
      }
      for (;;)
      {
        this.jdField_c_of_type_Boolean = true;
        if (this.jdField_a_of_type_AndroidOsHandler == null) {
          break;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        a(1, 1000L);
        return false;
        if (this.jdField_a_of_type_Int == 0)
        {
          this.jdField_a_of_type_Int += 1;
          this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(1, null);
          this.jdField_a_of_type_ComTencentMobileqqQassistantCoreVoiceAssistantManager.a(CommandUtils.a(a(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString));
        }
      }
    }
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (WakeManager.a().b()) {}
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      k();
      return;
    }
    l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.VoiceMessageHelper
 * JD-Core Version:    0.7.0.1
 */