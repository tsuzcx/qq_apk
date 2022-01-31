import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.io.File;

class aobn
  implements begw
{
  aobn(aobm paramaobm, FileInfo paramFileInfo, begr parambegr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!apdh.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())) || (apdh.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())))
    {
      apck.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c());
      this.jdField_a_of_type_Aobm.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    }
    try
    {
      paramView = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramView.setData(Uri.fromFile(new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())));
      this.jdField_a_of_type_Aobm.a.a.a.sendBroadcast(paramView);
      label104:
      this.jdField_a_of_type_Aobm.a.a.f();
      if (this.jdField_a_of_type_Begr.isShowing()) {
        this.jdField_a_of_type_Begr.dismiss();
      }
      return;
      apcb.a(2131626809);
      return;
    }
    catch (Exception paramView)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aobn
 * JD-Core Version:    0.7.0.1
 */