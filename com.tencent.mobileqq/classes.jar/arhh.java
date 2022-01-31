import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.qphone.base.util.QLog;

public class arhh
  extends arhg
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  
  public arhh(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    super(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    arni.c(paramFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private ForwardFileInfo a()
  {
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    localForwardFileInfo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    localForwardFileInfo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    localForwardFileInfo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
    localForwardFileInfo.b(this.jdField_a_of_type_Int);
    switch (this.jdField_a_of_type_Int)
    {
    case 10002: 
    case 10003: 
    default: 
      return localForwardFileInfo;
    case 10000: 
      localForwardFileInfo.d(3);
      localForwardFileInfo.b(10000);
      return localForwardFileInfo;
    case 10004: 
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {}
      for (String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();; str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin)
      {
        localForwardFileInfo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType());
        if (str != null) {
          localForwardFileInfo.a(Long.valueOf(str.replace("+", "")).longValue());
        }
        localForwardFileInfo.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        localForwardFileInfo.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
        return localForwardFileInfo;
      }
    }
    localForwardFileInfo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType());
    localForwardFileInfo.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
    localForwardFileInfo.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
    return localForwardFileInfo;
  }
  
  private Intent b()
  {
    Intent localIntent = new Intent();
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
    }
    return localIntent;
  }
  
  protected int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
    }
    return 0;
  }
  
  protected long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    }
    return 0L;
  }
  
  public Intent a()
  {
    ForwardFileInfo localForwardFileInfo = a();
    Intent localIntent = b();
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    localIntent.putExtra("selfSet_leftViewText", alpo.a(2131702594));
    return localIntent;
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    }
    return "";
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  protected String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) {
      return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath();
    }
    return "";
  }
  
  public void b(Bundle paramBundle)
  {
    if ((this.jdField_a_of_type_AndroidOsBundle != null) && (paramBundle != null) && (this.jdField_a_of_type_AndroidOsBundle.containsKey("file_color_note_subType"))) {
      paramBundle.putInt("file_color_note_subType", this.jdField_a_of_type_AndroidOsBundle.getInt("file_color_note_subType", -1));
    }
  }
  
  boolean c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 0) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 3))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideo", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + " status:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status + " resume");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      return true;
    }
    return false;
  }
  
  boolean d()
  {
    int i = arni.a(a());
    if (i != 2) {
      if (QLog.isColorLevel()) {
        QLog.i("FileVideo", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + " type is:" + i + " use old filebrowser:");
      }
    }
    boolean bool;
    do
    {
      return false;
      bool = arni.b(b());
      if (QLog.isColorLevel()) {
        QLog.i("FileVideo", 1, "id:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + " status:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status + " isLocal:" + bool);
      }
    } while ((bool) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 1) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isSend()));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arhh
 * JD-Core Version:    0.7.0.1
 */