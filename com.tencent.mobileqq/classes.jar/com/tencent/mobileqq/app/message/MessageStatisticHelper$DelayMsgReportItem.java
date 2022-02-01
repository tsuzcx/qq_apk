package com.tencent.mobileqq.app.message;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MessageStatisticHelper$DelayMsgReportItem
{
  private static LinkedList<DelayMsgReportItem> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  int b;
  int c;
  
  public static DelayMsgReportItem a(int paramInt1, String paramString, long paramLong, int paramInt2, int paramInt3)
  {
    try
    {
      DelayMsgReportItem localDelayMsgReportItem;
      if (jdField_a_of_type_JavaUtilLinkedList.size() > 0) {
        localDelayMsgReportItem = (DelayMsgReportItem)jdField_a_of_type_JavaUtilLinkedList.remove(0);
      } else {
        localDelayMsgReportItem = new DelayMsgReportItem();
      }
      localDelayMsgReportItem.jdField_a_of_type_Int = paramInt1;
      localDelayMsgReportItem.jdField_a_of_type_JavaLangString = paramString;
      localDelayMsgReportItem.jdField_a_of_type_Long = paramLong;
      localDelayMsgReportItem.b = paramInt2;
      localDelayMsgReportItem.c = paramInt3;
      return localDelayMsgReportItem;
    }
    finally {}
  }
  
  public static void a(List<DelayMsgReportItem> paramList)
  {
    try
    {
      int i = jdField_a_of_type_JavaUtilLinkedList.size();
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
        jdField_a_of_type_JavaUtilLinkedList.add(localDelayMsgReportItem);
        i = jdField_a_of_type_JavaUtilLinkedList.size();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.MessageStatisticHelper.DelayMsgReportItem
 * JD-Core Version:    0.7.0.1
 */