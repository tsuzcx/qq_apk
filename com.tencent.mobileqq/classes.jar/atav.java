import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atav
  implements View.OnClickListener
{
  public atav(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    atbg localatbg = (atbg)paramView.getTag();
    Object localObject2 = (WeiYunFileInfo)localatbg.a;
    Object localObject1 = QfileBaseCloudFileTabView.d(this.a).getFileManagerDataCenter().c(((WeiYunFileInfo)localObject2).jdField_a_of_type_JavaLangString);
    if (localObject1 != null) {
      if (localatbg.c == 1)
      {
        this.a.a.a().aa();
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          audr.a(2131692469);
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
        aucx.a((FileManagerEntity)localObject1).a(false, this.a.a, new ataw(this, (FileManagerEntity)localObject1));
      }
    }
    for (;;)
    {
      this.a.i();
      break;
      if (localatbg.c == 3)
      {
        this.a.a.a().ac();
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          audr.a(2131692469);
          break;
        }
        aucx.a((FileManagerEntity)localObject1).a(false, this.a.a, new atax(this, (FileManagerEntity)localObject1));
        continue;
      }
      if (localatbg.c == 0)
      {
        this.a.a.a().Z();
        localObject2 = new audz();
        ((audz)localObject2).b = "file_viewer_in";
        ((audz)localObject2).jdField_a_of_type_Int = 73;
        ((audz)localObject2).c = FileUtil.getExtension(((FileManagerEntity)localObject1).fileName);
        ((audz)localObject2).jdField_a_of_type_Long = ((FileManagerEntity)localObject1).fileSize;
        audy.a(QfileBaseCloudFileTabView.g(this.a).getCurrentAccountUin(), (audz)localObject2);
        localObject2 = new ForwardFileInfo();
        ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).getCloudType());
        ((ForwardFileInfo)localObject2).b(10001);
        ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).nSessionId);
        ((ForwardFileInfo)localObject2).c(((FileManagerEntity)localObject1).uniseq);
        ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileName);
        ((ForwardFileInfo)localObject2).d(((FileManagerEntity)localObject1).fileSize);
        ((ForwardFileInfo)localObject2).b(((FileManagerEntity)localObject1).Uuid);
        localObject1 = new Intent(QfileBaseCloudFileTabView.a(this.a), FileBrowserActivity.class);
        ((Intent)localObject1).putExtra("fileinfo", (Parcelable)localObject2);
        QfileBaseCloudFileTabView.b(this.a).startActivityForResult((Intent)localObject1, 102);
      }
      else if (localatbg.c == 2)
      {
        this.a.a.a().ab();
        QfileBaseCloudFileTabView.h(this.a).getFileManagerEngine().a(((FileManagerEntity)localObject1).nSessionId);
        continue;
        this.a.a.a().aa();
        localObject1 = new atay(this, (WeiYunFileInfo)localObject2);
        if ((((WeiYunFileInfo)localObject2).jdField_a_of_type_Long > atpj.a()) && (auea.a())) {
          auea.a(false, this.a.a, (audq)localObject1);
        } else {
          ((audq)localObject1).onYes();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atav
 * JD-Core Version:    0.7.0.1
 */