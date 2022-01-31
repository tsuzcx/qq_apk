import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

class aqyd
  extends aqru
{
  aqyd(aqyc paramaqyc) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, Bundle paramBundle)
  {
    label280:
    for (;;)
    {
      try
      {
        String str1;
        if (arbp.a)
        {
          paramString6 = "183.61.37.13";
          str1 = "443";
          paramString5 = null;
          paramString4 = paramString5;
          if (arbp.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            paramString4 = paramString5;
            if (paramBundle != null)
            {
              String str2 = paramBundle.getString("strHttpsDomain");
              short s2 = paramBundle.getShort("httpsPort", (short)0);
              paramString4 = paramString5;
              if (!TextUtils.isEmpty(str2))
              {
                short s1 = s2;
                if (s2 == 0) {
                  s1 = 443;
                }
                paramString4 = new Bundle();
                paramString4.putBoolean("ishttps", true);
                paramString4.putString("httpsdomain", str2);
                paramString4.putShort("httpsport", s1);
              }
            }
          }
          paramString5 = paramString4;
          if (arsx.a())
          {
            paramString5 = paramString4;
            if (paramBundle != null)
            {
              paramBundle = paramBundle.getString("IPv6Dns");
              paramString5 = paramString4;
              if (paramString4 == null) {
                paramString5 = new Bundle();
              }
              paramString5.putString("ipv6domain", paramBundle);
            }
          }
          if (this.a.jdField_a_of_type_Aqlx != null) {
            this.a.jdField_a_of_type_Aqlx.a(paramBoolean, paramString6, str1, paramInt1, paramString1, paramString3, paramString2, this.a.jdField_a_of_type_JavaLangString, paramString5);
          }
        }
        else
        {
          if ((paramString4 == null) || (paramString4.length() <= 0)) {
            break label280;
          }
          str1 = String.valueOf(paramInt2);
          paramString6 = paramString4;
          continue;
        }
        if (QLog.isColorLevel())
        {
          QLog.e(this.a.b, 2, " callback is null");
          continue;
          paramString4 = paramString5;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyd
 * JD-Core Version:    0.7.0.1
 */