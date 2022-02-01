import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.nearby.NearbyReportManager.1;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class axqa
  implements Manager
{
  bkyb<axqb> jdField_a_of_type_Bkyb = new bkyb();
  NearbyAppInterface jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface;
  public boolean a;
  
  public axqa(NearbyAppInterface paramNearbyAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyReportManager", 2, "report");
    }
    bkyb localbkyb = this.jdField_a_of_type_Bkyb.a();
    anzr localanzr = (anzr)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.a(axoc.c);
    boolean bool = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bkyb.a();
    ThreadManager.post(new NearbyReportManager.1(this, localbkyb, localanzr, bool), 5, null, false);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    axqb localaxqb = (axqb)this.jdField_a_of_type_Bkyb.a(paramLong);
    if (localaxqb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyReportManager", 2, "updateRecord ,not exist!! tinyID = " + paramLong);
      }
      return;
    }
    localaxqb.c += 1;
    localaxqb.d += paramInt1;
    if (paramInt2 > localaxqb.e) {
      localaxqb.e = paramInt2;
    }
    localaxqb.f |= paramInt3;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Bkyb.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqa
 * JD-Core Version:    0.7.0.1
 */