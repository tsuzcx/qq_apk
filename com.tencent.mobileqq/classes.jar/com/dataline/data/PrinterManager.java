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
  private PrinterManager.PrinterUpdateObserver jdField_a_of_type_ComDatalineDataPrinterManager$PrinterUpdateObserver;
  private SmartDeviceObserver jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<PrinterEntity> jdField_a_of_type_JavaUtilList;
  
  public PrinterManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new PrinterManager.1(this);
    this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver = new PrinterManager.2(this);
  }
  
  public static DeviceInfo a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    if (paramLong != 0L)
    {
      paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
      if (paramQQAppInterface.a())
      {
        DeviceInfo[] arrayOfDeviceInfo = paramQQAppInterface.a();
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
    PrinterManager.PrinterUpdateObserver localPrinterUpdateObserver = this.jdField_a_of_type_ComDatalineDataPrinterManager$PrinterUpdateObserver;
    if (localPrinterUpdateObserver != null) {
      localPrinterUpdateObserver.a(paramInt);
    }
  }
  
  public PrinterEntity a()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_last_printer");
    str = SharePreferenceUtils.a(localMobileQQ, localStringBuilder.toString());
    a();
    return b(str);
  }
  
  public PrinterEntity a(long paramLong)
  {
    if ((paramLong != 0L) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        PrinterEntity localPrinterEntity = (PrinterEntity)localIterator.next();
        if (localPrinterEntity.jdField_a_of_type_Long == paramLong) {
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
      localPCQQPrinter.jdField_a_of_type_Int = 1;
      localPCQQPrinter.jdField_a_of_type_Long = 0L;
      localPCQQPrinter.jdField_a_of_type_JavaLangString = paramString;
      localPCQQPrinter.c = true;
      localPCQQPrinter.b = true;
      localPCQQPrinter.jdField_a_of_type_Boolean = true;
      return localPCQQPrinter;
    }
    return null;
  }
  
  public List<PrinterEntity> a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = (DataLineHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (((DataLineHandler)localObject).a.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = ((DataLineHandler)localObject).a.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        PrinterEntity localPrinterEntity = a((String)((Iterator)localObject).next());
        this.jdField_a_of_type_JavaUtilList.add(localPrinterEntity);
      }
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver);
    }
    this.jdField_a_of_type_ComDatalineDataPrinterManager$PrinterUpdateObserver = null;
  }
  
  public void a(PrinterManager.PrinterUpdateObserver paramPrinterUpdateObserver)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentDeviceDevicemgrSmartDeviceObserver);
    }
    this.jdField_a_of_type_ComDatalineDataPrinterManager$PrinterUpdateObserver = paramPrinterUpdateObserver;
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {
      return;
    }
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    MobileQQ localMobileQQ = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("_last_printer");
    SharePreferenceUtils.a(localMobileQQ, localStringBuilder.toString(), paramString);
  }
  
  public boolean a()
  {
    return ((RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).a() != 0;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      int i = FileManagerUtil.a(paramString);
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
  
  public PrinterEntity b(String paramString)
  {
    if ((paramString != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        PrinterEntity localPrinterEntity = (PrinterEntity)localIterator.next();
        if (localPrinterEntity.jdField_a_of_type_JavaLangString.equals(paramString)) {
          return localPrinterEntity;
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.data.PrinterManager
 * JD-Core Version:    0.7.0.1
 */