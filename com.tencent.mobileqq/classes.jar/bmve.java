import android.os.Bundle;
import com.tencent.biz.qqcircle.beans.QCircleFakeFeed;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.List;

public class bmve
  implements EIPCResultCallback
{
  public bmve(QzoneIPCModule paramQzoneIPCModule) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    ArrayList localArrayList;
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null))
    {
      paramEIPCResult = paramEIPCResult.data;
      paramEIPCResult.setClassLoader(QCircleFakeFeed.class.getClassLoader());
      localArrayList = paramEIPCResult.getParcelableArrayList("KEY_CERTIFIED_FAKE_FEED_LIST");
      if (localArrayList != null) {
        aaak.a().a(new QCircleFeedEvent(localArrayList));
      }
      aaak.a().a(new QCirclePublishBoxStatusEvent(paramEIPCResult));
      if (localArrayList != null) {
        break label93;
      }
    }
    label93:
    for (int i = 0;; i = localArrayList.size())
    {
      QLog.d("QzoneIPCModule", 4, String.format("Get QCircleFakeFeed task list %b", new Object[] { Integer.valueOf(i) }));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmve
 * JD-Core Version:    0.7.0.1
 */