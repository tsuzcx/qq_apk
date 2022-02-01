package com.tencent.mobileqq.app;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.HPPrinterStateInfo;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo;

public class PrinterHandler
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  public PrinterSessionAdapter a;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new PrinterHandler.3(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  public String a;
  public ArrayList<PrinterItemMsgRecord> a;
  HashMap<Long, PrinterItemMsgRecord> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public List<String> a;
  public List<C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo> b = null;
  
  public PrinterHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  public int a()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (DataLineMsgProxy.a((BaseProxyManager)localObject2, "mr_dataline_printer")) {
      ((ProxyManager)localObject2).transSaveToDatabase((EntityManager)localObject1);
    }
    long l = 2147483647L;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      l = ((PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0)).msgId;
    }
    localObject2 = ((EntityManager)localObject1).rawQuery(PrinterItemMsgRecord.class, "select * from mr_dataline_printer where msgid<? order by msgid desc limit 5", new String[] { String.valueOf(l) });
    ((EntityManager)localObject1).close();
    if (localObject2 != null)
    {
      int k = ((List)localObject2).size();
      int i = 0;
      for (;;)
      {
        j = k;
        if (i >= ((List)localObject2).size()) {
          break;
        }
        localObject1 = (PrinterItemMsgRecord)((List)localObject2).get(i);
        if (((PrinterItemMsgRecord)localObject1).status < 10) {
          ((PrinterItemMsgRecord)localObject1).status = 11;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(0, localObject1);
        i += 1;
      }
    }
    int j = 0;
    return j;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  public void a(int paramInt, Session paramSession, double paramDouble, boolean paramBoolean)
  {
    if (!DataLineHandler.a(paramSession, "printer")) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        long l1;
        Object localObject;
        StringBuilder localStringBuilder;
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          l1 = this.jdField_a_of_type_Long + 1L;
          this.jdField_a_of_type_Long = l1;
          localObject = new PrinterItemMsgRecord(l1);
          ((PrinterItemMsgRecord)localObject).uSessionID = paramSession.uSessionID;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("获得printID=");
            localStringBuilder.append(((PrinterItemMsgRecord)localObject).uSessionID);
            localStringBuilder.append(", path=");
            localStringBuilder.append(paramSession.strFilePathSrc);
            QLog.d("dataline.Printer", 2, localStringBuilder.toString());
          }
          ((PrinterItemMsgRecord)localObject).filename = paramSession.strFilePathSrc;
          ((PrinterItemMsgRecord)localObject).time = MessageCache.a();
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
          b((PrinterItemMsgRecord)localObject);
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((PrinterItemMsgRecord)localObject).uSessionID), localObject);
          return;
        }
        paramSession = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramSession.uSessionID));
        if (paramSession != null)
        {
          if (paramBoolean)
          {
            paramSession.progress = 0.699999988079071D;
            paramSession.status = 2;
            localObject = new Timer();
            paramSession.mTimer_for_Print = ((Timer)localObject);
            localObject = new PrinterHandler.2(this, paramSession.uSessionID, (Timer)localObject);
            long l2 = MessageCache.a();
            if (l2 >= paramSession.time) {
              l1 = l2 - paramSession.time;
            } else {
              l1 = l2;
            }
            l1 = Math.max(Math.min(l1, 1800L), 60L);
            if (QLog.isDevelopLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("printID=");
              localStringBuilder.append(paramSession.uSessionID);
              localStringBuilder.append(", 当前时间[");
              localStringBuilder.append(l2);
              localStringBuilder.append("], 开始时间[");
              localStringBuilder.append(paramSession.time);
              localStringBuilder.append("], 超时时间[");
              localStringBuilder.append(l1);
              QLog.d("dataline.Printer", 4, localStringBuilder.toString());
            }
            paramSession.mTimer_for_Print.schedule((TimerTask)localObject, l1 * 1000L);
            return;
          }
          paramSession.status = 12;
          c(paramSession);
        }
      }
      else
      {
        paramSession = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramSession.uSessionID));
        if (paramSession != null)
        {
          paramSession.status = 2;
          paramSession.progress = ((float)(paramDouble * 0.7D));
        }
      }
    }
    else
    {
      paramSession = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramSession.uSessionID));
      if (paramSession != null)
      {
        paramSession.status = 2;
        paramSession.progress = (paramDouble * 0.7D);
      }
    }
  }
  
  public void a(Context paramContext, String paramString)
  {
    if (FileManagerUtil.a())
    {
      if (FileUtils.getFileSizes(paramString) > ((IFMConfig)QRoute.api(IFMConfig.class)).getFlowDialogSize())
      {
        FMDialogUtil.a(paramContext, 2131692561, 2131692566, new PrinterHandler.4(this, paramContext, paramString));
        return;
      }
      localIntent = new Intent(paramContext, PrinterActivity.class);
      localIntent.putExtra(AlbumConstants.h, 55);
      localArrayList = new ArrayList();
      localArrayList.add(paramString);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      paramContext.startActivity(localIntent);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004059", "0X8004059", 0, 0, "", "", "", "");
      return;
    }
    Intent localIntent = new Intent(paramContext, PrinterActivity.class);
    localIntent.putExtra(AlbumConstants.h, 55);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramContext.startActivity(localIntent);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004059", "0X8004059", 0, 0, "", "", "", "");
  }
  
  public void a(DataLineHandler paramDataLineHandler)
  {
    Object localObject = (RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER);
    if ((((RegisterProxySvcPackHandler)localObject).a() == 0) || (((RegisterProxySvcPackHandler)localObject).e() != 1))
    {
      paramDataLineHandler.a(12, false, null);
      if (this.jdField_a_of_type_JavaUtilHashMap.size() > 0)
      {
        localObject = new Timer();
        ((Timer)localObject).schedule(new PrinterHandler.1(this, paramDataLineHandler, (Timer)localObject), 5000L);
      }
    }
  }
  
  public void a(DataLineHandler paramDataLineHandler, msg_comm.Msg paramMsg, C2CType0x211_SubC2CType0x9.MsgBody paramMsgBody)
  {
    int i = paramMsgBody.uint32_CMD.get();
    boolean bool = true;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 6) {
          return;
        }
        paramMsg = (C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter)paramMsgBody.msg_printer.get();
        if (paramMsg == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("dataline.Printer", 2, "收到pc的打印机结果, msgPrinter为空");
          }
          return;
        }
        paramMsg = (C2CType0x211_SubC2CType0x9.MsgBody.HPPrinterStateInfo)paramMsg.hp_printer_state_info.get();
        paramDataLineHandler.notifyUI(19, true, new Object[] { Long.valueOf(paramMsg.uint64_printer_din.get()), paramMsg.str_printer_qr_pic_url.get(), paramMsg.str_printer_qr_open_url.get(), paramMsg.str_printer_tip_url.get() });
        return;
      }
      int j = -1;
      long l2 = 0L;
      paramMsg = (C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter)paramMsgBody.msg_printer.get();
      long l1;
      if (paramMsg == null)
      {
        i = j;
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("dataline.Printer", 2, "收到pc的打印结果, msgPrinter为空");
          i = j;
          l1 = l2;
        }
      }
      else
      {
        j = paramMsg.uint32_print_result.get();
        paramMsg = paramMsg.rpt_uint64_session_id.get();
        if ((paramMsg != null) && (paramMsg.size() != 0))
        {
          l1 = ((Long)paramMsg.get(0)).longValue();
          i = j;
        }
        else
        {
          i = j;
          l1 = l2;
          if (QLog.isColorLevel())
          {
            paramMsg = new StringBuilder();
            paramMsg.append("收到pc的打印结果, rpt_uint64_session_id为空. print_result = ");
            paramMsg.append(j);
            QLog.d("dataline.Printer", 2, paramMsg.toString());
            l1 = l2;
            i = j;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder();
        paramMsg.append("收到pc的打印结果, print_result = ");
        paramMsg.append(i);
        paramMsg.append(", print_id = ");
        paramMsg.append(l1);
        QLog.d("dataline.Printer", 2, paramMsg.toString());
      }
      new Intent().putExtra("sPrintResult", i);
      if (i != 0) {
        bool = false;
      }
      paramDataLineHandler.a(18, bool, Long.valueOf(l1));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004021", "0X8004021", (int)l1, i, "", "", "", "");
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("dataline.Printer", 4, "收到pc的打印机列表");
    }
    paramMsg = (PrinterStatusHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER);
    paramMsg.a(false);
    paramMsgBody = (C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter)paramMsgBody.msg_printer.get();
    if (paramMsgBody == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Printer", 2, "收到pc的打印机列表, msgPrinter为空");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList = paramMsgBody.rpt_string_printer.get();
    this.b = paramMsgBody.rpt_msg_support_file_info.get();
    if (((RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.REGPRXYSVCPACK_HANDLER)).a() != 0)
    {
      paramMsgBody = this.jdField_a_of_type_JavaUtilList;
      if ((paramMsgBody != null) && (paramMsgBody.size() > 0)) {
        paramMsg.a(true);
      }
    }
    paramDataLineHandler.a(12, false, null);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004022", "0X8004022", 0, 0, "", "", "", "");
  }
  
  public void a(PrinterItemMsgRecord paramPrinterItemMsgRecord)
  {
    if (paramPrinterItemMsgRecord.mTimer_for_Print != null)
    {
      paramPrinterItemMsgRecord.mTimer_for_Print.cancel();
      paramPrinterItemMsgRecord.mTimer_for_Print = null;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramPrinterItemMsgRecord);
    this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramPrinterItemMsgRecord.uSessionID));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004021", "0X8004021", (int)paramPrinterItemMsgRecord.uSessionID, -2, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().addMsgQueue(String.valueOf(0), 0, paramPrinterItemMsgRecord.getTableName(), "msgId=?", new String[] { String.valueOf(paramPrinterItemMsgRecord.msgId) }, 2, null);
  }
  
  public void a(Long paramLong, boolean paramBoolean)
  {
    PrinterItemMsgRecord localPrinterItemMsgRecord2 = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilHashMap.get(paramLong);
    PrinterItemMsgRecord localPrinterItemMsgRecord1 = localPrinterItemMsgRecord2;
    int i;
    if (localPrinterItemMsgRecord2 == null)
    {
      i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      for (;;)
      {
        localPrinterItemMsgRecord1 = localPrinterItemMsgRecord2;
        if (i < 0) {
          break;
        }
        if (((PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uSessionID == paramLong.longValue())
        {
          localPrinterItemMsgRecord1 = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          break;
        }
        i -= 1;
      }
    }
    if (localPrinterItemMsgRecord1 != null)
    {
      if (paramBoolean) {
        i = 10;
      } else {
        i = 11;
      }
      localPrinterItemMsgRecord1.status = i;
      localPrinterItemMsgRecord1.progress = 1.0D;
      if (localPrinterItemMsgRecord1.mTimer_for_Print != null)
      {
        localPrinterItemMsgRecord1.mTimer_for_Print.cancel();
        localPrinterItemMsgRecord1.mTimer_for_Print = null;
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramLong);
      c(localPrinterItemMsgRecord1);
    }
  }
  
  public String[] a()
  {
    if (((PrinterStatusHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PRINTER_STATUS_HANDLER)).a())
    {
      localObject = this.b;
      if (localObject != null)
      {
        String[] arrayOfString = new String[((List)localObject).size()];
        int i = this.b.size() - 1;
        for (;;)
        {
          localObject = arrayOfString;
          if (i < 0) {
            break;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(".");
          ((StringBuilder)localObject).append(((C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo)this.b.get(i)).str_file_suffix.get());
          arrayOfString[i] = ((StringBuilder)localObject).toString();
          i -= 1;
        }
      }
    }
    Object localObject = null;
    return localObject;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      while ((this.jdField_a_of_type_JavaUtilArrayList.size() > 5) && (((PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0)).status != 2)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
      return this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    int i = a();
    if (this.jdField_a_of_type_Long == 0L)
    {
      Object localObject;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
      {
        localObject = this.jdField_a_of_type_JavaUtilArrayList;
        this.jdField_a_of_type_Long = ((PrinterItemMsgRecord)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1)).msgId;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("初始化PrinterItemMsgRecord的msgid为");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
        QLog.d("dataline.Printer", 2, ((StringBuilder)localObject).toString());
      }
    }
    return i;
  }
  
  public void b(PrinterItemMsgRecord paramPrinterItemMsgRecord)
  {
    ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
    PrinterItemMsgRecord localPrinterItemMsgRecord = paramPrinterItemMsgRecord.clone();
    localProxyManager.addMsgQueue(String.valueOf(0), 0, paramPrinterItemMsgRecord.getTableName(), localPrinterItemMsgRecord, 0, null);
  }
  
  public void c(PrinterItemMsgRecord paramPrinterItemMsgRecord)
  {
    ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(paramPrinterItemMsgRecord.status));
    localProxyManager.addMsgQueue(String.valueOf(0), 0, paramPrinterItemMsgRecord.getTableName(), localContentValues, "msgId=?", new String[] { String.valueOf(paramPrinterItemMsgRecord.msgId) }, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterHandler
 * JD-Core Version:    0.7.0.1
 */