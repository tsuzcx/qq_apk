import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class asyt
  extends AsyncTask<String, String, List<FileInfo>>
{
  public asyt(LocalFileBrowserActivity paramLocalFileBrowserActivity, boolean paramBoolean) {}
  
  protected List<FileInfo> a(String... paramVarArgs)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_f_of_type_Int == 6) {
      if (auea.b().equalsIgnoreCase(paramVarArgs[0])) {
        paramVarArgs = auea.a(false, 0);
      }
    }
    while (paramVarArgs == null)
    {
      QLog.e(LocalFileBrowserActivity.jdField_f_of_type_JavaLangString, 1, "tmp is null! mCategory:" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_f_of_type_Int);
      return null;
      paramVarArgs = FileUtil.getFiles(paramVarArgs[0], false, 0);
      continue;
      paramVarArgs = FileUtil.getFiles(paramVarArgs[0], false, 1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.l)
    {
      localObject = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
      localObject = FileUtil.getFiles(new File(((File)localObject).getAbsolutePath() + "/QQ/").getAbsolutePath(), false, 0);
      if (localObject != null) {
        paramVarArgs.addAll((Collection)localObject);
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.getIntent().getStringArrayExtra("STRING_Show_Within_Suffixs");
    if (localObject != null)
    {
      int j;
      for (int i = 0; i < paramVarArgs.size(); i = j + 1)
      {
        FileInfo localFileInfo = (FileInfo)paramVarArgs.get(i);
        j = i;
        if (!localFileInfo.c()) {
          if (localFileInfo.a() != 0L)
          {
            j = i;
            if (bjps.a(localFileInfo.d().toLowerCase(), (String[])localObject)) {}
          }
          else
          {
            paramVarArgs.remove(i);
            j = i - 1;
          }
        }
      }
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
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_Atpx.getCount() != 0)
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
      auea.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.centerView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.g))
      {
        int i = ((Integer)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.g)).intValue();
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_Atpx.getCount() > i) {
          LocalFileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity, i);
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
    auea.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.centerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyt
 * JD-Core Version:    0.7.0.1
 */