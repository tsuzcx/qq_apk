package com.tencent.biz.pubaccount.AccountDetail.activity.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPublicAccountDetailActivity
  extends QRouteApi
{
  public static final String ACCOUNT_TYPE = "account_type";
  public static final int ACCOUNT_TYPE_EQQ = 2;
  public static final int ACCOUNT_TYPE_PUBLIC_ACCOUNT = 1;
  public static final String FROMADCARD = "from_card";
  public static final String FROM_JS = "from_js";
  public static final String FROM_WHERE = "source";
  public static final String REPORT_BUSINESS_TVALUE = "report_business_tvalue";
  public static final String REPORT_SRC_PARAM_NAME = "report_src_param_name";
  public static final String REPORT_SRC_PARAM_TYPE = "report_src_param_type";
  public static final String ROUTE_NAME = "/pubaccount/detail";
  public static final int SOURCE_AIO = 5;
  public static final int SOURCE_KD_DAILY = 121;
  public static final int SOURCE_NO = -1;
  public static final int SOURCE_QR = 1;
  public static final int SOURCE_RECENTCALL = 113;
  public static final int SOURCE_RECOMMENT = 3;
  public static final int SOURCE_SCHEME = 117;
  public static final int SOURCE_SEARCH = 4;
  public static final int SOURCE_SEARCH_RECOMMENT = 118;
  public static final int SOURCE_SHARE = 2;
  public static final int SOURCE_STRUCT_MSG_SHOP = 115;
  public static final int SOURCE_WEISHI = 119;
  public static final int TROOP_SYSTEM_FIN = 112;
  public static final String WEATHE_OUTSIDE_FOLLOW_STATE = "weather_outside_follow_state";
  public static final String WEATHE_SHARE_URL = "weather_share_url";
  
  public abstract String getArticleId(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.IPublicAccountDetailActivity
 * JD-Core Version:    0.7.0.1
 */