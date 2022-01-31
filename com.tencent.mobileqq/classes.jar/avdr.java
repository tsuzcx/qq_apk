import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class avdr
  implements aysa
{
  int jdField_a_of_type_Int;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public avdr(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString4;
    this.d = paramString2;
    this.c = paramString3;
  }
  
  public void onResp(aysx paramaysx)
  {
    try
    {
      if (paramaysx.jdField_a_of_type_Int == 0)
      {
        QLog.i("QSplash@QbossSplashDownloadManager", 1, "ResFile has download!");
        if (!TextUtils.isEmpty(this.d))
        {
          if (avdt.a(this.d, false))
          {
            paramaysx = new File(this.d);
            paramaysx.renameTo(new File(this.d.substring(0, this.d.lastIndexOf("."))));
            long l = paramaysx.length();
            paramaysx = (ayxq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
            if (paramaysx.a())
            {
              QLog.i("QSplash@QbossSplashUtil", 1, "preDownloadSuccess");
              paramaysx.a(this.b, l);
            }
            avdp.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_JavaLangString);
            return;
          }
          avdp.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          QLog.i("QSplash@QbossSplashUtil", 1, "ResFile check not exist");
        }
      }
      else if (paramaysx.jdField_a_of_type_Int == 1)
      {
        avdp.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        QLog.i("QSplash@QbossSplashUtil", 1, "ResFile dowload faield");
      }
      return;
    }
    catch (Exception paramaysx) {}
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avdr
 * JD-Core Version:    0.7.0.1
 */