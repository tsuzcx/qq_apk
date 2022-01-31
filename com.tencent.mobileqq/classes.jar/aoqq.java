import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileBaseCloudFileTabView;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;

public class aoqq
  implements View.OnClickListener
{
  public aoqq(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    aorb localaorb = (aorb)paramView.getTag();
    Object localObject = (WeiYunFileInfo)localaorb.a;
    paramView = QfileBaseCloudFileTabView.d(this.a).a().c(((WeiYunFileInfo)localObject).jdField_a_of_type_JavaLangString);
    if (paramView != null) {
      if (localaorb.c == 1)
      {
        this.a.a.a().ac();
        if (!bbev.d(BaseApplication.getContext()))
        {
          aptv.a(2131692665);
          return;
        }
        apsz.a(paramView).a(false, this.a.a, new aoqr(this, paramView));
      }
    }
    for (;;)
    {
      this.a.i();
      return;
      if (localaorb.c == 3)
      {
        this.a.a.a().ae();
        if (!bbev.d(BaseApplication.getContext()))
        {
          aptv.a(2131692665);
          return;
        }
        apsz.a(paramView).a(false, this.a.a, new aoqs(this, paramView));
      }
      else if (localaorb.c == 0)
      {
        this.a.a.a().ab();
        localObject = new apud();
        ((apud)localObject).b = "file_viewer_in";
        ((apud)localObject).jdField_a_of_type_Int = 73;
        ((apud)localObject).c = apvb.a(paramView.fileName);
        ((apud)localObject).jdField_a_of_type_Long = paramView.fileSize;
        apuc.a(QfileBaseCloudFileTabView.g(this.a).getCurrentAccountUin(), (apud)localObject);
        localObject = new ForwardFileInfo();
        ((ForwardFileInfo)localObject).d(paramView.getCloudType());
        ((ForwardFileInfo)localObject).b(10001);
        ((ForwardFileInfo)localObject).b(paramView.nSessionId);
        ((ForwardFileInfo)localObject).c(paramView.uniseq);
        ((ForwardFileInfo)localObject).d(paramView.fileName);
        ((ForwardFileInfo)localObject).d(paramView.fileSize);
        ((ForwardFileInfo)localObject).b(paramView.Uuid);
        paramView = new Intent(QfileBaseCloudFileTabView.a(this.a), FileBrowserActivity.class);
        paramView.putExtra("fileinfo", (Parcelable)localObject);
        QfileBaseCloudFileTabView.b(this.a).startActivityForResult(paramView, 102);
      }
      else if (localaorb.c == 2)
      {
        this.a.a.a().ad();
        QfileBaseCloudFileTabView.h(this.a).a().a(paramView.nSessionId);
        continue;
        this.a.a.a().ac();
        paramView = new aoqt(this, (WeiYunFileInfo)localObject);
        if ((((WeiYunFileInfo)localObject).jdField_a_of_type_Long > apee.a()) && (apue.a())) {
          apue.a(false, this.a.a, paramView);
        } else {
          paramView.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoqq
 * JD-Core Version:    0.7.0.1
 */