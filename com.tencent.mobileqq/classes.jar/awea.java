import android.text.TextUtils;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qcircleshadow.local.requests.QCircleSetMultiCircleWnsConfigRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import java.util.HashMap;

class awea
  implements CompoundButton.OnCheckedChangeListener
{
  awea(awdz paramawdz) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    String str = "";
    Object localObject;
    HashMap localHashMap;
    if (paramBoolean)
    {
      localObject = "1";
      localHashMap = new HashMap();
      if ((bdvn.a()) || (!paramBoolean)) {
        break label143;
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(str))
      {
        localHashMap.put("qqcircle_entrance_enable_on_children_mode", str);
        QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable_on_children_mode", str);
      }
      localHashMap.put("qqcircle_entrance_enable", localObject);
      QzoneConfig.getInstance().updateOneConfig("qqcircle", "qqcircle_entrance_enable", (String)localObject);
      localObject = new HashMap();
      ((HashMap)localObject).put("qqcircle", localHashMap);
      localObject = new QCircleSetMultiCircleWnsConfigRequest((HashMap)localObject);
      VSNetworkHelper.getInstance().sendRequest((VSBaseRequest)localObject, new aweb(this, paramBoolean, str));
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      localObject = "0";
      break;
      label143:
      if (paramBoolean) {
        str = "1";
      } else {
        str = "0";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awea
 * JD-Core Version:    0.7.0.1
 */