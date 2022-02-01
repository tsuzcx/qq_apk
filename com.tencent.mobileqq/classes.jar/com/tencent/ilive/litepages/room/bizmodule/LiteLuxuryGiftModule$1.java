package com.tencent.ilive.litepages.room.bizmodule;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.lottie.LottieAnimationViewInterface;
import com.tencent.falco.base.libapi.lottie.LottieCompositionInterface;
import com.tencent.falco.base.libapi.lottie.LottieServiceInterface;
import com.tencent.falco.base.libapi.lottie.LottieViewInterface;
import com.tencent.falco.utils.StringUtil;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnFetchH264GiftInfoListener;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnFetchH264ResListener;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnQueryLGInfoListener;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface;
import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo;
import com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo;
import com.tencent.livesdk.liveengine.LiveEngine;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class LiteLuxuryGiftModule$1
  implements LuxuryGiftAdapter
{
  LiteLuxuryGiftModule$1(LiteLuxuryGiftModule paramLiteLuxuryGiftModule) {}
  
  public LottieAnimationViewInterface createLottieAnimationView(Context paramContext)
  {
    return LiteLuxuryGiftModule.access$1400(this.this$0).a(paramContext);
  }
  
  public void fetchGiftResByGiftInfo(LuxuryGiftInfo paramLuxuryGiftInfo, OnFetchH264ResListener paramOnFetchH264ResListener)
  {
    paramLuxuryGiftInfo = LiteLuxuryGiftModule.access$1100(this.this$0, paramLuxuryGiftInfo);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLuxuryGiftInfo);
    if (this.this$0.getGiftServiceInterface() == null) {
      return;
    }
    this.this$0.getGiftServiceInterface().queryH264GiftRes(localArrayList, new LiteLuxuryGiftModule.1.2(this, paramOnFetchH264ResListener));
  }
  
  public void fetchH264GiftInfo(ArrayList<String> paramArrayList, OnFetchH264GiftInfoListener paramOnFetchH264GiftInfoListener)
  {
    if (this.this$0.getGiftServiceInterface() == null) {
      return;
    }
    this.this$0.getGiftServiceInterface().queryH264GiftInfo(paramArrayList, new LiteLuxuryGiftModule.1.3(this, paramOnFetchH264GiftInfoListener));
  }
  
  public long getAccountUin()
  {
    return LiteLuxuryGiftModule.access$900(this.this$0).getLoginInfo().uid;
  }
  
  public ActivityLifeService getActivityLifeService()
  {
    return LiteLuxuryGiftModule.access$200(this.this$0);
  }
  
  public long getAnchorUin()
  {
    if (LiteLuxuryGiftModule.access$600(this.this$0) != null) {
      return LiteLuxuryGiftModule.access$700(this.this$0).getAnchorInfo().uid;
    }
    return 0L;
  }
  
  public AppGeneralInfoService getAppGeneralInfoService()
  {
    return LiteLuxuryGiftModule.access$300(this.this$0);
  }
  
  public Context getContext()
  {
    return LiteLuxuryGiftModule.access$1000(this.this$0);
  }
  
  public DataReportInterface getDataReport()
  {
    return LiteLuxuryGiftModule.access$000(this.this$0);
  }
  
  public JSONObject getGiftEffectJson()
  {
    return null;
  }
  
  public String getGiftLogoUrl(String paramString, long paramLong)
  {
    if (TextUtils.isEmpty(LiteLuxuryGiftModule.access$1300(this.this$0)))
    {
      localObject = null;
      if (StringUtil.isEmpty(null)) {
        localObject = "https://now8.gtimg.com/huayang/resource/%s?timastamp=%d";
      }
      LiteLuxuryGiftModule.access$1302(this.this$0, (String)localObject);
    }
    paramString = String.format(LiteLuxuryGiftModule.access$1300(this.this$0), new Object[] { paramString, Long.valueOf(paramLong) });
    Object localObject = LiteLuxuryGiftModule.access$800(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGiftLogoUrl urlString = \n");
    localStringBuilder.append(paramString);
    ((LogInterface)localObject).d("LiteLuxuryGiftModule", localStringBuilder.toString(), new Object[0]);
    return paramString;
  }
  
  public HttpInterface getHttp()
  {
    return LiteLuxuryGiftModule.access$100(this.this$0);
  }
  
  public ImageLoaderInterface getImageLoaderInterface()
  {
    return LiteLuxuryGiftModule.access$400(this.this$0);
  }
  
  public LogInterface getLogger()
  {
    return (LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class);
  }
  
  public LottieCompositionInterface getLottieComposition()
  {
    return LiteLuxuryGiftModule.access$1400(this.this$0).a();
  }
  
  public LuxuryGiftInfo getLuxuryGiftInfo(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (this.this$0.getGiftServiceInterface() == null) {
      return null;
    }
    GiftInfo localGiftInfo = this.this$0.getGiftServiceInterface().getGiftInfo((int)paramLong);
    if (localGiftInfo == null) {
      return null;
    }
    return LiteLuxuryGiftModule.access$500(this.this$0, localGiftInfo);
  }
  
  public String getLuxuryGiftLogoUrl(String paramString, long paramLong)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(null)) {
      localObject = "https://now8.gtimg.com/huayang/resource/%s?timastamp=%d";
    }
    paramString = String.format((String)localObject, new Object[] { paramString, Long.valueOf(paramLong) });
    localObject = LiteLuxuryGiftModule.access$800(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getGiftLogoUrl urlString = \n");
    localStringBuilder.append(paramString);
    ((LogInterface)localObject).d("LiteLuxuryGiftModule", localStringBuilder.toString(), new Object[0]);
    return paramString;
  }
  
  public LottieViewInterface getLuxuryGiftLottieView(Context paramContext)
  {
    return LiteLuxuryGiftModule.access$1400(this.this$0).a(paramContext);
  }
  
  public JSONObject getWhiteListJson()
  {
    return null;
  }
  
  public void queryH264GiftInfo(ArrayList<String> paramArrayList)
  {
    if (this.this$0.getGiftServiceInterface() == null) {
      return;
    }
    this.this$0.getGiftServiceInterface().queryH264GiftInfo(paramArrayList, null);
  }
  
  public void queryH264GiftRes(List<LuxuryGiftInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LuxuryGiftInfo localLuxuryGiftInfo = (LuxuryGiftInfo)paramList.next();
      localArrayList.add(LiteLuxuryGiftModule.access$1100(this.this$0, localLuxuryGiftInfo));
    }
    if (this.this$0.getGiftServiceInterface() == null) {
      return;
    }
    this.this$0.getGiftServiceInterface().queryH264GiftRes(localArrayList, null);
  }
  
  public void queryLuxuryGiftInfo(long paramLong, OnQueryLGInfoListener paramOnQueryLGInfoListener)
  {
    if (this.this$0.getGiftServiceInterface() == null) {
      return;
    }
    this.this$0.getGiftServiceInterface().queryGiftInfo((int)paramLong, new LiteLuxuryGiftModule.1.1(this, paramOnQueryLGInfoListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule.1
 * JD-Core Version:    0.7.0.1
 */