import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;

class arws
  implements aszj
{
  arws(arwp paramarwp, WeiYunFileInfo paramWeiYunFileInfo) {}
  
  public void onNo() {}
  
  public void onYes()
  {
    FileManagerEntity localFileManagerEntity = aszt.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerauxDataWeiYunFileInfo);
    QfileBaseCloudFileTabView.i(this.jdField_a_of_type_Arwp.a).getFileManagerEngine().b(localFileManagerEntity);
    QfileBaseCloudFileTabView.j(this.jdField_a_of_type_Arwp.a).getFileManagerDataCenter().a(localFileManagerEntity);
    this.jdField_a_of_type_Arwp.a.a(localFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arws
 * JD-Core Version:    0.7.0.1
 */