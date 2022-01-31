import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.SoftReference;

public class awvc
  implements bapx
{
  String jdField_a_of_type_JavaLangString;
  SoftReference<QQAppInterface> jdField_a_of_type_JavaLangRefSoftReference;
  String b;
  String c;
  String d;
  
  public awvc(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString3;
    this.c = paramString2;
    this.d = paramString4;
  }
  
  public void onResp(baqw parambaqw)
  {
    try
    {
      if (parambaqw.a == 0)
      {
        QLog.i("QbossPreDownloadManager", 1, "ResFile has download!");
        if (TextUtils.isEmpty(this.c)) {
          return;
        }
        if (arof.b(this.c))
        {
          parambaqw = new File(this.c);
          File localFile = new File(this.c.substring(0, this.c.lastIndexOf(".")));
          if (!parambaqw.renameTo(localFile)) {
            return;
          }
          long l = localFile.length();
          parambaqw = (QQAppInterface)this.jdField_a_of_type_JavaLangRefSoftReference.get();
          if (parambaqw != null)
          {
            parambaqw = (bavr)parambaqw.getManager(193);
            if (parambaqw.a())
            {
              QLog.i("QbossPreDownloadManager", 1, "preDownloadSuccess");
              parambaqw.a(this.b, l);
            }
          }
          bjmf.a().c(this.d, null);
          return;
        }
        awva.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "2");
        QLog.i("QbossPreDownloadManager", 1, "ResFile check not exist");
        return;
      }
    }
    catch (Exception parambaqw)
    {
      QLog.e("QbossPreDownloadManager", 1, parambaqw, new Object[0]);
      return;
    }
    if (parambaqw.a == 1)
    {
      awva.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "1");
      QLog.i("QbossPreDownloadManager", 1, "ResFile dowload faield");
    }
  }
  
  public void onUpdateProgeress(baqv parambaqv, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awvc
 * JD-Core Version:    0.7.0.1
 */