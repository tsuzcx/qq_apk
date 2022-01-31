import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.SoftReference;

public class avdp
  implements aysc
{
  String jdField_a_of_type_JavaLangString;
  SoftReference<QQAppInterface> jdField_a_of_type_JavaLangRefSoftReference;
  String b;
  String c;
  String d;
  
  public avdp(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString3;
    this.c = paramString2;
    this.d = paramString4;
  }
  
  public void onResp(aysz paramaysz)
  {
    try
    {
      if (paramaysz.a == 0)
      {
        QLog.i("QbossPreDownloadManager", 1, "ResFile has download!");
        if (TextUtils.isEmpty(this.c)) {
          return;
        }
        if (apvd.b(this.c))
        {
          paramaysz = new File(this.c);
          File localFile = new File(this.c.substring(0, this.c.lastIndexOf(".")));
          if (!paramaysz.renameTo(localFile)) {
            return;
          }
          long l = localFile.length();
          paramaysz = (QQAppInterface)this.jdField_a_of_type_JavaLangRefSoftReference.get();
          if (paramaysz != null)
          {
            paramaysz = (ayxs)paramaysz.getManager(193);
            if (paramaysz.a())
            {
              QLog.i("QbossPreDownloadManager", 1, "preDownloadSuccess");
              paramaysz.a(this.b, l);
            }
          }
          bhku.a().c(this.d, null);
          return;
        }
        avdn.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "2");
        QLog.i("QbossPreDownloadManager", 1, "ResFile check not exist");
        return;
      }
    }
    catch (Exception paramaysz)
    {
      QLog.e("QbossPreDownloadManager", 1, paramaysz, new Object[0]);
      return;
    }
    if (paramaysz.a == 1)
    {
      avdn.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "1");
      QLog.i("QbossPreDownloadManager", 1, "ResFile dowload faield");
    }
  }
  
  public void onUpdateProgeress(aysy paramaysy, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avdp
 * JD-Core Version:    0.7.0.1
 */