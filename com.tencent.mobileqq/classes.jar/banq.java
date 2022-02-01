import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.SoftReference;

public class banq
  implements beuq
{
  String jdField_a_of_type_JavaLangString;
  SoftReference<QQAppInterface> jdField_a_of_type_JavaLangRefSoftReference;
  String b;
  String c;
  String d;
  
  public banq(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString3;
    this.c = paramString2;
    this.d = paramString4;
  }
  
  public void onResp(bevm parambevm)
  {
    try
    {
      if (parambevm.a == 0)
      {
        QLog.i("QbossPreDownloadManager", 1, "ResFile has download!");
        if (TextUtils.isEmpty(this.c)) {
          return;
        }
        if (auog.b(this.c))
        {
          parambevm = new File(this.c);
          File localFile = new File(this.c.substring(0, this.c.lastIndexOf(".")));
          if (!parambevm.renameTo(localFile)) {
            return;
          }
          long l = localFile.length();
          parambevm = (QQAppInterface)this.jdField_a_of_type_JavaLangRefSoftReference.get();
          if (parambevm != null)
          {
            parambevm = (bezv)parambevm.getManager(193);
            if (parambevm.a())
            {
              QLog.i("QbossPreDownloadManager", 1, "preDownloadSuccess");
              parambevm.a(this.b, l);
            }
          }
          bnfx.a().c(this.d, null);
          return;
        }
        bano.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "2");
        QLog.i("QbossPreDownloadManager", 1, "ResFile check not exist");
        return;
      }
    }
    catch (Exception parambevm)
    {
      QLog.e("QbossPreDownloadManager", 1, parambevm, new Object[0]);
      return;
    }
    if (parambevm.a == 1)
    {
      bano.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "1");
      QLog.i("QbossPreDownloadManager", 1, "ResFile dowload faield");
    }
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banq
 * JD-Core Version:    0.7.0.1
 */