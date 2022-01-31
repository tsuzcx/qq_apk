import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.SoftReference;

public class aueh
  implements axrt
{
  String jdField_a_of_type_JavaLangString;
  SoftReference<QQAppInterface> jdField_a_of_type_JavaLangRefSoftReference;
  String b;
  String c;
  String d;
  
  public aueh(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString3;
    this.c = paramString2;
    this.d = paramString4;
  }
  
  public void onResp(axsq paramaxsq)
  {
    try
    {
      if (paramaxsq.a == 0)
      {
        QLog.i("QbossPreDownloadManager", 1, "ResFile has download!");
        if (TextUtils.isEmpty(this.c)) {
          return;
        }
        if (apdh.b(this.c))
        {
          paramaxsq = new File(this.c);
          File localFile = new File(this.c.substring(0, this.c.lastIndexOf(".")));
          if (!paramaxsq.renameTo(localFile)) {
            return;
          }
          long l = localFile.length();
          paramaxsq = (QQAppInterface)this.jdField_a_of_type_JavaLangRefSoftReference.get();
          if (paramaxsq != null)
          {
            paramaxsq = (axxj)paramaxsq.getManager(193);
            if (paramaxsq.a())
            {
              QLog.i("QbossPreDownloadManager", 1, "preDownloadSuccess");
              paramaxsq.a(this.b, l);
            }
          }
          bgbr.a().c(this.d, null);
          return;
        }
        auef.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "2");
        QLog.i("QbossPreDownloadManager", 1, "ResFile check not exist");
        return;
      }
    }
    catch (Exception paramaxsq)
    {
      QLog.e("QbossPreDownloadManager", 1, paramaxsq, new Object[0]);
      return;
    }
    if (paramaxsq.a == 1)
    {
      auef.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "1");
      QLog.i("QbossPreDownloadManager", 1, "ResFile dowload faield");
    }
  }
  
  public void onUpdateProgeress(axsp paramaxsp, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aueh
 * JD-Core Version:    0.7.0.1
 */