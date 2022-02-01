package com.tencent.mobileqq.apollo.api.handler;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IApolloExtensionServlet
  extends QRouteApi
{
  public static final String EXTRA_CALLBACK_INDEX = "index";
  public static final String EXTRA_CMD = "cmd";
  public static final String EXTRA_DATA = "data";
  public static final String EXTRA_IS_FROM_SHOW_JS_REQUEST = "isCMShowJSRequest";
  public static final String EXTRA_MASK = "mask";
  public static final String EXTRA_REQ_DATA = "reqData";
  public static final String EXTRA_SCENE = "scene";
  public static final String EXTRA_TIMEOUT = "timeout";
  public static final String EXTRA_USRDATA = "usrdata";
  
  public abstract Class getImplClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.handler.IApolloExtensionServlet
 * JD-Core Version:    0.7.0.1
 */