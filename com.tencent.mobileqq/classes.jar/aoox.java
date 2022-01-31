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

public class aoox
  implements View.OnClickListener
{
  public aoox(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (apes)paramView.getTag();
    FileInfo localFileInfo = ((apes)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    int i;
    if (paramView.getId() == 2131366211)
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
        if ((this.a.i()) && (!apeh.a(apeh.b)))
        {
          paramView = bbcv.a(this.a, 2131698194);
          paramView.setPositiveButton(2131694793, new bbdf());
          paramView.show();
          return;
        }
        if (apeh.a(localFileInfo)) {
          apeh.b(localFileInfo);
        }
        for (;;)
        {
          this.a.l();
          if (!this.a.f()) {
            break;
          }
          ((apes)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          ((apes)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(apeh.a(localFileInfo));
          return;
          if (this.a.f) {
            apeh.b();
          }
          if (localFileInfo.a() == -1) {
            localFileInfo.b(apue.a(localFileInfo.c()));
          }
          apeh.a(localFileInfo);
          if (this.a.f) {
            LocalFileBrowserActivity.a(this.a);
          }
        }
        ((apes)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
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
      axqw.b(this.a.app, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
    }
    this.a.e();
    localObject = apue.a(localFileInfo);
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
      apeh.a(this.a.b);
      paramView.putExtra("clicked_file_hashcode", localFileInfo.hashCode());
    }
    localObject = new apud();
    ((apud)localObject).b = "file_viewer_in";
    ((apud)localObject).jdField_a_of_type_Int = 80;
    ((apud)localObject).c = apvb.a(localFileInfo.d());
    ((apud)localObject).jdField_a_of_type_Long = localFileInfo.a();
    apuc.a(this.a.app.getCurrentAccountUin(), (apud)localObject);
    this.a.startActivityForResult(paramView, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoox
 * JD-Core Version:    0.7.0.1
 */