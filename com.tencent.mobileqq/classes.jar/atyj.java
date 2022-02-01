import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.forward.ForwardFileOption;
import java.util.ArrayList;

public class atyj
  extends atyn
{
  private Context jdField_a_of_type_AndroidContentContext;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private boolean d;
  
  public atyj(Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.d = false;
  }
  
  public Intent a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null) {
      return null;
    }
    ForwardFileInfo localForwardFileInfo = ForwardFileOption.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    localForwardFileInfo.b(10009);
    Intent localIntent = new Intent();
    localIntent.putExtra("fileinfo", localForwardFileInfo);
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
      localIntent.putStringArrayListExtra("Aio_SessionId_ImageList", this.jdField_a_of_type_JavaUtilArrayList);
    }
    localIntent.putExtra("_from_aio_", this.d);
    return localIntent;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atyj
 * JD-Core Version:    0.7.0.1
 */