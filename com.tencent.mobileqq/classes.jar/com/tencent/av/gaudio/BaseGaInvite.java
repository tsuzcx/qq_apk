package com.tencent.av.gaudio;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.UITools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Timer;
import java.util.TimerTask;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(AudioHelper.b());
    this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
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
      float f = paramVideoAppInterface.getApp().getResources().getDimensionPixelSize(2131297441);
      str = UITools.a(paramVideoAppInterface.getApp(), paramString1, paramTextView, f);
    }
    paramTextView = paramVideoAppInterface.getApp().getString(2131695510);
    int i = paramVideoAppInterface.a(paramInt, paramString2);
    paramInt = i;
    if (i == 0) {
      if (paramArrayOfLong != null) {
        paramInt = paramArrayOfLong.length + 1;
      } else {
        paramInt = 1;
      }
    }
    paramVideoAppInterface = String.format(paramTextView, new Object[] { Integer.valueOf(paramInt) });
    paramTextView = new StringBuilder();
    paramTextView.append(str);
    paramTextView.append(paramVideoAppInterface);
    return paramTextView.toString();
  }
  
  public String a(int paramInt, long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = getApplicationContext();
    Object localObject1 = SessionMgr.a(paramInt, String.valueOf(paramLong), new int[0]);
    localObject1 = SessionMgr.a().c((String)localObject1);
    int i;
    if ((localObject1 != null) && (((SessionInfo)localObject1).W == 4)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      localObject2 = ((Context)localObject2).getString(2131695651);
      ScreenShareReportHelper.a(((SessionInfo)localObject1).jdField_b_of_type_JavaLangString, 1, "getGInviteWording");
    }
    else
    {
      i = 2131695669;
      float f;
      if (paramBoolean2)
      {
        f = ((Context)localObject2).getResources().getDimensionPixelSize(2131297873);
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), null);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = UITools.a((Context)localObject2, (String)localObject1, this.jdField_a_of_type_AndroidWidgetTextView, f);
        } else {
          paramString = "";
        }
        localObject2 = ((Context)localObject2).getResources();
        if (!paramBoolean1) {
          i = 2131695671;
        }
        localObject2 = String.format(((Resources)localObject2).getString(i), new Object[] { paramString });
        paramString = (String)localObject1;
      }
      else
      {
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Int, String.valueOf(this.jdField_a_of_type_Long), null);
        }
        f = ((Context)localObject2).getResources().getDimensionPixelSize(2131297162);
        paramString = UITools.a((Context)localObject2, (String)localObject1, this.jdField_a_of_type_AndroidWidgetTextView, f);
        localObject2 = ((Context)localObject2).getResources();
        if (!paramBoolean1) {
          i = 2131695671;
        }
        localObject2 = String.format(((Resources)localObject2).getString(i), new Object[] { paramString });
        paramString = (String)localObject1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getGInviteWording, relationType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], groupId[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], groupName[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], isOnlyAudio[");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("], fromMultiCall[");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("], inviteHintStr[");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("]");
      QLog.i((String)localObject1, 2, localStringBuilder.toString());
    }
    return localObject2;
  }
  
  protected void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    localObject = this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$TimerHandler;
    if (localObject != null)
    {
      ((BaseGaInvite.TimerHandler)localObject).removeMessages(0);
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$TimerHandler = null;
    }
  }
  
  protected void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer(true);
    localObject = new BaseGaInvite.ToolBarTask(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule((TimerTask)localObject, paramInt);
  }
  
  public void a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    AudioHelper.a(this.jdField_b_of_type_JavaLangString, paramIntent.getExtras());
    this.jdField_a_of_type_Int = paramIntent.getIntExtra("uinType", 0);
    this.jdField_a_of_type_Long = paramIntent.getLongExtra("discussId", 0L);
    this.jdField_b_of_type_Long = paramIntent.getLongExtra("friendUin", 0L);
    this.jdField_b_of_type_Int = paramIntent.getIntExtra("relationType", this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ArrayOfLong = paramIntent.getLongArrayExtra("memberList");
    int i = UITools.c(this.jdField_b_of_type_Int);
    if (i != this.jdField_a_of_type_Int)
    {
      paramIntent = this.jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processIntent, mUinType与mRelationType不匹配，mRelationType[");
      localStringBuilder.append(this.jdField_b_of_type_Int);
      localStringBuilder.append("], uinTpye[");
      localStringBuilder.append(i);
      localStringBuilder.append("], mUinType[");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      localStringBuilder.append("]");
      QLog.w(paramIntent, 1, localStringBuilder.toString());
    }
  }
  
  public void a(String paramString)
  {
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("from:");
    localStringBuilder.append(paramString);
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable == null)
    {
      a(null, 2);
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        str = Long.toString(this.jdField_b_of_type_Long);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      }
      else
      {
        str = this.jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshUI[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], mCallersName为空");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = new BaseGaInvite.GetGaFaceRunnable(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Long, this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable$OnGetSink);
    }
    this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable.a(paramString);
  }
  
  boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_b_of_type_JavaLangString, 2, "initEnvParam");
    }
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface != null)
    {
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      if (localVideoController != null)
      {
        if ((localVideoController.a().m()) || (this.jdField_a_of_type_ComTencentAvVideoController.a().n()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_b_of_type_JavaLangString, 2, "initEnvParam closeSession");
          }
          localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
          localVideoController.b(localVideoController.a().c, 2);
        }
        return true;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    if (paramInt != 1) {
      return paramInt == 3000;
    }
    return true;
  }
  
  public boolean a(Bitmap paramBitmap, int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateAvatar, from = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", headView = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidWidgetImageView);
      ((StringBuilder)localObject).append(", bitmap = ");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.i("QavAvatarHelper", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetImageView;
    if (localObject == null) {
      return false;
    }
    if ((paramInt != 2) && (paramInt != 3) && (paramInt != 5))
    {
      if (paramBitmap != null) {
        ((ImageView)localObject).setImageBitmap(paramBitmap);
      }
    }
    else {
      ((ImageView)localObject).setImageResource(2130839335);
    }
    return true;
  }
  
  public abstract void b();
  
  public boolean b()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 1) {
      return i == 3000;
    }
    return true;
  }
  
  public boolean c()
  {
    if ((Build.VERSION.SDK_INT >= 17) && (super.isDestroyed())) {
      return true;
    }
    return isFinishing();
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
    BaseGaInvite.GetGaFaceRunnable localGetGaFaceRunnable = this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable;
    if (localGetGaFaceRunnable != null)
    {
      localGetGaFaceRunnable.a();
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)getAppRuntime());
    this.jdField_a_of_type_ComTencentAvVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    a();
  }
  
  protected void onDestroy()
  {
    QLog.w(this.jdField_b_of_type_JavaLangString, 1, "onDestroy");
    super.onDestroy();
    a();
    BaseGaInvite.GetGaFaceRunnable localGetGaFaceRunnable = this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable;
    if (localGetGaFaceRunnable != null)
    {
      localGetGaFaceRunnable.a();
      this.jdField_a_of_type_ComTencentAvGaudioBaseGaInvite$GetGaFaceRunnable = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.BaseGaInvite
 * JD-Core Version:    0.7.0.1
 */