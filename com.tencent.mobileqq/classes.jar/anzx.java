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

public class anzx
  implements View.OnClickListener
{
  public anzx(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    aoai localaoai = (aoai)paramView.getTag();
    Object localObject = (WeiYunFileInfo)localaoai.a;
    paramView = QfileBaseCloudFileTabView.d(this.a).a().c(((WeiYunFileInfo)localObject).jdField_a_of_type_JavaLangString);
    if (paramView != null) {
      if (localaoai.c == 1)
      {
        this.a.a.a().ac();
        if (!badq.d(BaseApplication.getContext()))
        {
          apcb.a(2131627028);
          return;
        }
        apbf.a(paramView).a(false, this.a.a, new anzy(this, paramView));
      }
    }
    for (;;)
    {
      this.a.i();
      return;
      if (localaoai.c == 3)
      {
        this.a.a.a().ae();
        if (!badq.d(BaseApplication.getContext()))
        {
          apcb.a(2131627028);
          return;
        }
        apbf.a(paramView).a(false, this.a.a, new anzz(this, paramView));
      }
      else if (localaoai.c == 0)
      {
        this.a.a.a().ab();
        localObject = new apcj();
        ((apcj)localObject).b = "file_viewer_in";
        ((apcj)localObject).jdField_a_of_type_Int = 73;
        ((apcj)localObject).c = apdh.a(paramView.fileName);
        ((apcj)localObject).jdField_a_of_type_Long = paramView.fileSize;
        apci.a(QfileBaseCloudFileTabView.g(this.a).getCurrentAccountUin(), (apcj)localObject);
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
      else if (localaoai.c == 2)
      {
        this.a.a.a().ad();
        QfileBaseCloudFileTabView.h(this.a).a().a(paramView.nSessionId);
        continue;
        this.a.a.a().ac();
        paramView = new aoaa(this, (WeiYunFileInfo)localObject);
        if ((((WeiYunFileInfo)localObject).jdField_a_of_type_Long > aonj.a()) && (apck.a())) {
          apck.a(false, this.a.a, paramView);
        } else {
          paramView.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anzx
 * JD-Core Version:    0.7.0.1
 */