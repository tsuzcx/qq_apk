import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.SoftReference;

public class awzl
  implements baug
{
  String jdField_a_of_type_JavaLangString;
  SoftReference<QQAppInterface> jdField_a_of_type_JavaLangRefSoftReference;
  String b;
  String c;
  String d;
  
  public awzl(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString3;
    this.c = paramString2;
    this.d = paramString4;
  }
  
  public void onResp(bavf parambavf)
  {
    try
    {
      if (parambavf.a == 0)
      {
        QLog.i("QbossPreDownloadManager", 1, "ResFile has download!");
        if (TextUtils.isEmpty(this.c)) {
          return;
        }
        if (arso.b(this.c))
        {
          parambavf = new File(this.c);
          File localFile = new File(this.c.substring(0, this.c.lastIndexOf(".")));
          if (!parambavf.renameTo(localFile)) {
            return;
          }
          long l = localFile.length();
          parambavf = (QQAppInterface)this.jdField_a_of_type_JavaLangRefSoftReference.get();
          if (parambavf != null)
          {
            parambavf = (bbaa)parambavf.getManager(193);
            if (parambavf.a())
            {
              QLog.i("QbossPreDownloadManager", 1, "preDownloadSuccess");
              parambavf.a(this.b, l);
            }
          }
          bjqm.a().c(this.d, null);
          return;
        }
        awzj.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "2");
        QLog.i("QbossPreDownloadManager", 1, "ResFile check not exist");
        return;
      }
    }
    catch (Exception parambavf)
    {
      QLog.e("QbossPreDownloadManager", 1, parambavf, new Object[0]);
      return;
    }
    if (parambavf.a == 1)
    {
      awzj.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "1");
      QLog.i("QbossPreDownloadManager", 1, "ResFile dowload faield");
    }
  }
  
  public void onUpdateProgeress(bave parambave, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awzl
 * JD-Core Version:    0.7.0.1
 */