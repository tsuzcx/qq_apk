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

public class aruw
  implements View.OnClickListener
{
  public aruw(LocalFileBrowserActivity paramLocalFileBrowserActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = (asls)paramView.getTag();
    Object localObject1 = ((asls)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileInfo;
    int i;
    if (paramView.getId() == 2131366631)
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
        if ((this.a.i()) && (!aslg.a(aslg.b)))
        {
          localObject1 = bfur.a(this.a, 2131697629);
          ((QQCustomDialog)localObject1).setPositiveButton(2131694201, new bfvf());
          ((QQCustomDialog)localObject1).show();
        }
        else
        {
          if (aslg.a((FileInfo)localObject1)) {
            aslg.b((FileInfo)localObject1);
          }
          for (;;)
          {
            this.a.l();
            if (!this.a.f()) {
              break label230;
            }
            ((asls)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
            ((asls)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(aslg.a((FileInfo)localObject1));
            break;
            if (this.a.h) {
              aslg.b();
            }
            if (((FileInfo)localObject1).a() == -1) {
              ((FileInfo)localObject1).b(aszt.a(((FileInfo)localObject1).c()));
            }
            aslg.a((FileInfo)localObject1);
            if (this.a.h) {
              LocalFileBrowserActivity.a(this.a);
            }
          }
          label230:
          ((asls)localObject2).jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(8);
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
          bcef.b(this.a.app, "dc00898", "", "", "0X800A665", "0X800A665", 0, 0, "", "", "", "");
        }
        this.a.e();
        Object localObject3 = aszt.a((FileInfo)localObject1);
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
          aslg.a(this.a.b);
          ((Intent)localObject2).putExtra("clicked_file_hashcode", ((FileInfo)localObject1).hashCode());
        }
        localObject3 = new aszs();
        ((aszs)localObject3).b = "file_viewer_in";
        ((aszs)localObject3).jdField_a_of_type_Int = 80;
        ((aszs)localObject3).c = FileUtil.getExtension(((FileInfo)localObject1).d());
        ((aszs)localObject3).jdField_a_of_type_Long = ((FileInfo)localObject1).a();
        aszr.a(this.a.app.getCurrentAccountUin(), (aszs)localObject3);
        this.a.startActivityForResult((Intent)localObject2, 102);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aruw
 * JD-Core Version:    0.7.0.1
 */