import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanageraux.util.UniformDownloadBPTransEntity;
import com.tencent.qphone.base.util.QLog;

public class aukr
{
  private static aukr a;
  
  public static aukr a()
  {
    try
    {
      if (a == null) {
        a = new aukr();
      }
      aukr localaukr = a;
      return localaukr;
    }
    finally {}
  }
  
  public auks a(String paramString)
  {
    Object localObject = auht.a().a();
    if (localObject == null) {
      QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] getBPTransItem failed APP=null. url[" + paramString + "]");
    }
    for (;;)
    {
      return null;
      if (((QQAppInterface)localObject).getUDLBPTransProxy() != null) {}
      for (paramString = ((QQAppInterface)localObject).getUDLBPTransProxy().a(paramString); paramString != null; paramString = null)
      {
        localObject = new auks();
        ((auks)localObject).jdField_a_of_type_JavaLangString = paramString.mFileName;
        ((auks)localObject).jdField_a_of_type_Long = paramString.mFileSize;
        ((auks)localObject).c = paramString.mFilePath;
        ((auks)localObject).b = paramString.mTempPath;
        return localObject;
        QLog.e("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] getUDLBPTransProxy=null.");
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("UniformDownloadBPTrans<FileAssistant>", 1, "[UniformDL] delBPTransItem. url[" + paramString + "]");
    QQAppInterface localQQAppInterface = auht.a().a();
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
    QQAppInterface localQQAppInterface = auht.a().a();
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
 * Qualified Name:     aukr
 * JD-Core Version:    0.7.0.1
 */