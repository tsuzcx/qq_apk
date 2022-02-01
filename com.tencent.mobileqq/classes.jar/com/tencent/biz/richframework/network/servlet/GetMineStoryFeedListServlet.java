package com.tencent.biz.richframework.network.servlet;

import NS_QQ_STORY_CLIENT.CLIENT.StUinTime;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebRsp;
import android.content.Intent;
import android.os.Bundle;
import bhjl;
import com.tencent.biz.richframework.network.request.GetMineStoryFeedListRequest;
import com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet;
import com.tencent.mobileqq.mini.servlet.MiniAppObserver;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

public class GetMineStoryFeedListServlet
  extends MiniAppAbstractServlet
{
  public static final String KEY_GET_STORY_FEED_LIST = "key_get_story_feed_list";
  public static final String KEY_LIST_TYPE = "key_list_tyep";
  public static final String KEY_NEWEST_TIME = "key_newest_time";
  public static final String KEY_UIN = "key_uin";
  private static final String TAG = "GetMineStoryFeedListServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        PROTOCAL.StQWebRsp localStQWebRsp = new PROTOCAL.StQWebRsp();
        localStQWebRsp.mergeFrom(bhjl.b(paramFromServiceMsg.getWupBuffer()));
        localBundle.putInt("key_index", (int)localStQWebRsp.Seq.get());
        if (paramFromServiceMsg.isSuccess())
        {
          localBundle.putParcelable("key_get_story_feed_list", paramFromServiceMsg);
          notifyObserver(paramIntent, 1031, true, localBundle, MiniAppObserver.class);
          super.onReceive(paramIntent, paramFromServiceMsg);
          return;
        }
        QLog.e("GetMineStoryFeedListServlet", 2, "inform GetMineStoryFeedListServlet isSuccess false");
        notifyObserver(paramIntent, 1031, false, localBundle, MiniAppObserver.class);
        continue;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GetMineStoryFeedListServlet", 1, localThrowable + "onReceive error");
        notifyObserver(paramIntent, 1031, false, localBundle, MiniAppObserver.class);
        continue;
      }
      QLog.e("GetMineStoryFeedListServlet", 2, "inform GetMineStoryFeedListServlet resultcode fail.");
      notifyObserver(paramIntent, 1031, false, localBundle, MiniAppObserver.class);
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i = paramIntent.getIntExtra("key_index", -1);
    int j = paramIntent.getIntExtra("key_list_tyep", -1);
    long l1 = paramIntent.getLongExtra("key_uin", 0L);
    long l2 = paramIntent.getLongExtra("key_newest_time", 0L);
    Object localObject1 = new CLIENT.StUinTime();
    ((CLIENT.StUinTime)localObject1).newestTime.set(l2);
    ((CLIENT.StUinTime)localObject1).uin.set(l1);
    Object localObject2 = new GetMineStoryFeedListRequest(j, (CLIENT.StUinTime)localObject1);
    localObject1 = getTraceId();
    localObject2 = ((GetMineStoryFeedListRequest)localObject2).encode(paramIntent, i, (String)localObject1);
    QLog.e("GetMineStoryFeedListServlet", 2, "GetMineStoryFeedListServlet trace id = " + (String)localObject1);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new byte[4];
    }
    paramPacket.setSSOCommand("LightAppSvc.qq_story_client.GetStoryFeedList");
    paramPacket.putSendData(bhjl.a((byte[])localObject1));
    paramPacket.setTimeout(paramIntent.getLongExtra("timeout", 30000L));
    super.onSend(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.servlet.GetMineStoryFeedListServlet
 * JD-Core Version:    0.7.0.1
 */