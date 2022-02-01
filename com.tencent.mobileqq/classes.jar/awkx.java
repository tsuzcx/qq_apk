import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qqcircle.requests.QCircleSetCircleSwitchRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awkx
  implements CompoundButton.OnCheckedChangeListener
{
  awkx(awkw paramawkw) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = new QCircleSetCircleSwitchRequest("qqcircle", "qqcircle_entrance_enable", (String)localObject);
      VSNetworkHelper.a().a((VSBaseRequest)localObject, new awky(this, paramBoolean));
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkx
 * JD-Core Version:    0.7.0.1
 */