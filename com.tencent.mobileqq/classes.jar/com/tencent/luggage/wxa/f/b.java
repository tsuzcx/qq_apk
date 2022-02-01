package com.tencent.luggage.wxa.f;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.media.MediaRecorder.OnInfoListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.SurfaceHolder;
import androidx.collection.SparseArrayCompat;
import com.tencent.luggage.wxa.g.a.b;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;

class b
  extends i
  implements Camera.PreviewCallback, MediaRecorder.OnErrorListener, MediaRecorder.OnInfoListener
{
  private static final SparseArrayCompat<String> b = new SparseArrayCompat();
  private static final SparseArrayCompat<String> c;
  private int A;
  private float B;
  private int C;
  private float D = 1.0F;
  private CamcorderProfile E;
  private final AtomicBoolean F = new AtomicBoolean(false);
  private Handler G = new Handler();
  private Camera.AutoFocusCallback H;
  private boolean I;
  private SparseIntArray J;
  private boolean K;
  private SurfaceTexture L;
  Camera a;
  private int d;
  private final AtomicBoolean e = new AtomicBoolean(false);
  private Camera.Parameters h;
  private final Camera.CameraInfo i = new Camera.CameraInfo();
  private MediaRecorder j;
  private String k;
  private boolean l;
  private final r m = new r();
  private boolean n = false;
  private final r o = new r();
  private q p;
  private a q;
  private boolean r;
  private boolean s;
  private int t;
  private int u;
  private int v;
  private float w;
  private int x;
  private boolean y;
  private Context z;
  
  static
  {
    b.put(0, "off");
    b.put(1, "on");
    b.put(2, "torch");
    b.put(3, "auto");
    b.put(4, "red-eye");
    c = new SparseArrayCompat();
    c.put(0, "auto");
    c.put(1, "cloudy-daylight");
    c.put(2, "daylight");
    c.put(3, "shade");
    c.put(4, "fluorescent");
    c.put(5, "incandescent");
  }
  
  b(i.a parama, o paramo, Context paramContext)
  {
    super(parama, paramo);
    this.z = paramContext;
    this.I = com.tencent.luggage.wxa.sq.c.b(this.z);
    paramo.a(new b.1(this));
  }
  
  private void F()
  {
    this.a.startPreview();
    boolean bool = true;
    this.n = true;
    if (this.y) {
      this.a.setPreviewCallback(this);
    }
    if ((this.g instanceof l))
    {
      a.b localb = a(this.z, b(i()));
      if (localb != null)
      {
        com.tencent.luggage.wxa.sn.a locala = new com.tencent.luggage.wxa.sn.a();
        locala.b(localb.a.x);
        locala.a(localb.a.y);
        if (e() != 1) {
          bool = false;
        }
        locala.a(bool);
        locala.c(u());
        ((l)this.g).a(locala);
      }
    }
  }
  
  private void G()
  {
    Object localObject = a(this.z, b(this.q));
    int i2;
    int i1;
    if (localObject == null)
    {
      f.b("MicroMsg.Camera1", "can't find a suitable preview size!");
      localObject = a(this.m.b(this.q));
      i2 = ((q)localObject).a();
      i1 = ((q)localObject).b();
    }
    else
    {
      i2 = ((a.b)localObject).a.x;
      i1 = ((a.b)localObject).a.y;
    }
    this.h.setPreviewSize(i2, i1);
    this.a.setParameters(this.h);
  }
  
  private void H()
  {
    if (this.h != null)
    {
      if (!d()) {
        return;
      }
      if (!B()) {
        return;
      }
      Object localObject;
      try
      {
        List localList = this.h.getZoomRatios();
      }
      catch (Exception localException)
      {
        f.b("MicroMsg.Camera1", "getZoom error: %s", new Object[] { localException.getMessage() });
        localObject = null;
      }
      if (localObject != null)
      {
        if (localObject.isEmpty()) {
          return;
        }
        int i3 = ((Integer)localObject.get(localObject.size() - 1)).intValue();
        int i2 = i3;
        int i1 = 1;
        int i4;
        for (;;)
        {
          i4 = 10;
          i2 /= 10;
          if (i2 < 10) {
            break;
          }
          i1 *= 10;
        }
        int i5 = i3 / i1;
        i2 = i5;
        if ((i3 + 4) / i1 > i5) {
          i2 = i5 + 1;
        }
        this.J = new SparseIntArray(i2);
        i3 = i4;
        while (i3 <= i2)
        {
          i5 = i3 * i1;
          if (localObject.indexOf(Integer.valueOf(i5)) < 0)
          {
            i4 = 1;
            while (i4 <= 4)
            {
              int i6 = i5 - i4;
              if (localObject.indexOf(Integer.valueOf(i6)) > 0)
              {
                this.J.append(i3, i6);
                break;
              }
              i6 = i5 + i4;
              if (localObject.indexOf(Integer.valueOf(i6)) > 0)
              {
                this.J.append(i3, i6);
                break;
              }
              i4 += 1;
            }
          }
          this.J.append(i3, i5);
          i3 += 1;
        }
      }
    }
  }
  
  private boolean I()
  {
    int i2 = Camera.getNumberOfCameras();
    int i1 = 0;
    while (i1 < i2)
    {
      Camera.getCameraInfo(i1, this.i);
      if (this.i.facing == this.t)
      {
        this.d = i1;
        f.b("MicroMsg.Camera1", "chooseCamera, CameraId = %d", Integer.valueOf(this.d));
        return true;
      }
      i1 += 1;
    }
    this.d = -1;
    f.d("MicroMsg.Camera1", "chooseCamera, no camera available");
    return false;
  }
  
  private boolean J()
  {
    if (this.a != null) {
      P();
    }
    try
    {
      this.a = Camera.open(this.d);
      this.h = this.a.getParameters();
      this.m.b();
      Object localObject = this.h.getSupportedPreviewSizes().iterator();
      Camera.Size localSize;
      while (((Iterator)localObject).hasNext())
      {
        localSize = (Camera.Size)((Iterator)localObject).next();
        this.m.a(new q(localSize.width, localSize.height));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openCamera, supportedPreviewSizes: ");
      ((StringBuilder)localObject).append(this.m);
      f.b("MicroMsg.Camera1", ((StringBuilder)localObject).toString());
      this.o.b();
      localObject = this.h.getSupportedPictureSizes().iterator();
      while (((Iterator)localObject).hasNext())
      {
        localSize = (Camera.Size)((Iterator)localObject).next();
        this.o.a(new q(localSize.width, localSize.height));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openCamera, supportedPictureSizes: ");
      ((StringBuilder)localObject).append(this.o);
      f.b("MicroMsg.Camera1", ((StringBuilder)localObject).toString());
      K();
      f.b("MicroMsg.Camera1", "openCamera, adjustPreviewSizes: %s", this.m);
      if (this.q == null) {
        this.q = j.a;
      }
      E();
      this.a.setDisplayOrientation(f(this.v));
      this.f.a();
      return true;
    }
    catch (RuntimeException localRuntimeException)
    {
      f.c("MicroMsg.Camera1", "open camera1 error", localRuntimeException);
    }
    return false;
  }
  
  private void K()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = this.m.a().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      a locala = (a)((Iterator)localObject2).next();
      if (!this.o.a().contains(locala)) {
        ((List)localObject1).add(locala);
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (a)((Iterator)localObject1).next();
      this.m.a((a)localObject2);
    }
  }
  
  private void P()
  {
    Camera localCamera = this.a;
    if (localCamera != null)
    {
      localCamera.release();
      this.a = null;
      this.p = null;
      this.f.b();
    }
  }
  
  private void Q()
  {
    this.l = false;
    MediaRecorder localMediaRecorder = this.j;
    if (localMediaRecorder != null)
    {
      try
      {
        localMediaRecorder.stop();
      }
      catch (RuntimeException localRuntimeException)
      {
        f.c("MicroMsg.Camera1", "stopMediaRecorder", localRuntimeException);
      }
      this.j.reset();
      this.j.release();
      this.j = null;
    }
    String str = this.k;
    if ((str != null) && (new File(str).exists()))
    {
      this.f.a(this.k);
      this.k = null;
      return;
    }
    this.f.a(null);
  }
  
  private static int a(float paramFloat, int paramInt1, int paramInt2)
  {
    paramInt1 = (int)(paramFloat / paramInt1 * 2000.0F - 1000.0F);
    if (Math.abs(paramInt1) + paramInt2 > 1000)
    {
      if (paramInt1 > 0) {
        return 1000 - paramInt2;
      }
      return paramInt2 - 1000;
    }
    return paramInt1;
  }
  
  private q a(List<q> paramList)
  {
    paramList = a(this.z, paramList);
    if (paramList == null)
    {
      f.c("MicroMsg.Camera1", "supportSizes is empty, skip getReasonableSize");
      return null;
    }
    return new q(paramList.a.x, paramList.a.y);
  }
  
  private q a(SortedSet<q> paramSortedSet)
  {
    if (!this.g.i()) {
      return (q)paramSortedSet.first();
    }
    int i3 = this.g.l();
    int i1 = this.g.m();
    int i4 = i3;
    int i2 = i1;
    if (h(this.v))
    {
      i2 = i3;
      i4 = i1;
    }
    q localq = null;
    Iterator localIterator = paramSortedSet.iterator();
    paramSortedSet = localq;
    while (localIterator.hasNext())
    {
      localq = (q)localIterator.next();
      paramSortedSet = localq;
      if (i4 <= localq.a())
      {
        paramSortedSet = localq;
        if (i2 <= localq.b()) {
          paramSortedSet = localq;
        }
      }
    }
    return paramSortedSet;
  }
  
  private void a(CamcorderProfile paramCamcorderProfile, boolean paramBoolean)
  {
    this.E = paramCamcorderProfile;
    this.j.setOutputFormat(paramCamcorderProfile.fileFormat);
    this.j.setVideoFrameRate(paramCamcorderProfile.videoFrameRate);
    this.j.setVideoSize(paramCamcorderProfile.videoFrameWidth, paramCamcorderProfile.videoFrameHeight);
    this.j.setVideoEncodingBitRate(paramCamcorderProfile.videoBitRate);
    this.j.setVideoEncoder(paramCamcorderProfile.videoCodec);
    if (paramBoolean)
    {
      this.j.setAudioEncodingBitRate(paramCamcorderProfile.audioBitRate);
      this.j.setAudioChannels(paramCamcorderProfile.audioChannels);
      this.j.setAudioSamplingRate(paramCamcorderProfile.audioSampleRate);
      this.j.setAudioEncoder(paramCamcorderProfile.audioCodec);
    }
  }
  
  @TargetApi(14)
  private void a(boolean paramBoolean, Camera paramCamera)
  {
    if ((this.a != null) && (this.n))
    {
      this.G.removeCallbacksAndMessages(null);
      this.G.postDelayed(new b.8(this, paramCamera, paramBoolean), 3000L);
      return;
    }
    f.b("MicroMsg.Camera1", "execute simpleRequestFocus after camera.release");
  }
  
  private Rect b(float paramFloat1, float paramFloat2)
  {
    int i1 = M() / 2;
    int i2 = a(paramFloat1, this.g.l(), i1);
    int i3 = a(paramFloat2, this.g.m(), i1);
    return new Rect(i2 - i1, i3 - i1, i2 + i1, i3 + i1);
  }
  
  private void b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, CamcorderProfile paramCamcorderProfile, boolean paramBoolean2)
  {
    this.j = new MediaRecorder();
    this.a.unlock();
    this.j.setCamera(this.a);
    this.j.setVideoSource(1);
    if (paramBoolean1) {
      this.j.setAudioSource(5);
    }
    this.j.setOutputFile(paramString);
    this.k = paramString;
    if (paramBoolean2) {
      a(paramCamcorderProfile, paramBoolean1);
    } else if (CamcorderProfile.hasProfile(this.d, paramCamcorderProfile.quality)) {
      a(CamcorderProfile.get(this.d, paramCamcorderProfile.quality), paramBoolean1);
    } else {
      a(CamcorderProfile.get(this.d, 1), paramBoolean1);
    }
    this.j.setOrientationHint(g(this.v));
    if (paramInt1 != -1) {
      this.j.setMaxDuration(paramInt1);
    }
    if (paramInt2 != -1) {
      this.j.setMaxFileSize(paramInt2);
    }
    this.j.setOnInfoListener(this);
    this.j.setOnErrorListener(this);
  }
  
  private boolean d(float paramFloat)
  {
    if ((d()) && (this.h.isZoomSupported()))
    {
      int i1 = (int)(this.h.getMaxZoom() * paramFloat);
      this.h.setZoom(i1);
      this.w = paramFloat;
      return true;
    }
    this.w = paramFloat;
    return false;
  }
  
  private boolean d(boolean paramBoolean)
  {
    this.s = paramBoolean;
    if (d())
    {
      List localList = this.h.getSupportedFocusModes();
      if ((paramBoolean) && (localList.contains("continuous-picture")))
      {
        this.h.setFocusMode("continuous-picture");
        f.b("MicroMsg.Camera1", "setAutoFocusInternal, FOCUS_MODE_CONTINUOUS_PICTURE, autoFocus = true");
      }
      else if (localList.contains("fixed"))
      {
        this.h.setFocusMode("fixed");
        f.b("MicroMsg.Camera1", "setAutoFocusInternal, FOCUS_MODE_FIXED, autoFocus = %s", Boolean.valueOf(paramBoolean));
      }
      else if (localList.contains("infinity"))
      {
        this.h.setFocusMode("infinity");
        f.b("MicroMsg.Camera1", "setAutoFocusInternal, FOCUS_MODE_INFINITY, autoFocus = %s", Boolean.valueOf(paramBoolean));
      }
      else
      {
        this.h.setFocusMode((String)localList.get(0));
        f.a("MicroMsg.Camera1", "setAutoFocusInternal, mode = %s, autoFocus = %s", localList.get(0), Boolean.valueOf(paramBoolean));
      }
      return true;
    }
    f.b("MicroMsg.Camera1", "setAutoFocusInternal, camera not open, autoFocus = %s", Boolean.valueOf(paramBoolean));
    return false;
  }
  
  private void e(boolean paramBoolean)
  {
    this.y = paramBoolean;
    if (d())
    {
      if (this.y)
      {
        this.a.setPreviewCallback(this);
        return;
      }
      this.a.setPreviewCallback(null);
    }
  }
  
  private int f(int paramInt)
  {
    if (this.i.facing == 1) {
      return (360 - (this.i.orientation + paramInt) % 360) % 360;
    }
    return (this.i.orientation - paramInt + 360) % 360;
  }
  
  private int g(int paramInt)
  {
    if (this.i.facing == 1)
    {
      this.C = ((this.i.orientation + paramInt) % 360);
    }
    else
    {
      int i1;
      if (h(paramInt)) {
        i1 = 180;
      } else {
        i1 = 0;
      }
      this.C = ((this.i.orientation + paramInt + i1) % 360);
    }
    return this.C;
  }
  
  private boolean h(int paramInt)
  {
    return (paramInt == 90) || (paramInt == 270);
  }
  
  private boolean i(int paramInt)
  {
    if (d())
    {
      List localList = this.h.getSupportedFlashModes();
      String str = (String)b.get(paramInt);
      if ((localList != null) && (localList.contains(str)))
      {
        this.h.setFlashMode(str);
        this.u = paramInt;
        f.b("MicroMsg.Camera1", "setFlashInternal, flash = %d", Integer.valueOf(paramInt));
        return true;
      }
      str = (String)b.get(this.u);
      if ((localList != null) && (localList.contains(str))) {
        return false;
      }
      this.h.setFlashMode("off");
      return true;
    }
    this.u = paramInt;
    return false;
  }
  
  private boolean j(int paramInt)
  {
    this.x = paramInt;
    if (d())
    {
      List localList = this.h.getSupportedWhiteBalance();
      String str = (String)c.get(paramInt);
      if ((localList != null) && (localList.contains(str)))
      {
        this.h.setWhiteBalance(str);
        return true;
      }
      str = (String)c.get(this.x);
      if ((localList != null) && (localList.contains(str))) {
        return false;
      }
      this.h.setWhiteBalance("auto");
      return true;
    }
    return false;
  }
  
  float[] A()
  {
    if (this.J == null) {
      H();
    }
    float[] arrayOfFloat = new float[this.J.size()];
    int i1 = 0;
    while (i1 < this.J.size())
    {
      arrayOfFloat[i1] = (this.J.keyAt(i1) * 1.0F / 10.0F);
      i1 += 1;
    }
    return arrayOfFloat;
  }
  
  boolean B()
  {
    return this.h.isZoomSupported();
  }
  
  void C()
  {
    this.D = 0.75F;
  }
  
  Point D()
  {
    CamcorderProfile localCamcorderProfile = this.E;
    if (localCamcorderProfile == null) {
      return null;
    }
    int i2 = localCamcorderProfile.videoFrameWidth;
    int i1 = this.E.videoFrameHeight;
    float f1 = i2;
    float f2 = this.D;
    i2 = (int)(f1 * f2);
    i1 = (int)(i1 * f2);
    return new Point(com.tencent.luggage.wxa.g.a.a(i2), com.tencent.luggage.wxa.g.a.a(i1));
  }
  
  void E()
  {
    this.h.setRotation(g(this.v));
    Object localObject2 = this.m.b(this.q);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      f.b("MicroMsg.Camera1", "adjustCameraParameters, ratio[%s] is not supported", this.q);
      this.q = O();
      localObject1 = this.m.b(this.q);
      f.b("MicroMsg.Camera1", "adjustCameraParameters, change to ratio to %s", this.q);
    }
    a((SortedSet)localObject1);
    if (this.p == null)
    {
      localObject1 = new ArrayList();
      localObject2 = this.h.getSupportedPreviewSizes().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Camera.Size localSize = (Camera.Size)((Iterator)localObject2).next();
        ((List)localObject1).add(new q(localSize.width, localSize.height));
      }
      this.p = a((List)localObject1);
      if (this.p == null) {
        this.p = ((q)this.o.b(this.q).last());
      }
    }
    if (this.r)
    {
      this.a.stopPreview();
      this.n = false;
    }
    this.h.setPictureSize(this.p.a(), this.p.b());
    G();
    d(this.s);
    i(this.u);
    a(this.q);
    d(this.w);
    j(this.x);
    e(this.y);
    try
    {
      this.a.setParameters(this.h);
    }
    catch (Exception localException)
    {
      f.c("MicroMsg.Camera1", "adjustCameraParameters setParameters fail", localException);
    }
    if (this.r) {
      F();
    }
  }
  
  public void a(float paramFloat) {}
  
  @TargetApi(14)
  void a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.a;
    if ((localObject != null) && (this.n))
    {
      localObject = ((Camera)localObject).getParameters();
      String str = ((Camera.Parameters)localObject).getFocusMode();
      Rect localRect = b(paramFloat1, paramFloat2);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new Camera.Area(localRect, N()));
      if ((((Camera.Parameters)localObject).getMaxNumFocusAreas() != 0) && (str != null) && ((str.equals("auto")) || (str.equals("macro")) || (str.equals("continuous-picture")) || (str.equals("continuous-video"))))
      {
        if (!((Camera.Parameters)localObject).getSupportedFocusModes().contains("auto")) {
          return;
        }
        ((Camera.Parameters)localObject).setFocusMode("auto");
        ((Camera.Parameters)localObject).setFocusAreas(localArrayList);
        if (((Camera.Parameters)localObject).getMaxNumMeteringAreas() > 0) {
          ((Camera.Parameters)localObject).setMeteringAreas(localArrayList);
        }
        this.a.setParameters((Camera.Parameters)localObject);
        try
        {
          this.a.autoFocus(new b.5(this));
          return;
        }
        catch (Exception localException1)
        {
          f.c("MicroMsg.Camera1", "attachFocusTapListener, autofocus fail case 1", localException1);
          return;
        }
      }
      if (localException1.getMaxNumMeteringAreas() > 0)
      {
        if (!localException1.getSupportedFocusModes().contains("auto")) {
          return;
        }
        localException1.setFocusMode("auto");
        localException1.setFocusAreas(localArrayList);
        localException1.setMeteringAreas(localArrayList);
        this.a.setParameters(localException1);
        try
        {
          this.a.autoFocus(new b.6(this));
          return;
        }
        catch (Exception localException2)
        {
          f.c("MicroMsg.Camera1", "attachFocusTapListener, autofocus fail case 2", localException2);
          return;
        }
      }
      try
      {
        this.a.autoFocus(new b.7(this));
        return;
      }
      catch (Exception localException3)
      {
        f.c("MicroMsg.Camera1", "attachFocusTapListener, autofocus fail case 3", localException3);
        return;
      }
    }
    f.b("MicroMsg.Camera1", "execute simpleRequestFocus after camera.release");
  }
  
  void a(int paramInt)
  {
    if (this.t == paramInt) {
      return;
    }
    this.t = paramInt;
    if (d())
    {
      b();
      a();
      Camera localCamera = this.a;
      if (localCamera != null)
      {
        SurfaceTexture localSurfaceTexture = this.L;
        if (localSurfaceTexture != null) {
          try
          {
            localCamera.setPreviewTexture(localSurfaceTexture);
            return;
          }
          catch (IOException localIOException)
          {
            f.b("MicroMsg.Camera1", "change facing error", localIOException);
          }
        }
      }
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      if (this.a == null)
      {
        this.L = paramSurfaceTexture;
        return;
      }
      this.a.stopPreview();
      this.n = false;
      if (paramSurfaceTexture == null) {
        this.a.setPreviewTexture((SurfaceTexture)this.g.k());
      } else {
        this.a.setPreviewTexture(paramSurfaceTexture);
      }
      this.L = paramSurfaceTexture;
      F();
      return;
    }
    catch (IOException paramSurfaceTexture)
    {
      throw new RuntimeException(paramSurfaceTexture);
    }
  }
  
  void a(q paramq)
  {
    if (paramq == null) {
      return;
    }
    this.p = paramq;
    Camera.Parameters localParameters = this.h;
    if ((localParameters != null) && (this.a != null))
    {
      localParameters.setPictureSize(paramq.a(), paramq.b());
      this.a.setParameters(this.h);
    }
  }
  
  /* Error */
  void a(java.lang.Float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 868	com/tencent/luggage/wxa/f/b:K	Z
    //   4: ifeq +12 -> 16
    //   7: ldc 216
    //   9: ldc_w 870
    //   12: invokestatic 872	com/tencent/luggage/wxa/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: return
    //   16: aload_0
    //   17: getfield 237	com/tencent/luggage/wxa/f/b:h	Landroid/hardware/Camera$Parameters;
    //   20: ifnull +169 -> 189
    //   23: aload_0
    //   24: invokevirtual 252	com/tencent/luggage/wxa/f/b:d	()Z
    //   27: ifne +4 -> 31
    //   30: return
    //   31: aload_0
    //   32: invokevirtual 254	com/tencent/luggage/wxa/f/b:B	()Z
    //   35: istore_3
    //   36: iload_3
    //   37: ifeq +9 -> 46
    //   40: aload_0
    //   41: iconst_0
    //   42: putfield 868	com/tencent/luggage/wxa/f/b:K	Z
    //   45: return
    //   46: aload_0
    //   47: getfield 292	com/tencent/luggage/wxa/f/b:J	Landroid/util/SparseIntArray;
    //   50: ifnonnull +17 -> 67
    //   53: ldc 216
    //   55: ldc_w 874
    //   58: invokestatic 872	com/tencent/luggage/wxa/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 868	com/tencent/luggage/wxa/f/b:K	Z
    //   66: return
    //   67: aload_0
    //   68: getfield 237	com/tencent/luggage/wxa/f/b:h	Landroid/hardware/Camera$Parameters;
    //   71: invokevirtual 258	android/hardware/Camera$Parameters:getZoomRatios	()Ljava/util/List;
    //   74: aload_0
    //   75: getfield 292	com/tencent/luggage/wxa/f/b:J	Landroid/util/SparseIntArray;
    //   78: aload_1
    //   79: invokevirtual 880	java/lang/Float:floatValue	()F
    //   82: ldc_w 739
    //   85: fmul
    //   86: invokestatic 884	java/lang/Math:round	(F)I
    //   89: invokevirtual 886	android/util/SparseIntArray:get	(I)I
    //   92: invokestatic 296	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: invokeinterface 300 2 0
    //   100: istore_2
    //   101: iload_2
    //   102: iflt +44 -> 146
    //   105: iload_2
    //   106: aload_0
    //   107: getfield 237	com/tencent/luggage/wxa/f/b:h	Landroid/hardware/Camera$Parameters;
    //   110: invokevirtual 667	android/hardware/Camera$Parameters:getMaxZoom	()I
    //   113: if_icmple +6 -> 119
    //   116: goto +30 -> 146
    //   119: aload_0
    //   120: iconst_1
    //   121: putfield 868	com/tencent/luggage/wxa/f/b:K	Z
    //   124: aload_0
    //   125: getfield 237	com/tencent/luggage/wxa/f/b:h	Landroid/hardware/Camera$Parameters;
    //   128: iload_2
    //   129: invokevirtual 670	android/hardware/Camera$Parameters:setZoom	(I)V
    //   132: aload_0
    //   133: getfield 155	com/tencent/luggage/wxa/f/b:a	Landroid/hardware/Camera;
    //   136: aload_0
    //   137: getfield 237	com/tencent/luggage/wxa/f/b:h	Landroid/hardware/Camera$Parameters;
    //   140: invokevirtual 247	android/hardware/Camera:setParameters	(Landroid/hardware/Camera$Parameters;)V
    //   143: goto +33 -> 176
    //   146: aload_0
    //   147: iconst_0
    //   148: putfield 868	com/tencent/luggage/wxa/f/b:K	Z
    //   151: return
    //   152: astore_1
    //   153: goto +29 -> 182
    //   156: astore_1
    //   157: ldc 216
    //   159: ldc_w 888
    //   162: iconst_1
    //   163: anewarray 262	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_1
    //   169: invokevirtual 266	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   172: aastore
    //   173: invokestatic 269	com/tencent/luggage/wxa/f/f:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   176: aload_0
    //   177: iconst_0
    //   178: putfield 868	com/tencent/luggage/wxa/f/b:K	Z
    //   181: return
    //   182: aload_0
    //   183: iconst_0
    //   184: putfield 868	com/tencent/luggage/wxa/f/b:K	Z
    //   187: aload_1
    //   188: athrow
    //   189: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	this	b
    //   0	190	1	paramFloat	java.lang.Float
    //   100	29	2	i1	int
    //   35	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   31	36	152	finally
    //   46	61	152	finally
    //   67	101	152	finally
    //   105	116	152	finally
    //   119	143	152	finally
    //   157	176	152	finally
    //   31	36	156	java/lang/Exception
    //   46	61	156	java/lang/Exception
    //   67	101	156	java/lang/Exception
    //   105	116	156	java/lang/Exception
    //   119	143	156	java/lang/Exception
  }
  
  void a(boolean paramBoolean)
  {
    if (this.s == paramBoolean) {
      return;
    }
    if (d(paramBoolean)) {
      this.a.setParameters(this.h);
    }
  }
  
  boolean a()
  {
    I();
    if (!J())
    {
      this.f.c();
      return true;
    }
    if (this.g.i()) {
      c();
    }
    this.r = true;
    F();
    return true;
  }
  
  boolean a(a parama)
  {
    a locala = this.q;
    boolean bool = false;
    if ((locala != null) && (d()))
    {
      if (!this.q.equals(parama))
      {
        if (this.m.b(parama) == null)
        {
          f.b("MicroMsg.Camera1", "setAspectRatio, ratio [%s] is not supported", parama.toString());
          return false;
        }
        this.q = parama;
        this.p = ((q)this.o.b(this.q).last());
        E();
        return true;
      }
      return false;
    }
    if (this.q == null) {
      bool = true;
    }
    f.a("MicroMsg.Camera1", "setAspectRatio, mAspectRatio is null? %s, camera open? %s", Boolean.valueOf(bool), Boolean.valueOf(d()));
    this.q = parama;
    return true;
  }
  
  boolean a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, CamcorderProfile paramCamcorderProfile, boolean paramBoolean2)
  {
    if (!this.l)
    {
      b(paramString, paramInt1, paramInt2, paramBoolean1, paramCamcorderProfile, paramBoolean2);
      try
      {
        this.j.prepare();
        this.j.start();
        this.l = true;
        return true;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        Log.e("MicroMsg.Camera1", "record error", paramString);
      }
    }
    return false;
  }
  
  List<q> b(a parama)
  {
    return new ArrayList(this.m.b(this.q));
  }
  
  void b()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((Camera)localObject).stopPreview();
      this.n = false;
      this.a.setPreviewCallback(null);
    }
    this.r = false;
    localObject = this.j;
    if (localObject != null)
    {
      ((MediaRecorder)localObject).stop();
      this.j.release();
      this.j = null;
      if (this.l)
      {
        this.f.a(this.k);
        this.l = false;
      }
    }
    P();
  }
  
  void b(float paramFloat)
  {
    if (paramFloat == this.w) {
      return;
    }
    if (d(paramFloat)) {
      this.a.setParameters(this.h);
    }
  }
  
  void b(int paramInt)
  {
    if (paramInt == this.u) {
      return;
    }
    if (i(paramInt)) {
      try
      {
        this.a.setParameters(this.h);
        return;
      }
      catch (Exception localException)
      {
        f.c("MicroMsg.Camera1", "setFlash setParameters fail", localException);
      }
    }
  }
  
  void b(boolean paramBoolean)
  {
    if (paramBoolean == this.y) {
      return;
    }
    e(paramBoolean);
  }
  
  @SuppressLint({"NewApi"})
  void c()
  {
    for (;;)
    {
      try
      {
        if (this.L != null)
        {
          this.a.setPreviewTexture(this.L);
          return;
        }
        if (this.g.h() == SurfaceHolder.class)
        {
          if ((!this.r) || (Build.VERSION.SDK_INT >= 14)) {
            break label143;
          }
          bool = true;
          f.b("MicroMsg.Camera1", "setUpPreview, outputClass is SurfaceHolder, needsToStopPreview = %s", Boolean.valueOf(bool));
          if (bool)
          {
            this.a.stopPreview();
            this.n = false;
          }
          this.a.setPreviewDisplay(this.g.f());
          if (bool) {
            F();
          }
        }
        else
        {
          f.b("MicroMsg.Camera1", "setUpPreview, outputClass is SurfaceTexture");
          this.a.setPreviewTexture((SurfaceTexture)this.g.k());
          return;
        }
      }
      catch (IOException localIOException)
      {
        f.b("MicroMsg.Camera1", "setUpPreview, fail IOException message: ", localIOException.getMessage());
      }
      return;
      label143:
      boolean bool = false;
    }
  }
  
  void c(float paramFloat)
  {
    this.B = paramFloat;
  }
  
  public void c(int paramInt)
  {
    if (paramInt == this.x) {
      return;
    }
    if (j(paramInt)) {
      this.a.setParameters(this.h);
    }
  }
  
  void c(boolean paramBoolean) {}
  
  void d(int paramInt)
  {
    if (this.v == paramInt)
    {
      f.b("MicroMsg.Camera1", "Camera1 setDisplayOrientation, displayOrientation = %d, not changed", Integer.valueOf(paramInt));
      return;
    }
    this.v = paramInt;
    if (d())
    {
      int i2 = g(paramInt);
      this.h.setRotation(g(paramInt));
      this.a.setParameters(this.h);
      int i1;
      if ((this.r) && (Build.VERSION.SDK_INT < 14)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        this.a.stopPreview();
        this.n = false;
      }
      int i3 = f(paramInt);
      this.a.setDisplayOrientation(f(paramInt));
      if (i1 != 0) {
        F();
      }
      f.a("MicroMsg.Camera1", "Camera1 setDisplayOrientation, new orientation = %d, camera rotation = %d, camera orientation = %d", Integer.valueOf(paramInt), Integer.valueOf(i2), Integer.valueOf(i3));
    }
  }
  
  boolean d()
  {
    return this.a != null;
  }
  
  int e()
  {
    return this.t;
  }
  
  void e(int paramInt)
  {
    this.A = paramInt;
  }
  
  int f()
  {
    return this.d;
  }
  
  Set<a> g()
  {
    r localr = this.m;
    Object localObject = new ArrayList();
    Iterator localIterator = localr.a().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (this.o.b(locala) == null) {
        ((List)localObject).add(locala);
      }
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localr.a((a)((Iterator)localObject).next());
    }
    return localr.a();
  }
  
  q h()
  {
    return this.p;
  }
  
  a i()
  {
    return this.q;
  }
  
  boolean j()
  {
    if (!d()) {
      return this.s;
    }
    String str = this.h.getFocusMode();
    return (str != null) && (str.contains("continuous"));
  }
  
  int k()
  {
    return this.u;
  }
  
  float l()
  {
    return 0.0F;
  }
  
  float m()
  {
    return this.w;
  }
  
  public int n()
  {
    return this.x;
  }
  
  boolean o()
  {
    return this.y;
  }
  
  public void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    r();
  }
  
  public void onInfo(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 800) || (paramInt1 == 801)) {
      r();
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    paramCamera = this.h.getPreviewSize();
    if ((this.I) && ((this.g instanceof l)) && (((l)this.g).b() != null)) {
      ((l)this.g).b().a(paramArrayOfByte);
    }
    this.f.a(paramArrayOfByte, paramCamera.width, paramCamera.height, this.v);
  }
  
  void p()
  {
    if (!d())
    {
      f.b("MicroMsg.Camera1", "Camera is not ready, call start() before takePicture()");
      return;
    }
    if (this.n)
    {
      if (j())
      {
        f.b("MicroMsg.Camera1", "takePicture => autofocus");
        this.a.cancelAutoFocus();
        this.F.getAndSet(true);
        try
        {
          this.a.autoFocus(new b.2(this));
        }
        catch (Exception localException)
        {
          if (this.F.get())
          {
            f.a("MicroMsg.Camera1", "takePicture, autofocus exception => takePictureInternal", localException);
            this.F.set(false);
            q();
          }
        }
        new Handler(Looper.getMainLooper()).postDelayed(new b.3(this), 2000L);
        return;
      }
      f.b("MicroMsg.Camera1", "takePicture => takePictureInternal");
      q();
      return;
    }
    throw new IllegalStateException("Preview is paused - resume it before taking a picture.");
  }
  
  void q()
  {
    if ((d()) && (!this.e.getAndSet(true))) {
      this.a.takePicture(null, null, null, new b.4(this));
    }
  }
  
  void r()
  {
    if (this.l)
    {
      Q();
      Camera localCamera = this.a;
      if (localCamera != null) {
        localCamera.lock();
      }
    }
  }
  
  int s()
  {
    return this.A;
  }
  
  float t()
  {
    return this.B;
  }
  
  int u()
  {
    return this.i.orientation;
  }
  
  public q v()
  {
    Camera.Size localSize = this.h.getPreviewSize();
    return new q(localSize.width, localSize.height);
  }
  
  public r w()
  {
    return this.m;
  }
  
  public r x()
  {
    return this.o;
  }
  
  boolean y()
  {
    return this.n;
  }
  
  float z()
  {
    return this.h.getMaxZoom();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.b
 * JD-Core Version:    0.7.0.1
 */