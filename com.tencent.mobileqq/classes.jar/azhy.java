import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.qboss.QbossReportManager;
import java.io.File;
import java.lang.ref.SoftReference;

public class azhy
  implements INetEngine.INetEngineListener
{
  String jdField_a_of_type_JavaLangString;
  SoftReference<QQAppInterface> jdField_a_of_type_JavaLangRefSoftReference;
  String b;
  String c;
  String d;
  
  public azhy(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString3;
    this.c = paramString2;
    this.d = paramString4;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    try
    {
      if (paramNetResp.mResult == 0)
      {
        QLog.i("QbossPreDownloadManager", 1, "ResFile has download!");
        if (TextUtils.isEmpty(this.c)) {
          return;
        }
        if (FileUtil.fileExistsAndNotEmpty(this.c))
        {
          paramNetResp = new File(this.c);
          File localFile = new File(this.c.substring(0, this.c.lastIndexOf(".")));
          if (!paramNetResp.renameTo(localFile)) {
            return;
          }
          long l = localFile.length();
          paramNetResp = (QQAppInterface)this.jdField_a_of_type_JavaLangRefSoftReference.get();
          if (paramNetResp != null)
          {
            paramNetResp = (PreDownloadController)paramNetResp.getManager(193);
            if (paramNetResp.isEnable())
            {
              QLog.i("QbossPreDownloadManager", 1, "preDownloadSuccess");
              paramNetResp.preDownloadSuccess(this.b, l);
            }
          }
          QbossReportManager.getInstance().reportExpose(this.d, null);
          return;
        }
        azhw.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "2");
        QLog.i("QbossPreDownloadManager", 1, "ResFile check not exist");
        return;
      }
    }
    catch (Exception paramNetResp)
    {
      QLog.e("QbossPreDownloadManager", 1, paramNetResp, new Object[0]);
      return;
    }
    if (paramNetResp.mResult == 1)
    {
      azhw.a(this.b, this.jdField_a_of_type_JavaLangRefSoftReference, this.jdField_a_of_type_JavaLangString, "1");
      QLog.i("QbossPreDownloadManager", 1, "ResFile dowload faield");
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhy
 * JD-Core Version:    0.7.0.1
 */