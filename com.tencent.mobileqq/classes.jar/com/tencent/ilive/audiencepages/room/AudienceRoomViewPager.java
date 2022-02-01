package com.tencent.ilive.audiencepages.room;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.audiencepages.room.pagelogic.AudienceMultiRoomPageLogic;
import com.tencent.ilive.audiencepages.room.pagelogic.widgets.SwitchRoomAdapter;
import com.tencent.ilive.audiencepages.room.roomconfig.AudienceBaseBootModules;
import com.tencent.ilive.base.bizmodule.BootBizModules;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.base.page.PageListener;
import com.tencent.ilive.base.page.fragment.LiveTemplateFragment;
import com.tencent.ilive.commonpages.room.VerticalViewPager;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.RoomPageActionInterface;
import com.tencent.ilive.pages.room.events.FirstFrameEvent;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.livesdk.liveengine.FloatRoomManager;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;

public class AudienceRoomViewPager
  extends VerticalViewPager
{
  private final String TAG = "AudienceRoomViewPager";
  private AudienceMultiRoomPageLogic audienceRoomPageLogic;
  private long curRoomID = -1L;
  private String curVid = "";
  protected AudienceRoomFragment currentFragment;
  private boolean hasFirstRequestList = false;
  private boolean haveSlide = false;
  private boolean isFragmentChange = false;
  private boolean isLandScape = false;
  private boolean isNewIntent = false;
  private LogInterface logInterface;
  private FragmentActivity mActivity;
  private AudienceRoomPagerImpl mAudienceRoomPager;
  private Intent mIntent;
  private int mLastIndex = 0;
  protected PageListener mPageListener = new AudienceRoomViewPager.2(this);
  private RoomPageActionInterface mRoomPageActionInterface;
  private long meetTopAndBottomTime = 0L;
  Runnable queryRoomListRunnable = new AudienceRoomViewPager.1(this);
  private int scrollDirection = 0;
  private int scrollState = 0;
  private SwitchRoomAdapter switchRoomAdapter = null;
  
  public AudienceRoomViewPager(Context paramContext)
  {
    super(paramContext);
    this.mActivity = ((FragmentActivity)paramContext);
  }
  
  public AudienceRoomViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mActivity = ((FragmentActivity)paramContext);
  }
  
  private void firstQueryAndUpdateRoomList()
  {
    if (!this.hasFirstRequestList)
    {
      SwitchRoomAdapter localSwitchRoomAdapter = this.switchRoomAdapter;
      if (localSwitchRoomAdapter != null)
      {
        localSwitchRoomAdapter.queryAndUpdateRoomListFromServer(this.scrollDirection, 0);
        this.hasFirstRequestList = true;
      }
    }
  }
  
  private void notifyReachTopOrBottom(int paramInt)
  {
    LogInterface localLogInterface = this.logInterface;
    if (localLogInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyReachTopOrBottom direction = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" haveSlide = ");
      localStringBuilder.append(this.haveSlide);
      localLogInterface.i("AudienceRoomViewPager", localStringBuilder.toString(), new Object[0]);
    }
    if ((this.mRoomPageActionInterface != null) && (System.currentTimeMillis() - this.meetTopAndBottomTime > 2000L) && (this.haveSlide))
    {
      getRoomPageAction().onScrollTopOrBottom(paramInt);
      this.meetTopAndBottomTime = System.currentTimeMillis();
    }
  }
  
  private void onFragmentCreateFinish()
  {
    Object localObject = this.logInterface;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("activity--onFragmentCreateFinish--mLastIndex=");
      localStringBuilder.append(this.mLastIndex);
      ((LogInterface)localObject).i("AudienceTime", localStringBuilder.toString(), new Object[0]);
    }
    if ((this.mLastIndex == 0) && (!this.hasFirstRequestList))
    {
      this.currentFragment.getBootBizModules().getModuleEvent().observe(FirstFrameEvent.class, new AudienceRoomViewPager.4(this));
      ThreadCenter.postDefaultUITask(this.queryRoomListRunnable, 2000L);
    }
    else
    {
      localObject = this.logInterface;
      if (localObject != null) {
        ((LogInterface)localObject).i("AudienceTime", "activity--switch--room--start query switch list", new Object[0]);
      }
      localObject = this.switchRoomAdapter;
      if (localObject != null) {
        ((SwitchRoomAdapter)localObject).queryAndUpdateRoomListFromServer(this.scrollDirection, this.mLastIndex);
      }
    }
    localObject = this.audienceRoomPageLogic;
    if (localObject != null)
    {
      if (!this.isFragmentChange)
      {
        ((AudienceMultiRoomPageLogic)localObject).onCreate();
        this.isFragmentChange = true;
        return;
      }
      ((AudienceMultiRoomPageLogic)localObject).onSwitchFragment();
    }
  }
  
  private void setLandScape(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--setLandScape--isLandScape=");
    ((StringBuilder)localObject).append(paramBoolean);
    Log.i("AudienceRoomViewPager", ((StringBuilder)localObject).toString());
    setScrollForbidden(paramBoolean);
    localObject = this.audienceRoomPageLogic;
    if (localObject != null) {
      ((AudienceMultiRoomPageLogic)localObject).onLandscape(paramBoolean);
    }
  }
  
  public void finish() {}
  
  public LiveTemplateFragment getCurrentFragment()
  {
    return this.currentFragment;
  }
  
  public Intent getIntent()
  {
    return this.mIntent;
  }
  
  public int getLastIndex()
  {
    return this.mLastIndex;
  }
  
  public RoomPageActionInterface getRoomPageAction()
  {
    return this.mRoomPageActionInterface;
  }
  
  public int getScrollDirection()
  {
    return this.scrollDirection;
  }
  
  public int getScrollState()
  {
    return this.scrollState;
  }
  
  public void initRoomPageAction(RoomPageActionInterface paramRoomPageActionInterface)
  {
    this.mRoomPageActionInterface = paramRoomPageActionInterface;
  }
  
  public void onBackPressed()
  {
    Object localObject = this.currentFragment;
    if (localObject != null) {
      ((AudienceRoomFragment)localObject).onBackPressed();
    }
    localObject = this.audienceRoomPageLogic;
    if (localObject != null) {
      ((AudienceMultiRoomPageLogic)localObject).onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Object localObject = this.logInterface;
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onConfigurationChanged--orientation=");
      localStringBuilder.append(paramConfiguration.orientation);
      ((LogInterface)localObject).i("AudienceRoomViewPager", localStringBuilder.toString(), new Object[0]);
    }
    if (paramConfiguration.orientation == 2)
    {
      Log.i("AudienceRoomViewPager", "going to landscape");
      this.isLandScape = true;
    }
    else if (paramConfiguration.orientation == 1)
    {
      Log.i("AudienceRoomViewPager", "going to portrait");
      this.isLandScape = false;
      UIUtil.setFullscreen(this.mActivity, true, true);
    }
    localObject = this.currentFragment;
    if (localObject == null) {
      return;
    }
    localObject = (AudienceBaseBootModules)((AudienceRoomFragment)localObject).getBootBizModules();
    if (localObject != null)
    {
      ((AudienceBaseBootModules)localObject).onSwitchScreen(this.isLandScape);
      ((AudienceBaseBootModules)localObject).clearEvent();
    }
    setLandScape(this.isLandScape);
    super.onConfigurationChanged(paramConfiguration);
    if (localObject != null) {
      ((AudienceBaseBootModules)localObject).onCreateNormalBizModules(this.isLandScape);
    }
  }
  
  public void onCreate()
  {
    BizEngineMgr.getInstance().getLiveEngine().getFloatRoomManager().g();
    this.mAudienceRoomPager = new AudienceRoomPagerImpl(this);
    this.mActivity.getWindow().addFlags(128);
    this.logInterface = ((LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class));
    this.switchRoomAdapter = new SwitchRoomAdapter(this.mActivity.getSupportFragmentManager(), getIntent(), this.mAudienceRoomPager);
    this.currentFragment = this.switchRoomAdapter.getCurrentFragment();
    this.currentFragment.setPageListener(this.mPageListener);
    Object localObject = this.currentFragment.getRoomEngine();
    BizEngineMgr.getInstance().setCurrentRoomEngine((RoomEngine)localObject);
    this.audienceRoomPageLogic = new AudienceMultiRoomPageLogic(getContext(), this.mAudienceRoomPager, this.mRoomPageActionInterface);
    this.audienceRoomPageLogic.setRoomEngine((RoomEngine)localObject);
    this.audienceRoomPageLogic.initAction();
    setOffscreenPageLimit(1);
    setAdapter(this.switchRoomAdapter);
    localObject = this.mIntent;
    if (localObject != null) {
      this.curRoomID = ((Intent)localObject).getLongExtra("roomid", -1L);
    }
    setOnPageChangeListener(new AudienceRoomViewPager.3(this));
  }
  
  public void onDestroy()
  {
    ThreadCenter.removeDefaultUITask(this.queryRoomListRunnable);
    Object localObject = this.audienceRoomPageLogic;
    if (localObject != null) {
      ((AudienceMultiRoomPageLogic)localObject).onDestroy();
    }
    localObject = this.switchRoomAdapter;
    if (localObject != null) {
      ((SwitchRoomAdapter)localObject).onDestroy();
    }
    localObject = this.mAudienceRoomPager;
    if (localObject != null) {
      ((AudienceRoomPagerImpl)localObject).onDestroy();
    }
  }
  
  public void onDestroyViewPager()
  {
    SwitchRoomAdapter localSwitchRoomAdapter = this.switchRoomAdapter;
    if (localSwitchRoomAdapter != null) {
      localSwitchRoomAdapter.onDestroyViewPagerList();
    }
  }
  
  public void onExtActive()
  {
    AudienceRoomFragment localAudienceRoomFragment = this.currentFragment;
    if ((localAudienceRoomFragment != null) && (localAudienceRoomFragment.getBootBizModules() != null)) {
      this.currentFragment.getBootBizModules().onExtActive();
    }
  }
  
  public void onExtDeActive()
  {
    AudienceRoomFragment localAudienceRoomFragment = this.currentFragment;
    if ((localAudienceRoomFragment != null) && (localAudienceRoomFragment.getBootBizModules() != null)) {
      this.currentFragment.getBootBizModules().onExtDeActive();
    }
  }
  
  public void onExtOnStart()
  {
    AudienceRoomFragment localAudienceRoomFragment = this.currentFragment;
    if ((localAudienceRoomFragment != null) && (localAudienceRoomFragment.getBootBizModules() != null)) {
      this.currentFragment.getBootBizModules().onExtOnStart();
    }
  }
  
  public void onExtOnStop()
  {
    AudienceRoomFragment localAudienceRoomFragment = this.currentFragment;
    if ((localAudienceRoomFragment != null) && (localAudienceRoomFragment.getBootBizModules() != null)) {
      this.currentFragment.getBootBizModules().onExtOnStop();
    }
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    this.isNewIntent = true;
    this.scrollDirection = 0;
    long l = paramIntent.getLongExtra("roomid", -1L);
    Object localObject1 = paramIntent.getStringExtra("video_id");
    int i = paramIntent.getIntExtra("video_format", 1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onNewIntent--newRoomId=");
    ((StringBuilder)localObject2).append(l);
    ((StringBuilder)localObject2).append(";curRoomID=");
    ((StringBuilder)localObject2).append(this.curRoomID);
    Log.i("AudienceRoomViewPager", ((StringBuilder)localObject2).toString());
    if (i == 3)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!((String)localObject1).equals(this.curVid))) {}
    }
    else
    {
      if (l <= 0L) {
        return;
      }
      if (l == this.curRoomID) {
        return;
      }
    }
    if (this.switchRoomAdapter == null)
    {
      paramIntent = this.logInterface;
      if (paramIntent != null) {
        paramIntent.e("AudienceRoomViewPager", "onNewIntent--switchRoomAdapter is null", new Object[0]);
      }
      return;
    }
    this.curRoomID = l;
    this.curVid = ((String)localObject1);
    localObject2 = new SwitchRoomInfo();
    ((SwitchRoomInfo)localObject2).roomId = paramIntent.getLongExtra("roomid", 0L);
    ((SwitchRoomInfo)localObject2).videoUrl = paramIntent.getStringExtra("video_url");
    ((SwitchRoomInfo)localObject2).extData = paramIntent.getBundleExtra("biz_ext_data");
    ((SwitchRoomInfo)localObject2).videoLevel = paramIntent.getIntExtra("video_level", -1);
    ((SwitchRoomInfo)localObject2).videoIsOrigin = paramIntent.getBooleanExtra("video_is_origin", false);
    if (i == 3) {
      localObject1 = VideoType.VIDEO;
    } else {
      localObject1 = VideoType.LIVE;
    }
    ((SwitchRoomInfo)localObject2).videoType = ((VideoType)localObject1);
    ((SwitchRoomInfo)localObject2).videoId = paramIntent.getStringExtra("video_id");
    this.currentFragment = this.switchRoomAdapter.openNewRoom((SwitchRoomInfo)localObject2);
    this.audienceRoomPageLogic.onSwitchRoomBefore((SwitchRoomInfo)localObject2, this.currentFragment);
    this.audienceRoomPageLogic.exitRoom();
    paramIntent = this.currentFragment.getRoomEngine();
    BizEngineMgr.getInstance().setCurrentRoomEngine(paramIntent);
    this.audienceRoomPageLogic.setRoomEngine(paramIntent);
    this.audienceRoomPageLogic.onSwitchRoomAfter((SwitchRoomInfo)localObject2);
    this.mPageListener.onFragmentCreated();
    this.isNewIntent = false;
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    LogInterface localLogInterface = this.logInterface;
    if (localLogInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onOverScrolled onOverScrolled scrollX = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" scrollY = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" clampedX = ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(" clampedY = ");
      localStringBuilder.append(paramBoolean2);
      localLogInterface.i("brucelxhu", localStringBuilder.toString(), new Object[0]);
    }
  }
  
  public void onPause()
  {
    AudienceMultiRoomPageLogic localAudienceMultiRoomPageLogic = this.audienceRoomPageLogic;
    if (localAudienceMultiRoomPageLogic != null) {
      localAudienceMultiRoomPageLogic.onPause();
    }
  }
  
  public void onResume()
  {
    AudienceMultiRoomPageLogic localAudienceMultiRoomPageLogic = this.audienceRoomPageLogic;
    if (localAudienceMultiRoomPageLogic != null) {
      localAudienceMultiRoomPageLogic.onResume();
    }
  }
  
  public void onStart()
  {
    AudienceMultiRoomPageLogic localAudienceMultiRoomPageLogic = this.audienceRoomPageLogic;
    if (localAudienceMultiRoomPageLogic != null) {
      localAudienceMultiRoomPageLogic.onStart();
    }
  }
  
  public void onStop()
  {
    AudienceMultiRoomPageLogic localAudienceMultiRoomPageLogic = this.audienceRoomPageLogic;
    if (localAudienceMultiRoomPageLogic != null) {
      localAudienceMultiRoomPageLogic.onStop();
    }
  }
  
  public void populate(int paramInt)
  {
    try
    {
      super.populate(paramInt);
      return;
    }
    catch (Exception localException)
    {
      LogInterface localLogInterface = this.logInterface;
      if (localLogInterface != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("populate ex = ");
        localStringBuilder.append(localException);
        localLogInterface.i("AudienceRoomViewPager", localStringBuilder.toString(), new Object[0]);
      }
      FragmentActivity localFragmentActivity = this.mActivity;
      if (localFragmentActivity != null) {
        localFragmentActivity.finish();
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    LogInterface localLogInterface = this.logInterface;
    if (localLogInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCurrentItem scrollForbidden = ");
      localStringBuilder.append(this.scrollForbidden);
      localLogInterface.i("AudienceRoomViewPager", localStringBuilder.toString(), new Object[0]);
    }
    if (this.scrollForbidden) {
      return;
    }
    super.setCurrentItem(paramInt);
  }
  
  public void setIntent(Intent paramIntent)
  {
    this.mIntent = paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.AudienceRoomViewPager
 * JD-Core Version:    0.7.0.1
 */