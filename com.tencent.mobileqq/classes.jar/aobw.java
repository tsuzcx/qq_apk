import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aobw
  implements View.OnClickListener
{
  aobw(aobv paramaobv) {}
  
  public void onClick(View paramView)
  {
    Object localObject = apck.a((FileInfo)((aobx)paramView.getTag()).a);
    localObject = new aowq(aobv.a(this.a).app, aobv.a(this.a), (FileManagerEntity)localObject, 10000);
    localObject = new aows(aobv.a(this.a), (aowv)localObject);
    ((aows)localObject).a(8);
    ((aows)localObject).a(xgx.a(paramView));
    ((aows)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aobw
 * JD-Core Version:    0.7.0.1
 */