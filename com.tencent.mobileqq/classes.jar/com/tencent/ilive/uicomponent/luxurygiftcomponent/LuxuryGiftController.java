package com.tencent.ilive.uicomponent.luxurygiftcomponent;

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
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.web.IRichGiftShowPlay;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.web.RichGiftShowView;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnPresentLuxuryGiftOverData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LuxuryGiftController
  implements ThreadCenter.HandlerKeyable, IH264PlayL
{
  public static final int H264_GIFT = 2;
  public static final int H5_GIFT = 1;
  public static final String KEY_GIFT_EFFECTS_SHOW = "KEY_GIFT_EFFECTS_SHOW";
  public static final int NO_VIBRATE = 0;
  private static final String TAG = "HonorableGiftController";
  public static final int VIBRATE_RANGE_ALL = 1;
  public static final int VIBRATE_SYNCHRONIZE_INTERVAL = 100000;
  private final int COMBO_LUXURY_GIFT = 101;
  DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder().showImageForEmptyUri(2130840466).showImageOnFail(2130840466).cacheInMemory(true).cacheOnDisk(true).considerExifParams(false).bitmapConfig(Bitmap.Config.RGB_565).displayer(new FadeInBitmapDisplayer(300)).build();
  IRichGiftShowPlay iRichGiftShowPlay = new LuxuryGiftController.3(this);
  private boolean isPrepareState = false;
  private LuxuryGiftComponentImpl mComponentImpl;
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
  private RichGiftShowView mRichGiftShowView;
  private ViewGroup mRootView;
  private long mUpdateTimes = 1L;
  
  public LuxuryGiftController(LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    this.mLuxuryGiftAdapter = paramLuxuryGiftAdapter;
  }
  
  private View createH264ShowView()
  {
    this.mH264GiftView = new H264GiftView(this.mContext, this.mLuxuryGiftAdapter);
    this.mH264GiftView.setPlayListener(this);
    return this.mH264GiftView;
  }
  
  private View createRichShowView()
  {
    this.mRichGiftShowView = new RichGiftShowView(this.mContext, this.mLuxuryGiftAdapter);
    this.mRichGiftShowView.setmRichGiftPlayListener(this.iRichGiftShowPlay);
    return this.mRichGiftShowView;
  }
  
  private void fetchGiftResByGiftInfo(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    this.mLuxuryGiftAdapter.fetchGiftResByGiftInfo(paramLuxuryGiftInfo, new LuxuryGiftController.2(this));
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
    this.mLuxuryGiftAdapter.getLogger().e("HonorableGiftController", "file res is not complete!", new Object[0]);
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
      this.mLuxuryGiftAdapter.getLogger().e("HonorableGiftController", "user disabled gift effects--honorable gift", new Object[0]);
      return;
    }
    Object localObject = this.mH264GiftView;
    if (localObject != null)
    {
      if (this.mRichGiftShowView == null) {
        return;
      }
      if (this.mCurrentWebGiftInfo == null) {
        return;
      }
      this.mGiftType = 2;
      ((H264GiftView)localObject).setVisibility(0);
      this.mRichGiftShowView.setVisibility(8);
      localObject = new LottieGiftInfo();
      ((LottieGiftInfo)localObject).jdField_a_of_type_JavaLangString = this.mCurrentWebGiftInfo.senderName;
      ((LottieGiftInfo)localObject).jdField_b_of_type_JavaLangString = this.mCurrentWebGiftInfo.senderHeadUrl;
      ((LottieGiftInfo)localObject).c = this.mCurrentWebGiftInfo.effectId;
      ((LottieGiftInfo)localObject).d = this.mCurrentWebGiftInfo.giftName;
      ((LottieGiftInfo)localObject).e = this.mCurrentWebGiftInfo.effectNum;
      ((LottieGiftInfo)localObject).f = this.mCurrentWebGiftInfo.comment;
      ((LottieGiftInfo)localObject).g = this.mCurrentWebGiftInfo.anchorName;
      ((LottieGiftInfo)localObject).jdField_a_of_type_Long = this.mCurrentWebGiftInfo.anchorUin;
      ((LottieGiftInfo)localObject).h = this.mCurrentWebGiftInfo.linkMicGiftComment;
      ((LottieGiftInfo)localObject).jdField_b_of_type_Long = this.mLuxuryGiftAdapter.getAnchorUin();
      this.mH264GiftView.setLottieGiftInfo((LottieGiftInfo)localObject);
      localObject = this.mLuxuryGiftData;
      if (localObject != null) {
        ((LuxuryGiftData)localObject).playTimeMonitor.waitForDownloadTime = System.currentTimeMillis();
      }
      this.mH264GiftView.setBroadCastEvent(this.mLuxuryGiftData);
      this.mH264GiftView.play(paramLuxuryGiftInfo);
    }
  }
  
  private void playByH5()
  {
    if (!SPUtil.get(this.mContext, "KEY_GIFT_EFFECTS_SHOW").getBoolean("KEY_GIFT_EFFECTS_SHOW", true))
    {
      this.mLuxuryGiftAdapter.getLogger().e("HonorableGiftController", "user disabled gift effects--honorable gift", new Object[0]);
      onEnd();
      return;
    }
    Object localObject = this.mRichGiftShowView;
    if ((localObject != null) && (((RichGiftShowView)localObject).isAnimViewReady()))
    {
      localObject = this.mH264GiftView;
      if (localObject != null)
      {
        if (this.mRichGiftShowView == null) {
          return;
        }
        if (this.mCurrentWebGiftInfo == null) {
          return;
        }
        this.mGiftType = 1;
        ((H264GiftView)localObject).setVisibility(8);
        this.mRichGiftShowView.setVisibility(0);
        this.mRichGiftShowView.showAnimation(this.mCurrentWebGiftInfo);
      }
      return;
    }
    this.mLuxuryGiftAdapter.getLogger().e("HonorableGiftController", "h5 rich gift view is not ready!", new Object[0]);
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
    Object localObject;
    if (i == 1)
    {
      localObject = this.mRichGiftShowView;
      if (localObject != null) {
        ((RichGiftShowView)localObject).cancelAnimation();
      }
    }
    else if (i == 2)
    {
      localObject = this.mH264GiftView;
      if (localObject != null) {
        ((H264GiftView)localObject).stop();
      }
    }
  }
  
  public void createGiftView(ViewGroup paramViewGroup)
  {
    this.mContext = paramViewGroup.getContext();
    this.mRootView = paramViewGroup;
    paramViewGroup = createRichShowView();
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    paramViewGroup.setVisibility(8);
    this.mRootView.addView(paramViewGroup, localLayoutParams);
    paramViewGroup = createH264ShowView();
    localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
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
    localObject = this.mRichGiftShowView;
    if (localObject != null) {
      ((RichGiftShowView)localObject).destroy();
    }
    setAnimationListener(null);
    setPrePareState(false);
    this.mRootView = null;
    this.mRichGiftShowView = null;
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
    LogInterface localLogInterface;
    StringBuilder localStringBuilder;
    if (this.mH264GiftView != null)
    {
      localLogInterface = this.mLuxuryGiftAdapter.getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" h264 isAnimViewReady  ");
      localStringBuilder.append(this.mH264GiftView.isAnimViewReady());
      localLogInterface.e("HonorableGiftController", localStringBuilder.toString(), new Object[0]);
      if ((this.mIsSupportH264) && (this.mH264GiftView.isAnimViewReady())) {
        return true;
      }
    }
    if (this.mRichGiftShowView != null)
    {
      localLogInterface = this.mLuxuryGiftAdapter.getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" h5 isAnimViewReady  ");
      localStringBuilder.append(this.mRichGiftShowView.isAnimViewReady());
      localLogInterface.e("HonorableGiftController", localStringBuilder.toString(), new Object[0]);
      if (this.mRichGiftShowView.isAnimViewReady()) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isGiftViewBuilded()
  {
    return (this.mRichGiftShowView != null) && (this.mH264GiftView != null);
  }
  
  public boolean isH264GiftShowViewReady()
  {
    H264GiftView localH264GiftView = this.mH264GiftView;
    return (localH264GiftView != null) && (localH264GiftView.isAnimViewReady());
  }
  
  public boolean isRichGiftShowViewReady()
  {
    RichGiftShowView localRichGiftShowView = this.mRichGiftShowView;
    return (localRichGiftShowView != null) && (localRichGiftShowView.isAnimViewReady());
  }
  
  public boolean isSupportH264()
  {
    return this.mIsSupportH264;
  }
  
  public boolean isWorking()
  {
    if (this.mRichGiftShowView != null)
    {
      if (this.mH264GiftView == null) {
        return false;
      }
      LogInterface localLogInterface = this.mLuxuryGiftAdapter.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" isPrepare=");
      localStringBuilder.append(this.isPrepareState);
      localLogInterface.e("HonorableGiftController", localStringBuilder.toString(), new Object[0]);
      if (this.isPrepareState) {
        return true;
      }
      int i = this.mGiftType;
      if (i == 1)
      {
        localLogInterface = this.mLuxuryGiftAdapter.getLogger();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" rich working =");
        localStringBuilder.append(this.mRichGiftShowView.isWorking());
        localLogInterface.e("HonorableGiftController", localStringBuilder.toString(), new Object[0]);
        return this.mRichGiftShowView.isWorking();
      }
      if (i == 2)
      {
        localLogInterface = this.mLuxuryGiftAdapter.getLogger();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" h264 working =");
        localStringBuilder.append(this.mH264GiftView.isWorking());
        localLogInterface.e("HonorableGiftController", localStringBuilder.toString(), new Object[0]);
        return this.mH264GiftView.isWorking();
      }
    }
    return false;
  }
  
  public void onEnd()
  {
    this.mLuxuryGiftAdapter.getLogger().e("HonorableGiftController", " end !!!!!!!!!!!!!!!! ", new Object[0]);
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
    ((LogInterface)localObject).e("HonorableGiftController", localStringBuilder.toString(), new Object[0]);
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
    this.mLuxuryGiftAdapter.getLogger().i("HonorableGiftController", "h264 gift has nothing!!", new Object[0]);
  }
  
  public void onGetLuxuryH264Res(LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    if (this.mLuxuryGiftAdapter == null) {
      return;
    }
    if (paramLuxuryGiftInfo == null)
    {
      paramLuxuryGiftInfo = this.mH264GiftView;
      if (paramLuxuryGiftInfo != null) {
        paramLuxuryGiftInfo.setVisibility(8);
      }
      setPrePareState(false);
      this.mLuxuryGiftAdapter.getLogger().e("HonorableGiftController", " giftInfo onCompleted", new Object[0]);
      return;
    }
    LuxuryGiftInfo localLuxuryGiftInfo = this.mCurrentGiftInfo;
    if ((localLuxuryGiftInfo != null) && (localLuxuryGiftInfo.effectId != null) && (paramLuxuryGiftInfo.effectId != null) && (this.mCurrentGiftInfo.effectId.compareToIgnoreCase(paramLuxuryGiftInfo.effectId) == 0))
    {
      this.mLuxuryGiftAdapter.getLogger().e("HonorableGiftController", " start to play h264 anim", new Object[0]);
      if (this.mLuxuryGiftData == null) {
        this.mGiftImageAnimator.setVisibility(8);
      }
      if (isGiftH264Available(paramLuxuryGiftInfo))
      {
        playByH264(paramLuxuryGiftInfo);
        return;
      }
      this.mLuxuryGiftAdapter.getLogger().e("HonorableGiftController", " get giftInfo null don't play!!!!!!!!!!!!!!", new Object[0]);
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
          ((LogInterface)localObject).i("HonorableGiftController", localStringBuilder.toString(), new Object[0]);
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
    Object localObject = this.mRichGiftShowView;
    if (localObject != null) {
      ((RichGiftShowView)localObject).setAnimationListener(paramIGiftAnimation);
    }
    localObject = this.mH264GiftView;
    if (localObject != null) {
      ((H264GiftView)localObject).setAnimationListener(paramIGiftAnimation);
    }
  }
  
  public void setComponentImpl(LuxuryGiftComponentImpl paramLuxuryGiftComponentImpl)
  {
    this.mComponentImpl = paramLuxuryGiftComponentImpl;
  }
  
  public void setGiftViewVisible(boolean paramBoolean)
  {
    Object localObject = this.mRichGiftShowView;
    if (localObject != null)
    {
      if (this.mH264GiftView == null) {
        return;
      }
      int k = this.mGiftType;
      int j = 0;
      int i = 0;
      if (k == 1)
      {
        if (!paramBoolean) {
          i = 8;
        }
        ((RichGiftShowView)localObject).setVisibility(i);
        this.mH264GiftView.setVisibility(8);
      }
      else if (k == 2)
      {
        ((RichGiftShowView)localObject).setVisibility(8);
        localObject = this.mH264GiftView;
        if (paramBoolean) {
          i = j;
        } else {
          i = 8;
        }
        ((H264GiftView)localObject).setVisibility(i);
      }
      this.mH264GiftView.showCtrls(paramBoolean);
      this.mRichGiftShowView.showCtrls(paramBoolean);
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
    paramLuxuryGiftData = this.mLuxuryGiftAdapter.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mark prepare t=");
    localStringBuilder.append(System.currentTimeMillis());
    paramLuxuryGiftData.e("HonorableGiftController", localStringBuilder.toString(), new Object[0]);
    ThreadCenter.postDelayedUITask(this, new LuxuryGiftController.1(this, paramWebGiftInfo), 0L);
  }
  
  public void showCtrils(boolean paramBoolean)
  {
    Object localObject = this.mH264GiftView;
    if (localObject != null) {
      ((H264GiftView)localObject).showCtrls(paramBoolean);
    }
    localObject = this.mRichGiftShowView;
    if (localObject != null) {
      ((RichGiftShowView)localObject).showCtrls(paramBoolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.LuxuryGiftController
 * JD-Core Version:    0.7.0.1
 */