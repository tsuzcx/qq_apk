package com.tencent.mobileqq.activity.aio.audiopanel;

import adbf;
import adbh;
import adbi;
import ajya;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
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
import avbt;
import axqy;
import ayph;
import bbcf;
import bbiy;
import bbjg;
import bbvj;
import bcql;
import bfnz;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import mqq.os.MqqHandler;

public class CommonRecordSoundPanel
  extends RelativeLayout
  implements adbf, View.OnClickListener, bbiy
{
  protected double a;
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
  private Handler jdField_b_of_type_AndroidOsHandler = new adbh(this, Looper.getMainLooper());
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
    this.jdField_b_of_type_AndroidOsHandler.post(new CommonRecordSoundPanel.7(this));
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
  
  public void a(bbiy parambbiy)
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
    String str;
    if (this.jdField_b_of_type_Int == 0)
    {
      localObject = new QQRecorder.RecorderParam(bbjg.jdField_a_of_type_Int, 0, 0);
      str = ayph.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, 2, null);
    }
    for (;;)
    {
      str = bbvj.a(str);
      File localFile = new File(str);
      localFile.getParentFile().mkdirs();
      try
      {
        localFile.createNewFile();
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a((QQRecorder.RecorderParam)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("QQRecorder", 2, "path: " + str);
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.a(parambbiy);
        bbcf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, true);
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder.b(str);
        return;
        localObject = new QQRecorder.RecorderParam(bbjg.jdField_b_of_type_Int, 16000, 1);
        str = ayph.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, 25, null);
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("AIOAudioPanel", 2, "recorderInit, createNewFile cause exception", localIOException);
          }
        }
      }
    }
  }
  
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371901));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376441));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131368077));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)findViewById(2131368079));
    this.jdField_b_of_type_ComTencentMobileqqActivityAioAudiopanelVolumeIndicateSquareView = ((VolumeIndicateSquareView)findViewById(2131368080));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375006));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374999));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    if (paramBoolean) {
      ThreadManager.getUIHandler().postDelayed(new CommonRecordSoundPanel.2(this), 100L);
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
    this.jdField_b_of_type_AndroidOsHandler.post(new CommonRecordSoundPanel.4(this));
    a(paramString, true, paramRecorderParam);
  }
  
  public void a(String paramString, QQRecorder.RecorderParam paramRecorderParam, double paramDouble)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + paramString);
    }
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    if (this.c < 1200) {
      this.jdField_b_of_type_AndroidOsHandler.post(new CommonRecordSoundPanel.10(this, paramString));
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
        avbt.b(paramString);
        paramRecorderParam = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(102);
        paramRecorderParam.obj = paramString;
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramRecorderParam);
        return;
      }
    } while (i != 1);
    avbt.a(paramString);
    this.jdField_b_of_type_AndroidOsHandler.post(new CommonRecordSoundPanel.11(this, paramString));
  }
  
  public void a(String paramString1, QQRecorder.RecorderParam paramRecorderParam, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderError() is called,path is:" + paramString1);
    }
    avbt.a(paramString1);
    b(paramString1);
    this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_b_of_type_AndroidOsHandler.post(new CommonRecordSoundPanel.9(this));
  }
  
  public void a(String paramString, boolean paramBoolean, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQRecorder", 2, "onRecorderPerpare path = " + paramString);
    }
    paramRecorderParam = bbjg.a(paramRecorderParam.c, paramRecorderParam.jdField_a_of_type_Int);
    avbt.a(paramString);
    avbt.a(paramString, paramRecorderParam, paramRecorderParam.length);
    bbcf.b(2131230745, false);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, double paramDouble, QQRecorder.RecorderParam paramRecorderParam)
  {
    avbt.a(paramString, paramArrayOfByte, paramInt1);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(1);
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new CommonRecordSoundPanel.3(this, paramInt2, paramDouble));
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843957);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131702244));
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
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new CommonRecordSoundPanel.5(this));
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
    this.jdField_b_of_type_AndroidOsHandler.post(new CommonRecordSoundPanel.8(this));
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
    boolean bool2;
    boolean bool1;
    if (i == 2131374999)
    {
      bool2 = b();
      if ((Build.VERSION.SDK_INT < 23) || (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null)) {
        break label378;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
        break label118;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOAudioPanel", 2, "isRecording is:" + bool2 + " hasPermission is:" + bool1);
      }
      if (bool2)
      {
        b(102);
        return;
        label118:
        bool1 = false;
      }
      else
      {
        if ((!bool1) && (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new adbi(this), 1, new String[] { "android.permission.RECORD_AUDIO" });
          b(102);
          return;
        }
        bool1 = Environment.getExternalStorageState().equals("mounted");
        if (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null)
        {
          i = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight();
          if (!bool1) {
            break label360;
          }
          if (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() <= 1) {
            break label342;
          }
          if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()) {
            break label277;
          }
          bcql.a(BaseApplication.getContext(), 2131695522, 0).a();
        }
        for (;;)
        {
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
          return;
          label277:
          if (AudioHelper.b(1))
          {
            ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
          }
          else
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843955);
            this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(ajya.a(2131702245));
            a(this);
            setFateOfRecorder(102);
            getWindowVisibleDisplayFrame(new Rect());
            continue;
            label342:
            bcql.a(BaseApplication.getContext(), 2131719060, 0).b(i);
            continue;
            label360:
            bcql.a(BaseApplication.getContext(), 2131694694, 0).b(i);
          }
        }
        label378:
        bool1 = true;
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
      if (!bfnz.b()) {
        if (k == 1)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
          i = j;
          if (bfnz.c()) {
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
            if (bfnz.c()) {}
            for (i = 6;; i = 0)
            {
              ((BaseActivity)localObject).setRequestedOrientation(i);
              return;
            }
            if (bfnz.f())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel
 * JD-Core Version:    0.7.0.1
 */