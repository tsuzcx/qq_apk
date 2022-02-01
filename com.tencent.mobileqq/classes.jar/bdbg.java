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
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bdbg
  implements Camera.PreviewCallback, bczh
{
  private static HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  public volatile int a;
  private Camera.FaceDetectionListener jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener;
  public bdbe a;
  public final bdbj a;
  public final bdbm a;
  private bdbn jdField_a_of_type_Bdbn;
  bdbp jdField_a_of_type_Bdbp = new bdbp();
  private String jdField_a_of_type_JavaLangString = "";
  public Map<String, bdbp> a;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  public bdbp b;
  private String jdField_b_of_type_JavaLangString;
  public Map<String, bdbq> b;
  public boolean b;
  private int[] jdField_b_of_type_ArrayOfInt;
  public int c;
  public bdbp c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 2147483647;
  bdbp jdField_d_of_type_Bdbp = new bdbp();
  private boolean jdField_d_of_type_Boolean;
  bdbp jdField_e_of_type_Bdbp = new bdbp();
  private boolean jdField_e_of_type_Boolean;
  bdbp jdField_f_of_type_Bdbp = new bdbp();
  private volatile boolean jdField_f_of_type_Boolean;
  bdbp g = new bdbp();
  bdbp h = new bdbp();
  
  public bdbg(Context arg1, Handler paramHandler)
  {
    this.jdField_b_of_type_Bdbp = new bdbp();
    this.jdField_c_of_type_Bdbp = new bdbp();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_AndroidOsHandlerThread == null)
      {
        jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("Camera2 Handler Thread", 0);
        jdField_a_of_type_AndroidOsHandlerThread.start();
      }
      this.jdField_a_of_type_Bdbm = new bdbm(paramHandler);
      this.jdField_a_of_type_Bdbj = new bdbj(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
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
    if (bhsr.a((String)localObject1)) {
      this.jdField_d_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "getCurrentISO=" + (String)localObject1);
    }
    return localObject1;
  }
  
  private void a(SurfaceTexture paramSurfaceTexture, bdbn parambdbn, boolean paramBoolean)
  {
    if (paramSurfaceTexture != null) {
      a(paramSurfaceTexture);
    }
    if (parambdbn != null)
    {
      a(parambdbn);
      a(this, paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_Bdbj.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(paramSurfaceTexture);
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
  
  private void a(bdbn parambdbn)
  {
    this.jdField_a_of_type_Bdbn = parambdbn;
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
    if ((!bhsr.a((String)localObject1)) && (this.jdField_c_of_type_JavaLangString != null)) {
      return a(paramParameters, (String)localObject1);
    }
    return false;
  }
  
  private boolean a(Camera.Parameters paramParameters, String paramString)
  {
    if ((!bhsr.a(paramString)) && (this.jdField_c_of_type_JavaLangString != null))
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
      this.jdField_a_of_type_Bdbj.obtainMessage(1002, new Object[] { paramSurfaceTexture }).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(paramSurfaceTexture);
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
      bpam.b("CameraProxy", "camera2 open out.");
      this.jdField_a_of_type_Bdbj.obtainMessage(1001, new Object[] { Integer.valueOf(paramInt), this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(localRuntimeException);
    }
  }
  
  private void i()
  {
    try
    {
      this.jdField_a_of_type_Bdbj.obtainMessage(1060, new Object[] { this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(localRuntimeException);
    }
  }
  
  @TargetApi(14)
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "enterNightMode");
    }
    Camera.Parameters localParameters = bday.a().a();
    if (b(localParameters))
    {
      if (bhsr.a(this.jdField_a_of_type_JavaLangString)) {
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
    bday.a().a.setParameters(localParameters);
  }
  
  @TargetApi(14)
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "leaveNightMode");
    }
    Camera.Parameters localParameters = bday.a().a();
    if ((b(localParameters)) && (!bhsr.a(this.jdField_a_of_type_JavaLangString))) {
      a(localParameters, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_d_of_type_Int != 2147483647) {
      localParameters.setExposureCompensation(this.jdField_d_of_type_Int);
    }
    if (this.jdField_a_of_type_ArrayOfInt != null) {
      a(localParameters, this.jdField_a_of_type_ArrayOfInt);
    }
    bday.a().a.setParameters(localParameters);
  }
  
  private void l()
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      bczm.a(1, "[Camera2]initIsSupportCamera2:" + this.jdField_e_of_type_Boolean);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    int k = bddz.e();
    int j = bddz.f();
    bczm.a(1, "[Camera2]initIsSupportCamera2 sdkVersion:" + k + ", camera2Switch:" + j + ", version:" + Build.VERSION.SDK_INT);
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
    if (agej.a())
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 28)
      {
        i = j;
        if (brdw.a().d()) {
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
    bczm.a(1, "[Camera2]initIsSupportCamera2 result:" + this.jdField_b_of_type_Boolean);
  }
  
  public bdbj a()
  {
    return this.jdField_a_of_type_Bdbj;
  }
  
  public void a()
  {
    b(aluf.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Bdbj.obtainMessage(1070, paramInt, 0).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(localRuntimeException);
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      this.jdField_a_of_type_Bdbj.obtainMessage(6, paramInt2, paramInt3, Integer.valueOf(paramInt1)).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(localRuntimeException);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(long paramLong, String paramString)
  {
    paramString = "Timeout waiting " + paramLong + "ms for " + paramString;
    long l = SystemClock.uptimeMillis() + paramLong;
    try
    {
      bdbs localbdbs = new bdbs();
      this.jdField_a_of_type_Bdbj.post(localbdbs.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      synchronized (localbdbs.jdField_a_of_type_JavaLangObject)
      {
        localbdbs.jdField_a_of_type_JavaLangObject.wait(paramLong);
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
      this.jdField_a_of_type_Bdbj.obtainMessage(201, paramSurfaceTexture).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(paramSurfaceTexture);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, bdbn parambdbn, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (paramSurfaceTexture == null)
      {
        a(-201);
        return;
      }
      if (parambdbn != null) {
        a(parambdbn);
      }
      b(paramSurfaceTexture);
      return;
    }
    if (paramSurfaceTexture != null)
    {
      a(paramSurfaceTexture, parambdbn, paramBoolean);
      return;
    }
    a(paramSurfaceHolder, parambdbn, paramBoolean);
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
      bdbj localbdbj = this.jdField_a_of_type_Bdbj;
      if (paramBoolean) {
        i = 1;
      }
      localbdbj.obtainMessage(203, i, 0, paramPreviewCallback).sendToTarget();
      return;
    }
    catch (RuntimeException paramPreviewCallback)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(paramPreviewCallback);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      this.jdField_a_of_type_Bdbj.obtainMessage(202, paramSurfaceHolder).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(paramSurfaceHolder);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, bdbn parambdbn, boolean paramBoolean)
  {
    if (paramSurfaceHolder != null) {
      a(paramSurfaceHolder);
    }
    if (parambdbn != null)
    {
      a(parambdbn);
      a(this, paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_Bdbj.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(paramSurfaceHolder);
    }
  }
  
  public void a(bczn parambczn, bdbl parambdbl)
  {
    try
    {
      localbdbo = new bdbo(this);
      if (!this.jdField_b_of_type_Boolean) {
        break label118;
      }
      i = 1030;
      if ((parambczn != null) && (parambczn.jdField_a_of_type_Boolean) && (parambdbl != null))
      {
        parambdbl.a(true, true);
        return;
      }
      bczk localbczk = new bczk();
      localbczk.jdField_a_of_type_Int = 1;
      localbczk.jdField_a_of_type_Bczh = new bdbh(this, parambdbl);
      localbdbo.jdField_a_of_type_Bczk = localbczk;
      localbdbo.jdField_a_of_type_Bczn = parambczn;
    }
    catch (RuntimeException parambczn)
    {
      bdbo localbdbo;
      int i;
      while (this.jdField_a_of_type_Bdbe != null)
      {
        this.jdField_a_of_type_Bdbe.a(parambczn);
        return;
        label118:
        if ((parambczn != null) && (parambczn.a()))
        {
          localbdbo.jdField_a_of_type_AndroidGraphicsRect = parambczn.jdField_a_of_type_Alwd.a(parambczn.jdField_a_of_type_Float, parambczn.jdField_b_of_type_Float, parambczn.jdField_a_of_type_Int, parambczn.jdField_b_of_type_Int, 1.0F);
          localbdbo.b = parambczn.jdField_a_of_type_Alwd.a(parambczn.jdField_a_of_type_Float, parambczn.jdField_b_of_type_Float, parambczn.jdField_a_of_type_Int, parambczn.jdField_b_of_type_Int, 1.5F);
        }
        localbdbo.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback = new bdbi(this, parambdbl);
        i = 103;
      }
    }
    this.jdField_a_of_type_Bdbj.obtainMessage(i, localbdbo).sendToTarget();
    return;
  }
  
  public void a(bczs parambczs)
  {
    this.jdField_a_of_type_Bdbm.a(parambczs, new int[] { 1, 2, 3, 4, 6, 7, 10, 11, 12, 13, 14 });
  }
  
  public void a(bdbb parambdbb1, bdbb parambdbb2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Bdbj.obtainMessage(1005, new Object[] { parambdbb1, parambdbb2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
        return;
      }
      this.jdField_a_of_type_Bdbj.obtainMessage(7, new Object[] { parambdbb1, parambdbb2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    catch (RuntimeException parambdbb1)
    {
      if (this.jdField_a_of_type_Bdbe != null) {
        this.jdField_a_of_type_Bdbe.a(parambdbb1);
      }
    }
  }
  
  public void a(bdbe parambdbe)
  {
    this.jdField_a_of_type_Bdbe = parambdbe;
  }
  
  public void a(File paramFile, Rect paramRect, amap paramamap, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    bdbr localbdbr = new bdbr(this, null);
    localbdbr.jdField_a_of_type_JavaIoFile = paramFile;
    localbdbr.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    localbdbr.jdField_a_of_type_Amap = paramamap;
    localbdbr.jdField_a_of_type_Int = paramInt1;
    localbdbr.jdField_a_of_type_Boolean = paramBoolean;
    localbdbr.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_b_of_type_Boolean)
    {
      localbdbr.jdField_a_of_type_Int = paramInt3;
      this.jdField_a_of_type_Bdbj.obtainMessage(1010, localbdbr).sendToTarget();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraProxy", 2, "takePicture : file = " + paramFile + " ; orientation = " + paramInt1);
      }
      return;
      localbdbr.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_Bdbj.obtainMessage(301, localbdbr).sendToTarget();
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Bdbj.obtainMessage(701, new Object[] { paramString }).sendToTarget();
      return;
    }
    catch (RuntimeException paramString)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(paramString);
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
          this.jdField_a_of_type_Bdbj.sendEmptyMessage(205);
          return;
        }
        this.jdField_a_of_type_Bdbj.obtainMessage(205).sendToTarget();
        a(3500L, "stop preview");
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_Bdbe != null) {
        this.jdField_a_of_type_Bdbe.a(localRuntimeException);
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
          if (bpmn.jdField_d_of_type_Boolean)
          {
            localObject1 = PeakAppInterface.a;
            if (!bpmn.jdField_e_of_type_Boolean) {
              continue;
            }
            localObject1 = PeakAppInterface.a;
            localObject1 = Boolean.valueOf(bpmn.jdField_e_of_type_Boolean);
            this.jdField_a_of_type_Bdbm.a(1, new Object[] { localObject1 });
            if (QLog.isColorLevel()) {
              QLog.d("CameraProxy", 2, "cameraCreate, cameraCreate has created and notify");
            }
          }
          return;
          localObject1 = PeakAppInterface.a;
          localObject1 = bpmn.jdField_b_of_type_JavaLangString;
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
          this.jdField_a_of_type_Bdbj.obtainMessage(1, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
        }
        catch (RuntimeException localRuntimeException) {}
      }
      finally {}
      if (this.jdField_a_of_type_Bdbe != null) {
        this.jdField_a_of_type_Bdbe.a(localRuntimeException);
      }
    }
  }
  
  public void b(bczs parambczs)
  {
    this.jdField_a_of_type_Bdbm.a(parambczs);
  }
  
  public void b(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("CameraProxy", 2, new Object[] { "cameraDestroyed, cameraCreate has created, ", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
        }
        boolean bool = this.jdField_f_of_type_Boolean;
        if (!bool) {
          return;
        }
        this.jdField_f_of_type_Boolean = false;
        try
        {
          if (!this.jdField_b_of_type_Boolean) {
            break label89;
          }
          c();
        }
        catch (RuntimeException localRuntimeException) {}
        if (this.jdField_a_of_type_Bdbe == null) {
          continue;
        }
        this.jdField_a_of_type_Bdbe.a(localRuntimeException);
        continue;
        if (paramBoolean) {
          break label105;
        }
      }
      finally {}
      label89:
      this.jdField_a_of_type_Bdbj.sendEmptyMessage(2);
      continue;
      label105:
      this.jdField_a_of_type_Bdbj.obtainMessage(2).sendToTarget();
      a(3500L, "release camera");
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Bdbj.obtainMessage(1003).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(localRuntimeException);
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
      this.jdField_a_of_type_Bdbj.obtainMessage(i, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(localRuntimeException);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i = 1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Bdbj.obtainMessage(1050, new Object[] { Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    bdbj localbdbj = this.jdField_a_of_type_Bdbj;
    if (paramBoolean) {}
    for (;;)
    {
      localbdbj.obtainMessage(401, i, 0).sendToTarget();
      return;
      i = 2;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Bdbj.obtainMessage(502, 2, 0).sendToTarget();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    bdbj localbdbj = this.jdField_a_of_type_Bdbj;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localbdbj.obtainMessage(402, i, 0).sendToTarget();
      return;
    }
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_Bdbj.obtainMessage(102).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(localRuntimeException);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    bczm.a(1, "[Camera2]setCamera2Usable:" + this.jdField_e_of_type_Boolean);
  }
  
  public void f()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Bdbj.obtainMessage(1032).sendToTarget();
        return;
      }
      this.jdField_a_of_type_Bdbj.obtainMessage(104).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_Bdbe != null) {
        this.jdField_a_of_type_Bdbe.a(localRuntimeException);
      }
    }
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Bdbj.obtainMessage(1031).sendToTarget();
        return;
      }
      this.jdField_a_of_type_Bdbj.obtainMessage(101).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_Bdbe != null) {
        this.jdField_a_of_type_Bdbe.a(localRuntimeException);
      }
    }
  }
  
  public void h()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Bdbj.obtainMessage(1021).sendToTarget();
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Bdbe == null) {}
      this.jdField_a_of_type_Bdbe.a(localRuntimeException);
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    bdbn localbdbn = this.jdField_a_of_type_Bdbn;
    if (localbdbn != null) {
      localbdbn.a(paramArrayOfByte, paramCamera);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdbg
 * JD-Core Version:    0.7.0.1
 */