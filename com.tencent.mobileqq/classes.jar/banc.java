import QQService.StreamData;
import QQService.StreamInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.text.format.Time;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class banc
  extends bamw
{
  private static List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  public static boolean c;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = -1L;
  alsi jdField_a_of_type_Alsi = new band(this);
  private azwd jdField_a_of_type_Azwd = (azwd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17);
  public QQAppInterface a;
  private String jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  public boolean a;
  int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  boolean d = false;
  public boolean e = false;
  private boolean f;
  int p = -1;
  int q = -1;
  public int r = 0;
  public int s = 0;
  private int t;
  
  static
  {
    jdField_c_of_type_Boolean = true;
  }
  
  public banc(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, int paramInt1, int paramInt2, boolean paramBoolean2, batw parambatw, long paramLong)
  {
    super(paramString1, paramString2, paramBoolean1, parambatw);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    paramInt2 = paramInt1;
    if (paramInt1 == 131075)
    {
      paramInt2 = 1;
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Baoj.s = paramString1;
    this.jdField_a_of_type_Baoj.t = this.jdField_a_of_type_JavaLangString;
    if ((!paramBoolean1) && (paramBoolean2))
    {
      this.jdField_a_of_type_Baoj.p = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Baoj.q = paramString1;
    }
    for (this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;; this.jdField_b_of_type_JavaLangString = paramString1)
    {
      e(false);
      e(paramInt2);
      this.jdField_a_of_type_Baoj.h = 0;
      if (bdcs.c(paramString3)) {
        this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString = paramString3;
      }
      if ((paramString4 != null) && (!bdcs.c(paramString4))) {
        this.jdField_a_of_type_Baoj.g = paramString4;
      }
      if (paramInt2 == 65538)
      {
        this.jdField_a_of_type_Baoj.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString;
        this.jdField_a_of_type_Baoj.jdField_b_of_type_JavaLangString = "gif";
      }
      if (paramInt2 == 2) {
        basj.a(AppSetting.a());
      }
      if ((paramInt2 == 2) && (paramBoolean1))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, 0, paramLong);
        if (paramString1 != null)
        {
          this.jdField_b_of_type_Long = ayvy.a(paramString1.msgUid);
          this.t = ((int)paramString1.shmsgseq);
        }
        if (QLog.isColorLevel()) {
          QLog.e("streamptt", 2, "random:" + this.jdField_b_of_type_Long + " msgseq:" + this.t);
        }
      }
      return;
    }
  }
  
  public static bane a(byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    bane localbane = new bane();
    long l = paramArrayOfLong[0];
    byte[] arrayOfByte;
    if (paramArrayOfByte[0] == 1)
    {
      localbane.jdField_a_of_type_Byte = paramArrayOfByte[1];
      int k = bdlr.a(paramArrayOfByte, 2) + 4;
      int j = paramArrayOfByte[k];
      int i = j;
      if (j < 0) {
        i = j + 256;
      }
      j = k + 1;
      arrayOfByte = new byte[i];
      bdlr.a(arrayOfByte, 0, paramArrayOfByte, j, i);
      i += j;
      l = bdlr.a(paramArrayOfByte, i + 2 + bdlr.a(paramArrayOfByte, i));
      if (arrayOfByte != null) {
        if (l > 10000L) {
          paramArrayOfLong[0] = l;
        }
      }
    }
    for (paramArrayOfByte = new String(arrayOfByte);; paramArrayOfByte = null)
    {
      localbane.jdField_a_of_type_JavaLangString = paramArrayOfByte;
      return localbane;
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    return a(paramString1, paramString2, paramInt, paramArrayOfByte, true);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramString1 = aljq.aX + paramString1 + "/";
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = "";
      paramString2 = null;
      paramArrayOfByte = paramString1;
      paramString1 = (String)localObject;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "getTransferFilePath dir: " + paramArrayOfByte);
      }
      localObject = new File(paramArrayOfByte);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramString1 = new File(paramArrayOfByte + paramString1 + paramString2);
      if (paramInt == 0) {}
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("streamptt", 2, "getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
        }
        return paramString1.getAbsoluteFile().toString();
        paramArrayOfByte = bayb.a(paramString1 + "ptt/" + c() + "/", true);
        String str2 = ".amr";
        localObject = str2;
        paramString1 = paramArrayOfByte;
        if (paramString2 != null) {
          break label841;
        }
        if (QLog.isColorLevel()) {
          QLog.i("streamptt", 2, "pttdown,33333");
        }
        str1 = "stream_" + d();
        localObject = str2;
        paramString2 = paramArrayOfByte;
        paramString1 = str1;
        if (!QLog.isColorLevel()) {
          break label856;
        }
        QLog.i("streamptt", 2, "pttdown,name = " + str1);
        paramString2 = ".amr";
        paramString1 = str1;
        break;
        str1 = paramString1 + "photo/";
        str2 = ".jpg";
        localObject = str2;
        paramString1 = str1;
        if (paramString2 != null) {
          break label841;
        }
        String str3 = d();
        localObject = str2;
        paramString2 = str1;
        paramString1 = str3;
        if (paramArrayOfByte == null) {
          break label856;
        }
        paramString1 = str3 + HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);
        paramString2 = ".jpg";
        paramArrayOfByte = str1;
        break;
        localObject = aljq.bm;
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          paramString2 = d();
          paramString1 = paramString2;
          if (paramArrayOfByte != null) {
            paramString1 = paramString2 + HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);
          }
        }
        paramString2 = "";
        paramArrayOfByte = (byte[])localObject;
        break;
        paramArrayOfByte = paramString1 + "ptt/";
        localObject = ".slk";
        paramString1 = paramArrayOfByte;
        if (paramString2 != null) {
          break label841;
        }
        paramString1 = "buluo_" + d();
        paramString2 = ".slk";
        break;
        paramArrayOfByte = paramString1 + "ptt/";
        localObject = ".slk";
        paramString1 = paramArrayOfByte;
        if (paramString2 != null) {
          break label841;
        }
        paramString1 = "vs_" + d();
        paramString2 = ".slk";
        break;
        paramArrayOfByte = paramString1 + "ptt/";
        localObject = ".slk";
        paramString1 = paramArrayOfByte;
        if (paramString2 != null) {
          break label841;
        }
        paramString1 = "homework_" + d();
        paramString2 = ".slk";
        break;
        paramArrayOfByte = paramString1 + "ptt/";
        paramString1 = ".slk";
        if (paramString2 == null)
        {
          localObject = "ef_" + d();
          paramString2 = paramString1;
          paramString1 = (String)localObject;
          break;
        }
        localObject = "ef_" + paramString2;
        paramString2 = paramString1;
        paramString1 = (String)localObject;
        break;
        if ((paramBoolean) && (!paramString1.exists())) {
          try
          {
            paramString1.createNewFile();
          }
          catch (IOException paramString2) {}
        }
      }
      label841:
      String str1 = "";
      paramString2 = (String)localObject;
      paramArrayOfByte = paramString1;
      paramString1 = str1;
      continue;
      label856:
      paramArrayOfByte = paramString2;
      paramString2 = (String)localObject;
    }
  }
  
  private void a(String paramString, int paramInt1, long paramLong, int paramInt2)
  {
    QQMessageFacade.Message localMessage = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1, paramLong);
    if ((localMessage != null) && (localMessage.uniseq == paramLong)) {
      localMessage.extraflag = 32768;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt1, paramLong, 32768, paramInt2);
  }
  
  private void a(boolean paramBoolean, ayvo paramayvo)
  {
    int i = paramayvo.jdField_a_of_type_Short;
    short s1 = (short)paramayvo.jdField_a_of_type_Int;
    Object localObject = paramayvo.jdField_a_of_type_JavaLangString;
    if (paramBoolean) {
      if (paramayvo.jdField_b_of_type_Int != 0)
      {
        this.q = paramayvo.jdField_b_of_type_Int;
        a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long, this.q);
        a(2, 9312, "friend_block");
        d();
        azqa.b((String)localObject);
        azqa.a((String)localObject);
        if (paramayvo.jdField_b_of_type_Int == 58) {
          g();
        }
        if (QLog.isColorLevel()) {
          QLog.e("streamptt.send", 2, "respCode = " + this.q);
        }
      }
    }
    do
    {
      int k;
      long l;
      int j;
      do
      {
        do
        {
          short s2;
          do
          {
            do
            {
              return;
              if (i == -1)
              {
                this.d = true;
                c(2);
                this.jdField_a_of_type_Baoj.jdField_a_of_type_Baol.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(azqa.b((String)localObject)));
                this.jdField_a_of_type_Baoj.jdField_a_of_type_Long = new File(this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString).length();
                azqa.a((String)localObject);
                this.jdField_a_of_type_Baoj.g = paramayvo.jdField_a_of_type_QQServiceStreamInfo.fileKey;
                if (paramayvo.jdField_a_of_type_QQServiceStreamInfo.pttTransFlag == 1) {}
                for (s2 = 1;; s2 = 0)
                {
                  this.p = s2;
                  this.jdField_a_of_type_Long = paramayvo.jdField_a_of_type_QQServiceStreamInfo.msgTime;
                  e();
                  return;
                }
              }
            } while (this.d);
            s2 = azqa.a((String)localObject);
            if (s2 > 10)
            {
              if (QLog.isColorLevel()) {
                QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: preLayer > 10");
              }
              a(2, 9310, "retry overflow");
              d();
              azqa.b((String)localObject);
              azqa.a((String)localObject);
              return;
            }
            k = azqa.c((String)localObject);
            int m = azqa.b((String)localObject);
            this.jdField_b_of_type_Int = i;
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.send", 2, "server reset.ResetSeq: " + i + " packnum: " + m + ",slices:" + k + " uniseq:" + this.jdField_a_of_type_Baoj.jdField_b_of_type_Long + ",flowLayer:" + s1 + ",prelayer:" + s2);
            }
          } while (s2 >= s1);
          azqa.a((String)localObject, s1);
          paramayvo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long);
          l = 0L;
          localObject = new Bundle();
          if (paramayvo != null)
          {
            l = paramayvo.vipSubBubbleId;
            ((Bundle)localObject).putInt("DiyTextId", paramayvo.vipBubbleDiyTextId);
          }
          a(true, i, (short)k, l, (Bundle)localObject);
          this.jdField_a_of_type_Baoj.a(2, 2);
          return;
        } while (this.d);
        j = azqa.c((String)localObject);
        k = azqa.a((String)localObject);
        if (paramayvo.jdField_a_of_type_Int >= k) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: info.layer < flowlayer");
      return;
      if (this.jdField_c_of_type_Int == i)
      {
        if (this.jdField_a_of_type_Int < 8)
        {
          this.jdField_a_of_type_Int += 1;
          this.jdField_c_of_type_Int = 0;
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.send", 2, "client check timeout.retry:severAckSlice:" + this.jdField_b_of_type_Int + " packnum: " + j + " maxSendSeq:" + this.jdField_c_of_type_Int + " uniseq:" + this.jdField_a_of_type_Baoj.jdField_b_of_type_Long + ",retryCount:" + this.jdField_a_of_type_Int + ",flowLayer:" + k);
          }
          paramayvo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long);
          l = 0L;
          localObject = new Bundle();
          if (paramayvo != null)
          {
            l = paramayvo.vipSubBubbleId;
            ((Bundle)localObject).putInt("DiyTextId", paramayvo.vipBubbleDiyTextId);
          }
          a(true, (short)this.jdField_b_of_type_Int, (short)j, l, (Bundle)localObject);
          return;
        }
        a(2, 9310, "timeout");
        d();
        azqa.a((String)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: sendSeqMax != shResetSeq");
  }
  
  public static String c()
  {
    Time localTime = new Time();
    localTime.setToNow();
    if (localTime.month + 1 > 9) {}
    for (String str = "" + (localTime.month + 1);; str = "0" + (localTime.month + 1)) {
      return "" + localTime.year + str + "/" + localTime.monthDay;
    }
  }
  
  private static String d()
  {
    try
    {
      Thread.sleep(1L);
      long l = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date(l));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void g()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str2 = alpo.a(2131701593);
    long l = ayvc.a();
    MessageRecord localMessageRecord = ayvw.a(-2012);
    localMessageRecord.init(str1, this.jdField_c_of_type_JavaLangString, str1, str2, l, 0, 0, l);
    localMessageRecord.msgtype = -2012;
    localMessageRecord.isread = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, str1);
  }
  
  public MessageRecord a(long paramLong1, StreamInfo paramStreamInfo, long paramLong2, Bundle paramBundle)
  {
    Object localObject1 = new byte[3];
    bdlr.a(this.jdField_a_of_type_Baoj.g.length(), (byte[])localObject1, 0, 3, "utf-8");
    localObject1 = (MessageForPtt)ayvw.a(-2002);
    ((MessageForPtt)localObject1).voiceType = ((int)paramStreamInfo.pttFormat);
    ((MessageForPtt)localObject1).voiceLength = ((int)paramStreamInfo.pttTime);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt", 2, "voiceLength createMessageDataBaseContent " + ((MessageForPtt)localObject1).voiceLength);
    }
    ((MessageForPtt)localObject1).selfuin = this.jdField_a_of_type_JavaLangString;
    ((MessageForPtt)localObject1).frienduin = this.jdField_c_of_type_JavaLangString;
    ((MessageForPtt)localObject1).senderuin = this.jdField_a_of_type_Baoj.p;
    ((MessageForPtt)localObject1).isread = false;
    ((MessageForPtt)localObject1).time = paramStreamInfo.msgTime;
    ((MessageForPtt)localObject1).setPttStreamFlag(10001);
    ((MessageForPtt)localObject1).msgtype = -2002;
    ((MessageForPtt)localObject1).istroop = 0;
    ((MessageForPtt)localObject1).urlAtServer = this.jdField_a_of_type_Baoj.g;
    ((MessageForPtt)localObject1).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject1).voiceType, this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString);
    Object localObject2 = new File(this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString);
    int i;
    if (((File)localObject2).exists())
    {
      ((MessageForPtt)localObject1).fileSize = ((File)localObject2).length();
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800610E", "0X800610E", 1, 0, "", "", "", "8.3.3");
      ((MessageForPtt)localObject1).itemType = 2;
      ((MessageForPtt)localObject1).isread = false;
      ((MessageForPtt)localObject1).shmsgseq = ((short)paramStreamInfo.msgSeq);
      ((MessageForPtt)localObject1).msgUid = ayvy.a((int)paramStreamInfo.random);
      if ((paramStreamInfo.pttTransFlag != 1) && (!azwd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
        break label746;
      }
      i = 1;
      label313:
      ((MessageForPtt)localObject1).sttAbility = i;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (!((MessageForPtt)localObject1).isSend()) {
        break label752;
      }
    }
    label746:
    label752:
    for (paramStreamInfo = this.jdField_a_of_type_JavaLangString;; paramStreamInfo = this.jdField_c_of_type_JavaLangString)
    {
      ((MessageForPtt)localObject1).longPttVipFlag = ayvy.a((QQAppInterface)localObject2, paramStreamInfo);
      long l1 = System.currentTimeMillis() / 1000L;
      long l2 = ((MessageForPtt)localObject1).time;
      ((MessageForPtt)localObject1).msgRecTime = l1;
      ((MessageForPtt)localObject1).msgTime = l2;
      ((MessageForPtt)localObject1).vipSubBubbleId = ((int)paramLong2);
      ((MessageForPtt)localObject1).vipBubbleDiyTextId = paramBundle.getInt("DiyTextId", 0);
      i = paramBundle.getInt("DiyPendantId", 0);
      if (i > 0) {
        ((MessageForPtt)localObject1).saveExtInfoToExtStr("vip_pendant_diy_id", String.valueOf(i));
      }
      ((MessageForPtt)localObject1).serial();
      paramLong2 = paramLong1;
      if (paramLong1 == 4294967295L)
      {
        paramLong1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPtt)localObject1).frienduin);
        paramLong2 = paramLong1;
        if (QLog.isColorLevel())
        {
          QLog.e("streamptt.recv", 2, "Stream ptt:createMessageDataBaseContent: invalid bubbleID 0xffffffff. get one from cache:" + paramLong1);
          paramLong2 = paramLong1;
        }
      }
      ((MessageForPtt)localObject1).vipBubbleID = paramLong2;
      if (QLog.isColorLevel()) {
        QLog.e("streamptt.recv", 2, "Stream ptt:createMessageDataBaseContent:time" + ((MessageForPtt)localObject1).time + " urlAtServer:" + ((MessageForPtt)localObject1).urlAtServer + " bubbleId:" + paramLong2 + " msgseq:" + ((MessageForPtt)localObject1).shmsgseq + " msgUid:" + ((MessageForPtt)localObject1).msgUid);
      }
      paramStreamInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageForPtt)localObject1).frienduin, ((MessageForPtt)localObject1).istroop);
      if ((paramStreamInfo == null) || (paramStreamInfo.size() <= 0)) {
        break label760;
      }
      paramStreamInfo = paramStreamInfo.iterator();
      do
      {
        if (!paramStreamInfo.hasNext()) {
          break;
        }
      } while (!abot.a((MessageRecord)paramStreamInfo.next(), (MessageRecord)localObject1, true));
      if (QLog.isColorLevel()) {
        QLog.w("streamptt", 2, "same Ptt :" + ((MessageForPtt)localObject1).getBaseInfoString());
      }
      return null;
      ((MessageForPtt)localObject1).fileSize = 1000L;
      azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800610E", "0X800610E", 2, 0, "", "", "", "8.3.3");
      break;
      i = 0;
      break label313;
    }
    label760:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Baoj.a(((MessageForPtt)localObject1).uniseq);
    return localObject1;
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, Bundle paramBundle)
  {
    this.jdField_a_of_type_Baoj.jdField_a_of_type_Baol.d = true;
    b(2);
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "startReceiveOneStreamPack:" + paramStreamInfo.pttFormat + ", " + paramStreamInfo.pttTime);
    }
    this.jdField_a_of_type_Baoj.a(4, paramStreamData.vData.length);
    switch (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          if ((!Environment.getExternalStorageState().equals("mounted")) || (new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath()).getAvailableBlocks() < 1))
          {
            if (!Environment.getExternalStorageState().equals("mounted")) {
              b(9039, "not mounted");
            }
            for (;;)
            {
              paramStreamInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
              paramStreamInfo.putBoolean("sdcard_related_download_failed", true);
              paramStreamInfo.commit();
              d();
              return;
              b(9040, "no enough storage");
            }
          }
          i = azqa.a(this.jdField_a_of_type_Baoj.g);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.recv", 2, "curFlowLayer: " + i + " received shFlowLayer:" + paramStreamInfo.shFlowLayer + ",seq" + paramStreamData.shPackSeq + ",packNum:" + paramStreamInfo.shPackNum + " lkey:" + paramLong1);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false, bdee.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()), 2, 0, paramStreamData.vData.length);
          azqa.c(this.jdField_a_of_type_Baoj.g, paramLong1);
          if (i != paramStreamInfo.shFlowLayer)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Baoj.g, azqa.c(this.jdField_a_of_type_Baoj.g), paramLong1);
            return;
          }
          if (azqa.a(this.jdField_a_of_type_Baoj.g, paramStreamData.shPackSeq))
          {
            this.jdField_a_of_type_Baoj.a(2, 2);
            short s1 = (short)(azqa.a(this.jdField_a_of_type_Baoj.g) + 1);
            azqa.a(this.jdField_a_of_type_Baoj.g, s1);
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack JudgeReceiveError flowLayer: " + s1);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Baoj.g, azqa.c(this.jdField_a_of_type_Baoj.g), paramLong1);
            return;
          }
          if (paramStreamInfo.oprType == 1) {}
          for (i = 1; i != 0; i = 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "cancelled:" + this.jdField_a_of_type_Baoj.g);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baoj.g, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long);
            azqa.a(this.jdField_a_of_type_Baoj.g, true);
            azqa.a(this.jdField_a_of_type_Baoj.g);
            return;
          }
          azqa.a(this.jdField_a_of_type_Baoj.g, paramStreamInfo.shFlowLayer);
          azqa.a(this.jdField_a_of_type_Baoj.g, paramStreamData.vData, paramStreamData.vData.length, paramStreamData.shPackSeq);
        } while (paramStreamInfo.shPackNum <= 0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baoj.g, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long);
        azqa.a(this.jdField_a_of_type_Baoj.g, false);
        azqa.a(this.jdField_a_of_type_Baoj.g);
        paramStreamData = this.jdField_a_of_type_JavaLangString + "_" + this.jdField_b_of_type_JavaLangString + "_" + paramStreamInfo.iMsgId;
        if (!jdField_b_of_type_JavaUtilList.contains(paramStreamData)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("streamptt.recv", 2, "find stream stream duplicate,discard it ,key:" + paramStreamData);
      return;
      jdField_b_of_type_JavaUtilList.add(paramStreamData);
      long l = paramStreamInfo.iSendTime;
      paramStreamData = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(l * 1000L));
      paramStreamData = this.jdField_b_of_type_JavaLangString + "_" + paramStreamData;
      if (QLog.isColorLevel()) {
        QLog.d("streamptt.recv", 2, "stream duplicateKey:" + paramStreamData);
      }
      if (!azqa.e(paramStreamData)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.recv", 2, "find stream offline duplicate,stop stream recv");
    return;
    azqa.c(paramStreamData);
    c(2);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack received success path: " + this.jdField_a_of_type_Baoj.g);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Baoj.g, (short)-1, paramLong1);
    this.jdField_a_of_type_Baoj.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Baoj.g = paramStreamInfo.fileKey;
    if (paramStreamInfo.pttTransFlag == 1) {}
    for (int i = 1;; i = 0)
    {
      this.p = i;
      if (a(paramLong2, paramStreamInfo, paramLong3, paramBundle) != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
      }
      e();
      bark.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, true, 3);
      bark.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, true, 2);
      return;
    }
  }
  
  public void a(short paramShort, boolean paramBoolean, int paramInt1, int paramInt2, long paramLong, Bundle paramBundle)
  {
    this.r = paramInt2;
    this.s = paramInt1;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "startSendOneStreamPack:" + paramInt2 + ", " + paramInt1 + ", " + paramShort + ", subBubbleId=" + paramLong);
    }
    this.jdField_a_of_type_Baoj.jdField_a_of_type_Baol.d = true;
    String str = "";
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ("0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
    do
    {
      return;
      this.jdField_a_of_type_Baoj.d = 1001;
      b(2);
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alsi);
      }
      b(2);
      if (paramShort > this.jdField_c_of_type_Int) {
        this.jdField_c_of_type_Int = paramShort;
      }
      switch (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int)
      {
      default: 
        return;
      }
    } while ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new BuddyTransfileProcessor.2(this, str, paramShort, paramLong, paramBundle, paramBoolean));
  }
  
  protected void a(boolean paramBoolean)
  {
    if (basb.b(this.jdField_j_of_type_Int)) {
      break label10;
    }
    label10:
    label593:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Baoj.jdField_b_of_type_Int == 2) && (!this.f) && (!basb.b(this.jdField_j_of_type_Int)))
      {
        long l = (System.nanoTime() - this.k) / 1000000L;
        HashMap localHashMap = new HashMap();
        if (!this.jdField_a_of_type_Baoj.jdField_a_of_type_Baol.d) {
          localHashMap.put("param_step", this.jdField_a_of_type_Baoj.jdField_b_of_type_Baok.a(1) + ";" + this.jdField_a_of_type_Baoj.jdField_a_of_type_Baol.a(2) + ";" + this.jdField_a_of_type_Baoj.jdField_c_of_type_Baok.a(3));
        }
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_Baoj.jdField_a_of_type_Int == 0)
          {
            localHashMap.put("param_toUin", this.jdField_b_of_type_JavaLangString);
            localHashMap.putAll(this.jdField_a_of_type_Baoj.jdField_a_of_type_Baol.jdField_a_of_type_JavaUtilHashMap);
            azmz.a(BaseApplication.getContext()).a(null, "actC2CStreamPttUpload", true, l, this.jdField_a_of_type_Baoj.jdField_a_of_type_Long, localHashMap, "");
            if (TextUtils.isEmpty(this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString)) {
              break;
            }
            bark.a(this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString, true, paramBoolean, 0, this.jdField_a_of_type_Baoj.jdField_a_of_type_Long);
            return;
          }
          azmz.a(BaseApplication.getContext()).a(null, "actC2CStreamPttDownload", true, l, this.jdField_a_of_type_Baoj.jdField_a_of_type_Long, localHashMap, "");
          return;
        }
        if (this.jdField_a_of_type_Baoj.jdField_a_of_type_Int == 0) {
          if (!bamw.a(this.jdField_j_of_type_Int, localHashMap))
          {
            localHashMap.put("param_FailCode", Integer.toString(this.jdField_j_of_type_Int));
            if ((this.jdField_j_of_type_Int == -9527) || (this.jdField_j_of_type_Int == 9311) || (this.jdField_j_of_type_Int == 9044) || (this.jdField_j_of_type_Int == 9350) || (this.jdField_j_of_type_Int == 9351))
            {
              localHashMap.put(bamw.k, this.jdField_j_of_type_JavaLangString);
              localHashMap.put("param_toUin", this.jdField_b_of_type_JavaLangString);
              azmz.a(BaseApplication.getContext()).a(null, "actC2CStreamPttUpload", false, l, this.jdField_a_of_type_Baoj.jdField_a_of_type_Long, localHashMap, "");
              if (!TextUtils.isEmpty(this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString)) {
                bark.a(this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString, true, paramBoolean, 0, this.jdField_a_of_type_Baoj.jdField_a_of_type_Long);
              }
            }
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int != 2) {
            break label593;
          }
          basj.b(true, String.valueOf(this.jdField_j_of_type_Int) + "_" + this.jdField_j_of_type_JavaLangString);
          return;
          localHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
          break;
          this.jdField_j_of_type_Int = -9527;
          localHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
          break;
          localHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
          localHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
          azmz.a(BaseApplication.getContext()).a(null, "actC2CStreamPttDownload", false, l, this.jdField_a_of_type_Baoj.jdField_a_of_type_Long, localHashMap, "");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, short paramShort1, short paramShort2, long paramLong, Bundle paramBundle)
  {
    short s1 = paramShort1;
    while (s1 <= paramShort2)
    {
      a((short)s1, true, this.s, this.r, paramLong, paramBundle);
      s1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("streamptt", 2, "startSendRangeStreamPack, from slice " + paramShort1 + " to slice " + paramShort2 + ", subBubbleId=" + paramLong);
    }
  }
  
  public void aS_() {}
  
  void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
    }
    long l = (System.nanoTime() - this.k) / 1000000L;
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
      b(9366, "account switch");
    }
    if (this.jdField_a_of_type_Baoj.jdField_a_of_type_Int == 0) {}
    for (String str = "streamptt.send";; str = "streamptt.recv")
    {
      QLog.d(str, 2, "onError elapsed:" + l + " errCode:" + this.jdField_j_of_type_Int + " errDesc:" + this.jdField_j_of_type_JavaLangString + " reason:" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason") + " uniseq:" + this.jdField_a_of_type_Baoj.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsi);
      a(false);
      if (this.jdField_a_of_type_Baoj.jdField_a_of_type_Int != 0) {
        break;
      }
      d(1005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baoj.g, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long);
      return;
    }
    d(2005);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baoj.g, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long);
  }
  
  public void d(boolean paramBoolean)
  {
    label337:
    for (paramBoolean = true;; paramBoolean = false)
    {
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_Baoj.jdField_b_of_type_Int != 2) {
            break;
          }
          MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long);
          localMessageForPtt.url = this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString;
          localMessageForPtt.fileSize = this.jdField_a_of_type_Baoj.e;
          localMessageForPtt.itemType = this.jdField_a_of_type_Baoj.jdField_b_of_type_Int;
          if (this.jdField_a_of_type_Baoj.jdField_f_of_type_Int != 1) {
            break label337;
          }
          localMessageForPtt.isread = paramBoolean;
          localMessageForPtt.urlAtServer = this.jdField_a_of_type_Baoj.g;
          if (azwd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            localMessageForPtt.sttAbility = 1;
            QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (localMessageForPtt.isSend())
            {
              Object localObject = this.jdField_a_of_type_JavaLangString;
              localMessageForPtt.longPttVipFlag = ayvy.a(localQQAppInterface, (String)localObject);
              localMessageForPtt.serial();
              if (QLog.isColorLevel()) {
                QLog.e("streamptt.send", 2, "Stream ptt:updataMessageDataBaseContent:time" + localMessageForPtt.time + " urlAtServer:" + localMessageForPtt.urlAtServer);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long, localMessageForPtt.msgData);
              localMessageForPtt.time = this.jdField_a_of_type_Long;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long, this.jdField_a_of_type_Long);
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0);
              if ((localObject == null) || (this.jdField_a_of_type_Baoj.g == null) || (!this.jdField_a_of_type_Baoj.g.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
                break;
              }
              ((QQMessageFacade.Message)localObject).pttUrl = localMessageForPtt.url;
            }
          }
          else
          {
            localMessageForPtt.sttAbility = this.p;
            continue;
          }
          String str = this.jdField_c_of_type_JavaLangString;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
      }
      return;
    }
  }
  
  void e()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
    }
    long l = (System.nanoTime() - this.k) / 1000000L;
    Object localObject;
    if (this.jdField_a_of_type_Baoj.jdField_a_of_type_Int == 0)
    {
      localObject = "streamptt.send";
      QLog.d((String)localObject, 2, "onSuccess elapsed:" + l + " uniseq:" + this.jdField_a_of_type_Baoj.jdField_b_of_type_Long);
      a(true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alsi);
      if (this.jdField_a_of_type_Baoj.jdField_a_of_type_Int == 0) {
        d(true);
      }
      if (this.jdField_a_of_type_Baoj.jdField_a_of_type_Int != 0) {
        break label172;
      }
      d(1003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Baoj.p, this.jdField_a_of_type_Baoj.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long);
    }
    label172:
    do
    {
      return;
      localObject = "streamptt.recv";
      break;
      d(2003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Baoj.g, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long);
      localObject = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Baoj.jdField_b_of_type_Long);
    } while ((localObject == null) || (this.jdField_a_of_type_Azwd == null) || (!this.jdField_a_of_type_Azwd.b((MessageForPtt)localObject)));
    this.jdField_a_of_type_Azwd.b((MessageForPtt)localObject, 2);
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     banc
 * JD-Core Version:    0.7.0.1
 */