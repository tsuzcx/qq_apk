import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class anye
  implements View.OnClickListener
{
  public anye(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (aonx)paramView.getTag();
    FileInfo localFileInfo = ((aonx)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    int i;
    if (paramView.getId() == 2131300609)
    {
      i = 1;
      if (!localFileInfo.c()) {
        break label51;
      }
      LocalFileBrowserActivity.a(this.a, localFileInfo.c(), true);
    }
    label51:
    do
    {
      return;
      i = 0;
      break;
      if ((this.a.f()) && (i == 0))
      {
        if ((this.a.i()) && (!aonm.a(aonm.b)))
        {
          paramView = babr.a(this.a, 2131632462);
          paramView.setPositiveButton(2131629116, new baca());
          paramView.show();
          return;
        }
        if (aonm.a(localFileInfo)) {
          aonm.b(localFileInfo);
        }
        for (;;)
        {
          this.a.l();
          if (!this.a.f()) {
            break;
          }
          ((aonx)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          ((aonx)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(aonm.a(localFileInfo));
          return;
          if (this.a.f) {
            aonm.b();
          }
          if (localFileInfo.a() == -1) {
            localFileInfo.b(apck.a(localFileInfo.c()));
          }
          aonm.a(localFileInfo);
          if (this.a.f) {
            LocalFileBrowserActivity.a(this.a);
          }
        }
        ((aonx)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        return;
      }
      if (this.a.a()) {
        break label256;
      }
    } while (!QLog.isColorLevel());
    QLog.i(LocalFileBrowserActivity.g, 2, "click too fast , wait a minute.");
    return;
    label256:
    if (this.a.f()) {
      awqx.b(this.a.app, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
    }
    this.a.e();
    localObject = apck.a(localFileInfo);
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.d(3);
    localForwardFileInfo.b(10000);
    localForwardFileInfo.a(localFileInfo.c());
    localForwardFileInfo.d(localFileInfo.d());
    localForwardFileInfo.d(localFileInfo.a());
    paramView = new Intent(this.a.getApplicationContext(), FileBrowserActivity.class);
    paramView.putExtra("fileinfo", localForwardFileInfo);
    if ((((FileManagerEntity)localObject).nFileType == 0) || (((FileManagerEntity)localObject).nFileType == 1))
    {
      aonm.a(this.a.b);
      paramView.putExtra("clicked_file_hashcode", localFileInfo.hashCode());
    }
    localObject = new apcj();
    ((apcj)localObject).b = "file_viewer_in";
    ((apcj)localObject).jdField_a_of_type_Int = 80;
    ((apcj)localObject).c = apdh.a(localFileInfo.d());
    ((apcj)localObject).jdField_a_of_type_Long = localFileInfo.a();
    apci.a(this.a.app.getCurrentAccountUin(), (apcj)localObject);
    this.a.startActivityForResult(paramView, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anye
 * JD-Core Version:    0.7.0.1
 */