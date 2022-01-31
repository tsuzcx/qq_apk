import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.search.fragment.ContactSearchFragment;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;

public class azlb
  implements View.OnFocusChangeListener
{
  public azlb(NewTroopContactView paramNewTroopContactView) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramView = this.a.a();
      if (paramView != null)
      {
        paramView.d(true);
        paramView.a(NewTroopContactView.a(this.a), this.a.jdField_a_of_type_JavaUtilArrayList);
        FragmentTransaction localFragmentTransaction = this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopCreateActivity.getSupportFragmentManager().beginTransaction();
        if (this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment != null) {
          localFragmentTransaction.remove(this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment);
        }
        localFragmentTransaction.add(2131375189, paramView);
        localFragmentTransaction.commitAllowingStateLoss();
        this.a.jdField_a_of_type_ComTencentMobileqqSearchFragmentContactSearchFragment = paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlb
 * JD-Core Version:    0.7.0.1
 */