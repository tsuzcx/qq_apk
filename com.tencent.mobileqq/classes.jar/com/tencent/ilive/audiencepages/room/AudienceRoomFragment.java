package com.tencent.ilive.audiencepages.room;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ilive.base.bizmodule.BizModulesConfig;
import com.tencent.ilive.base.bizmodule.BizModulesFactory;
import com.tencent.ilive.commonpages.room.RoomBaseFragment;
import com.tencent.ilive.config.PageConfigInterface;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.RoomBootBizModules;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.VideoType;

public abstract class AudienceRoomFragment
  extends RoomBaseFragment
{
  private IAudienceRoomPager audienceRoomPager;
  private boolean forceUpdate = false;
  
  public void createBootBizModulesExtData()
  {
    super.createBootBizModulesExtData();
    this.roomBootBizModules.setAudienceRoomPager(this.audienceRoomPager);
  }
  
  public RoomBootBizModules createRooBootBizModules()
  {
    boolean bool = getActivity().getIntent().getBooleanExtra("screen_orientation_landscape", false);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("screen_orientation_landscape", bool);
    PageConfigInterface localPageConfigInterface = getPageUIConfig();
    getBizModulesFactory().getConfig().merge(localPageConfigInterface.createBizModulesConfig());
    this.roomBootBizModules = ((RoomBootBizModules)getBizModulesFactory().createBootBizModules(this.pageType, localBundle));
    return this.roomBootBizModules;
  }
  
  public void initBizContextRoomInfo()
  {
    EnterRoomInfo localEnterRoomInfo = new EnterRoomInfo();
    Bundle localBundle = getArguments();
    localEnterRoomInfo.roomId = localBundle.getLong("roomid", -1L);
    localEnterRoomInfo.source = localBundle.getString("source", "");
    localEnterRoomInfo.programId = localBundle.getString("program_id", "");
    localEnterRoomInfo.preVideoUrl = localBundle.getString("video_url", "");
    localEnterRoomInfo.isLiteSdk = localBundle.getBoolean("lite_sdk", false);
    localEnterRoomInfo.bootModulesIndex = localBundle.getInt("modules_index", 0);
    localEnterRoomInfo.videoType = localBundle.getInt("video_format", VideoType.LIVE.ordinal());
    localEnterRoomInfo.videoId = localBundle.getString("video_id", "");
    localEnterRoomInfo.extData = localBundle.getBundle("biz_ext_data");
    localEnterRoomInfo.coverBitmapBytes = localBundle.getByteArray("cover_bitmap");
    localEnterRoomInfo.isLiteSdk = localBundle.getBoolean("lite_sdk", false);
    this.roomBizContext.setEnterRoomInfo(localEnterRoomInfo);
  }
  
  public boolean isForceUpdate()
  {
    return this.forceUpdate;
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void setAudienceRoomPager(IAudienceRoomPager paramIAudienceRoomPager)
  {
    this.audienceRoomPager = paramIAudienceRoomPager;
  }
  
  public void setForceUpdate(boolean paramBoolean)
  {
    this.forceUpdate = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.audiencepages.room.AudienceRoomFragment
 * JD-Core Version:    0.7.0.1
 */