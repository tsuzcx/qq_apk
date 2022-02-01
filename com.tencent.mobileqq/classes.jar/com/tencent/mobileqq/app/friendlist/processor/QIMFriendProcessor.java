package com.tencent.mobileqq.app.friendlist.processor;

import android.util.Pair;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpdateItem;

@KeepClassConstructor
public class QIMFriendProcessor
  extends BaseFriendProcessor
{
  public QIMFriendProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  public void onBatchUpdateFriendInfo(List<Pair<Friends, FriendInfo>> paramList, long paramLong, boolean paramBoolean)
  {
    paramList = paramList.iterator();
    Object localObject1;
    Friends localFriends;
    while (paramList.hasNext())
    {
      localObject1 = (Pair)paramList.next();
      localFriends = (Friends)((Pair)localObject1).first;
      localObject1 = parseSnsUpdateBuffer(((FriendInfo)((Pair)localObject1).second).vecRing);
      if ((localObject1 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject1).rpt_msg_sns_update_item.has())) {
        localObject1 = ((Oidb_0x5d0.SnsUpateBuffer)localObject1).rpt_msg_sns_update_item.get().iterator();
      }
    }
    label85:
    label231:
    label235:
    for (;;)
    {
      int j;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject1).next();
        if (((Oidb_0x5d0.SnsUpdateItem)localObject2).uint32_update_sns_type.get() != 13824) {
          continue;
        }
        localObject2 = ((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.get().toByteArray();
        if (localObject2.length < 1) {
          break label231;
        }
        j = localObject2[0] & 0x2;
        i = j;
        if (j == 2) {
          localFriends.friendType = 1;
        }
      }
      for (int i = j;; i = 0)
      {
        if (!QLog.isColorLevel()) {
          break label235;
        }
        QLog.d("IMCore.friend.QIMFriendProcessor", 2, "updateQimFriend | friend.uin : " + localFriends.uin + " | friend.friendType : " + localFriends.friendType + " | itemType : " + i);
        break label85;
        break;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.friendlist.processor.QIMFriendProcessor
 * JD-Core Version:    0.7.0.1
 */