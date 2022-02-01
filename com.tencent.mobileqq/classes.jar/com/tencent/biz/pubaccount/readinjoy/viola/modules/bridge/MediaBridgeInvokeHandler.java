package com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge;

import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/MediaBridgeInvokeHandler;", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;", "(Lcom/tencent/biz/pubaccount/readinjoy/viola/modules/BridgeModule;)V", "nameSpace", "", "register", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class MediaBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final MediaBridgeInvokeHandler.Companion a = new MediaBridgeInvokeHandler.Companion(null);
  
  public MediaBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  @NotNull
  public String a()
  {
    return "media";
  }
  
  public void a()
  {
    a("showPicture", (Function2)new MediaBridgeInvokeHandler.register.1(this));
    a("saveImage", (Function2)new MediaBridgeInvokeHandler.register.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.MediaBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */