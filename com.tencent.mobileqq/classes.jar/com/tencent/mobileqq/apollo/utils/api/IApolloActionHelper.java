package com.tencent.mobileqq.apollo.utils.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IApolloActionHelper
  extends QRouteApi
{
  public static final int ACTION_TYPE_FROM_3D_SAYHI_DEFAULT = 14;
  public static final int ACTION_TYPE_FROM_4SHOW_DEFAULT = 2;
  public static final int ACTION_TYPE_FROM_4SHOW_ROLE_RELATED = 3;
  public static final int ACTION_TYPE_FROM_AIO_ADD_ACTION_DIR = 13;
  public static final int ACTION_TYPE_FROM_AIO_PANEL = 1;
  public static final int ACTION_TYPE_FROM_AI_DEFAULT = 8;
  public static final int ACTION_TYPE_FROM_AI_EMOTION = 9;
  public static final int ACTION_TYPE_FROM_CARD_PLAYHIDE = 7;
  public static final int ACTION_TYPE_FROM_CMSHOW_PANEL_FRAME = 15;
  public static final int ACTION_TYPE_FROM_DRAWER_PLAY_HIDE = 11;
  public static final int ACTION_TYPE_FROM_INTERACT_ROLE_RELATED = 10;
  public static final int ACTION_TYPE_FROM_SAYHI_DEFAULT = 4;
  public static final int ACTION_TYPE_FROM_SAYHI_ROLE_RELATED = 5;
  public static final int ACTION_TYPE_FROM_SHOW_STAND = 12;
  public static final int ACTION_TYPE_FROM_WEATHER = 6;
  
  public abstract String[] getActionResourcePath(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4);
  
  public abstract int getApolloFuncSwitch(String paramString, AppRuntime paramAppRuntime);
  
  public abstract String getApolloResource(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.IApolloActionHelper
 * JD-Core Version:    0.7.0.1
 */