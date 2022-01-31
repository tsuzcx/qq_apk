import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.io.File;

class aosl
  implements bfph
{
  aosl(aosk paramaosk, FileInfo paramFileInfo, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((!apvd.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())) || (apvd.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())))
    {
      apug.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c());
      this.jdField_a_of_type_Aosk.a.a.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo);
    }
    try
    {
      paramView = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramView.setData(Uri.fromFile(new File(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo.c())));
      this.jdField_a_of_type_Aosk.a.a.a.sendBroadcast(paramView);
      label104:
      this.jdField_a_of_type_Aosk.a.a.f();
      if (this.jdField_a_of_type_Bfpc.isShowing()) {
        this.jdField_a_of_type_Bfpc.dismiss();
      }
      return;
      aptx.a(2131692410);
      return;
    }
    catch (Exception paramView)
    {
      break label104;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosl
 * JD-Core Version:    0.7.0.1
 */