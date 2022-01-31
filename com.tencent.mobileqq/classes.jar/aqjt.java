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

public class aqjt
  implements View.OnClickListener
{
  public aqjt(QfileBaseCloudFileTabView paramQfileBaseCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    aqke localaqke = (aqke)paramView.getTag();
    Object localObject = (WeiYunFileInfo)localaqke.a;
    paramView = QfileBaseCloudFileTabView.d(this.a).a().c(((WeiYunFileInfo)localObject).jdField_a_of_type_JavaLangString);
    if (paramView != null) {
      if (localaqke.c == 1)
      {
        this.a.a.a().ac();
        if (!bdee.d(BaseApplication.getContext()))
        {
          armz.a(2131692745);
          return;
        }
        armf.a(paramView).a(false, this.a.a, new aqju(this, paramView));
      }
    }
    for (;;)
    {
      this.a.i();
      return;
      if (localaqke.c == 3)
      {
        this.a.a.a().ae();
        if (!bdee.d(BaseApplication.getContext()))
        {
          armz.a(2131692745);
          return;
        }
        armf.a(paramView).a(false, this.a.a, new aqjv(this, paramView));
      }
      else if (localaqke.c == 0)
      {
        this.a.a.a().ab();
        localObject = new arnh();
        ((arnh)localObject).b = "file_viewer_in";
        ((arnh)localObject).jdField_a_of_type_Int = 73;
        ((arnh)localObject).c = arof.a(paramView.fileName);
        ((arnh)localObject).jdField_a_of_type_Long = paramView.fileSize;
        arng.a(QfileBaseCloudFileTabView.g(this.a).getCurrentAccountUin(), (arnh)localObject);
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
      else if (localaqke.c == 2)
      {
        this.a.a.a().ad();
        QfileBaseCloudFileTabView.h(this.a).a().a(paramView.nSessionId);
        continue;
        this.a.a.a().ac();
        paramView = new aqjw(this, (WeiYunFileInfo)localObject);
        if ((((WeiYunFileInfo)localObject).jdField_a_of_type_Long > aqxg.a()) && (arni.a())) {
          arni.a(false, this.a.a, paramView);
        } else {
          paramView.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqjt
 * JD-Core Version:    0.7.0.1
 */