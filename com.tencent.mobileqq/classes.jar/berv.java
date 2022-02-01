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
import org.jetbrains.annotations.NotNull;

public class berv
  extends berp
{
  private static List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  public static boolean c;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = -1L;
  aocj jdField_a_of_type_Aocj = new berw(this);
  private bduh jdField_a_of_type_Bduh = (bduh)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17);
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
  int jdField_d_of_type_Int = -1;
  boolean jdField_d_of_type_Boolean = false;
  public boolean e = false;
  private boolean f;
  int q = -1;
  public int r = 0;
  public int s = 0;
  private int t;
  
  static
  {
    jdField_c_of_type_Boolean = true;
  }
  
  public berv(String paramString1, String paramString2, boolean paramBoolean1, String paramString3, String paramString4, int paramInt1, int paramInt2, boolean paramBoolean2, beyb parambeyb, long paramLong)
  {
    super(paramString1, paramString2, paramBoolean1, parambeyb);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    paramInt2 = paramInt1;
    if (paramInt1 == 131075)
    {
      paramInt2 = 1;
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_Bete.s = paramString1;
    this.jdField_a_of_type_Bete.t = this.jdField_a_of_type_JavaLangString;
    if ((!paramBoolean1) && (paramBoolean2))
    {
      this.jdField_a_of_type_Bete.p = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bete.q = paramString1;
    }
    for (this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;; this.jdField_b_of_type_JavaLangString = paramString1)
    {
      d(false);
      e(paramInt2);
      this.jdField_a_of_type_Bete.h = 0;
      if (bhmi.c(paramString3)) {
        this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString = paramString3;
      }
      if ((paramString4 != null) && (!bhmi.c(paramString4))) {
        this.jdField_a_of_type_Bete.g = paramString4;
      }
      if (paramInt2 == 65538)
      {
        this.jdField_a_of_type_Bete.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString;
        this.jdField_a_of_type_Bete.jdField_b_of_type_JavaLangString = "gif";
      }
      if (paramInt2 == 2) {
        bews.a(AppSetting.a());
      }
      if ((paramInt2 == 2) && (paramBoolean1))
      {
        paramString1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_JavaLangString, 0, paramLong);
        if (paramString1 != null)
        {
          this.jdField_b_of_type_Long = bcsa.a(paramString1.msgUid);
          this.t = ((int)paramString1.shmsgseq);
        }
        if (QLog.isColorLevel()) {
          QLog.e("streamptt", 2, "random:" + this.jdField_b_of_type_Long + " msgseq:" + this.t);
        }
      }
      return;
    }
  }
  
  public static berx a(byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    berx localberx = new berx();
    long l = paramArrayOfLong[0];
    byte[] arrayOfByte;
    if (paramArrayOfByte[0] == 1)
    {
      localberx.jdField_a_of_type_Byte = paramArrayOfByte[1];
      int k = bhvd.a(paramArrayOfByte, 2) + 4;
      int j = paramArrayOfByte[k];
      int i = j;
      if (j < 0) {
        i = j + 256;
      }
      j = k + 1;
      arrayOfByte = new byte[i];
      bhvd.a(arrayOfByte, 0, paramArrayOfByte, j, i);
      i += j;
      l = bhvd.a(paramArrayOfByte, i + 2 + bhvd.a(paramArrayOfByte, i));
      if (arrayOfByte != null) {
        if (l > 10000L) {
          paramArrayOfLong[0] = l;
        }
      }
    }
    for (paramArrayOfByte = new String(arrayOfByte);; paramArrayOfByte = null)
    {
      localberx.jdField_a_of_type_JavaLangString = paramArrayOfByte;
      return localberx;
    }
  }
  
  @NotNull
  private static bery a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    paramString1 = new bery(antf.ba + paramString1 + "/", null, "");
    switch (paramInt)
    {
    default: 
    case 2: 
    case 1: 
    case 65537: 
    case 0: 
    case 25: 
    case 53: 
    case 65: 
      do
      {
        do
        {
          do
          {
            return paramString1;
            a(paramString2, paramString1);
            return paramString1;
            b(paramString2, paramArrayOfByte, paramString1);
            return paramString1;
            a(paramString2, paramArrayOfByte, paramString1);
            return paramString1;
            paramString1.jdField_a_of_type_JavaLangString += "ptt/";
            paramString1.jdField_b_of_type_JavaLangString = ".slk";
          } while (paramString2 != null);
          paramString1.jdField_c_of_type_JavaLangString = ("buluo_" + d());
          return paramString1;
          paramString1.jdField_a_of_type_JavaLangString += "ptt/";
          paramString1.jdField_b_of_type_JavaLangString = ".slk";
        } while (paramString2 != null);
        paramString1.jdField_c_of_type_JavaLangString = ("vs_" + d());
        return paramString1;
        paramString1.jdField_a_of_type_JavaLangString += "ptt/";
        paramString1.jdField_b_of_type_JavaLangString = ".slk";
      } while (paramString2 != null);
      paramString1.jdField_c_of_type_JavaLangString = ("homework_" + d());
      return paramString1;
    }
    paramString1.jdField_a_of_type_JavaLangString += "ptt/";
    paramString1.jdField_b_of_type_JavaLangString = ".slk";
    if (paramString2 == null)
    {
      paramString1.jdField_c_of_type_JavaLangString = ("ef_" + d());
      return paramString1;
    }
    paramString1.jdField_c_of_type_JavaLangString = ("ef_" + paramString2);
    return paramString1;
  }
  
  public static String a()
  {
    Time localTime = new Time();
    localTime.setToNow();
    if (localTime.month + 1 > 9) {}
    for (String str = "" + (localTime.month + 1);; str = "0" + (localTime.month + 1)) {
      return "" + localTime.year + str + "/" + localTime.monthDay;
    }
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    return a(paramString1, paramString2, paramInt, paramArrayOfByte, true);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramString1 = a(paramString1, paramString2, paramInt, paramArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt", 2, "getTransferFilePath dir: " + paramString1.jdField_a_of_type_JavaLangString);
    }
    paramString2 = new File(paramString1.jdField_a_of_type_JavaLangString);
    if (!paramString2.exists()) {
      paramString2.mkdirs();
    }
    paramString1 = new File(paramString1.jdField_a_of_type_JavaLangString + paramString1.jdField_c_of_type_JavaLangString + paramString1.jdField_b_of_type_JavaLangString);
    if ((paramInt != 0) && (paramBoolean) && (!paramString1.exists())) {}
    try
    {
      paramString1.createNewFile();
      label127:
      if (QLog.isColorLevel()) {
        QLog.d("streamptt", 2, "getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
      }
      return paramString1.getAbsoluteFile().toString();
    }
    catch (IOException paramString2)
    {
      break label127;
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
  
  private static void a(String paramString, bery parambery)
  {
    parambery.jdField_a_of_type_JavaLangString = (parambery.jdField_a_of_type_JavaLangString + "ptt/" + a() + "/");
    parambery.jdField_a_of_type_JavaLangString = bfcj.a(parambery.jdField_a_of_type_JavaLangString, true);
    parambery.jdField_b_of_type_JavaLangString = ".amr";
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("streamptt", 2, "pttdown,33333");
      }
      parambery.jdField_c_of_type_JavaLangString = ("stream_" + d());
      if (QLog.isColorLevel()) {
        QLog.i("streamptt", 2, "pttdown,name = " + parambery.jdField_c_of_type_JavaLangString);
      }
    }
  }
  
  private static void a(String paramString, byte[] paramArrayOfByte, bery parambery)
  {
    parambery.jdField_a_of_type_JavaLangString = antf.bp;
    if (paramString == null)
    {
      parambery.jdField_c_of_type_JavaLangString = d();
      if (paramArrayOfByte == null) {}
    }
    for (parambery.jdField_c_of_type_JavaLangString += HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);; parambery.jdField_c_of_type_JavaLangString = paramString)
    {
      parambery.jdField_b_of_type_JavaLangString = "";
      return;
    }
  }
  
  private void a(boolean paramBoolean, bcrr parambcrr)
  {
    int i = parambcrr.jdField_a_of_type_Short;
    short s1 = (short)parambcrr.jdField_a_of_type_Int;
    Object localObject = parambcrr.jdField_a_of_type_JavaLangString;
    if (paramBoolean) {
      if (parambcrr.jdField_b_of_type_Int != 0)
      {
        this.q = parambcrr.jdField_b_of_type_Int;
        a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Bete.jdField_b_of_type_Long, this.q);
        a(2, 9312, "friend_block");
        d();
        bdoc.b((String)localObject);
        bdoc.a((String)localObject);
        if (parambcrr.jdField_b_of_type_Int == 58) {
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
                this.jdField_d_of_type_Boolean = true;
                c(2);
                this.jdField_a_of_type_Bete.jdField_a_of_type_Betg.jdField_a_of_type_JavaUtilHashMap.put("param_sliceNum", String.valueOf(bdoc.b((String)localObject)));
                this.jdField_a_of_type_Bete.jdField_a_of_type_Long = new File(this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString).length();
                bdoc.a((String)localObject);
                this.jdField_a_of_type_Bete.g = parambcrr.jdField_a_of_type_QQServiceStreamInfo.fileKey;
                if (parambcrr.jdField_a_of_type_QQServiceStreamInfo.pttTransFlag == 1) {}
                for (s2 = 1;; s2 = 0)
                {
                  this.jdField_d_of_type_Int = s2;
                  this.jdField_a_of_type_Long = parambcrr.jdField_a_of_type_QQServiceStreamInfo.msgTime;
                  e();
                  return;
                }
              }
            } while (this.jdField_d_of_type_Boolean);
            s2 = bdoc.a((String)localObject);
            if (s2 > 10)
            {
              if (QLog.isColorLevel()) {
                QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: preLayer > 10");
              }
              a(2, 9310, "retry overflow");
              d();
              bdoc.b((String)localObject);
              bdoc.a((String)localObject);
              return;
            }
            k = bdoc.c((String)localObject);
            int m = bdoc.b((String)localObject);
            this.jdField_b_of_type_Int = i;
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.send", 2, "server reset.ResetSeq: " + i + " packnum: " + m + ",slices:" + k + " uniseq:" + this.jdField_a_of_type_Bete.jdField_b_of_type_Long + ",flowLayer:" + s1 + ",prelayer:" + s2);
            }
          } while (s2 >= s1);
          bdoc.a((String)localObject, s1);
          parambcrr = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Bete.jdField_b_of_type_Long);
          l = 0L;
          localObject = new Bundle();
          if (parambcrr != null)
          {
            l = parambcrr.vipSubBubbleId;
            ((Bundle)localObject).putInt("DiyTextId", parambcrr.vipBubbleDiyTextId);
          }
          a(true, i, (short)k, l, (Bundle)localObject);
          this.jdField_a_of_type_Bete.a(2, 2);
          return;
        } while (this.jdField_d_of_type_Boolean);
        j = bdoc.c((String)localObject);
        k = bdoc.a((String)localObject);
        if (parambcrr.jdField_a_of_type_Int >= k) {
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
            QLog.d("streamptt.send", 2, "client check timeout.retry:severAckSlice:" + this.jdField_b_of_type_Int + " packnum: " + j + " maxSendSeq:" + this.jdField_c_of_type_Int + " uniseq:" + this.jdField_a_of_type_Bete.jdField_b_of_type_Long + ",retryCount:" + this.jdField_a_of_type_Int + ",flowLayer:" + k);
          }
          parambcrr = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Bete.jdField_b_of_type_Long);
          l = 0L;
          localObject = new Bundle();
          if (parambcrr != null)
          {
            l = parambcrr.vipSubBubbleId;
            ((Bundle)localObject).putInt("DiyTextId", parambcrr.vipBubbleDiyTextId);
          }
          a(true, (short)this.jdField_b_of_type_Int, (short)j, l, (Bundle)localObject);
          return;
        }
        a(2, 9310, "timeout");
        d();
        bdoc.a((String)localObject);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.send", 2, "handleUploadStreamPttFinished: sendSeqMax != shResetSeq");
  }
  
  private static void b(String paramString, byte[] paramArrayOfByte, bery parambery)
  {
    parambery.jdField_a_of_type_JavaLangString += "photo/";
    parambery.jdField_b_of_type_JavaLangString = ".jpg";
    if (paramString == null)
    {
      parambery.jdField_c_of_type_JavaLangString = d();
      if (paramArrayOfByte != null) {
        parambery.jdField_c_of_type_JavaLangString += HexUtil.bytes2HexStr(paramArrayOfByte).substring(0, 5);
      }
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
    String str2 = anzj.a(2131700136);
    long l = bcrg.a();
    MessageRecord localMessageRecord = bcry.a(-2012);
    localMessageRecord.init(str1, this.jdField_c_of_type_JavaLangString, str1, str2, l, 0, 0, l);
    localMessageRecord.msgtype = -2012;
    localMessageRecord.isread = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, str1);
  }
  
  public MessageRecord a(long paramLong1, StreamInfo paramStreamInfo, long paramLong2, Bundle paramBundle)
  {
    Object localObject1 = new byte[3];
    bhvd.a(this.jdField_a_of_type_Bete.g.length(), (byte[])localObject1, 0, 3, "utf-8");
    localObject1 = (MessageForPtt)bcry.a(-2002);
    ((MessageForPtt)localObject1).voiceType = ((int)paramStreamInfo.pttFormat);
    ((MessageForPtt)localObject1).voiceLength = ((int)paramStreamInfo.pttTime);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt", 2, "voiceLength createMessageDataBaseContent " + ((MessageForPtt)localObject1).voiceLength);
    }
    ((MessageForPtt)localObject1).selfuin = this.jdField_a_of_type_JavaLangString;
    ((MessageForPtt)localObject1).frienduin = this.jdField_c_of_type_JavaLangString;
    ((MessageForPtt)localObject1).senderuin = this.jdField_a_of_type_Bete.p;
    ((MessageForPtt)localObject1).isread = false;
    ((MessageForPtt)localObject1).time = paramStreamInfo.msgTime;
    ((MessageForPtt)localObject1).setPttStreamFlag(10001);
    ((MessageForPtt)localObject1).msgtype = -2002;
    ((MessageForPtt)localObject1).istroop = 0;
    ((MessageForPtt)localObject1).urlAtServer = this.jdField_a_of_type_Bete.g;
    ((MessageForPtt)localObject1).url = MessageForPtt.getMsgFilePath(((MessageForPtt)localObject1).voiceType, this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString);
    Object localObject2 = new File(this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString);
    int i;
    if (((File)localObject2).exists())
    {
      ((MessageForPtt)localObject1).fileSize = ((File)localObject2).length();
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800610E", "0X800610E", 1, 0, "", "", "", "8.4.5");
      ((MessageForPtt)localObject1).itemType = 2;
      ((MessageForPtt)localObject1).isread = false;
      ((MessageForPtt)localObject1).shmsgseq = ((short)paramStreamInfo.msgSeq);
      ((MessageForPtt)localObject1).msgUid = bcsa.a((int)paramStreamInfo.random);
      if ((paramStreamInfo.pttTransFlag != 1) && (!bduh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
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
      ((MessageForPtt)localObject1).longPttVipFlag = bcsa.a((QQAppInterface)localObject2, paramStreamInfo);
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
      } while (!adak.a((MessageRecord)paramStreamInfo.next(), (MessageRecord)localObject1, true));
      if (QLog.isColorLevel()) {
        QLog.w("streamptt", 2, "same Ptt :" + ((MessageForPtt)localObject1).getBaseInfoString());
      }
      return null;
      ((MessageForPtt)localObject1).fileSize = 1000L;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800610E", "0X800610E", 2, 0, "", "", "", "8.4.5");
      break;
      i = 0;
      break label313;
    }
    label760:
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject1, this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Bete.a(((MessageForPtt)localObject1).uniseq);
    return localObject1;
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, Bundle paramBundle)
  {
    this.jdField_a_of_type_Bete.jdField_a_of_type_Betg.jdField_d_of_type_Boolean = true;
    b(2);
    this.jdField_b_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("RecordParams", 2, "startReceiveOneStreamPack:" + paramStreamInfo.pttFormat + ", " + paramStreamInfo.pttTime);
    }
    this.jdField_a_of_type_Bete.a(4, paramStreamData.vData.length);
    switch (this.jdField_a_of_type_Bete.jdField_b_of_type_Int)
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
          i = bdoc.a(this.jdField_a_of_type_Bete.g);
          if (QLog.isColorLevel()) {
            QLog.d("streamptt.recv", 2, "curFlowLayer: " + i + " received shFlowLayer:" + paramStreamInfo.shFlowLayer + ",seq" + paramStreamData.shPackSeq + ",packNum:" + paramStreamInfo.shPackNum + " lkey:" + paramLong1);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendAppDataIncerment(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), false, bhnv.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()), 2, 0, paramStreamData.vData.length);
          bdoc.c(this.jdField_a_of_type_Bete.g, paramLong1);
          if (i != paramStreamInfo.shFlowLayer)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bete.g, bdoc.c(this.jdField_a_of_type_Bete.g), paramLong1);
            return;
          }
          if (bdoc.a(this.jdField_a_of_type_Bete.g, paramStreamData.shPackSeq))
          {
            this.jdField_a_of_type_Bete.a(2, 2);
            short s1 = (short)(bdoc.a(this.jdField_a_of_type_Bete.g) + 1);
            bdoc.a(this.jdField_a_of_type_Bete.g, s1);
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack JudgeReceiveError flowLayer: " + s1);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bete.g, bdoc.c(this.jdField_a_of_type_Bete.g), paramLong1);
            return;
          }
          if (paramStreamInfo.oprType == 1) {}
          for (i = 1; i != 0; i = 0)
          {
            if (QLog.isColorLevel()) {
              QLog.d("streamptt.recv", 2, "cancelled:" + this.jdField_a_of_type_Bete.g);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bete.g, this.jdField_a_of_type_Bete.jdField_b_of_type_Long);
            bdoc.a(this.jdField_a_of_type_Bete.g, true);
            bdoc.a(this.jdField_a_of_type_Bete.g);
            return;
          }
          bdoc.a(this.jdField_a_of_type_Bete.g, paramStreamInfo.shFlowLayer);
          bdoc.a(this.jdField_a_of_type_Bete.g, paramStreamData.vData, paramStreamData.vData.length, paramStreamData.shPackSeq);
        } while (paramStreamInfo.shPackNum <= 0);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bete.g, this.jdField_a_of_type_Bete.jdField_b_of_type_Long);
        bdoc.a(this.jdField_a_of_type_Bete.g, false);
        bdoc.a(this.jdField_a_of_type_Bete.g);
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
      if (!bdoc.e(paramStreamData)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("streamptt.recv", 2, "find stream offline duplicate,stop stream recv");
    return;
    bdoc.c(paramStreamData);
    c(2);
    if (QLog.isColorLevel()) {
      QLog.d("streamptt.recv", 2, "startReceiveOneStreamPack received success path: " + this.jdField_a_of_type_Bete.g);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bete.g, (short)-1, paramLong1);
    this.jdField_a_of_type_Bete.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Bete.g = paramStreamInfo.fileKey;
    if (paramStreamInfo.pttTransFlag == 1) {}
    for (int i = 1;; i = 0)
    {
      this.jdField_d_of_type_Int = i;
      if (a(paramLong2, paramStreamInfo, paramLong3, paramBundle) != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
      }
      e();
      bewa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, true, 3);
      bewa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, true, 2);
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
    this.jdField_a_of_type_Bete.jdField_a_of_type_Betg.jdField_d_of_type_Boolean = true;
    String str = "";
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && ("0".equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {}
    do
    {
      return;
      this.jdField_a_of_type_Bete.jdField_d_of_type_Int = 1001;
      b(2);
      this.jdField_b_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aocj);
      }
      b(2);
      if (paramShort > this.jdField_c_of_type_Int) {
        this.jdField_c_of_type_Int = paramShort;
      }
      switch (this.jdField_a_of_type_Bete.jdField_b_of_type_Int)
      {
      default: 
        return;
      }
    } while ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new BuddyTransfileProcessor.2(this, str, paramShort, paramLong, paramBundle, paramBoolean));
  }
  
  protected void a(boolean paramBoolean)
  {
    if (bewk.a(this.jdField_k_of_type_Int)) {
      break label10;
    }
    label10:
    label593:
    for (;;)
    {
      return;
      if ((this.jdField_a_of_type_Bete.jdField_b_of_type_Int == 2) && (!this.f) && (!bewk.a(this.jdField_k_of_type_Int)))
      {
        long l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
        HashMap localHashMap = new HashMap();
        if (!this.jdField_a_of_type_Bete.jdField_a_of_type_Betg.jdField_d_of_type_Boolean) {
          localHashMap.put("param_step", this.jdField_a_of_type_Bete.jdField_b_of_type_Betf.a(1) + ";" + this.jdField_a_of_type_Bete.jdField_a_of_type_Betg.a(2) + ";" + this.jdField_a_of_type_Bete.jdField_c_of_type_Betf.a(3));
        }
        if (paramBoolean)
        {
          if (this.jdField_a_of_type_Bete.jdField_a_of_type_Int == 0)
          {
            localHashMap.put("param_toUin", this.jdField_b_of_type_JavaLangString);
            localHashMap.putAll(this.jdField_a_of_type_Bete.jdField_a_of_type_Betg.jdField_a_of_type_JavaUtilHashMap);
            bdmc.a(BaseApplication.getContext()).a(null, "actC2CStreamPttUpload", true, l, this.jdField_a_of_type_Bete.jdField_a_of_type_Long, localHashMap, "");
            if (TextUtils.isEmpty(this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString)) {
              break;
            }
            bewa.a(this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString, true, paramBoolean, 0, this.jdField_a_of_type_Bete.jdField_a_of_type_Long);
            return;
          }
          bdmc.a(BaseApplication.getContext()).a(null, "actC2CStreamPttDownload", true, l, this.jdField_a_of_type_Bete.jdField_a_of_type_Long, localHashMap, "");
          return;
        }
        if (this.jdField_a_of_type_Bete.jdField_a_of_type_Int == 0) {
          if (!berp.a(this.jdField_k_of_type_Int, localHashMap))
          {
            localHashMap.put("param_FailCode", Integer.toString(this.jdField_k_of_type_Int));
            if ((this.jdField_k_of_type_Int == -9527) || (this.jdField_k_of_type_Int == 9311) || (this.jdField_k_of_type_Int == 9044) || (this.jdField_k_of_type_Int == 9350) || (this.jdField_k_of_type_Int == 9351))
            {
              localHashMap.put(berp.k, this.j);
              localHashMap.put("param_toUin", this.jdField_b_of_type_JavaLangString);
              bdmc.a(BaseApplication.getContext()).a(null, "actC2CStreamPttUpload", false, l, this.jdField_a_of_type_Bete.jdField_a_of_type_Long, localHashMap, "");
              if (!TextUtils.isEmpty(this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString)) {
                bewa.a(this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString, true, paramBoolean, 0, this.jdField_a_of_type_Bete.jdField_a_of_type_Long);
              }
            }
          }
        }
        for (;;)
        {
          if (this.jdField_a_of_type_Bete.jdField_b_of_type_Int != 2) {
            break label593;
          }
          bews.b(true, String.valueOf(this.jdField_k_of_type_Int) + "_" + this.j);
          return;
          localHashMap.put("param_errorDesc", this.j);
          break;
          this.jdField_k_of_type_Int = -9527;
          localHashMap.put("param_errorDesc", this.j);
          break;
          localHashMap.put("param_FailCode", String.valueOf(this.jdField_k_of_type_Int));
          localHashMap.put("param_errorDesc", this.j);
          bdmc.a(BaseApplication.getContext()).a(null, "actC2CStreamPttDownload", false, l, this.jdField_a_of_type_Bete.jdField_a_of_type_Long, localHashMap, "");
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
  
  public void aN_() {}
  
  public void c(boolean paramBoolean)
  {
    label337:
    for (paramBoolean = true;; paramBoolean = false)
    {
      for (;;)
      {
        try
        {
          if (this.jdField_a_of_type_Bete.jdField_b_of_type_Int != 2) {
            break;
          }
          MessageForPtt localMessageForPtt = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Bete.jdField_b_of_type_Long);
          localMessageForPtt.url = this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString;
          localMessageForPtt.fileSize = this.jdField_a_of_type_Bete.e;
          localMessageForPtt.itemType = this.jdField_a_of_type_Bete.jdField_b_of_type_Int;
          if (this.jdField_a_of_type_Bete.jdField_f_of_type_Int != 1) {
            break label337;
          }
          localMessageForPtt.isread = paramBoolean;
          localMessageForPtt.urlAtServer = this.jdField_a_of_type_Bete.g;
          if (bduh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
          {
            localMessageForPtt.sttAbility = 1;
            QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            if (localMessageForPtt.isSend())
            {
              Object localObject = this.jdField_a_of_type_JavaLangString;
              localMessageForPtt.longPttVipFlag = bcsa.a(localQQAppInterface, (String)localObject);
              localMessageForPtt.serial();
              if (QLog.isColorLevel()) {
                QLog.e("streamptt.send", 2, "Stream ptt:updataMessageDataBaseContent:time" + localMessageForPtt.time + " urlAtServer:" + localMessageForPtt.urlAtServer);
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Bete.jdField_b_of_type_Long, localMessageForPtt.msgData);
              localMessageForPtt.time = this.jdField_a_of_type_Long;
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Bete.jdField_b_of_type_Long, this.jdField_a_of_type_Long);
              localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0);
              if ((localObject == null) || (this.jdField_a_of_type_Bete.g == null) || (!this.jdField_a_of_type_Bete.g.equals(((QQMessageFacade.Message)localObject).pttUrl))) {
                break;
              }
              ((QQMessageFacade.Message)localObject).pttUrl = localMessageForPtt.url;
            }
          }
          else
          {
            localMessageForPtt.sttAbility = this.jdField_d_of_type_Int;
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
  
  void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
    }
    long l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    if ((!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isRunning())) {
      b(9366, "account switch");
    }
    if (this.jdField_a_of_type_Bete.jdField_a_of_type_Int == 0) {}
    for (String str = "streamptt.send";; str = "streamptt.recv")
    {
      QLog.d(str, 2, "onError elapsed:" + l + " errCode:" + this.jdField_k_of_type_Int + " errDesc:" + this.j + " reason:" + (String)this.jdField_a_of_type_JavaUtilHashMap.get("param_reason") + " uniseq:" + this.jdField_a_of_type_Bete.jdField_b_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
      a(false);
      if (this.jdField_a_of_type_Bete.jdField_a_of_type_Int != 0) {
        break;
      }
      d(1005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bete.g, this.jdField_a_of_type_Bete.jdField_b_of_type_Long);
      return;
    }
    d(2005);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bete.g, this.jdField_a_of_type_Bete.jdField_b_of_type_Long);
  }
  
  void e()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.shutdown();
    }
    long l = (System.nanoTime() - this.jdField_k_of_type_Long) / 1000000L;
    Object localObject;
    if (this.jdField_a_of_type_Bete.jdField_a_of_type_Int == 0)
    {
      localObject = "streamptt.send";
      QLog.d((String)localObject, 2, "onSuccess elapsed:" + l + " uniseq:" + this.jdField_a_of_type_Bete.jdField_b_of_type_Long);
      a(true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aocj);
      if (this.jdField_a_of_type_Bete.jdField_a_of_type_Int == 0) {
        c(true);
      }
      if (this.jdField_a_of_type_Bete.jdField_a_of_type_Int != 0) {
        break label172;
      }
      d(1003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Bete.p, this.jdField_a_of_type_Bete.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bete.jdField_b_of_type_Long);
    }
    label172:
    do
    {
      return;
      localObject = "streamptt.recv";
      break;
      d(2003);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Bete.g, this.jdField_a_of_type_Bete.jdField_b_of_type_Long);
      localObject = (MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_JavaLangString, 0, this.jdField_a_of_type_Bete.jdField_b_of_type_Long);
    } while ((localObject == null) || (this.jdField_a_of_type_Bduh == null) || (!this.jdField_a_of_type_Bduh.b((MessageForPtt)localObject)));
    this.jdField_a_of_type_Bduh.b((MessageForPtt)localObject, 2);
  }
  
  public void f()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = Executors.newSingleThreadExecutor();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berv
 * JD-Core Version:    0.7.0.1
 */