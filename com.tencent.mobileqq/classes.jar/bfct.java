import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.Map;
import org.json.JSONObject;

class bfct
  implements BasicMessageChannel.MessageHandler
{
  bfct(bfcr parambfcr) {}
  
  public void onMessage(Object paramObject, BasicMessageChannel.Reply paramReply)
  {
    paramReply = null;
    Object localObject1;
    Object localObject2;
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (betc.b()) {
        betc.a("miniapp-start-TISSUE-basic_channel", new JSONObject(paramObject).toString());
      }
      if ((paramObject.containsKey("messageType")) && ("__tissue_bridge_ready_".equals((String)paramObject.get("messageType"))))
      {
        bfcr.a(this.a, true);
        betc.c("miniapp-start-TISSUE", " tissue initialization done");
        beyq.a(214, "", bfcr.a(this.a).a());
        bfcr.a(this.a);
      }
      if (paramObject.containsKey("method"))
      {
        localObject1 = paramObject.get("method").toString();
        if (!((String)localObject1).equals("publishHandler")) {
          break label294;
        }
        Map localMap = (Map)paramObject.get("data");
        localObject2 = localMap.get("event").toString();
        localObject1 = (Integer)localMap.get("pageID");
        paramObject = paramReply;
        if (localMap.containsKey("dataForEvent")) {
          paramObject = (Map)localMap.get("dataForEvent");
        }
        paramReply = (BasicMessageChannel.Reply)localObject1;
        if (localObject1 == null)
        {
          paramReply = (BasicMessageChannel.Reply)localObject1;
          if (paramObject != null)
          {
            paramReply = (BasicMessageChannel.Reply)localObject1;
            if (paramObject.containsKey("pageID")) {
              paramReply = (Integer)paramObject.get("pageID");
            }
          }
        }
        localObject1 = "null";
        if (paramObject != null) {
          localObject1 = new JSONObject(paramObject).toString();
        }
        bfcr.a(this.a).a((String)localObject2, (String)localObject1, paramReply.intValue());
      }
    }
    return;
    label294:
    if (((String)localObject1).equals("onAppRoute"))
    {
      paramObject = (Map)paramObject.get("data");
      localObject2 = paramObject.get("path").toString();
      paramReply = (Integer)paramObject.get("pageID");
      localObject1 = (String)paramObject.get("openType");
      if (!paramObject.containsKey("query")) {
        break label1065;
      }
    }
    label1052:
    label1060:
    label1065:
    for (paramObject = (Map)paramObject.get("query");; paramObject = null)
    {
      paramObject = new bfeq((String)localObject2, paramObject);
      bfcr.a(this.a).c((String)localObject1, paramObject.b(), paramReply.intValue());
      return;
      if (((String)localObject1).equals("onAppRouteDone"))
      {
        paramObject = (Map)paramObject.get("data");
        localObject2 = paramObject.get("path").toString();
        paramReply = (Integer)paramObject.get("pageID");
        localObject1 = (String)paramObject.get("openType");
        if (!paramObject.containsKey("query")) {
          break label1060;
        }
      }
      for (paramObject = (Map)paramObject.get("query");; paramObject = null)
      {
        paramObject = new bfeq((String)localObject2, paramObject);
        bfcr.a(this.a).d((String)localObject1, paramObject.b(), paramReply.intValue());
        return;
        if ("viewDidAppear".equals(localObject1))
        {
          bfcr.a(this.a).a(bekc.a(11));
          if ((!paramObject.containsKey("data")) || (!(paramObject.get("data") instanceof Map))) {
            break label1052;
          }
          paramObject = (Map)paramObject.get("data");
          if ((!paramObject.containsKey("pageID")) || (!(paramObject.get("pageID") instanceof Integer))) {
            break label1052;
          }
        }
        for (paramObject = (Integer)paramObject.get("pageID");; paramObject = Integer.valueOf(0))
        {
          betc.c("miniapp-start-TISSUE", "flutter page " + paramObject + " shown" + System.currentTimeMillis());
          if (bfcr.a(this.a)) {
            break;
          }
          if (bfcr.b(this.a)) {}
          for (paramObject = "1";; paramObject = "0")
          {
            beyq.a(216, paramObject, bfcr.a(this.a).a());
            bfcr.b(this.a, true);
            return;
          }
          if ("invokeHandler".equals(localObject1))
          {
            paramReply = (Map)paramObject.get("data");
            paramObject = (String)paramReply.get("event");
            if ("invokeMiniProgramAPI".equals(paramObject))
            {
              int i = ((Integer)paramReply.get("pageID")).intValue();
              bfcr.a(this.a).a("onWebInvokeAppService", (String)paramReply.get("param"), i);
            }
            paramReply = new JSONObject(paramReply).toString();
            bfcr.a(this.a).a(paramObject, paramReply, ((bfbk)bfcr.a(this.a)).a(), 0);
            return;
          }
          if (!"timeCostReport".equals(localObject1)) {
            break;
          }
          localObject2 = (Map)paramObject.get("data");
          if (localObject2 == null) {
            break;
          }
          paramObject = (Integer)((Map)localObject2).get("matchTimeCost");
          paramReply = (Integer)((Map)localObject2).get("setDataTimeCost");
          localObject1 = (Integer)((Map)localObject2).get("renderTimeCost");
          localObject2 = (Integer)((Map)localObject2).get("totalTimeCost");
          if (paramObject != null) {
            bezi.a(bfcr.a(this.a).a(), 217, "0", paramObject.intValue());
          }
          if (paramReply != null) {
            bezi.a(bfcr.a(this.a).a(), 218, "0", paramReply.intValue());
          }
          if (localObject1 != null) {
            bezi.a(bfcr.a(this.a).a(), 219, "0", ((Integer)localObject1).intValue());
          }
          if (localObject2 == null) {
            break;
          }
          bezi.a(bfcr.a(this.a).a(), 220, "0", ((Integer)localObject2).intValue());
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfct
 * JD-Core Version:    0.7.0.1
 */