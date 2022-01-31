package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;
import ors;

public class KandianRedDotInfo
  implements Serializable
{
  public static final String REDDOT_TYPE_DAILY = "kandian_daily_red_pnt";
  public static final String REDDOT_TYPE_KANDIAN_DT = "kandian_dt_red_dot_info";
  public static final String REDDOT_TYPE_LOCK_SCREEN = "kandian_red_pnt_lock_screen";
  public static final String REDDOT_TYPE_MAIN_VIDEO_TAB = "kandian_video_tab_reddot_info";
  public long algorithmID;
  public ArrayList<Long> articleIDList = new ArrayList();
  public String cookie;
  public String extInfo;
  public KandianRedDotInfo.DailyFloatingWindowData floatingWinData = new KandianRedDotInfo.DailyFloatingWindowData();
  public String forderStatus;
  public byte[] msgData;
  public String rowkey = "";
  public long strategyID;
  public String type;
  
  public KandianRedDotInfo(String paramString)
  {
    this.type = paramString;
  }
  
  private static MessageRecord a(byte[] paramArrayOfByte, String paramString)
  {
    MessageForStructing localMessageForStructing = new MessageForStructing();
    localMessageForStructing.msgData = paramArrayOfByte;
    localMessageForStructing.parse();
    if ((TextUtils.equals(paramString, "kandian_dt_red_dot_info")) || (TextUtils.equals(paramString, "kandian_red_pnt_lock_screen"))) {
      localMessageForStructing.extInt = 1;
    }
    return localMessageForStructing;
  }
  
  public static KandianRedDotInfo createRedDotFromMessageRecord(MessageRecord paramMessageRecord, String paramString)
  {
    if (!(paramMessageRecord instanceof MessageForStructing)) {
      return null;
    }
    MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
    localMessageForStructing.parse();
    if (localMessageForStructing.structingMsg == null) {
      return null;
    }
    KandianRedDotInfo localKandianRedDotInfo = new KandianRedDotInfo(paramString);
    localKandianRedDotInfo.cookie = localMessageForStructing.structingMsg.mMsgActionData;
    localKandianRedDotInfo.forderStatus = localMessageForStructing.structingMsg.reportEventFolderStatusValue;
    localKandianRedDotInfo.extInfo = localMessageForStructing.structingMsg.mExtraData;
    localKandianRedDotInfo.msgData = paramMessageRecord.msgData;
    try
    {
      localKandianRedDotInfo.algorithmID = Long.valueOf(localMessageForStructing.structingMsg.mAlgorithmIds).longValue();
      localKandianRedDotInfo.strategyID = Long.valueOf(localMessageForStructing.structingMsg.mStrategyIds).longValue();
      QLog.d("KandianRedDotInfo", 1, "createRedDotFromMessageRecord | mr isRead " + paramMessageRecord.isread);
      if (("kandian_daily_red_pnt".equalsIgnoreCase(paramString)) && (!paramMessageRecord.isread)) {}
      try
      {
        paramString = new JSONObject(localMessageForStructing.structingMsg.mMsgActionData);
        if (paramString != null)
        {
          if (localKandianRedDotInfo.floatingWinData == null) {
            localKandianRedDotInfo.floatingWinData = new KandianRedDotInfo.DailyFloatingWindowData();
          }
          localKandianRedDotInfo.floatingWinData.type = paramString.optInt("type", 0);
          localKandianRedDotInfo.floatingWinData.url = paramString.optString("url", "");
          int i = paramString.optInt("remove", 0);
          KandianRedDotInfo.DailyFloatingWindowData localDailyFloatingWindowData = localKandianRedDotInfo.floatingWinData;
          if (i != 1) {
            break label507;
          }
          bool = true;
          localDailyFloatingWindowData.remove = bool;
          localKandianRedDotInfo.floatingWinData.topicID = paramString.optString("topicID", "");
          localKandianRedDotInfo.rowkey = paramString.optString("push_rowkey", "");
          QLog.d("KandianRedDotInfo", 1, "createRedDotFromMessageRecord | init floatingWindowData  " + localKandianRedDotInfo.floatingWinData.toString());
          paramString.put("algorithmIds", localMessageForStructing.structingMsg.mAlgorithmIds);
          paramString.put("reportEventFolderStatusValue", localMessageForStructing.structingMsg.reportEventFolderStatusValue);
          paramString.put("strategyIds", localMessageForStructing.structingMsg.mStrategyIds);
          localKandianRedDotInfo.cookie = paramString.toString();
          QLog.d("KandianRedDotInfo", 1, "createRedDotFromMessageRecord | origin_actionData is " + localMessageForStructing.structingMsg.mMsgActionData + "\n recombined_actionData is " + localKandianRedDotInfo.cookie);
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          boolean bool;
          QLog.d("KandianRedDotInfo", 2, "createRedDotFromMessageRecord | exception " + paramString.getMessage());
        }
      }
      paramMessageRecord = ors.a(paramMessageRecord);
      if ((paramMessageRecord != null) && (!paramMessageRecord.isEmpty()))
      {
        paramMessageRecord = paramMessageRecord.iterator();
        while (paramMessageRecord.hasNext())
        {
          paramString = (String)paramMessageRecord.next();
          try
          {
            localKandianRedDotInfo.articleIDList.add(Long.valueOf(paramString));
          }
          catch (NumberFormatException paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        continue;
        label507:
        bool = false;
      }
    }
    return localKandianRedDotInfo;
  }
  
  public static KandianRedDotInfo getRedDotFromDisk(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    return (KandianRedDotInfo)ors.a(paramAppRuntime, paramString, paramBoolean);
  }
  
  public MessageRecord getMessageRecord()
  {
    if (this.msgData != null) {
      return a(this.msgData, this.type);
    }
    return null;
  }
  
  public String getRowkey()
  {
    try
    {
      Object localObject = (MessageForStructing)getMessageRecord();
      if ((localObject != null) && (((MessageForStructing)localObject).structingMsg != null) && (!TextUtils.isEmpty(((MessageForStructing)localObject).structingMsg.mMsgActionData)))
      {
        localObject = new JSONObject(((MessageForStructing)localObject).structingMsg.mMsgActionData).optString("push_rowkey", "");
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.e("KandianRedDotInfo", 2, localException, new Object[0]);
    }
    return "";
  }
  
  public boolean hasArticleID()
  {
    return (this.articleIDList != null) && (!this.articleIDList.isEmpty());
  }
  
  public void removeFromDiskAsync(boolean paramBoolean)
  {
    ors.a(this.type, paramBoolean);
  }
  
  public void saveToDiskAsync(boolean paramBoolean)
  {
    ors.a(this.type, this, true);
  }
  
  public boolean shouldRemoveFloatingRedPntArticleId()
  {
    return (this.floatingWinData != null) && (this.floatingWinData.remove);
  }
  
  public String toString()
  {
    return "KandianRedDotInfo{type='" + this.type + '\'' + ", articleIDList=" + this.articleIDList + ", algorithmID=" + this.algorithmID + ", strategyID=" + this.strategyID + ", cookie='" + this.cookie + '\'' + ", forderStatus='" + this.forderStatus + '\'' + ", extInfo='" + this.extInfo + '\'' + ", msgData=" + Arrays.toString(this.msgData) + ", rowkey='" + this.rowkey + '\'' + ", floatingWinData=" + this.floatingWinData + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo
 * JD-Core Version:    0.7.0.1
 */