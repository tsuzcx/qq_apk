import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.troop.widget.UsingTimeReportManager;

public class axqk
  extends bgnb
{
  protected long a;
  private NearbyAppInterface a;
  
  public axqk(NearbyAppInterface paramNearbyAppInterface, String paramString1, String paramString2, String paramString3)
  {
    super(paramString1, paramString2, paramString3);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface = paramNearbyAppInterface;
  }
  
  public UsingTimeReportManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
      return null;
    }
    return (UsingTimeReportManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getManager(axoc.o);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
      return;
    }
    new aymp().b("nearby").c("nearby_tab_staying").a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()).g(String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long)).d(String.valueOf(paramInt1)).e(String.valueOf(paramInt2)).a();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.reportClickEvent("dc00899", this.jdField_a_of_type_JavaLangString, "", this.b, this.c, 0, 0, String.valueOf(paramLong), "", "", "");
    new aymp().b("nearby").c("nearby_page_staying").a(this.jdField_a_of_type_ComTencentMobileqqNearbyNearbyAppInterface.getCurrentAccountUin()).g(String.valueOf(paramLong)).f(String.valueOf(axns.a())).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axqk
 * JD-Core Version:    0.7.0.1
 */