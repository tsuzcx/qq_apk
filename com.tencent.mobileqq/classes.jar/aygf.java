import android.view.ViewGroup;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.widget.ListView;

public class aygf
  extends ayff<ayjl, ayru>
{
  public aygf(ContactSearchFragment paramContactSearchFragment, ListView paramListView, bcws parambcws)
  {
    super(paramListView, parambcws);
  }
  
  protected aymg<ayjl, ayru> a(int paramInt)
  {
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == -1) {
      return new aynp(this.jdField_a_of_type_Bcws, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.b(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 17) {
      return new aylt(this.jdField_a_of_type_Bcws, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 19) {
      return new ayls(this.jdField_a_of_type_Bcws, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 23) {
      return new aynr(this.jdField_a_of_type_Bcws, null);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 24) {
      return new aynq(this.jdField_a_of_type_Bcws, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    return new aylv(this.jdField_a_of_type_Bcws, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
  }
  
  protected ayrv a(int paramInt, ViewGroup paramViewGroup)
  {
    if ((ayrd.a(ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment))) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 5) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 8)) {
      return new ayro(paramViewGroup, 2131562586);
    }
    if ((ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == -1) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 19) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 24)) {
      return new ayro(paramViewGroup, 2131562585);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 17) {
      return new ayrn(paramViewGroup, 2131560885);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 23) {
      return new aytn(paramViewGroup, 2131560885);
    }
    return new ayro(paramViewGroup, 2131562584);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aygf
 * JD-Core Version:    0.7.0.1
 */