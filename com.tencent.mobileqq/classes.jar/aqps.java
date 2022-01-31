import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.io.File;

class aqps
  implements bhuk
{
  aqps(aqpr paramaqpr, FileInfo paramFileInfo, bhuf parambhuf) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!arso.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())) || (arso.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())))
    {
      arrr.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c());
      this.jdField_a_of_type_Aqpr.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    }
    try
    {
      paramView = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramView.setData(Uri.fromFile(new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())));
      this.jdField_a_of_type_Aqpr.a.a.a.sendBroadcast(paramView);
      label104:
      this.jdField_a_of_type_Aqpr.a.a.f();
      if (this.jdField_a_of_type_Bhuf.isShowing()) {
        this.jdField_a_of_type_Bhuf.dismiss();
      }
      return;
      arri.a(2131692487);
      return;
    }
    catch (Exception paramView)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqps
 * JD-Core Version:    0.7.0.1
 */