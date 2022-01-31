import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aqls
  implements View.OnClickListener
{
  aqls(aqlr paramaqlr) {}
  
  public void onClick(View paramView)
  {
    Object localObject = arni.a((FileInfo)((aqlt)paramView.getTag()).a);
    localObject = new arhh(aqlr.a(this.a).app, aqlr.a(this.a), (FileManagerEntity)localObject, 10000);
    localObject = new arhj(aqlr.a(this.a), (arhm)localObject);
    ((arhj)localObject).a(8);
    ((arhj)localObject).a(zen.a(paramView));
    ((arhj)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqls
 * JD-Core Version:    0.7.0.1
 */