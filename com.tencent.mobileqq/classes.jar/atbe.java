import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager.1;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class atbe
  implements Manager
{
  bfms<atbf> jdField_a_of_type_Bfms = new bfms();
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  public boolean a;
  
  public atbe(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    bfms localbfms = this.jdField_a_of_type_Bfms.a();
    akbm localakbm = (akbm)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bfms.a();
    ThreadManager.post(new NearbyReportManager.1(this, localbfms, localakbm, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    atbf localatbf = (atbf)this.jdField_a_of_type_Bfms.a(paramLong);
    if (localatbf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "updateRecord ,not exist!! tinyID = " + paramLong);
      }
      return;
    }
    localatbf.c += 1;
    localatbf.d += paramInt1;
    if (paramInt2 > localatbf.e) {
      localatbf.e = paramInt2;
    }
    localatbf.f |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bfms.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atbe
 * JD-Core Version:    0.7.0.1
 */