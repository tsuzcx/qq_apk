import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager.1;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class awjy
  implements Manager
{
  bjmo<awjz> jdField_a_of_type_Bjmo = new bjmo();
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  public boolean a;
  
  public awjy(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    bjmo localbjmo = this.jdField_a_of_type_Bjmo.a();
    amxd localamxd = (amxd)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bjmo.a();
    ThreadManager.post(new NearbyReportManager.1(this, localbjmo, localamxd, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    awjz localawjz = (awjz)this.jdField_a_of_type_Bjmo.a(paramLong);
    if (localawjz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "updateRecord ,not exist!! tinyID = " + paramLong);
      }
      return;
    }
    localawjz.c += 1;
    localawjz.d += paramInt1;
    if (paramInt2 > localawjz.e) {
      localawjz.e = paramInt2;
    }
    localawjz.f |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bjmo.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awjy
 * JD-Core Version:    0.7.0.1
 */