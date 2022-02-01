import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanageraux.util.UniformDownloadBPTransEntity;
import com.tencent.qphone.base.util.QLog;

public class atgk
{
  private static atgk a;
  
  public static atgk a()
  {
    try
    {
      if (a == null) {
        a = new atgk();
      }
      atgk localatgk = a;
      return localatgk;
    }
    finally {}
  }
  
  public atgl a(String paramString)
  {
    Object localObject = atdm.a().a();
    if (localObject == null) {
      QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] getBPTransItem failed APP=null. url[" + paramString + "]");
    }
    for (;;)
    {
      return null;
      if (((QQAppInterface)localObject).getUDLBPTransProxy() != null) {}
      for (paramString = ((QQAppInterface)localObject).getUDLBPTransProxy().a(paramString); paramString != null; paramString = null)
      {
        localObject = new atgl();
        ((atgl)localObject).jdField_a_of_type_JavaLangString = paramString.mFileName;
        ((atgl)localObject).jdField_a_of_type_Long = paramString.mFileSize;
        ((atgl)localObject).c = paramString.mFilePath;
        ((atgl)localObject).b = paramString.mTempPath;
        return localObject;
        QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] getUDLBPTransProxy=null.");
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] delBPTransItem. url[" + paramString + "]");
    QQAppInterface localQQAppInterface = atdm.a().a();
    if (localQQAppInterface == null) {
      QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] delBPTransItem failed APP=null. url[" + paramString + "]");
    }
    while (localQQAppInterface.getUDLBPTransProxy() == null) {
      return;
    }
    localQQAppInterface.getUDLBPTransProxy().a(paramString);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, String paramString3, String paramString4)
  {
    UniformDownloadBPTransEntity localUniformDownloadBPTransEntity = new UniformDownloadBPTransEntity();
    localUniformDownloadBPTransEntity.mUrl = paramString1;
    localUniformDownloadBPTransEntity.mFileName = paramString2;
    localUniformDownloadBPTransEntity.mFileSize = paramLong;
    localUniformDownloadBPTransEntity.mFilePath = paramString4;
    localUniformDownloadBPTransEntity.mTempPath = paramString3;
    QQAppInterface localQQAppInterface = atdm.a().a();
    if (localQQAppInterface == null)
    {
      QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] addBPTransItem.failed APP=null, filename[" + paramString2 + "] fillesize[" + paramLong + "] tempPath[" + paramString3 + "] strPath[" + paramString4 + "] url[" + paramString1 + "]");
      return;
    }
    if (localQQAppInterface.getUDLBPTransProxy() != null) {
      localQQAppInterface.getUDLBPTransProxy().a(localUniformDownloadBPTransEntity);
    }
    QLog.i("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] addBPTransItem.filename[" + paramString2 + "] fillesize[" + paramLong + "] tempPath[" + paramString3 + "] strPath[" + paramString4 + "] url[" + paramString1 + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atgk
 * JD-Core Version:    0.7.0.1
 */