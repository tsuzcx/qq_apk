import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.SoftReference;

public class avdn
  implements aysa
{
  String jdField_a_of_type_JavaLangString;
  SoftReference<QQAppInterface> jdField_a_of_type_JavaLangRefSoftReference;
  String b;
  String c;
  String d;
  
  public avdn(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString3;
    this.c = paramString2;
    this.d = paramString4;
  }
  
  public void onResp(aysx paramaysx)
  {
    try
    {
      if (paramaysx.a == 0)
      {
        QLog.i("QbossPreDownloadManager", 1, "ResFile has download!");
        if (TextUtils.isEmpty(this.c)) {
          return;
        }
        if (apvb.b(this.c))
        {
          paramaysx = new File(this.c);
          File localFile = new File(this.c.substring(0, this.c.lastIndexOf(".")));
          if (!paramaysx.renameTo(localFile)) {
            return;
          }
          long l = localFile.length();
          paramaysx = (QQAppInterface)this.jdField_a_of_type_JavaLangRefSoftReference.get();
          if (paramaysx != null)
          {
            paramaysx = (ayxq)paramaysx.getManager(193);
            if (paramaysx.a())
            {
              QLog.i("QbossPreDownloadManager", 1, "preDownloadSuccess");
              paramaysx.a(this.b, l);
            }
          }
          bhkd.a().c(this.d, null);
          return;
        }
        avdl.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "2");
        QLog.i("QbossPreDownloadManager", 1, "ResFile check not exist");
        return;
      }
    }
    catch (Exception paramaysx)
    {
      QLog.e("QbossPreDownloadManager", 1, paramaysx, new Object[0]);
      return;
    }
    if (paramaysx.a == 1)
    {
      avdl.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "1");
      QLog.i("QbossPreDownloadManager", 1, "ResFile dowload faield");
    }
  }
  
  public void onUpdateProgeress(aysw paramaysw, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avdn
 * JD-Core Version:    0.7.0.1
 */