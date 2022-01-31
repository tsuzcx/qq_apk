import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.qphone.base.util.QLog;

public class anqb
  extends anoj
{
  public anqb(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  protected void a(boolean paramBoolean, anpv paramanpv, int paramInt)
  {
    if (paramInt != ExtendFriendBaseFragment.a(this.a)) {}
    Object localObject;
    do
    {
      do
      {
        return;
      } while ((!paramBoolean) || (paramanpv == null));
      localObject = ((ajjj)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    } while (localObject == null);
    ExtendFriendBaseFragment localExtendFriendBaseFragment = this.a;
    if (!TextUtils.isEmpty(paramanpv.mDeclaration)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      localExtendFriendBaseFragment.jdField_a_of_type_Boolean = paramBoolean;
      this.a.b = ((Card)localObject).isShowCard;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendBaseFragment", 2, String.format("addMyFeed mProfileComplete=%s mShowCard=%s", new Object[] { Boolean.valueOf(this.a.jdField_a_of_type_Boolean), Boolean.valueOf(this.a.b) }));
      }
      if (this.a.jdField_a_of_type_Ansi == null) {
        break;
      }
      localObject = this.a.jdField_a_of_type_Ansi.a(0);
      paramanpv.mIsMyFeed = true;
      if ((localObject != null) && (TextUtils.equals(((anpv)localObject).mUin, paramanpv.mUin))) {
        this.a.jdField_a_of_type_Ansi.b(0);
      }
      this.a.jdField_a_of_type_Ansi.a(0, paramanpv);
      if (!TextUtils.isEmpty(paramanpv.mDeclaration)) {
        paramanpv.mDeclaration = paramanpv.mDeclaration.replace('\n', ' ').trim();
      }
      if ((!this.a.b) || (!this.a.jdField_a_of_type_Boolean)) {
        this.a.jdField_a_of_type_Ansi.b(0);
      }
      this.a.jdField_a_of_type_Ansi.notifyDataSetChanged();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anqb
 * JD-Core Version:    0.7.0.1
 */