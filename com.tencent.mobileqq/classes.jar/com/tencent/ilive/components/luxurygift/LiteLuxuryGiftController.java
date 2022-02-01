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
import com.tencent.falco.base.libapi.lottie.LottieGiftInfo;
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
  DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder().showImageForEmptyUri(2130841228).showImageOnFail(2130841228).cacheInMemory(true).cacheOnDisk(true).considerExifParams(false).bitmapConfig(Bitmap.Config.RGB_565).displayer(new FadeInBitmapDisplayer(300)).build();
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
    if (paramLuxuryGiftInfo == null) {
      return false;
    }
    if ((!TextUtils.isEmpty(paramLuxuryGiftInfo.giftRootPath)) && (!TextUtils.isEmpty(paramLuxuryGiftInfo.mediaFilePath)) && (!TextUtils.isEmpty(paramLuxuryGiftInfo.lottieConfigFilePath)) && (!TextUtils.isEmpty(paramLuxuryGiftInfo.lottiePlayConfigFilePath))) {
      return true;
    }
    this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", "file res is not complete!", new Object[0]);
    paramLuxuryGiftInfo = this.mCurrentWebGiftInfo;
    if (paramLuxuryGiftInfo != null) {
      paramLuxuryGiftInfo = paramLuxuryGiftInfo.effectId;
    }
    return false;
  }
  
  private void playByH264(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    if (!SPUtil.get(this.mContext, "KEY_GIFT_EFFECTS_SHOW").getBoolean("KEY_GIFT_EFFECTS_SHOW", true))
    {
      this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", "user disabled gift effects--honorable gift", new Object[0]);
      return;
    }
    Object localObject = this.mH264GiftView;
    if (localObject == null) {
      return;
    }
    if (this.mCurrentWebGiftInfo == null) {
      return;
    }
    this.mGiftType = 2;
    ((H264GiftView)localObject).setVisibility(0);
    localObject = new LottieGiftInfo();
    ((LottieGiftInfo)localObject).a = this.mCurrentWebGiftInfo.senderName;
    ((LottieGiftInfo)localObject).b = this.mCurrentWebGiftInfo.senderHeadUrl;
    ((LottieGiftInfo)localObject).c = this.mCurrentWebGiftInfo.effectId;
    ((LottieGiftInfo)localObject).d = this.mCurrentWebGiftInfo.giftName;
    ((LottieGiftInfo)localObject).e = this.mCurrentWebGiftInfo.effectNum;
    ((LottieGiftInfo)localObject).f = this.mCurrentWebGiftInfo.comment;
    ((LottieGiftInfo)localObject).g = this.mCurrentWebGiftInfo.anchorName;
    ((LottieGiftInfo)localObject).h = this.mCurrentWebGiftInfo.anchorUin;
    ((LottieGiftInfo)localObject).i = this.mCurrentWebGiftInfo.linkMicGiftComment;
    ((LottieGiftInfo)localObject).j = this.mLuxuryGiftAdapter.getAnchorUin();
    this.mH264GiftView.setLottieGiftInfo((LottieGiftInfo)localObject);
    localObject = this.mLuxuryGiftData;
    if (localObject != null) {
      ((LuxuryGiftData)localObject).playTimeMonitor.waitForDownloadTime = System.currentTimeMillis();
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
    int i = this.mGiftType;
    if (i == 1) {
      return;
    }
    if (i == 2)
    {
      H264GiftView localH264GiftView = this.mH264GiftView;
      if (localH264GiftView != null) {
        localH264GiftView.stop();
      }
    }
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
    Object localObject = this.mRootView;
    if (localObject == null) {
      return;
    }
    ((ViewGroup)localObject).removeAllViews();
    setAnimationListener(null);
    setPrePareState(false);
    this.mRootView = null;
    localObject = this.mH264GiftView;
    if (localObject != null) {
      ((H264GiftView)localObject).onDestory();
    }
    this.mH264GiftView = null;
    this.mCurrentWebGiftInfo = null;
    this.mGiftType = 1;
  }
  
  public boolean isAnimViewReady()
  {
    if (this.mH264GiftView != null)
    {
      LogInterface localLogInterface = this.mLuxuryGiftAdapter.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" h264 isAnimViewReady  ");
      localStringBuilder.append(this.mH264GiftView.isAnimViewReady());
      localLogInterface.e("LiteLuxuryGiftController", localStringBuilder.toString(), new Object[0]);
      if ((this.mIsSupportH264) && (this.mH264GiftView.isAnimViewReady())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isGiftViewBuilded()
  {
    return this.mH264GiftView != null;
  }
  
  public boolean isH264GiftShowViewReady()
  {
    H264GiftView localH264GiftView = this.mH264GiftView;
    return (localH264GiftView != null) && (localH264GiftView.isAnimViewReady());
  }
  
  public boolean isSupportH264()
  {
    return this.mIsSupportH264;
  }
  
  public boolean isWorking()
  {
    if (this.mH264GiftView == null) {
      return false;
    }
    LogInterface localLogInterface = this.mLuxuryGiftAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" isPrepare=");
    localStringBuilder.append(this.isPrepareState);
    localLogInterface.e("LiteLuxuryGiftController", localStringBuilder.toString(), new Object[0]);
    if (this.isPrepareState) {
      return true;
    }
    int i = this.mGiftType;
    if (i == 1) {
      return false;
    }
    if (i == 2)
    {
      localLogInterface = this.mLuxuryGiftAdapter.getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" h264 working =");
      localStringBuilder.append(this.mH264GiftView.isWorking());
      localLogInterface.e("LiteLuxuryGiftController", localStringBuilder.toString(), new Object[0]);
      return this.mH264GiftView.isWorking();
    }
    return false;
  }
  
  public void onEnd()
  {
    this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", " end !!!!!!!!!!!!!!!! ", new Object[0]);
    Object localObject = this.mH264GiftView;
    if (localObject != null) {
      ((H264GiftView)localObject).setVisibility(8);
    }
    setPrePareState(false);
    localObject = this.mLuxuryGiftData;
    if (localObject == null) {
      return;
    }
    if (((LuxuryGiftData)localObject).giftType != 101) {
      senLuxuryGiftOverData();
    }
  }
  
  public void onError(int paramInt)
  {
    Object localObject = this.mLuxuryGiftAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("!!!!!!!!!!!!!!error ~~~~~~~~~~h264 play fail, error code:");
    localStringBuilder.append(paramInt);
    ((LogInterface)localObject).e("LiteLuxuryGiftController", localStringBuilder.toString(), new Object[0]);
    playByH5();
    localObject = this.mCurrentWebGiftInfo;
  }
  
  public void onGetLuxuryGiftResInfoList(List<LuxuryGiftInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        LuxuryGiftInfo localLuxuryGiftInfo1 = (LuxuryGiftInfo)paramList.get(i);
        if (localLuxuryGiftInfo1 != null)
        {
          int j = 0;
          while (j < this.mH264GiftInfoList.size())
          {
            LuxuryGiftInfo localLuxuryGiftInfo2 = (LuxuryGiftInfo)this.mH264GiftInfoList.get(j);
            if ((localLuxuryGiftInfo2.effectId != null) && (localLuxuryGiftInfo2.effectId.equals(localLuxuryGiftInfo1.effectId))) {
              break;
            }
            j += 1;
          }
          if (j == this.mH264GiftInfoList.size()) {
            this.mH264GiftInfoList.add(localLuxuryGiftInfo1);
          }
        }
        i += 1;
      }
      this.mLuxuryGiftAdapter.queryH264GiftRes(this.mH264GiftInfoList);
      return;
    }
    this.mLuxuryGiftAdapter.getLogger().i("LiteLuxuryGiftController", "h264 gift has nothing!!", new Object[0]);
  }
  
  public void onGetLuxuryH264Res(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    Object localObject = this.mLuxuryGiftAdapter;
    if (localObject == null) {
      return;
    }
    ((LuxuryGiftAdapter)localObject).getLogger().i("LiteLuxuryGiftController", " onGetLuxuryH264Res res download success", new Object[0]);
    if (paramLuxuryGiftInfo == null)
    {
      paramLuxuryGiftInfo = this.mH264GiftView;
      if (paramLuxuryGiftInfo != null) {
        paramLuxuryGiftInfo.setVisibility(8);
      }
      setPrePareState(false);
      this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", " giftInfo onCompleted", new Object[0]);
      paramLuxuryGiftInfo = this.mComponentImpl;
      if (paramLuxuryGiftInfo != null) {
        paramLuxuryGiftInfo.onPlayError(3);
      }
      return;
    }
    localObject = this.mCurrentGiftInfo;
    if ((localObject != null) && (((LuxuryGiftInfo)localObject).effectId != null) && (paramLuxuryGiftInfo.effectId != null) && (this.mCurrentGiftInfo.effectId.compareToIgnoreCase(paramLuxuryGiftInfo.effectId) == 0))
    {
      this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", " start to play h264 anim", new Object[0]);
      if (this.mLuxuryGiftData == null) {
        this.mGiftImageAnimator.setVisibility(8);
      }
      if (isGiftH264Available(paramLuxuryGiftInfo))
      {
        playByH264(paramLuxuryGiftInfo);
        return;
      }
      paramLuxuryGiftInfo = this.mComponentImpl;
      if (paramLuxuryGiftInfo != null) {
        paramLuxuryGiftInfo.onPlayError(4);
      }
      this.mLuxuryGiftAdapter.getLogger().e("LiteLuxuryGiftController", " get giftInfo null don't play!!!!!!!!!!!!!!", new Object[0]);
      playByH5();
    }
  }
  
  public void onPlayAtTime(long paramLong)
  {
    long l;
    if (this.mPlayFirstTime)
    {
      localObject = this.mCurrentGiftInfo;
      if ((localObject != null) && (this.mCurrentWebGiftInfo != null) && (((LuxuryGiftInfo)localObject).vibrate != 0))
      {
        this.mPlayFirstTime = false;
        if (this.mLuxuryGiftAdapter.getAccountUin() != this.mLuxuryGiftAdapter.getAnchorUin())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(this.mCurrentGiftInfo.vibrate);
          ((StringBuilder)localObject).append("");
          this.mCurrentVibrateFile = ((StringBuilder)localObject).toString();
          localObject = this.mLuxuryGiftAdapter.getLogger();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("HonorableGiftController,onPlayAtTime, mCurrentVibrateFile=");
          localStringBuilder.append(this.mCurrentVibrateFile);
          localStringBuilder.append(",Account.getSelfUin()=");
          localStringBuilder.append(this.mLuxuryGiftAdapter.getAccountUin());
          localStringBuilder.append(",mCurrentWebGiftInfo.uin=");
          localStringBuilder.append(this.mCurrentWebGiftInfo.uin);
          ((LogInterface)localObject).i("LiteLuxuryGiftController", localStringBuilder.toString(), new Object[0]);
          if (this.mCurrentGiftInfo.vibrateRange != 1)
          {
            this.mLuxuryGiftAdapter.getAccountUin();
            l = this.mCurrentWebGiftInfo.uin;
          }
        }
      }
    }
    Object localObject = this.mCurrentGiftInfo;
    if ((localObject != null) && (((LuxuryGiftInfo)localObject).vibrate != 0) && (this.mIsCanUpdateing))
    {
      paramLong /= 100000L;
      l = this.mUpdateTimes;
      if (paramLong >= l)
      {
        this.mUpdateTimes = (l + 1L);
        this.mIsCanUpdateing = false;
        this.mIsCanUpdateing = true;
      }
    }
  }
  
  public void onStart()
  {
    WebGiftInfo localWebGiftInfo = this.mCurrentWebGiftInfo;
  }
  
  public void onVideoSize(int paramInt1, int paramInt2) {}
  
  public void setAnimationListener(IGiftAnimation paramIGiftAnimation)
  {
    H264GiftView localH264GiftView = this.mH264GiftView;
    if (localH264GiftView != null) {
      localH264GiftView.setAnimationListener(paramIGiftAnimation);
    }
  }
  
  public void setComponentImpl(LiteLuxuryGiftComponentImpl paramLiteLuxuryGiftComponentImpl)
  {
    this.mComponentImpl = paramLiteLuxuryGiftComponentImpl;
  }
  
  public void setGiftViewVisible(boolean paramBoolean)
  {
    H264GiftView localH264GiftView = this.mH264GiftView;
    if (localH264GiftView == null) {
      return;
    }
    int j = this.mGiftType;
    int i = 8;
    if (j == 1)
    {
      localH264GiftView.setVisibility(8);
    }
    else if (j == 2)
    {
      if (paramBoolean) {
        i = 0;
      }
      localH264GiftView.setVisibility(i);
    }
    this.mH264GiftView.showCtrls(paramBoolean);
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
    paramLuxuryGiftData = this.mLuxuryGiftAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mark prepare t=");
    localStringBuilder.append(System.currentTimeMillis());
    paramLuxuryGiftData.e("LiteLuxuryGiftController", localStringBuilder.toString(), new Object[0]);
    ThreadCenter.postDelayedUITask(this, new LiteLuxuryGiftController.1(this, paramWebGiftInfo), 0L);
  }
  
  public void showCtrils(boolean paramBoolean)
  {
    H264GiftView localH264GiftView = this.mH264GiftView;
    if (localH264GiftView != null) {
      localH264GiftView.showCtrls(paramBoolean);
    }
  }
  
  public void uninit()
  {
    if ((this.mGiftType == 2) && (isWorking())) {
      WebGiftInfo localWebGiftInfo = this.mCurrentWebGiftInfo;
    }
    destroyGiftView();
    this.mH264GiftInfoList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.components.luxurygift.LiteLuxuryGiftController
 * JD-Core Version:    0.7.0.1
 */