import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager.1;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class axdx
  implements Manager
{
  bkfu<axdy> jdField_a_of_type_Bkfu = new bkfu();
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  public boolean a;
  
  public axdx(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    bkfu localbkfu = this.jdField_a_of_type_Bkfu.a();
    anqv localanqv = (anqv)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bkfu.a();
    ThreadManager.post(new NearbyReportManager.1(this, localbkfu, localanqv, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    axdy localaxdy = (axdy)this.jdField_a_of_type_Bkfu.a(paramLong);
    if (localaxdy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "updateRecord ,not exist!! tinyID = " + paramLong);
      }
      return;
    }
    localaxdy.c += 1;
    localaxdy.d += paramInt1;
    if (paramInt2 > localaxdy.e) {
      localaxdy.e = paramInt2;
    }
    localaxdy.f |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bkfu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axdx
 * JD-Core Version:    0.7.0.1
 */