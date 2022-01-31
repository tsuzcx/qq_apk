import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class aosu
  implements View.OnClickListener
{
  aosu(aost paramaost) {}
  
  public void onClick(View paramView)
  {
    Object localObject = apug.a((FileInfo)((aosv)paramView.getTag()).a);
    localObject = new apoi(aost.a(this.a).app, aost.a(this.a), (FileManagerEntity)localObject, 10000);
    localObject = new apok(aost.a(this.a), (apon)localObject);
    ((apok)localObject).a(8);
    ((apok)localObject).a(xpu.a(paramView));
    ((apok)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aosu
 * JD-Core Version:    0.7.0.1
 */