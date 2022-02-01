import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class asod
  extends aslz
{
  public asod(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  protected void a(boolean paramBoolean, asnq paramasnq, int paramInt)
  {
    if (paramInt != ExtendFriendBaseFragment.a(this.a)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramasnq == null));
      localObject = ((anvk)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    } while (localObject == null);
    ExtendFriendBaseFragment localExtendFriendBaseFragment = this.a;
    if (!TextUtils.isEmpty(paramasnq.mDeclaration)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localExtendFriendBaseFragment.jdField_a_of_type_Boolean = paramBoolean;
      this.a.b = ((Card)localObject).isShowCard;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, String.format("addMyFeed mProfileComplete=%s mShowCard=%s", new Object[] { Boolean.valueOf(this.a.jdField_a_of_type_Boolean), Boolean.valueOf(this.a.b) }));
      }
      if (this.a.jdField_a_of_type_Asqk == null) {
        break;
      }
      localObject = this.a.jdField_a_of_type_Asqk.a(0);
      paramasnq.mIsMyFeed = true;
      if ((localObject != null) && (TextUtils.equals(((asnq)localObject).mUin, paramasnq.mUin))) {
        this.a.jdField_a_of_type_Asqk.b(0);
      }
      this.a.jdField_a_of_type_Asqk.a(0, paramasnq);
      if (!TextUtils.isEmpty(paramasnq.mDeclaration)) {
        paramasnq.mDeclaration = paramasnq.mDeclaration.replace('\n', ' ').trim();
      }
      if ((!this.a.b) || (!this.a.jdField_a_of_type_Boolean)) {
        this.a.jdField_a_of_type_Asqk.b(0);
      }
      this.a.jdField_a_of_type_Asqk.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asod
 * JD-Core Version:    0.7.0.1
 */