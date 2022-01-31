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

public class aqmj
  implements View.OnClickListener
{
  public aqmj(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (arcd)paramView.getTag();
    FileInfo localFileInfo = ((arcd)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    int i;
    if (paramView.getId() == 2131366301)
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
        if ((this.a.i()) && (!arbs.a(arbs.b)))
        {
          paramView = bdgm.a(this.a, 2131698506);
          paramView.setPositiveButton(2131694953, new bdgx());
          paramView.show();
          return;
        }
        if (arbs.a(localFileInfo)) {
          arbs.b(localFileInfo);
        }
        for (;;)
        {
          this.a.l();
          if (!this.a.f()) {
            break;
          }
          ((arcd)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          ((arcd)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(arbs.a(localFileInfo));
          return;
          if (this.a.f) {
            arbs.b();
          }
          if (localFileInfo.a() == -1) {
            localFileInfo.b(arrr.a(localFileInfo.c()));
          }
          arbs.a(localFileInfo);
          if (this.a.f) {
            LocalFileBrowserActivity.a(this.a);
          }
        }
        ((arcd)localObject).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
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
      azqs.b(this.a.app, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
    }
    this.a.e();
    localObject = arrr.a(localFileInfo);
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
      arbs.a(this.a.b);
      paramView.putExtra("clicked_file_hashcode", localFileInfo.hashCode());
    }
    localObject = new arrq();
    ((arrq)localObject).b = "file_viewer_in";
    ((arrq)localObject).jdField_a_of_type_Int = 80;
    ((arrq)localObject).c = arso.a(localFileInfo.d());
    ((arrq)localObject).jdField_a_of_type_Long = localFileInfo.a();
    arrp.a(this.a.app.getCurrentAccountUin(), (arrq)localObject);
    this.a.startActivityForResult(paramView, 102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqmj
 * JD-Core Version:    0.7.0.1
 */