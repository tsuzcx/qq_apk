package com.tencent.mobileqq.apollo.web.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import org.json.JSONObject;

@QAPI(process={"tool"})
@QRouteFactory(singleton=false)
public abstract interface IApolloJsPlugin
  extends QRouteApi
{
  public static final String BUSINESS_NAME = "apollo";
  
  public abstract JSONObject getThunderJson(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.api.IApolloJsPlugin
 * JD-Core Version:    0.7.0.1
 */