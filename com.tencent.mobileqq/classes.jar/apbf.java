import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;

public class apbf
{
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private final String jdField_a_of_type_JavaLangString = "FileModel<FileAssistant>";
  
  public static apbf a(MessageForFile paramMessageForFile)
  {
    try
    {
      QQAppInterface localQQAppInterface1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface1 == null) {
        throw new NullPointerException("newFileModel entity app null!");
      }
    }
    catch (Exception localException)
    {
      QQAppInterface localQQAppInterface2;
      for (;;)
      {
        localQQAppInterface2 = null;
      }
      return a(apck.a(localQQAppInterface2, paramMessageForFile));
    }
  }
  
  public static apbf a(FileManagerEntity paramFileManagerEntity)
  {
    apbf localapbf = new apbf();
    if ((paramFileManagerEntity == null) && (QLog.isDevelopLevel())) {
      throw new NullPointerException("newFileModel entity is null!");
    }
    localapbf.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    return localapbf;
  }
  
  public static apbf a(String paramString)
  {
    try
    {
      paramString = a(apck.a(new FileInfo(paramString)));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      paramString.printStackTrace();
      if (QLog.isDevelopLevel()) {
        throw new NullPointerException("check localPath");
      }
    }
    return null;
  }
  
  private void a(String paramString1, String paramString2)
  {
    QLog.i("FileModel<FileAssistant>" + paramString1, 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]" + paramString2);
  }
  
  private void b(Activity paramActivity, int paramInt)
  {
    aojd.a(paramActivity, new apbl(this, paramActivity, paramInt));
  }
  
  private void b(Activity paramActivity, int paramInt1, int paramInt2)
  {
    ForwardFileInfo localForwardFileInfo;
    try
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface == null)
      {
        QLog.e("FileModel<FileAssistant>", 1, "Start VideoActivity is not in QQ!");
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject = null;
      }
      localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(paramInt2);
      if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend) {}
    }
    for (Object localObject = ((QQAppInterface)localObject).getAccount();; localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin)
    {
      localForwardFileInfo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType());
      if (localObject != null) {
        localForwardFileInfo.a(Long.valueOf(((String)localObject).replace("+", "")).longValue());
      }
      localForwardFileInfo.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      localForwardFileInfo.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      localForwardFileInfo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      localForwardFileInfo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      localForwardFileInfo.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
      localForwardFileInfo.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath());
      localObject = new Intent(paramActivity, FileBrowserActivity.class);
      ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
      ((Intent)localObject).putExtra("file_enter_file_browser_type", paramInt1);
      ((Intent)localObject).putExtra("selfSet_leftViewText", ajjy.a(2131638770));
      paramActivity.startActivityForResult((Intent)localObject, 102);
      paramActivity.overridePendingTransition(2130772036, 2130772038);
      return;
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2)
    {
      if (!badq.d(BaseApplicationImpl.getContext())) {
        apcb.a(2131629294);
      }
      apbi localapbi;
      boolean bool1;
      do
      {
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() != 1) || (!apck.a()) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 2) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize <= 1048576L)) {
          break;
        }
        localapbi = new apbi(this, paramActivity, paramInt);
        boolean bool2 = bati.a(paramActivity, 2, new apbj(this, paramActivity, paramInt), "");
        bool1 = bool2;
        if (bool2) {
          bool1 = bbrm.a(paramActivity, 3, new apbk(this, paramActivity, paramInt));
        }
      } while (!bool1);
      apbx.a(paramActivity, paramActivity.getString(2131627035), paramActivity.getString(2131627037), localapbi);
      return;
      b(paramActivity, paramInt);
      return;
    }
    b(paramActivity, paramInt, 10004);
  }
  
  public void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    b(paramActivity, paramInt2, paramInt1);
  }
  
  public void a(boolean paramBoolean, Context paramContext, apca paramapca)
  {
    int j = 2;
    if (!badq.e(BaseApplicationImpl.getContext())) {
      apcb.a(2131627672);
    }
    boolean bool1;
    label48:
    label91:
    do
    {
      return;
      if (paramBoolean) {
        break;
      }
      bool1 = true;
      if (!a(bool1)) {
        break label160;
      }
      Activity localActivity = (Activity)paramContext;
      if (!paramBoolean) {
        break label140;
      }
      i = 3;
      boolean bool2 = bati.a(localActivity, i, new apbg(this, paramapca), "");
      bool1 = bool2;
      if (bool2)
      {
        localActivity = (Activity)paramContext;
        if (!paramBoolean) {
          break label146;
        }
        i = j;
        bool1 = bbrm.a(localActivity, i, new apbh(this, paramapca));
      }
    } while (!bool1);
    if (paramBoolean) {}
    for (int i = 2131627040;; i = 2131627037)
    {
      apbx.a(paramContext, 2131627035, i, paramapca);
      return;
      bool1 = false;
      break;
      label140:
      i = 2;
      break label48;
      label146:
      i = 1;
      break label91;
    }
    label160:
    paramapca.a();
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!badq.d(BaseApplicationImpl.getContext())) {}
    long l2;
    long l1;
    do
    {
      do
      {
        return false;
        if (!apck.a())
        {
          a("FlowShow", " donot ShowFlowDialog! Wi-Fi");
          return false;
        }
        l2 = aonj.a();
        l1 = aonj.b();
        a("FlowShow", "fileSize " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize + ",limit  " + l2);
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize < l2);
      if (paramBoolean)
      {
        a("FlowShow", "download model so Show!");
        return true;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 3) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType != 6))
      {
        a("FlowShow", "cloudeType " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType + " is not local File donot show!");
        return false;
      }
      l2 = awao.a();
      a("FlowShow", "last Succ " + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime + " now " + awao.a() + " = " + (l2 - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime) + " limit[" + l1 + "]");
    } while (l2 - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime < l1);
    a("FlowShow", "Must show!");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apbf
 * JD-Core Version:    0.7.0.1
 */