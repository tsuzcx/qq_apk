package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGroundCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/RIJChannelStayTimeMonitor$foreBackGroundCallback$1", "Lcom/tencent/biz/pubaccount/readinjoy/engine/ReadinjoySPEventReport$ForeBackGroundCallback;", "background", "", "foreground", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJChannelStayTimeMonitor$foreBackGroundCallback$1
  implements ReadinjoySPEventReport.ForeBackGroundCallback
{
  public void l()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = RIJChannelStayTimeMonitor.a(RIJChannelStayTimeMonitor.a);
    if (localTabChannelCoverInfo != null) {
      RIJChannelStayTimeMonitor.a.a(localTabChannelCoverInfo.mChannelCoverId);
    }
  }
  
  public void m()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = RIJChannelStayTimeMonitor.a(RIJChannelStayTimeMonitor.a);
    int i;
    if (localTabChannelCoverInfo != null)
    {
      localObject = (CharSequence)localTabChannelCoverInfo.mChannelVersion;
      if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
        break label59;
      }
      i = 1;
      if (i == 0) {
        break label64;
      }
    }
    label59:
    label64:
    for (Object localObject = "0";; localObject = localTabChannelCoverInfo.mChannelVersion)
    {
      RIJChannelStayTimeMonitor.a.a(localTabChannelCoverInfo.mChannelCoverId, RIJChannelStayTimeMonitor.a(RIJChannelStayTimeMonitor.a), (String)localObject);
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.RIJChannelStayTimeMonitor.foreBackGroundCallback.1
 * JD-Core Version:    0.7.0.1
 */