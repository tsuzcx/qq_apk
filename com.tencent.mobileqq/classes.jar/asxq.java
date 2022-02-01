import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class asxq
  extends asvt
{
  public asxq(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  protected void a(boolean paramBoolean, asxh paramasxh, int paramInt)
  {
    if (paramInt != ExtendFriendBaseFragment.a(this.a)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramasxh == null));
      localObject = ((anyw)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (localObject == null);
    ExtendFriendBaseFragment localExtendFriendBaseFragment = this.a;
    if (!TextUtils.isEmpty(paramasxh.mDeclaration)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localExtendFriendBaseFragment.jdField_a_of_type_Boolean = paramBoolean;
      this.a.b = ((Card)localObject).isShowCard;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, String.format("addMyFeed mProfileComplete=%s mShowCard=%s", new Object[] { Boolean.valueOf(this.a.jdField_a_of_type_Boolean), Boolean.valueOf(this.a.b) }));
      }
      if (this.a.jdField_a_of_type_Aszx == null) {
        break;
      }
      localObject = this.a.jdField_a_of_type_Aszx.a(0);
      paramasxh.mIsMyFeed = true;
      if ((localObject != null) && (TextUtils.equals(((asxh)localObject).mUin, paramasxh.mUin))) {
        this.a.jdField_a_of_type_Aszx.b(0);
      }
      this.a.jdField_a_of_type_Aszx.a(0, paramasxh);
      if (!TextUtils.isEmpty(paramasxh.mDeclaration)) {
        paramasxh.mDeclaration = paramasxh.mDeclaration.replace('\n', ' ').trim();
      }
      if ((!this.a.b) || (!this.a.jdField_a_of_type_Boolean)) {
        this.a.jdField_a_of_type_Aszx.b(0);
      }
      this.a.jdField_a_of_type_Aszx.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxq
 * JD-Core Version:    0.7.0.1
 */