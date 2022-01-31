package com.tencent.biz.pubaccount.readinjoy.struct;

import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import obz;

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
  public String forderStatus;
  public byte[] msgData;
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
    Object localObject = (MessageForStructing)paramMessageRecord;
    ((MessageForStructing)localObject).parse();
    if (((MessageForStructing)localObject).structingMsg == null) {
      return null;
    }
    paramString = new KandianRedDotInfo(paramString);
    paramString.cookie = ((MessageForStructing)localObject).structingMsg.mMsgActionData;
    paramString.forderStatus = ((MessageForStructing)localObject).structingMsg.reportEventFolderStatusValue;
    paramString.extInfo = ((MessageForStructing)localObject).structingMsg.mExtraData;
    try
    {
      paramString.algorithmID = Long.valueOf(((MessageForStructing)localObject).structingMsg.mAlgorithmIds).longValue();
      paramString.strategyID = Long.valueOf(((MessageForStructing)localObject).structingMsg.mStrategyIds).longValue();
      localObject = obz.a(paramMessageRecord);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str = (String)((Iterator)localObject).next();
          try
          {
            paramString.articleIDList.add(Long.valueOf(str));
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localNumberFormatException.printStackTrace();
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      paramString.msgData = paramMessageRecord.msgData;
    }
    return paramString;
  }
  
  public static KandianRedDotInfo getRedDotFromDisk(AppRuntime paramAppRuntime, String paramString, boolean paramBoolean)
  {
    return (KandianRedDotInfo)obz.a(paramAppRuntime, paramString, paramBoolean);
  }
  
  public MessageRecord getMessageRecord()
  {
    if (this.msgData != null) {
      return a(this.msgData, this.type);
    }
    return null;
  }
  
  public boolean hasArticleID()
  {
    return (this.articleIDList != null) && (!this.articleIDList.isEmpty());
  }
  
  public void removeFromDiskAsync(boolean paramBoolean)
  {
    obz.a(this.type, paramBoolean);
  }
  
  public void saveToDiskAsync(boolean paramBoolean)
  {
    obz.a(this.type, this, true);
  }
  
  public String toString()
  {
    return "KandianRedDotInfo{type='" + this.type + '\'' + ", articleIDList=" + this.articleIDList + ", algorithmID=" + this.algorithmID + ", strategyID=" + this.strategyID + ", cookie='" + this.cookie + '\'' + ", extInfo='" + this.extInfo + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo
 * JD-Core Version:    0.7.0.1
 */