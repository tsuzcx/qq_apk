package com.tencent.biz.pubaccount.util.api;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IPublicAccountConfigUtil
  extends QRouteApi
{
  public static final int MERGE_KANDIAN_FOLDER_ID = 3;
  public static final int PUBLIC_ACCOUNT_SUBSCRIPT_FOLDER_ID = 1;
  public static final int PUBLIC_ACCOUNT_XIN_KANDIAN_FOLDER_ID = 2;
  public static final String READINJOY_SEARCH_JUMP_URL_DEFAULT = "https://sou.qq.com/kandian.html?_bid=2958&_wv=3&keyword=$KEYWORD$";
  public static final String SSO_COMMOND_NET_CONNECT_INFO = "PubAccountSvc.net_connect_info";
  public static final String TAG = "PublicAccountConfigUtil";
  
  public abstract boolean checkNeedLongMessageChannel(String paramString);
  
  public abstract boolean checkPublicAccountCenterUrlConfigData(String paramString);
  
  public abstract ArrayList<String> getBigDataChannelWhiteList();
  
  public abstract Drawable getDefaultDrawable(Context paramContext, int paramInt);
  
  public abstract boolean getDisableBigDataChannel();
  
  public abstract IPublicAccountConfigUtil.PublicAccountConfigFolder getFolder(AppInterface paramAppInterface, Context paramContext, int paramInt);
  
  public abstract int getImageCollectionPreload();
  
  public abstract int getImageCollectionPreloadCover();
  
  public abstract int getImageCollectionPreloadImage();
  
  public abstract String getMergerKandianName(AppInterface paramAppInterface, Context paramContext);
  
  public abstract String getName(AppInterface paramAppInterface, Context paramContext, int paramInt);
  
  public abstract String getPublicAccountCategoryUrl();
  
  public abstract String getPublicAccountCenterUrlConfigData(AppInterface paramAppInterface);
  
  public abstract int getPublicAccountCenterUrlConfigVersionCode(AppInterface paramAppInterface);
  
  public abstract int getPublicAccountQQMailConfigVersionCode(AppInterface paramAppInterface);
  
  public abstract String getPublicAccountTitle();
  
  public abstract long getReadInJoyADBackgroundShowTime();
  
  public abstract int getReadInJoyIpConnectReportSwitch();
  
  public abstract String getReadInJoyIpConnectReportTail();
  
  public abstract String getReadInJoyPreloadToolConfig();
  
  public abstract String getReadInJoyReleaseWebServiceConfig();
  
  public abstract String getReadInJoyflingLToRHost();
  
  public abstract String getReadinjoySearchUrl();
  
  public abstract void getServiceAccountFolderConfigData(AppInterface paramAppInterface);
  
  public abstract int getServiceAccountFolderConfigVersionCode(AppInterface paramAppInterface);
  
  public abstract String getServiceAccountFolderIcon();
  
  public abstract String getServiceAccountFolderName();
  
  public abstract String getServiceAccountTitle();
  
  public abstract boolean getServiceFolderRedDelete();
  
  public abstract String getSubscriptName(AppInterface paramAppInterface, Context paramContext);
  
  public abstract String getXinKandianName(AppInterface paramAppInterface, Context paramContext);
  
  public abstract void initPublicAccountConfigFolder(IPublicAccountConfigUtil.PublicAccountConfigFolder paramPublicAccountConfigFolder, AppInterface paramAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2);
  
  public abstract boolean isClearAllPublicAccountFolderRedNumber();
  
  public abstract boolean isDisableBigDataChannel();
  
  public abstract boolean isNeedPABottomBar();
  
  public abstract boolean isPreloadTooProcess();
  
  public abstract boolean isPreloadToolProcess();
  
  public abstract boolean isReadInJoyFeedsImagePreload();
  
  public abstract boolean isReadInJoyFeedsPreload();
  
  public abstract boolean isReadInJoyFeedsPreload2G();
  
  public abstract boolean isReadInJoyFeedsPreload3G();
  
  public abstract boolean isReadInJoyFeedsPreload4G();
  
  public abstract boolean isReadInJoyFeedsPreloadWifi();
  
  public abstract boolean isReadInJoyIpConnect();
  
  public abstract boolean isReadInJoyLoadImg();
  
  public abstract boolean isServiceAccountFolderDelete();
  
  public abstract boolean isServiceFolderRedSpots();
  
  public abstract boolean isServiceFolderRedspots();
  
  public abstract boolean isSwitchToCertifiedAccount();
  
  public abstract void loadPublicAccountCenterUrlConfig(AppInterface paramAppInterface, String paramString);
  
  public abstract int readInJoyADGuideCardShowTime();
  
  public abstract boolean readInJoyIpConnect();
  
  public abstract int readInJoyIpConnectReportSwitch();
  
  public abstract String readInJoyIpConnectReportTail();
  
  public abstract String readInJoyPreloadToolConfig();
  
  public abstract String readInJoyReleaseWebServiceConfig();
  
  public abstract void resetPublicAccountConfig(String paramString);
  
  public abstract void setBigDataChannelWhiteList(ArrayList<String> paramArrayList);
  
  public abstract void setDisableBigDataChannel(boolean paramBoolean);
  
  public abstract void setImageCollectionPreload(int paramInt);
  
  public abstract void setImageCollectionPreloadCover(int paramInt);
  
  public abstract void setImageCollectionPreloadImage(int paramInt);
  
  public abstract void setNeedPABottomBar(boolean paramBoolean);
  
  public abstract void setPreloadToolProcess(boolean paramBoolean);
  
  public abstract void setReadInJoyADBackgroundShowTime(long paramLong);
  
  public abstract void setReadInJoyFeedsImagePreload(boolean paramBoolean);
  
  public abstract void setReadInJoyFeedsPreload(boolean paramBoolean);
  
  public abstract void setReadInJoyFeedsPreload2G(boolean paramBoolean);
  
  public abstract void setReadInJoyFeedsPreload3G(boolean paramBoolean);
  
  public abstract void setReadInJoyFeedsPreload4G(boolean paramBoolean);
  
  public abstract void setReadInJoyFeedsPreloadWifi(boolean paramBoolean);
  
  public abstract void setReadInJoyIpConnect(boolean paramBoolean);
  
  public abstract void setReadInJoyIpConnectReportSwitch(int paramInt);
  
  public abstract void setReadInJoyIpConnectReportTail(String paramString);
  
  public abstract void setReadInJoyLoadImg(boolean paramBoolean);
  
  public abstract void setReadInJoyPreloadToolConfig(String paramString);
  
  public abstract void setReadInJoyReleaseWebServiceConfig(String paramString);
  
  public abstract void setReadInJoyflingLToRHost(String paramString);
  
  public abstract void setServiceAccountFolderIcon(String paramString);
  
  public abstract void setServiceAccountFolderName(String paramString);
  
  public abstract void setServiceFolderDelete(boolean paramBoolean);
  
  public abstract void setServiceFolderRedCleanAfterEnter(boolean paramBoolean);
  
  public abstract void setServiceFolderRedDelete(boolean paramBoolean);
  
  public abstract void setServiceFolderRedSpots(boolean paramBoolean);
  
  public abstract void updatePublicAccountCenterUrlConfigData(AppInterface paramAppInterface);
  
  public abstract void updatePublicAccountCenterUrlConfigVersionCode(AppInterface paramAppInterface, int paramInt);
  
  public abstract void updatePublicAccountQQMailConfigData(AppInterface paramAppInterface, String paramString, int paramInt);
  
  public abstract boolean updateReadinjoyFolderConfig(AppInterface paramAppInterface, String paramString);
  
  public abstract void updateServiceAccountFolderConfigData(AppInterface paramAppInterface);
  
  public abstract boolean updateSubscriptRecommendConfig(AppInterface paramAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil
 * JD-Core Version:    0.7.0.1
 */