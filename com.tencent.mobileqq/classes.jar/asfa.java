import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager.1;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class asfa
  implements Manager
{
  beey<asfb> jdField_a_of_type_Beey = new beey();
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  public boolean a;
  
  public asfa(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    beey localbeey = this.jdField_a_of_type_Beey.a();
    ajnd localajnd = (ajnd)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(3);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Beey.a();
    ThreadManager.post(new NearbyReportManager.1(this, localbeey, localajnd, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    asfb localasfb = (asfb)this.jdField_a_of_type_Beey.a(paramLong);
    if (localasfb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "updateRecord ,not exist!! tinyID = " + paramLong);
      }
      return;
    }
    localasfb.c += 1;
    localasfb.d += paramInt1;
    if (paramInt2 > localasfb.e) {
      localasfb.e = paramInt2;
    }
    localasfb.f |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Beey.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     asfa
 * JD-Core Version:    0.7.0.1
 */