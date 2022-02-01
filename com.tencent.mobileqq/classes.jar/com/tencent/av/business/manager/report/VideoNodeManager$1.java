package com.tencent.av.business.manager.report;

import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.mobileqq.statistics.DcReportUtil;
import java.util.Map;

final class VideoNodeManager$1
  implements Handler.Callback
{
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    long l1;
    int i;
    long l2;
    boolean bool;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 6: 
      l1 = ((Bundle)localObject).getLong("roomId");
      i = ((Bundle)localObject).getInt("node");
      l2 = ((Bundle)localObject).getLong("value");
      bool = ((Bundle)localObject).getBoolean("isNode");
      VideoNodeManager.a(i, true);
      if (VideoNodeManager.a(i, true, bool)) {
        return false;
      }
      if ((bool) && (VideoNodeManager.a(33, true)))
      {
        paramMessage = new StringBuilder();
        paramMessage.append("--> TempSeesion THE node_session_close has write !!  this node  be rejected !!   node = ");
        paramMessage.append(VideoNodeConstant.a(i));
        AVLog.printInfoLog("VideoNodeManager", paramMessage.toString());
        return false;
      }
      paramMessage = new StringBuilder();
      paramMessage.append(i);
      paramMessage.append("");
      paramMessage = paramMessage.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("");
      VideoNodeManager.a(paramMessage, ((StringBuilder)localObject).toString(), bool);
      VideoNodeManager.a(i, l2, true);
      paramMessage = new StringBuilder();
      paramMessage.append("reportToTempSeesionRecord ,roomId = ");
      paramMessage.append(l1);
      paramMessage.append("  node = ");
      paramMessage.append(VideoNodeConstant.a(i));
      paramMessage.append(", value = ");
      paramMessage.append(l2);
      paramMessage.append("   isNode = ");
      paramMessage.append(bool);
      AVLog.printInfoLog("VideoNodeManager", paramMessage.toString());
      return false;
    case 5: 
      paramMessage = VideoNodeManager.b();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--> handleMessage() what = MSG_REPORT_TEMP_RECORD_TO_SERVER detail = ");
      ((StringBuilder)localObject).append(paramMessage);
      AVLog.printInfoLog("VideoNodeManager", ((StringBuilder)localObject).toString());
      if (TextUtils.isEmpty(paramMessage)) {
        break label720;
      }
      DcReportUtil.a(null, "dc03209", paramMessage);
      VideoNodeManager.f();
      return false;
    case 3: 
      paramMessage = VideoNodeManager.a();
      if (!TextUtils.isEmpty(paramMessage))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("--> handleMessage() what = MSG_REPORT_TO_SERVER detail = ");
        ((StringBuilder)localObject).append(paramMessage);
        AVLog.printDebugLog("VideoNodeManager", ((StringBuilder)localObject).toString());
        DcReportUtil.a(null, "dc03209", paramMessage);
        VideoNodeManager.e();
      }
      if (VideoNodeManager.a() == null) {
        break label720;
      }
      if (VideoNodeManager.a().size() == 0) {
        return false;
      }
    case 4: 
      VideoNodeManager.j();
      return false;
    case 2: 
      l1 = ((Bundle)localObject).getLong("roomId");
      i = ((Bundle)localObject).getInt("node");
      l2 = ((Bundle)localObject).getLong("value");
      bool = ((Bundle)localObject).getBoolean("isNode");
      VideoNodeManager.a(i, false);
      if (VideoNodeManager.a(i, false, bool)) {
        return false;
      }
      if ((bool) && (VideoNodeManager.a(33, false)))
      {
        paramMessage = new StringBuilder();
        paramMessage.append("--> THE node_session_close has write !!  this node  be rejected !!   node = ");
        paramMessage.append(VideoNodeConstant.a(i));
        AVLog.printInfoLog("VideoNodeManager", paramMessage.toString());
        return false;
      }
      if (VideoNodeManager.a(i))
      {
        paramMessage = new StringBuilder();
        paramMessage.append("reportToHandler  roomId = ");
        paramMessage.append(l1);
        paramMessage.append("  node = ");
        paramMessage.append(VideoNodeConstant.a(i));
        paramMessage.append(",  value = ");
        paramMessage.append(l2);
        paramMessage.append("   isNode = ");
        paramMessage.append(bool);
        AVLog.printDebugLog("VideoNodeManager", paramMessage.toString());
      }
      paramMessage = new StringBuilder();
      paramMessage.append(i);
      paramMessage.append("");
      paramMessage = paramMessage.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("");
      VideoNodeManager.b(paramMessage, ((StringBuilder)localObject).toString(), bool);
      VideoNodeManager.a(i, l2, false);
      return false;
    }
    if (VideoNodeManager.a() == null) {
      return false;
    }
    VideoNodeManager.c();
    VideoNodeManager.a(24, VideoNodeManager.b());
    try
    {
      VideoNodeManager.a().sendEmptyMessageDelayed(1, 5000L);
      return false;
    }
    catch (NullPointerException paramMessage)
    {
      paramMessage.printStackTrace();
    }
    label720:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.report.VideoNodeManager.1
 * JD-Core Version:    0.7.0.1
 */