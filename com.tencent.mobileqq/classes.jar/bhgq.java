import com.tencent.qqmini.sdk.log.QMLog;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.Map;
import org.json.JSONObject;

class bhgq
  implements BasicMessageChannel.MessageHandler
{
  bhgq(bhgo parambhgo) {}
  
  public void onMessage(Object paramObject, BasicMessageChannel.Reply paramReply)
  {
    Object localObject1 = null;
    Object localObject2;
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if ((paramObject.containsKey("messageType")) && ("__tissue_bridge_ready_".equals((String)paramObject.get("messageType"))))
      {
        bhgo.a(this.a, true);
        QMLog.w("miniapp-start-TISSUE", " tissue initialization done");
        bhbs.a(214, "", bhgo.a(this.a).a());
        bhgo.a(this.a);
      }
      if (paramObject.containsKey("method"))
      {
        localObject2 = paramObject.get("method").toString();
        if (!((String)localObject2).equals("publishHandler")) {
          break label267;
        }
        paramReply = (Map)paramObject.get("data");
        String str = paramReply.get("event").toString();
        localObject2 = (Integer)paramReply.get("pageID");
        paramObject = localObject1;
        if (paramReply.containsKey("dataForEvent")) {
          paramObject = (Map)paramReply.get("dataForEvent");
        }
        paramReply = (BasicMessageChannel.Reply)localObject2;
        if (localObject2 == null)
        {
          paramReply = (BasicMessageChannel.Reply)localObject2;
          if (paramObject != null)
          {
            paramReply = (BasicMessageChannel.Reply)localObject2;
            if (paramObject.containsKey("pageID")) {
              paramReply = (Integer)paramObject.get("pageID");
            }
          }
        }
        localObject1 = "null";
        if (paramObject != null) {
          localObject1 = new JSONObject(paramObject).toString();
        }
        bhgo.a(this.a).a(str, (String)localObject1, paramReply.intValue());
      }
    }
    return;
    label267:
    if (((String)localObject2).equals("onAppRoute"))
    {
      paramObject = (Map)paramObject.get("data");
      localObject2 = paramObject.get("path").toString();
      paramReply = (Integer)paramObject.get("pageID");
      localObject1 = (String)paramObject.get("openType");
      if (!paramObject.containsKey("query")) {
        break label1076;
      }
    }
    label1063:
    label1071:
    label1076:
    for (paramObject = (Map)paramObject.get("query");; paramObject = null)
    {
      paramObject = new bhix((String)localObject2, paramObject);
      bhgo.a(this.a).c((String)localObject1, paramObject.b(), paramReply.intValue());
      return;
      if (((String)localObject2).equals("onAppRouteDone"))
      {
        paramObject = (Map)paramObject.get("data");
        localObject2 = paramObject.get("path").toString();
        paramReply = (Integer)paramObject.get("pageID");
        localObject1 = (String)paramObject.get("openType");
        if (!paramObject.containsKey("query")) {
          break label1071;
        }
      }
      for (paramObject = (Map)paramObject.get("query");; paramObject = null)
      {
        paramObject = new bhix((String)localObject2, paramObject);
        bhgo.a(this.a).d((String)localObject1, paramObject.b(), paramReply.intValue());
        return;
        if ("viewDidAppear".equals(localObject2))
        {
          bhgo.a(this.a).a(bgmd.a(11));
          if ((!paramObject.containsKey("data")) || (!(paramObject.get("data") instanceof Map))) {
            break label1063;
          }
          paramObject = (Map)paramObject.get("data");
          if ((!paramObject.containsKey("pageID")) || (!(paramObject.get("pageID") instanceof Integer))) {
            break label1063;
          }
        }
        for (paramObject = (Integer)paramObject.get("pageID");; paramObject = Integer.valueOf(0))
        {
          QMLog.w("miniapp-start-TISSUE", "flutter page " + paramObject + " shown" + System.currentTimeMillis());
          if (bhgo.a(this.a)) {
            break;
          }
          if (bhgo.b(this.a)) {}
          for (paramObject = "1";; paramObject = "0")
          {
            bhbs.a(216, paramObject, bhgo.a(this.a).a());
            bhgo.b(this.a, true);
            return;
          }
          if ("invokeHandler".equals(localObject2))
          {
            paramReply = (Map)paramObject.get("data");
            paramObject = (String)paramReply.get("event");
            if ("invokeMiniProgramAPI".equals(paramObject))
            {
              int i = ((Integer)paramReply.get("pageID")).intValue();
              bhgo.a(this.a).a("onWebInvokeAppService", (String)paramReply.get("param"), i);
            }
            paramReply = new JSONObject(paramReply).toString();
            bhgo.a(this.a).a(paramObject, paramReply, ((bhfa)bhgo.a(this.a)).a(), 0);
            return;
          }
          if ("timeCostReport".equals(localObject2))
          {
            localObject2 = (Map)paramObject.get("data");
            if (localObject2 == null) {
              break;
            }
            paramObject = (Integer)((Map)localObject2).get("matchTimeCost");
            paramReply = (Integer)((Map)localObject2).get("setDataTimeCost");
            localObject1 = (Integer)((Map)localObject2).get("renderTimeCost");
            localObject2 = (Integer)((Map)localObject2).get("totalTimeCost");
            if (paramObject != null) {
              bhck.a(bhgo.a(this.a).a(), 217, "0", paramObject.intValue());
            }
            if (paramReply != null) {
              bhck.a(bhgo.a(this.a).a(), 218, "0", paramReply.intValue());
            }
            if (localObject1 != null) {
              bhck.a(bhgo.a(this.a).a(), 219, "0", ((Integer)localObject1).intValue());
            }
            if (localObject2 == null) {
              break;
            }
            bhck.a(bhgo.a(this.a).a(), 220, "0", ((Integer)localObject2).intValue());
            return;
          }
          if (!"getAbsolutePath".equals(localObject2)) {
            break;
          }
          paramObject = (String)((Map)paramObject.get("data")).get("filePath");
          paramReply.reply(bgnt.a().a(paramObject));
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgq
 * JD-Core Version:    0.7.0.1
 */