import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.io.File;

class aswt
  implements bkhw
{
  aswt(asws paramasws, FileInfo paramFileInfo, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!atwl.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())) || (atwl.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())))
    {
      atvo.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c());
      this.jdField_a_of_type_Asws.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    }
    try
    {
      paramView = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramView.setData(Uri.fromFile(new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())));
      this.jdField_a_of_type_Asws.a.a.a.sendBroadcast(paramView);
      label104:
      this.jdField_a_of_type_Asws.a.a.f();
      if (this.jdField_a_of_type_Bkho.isShowing()) {
        this.jdField_a_of_type_Bkho.dismiss();
      }
      return;
      atvf.a(2131692071);
      return;
    }
    catch (Exception paramView)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswt
 * JD-Core Version:    0.7.0.1
 */