import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qcircleshadow.local.requests.QCircleSetCircleSwitchRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auyb
  implements CompoundButton.OnCheckedChangeListener
{
  auyb(auya paramauya) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = "1";; localObject = "0")
    {
      localObject = new QCircleSetCircleSwitchRequest("qqcircle", "qqcircle_entrance_enable", (String)localObject);
      VSNetworkHelper.getInstance().sendRequest((VSBaseRequest)localObject, new auyc(this, paramBoolean));
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auyb
 * JD-Core Version:    0.7.0.1
 */