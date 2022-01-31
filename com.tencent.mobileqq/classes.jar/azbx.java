import com.tencent.mobileqq.tribe.fragment.TribeVideoPreviewFragment;
import mqq.app.QQPermissionCallback;

class azbx
  implements QQPermissionCallback
{
  azbx(azbw paramazbw) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    TribeVideoPreviewFragment.a(this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment, false);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqTribeFragmentTribeVideoPreviewFragment.a(this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azbx
 * JD-Core Version:    0.7.0.1
 */