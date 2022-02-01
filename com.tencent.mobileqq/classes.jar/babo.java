import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;

class babo
  extends anvi
{
  babo(babn parambabn) {}
  
  protected void onSetSelfSignatureResult(boolean paramBoolean)
  {
    if ((babn.a(this.a) != null) && (((azrb)babn.a(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(babn.b(this.a).getCurrentAccountUin())))
    {
      ExtensionInfo localExtensionInfo = ((anvk)babn.c(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(babn.d(this.a).getCurrentAccountUin());
      if (localExtensionInfo != null) {
        babn.a(this.a, localExtensionInfo.richBuffer, localExtensionInfo.richTime);
      }
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    anvk localanvk;
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length > 0) && (babn.e(this.a) != null))
    {
      localanvk = (anvk)babn.f(this.a).getManager(QQManagerFactory.FRIENDS_MANAGER);
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if (!TextUtils.equals(((azrb)babn.b(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, paramArrayOfString[i])) {
          break label144;
        }
        paramArrayOfString = localanvk.a(((azrb)babn.c(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
        if (paramArrayOfString != null)
        {
          ((azrb)babn.d(this.a)).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramArrayOfString.getRichStatus();
          babn.a(this.a, ((azrb)babn.e(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard, false);
        }
      }
      return;
      label144:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     babo
 * JD-Core Version:    0.7.0.1
 */