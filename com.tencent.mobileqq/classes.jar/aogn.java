import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class aogn
  extends aoeu
{
  public aogn(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  protected void a(boolean paramBoolean, aogh paramaogh, int paramInt)
  {
    if (paramInt != ExtendFriendBaseFragment.a(this.a)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramaogh == null));
      localObject = ((ajxn)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (localObject == null);
    ExtendFriendBaseFragment localExtendFriendBaseFragment = this.a;
    if (!TextUtils.isEmpty(paramaogh.mDeclaration)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localExtendFriendBaseFragment.jdField_a_of_type_Boolean = paramBoolean;
      this.a.b = ((Card)localObject).isShowCard;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, String.format("addMyFeed mProfileComplete=%s mShowCard=%s", new Object[] { Boolean.valueOf(this.a.jdField_a_of_type_Boolean), Boolean.valueOf(this.a.b) }));
      }
      if (this.a.jdField_a_of_type_Aoiu == null) {
        break;
      }
      localObject = this.a.jdField_a_of_type_Aoiu.a(0);
      paramaogh.mIsMyFeed = true;
      if ((localObject != null) && (TextUtils.equals(((aogh)localObject).mUin, paramaogh.mUin))) {
        this.a.jdField_a_of_type_Aoiu.b(0);
      }
      this.a.jdField_a_of_type_Aoiu.a(0, paramaogh);
      if (!TextUtils.isEmpty(paramaogh.mDeclaration)) {
        paramaogh.mDeclaration = paramaogh.mDeclaration.replace('\n', ' ').trim();
      }
      if ((!this.a.b) || (!this.a.jdField_a_of_type_Boolean)) {
        this.a.jdField_a_of_type_Aoiu.b(0);
      }
      this.a.jdField_a_of_type_Aoiu.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aogn
 * JD-Core Version:    0.7.0.1
 */