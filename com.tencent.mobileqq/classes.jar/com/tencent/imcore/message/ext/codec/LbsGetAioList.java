package com.tencent.imcore.message.ext.codec;

import com.tencent.imcore.message.GetAioListCallback;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import mqq.app.AppRuntime;

public class LbsGetAioList
  implements GetAioListCallback
{
  public void a(String paramString, int paramInt1, long paramLong, int paramInt2, boolean paramBoolean, List<MessageRecord> paramList, AppRuntime paramAppRuntime)
  {
    if ((paramInt1 != 1001) && (paramInt1 != 10002) && (UinTypeUtil.e(paramInt1) != 1032)) {
      return;
    }
    if (paramList == null) {
      paramInt1 = 0;
    } else {
      paramInt1 = paramList.size();
    }
    paramInt1 -= 1;
    while (paramInt1 >= 0)
    {
      paramString = (MessageRecord)paramList.get(paramInt1);
      if ((paramString != null) && (paramString.msgtype == -4011)) {
        paramList.remove(paramString);
      }
      paramInt1 -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.LbsGetAioList
 * JD-Core Version:    0.7.0.1
 */