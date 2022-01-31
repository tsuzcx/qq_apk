import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.troop.troopCard.VisitorTroopCardFragment;
import com.tencent.mobileqq.troop.widget.AvatarWallViewPagerAdapter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;

public class bagj
  implements bfos
{
  int jdField_a_of_type_Int = 0;
  
  public bagj(VisitorTroopCardFragment paramVisitorTroopCardFragment) {}
  
  private int a(AbsListView paramAbsListView)
  {
    int i = 0;
    View localView = paramAbsListView.getChildAt(0);
    if (localView == null) {
      return 0;
    }
    int j = paramAbsListView.getFirstVisiblePosition();
    int k = localView.getTop();
    if (j >= 1) {
      i = paramAbsListView.getHeight();
    }
    k = -k;
    return i + (localView.getHeight() * j + k);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment) == null) || (VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment).a().size() == 0)) {
      return;
    }
    paramInt1 = a(paramAbsListView);
    VisitorTroopCardFragment localVisitorTroopCardFragment = null;
    if ((paramInt1 > this.jdField_a_of_type_Int) && (paramInt1 >= this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_Int) && (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.getVisibility() != 0))
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
      if ((paramAbsListView != null) && (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.getAnimation()))
      {
        paramAbsListView.reset();
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(paramAbsListView);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation(paramAbsListView);
        localVisitorTroopCardFragment = this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment;
        if (paramAbsListView != this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_AndroidViewAnimationAlphaAnimation) {
          break label215;
        }
      }
    }
    label215:
    for (boolean bool = true;; bool = false)
    {
      VisitorTroopCardFragment.a(localVisitorTroopCardFragment, bool);
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment);
      this.jdField_a_of_type_Int = paramInt1;
      return;
      paramAbsListView = localVisitorTroopCardFragment;
      if (paramInt1 >= this.jdField_a_of_type_Int) {
        break;
      }
      paramAbsListView = localVisitorTroopCardFragment;
      if (paramInt1 > this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_Int) {
        break;
      }
      paramAbsListView = localVisitorTroopCardFragment;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.getVisibility() != 0) {
        break;
      }
      paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment.b;
      break;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment) != null) && (VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment).a)) {
      VisitorTroopCardFragment.a(this.jdField_a_of_type_ComTencentMobileqqTroopTroopCardVisitorTroopCardFragment, paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bagj
 * JD-Core Version:    0.7.0.1
 */