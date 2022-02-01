package com.tencent.ilive.components.luxurygift;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.falco.base.libapi.imageloader.DisplayImageOptions;
import com.tencent.falco.base.libapi.imageloader.DisplayImageOptions.Builder;
import com.tencent.falco.base.libapi.imageloader.FadeInBitmapDisplayer;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.SPUtil;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.WebGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.H264GiftView;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.IGiftAnimation;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.IH264PlayL;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnPresentLuxuryGiftOverData;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.showview.LottieGiftInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiteLuxuryGiftController
  implements ThreadCenter.HandlerKeyable, IH264PlayL
{
  public static final int H264_GIFT = 2;
  public static final int H5_GIFT = 1;
  public static final String KEY_GIFT_EFFECTS_SHOW = "KEY_GIFT_EFFECTS_SHOW";
  public static final int NO_VIBRATE = 0;
  private static final String TAG = "LiteLuxuryGiftController";
  public static final int VIBRATE_RANGE_ALL = 1;
  public static final int VIBRATE_SYNCHRONIZE_INTERVAL = 100000;
  private final int COMBO_LUXURY_GIFT = 101;
  DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder().showImageForEmptyUri(2130840593).showImageOnFail(2130840593).cacheInMemory(true).cacheOnDisk(true).considerExifParams(false).bitmapConfig(Bitmap.Config.RGB_565).displayer(new FadeInBitmapDisplayer(300)).build();
  private boolean isPrepareState = false;
  private LiteLuxuryGiftComponentImpl mComponentImpl;
  private Context mContext;
  private LuxuryGiftInfo mCurrentGiftInfo;
  private String mCurrentVibrateFile;
  private WebGiftInfo mCurrentWebGiftInfo;
  private ImageView mGiftImageAnimator;
  private int mGiftType = 1;
  private List<LuxuryGiftInfo> mH264GiftInfoList = new ArrayList();
  private H264GiftView mH264GiftView;
  private boolean mIsCanUpdateing = true;
  private boolean mIsSupportH264 = true;
  private LuxuryGiftAdapter mLuxuryGiftAdapter;
  private LuxuryGiftData mLuxuryGiftData;
  private boolean mPlayFirstTime;
  private ViewGroup mRootView;
  private long mUpdateTimes = 1L;
  
  public LiteLuxuryGiftController(LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    this.mLuxuryGiftAdapter = paramLuxuryGiftAdapter;
  }
  
  private View createH264ShowView()
  {
    this.mH264GiftView = new H264GiftView(this.mContext, this.mLuxuryGiftAdapter);
    this.mH264GiftView.setPlayListener(this);
    return this.mH264GiftView;
  }
  
  private void fetchGiftResByGiftInfo(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    this.mLuxuryGiftAdapter.fetchGiftResByGiftInfo(paramLuxuryGiftInfo, new LiteLuxuryGiftController.2(this));
  }
  
  private LuxuryGiftInfo getH264GiftInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.mH264GiftInfoList.iterator();
    while (localIterator.hasNext())
    {
      LuxuryGiftInfo localLuxuryGiftInfo = (LuxuryGiftInfo)localIterator.next();
      if ((localLuxuryGiftInfo != null) && (paramString.equals(localLuxuryGiftInfo.effectId))) {
        return localLuxuryGiftInfo;
      }
    }
    return null;
  }
  
  private boolean isGiftH264Available(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    if (paramLuxuryGiftInfo == null) {}
    do
    {
      return false;
      if ((!TextUtils.isEmpty(paramLuxuryGiftInfo.giftRootPath)) && (!TextUtils.isEmpty(paramLuxuryGiftInfo.mediaFilePath)) && (!TextUtils.isEmpty(paramLuxuryGiftInfo.lottieConfigFilePath)) && (!TextUtils.isEmpty(paramLuxuryGiftInfo.lottiePlayConfigFilePath))) {
        break;
      }
      this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", "file res is not complete!", new Object[0]);
    } while (this.mCurrentWebGiftInfo == null);
    paramLuxuryGiftInfo = this.mCurrentWebGiftInfo.effectId;
    return false;
    return true;
  }
  
  private void playByH264(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    if (!SPUtil.get(this.mContext, "KEY_GIFT_EFFECTS_SHOW").getBoolean("KEY_GIFT_EFFECTS_SHOW", true)) {
      this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", "user disabled gift effects--honorable gift", new Object[0]);
    }
    while ((this.mH264GiftView == null) || (this.mCurrentWebGiftInfo == null)) {
      return;
    }
    this.mGiftType = 2;
    this.mH264GiftView.setVisibility(0);
    LottieGiftInfo localLottieGiftInfo = new LottieGiftInfo();
    localLottieGiftInfo.senderName = this.mCurrentWebGiftInfo.senderName;
    localLottieGiftInfo.senderHeadUrl = this.mCurrentWebGiftInfo.senderHeadUrl;
    localLottieGiftInfo.effectId = this.mCurrentWebGiftInfo.effectId;
    localLottieGiftInfo.giftName = this.mCurrentWebGiftInfo.giftName;
    localLottieGiftInfo.effectNum = this.mCurrentWebGiftInfo.effectNum;
    localLottieGiftInfo.comment = this.mCurrentWebGiftInfo.comment;
    localLottieGiftInfo.anchorName = this.mCurrentWebGiftInfo.anchorName;
    localLottieGiftInfo.anchorUin = this.mCurrentWebGiftInfo.anchorUin;
    localLottieGiftInfo.linkMicComment = this.mCurrentWebGiftInfo.linkMicGiftComment;
    localLottieGiftInfo.mCurAnchorUin = this.mLuxuryGiftAdapter.getAnchorUin();
    this.mH264GiftView.setLottieGiftInfo(localLottieGiftInfo);
    if (this.mLuxuryGiftData != null) {
      this.mLuxuryGiftData.playTimeMonitor.waitForDownloadTime = System.currentTimeMillis();
    }
    this.mH264GiftView.setBroadCastEvent(this.mLuxuryGiftData);
    this.mH264GiftView.play(paramLuxuryGiftInfo);
  }
  
  private void playByH5()
  {
    onEnd();
  }
  
  private void senLuxuryGiftOverData()
  {
    OnPresentLuxuryGiftOverData localOnPresentLuxuryGiftOverData = new OnPresentLuxuryGiftOverData();
    localOnPresentLuxuryGiftOverData.mEffectNum = 1;
    localOnPresentLuxuryGiftOverData.mGiftIconUrl = this.mLuxuryGiftAdapter.getGiftLogoUrl(this.mCurrentWebGiftInfo.giftBigIcon, this.mCurrentWebGiftInfo.giftTimestamp);
    localOnPresentLuxuryGiftOverData.mGiftId = this.mLuxuryGiftData.giftId;
    localOnPresentLuxuryGiftOverData.mGiftName = this.mCurrentWebGiftInfo.giftName;
    localOnPresentLuxuryGiftOverData.mGiftType = this.mLuxuryGiftData.giftType;
    localOnPresentLuxuryGiftOverData.mHeadUrl = this.mLuxuryGiftData.headUrl;
    localOnPresentLuxuryGiftOverData.mPlayName = this.mLuxuryGiftData.consumerName;
    localOnPresentLuxuryGiftOverData.mConsumerUin = this.mLuxuryGiftData.consumerUin;
    localOnPresentLuxuryGiftOverData.mSendCount = 1;
    localOnPresentLuxuryGiftOverData.mSendNickName = this.mLuxuryGiftData.consumerName;
    localOnPresentLuxuryGiftOverData.mBusinessUid = this.mLuxuryGiftData.mBusinessUid;
    localOnPresentLuxuryGiftOverData.mMsgExtInfo = this.mLuxuryGiftData.mMsgExtInfo;
    this.mComponentImpl.sendLuxuryGiftOver(localOnPresentLuxuryGiftOverData);
  }
  
  public void cancelAnimation()
  {
    if (this.mGiftType == 1) {}
    while ((this.mGiftType != 2) || (this.mH264GiftView == null)) {
      return;
    }
    this.mH264GiftView.stop();
  }
  
  public void createGiftView(ViewGroup paramViewGroup)
  {
    this.mContext = paramViewGroup.getContext();
    this.mRootView = paramViewGroup;
    paramViewGroup = createH264ShowView();
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    paramViewGroup.setVisibility(8);
    this.mRootView.addView(paramViewGroup, localLayoutParams);
    this.mGiftImageAnimator = new ImageView(this.mContext);
    this.mGiftImageAnimator.setVisibility(4);
    this.mRootView.addView(this.mGiftImageAnimator);
  }
  
  public void destroyGiftView()
  {
    if (this.mRootView == null) {
      return;
    }
    this.mRootView.removeAllViews();
    setAnimationListener(null);
    setPrePareState(false);
    this.mRootView = null;
    if (this.mH264GiftView != null) {
      this.mH264GiftView.onDestory();
    }
    this.mH264GiftView = null;
    this.mCurrentWebGiftInfo = null;
    this.mGiftType = 1;
  }
  
  public boolean isAnimViewReady()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mH264GiftView != null)
    {
      this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", " h264 isAnimViewReady  " + this.mH264GiftView.isAnimViewReady(), new Object[0]);
      bool1 = bool2;
      if (this.mIsSupportH264)
      {
        bool1 = bool2;
        if (this.mH264GiftView.isAnimViewReady()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isGiftViewBuilded()
  {
    return this.mH264GiftView != null;
  }
  
  public boolean isH264GiftShowViewReady()
  {
    return (this.mH264GiftView != null) && (this.mH264GiftView.isAnimViewReady());
  }
  
  public boolean isSupportH264()
  {
    return this.mIsSupportH264;
  }
  
  public boolean isWorking()
  {
    if (this.mH264GiftView == null) {}
    do
    {
      return false;
      this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", " isPrepare=" + this.isPrepareState, new Object[0]);
      if (this.isPrepareState) {
        return true;
      }
    } while ((this.mGiftType == 1) || (this.mGiftType != 2));
    this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", " h264 working =" + this.mH264GiftView.isWorking(), new Object[0]);
    return this.mH264GiftView.isWorking();
  }
  
  public void onEnd()
  {
    this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", " end !!!!!!!!!!!!!!!! ", new Object[0]);
    if (this.mH264GiftView != null) {
      this.mH264GiftView.setVisibility(8);
    }
    setPrePareState(false);
    if (this.mLuxuryGiftData == null) {}
    while (this.mLuxuryGiftData.giftType == 101) {
      return;
    }
    senLuxuryGiftOverData();
  }
  
  public void onError(int paramInt)
  {
    this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", "!!!!!!!!!!!!!!error ~~~~~~~~~~h264 play fail, error code:" + paramInt, new Object[0]);
    playByH5();
    if (this.mCurrentWebGiftInfo != null) {}
  }
  
  public void onGetLuxuryGiftResInfoList(List<LuxuryGiftInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      this.mLuxuryGiftAdapter.getLogger().i("LiteLuxuryGiftController", "h264 gift has nothing!!", new Object[0]);
      return;
    }
    int i = 0;
    if (i < paramList.size())
    {
      LuxuryGiftInfo localLuxuryGiftInfo1 = (LuxuryGiftInfo)paramList.get(i);
      if (localLuxuryGiftInfo1 == null) {}
      for (;;)
      {
        i += 1;
        break;
        int j = 0;
        if (j < this.mH264GiftInfoList.size())
        {
          LuxuryGiftInfo localLuxuryGiftInfo2 = (LuxuryGiftInfo)this.mH264GiftInfoList.get(j);
          if (localLuxuryGiftInfo2.effectId == null) {}
          while (!localLuxuryGiftInfo2.effectId.equals(localLuxuryGiftInfo1.effectId))
          {
            j += 1;
            break;
          }
        }
        if (j == this.mH264GiftInfoList.size()) {
          this.mH264GiftInfoList.add(localLuxuryGiftInfo1);
        }
      }
    }
    this.mLuxuryGiftAdapter.queryH264GiftRes(this.mH264GiftInfoList);
  }
  
  public void onGetLuxuryH264Res(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    if (this.mLuxuryGiftAdapter == null) {}
    do
    {
      do
      {
        return;
        this.mLuxuryGiftAdapter.getLogger().i("LiteLuxuryGiftController", " onGetLuxuryH264Res res download success", new Object[0]);
        if (paramLuxuryGiftInfo != null) {
          break;
        }
        if (this.mH264GiftView != null) {
          this.mH264GiftView.setVisibility(8);
        }
        setPrePareState(false);
        this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", " giftInfo onCompleted", new Object[0]);
      } while (this.mComponentImpl == null);
      this.mComponentImpl.onPlayError(3);
      return;
    } while ((this.mCurrentGiftInfo == null) || (this.mCurrentGiftInfo.effectId == null) || (paramLuxuryGiftInfo.effectId == null) || (this.mCurrentGiftInfo.effectId.compareToIgnoreCase(paramLuxuryGiftInfo.effectId) != 0));
    this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", " start to play h264 anim", new Object[0]);
    if (this.mLuxuryGiftData == null) {
      this.mGiftImageAnimator.setVisibility(8);
    }
    if (isGiftH264Available(paramLuxuryGiftInfo))
    {
      playByH264(paramLuxuryGiftInfo);
      return;
    }
    if (this.mComponentImpl != null) {
      this.mComponentImpl.onPlayError(4);
    }
    this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", " get giftInfo null don't play!!!!!!!!!!!!!!", new Object[0]);
    playByH5();
  }
  
  public void onPlayAtTime(long paramLong)
  {
    if ((this.mPlayFirstTime) && (this.mCurrentGiftInfo != null) && (this.mCurrentWebGiftInfo != null) && (this.mCurrentGiftInfo.vibrate != 0))
    {
      this.mPlayFirstTime = false;
      if (this.mLuxuryGiftAdapter.getAccountUin() != this.mLuxuryGiftAdapter.getAnchorUin())
      {
        this.mCurrentVibrateFile = (this.mCurrentGiftInfo.vibrate + "");
        this.mLuxuryGiftAdapter.getLogger().i("LiteLuxuryGiftController", "HonorableGiftController,onPlayAtTime, mCurrentVibrateFile=" + this.mCurrentVibrateFile + ",Account.getSelfUin()=" + this.mLuxuryGiftAdapter.getAccountUin() + ",mCurrentWebGiftInfo.uin=" + this.mCurrentWebGiftInfo.uin, new Object[0]);
        if ((this.mCurrentGiftInfo.vibrateRange == 1) || (this.mLuxuryGiftAdapter.getAccountUin() != this.mCurrentWebGiftInfo.uin)) {}
      }
    }
    if ((this.mCurrentGiftInfo != null) && (this.mCurrentGiftInfo.vibrate != 0) && (this.mIsCanUpdateing) && (paramLong / 100000L >= this.mUpdateTimes))
    {
      this.mUpdateTimes += 1L;
      this.mIsCanUpdateing = false;
      this.mIsCanUpdateing = true;
    }
  }
  
  public void onStart()
  {
    if (this.mCurrentWebGiftInfo != null) {}
  }
  
  public void onVideoSize(int paramInt1, int paramInt2) {}
  
  public void setAnimationListener(IGiftAnimation paramIGiftAnimation)
  {
    if (this.mH264GiftView != null) {
      this.mH264GiftView.setAnimationListener(paramIGiftAnimation);
    }
  }
  
  public void setComponentImpl(LiteLuxuryGiftComponentImpl paramLiteLuxuryGiftComponentImpl)
  {
    this.mComponentImpl = paramLiteLuxuryGiftComponentImpl;
  }
  
  public void setGiftViewVisible(boolean paramBoolean)
  {
    int i = 8;
    if (this.mH264GiftView == null) {
      return;
    }
    if (this.mGiftType == 1) {
      this.mH264GiftView.setVisibility(8);
    }
    for (;;)
    {
      this.mH264GiftView.showCtrls(paramBoolean);
      return;
      if (this.mGiftType == 2)
      {
        H264GiftView localH264GiftView = this.mH264GiftView;
        if (paramBoolean) {
          i = 0;
        }
        localH264GiftView.setVisibility(i);
      }
    }
  }
  
  public void setPrePareState(boolean paramBoolean)
  {
    this.isPrepareState = paramBoolean;
  }
  
  public void showAnimation(WebGiftInfo paramWebGiftInfo, LuxuryGiftData paramLuxuryGiftData)
  {
    this.mLuxuryGiftData = paramLuxuryGiftData;
    this.mPlayFirstTime = true;
    this.mUpdateTimes = 1L;
    setPrePareState(true);
    this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", "mark prepare t=" + System.currentTimeMillis(), new Object[0]);
    ThreadCenter.postDelayedUITask(this, new LiteLuxuryGiftController.1(this, paramWebGiftInfo), 0L);
  }
  
  public void showCtrils(boolean paramBoolean)
  {
    if (this.mH264GiftView != null) {
      this.mH264GiftView.showCtrls(paramBoolean);
    }
  }
  
  public void uninit()
  {
    if ((this.mGiftType == 2) && (isWorking()) && (this.mCurrentWebGiftInfo != null)) {}
    destroyGiftView();
    this.mH264GiftInfoList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.components.luxurygift.LiteLuxuryGiftController
 * JD-Core Version:    0.7.0.1
 */