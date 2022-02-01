import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.SoftReference;

public class azva
  implements bdvw
{
  String jdField_a_of_type_JavaLangString;
  SoftReference<QQAppInterface> jdField_a_of_type_JavaLangRefSoftReference;
  String b;
  String c;
  String d;
  
  public azva(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString3;
    this.c = paramString2;
    this.d = paramString4;
  }
  
  public void onResp(bdwt parambdwt)
  {
    try
    {
      if (parambdwt.a == 0)
      {
        QLog.i("QbossPreDownloadManager", 1, "ResFile has download!");
        if (TextUtils.isEmpty(this.c)) {
          return;
        }
        if (atwl.b(this.c))
        {
          parambdwt = new File(this.c);
          File localFile = new File(this.c.substring(0, this.c.lastIndexOf(".")));
          if (!parambdwt.renameTo(localFile)) {
            return;
          }
          long l = localFile.length();
          parambdwt = (QQAppInterface)this.jdField_a_of_type_JavaLangRefSoftReference.get();
          if (parambdwt != null)
          {
            parambdwt = (beaw)parambdwt.getManager(193);
            if (parambdwt.a())
            {
              QLog.i("QbossPreDownloadManager", 1, "preDownloadSuccess");
              parambdwt.a(this.b, l);
            }
          }
          bmev.a().c(this.d, null);
          return;
        }
        azuy.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "2");
        QLog.i("QbossPreDownloadManager", 1, "ResFile check not exist");
        return;
      }
    }
    catch (Exception parambdwt)
    {
      QLog.e("QbossPreDownloadManager", 1, parambdwt, new Object[0]);
      return;
    }
    if (parambdwt.a == 1)
    {
      azuy.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "1");
      QLog.i("QbossPreDownloadManager", 1, "ResFile dowload faield");
    }
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azva
 * JD-Core Version:    0.7.0.1
 */