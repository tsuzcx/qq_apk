package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import axqy;
import bcql;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class PressToChangeVoicePanel$3
  implements Runnable
{
  PressToChangeVoicePanel$3(PressToChangeVoicePanel paramPressToChangeVoicePanel) {}
  
  public void run()
  {
    PressToChangeVoicePanel.a(this.this$0, true);
    boolean bool = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.n();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool);
    }
    if (bool)
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.m())
      {
        this.this$0.setClickable(false);
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.j(2);
      }
      return;
    }
    PressToChangeVoicePanel.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true, "0X8006386");
    if (PressToChangeVoicePanel.jdField_a_of_type_JavaLangString == null)
    {
      bcql.a(BaseApplication.getContext(), 2131698468, 0).a();
      return;
    }
    aytn.a = SystemClock.uptimeMillis();
    int i = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getTitleBarHeight();
    Object localObject = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a();
    if (!QQRecorder.d())
    {
      bcql.a(BaseApplication.getContext(), 2131719060, 0).b(i);
      label173:
      if (!this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.e) {
        break label623;
      }
    }
    label623:
    for (i = 1;; i = 2)
    {
      axqy.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8005472", "0X8005472", i, 0, "", "", "", "8.3.0");
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel == null) {
        break;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.a(this.this$0);
      return;
      if (!QQRecorder.a(((QQRecorder.RecorderParam)localObject).c))
      {
        bcql.a(BaseApplication.getContext(), 2131693600, 0).b(i);
        break label173;
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c())
      {
        bcql.a(BaseApplication.getContext(), 2131695522, 0).a();
        break label173;
      }
      if (AudioHelper.b(1))
      {
        ChatActivityUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a());
        break label173;
      }
      this.this$0.f();
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(this.this$0, false, (QQRecorder.RecorderParam)localObject);
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.k(2);
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel.setStatus(3);
      this.this$0.h();
      localObject = new Rect();
      Rect localRect = new Rect();
      this.this$0.b.getGlobalVisibleRect(localRect);
      this.this$0.getWindowVisibleDisplayFrame((Rect)localObject);
      localRect = new Rect();
      this.this$0.c.getGlobalVisibleRect(localRect);
      int j = localRect.bottom;
      if (((!Build.MODEL.startsWith("Coolpad")) || (Build.VERSION.SDK_INT != 19)) && ((!Build.MODEL.startsWith("Coolpad A8")) || (Build.VERSION.SDK_INT != 22)) && ((!Build.MODEL.startsWith("Coolpad B770")) || (Build.VERSION.SDK_INT != 22)))
      {
        i = j;
        if (Build.MODEL.startsWith("ivvi"))
        {
          i = j;
          if (Build.VERSION.SDK_INT != 22) {}
        }
      }
      else
      {
        i = j - ((Rect)localObject).top;
      }
      if (localRect.top <= this.this$0.getResources().getDisplayMetrics().heightPixels) {
        this.this$0.jdField_a_of_type_AndroidWidgetPopupWindow = AudioPanel.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), ((Rect)localObject).width(), i, this.this$0, 0, 0, 0);
      }
      this.this$0.jdField_a_of_type_AndroidViewView = AudioPanel.a(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.this$0.b, this.this$0.c);
      break label173;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToChangeVoicePanel.3
 * JD-Core Version:    0.7.0.1
 */