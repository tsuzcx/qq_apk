import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForCommonHobbyForAIOShow;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupController.2;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupController.3;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupController.4;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupController.5;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupController.6;
import com.tencent.mobileqq.msgbackup.data.MsgBackupExtraEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupMsgEntity;
import com.tencent.mobileqq.msgbackup.data.MsgBackupResEntity;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class arox
  implements Handler.Callback, Comparator<MessageRecord>
{
  private static int jdField_a_of_type_Int = 500;
  public static String a;
  private static int jdField_b_of_type_Int = 5000;
  private static int jdField_c_of_type_Int = 1000;
  private static int jdField_d_of_type_Int = 10000;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private arpg jdField_a_of_type_Arpg;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<arov> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<String, arpm> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<String, arph> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  private ConcurrentHashMap<String, arph> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap<String, arph> jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int jdField_e_of_type_Int;
  private ConcurrentHashMap<String, String> jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_JavaLangString = "MsgBackup_MsgBackupController";
  }
  
  public arox(QQAppInterface paramQQAppInterface)
  {
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localObject = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1) {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
    if (this.jdField_b_of_type_AndroidOsHandlerThread == null)
    {
      this.jdField_b_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("MsgbackupController_request", 5);
      this.jdField_b_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_b_of_type_AndroidOsHandlerThread.getLooper(), this);
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler == null)
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("MsgbackupController_flow", 5);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), new aroy(this));
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null)
    {
      int i = Runtime.getRuntime().availableProcessors();
      arsc.a(jdField_a_of_type_JavaLangString, "MsgBackupController cpuCount = %d ", new Object[] { Integer.valueOf(i) });
      paramQQAppInterface = new ThreadPoolParams();
      int j = i * 2 + 1;
      paramQQAppInterface.corePoolsize = i;
      paramQQAppInterface.maxPooolSize = j;
      paramQQAppInterface.priority = 5;
      paramQQAppInterface.poolThreadName = "msgbackupThreadPool";
      this.jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(paramQQAppInterface);
      jdField_b_of_type_Int = jdField_a_of_type_Int * j;
      jdField_d_of_type_Int = jdField_c_of_type_Int * j;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    paramQQAppInterface = new arpe(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = new arpj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    aroz localaroz = new aroz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localaroz);
  }
  
  private String a(String paramString, int paramInt)
  {
    return String.format("%s_%d", new Object[] { paramString, Integer.valueOf(arsc.b(paramInt)) });
  }
  
  private void a(Message paramMessage)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 1: 
          d();
          return;
        case 2: 
          e();
          return;
        case 3: 
          h();
          return;
        case 4: 
          g();
          return;
        case 6: 
          c();
          return;
        }
      } while (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.size() <= 0);
      paramMessage = (arph)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.elements().nextElement();
    } while (paramMessage == null);
    b(paramMessage);
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    arrt.a().a(paramString1, paramString2, paramLong);
  }
  
  private void a(List<MsgBackupResEntity> paramList, arph paramarph, int paramInt)
  {
    arsc.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianru step:query res.size = %d ", new Object[] { Integer.valueOf(paramList.size()) });
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label286;
      }
      MsgBackupResEntity localMsgBackupResEntity = (MsgBackupResEntity)localIterator.next();
      Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject1 = (arov)((Iterator)localObject2).next();
        if (!((arov)localObject1).a(localMsgBackupResEntity)) {
          break;
        }
        arsa.a();
        localObject2 = arsa.a;
        ((arrx)localObject2).d += 1L;
        localObject2 = ((arov)localObject1).a(null, localMsgBackupResEntity);
        if (((arpi)localObject2).a())
        {
          localObject1 = ((arpi)localObject2).a((arov)localObject1, null, localMsgBackupResEntity);
          arsc.a(jdField_a_of_type_JavaLangString, "segmentExcuteQianru step:need res:uin = %s,uinType = %d,msgType = %d,filePath = %s,clientPath = %s, filesize = %s", new Object[] { paramarph.jdField_a_of_type_JavaLangString, Integer.valueOf(paramarph.jdField_a_of_type_Int), Integer.valueOf(localMsgBackupResEntity.msgType), localMsgBackupResEntity.filePath, localObject1, Long.valueOf(localMsgBackupResEntity.fileSize) });
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            arsc.a(jdField_a_of_type_JavaLangString, "segmentExcuteQianru step:need res,but clientPath is empty", new Object[0]);
          }
          else if (!this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject1))
          {
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, "");
            a(localMsgBackupResEntity.filePath, (String)localObject1, localMsgBackupResEntity.fileSize);
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        label286:
        paramarph.f += paramList.size();
        this.jdField_e_of_type_Int -= paramInt;
        arsc.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianru step segment startNext,,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Integer.valueOf(paramarph.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramarph.jdField_e_of_type_Int) });
        if (paramarph.f >= paramarph.jdField_e_of_type_Int)
        {
          this.jdField_e_of_type_Int = 0;
          if (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
          {
            a(null, null, 0L);
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            arsb.a("statis_qianchums_end");
            arsb.e();
            return;
          }
          this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(6);
          continue;
        }
        this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      }
      finally {}
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(5);
    }
  }
  
  private void c()
  {
    f();
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Arpg != null)
    {
      if (this.jdField_a_of_type_Arpg.jdField_c_of_type_Int != -1) {
        break label268;
      }
      arsb.a(null, "single_uin_cost");
    }
    for (;;)
    {
      Object localObject1 = this.jdField_a_of_type_Arpg;
      ((arpg)localObject1).jdField_c_of_type_Int += 1;
      int i = this.jdField_a_of_type_Arpg.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_Arpg.jdField_b_of_type_Int;
      if (i == 0) {
        arsb.a("statis_qianchums_start");
      }
      if (i == j)
      {
        arsb.a("statis_qianchums_end");
        arsb.d();
      }
      if (i < j)
      {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = (arph)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
        ((arph)localObject1).g = 0;
        Object localObject2 = arsc.a((arph)localObject1);
        arpm.a((String)localObject2);
        localObject2 = new arpm((String)localObject2);
        ArrayList localArrayList = new ArrayList();
        if (!TextUtils.isEmpty(arpa.jdField_a_of_type_JavaLangString))
        {
          arsc.b(jdField_a_of_type_JavaLangString, "file meta is %s, key is %s", new Object[] { arpa.jdField_a_of_type_JavaLangString, arpa.b });
          MsgBackupExtraEntity localMsgBackupExtraEntity = new MsgBackupExtraEntity();
          localMsgBackupExtraEntity.name = "key_meta";
          localMsgBackupExtraEntity.value = arpa.jdField_a_of_type_JavaLangString;
          localArrayList.add(localMsgBackupExtraEntity);
          localMsgBackupExtraEntity = new MsgBackupExtraEntity();
          localMsgBackupExtraEntity.name = "db_version";
          localMsgBackupExtraEntity.value = String.valueOf(1);
          localArrayList.add(localMsgBackupExtraEntity);
        }
        ((arpm)localObject2).c(localArrayList);
        ((arpm)localObject2).a();
        a((arph)localObject1);
      }
      return;
      label268:
      arsb.a("single_uin_cost", null);
      arsb.a(null, "single_uin_cost");
    }
  }
  
  private void d(arph paramarph)
  {
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    String str = a(paramarph.jdField_a_of_type_JavaLangString, paramarph.jdField_a_of_type_Int);
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramarph);
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(5);
    arsb.a("statis_qianchums_start");
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Arpg != null)
    {
      int i = this.jdField_a_of_type_Arpg.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_Arpg.jdField_b_of_type_Int;
      if (i < j)
      {
        Object localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject = (arph)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        arsc.b(jdField_a_of_type_JavaLangString, "singleNextQianchu curUin = %s,curQueryCount = %d,sessionMsgTotalCount = %d,mPendingMsgCount = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(((arph)localObject).g), Integer.valueOf(((arph)localObject).jdField_e_of_type_Int), Integer.valueOf(this.jdField_e_of_type_Int) });
        if ((((arph)localObject).g < ((arph)localObject).jdField_e_of_type_Int) && (this.jdField_e_of_type_Int < jdField_b_of_type_Int)) {
          a((arph)localObject);
        }
      }
      arsc.b(jdField_a_of_type_JavaLangString, "singleNextQianchu curSessionListIndex = %d,totalSessionListCount = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
  }
  
  private void e(arph paramarph)
  {
    paramarph = arsc.a(paramarph);
    arsc.b(jdField_a_of_type_JavaLangString, "analysisFileMeta:start dbName = %s ", new Object[] { paramarph });
    arsc.a();
    paramarph = new arpm(paramarph);
    Object localObject1 = paramarph.a();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MsgBackupExtraEntity)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((MsgBackupExtraEntity)localObject2).name)) && (((MsgBackupExtraEntity)localObject2).name.equalsIgnoreCase("key_meta")) && (!TextUtils.isEmpty(((MsgBackupExtraEntity)localObject2).value)))
        {
          arpa.jdField_a_of_type_JavaLangString = ((MsgBackupExtraEntity)localObject2).value;
          localObject2 = (String)arpa.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((MsgBackupExtraEntity)localObject2).value);
          arpa.jdField_c_of_type_JavaLangString = (String)localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            arpa.a().h();
          }
        }
      }
    }
    paramarph.a();
  }
  
  private void f()
  {
    arrt.a().a(1);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Arpg != null)
    {
      int i = this.jdField_a_of_type_Arpg.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_Arpg.jdField_b_of_type_Int;
      if (i < j)
      {
        Object localObject = (String)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        localObject = (arph)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if ((((arph)localObject).g < ((arph)localObject).jdField_e_of_type_Int) && (this.jdField_e_of_type_Int < jdField_b_of_type_Int)) {
          c((arph)localObject);
        }
        arsc.b(jdField_a_of_type_JavaLangString, "singleNextQianchu curSessionListIndex = %d,totalSessionListCount = %d,querySingleIndex = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((arph)localObject).g) });
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Arpg != null)
    {
      Object localObject = this.jdField_a_of_type_Arpg;
      ((arpg)localObject).jdField_c_of_type_Int += 1;
      int i = this.jdField_a_of_type_Arpg.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_Arpg.jdField_b_of_type_Int;
      arsc.b(jdField_a_of_type_JavaLangString, "nextDaoru curIndex = %d,totalCount = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (i == 0) {
        arsb.a("statis_qianchums_start");
      }
      if (i == j)
      {
        arsb.a("statis_qianchums_end");
        arsb.f();
      }
      if (i < j)
      {
        localObject = (String)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        localObject = (arph)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        ((arph)localObject).g = 0;
        arsc.a(jdField_a_of_type_JavaLangString, "nextDaoru uin = %s,uinType = %d", new Object[] { ((arph)localObject).jdField_a_of_type_JavaLangString, Integer.valueOf(((arph)localObject).jdField_a_of_type_Int) });
        c((arph)localObject);
      }
    }
  }
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if (paramMessageRecord1.istroop == 1) {
      return (int)(paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq);
    }
    return (int)(paramMessageRecord1.time - paramMessageRecord2.time);
  }
  
  public List<MessageRecord> a(List<MessageRecord> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (localMessageRecord.msgtype != -2006) {
        if (((localMessageRecord.extraflag == 32768) || (localMessageRecord.extraflag == 32772)) && (localMessageRecord.isSendFromLocal()))
        {
          arsc.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport send not sucess msg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if (!(localMessageRecord instanceof ChatMessage))
        {
          arsc.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport not chatMessage _id = %d...,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if ((akbm.j(localMessageRecord.msgtype)) || (akbm.i(localMessageRecord.msgtype)))
        {
          arsc.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport graytipMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if (acjz.a((ChatMessage)localMessageRecord))
        {
          arsc.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport BeancurdMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if (mnf.a(localMessageRecord))
        {
          arsc.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport AnonymousMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else
        {
          if ((localMessageRecord instanceof MessageForFile)) {
            apck.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localMessageRecord);
          }
          if ((localMessageRecord instanceof MessageForCommonHobbyForAIOShow))
          {
            arsc.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport msgtype MessageForCommonHobbyForAIOShow MSG_TYPE_COMMON_HOBBY_FOR_AIO_SHOW", new Object[0]);
          }
          else if (((localMessageRecord.istroop == 1) || (localMessageRecord.istroop == 1)) && (localMessageRecord.shmsgseq <= 0L))
          {
            arsc.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport troop or discurss msg shmsgseq <= 0", new Object[0]);
          }
          else
          {
            boolean bool = aryb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localMessageRecord);
            if (localMessageRecord.msgtype == -2002) {
              bool = true;
            }
            for (;;)
            {
              if (!bool) {
                break label508;
              }
              localArrayList.add(localMessageRecord);
              break;
              if (localMessageRecord.msgtype == -2071) {
                bool = true;
              } else if (localMessageRecord.msgtype == -2007) {
                bool = true;
              } else if (localMessageRecord.msgtype == -5008) {
                bool = true;
              } else if (localMessageRecord.msgtype == -5017) {
                bool = true;
              }
            }
            label508:
            String str = aryb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord);
            arsc.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport trans to txtMessage _id = %d...,msgtype = %d .msgStr = %s", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype), str });
            localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, str, false);
            if (TextUtils.equals(localMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
              ((ajrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(localMessageRecord);
            }
            localMessageRecord.setStatus(1000);
            localMessageRecord.msgData = localMessageRecord.msg.getBytes();
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    arsc.a(jdField_a_of_type_JavaLangString, "preHandleQianchu..msgSize = %d...", new Object[] { Integer.valueOf(localArrayList.size()) });
    return localArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler != null) {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    arpf.a();
    arsb.c();
  }
  
  public void a(arpg paramarpg)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!arsc.a())) {
      arsc.b(jdField_a_of_type_JavaLangString, "handleRequest checkDBDirs result = false,requestType = %d ", new Object[] { Integer.valueOf(paramarpg.jdField_a_of_type_Int) });
    }
    do
    {
      return;
      switch (paramarpg.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 0: 
        int i = paramarpg.jdField_a_of_type_JavaUtilHashSet.size();
        arsc.b(jdField_a_of_type_JavaLangString, "requestQianchu start,request.dataList.size() = %d ", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          break label125;
        }
      }
    } while (paramarpg.jdField_a_of_type_Arou == null);
    paramarpg.jdField_a_of_type_Arou.a(1, paramarpg, null);
    return;
    label125:
    b(paramarpg);
    return;
    arsc.b(jdField_a_of_type_JavaLangString, "requestQianru start ", new Object[0]);
    arph localarph = new arph();
    arsc.a(paramarpg.jdField_a_of_type_JavaLangString.substring(paramarpg.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1), localarph);
    arpa.d = localarph.jdField_a_of_type_JavaLangString;
    arpa.jdField_c_of_type_Int = localarph.jdField_a_of_type_Int;
    d(localarph);
    return;
    arsc.b(jdField_a_of_type_JavaLangString, "requestDaoru start ", new Object[0]);
    c(paramarpg);
  }
  
  public void a(arpg paramarpg, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    arsc.b(jdField_a_of_type_JavaLangString, "sendRequest is called from = %d", new Object[] { Integer.valueOf(paramInt) });
    this.jdField_a_of_type_Arpg = paramarpg;
    if (arsc.b)
    {
      if (paramInt == 10000)
      {
        localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(5);
        localMessage.obj = paramarpg;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 100L);
        return;
      }
      if (paramInt == 10001)
      {
        arpa.jdField_a_of_type_JavaLangString = null;
        arpa.jdField_c_of_type_JavaLangString = null;
        localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(7);
        localMessage.obj = paramarpg;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 100L);
        return;
      }
      localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
      localMessage.obj = paramarpg;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 100L);
      return;
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
    localMessage.obj = paramarpg;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(arph paramarph)
  {
    Object localObject1 = arsc.a(paramarph);
    arsc.b(jdField_a_of_type_JavaLangString, "singleExcuteQianchu,start uin = %s,dbPath = %s,request.startQueryIndex = %d ", new Object[] { paramarph.jdField_a_of_type_JavaLangString, localObject1, Integer.valueOf(paramarph.h) });
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1) == null)
    {
      localObject2 = new arpm((String)localObject1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, localObject2);
    }
    localObject1 = (arpm)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
    Object localObject2 = MessageRecord.getTableName(paramarph.jdField_a_of_type_JavaLangString, paramarph.jdField_a_of_type_Int);
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    int j;
    int k;
    int m;
    if (paramarph.jdField_e_of_type_Int == 0)
    {
      j = localQQMessageFacade.a((String)localObject2, paramarph.jdField_a_of_type_Long, paramarph.jdField_b_of_type_Long, paramarph.jdField_a_of_type_Boolean);
      k = localQQMessageFacade.b((String)localObject2, paramarph.jdField_a_of_type_Long, paramarph.jdField_b_of_type_Long, paramarph.jdField_a_of_type_Boolean);
      m = j + k;
      paramarph.jdField_c_of_type_Int = j;
      paramarph.jdField_d_of_type_Int = k;
      paramarph.jdField_e_of_type_Int = m;
      if ((m != 0) && ((paramarph.g < m) || (this.jdField_e_of_type_Int != 0))) {
        break label301;
      }
      if ((this.jdField_a_of_type_Arpg != null) && (this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou != null))
      {
        localObject2 = new arpw();
        ((arpw)localObject2).jdField_a_of_type_JavaLangString = paramarph.jdField_a_of_type_JavaLangString;
        ((arpw)localObject2).jdField_a_of_type_Int = paramarph.jdField_a_of_type_Int;
        this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou.a(this.jdField_a_of_type_Arpg, localObject2);
      }
      ((arpm)localObject1).a();
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
      return;
      break label766;
      break label766;
    }
    label280:
    label301:
    label1383:
    label1386:
    label1389:
    for (;;)
    {
      j = paramarph.jdField_c_of_type_Int;
      k = paramarph.jdField_d_of_type_Int;
      m = paramarph.jdField_e_of_type_Int;
      break;
      arsc.b(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickDBCount = %d,slowDBCount = %d,totalCount = %d,request.queryIndex = %d,queryCount = %d", new Object[] { localObject2, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramarph.h), Integer.valueOf(paramarph.g) });
      int i;
      Object localObject3;
      Object localObject4;
      label1276:
      if (k == 0)
      {
        i = paramarph.g;
        if (i < paramarph.jdField_c_of_type_Int)
        {
          for (;;)
          {
            k = paramarph.h + 1;
            localObject3 = localQQMessageFacade.a((String)localObject2, paramarph.jdField_a_of_type_Long, paramarph.jdField_b_of_type_Long, k, jdField_a_of_type_Int, paramarph.jdField_a_of_type_Boolean);
            arsc.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu querySql = %s", new Object[] { localObject3 });
            localObject3 = localQQMessageFacade.b((String)localObject3, (String)localObject2);
            if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
              break label654;
            }
            m = ((List)localObject3).size();
            arsc.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu queryMsgSize = %d", new Object[] { Integer.valueOf(m) });
            localObject4 = new MsgBackupController.2(this, (arpm)localObject1, paramarph, (List)localObject3, k);
            this.jdField_e_of_type_Int += jdField_a_of_type_Int;
            i += jdField_a_of_type_Int;
            paramarph.g += jdField_a_of_type_Int;
            paramarph.h = ((int)((MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1)).getId());
            arsc.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu querySql lastQueryIndex = %d", new Object[] { Integer.valueOf(paramarph.h) });
            this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject4);
            arsc.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { localObject2, Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramarph.h) });
            if ((i >= j) || (this.jdField_e_of_type_Int >= jdField_b_of_type_Int)) {
              break;
            }
          }
          arsc.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu queryMsgSize = 0,mPendingMsgCount = %d", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) });
          if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_Arpg != null) && (this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou != null))
          {
            localObject2 = new arpw();
            ((arpw)localObject2).jdField_a_of_type_JavaLangString = paramarph.jdField_a_of_type_JavaLangString;
            ((arpw)localObject2).jdField_a_of_type_Int = paramarph.jdField_a_of_type_Int;
            this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou.a(this.jdField_a_of_type_Arpg, localObject2);
            this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
            ((arpm)localObject1).a();
          }
        }
      }
      else
      {
        i = paramarph.g;
        label766:
        if (i < m)
        {
          if (i < k)
          {
            j = paramarph.h + 1;
            localObject3 = localQQMessageFacade.a(localQQMessageFacade.a((String)localObject2, paramarph.jdField_a_of_type_Long, paramarph.jdField_b_of_type_Long, j, jdField_a_of_type_Int, paramarph.jdField_a_of_type_Boolean), (String)localObject2);
            if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
              break label1386;
            }
            m = ((List)localObject3).size();
            arsc.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu slowDB queryMsgSize = %d", new Object[] { Integer.valueOf(m) });
            localObject4 = new MsgBackupController.3(this, (arpm)localObject1, paramarph, (List)localObject3, j);
            this.jdField_e_of_type_Int += jdField_a_of_type_Int;
            i += jdField_a_of_type_Int;
            paramarph.g += jdField_a_of_type_Int;
            paramarph.h = ((int)((MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1)).getId());
            this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject4);
            arsc.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { localObject2, Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramarph.h) });
            j = i;
            if (i < k) {
              if (this.jdField_e_of_type_Int < jdField_b_of_type_Int) {
                break label1383;
              }
            }
          }
          for (j = i;; j = i)
          {
            if (j < k) {
              break label1389;
            }
            paramarph.g = k;
            paramarph.h = 0;
            return;
            int n = i - k;
            i = n;
            if (j <= 0) {
              break;
            }
            i = n;
            if (n >= j) {
              break;
            }
            i = n;
            for (;;)
            {
              k = paramarph.h + 1;
              localObject3 = localQQMessageFacade.b(localQQMessageFacade.a((String)localObject2, paramarph.jdField_a_of_type_Long, paramarph.jdField_b_of_type_Long, k, jdField_a_of_type_Int, paramarph.jdField_a_of_type_Boolean), (String)localObject2);
              if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
                break label1276;
              }
              m = ((List)localObject3).size();
              arsc.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu quickDB queryMsgSize = %d", new Object[] { Integer.valueOf(m) });
              localObject4 = new MsgBackupController.4(this, (arpm)localObject1, paramarph, (List)localObject3, k);
              this.jdField_e_of_type_Int += jdField_a_of_type_Int;
              i += jdField_a_of_type_Int;
              paramarph.g += jdField_a_of_type_Int;
              paramarph.h = ((int)((MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1)).getId());
              this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject4);
              arsc.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { localObject2, Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramarph.h) });
              if ((i >= j) || (this.jdField_e_of_type_Int >= jdField_b_of_type_Int)) {
                break;
              }
            }
            arsc.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu queryMsgSize = 0,mPendingMsgCount = %d", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) });
            if ((this.jdField_e_of_type_Int != 0) || (this.jdField_a_of_type_Arpg == null) || (this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou == null)) {
              break label280;
            }
            localObject2 = new arpw();
            ((arpw)localObject2).jdField_a_of_type_JavaLangString = paramarph.jdField_a_of_type_JavaLangString;
            ((arpw)localObject2).jdField_a_of_type_Int = paramarph.jdField_a_of_type_Int;
            this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou.a(this.jdField_a_of_type_Arpg, localObject2);
            this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
            ((arpm)localObject1).a();
            return;
            break label778;
          }
        }
      }
    }
  }
  
  public void a(arpm paramarpm, arph paramarph, List<MsgBackupMsgEntity> paramList)
  {
    paramList.size();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    arsc.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:query done ,msgEntity.size = %d ", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject1 = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject3 = (MsgBackupMsgEntity)paramList.next();
      if (((MsgBackupMsgEntity)localObject3).extensionData == null)
      {
        i += 1;
        arsc.b(jdField_a_of_type_JavaLangString, "segmentDaoru step has encounter msgEntity.extensionData == null,msgType = %d,invalidMsgCount = %d", new Object[] { Integer.valueOf(((MsgBackupMsgEntity)localObject3).msgType), Integer.valueOf(i) });
      }
      else
      {
        try
        {
          localObject3 = ((arpq)localObject2).a((MsgBackupMsgEntity)localObject3);
          if (localObject3 != null) {
            ((List)localObject1).add(localObject3);
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "transToMessageRecord " + localThrowable);
        }
      }
    }
    arsc.a(jdField_a_of_type_JavaLangString, "segmentDaoru step:trans done ,msg.size = %d ", new Object[] { Integer.valueOf(((List)localObject1).size()) });
    if (((List)localObject1).size() > 0) {
      localObject2 = ((List)localObject1).iterator();
    }
    label533:
    label815:
    label1204:
    label1215:
    label1219:
    label1224:
    for (;;)
    {
      label243:
      Object localObject4;
      Object localObject5;
      Iterator localIterator1;
      if (((Iterator)localObject2).hasNext())
      {
        localObject4 = (MessageRecord)((Iterator)localObject2).next();
        if (aryb.a((ChatMessage)localObject4))
        {
          localObject5 = paramarpm.a(((MessageRecord)localObject4).msgBackupMsgSeq, ((MessageRecord)localObject4).msgBackupMsgRandom);
          if ((localObject5 == null) || (((List)localObject5).size() <= 0)) {
            continue;
          }
          localIterator1 = ((List)localObject5).iterator();
          do
          {
            if (!localIterator1.hasNext()) {
              break;
            }
            paramList = (MsgBackupResEntity)localIterator1.next();
          } while (paramList.msgType != 4);
        }
      }
      for (;;)
      {
        if (paramList == null) {
          break label1224;
        }
        paramList = arpe.b((MessageRecord)localObject4, paramList);
        arsc.a(jdField_a_of_type_JavaLangString, "multimsg_tempFilPath = %s", new Object[] { paramList });
        paramList = new File(paramList);
        if (!paramList.exists()) {
          break label243;
        }
        arsc.a(jdField_a_of_type_JavaLangString, "multimsg_tempFilPath exist = %b", new Object[] { Boolean.valueOf(true) });
        paramList = bace.a(paramList);
        paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramList, null, (MessageRecord)localObject4, null);
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label243;
        }
        localIterator1 = arpe.a(paramList).iterator();
        for (;;)
        {
          if (!localIterator1.hasNext()) {
            break label533;
          }
          MessageRecord localMessageRecord = (MessageRecord)localIterator1.next();
          Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator2.hasNext())
          {
            arov localarov = (arov)localIterator2.next();
            if (!localarov.a(localMessageRecord)) {
              break;
            }
            localarov.b(localMessageRecord, (List)localObject5);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject4, paramList, null);
        break label243;
        localObject5 = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject5).hasNext()) {
          break label243;
        }
        paramList = (arov)((Iterator)localObject5).next();
        if (!paramList.a((MessageRecord)localObject4)) {
          break;
        }
        localObject5 = paramarpm.a(((MessageRecord)localObject4).msgBackupMsgSeq, ((MessageRecord)localObject4).msgBackupMsgRandom);
        if (localObject5 != null) {}
        for (i = ((List)localObject5).size();; i = 0)
        {
          arsc.a(jdField_a_of_type_JavaLangString, "segmentDaoru step:rich process ,query.res.size = %d ", new Object[] { Integer.valueOf(i) });
          paramList.b((MessageRecord)localObject4, (List)localObject5);
          break;
        }
        paramarpm = new ArrayList();
        localObject2 = (MessageRecord)((List)localObject1).get(0);
        paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, null);
        localObject4 = jdField_a_of_type_JavaLangString;
        if (paramList != null)
        {
          i = paramList.size();
          arsc.b((String)localObject4, "segmentDaoru step:mainMsg.size = %d,uin = %s,istroop = %d ", new Object[] { Integer.valueOf(i), ((MessageRecord)localObject2).frienduin, Integer.valueOf(((MessageRecord)localObject2).istroop) });
          localObject1 = ((List)localObject1).iterator();
        }
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (MessageRecord)((Iterator)localObject1).next();
            if ((paramList == null) || (paramList.size() <= 0)) {
              break label1215;
            }
            localObject4 = paramList.iterator();
            for (;;)
            {
              if (((Iterator)localObject4).hasNext())
              {
                localObject5 = (MessageRecord)((Iterator)localObject4).next();
                if ((((MessageRecord)localObject2).istroop == 1) || (((MessageRecord)localObject2).istroop == 1026) || (((MessageRecord)localObject2).istroop == 3000))
                {
                  if (((MessageRecord)localObject2).shmsgseq == 0L) {
                    arsc.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter duplicated troopMsg ,mr.msgshseq = 0.Msg.msgStr = %s ,mainMsg.msgStr = %s, msgtype = %d", new Object[] { ((MessageRecord)localObject2).msg, ((MessageRecord)localObject5).msg, Integer.valueOf(((MessageRecord)localObject2).msgtype) });
                  }
                  if ((((MessageRecord)localObject2).shmsgseq != ((MessageRecord)localObject5).shmsgseq) || (((MessageRecord)localObject2).msgtype != ((MessageRecord)localObject5).msgtype)) {
                    continue;
                  }
                  arsc.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter duplicated msg ,msgbackup.Msg.msgStr = %s ,mainMsg.msgStr = %s, msgtype = %d", new Object[] { ((MessageRecord)localObject2).msg, ((MessageRecord)localObject5).msg, Integer.valueOf(((MessageRecord)localObject2).msgtype) });
                  i = 1;
                }
              }
            }
          }
          for (;;)
          {
            if (i != 0) {
              break label1219;
            }
            paramarpm.add(localObject2);
            break label772;
            i = 0;
            break;
            if ((((MessageRecord)localObject2).msgUid != ((MessageRecord)localObject5).msgUid) || (((MessageRecord)localObject2).msgtype != ((MessageRecord)localObject5).msgtype)) {
              break label815;
            }
            arsc.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter duplicated msg ,msgbackup.Msg.msgStr = %s ,mainMsg.msgStr", new Object[] { ((MessageRecord)localObject2).msg, ((MessageRecord)localObject5).msg });
            i = 1;
            continue;
            arsc.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter done ,msgNew.size = %d ,uin = %s", new Object[] { Integer.valueOf(paramarpm.size()), paramarph.jdField_a_of_type_JavaLangString });
            if (paramarpm.size() > 0)
            {
              Collections.sort(paramarpm, this);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramarpm);
              if (arsc.jdField_a_of_type_Boolean)
              {
                ((MessageRecord)paramarpm.get(0)).getTableName();
                paramarpm = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramarph.jdField_a_of_type_JavaLangString, paramarph.jdField_a_of_type_Int, null);
                if (paramarpm != null) {
                  break label1204;
                }
              }
            }
            for (i = 0;; i = paramarpm.size())
            {
              arsc.a(jdField_a_of_type_JavaLangString, "daoru step:seqmentDaoru done result size =  %d", new Object[] { Integer.valueOf(i) });
              arsc.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:saveToDb done ", new Object[0]);
              return;
            }
            i = 0;
          }
        }
        paramList = null;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, arpm paramarpm, arph paramarph, List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramarpm == null) || (paramList == null)) {
      return;
    }
    int i = paramList.size();
    a(paramQQAppInterface, paramarpm, paramList);
    for (;;)
    {
      try
      {
        paramarph.f = (i + paramarph.f);
        this.jdField_e_of_type_Int -= paramInt;
        arsc.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step segment startNext,startIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramarph.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramarph.jdField_e_of_type_Int) });
        if (paramarph.f >= paramarph.jdField_e_of_type_Int)
        {
          if ((this.jdField_a_of_type_Arpg != null) && (this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou != null))
          {
            paramQQAppInterface = new arpw();
            paramQQAppInterface.jdField_a_of_type_JavaLangString = paramarph.jdField_a_of_type_JavaLangString;
            paramQQAppInterface.jdField_a_of_type_Int = paramarph.jdField_a_of_type_Int;
            this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou.a(this.jdField_a_of_type_Arpg, paramQQAppInterface);
          }
          arsc.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step this session has process done ,uin = %s,uintype = %d,msgSize = %d", new Object[] { paramarph.jdField_a_of_type_JavaLangString, Integer.valueOf(paramarph.jdField_a_of_type_Int), Integer.valueOf(paramarpm.a()) });
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramarpm.a());
          paramarpm.a();
          arpf.b();
          arsb.a("statis_qianchums_end");
          this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
          return;
        }
      }
      finally {}
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, arpm paramarpm, List<MessageRecord> paramList)
  {
    if ((paramQQAppInterface == null) || (paramarpm == null) || (paramList == null)) {
      return;
    }
    paramList.size();
    paramList = a(paramList);
    paramQQAppInterface = new ArrayList();
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    MessageRecord localMessageRecord;
    Object localObject3;
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label492;
      }
      localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
      Object localObject4;
      if (aryb.a((ChatMessage)localMessageRecord))
      {
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord);
        Object localObject5 = arpe.a((HashMap)localObject4);
        if (((List)localObject5).size() > 0)
        {
          localObject3 = new ArrayList();
          localObject5 = ((List)localObject5).iterator();
          for (;;)
          {
            if (!((Iterator)localObject5).hasNext()) {
              break label227;
            }
            localObject6 = (MessageRecord)((Iterator)localObject5).next();
            Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
            if (localIterator.hasNext())
            {
              arov localarov = (arov)localIterator.next();
              if (!localarov.a((MessageRecord)localObject6)) {
                break;
              }
              localarov.a((MessageRecord)localObject6, (List)localObject1);
              ((ArrayList)localObject3).addAll((Collection)localObject1);
              ((ArrayList)localObject1).clear();
            }
          }
          label227:
          long l1 = arsc.a(localMessageRecord);
          long l2 = arsc.b(localMessageRecord);
          localObject5 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (MsgBackupResEntity)((Iterator)localObject5).next();
            ((MsgBackupResEntity)localObject6).msgSeq = l1;
            ((MsgBackupResEntity)localObject6).msgRandom = l2;
          }
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((HashMap)localObject4, null, true);
          localObject5 = arsc.b(((MessageForStructing)localMessageRecord).structingMsg.mFileName);
          bace.a((byte[])localObject4, (String)localObject5);
          Object localObject6 = new MsgBackupResEntity();
          ((MsgBackupResEntity)localObject6).msgSeq = l1;
          ((MsgBackupResEntity)localObject6).msgRandom = l2;
          ((MsgBackupResEntity)localObject6).filePath = ((String)localObject5);
          ((MsgBackupResEntity)localObject6).fileSize = localObject4.length;
          ((MsgBackupResEntity)localObject6).msgSubType = 10;
          ((MsgBackupResEntity)localObject6).msgType = 4;
          ((MsgBackupResEntity)localObject6).extraDataStr = arpe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), localMessageRecord);
          paramQQAppInterface.add(localObject6);
          if (((ArrayList)localObject3).size() > 0) {
            paramQQAppInterface.addAll((Collection)localObject3);
          }
        }
      }
      else
      {
        localObject3 = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (arov)((Iterator)localObject3).next();
          if (!((arov)localObject4).a(localMessageRecord)) {
            break;
          }
          ((arov)localObject4).a(localMessageRecord, (List)localObject1);
          paramQQAppInterface.addAll((Collection)localObject1);
          ((ArrayList)localObject1).clear();
        }
      }
    }
    label492:
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    localObject2 = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localMessageRecord = (MessageRecord)paramList.next();
      try
      {
        localObject3 = ((arpq)localObject1).a(localMessageRecord);
        if (localObject3 == null) {
          break label604;
        }
        ((ArrayList)localObject2).add(localObject3);
      }
      catch (Throwable localThrowable)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "transToBackupEntity : " + localThrowable);
      }
      continue;
      label604:
      arsc.a(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu generate pb failed ..unsupport not chatMessage _id = %d,msgtype = %d .mr =%s ", new Object[] { Long.valueOf(localThrowable.getId()), Integer.valueOf(localThrowable.msgtype), localThrowable.toString() });
    }
    arsc.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step segment msg process  + msg.size = %d ", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()) });
    paramarpm.a((List)localObject2);
    paramarpm.b(paramQQAppInterface);
    arsc.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step segment insert db done", new Object[0]);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_AndroidOsHandlerThread.quit();
    }
    if (this.jdField_b_of_type_MqqOsMqqHandler != null)
    {
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    }
  }
  
  public void b(arpg paramarpg)
  {
    arsb.e = 0L;
    HashSet localHashSet = paramarpg.jdField_a_of_type_JavaUtilHashSet;
    if ((localHashSet == null) || (localHashSet.size() == 0))
    {
      arsc.b(jdField_a_of_type_JavaLangString, "qianchu no recentdBaseData ", new Object[0]);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    arpf.a();
    arsb.c();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (RecentBaseData)localIterator.next();
      String str = ((RecentBaseData)localObject).a();
      int i = ((RecentBaseData)localObject).a();
      arsc.b(jdField_a_of_type_JavaLangString, "requestQianchu uin = %s ", new Object[] { str });
      localObject = new arph();
      ((arph)localObject).jdField_a_of_type_JavaLangString = str;
      ((arph)localObject).jdField_a_of_type_Int = i;
      ((arph)localObject).jdField_b_of_type_Int = 0;
      ((arph)localObject).jdField_a_of_type_Long = paramarpg.jdField_a_of_type_Long;
      ((arph)localObject).jdField_b_of_type_Long = paramarpg.jdField_b_of_type_Long;
      ((arph)localObject).jdField_a_of_type_Boolean = paramarpg.jdField_a_of_type_Boolean;
      ((arph)localObject).g = -1;
      ((arph)localObject).h = 0;
      str = a(str, i);
      this.jdField_a_of_type_JavaUtilArrayList.add(str);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
    }
    paramarpg.jdField_b_of_type_Int = localHashSet.size();
    paramarpg.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
  
  public void b(arph paramarph)
  {
    Object localObject1 = arsc.a(paramarph);
    arsc.b(jdField_a_of_type_JavaLangString, "singleNextQianru step:start dbName = %s， request.queryIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { localObject1, Integer.valueOf(paramarph.h), Integer.valueOf(paramarph.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramarph.jdField_e_of_type_Int) });
    arsc.a();
    localObject1 = new arpm((String)localObject1);
    if (paramarph.jdField_e_of_type_Int == 0) {
      paramarph.jdField_e_of_type_Int = ((arpm)localObject1).b();
    }
    int i = paramarph.jdField_e_of_type_Int;
    if ((i == 0) || ((paramarph.g >= paramarph.jdField_e_of_type_Int) && (this.jdField_e_of_type_Int == 0)))
    {
      arsc.b(jdField_a_of_type_JavaLangString, "singleNextQianru step queryResList.size = 0,", new Object[0]);
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(6);
      ((arpm)localObject1).a();
      return;
    }
    while ((paramarph.g < i) && (this.jdField_e_of_type_Int < jdField_d_of_type_Int))
    {
      arsc.b(jdField_a_of_type_JavaLangString, "singleNextQianru step:,request.queryIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Integer.valueOf(paramarph.h), Integer.valueOf(paramarph.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramarph.jdField_e_of_type_Int) });
      Object localObject2 = ((arpm)localObject1).a(paramarph.h + 1, jdField_c_of_type_Int);
      paramarph.g += jdField_a_of_type_Int;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        paramarph.h = ((int)((MsgBackupResEntity)((List)localObject2).get(((List)localObject2).size() - 1)).getId());
        this.jdField_e_of_type_Int += jdField_c_of_type_Int;
        localObject2 = new MsgBackupController.5(this, (List)localObject2, paramarph);
        this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject2);
      }
      else if (this.jdField_e_of_type_Int == 0)
      {
        if ((paramarph.f == paramarph.jdField_e_of_type_Int) || (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.size() <= 0)) {
          break label372;
        }
        a(null, null, 0L);
      }
    }
    for (;;)
    {
      ((arpm)localObject1).a();
      return;
      label372:
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(6);
    }
  }
  
  /* Error */
  public void b(arpm paramarpm, arph paramarph, List<MsgBackupMsgEntity> paramList)
  {
    // Byte code:
    //   0: aload_3
    //   1: invokeinterface 274 1 0
    //   6: istore 4
    //   8: aload_0
    //   9: aload_1
    //   10: aload_2
    //   11: aload_3
    //   12: invokevirtual 1019	arox:a	(Larpm;Larph;Ljava/util/List;)V
    //   15: aload_0
    //   16: monitorenter
    //   17: aload_0
    //   18: aload_0
    //   19: getfield 358	arox:jdField_e_of_type_Int	I
    //   22: getstatic 39	arox:jdField_a_of_type_Int	I
    //   25: isub
    //   26: putfield 358	arox:jdField_e_of_type_Int	I
    //   29: aload_2
    //   30: iload 4
    //   32: aload_2
    //   33: getfield 356	arph:f	I
    //   36: iadd
    //   37: putfield 356	arph:f	I
    //   40: getstatic 37	arox:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   43: ldc_w 1021
    //   46: iconst_4
    //   47: anewarray 5	java/lang/Object
    //   50: dup
    //   51: iconst_0
    //   52: aload_2
    //   53: getfield 356	arph:f	I
    //   56: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: aload_0
    //   63: getfield 358	arox:jdField_e_of_type_Int	I
    //   66: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   69: aastore
    //   70: dup
    //   71: iconst_2
    //   72: aload_2
    //   73: getfield 361	arph:jdField_e_of_type_Int	I
    //   76: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: dup
    //   81: iconst_3
    //   82: aload_2
    //   83: getfield 320	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   86: aastore
    //   87: invokestatic 276	arsc:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: aload_2
    //   91: getfield 356	arph:f	I
    //   94: aload_2
    //   95: getfield 361	arph:jdField_e_of_type_Int	I
    //   98: if_icmplt +127 -> 225
    //   101: aload_0
    //   102: getfield 386	arox:jdField_a_of_type_Arpg	Larpg;
    //   105: ifnull +54 -> 159
    //   108: aload_0
    //   109: getfield 386	arox:jdField_a_of_type_Arpg	Larpg;
    //   112: getfield 627	arpg:jdField_a_of_type_Arou	Larou;
    //   115: ifnull +44 -> 159
    //   118: new 710	arpw
    //   121: dup
    //   122: invokespecial 711	arpw:<init>	()V
    //   125: astore_3
    //   126: aload_3
    //   127: aload_2
    //   128: getfield 320	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   131: putfield 712	arpw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: aload_3
    //   135: aload_2
    //   136: getfield 321	arph:jdField_a_of_type_Int	I
    //   139: putfield 713	arpw:jdField_a_of_type_Int	I
    //   142: aload_0
    //   143: getfield 386	arox:jdField_a_of_type_Arpg	Larpg;
    //   146: getfield 627	arpg:jdField_a_of_type_Arou	Larou;
    //   149: aload_0
    //   150: getfield 386	arox:jdField_a_of_type_Arpg	Larpg;
    //   153: aload_3
    //   154: invokeinterface 716 3 0
    //   159: getstatic 37	arox:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   162: ldc_w 1023
    //   165: iconst_2
    //   166: anewarray 5	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_2
    //   172: getfield 320	arph:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   175: aastore
    //   176: dup
    //   177: iconst_1
    //   178: aload_2
    //   179: getfield 321	arph:jdField_a_of_type_Int	I
    //   182: invokestatic 146	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: aastore
    //   186: invokestatic 276	arsc:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_0
    //   190: getfield 183	arox:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   193: aload_1
    //   194: invokevirtual 905	arpm:a	()Ljava/lang/String;
    //   197: invokevirtual 908	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   200: pop
    //   201: aload_1
    //   202: invokevirtual 441	arpm:a	()V
    //   205: aload_0
    //   206: getfield 118	arox:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   209: aconst_null
    //   210: invokevirtual 376	mqq/os/MqqHandler:removeCallbacksAndMessages	(Ljava/lang/Object;)V
    //   213: aload_0
    //   214: getfield 118	arox:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   217: iconst_3
    //   218: invokevirtual 380	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   221: pop
    //   222: aload_0
    //   223: monitorexit
    //   224: return
    //   225: aload_0
    //   226: getfield 118	arox:jdField_b_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   229: iconst_4
    //   230: invokevirtual 380	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   233: pop
    //   234: goto -12 -> 222
    //   237: astore_1
    //   238: aload_0
    //   239: monitorexit
    //   240: aload_1
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	arox
    //   0	242	1	paramarpm	arpm
    //   0	242	2	paramarph	arph
    //   0	242	3	paramList	List<MsgBackupMsgEntity>
    //   6	31	4	i	int
    // Exception table:
    //   from	to	target	type
    //   17	159	237	finally
    //   159	222	237	finally
    //   222	224	237	finally
    //   225	234	237	finally
    //   238	240	237	finally
  }
  
  public void c(arpg paramarpg)
  {
    HashSet localHashSet = paramarpg.jdField_a_of_type_JavaUtilHashSet;
    if ((localHashSet == null) || (localHashSet.size() == 0))
    {
      arsc.a(jdField_a_of_type_JavaLangString, "daoru no recentdBaseData ", new Object[0]);
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (RecentBaseData)localIterator.next();
      String str = ((RecentBaseData)localObject).a();
      int i = ((RecentBaseData)localObject).a();
      arsc.b(jdField_a_of_type_JavaLangString, "daoru uin = %s ", new Object[] { str });
      localObject = new arph();
      ((arph)localObject).jdField_a_of_type_JavaLangString = str;
      ((arph)localObject).jdField_a_of_type_Int = i;
      ((arph)localObject).jdField_b_of_type_Int = 2;
      ((arph)localObject).g = -1;
      ((arph)localObject).h = -1;
      str = a(str, i);
      this.jdField_b_of_type_JavaUtilArrayList.add(str);
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
    }
    paramarpg.jdField_b_of_type_Int = localHashSet.size();
    paramarpg.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
  }
  
  public void c(arph paramarph)
  {
    arpa.jdField_a_of_type_JavaLangString = null;
    arpa.jdField_c_of_type_JavaLangString = null;
    e(paramarph);
    Object localObject1;
    if (TextUtils.isEmpty(arpa.jdField_c_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou != null)
      {
        localObject1 = new arpw();
        ((arpw)localObject1).jdField_a_of_type_JavaLangString = paramarph.jdField_a_of_type_JavaLangString;
        ((arpw)localObject1).jdField_a_of_type_Int = paramarph.jdField_a_of_type_Int;
        arsc.b(jdField_a_of_type_JavaLangString, "singleDaoru progress callback curIndex = %d,totalCount = %d ", new Object[] { Integer.valueOf(paramarph.h), Integer.valueOf(paramarph.jdField_e_of_type_Int) });
        this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou.a(this.jdField_a_of_type_Arpg, localObject1);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
    }
    do
    {
      return;
      localObject1 = arsc.a(paramarph);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1) == null)
      {
        localObject2 = new arpm((String)localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, localObject2);
      }
      localObject1 = (arpm)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
      int i = ((arpm)localObject1).a();
      if (paramarph.jdField_e_of_type_Int == 0) {
        paramarph.jdField_e_of_type_Int = ((arpm)localObject1).a();
      }
      if ((paramarph.jdField_e_of_type_Int == 0) || ((paramarph.g >= i) && (this.jdField_e_of_type_Int == 0)))
      {
        if (this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou != null)
        {
          localObject2 = new arpw();
          ((arpw)localObject2).jdField_a_of_type_JavaLangString = paramarph.jdField_a_of_type_JavaLangString;
          ((arpw)localObject2).jdField_a_of_type_Int = paramarph.jdField_a_of_type_Int;
          arsc.b(jdField_a_of_type_JavaLangString, "singleDaoru progress callback curIndex = %d,totalCount = %d ", new Object[] { Integer.valueOf(paramarph.h), Integer.valueOf(paramarph.jdField_e_of_type_Int) });
          this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou.a(this.jdField_a_of_type_Arpg, localObject2);
        }
        ((arpm)localObject1).a();
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
        return;
      }
      do
      {
        paramarph.h = ((int)((MsgBackupMsgEntity)((List)localObject2).get(((List)localObject2).size() - 1)).getId());
        arsc.a(jdField_a_of_type_JavaLangString, "singleDaoru queryMsg result.size = %d ", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        this.jdField_e_of_type_Int += jdField_a_of_type_Int;
        localObject2 = new MsgBackupController.6(this, (arpm)localObject1, paramarph, (List)localObject2);
        this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject2);
        if ((paramarph.g >= i) || (this.jdField_e_of_type_Int >= jdField_b_of_type_Int)) {
          break;
        }
        arsc.b(jdField_a_of_type_JavaLangString, "singleDaoru queryMsgBefore  curIndex = %d,totalCount = %d,doneCount = %d ", new Object[] { Integer.valueOf(paramarph.h), Integer.valueOf(paramarph.jdField_e_of_type_Int), Integer.valueOf(paramarph.f) });
        if (paramarph.g <= 0) {
          arpq.jdField_a_of_type_Long = 0L;
        }
        localObject2 = ((arpm)localObject1).a(paramarph.h + 1, jdField_a_of_type_Int);
        paramarph.g += jdField_a_of_type_Int;
      } while ((localObject2 != null) && (((List)localObject2).size() != 0));
      arsc.b(jdField_a_of_type_JavaLangString, "singleDaoru..query result == 0", new Object[0]);
    } while ((this.jdField_e_of_type_Int != 0) || (this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou == null));
    arsc.a(jdField_a_of_type_JavaLangString, "singleDaoru queryMsgAfter  msgSize = = 0 ", new Object[0]);
    Object localObject2 = new arpw();
    ((arpw)localObject2).jdField_a_of_type_JavaLangString = paramarph.jdField_a_of_type_JavaLangString;
    ((arpw)localObject2).jdField_a_of_type_Int = paramarph.jdField_a_of_type_Int;
    this.jdField_a_of_type_Arpg.jdField_a_of_type_Arou.a(this.jdField_a_of_type_Arpg, localObject2);
    ((arpm)localObject1).a();
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      bool1 = false;
      return bool1;
    }
    switch (paramMessage.what)
    {
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      return true;
    case 0: 
      localObject = jdField_a_of_type_JavaLangString;
      if (paramMessage.obj != null) {}
      for (bool1 = true;; bool1 = false)
      {
        arsc.a((String)localObject, "MSG_WHAT_SUB_REQUEST_POST msg.obj = %b", new Object[] { Boolean.valueOf(bool1) });
        bool1 = bool2;
        if (!(paramMessage.obj instanceof arpg)) {
          break;
        }
        a((arpg)paramMessage.obj);
        return true;
      }
    case 5: 
      if (TextUtils.isEmpty(arpa.b))
      {
        localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(5);
        ((Message)localObject).obj = paramMessage.obj;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 1000L);
        return true;
      }
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
      ((Message)localObject).what = 0;
      ((Message)localObject).obj = paramMessage.obj;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
      return true;
    case 7: 
      if ((TextUtils.isEmpty(arpa.jdField_a_of_type_JavaLangString)) && ((paramMessage.obj instanceof arpg)))
      {
        localObject = (arpg)paramMessage.obj;
        arph localarph = new arph();
        arsc.a(((arpg)localObject).jdField_a_of_type_JavaLangString.substring(((arpg)localObject).jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1), localarph);
        e(localarph);
      }
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(6);
      ((Message)localObject).obj = paramMessage.obj;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
      return true;
    }
    if (TextUtils.isEmpty(arpa.jdField_a_of_type_JavaLangString))
    {
      arsc.a(jdField_a_of_type_JavaLangString, "MSG_WHAT_SUB_DECRYPT_KEY_VALID sFileMeta is null, so skip this session!", new Object[0]);
      f();
      return true;
    }
    Object localObject = (String)arpa.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(arpa.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(6);
      ((Message)localObject).obj = paramMessage.obj;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 1000L);
      return true;
    }
    arpa.jdField_c_of_type_JavaLangString = (String)localObject;
    localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
    ((Message)localObject).obj = paramMessage.obj;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arox
 * JD-Core Version:    0.7.0.1
 */