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

public class ayvx
  extends ayoz
{
  public QQAppInterface a;
  ArrayList<String> a;
  ArrayList<String> b;
  public ConcurrentHashMap<String, byte[]> b;
  
  public ayvx(QQAppInterface paramQQAppInterface)
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
  
  public static String a(aywc paramaywc)
  {
    return a(paramaywc.f, paramaywc.jdField_e_of_type_JavaLangString, paramaywc.b);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1))) {
      return paramString1 + "_" + paramInt;
    }
    return paramString2 + "_" + paramInt;
  }
  
  private void a(aywc paramaywc, aypb paramaypb)
  {
    try
    {
      if (paramaywc.jdField_a_of_type_Aywj.jdField_a_of_type_Int == -2)
      {
        ayuk.a(paramaywc.jdField_a_of_type_Int, paramaywc.jdField_a_of_type_Boolean, paramaywc.b, String.valueOf(paramaywc.jdField_a_of_type_Long), "callwait", "");
        paramaypb.wait();
        ayuk.a(paramaywc.jdField_a_of_type_Int, paramaywc.jdField_a_of_type_Boolean, paramaywc.b, String.valueOf(paramaywc.jdField_a_of_type_Long), "waitfin", "");
      }
      return;
    }
    catch (InterruptedException paramaywc)
    {
      paramaywc.printStackTrace();
    }
  }
  
  private void a(aywc paramaywc, aypb paramaypb, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "sync ";
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
      }
      ??? = (bbmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (??? == null) {
        break label418;
      }
      if (!(??? instanceof ayow)) {}
    }
    label418:
    do
    {
      do
      {
        long l;
        aywc localaywc;
        do
        {
          synchronized ((ayow)???)
          {
            l = ((ayow)???).c();
            localaywc = ((ayow)???).a();
            ayuk.a(paramaywc.jdField_a_of_type_Int, paramaywc.jdField_a_of_type_Boolean, paramaywc.b, String.valueOf(paramaywc.jdField_a_of_type_Long), str + "startDownloadProcessor", "status:" + l + ",key:" + paramString);
            if ((l == -1L) || (l == 2002L) || (l == 2001L))
            {
              paramaywc.jdField_a_of_type_Aywj = localaywc.jdField_a_of_type_Aywj;
              if (paramaywc.jdField_a_of_type_Auna != null) {
                ((ayow)???).jdField_b_of_type_JavaUtilArrayList.add(paramaywc.jdField_a_of_type_Auna);
              }
              if (paramBoolean) {
                a(paramaywc, (aypb)???);
              }
            }
            for (;;)
            {
              return;
              str = "aync ";
              break;
              if ((l == 2004L) || (l == 2005L))
              {
                if (paramaypb == null) {
                  continue;
                }
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramaypb);
                paramaypb.c(paramString);
                if (paramaypb.c() != 0) {
                  continue;
                }
                auns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaywc);
                paramaypb.aR_();
                if (!paramBoolean) {
                  continue;
                }
                try
                {
                  ayuk.a(paramaywc.jdField_a_of_type_Int, paramaywc.jdField_a_of_type_Boolean, paramaywc.b, String.valueOf(paramaywc.jdField_a_of_type_Long), "callwait", "");
                  ???.wait();
                }
                catch (InterruptedException paramaywc)
                {
                  paramaywc.printStackTrace();
                }
              }
            }
          }
        } while (l != 2003L);
        paramaywc.jdField_a_of_type_Aywj = localaywc.jdField_a_of_type_Aywj;
        if (paramaywc.jdField_a_of_type_Auna != null)
        {
          paramaypb = new aunb();
          paramaypb.jdField_a_of_type_Int = 0;
          paramaypb.b = paramaywc.h;
          paramaypb.jdField_c_of_type_JavaLangString = paramaywc.f;
          paramaypb.jdField_c_of_type_Int = paramaywc.b;
          paramaypb.d = paramaywc.g;
          paramaywc.jdField_a_of_type_Auna.a(paramaypb);
        }
        return;
        ayuk.a(paramaywc.jdField_a_of_type_Int, paramaywc.jdField_a_of_type_Boolean, paramaywc.b, String.valueOf(paramaywc.jdField_a_of_type_Long), str + "startDownloadProcessor", "firs time ,key:" + paramString);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramaypb);
        paramaypb.c(paramString);
      } while (paramaypb.c() != 0);
      auns.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaywc);
      paramaypb.aR_();
    } while (!paramBoolean);
    try
    {
      a(paramaywc, paramaypb);
      return;
    }
    finally {}
  }
  
  private boolean a(bbmw parambbmw)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambbmw != null) {
      if (!(parambbmw instanceof aypl))
      {
        bool1 = bool2;
        if (!(parambbmw instanceof ayrf)) {}
      }
      else
      {
        parambbmw = (aypb)parambbmw;
        bool1 = bool2;
        if (parambbmw.c() != 1003L)
        {
          bool1 = bool2;
          if (parambbmw.d() != 1003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b(bbmw parambbmw)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambbmw != null)
    {
      bool1 = bool2;
      if ((parambbmw instanceof StructLongMessageDownloadProcessor))
      {
        bool1 = bool2;
        if (((aypb)parambbmw).c() != 2003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean c(bbmw parambbmw)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambbmw != null) {
      if (!(parambbmw instanceof aysf))
      {
        bool1 = bool2;
        if (!(parambbmw instanceof ayse)) {}
      }
      else
      {
        parambbmw = (aypb)parambbmw;
        bool1 = bool2;
        if (parambbmw.c() != 1003L)
        {
          bool1 = bool2;
          if (parambbmw.d() != 2003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean d(bbmw parambbmw)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambbmw != null)
    {
      bool1 = bool2;
      if ((parambbmw instanceof ayto))
      {
        bool1 = bool2;
        if (((aypb)parambbmw).c() != 1003L) {
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
      paramString1 = (bbmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof aypb)) {
        return ((aypb)paramString1).f();
      }
    }
    return 0;
  }
  
  public aypb a(aywc paramaywc)
  {
    if (paramaywc == null) {
      return null;
    }
    if (paramaywc.b == 131078)
    {
      if (paramaywc.jdField_a_of_type_Boolean) {
        return new aysr(this, paramaywc);
      }
      return new aysq(this, paramaywc);
    }
    if (paramaywc.b == 262153)
    {
      if (paramaywc.jdField_a_of_type_Boolean) {
        return new ayun(this, paramaywc);
      }
      return new ayum(this, paramaywc);
    }
    if (paramaywc.b == 327689) {
      return new aysi(this, paramaywc);
    }
    if (paramaywc.b == 327696) {
      return new ayto(this, paramaywc);
    }
    if (paramaywc.b == 66) {
      return new ayur(this, paramaywc);
    }
    if ((paramaywc.b == 52) && (paramaywc.jdField_a_of_type_Boolean)) {
      return new ayqt(this, paramaywc);
    }
    if (paramaywc.jdField_a_of_type_Int == 1026)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "getProcessor UIN_TYPE_HOTCHAT_TOPIC  isUp = " + paramaywc.jdField_a_of_type_Boolean);
      }
      if (paramaywc.jdField_a_of_type_Boolean) {
        return new ayrf(this, paramaywc);
      }
      if (paramaywc.b == 2) {
        return new GroupPttDownloadProcessor(this, paramaywc);
      }
      return null;
    }
    if ((paramaywc.jdField_a_of_type_Int == 1) || (paramaywc.jdField_a_of_type_Int == 3000))
    {
      if (paramaywc.jdField_a_of_type_Boolean)
      {
        if ((paramaywc.b == 6) || (paramaywc.b == 17) || (paramaywc.b == 9)) {
          return new ShortVideoUploadProcessor(this, paramaywc);
        }
        if (paramaywc.b == 20) {
          return new ayuw(this, paramaywc);
        }
        if (paramaywc.b == 55) {
          return new aywl(this, paramaywc);
        }
        if (paramaywc.jdField_e_of_type_Int == 1045) {
          return new ayrn(this, paramaywc);
        }
        if (paramaywc.b == 2) {
          return new ayrj(this, paramaywc);
        }
        return new ayrf(this, paramaywc);
      }
      if (paramaywc.b == 2) {
        return new GroupPttDownloadProcessor(this, paramaywc);
      }
      if ((paramaywc.b == 1) || (paramaywc.b == 65537) || (paramaywc.b == 131075)) {
        return new ayre(this, paramaywc);
      }
      if ((paramaywc.b == 6) || (paramaywc.b == 7) || (paramaywc.b == 17) || (paramaywc.b == 18) || (paramaywc.b == 9) || (paramaywc.b == 16)) {
        return new ayut(this, paramaywc);
      }
    }
    else
    {
      if (paramaywc.jdField_a_of_type_Boolean)
      {
        if (paramaywc.b == 2) {
          return new aypp(this, paramaywc);
        }
        if (paramaywc.b == 32) {
          return new aysf(this, paramaywc);
        }
        if ((paramaywc.b == 6) || (paramaywc.b == 17) || (paramaywc.b == 9)) {
          return new ShortVideoUploadProcessor(this, paramaywc);
        }
        if ((paramaywc.b == 8) || (paramaywc.b == 64) || (paramaywc.b == 22) || (paramaywc.b == 21) || (paramaywc.b == 34) || (paramaywc.b == 35) || (paramaywc.b == 36) || (paramaywc.b == 37) || (paramaywc.b == 38) || (paramaywc.b == 48) || (paramaywc.b == 23) || (paramaywc.b == 39) || (paramaywc.b == 40) || (paramaywc.b == 41) || (paramaywc.b == 50) || (paramaywc.b == 51) || (paramaywc.b == 56)) {
          return new aysv(this, paramaywc);
        }
        if (paramaywc.b == 20) {
          return new ayuw(this, paramaywc);
        }
        if (paramaywc.b == 24) {
          return new ayou(this, paramaywc);
        }
        if ((paramaywc.b == 196609) || (paramaywc.b == 196610) || (paramaywc.b == 327681)) {
          return new ayvp(this, paramaywc);
        }
        if (paramaywc.jdField_e_of_type_Int == 1045) {
          return new aypt(this, paramaywc);
        }
        return new aypl(this, paramaywc);
      }
      if (paramaywc.b == 2) {
        return new C2CPttDownloadProcessor(this, paramaywc);
      }
      if (paramaywc.b == 32) {
        return new ayse(this, paramaywc);
      }
      if (paramaywc.b == 33) {
        return new aytd(this, paramaywc);
      }
      if ((paramaywc.b == 6) || (paramaywc.b == 7) || (paramaywc.b == 17) || (paramaywc.b == 18) || (paramaywc.b == 9) || (paramaywc.b == 16)) {
        return new ayut(this, paramaywc);
      }
      if ((paramaywc.b == 1) || (paramaywc.b == 65537) || (paramaywc.b == 131075)) {
        return new aypk(this, paramaywc);
      }
      if (paramaywc.b == 131079) {
        return new StructLongMessageDownloadProcessor(this, paramaywc);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, paramaywc.toString());
    }
    return null;
  }
  
  public aywj a(aywc paramaywc)
  {
    paramaywc.jdField_a_of_type_Boolean = false;
    paramaywc.jdField_a_of_type_Aywj = new aywj();
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (paramaywc.b == 131076)
      {
        localObject = new aywo(this, paramaywc);
        a(paramaywc, (aypb)localObject, a(paramaywc), true);
      }
    }
    for (;;)
    {
      return paramaywc.jdField_a_of_type_Aywj;
      if ((paramaywc.jdField_a_of_type_Int == 1) || (paramaywc.jdField_a_of_type_Int == 3000))
      {
        localObject = new ayre(this, paramaywc);
        break;
      }
      localObject = new aypk(this, paramaywc);
      break;
      localObject = paramaywc.jdField_a_of_type_Aywj;
      ((aywj)localObject).jdField_a_of_type_Int = -1;
      ((aywj)localObject).jdField_a_of_type_Long = 9366L;
      ((aywj)localObject).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public bbmw a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (bbmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public bbmw a(String paramString1, String paramString2, long paramLong)
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
      bbmw localbbmw = a(paramString2, paramLong1);
      if ((localbbmw instanceof ayqr)) {
        ((ayqr)localbbmw).a();
      }
    }
    paramString1 = new ayqr(paramLong1, paramString1, paramQQAppInterface, paramInt1, paramString2, paramString3, paramString4, paramString5, paramLong2, paramInt2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ptt_reserve.ReserveStruct paramReserveStruct)
  {
    Object localObject2 = axug.a(paramStreamInfo.iMsgId, 1);
    long l1 = paramStreamInfo.lFromUIN;
    long l2 = paramStreamInfo.lToUIN;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = ayph.a(String.valueOf(l2), null, 2, null);
      int i = bbbr.a(paramStreamInfo.pttFormat);
      localObject2 = MessageForPtt.getLocalFilePath(i, (String)localObject1);
      axug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject2, 1, paramStreamInfo.iMsgId);
      axug.a((String)localObject2, (short)paramStreamInfo.msgSeq);
      axug.b((String)localObject2, paramStreamInfo.random);
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
          localObject = (asuw)((QQAppInterface)localObject).getManager(324);
        } while (!((asuw)localObject).a(paramChatMessage));
        ((asuw)localObject).b(paramChatMessage, 0L, 0, 256);
        return;
      } while (!(paramChatMessage instanceof MessageForPic));
      paramChatMessage = (MessageForPic)paramChatMessage;
      a(paramChatMessage, 131075);
      a(paramChatMessage, 1);
      a(paramChatMessage, 131075);
      localObject = (asuw)((QQAppInterface)localObject).getManager(324);
    } while (!((asuw)localObject).a(paramChatMessage));
    ((asuw)localObject).b(paramChatMessage, 0L, 0, 24);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    paramMessageForPic = a(a(paramMessageForPic.md5, paramMessageForPic.uuid, paramInt));
    if ((paramMessageForPic != null) && ((paramMessageForPic instanceof aypb))) {
      ((aypb)paramMessageForPic).a();
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
        Object localObject = (bbmw)((Map.Entry)localIterator.next()).getValue();
        if (a((bbmw)localObject))
        {
          localObject = (aypb)localObject;
          if ((paramString.equals(((aypb)localObject).a.jdField_c_of_type_JavaLangString)) && (((aypb)localObject).k))
          {
            ((aypb)localObject).b();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "resume pic:" + ((aypb)localObject).a.jdField_a_of_type_Long);
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
      bbmw localbbmw = (bbmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        if (((localbbmw instanceof ayph)) && (paramString.equals(((ayph)localbbmw).a.p)))
        {
          ((aypb)localbbmw).j();
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
        Object localObject = (bbmw)((Map.Entry)localIterator.next()).getValue();
        if (a((bbmw)localObject))
        {
          localObject = (aypb)localObject;
          if ((paramString.equals(((aypb)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((aypb)localObject).a.jdField_a_of_type_Long))
          {
            ((aypb)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((aypb)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, aywa paramaywa)
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
        Object localObject = (bbmw)((Map.Entry)localIterator.next()).getValue();
        if (a((bbmw)localObject))
        {
          localObject = (aypb)localObject;
          if ((paramString.equals(((aypb)localObject).a.jdField_c_of_type_JavaLangString)) && (((aypb)localObject).d()))
          {
            ((aypb)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((aypb)localObject).a.jdField_a_of_type_Long);
            }
            if (((aypb)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              localArrayList.add(((aypb)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          }
        }
      }
    } while (paramaywa == null);
    paramaywa.a(localArrayList);
  }
  
  public void a(String paramString, bbmw parambbmw)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambbmw);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bbmw)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof aypb))) {
        break label171;
      }
      localObject = (aypb)localObject;
      if ((!((aypb)localObject).m) || (((aypb)localObject).k)) {
        break label171;
      }
      ((aypb)localObject).c();
      if (((aypb)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((aypb)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend key:" + ((aypb)localObject).a());
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
      Object localObject = (bbmw)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof aypg))) {
        break label175;
      }
      localObject = (aypg)localObject;
      if ((((aypg)localObject).a == null) || (!((aypg)localObject).a.i)) {
        break label175;
      }
      ((aypg)localObject).u = paramLong;
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
  
  public boolean a(aywc paramaywc)
  {
    try
    {
      boolean bool = super.a(paramaywc);
      return bool;
    }
    finally
    {
      paramaywc = finally;
      throw paramaywc;
    }
  }
  
  public boolean a(aywc paramaywc, MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = a(paramaywc);
      return bool;
    }
    finally
    {
      paramaywc = finally;
      throw paramaywc;
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
    //   22: getfield 147	ayvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +31 -> 60
    //   32: aload_0
    //   33: getfield 147	ayvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: aload_1
    //   37: invokevirtual 151	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 334	ayut
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 684	ayut:c	()V
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
    //   0	71	0	this	ayvx
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
        ayph localayph = new ayph(paramString1, paramString2, false, null, null, 2, -1, false, this, paramLong1);
        localayph.a(paramLong1);
        localayph.a().jdField_c_of_type_JavaLangString = paramString2;
        localayph.c(paramString1 + paramString2 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramString2 + paramLong1, localayph);
        localayph.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (ayph)a(paramString1 + paramString2 + paramLong1);
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
        paramString2 = new ayph(paramString1, paramString2, true, null, null, 2, -1, false, this, paramLong1);
        paramString2.a(paramLong1);
        paramString2.f();
        paramString2.c(paramString1 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramLong1, paramString2);
        paramString2.a(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (ayph)a(paramString1, paramString2, paramLong1);
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
      paramString1 = (bbmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof aypb)) {
        return (int)((aypb)paramString1).c();
      }
    }
    return -1;
  }
  
  public aywj b(aywc paramaywc)
  {
    paramaywc.jdField_a_of_type_Boolean = false;
    paramaywc.jdField_a_of_type_Aywj = new aywj();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        Object localObject1;
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
        {
          localObject1 = paramaywc.jdField_a_of_type_Aywj;
          ((aywj)localObject1).jdField_a_of_type_Int = -1;
          ((aywj)localObject1).jdField_a_of_type_Long = 9366L;
          ((aywj)localObject1).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          paramaywc = paramaywc.jdField_a_of_type_Aywj;
          return paramaywc;
        }
        try
        {
          if (paramaywc.b == 131076)
          {
            localObject1 = new aywo(this, paramaywc);
            a(paramaywc, (aypb)localObject1, a(paramaywc), false);
            return paramaywc.jdField_a_of_type_Aywj;
          }
          if ((paramaywc.jdField_a_of_type_Int == 1) || (paramaywc.jdField_a_of_type_Int == 3000))
          {
            localObject1 = new ayre(this, paramaywc);
            continue;
            paramaywc = finally;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          localObject2 = paramaywc.jdField_a_of_type_Aywj;
          ((aywj)localObject2).jdField_a_of_type_Int = -1;
          ((aywj)localObject2).jdField_a_of_type_Long = 9366L;
          ((aywj)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          paramaywc = paramaywc.jdField_a_of_type_Aywj;
          return paramaywc;
        }
      }
      Object localObject2 = new aypk(this, paramaywc);
      continue;
      localObject2 = paramaywc.jdField_a_of_type_Aywj;
      ((aywj)localObject2).jdField_a_of_type_Int = -1;
      ((aywj)localObject2).jdField_a_of_type_Long = 9366L;
      ((aywj)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
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
        Object localObject = (bbmw)((Map.Entry)localIterator.next()).getValue();
        if (c((bbmw)localObject))
        {
          localObject = (aypb)localObject;
          if ((paramString.equals(((aypb)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((aypb)localObject).a.jdField_a_of_type_Long))
          {
            ((aypb)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel JSPTT:" + ((aypb)localObject).a.jdField_a_of_type_Long);
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
      Object localObject = (bbmw)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof aypb))) {
        break label211;
      }
      localObject = (aypb)localObject;
      if ((!((aypb)localObject).n) || (((aypb)localObject).k)) {
        break label211;
      }
      ((aypb)localObject).c();
      if (((aypb)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((aypb)localObject).a());
      }
      localStringBuilder.append(((aypb)localObject).a());
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
    if ((paramString != null) && ((paramString instanceof aypb)))
    {
      paramString = (aypb)paramString;
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
    //   25: getfield 147	ayvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +36 -> 68
    //   35: aload_0
    //   36: getfield 147	ayvx:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_1
    //   40: invokevirtual 151	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 153	bbmw
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
    //   81: checkcast 315	ayuw
    //   84: invokevirtual 738	ayuw:c	()V
    //   87: goto -22 -> 65
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	ayvx
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
      paramString2 = (ayph)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
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
      Object localObject = (bbmw)((Map.Entry)localIterator.next()).getValue();
      if (b((bbmw)localObject))
      {
        ThreadManager.getSubThreadHandler().removeCallbacks((StructLongMessageDownloadProcessor)localObject);
        localObject = (aypb)localObject;
        if ((paramString.equals(((aypb)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((aypb)localObject).a.jdField_a_of_type_Long))
        {
          ((aypb)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("cancelpic", 2, "cancel PALongMsg:" + ((aypb)localObject).a.jdField_a_of_type_Long);
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
      Object localObject = (bbmw)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof aypb))) {
        break label178;
      }
      localObject = (aypb)localObject;
      if ((!((aypb)localObject).l) || (((aypb)localObject).k)) {
        break label178;
      }
      ((aypb)localObject).c();
      if (((aypb)localObject).a() != null) {
        this.jdField_b_of_type_JavaUtilArrayList.add(((aypb)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend key:" + ((aypb)localObject).a());
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
      Object localObject = (bbmw)((Map.Entry)localIterator.next()).getValue();
      bool1 = bool2;
      if (a((bbmw)localObject))
      {
        localObject = (aypb)localObject;
        bool1 = bool2;
        if (paramString.equals(((aypb)localObject).a.jdField_c_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (!((aypb)localObject).k)
          {
            ((aypb)localObject).c();
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("cancelpic", 2, "pause pic:" + ((aypb)localObject).a.jdField_a_of_type_Long);
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
          paramString = (bbmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
      paramString2 = (ayph)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
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
      if ((localObject != null) && ((localObject instanceof aypb)))
      {
        localObject = (aypb)localObject;
        if (((aypb)localObject).k)
        {
          ((aypb)localObject).b();
          localStringBuilder.append(((aypb)localObject).a());
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
        Object localObject = (bbmw)((Map.Entry)localIterator.next()).getValue();
        if (d((bbmw)localObject))
        {
          localObject = (aypb)localObject;
          if ((paramString.equals(((aypb)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((aypb)localObject).a.jdField_a_of_type_Long))
          {
            ((aypb)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "PttSliceUploadProcessor cancelVoiceTextTask:" + ((aypb)localObject).a.jdField_a_of_type_Long);
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
        bbmw localbbmw = (bbmw)((Map.Entry)localIterator.next()).getValue();
        if ((!a(localbbmw)) || (!paramString.equals(((aypb)localbbmw).a.jdField_c_of_type_JavaLangString))) {
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
          bbmw localbbmw = (bbmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (localbbmw != null)
          {
            if ((localbbmw instanceof ShortVideoUploadProcessor)) {
              ((ShortVideoUploadProcessor)localbbmw).c();
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
            bool = true;
            return bool;
          }
          if (!(localbbmw instanceof ayuw)) {
            continue;
          }
          ((ayuw)localbbmw).c();
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
      bbmw localbbmw = (bbmw)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localbbmw instanceof ayut))
      {
        ((ayut)localbbmw).c();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayvx
 * JD-Core Version:    0.7.0.1
 */