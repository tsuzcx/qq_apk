import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.arengine.ARLocalControl.1;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecog;
import com.tencent.mobileqq.ar.arengine.ARLocalMarkerRecog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apoh
  implements apol, apop, apov
{
  private static final Object jdField_b_of_type_JavaLangObject = new Object();
  private long jdField_a_of_type_Long = 0L;
  apoi jdField_a_of_type_Apoi = null;
  public apoj a;
  ARLocalGestureCircleRecog jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = null;
  ARLocalMarkerRecog jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog = null;
  Object jdField_a_of_type_JavaLangObject = new Object();
  private boolean jdField_a_of_type_Boolean;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  private void a(Context paramContext, int paramInt1, int paramInt2, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo)
  {
    QLog.i("AREngine_ARLocalControl", 1, "initFaceRecogAsync start.");
    ThreadManager.postImmediately(new ARLocalControl.1(this, paramInt1, paramInt2, paramContext, paramARScanStarFaceConfigInfo, System.currentTimeMillis()), null, true);
  }
  
  public void a()
  {
    QLog.i("AREngine_ARLocalControl", 1, "stop start.");
    if (!this.jdField_a_of_type_Boolean) {}
    while (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.d();
    }
    if (this.jdField_a_of_type_Apoj != null) {
      this.jdField_a_of_type_Apoj.e();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.c();
    }
    this.jdField_b_of_type_Boolean = false;
    QLog.i("AREngine_ARLocalControl", 1, "stop end. mIsStarted = " + this.jdField_b_of_type_Boolean);
  }
  
  public void a(long paramLong)
  {
    QLog.i("AREngine_ARLocalControl", 1, "pause. recogType = " + paramLong);
    if (((1L & paramLong) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.b();
    }
    if (((0x4 & paramLong) != 0L) && (this.jdField_a_of_type_Apoj != null)) {
      this.jdField_a_of_type_Apoj.c();
    }
    if (((0x1000 & paramLong) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.a();
    }
  }
  
  public void a(long paramLong, apoz paramapoz)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Apoi != null)) {
        this.jdField_a_of_type_Apoi.a(paramLong, paramapoz);
      }
      return;
    }
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (!this.jdField_b_of_type_Boolean)) {}
    do
    {
      do
      {
        return;
        if (!this.d) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog == null);
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.a(paramLong, paramArrayOfByte);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.a(paramLong, paramArrayOfByte);
      }
    } while (this.jdField_a_of_type_Apoj == null);
    this.jdField_a_of_type_Apoj.a(paramLong, paramArrayOfByte);
  }
  
  public void a(apon paramapon)
  {
    a(4L, paramapon);
  }
  
  public void a(apoq paramapoq)
  {
    a(4096L, paramapoq);
  }
  
  public void a(apox paramapox)
  {
    a(1L, paramapox);
  }
  
  public boolean a()
  {
    QLog.i("AREngine_ARLocalControl", 1, "start start.");
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (this.jdField_b_of_type_Boolean) {
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null) && (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.a()))
    {
      this.jdField_b_of_type_Boolean = false;
      QLog.i("AREngine_ARLocalControl", 1, "start end. marker recog start failed. mIsStarted = " + this.jdField_b_of_type_Boolean);
      return this.jdField_b_of_type_Boolean;
    }
    if ((this.jdField_a_of_type_Apoj != null) && (!this.jdField_a_of_type_Apoj.b()))
    {
      this.jdField_b_of_type_Boolean = false;
      QLog.i("AREngine_ARLocalControl", 1, "start end. face recog start failed. mIsStarted = " + this.jdField_b_of_type_Boolean);
      return this.jdField_b_of_type_Boolean;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null) && (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.c()))
    {
      this.jdField_b_of_type_Boolean = false;
      QLog.i("AREngine_ARLocalControl", 1, "start end. gesture circle recog start failed. mIsStarted = " + this.jdField_b_of_type_Boolean);
      return this.jdField_b_of_type_Boolean;
    }
    this.jdField_b_of_type_Boolean = true;
    QLog.i("AREngine_ARLocalControl", 1, "start end. mIsStarted = " + this.jdField_b_of_type_Boolean);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    if (((1L & paramLong) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.b();
    }
    if (((0x4 & paramLong) != 0L) && (this.jdField_a_of_type_Apoj != null)) {
      return this.jdField_a_of_type_Apoj.c();
    }
    if (((0x1000 & paramLong) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.d();
    }
    return true;
  }
  
  public boolean a(Context arg1, long paramLong, int paramInt1, int paramInt2, ArConfigInfo paramArConfigInfo, ArrayList<ArCloudConfigInfo> paramArrayList, ARScanStarFaceConfigInfo paramARScanStarFaceConfigInfo, apoi paramapoi)
  {
    long l = System.currentTimeMillis();
    QLog.i("AREngine_ARLocalControl", 1, String.format("init start. mIsInited=%s recogType=%s imageWidth=%s imageHeight=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Apoi = paramapoi;
    a(???, paramInt1, paramInt2, paramARScanStarFaceConfigInfo);
    QLog.i("AREngine_ARLocalControl", 1, "init running. marker recog start.");
    paramLong = System.currentTimeMillis();
    if ((this.jdField_a_of_type_Long & 1L) != 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog = new ARLocalMarkerRecog();
      if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.a(paramInt1, paramInt2, paramArConfigInfo, paramArrayList, this)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog = null;
      }
    }
    if ((this.jdField_a_of_type_Long & 0x1000) != 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = new ARLocalGestureCircleRecog();
      if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.a(paramInt1, paramInt2, this)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = null;
      }
    }
    QLog.i("AREngine_ARLocalControl", 1, String.format("init running. marker recog end. time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - paramLong) }));
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      if (!this.c) {
        QLog.i("AREngine_ARLocalControl", 1, "init running. face recog has not init complete, wait...");
      }
    }
    try
    {
      jdField_b_of_type_JavaLangObject.wait();
      label239:
      QLog.i("AREngine_ARLocalControl", 1, "init running. face recog init complete.");
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null) || (this.jdField_a_of_type_Apoj != null) || (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null)) {}
      for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
      {
        this.jdField_b_of_type_Boolean = false;
        QLog.i("AREngine_ARLocalControl", 1, String.format("init end. mIsInited=%s time cost:%sms", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Long.valueOf(System.currentTimeMillis() - l) }));
        appv.a().a(System.currentTimeMillis() - l, this.jdField_a_of_type_Boolean);
        return this.jdField_a_of_type_Boolean;
        paramArConfigInfo = finally;
        throw paramArConfigInfo;
      }
    }
    catch (Exception paramArConfigInfo)
    {
      break label239;
    }
  }
  
  public boolean a(apnv paramapnv)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while (this.jdField_a_of_type_Apoj == null) {
      return false;
    }
    return this.jdField_a_of_type_Apoj.a(paramapnv);
  }
  
  public boolean a(String paramString1, String paramString2, ArCloudConfigInfo paramArCloudConfigInfo)
  {
    if (!this.jdField_b_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.a(paramString1, paramString2, paramArCloudConfigInfo);
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = new ARLocalGestureCircleRecog();
        if (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.a(paramInt1, paramInt2, this))
        {
          this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog = null;
          return false;
        }
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.c();
        this.jdField_b_of_type_Boolean = true;
      }
    }
    for (this.jdField_a_of_type_Long |= 0x1000;; this.jdField_a_of_type_Long &= 0xFFFFEFFF)
    {
      this.d = paramBoolean;
      return this.d;
    }
  }
  
  public float[] a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.a(paramInt1, paramInt2);
  }
  
  public void b()
  {
    QLog.i("AREngine_ARLocalControl", 1, "uninit start.");
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.e();
    }
    if (this.jdField_a_of_type_Apoj != null) {
      this.jdField_a_of_type_Apoj.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.d();
    }
    this.jdField_a_of_type_Boolean = false;
    QLog.i("AREngine_ARLocalControl", 1, "uninit end. mIsInited = " + this.jdField_a_of_type_Boolean);
  }
  
  public void b(long paramLong)
  {
    QLog.i("AREngine_ARLocalControl", 1, "resume. recogType = " + paramLong);
    if (((1L & paramLong) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalMarkerRecog.c();
    }
    if (((0x4 & paramLong) != 0L) && (this.jdField_a_of_type_Apoj != null)) {
      this.jdField_a_of_type_Apoj.d();
    }
    if (((0x1000 & paramLong) != 0L) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.b();
    }
  }
  
  public boolean b(long paramLong)
  {
    if (((0x4 & paramLong) != 0L) && (this.jdField_a_of_type_Apoj != null)) {
      return this.jdField_a_of_type_Apoj.d();
    }
    return true;
  }
  
  public void c()
  {
    if ((this.d) && (this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog != null) && (!this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.d())) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARLocalGestureCircleRecog.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apoh
 * JD-Core Version:    0.7.0.1
 */