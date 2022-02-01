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

public class arzv
  extends asbj
{
  public arzv(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  protected void onFileCome(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.G(this.a).getFileManagerDataCenter().a(paramLong1, paramString, paramInt, paramLong2);
    if (localFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 2, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + aszt.e(paramString) + "], peerType[" + paramInt + "]");
      }
      return;
    }
    this.a.b(localFileManagerEntity);
    QfileBaseRecentFileTabView.H(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
    QfileBaseRecentFileTabView.d(this.a, new QfileBaseRecentFileTabView.10.3(this));
  }
  
  protected void onFileTransferEnd(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    FileManagerEntity localFileManagerEntity = QfileBaseRecentFileTabView.D(this.a).getFileManagerDataCenter().a(paramLong1, paramString1, paramInt1, paramLong2);
    if (localFileManagerEntity == null)
    {
      QLog.e(QfileBaseRecentFileTabView.jdField_a_of_type_JavaLangString, 1, "OnFileCome,but query FileEntity null,uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + "], strUin[" + aszt.e(paramString1) + "], peerType[" + paramInt1 + "]");
      return;
    }
    if (!paramBoolean)
    {
      localFileManagerEntity.bDelInFM = false;
      aszt.a(paramLong2, paramInt2, paramString2);
      blho.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramInt2);
    }
    for (;;)
    {
      if ((this.a.b == null) || (this.a.b.trim().length() == 0) || (localFileManagerEntity.getCloudType() != 2)) {
        this.a.b(localFileManagerEntity);
      }
      QfileBaseRecentFileTabView.E(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
      QfileBaseRecentFileTabView.c(this.a, new QfileBaseRecentFileTabView.10.2(this, paramLong2));
      return;
      paramInt1 = localFileManagerEntity.nOpType;
      if ((paramInt1 == 4) || (paramInt1 == 20) || (paramInt1 == 6)) {
        aszt.a(paramLong2);
      }
    }
  }
  
  protected void onFileTransferProgress(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    QfileBaseRecentFileTabView.b(this.a, new QfileBaseRecentFileTabView.10.1(this));
  }
  
  protected void onOfflineSendToWeiYunFaild(int paramInt, long paramLong, String paramString)
  {
    super.onOfflineSendToWeiYunFaild(paramInt, paramLong, paramString);
    aszt.a(paramLong, paramInt, paramString);
    blho.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramInt);
  }
  
  protected void onOfflineSendToWeiYunSuccess(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    super.onOfflineSendToWeiYunSuccess(paramLong, paramString1, paramInt, paramString2);
    aszt.a(paramLong);
    this.a.i();
  }
  
  protected void onRefreshList()
  {
    super.onRefreshList();
    QfileBaseRecentFileTabView.f(this.a, new QfileBaseRecentFileTabView.10.5(this));
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
    QfileBaseRecentFileTabView.C(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
    this.a.i();
  }
  
  protected void onWeiYunOfflineListSucess(Boolean paramBoolean, List<OfflineFileInfo> paramList)
  {
    QfileBaseRecentFileTabView.a(this.a, paramBoolean, paramList);
  }
  
  protected void onWeiYunSendToOfflineFaild(Integer paramInteger, long paramLong, String paramString)
  {
    QfileBaseRecentFileTabView.e(this.a, new QfileBaseRecentFileTabView.10.4(this));
    aszt.a(paramLong, paramInteger.intValue(), paramString);
    blho.a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzv
 * JD-Core Version:    0.7.0.1
 */