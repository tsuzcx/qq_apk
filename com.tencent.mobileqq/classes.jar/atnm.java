import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.10.1;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.10.2;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.10.3;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.10.4;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView.10.5;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class atnm
  extends atpa
{
  public atnm(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    super.a(paramInt, paramLong, paramString);
    aunj.a(paramLong, paramInt, paramString);
    boch.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramInt);
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.G(this.a).a().a(paramLong1, paramString, paramInt, paramLong2);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + aunj.e(paramString) + "], peerType[" + paramInt + "]");
      }
      return;
    }
    this.a.b(localFileManagerEntity);
    QfileBaseRecentFileTabView.H(this.a).a().c(localFileManagerEntity);
    QfileBaseRecentFileTabView.d(this.a, new QfileBaseRecentFileTabView.10.3(this));
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.a(paramLong, paramString1, paramInt, paramString2);
    aunj.a(paramLong);
    this.a.i();
  }
  
  protected void a(atzl paramatzl)
  {
    if (paramatzl == null) {}
    FileManagerEntity localFileManagerEntity;
    do
    {
      do
      {
        return;
      } while (!(paramatzl.a instanceof FileManagerEntity));
      localFileManagerEntity = (FileManagerEntity)paramatzl.a;
    } while ((paramatzl.b == null) || (paramatzl.b.length() <= 0));
    localFileManagerEntity.strThumbPath = paramatzl.b;
    QfileBaseRecentFileTabView.C(this.a).a().c(localFileManagerEntity);
    this.a.i();
  }
  
  protected void a(Boolean paramBoolean, List<OfflineFileInfo> paramList)
  {
    QfileBaseRecentFileTabView.a(this.a, paramBoolean, paramList);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    QfileBaseRecentFileTabView.e(this.a, new QfileBaseRecentFileTabView.10.4(this));
    aunj.a(paramLong, paramInteger.intValue(), paramString);
    boch.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramInteger.intValue());
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseRecentFileTabView.b(this.a, new QfileBaseRecentFileTabView.10.1(this));
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.D(this.a).a().a(paramLong1, paramString1, paramInt1, paramLong2);
    if (localFileManagerEntity == null)
    {
      QLog.e(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 1, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + aunj.e(paramString1) + "], peerType[" + paramInt1 + "]");
      return;
    }
    if (!paramBoolean)
    {
      localFileManagerEntity.bDelInFM = false;
      aunj.a(paramLong2, paramInt2, paramString2);
      boch.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramInt2);
    }
    for (;;)
    {
      if ((this.a.b == null) || (this.a.b.trim().length() == 0) || (localFileManagerEntity.getCloudType() != 2)) {
        this.a.b(localFileManagerEntity);
      }
      QfileBaseRecentFileTabView.E(this.a).a().c(localFileManagerEntity);
      QfileBaseRecentFileTabView.c(this.a, new QfileBaseRecentFileTabView.10.2(this, paramLong2));
      return;
      paramInt1 = localFileManagerEntity.nOpType;
      if ((paramInt1 == 4) || (paramInt1 == 20) || (paramInt1 == 6)) {
        aunj.a(paramLong2);
      }
    }
  }
  
  protected void b()
  {
    super.b();
    QfileBaseRecentFileTabView.f(this.a, new QfileBaseRecentFileTabView.10.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atnm
 * JD-Core Version:    0.7.0.1
 */