package com.tencent.mobileqq.activity.aio.audiopanel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.StatFs;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvp.IBasePresenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.io.File;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class CommonRecordSoundPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, ICommonRecordSoundPanelView
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  ICommonRecordSoundPanelPresenter jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter;
  private VolumeIndicateSquareView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  private String jdField_a_of_type_JavaLangString = "common record panel";
  AppActivity jdField_a_of_type_MqqAppAppActivity;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VolumeIndicateSquareView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  
  public CommonRecordSoundPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonRecordSoundPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  private int a()
  {
    return this.jdField_a_of_type_MqqAppAppActivity.getResources().getDimensionPixelSize(2131299168);
  }
  
  public double a()
  {
    ICommonRecordSoundPanelPresenter localICommonRecordSoundPanelPresenter = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter;
    if (localICommonRecordSoundPanelPresenter != null) {
      return localICommonRecordSoundPanelPresenter.a();
    }
    return 0.0D;
  }
  
  public Handler a()
  {
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public IBasePresenter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter;
  }
  
  public AppActivity a()
  {
    return this.jdField_a_of_type_MqqAppAppActivity;
  }
  
  public AppRuntime a()
  {
    return this.jdField_a_of_type_MqqAppAppRuntime;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset() is called");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844759);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131702428));
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter;
    if (localObject != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((ICommonRecordSoundPanelPresenter)localObject).a(0.0D));
    }
    localObject = this.jdField_a_of_type_AndroidWidgetPopupWindow;
    if (localObject != null)
    {
      if (((PopupWindow)localObject).isShowing()) {
        try
        {
          this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
          }
        }
      }
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      if (localView.getParent() != null) {
        ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void a(int paramInt)
  {
    ICommonRecordSoundPanelPresenter localICommonRecordSoundPanelPresenter = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter;
    if (localICommonRecordSoundPanelPresenter != null) {
      localICommonRecordSoundPanelPresenter.a(paramInt);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_MqqAppAppActivity.runOnUiThread(new CommonRecordSoundPanel.2(this));
  }
  
  public void a(AppRuntime paramAppRuntime, AppActivity paramAppActivity, Handler paramHandler, int paramInt)
  {
    a(paramAppRuntime, paramAppActivity, paramHandler, paramInt, false);
  }
  
  public void a(AppRuntime paramAppRuntime, AppActivity paramAppActivity, Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_MqqAppAppActivity = paramAppActivity;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373026));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377835));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131368764));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)findViewById(2131368766));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)findViewById(2131368767));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376292));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376286));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramAppRuntime = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter;
    if (paramAppRuntime != null) {
      paramAppRuntime.d(paramInt);
    }
    if (paramBoolean) {
      ThreadManager.getUIHandler().postDelayed(new CommonRecordSoundPanel.1(this), 100L);
    }
  }
  
  public boolean a()
  {
    boolean bool = b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onBackEvent() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool)
    {
      a(102);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    boolean bool = b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onPause() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool) {
      a(102);
    }
  }
  
  public void b(int paramInt)
  {
    paramInt /= 1180;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
  }
  
  public void b(String paramString)
  {
    setRequestedOrientation4Recording(true);
    this.jdField_a_of_type_MqqAppAppActivity.getWindow().clearFlags(128);
  }
  
  public boolean b()
  {
    ICommonRecordSoundPanelPresenter localICommonRecordSoundPanelPresenter = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter;
    if (localICommonRecordSoundPanelPresenter != null) {
      return localICommonRecordSoundPanelPresenter.a();
    }
    return false;
  }
  
  public void c()
  {
    boolean bool = b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecordSoundPanel.onDestroy() is called,isRecording is:");
      localStringBuilder.append(bool);
      QLog.d("AIOAudioPanel", 2, localStringBuilder.toString());
    }
    if (bool) {
      a(1);
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void e()
  {
    VolumeIndicateSquareView localVolumeIndicateSquareView = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
    if ((localVolumeIndicateSquareView != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView != null))
    {
      localVolumeIndicateSquareView.a();
      this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onClick() is called");
    }
    if (i == 2131376286)
    {
      boolean bool2 = b();
      Object localObject;
      if (Build.VERSION.SDK_INT >= 23)
      {
        localObject = this.jdField_a_of_type_MqqAppAppActivity;
        if ((localObject != null) && (((AppActivity)localObject).checkSelfPermission("android.permission.RECORD_AUDIO") != 0))
        {
          bool1 = false;
          break label72;
        }
      }
      boolean bool1 = true;
      label72:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isRecording is:");
        ((StringBuilder)localObject).append(bool2);
        ((StringBuilder)localObject).append(" hasPermission is:");
        ((StringBuilder)localObject).append(bool1);
        QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
      }
      if (bool2)
      {
        a(102);
      }
      else
      {
        if (!bool1)
        {
          localObject = this.jdField_a_of_type_MqqAppAppActivity;
          if (localObject != null)
          {
            ((AppActivity)localObject).requestPermissions(new CommonRecordSoundPanel.4(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
            a(102);
            break label400;
          }
        }
        bool1 = Environment.getExternalStorageState().equals("mounted");
        if (this.jdField_a_of_type_MqqAppAppActivity != null)
        {
          i = a();
          if (bool1)
          {
            if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() > 1)
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter;
              if (localObject != null)
              {
                if (((ICommonRecordSoundPanelPresenter)localObject).b())
                {
                  this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844757);
                  this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(HardCodeUtil.a(2131702429));
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter.a();
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter.b(102);
                  getWindowVisibleDisplayFrame(new Rect());
                }
              }
              else {
                QLog.e(this.jdField_a_of_type_JavaLangString, 1, "recorderInit mPresenter not find");
              }
            }
            else
            {
              QQToast.a(BaseApplication.getContext(), 2131718577, 0).b(i);
            }
          }
          else {
            QQToast.a(BaseApplication.getContext(), 2131694487, 0).b(i);
          }
        }
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
      }
    }
    label400:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return b();
  }
  
  public void setPresenter(IBasePresenter paramIBasePresenter)
  {
    if (paramIBasePresenter == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter = null;
      return;
    }
    if ((paramIBasePresenter instanceof ICommonRecordSoundPanelPresenter)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter = ((ICommonRecordSoundPanelPresenter)paramIBasePresenter);
    }
  }
  
  public void setRecordTime(String paramString)
  {
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  @TargetApi(13)
  public void setRequestedOrientation4Recording(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_MqqAppAppActivity.getRequestedOrientation();
      int m = getResources().getConfiguration().orientation;
      paramBoolean = VersionUtils.b();
      int i = 0;
      int j = 0;
      int k = 1;
      Object localObject;
      if (!paramBoolean)
      {
        if (m == 1)
        {
          localObject = this.jdField_a_of_type_MqqAppAppActivity;
          i = k;
          if (VersionUtils.c()) {
            i = 7;
          }
          ((AppActivity)localObject).setRequestedOrientation(i);
          return;
        }
        if (m == 2)
        {
          localObject = this.jdField_a_of_type_MqqAppAppActivity;
          i = j;
          if (VersionUtils.c()) {
            i = 6;
          }
          ((AppActivity)localObject).setRequestedOrientation(i);
        }
      }
      else
      {
        if (VersionUtils.f())
        {
          localObject = this.jdField_a_of_type_MqqAppAppActivity.getWindowManager().getDefaultDisplay();
          j = ((Display)localObject).getRotation();
          Point localPoint = new Point();
          ((Display)localObject).getSize(localPoint);
          if ((j != 0) && (j != 2))
          {
            if (localPoint.x > localPoint.y)
            {
              if (j == 1) {
                break label224;
              }
            }
            else
            {
              if (j != 1) {
                break label216;
              }
              break label221;
            }
          }
          else
          {
            if (localPoint.x <= localPoint.y) {
              break label212;
            }
            if (j == 0) {
              break label224;
            }
          }
          i = 8;
          break label224;
          label212:
          if (j == 0) {
            label216:
            i = 1;
          } else {
            label221:
            i = 9;
          }
          label224:
          this.jdField_a_of_type_MqqAppAppActivity.setRequestedOrientation(i);
          return;
        }
        i = this.jdField_a_of_type_MqqAppAppActivity.getWindowManager().getDefaultDisplay().getRotation();
        if ((i != 0) && (i != 1))
        {
          if ((i == 2) || (i == 3))
          {
            if (m == 1)
            {
              this.jdField_a_of_type_MqqAppAppActivity.setRequestedOrientation(9);
              return;
            }
            if (m == 2) {
              this.jdField_a_of_type_MqqAppAppActivity.setRequestedOrientation(8);
            }
          }
        }
        else
        {
          if (m == 1)
          {
            this.jdField_a_of_type_MqqAppAppActivity.setRequestedOrientation(1);
            return;
          }
          if (m == 2) {
            this.jdField_a_of_type_MqqAppAppActivity.setRequestedOrientation(0);
          }
        }
      }
    }
    else
    {
      this.jdField_a_of_type_MqqAppAppActivity.setRequestedOrientation(this.jdField_b_of_type_Int);
    }
  }
  
  public void setTimeOutTime(int paramInt)
  {
    ICommonRecordSoundPanelPresenter localICommonRecordSoundPanelPresenter = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelICommonRecordSoundPanelPresenter;
    if (localICommonRecordSoundPanelPresenter != null) {
      localICommonRecordSoundPanelPresenter.c(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel
 * JD-Core Version:    0.7.0.1
 */