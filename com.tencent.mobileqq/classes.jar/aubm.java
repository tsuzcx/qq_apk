import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.qphone.base.util.QLog;

public class aubm
  extends aubk
  implements bfwj
{
  protected bfwk a;
  protected String b;
  
  public aubm(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, aubl paramaubl)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, paramInt, paramaubl);
  }
  
  public static bfwj a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString, aubl paramaubl)
  {
    if (paramaubl == null)
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader fileInfo is null");
      return null;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader strTmpFilePath is err");
      return null;
    }
    if (!paramaubl.a())
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader fileInfo is err");
      return null;
    }
    paramQQAppInterface = new aubm(paramQQAppInterface, paramLong1, paramLong2, 1, paramaubl);
    paramQQAppInterface.a(paramString);
    return paramQQAppInterface;
  }
  
  protected ExcitingTransferDownloadConfig a()
  {
    return aubf.a().b();
  }
  
  protected String a()
  {
    return antf.bp;
  }
  
  protected void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    super.a(paramInt, paramExcitingTransferDownloadCompletedInfo);
    if (this.jdField_a_of_type_Bfwk != null)
    {
      Bundle localBundle = new Bundle();
      if (paramExcitingTransferDownloadCompletedInfo != null) {
        localBundle.putInt("nSrvReturnCode", paramExcitingTransferDownloadCompletedInfo.m_nSrvReturnCode);
      }
      this.jdField_a_of_type_Bfwk.a(true, a(), paramInt, "", "", localBundle);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    super.a(paramLong1, paramLong2, paramLong3);
    if (this.jdField_a_of_type_Bfwk != null) {
      this.jdField_a_of_type_Bfwk.a(paramLong2, this.jdField_a_of_type_Aubl.a());
    }
  }
  
  public void a(bfwk parambfwk)
  {
    this.jdField_a_of_type_Bfwk = parambfwk;
  }
  
  protected void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    super.a(paramExcitingTransferDownloadCompletedInfo);
    if (this.jdField_a_of_type_Bfwk != null) {
      this.jdField_a_of_type_Bfwk.a(paramExcitingTransferDownloadCompletedInfo.m_strFileSavePath);
    }
  }
  
  protected void a(String paramString)
  {
    this.b = paramString;
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
    return this.b;
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
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aubm
 * JD-Core Version:    0.7.0.1
 */