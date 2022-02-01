package com.tencent.mobileqq.activity.aio.audiopanel;

import agnw;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import bdll;
import bhud;
import bhue;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class CommonListenPanel
  extends RelativeLayout
  implements agnw, View.OnClickListener, bhue
{
  public static int a;
  public static int b = jdField_a_of_type_Int + 1;
  private double jdField_a_of_type_Double;
  Handler jdField_a_of_type_AndroidOsHandler;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bhud jdField_a_of_type_Bhud;
  private CircleProgressView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int c;
  private int d = jdField_a_of_type_Int;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
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
    if (this.jdField_a_of_type_Bhud != null)
    {
      this.jdField_a_of_type_Bhud.e();
      this.jdField_a_of_type_Bhud = null;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130844776);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(anzj.a(2131701139));
    a();
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
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onPause() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_a_of_type_Bhud != null)
    {
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130844776);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(anzj.a(2131701138));
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.onDestroy() is called,audioPath is:" + this.jdField_a_of_type_JavaLangString);
    }
    a();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131370058) {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        StringBuilder localStringBuilder = new StringBuilder();
        if (this.d == b)
        {
          i = 1;
          bdll.b(localQQAppInterface, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, i + "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.d("QQRecorder", 2, "ListenPanel listened, jump source = " + this.d);
          }
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(103);
        }
      }
      else
      {
        if (this.jdField_a_of_type_Bhud != null) {
          break label228;
        }
        this.jdField_a_of_type_Bhud = new bhud(this.jdField_a_of_type_JavaLangString, new Handler(), 1);
        this.jdField_a_of_type_Bhud.a(getContext());
        this.jdField_a_of_type_Bhud.b();
        this.jdField_a_of_type_Bhud.a(this);
        this.jdField_a_of_type_Bhud.b();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130844778);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(anzj.a(2131701135));
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 2;
      break;
      label228:
      a();
      this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(this.jdField_a_of_type_Double));
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130844776);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(anzj.a(2131701136));
      continue;
      if (i == 2131370057)
      {
        a();
        if (this.c == 2)
        {
          setVisibility(8);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
        }
      }
      else if (i == 2131370060)
      {
        a();
        if (this.jdField_a_of_type_Double < 1000.0D)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697822), 0).a();
        }
        else if (this.c == 2)
        {
          setVisibility(8);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(102);
        }
      }
    }
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(AudioPanel.a(paramDouble));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setProgress(0);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setImageResource(2130844776);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCircleProgressView.setContentDescription(anzj.a(2131701137));
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "ListenPanel.setAudioPath() is called,path is:" + paramString + ",recordTime is:" + paramDouble);
    }
  }
  
  public void setJumpSource(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonListenPanel
 * JD-Core Version:    0.7.0.1
 */