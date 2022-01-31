import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vashealth.PathTraceManager;
import com.tencent.mobileqq.vashealth.TracePointsData;
import com.tencent.qphone.base.util.QLog;

public class bdyo
  extends ampt
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public bdyo(PathTraceManager paramPathTraceManager, AppInterface paramAppInterface)
  {
    super(0, true, true, 0L, true, true, "pathtrace");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 3) {
      QLog.d("PathTraceManager", 1, "Consecutive Err");
    }
    super.onConsecutiveFailure(paramInt1, paramInt2);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      Object localObject = paramSosoLbsInfo.a;
      paramSosoLbsInfo = new TracePointsData();
      paramSosoLbsInfo.time = NetConnInfoCenter.getServerTime();
      paramSosoLbsInfo.latitude = ((float)((SosoInterface.SosoLocation)localObject).jdField_a_of_type_Double);
      paramSosoLbsInfo.longitude = ((float)((SosoInterface.SosoLocation)localObject).jdField_b_of_type_Double);
      paramSosoLbsInfo.altitude = ((SosoInterface.SosoLocation)localObject).e;
      paramSosoLbsInfo.accuracy = ((int)((SosoInterface.SosoLocation)localObject).jdField_a_of_type_Float);
      paramSosoLbsInfo.speed = ((SosoInterface.SosoLocation)localObject).jdField_b_of_type_Float;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        localObject = (PathTraceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(210);
        if (localObject != null) {
          ((PathTraceManager)localObject).a(paramSosoLbsInfo);
        }
      }
      return;
    }
    PathTraceManager.b(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager, PathTraceManager.b(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager));
    if (PathTraceManager.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager) != null) {
      this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager.a(PathTraceManager.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager));
    }
    QLog.e("PathTraceManager", 1, "Location Err: " + paramInt);
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1.equals("gps")) && (paramInt == 0)) {
      QLog.d("PathTraceManager", 1, "GPS shutdown");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyo
 * JD-Core Version:    0.7.0.1
 */