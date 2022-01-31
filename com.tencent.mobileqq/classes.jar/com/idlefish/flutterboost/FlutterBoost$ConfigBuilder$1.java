package com.idlefish.flutterboost;

import android.app.Application;
import android.content.Context;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import io.flutter.embedding.android.FlutterView.RenderMode;
import java.util.Map;

class FlutterBoost$ConfigBuilder$1
  extends Platform
{
  FlutterBoost$ConfigBuilder$1(FlutterBoost.ConfigBuilder paramConfigBuilder) {}
  
  public Application getApplication()
  {
    return FlutterBoost.ConfigBuilder.access$300(this.this$0);
  }
  
  public String initialRoute()
  {
    return FlutterBoost.ConfigBuilder.access$500(this.this$0);
  }
  
  public boolean isDebug()
  {
    return FlutterBoost.ConfigBuilder.access$400(this.this$0);
  }
  
  public void openContainer(Context paramContext, String paramString, Map<String, Object> paramMap1, int paramInt, Map<String, Object> paramMap2)
  {
    FlutterBoost.ConfigBuilder.access$600(this.this$0).openContainer(paramContext, paramString, paramMap1, paramInt, paramMap2);
  }
  
  public FlutterView.RenderMode renderMode()
  {
    return FlutterBoost.ConfigBuilder.access$800(this.this$0);
  }
  
  public int whenEngineStart()
  {
    return FlutterBoost.ConfigBuilder.access$700(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.idlefish.flutterboost.FlutterBoost.ConfigBuilder.1
 * JD-Core Version:    0.7.0.1
 */