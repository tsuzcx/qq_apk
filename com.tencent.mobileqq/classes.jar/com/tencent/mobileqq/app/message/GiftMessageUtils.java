package com.tencent.mobileqq.app.message;

import android.os.Bundle;
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
    int j;
    if (paramMessageRecord != null)
    {
      paramMessageRecord = paramMessageRecord.iterator();
      int i = 0;
      j = i;
      if (!paramMessageRecord.hasNext()) {
        break label62;
      }
      GiftMessageUtils.GiftInfo localGiftInfo = (GiftMessageUtils.GiftInfo)paramMessageRecord.next();
      if (localGiftInfo.a != paramInt) {
        break label64;
      }
      i = localGiftInfo.b + i;
    }
    label62:
    label64:
    for (;;)
    {
      break;
      j = 0;
      return j;
    }
  }
  
  public static List a(MessageRecord paramMessageRecord)
  {
    ArrayList localArrayList;
    String str;
    int j;
    int i;
    if (((paramMessageRecord instanceof MessageForStructing)) && ((((MessageForStructing)paramMessageRecord).structingMsg instanceof AbsShareMsg)) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 52))
    {
      paramMessageRecord = (AbsShareMsg)((MessageForStructing)paramMessageRecord).structingMsg;
      localArrayList = new ArrayList();
      Iterator localIterator = paramMessageRecord.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          paramMessageRecord = (AbsStructMsgElement)localIterator.next();
          if (paramMessageRecord != null)
          {
            str = "礼物";
            j = 1;
            if ((paramMessageRecord instanceof StructMsgItemLayout12))
            {
              i = ((StructMsgItemLayout12)paramMessageRecord).a.getInt("count");
              j = 1;
              paramMessageRecord = "礼物";
            }
          }
        }
      }
    }
    for (;;)
    {
      localArrayList.add(new GiftMessageUtils.GiftInfo(paramMessageRecord, j, i));
      break;
      Object localObject = paramMessageRecord.h;
      if (localObject != null)
      {
        i = j;
        paramMessageRecord = str;
        try
        {
          localObject = new JSONObject((String)localObject);
          i = j;
          paramMessageRecord = str;
          str = ((JSONObject)localObject).getString("giftName");
          i = j;
          paramMessageRecord = str;
          j = ((JSONObject)localObject).getInt("giftType");
          i = j;
          paramMessageRecord = str;
          int k = ((JSONObject)localObject).getInt("giftCount");
          i = k;
          paramMessageRecord = str;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          j = i;
          i = 0;
        }
        continue;
        return localArrayList;
        return null;
      }
      else
      {
        i = 0;
        j = 1;
        paramMessageRecord = "礼物";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.GiftMessageUtils
 * JD-Core Version:    0.7.0.1
 */