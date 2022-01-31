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

public class aqoc
  implements View.OnClickListener
{
  public aqoc(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    aqon localaqon = (aqon)paramView.getTag();
    Object localObject = (WeiYunFileInfo)localaqon.a;
    paramView = QfileBaseCloudFileTabView.d(this.a).a().c(((WeiYunFileInfo)localObject).jdField_a_of_type_JavaLangString);
    if (paramView != null) {
      if (localaqon.c == 1)
      {
        this.a.a.a().ac();
        if (!bdin.d(BaseApplication.getContext()))
        {
          arri.a(2131692747);
          return;
        }
        arqo.a(paramView).a(false, this.a.a, new aqod(this, paramView));
      }
    }
    for (;;)
    {
      this.a.i();
      return;
      if (localaqon.c == 3)
      {
        this.a.a.a().ae();
        if (!bdin.d(BaseApplication.getContext()))
        {
          arri.a(2131692747);
          return;
        }
        arqo.a(paramView).a(false, this.a.a, new aqoe(this, paramView));
      }
      else if (localaqon.c == 0)
      {
        this.a.a.a().ab();
        localObject = new arrq();
        ((arrq)localObject).b = "file_viewer_in";
        ((arrq)localObject).jdField_a_of_type_Int = 73;
        ((arrq)localObject).c = arso.a(paramView.fileName);
        ((arrq)localObject).jdField_a_of_type_Long = paramView.fileSize;
        arrp.a(QfileBaseCloudFileTabView.g(this.a).getCurrentAccountUin(), (arrq)localObject);
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
      else if (localaqon.c == 2)
      {
        this.a.a.a().ad();
        QfileBaseCloudFileTabView.h(this.a).a().a(paramView.nSessionId);
        continue;
        this.a.a.a().ac();
        paramView = new aqof(this, (WeiYunFileInfo)localObject);
        if ((((WeiYunFileInfo)localObject).jdField_a_of_type_Long > arbp.a()) && (arrr.a())) {
          arrr.a(false, this.a.a, paramView);
        } else {
          paramView.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqoc
 * JD-Core Version:    0.7.0.1
 */