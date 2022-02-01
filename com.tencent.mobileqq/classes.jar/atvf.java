import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import java.util.ArrayList;
import java.util.List;

public class atvf
{
  protected int a;
  protected QQAppInterface a;
  protected FileManagerEntity a;
  protected List<atuz> a;
  private int b;
  
  public atvf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public attg a(BaseActivity paramBaseActivity)
  {
    return new atvg(this, paramBaseActivity);
  }
  
  public List<atuz> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a(Intent paramIntent, Activity paramActivity)
  {
    Object localObject = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (localObject == null) {
      return false;
    }
    if (paramIntent.getBooleanExtra("from_webview", false))
    {
      bfjs localbfjs = bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ForwardFileInfo)localObject).a(), ((ForwardFileInfo)localObject).b(), ((ForwardFileInfo)localObject).e(), ((ForwardFileInfo)localObject).d(), ((ForwardFileInfo)localObject).d(), paramIntent.getIntExtra("bisId", 0));
      l1 = ((ForwardFileInfo)localObject).a();
      localObject = paramIntent.getStringExtra("sender_uin");
      long l2 = paramIntent.getLongExtra("last_time", 0L);
      aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramActivity, null, null, l1, localbfjs, (String)localObject, l2, -1, 0, null, false, false);
      paramActivity.finish();
      return false;
    }
    long l1 = ((ForwardFileInfo)localObject).b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().a(l1);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime = paramIntent.getLongExtra("last_time", 0L);
    this.jdField_a_of_type_JavaUtilList.add(atus.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      this.jdField_a_of_type_Int = 1;
      return true;
    }
    this.jdField_a_of_type_Int = 3;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvf
 * JD-Core Version:    0.7.0.1
 */