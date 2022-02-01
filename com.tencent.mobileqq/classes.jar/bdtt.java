import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.SttManager.1;
import com.tencent.mobileqq.stt.SttManager.2;
import com.tencent.mobileqq.stt.SttManager.3;
import com.tencent.mobileqq.stt.SttManager.4;
import com.tencent.mobileqq.stt.SttManager.5;
import com.tencent.mobileqq.stt.SttManager.6;
import com.tencent.mobileqq.stt.SttManager.7;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttResp;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttShardRsp;

public class bdtt
  implements Handler.Callback, Manager, BusinessObserver
{
  private static int jdField_a_of_type_Int = -1;
  protected Handler a;
  public bdtu a;
  public QQAppInterface a;
  private ConcurrentHashMap<Long, bdtw> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<Long> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private volatile boolean jdField_a_of_type_Boolean;
  private int b;
  protected Handler b;
  
  public bdtt()
  {
    this.jdField_b_of_type_Int = -1;
  }
  
  public bdtt(QQAppInterface paramQQAppInterface)
  {
    this();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("rich_status" + paramQQAppInterface.getCurrentUin(), 0).getInt("k_c_v", 0);
  }
  
  private void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface.getApplication().getSharedPreferences("rich_status" + paramQQAppInterface.getCurrentUin(), 0).edit().putInt("k_c_v", paramInt).commit();
  }
  
  private void a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    if (paramMessageForPtt != null)
    {
      paramMessageForPtt.sttAbility = 3;
      paramMessageForPtt.sttText = "";
      paramMessageForPtt.isReadPtt = true;
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_succ_flag", "0");
      localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
      localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      localHashMap.put("param_resultCode", paramInt + "");
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "ptttotextSuc", false, 0L, 0L, localHashMap, null);
    }
    try
    {
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgContentByUniseq(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
      return;
    }
    catch (Exception paramMessageForPtt)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.stt", 2, "updatedb", paramMessageForPtt);
    }
  }
  
  private boolean a()
  {
    if (this.jdField_b_of_type_Int == -1) {
      this.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).getInt("k_ability_101" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1);
    }
    return this.jdField_b_of_type_Int == 1;
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Int < 0) {
      jdField_a_of_type_Int = paramQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).getInt("k_ability_" + paramQQAppInterface.getAccount(), 0);
    }
    if (jdField_a_of_type_Int == 1) {
      return true;
    }
    return ((bdtt)paramQQAppInterface.getManager(QQManagerFactory.STT_MANAGER)).a();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (a(paramQQAppInterface) != paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        jdField_a_of_type_Int = i;
        paramQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).edit().putInt("k_ability_" + paramQQAppInterface.getAccount(), jdField_a_of_type_Int).commit();
        return true;
      }
    }
    return false;
  }
  
  private Long c(MessageForPtt paramMessageForPtt, int paramInt)
  {
    bdtw localbdtw = bdtw.a(paramMessageForPtt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
    localbdtw.a(this.jdField_a_of_type_AndroidOsHandler);
    Long localLong = localbdtw.b();
    if (localLong != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localLong, localbdtw);
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(Long.valueOf(paramMessageForPtt.uniseq));
    }
    return localLong;
  }
  
  public Long a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    return b(paramMessageForPtt, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).edit().putInt("k_ability_101" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramInt).apply();
    try
    {
      StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      localHashMap.put("appversion", "8.4.10");
      localStatisticCollector.collectPerformance("", "PttSttEntryChange", false, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(bdtu parambdtu)
  {
    this.jdField_a_of_type_Bdtu = parambdtu;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    SttResultPush.MsgBody localMsgBody = new SttResultPush.MsgBody();
    for (;;)
    {
      bdtw localbdtw;
      try
      {
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (localMsgBody.msg_ptt_shard_resp.has())
        {
          paramArrayOfByte = Long.valueOf(localMsgBody.msg_ptt_shard_resp.uint64_sessionid.get());
          localbdtw = (bdtw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramArrayOfByte);
          if (localbdtw != null) {
            break label134;
          }
          if (QLog.isColorLevel()) {
            QLog.e("Q.stt", 2, "onSttResultPush task not find: session = " + paramArrayOfByte);
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.stt", 2, "onSttResultPush failed with: ", paramArrayOfByte);
        return;
      }
      if (localMsgBody.msg_ptt_resp.has())
      {
        paramArrayOfByte = Long.valueOf(localMsgBody.msg_ptt_resp.uint64_sessionid.get());
        continue;
        label134:
        boolean bool = localbdtw.a(localMsgBody);
        if (QLog.isColorLevel()) {
          QLog.e("Q.stt", 2, "onSttResultPush task doReceivePushData session = " + paramArrayOfByte + " | result = " + bool);
        }
      }
      else
      {
        paramArrayOfByte = Long.valueOf(0L);
      }
    }
  }
  
  public boolean a(MessageForPtt paramMessageForPtt)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(Long.valueOf(paramMessageForPtt.uniseq));
  }
  
  public Long b(MessageForPtt paramMessageForPtt, int paramInt)
  {
    a();
    if (paramMessageForPtt.istroop == 0)
    {
      if (StringUtil.isEmpty(paramMessageForPtt.urlAtServer))
      {
        QLog.e("", 1, new Object[] { "stt err, c2c no fileID ", paramMessageForPtt });
        paramMessageForPtt.getSttResult().a(1, 2003);
        this.jdField_b_of_type_AndroidOsHandler.post(new SttManager.1(this, paramMessageForPtt));
        return Long.valueOf(paramMessageForPtt.uniseq);
      }
    }
    else if (StringUtil.isEmpty(paramMessageForPtt.md5))
    {
      QLog.e("", 1, new Object[] { "stt err, troop no md5 ", paramMessageForPtt });
      paramMessageForPtt.getSttResult().a(1, 2004);
      this.jdField_b_of_type_AndroidOsHandler.post(new SttManager.2(this, paramMessageForPtt));
      return Long.valueOf(paramMessageForPtt.uniseq);
    }
    Object localObject = arjw.c();
    boolean bool = bhzf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_add_ptt_svip_gray_msg", false);
    if ((((arjv)localObject).jdField_a_of_type_Int == 2) && (!bool) && (VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (ahdg.d))
    {
      localObject = new avhz(paramMessageForPtt.frienduin, paramMessageForPtt.selfuin, anvx.a(2131714003), paramMessageForPtt.istroop, -5020, 655392, paramMessageForPtt.time);
      MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
      if (paramMessageForPtt.istroop == 1) {
        localMessageForUniteGrayTip.shmsgseq = paramMessageForPtt.shmsgseq;
      }
      localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (avhz)localObject);
      avia.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
      bhzf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_add_ptt_svip_gray_msg", true);
      QLog.e("Q.stt", 1, "stage2 first translate It is need add gray msg and insert success");
    }
    for (;;)
    {
      return c(paramMessageForPtt, paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 1, "stage2 first translate It is need add gray msg and insert falied:conf.stage == " + ((arjv)localObject).jdField_a_of_type_Int + " && " + bool);
      }
    }
  }
  
  public boolean b(MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt.autoToText >= 1) && (!a(paramMessageForPtt)) && (paramMessageForPtt.sttAbility != 2)) {}
    do
    {
      return true;
      bhfx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "needAuotoChange AutoChangeFlag=" + ahdg.d + " AutoChangeSetTime=" + ahdg.a + " isTranslating=" + a(paramMessageForPtt) + "msgPtt.msgTime=" + paramMessageForPtt.msgTime + " msgPtt.time=" + paramMessageForPtt.time + " msgPtt.sttAbility=" + paramMessageForPtt.sttAbility + " isRedPackPTT=" + alcm.a(paramMessageForPtt));
      }
    } while ((!a(paramMessageForPtt)) && (!alcm.a(paramMessageForPtt)) && (ahdg.d) && ((ahdg.a < paramMessageForPtt.msgTime) || (ahdg.a < paramMessageForPtt.time)) && (paramMessageForPtt.voiceChangeFlag != 1) && ((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)));
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    long l = paramMessage.arg1 << 32 | paramMessage.arg2 & 0xFFFFFFFF;
    switch (paramMessage.what)
    {
    default: 
      QLog.e("Q.stt", 1, "handleMessage unknown msg = " + paramMessage.what);
    }
    Object localObject1;
    do
    {
      do
      {
        do
        {
          Object localObject2;
          do
          {
            do
            {
              return true;
              localObject1 = (bdtw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
              if (localObject1 != null) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.e("Q.stt", 2, "handleMessage STT_MSG_STT_RSP_ERROR get sttTask is null = " + paramMessage.what);
            return true;
            paramMessage = ((bdtw)localObject1).a();
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(Long.valueOf(paramMessage.uniseq));
            this.jdField_b_of_type_AndroidOsHandler.post(new SttManager.3(this, paramMessage));
            return true;
            localObject2 = (bdtw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l));
            if (localObject2 != null) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("Q.stt", 2, "handleMessage STT_MSG_TASK_STT_UPDATE get sttTask is null = " + paramMessage.what);
          return true;
          localObject1 = ((bdtw)localObject2).a();
          if (((bdtw)localObject2).a() == 3)
          {
            ((MessageForPtt)localObject1).sttText = ((MessageForPtt)localObject1).getSttResult().a();
            ((MessageForPtt)localObject1).sttAbility = 2;
            ((MessageForPtt)localObject1).isReadPtt = true;
            ((MessageForPtt)localObject1).serial();
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
            this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(Long.valueOf(((MessageForPtt)localObject1).uniseq));
            this.jdField_b_of_type_AndroidOsHandler.post(new SttManager.4(this, (MessageForPtt)localObject1));
            if (QLog.isColorLevel()) {
              QLog.d("Q.stt", 2, "PttSttReport PTT_STT_RESULT_MONITOR success");
            }
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("resultCode", "0");
            ((HashMap)localObject2).put("subCode", "0");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSttResultMonitor", true, 0L, 0L, (HashMap)localObject2, null);
          }
        } while (!((MessageForPtt)localObject1).getSttResult().a());
        if (paramMessage.what == 4) {}
        for (boolean bool = true;; bool = false)
        {
          if ((bool) && (!((MessageForPtt)localObject1).isReadPtt))
          {
            ((MessageForPtt)localObject1).isReadPtt = true;
            ((MessageForPtt)localObject1).serial();
          }
          this.jdField_b_of_type_AndroidOsHandler.post(new SttManager.5(this, (MessageForPtt)localObject1, bool));
          return true;
        }
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Long.valueOf(l))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.stt", 2, "handleMessage TIME OUT task not key = " + paramMessage.what + "  | session = " + l);
      return true;
      localObject1 = (bdtw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(l));
      if (QLog.isColorLevel()) {
        QLog.e("Q.stt", 2, "handleMessage TIME OUT key = " + paramMessage.what + "  | session = " + l);
      }
    } while ((localObject1 == null) || (((bdtw)localObject1).a() == null));
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(Long.valueOf(((bdtw)localObject1).a().uniseq));
    int i = 2002;
    if (paramMessage.what == 3) {
      i = 2006;
    }
    paramMessage = ((bdtw)localObject1).a(i);
    if (paramMessage != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramMessage, localObject1);
      this.jdField_b_of_type_AndroidOsHandler.post(new SttManager.6(this, (bdtw)localObject1));
      return true;
    }
    paramMessage = ((bdtw)localObject1).a();
    a(paramMessage, paramMessage.getSttResult().c());
    this.jdField_b_of_type_AndroidOsHandler.post(new SttManager.7(this, (bdtw)localObject1));
    return true;
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(this);
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_Bdtu = null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "onReceive bundle is null");
      }
    }
    do
    {
      Long localLong;
      bdtw localbdtw;
      do
      {
        return;
        localLong = Long.valueOf(paramBundle.getLong("k_session", 0L));
        localbdtw = (bdtw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localLong);
        if (localbdtw != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.stt", 2, "mSttTaskList get by session is null , session = " + localLong);
      return;
      paramBoolean = localbdtw.a(paramBoolean, paramBundle);
    } while (!QLog.isColorLevel());
    QLog.d("Q.stt", 2, "onReceive result is " + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtt
 * JD-Core Version:    0.7.0.1
 */