package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class DynamicAvatarInfo$VideoHeadInfo
{
  public String a;
  public int b;
  
  public static VideoHeadInfo a(oidb_0x74b.VideoHeadInfo paramVideoHeadInfo)
  {
    if (paramVideoHeadInfo == null) {
      return null;
    }
    VideoHeadInfo localVideoHeadInfo = new VideoHeadInfo();
    if (paramVideoHeadInfo.str_url.has()) {
      localVideoHeadInfo.a = paramVideoHeadInfo.str_url.get();
    }
    if (paramVideoHeadInfo.uint32_video_size.has()) {
      localVideoHeadInfo.b = paramVideoHeadInfo.uint32_video_size.get();
    }
    return localVideoHeadInfo;
  }
  
  public static ArrayList<VideoHeadInfo> a(List<oidb_0x74b.VideoHeadInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        VideoHeadInfo localVideoHeadInfo = a((oidb_0x74b.VideoHeadInfo)paramList.next());
        if (localVideoHeadInfo != null) {
          localArrayList.add(localVideoHeadInfo);
        }
      }
      return localArrayList;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfo.VideoHeadInfo
 * JD-Core Version:    0.7.0.1
 */