package com.tencent.mobileqq.activity.aio.audiopanel.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelCallback;
import com.tencent.mobileqq.activity.aio.audiopanel.CircleProgressView;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.utils.VoicePlayer.VoicePlayerListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

public class CommonListenPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, VoicePlayer.VoicePlayerListener
{
  public static int a = 1;
  public static int b = jdField_a_of_type_Int + 1;
  private double jdField_a_of_type_Double;
  Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private VoicePlayer jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
  private String jdField_a_of_type_JavaLangString;
  private AppActivity jdField_a_of_type_MqqAppAppActivity;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean = false;
  private int c;
  private int d = jdField_a_of_type_Int;
  
  public CommonListenPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonListenPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  void a()
  {
    VoicePlayer localVoicePlayer = this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer;
    if (localVoicePlayer != null)
    {
      localVoicePlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = null;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130844755);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(HardCodeUtil.a(2131702412));
    a();
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      if (paramInt2 > paramInt1) {
        paramInt1 = 100;
      } else {
        paramInt1 = paramInt2 * 100 / paramInt1;
      }
    }
    else {
      paramInt1 = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(paramInt1);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(paramInt2));
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel.onBackEvent() is called,audioPath is:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    a();
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel.onPause() is called,audioPath is:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer != null)
    {
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130844755);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(HardCodeUtil.a(2131702411));
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel.onDestroy() is called,audioPath is:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    a();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131370159)
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        localObject = this.jdField_a_of_type_MqqAppAppRuntime;
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.d == b) {
          i = 1;
        } else {
          i = 2;
        }
        localStringBuilder.append(i);
        localStringBuilder.append("");
        ReportController.b((AppRuntime)localObject, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, localStringBuilder.toString(), "", "", "");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("ListenPanel listened, jump source = ");
          ((StringBuilder)localObject).append(this.d);
          QLog.d("QQRecorder", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(103);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer = new VoicePlayer(this.jdField_a_of_type_JavaLangString, new Handler(), 1);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(getContext());
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.a(this);
        this.jdField_a_of_type_ComTencentMobileqqUtilsVoicePlayer.b();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130844757);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(HardCodeUtil.a(2131702408));
      }
      else
      {
        a();
        this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.jdField_a_of_type_Double));
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130844755);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(HardCodeUtil.a(2131702409));
      }
    }
    else if (i == 2131370158)
    {
      a();
      if (this.c == 2)
      {
        setVisibility(8);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
      }
    }
    else if (i == 2131370161)
    {
      a();
      if (this.jdField_a_of_type_Double < 1000.0D)
      {
        localObject = this.jdField_a_of_type_MqqAppAppActivity;
        QQToast.a((Context)localObject, ((AppActivity)localObject).getString(2131698595), 0).a();
      }
      else if (this.c == 2)
      {
        setVisibility(8);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAudioPath(String paramString, double paramDouble)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(((IAudioPanelUtils)QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(paramDouble));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130844755);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(HardCodeUtil.a(2131702410));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ListenPanel.setAudioPath() is called,path is:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",recordTime is:");
      localStringBuilder.append(paramDouble);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
  }
  
  public void setJumpSource(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.view.CommonListenPanel
 * JD-Core Version:    0.7.0.1
 */