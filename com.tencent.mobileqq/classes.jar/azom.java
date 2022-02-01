import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

class azom
  extends anmu
{
  azom(azol paramazol) {}
  
  protected void onSetSelfSignatureResult(boolean paramBoolean)
  {
    if ((azol.a(this.a) != null) && (((azfe)azol.a(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(azol.b(this.a).getCurrentAccountUin())))
    {
      ExtensionInfo localExtensionInfo = ((anmw)azol.c(this.a).getManager(51)).a(azol.d(this.a).getCurrentAccountUin());
      if (localExtensionInfo != null) {
        azol.a(this.a, localExtensionInfo.richBuffer, localExtensionInfo.richTime);
      }
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    anmw localanmw;
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length > 0) && (azol.e(this.a) != null))
    {
      localanmw = (anmw)azol.f(this.a).getManager(51);
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if (!TextUtils.equals(((azfe)azol.b(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, paramArrayOfString[i])) {
          break label143;
        }
        paramArrayOfString = localanmw.a(((azfe)azol.c(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
        if (paramArrayOfString != null)
        {
          ((azfe)azol.d(this.a)).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramArrayOfString.getRichStatus();
          azol.a(this.a, ((azfe)azol.e(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard, false);
        }
      }
      return;
      label143:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azom
 * JD-Core Version:    0.7.0.1
 */