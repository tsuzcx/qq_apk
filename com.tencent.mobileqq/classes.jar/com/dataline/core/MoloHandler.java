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
    long l = 0L;
    float f;
    try
    {
      paramString = paramString.toUpperCase();
      int i = paramString.indexOf('G');
      if (i != -1)
      {
        f = Float.parseFloat(paramString.substring(0, i)) * 1024.0F;
      }
      else
      {
        i = paramString.indexOf('M');
        if (i != -1)
        {
          f = Float.parseFloat(paramString.substring(0, i));
        }
        else
        {
          i = paramString.indexOf('K');
          if (i != -1)
          {
            f = Float.parseFloat(paramString.substring(0, i));
            break label123;
          }
          i = paramString.indexOf('B');
          if (i != -1)
          {
            f = Float.parseFloat(paramString.substring(0, i));
            l = f;
          }
          return l;
        }
      }
    }
    catch (Exception paramString)
    {
      return 0L;
    }
    f *= 1024.0F;
    label123:
    return (f * 1024.0F);
  }
  
  public int a(String paramString)
  {
    DataLineReportUtil.j(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a);
    int i = PCPushProxy.a().a(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PCPushProxy open(");
      localStringBuilder.append(paramString);
      localStringBuilder.append("):");
      localStringBuilder.append(i);
      QLog.d("dataline.MoloHandler", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public DataLineMsgRecord a(byte[] paramArrayOfByte)
  {
    PCPushProxy.a().a(this.jdField_a_of_type_ComTencentOpenPcpushPCPushProxy$OnDownloadListener);
    try
    {
      paramArrayOfByte = PCPushProxy.a().a(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dealWith new pkgEntry:");
          ((StringBuilder)localObject).append(paramArrayOfByte.e);
          QLog.d("dataline.MoloHandler", 2, ((StringBuilder)localObject).toString());
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler;
        boolean bool2 = false;
        long l = ((DataLineHandler)localObject).a(0).longValue();
        localObject = new DataLineMsgRecord();
        ((DataLineMsgRecord)localObject).msg = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getApp().getString(2131693713);
        ((DataLineMsgRecord)localObject).msgtype = -2335;
        ((DataLineMsgRecord)localObject).sessionid = l;
        ((DataLineMsgRecord)localObject).isread = false;
        ((DataLineMsgRecord)localObject).path = null;
        ((DataLineMsgRecord)localObject).thumbPath = null;
        ((DataLineMsgRecord)localObject).filename = paramArrayOfByte.e;
        ((DataLineMsgRecord)localObject).filesize = a(paramArrayOfByte.h);
        ((DataLineMsgRecord)localObject).issuc = false;
        ((DataLineMsgRecord)localObject).vipBubbleID = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.b();
        ((DataLineMsgRecord)localObject).time = MessageCache.a();
        ((DataLineMsgRecord)localObject).strMoloKey = paramArrayOfByte.a;
        ((DataLineMsgRecord)localObject).strMoloSource = paramArrayOfByte.i;
        ((DataLineMsgRecord)localObject).strMoloIconUrl = paramArrayOfByte.g;
        ((DataLineMsgRecord)localObject).strMoloSrcIconUrl = paramArrayOfByte.j;
        if (paramArrayOfByte.b == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((DataLineMsgRecord)localObject).bIsApkFile = bool1;
        boolean bool1 = bool2;
        if (FileManagerUtil.a(((DataLineMsgRecord)localObject).filename) == 0) {
          bool1 = true;
        }
        ((DataLineMsgRecord)localObject).bIsMoloImage = bool1;
        ((DataLineMsgRecord)localObject).fileMsgStatus = 1L;
        return localObject;
      }
      return null;
    }
    catch (Exception paramArrayOfByte)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("PCPushProxy.parse Exception:");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        QLog.d("dataline.MoloHandler", 2, ((StringBuilder)localObject).toString());
      }
    }
    return null;
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler;
    if ((localObject1 != null) && (((DataLineHandler)localObject1).a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getProxyManager() != null))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getProxyManager().a(0).a();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getProxyManager().a(0).a(true);
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
    QLog.e("dataline.MoloHandler", 1, "cancelAll app about = null");
    return false;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = PCPushProxy.a().a(paramString);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("PCPushProxy start(");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("):");
      ((StringBuilder)localObject).append(bool);
      QLog.d("dataline.MoloHandler", 2, ((StringBuilder)localObject).toString());
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
        localObject = (DataLineMsgRecord)paramString.next();
        ((DataLineMsgRecord)localObject).issuc = true;
        ((DataLineMsgRecord)localObject).fileMsgStatus = 0L;
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a.getMessageFacade().a(0).d(((DataLineMsgRecord)localObject).msgId);
        this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a(6, true, new Object[] { Long.valueOf(0L), Long.valueOf(((DataLineMsgRecord)localObject).sessionid), ((DataLineMsgRecord)localObject).path, Byte.valueOf(0), Boolean.valueOf(false), Boolean.valueOf(true), Long.valueOf(((DataLineMsgRecord)localObject).filesize) });
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
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler;
    if ((localObject1 != null) && (((DataLineHandler)localObject1).a() != null) && (this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getProxyManager() != null))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getProxyManager().a(0).a();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a().getProxyManager().a(0).a(true);
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
    QLog.e("dataline.MoloHandler", 1, "deleteAll app about = null");
    return false;
  }
  
  public boolean b(String paramString)
  {
    DataLineReportUtil.h(this.jdField_a_of_type_ComTencentMobileqqAppDataLineHandler.a);
    PCPushProxy.a().b(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PCPushProxy install : ");
      localStringBuilder.append(paramString);
      QLog.d("dataline.MoloHandler", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  public boolean c(String paramString)
  {
    PCPushProxy.a().a(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PCPushProxy pause(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      QLog.d("dataline.MoloHandler", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  public boolean d(String paramString)
  {
    PCPushProxy.a().c(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PCPushProxy delete(");
      localStringBuilder.append(paramString);
      localStringBuilder.append(")");
      QLog.d("dataline.MoloHandler", 2, localStringBuilder.toString());
    }
    return true;
  }
  
  public boolean e(String paramString)
  {
    boolean bool = PCPushProxy.a().b(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PCPushProxy isInstalled(");
      localStringBuilder.append(paramString);
      localStringBuilder.append("):");
      localStringBuilder.append(bool);
      QLog.d("dataline.MoloHandler", 2, localStringBuilder.toString());
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.core.MoloHandler
 * JD-Core Version:    0.7.0.1
 */