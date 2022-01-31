import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.1;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.2;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.3;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class aosl
  extends aouj
{
  public aosl(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    super.a(paramInt, paramLong, paramString);
    apue.a(paramLong, paramInt, paramString);
    bifs.a(this.a.a, paramInt);
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.a(paramLong, paramString1, paramInt, paramString2);
    apue.a(paramLong);
  }
  
  protected void a(apev paramapev)
  {
    if (paramapev == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
      } while (!(paramapev.a instanceof FileManagerEntity));
      localFileManagerEntity = (FileManagerEntity)paramapev.a;
    } while ((paramapev.b == null) || (paramapev.b.length() <= 0));
    localFileManagerEntity.strThumbPath = paramapev.b;
    QfileBaseLocalFileTabView.c(this.a).a().c(localFileManagerEntity);
    this.a.i();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseLocalFileTabView.a(this.a, new QfileBaseLocalFileTabView.7.1(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    QfileBaseLocalFileTabView.b(this.a, new QfileBaseLocalFileTabView.7.2(this, paramLong2, paramBoolean, paramInt2, paramString2));
  }
  
  protected void b()
  {
    super.b();
    QfileBaseLocalFileTabView.c(this.a, new QfileBaseLocalFileTabView.7.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosl
 * JD-Core Version:    0.7.0.1
 */