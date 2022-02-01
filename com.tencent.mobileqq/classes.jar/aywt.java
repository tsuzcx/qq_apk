import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

class aywt
  extends amsu
{
  aywt(ayws paramayws) {}
  
  protected void onSetSelfSignatureResult(boolean paramBoolean)
  {
    if ((ayws.a(this.a) != null) && (((aymg)ayws.a(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(ayws.b(this.a).getCurrentAccountUin())))
    {
      ExtensionInfo localExtensionInfo = ((amsw)ayws.c(this.a).getManager(51)).a(ayws.d(this.a).getCurrentAccountUin());
      if (localExtensionInfo != null) {
        ayws.a(this.a, localExtensionInfo.richBuffer, localExtensionInfo.richTime);
      }
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    amsw localamsw;
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length > 0) && (ayws.e(this.a) != null))
    {
      localamsw = (amsw)ayws.f(this.a).getManager(51);
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if (!TextUtils.equals(((aymg)ayws.b(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, paramArrayOfString[i])) {
          break label143;
        }
        paramArrayOfString = localamsw.a(((aymg)ayws.c(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
        if (paramArrayOfString != null)
        {
          ((aymg)ayws.d(this.a)).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramArrayOfString.getRichStatus();
          ayws.a(this.a, ((aymg)ayws.e(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard, false);
        }
      }
      return;
      label143:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywt
 * JD-Core Version:    0.7.0.1
 */