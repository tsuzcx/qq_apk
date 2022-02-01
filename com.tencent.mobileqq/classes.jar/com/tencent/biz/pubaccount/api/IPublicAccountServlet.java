package com.tencent.biz.pubaccount.api;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.Servlet;

@QAPI(process={"all"})
public abstract interface IPublicAccountServlet
  extends QRouteApi
{
  public static final int FollowReq_2019_FUDAI = 24;
  public static final int FollowReq_AIO_BaseChat_inviteForFriend = 22;
  public static final int FollowReq_AIO_EncounterChatBizQQ = 23;
  public static final int FollowReq_BookWebBaseView = 13;
  public static final int FollowReq_EncounterChat = 3;
  public static final int FollowReq_EncounterChat_Promotion = 4;
  public static final int FollowReq_FollowButton_PAAlbum = 21;
  public static final int FollowReq_FollowButton_PACard = 1;
  public static final int FollowReq_GroupSetting = 14;
  public static final int FollowReq_GroupVerifyMessage = 5;
  public static final int FollowReq_JSBridgeDataPlugin_newerguide = 15;
  public static final int FollowReq_Lua = 20;
  public static final int FollowReq_PUBLIC_ACCOUNT_IN_READ_JOY = 27;
  public static final int FollowReq_PUBLIC_ACCOUNT_IN_SHOP_ACCOUNT = 26;
  public static final int FollowReq_PUBLIC_ACCOUNT_LIST = 25;
  public static final int FollowReq_PublicAccountView_Follow = 2;
  public static final int FollowReq_QQReader = 12;
  public static final int FollowReq_QQWallet_PayOrder = 7;
  public static final int FollowReq_QQWallet_StartPay = 6;
  public static final int FollowReq_QQWallet_handleGotoViewTaskCallBackResultInfos = 9;
  public static final int FollowReq_QQWallet_handlePayResult = 8;
  public static final int FollowReq_QQWallet_handleTenpayResult = 10;
  public static final int FollowReq_QRDaShen = 18;
  public static final int FollowReq_ReAddGroupController = 16;
  public static final int FollowReq_ReadInJoyVideoRecomCell = 17;
  public static final int FollowReq_ShoppingRecommend = 11;
  public static final int FollowReq_TextBaseView = 19;
  public static final int FollowReq_Unknown = 0;
  public static final String RESPONES_CODE = "respones_code";
  
  public abstract void configNeedHandler(Intent paramIntent);
  
  public abstract Class<? extends Servlet> getServletClass();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountServlet
 * JD-Core Version:    0.7.0.1
 */