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
import com.tencent.falco.utils.StringUtil;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LottieServiceInterface;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LottieViewInterface;
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
  
  public LottieViewInterface createLottieView(Context paramContext, LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    return LiteLuxuryGiftModule.access$1500(this.this$0).getLottieView(paramContext, paramLuxuryGiftAdapter);
  }
  
  public void fetchGiftResByGiftInfo(LuxuryGiftInfo paramLuxuryGiftInfo, OnFetchH264ResListener paramOnFetchH264ResListener)
  {
    paramLuxuryGiftInfo = LiteLuxuryGiftModule.access$1200(this.this$0, paramLuxuryGiftInfo);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramLuxuryGiftInfo);
    LiteLuxuryGiftModule.access$500(this.this$0).queryH264GiftRes(localArrayList, new LiteLuxuryGiftModule.1.2(this, paramOnFetchH264ResListener));
  }
  
  public void fetchH264GiftInfo(ArrayList<String> paramArrayList, OnFetchH264GiftInfoListener paramOnFetchH264GiftInfoListener)
  {
    LiteLuxuryGiftModule.access$500(this.this$0).queryH264GiftInfo(paramArrayList, new LiteLuxuryGiftModule.1.3(this, paramOnFetchH264GiftInfoListener));
  }
  
  public long getAccountUin()
  {
    return LiteLuxuryGiftModule.access$1000(this.this$0).getLoginInfo().uid;
  }
  
  public ActivityLifeService getActivityLifeService()
  {
    return LiteLuxuryGiftModule.access$200(this.this$0);
  }
  
  public long getAnchorUin()
  {
    if (LiteLuxuryGiftModule.access$700(this.this$0) != null) {
      return LiteLuxuryGiftModule.access$800(this.this$0).getAnchorInfo().uid;
    }
    return 0L;
  }
  
  public AppGeneralInfoService getAppGeneralInfoService()
  {
    return LiteLuxuryGiftModule.access$300(this.this$0);
  }
  
  public Context getContext()
  {
    return LiteLuxuryGiftModule.access$1100(this.this$0);
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
    String str;
    if (TextUtils.isEmpty(LiteLuxuryGiftModule.access$1400(this.this$0)))
    {
      str = null;
      if (StringUtil.isEmpty(null)) {
        break label98;
      }
    }
    for (;;)
    {
      LiteLuxuryGiftModule.access$1402(this.this$0, str);
      paramString = String.format(LiteLuxuryGiftModule.access$1400(this.this$0), new Object[] { paramString, Long.valueOf(paramLong) });
      LiteLuxuryGiftModule.access$900(this.this$0).d("LiteLuxuryGiftModule", "getGiftLogoUrl urlString = \n" + paramString, new Object[0]);
      return paramString;
      label98:
      str = "https://now8.gtimg.com/huayang/resource/%s?timastamp=%d";
    }
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
  
  public LuxuryGiftInfo getLuxuryGiftInfo(int paramInt, long paramLong, boolean paramBoolean)
  {
    GiftInfo localGiftInfo = LiteLuxuryGiftModule.access$500(this.this$0).getGiftInfo((int)paramLong);
    if (localGiftInfo == null) {
      return null;
    }
    return LiteLuxuryGiftModule.access$600(this.this$0, localGiftInfo);
  }
  
  public String getLuxuryGiftLogoUrl(String paramString, long paramLong)
  {
    String str = null;
    if (!TextUtils.isEmpty(null)) {}
    for (;;)
    {
      paramString = String.format(str, new Object[] { paramString, Long.valueOf(paramLong) });
      LiteLuxuryGiftModule.access$900(this.this$0).d("LiteLuxuryGiftModule", "getGiftLogoUrl urlString = \n" + paramString, new Object[0]);
      return paramString;
      str = "https://now8.gtimg.com/huayang/resource/%s?timastamp=%d";
    }
  }
  
  public JSONObject getWhiteListJson()
  {
    return null;
  }
  
  public void queryH264GiftInfo(ArrayList<String> paramArrayList)
  {
    LiteLuxuryGiftModule.access$500(this.this$0).queryH264GiftInfo(paramArrayList, null);
  }
  
  public void queryH264GiftRes(List<LuxuryGiftInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      LuxuryGiftInfo localLuxuryGiftInfo = (LuxuryGiftInfo)paramList.next();
      localArrayList.add(LiteLuxuryGiftModule.access$1200(this.this$0, localLuxuryGiftInfo));
    }
    LiteLuxuryGiftModule.access$500(this.this$0).queryH264GiftRes(localArrayList, null);
  }
  
  public void queryLuxuryGiftInfo(long paramLong, OnQueryLGInfoListener paramOnQueryLGInfoListener)
  {
    LiteLuxuryGiftModule.access$500(this.this$0).queryGiftInfo((int)paramLong, new LiteLuxuryGiftModule.1.1(this, paramOnQueryLGInfoListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule.1
 * JD-Core Version:    0.7.0.1
 */