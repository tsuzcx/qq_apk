import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.observer.BusinessObserver;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x3d.SttResultPush.TransPttResp;

public class axaf
  implements Handler.Callback, Manager, BusinessObserver
{
  private static int jdField_a_of_type_Int = -1;
  protected Handler a;
  public axah a;
  public QQAppInterface a;
  public HashMap<Long, MessageForPtt> a;
  private ConcurrentHashMap<Long, axai> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private int b = -1;
  private final int c = 2002;
  private final int d = 2003;
  private final int e = 2004;
  
  public axaf() {}
  
  public axaf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("rich_status" + paramQQAppInterface.c(), 0).getInt("k_c_v", 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface.getApplication().getSharedPreferences("rich_status" + paramQQAppInterface.c(), 0).edit().putInt("k_c_v", paramInt).commit();
  }
  
  private void a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    if (paramMessageForPtt != null)
    {
      paramMessageForPtt.sttAbility = 3;
      paramMessageForPtt.sttText = ajjy.a(2131648829);
      paramMessageForPtt.isReadPtt = true;
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_succ_flag", "0");
      localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
      localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
      localHashMap.put("param_resultCode", paramInt + "");
      awrn.a(BaseApplication.getContext()).a(null, "ptttotextSuc", false, 0L, 0L, localHashMap, null);
    }
    try
    {
      paramMessageForPtt.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForPtt.frienduin, paramMessageForPtt.istroop, paramMessageForPtt.uniseq, paramMessageForPtt.msgData);
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
    if (this.b == -1) {
      this.b = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).getInt("k_ability_101" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 1);
    }
    return this.b == 1;
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
    return ((axaf)paramQQAppInterface.getManager(17)).a();
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
  
  public Long a(MessageForPtt paramMessageForPtt, int paramInt)
  {
    return b(paramMessageForPtt, paramInt);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("rich_status", 0).edit().putInt("k_ability_101" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramInt).apply();
    try
    {
      awrn localawrn = awrn.a(BaseApplication.getContext());
      HashMap localHashMap = new HashMap();
      localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
      localHashMap.put("param_FailCode", String.valueOf(paramInt));
      localHashMap.put("appversion", "8.2.6");
      localawrn.a("", "PttSttEntryChange", false, 0L, 0L, localHashMap, "");
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(axah paramaxah)
  {
    this.jdField_a_of_type_Axah = paramaxah;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    Object localObject = new SttResultPush.MsgBody();
    for (;;)
    {
      SttResultPush.TransPttResp localTransPttResp;
      Long localLong;
      int i;
      int j;
      int k;
      int m;
      try
      {
        ((SttResultPush.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        localTransPttResp = ((SttResultPush.MsgBody)localObject).msg_ptt_resp;
        localLong = Long.valueOf(localTransPttResp.uint64_sessionid.get());
        i = localTransPttResp.uint32_pos.get();
        j = localTransPttResp.uint32_len.get();
        k = localTransPttResp.uint32_total_len.get();
        m = 1 << localTransPttResp.uint32_seq.get();
        int n = localTransPttResp.uint32_error_code.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt", 2, "onSttResultPush with: " + n + ", " + localLong + ", " + i + ", " + j + ", " + k);
        }
        if ((n != 0) || (i + j > k))
        {
          if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localLong);
          }
          this.jdField_a_of_type_AndroidOsHandler.obtainMessage(4, localLong).sendToTarget();
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.stt", 2, "onSttResultPush failed with: ", paramArrayOfByte);
        return;
      }
      if (j >= k) {
        paramArrayOfByte = new String(localTransPttResp.bytes_text.get().toByteArray());
      }
      while (paramArrayOfByte != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, (int)(localLong.longValue() >> 32) & 0xFFFFFFFF, (int)(localLong.longValue() & 0xFFFFFFFF), paramArrayOfByte).sendToTarget();
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
        }
        localObject = (axai)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localLong);
        paramArrayOfByte = (byte[])localObject;
        if (localObject == null)
        {
          paramArrayOfByte = new axai(null);
          paramArrayOfByte.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(k);
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(1, localLong);
          localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2, localLong);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 30000L);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localLong, paramArrayOfByte);
        }
        if (0L == (paramArrayOfByte.jdField_a_of_type_Long & m))
        {
          paramArrayOfByte.jdField_a_of_type_JavaNioByteBuffer.position(i);
          paramArrayOfByte.jdField_a_of_type_JavaNioByteBuffer.put(localTransPttResp.bytes_text.get().toByteArray());
          long l = paramArrayOfByte.b;
          paramArrayOfByte.b = (j + l);
          paramArrayOfByte.jdField_a_of_type_Long |= m;
          if (paramArrayOfByte.b >= k)
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localLong);
            paramArrayOfByte = new String(paramArrayOfByte.jdField_a_of_type_JavaNioByteBuffer.array());
            continue;
          }
        }
        paramArrayOfByte = null;
      }
    }
  }
  
  public boolean a(MessageForPtt paramMessageForPtt)
  {
    return (this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramMessageForPtt.uniseq)));
  }
  
  public Long b(MessageForPtt paramMessageForPtt, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this);
    }
    Long localLong = Long.valueOf(paramMessageForPtt.uniseq);
    if (paramMessageForPtt.istroop == 0)
    {
      if (!baip.a(paramMessageForPtt.urlAtServer)) {
        break label160;
      }
      QLog.e("", 1, new Object[] { "stt err, c2c no fileID ", paramMessageForPtt });
      a(paramMessageForPtt, 2003);
      if (this.jdField_a_of_type_Axah != null) {
        this.jdField_a_of_type_Axah.a(false, paramMessageForPtt);
      }
    }
    for (;;)
    {
      return localLong;
      if (baip.a(paramMessageForPtt.md5))
      {
        QLog.e("", 1, new Object[] { "stt err, troop no md5 ", paramMessageForPtt });
        a(paramMessageForPtt, 2004);
        if (this.jdField_a_of_type_Axah != null)
        {
          this.jdField_a_of_type_Axah.a(false, paramMessageForPtt);
          return localLong;
        }
      }
      else
      {
        label160:
        Object localObject = amir.c();
        boolean bool = baub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_add_ptt_svip_gray_msg", false);
        if ((((amiq)localObject).jdField_a_of_type_Int == 2) && (!bool) && (bajr.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (adlw.d))
        {
          localObject = new aqax(paramMessageForPtt.frienduin, paramMessageForPtt.selfuin, ajjy.a(2131648830), paramMessageForPtt.istroop, -5020, 655392, paramMessageForPtt.time);
          MessageForUniteGrayTip localMessageForUniteGrayTip = new MessageForUniteGrayTip();
          if (paramMessageForPtt.istroop == 1) {
            localMessageForUniteGrayTip.shmsgseq = paramMessageForPtt.shmsgseq;
          }
          localMessageForUniteGrayTip.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (aqax)localObject);
          aqay.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForUniteGrayTip);
          baub.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "have_add_ptt_svip_gray_msg", true);
          QLog.e("Q.stt", 1, "stage2 first translate It is need add gray msg and insert success");
        }
        while (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localLong))
        {
          this.jdField_a_of_type_JavaUtilHashMap.put(localLong, paramMessageForPtt);
          axaj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForPtt, localLong, paramInt);
          return localLong;
          if (QLog.isColorLevel()) {
            QLog.d("Q.stt", 1, "stage2 first translate It is need add gray msg and insert falied:conf.stage == " + ((amiq)localObject).jdField_a_of_type_Int + " && " + bool);
          }
        }
      }
    }
  }
  
  public boolean b(MessageForPtt paramMessageForPtt)
  {
    if ((paramMessageForPtt.autoToText >= 1) && (!a(paramMessageForPtt)) && (paramMessageForPtt.sttAbility != 2)) {}
    do
    {
      return true;
      baeh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "needAuotoChange AutoChangeFlag=" + adlw.d + " AutoChangeSetTime=" + adlw.jdField_a_of_type_Long + " isTranslating=" + a(paramMessageForPtt) + "mPtt.msgTime=" + paramMessageForPtt.msgTime + " mPtt.time=" + paramMessageForPtt.time + " mPtt.sttAbility=" + paramMessageForPtt.sttAbility + " isRedPackPTT=" + agwx.a(paramMessageForPtt));
      }
    } while ((!a(paramMessageForPtt)) && (!agwx.a(paramMessageForPtt)) && (adlw.d) && ((adlw.jdField_a_of_type_Long < paramMessageForPtt.msgTime) || (adlw.jdField_a_of_type_Long < paramMessageForPtt.time)) && (paramMessageForPtt.voiceChangeFlag != 1) && ((paramMessageForPtt.sttAbility == 1) || (paramMessageForPtt.sttAbility == 3)));
    return false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      throw new RuntimeException("unknown msg: " + paramMessage.what);
    case 2: 
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMessage.obj);
      }
    case 1: 
    case 4: 
      if (this.jdField_a_of_type_JavaUtilHashMap == null) {}
      break;
    }
    for (MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_JavaUtilHashMap.remove(paramMessage.obj);; localMessageForPtt = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "handleMessage with: " + paramMessage.what + ", " + paramMessage.obj + ", " + localMessageForPtt);
      }
      if ((localMessageForPtt != null) && (this.jdField_a_of_type_Axah != null))
      {
        a(localMessageForPtt, 2002);
        this.jdField_a_of_type_Axah.a(false, localMessageForPtt);
      }
      return true;
      long l = paramMessage.arg1 << 32 | paramMessage.arg2 & 0xFFFFFFFF;
      if (this.jdField_a_of_type_JavaUtilHashMap != null) {}
      for (localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(l));; localMessageForPtt = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt", 2, "handleMessage with: " + paramMessage.what + ", " + l + ", " + localMessageForPtt);
        }
        if (localMessageForPtt == null) {
          break;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("param_succ_flag", "1");
        localHashMap.put("param_version", Build.VERSION.SDK_INT + "");
        localHashMap.put("param_deviceName", Build.MANUFACTURER + "_" + Build.MODEL);
        localHashMap.put("param_resultCode", "0");
        awrn.a(BaseApplication.getContext()).a(null, "ptttotextSuc", true, 0L, 0L, localHashMap, null);
        localMessageForPtt.sttAbility = 2;
        localMessageForPtt.sttText = ((String)paramMessage.obj);
        localMessageForPtt.isReadPtt = true;
        localMessageForPtt.serial();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForPtt.frienduin, localMessageForPtt.istroop, localMessageForPtt.uniseq, localMessageForPtt.msgData);
        if (QLog.isColorLevel()) {
          QLog.d("PttItemBuilder", 2, "ptt convert to text success,seq is:" + localMessageForPtt.uniseq + ",sttAbility is:" + localMessageForPtt.sttAbility + ",sttText is:" + azzz.a(localMessageForPtt.sttText));
        }
        if (this.jdField_a_of_type_Axah == null) {
          break;
        }
        this.jdField_a_of_type_Axah.a(true, localMessageForPtt);
        return true;
      }
    }
  }
  
  public void onDestroy()
  {
    jdField_a_of_type_Int = -1;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_Axah = null;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = null;
    if (paramBundle == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.stt", 2, "onReceive bundle is null");
      }
    }
    Long localLong2;
    do
    {
      do
      {
        return;
        localLong2 = Long.valueOf(paramBundle.getLong("k_session", 0L));
        Long localLong1 = Long.valueOf(paramBundle.getLong("k_time_out", 30000L));
        paramInt = paramBundle.getInt("k_result_code", 0);
        String str = paramBundle.getString("k_ptt_trans_txt", null);
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt", 2, "onReceive, session = " + localLong2 + ", timeout = " + localLong1);
        }
        paramBundle = localObject;
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          paramBundle = (MessageForPtt)this.jdField_a_of_type_JavaUtilHashMap.get(localLong2);
        }
        if (paramBundle == null) {
          break;
        }
        if (paramBoolean)
        {
          if (str != null)
          {
            this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, (int)(localLong2.longValue() >> 32) & 0xFFFFFFFF, (int)(localLong2.longValue() & 0xFFFFFFFF), str).sendToTarget();
            return;
          }
          paramBundle = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, localLong2);
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(paramBundle, localLong1.longValue());
          return;
        }
        if (this.jdField_a_of_type_JavaUtilHashMap != null) {
          this.jdField_a_of_type_JavaUtilHashMap.remove(localLong2);
        }
        a(paramBundle, paramInt);
      } while (this.jdField_a_of_type_Axah == null);
      this.jdField_a_of_type_Axah.a(false, paramBundle);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("Q.stt", 2, "onReceive with no request on: " + localLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axaf
 * JD-Core Version:    0.7.0.1
 */