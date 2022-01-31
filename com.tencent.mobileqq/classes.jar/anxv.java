import android.content.Intent;
import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.NoFileRelativeLayout;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class anxv
  extends AsyncTask<String, String, List<FileInfo>>
{
  public anxv(LocalFileBrowserActivity paramLocalFileBrowserActivity, boolean paramBoolean) {}
  
  protected List<FileInfo> a(String... paramVarArgs)
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.f == 6) {
      if (apck.b().equalsIgnoreCase(paramVarArgs[0])) {
        paramVarArgs = apck.a(false, 0);
      }
    }
    for (;;)
    {
      String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.getIntent().getStringArrayExtra("STRING_Show_Within_Suffixs");
      if ((arrayOfString == null) || (paramVarArgs == null)) {
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
            if (bcjf.a(localFileInfo.d().toLowerCase(), arrayOfString)) {}
          }
          else
          {
            paramVarArgs.remove(i);
            j = i - 1;
          }
        }
        i = j + 1;
      }
      paramVarArgs = apdh.a(paramVarArgs[0], false, 0);
      continue;
      paramVarArgs = apdh.a(paramVarArgs[0], false, 1);
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
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_Aonw.getCount() != 0)
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
      apck.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.centerView);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.h))
      {
        int i = ((Integer)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.h)).intValue();
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_Aonw.getCount() > i) {
          LocalFileBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity, i);
        }
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetNoFileRelativeLayout.setVisible(true);
    apck.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityLocalFileBrowserActivity.centerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anxv
 * JD-Core Version:    0.7.0.1
 */