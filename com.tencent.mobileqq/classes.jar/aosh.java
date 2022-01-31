import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.io.File;

class aosh
  implements bfoq
{
  aosh(aosg paramaosg, FileInfo paramFileInfo, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!apvb.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())) || (apvb.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())))
    {
      apue.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c());
      this.jdField_a_of_type_Aosg.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    }
    try
    {
      paramView = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramView.setData(Uri.fromFile(new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())));
      this.jdField_a_of_type_Aosg.a.a.a.sendBroadcast(paramView);
      label104:
      this.jdField_a_of_type_Aosg.a.a.f();
      if (this.jdField_a_of_type_Bfol.isShowing()) {
        this.jdField_a_of_type_Bfol.dismiss();
      }
      return;
      aptv.a(2131692410);
      return;
    }
    catch (Exception paramView)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosh
 * JD-Core Version:    0.7.0.1
 */