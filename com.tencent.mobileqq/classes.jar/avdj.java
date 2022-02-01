import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;

public class avdj
{
  private static avdj jdField_a_of_type_Avdj;
  private GameCenterVideoViewController jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController;
  
  public static avdj a()
  {
    try
    {
      if (jdField_a_of_type_Avdj == null) {
        jdField_a_of_type_Avdj = new avdj();
      }
      avdj localavdj = jdField_a_of_type_Avdj;
      return localavdj;
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
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.stop();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.release();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController = null;
    }
  }
  
  public void a(GameCenterVideoViewController paramGameCenterVideoViewController)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController != paramGameCenterVideoViewController) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.stop();
      this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.release();
    }
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController = paramGameCenterVideoViewController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdj
 * JD-Core Version:    0.7.0.1
 */