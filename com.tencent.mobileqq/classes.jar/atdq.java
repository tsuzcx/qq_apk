import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.1;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.2;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView.7.3;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

public class atdq
  extends atfq
{
  public atdq(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    super.a(paramInt, paramLong, paramString);
    auea.a(paramLong, paramInt, paramString);
    bmuf.a(this.a.a, paramInt);
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.a(paramLong, paramString1, paramInt, paramString2);
    auea.a(paramLong);
  }
  
  protected void a(atqb paramatqb)
  {
    if (paramatqb == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
      } while (!(paramatqb.a instanceof FileManagerEntity));
      localFileManagerEntity = (FileManagerEntity)paramatqb.a;
    } while ((paramatqb.b == null) || (paramatqb.b.length() <= 0));
    localFileManagerEntity.strThumbPath = paramatqb.b;
    QfileBaseLocalFileTabView.c(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
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
 * Qualified Name:     atdq
 * JD-Core Version:    0.7.0.1
 */