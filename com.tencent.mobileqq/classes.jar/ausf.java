import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager.1;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class ausf
  implements Manager
{
  bhod<ausg> jdField_a_of_type_Bhod = new bhod();
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  public boolean a;
  
  public ausf(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    bhod localbhod = this.jdField_a_of_type_Bhod.a();
    alta localalta = (alta)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bhod.a();
    ThreadManager.post(new NearbyReportManager.1(this, localbhod, localalta, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    ausg localausg = (ausg)this.jdField_a_of_type_Bhod.a(paramLong);
    if (localausg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "updateRecord ,not exist!! tinyID = " + paramLong);
      }
      return;
    }
    localausg.c += 1;
    localausg.d += paramInt1;
    if (paramInt2 > localausg.e) {
      localausg.e = paramInt2;
    }
    localausg.f |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bhod.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ausf
 * JD-Core Version:    0.7.0.1
 */