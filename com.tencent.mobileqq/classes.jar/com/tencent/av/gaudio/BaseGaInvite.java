package com.tencent.av.gaudio;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Timer;
import mqq.app.BaseActivity;

public abstract class BaseGaInvite
  extends BaseActivity
{
  public int a;
  public long a;
  public ImageView a;
  public TextView a;
  public VideoController a;
  public VideoAppInterface a;
  BaseGaInvite.GetGaFaceRunnable.OnGetSink jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$OnGetSink = new BaseGaInvite.1(this);
  BaseGaInvite.GetGaFaceRunnable jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
  BaseGaInvite.TimerHandler jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$TimerHandler = new BaseGaInvite.TimerHandler(this);
  public String a;
  Timer jdField_a_of_type_JavaUtilTimer = null;
  long[] jdField_a_of_type_ArrayOfLong = null;
  public int b;
  public long b;
  public TextView b;
  public final String b;
  
  public BaseGaInvite()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
    this.jdField_a_of_type_ComTencentAvVideoController = null;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetImageView = null;
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_b_of_type_JavaLangString = (getClass().getSimpleName() + "_" + AudioHelper.b());
  }
  
  public static Intent a(Intent paramIntent, String paramString)
  {
    return paramIntent.putExtra("_from", paramString);
  }
  
  public static String a(Intent paramIntent)
  {
    return paramIntent.getStringExtra("_from");
  }
  
  public static String a(VideoAppInterface paramVideoAppInterface, TextView paramTextView, int paramInt1, int paramInt2, String paramString, long[] paramArrayOfLong)
  {
    return a(paramVideoAppInterface, paramTextView, paramVideoAppInterface.a(paramInt1, paramString, null), paramInt2, paramString, paramArrayOfLong);
  }
  
  public static String a(VideoAppInterface paramVideoAppInterface, TextView paramTextView, String paramString1, int paramInt, String paramString2, long[] paramArrayOfLong)
  {
    String str = paramString1;
    if (paramTextView != null)
    {
      float f = paramVideoAppInterface.getApp().getResources().getDimensionPixelSize(2131297452);
      str = UITools.a(paramVideoAppInterface.getApp(), paramString1, paramTextView, f);
    }
    paramTextView = paramVideoAppInterface.getApp().getString(2131695499);
    int i = paramVideoAppInterface.a(paramInt, paramString2);
    paramInt = i;
    if (i == 0) {
      if (paramArrayOfLong == null) {
        break label109;
      }
    }
    label109:
    for (paramInt = paramArrayOfLong.length + 1;; paramInt = 1)
    {
      paramVideoAppInterface = String.format(paramTextView, new Object[] { Integer.valueOf(paramInt) });
      return str + paramVideoAppInterface;
    }
  }
  
  public String a(int paramInt, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Context localContext = getApplicationContext();
    Object localObject1 = SessionMgr.a(paramInt, String.valueOf(paramLong), new int[0]);
    localObject1 = SessionMgr.a().c((String)localObject1);
    int i = 0;
    if (localObject1 != null) {
      if (((SessionInfo)localObject1).ad != 4) {
        break label172;
      }
    }
    label172:
    for (i = 1; i != 0; i = 0)
    {
      localObject2 = localContext.getString(2131695637);
      ScreenShareReportHelper.a(((SessionInfo)localObject1).c, 1, "getGInviteWording");
      localObject1 = paramString;
      paramString = (String)localObject2;
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_b_of_type_JavaLangString, 2, "getGInviteWording, relationType[" + paramInt + "], groupId[" + paramInt + "], groupName[" + (String)localObject1 + "], isOnlyAudio[" + paramBoolean1 + "], fromMultiCall[" + paramBoolean2 + "], inviteHintStr[" + paramString + "]");
      }
      return paramString;
    }
    if (paramBoolean2)
    {
      f = localContext.getResources().getDimensionPixelSize(2131297879);
      localObject2 = "";
      localObject1 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), null);
      }
      paramString = (String)localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramString = UITools.a(localContext, (String)localObject1, this.jdField_a_of_type_AndroidWidgetTextView, f);
      }
      localObject2 = localContext.getResources();
      if (paramBoolean1) {}
      for (i = 2131695655;; i = 2131695657)
      {
        paramString = String.format(((Resources)localObject2).getString(i), new Object[] { paramString });
        break;
      }
    }
    localObject1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), null);
    }
    float f = localContext.getResources().getDimensionPixelSize(2131297180);
    paramString = UITools.a(localContext, (String)localObject1, this.jdField_a_of_type_AndroidWidgetTextView, f);
    Object localObject2 = localContext.getResources();
    if (paramBoolean1) {}
    for (i = 2131695655;; i = 2131695657)
    {
      paramString = String.format(((Resources)localObject2).getString(i), new Object[] { paramString });
      break;
    }
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$TimerHandler != null)
    {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$TimerHandler.removeMessages(0);
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$TimerHandler = null;
    }
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer(true);
    BaseGaInvite.ToolBarTask localToolBarTask = new BaseGaInvite.ToolBarTask(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(localToolBarTask, paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {}
    int i;
    do
    {
      return;
      AudioHelper.a(this.jdField_b_of_type_JavaLangString, paramIntent.getExtras());
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("uinType", 0);
      this.jdField_a_of_type_Long = paramIntent.getLongExtra("discussId", 0L);
      this.jdField_b_of_type_Long = paramIntent.getLongExtra("friendUin", 0L);
      this.jdField_b_of_type_Int = paramIntent.getIntExtra("relationType", this.jdField_b_of_type_Int);
      this.jdField_a_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
      i = UITools.c(this.jdField_b_of_type_Int);
    } while (i == this.jdField_a_of_type_Int);
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "processIntent, mUinType与mRelationType不匹配，mRelationType[" + this.jdField_b_of_type_Int + "], uinTpye[" + i + "], mUinType[" + this.jdField_a_of_type_Int + "]");
  }
  
  public void a(String paramString)
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "from:" + paramString);
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable == null)
    {
      if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
        break label123;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839479);
      if (this.jdField_b_of_type_AndroidWidgetTextView == null) {
        break label160;
      }
      String str = Long.toString(this.jdField_b_of_type_Long);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = new BaseGaInvite.GetGaFaceRunnable(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$OnGetSink);
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.a(paramString);
      return;
      label123:
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "refreshUI[" + paramString + "], mHeadImage为空");
      break;
      label160:
      QLog.w(this.jdField_b_of_type_JavaLangString, 1, "refreshUI[" + paramString + "], mCallersName为空");
    }
  }
  
  boolean a()
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "initEnvParam");
    }
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        if ((this.jdField_a_of_type_ComTencentAvVideoController.a().o()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().p()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "initEnvParam closeSession");
          }
          this.jdField_a_of_type_ComTencentAvVideoController.b(this.jdField_a_of_type_ComTencentAvVideoController.a().d, 2);
        }
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 3000);
  }
  
  public abstract void b();
  
  public boolean b()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3000);
  }
  
  public boolean c()
  {
    if ((Build.VERSION.SDK_INT >= 17) && (super.isDestroyed())) {}
    while (isFinishing()) {
      return true;
    }
    return false;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void finish()
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "finish", new Throwable("打印调用栈"));
    a();
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.a();
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
    }
    super.finish();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    a();
  }
  
  public void onDestroy()
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onDestroy");
    super.onDestroy();
    a();
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable != null)
    {
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.a();
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.BaseGaInvite
 * JD-Core Version:    0.7.0.1
 */