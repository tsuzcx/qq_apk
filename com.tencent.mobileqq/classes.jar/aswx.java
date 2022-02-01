import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.1;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.2;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.3;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class aswx
  extends asyw
{
  public aswx(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    super.a(paramInt, paramLong, paramString);
    atvo.a(paramLong, paramInt, paramString);
    bnaz.a(this.a.a, paramInt);
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.a(paramLong, paramString1, paramInt, paramString2);
    atvo.a(paramLong);
  }
  
  protected void a(athr paramathr)
  {
    if (paramathr == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
      } while (!(paramathr.a instanceof FileManagerEntity));
      localFileManagerEntity = (FileManagerEntity)paramathr.a;
    } while ((paramathr.b == null) || (paramathr.b.length() <= 0));
    localFileManagerEntity.strThumbPath = paramathr.b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswx
 * JD-Core Version:    0.7.0.1
 */