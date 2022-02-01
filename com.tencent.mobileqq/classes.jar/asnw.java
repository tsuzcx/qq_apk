import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadConfig;
import com.tencent.qphone.base.util.QLog;

public class asnw
  extends asnu
  implements befu
{
  protected befv a;
  protected String b;
  
  public asnw(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt, asnv paramasnv)
  {
    super(paramQQAppInterface, paramLong1, paramLong2, paramInt, paramasnv);
  }
  
  public static befu a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString, asnv paramasnv)
  {
    if (paramasnv == null)
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader fileInfo is null");
      return null;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader strTmpFilePath is err");
      return null;
    }
    if (!paramasnv.a())
    {
      QLog.e("ExcitingTransfer.GroupDownloader<FileAssistant>", 1, "getFileDownloader fileInfo is err");
      return null;
    }
    paramQQAppInterface = new asnw(paramQQAppInterface, paramLong1, paramLong2, 1, paramasnv);
    paramQQAppInterface.a(paramString);
    return paramQQAppInterface;
  }
  
  protected ExcitingTransferDownloadConfig a()
  {
    return asnp.a().b();
  }
  
  protected String a()
  {
    return AppConstants.SDCARD_FILE_SAVE_PATH;
  }
  
  protected void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    super.a(paramInt, paramExcitingTransferDownloadCompletedInfo);
    if (this.jdField_a_of_type_Befv != null)
    {
      Bundle localBundle = new Bundle();
      if (paramExcitingTransferDownloadCompletedInfo != null) {
        localBundle.putInt("nSrvReturnCode", paramExcitingTransferDownloadCompletedInfo.m_nSrvReturnCode);
      }
      this.jdField_a_of_type_Befv.a(true, a(), paramInt, "", "", localBundle);
    }
  }
  
  protected void a(long paramLong1, long paramLong2, long paramLong3)
  {
    super.a(paramLong1, paramLong2, paramLong3);
    if (this.jdField_a_of_type_Befv != null) {
      this.jdField_a_of_type_Befv.a(paramLong2, this.jdField_a_of_type_Asnv.a());
    }
  }
  
  public void a(befv parambefv)
  {
    this.jdField_a_of_type_Befv = parambefv;
  }
  
  protected void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    super.a(paramExcitingTransferDownloadCompletedInfo);
    if (this.jdField_a_of_type_Befv != null) {
      this.jdField_a_of_type_Befv.a(paramExcitingTransferDownloadCompletedInfo.m_strFileSavePath);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asnw
 * JD-Core Version:    0.7.0.1
 */