import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Set;

public class awvl
  implements alpg
{
  private WeakReference<ProfileHeaderView> a;
  
  public awvl(ProfileHeaderView paramProfileHeaderView)
  {
    this.a = new WeakReference(paramProfileHeaderView);
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (paramInt == 66) && ((paramObject instanceof Set)))
    {
      paramObject = (Set)paramObject;
      ProfileHeaderView localProfileHeaderView = (ProfileHeaderView)this.a.get();
      if (localProfileHeaderView == null) {
        break label80;
      }
      if (paramObject.contains(localProfileHeaderView.jdField_a_of_type_Awqt.a.jdField_a_of_type_JavaLangString))
      {
        localProfileHeaderView.b(localProfileHeaderView.jdField_a_of_type_Awqt, false);
        localProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this);
      }
    }
    label80:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(ProfileHeaderView.jdField_a_of_type_JavaLangString, 2, "Can't get reference to ProfileHeadView.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awvl
 * JD-Core Version:    0.7.0.1
 */