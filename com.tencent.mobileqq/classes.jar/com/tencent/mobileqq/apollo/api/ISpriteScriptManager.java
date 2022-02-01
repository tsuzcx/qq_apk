package com.tencent.mobileqq.apollo.api;

import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.ISpriteUIHandler;
import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

@Service(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/api/ISpriteScriptManager;", "Lmqq/app/api/IRuntimeService;", "getSpriteBridge", "Lcom/tencent/mobileqq/apollo/script/ISpriteBridge;", "getSpriteContext", "Lcom/tencent/mobileqq/apollo/script/ISpriteContext;", "getTaskHandler", "Lcom/tencent/mobileqq/apollo/script/ISpriteTaskHandler;", "getUIHandler", "Lcom/tencent/mobileqq/apollo/script/ISpriteUIHandler;", "BusinessId", "cmshow_api_release"}, k=1, mv={1, 1, 16})
public abstract interface ISpriteScriptManager
  extends IRuntimeService
{
  public static final ISpriteScriptManager.BusinessId BusinessId = ISpriteScriptManager.BusinessId.a;
  public static final int SCRIPT_BID_BASIC = 0;
  public static final int SCRIPT_BID_PET = 7;
  public static final int SCRIPT_BID_RANDOM = 8;
  public static final int SCRIPT_BID_SLAVE = 5;
  public static final int SCRIPT_BID_WHITEFACE = 1;
  
  @NotNull
  public abstract ISpriteBridge getSpriteBridge();
  
  @NotNull
  public abstract ISpriteContext getSpriteContext();
  
  @NotNull
  public abstract ISpriteTaskHandler getTaskHandler();
  
  @NotNull
  public abstract ISpriteUIHandler getUIHandler();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.ISpriteScriptManager
 * JD-Core Version:    0.7.0.1
 */