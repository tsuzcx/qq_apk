import android.content.ContentValues;
import android.content.Intent;
import com.dataline.activities.PrinterActivity;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PrinterHandler.1;
import com.tencent.mobileqq.app.PrinterHandler.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
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

public class amxk
{
  long jdField_a_of_type_Long = 0L;
  private amqk jdField_a_of_type_Amqk = new amxl(this);
  public QQAppInterface a;
  public es a;
  public String a;
  public ArrayList<PrinterItemMsgRecord> a;
  public HashMap<Long, PrinterItemMsgRecord> a;
  public List<String> a;
  public List<C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo> b;
  
  public amxk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amqk);
  }
  
  public int a()
  {
    int i = 0;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (anuv.a((ProxyManager)localObject2, "mr_dataline_printer")) {
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
      int j = ((List)localObject2).size();
      i = 0;
      while (i < ((List)localObject2).size())
      {
        localObject1 = (PrinterItemMsgRecord)((List)localObject2).get(i);
        if (((PrinterItemMsgRecord)localObject1).status < 10) {
          ((PrinterItemMsgRecord)localObject1).status = 11;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(0, localObject1);
        i += 1;
      }
      i = j;
    }
    return i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amqk);
  }
  
  public void a(int paramInt, Session paramSession, double paramDouble, boolean paramBoolean)
  {
    if (!amqd.a(paramSession, "printer")) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt)
          {
          default: 
            return;
          case 0: 
            paramSession = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramSession.uSessionID));
          }
        } while (paramSession == null);
        paramSession.status = 2;
        paramSession.progress = (0.7D * paramDouble);
        return;
        l1 = this.jdField_a_of_type_Long + 1L;
        this.jdField_a_of_type_Long = l1;
        localObject = new PrinterItemMsgRecord(l1);
        ((PrinterItemMsgRecord)localObject).uSessionID = paramSession.uSessionID;
        if (QLog.isColorLevel()) {
          QLog.d("dataline.Printer", 2, "获得printID=" + ((PrinterItemMsgRecord)localObject).uSessionID + ", path=" + paramSession.strFilePathSrc);
        }
        ((PrinterItemMsgRecord)localObject).filename = paramSession.strFilePathSrc;
        ((PrinterItemMsgRecord)localObject).time = bbko.a();
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        b((PrinterItemMsgRecord)localObject);
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((PrinterItemMsgRecord)localObject).uSessionID), localObject);
        return;
        paramSession = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramSession.uSessionID));
      } while (paramSession == null);
      paramSession.status = 2;
      paramSession.progress = ((float)(0.7D * paramDouble));
      return;
      paramSession = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramSession.uSessionID));
    } while (paramSession == null);
    long l2;
    if (paramBoolean)
    {
      paramSession.progress = 0.699999988079071D;
      paramSession.status = 2;
      localObject = new Timer();
      paramSession.mTimer_for_Print = ((Timer)localObject);
      localObject = new PrinterHandler.2(this, paramSession.uSessionID, (Timer)localObject);
      l2 = bbko.a();
      if (l2 < paramSession.time) {
        break label454;
      }
    }
    label454:
    for (long l1 = l2 - paramSession.time;; l1 = l2)
    {
      l1 = Math.max(Math.min(l1, 1800L), 60L);
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.Printer", 4, "printID=" + paramSession.uSessionID + ", 当前时间[" + l2 + "], 开始时间[" + paramSession.time + "], 超时时间[" + l1);
      }
      paramSession.mTimer_for_Print.schedule((TimerTask)localObject, l1 * 1000L);
      return;
      paramSession.status = 12;
      c(paramSession);
      return;
    }
  }
  
  public void a(amqd paramamqd)
  {
    Object localObject = (amzy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(10);
    if ((((amzy)localObject).a() == 0) || (((amzy)localObject).e() != 1))
    {
      paramamqd.a(12, false, null);
      if (this.jdField_a_of_type_JavaUtilHashMap.size() > 0)
      {
        localObject = new Timer();
        ((Timer)localObject).schedule(new PrinterHandler.1(this, paramamqd, (Timer)localObject), 5000L);
      }
    }
  }
  
  public void a(amqd paramamqd, msg_comm.Msg paramMsg, C2CType0x211_SubC2CType0x9.MsgBody paramMsgBody)
  {
    boolean bool = false;
    int j;
    int i;
    long l;
    switch (paramMsgBody.uint32_CMD.get())
    {
    case 4: 
    case 5: 
    default: 
    case 2: 
      do
      {
        return;
        if (QLog.isDevelopLevel()) {
          QLog.d("dataline.Printer", 4, "收到pc的打印机列表");
        }
        paramMsg = (amxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(74);
        paramMsg.a(false);
        paramMsgBody = (C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter)paramMsgBody.msg_printer.get();
        if (paramMsgBody != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("dataline.Printer", 2, "收到pc的打印机列表, msgPrinter为空");
      return;
      this.jdField_a_of_type_JavaUtilList = paramMsgBody.rpt_string_printer.get();
      this.b = paramMsgBody.rpt_msg_support_file_info.get();
      if ((((amzy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(10)).a() != 0) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        paramMsg.a(true);
      }
      paramamqd.a(12, false, null);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004022", "0X8004022", 0, 0, "", "", "", "");
      return;
    case 3: 
      j = -1;
      paramMsg = (C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter)paramMsgBody.msg_printer.get();
      if (paramMsg == null)
      {
        i = j;
        if (!QLog.isColorLevel()) {
          break label579;
        }
        QLog.d("dataline.Printer", 2, "收到pc的打印结果, msgPrinter为空");
        l = 0L;
        i = j;
      }
      break;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Printer", 2, "收到pc的打印结果, print_result = " + i + ", print_id = " + l);
      }
      new Intent().putExtra("sPrintResult", i);
      if (i == 0) {
        bool = true;
      }
      paramamqd.a(18, bool, Long.valueOf(l));
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004021", "0X8004021", (int)l, i, "", "", "", "");
      return;
      j = paramMsg.uint32_print_result.get();
      paramMsg = paramMsg.rpt_uint64_session_id.get();
      if ((paramMsg == null) || (paramMsg.size() == 0))
      {
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("dataline.Printer", 2, "收到pc的打印结果, rpt_uint64_session_id为空. print_result = " + j);
          l = 0L;
          i = j;
        }
      }
      else
      {
        l = ((Long)paramMsg.get(0)).longValue();
        i = j;
        continue;
        paramMsg = (C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter)paramMsgBody.msg_printer.get();
        if (paramMsg == null)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("dataline.Printer", 2, "收到pc的打印机结果, msgPrinter为空");
          return;
        }
        paramMsg = (C2CType0x211_SubC2CType0x9.MsgBody.HPPrinterStateInfo)paramMsg.hp_printer_state_info.get();
        paramamqd.notifyUI(19, true, new Object[] { Long.valueOf(paramMsg.uint64_printer_din.get()), paramMsg.str_printer_qr_pic_url.get(), paramMsg.str_printer_qr_open_url.get(), paramMsg.str_printer_tip_url.get() });
        return;
      }
      label579:
      l = 0L;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (aszt.a())
    {
      if (FileUtils.getFileSizes(paramString) > asld.a())
      {
        aszg.a(paramBaseActivity, 2131692374, 2131692379, new amxm(this, paramBaseActivity, paramString));
        return;
      }
      localIntent = new Intent(paramBaseActivity, PrinterActivity.class);
      localIntent.putExtra(bftk.h, 55);
      localArrayList = new ArrayList();
      localArrayList.add(paramString);
      localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
      paramBaseActivity.startActivity(localIntent);
      bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004059", "0X8004059", 0, 0, "", "", "", "");
      return;
    }
    Intent localIntent = new Intent(paramBaseActivity, PrinterActivity.class);
    localIntent.putExtra(bftk.h, 55);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramBaseActivity.startActivity(localIntent);
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004059", "0X8004059", 0, 0, "", "", "", "");
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
    bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004021", "0X8004021", (int)paramPrinterItemMsgRecord.uSessionID, -2, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().addMsgQueue(String.valueOf(0), 0, paramPrinterItemMsgRecord.getTableName(), "msgId=?", new String[] { String.valueOf(paramPrinterItemMsgRecord.msgId) }, 2, null);
  }
  
  public void a(Long paramLong, boolean paramBoolean)
  {
    PrinterItemMsgRecord localPrinterItemMsgRecord = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilHashMap.get(paramLong);
    int i;
    if (localPrinterItemMsgRecord == null)
    {
      i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (i >= 0) {
        if (((PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i)).uSessionID == paramLong.longValue()) {
          localPrinterItemMsgRecord = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        }
      }
    }
    for (;;)
    {
      if (localPrinterItemMsgRecord != null) {
        if (!paramBoolean) {
          break label136;
        }
      }
      label136:
      for (i = 10;; i = 11)
      {
        localPrinterItemMsgRecord.status = i;
        localPrinterItemMsgRecord.progress = 1.0D;
        if (localPrinterItemMsgRecord.mTimer_for_Print != null)
        {
          localPrinterItemMsgRecord.mTimer_for_Print.cancel();
          localPrinterItemMsgRecord.mTimer_for_Print = null;
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramLong);
        c(localPrinterItemMsgRecord);
        return;
        i -= 1;
        break;
      }
    }
  }
  
  public String[] a()
  {
    if ((((amxn)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(74)).a()) && (this.b != null))
    {
      String[] arrayOfString = new String[this.b.size()];
      int i = this.b.size() - 1;
      while (i >= 0)
      {
        arrayOfString[i] = ("." + ((C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo)this.b.get(i)).str_file_suffix.get());
        i -= 1;
      }
      return arrayOfString;
    }
    return null;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      for (;;)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() <= 5) || (((PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0)).status == 2)) {
          return this.jdField_a_of_type_JavaUtilArrayList.size();
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
    }
    int i = a();
    if (this.jdField_a_of_type_Long == 0L)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_Long = ((PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).msgId;
      }
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Printer", 2, "初始化PrinterItemMsgRecord的msgid为" + this.jdField_a_of_type_Long);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxk
 * JD-Core Version:    0.7.0.1
 */