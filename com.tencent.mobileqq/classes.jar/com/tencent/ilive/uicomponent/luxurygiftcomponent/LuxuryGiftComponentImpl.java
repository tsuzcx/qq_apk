package com.tencent.ilive.uicomponent.luxurygiftcomponent;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.uicomponent.UIBaseComponent;
import com.tencent.ilive.uicomponent.UIView;
import com.tencent.ilive.uicomponent.UIViewModel;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.GiftQueue;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.WebGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.showview.IGiftAnimation;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftAdapter;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.LuxuryGiftComponent;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnPresentLuxuryGiftOverData;
import com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.OnPresentLuxuryGiftOverListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LuxuryGiftComponentImpl
  extends UIBaseComponent
  implements ThreadCenter.HandlerKeyable, IGiftAnimation, LuxuryGiftComponent
{
  private static final String TAG = "LuxuryGiftComponentImpl";
  private Set<OnPresentLuxuryGiftOverListener> giftOverListeners = new HashSet();
  private LuxuryGiftController mHonorableGiftController;
  private boolean mIsNeedShow = true;
  private LuxuryGiftAdapter mLuxuryGiftAdapter = null;
  private FrameLayout mRichGiftContainerView;
  private View mRootView;
  private GiftQueue mToPlayGiftsList;
  
  private WebGiftInfo constructWebGiftInfo(LuxuryGiftData paramLuxuryGiftData, LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    WebGiftInfo localWebGiftInfo = new WebGiftInfo();
    localWebGiftInfo.uin = paramLuxuryGiftData.consumerUin;
    LogInterface localLogInterface;
    StringBuilder localStringBuilder;
    if (!TextUtils.isEmpty(paramLuxuryGiftData.effectId))
    {
      localLogInterface = getLuxuryGiftAdapter().getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" effectId e= ");
      localStringBuilder.append(paramLuxuryGiftData.effectId);
      localLogInterface.e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
      localWebGiftInfo.effectId = paramLuxuryGiftData.effectId;
    }
    else
    {
      localWebGiftInfo.effectId = paramLuxuryGiftInfo.effectId;
      localLogInterface = getLuxuryGiftAdapter().getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" effectId g= ");
      localStringBuilder.append(paramLuxuryGiftInfo.effectId);
      localLogInterface.e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
    }
    if (!TextUtils.isEmpty(paramLuxuryGiftData.effectWord))
    {
      localLogInterface = getLuxuryGiftAdapter().getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" effectWord  e= ");
      localStringBuilder.append(paramLuxuryGiftData.effectWord);
      localLogInterface.e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
      localWebGiftInfo.comment = paramLuxuryGiftData.effectWord;
    }
    else
    {
      localLogInterface = getLuxuryGiftAdapter().getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" comment  g= ");
      localStringBuilder.append(paramLuxuryGiftInfo.comment);
      localLogInterface.e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
      localWebGiftInfo.comment = paramLuxuryGiftInfo.comment;
    }
    localWebGiftInfo.giftName = paramLuxuryGiftInfo.giftName;
    localWebGiftInfo.senderName = paramLuxuryGiftData.consumerName;
    localWebGiftInfo.senderHeadKey = paramLuxuryGiftData.headKey;
    localWebGiftInfo.senderHeadUrl = paramLuxuryGiftData.headUrl;
    localWebGiftInfo.anchorName = paramLuxuryGiftData.playName;
    localWebGiftInfo.anchorUin = paramLuxuryGiftData.playUin;
    localWebGiftInfo.giftBigIcon = paramLuxuryGiftInfo.bigIcon;
    localWebGiftInfo.giftSmallIcon = paramLuxuryGiftInfo.smallIcon;
    localWebGiftInfo.giftTimestamp = paramLuxuryGiftInfo.timestamp;
    return localWebGiftInfo;
  }
  
  private boolean isShowingAnim()
  {
    LuxuryGiftController localLuxuryGiftController = this.mHonorableGiftController;
    return (localLuxuryGiftController != null) && (localLuxuryGiftController.isGiftViewBuilded()) && (this.mHonorableGiftController.isWorking());
  }
  
  private void playNext()
  {
    if (this.mToPlayGiftsList.size() == 0) {
      return;
    }
    if (this.mLuxuryGiftAdapter == null) {
      return;
    }
    Object localObject = getLuxuryGiftAdapter().getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playNext  size=");
    localStringBuilder.append(this.mToPlayGiftsList.size());
    ((LogInterface)localObject).e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
    localObject = this.mToPlayGiftsList.peek();
    if ((((LuxuryGiftData)localObject).giftType == 104) || (((LuxuryGiftData)localObject).giftType == 101) || (((LuxuryGiftData)localObject).giftType == 106))
    {
      if (!this.mHonorableGiftController.isGiftViewBuilded()) {
        buildRichGiftShowView();
      }
      if (!this.mHonorableGiftController.isAnimViewReady()) {
        getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "false  mHonorableGiftController.isAnimViewReady()", new Object[0]);
      }
    }
    getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", " playNext poll", new Object[0]);
    showAnimation(this.mToPlayGiftsList.poll());
  }
  
  private void sendShowGiftMsg(LuxuryGiftData paramLuxuryGiftData)
  {
    if (paramLuxuryGiftData.giftType != 101)
    {
      if (paramLuxuryGiftData.giftType == 106) {
        return;
      }
      LogInterface localLogInterface = getLuxuryGiftAdapter().getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendShowGiftMsg e=");
      localStringBuilder.append(paramLuxuryGiftData);
      localLogInterface.e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
    }
  }
  
  private void showAnimation(LuxuryGiftData paramLuxuryGiftData)
  {
    if (!UIUtil.isScreenPortrait(this.mRootView.getContext()))
    {
      paramLuxuryGiftData = getLuxuryGiftAdapter().getLogger();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" showAnimation isPortrait= ");
      ((StringBuilder)localObject).append(UIUtil.isScreenPortrait(this.mRootView.getContext()));
      paramLuxuryGiftData.i("LuxuryGiftComponentImpl", ((StringBuilder)localObject).toString(), new Object[0]);
      return;
    }
    if (paramLuxuryGiftData == null)
    {
      getLuxuryGiftAdapter().getLogger().i("LuxuryGiftComponentImpl", "showAnimation: info = null.", new Object[0]);
      return;
    }
    Object localObject = getLuxuryGiftAdapter().getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showAnimation，info.effectId=");
    localStringBuilder.append(paramLuxuryGiftData.effectId);
    localStringBuilder.append(" info=");
    localStringBuilder.append(paramLuxuryGiftData.consumerUin);
    ((LogInterface)localObject).e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
    paramLuxuryGiftData.playTimeMonitor.waitInQueueTime = System.currentTimeMillis();
    if ((paramLuxuryGiftData.giftType == 104) || (paramLuxuryGiftData.giftType == 101))
    {
      localObject = getLuxuryGiftAdapter().getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("showAnimation  type=");
      localStringBuilder.append(paramLuxuryGiftData.giftType);
      ((LogInterface)localObject).e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
      showRichGiftAnimation(paramLuxuryGiftData);
    }
    if (paramLuxuryGiftData.consumerUin == getLuxuryGiftAdapter().getAccountUin())
    {
      getLuxuryGiftAdapter().getLogger().i("RichGiftLog", "Self Gift Play, Type=%d, Id=%d, Name=%s", new Object[] { Integer.valueOf(paramLuxuryGiftData.giftType), Integer.valueOf(paramLuxuryGiftData.giftId), paramLuxuryGiftData.giftName });
      return;
    }
    getLuxuryGiftAdapter().getLogger().i("RichGiftLog", "Broadcast Gift Play, Type=%d, Id=%d, Name=%s", new Object[] { Integer.valueOf(paramLuxuryGiftData.giftType), Integer.valueOf(paramLuxuryGiftData.giftId), paramLuxuryGiftData.giftName });
  }
  
  public void animViewReady()
  {
    if (this.mLuxuryGiftAdapter == null) {
      return;
    }
    getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "======================animViewReady-----------------", new Object[0]);
    if (this.mIsNeedShow)
    {
      LuxuryGiftController localLuxuryGiftController = this.mHonorableGiftController;
      if ((localLuxuryGiftController != null) && (localLuxuryGiftController.isGiftViewBuilded())) {
        this.mHonorableGiftController.setGiftViewVisible(true);
      }
    }
    getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "sgac - animViewReady PlayNext", new Object[0]);
    if ((this.mToPlayGiftsList.selfSize() > 0) && (!this.mToPlayGiftsList.isPrevEventSelfEvent()))
    {
      getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", " play Self", new Object[0]);
      playNext();
      return;
    }
    if (isShowingAnim()) {
      return;
    }
    getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", " play Next ", new Object[0]);
    playNext();
  }
  
  public void animationCancel()
  {
    if (this.mLuxuryGiftAdapter == null) {
      return;
    }
    getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "======================animationCancel-----------------", new Object[0]);
  }
  
  public void animationEnd()
  {
    ThreadCenter.postDelayedUITask(this, new LuxuryGiftComponentImpl.2(this), 300L);
  }
  
  public void buildRichGiftShowView()
  {
    getLuxuryGiftAdapter().getLogger().i("LuxuryGiftComponentImpl", "buildRichGiftShowView", new Object[0]);
    FrameLayout localFrameLayout = this.mRichGiftContainerView;
    if (localFrameLayout != null)
    {
      this.mHonorableGiftController.createGiftView(localFrameLayout);
      this.mHonorableGiftController.setAnimationListener(this);
    }
  }
  
  public void cancelAnimation()
  {
    this.mToPlayGiftsList.clearQueue();
    this.mHonorableGiftController.cancelAnimation();
  }
  
  public void clearLuxuryQueue() {}
  
  public void displayLuxuryGift(LuxuryGiftData paramLuxuryGiftData)
  {
    paramLuxuryGiftData.playTimeMonitor.sendTimeStamp = System.currentTimeMillis();
    this.mToPlayGiftsList.offer(paramLuxuryGiftData);
    if (this.mLuxuryGiftAdapter == null) {
      return;
    }
    if ((paramLuxuryGiftData.consumerUin == getLuxuryGiftAdapter().getAccountUin()) && (paramLuxuryGiftData.effectType != 1))
    {
      localLogInterface = getLuxuryGiftAdapter().getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" add To PlayList mySelf:");
      localStringBuilder.append(paramLuxuryGiftData.consumerUin);
      localLogInterface.e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
      paramLuxuryGiftData = this.mHonorableGiftController;
      if (paramLuxuryGiftData != null) {
        paramLuxuryGiftData.cancelAnimation();
      }
      playNext();
      return;
    }
    LogInterface localLogInterface = getLuxuryGiftAdapter().getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("t=");
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(",uin=");
    localStringBuilder.append(paramLuxuryGiftData.consumerUin);
    localStringBuilder.append(",hornorable=");
    localStringBuilder.append(this.mHonorableGiftController.isWorking());
    localLogInterface.e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
    if (!this.mHonorableGiftController.isWorking())
    {
      localLogInterface = getLuxuryGiftAdapter().getLogger();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("  isWorking= ");
      localStringBuilder.append(this.mHonorableGiftController.isWorking());
      localStringBuilder.append(",t =");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(",addToPlayList ");
      localStringBuilder.append(paramLuxuryGiftData);
      localLogInterface.e("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
      playNext();
    }
  }
  
  public LuxuryGiftAdapter getLuxuryGiftAdapter()
  {
    return this.mLuxuryGiftAdapter;
  }
  
  public UIView getView()
  {
    return null;
  }
  
  public UIViewModel getViewModel()
  {
    return null;
  }
  
  public void hideLuxuryAnimationView()
  {
    this.mIsNeedShow = false;
    LuxuryGiftController localLuxuryGiftController = this.mHonorableGiftController;
    if ((localLuxuryGiftController != null) && (localLuxuryGiftController.isGiftViewBuilded())) {
      this.mHonorableGiftController.setGiftViewVisible(false);
    }
  }
  
  public void init(LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    this.mLuxuryGiftAdapter = paramLuxuryGiftAdapter;
    this.mRichGiftContainerView = ((FrameLayout)this.mRootView);
    this.mHonorableGiftController = new LuxuryGiftController(this.mLuxuryGiftAdapter);
    this.mHonorableGiftController.setComponentImpl(this);
    this.mToPlayGiftsList = new GiftQueue(this.mLuxuryGiftAdapter);
  }
  
  public void onCreate(View paramView)
  {
    super.onCreate(paramView);
    this.mRootView = paramView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ThreadCenter.clear(this);
    ThreadCenter.clear(this.mHonorableGiftController);
    this.mLuxuryGiftAdapter = null;
    this.mHonorableGiftController.uninit();
  }
  
  public void onGetLuxuryGiftResInfoList(List<LuxuryGiftInfo> paramList)
  {
    LuxuryGiftController localLuxuryGiftController = this.mHonorableGiftController;
    if (localLuxuryGiftController != null) {
      localLuxuryGiftController.onGetLuxuryGiftResInfoList(paramList);
    }
  }
  
  public void removeOnPresentLuxuryOverListener(OnPresentLuxuryGiftOverListener paramOnPresentLuxuryGiftOverListener)
  {
    this.giftOverListeners.remove(paramOnPresentLuxuryGiftOverListener);
  }
  
  public void sendLuxuryGiftOver(OnPresentLuxuryGiftOverData paramOnPresentLuxuryGiftOverData)
  {
    Iterator localIterator = this.giftOverListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnPresentLuxuryGiftOverListener)localIterator.next()).onPresentLuxuryGiftOver(paramOnPresentLuxuryGiftOverData);
    }
  }
  
  public void setOnPresentLuxuryOverListener(OnPresentLuxuryGiftOverListener paramOnPresentLuxuryGiftOverListener)
  {
    this.giftOverListeners.add(paramOnPresentLuxuryGiftOverListener);
  }
  
  public void showAllLuxuryView()
  {
    this.mIsNeedShow = true;
    LuxuryGiftController localLuxuryGiftController = this.mHonorableGiftController;
    if ((localLuxuryGiftController != null) && (localLuxuryGiftController.isGiftViewBuilded())) {
      this.mHonorableGiftController.setGiftViewVisible(true);
    }
  }
  
  public void showLuxuryAnimationView()
  {
    this.mIsNeedShow = true;
    LuxuryGiftController localLuxuryGiftController = this.mHonorableGiftController;
    if ((localLuxuryGiftController != null) && (localLuxuryGiftController.isGiftViewBuilded())) {
      this.mHonorableGiftController.setGiftViewVisible(true);
    }
  }
  
  public void showRichGiftAnimation(LuxuryGiftData paramLuxuryGiftData)
  {
    Object localObject1 = getLuxuryGiftAdapter().getLogger();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("showRichGiftAnimation: event:");
    ((StringBuilder)localObject2).append(paramLuxuryGiftData);
    ((LogInterface)localObject1).i("LuxuryGiftComponentImpl", ((StringBuilder)localObject2).toString(), new Object[0]);
    if (paramLuxuryGiftData == null)
    {
      getLuxuryGiftAdapter().getLogger().i("LuxuryGiftComponentImpl", "exception gift == null", new Object[0]);
      return;
    }
    if (this.mRichGiftContainerView == null)
    {
      getLuxuryGiftAdapter().getLogger().i("LuxuryGiftComponentImpl", "exceptionLuxuryGiftComponentImplnot init", new Object[0]);
      return;
    }
    localObject1 = this.mHonorableGiftController;
    if ((localObject1 != null) && (((LuxuryGiftController)localObject1).isGiftViewBuilded()))
    {
      localObject1 = getLuxuryGiftAdapter().getLuxuryGiftInfo(paramLuxuryGiftData.giftType, paramLuxuryGiftData.giftId, true);
      if (localObject1 == null)
      {
        localObject1 = getLuxuryGiftAdapter().getLogger();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("!!!!!!!!!!!! showRichGiftAnimation, giftInfo is null  id=");
        ((StringBuilder)localObject2).append(paramLuxuryGiftData.giftId);
        ((LogInterface)localObject1).e("LuxuryGiftComponentImpl", ((StringBuilder)localObject2).toString(), new Object[0]);
        getLuxuryGiftAdapter().queryLuxuryGiftInfo(paramLuxuryGiftData.giftId, new LuxuryGiftComponentImpl.1(this, paramLuxuryGiftData));
        return;
      }
      localObject2 = getLuxuryGiftAdapter().getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showRichGiftAnimation: giftinfo:");
      localStringBuilder.append(localObject1);
      ((LogInterface)localObject2).i("LuxuryGiftComponentImpl", localStringBuilder.toString(), new Object[0]);
      this.mHonorableGiftController.showAnimation(constructWebGiftInfo(paramLuxuryGiftData, (LuxuryGiftInfo)localObject1), paramLuxuryGiftData);
      return;
    }
    getLuxuryGiftAdapter().getLogger().i("LuxuryGiftComponentImpl", "exceptionmRichGiftShowView not init", new Object[0]);
  }
  
  public void stopLuxuyAnimationAndHide() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.LuxuryGiftComponentImpl
 * JD-Core Version:    0.7.0.1
 */