package com.tencent.mobileqq.activity.aio.audiopanel;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ptt.PttBuffer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.OnQQRecorderListener;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import mqq.os.MqqHandler;
import upk;
import upl;
import upm;
import upn;
import upo;
import upp;
import upq;
import upr;
import ups;
import upt;

public class CommonRecordSoundPanel
  extends RelativeLayout
  implements View.OnClickListener, AudioPanelCallback, QQRecorder.OnQQRecorderListener
{
  public double a;
  int jdField_a_of_type_Int = 0;
  public Handler a;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private MediaPlayerManager jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager;
  private VolumeIndicateSquareView jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  public BaseActivity a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private QQRecorder jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder;
  private String jdField_a_of_type_JavaLangString = "common record panel";
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private Handler jdField_b_of_type_AndroidOsHandler = new upk(this, Looper.getMainLooper());
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private VolumeIndicateSquareView jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView;
  private int c;
  private int d;
  private int e = 180000;
  
  public CommonRecordSoundPanel(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonRecordSoundPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public double a()
  {
    return this.jdField_a_of_type_Double;
  }
  
  public int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderStart() is called");
    }
    this.c = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    this.jdField_b_of_type_AndroidOsHandler.post(new upr(this));
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 2000L);
    this.jdField_a_of_type_Boolean = true;
    return 250;
  }
  
  public int a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBeginReceiveData() is called");
    }
    return c();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitSuccess() is called");
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Handler paramHandler)
  {
    a(paramQQAppInterface, paramBaseActivity, paramHandler, 0, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Handler paramHandler, int paramInt)
  {
    a(paramQQAppInterface, paramBaseActivity, paramHandler, paramInt, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, Handler paramHandler, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager = MediaPlayerManager.a(paramQQAppInterface);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366444));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131366445));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131363125));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)findViewById(2131366436));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)findViewById(2131366438));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366448));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366449));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (paramBoolean) {
      ThreadManager.getUIHandler().postDelayed(new upn(this), 100L);
    }
  }
  
  public void a(QQRecorder.OnQQRecorderListener paramOnQQRecorderListener)
  {
    if (this.jdField_b_of_type_AndroidOsHandler != null)
    {
      if (this.jdField_b_of_type_AndroidOsHandler.hasMessages(16711688)) {
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711688);
      }
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711687);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(128);
    setRequestedOrientation4Recording(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioMediaPlayerManager.a(true);
    Object localObject = new Intent();
    ((Intent)localObject).setAction("com.tencent.mobileqq.activity.ai.audiopanel.startrecord_action");
    ((Intent)localObject).setPackage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getPackageName());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startRecord() is called");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder == null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder = new QQRecorder(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    QQRecorder.RecorderParam localRecorderParam;
    if (this.jdField_b_of_type_Int == 0) {
      localRecorderParam = new QQRecorder.RecorderParam(RecordParams.jdField_a_of_type_Int, 0, 0);
    }
    for (localObject = BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, 2, null);; localObject = BuddyTransfileProcessor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, 25, null))
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(localRecorderParam);
      if (QLog.isColorLevel()) {
        QLog.i("QQRecorder", 2, "path: " + (String)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(paramOnQQRecorderListener);
      AudioUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, true);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a((String)localObject);
      return;
      localRecorderParam = new QQRecorder.RecorderParam(RecordParams.jdField_b_of_type_Int, 16000, 1);
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderNotReady() is called,path is:" + paramString);
    }
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderPrepare() is called");
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new upp(this));
    a(paramString, true, paramRecorderParam);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    if (this.c < 1200) {
      this.jdField_b_of_type_AndroidOsHandler.post(new upl(this, paramString));
    }
    int i;
    do
    {
      return;
      i = b();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "fateOfRecorder is:" + i);
      }
      if (i == 102)
      {
        PttBuffer.b(paramString);
        paramRecorderParam = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(102);
        paramRecorderParam.obj = paramString;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramRecorderParam);
        return;
      }
    } while (i != 1);
    PttBuffer.a(paramString);
    this.jdField_b_of_type_AndroidOsHandler.post(new upm(this, paramString));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderError() is called,path is:" + paramString1);
    }
    PttBuffer.a(paramString1);
    b(paramString1);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_b_of_type_AndroidOsHandler.post(new upt(this));
  }
  
  public void a(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "onRecorderPerpare path = " + paramString);
    }
    paramRecorderParam = RecordParams.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    PttBuffer.a(paramString);
    PttBuffer.a(paramString, paramRecorderParam, paramRecorderParam.length);
    AudioUtil.b(2131230744, false);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    PttBuffer.a(paramString, paramArrayOfByte, paramInt1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new upo(this, paramInt2, paramDouble));
    this.c = ((int)paramDouble);
  }
  
  public boolean a()
  {
    boolean bool1 = false;
    boolean bool2 = b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + bool2);
    }
    if (bool2)
    {
      b(102);
      bool1 = true;
    }
    return bool1;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset() is called");
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842179);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("开始录音");
    this.jdField_b_of_type_AndroidWidgetTextView.setText(AudioPanel.a(0.0D));
    if ((this.jdField_a_of_type_AndroidWidgetPopupWindow == null) || (this.jdField_a_of_type_AndroidWidgetPopupWindow.isShowing())) {}
    try
    {
      this.jdField_a_of_type_AndroidWidgetPopupWindow.dismiss();
      this.jdField_a_of_type_AndroidWidgetPopupWindow = null;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (this.jdField_a_of_type_AndroidViewView.getParent() != null) {
          ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
        }
        this.jdField_a_of_type_AndroidViewView = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset(),dismiss topMaskPanel caused exception,it is no matter.", localException);
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (!this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b()) && (!this.jdField_b_of_type_AndroidOsHandler.hasMessages(16711686)))
    {
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711688);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711686);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(16711687);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stopRecord() is called,time is:" + System.currentTimeMillis());
      }
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null)
      {
        Message localMessage = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(16711686);
        this.jdField_b_of_type_AndroidOsHandler.sendMessageDelayed(localMessage, 200L);
      }
    }
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new upq(this));
  }
  
  public void b(String paramString, QQRecorder.RecorderParam paramRecorderParam) {}
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a());
  }
  
  public int c()
  {
    this.e -= 200;
    this.jdField_b_of_type_AndroidOsHandler.sendEmptyMessageDelayed(16711687, this.e);
    return this.e + 200;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void c(int paramInt)
  {
    paramInt /= 1180;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a(paramInt);
  }
  
  public void c(String paramString)
  {
    setRequestedOrientation4Recording(true);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
  }
  
  public void c(String paramString, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new ups(this));
  }
  
  public void d()
  {
    boolean bool = b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + bool);
    }
    if (bool) {
      b(102);
    }
  }
  
  public void e()
  {
    boolean bool = b();
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + bool);
    }
    if (bool) {
      b(1);
    }
  }
  
  public void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView != null) && (this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView.a();
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
    if (i == 2131366449)
    {
      boolean bool = b();
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool);
      }
      if (bool) {
        b(102);
      }
    }
    else
    {
      return;
    }
    paramView = Environment.getExternalStorageDirectory();
    label115:
    int j;
    if ((paramView.exists()) && (paramView.canWrite()))
    {
      i = 1;
      if ((!Environment.getExternalStorageState().equals("mounted")) || (i == 0)) {
        break label213;
      }
      i = 1;
      j = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight();
      if (i == 0) {
        break label298;
      }
      if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1) {
        break label280;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
        break label218;
      }
      QQToast.a(BaseApplication.getContext(), 2131433788, 0).a();
    }
    label280:
    label298:
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
      return;
      i = 0;
      break;
      label213:
      i = 0;
      break label115;
      label218:
      if (AudioHelper.b(1))
      {
        ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842178);
        this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("ֹͣ停止录音");
        a(this);
        setFateOfRecorder(102);
        getWindowVisibleDisplayFrame(new Rect());
        continue;
        QQToast.a(BaseApplication.getContext(), 2131433438, 0).b(j);
        continue;
        QQToast.a(BaseApplication.getContext(), 2131433437, 0).b(j);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    super.onTouchEvent(paramMotionEvent);
    return b();
  }
  
  public void setFateOfRecorder(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @TargetApi(13)
  public void setRequestedOrientation4Recording(boolean paramBoolean)
  {
    int i = 0;
    int j = 1;
    if (!paramBoolean)
    {
      this.d = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getRequestedOrientation();
      int k = getResources().getConfiguration().orientation;
      Object localObject;
      if (!VersionUtils.b()) {
        if (k == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          i = j;
          if (VersionUtils.c()) {
            i = 7;
          }
          ((BaseActivity)localObject).setRequestedOrientation(i);
        }
      }
      label66:
      do
      {
        do
        {
          do
          {
            break label66;
            do
            {
              return;
            } while (k != 2);
            localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
            if (VersionUtils.c()) {}
            for (i = 6;; i = 0)
            {
              ((BaseActivity)localObject).setRequestedOrientation(i);
              return;
            }
            if (VersionUtils.f())
            {
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay();
              j = ((Display)localObject).getRotation();
              Point localPoint = new Point();
              ((Display)localObject).getSize(localPoint);
              if ((j == 0) || (j == 2)) {
                if (localPoint.x > localPoint.y) {
                  if (j != 0) {}
                }
              }
              for (;;)
              {
                this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(i);
                return;
                i = 8;
                continue;
                if (j == 0)
                {
                  i = 1;
                }
                else
                {
                  i = 9;
                  continue;
                  if (localPoint.x > localPoint.y)
                  {
                    if (j != 1) {
                      i = 8;
                    }
                  }
                  else if (j == 1) {
                    i = 9;
                  } else {
                    i = 1;
                  }
                }
              }
            }
            i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay().getRotation();
            if ((i != 0) && (i != 1)) {
              break;
            }
            if (k == 1)
            {
              this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(1);
              return;
            }
          } while (k != 2);
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(0);
          return;
        } while ((i != 2) && (i != 3));
        if (k == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(9);
          return;
        }
      } while (k != 2);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.setRequestedOrientation(this.d);
  }
  
  public void setTimeOutTime(int paramInt)
  {
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel
 * JD-Core Version:    0.7.0.1
 */