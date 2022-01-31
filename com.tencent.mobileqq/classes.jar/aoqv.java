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

public class aoqv
  implements View.OnClickListener
{
  public aoqv(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    aorg localaorg = (aorg)paramView.getTag();
    Object localObject = (WeiYunFileInfo)localaorg.a;
    paramView = QfileBaseCloudFileTabView.d(this.a).a().c(((WeiYunFileInfo)localObject).jdField_a_of_type_JavaLangString);
    if (paramView != null) {
      if (localaorg.c == 1)
      {
        this.a.a.a().ac();
        if (!bbfj.d(BaseApplication.getContext()))
        {
          aptx.a(2131692666);
          return;
        }
        aptd.a(paramView).a(false, this.a.a, new aoqw(this, paramView));
      }
    }
    for (;;)
    {
      this.a.i();
      return;
      if (localaorg.c == 3)
      {
        this.a.a.a().ae();
        if (!bbfj.d(BaseApplication.getContext()))
        {
          aptx.a(2131692666);
          return;
        }
        aptd.a(paramView).a(false, this.a.a, new aoqx(this, paramView));
      }
      else if (localaorg.c == 0)
      {
        this.a.a.a().ab();
        localObject = new apuf();
        ((apuf)localObject).b = "file_viewer_in";
        ((apuf)localObject).jdField_a_of_type_Int = 73;
        ((apuf)localObject).c = apvd.a(paramView.fileName);
        ((apuf)localObject).jdField_a_of_type_Long = paramView.fileSize;
        apue.a(QfileBaseCloudFileTabView.g(this.a).getCurrentAccountUin(), (apuf)localObject);
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
      else if (localaorg.c == 2)
      {
        this.a.a.a().ad();
        QfileBaseCloudFileTabView.h(this.a).a().a(paramView.nSessionId);
        continue;
        this.a.a.a().ac();
        paramView = new aoqy(this, (WeiYunFileInfo)localObject);
        if ((((WeiYunFileInfo)localObject).jdField_a_of_type_Long > apei.a()) && (apug.a())) {
          apug.a(false, this.a.a, paramView);
        } else {
          paramView.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoqv
 * JD-Core Version:    0.7.0.1
 */