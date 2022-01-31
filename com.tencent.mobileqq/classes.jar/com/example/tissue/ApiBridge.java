package com.example.tissue;

import android.content.Context;
import com.example.tissue.utils.ThreadUtil;
import com.tencent.tissue.miniapp.IJsService;
import com.tencent.tissue.miniapp.WxsService;
import com.tencent.tissue.miniapp.utils.Path;
import com.tencent.tissue.v8rt.engine.AssetUtil;
import com.tencent.tissue.v8rt.engine.JsValueUtil;
import com.tencent.tissue.v8rt.engine.Logger;
import com.tencent.tissue.v8rt.engine.SpeedUtil;
import com.tencent.tissue.v8rt.engine.V8JsContext;
import com.tencent.tissue.v8rt.engine.V8JsRuntime;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.FlutterStandardFieldJSValueWrapper;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.view.FlutterView;
import java.util.HashMap;
import java.util.Map;

public class ApiBridge
{
  private static final String JS_CHANNEL = "com.tencent.tissue/basic_channel";
  private static final String TAG = "ApiBridge3";
  private static final ApiBridge ourInstance = new ApiBridge();
  private BasicMessageChannel<Object> basicMessageChannel;
  ApiBridge.BridgeReadyListener bridgeReadyListener;
  private Context context;
  private String currentWxsPath;
  private FlutterView flutterView;
  private IJsService wxsService;
  
  public static ApiBridge getInstance()
  {
    return ourInstance;
  }
  
  private String getJs2DartAsset()
  {
    return AssetUtil.loadAssetTextAsString(this.context, "v8test/test_js2dart.js");
  }
  
  private String getJs2DartBigJson()
  {
    String str = AssetUtil.loadFileAsString("/sdcard/test/415k.json");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(str);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  private void initMessageChannel()
  {
    this.basicMessageChannel.setMessageHandler(new ApiBridge.1(this));
  }
  
  public static String normalizePath(String paramString)
  {
    return Path.getPath("", new String[] { paramString }).normalize().toString();
  }
  
  public void init(Context paramContext, FlutterView paramFlutterView)
  {
    this.context = paramContext;
    ThreadUtil.getLooper("v8Thread");
    this.wxsService = new WxsService();
    ((WxsService)this.wxsService).init(paramContext);
    this.flutterView = paramFlutterView;
    this.basicMessageChannel = new BasicMessageChannel(this.flutterView, "com.tencent.tissue/basic_channel", StandardMessageCodec.INSTANCE);
    initMessageChannel();
  }
  
  public void sendMsg(String paramString, Object... paramVarArgs) {}
  
  public void setBridgeReadyListener(ApiBridge.BridgeReadyListener paramBridgeReadyListener)
  {
    this.bridgeReadyListener = paramBridgeReadyListener;
  }
  
  public void testJs2Dart()
  {
    this.wxsService.loadScript("js2darttest", "");
    SpeedUtil.DEFAULT.event("testJs2Dart start");
    long l = this.wxsService.executeScriptWithReturnPtr("js2darttest", getJs2DartAsset());
    Object localObject1 = SpeedUtil.DEFAULT;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("testJs2Dart got addr ");
    ((StringBuilder)localObject2).append(l);
    ((SpeedUtil)localObject1).event(((StringBuilder)localObject2).toString());
    if (l > 0L)
    {
      localObject1 = new HashMap();
      localObject2 = new FlutterStandardFieldJSValueWrapper(l);
      ((Map)localObject1).put("key", "testjs2dart");
      ((Map)localObject1).put("value", localObject2);
      this.basicMessageChannel.send(localObject1);
      SpeedUtil.DEFAULT.event("testJs2Dart message send");
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("testJs2Dart send message ");
      ((StringBuilder)localObject1).append(l);
      Logger.i("ApiBridge3", ((StringBuilder)localObject1).toString());
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("testJs2Dart failed ptr is ");
    ((StringBuilder)localObject1).append(l);
    Logger.e("ApiBridge3", ((StringBuilder)localObject1).toString());
  }
  
  public void testJs2Map()
  {
    this.wxsService.loadScript("js2map", "");
    SpeedUtil.DEFAULT.event("testJs2Map start");
    long l = this.wxsService.executeScriptWithReturnPtr("js2map", getJs2DartBigJson());
    Object localObject1 = SpeedUtil.DEFAULT;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("testJs2Map got addr ");
    ((StringBuilder)localObject2).append(l);
    ((SpeedUtil)localObject1).event(((StringBuilder)localObject2).toString());
    if (l > 0L)
    {
      localObject1 = this.wxsService.getRuntime("js2map");
      if (localObject1 != null)
      {
        SpeedUtil.DEFAULT.event("testJs2Map convertPtrJsonString start");
        localObject2 = ((V8JsRuntime)localObject1).getDefaultContext().convertPtrJsonString(l);
        SpeedUtil.DEFAULT.event("testJs2Map convertPtrJsonString end");
        if (localObject2 != null)
        {
          SpeedUtil.DEFAULT.event("testJs2Map convertJsValueString start");
          localObject1 = new HashMap();
          localObject2 = JsValueUtil.convertJsValueString((String)localObject2);
          SpeedUtil.DEFAULT.event("testJs2Map convertJsValueString end");
          ((Map)localObject1).put("key", "testjs2dart");
          ((Map)localObject1).put("value", localObject2);
          this.basicMessageChannel.send(localObject1);
          SpeedUtil.DEFAULT.event("testJs2Map message send");
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("testJs2Map send message ");
          ((StringBuilder)localObject1).append(l);
          Logger.i("ApiBridge3", ((StringBuilder)localObject1).toString());
          return;
        }
        Logger.e("ApiBridge3", "testJs2Map failed json is null");
        return;
      }
      Logger.e("ApiBridge3", "testJs2Map failed no jsruntime");
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("testJs2Map failed ptr is ");
    ((StringBuilder)localObject1).append(l);
    Logger.e("ApiBridge3", ((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.ApiBridge
 * JD-Core Version:    0.7.0.1
 */