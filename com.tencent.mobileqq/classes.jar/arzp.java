import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class arzp
  implements View.OnClickListener
{
  arzp(arzo paramarzo) {}
  
  public void onClick(View paramView)
  {
    Object localObject = aszt.a((FileInfo)((arzq)paramView.getTag()).a);
    localObject = new asub(arzo.a(this.a).app, arzo.a(this.a), (FileManagerEntity)localObject, 10000);
    localObject = new asud(arzo.a(this.a), (asug)localObject);
    ((asud)localObject).a(8);
    ((asud)localObject).a(aagn.a(paramView));
    ((asud)localObject).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzp
 * JD-Core Version:    0.7.0.1
 */