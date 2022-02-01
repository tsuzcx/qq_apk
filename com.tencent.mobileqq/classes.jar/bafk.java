import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import java.lang.ref.WeakReference;
import java.util.Set;

public class bafk
  implements anui
{
  private WeakReference<AbsProfileHeaderView> a;
  
  public bafk(AbsProfileHeaderView paramAbsProfileHeaderView)
  {
    this.a = new WeakReference(paramAbsProfileHeaderView);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramInt == 66) && ((paramObject instanceof Set)))
    {
      paramObject = (Set)paramObject;
      AbsProfileHeaderView localAbsProfileHeaderView = (AbsProfileHeaderView)this.a.get();
      if ((localAbsProfileHeaderView != null) && (paramObject.contains(localAbsProfileHeaderView.jdField_a_of_type_Azxr.a.a)))
      {
        localAbsProfileHeaderView.b(localAbsProfileHeaderView.jdField_a_of_type_Azxr, false);
        localAbsProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bafk
 * JD-Core Version:    0.7.0.1
 */