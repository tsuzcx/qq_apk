package com.tencent.mobileqq.app.handler.receivesuccess;

import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qlink.QlinkServiceManager;

public class NearFieldTranFileSvrNotifyList
{
  public static void a(QQAppInterface paramQQAppInterface, Object paramObject, String paramString)
  {
    if ("NearFieldTranFileSvr.NotifyList".equalsIgnoreCase(paramString)) {
      paramQQAppInterface.getQlinkServiceMgr().a((byte[])paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.handler.receivesuccess.NearFieldTranFileSvrNotifyList
 * JD-Core Version:    0.7.0.1
 */