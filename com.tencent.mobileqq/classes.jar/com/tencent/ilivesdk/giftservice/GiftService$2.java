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
    if (paramBoolean)
    {
      this.this$0.getServiceAdapter().getLogger().e("GiftService", "queryAllGiftsInfo timeout", new Object[0]);
    }
    else
    {
      localObject = this.this$0.getServiceAdapter().getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("queryAllGiftsInfo on err ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" msg ");
      localStringBuilder.append(paramString);
      ((LogInterface)localObject).e("GiftService", localStringBuilder.toString(), new Object[0]);
    }
    Object localObject = this.val$callback;
    if (localObject != null) {
      ((GiftServiceInterface.OnQueryAllGiftsInfoCallback)localObject).onFail(paramInt, paramString);
    }
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      int i;
      try
      {
        paramArrayOfByte = PersonGiftListNewRsp.parseFrom(paramArrayOfByte);
        i = paramArrayOfByte.retsult;
        Object localObject1;
        if (i != 0)
        {
          localObject1 = this.this$0.getServiceAdapter().getLogger();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("PersonGiftListNewRsp is not 0 is ");
          ((StringBuilder)localObject2).append(paramArrayOfByte.retsult);
          ((LogInterface)localObject1).e("GiftService", ((StringBuilder)localObject2).toString(), new Object[0]);
          return;
        }
        this.this$0.getServiceAdapter().getLogger().i("GiftService", "queryAllGiftsInfo PersonGiftListNewRsp", new Object[0]);
        Object localObject2 = new ArrayList();
        HashMap localHashMap = new HashMap();
        TabAndGiftInfo[] arrayOfTabAndGiftInfo = paramArrayOfByte.giftInfoList;
        int k = arrayOfTabAndGiftInfo.length;
        i = 0;
        if (i < k)
        {
          TabAndGiftInfo localTabAndGiftInfo = arrayOfTabAndGiftInfo[i];
          paramArrayOfByte = new TabInfo();
          paramArrayOfByte.name = localTabAndGiftInfo.tabName;
          paramArrayOfByte.type = localTabAndGiftInfo.tabType;
          ((List)localObject2).add(paramArrayOfByte);
          GiftInfoRsp[] arrayOfGiftInfoRsp = localTabAndGiftInfo.giftInfoList;
          int m = arrayOfGiftInfoRsp.length;
          int j = 0;
          if (j >= m) {
            break label505;
          }
          paramArrayOfByte = arrayOfGiftInfoRsp[j];
          GiftInfo localGiftInfo = GiftService.access$100(this.this$0, paramArrayOfByte);
          if ((localGiftInfo.mGiftScene != 0L) || (localGiftInfo.mNobelType == 0)) {
            if (localGiftInfo.mGiftScene != 0L)
            {
              if ((localGiftInfo.mGiftScene & 0xFF) == 1L)
              {
                localObject1 = (List)localHashMap.get(Integer.valueOf(-1));
                paramArrayOfByte = (byte[])localObject1;
                if (localObject1 == null)
                {
                  paramArrayOfByte = new ArrayList();
                  localHashMap.put(Integer.valueOf(-1), paramArrayOfByte);
                }
                paramArrayOfByte.add(localGiftInfo);
              }
            }
            else
            {
              int n = localTabAndGiftInfo.tabType;
              localObject1 = (List)localHashMap.get(Integer.valueOf(n));
              paramArrayOfByte = (byte[])localObject1;
              if (localObject1 == null)
              {
                paramArrayOfByte = new ArrayList();
                localHashMap.put(Integer.valueOf(n), paramArrayOfByte);
              }
              paramArrayOfByte.add(localGiftInfo);
            }
          }
          localGiftInfo.mTabId = localTabAndGiftInfo.tabType;
          GiftService.access$200(this.this$0).put(Integer.valueOf(localGiftInfo.mGiftId), Integer.valueOf(localGiftInfo.mGiftType));
          GiftService.access$300(this.this$0).put(Integer.valueOf(localGiftInfo.mGiftId), localGiftInfo);
          j += 1;
          continue;
        }
        GiftService.access$402(this.this$0, (List)localObject2);
        GiftService.access$502(this.this$0, localHashMap);
        GiftService.access$602(this.this$0, this.val$roomId);
        if (this.val$callback != null)
        {
          this.val$callback.onGetAllGiftsInfo(localHashMap, (List)localObject2);
          return;
        }
      }
      catch (InvalidProtocolBufferNanoException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
      return;
      label505:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.GiftService.2
 * JD-Core Version:    0.7.0.1
 */