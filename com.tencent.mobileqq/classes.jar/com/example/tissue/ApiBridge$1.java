package com.example.tissue;

import android.os.Looper;
import android.util.Log;
import com.example.tissue.utils.ThreadUtil;
import com.tencent.tissue.miniapp.hdasync.HdAsync;
import com.tencent.tissue.v8rt.engine.Logger;
import com.tencent.tissue.v8rt.engine.SpeedUtil;
import io.flutter.plugin.common.BasicMessageChannel.MessageHandler;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import java.util.HashMap;
import java.util.List;

class ApiBridge$1
  implements BasicMessageChannel.MessageHandler<Object>
{
  ApiBridge$1(ApiBridge paramApiBridge) {}
  
  public void onMessage(Object paramObject, BasicMessageChannel.Reply<Object> paramReply)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onMessage: ");
    ((StringBuilder)localObject1).append(paramObject);
    Log.w("ApiBridge", ((StringBuilder)localObject1).toString());
    try
    {
      paramObject = (HashMap)paramObject;
      localObject1 = (String)paramObject.get("messageType");
      Object localObject2;
      if ("__tissue_load_wxs_".equals(localObject1))
      {
        localObject1 = (String)paramObject.get("wxsPath");
        paramObject = (String)paramObject.get("module");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("wxsPath: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" module:");
        ((StringBuilder)localObject2).append(paramObject);
        Log.w("ApiBridge", ((StringBuilder)localObject2).toString());
        HdAsync.with(this.this$0).then(new ApiBridge.1.2(this, ThreadUtil.getLooper("v8Thread"), paramObject, (String)localObject1)).then(new ApiBridge.1.1(this, Looper.getMainLooper(), paramReply)).call();
        return;
      }
      if ("__tissue_call_wxs_method_".equals(localObject1))
      {
        localObject1 = (String)paramObject.get("method");
        localObject2 = (List)paramObject.get("arguments");
        paramObject = (String)paramObject.get("module");
        HdAsync.with(this.this$0).then(new ApiBridge.1.4(this, ThreadUtil.getLooper("v8Thread"), (List)localObject2, paramObject, (String)localObject1)).then(new ApiBridge.1.3(this, Looper.getMainLooper(), paramReply)).call();
        return;
      }
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
      return;
    }
    if ("__tissue_bridge_ready_".equals(localObject1))
    {
      Logger.i("ApiBridge", "__tissue_bridge_ready_");
      this.this$0.testJs2Dart();
      return;
    }
    if ("testjs2dart_message_recieved".equals(localObject1))
    {
      SpeedUtil.DEFAULT.event("testjs2dart finish");
      SpeedUtil.DEFAULT.report(new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.ApiBridge.1
 * JD-Core Version:    0.7.0.1
 */