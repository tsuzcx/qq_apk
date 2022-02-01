package com.dataline.core;

import com.dataline.util.DataLineReportUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.DatalineMessageManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.data.DataLineMsgSetList;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.open.pcpush.PCPushProxy;
import com.tencent.open.pcpush.PCPushProxy.OnDownloadListener;
import com.tencent.open.pcpush.PCPushProxy.PkgEntry;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MoloHandler
{
  DataLineHandler jdField_a_of_type_ComTencentMobileqqAppDataLineHandler;
  private PCPushProxy.OnDownloadListener jdField_a_of_type_ComTencentOpenPcpushPCPushProxy$OnDownloadListener = new MoloHandler.1(this);
  
  public MoloHandler(DataLineHandler paramDataLineHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler = paramDataLineHandler;
    PCPushProxy.a().a(this.jdField_a_of_type_ComTencentOpenPcpushPCPushProxy$OnDownloadListener);
  }
  
  private long a(String paramString)
  {
    try
    {
      paramString = paramString.toUpperCase();
      int i = paramString.indexOf('G');
      if (i != -1) {
        return (Float.parseFloat(paramString.substring(0, i)) * 1024.0F * 1024.0F * 1024.0F);
      }
      i = paramString.indexOf('M');
      if (i != -1) {
        return (Float.parseFloat(paramString.substring(0, i)) * 1024.0F * 1024.0F);
      }
      i = paramString.indexOf('K');
      if (i != -1) {
        return (Float.parseFloat(paramString.substring(0, i)) * 1024.0F);
      }
      i = paramString.indexOf('B');
      if (i != -1)
      {
        float f = Float.parseFloat(paramString.substring(0, i));
        return f;
      }
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public int a(String paramString)
  {
    DataLineReportUtil.j(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a);
    int i = PCPushProxy.a().a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy open(" + paramString + "):" + i);
    }
    return i;
  }
  
  public DataLineMsgRecord a(byte[] paramArrayOfByte)
  {
    boolean bool2 = true;
    Object localObject = null;
    PCPushProxy.a().a(this.jdField_a_of_type_ComTencentOpenPcpushPCPushProxy$OnDownloadListener);
    for (;;)
    {
      try
      {
        PCPushProxy.PkgEntry localPkgEntry = PCPushProxy.a().a(paramArrayOfByte);
        paramArrayOfByte = localObject;
        if (localPkgEntry != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("dataline.MoloHandler", 2, "dealWith new pkgEntry:" + localPkgEntry.e);
          }
          long l = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a(0).longValue();
          paramArrayOfByte = new DataLineMsgRecord();
          paramArrayOfByte.msg = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getApp().getString(2131693760);
          paramArrayOfByte.msgtype = -2335;
          paramArrayOfByte.sessionid = l;
          paramArrayOfByte.isread = false;
          paramArrayOfByte.path = null;
          paramArrayOfByte.thumbPath = null;
          paramArrayOfByte.filename = localPkgEntry.e;
          paramArrayOfByte.filesize = a(localPkgEntry.h);
          paramArrayOfByte.issuc = false;
          paramArrayOfByte.vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.b();
          paramArrayOfByte.time = MessageCache.a();
          paramArrayOfByte.strMoloKey = localPkgEntry.a;
          paramArrayOfByte.strMoloSource = localPkgEntry.i;
          paramArrayOfByte.strMoloIconUrl = localPkgEntry.g;
          paramArrayOfByte.strMoloSrcIconUrl = localPkgEntry.j;
          if (localPkgEntry.b != 1) {
            break label299;
          }
          bool1 = true;
          paramArrayOfByte.bIsApkFile = bool1;
          if (FileManagerUtil.a(paramArrayOfByte.filename) != 0) {
            break label304;
          }
          bool1 = bool2;
          paramArrayOfByte.bIsMoloImage = bool1;
          paramArrayOfByte.fileMsgStatus = 1L;
        }
      }
      catch (Exception localException)
      {
        paramArrayOfByte = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("dataline.MoloHandler", 2, "PCPushProxy.parse Exception:" + localException.toString());
        return null;
      }
      return paramArrayOfByte;
      label299:
      boolean bool1 = false;
      continue;
      label304:
      bool1 = false;
    }
  }
  
  public void a()
  {
    PCPushProxy.a().b(this.jdField_a_of_type_ComTencentOpenPcpushPCPushProxy$OnDownloadListener);
  }
  
  public void a(int paramInt)
  {
    PCPushProxy.a().a(paramInt);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getProxyManager() == null))
    {
      QLog.e("dataline.MoloHandler", 1, "cancelAll app about = null");
      return false;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getProxyManager().a(0).a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getProxyManager().a(0).a(true);
    localObject2 = ((DataLineMsgSetList)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((DataLineMsgSet)((Iterator)localObject2).next()).values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject3).next();
        if (localDataLineMsgRecord.strMoloKey != null) {
          c(localDataLineMsgRecord.strMoloKey);
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((DataLineMsgSetList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((DataLineMsgSet)((Iterator)localObject1).next()).values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (DataLineMsgRecord)((Iterator)localObject2).next();
          if (((DataLineMsgRecord)localObject3).strMoloKey != null) {
            c(((DataLineMsgRecord)localObject3).strMoloKey);
          }
        }
      }
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = PCPushProxy.a().a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy start(" + paramString + "):" + bool);
    }
    if (bool)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.getDataLineMsgProxy(0).a(paramString);
      if (paramString == null) {
        return bool;
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)paramString.next();
        localDataLineMsgRecord.issuc = true;
        localDataLineMsgRecord.fileMsgStatus = 0L;
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.getMessageFacade().a(0).d(localDataLineMsgRecord.msgId);
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(localDataLineMsgRecord.sessionid), localDataLineMsgRecord.path, Byte.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(true), Long.valueOf(localDataLineMsgRecord.filesize) });
      }
    }
    return bool;
  }
  
  public void b(int paramInt)
  {
    PCPushProxy.a().b(paramInt);
  }
  
  public boolean b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler == null) || (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a() == null) || (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getProxyManager() == null))
    {
      QLog.e("dataline.MoloHandler", 1, "deleteAll app about = null");
      return false;
    }
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getProxyManager().a(0).a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getProxyManager().a(0).a(true);
    localObject2 = ((DataLineMsgSetList)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((DataLineMsgSet)((Iterator)localObject2).next()).values().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)((Iterator)localObject3).next();
        if (localDataLineMsgRecord.strMoloKey != null) {
          d(localDataLineMsgRecord.strMoloKey);
        }
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((DataLineMsgSetList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((DataLineMsgSet)((Iterator)localObject1).next()).values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (DataLineMsgRecord)((Iterator)localObject2).next();
          if (((DataLineMsgRecord)localObject3).strMoloKey != null) {
            d(((DataLineMsgRecord)localObject3).strMoloKey);
          }
        }
      }
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    DataLineReportUtil.h(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a);
    PCPushProxy.a().b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy install : " + paramString);
    }
    return true;
  }
  
  public boolean c(String paramString)
  {
    PCPushProxy.a().a(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy pause(" + paramString + ")");
    }
    return true;
  }
  
  public boolean d(String paramString)
  {
    PCPushProxy.a().c(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy delete(" + paramString + ")");
    }
    return true;
  }
  
  public boolean e(String paramString)
  {
    boolean bool = PCPushProxy.a().b(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("dataline.MoloHandler", 2, "PCPushProxy isInstalled(" + paramString + "):" + bool);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.core.MoloHandler
 * JD-Core Version:    0.7.0.1
 */