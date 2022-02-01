import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class atie
  extends AsyncTask<String, String, List<FileInfo>>
{
  public atie(LocalFileBrowserActivity paramLocalFileBrowserActivity, boolean paramBoolean) {}
  
  protected List<FileInfo> a(String... paramVarArgs)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.f == 6) {
      if (aunj.b().equalsIgnoreCase(paramVarArgs[0])) {
        paramVarArgs = aunj.a(false, 0);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.l)
      {
        localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        localObject = auog.a(new File(((File)localObject).getAbsolutePath() + "/QQ/").getAbsolutePath(), false, 0);
        if (localObject != null) {
          paramVarArgs.addAll((Collection)localObject);
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.getIntent().getStringArrayExtra("STRING_Show_Within_Suffixs");
      if ((localObject == null) || (paramVarArgs == null)) {
        break;
      }
      while (i < paramVarArgs.size())
      {
        FileInfo localFileInfo = (FileInfo)paramVarArgs.get(i);
        int j = i;
        if (!localFileInfo.c()) {
          if (localFileInfo.a() != 0L)
          {
            j = i;
            if (bjzg.a(localFileInfo.d().toLowerCase(), (String[])localObject)) {}
          }
          else
          {
            paramVarArgs.remove(i);
            j = i - 1;
          }
        }
        i = j + 1;
      }
      paramVarArgs = auog.a(paramVarArgs[0], false, 0);
      continue;
      paramVarArgs = auog.a(paramVarArgs[0], false, 1);
    }
    return paramVarArgs;
  }
  
  protected void a(List<FileInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b.clear();
    if (paramList != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.b.addAll(paramList);
      paramList.clear();
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_Atzh.getCount() != 0)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.isStackFromBottom()) {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setStackFromBottom(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.setStackFromBottom(false);
      }
      LocalFileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity);
    }
    for (;;)
    {
      aunj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.centerView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.g))
      {
        int i = ((Integer)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.g)).intValue();
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_Atzh.getCount() > i) {
          LocalFileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity, i);
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
    aunj.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.centerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atie
 * JD-Core Version:    0.7.0.1
 */