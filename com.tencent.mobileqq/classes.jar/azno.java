import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class azno
  implements View.OnClickListener
{
  azno(aznl paramaznl) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ProfileCircleComponent", 4, "qqCircleWriteEntrance onClick");
    Intent localIntent = new Intent();
    localIntent.putExtra("key_is_publish", true);
    localIntent.putExtra("key_jump_from", "5");
    uxo.a(aznl.a(this.a), localIntent);
    vrf.a("", 3, 2, 2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azno
 * JD-Core Version:    0.7.0.1
 */