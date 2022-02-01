import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;
import mqq.util.WeakReference;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttResp;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttShardRsp;

public class bdtw
{
  private static long jdField_a_of_type_Long;
  private int jdField_a_of_type_Int;
  private bdua jdField_a_of_type_Bdua;
  private bdub jdField_a_of_type_Bdub;
  private MessageForPtt jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  private volatile Long jdField_a_of_type_JavaLangLong = Long.valueOf(0L);
  private WeakReference<Handler> jdField_a_of_type_MqqUtilWeakReference;
  private int jdField_b_of_type_Int;
  private volatile Long jdField_b_of_type_JavaLangLong = Long.valueOf(0L);
  private WeakReference<QQAppInterface> jdField_b_of_type_MqqUtilWeakReference;
  
  public static long a()
  {
    if (jdField_a_of_type_Long == 0L)
    {
      long l2 = ((ardn)aqxe.a().a(488)).a();
      long l1 = l2;
      if (l2 == 0L) {
        l1 = 45000L;
      }
      jdField_a_of_type_Long = l1;
    }
    return jdField_a_of_type_Long;
  }
  
  public static bdtw a(MessageForPtt paramMessageForPtt, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if ((paramMessageForPtt == null) || (paramQQAppInterface == null)) {
      return null;
    }
    bdtw localbdtw = new bdtw();
    localbdtw.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt = paramMessageForPtt;
    localbdtw.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
    localbdtw.jdField_b_of_type_Int = paramInt;
    return localbdtw;
  }
  
  private void a(int paramInt)
  {
    a(paramInt, -1L);
  }
  
  private void a(int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.isEnqueued()))
    {
      QLog.e("Q.stt_SttTask", 1, "sendMsgHandlerDelayed, handlerWeakReference is Null msgKey = " + paramInt + " | sessionID = " + a());
      return;
    }
    QLog.e("Q.stt_SttTask", 1, "sendMsgHandlerDelayed,  msgKey = " + paramInt + " | sessionID = " + a() + " | delayMillis = " + paramLong);
    Handler localHandler = (Handler)this.jdField_a_of_type_MqqUtilWeakReference.get();
    long l = a().longValue();
    Message localMessage = localHandler.obtainMessage(paramInt, (int)(l >> 32) & 0xFFFFFFFF, (int)(l & 0xFFFFFFFF), this);
    if (paramLong > 0L)
    {
      localHandler.sendMessageDelayed(localMessage, paramLong);
      return;
    }
    localHandler.sendMessage(localMessage);
  }
  
  private long b()
  {
    int i = (int)(a().uniseq >> 32);
    int j = new Random().nextInt();
    long l = i & 0xFFFFFFFF;
    return j & 0xFFFFFFFF | l << 32;
  }
  
  private void b(int paramInt)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.isEnqueued()))
    {
      QLog.e("Q.stt_SttTask", 1, "checkAndRemoveMsgHandler, handlerWeakReference is Null msgKey = " + paramInt + " | sessionID = " + a());
      return;
    }
    Handler localHandler = (Handler)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localHandler.hasMessages(paramInt, this))
    {
      QLog.e("Q.stt_SttTask", 1, "checkAndRemoveMsgHandler, hasMessages is true msgKey = " + paramInt + " | sessionID = " + a());
      localHandler.removeMessages(paramInt, this);
      if (!localHandler.hasMessages(paramInt, this)) {}
      for (boolean bool = true;; bool = false)
      {
        QLog.e("Q.stt_SttTask", 1, "checkAndRemoveMsgHandler, removeMessages removeResult = " + bool + " | msgKey = " + paramInt + " | sessionID = " + a());
        return;
      }
    }
    QLog.e("Q.stt_SttTask", 1, "checkAndRemoveMsgHandler, hasMessages is false msgKey = " + paramInt + " | sessionID = " + a());
  }
  
  private Long c()
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.stt_SttTask", 2, "realRetryStt session = " + a() + ", retryNum = " + this.jdField_a_of_type_Int);
    }
    this.jdField_b_of_type_JavaLangLong = Long.valueOf(0L);
    if (this.jdField_a_of_type_Bdub != null) {
      this.jdField_a_of_type_Bdub.a();
    }
    if (this.jdField_a_of_type_Bdua != null) {
      this.jdField_a_of_type_Bdua.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a(false);
    return b();
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_b_of_type_JavaLangLong.longValue() == 0L) {
      return;
    }
    long l = System.currentTimeMillis() - this.jdField_b_of_type_JavaLangLong.longValue();
    this.jdField_b_of_type_JavaLangLong = Long.valueOf(0L);
    if (QLog.isColorLevel()) {
      QLog.d("Q.stt_SttTask", 2, "PttSttReport reportSttFristPackTimeCost cost = " + l + "  | type = " + paramInt);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("timeCost", l + "");
    localHashMap.put("sttType", paramInt + "");
    localHashMap.put("ntimeCost", l + "");
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PttSttFristShowTimeCost", true, 0L, 0L, localHashMap, null);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a();
  }
  
  public MessageForPtt a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt;
  }
  
  public Long a()
  {
    return this.jdField_a_of_type_JavaLangLong;
  }
  
  public Long a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("Q.stt_SttTask", 2, "checkTimeOutRetryStt session = " + a() + ", timeoutType = " + paramInt + ", retryNum = " + this.jdField_a_of_type_Int);
    }
    int i = this.jdField_a_of_type_Int + 1;
    this.jdField_a_of_type_Int = i;
    if (i > 3)
    {
      a().getSttResult().a(3, paramInt);
      return null;
    }
    return c();
  }
  
  public void a(Handler paramHandler)
  {
    if (paramHandler == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.stt_SttTask", 2, "setTimeoutHandler timeoutHandler is null");
      }
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramHandler);
  }
  
  public boolean a(SttResultPush.MsgBody paramMsgBody)
  {
    if (paramMsgBody == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.stt_SttTask", 2, "doReceivePushData resp is null. session = " + a());
      }
      return false;
    }
    if ((a() != 2) && (a() != 1)) {
      return true;
    }
    int j;
    int i;
    if (paramMsgBody.msg_ptt_shard_resp.has())
    {
      if (this.jdField_a_of_type_Bdub == null) {
        this.jdField_a_of_type_Bdub = new bdub(a().getSttResult());
      }
      j = this.jdField_a_of_type_Bdub.a(paramMsgBody);
      i = 1;
      label105:
      if ((j != 0) && (j != -10001) && (j != -10002)) {
        break label347;
      }
      b(1);
      b(3);
      if (j != -10002) {
        break label356;
      }
    }
    label347:
    label356:
    for (int k = 4;; k = 2)
    {
      if (a() == 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt_SttTask", 2, "doReceivePushData stt receive success session = " + a());
        }
        a(k);
        c(i);
      }
      for (;;)
      {
        return true;
        if (paramMsgBody.msg_ptt_resp.has())
        {
          if (this.jdField_a_of_type_Bdua == null) {
            this.jdField_a_of_type_Bdua = new bdua(a().getSttResult());
          }
          j = this.jdField_a_of_type_Bdua.a(paramMsgBody);
          i = 2;
          break label105;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("Q.stt_SttTask", 2, "doReceivePushData msg_ptt_resp and msg_ptt_shard_resp all are null. session = " + a());
        return false;
        if ((a() == 2) && ((j == -10001) || (j == -10002)))
        {
          a(k);
          if (i == 1) {
            c(1);
          }
        }
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a()) {
          a(3, a());
        }
      }
      a(1002);
      return false;
    }
  }
  
  public boolean a(boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().b();
    Long localLong = Long.valueOf(paramBundle.getLong("k_time_out", 60000L));
    int i = paramBundle.getInt("k_result_code", 0);
    String str = paramBundle.getString("k_ptt_trans_txt", null);
    paramBundle.getInt("k_retry", 0);
    if (QLog.isColorLevel()) {
      QLog.d("Q.stt_SttTask", 2, "onReceive, session = " + a() + ", timeout = " + localLong + ", retryNum = " + this.jdField_a_of_type_Int);
    }
    if (paramBoolean)
    {
      if (str != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a(false);
        this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a(str, true);
        a(2);
        c(3);
        return paramBoolean;
      }
      a(1, localLong.longValue());
      return paramBoolean;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a(2, i);
    a(1001);
    return paramBoolean;
  }
  
  public Long b()
  {
    for (;;)
    {
      try
      {
        if ((this.jdField_b_of_type_MqqUtilWeakReference != null) && (!this.jdField_b_of_type_MqqUtilWeakReference.isEnqueued()))
        {
          Object localObject1 = (QQAppInterface)this.jdField_b_of_type_MqqUtilWeakReference.get();
          if (localObject1 == null)
          {
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a(2, 2005);
            a(1001);
            localObject1 = null;
            return localObject1;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt.getSttResult().a();
          long l = b();
          this.jdField_a_of_type_JavaLangLong = Long.valueOf(l);
          bdtv.a((QQAppInterface)localObject1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPtt, Long.valueOf(l), this.jdField_b_of_type_Int, 1);
          if (QLog.isColorLevel()) {
            QLog.d("Q.stt_SttTask", 2, "sendSttRequest, session = " + a() + ", version = " + 1 + ", retryNum = " + this.jdField_a_of_type_Int);
          }
          this.jdField_b_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
          localObject1 = Long.valueOf(l);
          continue;
        }
        Object localObject3 = null;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdtw
 * JD-Core Version:    0.7.0.1
 */