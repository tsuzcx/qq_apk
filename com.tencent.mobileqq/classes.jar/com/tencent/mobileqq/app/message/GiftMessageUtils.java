package com.tencent.mobileqq.app.message;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout12;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GiftMessageUtils
{
  public static int a(MessageRecord paramMessageRecord, int paramInt)
  {
    paramMessageRecord = a(paramMessageRecord);
    int j = 0;
    int i = 0;
    if (paramMessageRecord != null)
    {
      paramMessageRecord = paramMessageRecord.iterator();
      for (;;)
      {
        j = i;
        if (!paramMessageRecord.hasNext()) {
          break;
        }
        GiftMessageUtils.GiftInfo localGiftInfo = (GiftMessageUtils.GiftInfo)paramMessageRecord.next();
        if (localGiftInfo.a == paramInt) {
          i += localGiftInfo.b;
        }
      }
    }
    return j;
  }
  
  public static List<GiftMessageUtils.GiftInfo> a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      if (((paramMessageRecord.structingMsg instanceof AbsShareMsg)) && (paramMessageRecord.structingMsg.mMsgServiceID == 52))
      {
        paramMessageRecord = (AbsShareMsg)paramMessageRecord.structingMsg;
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramMessageRecord.iterator();
        while (localIterator.hasNext())
        {
          paramMessageRecord = (AbsStructMsgElement)localIterator.next();
          if (paramMessageRecord != null)
          {
            String str = HardCodeUtil.a(2131705359);
            int i = 1;
            int m = 1;
            int k = 0;
            int j;
            if ((paramMessageRecord instanceof StructMsgItemLayout12))
            {
              j = ((StructMsgItemLayout12)paramMessageRecord).a.getInt("count");
              paramMessageRecord = str;
            }
            else
            {
              Object localObject = paramMessageRecord.h;
              paramMessageRecord = str;
              j = k;
              if (localObject != null)
              {
                paramMessageRecord = str;
                i = m;
                try
                {
                  localObject = new JSONObject((String)localObject);
                  paramMessageRecord = str;
                  i = m;
                  str = ((JSONObject)localObject).getString("giftName");
                  paramMessageRecord = str;
                  i = m;
                  j = ((JSONObject)localObject).getInt("giftType");
                  paramMessageRecord = str;
                  i = j;
                  m = ((JSONObject)localObject).getInt("giftCount");
                  paramMessageRecord = str;
                  i = j;
                  j = m;
                }
                catch (JSONException localJSONException)
                {
                  localJSONException.printStackTrace();
                  j = k;
                }
              }
            }
            localArrayList.add(new GiftMessageUtils.GiftInfo(paramMessageRecord, i, j));
          }
        }
        return localArrayList;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.GiftMessageUtils
 * JD-Core Version:    0.7.0.1
 */