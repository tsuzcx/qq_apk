package com.tencent.luggage.wxa.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CameraManager.AvailabilityCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.media.MediaRecorder.OnInfoListener;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Surface;
import com.tencent.luggage.wxa.g.a.b;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;

@TargetApi(21)
class c
  extends i
  implements MediaRecorder.OnErrorListener, MediaRecorder.OnInfoListener
{
  private static final SparseIntArray h = new SparseIntArray();
  private final ImageReader.OnImageAvailableListener A = new c.4(this);
  private String B;
  private CameraCharacteristics C;
  private ImageReader D;
  private ImageReader E;
  private int F;
  private MediaRecorder G;
  private String H;
  private boolean I;
  private final r J = new r();
  private final r K = new r();
  private q L;
  private int M;
  private a N = j.a;
  private a O;
  private int P;
  private int Q;
  private float R;
  private float S;
  private int T;
  private boolean U;
  private Surface V;
  private Rect W;
  c.a a = new c.3(this);
  CameraDevice b;
  CameraCaptureSession c;
  CaptureRequest.Builder d;
  Set<String> e = new HashSet();
  private final CameraManager i;
  private Context j;
  private q k = new q(0, 0);
  private CameraManager.AvailabilityCallback l;
  private List<q> m = new ArrayList();
  private SparseBooleanArray n = new SparseBooleanArray();
  private int o;
  private boolean p = false;
  private CamcorderProfile q;
  private int r;
  private float s;
  private boolean t;
  private Rect u;
  private float[] v;
  private boolean w;
  private boolean x;
  private final CameraDevice.StateCallback y = new c.1(this);
  private final CameraCaptureSession.StateCallback z = new c.2(this);
  
  static
  {
    h.put(0, 1);
    h.put(1, 0);
  }
  
  c(i.a parama, o paramo, Context paramContext)
  {
    super(parama, paramo);
    this.j = paramContext;
    this.t = com.tencent.luggage.wxa.sq.c.b(this.j);
    this.i = ((CameraManager)paramContext.getSystemService("camera"));
    this.l = new c.5(this);
    this.i.registerAvailabilityCallback(this.l, null);
    int i1;
    if (this.U) {
      i1 = 35;
    } else {
      i1 = 256;
    }
    this.F = i1;
    this.g.a(new c.6(this));
  }
  
  private boolean P()
  {
    try
    {
      i2 = h.get(this.M);
      localObject = this.i.getCameraIdList();
      if (localObject.length == 0) {
        break label268;
      }
      i3 = localObject.length;
      i1 = 0;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      for (;;)
      {
        int i2;
        Object localObject;
        int i3;
        int i1;
        String str;
        CameraCharacteristics localCameraCharacteristics;
        Integer localInteger;
        label268:
        RuntimeException localRuntimeException = new RuntimeException("Failed to get a list of camera devices", localCameraAccessException);
        for (;;)
        {
          throw localRuntimeException;
        }
        i1 += 1;
        continue;
        label311:
        i1 += 1;
      }
    }
    if (i1 < i3)
    {
      str = localObject[i1];
      localCameraCharacteristics = this.i.getCameraCharacteristics(str);
      localInteger = (Integer)localCameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
      if ((localInteger != null) && (localInteger.intValue() != 2))
      {
        localInteger = (Integer)localCameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
        if (localInteger != null)
        {
          if (localInteger.intValue() == i2)
          {
            this.B = str;
            this.C = localCameraCharacteristics;
            return true;
          }
        }
        else {
          throw new NullPointerException("Unexpected state: LENS_FACING null");
        }
      }
    }
    else
    {
      this.B = localObject[0];
      this.C = this.i.getCameraCharacteristics(this.B);
      localObject = (Integer)this.C.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
      if (localObject == null) {
        break label318;
      }
      if (((Integer)localObject).intValue() == 2) {
        return false;
      }
      localObject = (Integer)this.C.get(CameraCharacteristics.LENS_FACING);
      if (localObject != null)
      {
        i2 = h.size();
        i1 = 0;
        if (i1 < i2)
        {
          if (h.valueAt(i1) != ((Integer)localObject).intValue()) {
            break label311;
          }
          this.M = h.keyAt(i1);
          return true;
        }
        this.M = 0;
        return true;
      }
      throw new NullPointerException("Unexpected state: LENS_FACING null");
      throw new RuntimeException("No camera available.");
    }
    label318:
    return false;
  }
  
  private void Q()
  {
    Object localObject1 = (StreamConfigurationMap)this.C.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    if (localObject1 != null)
    {
      f(this.Q);
      this.m.clear();
      this.J.b();
      Object localObject2 = ((StreamConfigurationMap)localObject1).getOutputSizes(this.g.h());
      int i2 = localObject2.length;
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject3 = localObject2[i1];
        int i3 = localObject3.getWidth();
        int i4 = localObject3.getHeight();
        this.m.add(new q(i3, i4));
        if ((i3 <= 1920) && (i4 <= 1080)) {
          this.J.a(new q(i3, i4));
        }
        i1 += 1;
      }
      this.K.b();
      a(this.K, (StreamConfigurationMap)localObject1);
      if (this.L == null)
      {
        this.N = O();
        localObject1 = a(this.j, new ArrayList(this.K.b(this.N)));
        if (localObject1 != null) {
          this.L = new q(((a.b)localObject1).a.x, ((a.b)localObject1).a.y);
        } else {
          this.L = ((q)this.K.b(this.N).last());
        }
      }
      localObject1 = this.J.a().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (a)((Iterator)localObject1).next();
        if (!this.K.a().contains(localObject2)) {
          this.J.a((a)localObject2);
        }
      }
      if (!this.J.a().contains(this.N)) {
        this.N = ((a)this.J.a().iterator().next());
      }
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Failed to get configuration map: ");
    ((StringBuilder)localObject1).append(this.B);
    localObject1 = new IllegalStateException(((StringBuilder)localObject1).toString());
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
  
  private void R()
  {
    ImageReader localImageReader = this.D;
    if (localImageReader != null) {
      localImageReader.close();
    }
    this.D = ImageReader.newInstance(this.L.a(), this.L.b(), 256, 1);
    this.D.setOnImageAvailableListener(this.A, null);
  }
  
  private void S()
  {
    ImageReader localImageReader = this.E;
    if (localImageReader != null) {
      localImageReader.close();
    }
    U();
  }
  
  private void T()
  {
    for (;;)
    {
      try
      {
        this.i.openCamera(this.B, this.y, null);
        if ((this.g instanceof l))
        {
          a.b localb = a(this.j, b(i()));
          if (localb != null)
          {
            localObject = new com.tencent.luggage.wxa.sn.a();
            ((com.tencent.luggage.wxa.sn.a)localObject).b(localb.a.x);
            ((com.tencent.luggage.wxa.sn.a)localObject).a(localb.a.y);
            int i1 = e();
            bool = true;
            if (i1 != 1) {
              break label166;
            }
            ((com.tencent.luggage.wxa.sn.a)localObject).a(bool);
            ((com.tencent.luggage.wxa.sn.a)localObject).c(u());
            ((l)this.g).a((com.tencent.luggage.wxa.sn.a)localObject);
          }
        }
        return;
      }
      catch (CameraAccessException localCameraAccessException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Failed to open camera: ");
        ((StringBuilder)localObject).append(this.B);
        throw new RuntimeException(((StringBuilder)localObject).toString(), localCameraAccessException);
      }
      label166:
      boolean bool = false;
    }
  }
  
  private void U()
  {
    Object localObject;
    int i2;
    int i1;
    if (this.x)
    {
      f.b("Camera2", "safeSetPreviewSize, in safe mode");
      localObject = (q)this.J.b(this.N).last();
      i2 = ((q)localObject).a();
      i1 = ((q)localObject).b();
    }
    else
    {
      localObject = a(this.j, new ArrayList(this.J.b(this.N)));
      if (localObject == null)
      {
        f.b("Camera2", "can't find a suitable preview size!");
        localObject = (q)this.J.b(this.N).last();
        i2 = ((q)localObject).a();
        i1 = ((q)localObject).b();
      }
      else
      {
        i2 = ((a.b)localObject).a.x;
        i1 = ((a.b)localObject).a.y;
      }
    }
    this.k = new q(i2, i1);
    this.E = ImageReader.newInstance(i2, i1, 35, 1);
    this.E.setOnImageAvailableListener(this.A, null);
    if ((this.g != null) && (this.g.m() == 0) && (this.g.l() == 0))
    {
      int i3 = this.o;
      if ((i3 != 90) && (i3 != 270))
      {
        this.g.b(i2, i1);
        return;
      }
      this.g.b(i1, i2);
    }
  }
  
  private void V()
  {
    Object localObject = this.C;
    if (localObject == null) {
      return;
    }
    localObject = (Float)((CameraCharacteristics)localObject).get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
    if (localObject == null) {
      f = 0.0F;
    } else {
      f = ((Float)localObject).floatValue();
    }
    float f = Math.round(Float.valueOf(f).floatValue() * 10.0F) * 1.0F / 10.0F * 10.0F;
    this.v = new float[Math.round(f)];
    int i1 = 0;
    while (i1 < Math.round(f))
    {
      this.v[i1] = (i1 * 1.0F / 10.0F + 1.0F);
      i1 += 1;
    }
  }
  
  private void W()
  {
    f.b("Camera2", "open camera in safe mode");
    this.x = true;
    this.L = ((q)this.K.b(this.N).last());
    this.k = ((q)this.J.b(this.N).last());
    R();
    S();
    T();
    this.x = false;
  }
  
  private q X()
  {
    int i3 = this.g.l();
    int i1 = this.g.m();
    int i4 = i3;
    int i2 = i1;
    if (i3 < i1)
    {
      i2 = i3;
      i4 = i1;
    }
    SortedSet localSortedSet = this.J.b(this.N);
    Iterator localIterator = localSortedSet.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if ((localq.a() >= i4) && (localq.b() >= i2)) {
        return localq;
      }
    }
    return (q)localSortedSet.last();
  }
  
  private void Y()
  {
    this.d.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
    try
    {
      this.a.a(1);
      if (this.c == null)
      {
        f.c("Camera2", "mCaptureSession is null.");
        return;
      }
      this.c.capture(this.d.build(), this.a, null);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalStateException localIllegalStateException) {}catch (CameraAccessException localCameraAccessException) {}
    f.c("Camera2", "Failed to lock focus.", localCameraAccessException);
  }
  
  private int Z()
  {
    int i2 = ((Integer)this.C.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    int i3 = this.Q;
    int i4 = this.M;
    int i1 = 1;
    if (i4 != 1) {
      i1 = -1;
    }
    return (i2 + i3 * i1 + 360) % 360;
  }
  
  private void a(CamcorderProfile paramCamcorderProfile, boolean paramBoolean)
  {
    this.G.setOutputFormat(paramCamcorderProfile.fileFormat);
    this.G.setVideoFrameRate(paramCamcorderProfile.videoFrameRate);
    this.G.setVideoSize(paramCamcorderProfile.videoFrameWidth, paramCamcorderProfile.videoFrameHeight);
    this.G.setVideoEncodingBitRate(paramCamcorderProfile.videoBitRate);
    this.G.setVideoEncoder(paramCamcorderProfile.videoCodec);
    if (paramBoolean)
    {
      this.G.setAudioEncodingBitRate(paramCamcorderProfile.audioBitRate);
      this.G.setAudioChannels(paramCamcorderProfile.audioChannels);
      this.G.setAudioSamplingRate(paramCamcorderProfile.audioSampleRate);
      this.G.setAudioEncoder(paramCamcorderProfile.audioCodec);
    }
  }
  
  private void aa()
  {
    this.I = false;
    try
    {
      if (this.c != null)
      {
        this.c.stopRepeating();
        this.c.abortCaptures();
      }
      this.G.stop();
    }
    catch (Exception localException)
    {
      f.c("Camera2", "stop media recorder fail", localException);
    }
    this.G.reset();
    this.G.release();
    this.G = null;
    String str = this.H;
    if ((str != null) && (new File(str).exists()))
    {
      this.f.a(this.H);
      this.H = null;
      return;
    }
    this.f.a(null);
  }
  
  private void b(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, CamcorderProfile paramCamcorderProfile, boolean paramBoolean2)
  {
    this.G = new MediaRecorder();
    this.G.setVideoSource(2);
    if (paramBoolean1) {
      this.G.setAudioSource(1);
    }
    this.G.setOutputFile(paramString);
    this.H = paramString;
    this.q = paramCamcorderProfile;
    if (paramBoolean2) {
      a(paramCamcorderProfile, paramBoolean1);
    } else if (CamcorderProfile.hasProfile(f(), paramCamcorderProfile.quality)) {
      a(paramCamcorderProfile, paramBoolean1);
    } else {
      a(CamcorderProfile.get(f(), 1), paramBoolean1);
    }
    this.G.setOrientationHint(Z());
    if (paramInt1 != -1) {
      this.G.setMaxDuration(paramInt1);
    }
    if (paramInt2 != -1) {
      this.G.setMaxFileSize(paramInt2);
    }
    this.G.setOnInfoListener(this);
    this.G.setOnErrorListener(this);
  }
  
  private static byte[] b(Image paramImage)
  {
    ByteBuffer localByteBuffer1 = paramImage.getPlanes()[0].getBuffer();
    ByteBuffer localByteBuffer2 = paramImage.getPlanes()[1].getBuffer();
    ByteBuffer localByteBuffer3 = paramImage.getPlanes()[2].getBuffer();
    int i1 = localByteBuffer1.remaining();
    int i2 = localByteBuffer2.remaining();
    int i3 = localByteBuffer3.remaining();
    try
    {
      paramImage = new byte[i1 + i2 + i3];
    }
    catch (OutOfMemoryError paramImage)
    {
      label90:
      break label90;
    }
    try
    {
      localByteBuffer1.get(paramImage, 0, i1);
      localByteBuffer3.get(paramImage, i1, i3);
      localByteBuffer2.get(paramImage, i1 + i3, i2);
      return paramImage;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label92;
    }
    paramImage = null;
    label92:
    f.c("Camera2", "YUV_420_888toNV21 oom");
    return paramImage;
  }
  
  private int f(int paramInt)
  {
    CameraCharacteristics localCameraCharacteristics = this.C;
    int i1 = 0;
    if (localCameraCharacteristics == null) {
      return 0;
    }
    int i2 = ((Integer)localCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    if (this.M == 1)
    {
      this.o = ((i2 + paramInt) % 360);
    }
    else
    {
      if (g(paramInt)) {
        i1 = 180;
      }
      this.o = ((i2 + paramInt + i1) % 360);
    }
    return this.o;
  }
  
  private boolean g(int paramInt)
  {
    return (paramInt == 90) || (paramInt == 270);
  }
  
  float[] A()
  {
    if (this.v == null) {
      V();
    }
    return this.v;
  }
  
  boolean B()
  {
    return ((Float)this.C.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() > 0.0F;
  }
  
  void C() {}
  
  Point D()
  {
    CamcorderProfile localCamcorderProfile = this.q;
    if (localCamcorderProfile == null) {
      return null;
    }
    int i1 = localCamcorderProfile.videoFrameWidth;
    int i2 = this.q.videoFrameHeight;
    return new Point(com.tencent.luggage.wxa.g.a.a(i1), com.tencent.luggage.wxa.g.a.a(i2));
  }
  
  void E()
  {
    boolean bool = this.n.get(this.M);
    Integer localInteger = Integer.valueOf(0);
    if (bool)
    {
      int[] arrayOfInt = (int[])this.C.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
      if ((arrayOfInt != null) && (arrayOfInt.length != 0) && ((arrayOfInt.length != 1) || (arrayOfInt[0] != 0)))
      {
        this.d.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        return;
      }
      this.n.put(this.M, false);
      this.d.set(CaptureRequest.CONTROL_AF_MODE, localInteger);
      return;
    }
    this.d.set(CaptureRequest.CONTROL_AF_MODE, localInteger);
  }
  
  void F()
  {
    int i1 = this.P;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4) {
              return;
            }
            this.d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(4));
            this.d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
            return;
          }
          this.d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
          this.d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
          return;
        }
        this.d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
        this.d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
        return;
      }
      this.d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(3));
      this.d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
      return;
    }
    this.d.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
    this.d.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
  }
  
  void G()
  {
    if (this.n.get(this.M)) {
      return;
    }
    Float localFloat = (Float)this.C.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
    if (localFloat != null)
    {
      float f1 = this.R;
      float f2 = localFloat.floatValue();
      this.d.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(f1 * f2));
      return;
    }
    throw new NullPointerException("Unexpected state: LENS_INFO_MINIMUM_FOCUS_DISTANCE null");
  }
  
  void H()
  {
    float f = ((Float)this.C.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
    f = this.S * (f - 1.0F) + 1.0F;
    Rect localRect = (Rect)this.C.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
    if (localRect != null)
    {
      int i3 = localRect.width();
      int i1 = localRect.height();
      int i4 = (int)(i3 / f);
      int i2 = (int)(i1 / f);
      i3 = (i3 - i4) / 2;
      i1 = (i1 - i2) / 2;
      localRect = new Rect(localRect.left + i3, localRect.top + i1, localRect.right - i3, localRect.bottom - i1);
      if (f != 1.0F)
      {
        this.d.set(CaptureRequest.SCALER_CROP_REGION, localRect);
        return;
      }
      this.d.set(CaptureRequest.SCALER_CROP_REGION, this.W);
    }
  }
  
  void I()
  {
    int i1 = this.T;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if (i1 != 4)
            {
              if (i1 != 5) {
                return;
              }
              this.d.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(2));
              return;
            }
            this.d.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(3));
            return;
          }
          this.d.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(8));
          return;
        }
        this.d.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(5));
        return;
      }
      this.d.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(6));
      return;
    }
    this.d.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(1));
  }
  
  void J()
  {
    try
    {
      CaptureRequest.Builder localBuilder = this.b.createCaptureRequest(2);
      if (this.U)
      {
        this.F = 256;
        localBuilder.removeTarget(this.E.getSurface());
      }
      localBuilder.addTarget(this.D.getSurface());
      localBuilder.set(CaptureRequest.CONTROL_AF_MODE, this.d.get(CaptureRequest.CONTROL_AF_MODE));
      int i1 = this.P;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 == 4) {
                localBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
              }
            }
            else {
              localBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(2));
            }
          }
          else
          {
            localBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
            localBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
          }
        }
        else {
          localBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(3));
        }
      }
      else
      {
        localBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
        localBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
      }
      localBuilder.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(Z()));
      localBuilder.set(CaptureRequest.SCALER_CROP_REGION, this.d.get(CaptureRequest.SCALER_CROP_REGION));
      if (this.c == null)
      {
        f.c("Camera2", "mCaptureSession is null.");
        return;
      }
      this.c.stopRepeating();
      this.c.capture(localBuilder.build(), new c.8(this), null);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalStateException localIllegalStateException) {}catch (CameraAccessException localCameraAccessException) {}
    f.c("Camera2", "Cannot capture a still picture.", localCameraAccessException);
  }
  
  void K()
  {
    this.d.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
    try
    {
      if (this.c != null) {
        this.c.capture(this.d.build(), this.a, null);
      }
      E();
      F();
      if (this.U)
      {
        this.F = 35;
        c();
        return;
      }
      this.d.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
      if (this.c != null) {
        this.c.setRepeatingRequest(this.d.build(), this.a, null);
      }
      this.a.a(0);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalStateException localIllegalStateException) {}catch (CameraAccessException localCameraAccessException) {}
    f.c("Camera2", "Failed to restart camera preview.", localCameraAccessException);
  }
  
  public void a(float paramFloat)
  {
    float f = this.R;
    if (f == paramFloat) {
      return;
    }
    this.R = paramFloat;
    if (this.c != null)
    {
      G();
      try
      {
        this.c.setRepeatingRequest(this.d.build(), this.a, null);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalStateException localIllegalStateException) {}catch (CameraAccessException localCameraAccessException) {}
      this.R = f;
      f.c("Camera2", "set focus depth fail", localCameraAccessException);
    }
  }
  
  void a(float paramFloat1, float paramFloat2) {}
  
  void a(int paramInt)
  {
    if (this.M == paramInt) {
      return;
    }
    this.M = paramInt;
    if (d())
    {
      b();
      a();
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    if (paramSurfaceTexture != null)
    {
      a.b localb = a(this.j, b(this.N));
      paramSurfaceTexture.setDefaultBufferSize(localb.a.x, localb.a.y);
      this.V = new Surface(paramSurfaceTexture);
    }
    else
    {
      this.V = null;
    }
    new Handler(Looper.getMainLooper()).post(new c.7(this));
  }
  
  void a(q paramq)
  {
    if (paramq == null) {
      return;
    }
    CameraCaptureSession localCameraCaptureSession = this.c;
    if (localCameraCaptureSession != null)
    {
      try
      {
        localCameraCaptureSession.stopRepeating();
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalStateException localIllegalStateException) {}catch (CameraAccessException localCameraAccessException) {}
      f.c("Camera2", "set picture size fail", localCameraAccessException);
      this.c.close();
      this.c = null;
    }
    ImageReader localImageReader = this.D;
    if (localImageReader != null) {
      localImageReader.close();
    }
    this.L = paramq;
    R();
    c();
  }
  
  protected void a(r paramr, StreamConfigurationMap paramStreamConfigurationMap)
  {
    paramr = paramStreamConfigurationMap.getOutputSizes(this.F);
    int i2 = paramr.length;
    int i1 = 0;
    while (i1 < i2)
    {
      paramStreamConfigurationMap = paramr[i1];
      this.K.a(new q(paramStreamConfigurationMap.getWidth(), paramStreamConfigurationMap.getHeight()));
      i1 += 1;
    }
  }
  
  /* Error */
  void a(Float paramFloat)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 898	com/tencent/luggage/wxa/f/c:w	Z
    //   4: ifeq +13 -> 17
    //   7: ldc_w 447
    //   10: ldc_w 900
    //   13: invokestatic 902	com/tencent/luggage/wxa/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: return
    //   17: aload_0
    //   18: invokevirtual 904	com/tencent/luggage/wxa/f/c:B	()Z
    //   21: ifne +13 -> 34
    //   24: ldc_w 447
    //   27: ldc_w 906
    //   30: invokestatic 902	com/tencent/luggage/wxa/f/f:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: return
    //   34: aload_0
    //   35: getfield 247	com/tencent/luggage/wxa/f/c:C	Landroid/hardware/camera2/CameraCharacteristics;
    //   38: astore 4
    //   40: aload 4
    //   42: ifnull +210 -> 252
    //   45: aload_0
    //   46: getfield 502	com/tencent/luggage/wxa/f/c:d	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   49: ifnull +203 -> 252
    //   52: aload 4
    //   54: getstatic 775	android/hardware/camera2/CameraCharacteristics:SENSOR_INFO_ACTIVE_ARRAY_SIZE	Landroid/hardware/camera2/CameraCharacteristics$Key;
    //   57: invokevirtual 234	android/hardware/camera2/CameraCharacteristics:get	(Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;
    //   60: checkcast 777	android/graphics/Rect
    //   63: astore 4
    //   65: aload 4
    //   67: invokevirtual 780	android/graphics/Rect:width	()I
    //   70: aload 4
    //   72: invokevirtual 780	android/graphics/Rect:width	()I
    //   75: i2f
    //   76: fconst_1
    //   77: fmul
    //   78: aload_1
    //   79: invokevirtual 473	java/lang/Float:floatValue	()F
    //   82: fdiv
    //   83: invokestatic 484	java/lang/Math:round	(F)I
    //   86: isub
    //   87: istore_2
    //   88: aload 4
    //   90: invokevirtual 783	android/graphics/Rect:height	()I
    //   93: aload 4
    //   95: invokevirtual 783	android/graphics/Rect:height	()I
    //   98: i2f
    //   99: fconst_1
    //   100: fmul
    //   101: aload_1
    //   102: invokevirtual 473	java/lang/Float:floatValue	()F
    //   105: fdiv
    //   106: invokestatic 484	java/lang/Math:round	(F)I
    //   109: isub
    //   110: istore_3
    //   111: aload_0
    //   112: new 777	android/graphics/Rect
    //   115: dup
    //   116: iload_2
    //   117: iconst_2
    //   118: idiv
    //   119: iload_3
    //   120: iconst_2
    //   121: idiv
    //   122: aload 4
    //   124: invokevirtual 780	android/graphics/Rect:width	()I
    //   127: iload_2
    //   128: iconst_2
    //   129: idiv
    //   130: isub
    //   131: aload 4
    //   133: invokevirtual 783	android/graphics/Rect:height	()I
    //   136: iload_3
    //   137: iconst_2
    //   138: idiv
    //   139: isub
    //   140: invokespecial 798	android/graphics/Rect:<init>	(IIII)V
    //   143: putfield 908	com/tencent/luggage/wxa/f/c:u	Landroid/graphics/Rect;
    //   146: aload_0
    //   147: getfield 502	com/tencent/luggage/wxa/f/c:d	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   150: getstatic 801	android/hardware/camera2/CaptureRequest:SCALER_CROP_REGION	Landroid/hardware/camera2/CaptureRequest$Key;
    //   153: aload_0
    //   154: getfield 908	com/tencent/luggage/wxa/f/c:u	Landroid/graphics/Rect;
    //   157: invokevirtual 517	android/hardware/camera2/CaptureRequest$Builder:set	(Landroid/hardware/camera2/CaptureRequest$Key;Ljava/lang/Object;)V
    //   160: aload_0
    //   161: getfield 522	com/tencent/luggage/wxa/f/c:c	Landroid/hardware/camera2/CameraCaptureSession;
    //   164: astore_1
    //   165: aload_1
    //   166: ifnull +73 -> 239
    //   169: aload_0
    //   170: getfield 522	com/tencent/luggage/wxa/f/c:c	Landroid/hardware/camera2/CameraCaptureSession;
    //   173: aload_0
    //   174: getfield 502	com/tencent/luggage/wxa/f/c:d	Landroid/hardware/camera2/CaptureRequest$Builder;
    //   177: invokevirtual 530	android/hardware/camera2/CaptureRequest$Builder:build	()Landroid/hardware/camera2/CaptureRequest;
    //   180: aload_0
    //   181: getfield 139	com/tencent/luggage/wxa/f/c:a	Lcom/tencent/luggage/wxa/f/c$a;
    //   184: aconst_null
    //   185: invokevirtual 845	android/hardware/camera2/CameraCaptureSession:setRepeatingRequest	(Landroid/hardware/camera2/CaptureRequest;Landroid/hardware/camera2/CameraCaptureSession$CaptureCallback;Landroid/os/Handler;)I
    //   188: pop
    //   189: goto +50 -> 239
    //   192: astore_1
    //   193: goto +8 -> 201
    //   196: astore_1
    //   197: goto +4 -> 201
    //   200: astore_1
    //   201: ldc_w 447
    //   204: ldc_w 910
    //   207: aload_1
    //   208: invokestatic 541	com/tencent/luggage/wxa/f/f:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   211: goto +28 -> 239
    //   214: astore_1
    //   215: goto +30 -> 245
    //   218: astore_1
    //   219: ldc_w 447
    //   222: ldc_w 912
    //   225: iconst_1
    //   226: anewarray 914	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_1
    //   232: invokevirtual 917	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   235: aastore
    //   236: invokestatic 920	com/tencent/luggage/wxa/f/f:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: aload_0
    //   240: iconst_0
    //   241: putfield 898	com/tencent/luggage/wxa/f/c:w	Z
    //   244: return
    //   245: aload_0
    //   246: iconst_0
    //   247: putfield 898	com/tencent/luggage/wxa/f/c:w	Z
    //   250: aload_1
    //   251: athrow
    //   252: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	c
    //   0	253	1	paramFloat	Float
    //   87	43	2	i1	int
    //   110	29	3	i2	int
    //   38	94	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   169	189	192	java/lang/IllegalArgumentException
    //   169	189	196	java/lang/IllegalStateException
    //   169	189	200	android/hardware/camera2/CameraAccessException
    //   52	165	214	finally
    //   169	189	214	finally
    //   201	211	214	finally
    //   219	239	214	finally
    //   52	165	218	java/lang/Exception
    //   169	189	218	java/lang/Exception
    //   201	211	218	java/lang/Exception
  }
  
  void a(boolean paramBoolean)
  {
    if (this.n.get(this.M) == paramBoolean) {
      return;
    }
    this.n.put(this.M, paramBoolean);
    if (this.d != null)
    {
      E();
      CameraCaptureSession localCameraCaptureSession = this.c;
      if (localCameraCaptureSession != null)
      {
        try
        {
          localCameraCaptureSession.setRepeatingRequest(this.d.build(), this.a, null);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalStateException localIllegalStateException) {}catch (CameraAccessException localCameraAccessException) {}
        SparseBooleanArray localSparseBooleanArray = this.n;
        int i1 = this.M;
        localSparseBooleanArray.put(i1, localSparseBooleanArray.get(i1) ^ true);
        f.c("Camera2", "set auto focus fail", localCameraAccessException);
      }
    }
  }
  
  boolean a()
  {
    if (!P())
    {
      this.N = this.O;
      return false;
    }
    Q();
    a(this.O);
    this.O = null;
    R();
    S();
    T();
    return true;
  }
  
  boolean a(a parama)
  {
    if ((parama != null) && (this.J.c()))
    {
      this.O = parama;
      return false;
    }
    if ((parama != null) && (!parama.equals(this.N)))
    {
      if (!this.J.a().contains(parama)) {
        return false;
      }
      this.N = parama;
      parama = a(this.j, new ArrayList(this.K.b(this.N)));
      if (parama != null) {
        this.L = new q(parama.a.x, parama.a.y);
      } else {
        this.L = ((q)this.K.b(this.N).last());
      }
      R();
      S();
      parama = this.c;
      if (parama != null)
      {
        parama.close();
        this.c = null;
        c();
      }
      return true;
    }
    return false;
  }
  
  boolean a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, CamcorderProfile paramCamcorderProfile, boolean paramBoolean2)
  {
    if (!this.I)
    {
      b(paramString, paramInt1, paramInt2, paramBoolean1, paramCamcorderProfile, paramBoolean2);
      try
      {
        this.G.prepare();
        if (this.c != null)
        {
          this.c.close();
          this.c = null;
        }
        paramString = X();
        this.g.a(paramString.a(), paramString.b());
        paramString = q();
        paramCamcorderProfile = this.G.getSurface();
        this.d = this.b.createCaptureRequest(3);
        this.d.addTarget(paramString);
        this.d.addTarget(paramCamcorderProfile);
        this.b.createCaptureSession(Arrays.asList(new Surface[] { paramString, paramCamcorderProfile }), this.z, null);
        this.G.start();
        this.I = true;
        return true;
      }
      catch (IOException paramString) {}catch (IllegalArgumentException paramString) {}catch (IllegalStateException paramString) {}catch (CameraAccessException paramString) {}
      f.c("Camera2", "record fail", paramString);
    }
    return false;
  }
  
  List<q> b(a parama)
  {
    return new ArrayList(this.J.b(this.N));
  }
  
  void b()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((CameraCaptureSession)localObject).close();
      this.c = null;
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((CameraDevice)localObject).close();
      this.b = null;
    }
    localObject = this.D;
    if (localObject != null)
    {
      ((ImageReader)localObject).close();
      this.D = null;
    }
    localObject = this.E;
    if (localObject != null)
    {
      ((ImageReader)localObject).close();
      this.E = null;
    }
    localObject = this.G;
    if (localObject != null)
    {
      ((MediaRecorder)localObject).stop();
      this.G.reset();
      this.G.release();
      this.G = null;
      if (this.I)
      {
        this.f.a(this.H);
        this.I = false;
      }
    }
    localObject = this.i;
    if (localObject != null)
    {
      CameraManager.AvailabilityCallback localAvailabilityCallback = this.l;
      if (localAvailabilityCallback != null) {
        ((CameraManager)localObject).unregisterAvailabilityCallback(localAvailabilityCallback);
      }
    }
  }
  
  public void b(float paramFloat)
  {
    float f = this.S;
    if (f == paramFloat) {
      return;
    }
    this.S = paramFloat;
    if (this.c != null)
    {
      H();
      try
      {
        this.c.setRepeatingRequest(this.d.build(), this.a, null);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalStateException localIllegalStateException) {}catch (CameraAccessException localCameraAccessException) {}
      this.S = f;
      f.c("Camera2", "set zoom fail", localCameraAccessException);
    }
  }
  
  void b(int paramInt)
  {
    int i1 = this.P;
    if (i1 == paramInt) {
      return;
    }
    this.P = paramInt;
    if (this.d != null)
    {
      F();
      CameraCaptureSession localCameraCaptureSession = this.c;
      if (localCameraCaptureSession != null)
      {
        try
        {
          localCameraCaptureSession.setRepeatingRequest(this.d.build(), this.a, null);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalStateException localIllegalStateException) {}catch (CameraAccessException localCameraAccessException) {}
        this.P = i1;
        f.c("Camera2", "set flash fail", localCameraAccessException);
      }
    }
  }
  
  void b(boolean paramBoolean)
  {
    if (this.U == paramBoolean) {
      return;
    }
    this.U = paramBoolean;
    if (!this.U) {
      this.F = 256;
    } else {
      this.F = 35;
    }
    CameraCaptureSession localCameraCaptureSession = this.c;
    if (localCameraCaptureSession != null)
    {
      localCameraCaptureSession.close();
      this.c = null;
    }
    c();
  }
  
  void c()
  {
    if ((d()) && (this.g.i()) && (this.D != null))
    {
      if (this.E == null) {
        return;
      }
      Object localObject = X();
      this.g.a(((q)localObject).a(), ((q)localObject).b());
      localObject = q();
      try
      {
        this.d = this.b.createCaptureRequest(1);
        this.d.addTarget((Surface)localObject);
        if (this.U) {
          this.d.addTarget(this.E.getSurface());
        }
        this.b.createCaptureSession(Arrays.asList(new Surface[] { localObject, this.D.getSurface(), this.E.getSurface() }), this.z, null);
        return;
      }
      catch (IllegalStateException localIllegalStateException) {}catch (IllegalArgumentException localIllegalArgumentException) {}catch (CameraAccessException localCameraAccessException) {}
      f.c("Camera2", "startCaptureSession error", localCameraAccessException);
      this.f.c();
    }
  }
  
  void c(float paramFloat)
  {
    this.s = paramFloat;
  }
  
  public void c(int paramInt)
  {
    int i1 = this.T;
    if (i1 == paramInt) {
      return;
    }
    this.T = paramInt;
    if (this.c != null)
    {
      I();
      try
      {
        this.c.setRepeatingRequest(this.d.build(), this.a, null);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalStateException localIllegalStateException) {}catch (CameraAccessException localCameraAccessException) {}
      this.T = i1;
      f.c("Camera2", "set white balance fail", localCameraAccessException);
    }
  }
  
  void c(boolean paramBoolean) {}
  
  void d(int paramInt)
  {
    f(paramInt);
    this.Q = paramInt;
    this.g.a(this.Q);
  }
  
  boolean d()
  {
    return this.b != null;
  }
  
  int e()
  {
    return this.M;
  }
  
  void e(int paramInt)
  {
    this.r = paramInt;
  }
  
  int f()
  {
    return Integer.parseInt(this.B);
  }
  
  Set<a> g()
  {
    return this.J.a();
  }
  
  q h()
  {
    return this.L;
  }
  
  a i()
  {
    return this.N;
  }
  
  boolean j()
  {
    return this.n.get(this.M);
  }
  
  int k()
  {
    return this.P;
  }
  
  float l()
  {
    return this.R;
  }
  
  float m()
  {
    return this.S;
  }
  
  public int n()
  {
    return this.T;
  }
  
  boolean o()
  {
    return this.U;
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
  
  void p()
  {
    if (this.n.get(this.M))
    {
      Y();
      return;
    }
    J();
  }
  
  public Surface q()
  {
    Surface localSurface = this.V;
    if (localSurface != null) {
      return localSurface;
    }
    return this.g.e();
  }
  
  void r()
  {
    if (this.I)
    {
      aa();
      CameraCaptureSession localCameraCaptureSession = this.c;
      if (localCameraCaptureSession != null)
      {
        localCameraCaptureSession.close();
        this.c = null;
      }
      c();
    }
  }
  
  int s()
  {
    return this.r;
  }
  
  float t()
  {
    return this.s;
  }
  
  int u()
  {
    CameraCharacteristics localCameraCharacteristics = this.C;
    if (localCameraCharacteristics == null) {
      return 0;
    }
    return ((Integer)localCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
  }
  
  public q v()
  {
    return this.k;
  }
  
  public r w()
  {
    return this.J;
  }
  
  public r x()
  {
    return this.K;
  }
  
  boolean y()
  {
    return this.p;
  }
  
  float z()
  {
    return ((Float)this.C.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.c
 * JD-Core Version:    0.7.0.1
 */