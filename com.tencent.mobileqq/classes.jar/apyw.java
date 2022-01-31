import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class apyw
  extends apxc
{
  public apyw(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  protected void a(boolean paramBoolean, apyo paramapyo, int paramInt)
  {
    if (paramInt != ExtendFriendBaseFragment.a(this.a)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramapyo == null));
      localObject = ((aloz)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (localObject == null);
    ExtendFriendBaseFragment localExtendFriendBaseFragment = this.a;
    if (!TextUtils.isEmpty(paramapyo.mDeclaration)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localExtendFriendBaseFragment.jdField_a_of_type_Boolean = paramBoolean;
      this.a.b = ((Card)localObject).isShowCard;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, String.format("addMyFeed mProfileComplete=%s mShowCard=%s", new Object[] { Boolean.valueOf(this.a.jdField_a_of_type_Boolean), Boolean.valueOf(this.a.b) }));
      }
      if (this.a.jdField_a_of_type_Aqay == null) {
        break;
      }
      localObject = this.a.jdField_a_of_type_Aqay.a(0);
      paramapyo.mIsMyFeed = true;
      if ((localObject != null) && (TextUtils.equals(((apyo)localObject).mUin, paramapyo.mUin))) {
        this.a.jdField_a_of_type_Aqay.b(0);
      }
      this.a.jdField_a_of_type_Aqay.a(0, paramapyo);
      if (!TextUtils.isEmpty(paramapyo.mDeclaration)) {
        paramapyo.mDeclaration = paramapyo.mDeclaration.replace('\n', ' ').trim();
      }
      if ((!this.a.b) || (!this.a.jdField_a_of_type_Boolean)) {
        this.a.jdField_a_of_type_Aqay.b(0);
      }
      this.a.jdField_a_of_type_Aqay.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyw
 * JD-Core Version:    0.7.0.1
 */