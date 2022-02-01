package com.tencent.ilive.components.luxurygift;

import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.falco.base.libapi.datareport.DataReportInterface;
import com.tencent.falco.base.libapi.datareport.ReportTask;
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

public class LiteLuxuryGiftComponentImpl
  extends UIBaseComponent
  implements ThreadCenter.HandlerKeyable, IGiftAnimation, LuxuryGiftComponent
{
  private static final String TAG = "LuxuryGiftComponentImpl";
  private Set<OnPresentLuxuryGiftOverListener> giftOverListeners = new HashSet();
  private LuxuryGiftData mCurrentLuxuryGiftData;
  private LiteLuxuryGiftController mHonorableGiftController;
  private boolean mIsNeedShow = true;
  private LuxuryGiftAdapter mLuxuryGiftAdapter = null;
  private FrameLayout mRichGiftContainerView;
  private View mRootView;
  private GiftQueue mToPlayGiftsList;
  
  private WebGiftInfo constructWebGiftInfo(LuxuryGiftData paramLuxuryGiftData, LuxuryGiftInfo paramLuxuryGiftInfo)
  {
    WebGiftInfo localWebGiftInfo = new WebGiftInfo();
    localWebGiftInfo.uin = paramLuxuryGiftData.consumerUin;
    if (!TextUtils.isEmpty(paramLuxuryGiftData.effectId))
    {
      getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", " effectId e= " + paramLuxuryGiftData.effectId, new Object[0]);
      localWebGiftInfo.effectId = paramLuxuryGiftData.effectId;
      if (TextUtils.isEmpty(paramLuxuryGiftData.effectWord)) {
        break label263;
      }
      getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", " effectWord  e= " + paramLuxuryGiftData.effectWord, new Object[0]);
    }
    for (localWebGiftInfo.comment = paramLuxuryGiftData.effectWord;; localWebGiftInfo.comment = paramLuxuryGiftInfo.comment)
    {
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
      localWebGiftInfo.effectId = paramLuxuryGiftInfo.effectId;
      getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", " effectId g= " + paramLuxuryGiftInfo.effectId, new Object[0]);
      break;
      label263:
      getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", " comment  g= " + paramLuxuryGiftInfo.comment, new Object[0]);
    }
  }
  
  private boolean isShowingAnim()
  {
    return (this.mHonorableGiftController != null) && (this.mHonorableGiftController.isGiftViewBuilded()) && (this.mHonorableGiftController.isWorking());
  }
  
  private void playNext()
  {
    if (this.mToPlayGiftsList.size() == 0) {}
    while (this.mLuxuryGiftAdapter == null) {
      return;
    }
    getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "playNext  size=" + this.mToPlayGiftsList.size(), new Object[0]);
    LuxuryGiftData localLuxuryGiftData = this.mToPlayGiftsList.peek();
    if ((localLuxuryGiftData.giftType == 104) || (localLuxuryGiftData.giftType == 101) || (localLuxuryGiftData.giftType == 106))
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
    if ((paramLuxuryGiftData.giftType == 101) || (paramLuxuryGiftData.giftType == 106)) {
      return;
    }
    getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "sendShowGiftMsg e=" + paramLuxuryGiftData, new Object[0]);
  }
  
  private void showAnimation(LuxuryGiftData paramLuxuryGiftData)
  {
    this.mCurrentLuxuryGiftData = paramLuxuryGiftData;
    if (!UIUtil.isScreenPortrait(this.mRootView.getContext()))
    {
      getLuxuryGiftAdapter().getLogger().i("LuxuryGiftComponentImpl", " showAnimation isPortrait= " + UIUtil.isScreenPortrait(this.mRootView.getContext()), new Object[0]);
      return;
    }
    if (paramLuxuryGiftData == null)
    {
      getLuxuryGiftAdapter().getLogger().i("LuxuryGiftComponentImpl", "showAnimation: info = null.", new Object[0]);
      return;
    }
    getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "showAnimation，info.effectId=" + paramLuxuryGiftData.effectId + " info=" + paramLuxuryGiftData.consumerUin, new Object[0]);
    paramLuxuryGiftData.playTimeMonitor.waitInQueueTime = System.currentTimeMillis();
    if ((paramLuxuryGiftData.giftType == 104) || (paramLuxuryGiftData.giftType == 101))
    {
      getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "showAnimation  type=" + paramLuxuryGiftData.giftType, new Object[0]);
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
    if (this.mLuxuryGiftAdapter == null) {}
    do
    {
      return;
      getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "======================animViewReady-----------------", new Object[0]);
      ReportTask localReportTask = getLuxuryGiftAdapter().getDataReport().newTask().setPage("room_page").setPageDesc("直播/视频房间").setModule("gift_luxury_play").setModuleDesc("豪华礼物播放").setActType("success").setActTypeDesc("成功");
      if (this.mCurrentLuxuryGiftData != null) {}
      for (int i = this.mCurrentLuxuryGiftData.giftId;; i = -1)
      {
        localReportTask.addKeyValue("zt_int1", i).send();
        if ((this.mIsNeedShow) && (this.mHonorableGiftController != null) && (this.mHonorableGiftController.isGiftViewBuilded())) {
          this.mHonorableGiftController.setGiftViewVisible(true);
        }
        getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "sgac - animViewReady PlayNext", new Object[0]);
        if ((this.mToPlayGiftsList.selfSize() <= 0) || (this.mToPlayGiftsList.isPrevEventSelfEvent())) {
          break;
        }
        getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", " play Self", new Object[0]);
        playNext();
        return;
      }
    } while (isShowingAnim());
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
    ThreadCenter.postDelayedUITask(this, new LiteLuxuryGiftComponentImpl.2(this), 300L);
  }
  
  public void buildRichGiftShowView()
  {
    getLuxuryGiftAdapter().getLogger().i("LuxuryGiftComponentImpl", "buildRichGiftShowView", new Object[0]);
    if (this.mRichGiftContainerView != null)
    {
      this.mHonorableGiftController.createGiftView(this.mRichGiftContainerView);
      this.mHonorableGiftController.setAnimationListener(this);
    }
  }
  
  public void cancelAnimation() {}
  
  public void clearLuxuryQueue()
  {
    if (this.mToPlayGiftsList != null) {
      this.mToPlayGiftsList.clearQueue();
    }
  }
  
  public void displayLuxuryGift(LuxuryGiftData paramLuxuryGiftData)
  {
    this.mIsNeedShow = true;
    paramLuxuryGiftData.playTimeMonitor.sendTimeStamp = System.currentTimeMillis();
    this.mToPlayGiftsList.offer(paramLuxuryGiftData);
    if (this.mLuxuryGiftAdapter == null) {}
    do
    {
      return;
      if ((paramLuxuryGiftData.consumerUin == getLuxuryGiftAdapter().getAccountUin()) && (paramLuxuryGiftData.effectType != 1))
      {
        getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", " add To PlayList mySelf:" + paramLuxuryGiftData.consumerUin, new Object[0]);
        if (this.mHonorableGiftController != null) {
          this.mHonorableGiftController.cancelAnimation();
        }
        playNext();
        return;
      }
      getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "t=" + System.currentTimeMillis() + ",uin=" + paramLuxuryGiftData.consumerUin + ",hornorable=" + this.mHonorableGiftController.isWorking(), new Object[0]);
    } while (this.mHonorableGiftController.isWorking());
    getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "  isWorking= " + this.mHonorableGiftController.isWorking() + ",t =" + System.currentTimeMillis() + ",addToPlayList " + paramLuxuryGiftData, new Object[0]);
    playNext();
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
    if ((this.mHonorableGiftController != null) && (this.mHonorableGiftController.isGiftViewBuilded())) {
      this.mHonorableGiftController.setGiftViewVisible(false);
    }
  }
  
  public void init(LuxuryGiftAdapter paramLuxuryGiftAdapter)
  {
    this.mLuxuryGiftAdapter = paramLuxuryGiftAdapter;
    this.mRichGiftContainerView = ((FrameLayout)this.mRootView);
    this.mHonorableGiftController = new LiteLuxuryGiftController(this.mLuxuryGiftAdapter);
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
  }
  
  public void onGetLuxuryGiftResInfoList(List<LuxuryGiftInfo> paramList)
  {
    if (this.mHonorableGiftController != null) {
      this.mHonorableGiftController.onGetLuxuryGiftResInfoList(paramList);
    }
  }
  
  public void onPlayError(int paramInt)
  {
    ReportTask localReportTask = getLuxuryGiftAdapter().getDataReport().newTask().setPage("room_page").setPageDesc("直播/视频房间").setModule("gift_luxury_play").setModuleDesc("豪华礼物播放").setActType("failure").setActTypeDesc("failure");
    if (this.mCurrentLuxuryGiftData != null) {}
    for (int i = this.mCurrentLuxuryGiftData.giftId;; i = -1)
    {
      localReportTask.addKeyValue("zt_int1", i).addKeyValue("zt_int2", paramInt).send();
      return;
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
    if ((this.mHonorableGiftController != null) && (this.mHonorableGiftController.isGiftViewBuilded())) {
      this.mHonorableGiftController.setGiftViewVisible(true);
    }
  }
  
  public void showLuxuryAnimationView()
  {
    this.mIsNeedShow = true;
    if ((this.mHonorableGiftController != null) && (this.mHonorableGiftController.isGiftViewBuilded())) {
      this.mHonorableGiftController.setGiftViewVisible(true);
    }
  }
  
  public void showRichGiftAnimation(LuxuryGiftData paramLuxuryGiftData)
  {
    getLuxuryGiftAdapter().getLogger().i("LuxuryGiftComponentImpl", "showRichGiftAnimation: event:" + paramLuxuryGiftData, new Object[0]);
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
    if ((this.mHonorableGiftController == null) || (!this.mHonorableGiftController.isGiftViewBuilded()))
    {
      getLuxuryGiftAdapter().getLogger().i("LuxuryGiftComponentImpl", "exceptionmRichGiftShowView not init", new Object[0]);
      return;
    }
    LuxuryGiftInfo localLuxuryGiftInfo = getLuxuryGiftAdapter().getLuxuryGiftInfo(paramLuxuryGiftData.giftType, paramLuxuryGiftData.giftId, true);
    if (localLuxuryGiftInfo == null)
    {
      getLuxuryGiftAdapter().getLogger().e("LuxuryGiftComponentImpl", "!!!!!!!!!!!! showRichGiftAnimation, giftInfo is null  id=" + paramLuxuryGiftData.giftId, new Object[0]);
      getLuxuryGiftAdapter().queryLuxuryGiftInfo(paramLuxuryGiftData.giftId, new LiteLuxuryGiftComponentImpl.1(this, paramLuxuryGiftData));
      return;
    }
    getLuxuryGiftAdapter().getLogger().i("LuxuryGiftComponentImpl", "showRichGiftAnimation: giftinfo:" + localLuxuryGiftInfo, new Object[0]);
    this.mHonorableGiftController.showAnimation(constructWebGiftInfo(paramLuxuryGiftData, localLuxuryGiftInfo), paramLuxuryGiftData);
  }
  
  public void stopLuxuyAnimationAndHide()
  {
    if (this.mHonorableGiftController != null) {
      this.mHonorableGiftController.cancelAnimation();
    }
    hideLuxuryAnimationView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.components.luxurygift.LiteLuxuryGiftComponentImpl
 * JD-Core Version:    0.7.0.1
 */