import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.io.File;

class atmx
  implements bliz
{
  atmx(atmw paramatmw, FileInfo paramFileInfo, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!auog.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())) || (auog.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())))
    {
      aunj.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c());
      this.jdField_a_of_type_Atmw.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    }
    try
    {
      paramView = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramView.setData(Uri.fromFile(new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())));
      this.jdField_a_of_type_Atmw.a.a.a.sendBroadcast(paramView);
      label104:
      this.jdField_a_of_type_Atmw.a.a.f();
      if (this.jdField_a_of_type_Blir.isShowing()) {
        this.jdField_a_of_type_Blir.dismiss();
      }
      return;
      auna.a(2131692076);
      return;
    }
    catch (Exception paramView)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmx
 * JD-Core Version:    0.7.0.1
 */