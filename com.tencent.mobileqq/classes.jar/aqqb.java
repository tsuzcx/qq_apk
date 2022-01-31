import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aqqb
  implements View.OnClickListener
{
  aqqb(aqqa paramaqqa) {}
  
  public void onClick(View paramView)
  {
    Object localObject = arrr.a((FileInfo)((aqqc)paramView.getTag()).a);
    localObject = new arlq(aqqa.a(this.a).app, aqqa.a(this.a), (FileManagerEntity)localObject, 10000);
    localObject = new arls(aqqa.a(this.a), (arlv)localObject);
    ((arls)localObject).a(8);
    ((arls)localObject).a(zjc.a(paramView));
    ((arls)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqb
 * JD-Core Version:    0.7.0.1
 */