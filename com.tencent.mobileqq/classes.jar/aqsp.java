import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;

public class aqsp
{
  private static aqsp jdField_a_of_type_Aqsp;
  private GameCenterVideoViewController jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
  
  public static aqsp a()
  {
    try
    {
      if (jdField_a_of_type_Aqsp == null) {
        jdField_a_of_type_Aqsp = new aqsp();
      }
      aqsp localaqsp = jdField_a_of_type_Aqsp;
      return localaqsp;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqsp
 * JD-Core Version:    0.7.0.1
 */