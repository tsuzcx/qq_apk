package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.VideoHeadInfo;

public class DynamicAvatarInfo$VideoHeadInfo
{
  public int a;
  public String a;
  
  public static VideoHeadInfo a(oidb_0x74b.VideoHeadInfo paramVideoHeadInfo)
  {
    Object localObject;
    if (paramVideoHeadInfo == null) {
      localObject = null;
    }
    VideoHeadInfo localVideoHeadInfo;
    do
    {
      return localObject;
      localVideoHeadInfo = new VideoHeadInfo();
      if (paramVideoHeadInfo.str_url.has()) {
        localVideoHeadInfo.jdField_a_of_type_JavaLangString = paramVideoHeadInfo.str_url.get();
      }
      localObject = localVideoHeadInfo;
    } while (!paramVideoHeadInfo.uint32_video_size.has());
    localVideoHeadInfo.jdField_a_of_type_Int = paramVideoHeadInfo.uint32_video_size.get();
    return localVideoHeadInfo;
  }
  
  public static ArrayList a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfo.VideoHeadInfo
 * JD-Core Version:    0.7.0.1
 */