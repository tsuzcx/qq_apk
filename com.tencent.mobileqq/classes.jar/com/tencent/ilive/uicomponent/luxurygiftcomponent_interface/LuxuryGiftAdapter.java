package com.tencent.ilive.uicomponent.luxurygiftcomponent_interface;

import android.content.Context;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnFetchH264GiftInfoListener;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnFetchH264ResListener;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnQueryLGInfoListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public abstract interface LuxuryGiftAdapter
{
  public abstract LottieViewInterface createLottieView(Context paramContext, LuxuryGiftAdapter paramLuxuryGiftAdapter);
  
  public abstract void fetchGiftResByGiftInfo(LuxuryGiftInfo paramLuxuryGiftInfo, OnFetchH264ResListener paramOnFetchH264ResListener);
  
  public abstract void fetchH264GiftInfo(ArrayList<String> paramArrayList, OnFetchH264GiftInfoListener paramOnFetchH264GiftInfoListener);
  
  public abstract long getAccountUin();
  
  public abstract ActivityLifeService getActivityLifeService();
  
  public abstract long getAnchorUin();
  
  public abstract AppGeneralInfoService getAppGeneralInfoService();
  
  public abstract Context getContext();
  
  public abstract DataReportInterface getDataReport();
  
  public abstract JSONObject getGiftEffectJson();
  
  public abstract String getGiftLogoUrl(String paramString, long paramLong);
  
  public abstract HttpInterface getHttp();
  
  public abstract ImageLoaderInterface getImageLoaderInterface();
  
  public abstract LogInterface getLogger();
  
  public abstract LuxuryGiftInfo getLuxuryGiftInfo(int paramInt, long paramLong, boolean paramBoolean);
  
  public abstract String getLuxuryGiftLogoUrl(String paramString, long paramLong);
  
  public abstract JSONObject getWhiteListJson();
  
  public abstract void queryH264GiftInfo(ArrayList<String> paramArrayList);
  
  public abstract void queryH264GiftRes(List<LuxuryGiftInfo> paramList);
  
  public abstract void queryLuxuryGiftInfo(long paramLong, OnQueryLGInfoListener paramOnQueryLGInfoListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter
 * JD-Core Version:    0.7.0.1
 */