package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import upy;

public class ListenPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, VoicePlayer.VoicePlayerListener
{
  public static int a;
  public static int b;
  private double jdField_a_of_type_Double;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
  private AudioPanel jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQRecorder.RecorderParam jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private int jdField_c_of_type_Int;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private int d = jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = jdField_a_of_type_Int + 1;
  }
  
  public ListenPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public ListenPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.f();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130842177);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131427469));
    a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ViewGroup paramViewGroup1, AudioPanel paramAudioPanel, ViewGroup paramViewGroup2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelAudioPanel = paramAudioPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup2;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup1;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366437));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView = ((CircleProgressView)findViewById(2131366439));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366441));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366442));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.init() is called");
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      paramInt1 = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(paramInt1);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(paramInt2));
      return;
      if (paramInt2 > paramInt1) {
        paramInt1 = 100;
      } else {
        paramInt1 = paramInt2 * 100 / paramInt1;
      }
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    if (this.d == jdField_b_of_type_Int)
    {
      i = 3;
      ((BaseChatPie)localObject).b(str, i, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_c_of_type_Int != 1) {
        break label125;
      }
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369460);
      ((PressToSpeakPanel)localObject).b();
      ((PressToSpeakPanel)localObject).setVisibility(0);
    }
    label125:
    while (this.jdField_c_of_type_Int != 2)
    {
      return false;
      i = 2;
      break;
    }
    setVisibility(8);
    localObject = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366443);
    ((RecordSoundPanel)localObject).b();
    ((RecordSoundPanel)localObject).setVisibility(0);
    return false;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onPause() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130842177);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131427469));
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onDestroy() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
    String str = this.jdField_a_of_type_JavaLangString;
    int i;
    if (this.d == jdField_b_of_type_Int)
    {
      i = 3;
      ((BaseChatPie)localObject).b(str, i, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_c_of_type_Int != 1) {
        break label124;
      }
      setVisibility(8);
      localObject = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369460);
      ((PressToSpeakPanel)localObject).b();
      ((PressToSpeakPanel)localObject).setVisibility(0);
    }
    label124:
    while (this.jdField_c_of_type_Int != 2)
    {
      return;
      i = 2;
      break;
    }
    setVisibility(8);
    localObject = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366443);
    ((RecordSoundPanel)localObject).b();
    ((RecordSoundPanel)localObject).setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131366439)
    {
      if (AppSetting.b) {
        this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.h(2131230744);
      }
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        paramView = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject = new StringBuilder();
        if (this.d != jdField_b_of_type_Int) {
          break label232;
        }
        i = 1;
        ReportController.b(paramView, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, i + "", "", "", "");
        if (QLog.isColorLevel()) {
          QLog.d("QQRecorder", 2, "ListenPanel listened, jump source = " + this.d);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(this.jdField_a_of_type_JavaLangString, new Handler(), this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam.jdField_c_of_type_Int);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(getContext());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a();
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.c();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130842178);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131427472));
      }
    }
    label232:
    label495:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            i = 2;
            break;
            a();
            this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(this.jdField_a_of_type_Double));
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130842177);
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131427469));
            return;
            if (i != 2131366441) {
              break label495;
            }
            a();
            paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
            localObject = this.jdField_a_of_type_JavaLangString;
            if (this.d == jdField_b_of_type_Int) {}
            for (i = 3;; i = 2)
            {
              paramView.b((String)localObject, i, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam);
              this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
              if (this.jdField_c_of_type_Int != 1) {
                break;
              }
              setVisibility(8);
              paramView = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369460);
              paramView.b();
              paramView.setVisibility(0);
              return;
            }
          } while (this.jdField_c_of_type_Int != 2);
          setVisibility(8);
          paramView = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366443);
          paramView.b();
          paramView.setVisibility(0);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Voice_record _cancel", 0, 0, "", "", "", "");
        } while (!(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof PublicAccountChatPie));
        PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005856", "0X8005856", 0, 0, "", "", "", "", false);
        return;
      } while (i != 2131366442);
      a();
      int j = (int)this.jdField_a_of_type_Double;
      if (this.jdField_c_of_type_Int == 2)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Record_attribute", 0, 0, String.valueOf(j), "", "", "");
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie instanceof PublicAccountChatPie)) {
          PublicAccountReportUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005855", "0X8005855", 0, 0, "", "", "", "", false);
        }
      }
      if (this.jdField_a_of_type_Double < 1000.0D)
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.a().getString(2131433397), 0).a();
        return;
      }
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.G;
      this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie.b(this.jdField_a_of_type_JavaLangString, null);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityBaseChatPie;
      localObject = this.jdField_a_of_type_JavaLangString;
      if (this.d == jdField_a_of_type_Int) {}
      for (i = 2;; i = 3)
      {
        paramView.a((String)localObject, i, j, this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam, 0, true);
        if (!bool) {
          break;
        }
        ((PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369460)).h();
        return;
      }
      if (this.jdField_c_of_type_Int == 1)
      {
        setVisibility(8);
        paramView = (PressToSpeakPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369460);
        paramView.b();
        paramView.setVisibility(0);
        return;
      }
    } while (this.jdField_c_of_type_Int != 2);
    setVisibility(8);
    paramView = (RecordSoundPanel)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366443);
    paramView.b();
    paramView.setVisibility(0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam = paramRecorderParam;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(paramDouble));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130842177);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(getContext().getString(2131427469));
    if (AppSetting.b)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setFocusable(true);
      ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_AndroidWidgetTextView, new upy(this));
      this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_b_of_type_AndroidWidgetTextView.getText() + getContext().getString(2131427457));
      this.jdField_c_of_type_AndroidWidgetTextView.setContentDescription(this.jdField_c_of_type_AndroidWidgetTextView.getText() + getContext().getString(2131427457));
      QQAppInterface.f(getContext().getString(2131427470));
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.setAudioPath() is called,path is:" + paramString + ",recordTime is:" + paramDouble);
    }
  }
  
  public void setJumpSource(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel
 * JD-Core Version:    0.7.0.1
 */