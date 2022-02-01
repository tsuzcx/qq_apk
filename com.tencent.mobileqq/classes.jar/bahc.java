import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;

class bahc
  extends anyu
{
  bahc(bahb parambahb) {}
  
  protected void onSetSelfSignatureResult(boolean paramBoolean)
  {
    if ((bahb.a(this.a) != null) && (((azxr)bahb.a(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a.equals(bahb.b(this.a).getCurrentAccountUin())))
    {
      ExtensionInfo localExtensionInfo = ((anyw)bahb.c(this.a).getManager(51)).a(bahb.d(this.a).getCurrentAccountUin());
      if (localExtensionInfo != null) {
        bahb.a(this.a, localExtensionInfo.richBuffer, localExtensionInfo.richTime);
      }
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    anyw localanyw;
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length > 0) && (bahb.e(this.a) != null))
    {
      localanyw = (anyw)bahb.f(this.a).getManager(51);
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if (!TextUtils.equals(((azxr)bahb.b(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, paramArrayOfString[i])) {
          break label143;
        }
        paramArrayOfString = localanyw.a(((azxr)bahb.c(this.a)).jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a);
        if (paramArrayOfString != null)
        {
          ((azxr)bahb.d(this.a)).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramArrayOfString.getRichStatus();
          bahb.a(this.a, ((azxr)bahb.e(this.a)).jdField_a_of_type_ComTencentMobileqqDataCard, false);
        }
      }
      return;
      label143:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bahc
 * JD-Core Version:    0.7.0.1
 */