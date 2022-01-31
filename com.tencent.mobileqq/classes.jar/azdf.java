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

public class azdf
  implements Camera.PreviewCallback, azbg
{
  public static HandlerThread a;
  public volatile int a;
  private Camera.FaceDetectionListener jdField_a_of_type_AndroidHardwareCamera$FaceDetectionListener;
  public azdd a;
  public final azdi a;
  public final azdl a;
  private azdm jdField_a_of_type_Azdm;
  azdo jdField_a_of_type_Azdo = new azdo();
  private String jdField_a_of_type_JavaLangString = "";
  public Map<String, azdo> a;
  public boolean a;
  private int[] jdField_a_of_type_ArrayOfInt;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  public int b;
  public azdo b;
  private String jdField_b_of_type_JavaLangString;
  public Map<String, azdp> b;
  public boolean b;
  private int[] jdField_b_of_type_ArrayOfInt;
  public int c;
  public azdo c;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 2147483647;
  azdo jdField_d_of_type_Azdo = new azdo();
  private boolean jdField_d_of_type_Boolean;
  azdo jdField_e_of_type_Azdo = new azdo();
  private boolean jdField_e_of_type_Boolean;
  azdo jdField_f_of_type_Azdo = new azdo();
  private volatile boolean jdField_f_of_type_Boolean;
  azdo g = new azdo();
  azdo h = new azdo();
  
  public azdf(Context paramContext, Handler paramHandler)
  {
    this.jdField_b_of_type_Azdo = new azdo();
    this.jdField_c_of_type_Azdo = new azdo();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    if (jdField_a_of_type_AndroidOsHandlerThread == null)
    {
      jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("Camera2 Handler Thread", 0);
      jdField_a_of_type_AndroidOsHandlerThread.start();
    }
    this.jdField_a_of_type_Azdl = new azdl(paramHandler);
    this.jdField_a_of_type_Azdi = new azdi(this, jdField_a_of_type_AndroidOsHandlerThread.getLooper());
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
    if (bdje.a((String)localObject1)) {
      this.jdField_d_of_type_Boolean = false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "getCurrentISO=" + (String)localObject1);
    }
    return localObject1;
  }
  
  private void a(SurfaceTexture paramSurfaceTexture, azdm paramazdm, boolean paramBoolean)
  {
    if (paramSurfaceTexture != null) {
      a(paramSurfaceTexture);
    }
    if (paramazdm != null)
    {
      a(paramazdm);
      a(this, paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_Azdi.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(paramSurfaceTexture);
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
  
  private void a(azdm paramazdm)
  {
    this.jdField_a_of_type_Azdm = paramazdm;
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
    if ((!bdje.a((String)localObject1)) && (this.jdField_c_of_type_JavaLangString != null)) {
      return a(paramParameters, (String)localObject1);
    }
    return false;
  }
  
  private boolean a(Camera.Parameters paramParameters, String paramString)
  {
    if ((!bdje.a(paramString)) && (this.jdField_c_of_type_JavaLangString != null))
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
      this.jdField_a_of_type_Azdi.obtainMessage(1002, new Object[] { paramSurfaceTexture }).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(paramSurfaceTexture);
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
      blfg.b("CameraProxy", "camera2 open out.");
      this.jdField_a_of_type_Azdi.obtainMessage(1001, new Object[] { Integer.valueOf(paramInt), this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(localRuntimeException);
    }
  }
  
  private void i()
  {
    try
    {
      this.jdField_a_of_type_Azdi.obtainMessage(1060, new Object[] { this }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(localRuntimeException);
    }
  }
  
  @TargetApi(14)
  private void j()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "enterNightMode");
    }
    Camera.Parameters localParameters = azcx.a().a();
    if (b(localParameters))
    {
      if (bdje.a(this.jdField_a_of_type_JavaLangString)) {
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
    azcx.a().a.setParameters(localParameters);
  }
  
  @TargetApi(14)
  private void k()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraProxy", 2, "leaveNightMode");
    }
    Camera.Parameters localParameters = azcx.a().a();
    if ((b(localParameters)) && (!bdje.a(this.jdField_a_of_type_JavaLangString))) {
      a(localParameters, this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_d_of_type_Int != 2147483647) {
      localParameters.setExposureCompensation(this.jdField_d_of_type_Int);
    }
    if (this.jdField_a_of_type_ArrayOfInt != null) {
      a(localParameters, this.jdField_a_of_type_ArrayOfInt);
    }
    azcx.a().a.setParameters(localParameters);
  }
  
  private void l()
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      azbl.a(1, "[Camera2]initIsSupportCamera2:" + this.jdField_e_of_type_Boolean);
      this.jdField_b_of_type_Boolean = false;
      return;
    }
    int k = azfz.e();
    int j = azfz.f();
    azbl.a(1, "[Camera2]initIsSupportCamera2 sdkVersion:" + k + ", camera2Switch:" + j + ", version:" + Build.VERSION.SDK_INT);
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
    if (aekt.a())
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 28)
      {
        i = j;
        if (bngq.a().d()) {
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
    azbl.a(1, "[Camera2]initIsSupportCamera2 result:" + this.jdField_b_of_type_Boolean);
  }
  
  public azdi a()
  {
    return this.jdField_a_of_type_Azdi;
  }
  
  public void a()
  {
    b(ajli.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Azdi.obtainMessage(1070, paramInt, 0).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(localRuntimeException);
    }
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      this.jdField_a_of_type_Azdi.obtainMessage(6, paramInt2, paramInt3, Integer.valueOf(paramInt1)).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(localRuntimeException);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(long paramLong, String paramString)
  {
    paramString = "Timeout waiting " + paramLong + "ms for " + paramString;
    long l = SystemClock.uptimeMillis() + paramLong;
    try
    {
      azdr localazdr = new azdr();
      this.jdField_a_of_type_Azdi.post(localazdr.jdField_a_of_type_JavaLangRunnable);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      synchronized (localazdr.jdField_a_of_type_JavaLangObject)
      {
        localazdr.jdField_a_of_type_JavaLangObject.wait(paramLong);
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
      this.jdField_a_of_type_Azdi.obtainMessage(201, paramSurfaceTexture).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceTexture)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(paramSurfaceTexture);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, SurfaceHolder paramSurfaceHolder, azdm paramazdm, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (paramSurfaceTexture == null)
      {
        a(-201);
        return;
      }
      if (paramazdm != null) {
        a(paramazdm);
      }
      b(paramSurfaceTexture);
      return;
    }
    if (paramSurfaceTexture != null)
    {
      a(paramSurfaceTexture, paramazdm, paramBoolean);
      return;
    }
    a(paramSurfaceHolder, paramazdm, paramBoolean);
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
      azdi localazdi = this.jdField_a_of_type_Azdi;
      if (paramBoolean) {
        i = 1;
      }
      localazdi.obtainMessage(203, i, 0, paramPreviewCallback).sendToTarget();
      return;
    }
    catch (RuntimeException paramPreviewCallback)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(paramPreviewCallback);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      this.jdField_a_of_type_Azdi.obtainMessage(202, paramSurfaceHolder).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(paramSurfaceHolder);
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder, azdm paramazdm, boolean paramBoolean)
  {
    if (paramSurfaceHolder != null) {
      a(paramSurfaceHolder);
    }
    if (paramazdm != null)
    {
      a(paramazdm);
      a(this, paramBoolean);
    }
    try
    {
      this.jdField_a_of_type_Azdi.obtainMessage(204).sendToTarget();
      return;
    }
    catch (RuntimeException paramSurfaceHolder)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(paramSurfaceHolder);
    }
  }
  
  public void a(azbm paramazbm, azdk paramazdk)
  {
    try
    {
      localazdn = new azdn(this);
      if (!this.jdField_b_of_type_Boolean) {
        break label118;
      }
      i = 1030;
      if ((paramazbm != null) && (paramazbm.jdField_a_of_type_Boolean) && (paramazdk != null))
      {
        paramazdk.a(true, true);
        return;
      }
      azbj localazbj = new azbj();
      localazbj.jdField_a_of_type_Int = 1;
      localazbj.jdField_a_of_type_Azbg = new azdg(this, paramazdk);
      localazdn.jdField_a_of_type_Azbj = localazbj;
      localazdn.jdField_a_of_type_Azbm = paramazbm;
    }
    catch (RuntimeException paramazbm)
    {
      azdn localazdn;
      int i;
      while (this.jdField_a_of_type_Azdd != null)
      {
        this.jdField_a_of_type_Azdd.a(paramazbm);
        return;
        label118:
        if ((paramazbm != null) && (paramazbm.a()))
        {
          localazdn.jdField_a_of_type_AndroidGraphicsRect = paramazbm.jdField_a_of_type_Ajng.a(paramazbm.jdField_a_of_type_Float, paramazbm.jdField_b_of_type_Float, paramazbm.jdField_a_of_type_Int, paramazbm.jdField_b_of_type_Int, 1.0F);
          localazdn.b = paramazbm.jdField_a_of_type_Ajng.a(paramazbm.jdField_a_of_type_Float, paramazbm.jdField_b_of_type_Float, paramazbm.jdField_a_of_type_Int, paramazbm.jdField_b_of_type_Int, 1.5F);
        }
        localazdn.jdField_a_of_type_AndroidHardwareCamera$AutoFocusCallback = new azdh(this, paramazdk);
        i = 103;
      }
    }
    this.jdField_a_of_type_Azdi.obtainMessage(i, localazdn).sendToTarget();
    return;
  }
  
  public void a(azbr paramazbr)
  {
    this.jdField_a_of_type_Azdl.a(paramazbr, new int[] { 1, 2, 3, 4, 6, 7, 10, 11, 12, 13, 14 });
  }
  
  public void a(azda paramazda1, azda paramazda2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Azdi.obtainMessage(1005, new Object[] { paramazda1, paramazda2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
        return;
      }
      this.jdField_a_of_type_Azdi.obtainMessage(7, new Object[] { paramazda1, paramazda2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    catch (RuntimeException paramazda1)
    {
      if (this.jdField_a_of_type_Azdd != null) {
        this.jdField_a_of_type_Azdd.a(paramazda1);
      }
    }
  }
  
  public void a(azdd paramazdd)
  {
    this.jdField_a_of_type_Azdd = paramazdd;
  }
  
  public void a(File paramFile, Rect paramRect, ajrs paramajrs, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    azdq localazdq = new azdq(this, null);
    localazdq.jdField_a_of_type_JavaIoFile = paramFile;
    localazdq.jdField_a_of_type_AndroidGraphicsRect = paramRect;
    localazdq.jdField_a_of_type_Ajrs = paramajrs;
    localazdq.jdField_a_of_type_Int = paramInt1;
    localazdq.jdField_a_of_type_Boolean = paramBoolean;
    localazdq.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_b_of_type_Boolean)
    {
      localazdq.jdField_a_of_type_Int = paramInt3;
      this.jdField_a_of_type_Azdi.obtainMessage(1010, localazdq).sendToTarget();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CameraProxy", 2, "takePicture : file = " + paramFile + " ; orientation = " + paramInt1);
      }
      return;
      localazdq.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_Azdi.obtainMessage(301, localazdq).sendToTarget();
    }
  }
  
  public void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_Azdi.obtainMessage(701, new Object[] { paramString }).sendToTarget();
      return;
    }
    catch (RuntimeException paramString)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(paramString);
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
          this.jdField_a_of_type_Azdi.sendEmptyMessage(205);
          return;
        }
        this.jdField_a_of_type_Azdi.obtainMessage(205).sendToTarget();
        a(3500L, "stop preview");
        return;
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_Azdd != null) {
        this.jdField_a_of_type_Azdd.a(localRuntimeException);
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
          if (blnc.jdField_d_of_type_Boolean)
          {
            localObject1 = PeakAppInterface.a;
            if (!blnc.jdField_e_of_type_Boolean) {
              continue;
            }
            localObject1 = PeakAppInterface.a;
            localObject1 = Boolean.valueOf(blnc.jdField_e_of_type_Boolean);
            this.jdField_a_of_type_Azdl.a(1, new Object[] { localObject1 });
            if (QLog.isColorLevel()) {
              QLog.d("CameraProxy", 2, "cameraCreate, cameraCreate has created and notify");
            }
          }
          return;
          localObject1 = PeakAppInterface.a;
          localObject1 = blnc.jdField_b_of_type_JavaLangString;
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
          this.jdField_a_of_type_Azdi.obtainMessage(1, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
        }
        catch (RuntimeException localRuntimeException) {}
      }
      finally {}
      if (this.jdField_a_of_type_Azdd != null) {
        this.jdField_a_of_type_Azdd.a(localRuntimeException);
      }
    }
  }
  
  public void b(azbr paramazbr)
  {
    this.jdField_a_of_type_Azdl.a(paramazbr);
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
        if (this.jdField_a_of_type_Azdd == null) {
          continue;
        }
        this.jdField_a_of_type_Azdd.a(localRuntimeException);
        continue;
        if (paramBoolean) {
          break label105;
        }
      }
      finally {}
      label89:
      this.jdField_a_of_type_Azdi.sendEmptyMessage(2);
      continue;
      label105:
      this.jdField_a_of_type_Azdi.obtainMessage(2).sendToTarget();
      a(3500L, "release camera");
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_Azdi.obtainMessage(1003).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(localRuntimeException);
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
      this.jdField_a_of_type_Azdi.obtainMessage(i, new Object[] { Integer.valueOf(paramInt) }).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(localRuntimeException);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i = 1;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_Azdi.obtainMessage(1050, new Object[] { Boolean.valueOf(paramBoolean) }).sendToTarget();
      return;
    }
    azdi localazdi = this.jdField_a_of_type_Azdi;
    if (paramBoolean) {}
    for (;;)
    {
      localazdi.obtainMessage(401, i, 0).sendToTarget();
      return;
      i = 2;
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_Azdi.obtainMessage(502, 2, 0).sendToTarget();
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    azdi localazdi = this.jdField_a_of_type_Azdi;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localazdi.obtainMessage(402, i, 0).sendToTarget();
      return;
    }
  }
  
  public void e()
  {
    try
    {
      this.jdField_a_of_type_Azdi.obtainMessage(102).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(localRuntimeException);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
    azbl.a(1, "[Camera2]setCamera2Usable:" + this.jdField_e_of_type_Boolean);
  }
  
  public void f()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Azdi.obtainMessage(1032).sendToTarget();
        return;
      }
      this.jdField_a_of_type_Azdi.obtainMessage(104).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_Azdd != null) {
        this.jdField_a_of_type_Azdd.a(localRuntimeException);
      }
    }
  }
  
  public void g()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Azdi.obtainMessage(1031).sendToTarget();
        return;
      }
      this.jdField_a_of_type_Azdi.obtainMessage(101).sendToTarget();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      if (this.jdField_a_of_type_Azdd != null) {
        this.jdField_a_of_type_Azdd.a(localRuntimeException);
      }
    }
  }
  
  public void h()
  {
    try
    {
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_Azdi.obtainMessage(1021).sendToTarget();
      }
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      while (this.jdField_a_of_type_Azdd == null) {}
      this.jdField_a_of_type_Azdd.a(localRuntimeException);
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    azdm localazdm = this.jdField_a_of_type_Azdm;
    if (localazdm != null) {
      localazdm.a(paramArrayOfByte, paramCamera);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdf
 * JD-Core Version:    0.7.0.1
 */