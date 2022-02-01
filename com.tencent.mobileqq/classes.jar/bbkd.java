import android.view.ViewGroup;
import com.tencent.mobileqq.search.fragment.SelectMemberContactSearchFragment;
import com.tencent.widget.ListView;

public class bbkd
  extends bbip<bbmy, bbvg>
{
  public bbkd(SelectMemberContactSearchFragment paramSelectMemberContactSearchFragment, ListView paramListView, aobu paramaobu)
  {
    super(paramListView, paramaobu);
  }
  
  protected bbps<bbmy, bbvg> a(int paramInt)
  {
    return new bbph(this.jdField_a_of_type_Aobu);
  }
  
  protected bbvh a(int paramInt, ViewGroup paramViewGroup)
  {
    if (bbup.a(SelectMemberContactSearchFragment.a(this.jdField_a_of_type_ComTencentMobileqqSearchFragmentSelectMemberContactSearchFragment))) {
      return new bbva(paramViewGroup, 2131562839);
    }
    return new bbva(paramViewGroup, 2131562840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbkd
 * JD-Core Version:    0.7.0.1
 */