import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
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
import com.tencent.mobileqq.utils.FileUtils;
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

public class awzp
  implements Handler.Callback, Comparator<MessageRecord>
{
  private static int jdField_a_of_type_Int = 500;
  public static String a;
  private static int jdField_b_of_type_Int = 5000;
  private static int jdField_c_of_type_Int = 1000;
  private static int jdField_d_of_type_Int = 10000;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private awzy jdField_a_of_type_Awzy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<awzn> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<String, axae> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private HandlerThread jdField_b_of_type_AndroidOsHandlerThread;
  private ArrayList<String> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private ConcurrentHashMap<String, awzz> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private MqqHandler jdField_b_of_type_MqqOsMqqHandler;
  private ConcurrentHashMap<String, awzz> jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap;
  private ConcurrentHashMap<String, awzz> jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int jdField_e_of_type_Int;
  private ConcurrentHashMap<String, String> jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap;
  
  static
  {
    jdField_a_of_type_JavaLangString = "MsgBackup_MsgBackupController";
  }
  
  public awzp(QQAppInterface paramQQAppInterface)
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
      this.jdField_b_of_type_MqqOsMqqHandler = new MqqHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), new awzq(this));
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutor == null)
    {
      int i = Runtime.getRuntime().availableProcessors();
      axcw.a(jdField_a_of_type_JavaLangString, "MsgBackupController cpuCount = %d ", new Object[] { Integer.valueOf(i) });
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
    paramQQAppInterface = new awzw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = new axab(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    awzr localawzr = new awzr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localawzr);
  }
  
  private String a(String paramString, int paramInt)
  {
    return String.format("%s_%d", new Object[] { paramString, Integer.valueOf(axcw.b(paramInt)) });
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
      paramMessage = (awzz)this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.elements().nextElement();
    } while (paramMessage == null);
    b(paramMessage);
  }
  
  private void a(String paramString1, String paramString2, long paramLong)
  {
    axcm.a().a(paramString1, paramString2, paramLong);
  }
  
  private void a(List<MsgBackupResEntity> paramList, awzz paramawzz, int paramInt)
  {
    axcw.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianru step:query res.size = %d ", new Object[] { Integer.valueOf(paramList.size()) });
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
        Object localObject1 = (awzn)((Iterator)localObject2).next();
        if (!((awzn)localObject1).a(localMsgBackupResEntity)) {
          break;
        }
        axct.a();
        localObject2 = axct.a;
        ((axcq)localObject2).d += 1L;
        localObject2 = ((awzn)localObject1).a(null, localMsgBackupResEntity);
        if (((axaa)localObject2).a())
        {
          localObject1 = ((axaa)localObject2).a((awzn)localObject1, null, localMsgBackupResEntity);
          axcw.a(jdField_a_of_type_JavaLangString, "segmentExcuteQianru step:need res:uin = %s,uinType = %d,msgType = %d,filePath = %s,clientPath = %s, filesize = %s", new Object[] { paramawzz.jdField_a_of_type_JavaLangString, Integer.valueOf(paramawzz.jdField_a_of_type_Int), Integer.valueOf(localMsgBackupResEntity.msgType), localMsgBackupResEntity.filePath, localObject1, Long.valueOf(localMsgBackupResEntity.fileSize) });
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            axcw.a(jdField_a_of_type_JavaLangString, "segmentExcuteQianru step:need res,but clientPath is empty", new Object[0]);
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
        paramawzz.f += paramList.size();
        this.jdField_e_of_type_Int -= paramInt;
        axcw.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianru step segment startNext,,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Integer.valueOf(paramawzz.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramawzz.jdField_e_of_type_Int) });
        if (paramawzz.f >= paramawzz.jdField_e_of_type_Int)
        {
          this.jdField_e_of_type_Int = 0;
          if (this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.size() > 0)
          {
            a(null, null, 0L);
            this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
            axcv.a("statis_qianchums_end");
            axcv.e();
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
    if (this.jdField_a_of_type_Awzy != null)
    {
      if (this.jdField_a_of_type_Awzy.jdField_c_of_type_Int != -1) {
        break label268;
      }
      axcv.a(null, "single_uin_cost");
    }
    for (;;)
    {
      Object localObject1 = this.jdField_a_of_type_Awzy;
      ((awzy)localObject1).jdField_c_of_type_Int += 1;
      int i = this.jdField_a_of_type_Awzy.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_Awzy.jdField_b_of_type_Int;
      if (i == 0) {
        axcv.a("statis_qianchums_start");
      }
      if (i == j)
      {
        axcv.a("statis_qianchums_end");
        axcv.d();
      }
      if (i < j)
      {
        localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject1 = (awzz)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
        ((awzz)localObject1).g = 0;
        Object localObject2 = axcw.a((awzz)localObject1);
        axae.a((String)localObject2);
        localObject2 = new axae((String)localObject2);
        ArrayList localArrayList = new ArrayList();
        if (!TextUtils.isEmpty(awzs.jdField_a_of_type_JavaLangString))
        {
          axcw.b(jdField_a_of_type_JavaLangString, "file meta is %s, key is %s", new Object[] { awzs.jdField_a_of_type_JavaLangString, awzs.b });
          MsgBackupExtraEntity localMsgBackupExtraEntity = new MsgBackupExtraEntity();
          localMsgBackupExtraEntity.name = "key_meta";
          localMsgBackupExtraEntity.value = awzs.jdField_a_of_type_JavaLangString;
          localArrayList.add(localMsgBackupExtraEntity);
          localMsgBackupExtraEntity = new MsgBackupExtraEntity();
          localMsgBackupExtraEntity.name = "db_version";
          localMsgBackupExtraEntity.value = String.valueOf(1);
          localArrayList.add(localMsgBackupExtraEntity);
        }
        ((axae)localObject2).c(localArrayList);
        ((axae)localObject2).a();
        a((awzz)localObject1);
      }
      return;
      label268:
      axcv.a("single_uin_cost", null);
      axcv.a(null, "single_uin_cost");
    }
  }
  
  private void d(awzz paramawzz)
  {
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_e_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    String str = a(paramawzz.jdField_a_of_type_JavaLangString, paramawzz.jdField_a_of_type_Int);
    this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramawzz);
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(5);
    axcv.a("statis_qianchums_start");
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Awzy != null)
    {
      int i = this.jdField_a_of_type_Awzy.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_Awzy.jdField_b_of_type_Int;
      if (i < j)
      {
        Object localObject = (String)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        localObject = (awzz)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        axcw.b(jdField_a_of_type_JavaLangString, "singleNextQianchu curUin = %s,curQueryCount = %d,sessionMsgTotalCount = %d,mPendingMsgCount = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(((awzz)localObject).g), Integer.valueOf(((awzz)localObject).jdField_e_of_type_Int), Integer.valueOf(this.jdField_e_of_type_Int) });
        if ((((awzz)localObject).g < ((awzz)localObject).jdField_e_of_type_Int) && (this.jdField_e_of_type_Int < jdField_b_of_type_Int)) {
          a((awzz)localObject);
        }
      }
      axcw.b(jdField_a_of_type_JavaLangString, "singleNextQianchu curSessionListIndex = %d,totalSessionListCount = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    }
  }
  
  private void e(awzz paramawzz)
  {
    paramawzz = axcw.a(paramawzz);
    axcw.b(jdField_a_of_type_JavaLangString, "analysisFileMeta:start dbName = %s ", new Object[] { paramawzz });
    axcw.a();
    paramawzz = new axae(paramawzz);
    Object localObject1 = paramawzz.a();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (MsgBackupExtraEntity)((Iterator)localObject1).next();
        if ((localObject2 != null) && (!TextUtils.isEmpty(((MsgBackupExtraEntity)localObject2).name)) && (((MsgBackupExtraEntity)localObject2).name.equalsIgnoreCase("key_meta")) && (!TextUtils.isEmpty(((MsgBackupExtraEntity)localObject2).value)))
        {
          awzs.jdField_a_of_type_JavaLangString = ((MsgBackupExtraEntity)localObject2).value;
          localObject2 = (String)awzs.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(((MsgBackupExtraEntity)localObject2).value);
          awzs.jdField_c_of_type_JavaLangString = (String)localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            awzs.a().h();
          }
        }
      }
    }
    paramawzz.a();
  }
  
  private void f()
  {
    axcm.a().a(1);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Awzy != null)
    {
      int i = this.jdField_a_of_type_Awzy.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_Awzy.jdField_b_of_type_Int;
      if (i < j)
      {
        Object localObject = (String)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        localObject = (awzz)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        if ((((awzz)localObject).g < ((awzz)localObject).jdField_e_of_type_Int) && (this.jdField_e_of_type_Int < jdField_b_of_type_Int)) {
          c((awzz)localObject);
        }
        axcw.b(jdField_a_of_type_JavaLangString, "singleNextQianchu curSessionListIndex = %d,totalSessionListCount = %d,querySingleIndex = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(((awzz)localObject).g) });
      }
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Awzy != null)
    {
      Object localObject = this.jdField_a_of_type_Awzy;
      ((awzy)localObject).jdField_c_of_type_Int += 1;
      int i = this.jdField_a_of_type_Awzy.jdField_c_of_type_Int;
      int j = this.jdField_a_of_type_Awzy.jdField_b_of_type_Int;
      axcw.b(jdField_a_of_type_JavaLangString, "nextDaoru curIndex = %d,totalCount = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if (i == 0) {
        axcv.a("statis_qianchums_start");
      }
      if (i == j)
      {
        axcv.a("statis_qianchums_end");
        axcv.f();
      }
      if (i < j)
      {
        localObject = (String)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        localObject = (awzz)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject);
        ((awzz)localObject).g = 0;
        axcw.a(jdField_a_of_type_JavaLangString, "nextDaoru uin = %s,uinType = %d", new Object[] { ((awzz)localObject).jdField_a_of_type_JavaLangString, Integer.valueOf(((awzz)localObject).jdField_a_of_type_Int) });
        c((awzz)localObject);
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
          axcw.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport send not sucess msg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if (!(localMessageRecord instanceof ChatMessage))
        {
          axcw.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport not chatMessage _id = %d...,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if ((acnh.k(localMessageRecord.msgtype)) || (acnh.j(localMessageRecord.msgtype)))
        {
          axcw.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport graytipMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if (afqy.a((ChatMessage)localMessageRecord))
        {
          axcw.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport BeancurdMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else if (nty.a(localMessageRecord))
        {
          axcw.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport AnonymousMsg _id = %d..,msgtype = %d .", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype) });
        }
        else
        {
          if ((localMessageRecord instanceof MessageForFile)) {
            auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForFile)localMessageRecord);
          }
          if ((localMessageRecord instanceof MessageForCommonHobbyForAIOShow))
          {
            axcw.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport msgtype MessageForCommonHobbyForAIOShow MSG_TYPE_COMMON_HOBBY_FOR_AIO_SHOW", new Object[0]);
          }
          else if (((localMessageRecord.istroop == 1) || (localMessageRecord.istroop == 1)) && (localMessageRecord.shmsgseq <= 0L))
          {
            axcw.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport troop or discurss msg shmsgseq <= 0", new Object[0]);
          }
          else
          {
            boolean bool = axiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ChatMessage)localMessageRecord);
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
            String str = axiv.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord);
            axcw.b(jdField_a_of_type_JavaLangString, "preHandleQianchu..unsupport trans to txtMessage _id = %d...,msgtype = %d .msgStr = %s", new Object[] { Long.valueOf(localMessageRecord.getId()), Integer.valueOf(localMessageRecord.msgtype), str });
            localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a(localMessageRecord, str, false);
            if (TextUtils.equals(localMessageRecord.senderuin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
              ((aocy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(localMessageRecord);
            }
            localMessageRecord.setStatus(1000);
            localMessageRecord.msgData = localMessageRecord.msg.getBytes();
            localArrayList.add(localMessageRecord);
          }
        }
      }
    }
    axcw.a(jdField_a_of_type_JavaLangString, "preHandleQianchu..msgSize = %d...", new Object[] { Integer.valueOf(localArrayList.size()) });
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
    awzx.a();
    axcv.c();
  }
  
  public void a(awzy paramawzy)
  {
    if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (!axcw.a())) {
      axcw.b(jdField_a_of_type_JavaLangString, "handleRequest checkDBDirs result = false,requestType = %d ", new Object[] { Integer.valueOf(paramawzy.jdField_a_of_type_Int) });
    }
    do
    {
      return;
      switch (paramawzy.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 0: 
        int i = paramawzy.jdField_a_of_type_JavaUtilHashSet.size();
        axcw.b(jdField_a_of_type_JavaLangString, "requestQianchu start,request.dataList.size() = %d ", new Object[] { Integer.valueOf(i) });
        if (i != 0) {
          break label125;
        }
      }
    } while (paramawzy.jdField_a_of_type_Awzm == null);
    paramawzy.jdField_a_of_type_Awzm.a(1, paramawzy, null);
    return;
    label125:
    b(paramawzy);
    return;
    axcw.b(jdField_a_of_type_JavaLangString, "requestQianru start ", new Object[0]);
    awzz localawzz = new awzz();
    axcw.a(paramawzy.jdField_a_of_type_JavaLangString.substring(paramawzy.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1), localawzz);
    awzs.d = localawzz.jdField_a_of_type_JavaLangString;
    awzs.jdField_c_of_type_Int = localawzz.jdField_a_of_type_Int;
    d(localawzz);
    return;
    axcw.b(jdField_a_of_type_JavaLangString, "requestDaoru start ", new Object[0]);
    c(paramawzy);
  }
  
  public void a(awzy paramawzy, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    axcw.b(jdField_a_of_type_JavaLangString, "sendRequest is called from = %d", new Object[] { Integer.valueOf(paramInt) });
    this.jdField_a_of_type_Awzy = paramawzy;
    if (axcw.b)
    {
      if (paramInt == 10000)
      {
        localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(5);
        localMessage.obj = paramawzy;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 100L);
        return;
      }
      if (paramInt == 10001)
      {
        awzs.jdField_a_of_type_JavaLangString = null;
        awzs.jdField_c_of_type_JavaLangString = null;
        localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(7);
        localMessage.obj = paramawzy;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 100L);
        return;
      }
      localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
      localMessage.obj = paramawzy;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(localMessage, 100L);
      return;
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
    localMessage.obj = paramawzy;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void a(awzz paramawzz)
  {
    Object localObject1 = axcw.a(paramawzz);
    axcw.b(jdField_a_of_type_JavaLangString, "singleExcuteQianchu,start uin = %s,dbPath = %s,request.startQueryIndex = %d ", new Object[] { paramawzz.jdField_a_of_type_JavaLangString, localObject1, Integer.valueOf(paramawzz.h) });
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1) == null)
    {
      localObject2 = new axae((String)localObject1);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, localObject2);
    }
    localObject1 = (axae)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
    Object localObject2 = MessageRecord.getTableName(paramawzz.jdField_a_of_type_JavaLangString, paramawzz.jdField_a_of_type_Int);
    QQMessageFacade localQQMessageFacade = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    int j;
    int k;
    int m;
    if (paramawzz.jdField_e_of_type_Int == 0)
    {
      j = localQQMessageFacade.getQuickDBMsgCount((String)localObject2, paramawzz.jdField_a_of_type_Long, paramawzz.jdField_b_of_type_Long, paramawzz.jdField_a_of_type_Boolean);
      k = localQQMessageFacade.getSlowDBMsgCount((String)localObject2, paramawzz.jdField_a_of_type_Long, paramawzz.jdField_b_of_type_Long, paramawzz.jdField_a_of_type_Boolean);
      m = j + k;
      paramawzz.jdField_c_of_type_Int = j;
      paramawzz.jdField_d_of_type_Int = k;
      paramawzz.jdField_e_of_type_Int = m;
      if ((m != 0) && ((paramawzz.g < m) || (this.jdField_e_of_type_Int != 0))) {
        break label301;
      }
      if ((this.jdField_a_of_type_Awzy != null) && (this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm != null))
      {
        localObject2 = new axao();
        ((axao)localObject2).jdField_a_of_type_JavaLangString = paramawzz.jdField_a_of_type_JavaLangString;
        ((axao)localObject2).jdField_a_of_type_Int = paramawzz.jdField_a_of_type_Int;
        this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm.a(this.jdField_a_of_type_Awzy, localObject2);
      }
      ((axae)localObject1).a();
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
      j = paramawzz.jdField_c_of_type_Int;
      k = paramawzz.jdField_d_of_type_Int;
      m = paramawzz.jdField_e_of_type_Int;
      break;
      axcw.b(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickDBCount = %d,slowDBCount = %d,totalCount = %d,request.queryIndex = %d,queryCount = %d", new Object[] { localObject2, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(paramawzz.h), Integer.valueOf(paramawzz.g) });
      int i;
      Object localObject3;
      Object localObject4;
      label1276:
      if (k == 0)
      {
        i = paramawzz.g;
        if (i < paramawzz.jdField_c_of_type_Int)
        {
          for (;;)
          {
            k = paramawzz.h + 1;
            localObject3 = localQQMessageFacade.getSqlStr((String)localObject2, paramawzz.jdField_a_of_type_Long, paramawzz.jdField_b_of_type_Long, k, jdField_a_of_type_Int, paramawzz.jdField_a_of_type_Boolean);
            axcw.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu querySql = %s", new Object[] { localObject3 });
            localObject3 = localQQMessageFacade.getQuickDbMessage((String)localObject3, (String)localObject2);
            if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
              break label654;
            }
            m = ((List)localObject3).size();
            axcw.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu queryMsgSize = %d", new Object[] { Integer.valueOf(m) });
            localObject4 = new MsgBackupController.2(this, (axae)localObject1, paramawzz, (List)localObject3, k);
            this.jdField_e_of_type_Int += jdField_a_of_type_Int;
            i += jdField_a_of_type_Int;
            paramawzz.g += jdField_a_of_type_Int;
            paramawzz.h = ((int)((MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1)).getId());
            axcw.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu querySql lastQueryIndex = %d", new Object[] { Integer.valueOf(paramawzz.h) });
            this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject4);
            axcw.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { localObject2, Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramawzz.h) });
            if ((i >= j) || (this.jdField_e_of_type_Int >= jdField_b_of_type_Int)) {
              break;
            }
          }
          axcw.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu queryMsgSize = 0,mPendingMsgCount = %d", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) });
          if ((this.jdField_e_of_type_Int == 0) && (this.jdField_a_of_type_Awzy != null) && (this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm != null))
          {
            localObject2 = new axao();
            ((axao)localObject2).jdField_a_of_type_JavaLangString = paramawzz.jdField_a_of_type_JavaLangString;
            ((axao)localObject2).jdField_a_of_type_Int = paramawzz.jdField_a_of_type_Int;
            this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm.a(this.jdField_a_of_type_Awzy, localObject2);
            this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
            ((axae)localObject1).a();
          }
        }
      }
      else
      {
        i = paramawzz.g;
        label766:
        if (i < m)
        {
          if (i < k)
          {
            j = paramawzz.h + 1;
            localObject3 = localQQMessageFacade.getSlowDbMessage(localQQMessageFacade.getSqlStr((String)localObject2, paramawzz.jdField_a_of_type_Long, paramawzz.jdField_b_of_type_Long, j, jdField_a_of_type_Int, paramawzz.jdField_a_of_type_Boolean), (String)localObject2);
            if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
              break label1386;
            }
            m = ((List)localObject3).size();
            axcw.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu slowDB queryMsgSize = %d", new Object[] { Integer.valueOf(m) });
            localObject4 = new MsgBackupController.3(this, (axae)localObject1, paramawzz, (List)localObject3, j);
            this.jdField_e_of_type_Int += jdField_a_of_type_Int;
            i += jdField_a_of_type_Int;
            paramawzz.g += jdField_a_of_type_Int;
            paramawzz.h = ((int)((MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1)).getId());
            this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject4);
            axcw.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { localObject2, Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramawzz.h) });
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
            paramawzz.g = k;
            paramawzz.h = 0;
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
              k = paramawzz.h + 1;
              localObject3 = localQQMessageFacade.getQuickDbMessage(localQQMessageFacade.getSqlStr((String)localObject2, paramawzz.jdField_a_of_type_Long, paramawzz.jdField_b_of_type_Long, k, jdField_a_of_type_Int, paramawzz.jdField_a_of_type_Boolean), (String)localObject2);
              if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
                break label1276;
              }
              m = ((List)localObject3).size();
              axcw.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu quickDB queryMsgSize = %d", new Object[] { Integer.valueOf(m) });
              localObject4 = new MsgBackupController.4(this, (axae)localObject1, paramawzz, (List)localObject3, k);
              this.jdField_e_of_type_Int += jdField_a_of_type_Int;
              i += jdField_a_of_type_Int;
              paramawzz.g += jdField_a_of_type_Int;
              paramawzz.h = ((int)((MessageRecord)((List)localObject3).get(((List)localObject3).size() - 1)).getId());
              this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject4);
              axcw.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu dbName = %s,quickOnly,pendingMsgCount = %d,request.queryIndex = %d ", new Object[] { localObject2, Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramawzz.h) });
              if ((i >= j) || (this.jdField_e_of_type_Int >= jdField_b_of_type_Int)) {
                break;
              }
            }
            axcw.a(jdField_a_of_type_JavaLangString, "singleExcuteQianchu queryMsgSize = 0,mPendingMsgCount = %d", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int) });
            if ((this.jdField_e_of_type_Int != 0) || (this.jdField_a_of_type_Awzy == null) || (this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm == null)) {
              break label280;
            }
            localObject2 = new axao();
            ((axao)localObject2).jdField_a_of_type_JavaLangString = paramawzz.jdField_a_of_type_JavaLangString;
            ((axao)localObject2).jdField_a_of_type_Int = paramawzz.jdField_a_of_type_Int;
            this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm.a(this.jdField_a_of_type_Awzy, localObject2);
            this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
            ((axae)localObject1).a();
            return;
            break label778;
          }
        }
      }
    }
  }
  
  public void a(axae paramaxae, awzz paramawzz, List<MsgBackupMsgEntity> paramList)
  {
    paramList.size();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    axcw.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:query done ,msgEntity.size = %d ", new Object[] { Integer.valueOf(paramList.size()) });
    Object localObject1 = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject3 = (MsgBackupMsgEntity)paramList.next();
      if (((MsgBackupMsgEntity)localObject3).extensionData == null)
      {
        i += 1;
        axcw.b(jdField_a_of_type_JavaLangString, "segmentDaoru step has encounter msgEntity.extensionData == null,msgType = %d,invalidMsgCount = %d", new Object[] { Integer.valueOf(((MsgBackupMsgEntity)localObject3).msgType), Integer.valueOf(i) });
      }
      else
      {
        try
        {
          localObject3 = ((axai)localObject2).a((MsgBackupMsgEntity)localObject3);
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
    axcw.a(jdField_a_of_type_JavaLangString, "segmentDaoru step:trans done ,msg.size = %d ", new Object[] { Integer.valueOf(((List)localObject1).size()) });
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
        if (axiv.a((ChatMessage)localObject4))
        {
          localObject5 = paramaxae.a(((MessageRecord)localObject4).msgBackupMsgSeq, ((MessageRecord)localObject4).msgBackupMsgRandom);
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
        paramList = awzw.b((MessageRecord)localObject4, paramList);
        axcw.a(jdField_a_of_type_JavaLangString, "multimsg_tempFilPath = %s", new Object[] { paramList });
        paramList = new File(paramList);
        if (!paramList.exists()) {
          break label243;
        }
        axcw.a(jdField_a_of_type_JavaLangString, "multimsg_tempFilPath exist = %b", new Object[] { Boolean.valueOf(true) });
        paramList = FileUtils.fileToBytes(paramList);
        paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a(paramList, null, (MessageRecord)localObject4, null);
        if ((paramList == null) || (paramList.size() <= 0)) {
          break label243;
        }
        localIterator1 = awzw.a(paramList).iterator();
        for (;;)
        {
          if (!localIterator1.hasNext()) {
            break label533;
          }
          MessageRecord localMessageRecord = (MessageRecord)localIterator1.next();
          Iterator localIterator2 = this.jdField_a_of_type_JavaUtilList.iterator();
          if (localIterator2.hasNext())
          {
            awzn localawzn = (awzn)localIterator2.next();
            if (!localawzn.a(localMessageRecord)) {
              break;
            }
            localawzn.b(localMessageRecord, (List)localObject5);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a((MessageRecord)localObject4, paramList, null);
        break label243;
        localObject5 = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject5).hasNext()) {
          break label243;
        }
        paramList = (awzn)((Iterator)localObject5).next();
        if (!paramList.a((MessageRecord)localObject4)) {
          break;
        }
        localObject5 = paramaxae.a(((MessageRecord)localObject4).msgBackupMsgSeq, ((MessageRecord)localObject4).msgBackupMsgRandom);
        if (localObject5 != null) {}
        for (i = ((List)localObject5).size();; i = 0)
        {
          axcw.a(jdField_a_of_type_JavaLangString, "segmentDaoru step:rich process ,query.res.size = %d ", new Object[] { Integer.valueOf(i) });
          paramList.b((MessageRecord)localObject4, (List)localObject5);
          break;
        }
        paramaxae = new ArrayList();
        localObject2 = (MessageRecord)((List)localObject1).get(0);
        paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages(((MessageRecord)localObject2).frienduin, ((MessageRecord)localObject2).istroop, null);
        localObject4 = jdField_a_of_type_JavaLangString;
        if (paramList != null)
        {
          i = paramList.size();
          axcw.b((String)localObject4, "segmentDaoru step:mainMsg.size = %d,uin = %s,istroop = %d ", new Object[] { Integer.valueOf(i), ((MessageRecord)localObject2).frienduin, Integer.valueOf(((MessageRecord)localObject2).istroop) });
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
                    axcw.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter duplicated troopMsg ,mr.msgshseq = 0.Msg.msgStr = %s ,mainMsg.msgStr = %s, msgtype = %d", new Object[] { ((MessageRecord)localObject2).msg, ((MessageRecord)localObject5).msg, Integer.valueOf(((MessageRecord)localObject2).msgtype) });
                  }
                  if ((((MessageRecord)localObject2).shmsgseq != ((MessageRecord)localObject5).shmsgseq) || (((MessageRecord)localObject2).msgtype != ((MessageRecord)localObject5).msgtype)) {
                    continue;
                  }
                  axcw.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter duplicated msg ,msgbackup.Msg.msgStr = %s ,mainMsg.msgStr = %s, msgtype = %d", new Object[] { ((MessageRecord)localObject2).msg, ((MessageRecord)localObject5).msg, Integer.valueOf(((MessageRecord)localObject2).msgtype) });
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
            paramaxae.add(localObject2);
            break label772;
            i = 0;
            break;
            if ((((MessageRecord)localObject2).msgUid != ((MessageRecord)localObject5).msgUid) || (((MessageRecord)localObject2).msgtype != ((MessageRecord)localObject5).msgtype)) {
              break label815;
            }
            axcw.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter duplicated msg ,msgbackup.Msg.msgStr = %s ,mainMsg.msgStr", new Object[] { ((MessageRecord)localObject2).msg, ((MessageRecord)localObject5).msg });
            i = 1;
            continue;
            axcw.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:msgfilter done ,msgNew.size = %d ,uin = %s", new Object[] { Integer.valueOf(paramaxae.size()), paramawzz.jdField_a_of_type_JavaLangString });
            if (paramaxae.size() > 0)
            {
              Collections.sort(paramaxae, this);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessageForMsgBackup(paramaxae);
              if (axcw.jdField_a_of_type_Boolean)
              {
                ((MessageRecord)paramaxae.get(0)).getTableName();
                paramaxae = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getAllMessages(paramawzz.jdField_a_of_type_JavaLangString, paramawzz.jdField_a_of_type_Int, null);
                if (paramaxae != null) {
                  break label1204;
                }
              }
            }
            for (i = 0;; i = paramaxae.size())
            {
              axcw.a(jdField_a_of_type_JavaLangString, "daoru step:seqmentDaoru done result size =  %d", new Object[] { Integer.valueOf(i) });
              axcw.b(jdField_a_of_type_JavaLangString, "segmentDaoru step:saveToDb done ", new Object[0]);
              return;
            }
            i = 0;
          }
        }
        paramList = null;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, axae paramaxae, awzz paramawzz, List<MessageRecord> paramList, long paramLong, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramaxae == null) || (paramList == null)) {
      return;
    }
    int i = paramList.size();
    a(paramQQAppInterface, paramaxae, paramList);
    for (;;)
    {
      try
      {
        paramawzz.f = (i + paramawzz.f);
        this.jdField_e_of_type_Int -= paramInt;
        axcw.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step segment startNext,startIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramawzz.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramawzz.jdField_e_of_type_Int) });
        if (paramawzz.f >= paramawzz.jdField_e_of_type_Int)
        {
          if ((this.jdField_a_of_type_Awzy != null) && (this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm != null))
          {
            paramQQAppInterface = new axao();
            paramQQAppInterface.jdField_a_of_type_JavaLangString = paramawzz.jdField_a_of_type_JavaLangString;
            paramQQAppInterface.jdField_a_of_type_Int = paramawzz.jdField_a_of_type_Int;
            this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm.a(this.jdField_a_of_type_Awzy, paramQQAppInterface);
          }
          axcw.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step this session has process done ,uin = %s,uintype = %d,msgSize = %d", new Object[] { paramawzz.jdField_a_of_type_JavaLangString, Integer.valueOf(paramawzz.jdField_a_of_type_Int), Integer.valueOf(paramaxae.a()) });
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramaxae.a());
          paramaxae.a();
          awzx.b();
          axcv.a("statis_qianchums_end");
          this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
          return;
        }
      }
      finally {}
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(2);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, axae paramaxae, List<MessageRecord> paramList)
  {
    if ((paramQQAppInterface == null) || (paramaxae == null) || (paramList == null)) {
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
      if (axiv.a((ChatMessage)localMessageRecord))
      {
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a(localMessageRecord);
        Object localObject5 = awzw.a((HashMap)localObject4);
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
              awzn localawzn = (awzn)localIterator.next();
              if (!localawzn.a((MessageRecord)localObject6)) {
                break;
              }
              localawzn.a((MessageRecord)localObject6, (List)localObject1);
              ((ArrayList)localObject3).addAll((Collection)localObject1);
              ((ArrayList)localObject1).clear();
            }
          }
          label227:
          long l1 = axcw.a(localMessageRecord);
          long l2 = axcw.b(localMessageRecord);
          localObject5 = ((ArrayList)localObject3).iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = (MsgBackupResEntity)((Iterator)localObject5).next();
            ((MsgBackupResEntity)localObject6).msgSeq = l1;
            ((MsgBackupResEntity)localObject6).msgRandom = l2;
          }
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy().a((HashMap)localObject4, null, true);
          localObject5 = axcw.b(((MessageForStructing)localMessageRecord).structingMsg.mFileName);
          FileUtils.writeFile((byte[])localObject4, (String)localObject5);
          Object localObject6 = new MsgBackupResEntity();
          ((MsgBackupResEntity)localObject6).msgSeq = l1;
          ((MsgBackupResEntity)localObject6).msgRandom = l2;
          ((MsgBackupResEntity)localObject6).filePath = ((String)localObject5);
          ((MsgBackupResEntity)localObject6).fileSize = localObject4.length;
          ((MsgBackupResEntity)localObject6).msgSubType = 10;
          ((MsgBackupResEntity)localObject6).msgType = 4;
          ((MsgBackupResEntity)localObject6).extraDataStr = awzw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), localMessageRecord);
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
          localObject4 = (awzn)((Iterator)localObject3).next();
          if (!((awzn)localObject4).a(localMessageRecord)) {
            break;
          }
          ((awzn)localObject4).a(localMessageRecord, (List)localObject1);
          paramQQAppInterface.addAll((Collection)localObject1);
          ((ArrayList)localObject1).clear();
        }
      }
    }
    label492:
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    localObject2 = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localMessageRecord = (MessageRecord)paramList.next();
      try
      {
        localObject3 = ((axai)localObject1).a(localMessageRecord);
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
      axcw.a(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu generate pb failed ..unsupport not chatMessage _id = %d,msgtype = %d .mr =%s ", new Object[] { Long.valueOf(localThrowable.getId()), Integer.valueOf(localThrowable.msgtype), localThrowable.toString() });
    }
    axcw.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step segment msg process  + msg.size = %d ", new Object[] { Integer.valueOf(((ArrayList)localObject2).size()) });
    paramaxae.a((List)localObject2);
    paramaxae.b(paramQQAppInterface);
    axcw.b(jdField_a_of_type_JavaLangString, "segmentExcuteQianchu step segment insert db done", new Object[0]);
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
  
  public void b(awzy paramawzy)
  {
    axcv.e = 0L;
    HashSet localHashSet = paramawzy.jdField_a_of_type_JavaUtilHashSet;
    if ((localHashSet == null) || (localHashSet.size() == 0))
    {
      axcw.b(jdField_a_of_type_JavaLangString, "qianchu no recentdBaseData ", new Object[0]);
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    awzx.a();
    axcv.c();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (RecentBaseData)localIterator.next();
      String str = ((RecentBaseData)localObject).getRecentUserUin();
      int i = ((RecentBaseData)localObject).getRecentUserType();
      axcw.b(jdField_a_of_type_JavaLangString, "requestQianchu uin = %s ", new Object[] { str });
      localObject = new awzz();
      ((awzz)localObject).jdField_a_of_type_JavaLangString = str;
      ((awzz)localObject).jdField_a_of_type_Int = i;
      ((awzz)localObject).jdField_b_of_type_Int = 0;
      ((awzz)localObject).jdField_a_of_type_Long = paramawzy.jdField_a_of_type_Long;
      ((awzz)localObject).jdField_b_of_type_Long = paramawzy.jdField_b_of_type_Long;
      ((awzz)localObject).jdField_a_of_type_Boolean = paramawzy.jdField_a_of_type_Boolean;
      ((awzz)localObject).g = -1;
      ((awzz)localObject).h = 0;
      str = a(str, i);
      this.jdField_a_of_type_JavaUtilArrayList.add(str);
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
    }
    paramawzy.jdField_b_of_type_Int = localHashSet.size();
    paramawzy.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(1);
  }
  
  public void b(awzz paramawzz)
  {
    Object localObject1 = axcw.a(paramawzz);
    axcw.b(jdField_a_of_type_JavaLangString, "singleNextQianru step:start dbName = %s， request.queryIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { localObject1, Integer.valueOf(paramawzz.h), Integer.valueOf(paramawzz.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramawzz.jdField_e_of_type_Int) });
    axcw.a();
    localObject1 = new axae((String)localObject1);
    if (paramawzz.jdField_e_of_type_Int == 0) {
      paramawzz.jdField_e_of_type_Int = ((axae)localObject1).b();
    }
    int i = paramawzz.jdField_e_of_type_Int;
    if ((i == 0) || ((paramawzz.g >= paramawzz.jdField_e_of_type_Int) && (this.jdField_e_of_type_Int == 0)))
    {
      axcw.b(jdField_a_of_type_JavaLangString, "singleNextQianru step queryResList.size = 0,", new Object[0]);
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(6);
      ((axae)localObject1).a();
      return;
    }
    while ((paramawzz.g < i) && (this.jdField_e_of_type_Int < jdField_d_of_type_Int))
    {
      axcw.b(jdField_a_of_type_JavaLangString, "singleNextQianru step:,request.queryIndex = %d,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d", new Object[] { Integer.valueOf(paramawzz.h), Integer.valueOf(paramawzz.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramawzz.jdField_e_of_type_Int) });
      Object localObject2 = ((axae)localObject1).a(paramawzz.h + 1, jdField_c_of_type_Int);
      paramawzz.g += jdField_a_of_type_Int;
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        paramawzz.h = ((int)((MsgBackupResEntity)((List)localObject2).get(((List)localObject2).size() - 1)).getId());
        this.jdField_e_of_type_Int += jdField_c_of_type_Int;
        localObject2 = new MsgBackupController.5(this, (List)localObject2, paramawzz);
        this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject2);
      }
      else if (this.jdField_e_of_type_Int == 0)
      {
        if ((paramawzz.f == paramawzz.jdField_e_of_type_Int) || (this.jdField_d_of_type_JavaUtilConcurrentConcurrentHashMap.size() <= 0)) {
          break label372;
        }
        a(null, null, 0L);
      }
    }
    for (;;)
    {
      ((axae)localObject1).a();
      return;
      label372:
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(6);
    }
  }
  
  public void b(axae paramaxae, awzz paramawzz, List<MsgBackupMsgEntity> paramList)
  {
    if ((paramaxae != null) && (paramawzz != null) && (paramList != null))
    {
      int i = paramList.size();
      a(paramaxae, paramawzz, paramList);
      try
      {
        this.jdField_e_of_type_Int -= jdField_a_of_type_Int;
        paramawzz.f = (i + paramawzz.f);
        axcw.b(jdField_a_of_type_JavaLangString, "segmentDaoru step segment startNext,request.doneCount = %d,mPendingMsgCount = %d,totalCount = %d,uin = %s ", new Object[] { Integer.valueOf(paramawzz.f), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(paramawzz.jdField_e_of_type_Int), paramawzz.jdField_a_of_type_JavaLangString });
        if (paramawzz.f >= paramawzz.jdField_e_of_type_Int)
        {
          if ((this.jdField_a_of_type_Awzy != null) && (this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm != null))
          {
            paramList = new axao();
            paramList.jdField_a_of_type_JavaLangString = paramawzz.jdField_a_of_type_JavaLangString;
            paramList.jdField_a_of_type_Int = paramawzz.jdField_a_of_type_Int;
            this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm.a(this.jdField_a_of_type_Awzy, paramList);
          }
          axcw.b(jdField_a_of_type_JavaLangString, "segmentDaoru step this session has process done ,uin = %s,uintype = %d", new Object[] { paramawzz.jdField_a_of_type_JavaLangString, Integer.valueOf(paramawzz.jdField_a_of_type_Int) });
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramaxae.a());
          paramaxae.a();
          this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
        }
        for (;;)
        {
          return;
          this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(4);
        }
        return;
      }
      finally {}
    }
  }
  
  public void c(awzy paramawzy)
  {
    HashSet localHashSet = paramawzy.jdField_a_of_type_JavaUtilHashSet;
    if ((localHashSet == null) || (localHashSet.size() == 0))
    {
      axcw.a(jdField_a_of_type_JavaLangString, "daoru no recentdBaseData ", new Object[0]);
      return;
    }
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (RecentBaseData)localIterator.next();
      String str = ((RecentBaseData)localObject).getRecentUserUin();
      int i = ((RecentBaseData)localObject).getRecentUserType();
      axcw.b(jdField_a_of_type_JavaLangString, "daoru uin = %s ", new Object[] { str });
      localObject = new awzz();
      ((awzz)localObject).jdField_a_of_type_JavaLangString = str;
      ((awzz)localObject).jdField_a_of_type_Int = i;
      ((awzz)localObject).jdField_b_of_type_Int = 2;
      ((awzz)localObject).g = -1;
      ((awzz)localObject).h = -1;
      str = a(str, i);
      this.jdField_b_of_type_JavaUtilArrayList.add(str);
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject);
    }
    paramawzy.jdField_b_of_type_Int = localHashSet.size();
    paramawzy.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
  }
  
  public void c(awzz paramawzz)
  {
    awzs.jdField_a_of_type_JavaLangString = null;
    awzs.jdField_c_of_type_JavaLangString = null;
    e(paramawzz);
    Object localObject1;
    if (TextUtils.isEmpty(awzs.jdField_c_of_type_JavaLangString))
    {
      if (this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm != null)
      {
        localObject1 = new axao();
        ((axao)localObject1).jdField_a_of_type_JavaLangString = paramawzz.jdField_a_of_type_JavaLangString;
        ((axao)localObject1).jdField_a_of_type_Int = paramawzz.jdField_a_of_type_Int;
        axcw.b(jdField_a_of_type_JavaLangString, "singleDaoru progress callback curIndex = %d,totalCount = %d ", new Object[] { Integer.valueOf(paramawzz.h), Integer.valueOf(paramawzz.jdField_e_of_type_Int) });
        this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm.a(this.jdField_a_of_type_Awzy, localObject1);
      }
      this.jdField_b_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
      this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
    }
    do
    {
      return;
      localObject1 = axcw.a(paramawzz);
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1) == null)
      {
        localObject2 = new axae((String)localObject1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject1, localObject2);
      }
      localObject1 = (axae)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localObject1);
      int i = ((axae)localObject1).a();
      if (paramawzz.jdField_e_of_type_Int == 0) {
        paramawzz.jdField_e_of_type_Int = ((axae)localObject1).a();
      }
      if ((paramawzz.jdField_e_of_type_Int == 0) || ((paramawzz.g >= i) && (this.jdField_e_of_type_Int == 0)))
      {
        if (this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm != null)
        {
          localObject2 = new axao();
          ((axao)localObject2).jdField_a_of_type_JavaLangString = paramawzz.jdField_a_of_type_JavaLangString;
          ((axao)localObject2).jdField_a_of_type_Int = paramawzz.jdField_a_of_type_Int;
          axcw.b(jdField_a_of_type_JavaLangString, "singleDaoru progress callback curIndex = %d,totalCount = %d ", new Object[] { Integer.valueOf(paramawzz.h), Integer.valueOf(paramawzz.jdField_e_of_type_Int) });
          this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm.a(this.jdField_a_of_type_Awzy, localObject2);
        }
        ((axae)localObject1).a();
        this.jdField_b_of_type_MqqOsMqqHandler.sendEmptyMessage(3);
        return;
      }
      do
      {
        paramawzz.h = ((int)((MsgBackupMsgEntity)((List)localObject2).get(((List)localObject2).size() - 1)).getId());
        axcw.a(jdField_a_of_type_JavaLangString, "singleDaoru queryMsg result.size = %d ", new Object[] { Integer.valueOf(((List)localObject2).size()) });
        this.jdField_e_of_type_Int += jdField_a_of_type_Int;
        localObject2 = new MsgBackupController.6(this, (axae)localObject1, paramawzz, (List)localObject2);
        this.jdField_a_of_type_JavaUtilConcurrentExecutor.execute((Runnable)localObject2);
        if ((paramawzz.g >= i) || (this.jdField_e_of_type_Int >= jdField_b_of_type_Int)) {
          break;
        }
        axcw.b(jdField_a_of_type_JavaLangString, "singleDaoru queryMsgBefore  curIndex = %d,totalCount = %d,doneCount = %d ", new Object[] { Integer.valueOf(paramawzz.h), Integer.valueOf(paramawzz.jdField_e_of_type_Int), Integer.valueOf(paramawzz.f) });
        if (paramawzz.g <= 0) {
          axai.jdField_a_of_type_Long = 0L;
        }
        localObject2 = ((axae)localObject1).a(paramawzz.h + 1, jdField_a_of_type_Int);
        paramawzz.g += jdField_a_of_type_Int;
      } while ((localObject2 != null) && (((List)localObject2).size() != 0));
      axcw.b(jdField_a_of_type_JavaLangString, "singleDaoru..query result == 0", new Object[0]);
    } while ((this.jdField_e_of_type_Int != 0) || (this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm == null));
    axcw.a(jdField_a_of_type_JavaLangString, "singleDaoru queryMsgAfter  msgSize = = 0 ", new Object[0]);
    Object localObject2 = new axao();
    ((axao)localObject2).jdField_a_of_type_JavaLangString = paramawzz.jdField_a_of_type_JavaLangString;
    ((axao)localObject2).jdField_a_of_type_Int = paramawzz.jdField_a_of_type_Int;
    this.jdField_a_of_type_Awzy.jdField_a_of_type_Awzm.a(this.jdField_a_of_type_Awzy, localObject2);
    ((axae)localObject1).a();
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
        axcw.a((String)localObject, "MSG_WHAT_SUB_REQUEST_POST msg.obj = %b", new Object[] { Boolean.valueOf(bool1) });
        bool1 = bool2;
        if (!(paramMessage.obj instanceof awzy)) {
          break;
        }
        a((awzy)paramMessage.obj);
        return true;
      }
    case 5: 
      if (TextUtils.isEmpty(awzs.b))
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
      if ((TextUtils.isEmpty(awzs.jdField_a_of_type_JavaLangString)) && ((paramMessage.obj instanceof awzy)))
      {
        localObject = (awzy)paramMessage.obj;
        awzz localawzz = new awzz();
        axcw.a(((awzy)localObject).jdField_a_of_type_JavaLangString.substring(((awzy)localObject).jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1), localawzz);
        e(localawzz);
      }
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(6);
      ((Message)localObject).obj = paramMessage.obj;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
      return true;
    }
    if (TextUtils.isEmpty(awzs.jdField_a_of_type_JavaLangString))
    {
      axcw.a(jdField_a_of_type_JavaLangString, "MSG_WHAT_SUB_DECRYPT_KEY_VALID sFileMeta is null, so skip this session!", new Object[0]);
      f();
      return true;
    }
    Object localObject = (String)awzs.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(awzs.jdField_a_of_type_JavaLangString);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(6);
      ((Message)localObject).obj = paramMessage.obj;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, 1000L);
      return true;
    }
    awzs.jdField_c_of_type_JavaLangString = (String)localObject;
    localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(0);
    ((Message)localObject).obj = paramMessage.obj;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage((Message)localObject);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awzp
 * JD-Core Version:    0.7.0.1
 */