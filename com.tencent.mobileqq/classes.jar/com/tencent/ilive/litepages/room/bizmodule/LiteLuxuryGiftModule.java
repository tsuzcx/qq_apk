package com.tencent.ilive.litepages.room.bizmodule;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.lifecycle.Observer;
import com.tencent.falco.base.libapi.activitylife.ActivityLifeService;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginServiceInterface;
import com.tencent.falco.base.libapi.lottie.LottieServiceInterface;
import com.tencent.ilive.base.component.ComponentFactory;
import com.tencent.ilive.base.component.ComponentFactory.ComponentsBuilder;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.litepages.room.webmodule.event.ClearLuxuryQueueEvent;
import com.tencent.ilive.litepages.room.webmodule.event.LiteShowLuxuryAnimationEvent;
import com.tencent.ilive.litepages.room.webmodule.event.PreloadLuxuryAnimationEvent;
import com.tencent.ilive.litepages.room.webmodule.event.StopLuxuryAnimationPlayEvent;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftComponent;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo.FlashEffect;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo.GiftEffect;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo.SpecialNumber;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.ReceiveGiftMessageListener;
import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo;
import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo.FlashEffect;
import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo.GiftEffect;
import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo.SpecialNumber;
import com.tencent.ilivesdk.giftservice_interface.model.GiftMessage;
import com.tencent.livesdk.roomengine.RoomEngine;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;

public class LiteLuxuryGiftModule
  extends RoomBizModule
{
  private static final String TAG = "LiteLuxuryGiftModule";
  Observer clearLuxuryQueueEvent = new LiteLuxuryGiftModule.6(this);
  private ActivityLifeService mActivityLifeService;
  private AppGeneralInfoService mAppGeneralInfoService;
  private DataReportInterface mDataReportInterface;
  private GiftServiceInterface mGiftServiceInterface;
  private HttpInterface mHttpInterface;
  private String mIconPrefix = "";
  private ImageLoaderInterface mImageLoaderInterface;
  private LogInterface mLogInterface;
  private LoginServiceInterface mLoginServiceInterface;
  private LottieServiceInterface mLottieServiceInterface;
  private LuxuryGiftComponent mLuxuryGiftComponent;
  Observer preloadLuxuryAnimationEvent = new LiteLuxuryGiftModule.3(this);
  GiftServiceInterface.ReceiveGiftMessageListener receiveGiftMessageListener = new LiteLuxuryGiftModule.7(this);
  Observer showLuxuryAnimationEvent = new LiteLuxuryGiftModule.2(this);
  Observer stopLuxuryAnimationPlayEvent = new LiteLuxuryGiftModule.5(this);
  
  private ImageLoaderInterface getImageLoaderInterface()
  {
    if (this.mImageLoaderInterface == null) {
      this.mImageLoaderInterface = ((ImageLoaderInterface)getRoomEngine().getService(ImageLoaderInterface.class));
    }
    return this.mImageLoaderInterface;
  }
  
  private void initLuxuryGiftComponent(View paramView)
  {
    this.mLuxuryGiftComponent = ((LuxuryGiftComponent)getComponentFactory().getComponent(LuxuryGiftComponent.class).setRootView(paramView).build());
    this.mLuxuryGiftComponent.init(new LiteLuxuryGiftModule.1(this));
  }
  
  private void initServiceInterface()
  {
    this.mDataReportInterface = ((DataReportInterface)getRoomEngine().getService(DataReportInterface.class));
    this.mHttpInterface = ((HttpInterface)getRoomEngine().getService(HttpInterface.class));
    this.mLogInterface = ((LogInterface)getRoomEngine().getService(LogInterface.class));
    this.mActivityLifeService = ((ActivityLifeService)getRoomEngine().getService(ActivityLifeService.class));
    this.mAppGeneralInfoService = ((AppGeneralInfoService)getRoomEngine().getService(AppGeneralInfoService.class));
    this.mLoginServiceInterface = ((LoginServiceInterface)getRoomEngine().getService(LoginServiceInterface.class));
    this.mLottieServiceInterface = ((LottieServiceInterface)getRoomEngine().getService(LottieServiceInterface.class));
  }
  
  private void preloadLuxuryGift(PreloadLuxuryAnimationEvent paramPreloadLuxuryAnimationEvent)
  {
    if (getGiftServiceInterface() == null) {
      return;
    }
    getGiftServiceInterface().queryH264GiftInfo(paramPreloadLuxuryAnimationEvent.effectIds, new LiteLuxuryGiftModule.4(this));
  }
  
  private void startListenLuxuryGiftMessage()
  {
    getEvent().observe(LiteShowLuxuryAnimationEvent.class, this.showLuxuryAnimationEvent);
    getEvent().observe(ClearLuxuryQueueEvent.class, this.clearLuxuryQueueEvent);
    getEvent().observe(PreloadLuxuryAnimationEvent.class, this.preloadLuxuryAnimationEvent);
    getEvent().observe(StopLuxuryAnimationPlayEvent.class, this.stopLuxuryAnimationPlayEvent);
    if (getGiftServiceInterface() != null) {
      getGiftServiceInterface().addReceiveGiftMessageListener(this.receiveGiftMessageListener);
    }
  }
  
  private void stopListenLuxuryGiftMessage()
  {
    getEvent().removeObserver(LiteShowLuxuryAnimationEvent.class, this.showLuxuryAnimationEvent);
    getEvent().removeObserver(ClearLuxuryQueueEvent.class, this.clearLuxuryQueueEvent);
    getEvent().removeObserver(PreloadLuxuryAnimationEvent.class, this.preloadLuxuryAnimationEvent);
    getEvent().removeObserver(StopLuxuryAnimationPlayEvent.class, this.stopLuxuryAnimationPlayEvent);
    if (getGiftServiceInterface() != null) {
      getGiftServiceInterface().delReceiveGiftMessageListener(this.receiveGiftMessageListener);
    }
  }
  
  private LuxuryGiftData transAnimationEventToLuxuryData(LiteShowLuxuryAnimationEvent paramLiteShowLuxuryAnimationEvent)
  {
    LuxuryGiftData localLuxuryGiftData = new LuxuryGiftData();
    localLuxuryGiftData.giftId = ((int)paramLiteShowLuxuryAnimationEvent.giftid);
    localLuxuryGiftData.consumerUin = paramLiteShowLuxuryAnimationEvent.uin;
    localLuxuryGiftData.consumerName = paramLiteShowLuxuryAnimationEvent.uName;
    localLuxuryGiftData.effectId = paramLiteShowLuxuryAnimationEvent.effectId;
    localLuxuryGiftData.effectNum = paramLiteShowLuxuryAnimationEvent.effectNum;
    localLuxuryGiftData.effectType = paramLiteShowLuxuryAnimationEvent.effectType;
    localLuxuryGiftData.effectWord = paramLiteShowLuxuryAnimationEvent.comboEffectWording;
    localLuxuryGiftData.giftName = paramLiteShowLuxuryAnimationEvent.giftName;
    localLuxuryGiftData.giftnum = paramLiteShowLuxuryAnimationEvent.giftnum;
    localLuxuryGiftData.giftType = paramLiteShowLuxuryAnimationEvent.giftType;
    localLuxuryGiftData.giftTimestamp = ((int)paramLiteShowLuxuryAnimationEvent.giftTimestamp);
    localLuxuryGiftData.headKey = paramLiteShowLuxuryAnimationEvent.headKey;
    localLuxuryGiftData.headTimestamp = paramLiteShowLuxuryAnimationEvent.headTimestamp;
    localLuxuryGiftData.headUrl = paramLiteShowLuxuryAnimationEvent.headUrl;
    localLuxuryGiftData.playUin = paramLiteShowLuxuryAnimationEvent.playUin;
    localLuxuryGiftData.roomid = paramLiteShowLuxuryAnimationEvent.roomid;
    localLuxuryGiftData.subroomid = paramLiteShowLuxuryAnimationEvent.subroomid;
    localLuxuryGiftData.giftIcon = paramLiteShowLuxuryAnimationEvent.giftIcon;
    localLuxuryGiftData.mBusinessUid = paramLiteShowLuxuryAnimationEvent.mBusinessUid;
    localLuxuryGiftData.mMsgExtInfo = paramLiteShowLuxuryAnimationEvent.mMsgExtInfo;
    return localLuxuryGiftData;
  }
  
  private LuxuryGiftInfo transEffectInfoToLuxuryGiftInfo(GiftEffectResourceInfo paramGiftEffectResourceInfo)
  {
    if (paramGiftEffectResourceInfo == null) {
      return null;
    }
    LuxuryGiftInfo localLuxuryGiftInfo = new LuxuryGiftInfo();
    localLuxuryGiftInfo.effectId = paramGiftEffectResourceInfo.mGiftEffectId;
    localLuxuryGiftInfo.giftRootPath = paramGiftEffectResourceInfo.mGiftRootPath;
    localLuxuryGiftInfo.isResUpdate = paramGiftEffectResourceInfo.mIsResUpdate;
    localLuxuryGiftInfo.lottieConfigFilePath = paramGiftEffectResourceInfo.mLottieConfigFilePath;
    localLuxuryGiftInfo.lottiePlayConfigFilePath = paramGiftEffectResourceInfo.mLottiePlayConfigFilePath;
    localLuxuryGiftInfo.mediaFilePath = paramGiftEffectResourceInfo.mMediaFilePath;
    localLuxuryGiftInfo.resLevel = paramGiftEffectResourceInfo.mResLevel;
    localLuxuryGiftInfo.resourceMd5 = paramGiftEffectResourceInfo.mResourceMD5;
    localLuxuryGiftInfo.resourceUrl = paramGiftEffectResourceInfo.mResourceUrl;
    localLuxuryGiftInfo.vibrate = paramGiftEffectResourceInfo.mVibrate;
    localLuxuryGiftInfo.vibrateRange = paramGiftEffectResourceInfo.mVibrateRange;
    return localLuxuryGiftInfo;
  }
  
  private LuxuryGiftInfo transGiftInfoToLuxuryInfo(GiftInfo paramGiftInfo)
  {
    LuxuryGiftInfo localLuxuryGiftInfo = new LuxuryGiftInfo();
    localLuxuryGiftInfo.giftType = paramGiftInfo.mGiftType;
    localLuxuryGiftInfo.giftId = paramGiftInfo.mGiftId;
    localLuxuryGiftInfo.giftName = paramGiftInfo.mGiftName;
    localLuxuryGiftInfo.activeIcon = paramGiftInfo.mActiveIcon;
    localLuxuryGiftInfo.apngUrl = paramGiftInfo.mApngUrl;
    localLuxuryGiftInfo.beginTs = paramGiftInfo.mBeginTs;
    localLuxuryGiftInfo.belong = paramGiftInfo.mBelong;
    localLuxuryGiftInfo.bigIcon = paramGiftInfo.mBigIcon;
    localLuxuryGiftInfo.comment = paramGiftInfo.mComment;
    localLuxuryGiftInfo.defaultCount = paramGiftInfo.mDefaultCount;
    localLuxuryGiftInfo.displayConfig = paramGiftInfo.mDisplayConfig;
    localLuxuryGiftInfo.displayGiftName = paramGiftInfo.mDisplayGiftName;
    localLuxuryGiftInfo.displayIcon = paramGiftInfo.mDisplayIcon;
    localLuxuryGiftInfo.displayType = paramGiftInfo.mDisplayType;
    localLuxuryGiftInfo.displayWord = paramGiftInfo.mDisplayWord;
    localLuxuryGiftInfo.duration = 0;
    localLuxuryGiftInfo.effectId = paramGiftInfo.mEffectId;
    localLuxuryGiftInfo.effectType = paramGiftInfo.mEffectType;
    localLuxuryGiftInfo.endTs = paramGiftInfo.mEndTs;
    localLuxuryGiftInfo.giftComment = paramGiftInfo.mGiftComment;
    localLuxuryGiftInfo.giftScene = paramGiftInfo.mGiftScene;
    localLuxuryGiftInfo.isLocked = paramGiftInfo.mIsLocked;
    localLuxuryGiftInfo.middleIcon = paramGiftInfo.mMiddleIcon;
    localLuxuryGiftInfo.price = paramGiftInfo.mPrice;
    localLuxuryGiftInfo.priority = paramGiftInfo.mPriority;
    localLuxuryGiftInfo.resourcePack = paramGiftInfo.mResourcePack;
    localLuxuryGiftInfo.smallIcon = paramGiftInfo.mSmallIcon;
    Object localObject1 = paramGiftInfo.mSpecialNumList.iterator();
    Object localObject2;
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (GiftInfo.SpecialNumber)((Iterator)localObject1).next();
      localLuxuryGiftInfo.getClass();
      localObject3 = new LuxuryGiftInfo.SpecialNumber(localLuxuryGiftInfo);
      ((LuxuryGiftInfo.SpecialNumber)localObject3).specialName = ((GiftInfo.SpecialNumber)localObject2).mSpecialName;
      ((LuxuryGiftInfo.SpecialNumber)localObject3).specialNumber = ((GiftInfo.SpecialNumber)localObject2).mSpecialNumber;
      localLuxuryGiftInfo.specialNumList.add(localObject3);
    }
    localLuxuryGiftInfo.timestamp = paramGiftInfo.mTimestamp;
    localLuxuryGiftInfo.visible = paramGiftInfo.mVisible;
    paramGiftInfo = paramGiftInfo.mGiftEffectList.iterator();
    while (paramGiftInfo.hasNext())
    {
      localObject1 = (GiftInfo.GiftEffect)paramGiftInfo.next();
      localLuxuryGiftInfo.getClass();
      localObject2 = new LuxuryGiftInfo.GiftEffect(localLuxuryGiftInfo);
      localLuxuryGiftInfo.getClass();
      localObject3 = new LuxuryGiftInfo.FlashEffect(localLuxuryGiftInfo);
      ((LuxuryGiftInfo.FlashEffect)localObject3).types = ((GiftInfo.GiftEffect)localObject1).mFlashEffect.mTypes;
      ((LuxuryGiftInfo.FlashEffect)localObject3).url = ((GiftInfo.GiftEffect)localObject1).mFlashEffect.mUrl;
      ((LuxuryGiftInfo.GiftEffect)localObject2).flashEffect = ((LuxuryGiftInfo.FlashEffect)localObject3);
      localLuxuryGiftInfo.getClass();
      localObject3 = new LuxuryGiftInfo.FlashEffect(localLuxuryGiftInfo);
      ((LuxuryGiftInfo.FlashEffect)localObject3).types = ((GiftInfo.GiftEffect)localObject1).mFullScreenEffect.mTypes;
      ((LuxuryGiftInfo.FlashEffect)localObject3).url = ((GiftInfo.GiftEffect)localObject1).mFullScreenEffect.mUrl;
      ((LuxuryGiftInfo.GiftEffect)localObject2).fullScreenEffect = ((LuxuryGiftInfo.FlashEffect)localObject3);
      ((LuxuryGiftInfo.GiftEffect)localObject2).giftEffect = ((GiftInfo.GiftEffect)localObject1).mGiftEffect;
      ((LuxuryGiftInfo.GiftEffect)localObject2).maxNum = ((GiftInfo.GiftEffect)localObject1).mMaxNum;
      ((LuxuryGiftInfo.GiftEffect)localObject2).minNum = ((GiftInfo.GiftEffect)localObject1).mMinNum;
      localLuxuryGiftInfo.giftEffectList.add(localObject2);
    }
    return localLuxuryGiftInfo;
  }
  
  private LuxuryGiftData transGiftMessageToLuxuryData(GiftMessage paramGiftMessage)
  {
    LuxuryGiftData localLuxuryGiftData = new LuxuryGiftData();
    localLuxuryGiftData.consumerUin = paramGiftMessage.mConsumerId;
    localLuxuryGiftData.giftType = paramGiftMessage.mGiftType;
    localLuxuryGiftData.headKey = new String(paramGiftMessage.mConsumerHeadKey, StandardCharsets.UTF_8);
    localLuxuryGiftData.headUrl = paramGiftMessage.mConsumerLogoUrl;
    localLuxuryGiftData.headTimestamp = paramGiftMessage.mLogoTimestamp;
    localLuxuryGiftData.consumerName = paramGiftMessage.mConsumerNickName;
    localLuxuryGiftData.playUin = paramGiftMessage.mPlayUid;
    localLuxuryGiftData.playName = paramGiftMessage.mPlayNickname;
    localLuxuryGiftData.roomid = paramGiftMessage.mRoomId;
    localLuxuryGiftData.subroomid = paramGiftMessage.mSubRoomId;
    localLuxuryGiftData.giftnum = paramGiftMessage.mGiftNum;
    localLuxuryGiftData.giftId = paramGiftMessage.mGiftId;
    localLuxuryGiftData.giftIcon = paramGiftMessage.mGiftIconUrl;
    localLuxuryGiftData.mBusinessUid = paramGiftMessage.mBusinessUid;
    localLuxuryGiftData.giftName = paramGiftMessage.mGiftName;
    localLuxuryGiftData.mMsgExtInfo = paramGiftMessage.mMsgExtInfo;
    return localLuxuryGiftData;
  }
  
  private GiftEffectResourceInfo transLuxuryGiftInfoToEffectInfo(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    GiftEffectResourceInfo localGiftEffectResourceInfo = new GiftEffectResourceInfo();
    localGiftEffectResourceInfo.mGiftEffectId = paramLuxuryGiftInfo.effectId;
    localGiftEffectResourceInfo.mGiftRootPath = paramLuxuryGiftInfo.giftRootPath;
    localGiftEffectResourceInfo.mIsResUpdate = paramLuxuryGiftInfo.isResUpdate;
    localGiftEffectResourceInfo.mLottieConfigFilePath = paramLuxuryGiftInfo.lottieConfigFilePath;
    localGiftEffectResourceInfo.mLottiePlayConfigFilePath = paramLuxuryGiftInfo.lottiePlayConfigFilePath;
    localGiftEffectResourceInfo.mMediaFilePath = paramLuxuryGiftInfo.mediaFilePath;
    localGiftEffectResourceInfo.mResLevel = paramLuxuryGiftInfo.resLevel;
    localGiftEffectResourceInfo.mResourceMD5 = paramLuxuryGiftInfo.resourceMd5;
    localGiftEffectResourceInfo.mResourceUrl = paramLuxuryGiftInfo.resourceUrl;
    localGiftEffectResourceInfo.mVibrate = paramLuxuryGiftInfo.vibrate;
    localGiftEffectResourceInfo.mVibrateRange = paramLuxuryGiftInfo.vibrateRange;
    return localGiftEffectResourceInfo;
  }
  
  public GiftServiceInterface getGiftServiceInterface()
  {
    if (this.mGiftServiceInterface == null) {
      this.mGiftServiceInterface = ((GiftServiceInterface)getRoomEngine().getService(GiftServiceInterface.class));
    }
    return this.mGiftServiceInterface;
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mLuxuryGiftComponent.hideLuxuryAnimationView();
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    startListenLuxuryGiftMessage();
  }
  
  protected void onInflateComponent()
  {
    initServiceInterface();
    ViewStub localViewStub = (ViewStub)getRootView().findViewById(2131437773);
    localViewStub.setLayoutResource(2131625157);
    initLuxuryGiftComponent((FrameLayout)localViewStub.inflate());
  }
  
  public void onSwitchScreen(boolean paramBoolean)
  {
    super.onSwitchScreen(paramBoolean);
    if (paramBoolean)
    {
      stopListenLuxuryGiftMessage();
      return;
    }
    startListenLuxuryGiftMessage();
  }
  
  public void onVisibleToUser(boolean paramBoolean)
  {
    super.onVisibleToUser(paramBoolean);
    if (!paramBoolean) {
      this.mLuxuryGiftComponent.hideLuxuryAnimationView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.bizmodule.LiteLuxuryGiftModule
 * JD-Core Version:    0.7.0.1
 */