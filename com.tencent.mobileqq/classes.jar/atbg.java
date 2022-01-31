import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager.1;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class atbg
  implements Manager
{
  bfnj<atbh> jdField_a_of_type_Bfnj = new bfnj();
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  public boolean a;
  
  public atbg(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    bfnj localbfnj = this.jdField_a_of_type_Bfnj.a();
    akbl localakbl = (akbl)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bfnj.a();
    ThreadManager.post(new NearbyReportManager.1(this, localbfnj, localakbl, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    atbh localatbh = (atbh)this.jdField_a_of_type_Bfnj.a(paramLong);
    if (localatbh == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "updateRecord ,not exist!! tinyID = " + paramLong);
      }
      return;
    }
    localatbh.c += 1;
    localatbh.d += paramInt1;
    if (paramInt2 > localatbh.e) {
      localatbh.e = paramInt2;
    }
    localatbh.f |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bfnj.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atbg
 * JD-Core Version:    0.7.0.1
 */