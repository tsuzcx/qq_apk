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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class assj
  implements View.OnClickListener
{
  public assj(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = (atho)paramView.getTag();
    Object localObject1 = ((atho)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    int i;
    if (paramView.getId() == 2131366555)
    {
      i = 1;
      if (!((FileInfo)localObject1).c()) {
        break label58;
      }
      LocalFileBrowserActivity.a(this.a, ((FileInfo)localObject1).c(), true);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      label58:
      if ((this.a.f()) && (i == 0))
      {
        if ((this.a.i()) && (!athc.a(athc.b)))
        {
          localObject1 = bglp.a(this.a, 2131697403);
          ((bgpa)localObject1).setPositiveButton(2131694081, new bgmc());
          ((bgpa)localObject1).show();
        }
        else
        {
          if (athc.a((FileInfo)localObject1)) {
            athc.b((FileInfo)localObject1);
          }
          for (;;)
          {
            this.a.l();
            if (!this.a.f()) {
              break label230;
            }
            ((atho)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            ((atho)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(athc.a((FileInfo)localObject1));
            break;
            if (this.a.h) {
              athc.b();
            }
            if (((FileInfo)localObject1).a() == -1) {
              ((FileInfo)localObject1).b(atvo.a(((FileInfo)localObject1).c()));
            }
            athc.a((FileInfo)localObject1);
            if (this.a.h) {
              LocalFileBrowserActivity.a(this.a);
            }
          }
          label230:
          ((atho)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        }
      }
      else if (!this.a.a())
      {
        if (QLog.isColorLevel()) {
          QLog.i(LocalFileBrowserActivity.g, 2, "click too fast , wait a minute.");
        }
      }
      else
      {
        if (this.a.f()) {
          bcst.b(this.a.app, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
        }
        this.a.e();
        Object localObject3 = atvo.a((FileInfo)localObject1);
        ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
        localForwardFileInfo.b(((FileManagerEntity)localObject3).nSessionId);
        localForwardFileInfo.d(3);
        localForwardFileInfo.b(10000);
        localForwardFileInfo.a(((FileInfo)localObject1).c());
        localForwardFileInfo.d(((FileInfo)localObject1).d());
        localForwardFileInfo.d(((FileInfo)localObject1).a());
        localObject2 = new Intent(this.a.getApplicationContext(), FileBrowserActivity.class);
        ((Intent)localObject2).putExtra("fileinfo", localForwardFileInfo);
        if ((((FileManagerEntity)localObject3).nFileType == 0) || (((FileManagerEntity)localObject3).nFileType == 1))
        {
          athc.a(this.a.b);
          ((Intent)localObject2).putExtra("clicked_file_hashcode", ((FileInfo)localObject1).hashCode());
        }
        localObject3 = new atvn();
        ((atvn)localObject3).b = "file_viewer_in";
        ((atvn)localObject3).jdField_a_of_type_Int = 80;
        ((atvn)localObject3).c = atwl.a(((FileInfo)localObject1).d());
        ((atvn)localObject3).jdField_a_of_type_Long = ((FileInfo)localObject1).a();
        atvm.a(this.a.app.getCurrentAccountUin(), (atvn)localObject3);
        this.a.startActivityForResult((Intent)localObject2, 102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assj
 * JD-Core Version:    0.7.0.1
 */