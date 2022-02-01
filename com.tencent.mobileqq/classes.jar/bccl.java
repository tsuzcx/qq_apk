import android.view.ViewGroup;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.widget.ListView;

public class bccl
  extends bcbj<bcfr, bcnz>
{
  public bccl(ContactSearchFragment paramContactSearchFragment, ListView paramListView, aoof paramaoof)
  {
    super(paramListView, paramaoof);
  }
  
  protected bcil<bcfr, bcnz> a(int paramInt)
  {
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == -1) {
      return new bcju(this.jdField_a_of_type_Aoof, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.b(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 17) {
      return new bchy(this.jdField_a_of_type_Aoof, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 19) {
      return new bchx(this.jdField_a_of_type_Aoof, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 23) {
      return new bcjw(this.jdField_a_of_type_Aoof, null);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 24) {
      return new bcjv(this.jdField_a_of_type_Aoof, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    return new bcia(this.jdField_a_of_type_Aoof, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
  }
  
  protected bcoa a(int paramInt, ViewGroup paramViewGroup)
  {
    if ((bcni.a(ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment))) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 5) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 8)) {
      return new bcnt(paramViewGroup, 2131562876);
    }
    if ((ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == -1) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 19) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 24)) {
      return new bcnt(paramViewGroup, 2131562875);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 17) {
      return new bcns(paramViewGroup, 2131561145);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 23) {
      return new bcpq(paramViewGroup, 2131561145);
    }
    return new bcnt(paramViewGroup, 2131562874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bccl
 * JD-Core Version:    0.7.0.1
 */