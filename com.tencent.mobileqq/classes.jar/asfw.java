import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;

class asfw
  extends asbj
{
  asfw(asfv paramasfv) {}
  
  protected void onFileTransferEnd(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    paramString2 = this.a.a(paramInt1 + "", paramString1, paramLong2 + "");
    FileManagerEntity localFileManagerEntity = asfv.a(this.a).getFileManagerDataCenter().a(paramLong2, paramLong1, paramString1, paramInt1);
    QLog.i("FMObserver<FileAssistant>", 1, "offline file download is finish. isSuc[" + paramBoolean + "sessionId[" + paramLong2 + "]");
    if ((paramString2 != null) && (localFileManagerEntity != null) && (paramString2.a() != null)) {
      paramString2.a().a(paramBoolean, paramInt1, paramString1, new Bundle());
    }
    if (paramString2 != null) {
      this.a.b(paramString2);
    }
  }
  
  protected void onFileTransferProgress(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    Object localObject = this.a.a(paramInt + "", paramString, paramLong2 + "");
    FileManagerEntity localFileManagerEntity = asfv.a(this.a).getFileManagerDataCenter().a(paramLong2, paramLong1, paramString, paramInt);
    if ((localObject != null) && (localFileManagerEntity != null))
    {
      localObject = ((asxz)localObject).a();
      if (localObject != null) {
        ((asxy)localObject).a(0, paramInt, paramString, (int)(localFileManagerEntity.fProgress * 100.0F), new Bundle());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfw
 * JD-Core Version:    0.7.0.1
 */