package com.tencent.mobileqq.avatar.dynamicavatar;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.OneUinHeadInfo;

public class DynamicAvatarInfo$OneUinHeadInfo
{
  public int a;
  public long a;
  public ArrayList<DynamicAvatarInfo.UinHeadInfo> a;
  public long b;
  
  public static OneUinHeadInfo a(oidb_0x74b.OneUinHeadInfo paramOneUinHeadInfo)
  {
    if (paramOneUinHeadInfo == null) {
      return null;
    }
    OneUinHeadInfo localOneUinHeadInfo = new OneUinHeadInfo();
    if (paramOneUinHeadInfo.uint64_uin.has()) {
      localOneUinHeadInfo.jdField_a_of_type_Long = paramOneUinHeadInfo.uint64_uin.get();
    }
    if (paramOneUinHeadInfo.uint64_tinyid.has()) {
      localOneUinHeadInfo.b = paramOneUinHeadInfo.uint64_tinyid.get();
    }
    localOneUinHeadInfo.jdField_a_of_type_Int = ((int)(System.currentTimeMillis() / 1000L));
    if (paramOneUinHeadInfo.rpt_msg_head_list.has()) {
      localOneUinHeadInfo.jdField_a_of_type_JavaUtilArrayList = DynamicAvatarInfo.UinHeadInfo.a(paramOneUinHeadInfo.rpt_msg_head_list.get());
    }
    return localOneUinHeadInfo;
  }
  
  public static ArrayList<OneUinHeadInfo> a(List<oidb_0x74b.OneUinHeadInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        OneUinHeadInfo localOneUinHeadInfo = a((oidb_0x74b.OneUinHeadInfo)paramList.next());
        if (localOneUinHeadInfo != null) {
          localArrayList.add(localOneUinHeadInfo);
        }
      }
      return localArrayList;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarInfo.OneUinHeadInfo
 * JD-Core Version:    0.7.0.1
 */