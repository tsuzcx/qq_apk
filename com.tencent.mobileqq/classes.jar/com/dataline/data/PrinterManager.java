package com.dataline.data;

import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.devicemgr.SmartDeviceObserver;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.PrinterHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RegisterProxySvcPackHandler;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class PrinterManager
{
  public PrinterEntity a;
  private QQAppInterface b;
  private List<PrinterEntity> c;
  private DataLineObserver d;
  private SmartDeviceObserver e;
  private PrinterManager.PrinterUpdateObserver f;
  
  public PrinterManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.c = new ArrayList();
    this.d = new PrinterManager.1(this);
    this.e = new PrinterManager.2(this);
  }
  
  public static DeviceInfo a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong != 0L)
    {
      paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if (paramQQAppInterface.c())
      {
        DeviceInfo[] arrayOfDeviceInfo = paramQQAppInterface.e();
        if (arrayOfDeviceInfo != null)
        {
          int j = arrayOfDeviceInfo.length;
          int i = 0;
          while (i < j)
          {
            DeviceInfo localDeviceInfo = arrayOfDeviceInfo[i];
            if ((paramQQAppInterface.c(localDeviceInfo.din)) && (paramQQAppInterface.a(localDeviceInfo.din, 17)) && (paramLong == localDeviceInfo.din)) {
              return localDeviceInfo;
            }
            i += 1;
          }
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    a();
    PrinterManager.PrinterUpdateObserver localPrinterUpdateObserver = this.f;
    if (localPrinterUpdateObserver != null) {
      localPrinterUpdateObserver.a(paramInt);
    }
  }
  
  public PrinterEntity a(long paramLong)
  {
    if ((paramLong != 0L) && (this.c.size() > 0))
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        PrinterEntity localPrinterEntity = (PrinterEntity)localIterator.next();
        if (localPrinterEntity.c == paramLong) {
          return localPrinterEntity;
        }
      }
    }
    return null;
  }
  
  public PrinterEntity a(String paramString)
  {
    if (paramString != null)
    {
      PCQQPrinter localPCQQPrinter = new PCQQPrinter();
      localPCQQPrinter.b = 1;
      localPCQQPrinter.c = 0L;
      localPCQQPrinter.a = paramString;
      localPCQQPrinter.f = true;
      localPCQQPrinter.e = true;
      localPCQQPrinter.d = true;
      return localPCQQPrinter;
    }
    return null;
  }
  
  public List<PrinterEntity> a()
  {
    this.c.clear();
    Object localObject = (DataLineHandler)this.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (((DataLineHandler)localObject).e.c != null)
    {
      localObject = ((DataLineHandler)localObject).e.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PrinterEntity localPrinterEntity = a((String)((Iterator)localObject).next());
        this.c.add(localPrinterEntity);
      }
    }
    return this.c;
  }
  
  public void a(PrinterManager.PrinterUpdateObserver paramPrinterUpdateObserver)
  {
    QQAppInterface localQQAppInterface = this.b;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.addObserver(this.d);
      this.b.addObserver(this.e);
    }
    this.f = paramPrinterUpdateObserver;
  }
  
  public PrinterEntity b()
  {
    String str = this.b.getCurrentAccountUin();
    MobileQQ localMobileQQ = this.b.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_last_printer");
    str = SharePreferenceUtils.a(localMobileQQ, localStringBuilder.toString());
    a();
    return b(str);
  }
  
  public PrinterEntity b(String paramString)
  {
    if ((paramString != null) && (this.c.size() > 0))
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        PrinterEntity localPrinterEntity = (PrinterEntity)localIterator.next();
        if (localPrinterEntity.a.equals(paramString)) {
          return localPrinterEntity;
        }
      }
    }
    return null;
  }
  
  public void c()
  {
    QQAppInterface localQQAppInterface = this.b;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this.d);
      this.b.removeObserver(this.e);
    }
    this.f = null;
  }
  
  public boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      int i = FileManagerUtil.c(paramString);
      if ((i != 3) && (i != 0) && (i != 7) && (i != 6) && (i != 9))
      {
        bool1 = bool2;
        if (i != 10) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String str = this.b.getCurrentAccountUin();
    MobileQQ localMobileQQ = this.b.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_last_printer");
    SharePreferenceUtils.a(localMobileQQ, localStringBuilder.toString(), paramString);
  }
  
  public boolean d()
  {
    return ((RegisterProxySvcPackHandler)this.b.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).d() != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.data.PrinterManager
 * JD-Core Version:    0.7.0.1
 */