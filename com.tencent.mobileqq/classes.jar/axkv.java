import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.mobileqq.multiaio.widget.MultiAIOBaseViewPager;
import com.tencent.widget.AbsListView;

public class axkv
  implements blih
{
  private boolean jdField_a_of_type_Boolean;
  
  public axkv(MultiAIOItemFragment paramMultiAIOItemFragment, blih paramblih) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Blih.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Blih.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      paramAbsListView = MultiAIOItemFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOItemFragment);
      if ((paramAbsListView != null) && (paramAbsListView.a() == MultiAIOItemFragment.a(this.jdField_a_of_type_ComTencentMobileqqMultiaioMultiAIOItemFragment)) && (!this.jdField_a_of_type_Boolean))
      {
        MultiAIOFragment.a("0X8009F80", 0);
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axkv
 * JD-Core Version:    0.7.0.1
 */