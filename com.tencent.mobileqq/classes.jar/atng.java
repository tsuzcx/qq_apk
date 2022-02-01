import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atng
  implements View.OnClickListener
{
  atng(atnf paramatnf) {}
  
  public void onClick(View paramView)
  {
    Object localObject = aunj.a((FileInfo)((atnh)paramView.getTag()).a);
    localObject = new auhr(atnf.a(this.a).app, atnf.a(this.a), (FileManagerEntity)localObject, 10000);
    localObject = new auht(atnf.a(this.a), (auhw)localObject);
    ((auht)localObject).a(8);
    ((auht)localObject).a(abke.a(paramView));
    ((auht)localObject).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atng
 * JD-Core Version:    0.7.0.1
 */