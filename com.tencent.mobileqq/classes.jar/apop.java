import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class apop
  extends apon
{
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private WeiYunFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo;
  private ArrayList<WeiYunFileInfo> jdField_a_of_type_JavaUtilArrayList;
  
  public apop(QQAppInterface paramQQAppInterface, Context paramContext, WeiYunFileInfo paramWeiYunFileInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo = paramWeiYunFileInfo;
  }
  
  public Intent a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (localObject1 != null)
    {
      if (localObject1 != null) {
        break label103;
      }
      QLog.i("WeiYunFileBrowserParams<FileAssistant>", 1, "");
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
    }
    Object localObject2;
    label103:
    do
    {
      do
      {
        return localObject1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo == null) {
          break;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a);
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        localObject1 = apug.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo);
        break;
        if (QLog.isColorLevel()) {
          QLog.i("WeiYunFileBrowserParams<FileAssistant>", 1, "open a weiyun file with filebrowser, fileSessionId[" + ((FileManagerEntity)localObject1).nSessionId + "] fileName[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.c + "]fileId[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataWeiYunFileInfo.a + "]");
        }
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.d(2);
        localForwardFileInfo.b(10003);
        localForwardFileInfo.b(((FileManagerEntity)localObject1).nSessionId);
        localForwardFileInfo.d(((FileManagerEntity)localObject1).fileName);
        localForwardFileInfo.c(((FileManagerEntity)localObject1).WeiYunFileId);
        localForwardFileInfo.c(((FileManagerEntity)localObject1).nWeiYunSrcType);
        localForwardFileInfo.d(((FileManagerEntity)localObject1).fileSize);
        localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, FileBrowserActivity.class);
        ((Intent)localObject2).putExtra("fileinfo", localForwardFileInfo);
        localObject1 = localObject2;
      } while (this.jdField_a_of_type_JavaUtilArrayList == null);
      localObject1 = localObject2;
    } while (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0);
    ((Intent)localObject2).putParcelableArrayListExtra("local_weiyun_list", this.jdField_a_of_type_JavaUtilArrayList);
    return localObject2;
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
  }
  
  public void a(ArrayList<WeiYunFileInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public void b(Bundle paramBundle) {}
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apop
 * JD-Core Version:    0.7.0.1
 */