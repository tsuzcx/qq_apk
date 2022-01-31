import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager.1;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class auwo
  implements Manager
{
  bhsk<auwp> jdField_a_of_type_Bhsk = new bhsk();
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  public boolean a;
  
  public auwo(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    bhsk localbhsk = this.jdField_a_of_type_Bhsk.a();
    alxp localalxp = (alxp)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bhsk.a();
    ThreadManager.post(new NearbyReportManager.1(this, localbhsk, localalxp, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    auwp localauwp = (auwp)this.jdField_a_of_type_Bhsk.a(paramLong);
    if (localauwp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "updateRecord ,not exist!! tinyID = " + paramLong);
      }
      return;
    }
    localauwp.c += 1;
    localauwp.d += paramInt1;
    if (paramInt2 > localauwp.e) {
      localauwp.e = paramInt2;
    }
    localauwp.f |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bhsk.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auwo
 * JD-Core Version:    0.7.0.1
 */