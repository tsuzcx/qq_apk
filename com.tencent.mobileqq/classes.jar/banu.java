import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class banu
  implements beuq
{
  int jdField_a_of_type_Int;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public banu(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString4;
    this.d = paramString2;
    this.c = paramString3;
  }
  
  public void onResp(bevm parambevm)
  {
    try
    {
      if (parambevm.jdField_a_of_type_Int == 0)
      {
        QLog.i("QSplash@QbossSplashDownloadManager", 1, "ResFile has download!");
        if (!TextUtils.isEmpty(this.d))
        {
          if (banw.a(this.d, false))
          {
            parambevm = new File(this.d);
            parambevm.renameTo(new File(this.d.substring(0, this.d.lastIndexOf("."))));
            long l = parambevm.length();
            parambevm = (bezv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
            if (parambevm.a())
            {
              QLog.i("QSplash@QbossSplashUtil", 1, "preDownloadSuccess");
              parambevm.a(this.b, l);
            }
            bans.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_JavaLangString);
            return;
          }
          bans.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          QLog.i("QSplash@QbossSplashUtil", 1, "ResFile check not exist");
        }
      }
      else if (parambevm.jdField_a_of_type_Int == 1)
      {
        bans.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        QLog.i("QSplash@QbossSplashUtil", 1, "ResFile dowload faield");
      }
      return;
    }
    catch (Exception parambevm) {}
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banu
 * JD-Core Version:    0.7.0.1
 */