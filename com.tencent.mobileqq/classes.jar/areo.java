import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.qphone.base.util.QLog;

public class areo
  extends arem
  implements bbwd
{
  protected bbwe a;
  protected String a;
  
  public areo(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, aren paramaren)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, paramInt, paramaren);
  }
  
  public static bbwd a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString, aren paramaren)
  {
    if (paramaren == null)
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader fileInfo is null");
      return null;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader strTmpFilePath is err");
      return null;
    }
    if (!paramaren.a())
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader fileInfo is err");
      return null;
    }
    paramQQAppInterface = new areo(paramQQAppInterface, paramLong1, paramLong2, 1, paramaren);
    paramQQAppInterface.a(paramString);
    return paramQQAppInterface;
  }
  
  protected ExcitingTransferDownloadConfig a()
  {
    return areh.a().c();
  }
  
  protected String a()
  {
    return alof.bm;
  }
  
  protected void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    super.a(paramInt, paramExcitingTransferDownloadCompletedInfo);
    if (this.jdField_a_of_type_Bbwe != null)
    {
      Bundle localBundle = new Bundle();
      if (paramExcitingTransferDownloadCompletedInfo != null) {
        localBundle.putInt("nSrvReturnCode", paramExcitingTransferDownloadCompletedInfo.m_nSrvReturnCode);
      }
      this.jdField_a_of_type_Bbwe.a(true, a(), paramInt, "", "", localBundle);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    super.a(paramLong1, paramLong2, paramLong3);
    if (this.jdField_a_of_type_Bbwe != null) {
      this.jdField_a_of_type_Bbwe.a(paramLong2, this.jdField_a_of_type_Aren.a());
    }
  }
  
  public void a(bbwe parambbwe)
  {
    this.jdField_a_of_type_Bbwe = parambbwe;
  }
  
  protected void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    super.a(paramExcitingTransferDownloadCompletedInfo);
    if (this.jdField_a_of_type_Bbwe != null) {
      this.jdField_a_of_type_Bbwe.a(paramExcitingTransferDownloadCompletedInfo.m_strFileSavePath);
    }
  }
  
  protected void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int b()
  {
    if (a() != null) {
      return a().m_uRetryTimes;
    }
    return 0;
  }
  
  protected String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
    a();
  }
  
  public boolean b()
  {
    return false;
  }
  
  public int c()
  {
    return 0;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    QLog.i("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "Id[" + this.d + "] cancelTask");
    a();
  }
  
  public int d()
  {
    if (a() != null) {
      return a().m_uProxyType;
    }
    return 0;
  }
  
  public String d()
  {
    if (a() != null) {
      return a().m_strLastServerHost;
    }
    return "";
  }
  
  public String e()
  {
    if (a() != null) {
      return a().m_strLastServerHost;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     areo
 * JD-Core Version:    0.7.0.1
 */