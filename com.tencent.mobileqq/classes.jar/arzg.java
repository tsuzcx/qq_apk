import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.io.File;

class arzg
  implements bjoe
{
  arzg(arzf paramarzf, FileInfo paramFileInfo, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!FileUtil.isFileExists(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())) || (FileUtil.deleteFile(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())))
    {
      aszt.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c());
      this.jdField_a_of_type_Arzf.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    }
    try
    {
      paramView = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramView.setData(Uri.fromFile(new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())));
      this.jdField_a_of_type_Arzf.a.a.a.sendBroadcast(paramView);
      label104:
      this.jdField_a_of_type_Arzf.a.a.f();
      if (this.jdField_a_of_type_Bjnw.isShowing()) {
        this.jdField_a_of_type_Bjnw.dismiss();
      }
      return;
      aszk.a(2131692124);
      return;
    }
    catch (Exception paramView)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzg
 * JD-Core Version:    0.7.0.1
 */