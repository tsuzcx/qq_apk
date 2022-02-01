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
  static final int[][] jdField_a_of_type_Array2dOfInt;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private VirtualDisplay jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay;
  private MediaProjection jdField_a_of_type_AndroidMediaProjectionMediaProjection;
  private MediaProjectionManager jdField_a_of_type_AndroidMediaProjectionMediaProjectionManager;
  private EGLScreenCaptureThread jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread;
  private ScreenRecordHelper.OnMediaProjectionReadyListener jdField_a_of_type_ComTencentAvUiScreenRecordHelper$OnMediaProjectionReadyListener;
  private final RecordParam jdField_a_of_type_ComTencentAvcoreDataRecordParam = new RecordParam();
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int c;
  
  static
  {
    int[] arrayOfInt = { 1080, 1920 };
    jdField_a_of_type_Array2dOfInt = new int[][] { { 720, 1280 }, arrayOfInt, { 1080, 1920 } };
  }
  
  private void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ScreenRecordHelper.OnMediaProjectionReadyListener localOnMediaProjectionReadyListener = this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper$OnMediaProjectionReadyListener;
      if (localOnMediaProjectionReadyListener != null) {
        localOnMediaProjectionReadyListener.b(1);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay = this.jdField_a_of_type_AndroidMediaProjectionMediaProjection.createVirtualDisplay("ScreenRecordHelper", this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_Int, 16, this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread.a(), null, null);
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
      localActivity.startActivityForResult(this.jdField_a_of_type_AndroidMediaProjectionMediaProjectionManager.createScreenCaptureIntent(), 8080);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      label72:
      break label72;
    }
    QLog.d("ScreenRecordHelper", 1, "Start requestScreenCapture fail ActivityNotFoundException");
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop, fromType[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("ScreenRecordHelper", 4, localStringBuilder.toString());
    }
    b();
    a(paramInt);
    c();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int k;
    if (this.jdField_b_of_type_Int < this.c) {
      k = 1;
    } else {
      k = 0;
    }
    int i = AEFilterSupport.a();
    if (i != 4)
    {
      if (i != 7) {
        i = 0;
      } else {
        i = 2;
      }
    }
    else {
      i = 1;
    }
    Object localObject = jdField_a_of_type_Array2dOfInt;
    int m = localObject[i][0];
    int n = localObject[i][1];
    int j = n;
    i = m;
    if (paramInt1 != 0)
    {
      j = n;
      i = m;
      if (paramInt2 != 0)
      {
        j = n;
        i = m;
        if (Math.max(paramInt1, paramInt2) < Math.max(m, n))
        {
          i = Math.min(paramInt1, paramInt2);
          j = Math.max(paramInt1, paramInt2);
        }
      }
    }
    if (k != 0)
    {
      m = i;
      i = j;
      j = m;
    }
    if (k != 0)
    {
      k = Math.min(this.c, i) / 8 * 8;
      m = (int)(k * (this.jdField_b_of_type_Int / this.c)) / 16 * 16;
    }
    else
    {
      m = Math.min(this.jdField_b_of_type_Int, j) / 16 * 16;
      k = (int)(m * this.c / this.jdField_b_of_type_Int) / 8 * 8;
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateRecordParam, pre[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam);
      ((StringBuilder)localObject).append("], display[");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("], limit[");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("], come[");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt3);
      ((StringBuilder)localObject).append("], record[");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append("]");
      QLog.i("ScreenRecordHelper", 4, ((StringBuilder)localObject).toString());
    }
    localObject = this.jdField_a_of_type_ComTencentAvcoreDataRecordParam;
    ((RecordParam)localObject).width = m;
    ((RecordParam)localObject).height = k;
    if (paramInt3 > 0) {
      ((RecordParam)localObject).fps = paramInt3;
    }
    localObject = this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread;
    if (localObject != null) {
      ((EGLScreenCaptureThread)localObject).a(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam);
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidMediaProjectionMediaProjectionManager = ((MediaProjectionManager)paramContext.getApplicationContext().getSystemService("media_projection"));
    Object localObject = new DisplayMetrics();
    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    this.jdField_a_of_type_Int = ((DisplayMetrics)localObject).densityDpi;
    localObject = new Point();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealSize((Point)localObject);
    this.jdField_b_of_type_Int = ((Point)localObject).x;
    this.c = ((Point)localObject).y;
    a(0, 0, 15);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread = new EGLScreenCaptureThread();
    this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread.a(this.jdField_b_of_type_Int, this.c);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread.a(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam);
    this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread.a();
    if (QLog.isDevelopLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("doBindActivityContext, density[");
      paramContext.append(this.jdField_a_of_type_Int);
      paramContext.append("], size[");
      paramContext.append(this.jdField_b_of_type_Int);
      paramContext.append(",");
      paramContext.append(this.c);
      paramContext.append("]");
      QLog.i("ScreenRecordHelper", 4, paramContext.toString());
    }
  }
  
  public void a(EGLScreenCaptureThread.onVideoFrameAvailableListener paramonVideoFrameAvailableListener)
  {
    EGLScreenCaptureThread localEGLScreenCaptureThread = this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread;
    if (localEGLScreenCaptureThread != null) {
      localEGLScreenCaptureThread.a(paramonVideoFrameAvailableListener);
    }
  }
  
  public void a(ScreenRecordHelper.OnMediaProjectionReadyListener paramOnMediaProjectionReadyListener)
  {
    this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper$OnMediaProjectionReadyListener = paramOnMediaProjectionReadyListener;
  }
  
  public boolean a()
  {
    try
    {
      QLog.d("ScreenRecordHelper", 1, "attachRecorder");
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean a(int paramInt)
  {
    long l = AudioHelper.b();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Start stopProjection fromType:=");
    ((StringBuilder)localObject1).append(paramInt);
    QLog.d("ScreenRecordHelper", 1, ((StringBuilder)localObject1).toString());
    Object localObject2 = this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay;
    localObject1 = null;
    if (localObject2 != null)
    {
      ((VirtualDisplay)localObject2).release();
      this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay = null;
    }
    localObject2 = this.jdField_a_of_type_AndroidMediaProjectionMediaProjection;
    if (localObject2 != null)
    {
      ((MediaProjection)localObject2).stop();
      this.jdField_a_of_type_AndroidMediaProjectionMediaProjection = null;
    }
    localObject2 = this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper$OnMediaProjectionReadyListener;
    if (localObject2 != null) {
      ((ScreenRecordHelper.OnMediaProjectionReadyListener)localObject2).a(paramInt);
    }
    a(null);
    a(null);
    this.jdField_b_of_type_Boolean = false;
    TipsUtil.a(VideoController.a().a, true);
    localObject2 = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject2 != null) {
      localObject1 = (Context)((WeakReference)localObject2).get();
    }
    if ((localObject1 != null) && (Build.VERSION.SDK_INT >= 21))
    {
      if (paramInt == 1)
      {
        SmallScreenUtils.a(l, 3, (Context)localObject1);
        return true;
      }
      if (paramInt == 2) {
        return true;
      }
      SmallScreenUtils.a(l, 3, (Context)localObject1);
    }
    return true;
  }
  
  public boolean a(Intent paramIntent)
  {
    QLog.d("ScreenRecordHelper", 1, "Start startProjection");
    long l = AudioHelper.b();
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
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
    MediaProjectionManager localMediaProjectionManager = this.jdField_a_of_type_AndroidMediaProjectionMediaProjectionManager;
    if (localMediaProjectionManager == null)
    {
      a(false);
      QLog.d("ScreenRecordHelper", 1, "Start startProjection, mMediaProjectionManager is null.");
      return false;
    }
    this.jdField_a_of_type_AndroidMediaProjectionMediaProjection = localMediaProjectionManager.getMediaProjection(-1, paramIntent);
    if (this.jdField_a_of_type_AndroidMediaProjectionMediaProjection == null)
    {
      a(false);
      return false;
    }
    a(true);
    d();
    paramIntent = this.jdField_a_of_type_ComTencentAvUiScreenRecordHelper$OnMediaProjectionReadyListener;
    if (paramIntent != null) {
      paramIntent.a(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam, this.jdField_b_of_type_Int, this.c);
    }
    paramIntent = VideoController.a().a;
    if (Build.VERSION.SDK_INT >= 21) {
      SmallScreenUtils.a(l, 3, (Context)localObject, true, paramIntent.getCurrentAccountUin(), true);
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilTimer.scheduleAtFixedRate(new ScreenRecordHelper.1(this), 0L, 1000L);
    this.jdField_b_of_type_Boolean = true;
    com.tencent.av.screenshare.ScreenShareTipsHelper.jdField_a_of_type_Boolean = false;
    return true;
  }
  
  public void b()
  {
    a(false);
  }
  
  public boolean b()
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
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ScreenRecordHelper", 4, "quit");
    }
    EGLScreenCaptureThread localEGLScreenCaptureThread = this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread;
    if (localEGLScreenCaptureThread != null)
    {
      localEGLScreenCaptureThread.a(true);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsEGLScreenCaptureThread = null;
    }
    this.jdField_a_of_type_AndroidMediaProjectionMediaProjectionManager = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidHardwareDisplayVirtualDisplay = null;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ScreenRecordHelper
 * JD-Core Version:    0.7.0.1
 */