import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;

public class aqdi
  implements bjhk
{
  private long jdField_a_of_type_Long;
  private boolean jdField_a_of_type_Boolean = true;
  
  public aqdi(ExtendFriendCampusFragment paramExtendFriendCampusFragment) {}
  
  private boolean a()
  {
    long l = System.nanoTime();
    if (l - this.jdField_a_of_type_Long < 400000000L) {
      return true;
    }
    this.jdField_a_of_type_Long = l;
    return false;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) || (a())) {
      return;
    }
    ExtendFriendCampusFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment).a();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = System.nanoTime();
  }
  
  public void b()
  {
    if ((!this.jdField_a_of_type_Boolean) || (a())) {
      return;
    }
    ExtendFriendCampusFragment.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendCampusFragment).b();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = System.nanoTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqdi
 * JD-Core Version:    0.7.0.1
 */