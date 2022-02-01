package com.tencent.ilive.audiencepages.room;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
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
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;

public class AudienceRoomViewPager
  extends VerticalViewPager
{
  private final String TAG = "AudienceRoomViewPager";
  private AudienceMultiRoomPageLogic audienceRoomPageLogic;
  private long curRoomID = -1L;
  private String curVid = "";
  protected LiveTemplateFragment currentFragment;
  private boolean hasFirstRequestList = false;
  private boolean haveSlide = false;
  private boolean isFragmentChange = false;
  private boolean isLandScape = false;
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
    if ((!this.hasFirstRequestList) && (this.switchRoomAdapter != null))
    {
      this.switchRoomAdapter.queryAndUpdateRoomListFromServer(this.scrollDirection, 0);
      this.hasFirstRequestList = true;
    }
  }
  
  private void notifyReachTopOrBottom(int paramInt)
  {
    if (this.logInterface != null) {
      this.logInterface.i("AudienceRoomViewPager", "notifyReachTopOrBottom direction = " + paramInt + " haveSlide = " + this.haveSlide, new Object[0]);
    }
    if ((this.mRoomPageActionInterface != null) && (System.currentTimeMillis() - this.meetTopAndBottomTime > 2000L) && (this.haveSlide))
    {
      getRoomPageAction().onScrollTopOrBottom(paramInt);
      this.meetTopAndBottomTime = System.currentTimeMillis();
    }
  }
  
  private void onFragmentCreateFinish()
  {
    if (this.logInterface != null) {
      this.logInterface.i("AudienceTime", "activity--onFragmentCreateFinish--mLastIndex=" + this.mLastIndex, new Object[0]);
    }
    if ((this.mLastIndex == 0) && (!this.hasFirstRequestList))
    {
      this.currentFragment.getBootBizModules().getModuleEvent().observe(FirstFrameEvent.class, new AudienceRoomViewPager.4(this));
      ThreadCenter.postDefaultUITask(this.queryRoomListRunnable, 2000L);
    }
    for (;;)
    {
      if (this.audienceRoomPageLogic != null)
      {
        if (this.isFragmentChange) {
          break;
        }
        this.audienceRoomPageLogic.onCreate();
        this.isFragmentChange = true;
      }
      return;
      if (this.logInterface != null) {
        this.logInterface.i("AudienceTime", "activity--switch--room--start query switch list", new Object[0]);
      }
      if (this.switchRoomAdapter != null) {
        this.switchRoomAdapter.queryAndUpdateRoomListFromServer(this.scrollDirection, this.mLastIndex);
      }
    }
    this.audienceRoomPageLogic.onSwitchFragment();
  }
  
  private void setLandScape(boolean paramBoolean)
  {
    Log.i("AudienceRoomViewPager", "--setLandScape--isLandScape=" + paramBoolean);
    setScrollForbidden(paramBoolean);
    if (this.audienceRoomPageLogic != null) {
      this.audienceRoomPageLogic.onLandscape(paramBoolean);
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
    if (this.currentFragment != null) {
      this.currentFragment.onBackPressed();
    }
    if (this.audienceRoomPageLogic != null) {
      this.audienceRoomPageLogic.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.logInterface != null) {
      this.logInterface.i("AudienceRoomViewPager", "onConfigurationChanged--orientation=" + paramConfiguration.orientation, new Object[0]);
    }
    if (paramConfiguration.orientation == 2)
    {
      Log.i("AudienceRoomViewPager", "going to landscape");
      this.isLandScape = true;
    }
    AudienceBaseBootModules localAudienceBaseBootModules;
    do
    {
      while (this.currentFragment == null)
      {
        return;
        if (paramConfiguration.orientation == 1)
        {
          Log.i("AudienceRoomViewPager", "going to portrait");
          this.isLandScape = false;
          UIUtil.setFullscreen(this.mActivity, true, true);
        }
      }
      localAudienceBaseBootModules = (AudienceBaseBootModules)this.currentFragment.getBootBizModules();
      if (localAudienceBaseBootModules != null)
      {
        localAudienceBaseBootModules.onSwitchScreen(this.isLandScape);
        localAudienceBaseBootModules.clearEvent();
      }
      setLandScape(this.isLandScape);
      super.onConfigurationChanged(paramConfiguration);
    } while (localAudienceBaseBootModules == null);
    localAudienceBaseBootModules.onCreateNormalBizModules(this.isLandScape);
  }
  
  public void onCreate()
  {
    this.mAudienceRoomPager = new AudienceRoomPagerImpl(this);
    this.mActivity.getWindow().addFlags(128);
    this.logInterface = ((LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class));
    this.switchRoomAdapter = new SwitchRoomAdapter(this.mActivity.getSupportFragmentManager(), getIntent(), this.mAudienceRoomPager);
    this.currentFragment = this.switchRoomAdapter.getCurrentFragment();
    this.currentFragment.setPageListener(this.mPageListener);
    RoomEngine localRoomEngine = ((AudienceRoomFragment)this.currentFragment).getRoomEngine();
    BizEngineMgr.getInstance().setCurrentRoomEngine(localRoomEngine);
    this.audienceRoomPageLogic = new AudienceMultiRoomPageLogic(getContext(), this.mAudienceRoomPager, this.mRoomPageActionInterface);
    this.audienceRoomPageLogic.setRoomEngine(localRoomEngine);
    this.audienceRoomPageLogic.initAction();
    setOffscreenPageLimit(1);
    setAdapter(this.switchRoomAdapter);
    if (this.mIntent != null) {
      this.curRoomID = this.mIntent.getLongExtra("roomid", -1L);
    }
    setOnPageChangeListener(new AudienceRoomViewPager.3(this));
  }
  
  public void onDestroy()
  {
    ThreadCenter.removeDefaultUITask(this.queryRoomListRunnable);
    if (this.audienceRoomPageLogic != null) {
      this.audienceRoomPageLogic.onDestroy();
    }
    if (this.switchRoomAdapter != null) {
      this.switchRoomAdapter.onDestroy();
    }
    if (this.mAudienceRoomPager != null) {
      this.mAudienceRoomPager.onDestroy();
    }
  }
  
  public void onDestroyViewPager()
  {
    if (this.switchRoomAdapter != null) {
      this.switchRoomAdapter.onDestroyViewPagerList();
    }
  }
  
  public void onExtActive()
  {
    if ((this.currentFragment != null) && (this.currentFragment.getBootBizModules() != null)) {
      this.currentFragment.getBootBizModules().onExtActive();
    }
  }
  
  public void onExtDeActive()
  {
    if ((this.currentFragment != null) && (this.currentFragment.getBootBizModules() != null)) {
      this.currentFragment.getBootBizModules().onExtDeActive();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.scrollForbidden) {
      return false;
    }
    try
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("roomid", -1L);
    Object localObject = paramIntent.getStringExtra("video_id");
    int i = paramIntent.getIntExtra("video_format", 1);
    Log.i("AudienceRoomViewPager", "onNewIntent--newRoomId=" + l + ";curRoomID=" + this.curRoomID);
    if (i == 3) {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals(this.curVid))) {
        break label109;
      }
    }
    label109:
    do
    {
      do
      {
        return;
      } while ((l <= 0L) || (l == this.curRoomID));
      if (this.switchRoomAdapter != null) {
        break;
      }
    } while (this.logInterface == null);
    this.logInterface.e("AudienceRoomViewPager", "onNewIntent--switchRoomAdapter is null", new Object[0]);
    return;
    this.curRoomID = l;
    this.curVid = ((String)localObject);
    SwitchRoomInfo localSwitchRoomInfo = new SwitchRoomInfo();
    localSwitchRoomInfo.roomId = paramIntent.getLongExtra("roomid", 0L);
    localSwitchRoomInfo.videoUrl = paramIntent.getStringExtra("video_url");
    localSwitchRoomInfo.extData = paramIntent.getBundleExtra("biz_ext_data");
    localSwitchRoomInfo.videoLevel = paramIntent.getIntExtra("video_level", -1);
    localSwitchRoomInfo.videoIsOrigin = paramIntent.getBooleanExtra("video_is_origin", false);
    if (i == 3) {}
    for (localObject = VideoType.VIDEO;; localObject = VideoType.LIVE)
    {
      localSwitchRoomInfo.videoType = ((VideoType)localObject);
      localSwitchRoomInfo.videoId = paramIntent.getStringExtra("video_id");
      this.currentFragment = this.switchRoomAdapter.openNewRoom(localSwitchRoomInfo);
      this.audienceRoomPageLogic.onSwitchRoomBefore(localSwitchRoomInfo, (AudienceRoomFragment)this.currentFragment);
      paramIntent = ((AudienceRoomFragment)this.currentFragment).getRoomEngine();
      BizEngineMgr.getInstance().setCurrentRoomEngine(paramIntent);
      this.audienceRoomPageLogic.setRoomEngine(paramIntent);
      this.audienceRoomPageLogic.onSwitchRoomAfter(localSwitchRoomInfo);
      this.mPageListener.onFragmentCreated();
      return;
    }
  }
  
  public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    if (this.logInterface != null) {
      this.logInterface.i("brucelxhu", "onOverScrolled onOverScrolled scrollX = " + paramInt1 + " scrollY = " + paramInt2 + " clampedX = " + paramBoolean1 + " clampedY = " + paramBoolean2, new Object[0]);
    }
    if ((paramBoolean2) && (paramInt2 > 0)) {}
  }
  
  public void onPause()
  {
    if (this.audienceRoomPageLogic != null) {
      this.audienceRoomPageLogic.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.audienceRoomPageLogic != null) {
      this.audienceRoomPageLogic.onResume();
    }
  }
  
  public void onStart()
  {
    if (this.audienceRoomPageLogic != null) {
      this.audienceRoomPageLogic.onStart();
    }
  }
  
  public void onStop()
  {
    if (this.audienceRoomPageLogic != null) {
      this.audienceRoomPageLogic.onStop();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.scrollForbidden) {
      return false;
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  public void setCurrentItem(int paramInt)
  {
    if (this.logInterface != null) {
      this.logInterface.i("AudienceRoomViewPager", "setCurrentItem scrollForbidden = " + this.scrollForbidden, new Object[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.AudienceRoomViewPager
 * JD-Core Version:    0.7.0.1
 */