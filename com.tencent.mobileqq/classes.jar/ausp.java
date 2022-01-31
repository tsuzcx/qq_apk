import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;

public class ausp
  extends bcmi
{
  private NearbyAppInterface a;
  
  public ausp(NearbyAppInterface paramNearbyAppInterface, String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public UsingTimeReportManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
      return null;
    }
    return (UsingTimeReportManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(221);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.reportClickEvent("dc00899", this.jdField_a_of_type_JavaLangString, "", this.b, this.c, 0, 0, String.valueOf(paramLong), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ausp
 * JD-Core Version:    0.7.0.1
 */