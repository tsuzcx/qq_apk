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
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aszc
  implements View.OnClickListener
{
  public aszc(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = (atpy)paramView.getTag();
    Object localObject1 = ((atpy)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    int i;
    if (paramView.getId() == 2131366742)
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
        if ((this.a.i()) && (!atpm.a(atpm.b)))
        {
          localObject1 = bhdj.a(this.a, 2131697909);
          ((QQCustomDialog)localObject1).setPositiveButton(2131694399, new bhdx());
          ((QQCustomDialog)localObject1).show();
        }
        else
        {
          if (atpm.a((FileInfo)localObject1)) {
            atpm.b((FileInfo)localObject1);
          }
          for (;;)
          {
            this.a.l();
            if (!this.a.f()) {
              break label230;
            }
            ((atpy)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            ((atpy)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(atpm.a((FileInfo)localObject1));
            break;
            if (this.a.h) {
              atpm.b();
            }
            if (((FileInfo)localObject1).a() == -1) {
              ((FileInfo)localObject1).b(auea.a(((FileInfo)localObject1).c()));
            }
            atpm.a((FileInfo)localObject1);
            if (this.a.h) {
              LocalFileBrowserActivity.a(this.a);
            }
          }
          label230:
          ((atpy)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
        }
      }
      else if (!this.a.a())
      {
        if (QLog.isColorLevel()) {
          QLog.i(LocalFileBrowserActivity.f, 2, "click too fast , wait a minute.");
        }
      }
      else
      {
        if (this.a.f()) {
          bdla.b(this.a.app, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
        }
        this.a.e();
        Object localObject3 = auea.a((FileInfo)localObject1);
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
          atpm.a(this.a.b);
          ((Intent)localObject2).putExtra("clicked_file_hashcode", ((FileInfo)localObject1).hashCode());
        }
        localObject3 = new audz();
        ((audz)localObject3).b = "file_viewer_in";
        ((audz)localObject3).jdField_a_of_type_Int = 80;
        ((audz)localObject3).c = FileUtil.getExtension(((FileInfo)localObject1).d());
        ((audz)localObject3).jdField_a_of_type_Long = ((FileInfo)localObject1).a();
        audy.a(this.a.app.getCurrentAccountUin(), (audz)localObject3);
        this.a.startActivityForResult((Intent)localObject2, 102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszc
 * JD-Core Version:    0.7.0.1
 */