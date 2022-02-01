package com.tencent.biz.qcircleshadow.local.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCirclePrivateMsgShow.UserPMGiftInfo;
import qqcircle.QQCircleReport.SingleDcData;

public class QCircleHostProtoUtil
{
  public static List<QQCircleReport.SingleDcData> a(List<byte[]> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCircleReport.SingleDcData localSingleDcData = a((byte[])paramList.next());
      if (localSingleDcData != null) {
        localArrayList.add(localSingleDcData);
      }
    }
    return localArrayList;
  }
  
  public static QQCirclePrivateMsgShow.UserPMGiftInfo a(byte[] paramArrayOfByte)
  {
    try
    {
      QQCirclePrivateMsgShow.UserPMGiftInfo localUserPMGiftInfo = new QQCirclePrivateMsgShow.UserPMGiftInfo();
      localUserPMGiftInfo.mergeFrom(paramArrayOfByte);
      return localUserPMGiftInfo;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static QQCircleReport.SingleDcData a(byte[] paramArrayOfByte)
  {
    try
    {
      QQCircleReport.SingleDcData localSingleDcData = new QQCircleReport.SingleDcData();
      localSingleDcData.mergeFrom(paramArrayOfByte);
      return localSingleDcData;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  public static List<QQCirclePrivateMsgShow.UserPMGiftInfo> b(List<byte[]> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QQCirclePrivateMsgShow.UserPMGiftInfo localUserPMGiftInfo = a((byte[])paramList.next());
      if (localUserPMGiftInfo != null) {
        localArrayList.add(localUserPMGiftInfo);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.util.QCircleHostProtoUtil
 * JD-Core Version:    0.7.0.1
 */