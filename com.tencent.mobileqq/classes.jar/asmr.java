import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;

public class asmr
{
  private static asmr jdField_a_of_type_Asmr;
  private GameCenterVideoViewController jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
  
  public static asmr a()
  {
    try
    {
      if (jdField_a_of_type_Asmr == null) {
        jdField_a_of_type_Asmr = new asmr();
      }
      asmr localasmr = jdField_a_of_type_Asmr;
      return localasmr;
    }
    finally {}
  }
  
  public GameCenterVideoViewController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.i();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.l();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController = null;
    }
  }
  
  public void a(GameCenterVideoViewController paramGameCenterVideoViewController)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController != paramGameCenterVideoViewController) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.i();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.l();
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController = paramGameCenterVideoViewController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmr
 * JD-Core Version:    0.7.0.1
 */