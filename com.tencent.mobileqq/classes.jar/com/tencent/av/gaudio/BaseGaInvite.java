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
  public int a = 0;
  public long b = 0L;
  public long c = 0L;
  public int d = 0;
  public VideoAppInterface e = null;
  public VideoController f = null;
  public String g = null;
  public TextView h = null;
  long[] i = null;
  public ImageView j = null;
  public TextView k = null;
  public final String l;
  Timer m = null;
  BaseGaInvite.TimerHandler n = new BaseGaInvite.TimerHandler(this);
  BaseGaInvite.GetGaFaceRunnable.OnGetSink o = new BaseGaInvite.1(this);
  BaseGaInvite.GetGaFaceRunnable p = null;
  
  public BaseGaInvite()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(AudioHelper.c());
    this.l = localStringBuilder.toString();
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
      float f1 = paramVideoAppInterface.getApp().getResources().getDimensionPixelSize(2131298092);
      str = UITools.a(paramVideoAppInterface.getApp(), paramString1, paramTextView, f1);
    }
    paramTextView = paramVideoAppInterface.getApp().getString(2131893269);
    int i1 = paramVideoAppInterface.d(paramInt, paramString2);
    paramInt = i1;
    if (i1 == 0) {
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
    localObject1 = SessionMgr.a().d((String)localObject1);
    int i1;
    if ((localObject1 != null) && (((SessionInfo)localObject1).ci == 4)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      localObject2 = ((Context)localObject2).getString(2131893410);
      ScreenShareReportHelper.a(((SessionInfo)localObject1).f, 1, "getGInviteWording");
    }
    else
    {
      i1 = 2131893428;
      float f1;
      if (paramBoolean2)
      {
        f1 = ((Context)localObject2).getResources().getDimensionPixelSize(2131298543);
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject1 = this.e.a(this.a, String.valueOf(this.b), null);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          paramString = UITools.a((Context)localObject2, (String)localObject1, this.h, f1);
        } else {
          paramString = "";
        }
        localObject2 = ((Context)localObject2).getResources();
        if (!paramBoolean1) {
          i1 = 2131893430;
        }
        localObject2 = String.format(((Resources)localObject2).getString(i1), new Object[] { paramString });
        paramString = (String)localObject1;
      }
      else
      {
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject1 = this.e.a(this.a, String.valueOf(this.b), null);
        }
        f1 = ((Context)localObject2).getResources().getDimensionPixelSize(2131297547);
        paramString = UITools.a((Context)localObject2, (String)localObject1, this.h, f1);
        localObject2 = ((Context)localObject2).getResources();
        if (!paramBoolean1) {
          i1 = 2131893430;
        }
        localObject2 = String.format(((Resources)localObject2).getString(i1), new Object[] { paramString });
        paramString = (String)localObject1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = this.l;
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
  
  public void a(String paramString)
  {
    String str = this.l;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("from:");
    localStringBuilder.append(paramString);
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.p == null)
    {
      a(null, 2);
      if (this.k != null)
      {
        str = Long.toString(this.c);
        this.k.setText(str);
      }
      else
      {
        str = this.l;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("refreshUI[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], mCallersName为空");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.p = new BaseGaInvite.GetGaFaceRunnable(this.l, this.e, this.a, this.d, this.b, this.c, this.o);
    }
    this.p.a(paramString);
  }
  
  boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.l, 2, "initEnvParam");
    }
    if (this.e != null)
    {
      VideoController localVideoController = this.f;
      if (localVideoController != null)
      {
        if ((localVideoController.k().m()) || (this.f.k().n()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.l, 2, "initEnvParam closeSession");
          }
          localVideoController = this.f;
          localVideoController.b(localVideoController.k().s, 2);
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
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append(", bitmap = ");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.i("QavAvatarHelper", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.j;
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
      ((ImageView)localObject).setImageResource(2130839517);
    }
    return true;
  }
  
  protected void b(int paramInt)
  {
    Object localObject = this.m;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    this.m = new Timer(true);
    localObject = new BaseGaInvite.ToolBarTask(this);
    this.m.schedule((TimerTask)localObject, paramInt);
  }
  
  public void b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    AudioHelper.a(this.l, paramIntent.getExtras());
    this.a = paramIntent.getIntExtra("uinType", 0);
    this.b = paramIntent.getLongExtra("discussId", 0L);
    this.c = paramIntent.getLongExtra("friendUin", 0L);
    this.d = paramIntent.getIntExtra("relationType", this.d);
    this.i = paramIntent.getLongArrayExtra("memberList");
    int i1 = UITools.c(this.d);
    if (i1 != this.a)
    {
      paramIntent = this.l;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("processIntent, mUinType与mRelationType不匹配，mRelationType[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("], uinTpye[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], mUinType[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.w(paramIntent, 1, localStringBuilder.toString());
    }
  }
  
  public boolean b()
  {
    int i1 = this.a;
    if (i1 != 1) {
      return i1 == 3000;
    }
    return true;
  }
  
  protected void c()
  {
    Object localObject = this.m;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.m = null;
    }
    localObject = this.n;
    if (localObject != null)
    {
      ((BaseGaInvite.TimerHandler)localObject).removeMessages(0);
      this.n = null;
    }
  }
  
  public abstract void d();
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean e()
  {
    if ((Build.VERSION.SDK_INT >= 17) && (super.isDestroyed())) {
      return true;
    }
    return isFinishing();
  }
  
  public void finish()
  {
    QLog.w(this.l, 1, "finish", new Throwable("打印调用栈"));
    c();
    BaseGaInvite.GetGaFaceRunnable localGetGaFaceRunnable = this.p;
    if (localGetGaFaceRunnable != null)
    {
      localGetGaFaceRunnable.a();
      this.p = null;
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
    this.e = ((VideoAppInterface)getAppRuntime());
    this.f = this.e.b();
    a();
  }
  
  protected void onDestroy()
  {
    QLog.w(this.l, 1, "onDestroy");
    super.onDestroy();
    c();
    BaseGaInvite.GetGaFaceRunnable localGetGaFaceRunnable = this.p;
    if (localGetGaFaceRunnable != null)
    {
      localGetGaFaceRunnable.a();
      this.p = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.BaseGaInvite
 * JD-Core Version:    0.7.0.1
 */