import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.Map;
import org.json.JSONObject;

class bdvu
  implements BasicMessageChannel.MessageHandler
{
  bdvu(bdvs parambdvs) {}
  
  public void onMessage(Object paramObject, BasicMessageChannel.Reply paramReply)
  {
    Object localObject2;
    Object localObject1;
    if ((paramObject instanceof Map))
    {
      paramObject = (Map)paramObject;
      if (bdnw.b()) {
        bdnw.a("miniapp-start-TISSUE-basic_channel", new JSONObject(paramObject).toString());
      }
      if ((paramObject.containsKey("messageType")) && ("__tissue_bridge_ready_".equals((String)paramObject.get("messageType"))))
      {
        bdvs.a(this.a, true);
        bdnw.c("miniapp-start-TISSUE", " tissue initialization done");
        bdsc.a(214, "", bdvs.a(this.a).a());
        bdvs.a(this.a);
      }
      if (paramObject.containsKey("method"))
      {
        paramReply = paramObject.get("method").toString();
        if (!paramReply.equals("publishHandler")) {
          break label277;
        }
        paramReply = (Map)paramObject.get("data");
        localObject2 = paramReply.get("event").toString();
        localObject1 = (Integer)paramReply.get("pageID");
        paramObject = null;
        if (paramReply.containsKey("dataForEvent")) {
          paramObject = (Map)paramReply.get("dataForEvent");
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
        bdvs.a(this.a).a((String)localObject2, (String)localObject1, paramReply.intValue());
      }
    }
    return;
    label277:
    if (paramReply.equals("onAppRoute"))
    {
      paramReply = (Map)paramObject.get("data");
      paramObject = paramReply.get("path").toString();
      paramReply = (Integer)paramReply.get("pageID");
      bdvs.a(this.a).c("appLaunch", paramObject, paramReply.intValue());
      return;
    }
    if (paramReply.equals("onAppRouteDone"))
    {
      paramReply = (Map)paramObject.get("data");
      paramObject = paramReply.get("path").toString();
      paramReply = (Integer)paramReply.get("pageID");
      bdvs.a(this.a).d("appLaunch", paramObject, paramReply.intValue());
      return;
    }
    if ("viewDidAppear".equals(paramReply))
    {
      bdvs.a(this.a).a(bdfl.a(11));
      if ((!paramObject.containsKey("data")) || (!(paramObject.get("data") instanceof Map))) {
        break label800;
      }
      paramObject = (Map)paramObject.get("data");
      if ((!paramObject.containsKey("pageID")) || (!(paramObject.get("pageID") instanceof Integer))) {
        break label800;
      }
    }
    label800:
    for (paramObject = (Integer)paramObject.get("pageID");; paramObject = Integer.valueOf(0))
    {
      bdnw.c("miniapp-start-TISSUE", "flutter page " + paramObject + " shown" + System.currentTimeMillis());
      if (bdvs.a(this.a)) {
        break;
      }
      if (bdvs.b(this.a)) {}
      for (paramObject = "1";; paramObject = "0")
      {
        bdsc.a(216, paramObject, bdvs.a(this.a).a());
        bdvs.b(this.a, true);
        return;
      }
      if (!"timeCostReport".equals(paramReply)) {
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
        bdsu.a(bdvs.a(this.a).a(), 217, "0", paramObject.intValue());
      }
      if (paramReply != null) {
        bdsu.a(bdvs.a(this.a).a(), 218, "0", paramReply.intValue());
      }
      if (localObject1 != null) {
        bdsu.a(bdvs.a(this.a).a(), 219, "0", ((Integer)localObject1).intValue());
      }
      if (localObject2 == null) {
        break;
      }
      bdsu.a(bdvs.a(this.a).a(), 220, "0", ((Integer)localObject2).intValue());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdvu
 * JD-Core Version:    0.7.0.1
 */