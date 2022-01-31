import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.io.File;

class aqlj
  implements bhqd
{
  aqlj(aqli paramaqli, FileInfo paramFileInfo, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!arof.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())) || (arof.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())))
    {
      arni.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c());
      this.jdField_a_of_type_Aqli.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    }
    try
    {
      paramView = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramView.setData(Uri.fromFile(new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())));
      this.jdField_a_of_type_Aqli.a.a.a.sendBroadcast(paramView);
      label104:
      this.jdField_a_of_type_Aqli.a.a.f();
      if (this.jdField_a_of_type_Bhpy.isShowing()) {
        this.jdField_a_of_type_Bhpy.dismiss();
      }
      return;
      armz.a(2131692486);
      return;
    }
    catch (Exception paramView)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqlj
 * JD-Core Version:    0.7.0.1
 */