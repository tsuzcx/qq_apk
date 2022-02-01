package com.tencent.mobileqq.app.message;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MessageStatisticHelper$DelayMsgReportItem
{
  private static LinkedList<DelayMsgReportItem> f = new LinkedList();
  int a;
  String b;
  long c;
  int d;
  int e;
  
  public static DelayMsgReportItem a(int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    try
    {
      DelayMsgReportItem localDelayMsgReportItem;
      if (f.size() > 0) {
        localDelayMsgReportItem = (DelayMsgReportItem)f.remove(0);
      } else {
        localDelayMsgReportItem = new DelayMsgReportItem();
      }
      localDelayMsgReportItem.a = paramInt1;
      localDelayMsgReportItem.b = paramString;
      localDelayMsgReportItem.c = paramLong;
      localDelayMsgReportItem.d = paramInt2;
      localDelayMsgReportItem.e = paramInt3;
      return localDelayMsgReportItem;
    }
    finally {}
  }
  
  public static void a(List<DelayMsgReportItem> paramList)
  {
    try
    {
      int i = f.size();
      if (i >= 100) {
        return;
      }
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
        DelayMsgReportItem localDelayMsgReportItem = (DelayMsgReportItem)paramList.next();
        f.add(localDelayMsgReportItem);
        i = f.size();
      } while (i < 100);
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MessageStatisticHelper.DelayMsgReportItem
 * JD-Core Version:    0.7.0.1
 */