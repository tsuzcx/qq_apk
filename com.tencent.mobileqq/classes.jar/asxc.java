import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class asxc
  implements View.OnClickListener
{
  asxc(asxb paramasxb) {}
  
  public void onClick(View paramView)
  {
    Object localObject = atvo.a((FileInfo)((asxd)paramView.getTag()).a);
    localObject = new atpw(asxb.a(this.a).app, asxb.a(this.a), (FileManagerEntity)localObject, 10000);
    localObject = new atpy(asxb.a(this.a), (atqb)localObject);
    ((atpy)localObject).a(8);
    ((atpy)localObject).a(abga.a(paramView));
    ((atpy)localObject).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxc
 * JD-Core Version:    0.7.0.1
 */