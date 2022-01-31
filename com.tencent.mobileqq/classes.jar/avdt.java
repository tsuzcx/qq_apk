import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class avdt
  implements aysc
{
  int jdField_a_of_type_Int;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  String d;
  
  public avdt(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString4;
    this.d = paramString2;
    this.c = paramString3;
  }
  
  public void onResp(aysz paramaysz)
  {
    try
    {
      if (paramaysz.jdField_a_of_type_Int == 0)
      {
        QLog.i("QSplash@QbossSplashDownloadManager", 1, "ResFile has download!");
        if (!TextUtils.isEmpty(this.d))
        {
          if (avdv.a(this.d, false))
          {
            paramaysz = new File(this.d);
            paramaysz.renameTo(new File(this.d.substring(0, this.d.lastIndexOf("."))));
            long l = paramaysz.length();
            paramaysz = (ayxs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(193);
            if (paramaysz.a())
            {
              QLog.i("QSplash@QbossSplashUtil", 1, "preDownloadSuccess");
              paramaysz.a(this.b, l);
            }
            avdr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), this.jdField_a_of_type_JavaLangString);
            return;
          }
          avdr.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
          QLog.i("QSplash@QbossSplashUtil", 1, "ResFile check not exist");
        }
      }
      else if (paramaysz.jdField_a_of_type_Int == 1)
      {
        avdr.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString);
        QLog.i("QSplash@QbossSplashUtil", 1, "ResFile dowload faield");
      }
      return;
    }
    catch (Exception paramaysz) {}
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avdt
 * JD-Core Version:    0.7.0.1
 */