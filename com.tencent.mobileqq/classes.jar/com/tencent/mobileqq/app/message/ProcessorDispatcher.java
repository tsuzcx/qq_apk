package com.tencent.mobileqq.app.message;

import android.util.Pair;
import java.util.HashMap;
import java.util.Map;

public class ProcessorDispatcher
  implements ProcessorDispatcherInterface
{
  private static Map<String, Pair<String, Integer>> a;
  private static Object b = new Object();
  
  public static String a(int paramInt)
  {
    if (paramInt == 1) {
      return "troop_processor";
    }
    if (paramInt == 1026) {
      return "hctopic_processor";
    }
    if (paramInt == 3000) {
      return "disc_processor";
    }
    return "c2c_processor";
  }
  
  public static String a(String paramString)
  {
    return (String)((Pair)a.get(paramString)).first;
  }
  
  public static Map<String, Pair<String, Integer>> a()
  {
    if (a == null) {
      synchronized (b)
      {
        if (a == null) {
          b();
        }
      }
    }
    return a;
  }
  
  public static int b(String paramString)
  {
    return ((Integer)((Pair)a.get(paramString)).second).intValue();
  }
  
  private static void b()
  {
    a = new HashMap();
    Map localMap = a;
    Integer localInteger = Integer.valueOf(5002);
    localMap.put("MessageSvc.GetMsgV4", Pair.create("accost_processor", localInteger));
    a.put("RegPrxySvc.GetMsgV2", Pair.create("accost_processor", localInteger));
    a.put("AccostSvc.SvrMsg", Pair.create("accost_processor", Integer.valueOf(5001)));
    a.put("ProfileService.Pb.ReqSystemMsgNew", Pair.create("system_processor", Integer.valueOf(6002)));
    a.put("ProfileService.Pb.ReqSystemMsgNew.Friend", Pair.create("system_processor", Integer.valueOf(6001)));
    a.put("ProfileService.Pb.ReqSystemMsgNew.Group", Pair.create("system_processor", Integer.valueOf(6003)));
    a.put("ProfileService.Pb.ReqSystemMsgRead", Pair.create("system_processor", Integer.valueOf(6006)));
    a.put("ProfileService.Pb.ReqSystemMsgAction", Pair.create("system_processor", Integer.valueOf(6007)));
    a.put("OidbSvc.0x5cf_0", Pair.create("system_processor", Integer.valueOf(6008)));
    a.put("OidbSvc.0x5cf_1", Pair.create("system_processor", Integer.valueOf(6009)));
    a.put("MessageSvc.PbGetOneDayRoamMsg", Pair.create("c2c_processor", Integer.valueOf(1003)));
    a.put("MessageSvc.PbGetRoamMsg", Pair.create("c2c_processor", Integer.valueOf(2001)));
    a.put("PbMessageSvc.PbSearchRoamMsgInCloud", Pair.create("c2c_processor", Integer.valueOf(2005)));
    a.put("TransService.ReqOffFilePack", Pair.create("offlinefile_processor", Integer.valueOf(7001)));
    a.put("OnlinePush.ReqPush", Pair.create("businessbase_processor", Integer.valueOf(3001)));
    a.put("MessageSvc.PbBindUinGetMsg", Pair.create("sub_account_processor", Integer.valueOf(4001)));
    a.put("PbMessageSvc.PbBindUinMsgReadedConfirm", Pair.create("sub_account_processor", Integer.valueOf(4002)));
    a.put("OidbSvc.0x5d0_1", Pair.create("sub_account_processor", Integer.valueOf(4003)));
    a.put("MessageSvc.PbMultiMsgSend", Pair.create("uncommon_msg_processor", Integer.valueOf(8001)));
    a.put("PbMessageSvc.PbMsgWithDraw", Pair.create("uncommon_msg_processor", Integer.valueOf(8002)));
    a.put("PbMessageSvc.PbDelOneRoamMsg", Pair.create("uncommon_msg_processor", Integer.valueOf(8003)));
    a.put("SecSvcBlessingHelper.blessing_helper", Pair.create("uncommon_msg_processor", Integer.valueOf(8004)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.ProcessorDispatcher
 * JD-Core Version:    0.7.0.1
 */