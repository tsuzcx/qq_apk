import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.1;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.2;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.3;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class arzk
  extends asbj
{
  public arzk(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  protected void onFileTransferEnd(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QfileBaseLocalFileTabView.b(this.a, new QfileBaseLocalFileTabView.7.2(this, paramLong2, paramBoolean, paramInt2, paramString2));
  }
  
  protected void onFileTransferProgress(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseLocalFileTabView.a(this.a, new QfileBaseLocalFileTabView.7.1(this));
  }
  
  protected void onOfflineSendToWeiYunFaild(int paramInt, long paramLong, String paramString)
  {
    super.onOfflineSendToWeiYunFaild(paramInt, paramLong, paramString);
    aszt.a(paramLong, paramInt, paramString);
    blho.a(this.a.a, paramInt);
  }
  
  protected void onOfflineSendToWeiYunSuccess(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.onOfflineSendToWeiYunSuccess(paramLong, paramString1, paramInt, paramString2);
    aszt.a(paramLong);
  }
  
  protected void onRefreshList()
  {
    super.onRefreshList();
    QfileBaseLocalFileTabView.c(this.a, new QfileBaseLocalFileTabView.7.3(this));
  }
  
  protected void onThumbDownLoadSuccess(aslv paramaslv)
  {
    if (paramaslv == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
      } while (!(paramaslv.a instanceof FileManagerEntity));
      localFileManagerEntity = (FileManagerEntity)paramaslv.a;
    } while ((paramaslv.b == null) || (paramaslv.b.length() <= 0));
    localFileManagerEntity.strThumbPath = paramaslv.b;
    QfileBaseLocalFileTabView.c(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
    this.a.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzk
 * JD-Core Version:    0.7.0.1
 */