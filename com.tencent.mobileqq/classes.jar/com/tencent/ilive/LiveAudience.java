package com.tencent.ilive;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.ilive.audiencepages.room.AudienceRoomViewPager;
import com.tencent.ilive.base.page.PageType;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;

public class LiveAudience
{
  public static AudienceRoomViewPager createAudienceRoomPager(Context paramContext, EnterRoomConfig paramEnterRoomConfig)
  {
    paramContext = (AudienceRoomViewPager)LayoutInflater.from(paramContext).inflate(2131625165, null).findViewById(2131428833);
    paramContext.setIntent(getEnterRoomIntent(paramEnterRoomConfig));
    return paramContext;
  }
  
  public static Intent getEnterRoomIntent(EnterRoomConfig paramEnterRoomConfig)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("roomid", paramEnterRoomConfig.roomId);
    localIntent.putExtra("source", paramEnterRoomConfig.source);
    localIntent.putExtra("cover_bitmap", paramEnterRoomConfig.coverBitmapBytes);
    localIntent.putExtra("video_url", paramEnterRoomConfig.videoUrl);
    localIntent.putExtra("video_level", paramEnterRoomConfig.videoLevel);
    localIntent.putExtra("video_is_origin", paramEnterRoomConfig.videoIsOrigin);
    localIntent.putExtra("video_format", paramEnterRoomConfig.videoFormat);
    localIntent.putExtra("support_video_format", transferVideoFormat(paramEnterRoomConfig.supportVideoFormats));
    localIntent.putExtra("screen_orientation_landscape", false);
    if (paramEnterRoomConfig.isLiteSdk) {
      localIntent.putExtra("page_type", PageType.LIVE_ROOM_AUDIENCE_LITE.value);
    } else {
      localIntent.putExtra("page_type", PageType.LIVE_ROOM_AUDIENCE.value);
    }
    localIntent.putExtra("biz_ext_data", paramEnterRoomConfig.extData);
    localIntent.putExtra("lite_sdk", paramEnterRoomConfig.isLiteSdk);
    localIntent.putExtra("video_id", paramEnterRoomConfig.videoId);
    localIntent.setFlags(335544320);
    return localIntent;
  }
  
  public static int getPageType(EnterRoomConfig paramEnterRoomConfig)
  {
    if (paramEnterRoomConfig.isLiteSdk) {
      return PageType.LIVE_ROOM_AUDIENCE_LITE.value;
    }
    return PageType.LIVE_ROOM_AUDIENCE.value;
  }
  
  public static Intent switchToNewIntent(Intent paramIntent, SwitchRoomInfo paramSwitchRoomInfo)
  {
    paramIntent.putExtra("roomid", paramSwitchRoomInfo.roomId);
    paramIntent.putExtra("cover_bitmap", paramSwitchRoomInfo.coverBitmapBytes);
    paramIntent.putExtra("video_url", paramSwitchRoomInfo.videoUrl);
    paramIntent.putExtra("video_level", paramSwitchRoomInfo.videoLevel);
    paramIntent.putExtra("video_is_origin", paramSwitchRoomInfo.videoIsOrigin);
    paramIntent.putExtra("biz_ext_data", paramSwitchRoomInfo.extData);
    paramIntent.putExtra("video_id", paramSwitchRoomInfo.videoId);
    paramIntent.setFlags(335544320);
    return paramIntent;
  }
  
  private static String[] transferVideoFormat(EnterRoomConfig.VideoFormat[] paramArrayOfVideoFormat)
  {
    if ((paramArrayOfVideoFormat != null) && (paramArrayOfVideoFormat.length != 0))
    {
      String[] arrayOfString = new String[paramArrayOfVideoFormat.length];
      int i = 0;
      while (i < paramArrayOfVideoFormat.length)
      {
        arrayOfString[i] = paramArrayOfVideoFormat[i].value;
        i += 1;
      }
      return arrayOfString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.LiveAudience
 * JD-Core Version:    0.7.0.1
 */