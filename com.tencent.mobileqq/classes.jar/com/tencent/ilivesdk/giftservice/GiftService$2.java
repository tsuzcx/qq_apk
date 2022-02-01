package com.tencent.ilivesdk.giftservice;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceAdapter;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.OnQueryAllGiftsInfoCallback;
import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo;
import com.tencent.ilivesdk.giftservice_interface.model.TabInfo;
import com.tencent.protobuf.iliveGiftInfoNew.nano.GiftInfoRsp;
import com.tencent.protobuf.iliveGiftInfoNew.nano.PersonGiftListNewRsp;
import com.tencent.protobuf.iliveGiftInfoNew.nano.TabAndGiftInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GiftService$2
  implements ChannelCallback
{
  GiftService$2(GiftService paramGiftService, long paramLong, GiftServiceInterface.OnQueryAllGiftsInfoCallback paramOnQueryAllGiftsInfoCallback) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramBoolean) {
      this.this$0.getServiceAdapter().getLogger().e("GiftService", "queryAllGiftsInfo timeout", new Object[0]);
    }
    for (;;)
    {
      if (this.val$callback != null) {
        this.val$callback.onFail(paramInt, paramString);
      }
      return;
      this.this$0.getServiceAdapter().getLogger().e("GiftService", "queryAllGiftsInfo on err " + paramInt + " msg " + paramString, new Object[0]);
    }
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      ArrayList localArrayList;
      HashMap localHashMap;
      int i;
      GiftInfo localGiftInfo;
      try
      {
        paramArrayOfByte = PersonGiftListNewRsp.parseFrom(paramArrayOfByte);
        if (paramArrayOfByte.retsult != 0)
        {
          this.this$0.getServiceAdapter().getLogger().e("GiftService", "PersonGiftListNewRsp is not 0 is " + paramArrayOfByte.retsult, new Object[0]);
          return;
        }
        this.this$0.getServiceAdapter().getLogger().i("GiftService", "queryAllGiftsInfo PersonGiftListNewRsp", new Object[0]);
        localArrayList = new ArrayList();
        localHashMap = new HashMap();
        TabAndGiftInfo[] arrayOfTabAndGiftInfo = paramArrayOfByte.giftInfoList;
        int k = arrayOfTabAndGiftInfo.length;
        i = 0;
        if (i >= k) {
          break label436;
        }
        TabAndGiftInfo localTabAndGiftInfo = arrayOfTabAndGiftInfo[i];
        paramArrayOfByte = new TabInfo();
        paramArrayOfByte.name = localTabAndGiftInfo.tabName;
        paramArrayOfByte.type = localTabAndGiftInfo.tabType;
        localArrayList.add(paramArrayOfByte);
        GiftInfoRsp[] arrayOfGiftInfoRsp = localTabAndGiftInfo.giftInfoList;
        int m = arrayOfGiftInfoRsp.length;
        int j = 0;
        if (j >= m) {
          break label489;
        }
        paramArrayOfByte = arrayOfGiftInfoRsp[j];
        localGiftInfo = GiftService.access$100(this.this$0, paramArrayOfByte);
        if ((localGiftInfo.mGiftScene == 0L) && (localGiftInfo.mNobelType != 0))
        {
          localGiftInfo.mTabId = localTabAndGiftInfo.tabType;
          GiftService.access$200(this.this$0).put(Integer.valueOf(localGiftInfo.mGiftId), Integer.valueOf(localGiftInfo.mGiftType));
          GiftService.access$300(this.this$0).put(Integer.valueOf(localGiftInfo.mGiftId), localGiftInfo);
          j += 1;
          continue;
        }
        if (localGiftInfo.mGiftScene != 0L)
        {
          if ((localGiftInfo.mGiftScene & 0xFF) != 1L) {
            continue;
          }
          localList = (List)localHashMap.get(Integer.valueOf(-1));
          paramArrayOfByte = localList;
          if (localList == null)
          {
            paramArrayOfByte = new ArrayList();
            localHashMap.put(Integer.valueOf(-1), paramArrayOfByte);
          }
          paramArrayOfByte.add(localGiftInfo);
          continue;
        }
        n = localTabAndGiftInfo.tabType;
      }
      catch (InvalidProtocolBufferNanoException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
      int n;
      List localList = (List)localHashMap.get(Integer.valueOf(n));
      paramArrayOfByte = localList;
      if (localList == null)
      {
        paramArrayOfByte = new ArrayList();
        localHashMap.put(Integer.valueOf(n), paramArrayOfByte);
      }
      paramArrayOfByte.add(localGiftInfo);
      continue;
      label436:
      GiftService.access$402(this.this$0, localArrayList);
      GiftService.access$502(this.this$0, localHashMap);
      GiftService.access$602(this.this$0, this.val$roomId);
      if (this.val$callback != null) {
        this.val$callback.onGetAllGiftsInfo(localHashMap, localArrayList);
      }
      return;
      label489:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.GiftService.2
 * JD-Core Version:    0.7.0.1
 */