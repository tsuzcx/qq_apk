package com.tencent.ilive.audiencepages.room.pagelogic.widgets;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilive.audiencepages.room.AudienceRoomFragment;
import com.tencent.ilive.base.bizmodule.BootBizModules;
import com.tencent.ilive.base.component.ComponentFactory;
import com.tencent.ilive.base.page.PageFactory;
import com.tencent.ilive.base.page.PageType;
import com.tencent.ilive.config.PageConfigInterface;
import com.tencent.ilive.enginemanager.BizEngineMgr;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface.QueryRoomListTrigger;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;
import com.tencent.livesdk.accountengine.UserEngine;
import com.tencent.livesdk.liveengine.LiveEngine;
import com.tencent.livesdk.roomengine.RoomEngine;
import java.util.ArrayList;
import java.util.List;

public class SwitchRoomAdapter
  extends FragmentStatePagerAdapter
{
  public static final String TAG = "SwitchRoomAdapter";
  private SparseArray<AudienceRoomFragment> audienceRoomFragmentSparseArray = new SparseArray();
  private AudienceRoomFragment currentFragment = null;
  private IAudienceRoomPager mAudienceRoomPager;
  private int mPageType;
  public RoomSwitchInterface.QueryRoomListTrigger mQueryRoomListTrigger = new SwitchRoomAdapter.1(this);
  private String mSource = "";
  private List<SwitchRoomInfo> switchRoomInfoList = new ArrayList();
  
  public SwitchRoomAdapter(FragmentManager paramFragmentManager, Intent paramIntent, IAudienceRoomPager paramIAudienceRoomPager)
  {
    super(paramFragmentManager);
    this.mAudienceRoomPager = paramIAudienceRoomPager;
    this.mPageType = paramIntent.getIntExtra("page_type", PageType.LIVE_ROOM_AUDIENCE.value);
    long l = paramIntent.getLongExtra("roomid", -1L);
    paramIAudienceRoomPager = new SwitchRoomInfo();
    paramIAudienceRoomPager.roomId = l;
    paramIAudienceRoomPager.videoUrl = paramIntent.getStringExtra("video_url");
    paramIAudienceRoomPager.extData = paramIntent.getBundleExtra("biz_ext_data");
    paramIAudienceRoomPager.videoLevel = paramIntent.getIntExtra("video_level", -1);
    paramIAudienceRoomPager.videoIsOrigin = paramIntent.getBooleanExtra("video_is_origin", false);
    if (paramIntent.getIntExtra("video_format", 1) == 3) {
      paramFragmentManager = VideoType.VIDEO;
    } else {
      paramFragmentManager = VideoType.LIVE;
    }
    paramIAudienceRoomPager.videoType = paramFragmentManager;
    paramIAudienceRoomPager.videoId = paramIntent.getStringExtra("video_id");
    paramIAudienceRoomPager.coverBitmapBytes = paramIntent.getByteArrayExtra("cover_bitmap");
    this.switchRoomInfoList.add(paramIAudienceRoomPager);
    this.audienceRoomFragmentSparseArray.put(0, createFragment(0));
    this.mSource = ((AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class)).getSource();
  }
  
  private AudienceRoomFragment createFragment(int paramInt)
  {
    RoomEngine localRoomEngine = BizEngineMgr.getInstance().getUserEngine().createRoomEngine();
    Object localObject1 = (RoomSwitchInterface)localRoomEngine.getService(RoomSwitchInterface.class);
    if (localObject1 != null) {
      ((RoomSwitchInterface)localObject1).setQueryRoomListTrigger(this.mQueryRoomListTrigger);
    }
    localObject1 = (AudienceRoomFragment)PageFactory.createFragment(this.mPageType, null);
    Object localObject2 = ((AudienceRoomFragment)localObject1).getPageUIConfig();
    ((AudienceRoomFragment)localObject1).getComponentFactory().addConfig(((PageConfigInterface)localObject2).createComponentConfig(false), localRoomEngine);
    localObject2 = new Bundle();
    SwitchRoomInfo localSwitchRoomInfo = (SwitchRoomInfo)this.switchRoomInfoList.get(paramInt);
    ((Bundle)localObject2).putLong("roomid", localSwitchRoomInfo.roomId);
    ((Bundle)localObject2).putString("source", this.mSource);
    ((Bundle)localObject2).putString("program_id", "0");
    ((Bundle)localObject2).putString("video_url", localSwitchRoomInfo.videoUrl);
    ((Bundle)localObject2).putInt("video_format", localSwitchRoomInfo.videoType.ordinal());
    ((Bundle)localObject2).putInt("modules_index", paramInt);
    ((Bundle)localObject2).putString("video_id", localSwitchRoomInfo.videoId);
    ((Bundle)localObject2).putBundle("biz_ext_data", localSwitchRoomInfo.extData);
    ((Bundle)localObject2).putByteArray("cover_bitmap", localSwitchRoomInfo.coverBitmapBytes);
    ((AudienceRoomFragment)localObject1).setArguments((Bundle)localObject2);
    ((AudienceRoomFragment)localObject1).setRoomEngine(localRoomEngine);
    ((AudienceRoomFragment)localObject1).setAudienceRoomPager(this.mAudienceRoomPager);
    return localObject1;
  }
  
  public void destroyItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    super.destroyItem(paramViewGroup, paramInt, paramObject);
    ((AudienceRoomFragment)paramObject).setForceUpdate(true);
    this.audienceRoomFragmentSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.switchRoomInfoList.size();
  }
  
  public AudienceRoomFragment getCurrentFragment()
  {
    AudienceRoomFragment localAudienceRoomFragment2 = this.currentFragment;
    AudienceRoomFragment localAudienceRoomFragment1 = localAudienceRoomFragment2;
    if (localAudienceRoomFragment2 == null) {
      localAudienceRoomFragment1 = (AudienceRoomFragment)this.audienceRoomFragmentSparseArray.get(0);
    }
    return localAudienceRoomFragment1;
  }
  
  public Fragment getItem(int paramInt)
  {
    if (this.audienceRoomFragmentSparseArray.get(paramInt) == null) {
      return createFragment(paramInt);
    }
    return (AudienceRoomFragment)this.audienceRoomFragmentSparseArray.get(paramInt);
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (AudienceRoomFragment)paramObject;
    if (paramObject.isForceUpdate()) {
      return -2;
    }
    paramObject = (RoomBizContext)paramObject.getBootBizModules().getBizModuleContext();
    int i = paramObject.getEnterRoomInfo().bootModulesIndex;
    if ((i == this.mAudienceRoomPager.getLastIndex() + 1) && (i < this.switchRoomInfoList.size()))
    {
      paramObject = ((SwitchRoomInfo)this.switchRoomInfoList.get(paramObject.getEnterRoomInfo().bootModulesIndex)).extData;
      if ((paramObject != null) && (paramObject.getBoolean("force_update")))
      {
        paramObject.putBoolean("force_update", false);
        return -2;
      }
    }
    return -1;
  }
  
  public SwitchRoomInfo getSwitchRoomInfo(int paramInt)
  {
    return (SwitchRoomInfo)this.switchRoomInfoList.get(paramInt);
  }
  
  @NonNull
  public Object instantiateItem(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = (AudienceRoomFragment)super.instantiateItem(paramViewGroup, paramInt);
    this.audienceRoomFragmentSparseArray.put(paramInt, paramViewGroup);
    return paramViewGroup;
  }
  
  public void onDestroy() {}
  
  public void onDestroyViewPagerList()
  {
    int i = 0;
    while (i < this.audienceRoomFragmentSparseArray.size())
    {
      AudienceRoomFragment localAudienceRoomFragment = (AudienceRoomFragment)this.audienceRoomFragmentSparseArray.valueAt(i);
      localAudienceRoomFragment.setForceUpdate(true);
      localAudienceRoomFragment.setAudienceRoomPager(null);
      i += 1;
    }
    this.switchRoomInfoList.clear();
    notifyDataSetChanged();
    this.audienceRoomFragmentSparseArray.clear();
    this.currentFragment = null;
  }
  
  public AudienceRoomFragment openNewRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    int i = 0;
    while (i < this.audienceRoomFragmentSparseArray.size())
    {
      ((AudienceRoomFragment)this.audienceRoomFragmentSparseArray.valueAt(i)).setForceUpdate(true);
      i += 1;
    }
    this.mSource = ((AppGeneralInfoService)BizEngineMgr.getInstance().getLiveEngine().getService(AppGeneralInfoService.class)).getSource();
    this.switchRoomInfoList.clear();
    this.switchRoomInfoList.add(paramSwitchRoomInfo);
    this.currentFragment = null;
    this.audienceRoomFragmentSparseArray.clear();
    this.audienceRoomFragmentSparseArray.put(0, createFragment(0));
    notifyDataSetChanged();
    return (AudienceRoomFragment)this.audienceRoomFragmentSparseArray.get(0);
  }
  
  public void queryAndUpdateRoomListFromServer(int paramInt1, int paramInt2)
  {
    Object localObject = (LogInterface)BizEngineMgr.getInstance().getLiveEngine().getService(LogInterface.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("direction: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", index: ");
    localStringBuilder.append(paramInt2);
    ((LogInterface)localObject).i("SwitchRoomAdapter", localStringBuilder.toString(), new Object[0]);
    if (getCurrentFragment() == null)
    {
      ((LogInterface)localObject).e("SwitchRoomAdapter", "queryAndUpdateRoomListFromServer--getCurrentFragment is null", new Object[0]);
      return;
    }
    localObject = (RoomSwitchInterface)getCurrentFragment().getRoomEngine().getService(RoomSwitchInterface.class);
    if (localObject != null) {
      ((RoomSwitchInterface)localObject).queryRoomList(this.switchRoomInfoList, paramInt1, paramInt2, new SwitchRoomAdapter.2(this));
    }
  }
  
  public void setPrimaryItem(@NonNull ViewGroup paramViewGroup, int paramInt, @NonNull Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    this.currentFragment = ((AudienceRoomFragment)paramObject);
  }
  
  public void updateSwichtRoomInfo(List<SwitchRoomInfo> paramList)
  {
    this.switchRoomInfoList.clear();
    this.switchRoomInfoList.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.pagelogic.widgets.SwitchRoomAdapter
 * JD-Core Version:    0.7.0.1
 */