import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class aogs
  extends aoez
{
  public aogs(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  protected void a(boolean paramBoolean, aogm paramaogm, int paramInt)
  {
    if (paramInt != ExtendFriendBaseFragment.a(this.a)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramaogm == null));
      localObject = ((ajxl)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (localObject == null);
    ExtendFriendBaseFragment localExtendFriendBaseFragment = this.a;
    if (!TextUtils.isEmpty(paramaogm.mDeclaration)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localExtendFriendBaseFragment.jdField_a_of_type_Boolean = paramBoolean;
      this.a.b = ((Card)localObject).isShowCard;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, String.format("addMyFeed mProfileComplete=%s mShowCard=%s", new Object[] { Boolean.valueOf(this.a.jdField_a_of_type_Boolean), Boolean.valueOf(this.a.b) }));
      }
      if (this.a.jdField_a_of_type_Aoiz == null) {
        break;
      }
      localObject = this.a.jdField_a_of_type_Aoiz.a(0);
      paramaogm.mIsMyFeed = true;
      if ((localObject != null) && (TextUtils.equals(((aogm)localObject).mUin, paramaogm.mUin))) {
        this.a.jdField_a_of_type_Aoiz.b(0);
      }
      this.a.jdField_a_of_type_Aoiz.a(0, paramaogm);
      if (!TextUtils.isEmpty(paramaogm.mDeclaration)) {
        paramaogm.mDeclaration = paramaogm.mDeclaration.replace('\n', ' ').trim();
      }
      if ((!this.a.b) || (!this.a.jdField_a_of_type_Boolean)) {
        this.a.jdField_a_of_type_Aoiz.b(0);
      }
      this.a.jdField_a_of_type_Aoiz.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aogs
 * JD-Core Version:    0.7.0.1
 */