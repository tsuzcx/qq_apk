import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;
import mqq.app.QQPermissionCallback;

class bett
  implements QQPermissionCallback
{
  bett(bets parambets) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    TribeVideoPreviewFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment, false);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.a(this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bett
 * JD-Core Version:    0.7.0.1
 */