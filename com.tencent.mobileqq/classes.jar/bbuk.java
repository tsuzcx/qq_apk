import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bbuk
  implements Camera.PreviewCallback, bbsm
{
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public volatile int a;
  private Camera.FaceDetectionListener jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener;
  public bbui a;
  public final bbun a;
  public final bbuq a;
  private bbur jdField_a_of_type_Bbur;
  bbut jdField_a_of_type_Bbut = new bbut();
  private String jdField_a_of_type_JavaLangString = "";
  public Map<String, bbut> a;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  public bbut b;
  private String jdField_b_of_type_JavaLangString;
  public Map<String, bbuu> b;
  public boolean b;
  private int[] jdField_b_of_type_ArrayOfInt;
  public int c;
  public bbut c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 2147483647;
  bbut jdField_d_of_type_Bbut = new bbut();
  private boolean jdField_d_of_type_Boolean;
  bbut jdField_e_of_type_Bbut = new bbut();
  private boolean jdField_e_of_type_Boolean;
  bbut jdField_f_of_type_Bbut = new bbut();
  private volatile boolean jdField_f_of_type_Boolean;
  bbut g = new bbut();
  bbut h = new bbut();
  
  public bbuk(Context arg1, Handler paramHandler)
  {
    this.jdField_b_of_type_Bbut = new bbut();
    this.jdField_c_of_type_Bbut = new bbut();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("Camera2 Handler Thread", 0);
        jdField_a_of_type_AndroidOsHandlerThread.start();
      }
      this.jdField_a_of_type_Bbuq = new bbuq(paramHandler);
      this.jdField_a_of_type_Bbun = new bbun(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
      return;
    }
  }
  
  private String a(Camera.Parameters paramParameters)
  {
    if (!this.jdField_c_of_type_Boolean) {
      a(paramParameters);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_d_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (this.jdField_c_of_type_JavaLangString != null) {
        localObject1 = paramParameters.get(this.jdField_c_of_type_JavaLangString);
      }
    }
    if (StringUtil.isEmpty((String)localObject1)) {
      this.jdField_d_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "getCurrentISO=" + (String)localObject1);
    }
    return localObject1;
  }
  
  private void a(SurfaceTexture paramSurfaceTexture, bbur parambbur, boolean paramBoolean)
  {
    if (paramSurfaceTexture != null) {
      a(paramSurfaceTexture);
    }
    if (parambbur != null)
    {
      a(parambbur);
      a(this, paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_Bbun.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(paramSurfaceTexture);
    }
  }
  
  private void a(Camera.Parameters paramParameters)
  {
    this.jdField_c_of_type_Boolean = true;
    paramParameters = paramParameters.flatten();
    if (paramParameters.contains("iso-values"))
    {
      this.jdField_b_of_type_JavaLangString = "iso-values";
      this.jdField_c_of_type_JavaLangString = "iso";
      if (this.jdField_c_of_type_JavaLangString == null) {
        break label225;
      }
      paramParameters = paramParameters.substring(paramParameters.indexOf(this.jdField_b_of_type_JavaLangString));
      String str = paramParameters.substring(paramParameters.indexOf("=") + 1);
      paramParameters = str;
      if (str.contains(";")) {
        paramParameters = str.substring(0, str.indexOf(";"));
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = paramParameters.split(",");
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "init iso key=" + this.jdField_c_of_type_JavaLangString + " value key" + this.jdField_b_of_type_JavaLangString + " Values=" + paramParameters);
      }
    }
    label225:
    do
    {
      return;
      if (paramParameters.contains("iso-mode-values"))
      {
        this.jdField_b_of_type_JavaLangString = "iso-mode-values";
        this.jdField_c_of_type_JavaLangString = "iso";
        break;
      }
      if (paramParameters.contains("iso-speed-values"))
      {
        this.jdField_b_of_type_JavaLangString = "iso-speed-values";
        this.jdField_c_of_type_JavaLangString = "iso-speed";
        break;
      }
      if (!paramParameters.contains("nv-picture-iso-values")) {
        break;
      }
      this.jdField_b_of_type_JavaLangString = "nv-picture-iso-values";
      this.jdField_c_of_type_JavaLangString = "nv-picture-iso";
      break;
      this.jdField_d_of_type_Boolean = false;
    } while (!QLog.isColorLevel());
    QLog.i("CameraProxy", 2, "init iso not support");
  }
  
  private void a(bbur parambbur)
  {
    this.jdField_a_of_type_Bbur = parambbur;
  }
  
  private boolean a(Camera.Parameters paramParameters)
  {
    if (!this.jdField_c_of_type_Boolean) {
      a(paramParameters);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_d_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ArrayOfJavaLangString.length > 0) {
          localObject1 = this.jdField_a_of_type_ArrayOfJavaLangString[(this.jdField_a_of_type_ArrayOfJavaLangString.length - 1)];
        }
      }
    }
    if ((!StringUtil.isEmpty((String)localObject1)) && (this.jdField_c_of_type_JavaLangString != null)) {
      return a(paramParameters, (String)localObject1);
    }
    return false;
  }
  
  private boolean a(Camera.Parameters paramParameters, String paramString)
  {
    if ((!StringUtil.isEmpty(paramString)) && (this.jdField_c_of_type_JavaLangString != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "set iso to =" + paramString);
      }
      paramParameters.set(this.jdField_c_of_type_JavaLangString, paramString);
      return true;
    }
    return false;
  }
  
  @TargetApi(9)
  private boolean a(Camera.Parameters paramParameters, int[] paramArrayOfInt)
  {
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length != 2)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "setFpsRange " + paramArrayOfInt[0] + " " + paramArrayOfInt[1]);
    }
    paramParameters.setPreviewFpsRange(paramArrayOfInt[0], paramArrayOfInt[1]);
    return true;
  }
  
  @TargetApi(9)
  private int[] a(Camera.Parameters paramParameters)
  {
    int[] arrayOfInt = new int[2];
    paramParameters.getPreviewFpsRange(arrayOfInt);
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "getCurrentFpsRange " + arrayOfInt[0] + " " + arrayOfInt[1]);
    }
    return arrayOfInt;
  }
  
  private void b(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      i();
      this.jdField_a_of_type_Bbun.obtainMessage(1002, new Object[] { paramSurfaceTexture }).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(paramSurfaceTexture);
    }
  }
  
  private boolean b(Camera.Parameters paramParameters)
  {
    if (!this.jdField_c_of_type_Boolean) {
      a(paramParameters);
    }
    return this.jdField_d_of_type_Boolean;
  }
  
  @TargetApi(9)
  private int[] b(Camera.Parameters paramParameters)
  {
    new ArrayList();
    Object localObject = paramParameters.getSupportedPreviewFpsRange();
    paramParameters = new int[2];
    if (localObject != null)
    {
      Iterator localIterator = ((List)localObject).iterator();
      int i = 2147483647;
      localObject = paramParameters;
      if (!localIterator.hasNext()) {
        break label73;
      }
      localObject = (int[])localIterator.next();
      if (localObject[0] >= i) {
        break label121;
      }
      i = localObject[0];
      paramParameters = (Camera.Parameters)localObject;
    }
    label73:
    label121:
    for (;;)
    {
      break;
      localObject = paramParameters;
      if (QLog.isColorLevel()) {
        QLog.i("CameraProxy", 2, "getCurrentFpsRange " + localObject[0] + " " + localObject[1]);
      }
      return localObject;
    }
  }
  
  private void d(int paramInt)
  {
    try
    {
      bmbx.b("CameraProxy", "camera2 open out.");
      this.jdField_a_of_type_Bbun.obtainMessage(1001, new Object[] { Integer.valueOf(paramInt), this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(localRuntimeException);
    }
  }
  
  private void i()
  {
    try
    {
      this.jdField_a_of_type_Bbun.obtainMessage(1060, new Object[] { this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(localRuntimeException);
    }
  }
  
  @TargetApi(14)
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "enterNightMode");
    }
    Camera.Parameters localParameters = bbuc.a().a();
    if (b(localParameters))
    {
      if (StringUtil.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaLangString = a(localParameters);
      }
      a(localParameters);
    }
    if (this.jdField_d_of_type_Int == 2147483647) {
      this.jdField_d_of_type_Int = localParameters.getExposureCompensation();
    }
    localParameters.setExposureCompensation(localParameters.getMaxExposureCompensation());
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      this.jdField_a_of_type_ArrayOfInt = a(localParameters);
    }
    if (this.jdField_b_of_type_ArrayOfInt == null) {
      this.jdField_b_of_type_ArrayOfInt = b(localParameters);
    }
    a(localParameters, this.jdField_b_of_type_ArrayOfInt);
    bbuc.a().a.setParameters(localParameters);
  }
  
  @TargetApi(14)
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "leaveNightMode");
    }
    Camera.Parameters localParameters = bbuc.a().a();
    if ((b(localParameters)) && (!StringUtil.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      a(localParameters, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_d_of_type_Int != 2147483647) {
      localParameters.setExposureCompensation(this.jdField_d_of_type_Int);
    }
    if (this.jdField_a_of_type_ArrayOfInt != null) {
      a(localParameters, this.jdField_a_of_type_ArrayOfInt);
    }
    bbuc.a().a.setParameters(localParameters);
  }
  
  private void l()
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      bbsr.a(1, "[Camera2]initIsSupportCamera2:" + this.jdField_e_of_type_Boolean);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    int k = bbwy.c();
    int j = bbwy.d();
    bbsr.a(1, "[Camera2]initIsSupportCamera2 sdkVersion:" + k + ", camera2Switch:" + j + ", version:" + Build.VERSION.SDK_INT);
    if (Build.VERSION.SDK_INT < 23)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    if ((k <= -1) || (j <= -1))
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    int i = j;
    if (AIOUtils.isSamsungPhone())
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 28)
      {
        i = j;
        if (bnxr.a().d()) {
          i = 1;
        }
      }
    }
    if ((k >= 23) && (Build.VERSION.SDK_INT >= k) && (i != 2))
    {
      this.jdField_b_of_type_Boolean = Camera2Control.a();
      return;
    }
    if (i == 0)
    {
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    this.jdField_b_of_type_Boolean = Camera2Control.a();
    bbsr.a(1, "[Camera2]initIsSupportCamera2 result:" + this.jdField_b_of_type_Boolean);
  }
  
  public bbun a()
  {
    return this.jdField_a_of_type_Bbun;
  }
  
  public void a()
  {
    b(akrw.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Bbun.obtainMessage(1070, paramInt, 0).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(localRuntimeException);
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      this.jdField_a_of_type_Bbun.obtainMessage(6, paramInt2, paramInt3, Integer.valueOf(paramInt1)).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(localRuntimeException);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(long paramLong, String paramString)
  {
    paramString = "Timeout waiting " + paramLong + "ms for " + paramString;
    long l = SystemClock.uptimeMillis() + paramLong;
    try
    {
      bbuw localbbuw = new bbuw();
      this.jdField_a_of_type_Bbun.post(localbbuw.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      synchronized (localbbuw.jdField_a_of_type_JavaLangObject)
      {
        localbbuw.jdField_a_of_type_JavaLangObject.wait(paramLong);
        if (SystemClock.uptimeMillis() > l)
        {
          throw new IllegalStateException(paramString);
          localInterruptedException = localInterruptedException;
          if (SystemClock.uptimeMillis() > l) {
            throw new IllegalStateException(paramString);
          }
        }
      }
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    try
    {
      this.jdField_a_of_type_Bbun.obtainMessage(201, paramSurfaceTexture).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(paramSurfaceTexture);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, bbur parambbur, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (paramSurfaceTexture == null)
      {
        a(-201);
        return;
      }
      if (parambbur != null) {
        a(parambbur);
      }
      b(paramSurfaceTexture);
      return;
    }
    if (paramSurfaceTexture != null)
    {
      a(paramSurfaceTexture, parambbur, paramBoolean);
      return;
    }
    a(paramSurfaceHolder, parambbur, paramBoolean);
  }
  
  public void a(Camera.FaceDetectionListener paramFaceDetectionListener)
  {
    this.jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener = paramFaceDetectionListener;
  }
  
  public void a(Camera.PreviewCallback paramPreviewCallback, boolean paramBoolean)
  {
    int i = 0;
    try
    {
      bbun localbbun = this.jdField_a_of_type_Bbun;
      if (paramBoolean) {
        i = 1;
      }
      localbbun.obtainMessage(203, i, 0, paramPreviewCallback).sendToTarget();
      return;
    }
    catch (RuntimeException paramPreviewCallback)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(paramPreviewCallback);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      this.jdField_a_of_type_Bbun.obtainMessage(202, paramSurfaceHolder).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(paramSurfaceHolder);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, bbur parambbur, boolean paramBoolean)
  {
    if (paramSurfaceHolder != null) {
      a(paramSurfaceHolder);
    }
    if (parambbur != null)
    {
      a(parambbur);
      a(this, paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_Bbun.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(paramSurfaceHolder);
    }
  }
  
  public void a(bbss parambbss, bbup parambbup)
  {
    try
    {
      localbbus = new bbus(this);
      if (!this.jdField_b_of_type_Boolean) {
        break label118;
      }
      i = 1030;
      if ((parambbss != null) && (parambbss.jdField_a_of_type_Boolean) && (parambbup != null))
      {
        parambbup.onAutoFocusCallback(true, true);
        return;
      }
      bbsp localbbsp = new bbsp();
      localbbsp.jdField_a_of_type_Int = 1;
      localbbsp.jdField_a_of_type_Bbsm = new bbul(this, parambbup);
      localbbus.jdField_a_of_type_Bbsp = localbbsp;
      localbbus.jdField_a_of_type_Bbss = parambbss;
    }
    catch (RuntimeException parambbss)
    {
      bbus localbbus;
      int i;
      while (this.jdField_a_of_type_Bbui != null)
      {
        this.jdField_a_of_type_Bbui.a(parambbss);
        return;
        label118:
        if ((parambbss != null) && (parambbss.a()))
        {
          localbbus.jdField_a_of_type_AndroidGraphicsRect = parambbss.jdField_a_of_type_Aktu.a(parambbss.jdField_a_of_type_Float, parambbss.jdField_b_of_type_Float, parambbss.jdField_a_of_type_Int, parambbss.jdField_b_of_type_Int, 1.0F);
          localbbus.b = parambbss.jdField_a_of_type_Aktu.a(parambbss.jdField_a_of_type_Float, parambbss.jdField_b_of_type_Float, parambbss.jdField_a_of_type_Int, parambbss.jdField_b_of_type_Int, 1.5F);
        }
        localbbus.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback = new bbum(this, parambbup);
        i = 103;
      }
    }
    this.jdField_a_of_type_Bbun.obtainMessage(i, localbbus).sendToTarget();
    return;
  }
  
  public void a(bbsx parambbsx)
  {
    this.jdField_a_of_type_Bbuq.a(parambbsx, new int[] { 1, 2, 3, 4, 6, 7, 10, 11, 12, 13, 14 });
  }
  
  public void a(bbuf parambbuf1, bbuf parambbuf2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Bbun.obtainMessage(1005, new Object[] { parambbuf1, parambbuf2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
        return;
      }
      this.jdField_a_of_type_Bbun.obtainMessage(7, new Object[] { parambbuf1, parambbuf2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    catch (RuntimeException parambbuf1)
    {
      if (this.jdField_a_of_type_Bbui != null) {
        this.jdField_a_of_type_Bbui.a(parambbuf1);
      }
    }
  }
  
  public void a(bbui parambbui)
  {
    this.jdField_a_of_type_Bbui = parambbui;
  }
  
  public void a(File paramFile, Rect paramRect, akwr paramakwr, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    bbuv localbbuv = new bbuv(this, null);
    localbbuv.jdField_a_of_type_JavaIoFile = paramFile;
    localbbuv.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    localbbuv.jdField_a_of_type_Akwr = paramakwr;
    localbbuv.jdField_a_of_type_Int = paramInt1;
    localbbuv.jdField_a_of_type_Boolean = paramBoolean;
    localbbuv.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_b_of_type_Boolean)
    {
      localbbuv.jdField_a_of_type_Int = paramInt3;
      this.jdField_a_of_type_Bbun.obtainMessage(1010, localbbuv).sendToTarget();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraProxy", 2, "takePicture : file = " + paramFile + " ; orientation = " + paramInt1);
      }
      return;
      localbbuv.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_Bbun.obtainMessage(301, localbbuv).sendToTarget();
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Bbun.obtainMessage(701, new Object[] { paramString }).sendToTarget();
      return;
    }
    catch (RuntimeException paramString)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      a(null);
      if (!this.jdField_b_of_type_Boolean)
      {
        if (!paramBoolean)
        {
          this.jdField_a_of_type_Bbun.sendEmptyMessage(205);
          return;
        }
        this.jdField_a_of_type_Bbun.obtainMessage(205).sendToTarget();
        a(3500L, "stop preview");
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_Bbui != null) {
        this.jdField_a_of_type_Bbui.a(localRuntimeException);
      }
    }
  }
  
  public void b()
  {
    a(false);
  }
  
  public void b(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraProxy", 2, new Object[] { "cameraCreate, cameraCreate has created, ", Boolean.valueOf(this.jdField_f_of_type_Boolean), " id:", Integer.valueOf(paramInt) });
        }
        if (this.jdField_f_of_type_Boolean)
        {
          Object localObject1 = PeakAppInterface.a;
          if (bmri.jdField_d_of_type_Boolean)
          {
            localObject1 = PeakAppInterface.a;
            if (!bmri.jdField_e_of_type_Boolean) {
              continue;
            }
            localObject1 = PeakAppInterface.a;
            localObject1 = Boolean.valueOf(bmri.jdField_e_of_type_Boolean);
            this.jdField_a_of_type_Bbuq.a(1, new Object[] { localObject1 });
            if (QLog.isColorLevel()) {
              QLog.d("CameraProxy", 2, "cameraCreate, cameraCreate has created and notify");
            }
          }
          return;
          localObject1 = PeakAppInterface.a;
          localObject1 = bmri.jdField_b_of_type_JavaLangString;
          continue;
        }
        this.jdField_f_of_type_Boolean = true;
        l();
        if (this.jdField_b_of_type_Boolean)
        {
          d(paramInt);
          continue;
        }
        try
        {
          this.jdField_a_of_type_Bbun.obtainMessage(1, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
        }
        catch (RuntimeException localRuntimeException) {}
      }
      finally {}
      if (this.jdField_a_of_type_Bbui != null) {
        this.jdField_a_of_type_Bbui.a(localRuntimeException);
      }
    }
  }
  
  public void b(bbsx parambbsx)
  {
    this.jdField_a_of_type_Bbuq.a(parambbsx);
  }
  
  /* Error */
  public void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 138	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 140
    //   10: iconst_2
    //   11: iconst_2
    //   12: anewarray 4	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: ldc_w 632
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: aload_0
    //   24: getfield 604	bbuk:jdField_f_of_type_Boolean	Z
    //   27: invokestatic 561	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   30: aastore
    //   31: invokestatic 609	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   34: aload_0
    //   35: getfield 604	bbuk:jdField_f_of_type_Boolean	Z
    //   38: istore_2
    //   39: iload_2
    //   40: ifne +6 -> 46
    //   43: aload_0
    //   44: monitorexit
    //   45: return
    //   46: aload_0
    //   47: iconst_0
    //   48: putfield 604	bbuk:jdField_f_of_type_Boolean	Z
    //   51: aload_0
    //   52: getfield 387	bbuk:jdField_b_of_type_Boolean	Z
    //   55: ifeq +30 -> 85
    //   58: aload_0
    //   59: invokevirtual 634	bbuk:c	()V
    //   62: new 636	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$1
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 637	com/tencent/mobileqq/shortvideo/mediadevice/CameraProxy$1:<init>	(Lbbuk;)V
    //   70: bipush 16
    //   72: aconst_null
    //   73: iconst_0
    //   74: invokestatic 641	com/tencent/mobileqq/app/ThreadManager:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   77: goto -34 -> 43
    //   80: astore_3
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_3
    //   84: athrow
    //   85: iload_1
    //   86: ifne +34 -> 120
    //   89: aload_0
    //   90: getfield 107	bbuk:jdField_a_of_type_Bbun	Lbbun;
    //   93: iconst_2
    //   94: invokevirtual 592	bbun:sendEmptyMessage	(I)Z
    //   97: pop
    //   98: goto -36 -> 62
    //   101: astore_3
    //   102: aload_0
    //   103: getfield 180	bbuk:jdField_a_of_type_Bbui	Lbbui;
    //   106: ifnull -44 -> 62
    //   109: aload_0
    //   110: getfield 180	bbuk:jdField_a_of_type_Bbui	Lbbui;
    //   113: aload_3
    //   114: invokevirtual 185	bbui:a	(Ljava/lang/RuntimeException;)V
    //   117: goto -55 -> 62
    //   120: aload_0
    //   121: getfield 107	bbuk:jdField_a_of_type_Bbun	Lbbun;
    //   124: iconst_2
    //   125: invokevirtual 173	bbun:obtainMessage	(I)Landroid/os/Message;
    //   128: invokevirtual 178	android/os/Message:sendToTarget	()V
    //   131: aload_0
    //   132: ldc2_w 593
    //   135: ldc_w 643
    //   138: invokevirtual 598	bbuk:a	(JLjava/lang/String;)V
    //   141: goto -79 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	bbuk
    //   0	144	1	paramBoolean	boolean
    //   38	2	2	bool	boolean
    //   80	4	3	localObject	Object
    //   101	13	3	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   2	34	80	finally
    //   34	39	80	finally
    //   46	51	80	finally
    //   51	62	80	finally
    //   62	77	80	finally
    //   89	98	80	finally
    //   102	117	80	finally
    //   120	141	80	finally
    //   51	62	101	java/lang/RuntimeException
    //   89	98	101	java/lang/RuntimeException
    //   120	141	101	java/lang/RuntimeException
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Bbun.obtainMessage(1003).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(localRuntimeException);
    }
  }
  
  public void c(int paramInt)
  {
    int i = 601;
    try
    {
      if (this.jdField_b_of_type_Boolean) {
        i = 1040;
      }
      this.jdField_a_of_type_Bbun.obtainMessage(i, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(localRuntimeException);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i = 1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Bbun.obtainMessage(1050, new Object[] { Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    bbun localbbun = this.jdField_a_of_type_Bbun;
    if (paramBoolean) {}
    for (;;)
    {
      localbbun.obtainMessage(401, i, 0).sendToTarget();
      return;
      i = 2;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bbun.obtainMessage(502, 2, 0).sendToTarget();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    bbun localbbun = this.jdField_a_of_type_Bbun;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbbun.obtainMessage(402, i, 0).sendToTarget();
      return;
    }
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_Bbun.obtainMessage(102).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(localRuntimeException);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    bbsr.a(1, "[Camera2]setCamera2Usable:" + this.jdField_e_of_type_Boolean);
  }
  
  public void f()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Bbun.obtainMessage(1032).sendToTarget();
        return;
      }
      this.jdField_a_of_type_Bbun.obtainMessage(104).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_Bbui != null) {
        this.jdField_a_of_type_Bbui.a(localRuntimeException);
      }
    }
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Bbun.obtainMessage(1031).sendToTarget();
        return;
      }
      this.jdField_a_of_type_Bbun.obtainMessage(101).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_Bbui != null) {
        this.jdField_a_of_type_Bbui.a(localRuntimeException);
      }
    }
  }
  
  public void h()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Bbun.obtainMessage(1021).sendToTarget();
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bbui == null) {}
      this.jdField_a_of_type_Bbui.a(localRuntimeException);
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    bbur localbbur = this.jdField_a_of_type_Bbur;
    if (localbbur != null) {
      localbbur.onPreviewFrame(paramArrayOfByte, paramCamera);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbuk
 * JD-Core Version:    0.7.0.1
 */