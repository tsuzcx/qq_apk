package com.tencent.biz.pubaccount.util.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPublicAccountConfigUtil
  extends QRouteApi
{
  public static final int MERGE_KANDIAN_FOLDER_ID = 3;
  public static final int PUBLIC_ACCOUNT_SUBSCRIPT_FOLDER_ID = 1;
  public static final int PUBLIC_ACCOUNT_XIN_KANDIAN_FOLDER_ID = 2;
  public static final int PUBLIC_ACCOUNT_XIN_KANDIAN_NOTIFICATION_ICON = 2130842888;
  public static final int PUBLIC_ACCOUNT_XIN_KANDIAN_NOTIFICATION_NAME = 2131695236;
  public static final String READINJOY_SEARCH_JUMP_URL_DEFAULT = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
  public static final String SSO_COMMOND_NET_CONNECT_INFO = "PubAccountSvc.net_connect_info";
  public static final String TAG = "PublicAccountConfigUtil";
  
  public abstract boolean checkPublicAccountCenterUrlConfigData(String paramString);
  
  public abstract Drawable getDefaultDrawable(Context paramContext, int paramInt);
  
  public abstract boolean getDisableBigDataChannel();
  
  public abstract IPublicAccountConfigUtil.PublicAccountConfigFolder getFolder(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt);
  
  public abstract String getMergerKandianName(QQAppInterface paramQQAppInterface, Context paramContext);
  
  public abstract String getName(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt);
  
  public abstract String getPublicAccountCategoryUrl();
  
  public abstract String getPublicAccountCenterUrlConfigData(QQAppInterface paramQQAppInterface);
  
  public abstract int getPublicAccountCenterUrlConfigVersionCode(QQAppInterface paramQQAppInterface);
  
  public abstract int getPublicAccountQQMailConfigVersionCode(QQAppInterface paramQQAppInterface);
  
  public abstract String getPublicAccountTitle();
  
  public abstract String getReadinjoySearchUrl();
  
  public abstract void getServiceAccountFolderConfigData(QQAppInterface paramQQAppInterface);
  
  public abstract String getServiceAccountFolderIcon();
  
  public abstract boolean getServiceFolderRedDelete();
  
  public abstract String getSubscriptName(QQAppInterface paramQQAppInterface, Context paramContext);
  
  public abstract String getXinKandianName(QQAppInterface paramQQAppInterface, Context paramContext);
  
  public abstract boolean isPreloadTooProcess();
  
  public abstract boolean isServiceFolderRedspots();
  
  public abstract void loadPublicAccountCenterUrlConfig(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract void resetPublicAccountConfig(String paramString);
  
  public abstract void setPreloadToolProcess(boolean paramBoolean);
  
  public abstract void setServiceAccountFolderIcon(String paramString);
  
  public abstract void updatePublicAccountCenterUrlConfigData(QQAppInterface paramQQAppInterface);
  
  public abstract void updatePublicAccountCenterUrlConfigVersionCode(QQAppInterface paramQQAppInterface, int paramInt);
  
  public abstract void updatePublicAccountQQMailConfigData(QQAppInterface paramQQAppInterface, String paramString, int paramInt);
  
  public abstract boolean updateReadinjoyFolderConfig(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract boolean updateSubscriptRecommendConfig(QQAppInterface paramQQAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
 * JD-Core Version:    0.7.0.1
 */