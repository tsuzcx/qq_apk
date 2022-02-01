package com.tencent.av.ui;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.opengl.effects.EGLScreenCaptureThread;
import com.tencent.av.opengl.effects.EGLScreenCaptureThread.onVideoFrameAvailableListener;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.avcore.data.RecordParam;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Timer;

@RequiresApi(api=21)
public class ScreenRecordHelper
{
  static final int[][] a = { { 720, 1280 }, { 1080, 1920 }, { 1080, 1920 } };
  private WeakReference<Context> b;
  private VirtualDisplay c;
  private MediaProjection d;
  private MediaProjectionManager e;
  private ScreenRecordHelper.OnMediaProjectionReadyListener f;
  private boolean g = false;
  private int h;
  private int i;
  private int j;
  private EGLScreenCaptureThread k;
  private Timer l;
  private boolean m = false;
  private long n;
  private final RecordParam o = new RecordParam();
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ScreenRecordHelper.OnMediaProjectionReadyListener localOnMediaProjectionReadyListener = this.f;
      if (localOnMediaProjectionReadyListener != null) {
        localOnMediaProjectionReadyListener.b(1);
      }
    }
  }
  
  private void g()
  {
    this.c = this.d.createVirtualDisplay("ScreenRecordHelper", this.i, this.j, this.h, 16, this.k.c(), null, null);
  }
  
  public void a()
  {
    Object localObject = this.b;
    Activity localActivity = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (Context)((WeakReference)localObject).get();
    }
    if ((localObject instanceof Activity)) {
      localActivity = (Activity)localObject;
    }
    if (localActivity == null)
    {
      QLog.i("ScreenRecordHelper", 1, "requestScreenCapture, context not bind Activity .");
      return;
    }
    QLog.d("ScreenRecordHelper", 1, "Start requestScreenCapture");
    try
    {
      localActivity.startActivityForResult(this.e.createScreenCaptureIntent(), 8080);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      label72:
      break label72;
    }
    QLog.d("ScreenRecordHelper", 1, "Start requestScreenCapture fail ActivityNotFoundException");
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i3;
    if (this.i < this.j) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i1 = AEFilterSupport.a();
    if (i1 != 4)
    {
      if (i1 != 7) {
        i1 = 0;
      } else {
        i1 = 2;
      }
    }
    else {
      i1 = 1;
    }
    Object localObject = a;
    int i4 = localObject[i1][0];
    int i5 = localObject[i1][1];
    int i2 = i5;
    i1 = i4;
    if (paramInt1 != 0)
    {
      i2 = i5;
      i1 = i4;
      if (paramInt2 != 0)
      {
        i2 = i5;
        i1 = i4;
        if (Math.max(paramInt1, paramInt2) < Math.max(i4, i5))
        {
          i1 = Math.min(paramInt1, paramInt2);
          i2 = Math.max(paramInt1, paramInt2);
        }
      }
    }
    if (i3 != 0)
    {
      i4 = i1;
      i1 = i2;
      i2 = i4;
    }
    if (i3 != 0)
    {
      i3 = Math.min(this.j, i1) / 8 * 8;
      i4 = (int)(i3 * (this.i / this.j)) / 16 * 16;
    }
    else
    {
      i4 = Math.min(this.i, i2) / 16 * 16;
      i3 = (int)(i4 * this.j / this.i) / 8 * 8;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateRecordParam, pre[");
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append("], display[");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append("], limit[");
      ((StringBuilder)localObject).append(i2);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(i1);
      ((StringBuilder)localObject).append("], come[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("], record[");
      ((StringBuilder)localObject).append(i4);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(i3);
      ((StringBuilder)localObject).append("]");
      QLog.i("ScreenRecordHelper", 4, ((StringBuilder)localObject).toString());
    }
    localObject = this.o;
    ((RecordParam)localObject).width = i4;
    ((RecordParam)localObject).height = i3;
    if (paramInt3 > 0) {
      ((RecordParam)localObject).fps = paramInt3;
    }
    localObject = this.k;
    if (localObject != null) {
      ((EGLScreenCaptureThread)localObject).a(this.o);
    }
  }
  
  public void a(Context paramContext)
  {
    this.b = new WeakReference(paramContext);
    if (this.g) {
      return;
    }
    this.g = true;
    this.e = ((MediaProjectionManager)paramContext.getApplicationContext().getSystemService("media_projection"));
    Object localObject = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.h = ((DisplayMetrics)localObject).densityDpi;
    localObject = new Point();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealSize((Point)localObject);
    this.i = ((Point)localObject).x;
    this.j = ((Point)localObject).y;
    a(0, 0, 15);
    this.k = new EGLScreenCaptureThread();
    this.k.a(this.i, this.j);
    this.k.a(this.o);
    this.k.a();
    if (QLog.isDevelopLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("doBindActivityContext, density[");
      paramContext.append(this.h);
      paramContext.append("], size[");
      paramContext.append(this.i);
      paramContext.append(",");
      paramContext.append(this.j);
      paramContext.append("]");
      QLog.i("ScreenRecordHelper", 4, paramContext.toString());
    }
  }
  
  public void a(EGLScreenCaptureThread.onVideoFrameAvailableListener paramonVideoFrameAvailableListener)
  {
    EGLScreenCaptureThread localEGLScreenCaptureThread = this.k;
    if (localEGLScreenCaptureThread != null) {
      localEGLScreenCaptureThread.a(paramonVideoFrameAvailableListener);
    }
  }
  
  public void a(ScreenRecordHelper.OnMediaProjectionReadyListener paramOnMediaProjectionReadyListener)
  {
    this.f = paramOnMediaProjectionReadyListener;
  }
  
  public boolean a(int paramInt)
  {
    long l1 = AudioHelper.c();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Start stopProjection fromType:=");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.d("ScreenRecordHelper", 1, ((StringBuilder)localObject1).toString());
    Object localObject2 = this.c;
    localObject1 = null;
    if (localObject2 != null)
    {
      ((VirtualDisplay)localObject2).release();
      this.c = null;
    }
    localObject2 = this.d;
    if (localObject2 != null)
    {
      ((MediaProjection)localObject2).stop();
      this.d = null;
    }
    localObject2 = this.f;
    if (localObject2 != null) {
      ((ScreenRecordHelper.OnMediaProjectionReadyListener)localObject2).a(paramInt);
    }
    a(null);
    a(null);
    this.m = false;
    TipsUtil.a(VideoController.f().e, true);
    localObject2 = this.b;
    if (localObject2 != null) {
      localObject1 = (Context)((WeakReference)localObject2).get();
    }
    if ((localObject1 != null) && (Build.VERSION.SDK_INT >= 21))
    {
      if (paramInt == 1)
      {
        SmallScreenUtils.a(l1, 3, (Context)localObject1);
        return true;
      }
      if (paramInt == 2) {
        return true;
      }
      SmallScreenUtils.a(l1, 3, (Context)localObject1);
    }
    return true;
  }
  
  public boolean a(Intent paramIntent)
  {
    QLog.d("ScreenRecordHelper", 1, "Start startProjection");
    long l1 = AudioHelper.c();
    Object localObject = this.b;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (Context)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("ScreenRecordHelper", 1, "Start startProjection, context is null.");
      return false;
    }
    MediaProjectionManager localMediaProjectionManager = this.e;
    if (localMediaProjectionManager == null)
    {
      a(false);
      QLog.d("ScreenRecordHelper", 1, "Start startProjection, mMediaProjectionManager is null.");
      return false;
    }
    this.d = localMediaProjectionManager.getMediaProjection(-1, paramIntent);
    if (this.d == null)
    {
      a(false);
      return false;
    }
    a(true);
    g();
    paramIntent = this.f;
    if (paramIntent != null) {
      paramIntent.a(this.o, this.i, this.j);
    }
    paramIntent = VideoController.f().e;
    if (Build.VERSION.SDK_INT >= 21) {
      SmallScreenUtils.a(l1, 3, (Context)localObject, true, paramIntent.getCurrentAccountUin(), true);
    }
    this.l = new Timer();
    this.n = 0L;
    this.l.scheduleAtFixedRate(new ScreenRecordHelper.1(this), 0L, 1000L);
    this.m = true;
    com.tencent.av.screenshare.ScreenShareTipsHelper.a = false;
    return true;
  }
  
  public void b()
  {
    a(false);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop, fromType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("ScreenRecordHelper", 4, localStringBuilder.toString());
    }
    d();
    a(paramInt);
    f();
  }
  
  public boolean c()
  {
    try
    {
      QLog.d("ScreenRecordHelper", 1, "attachRecorder");
      if (this.l != null)
      {
        this.l.cancel();
        this.l = null;
      }
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean d()
  {
    try
    {
      QLog.d("ScreenRecordHelper", 1, "detachRecorder");
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean e()
  {
    return (this.g) && (this.m);
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ScreenRecordHelper", 4, "quit");
    }
    EGLScreenCaptureThread localEGLScreenCaptureThread = this.k;
    if (localEGLScreenCaptureThread != null)
    {
      localEGLScreenCaptureThread.a(true);
      this.k = null;
    }
    this.e = null;
    this.m = false;
    this.g = false;
    this.c = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenRecordHelper
 * JD-Core Version:    0.7.0.1
 */