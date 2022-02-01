package com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action;

import java.util.HashMap;
import java.util.Map;

public class WSJumpActionFactory
{
  private static final Map<String, WSJumpActionFactory.OnCreateJumpActionListener> a = new HashMap();
  
  static
  {
    a.put("operationh5", new WSJumpActionFactory.1());
    a.put("waterfall", new WSJumpActionFactory.2());
    a.put("openPlayer", new WSJumpActionFactory.3());
    a.put("videoCollection", new WSJumpActionFactory.4());
    a.put("videoDrama", new WSJumpActionFactory.5());
    a.put("dramaGround", new WSJumpActionFactory.6());
  }
  
  public static AbsWSJumpAction a(String paramString)
  {
    paramString = (WSJumpActionFactory.OnCreateJumpActionListener)a.get(paramString);
    if (paramString != null) {
      return paramString.a();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.wsqqscheme.action.WSJumpActionFactory
 * JD-Core Version:    0.7.0.1
 */