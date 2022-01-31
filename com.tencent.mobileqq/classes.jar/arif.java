import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import java.util.ArrayList;
import java.util.List;

public class arif
{
  protected int a;
  protected QQAppInterface a;
  protected FileManagerEntity a;
  protected List<arhz> a;
  private int b;
  
  public arif(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public arfs a(BaseActivity paramBaseActivity)
  {
    return new arig(this, paramBaseActivity);
  }
  
  public List<arhz> a()
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
      bbtn localbbtn = bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((ForwardFileInfo)localObject).a(), ((ForwardFileInfo)localObject).b(), ((ForwardFileInfo)localObject).e(), ((ForwardFileInfo)localObject).d(), ((ForwardFileInfo)localObject).d(), paramIntent.getIntExtra("bisId", 0));
      l1 = ((ForwardFileInfo)localObject).a();
      localObject = paramIntent.getStringExtra("sender_uin");
      long l2 = paramIntent.getLongExtra("last_time", 0L);
      arsx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramActivity, null, null, l1, localbbtn, (String)localObject, l2, -1, 0, null, false, false);
      paramActivity.finish();
      return false;
    }
    long l1 = ((ForwardFileInfo)localObject).b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l1);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return false;
    }
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime = paramIntent.getLongExtra("last_time", 0L);
    this.jdField_a_of_type_JavaUtilList.add(arhs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      this.jdField_a_of_type_Int = 1;
      return true;
    }
    this.jdField_a_of_type_Int = 3;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arif
 * JD-Core Version:    0.7.0.1
 */