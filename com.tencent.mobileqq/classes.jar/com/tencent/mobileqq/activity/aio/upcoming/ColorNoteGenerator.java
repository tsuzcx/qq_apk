package com.tencent.mobileqq.activity.aio.upcoming;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.smallscreen.UpComingMsgModel;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ColorNoteGenerator
{
  protected QQAppInterface a;
  
  protected String a(SessionInfo paramSessionInfo, String paramString)
  {
    if ((paramSessionInfo != null) && (paramSessionInfo.a != 0) && (1 != paramSessionInfo.a) && (3000 != paramSessionInfo.a)) {
      return paramString;
    }
    return "";
  }
  
  protected boolean a(List<MessageRecord> paramList)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!paramList.hasNext()) {
          break;
        }
        if (!((MessageRecord)paramList.next()).isSend()) {
          bool1 = false;
        }
      }
    }
    return bool2;
  }
  
  protected byte[] a(List<MessageRecord> paramList, int paramInt, String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(Long.valueOf(((MessageRecord)localIterator.next()).uniseq));
    }
    int i;
    if ((paramList.size() == 1) && (paramInt == 1)) {
      i = UpComingMsgUtil.a((MessageRecord)paramList.get(0));
    } else {
      i = 8;
    }
    return new UpComingMsgModel(((MessageRecord)paramList.get(0)).frienduin, paramString2, localArrayList, ((MessageRecord)paramList.get(0)).istroop, paramInt, i, paramString1).toJson().getBytes();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.upcoming.ColorNoteGenerator
 * JD-Core Version:    0.7.0.1
 */