import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atdv
  implements View.OnClickListener
{
  atdv(atdu paramatdu) {}
  
  public void onClick(View paramView)
  {
    Object localObject = auea.a((FileInfo)((atdw)paramView.getTag()).a);
    localObject = new atyi(atdu.a(this.a).app, atdu.a(this.a), (FileManagerEntity)localObject, 10000);
    localObject = new atyk(atdu.a(this.a), (atyn)localObject);
    ((atyk)localObject).a(8);
    ((atyk)localObject).a(aavz.a(paramView));
    ((atyk)localObject).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdv
 * JD-Core Version:    0.7.0.1
 */