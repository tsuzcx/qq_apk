import QQService.StreamData;
import QQService.StreamInfo;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.transfile.C2CPttDownloadProcessor;
import com.tencent.mobileqq.transfile.GroupPttDownloadProcessor;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController.1;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class bayf
  extends bard
{
  public QQAppInterface a;
  ArrayList<String> a;
  ArrayList<String> b;
  public ConcurrentHashMap<String, byte[]> b;
  
  public bayf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.TransFileController", 2, "construct transfilecontroller:" + this);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static String a(bayk parambayk)
  {
    return a(parambayk.f, parambayk.jdField_e_of_type_JavaLangString, parambayk.b);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1))) {
      return paramString1 + "_" + paramInt;
    }
    return paramString2 + "_" + paramInt;
  }
  
  private void a(bayk parambayk, barf parambarf)
  {
    try
    {
      if (parambayk.jdField_a_of_type_Bayr.jdField_a_of_type_Int == -2)
      {
        baws.a(parambayk.jdField_a_of_type_Int, parambayk.jdField_a_of_type_Boolean, parambayk.b, String.valueOf(parambayk.jdField_a_of_type_Long), "callwait", "");
        parambarf.wait();
        baws.a(parambayk.jdField_a_of_type_Int, parambayk.jdField_a_of_type_Boolean, parambayk.b, String.valueOf(parambayk.jdField_a_of_type_Long), "waitfin", "");
      }
      return;
    }
    catch (InterruptedException parambayk)
    {
      parambayk.printStackTrace();
    }
  }
  
  private void a(bayk parambayk, barf parambarf, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "sync ";
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
      }
      ??? = (bdpz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (??? == null) {
        break label418;
      }
      if (!(??? instanceof bara)) {}
    }
    label418:
    do
    {
      do
      {
        long l;
        bayk localbayk;
        do
        {
          synchronized ((bara)???)
          {
            l = ((bara)???).c();
            localbayk = ((bara)???).a();
            baws.a(parambayk.jdField_a_of_type_Int, parambayk.jdField_a_of_type_Boolean, parambayk.b, String.valueOf(parambayk.jdField_a_of_type_Long), str + "startDownloadProcessor", "status:" + l + ",key:" + paramString);
            if ((l == -1L) || (l == 2002L) || (l == 2001L))
            {
              parambayk.jdField_a_of_type_Bayr = localbayk.jdField_a_of_type_Bayr;
              if (parambayk.jdField_a_of_type_Awiq != null) {
                ((bara)???).jdField_b_of_type_JavaUtilArrayList.add(parambayk.jdField_a_of_type_Awiq);
              }
              if (paramBoolean) {
                a(parambayk, (barf)???);
              }
            }
            for (;;)
            {
              return;
              str = "aync ";
              break;
              if ((l == 2004L) || (l == 2005L))
              {
                if (parambarf == null) {
                  continue;
                }
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambarf);
                parambarf.c(paramString);
                if (parambarf.c() != 0) {
                  continue;
                }
                awji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambayk);
                parambarf.aP_();
                if (!paramBoolean) {
                  continue;
                }
                try
                {
                  baws.a(parambayk.jdField_a_of_type_Int, parambayk.jdField_a_of_type_Boolean, parambayk.b, String.valueOf(parambayk.jdField_a_of_type_Long), "callwait", "");
                  ???.wait();
                }
                catch (InterruptedException parambayk)
                {
                  parambayk.printStackTrace();
                }
              }
            }
          }
        } while (l != 2003L);
        parambayk.jdField_a_of_type_Bayr = localbayk.jdField_a_of_type_Bayr;
        if (parambayk.jdField_a_of_type_Awiq != null)
        {
          parambarf = new awir();
          parambarf.jdField_a_of_type_Int = 0;
          parambarf.b = parambayk.h;
          parambarf.jdField_c_of_type_JavaLangString = parambayk.f;
          parambarf.jdField_c_of_type_Int = parambayk.b;
          parambarf.d = parambayk.g;
          parambayk.jdField_a_of_type_Awiq.a(parambarf);
        }
        return;
        baws.a(parambayk.jdField_a_of_type_Int, parambayk.jdField_a_of_type_Boolean, parambayk.b, String.valueOf(parambayk.jdField_a_of_type_Long), str + "startDownloadProcessor", "firs time ,key:" + paramString);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambarf);
        parambarf.c(paramString);
      } while (parambarf.c() != 0);
      awji.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambayk);
      parambarf.aP_();
    } while (!paramBoolean);
    try
    {
      a(parambayk, parambarf);
      return;
    }
    finally {}
  }
  
  private boolean a(bdpz parambdpz)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambdpz != null) {
      if (!(parambdpz instanceof barp))
      {
        bool1 = bool2;
        if (!(parambdpz instanceof batj)) {}
      }
      else
      {
        parambdpz = (barf)parambdpz;
        bool1 = bool2;
        if (parambdpz.c() != 1003L)
        {
          bool1 = bool2;
          if (parambdpz.d() != 1003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b(bdpz parambdpz)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambdpz != null)
    {
      bool1 = bool2;
      if ((parambdpz instanceof StructLongMessageDownloadProcessor))
      {
        bool1 = bool2;
        if (((barf)parambdpz).c() != 2003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean c(bdpz parambdpz)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambdpz != null) {
      if (!(parambdpz instanceof baul))
      {
        bool1 = bool2;
        if (!(parambdpz instanceof bauk)) {}
      }
      else
      {
        parambdpz = (barf)parambdpz;
        bool1 = bool2;
        if (parambdpz.c() != 1003L)
        {
          bool1 = bool2;
          if (parambdpz.d() != 2003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean d(bdpz parambdpz)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambdpz != null)
    {
      bool1 = bool2;
      if ((parambdpz instanceof bavu))
      {
        bool1 = bool2;
        if (((barf)parambdpz).c() != 1003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public int a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)))
    {
      paramString1 = (bdpz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof barf)) {
        return ((barf)paramString1).f();
      }
    }
    return 0;
  }
  
  public barf a(bayk parambayk)
  {
    if (parambayk == null) {
      return null;
    }
    if (parambayk.b == 131078)
    {
      if (parambayk.jdField_a_of_type_Boolean) {
        return new baux(this, parambayk);
      }
      return new bauw(this, parambayk);
    }
    if (parambayk.b == 262153)
    {
      if (parambayk.jdField_a_of_type_Boolean) {
        return new bawv(this, parambayk);
      }
      return new bawu(this, parambayk);
    }
    if (parambayk.b == 327689) {
      return new bauo(this, parambayk);
    }
    if (parambayk.b == 327696) {
      return new bavu(this, parambayk);
    }
    if (parambayk.b == 66) {
      return new bawz(this, parambayk);
    }
    if ((parambayk.b == 52) && (parambayk.jdField_a_of_type_Boolean)) {
      return new basx(this, parambayk);
    }
    if (parambayk.jdField_a_of_type_Int == 1026)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "getProcessor UIN_TYPE_HOTCHAT_TOPIC  isUp = " + parambayk.jdField_a_of_type_Boolean);
      }
      if (parambayk.jdField_a_of_type_Boolean) {
        return new batj(this, parambayk);
      }
      if (parambayk.b == 2) {
        return new GroupPttDownloadProcessor(this, parambayk);
      }
      return null;
    }
    if ((parambayk.jdField_a_of_type_Int == 1) || (parambayk.jdField_a_of_type_Int == 3000))
    {
      if (parambayk.jdField_a_of_type_Boolean)
      {
        if ((parambayk.b == 6) || (parambayk.b == 17) || (parambayk.b == 9)) {
          return new ShortVideoUploadProcessor(this, parambayk);
        }
        if (parambayk.b == 20) {
          return new baxe(this, parambayk);
        }
        if (parambayk.b == 55) {
          return new bayt(this, parambayk);
        }
        if (parambayk.jdField_e_of_type_Int == 1045) {
          return new batr(this, parambayk);
        }
        if (parambayk.b == 2) {
          return new batn(this, parambayk);
        }
        return new batj(this, parambayk);
      }
      if (parambayk.b == 2) {
        return new GroupPttDownloadProcessor(this, parambayk);
      }
      if ((parambayk.b == 1) || (parambayk.b == 65537) || (parambayk.b == 131075)) {
        return new bati(this, parambayk);
      }
      if ((parambayk.b == 6) || (parambayk.b == 7) || (parambayk.b == 17) || (parambayk.b == 18) || (parambayk.b == 9) || (parambayk.b == 16)) {
        return new baxb(this, parambayk);
      }
    }
    else
    {
      if (parambayk.jdField_a_of_type_Boolean)
      {
        if (parambayk.b == 2) {
          return new bart(this, parambayk);
        }
        if (parambayk.b == 32) {
          return new baul(this, parambayk);
        }
        if ((parambayk.b == 6) || (parambayk.b == 17) || (parambayk.b == 9)) {
          return new ShortVideoUploadProcessor(this, parambayk);
        }
        if ((parambayk.b == 8) || (parambayk.b == 64) || (parambayk.b == 22) || (parambayk.b == 21) || (parambayk.b == 34) || (parambayk.b == 35) || (parambayk.b == 36) || (parambayk.b == 37) || (parambayk.b == 38) || (parambayk.b == 48) || (parambayk.b == 23) || (parambayk.b == 39) || (parambayk.b == 40) || (parambayk.b == 41) || (parambayk.b == 50) || (parambayk.b == 51) || (parambayk.b == 56)) {
          return new bavb(this, parambayk);
        }
        if (parambayk.b == 20) {
          return new baxe(this, parambayk);
        }
        if (parambayk.b == 24) {
          return new baqy(this, parambayk);
        }
        if ((parambayk.b == 196609) || (parambayk.b == 196610) || (parambayk.b == 327681)) {
          return new baxx(this, parambayk);
        }
        if (parambayk.jdField_e_of_type_Int == 1045) {
          return new barx(this, parambayk);
        }
        return new barp(this, parambayk);
      }
      if (parambayk.b == 2) {
        return new C2CPttDownloadProcessor(this, parambayk);
      }
      if (parambayk.b == 32) {
        return new bauk(this, parambayk);
      }
      if (parambayk.b == 33) {
        return new bavj(this, parambayk);
      }
      if ((parambayk.b == 6) || (parambayk.b == 7) || (parambayk.b == 17) || (parambayk.b == 18) || (parambayk.b == 9) || (parambayk.b == 16)) {
        return new baxb(this, parambayk);
      }
      if ((parambayk.b == 1) || (parambayk.b == 65537) || (parambayk.b == 131075)) {
        return new baro(this, parambayk);
      }
      if (parambayk.b == 131079) {
        return new StructLongMessageDownloadProcessor(this, parambayk);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, parambayk.toString());
    }
    return null;
  }
  
  public bayr a(bayk parambayk)
  {
    parambayk.jdField_a_of_type_Boolean = false;
    parambayk.jdField_a_of_type_Bayr = new bayr();
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (parambayk.b == 131076)
      {
        localObject = new bayw(this, parambayk);
        a(parambayk, (barf)localObject, a(parambayk), true);
      }
    }
    for (;;)
    {
      return parambayk.jdField_a_of_type_Bayr;
      if ((parambayk.jdField_a_of_type_Int == 1) || (parambayk.jdField_a_of_type_Int == 3000))
      {
        localObject = new bati(this, parambayk);
        break;
      }
      localObject = new baro(this, parambayk);
      break;
      localObject = parambayk.jdField_a_of_type_Bayr;
      ((bayr)localObject).jdField_a_of_type_Int = -1;
      ((bayr)localObject).jdField_a_of_type_Long = 9366L;
      ((bayr)localObject).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public bdpz a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (bdpz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public bdpz a(String paramString1, String paramString2, long paramLong)
  {
    return a(paramString1, paramLong);
  }
  
  public String a(String paramString, long paramLong)
  {
    return paramString + paramLong;
  }
  
  public void a(long paramLong1, String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong2, int paramInt2)
  {
    String str = paramString2 + paramLong1;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str))
    {
      bdpz localbdpz = a(paramString2, paramLong1);
      if ((localbdpz instanceof basv)) {
        ((basv)localbdpz).a();
      }
    }
    paramString1 = new basv(paramLong1, paramString1, paramQQAppInterface, paramInt1, paramString2, paramString3, paramString4, paramString5, paramLong2, paramInt2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ptt_reserve.ReserveStruct paramReserveStruct)
  {
    Object localObject2 = azuj.a(paramStreamInfo.iMsgId, 1);
    long l1 = paramStreamInfo.lFromUIN;
    long l2 = paramStreamInfo.lToUIN;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = barl.a(String.valueOf(l2), null, 2, null);
      int i = bdeu.a(paramStreamInfo.pttFormat);
      localObject2 = MessageForPtt.getLocalFilePath(i, (String)localObject1);
      azuj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject2, 1, paramStreamInfo.iMsgId);
      azuj.a((String)localObject2, (short)paramStreamInfo.msgSeq);
      azuj.b((String)localObject2, paramStreamInfo.random);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.TransFileController", 2, "onReceiveStreamAction  key is:" + (String)localObject2 + ",msgSeq is:" + paramStreamInfo.msgSeq + ",random is:" + paramStreamInfo.random);
        localObject1 = localObject2;
      }
    }
    localObject2 = new Bundle();
    im_msg_body.GeneralFlags localGeneralFlags = new im_msg_body.GeneralFlags();
    try
    {
      localGeneralFlags.mergeFrom(paramReserveStruct.bytes_general_flags.get().toByteArray());
      ((Bundle)localObject2).putInt("DiyTextId", localGeneralFlags.uint32_bubble_diy_text_id.get());
      ((Bundle)localObject2).putInt("DiyPendantId", (int)paramLong4);
      a(String.valueOf(l1), (String)localObject1, -1000L, paramStreamInfo, paramStreamData, paramLong1, paramLong2, paramLong3, (Bundle)localObject2);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramReserveStruct)
    {
      for (;;)
      {
        QLog.e("Q.richmedia.TransFileController", 1, "pb merge failed.", paramReserveStruct);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, Intent paramIntent)
  {
    ThreadManager.postImmediately(new TransFileController.1(this, paramString, paramIntent, paramQQAppInterface), null, true);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((paramChatMessage instanceof MessageForPtt)) {}
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!(paramChatMessage instanceof MessageForShortVideo)) {
              break;
            }
            paramChatMessage = (MessageForShortVideo)paramChatMessage;
            ((QQAppInterface)localObject).a().e(paramChatMessage.frienduin, paramChatMessage.uniseq);
          } while (paramChatMessage.busiType != 0);
          localObject = (auqc)((QQAppInterface)localObject).getManager(324);
        } while (!((auqc)localObject).a(paramChatMessage));
        ((auqc)localObject).b(paramChatMessage, 0L, 0, 256);
        return;
      } while (!(paramChatMessage instanceof MessageForPic));
      paramChatMessage = (MessageForPic)paramChatMessage;
      a(paramChatMessage, 131075);
      a(paramChatMessage, 1);
      a(paramChatMessage, 131075);
      localObject = (auqc)((QQAppInterface)localObject).getManager(324);
    } while (!((auqc)localObject).a(paramChatMessage));
    ((auqc)localObject).b(paramChatMessage, 0L, 0, 24);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    paramMessageForPic = a(a(paramMessageForPic.md5, paramMessageForPic.uuid, paramInt));
    if ((paramMessageForPic != null) && ((paramMessageForPic instanceof barf))) {
      ((barf)paramMessageForPic).a();
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bdpz)((Map.Entry)localIterator.next()).getValue();
        if (a((bdpz)localObject))
        {
          localObject = (barf)localObject;
          if ((paramString.equals(((barf)localObject).a.jdField_c_of_type_JavaLangString)) && (((barf)localObject).k))
          {
            ((barf)localObject).b();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "resume pic:" + ((barf)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Iterator localIterator = a(this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      bdpz localbdpz = (bdpz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        if (((localbdpz instanceof barl)) && (paramString.equals(((barl)localbdpz).a.p)))
        {
          ((barf)localbdpz).j();
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
        }
        break;
      }
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bdpz)((Map.Entry)localIterator.next()).getValue();
        if (a((bdpz)localObject))
        {
          localObject = (barf)localObject;
          if ((paramString.equals(((barf)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((barf)localObject).a.jdField_a_of_type_Long))
          {
            ((barf)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((barf)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, bayi parambayi)
  {
    if (paramString == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bdpz)((Map.Entry)localIterator.next()).getValue();
        if (a((bdpz)localObject))
        {
          localObject = (barf)localObject;
          if ((paramString.equals(((barf)localObject).a.jdField_c_of_type_JavaLangString)) && (((barf)localObject).d()))
          {
            ((barf)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((barf)localObject).a.jdField_a_of_type_Long);
            }
            if (((barf)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              localArrayList.add(((barf)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          }
        }
      }
    } while (parambayi == null);
    parambayi.a(localArrayList);
  }
  
  public void a(String paramString, bdpz parambdpz)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambdpz);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bdpz)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof barf))) {
        break label171;
      }
      localObject = (barf)localObject;
      if ((!((barf)localObject).m) || (((barf)localObject).k)) {
        break label171;
      }
      ((barf)localObject).c();
      if (((barf)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((barf)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend key:" + ((barf)localObject).a());
      }
      bool = true;
    }
    label171:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean a(long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bdpz)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof bark))) {
        break label175;
      }
      localObject = (bark)localObject;
      if ((((bark)localObject).a == null) || (!((bark)localObject).a.i)) {
        break label175;
      }
      ((bark)localObject).u = paramLong;
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicReport", 2, "initAllPSProcessorEnterAioTime ,Processor:" + localObject + ",time = " + paramLong);
      }
      bool = true;
    }
    label175:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("PresendPicReport", 2, "initAllPSProcessorEnterAioTime result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean a(bayk parambayk)
  {
    try
    {
      boolean bool = super.a(parambayk);
      return bool;
    }
    finally
    {
      parambayk = finally;
      throw parambayk;
    }
  }
  
  public boolean a(bayk parambayk, MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = a(parambayk);
      return bool;
    }
    finally
    {
      parambayk = finally;
      throw parambayk;
    }
  }
  
  /* Error */
  public boolean a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 42	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: lload_2
    //   14: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 147	bayf:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +31 -> 60
    //   32: aload_0
    //   33: getfield 147	bayf:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: aload_1
    //   37: invokevirtual 151	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 334	baxb
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 684	baxb:c	()V
    //   52: iconst_1
    //   53: istore 4
    //   55: aload_0
    //   56: monitorexit
    //   57: iload 4
    //   59: ireturn
    //   60: iconst_0
    //   61: istore 4
    //   63: goto -8 -> 55
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	bayf
    //   0	71	1	paramString	String
    //   0	71	2	paramLong	long
    //   53	9	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	44	66	finally
    //   48	52	66	finally
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    return b(paramString1 + paramString2);
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong1, StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong2, long paramLong3, long paramLong4, Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1 + paramString2 + paramLong1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        barl localbarl = new barl(paramString1, paramString2, false, null, null, 2, -1, false, this, paramLong1);
        localbarl.a(paramLong1);
        localbarl.a().jdField_c_of_type_JavaLangString = paramString2;
        localbarl.c(paramString1 + paramString2 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramString2 + paramLong1, localbarl);
        localbarl.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (barl)a(paramString1 + paramString2 + paramLong1);
    if (paramString1 != null) {
      paramString1.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, long paramLong1, short paramShort, int paramInt1, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1 + paramLong1))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        paramString2 = new barl(paramString1, paramString2, true, null, null, 2, -1, false, this, paramLong1);
        paramString2.a(paramLong1);
        paramString2.f();
        paramString2.c(paramString1 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramLong1, paramString2);
        paramString2.a(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (barl)a(paramString1, paramString2, paramLong1);
    if (paramString1 != null) {
      paramString1.a(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
    }
    return false;
  }
  
  public int b(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if ((!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)))
    {
      paramString1 = (bdpz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof barf)) {
        return (int)((barf)paramString1).c();
      }
    }
    return -1;
  }
  
  public bayr b(bayk parambayk)
  {
    parambayk.jdField_a_of_type_Boolean = false;
    parambayk.jdField_a_of_type_Bayr = new bayr();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        Object localObject1;
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
        {
          localObject1 = parambayk.jdField_a_of_type_Bayr;
          ((bayr)localObject1).jdField_a_of_type_Int = -1;
          ((bayr)localObject1).jdField_a_of_type_Long = 9366L;
          ((bayr)localObject1).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          parambayk = parambayk.jdField_a_of_type_Bayr;
          return parambayk;
        }
        try
        {
          if (parambayk.b == 131076)
          {
            localObject1 = new bayw(this, parambayk);
            a(parambayk, (barf)localObject1, a(parambayk), false);
            return parambayk.jdField_a_of_type_Bayr;
          }
          if ((parambayk.jdField_a_of_type_Int == 1) || (parambayk.jdField_a_of_type_Int == 3000))
          {
            localObject1 = new bati(this, parambayk);
            continue;
            parambayk = finally;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          localObject2 = parambayk.jdField_a_of_type_Bayr;
          ((bayr)localObject2).jdField_a_of_type_Int = -1;
          ((bayr)localObject2).jdField_a_of_type_Long = 9366L;
          ((bayr)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          parambayk = parambayk.jdField_a_of_type_Bayr;
          return parambayk;
        }
      }
      Object localObject2 = new baro(this, parambayk);
      continue;
      localObject2 = parambayk.jdField_a_of_type_Bayr;
      ((bayr)localObject2).jdField_a_of_type_Int = -1;
      ((bayr)localObject2).jdField_a_of_type_Long = 9366L;
      ((bayr)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public void b() {}
  
  public void b(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bdpz)((Map.Entry)localIterator.next()).getValue();
        if (c((bdpz)localObject))
        {
          localObject = (barf)localObject;
          if ((paramString.equals(((barf)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((barf)localObject).a.jdField_a_of_type_Long))
          {
            ((barf)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel JSPTT:" + ((barf)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bdpz)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof barf))) {
        break label211;
      }
      localObject = (barf)localObject;
      if ((!((barf)localObject).n) || (((barf)localObject).k)) {
        break label211;
      }
      ((barf)localObject).c();
      if (((barf)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((barf)localObject).a());
      }
      localStringBuilder.append(((barf)localObject).a());
      localStringBuilder.append(",");
      bool = true;
    }
    label211:
    for (;;)
    {
      break;
      if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
        QLog.d("short_video", 2, "pauseAllShortVideoReceive key:" + localStringBuilder);
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoReceive result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean b(String paramString)
  {
    paramString = a(paramString);
    if ((paramString != null) && ((paramString instanceof barf)))
    {
      paramString = (barf)paramString;
      if ((paramString.l) && (paramString.k))
      {
        paramString.b();
        if (QLog.isColorLevel()) {
          QLog.d("raw_photo", 2, "resumeRawSend ,key:" + paramString.a());
        }
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  public boolean b(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 4
    //   5: new 42	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: lload_2
    //   17: invokevirtual 169	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 147	bayf:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +36 -> 68
    //   35: aload_0
    //   36: getfield 147	bayf:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_1
    //   40: invokevirtual 151	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 153	bdpz
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +17 -> 65
    //   51: aload_1
    //   52: instanceof 312
    //   55: ifeq +18 -> 73
    //   58: aload_1
    //   59: checkcast 312	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor
    //   62: invokevirtual 737	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:c	()V
    //   65: iconst_1
    //   66: istore 4
    //   68: aload_0
    //   69: monitorexit
    //   70: iload 4
    //   72: ireturn
    //   73: aload_1
    //   74: instanceof 315
    //   77: ifeq -12 -> 65
    //   80: aload_1
    //   81: checkcast 315	baxe
    //   84: invokevirtual 738	baxe:c	()V
    //   87: goto -22 -> 65
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	bayf
    //   0	95	1	paramString	String
    //   0	95	2	paramLong	long
    //   3	68	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	24	90	finally
    //   24	47	90	finally
    //   51	65	90	finally
    //   73	87	90	finally
  }
  
  public boolean b(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      paramString2 = (barl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.j();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public void c()
  {
    long l;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      l = System.currentTimeMillis();
    }
    synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().b();
      a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.TransFileController", 2, "destroy transfilecontroller:" + this + " elapsed:" + (System.currentTimeMillis() - l));
      }
      return;
    }
  }
  
  public void c(String paramString, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bdpz)((Map.Entry)localIterator.next()).getValue();
      if (b((bdpz)localObject))
      {
        ThreadManager.getSubThreadHandler().removeCallbacks((StructLongMessageDownloadProcessor)localObject);
        localObject = (barf)localObject;
        if ((paramString.equals(((barf)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((barf)localObject).a.jdField_a_of_type_Long))
        {
          ((barf)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("cancelpic", 2, "cancel PALongMsg:" + ((barf)localObject).a.jdField_a_of_type_Long);
          }
        }
      }
    }
  }
  
  public boolean c()
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bdpz)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof barf))) {
        break label178;
      }
      localObject = (barf)localObject;
      if ((!((barf)localObject).l) || (((barf)localObject).k)) {
        break label178;
      }
      ((barf)localObject).c();
      if (((barf)localObject).a() != null) {
        this.jdField_b_of_type_JavaUtilArrayList.add(((barf)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend key:" + ((barf)localObject).a());
      }
      bool = true;
    }
    label178:
    for (;;)
    {
      break;
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend result:" + bool);
      }
      return bool;
    }
  }
  
  public boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool1;
    for (boolean bool2 = false; localIterator.hasNext(); bool2 = bool1)
    {
      Object localObject = (bdpz)((Map.Entry)localIterator.next()).getValue();
      bool1 = bool2;
      if (a((bdpz)localObject))
      {
        localObject = (barf)localObject;
        bool1 = bool2;
        if (paramString.equals(((barf)localObject).a.jdField_c_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (!((barf)localObject).k)
          {
            ((barf)localObject).c();
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("cancelpic", 2, "pause pic:" + ((barf)localObject).a.jdField_a_of_type_Long);
              bool1 = bool2;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean c(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        paramString = paramString + paramLong;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
        {
          paramString = (bdpz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (((paramString instanceof ShortVideoUploadProcessor)) && (((ShortVideoUploadProcessor)paramString).d()))
          {
            ((ShortVideoUploadProcessor)paramString).b();
            bool = true;
            return bool;
          }
        }
      }
      finally
      {
        paramString = finally;
        throw paramString;
      }
      boolean bool = false;
    }
  }
  
  public boolean c(String paramString1, String paramString2, long paramLong)
  {
    paramString1 = paramString1 + paramString2 + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1))
    {
      paramString2 = (barl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.j();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend keys size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = a((String)localIterator.next());
      if ((localObject != null) && ((localObject instanceof barf)))
      {
        localObject = (barf)localObject;
        if (((barf)localObject).k)
        {
          ((barf)localObject).b();
          localStringBuilder.append(((barf)localObject).a());
          localStringBuilder.append(",");
        }
      }
    }
    if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend , key: " + localStringBuilder);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void d(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bdpz)((Map.Entry)localIterator.next()).getValue();
        if (d((bdpz)localObject))
        {
          localObject = (barf)localObject;
          if ((paramString.equals(((barf)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((barf)localObject).a.jdField_a_of_type_Long))
          {
            ((barf)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "PttSliceUploadProcessor cancelVoiceTextTask:" + ((barf)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public boolean d(String paramString)
  {
    if (paramString == null) {}
    label90:
    label91:
    for (;;)
    {
      return false;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        bdpz localbdpz = (bdpz)((Map.Entry)localIterator.next()).getValue();
        if ((!a(localbdpz)) || (!paramString.equals(((barf)localbdpz).a.jdField_c_of_type_JavaLangString))) {
          break label90;
        }
        i += 1;
      }
      for (;;)
      {
        break;
        if (i <= 1) {
          break label91;
        }
        return true;
      }
    }
  }
  
  public boolean d(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        paramString = paramString + paramLong;
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
        {
          bdpz localbdpz = (bdpz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (localbdpz != null)
          {
            if ((localbdpz instanceof ShortVideoUploadProcessor)) {
              ((ShortVideoUploadProcessor)localbdpz).c();
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
            bool = true;
            return bool;
          }
          if (!(localbdpz instanceof baxe)) {
            continue;
          }
          ((baxe)localbdpz).c();
          continue;
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "resumeLastRawSend keys size:" + this.jdField_b_of_type_JavaUtilArrayList.size());
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      b((String)localIterator.next());
    }
  }
  
  public boolean e(String paramString, long paramLong)
  {
    paramString = paramString + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      bdpz localbdpz = (bdpz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localbdpz instanceof baxb))
      {
        ((baxb)localbdpz).c();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bayf
 * JD-Core Version:    0.7.0.1
 */