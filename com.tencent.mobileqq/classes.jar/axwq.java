import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager.1;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class axwq
  implements Manager
{
  blgz<axwr> jdField_a_of_type_Blgz = new blgz();
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  public boolean a;
  
  public axwq(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    blgz localblgz = this.jdField_a_of_type_Blgz.a();
    aodb localaodb = (aodb)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Blgz.a();
    ThreadManager.post(new NearbyReportManager.1(this, localblgz, localaodb, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    axwr localaxwr = (axwr)this.jdField_a_of_type_Blgz.a(paramLong);
    if (localaxwr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "updateRecord ,not exist!! tinyID = " + paramLong);
      }
      return;
    }
    localaxwr.c += 1;
    localaxwr.d += paramInt1;
    if (paramInt2 > localaxwr.e) {
      localaxwr.e = paramInt2;
    }
    localaxwr.f |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Blgz.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axwq
 * JD-Core Version:    0.7.0.1
 */