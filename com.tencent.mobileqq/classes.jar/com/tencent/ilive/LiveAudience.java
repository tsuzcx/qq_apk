package com.tencent.ilive;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.ilive.audiencepages.room.AudienceRoomViewPager;
import com.tencent.ilive.base.page.PageType;

public class LiveAudience
{
  public static AudienceRoomViewPager createAudienceRoomPager(Context paramContext, EnterRoomConfig paramEnterRoomConfig)
  {
    paramContext = (AudienceRoomViewPager)LayoutInflater.from(paramContext).inflate(2131559370, null).findViewById(2131363083);
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
    }
    for (;;)
    {
      localIntent.putExtra("biz_ext_data", paramEnterRoomConfig.extData);
      localIntent.putExtra("lite_sdk", paramEnterRoomConfig.isLiteSdk);
      localIntent.putExtra("video_id", paramEnterRoomConfig.videoId);
      localIntent.setFlags(335544320);
      return localIntent;
      localIntent.putExtra("page_type", PageType.LIVE_ROOM_AUDIENCE.value);
    }
  }
  
  public static int getPageType(EnterRoomConfig paramEnterRoomConfig)
  {
    if (paramEnterRoomConfig.isLiteSdk) {
      return PageType.LIVE_ROOM_AUDIENCE_LITE.value;
    }
    return PageType.LIVE_ROOM_AUDIENCE.value;
  }
  
  private static String[] transferVideoFormat(EnterRoomConfig.VideoFormat[] paramArrayOfVideoFormat)
  {
    if ((paramArrayOfVideoFormat == null) || (paramArrayOfVideoFormat.length == 0)) {
      return null;
    }
    String[] arrayOfString = new String[paramArrayOfVideoFormat.length];
    int i = 0;
    while (i < paramArrayOfVideoFormat.length)
    {
      arrayOfString[i] = paramArrayOfVideoFormat[i].value;
      i += 1;
    }
    return arrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.LiveAudience
 * JD-Core Version:    0.7.0.1
 */