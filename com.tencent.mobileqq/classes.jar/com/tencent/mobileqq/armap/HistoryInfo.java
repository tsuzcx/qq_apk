package com.tencent.mobileqq.armap;

import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.HistoryInfo;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.ItemInfo;
import tencent.im.oidb.cmd0x7bb.oidb_0x7bb.TaskInfo;

public class HistoryInfo
{
  public int a;
  public long a;
  public ItemInfo a;
  public POITaskInfo a;
  
  public static HistoryInfo a(oidb_0x7bb.HistoryInfo paramHistoryInfo)
  {
    if (paramHistoryInfo == null) {
      return new HistoryInfo();
    }
    HistoryInfo localHistoryInfo = new HistoryInfo();
    int i;
    long l;
    label63:
    ItemInfo localItemInfo;
    if (paramHistoryInfo.op_type.has())
    {
      i = paramHistoryInfo.op_type.get();
      localHistoryInfo.jdField_a_of_type_Int = i;
      if (!paramHistoryInfo.ctime.has()) {
        break label139;
      }
      l = paramHistoryInfo.ctime.get();
      localHistoryInfo.jdField_a_of_type_Long = l;
      if (!paramHistoryInfo.item.has()) {
        break label144;
      }
      localItemInfo = ItemInfo.a((oidb_0x7bb.ItemInfo)paramHistoryInfo.item.get());
      label94:
      localHistoryInfo.jdField_a_of_type_ComTencentMobileqqArmapItemInfo = localItemInfo;
      if (!paramHistoryInfo.task.has()) {
        break label156;
      }
    }
    label139:
    label144:
    label156:
    for (paramHistoryInfo = POITaskInfo.a((oidb_0x7bb.TaskInfo)paramHistoryInfo.task.get());; paramHistoryInfo = new POITaskInfo())
    {
      localHistoryInfo.jdField_a_of_type_ComTencentMobileqqArmapPOITaskInfo = paramHistoryInfo;
      return localHistoryInfo;
      i = 0;
      break;
      l = 0L;
      break label63;
      localItemInfo = new ItemInfo();
      break label94;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.HistoryInfo
 * JD-Core Version:    0.7.0.1
 */