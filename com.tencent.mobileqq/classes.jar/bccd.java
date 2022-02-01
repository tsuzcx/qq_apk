import android.view.ViewGroup;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.widget.ListView;

public class bccd
  extends bcbd<bcfj, bcnt>
{
  public bccd(ContactSearchFragment paramContactSearchFragment, ListView paramListView, FaceDecoder paramFaceDecoder)
  {
    super(paramListView, paramFaceDecoder);
  }
  
  protected bcif<bcfj, bcnt> a(int paramInt)
  {
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == -1) {
      return new bcjo(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.b(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 17) {
      return new bchs(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 19) {
      return new bchr(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 23) {
      return new bcjq(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, null);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 24) {
      return new bcjp(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
    }
    return new bchu(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder, ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment), ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment));
  }
  
  protected bcnu a(int paramInt, ViewGroup paramViewGroup)
  {
    if ((bcnc.a(ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment))) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 5) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 8)) {
      return new bcnn(paramViewGroup, 2131562826);
    }
    if ((ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == -1) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 19) || (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 24)) {
      return new bcnn(paramViewGroup, 2131562825);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 17) {
      return new bcnm(paramViewGroup, 2131561080);
    }
    if (ContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment) == 23) {
      return new bcpk(paramViewGroup, 2131561080);
    }
    return new bcnn(paramViewGroup, 2131562824);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bccd
 * JD-Core Version:    0.7.0.1
 */