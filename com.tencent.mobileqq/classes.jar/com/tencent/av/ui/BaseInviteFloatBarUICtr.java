package com.tencent.av.ui;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.compat.VibratorCompactUtil;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable;
import com.tencent.av.gaudio.BaseGaInvite.GetGaFaceRunnable.OnGetSink;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BaseInviteFloatBarUICtr
{
  public static int a = 6000;
  final String b;
  VideoAppInterface c = null;
  long d = 0L;
  String e = null;
  Bitmap f = null;
  int g = 0;
  int h = 0;
  long i = 0L;
  long[] j = null;
  boolean k = false;
  SessionInfo l = null;
  String m = null;
  String n = null;
  VideoInviteFloatBar o;
  BaseGaInvite.GetGaFaceRunnable p = null;
  BaseGaInvite.GetGaFaceRunnable.OnGetSink q = new BaseInviteFloatBarUICtr.1(this);
  Runnable r = new BaseInviteFloatBarUICtr.2(this);
  
  public BaseInviteFloatBarUICtr()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("_");
    localStringBuilder.append(AudioHelper.c());
    this.b = localStringBuilder.toString();
  }
  
  public void a()
  {
    QLog.d(this.b, 1, "onDestroy");
    Object localObject = this.p;
    if (localObject != null) {
      ((BaseGaInvite.GetGaFaceRunnable)localObject).a();
    }
    localObject = this.o;
    if (localObject != null)
    {
      ((VideoInviteFloatBar)localObject).a();
      this.o = null;
    }
    b();
  }
  
  public void a(String paramString)
  {
    String str = String.valueOf(this.d);
    Object localObject = this.o;
    if (localObject != null) {
      localObject = ((VideoInviteFloatBar)localObject).d();
    } else {
      localObject = null;
    }
    this.e = BaseGaInvite.a(this.c, (TextView)localObject, this.g, this.h, str, this.j);
    this.f = this.c.a(this.g, str, null, true, false);
    if (this.p == null) {
      this.p = new BaseGaInvite.GetGaFaceRunnable(this.b, this.c, this.g, this.h, this.d, this.i, this.q);
    }
    this.p.a(paramString);
  }
  
  void a(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refreshUI, isMultiCall[");
      ((StringBuilder)localObject2).append(AVUtil.e(this.g));
      ((StringBuilder)localObject2).append("], multiIncomingCall[");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append("], mUinType[");
      ((StringBuilder)localObject2).append(this.g);
      ((StringBuilder)localObject2).append("], mIsAudioMode[");
      ((StringBuilder)localObject2).append(this.k);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = this.m;
    int i2 = this.g;
    if (AVUtil.e(i2))
    {
      a("refreshUI");
    }
    else
    {
      SessionInfo localSessionInfo = this.l;
      localObject1 = localObject2;
      int i1 = i2;
      if (localSessionInfo != null)
      {
        localObject1 = localObject2;
        i1 = i2;
        if (localSessionInfo.az == 1)
        {
          localObject1 = localObject2;
          i1 = i2;
          if (this.g == 9500)
          {
            localObject1 = localObject2;
            i1 = i2;
            if (!TextUtils.isEmpty(this.l.aB))
            {
              localObject1 = this.l.aB;
              i1 = 0;
            }
          }
        }
      }
      this.f = this.c.a(i1, (String)localObject1, this.n, true, true);
      this.e = this.c.a(i1, (String)localObject1, this.n);
      if ((this.g == 25) && (this.e.equals(this.m)))
      {
        localObject1 = this.l;
        if (localObject1 != null) {
          this.e = ((SessionInfo)localObject1).w;
        }
        if (QLog.isColorLevel())
        {
          localObject1 = this.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("refreshUI mPeerName = ");
          ((StringBuilder)localObject2).append(this.e);
          QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    if (this.o == null)
    {
      this.o = new VideoInviteFloatBar(this.c.getApp().getApplicationContext());
      this.o.a(this.f, this.e);
      localObject1 = new Date();
      localObject1 = new SimpleDateFormat("HH:mm").format((Date)localObject1);
      this.o.b((String)localObject1);
      this.o.a(this.k, AVUtil.e(this.g), paramBoolean);
      if (AVUtil.e(this.g)) {
        this.c.a().postDelayed(this.r, a);
      }
    }
    VibratorCompactUtil.a(this.c.getApplication(), 200L);
  }
  
  void b()
  {
    if (this.r != null)
    {
      this.c.a().removeCallbacks(this.r);
      this.r = null;
    }
  }
  
  abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.BaseInviteFloatBarUICtr
 * JD-Core Version:    0.7.0.1
 */