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
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asuc
  implements View.OnClickListener
{
  public asuc(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    asun localasun = (asun)paramView.getTag();
    Object localObject2 = (WeiYunFileInfo)localasun.a;
    Object localObject1 = QfileBaseCloudFileTabView.d(this.a).a().c(((WeiYunFileInfo)localObject2).jdField_a_of_type_JavaLangString);
    if (localObject1 != null) {
      if (localasun.c == 1)
      {
        this.a.a.a().aa();
        if (!bgnt.d(BaseApplication.getContext()))
        {
          atvf.a(2131692314);
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
        atul.a((FileManagerEntity)localObject1).a(false, this.a.a, new asud(this, (FileManagerEntity)localObject1));
      }
    }
    for (;;)
    {
      this.a.i();
      break;
      if (localasun.c == 3)
      {
        this.a.a.a().ac();
        if (!bgnt.d(BaseApplication.getContext()))
        {
          atvf.a(2131692314);
          break;
        }
        atul.a((FileManagerEntity)localObject1).a(false, this.a.a, new asue(this, (FileManagerEntity)localObject1));
        continue;
      }
      if (localasun.c == 0)
      {
        this.a.a.a().Z();
        localObject2 = new atvn();
        ((atvn)localObject2).b = "file_viewer_in";
        ((atvn)localObject2).jdField_a_of_type_Int = 73;
        ((atvn)localObject2).c = atwl.a(((FileManagerEntity)localObject1).fileName);
        ((atvn)localObject2).jdField_a_of_type_Long = ((FileManagerEntity)localObject1).fileSize;
        atvm.a(QfileBaseCloudFileTabView.g(this.a).getCurrentAccountUin(), (atvn)localObject2);
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
      else if (localasun.c == 2)
      {
        this.a.a.a().ab();
        QfileBaseCloudFileTabView.h(this.a).a().a(((FileManagerEntity)localObject1).nSessionId);
        continue;
        this.a.a.a().aa();
        localObject1 = new asuf(this, (WeiYunFileInfo)localObject2);
        if ((((WeiYunFileInfo)localObject2).jdField_a_of_type_Long > atgz.a()) && (atvo.a())) {
          atvo.a(false, this.a.a, (atve)localObject1);
        } else {
          ((atve)localObject1).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asuc
 * JD-Core Version:    0.7.0.1
 */