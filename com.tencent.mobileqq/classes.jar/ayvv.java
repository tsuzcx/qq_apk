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

public class ayvv
  extends ayox
{
  public QQAppInterface a;
  ArrayList<String> a;
  ArrayList<String> b;
  public ConcurrentHashMap<String, byte[]> b;
  
  public ayvv(QQAppInterface paramQQAppInterface)
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
  
  public static String a(aywa paramaywa)
  {
    return a(paramaywa.f, paramaywa.jdField_e_of_type_JavaLangString, paramaywa.b);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1))) {
      return paramString1 + "_" + paramInt;
    }
    return paramString2 + "_" + paramInt;
  }
  
  private void a(aywa paramaywa, ayoz paramayoz)
  {
    try
    {
      if (paramaywa.jdField_a_of_type_Aywh.jdField_a_of_type_Int == -2)
      {
        ayui.a(paramaywa.jdField_a_of_type_Int, paramaywa.jdField_a_of_type_Boolean, paramaywa.b, String.valueOf(paramaywa.jdField_a_of_type_Long), "callwait", "");
        paramayoz.wait();
        ayui.a(paramaywa.jdField_a_of_type_Int, paramaywa.jdField_a_of_type_Boolean, paramaywa.b, String.valueOf(paramaywa.jdField_a_of_type_Long), "waitfin", "");
      }
      return;
    }
    catch (InterruptedException paramaywa)
    {
      paramaywa.printStackTrace();
    }
  }
  
  private void a(aywa paramaywa, ayoz paramayoz, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "sync ";
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
      }
      ??? = (bbmi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (??? == null) {
        break label418;
      }
      if (!(??? instanceof ayou)) {}
    }
    label418:
    do
    {
      do
      {
        long l;
        aywa localaywa;
        do
        {
          synchronized ((ayou)???)
          {
            l = ((ayou)???).c();
            localaywa = ((ayou)???).a();
            ayui.a(paramaywa.jdField_a_of_type_Int, paramaywa.jdField_a_of_type_Boolean, paramaywa.b, String.valueOf(paramaywa.jdField_a_of_type_Long), str + "startDownloadProcessor", "status:" + l + ",key:" + paramString);
            if ((l == -1L) || (l == 2002L) || (l == 2001L))
            {
              paramaywa.jdField_a_of_type_Aywh = localaywa.jdField_a_of_type_Aywh;
              if (paramaywa.jdField_a_of_type_Aumy != null) {
                ((ayou)???).jdField_b_of_type_JavaUtilArrayList.add(paramaywa.jdField_a_of_type_Aumy);
              }
              if (paramBoolean) {
                a(paramaywa, (ayoz)???);
              }
            }
            for (;;)
            {
              return;
              str = "aync ";
              break;
              if ((l == 2004L) || (l == 2005L))
              {
                if (paramayoz == null) {
                  continue;
                }
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramayoz);
                paramayoz.c(paramString);
                if (paramayoz.c() != 0) {
                  continue;
                }
                aunq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaywa);
                paramayoz.aR_();
                if (!paramBoolean) {
                  continue;
                }
                try
                {
                  ayui.a(paramaywa.jdField_a_of_type_Int, paramaywa.jdField_a_of_type_Boolean, paramaywa.b, String.valueOf(paramaywa.jdField_a_of_type_Long), "callwait", "");
                  ???.wait();
                }
                catch (InterruptedException paramaywa)
                {
                  paramaywa.printStackTrace();
                }
              }
            }
          }
        } while (l != 2003L);
        paramaywa.jdField_a_of_type_Aywh = localaywa.jdField_a_of_type_Aywh;
        if (paramaywa.jdField_a_of_type_Aumy != null)
        {
          paramayoz = new aumz();
          paramayoz.jdField_a_of_type_Int = 0;
          paramayoz.b = paramaywa.h;
          paramayoz.jdField_c_of_type_JavaLangString = paramaywa.f;
          paramayoz.jdField_c_of_type_Int = paramaywa.b;
          paramayoz.d = paramaywa.g;
          paramaywa.jdField_a_of_type_Aumy.a(paramayoz);
        }
        return;
        ayui.a(paramaywa.jdField_a_of_type_Int, paramaywa.jdField_a_of_type_Boolean, paramaywa.b, String.valueOf(paramaywa.jdField_a_of_type_Long), str + "startDownloadProcessor", "firs time ,key:" + paramString);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramayoz);
        paramayoz.c(paramString);
      } while (paramayoz.c() != 0);
      aunq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaywa);
      paramayoz.aR_();
    } while (!paramBoolean);
    try
    {
      a(paramaywa, paramayoz);
      return;
    }
    finally {}
  }
  
  private boolean a(bbmi parambbmi)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambbmi != null) {
      if (!(parambbmi instanceof aypj))
      {
        bool1 = bool2;
        if (!(parambbmi instanceof ayrd)) {}
      }
      else
      {
        parambbmi = (ayoz)parambbmi;
        bool1 = bool2;
        if (parambbmi.c() != 1003L)
        {
          bool1 = bool2;
          if (parambbmi.d() != 1003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b(bbmi parambbmi)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambbmi != null)
    {
      bool1 = bool2;
      if ((parambbmi instanceof StructLongMessageDownloadProcessor))
      {
        bool1 = bool2;
        if (((ayoz)parambbmi).c() != 2003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean c(bbmi parambbmi)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambbmi != null) {
      if (!(parambbmi instanceof aysd))
      {
        bool1 = bool2;
        if (!(parambbmi instanceof aysc)) {}
      }
      else
      {
        parambbmi = (ayoz)parambbmi;
        bool1 = bool2;
        if (parambbmi.c() != 1003L)
        {
          bool1 = bool2;
          if (parambbmi.d() != 2003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean d(bbmi parambbmi)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambbmi != null)
    {
      bool1 = bool2;
      if ((parambbmi instanceof aytm))
      {
        bool1 = bool2;
        if (((ayoz)parambbmi).c() != 1003L) {
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
      paramString1 = (bbmi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof ayoz)) {
        return ((ayoz)paramString1).f();
      }
    }
    return 0;
  }
  
  public ayoz a(aywa paramaywa)
  {
    if (paramaywa == null) {
      return null;
    }
    if (paramaywa.b == 131078)
    {
      if (paramaywa.jdField_a_of_type_Boolean) {
        return new aysp(this, paramaywa);
      }
      return new ayso(this, paramaywa);
    }
    if (paramaywa.b == 262153)
    {
      if (paramaywa.jdField_a_of_type_Boolean) {
        return new ayul(this, paramaywa);
      }
      return new ayuk(this, paramaywa);
    }
    if (paramaywa.b == 327689) {
      return new aysg(this, paramaywa);
    }
    if (paramaywa.b == 327696) {
      return new aytm(this, paramaywa);
    }
    if (paramaywa.b == 66) {
      return new ayup(this, paramaywa);
    }
    if ((paramaywa.b == 52) && (paramaywa.jdField_a_of_type_Boolean)) {
      return new ayqr(this, paramaywa);
    }
    if (paramaywa.jdField_a_of_type_Int == 1026)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "getProcessor UIN_TYPE_HOTCHAT_TOPIC  isUp = " + paramaywa.jdField_a_of_type_Boolean);
      }
      if (paramaywa.jdField_a_of_type_Boolean) {
        return new ayrd(this, paramaywa);
      }
      if (paramaywa.b == 2) {
        return new GroupPttDownloadProcessor(this, paramaywa);
      }
      return null;
    }
    if ((paramaywa.jdField_a_of_type_Int == 1) || (paramaywa.jdField_a_of_type_Int == 3000))
    {
      if (paramaywa.jdField_a_of_type_Boolean)
      {
        if ((paramaywa.b == 6) || (paramaywa.b == 17) || (paramaywa.b == 9)) {
          return new ShortVideoUploadProcessor(this, paramaywa);
        }
        if (paramaywa.b == 20) {
          return new ayuu(this, paramaywa);
        }
        if (paramaywa.b == 55) {
          return new aywj(this, paramaywa);
        }
        if (paramaywa.jdField_e_of_type_Int == 1045) {
          return new ayrl(this, paramaywa);
        }
        if (paramaywa.b == 2) {
          return new ayrh(this, paramaywa);
        }
        return new ayrd(this, paramaywa);
      }
      if (paramaywa.b == 2) {
        return new GroupPttDownloadProcessor(this, paramaywa);
      }
      if ((paramaywa.b == 1) || (paramaywa.b == 65537) || (paramaywa.b == 131075)) {
        return new ayrc(this, paramaywa);
      }
      if ((paramaywa.b == 6) || (paramaywa.b == 7) || (paramaywa.b == 17) || (paramaywa.b == 18) || (paramaywa.b == 9) || (paramaywa.b == 16)) {
        return new ayur(this, paramaywa);
      }
    }
    else
    {
      if (paramaywa.jdField_a_of_type_Boolean)
      {
        if (paramaywa.b == 2) {
          return new aypn(this, paramaywa);
        }
        if (paramaywa.b == 32) {
          return new aysd(this, paramaywa);
        }
        if ((paramaywa.b == 6) || (paramaywa.b == 17) || (paramaywa.b == 9)) {
          return new ShortVideoUploadProcessor(this, paramaywa);
        }
        if ((paramaywa.b == 8) || (paramaywa.b == 64) || (paramaywa.b == 22) || (paramaywa.b == 21) || (paramaywa.b == 34) || (paramaywa.b == 35) || (paramaywa.b == 36) || (paramaywa.b == 37) || (paramaywa.b == 38) || (paramaywa.b == 48) || (paramaywa.b == 23) || (paramaywa.b == 39) || (paramaywa.b == 40) || (paramaywa.b == 41) || (paramaywa.b == 50) || (paramaywa.b == 51) || (paramaywa.b == 56)) {
          return new ayst(this, paramaywa);
        }
        if (paramaywa.b == 20) {
          return new ayuu(this, paramaywa);
        }
        if (paramaywa.b == 24) {
          return new ayos(this, paramaywa);
        }
        if ((paramaywa.b == 196609) || (paramaywa.b == 196610) || (paramaywa.b == 327681)) {
          return new ayvn(this, paramaywa);
        }
        if (paramaywa.jdField_e_of_type_Int == 1045) {
          return new aypr(this, paramaywa);
        }
        return new aypj(this, paramaywa);
      }
      if (paramaywa.b == 2) {
        return new C2CPttDownloadProcessor(this, paramaywa);
      }
      if (paramaywa.b == 32) {
        return new aysc(this, paramaywa);
      }
      if (paramaywa.b == 33) {
        return new aytb(this, paramaywa);
      }
      if ((paramaywa.b == 6) || (paramaywa.b == 7) || (paramaywa.b == 17) || (paramaywa.b == 18) || (paramaywa.b == 9) || (paramaywa.b == 16)) {
        return new ayur(this, paramaywa);
      }
      if ((paramaywa.b == 1) || (paramaywa.b == 65537) || (paramaywa.b == 131075)) {
        return new aypi(this, paramaywa);
      }
      if (paramaywa.b == 131079) {
        return new StructLongMessageDownloadProcessor(this, paramaywa);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, paramaywa.toString());
    }
    return null;
  }
  
  public aywh a(aywa paramaywa)
  {
    paramaywa.jdField_a_of_type_Boolean = false;
    paramaywa.jdField_a_of_type_Aywh = new aywh();
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (paramaywa.b == 131076)
      {
        localObject = new aywm(this, paramaywa);
        a(paramaywa, (ayoz)localObject, a(paramaywa), true);
      }
    }
    for (;;)
    {
      return paramaywa.jdField_a_of_type_Aywh;
      if ((paramaywa.jdField_a_of_type_Int == 1) || (paramaywa.jdField_a_of_type_Int == 3000))
      {
        localObject = new ayrc(this, paramaywa);
        break;
      }
      localObject = new aypi(this, paramaywa);
      break;
      localObject = paramaywa.jdField_a_of_type_Aywh;
      ((aywh)localObject).jdField_a_of_type_Int = -1;
      ((aywh)localObject).jdField_a_of_type_Long = 9366L;
      ((aywh)localObject).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public bbmi a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (bbmi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public bbmi a(String paramString1, String paramString2, long paramLong)
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
      bbmi localbbmi = a(paramString2, paramLong1);
      if ((localbbmi instanceof ayqp)) {
        ((ayqp)localbbmi).a();
      }
    }
    paramString1 = new ayqp(paramLong1, paramString1, paramQQAppInterface, paramInt1, paramString2, paramString3, paramString4, paramString5, paramLong2, paramInt2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ptt_reserve.ReserveStruct paramReserveStruct)
  {
    Object localObject2 = axue.a(paramStreamInfo.iMsgId, 1);
    long l1 = paramStreamInfo.lFromUIN;
    long l2 = paramStreamInfo.lToUIN;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = aypf.a(String.valueOf(l2), null, 2, null);
      int i = bbbd.a(paramStreamInfo.pttFormat);
      localObject2 = MessageForPtt.getLocalFilePath(i, (String)localObject1);
      axue.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject2, 1, paramStreamInfo.iMsgId);
      axue.a((String)localObject2, (short)paramStreamInfo.msgSeq);
      axue.b((String)localObject2, paramStreamInfo.random);
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
          localObject = (asuu)((QQAppInterface)localObject).getManager(324);
        } while (!((asuu)localObject).a(paramChatMessage));
        ((asuu)localObject).b(paramChatMessage, 0L, 0, 256);
        return;
      } while (!(paramChatMessage instanceof MessageForPic));
      paramChatMessage = (MessageForPic)paramChatMessage;
      a(paramChatMessage, 131075);
      a(paramChatMessage, 1);
      a(paramChatMessage, 131075);
      localObject = (asuu)((QQAppInterface)localObject).getManager(324);
    } while (!((asuu)localObject).a(paramChatMessage));
    ((asuu)localObject).b(paramChatMessage, 0L, 0, 24);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    paramMessageForPic = a(a(paramMessageForPic.md5, paramMessageForPic.uuid, paramInt));
    if ((paramMessageForPic != null) && ((paramMessageForPic instanceof ayoz))) {
      ((ayoz)paramMessageForPic).a();
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
        Object localObject = (bbmi)((Map.Entry)localIterator.next()).getValue();
        if (a((bbmi)localObject))
        {
          localObject = (ayoz)localObject;
          if ((paramString.equals(((ayoz)localObject).a.jdField_c_of_type_JavaLangString)) && (((ayoz)localObject).k))
          {
            ((ayoz)localObject).b();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "resume pic:" + ((ayoz)localObject).a.jdField_a_of_type_Long);
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
      bbmi localbbmi = (bbmi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        if (((localbbmi instanceof aypf)) && (paramString.equals(((aypf)localbbmi).a.p)))
        {
          ((ayoz)localbbmi).j();
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
        Object localObject = (bbmi)((Map.Entry)localIterator.next()).getValue();
        if (a((bbmi)localObject))
        {
          localObject = (ayoz)localObject;
          if ((paramString.equals(((ayoz)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((ayoz)localObject).a.jdField_a_of_type_Long))
          {
            ((ayoz)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((ayoz)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, ayvy paramayvy)
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
        Object localObject = (bbmi)((Map.Entry)localIterator.next()).getValue();
        if (a((bbmi)localObject))
        {
          localObject = (ayoz)localObject;
          if ((paramString.equals(((ayoz)localObject).a.jdField_c_of_type_JavaLangString)) && (((ayoz)localObject).d()))
          {
            ((ayoz)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((ayoz)localObject).a.jdField_a_of_type_Long);
            }
            if (((ayoz)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              localArrayList.add(((ayoz)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          }
        }
      }
    } while (paramayvy == null);
    paramayvy.a(localArrayList);
  }
  
  public void a(String paramString, bbmi parambbmi)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambbmi);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bbmi)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof ayoz))) {
        break label171;
      }
      localObject = (ayoz)localObject;
      if ((!((ayoz)localObject).m) || (((ayoz)localObject).k)) {
        break label171;
      }
      ((ayoz)localObject).c();
      if (((ayoz)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((ayoz)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend key:" + ((ayoz)localObject).a());
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
      Object localObject = (bbmi)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof aype))) {
        break label175;
      }
      localObject = (aype)localObject;
      if ((((aype)localObject).a == null) || (!((aype)localObject).a.i)) {
        break label175;
      }
      ((aype)localObject).u = paramLong;
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
  
  public boolean a(aywa paramaywa)
  {
    try
    {
      boolean bool = super.a(paramaywa);
      return bool;
    }
    finally
    {
      paramaywa = finally;
      throw paramaywa;
    }
  }
  
  public boolean a(aywa paramaywa, MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = a(paramaywa);
      return bool;
    }
    finally
    {
      paramaywa = finally;
      throw paramaywa;
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
    //   22: getfield 147	ayvv:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +31 -> 60
    //   32: aload_0
    //   33: getfield 147	ayvv:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: aload_1
    //   37: invokevirtual 151	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 334	ayur
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 684	ayur:c	()V
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
    //   0	71	0	this	ayvv
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
        aypf localaypf = new aypf(paramString1, paramString2, false, null, null, 2, -1, false, this, paramLong1);
        localaypf.a(paramLong1);
        localaypf.a().jdField_c_of_type_JavaLangString = paramString2;
        localaypf.c(paramString1 + paramString2 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramString2 + paramLong1, localaypf);
        localaypf.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (aypf)a(paramString1 + paramString2 + paramLong1);
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
        paramString2 = new aypf(paramString1, paramString2, true, null, null, 2, -1, false, this, paramLong1);
        paramString2.a(paramLong1);
        paramString2.f();
        paramString2.c(paramString1 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramLong1, paramString2);
        paramString2.a(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (aypf)a(paramString1, paramString2, paramLong1);
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
      paramString1 = (bbmi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof ayoz)) {
        return (int)((ayoz)paramString1).c();
      }
    }
    return -1;
  }
  
  public aywh b(aywa paramaywa)
  {
    paramaywa.jdField_a_of_type_Boolean = false;
    paramaywa.jdField_a_of_type_Aywh = new aywh();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        Object localObject1;
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
        {
          localObject1 = paramaywa.jdField_a_of_type_Aywh;
          ((aywh)localObject1).jdField_a_of_type_Int = -1;
          ((aywh)localObject1).jdField_a_of_type_Long = 9366L;
          ((aywh)localObject1).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          paramaywa = paramaywa.jdField_a_of_type_Aywh;
          return paramaywa;
        }
        try
        {
          if (paramaywa.b == 131076)
          {
            localObject1 = new aywm(this, paramaywa);
            a(paramaywa, (ayoz)localObject1, a(paramaywa), false);
            return paramaywa.jdField_a_of_type_Aywh;
          }
          if ((paramaywa.jdField_a_of_type_Int == 1) || (paramaywa.jdField_a_of_type_Int == 3000))
          {
            localObject1 = new ayrc(this, paramaywa);
            continue;
            paramaywa = finally;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          localObject2 = paramaywa.jdField_a_of_type_Aywh;
          ((aywh)localObject2).jdField_a_of_type_Int = -1;
          ((aywh)localObject2).jdField_a_of_type_Long = 9366L;
          ((aywh)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          paramaywa = paramaywa.jdField_a_of_type_Aywh;
          return paramaywa;
        }
      }
      Object localObject2 = new aypi(this, paramaywa);
      continue;
      localObject2 = paramaywa.jdField_a_of_type_Aywh;
      ((aywh)localObject2).jdField_a_of_type_Int = -1;
      ((aywh)localObject2).jdField_a_of_type_Long = 9366L;
      ((aywh)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
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
        Object localObject = (bbmi)((Map.Entry)localIterator.next()).getValue();
        if (c((bbmi)localObject))
        {
          localObject = (ayoz)localObject;
          if ((paramString.equals(((ayoz)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((ayoz)localObject).a.jdField_a_of_type_Long))
          {
            ((ayoz)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel JSPTT:" + ((ayoz)localObject).a.jdField_a_of_type_Long);
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
      Object localObject = (bbmi)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof ayoz))) {
        break label211;
      }
      localObject = (ayoz)localObject;
      if ((!((ayoz)localObject).n) || (((ayoz)localObject).k)) {
        break label211;
      }
      ((ayoz)localObject).c();
      if (((ayoz)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((ayoz)localObject).a());
      }
      localStringBuilder.append(((ayoz)localObject).a());
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
    if ((paramString != null) && ((paramString instanceof ayoz)))
    {
      paramString = (ayoz)paramString;
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
    //   25: getfield 147	ayvv:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +36 -> 68
    //   35: aload_0
    //   36: getfield 147	ayvv:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_1
    //   40: invokevirtual 151	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 153	bbmi
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
    //   81: checkcast 315	ayuu
    //   84: invokevirtual 738	ayuu:c	()V
    //   87: goto -22 -> 65
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	ayvv
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
      paramString2 = (aypf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
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
      Object localObject = (bbmi)((Map.Entry)localIterator.next()).getValue();
      if (b((bbmi)localObject))
      {
        ThreadManager.getSubThreadHandler().removeCallbacks((StructLongMessageDownloadProcessor)localObject);
        localObject = (ayoz)localObject;
        if ((paramString.equals(((ayoz)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((ayoz)localObject).a.jdField_a_of_type_Long))
        {
          ((ayoz)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("cancelpic", 2, "cancel PALongMsg:" + ((ayoz)localObject).a.jdField_a_of_type_Long);
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
      Object localObject = (bbmi)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof ayoz))) {
        break label178;
      }
      localObject = (ayoz)localObject;
      if ((!((ayoz)localObject).l) || (((ayoz)localObject).k)) {
        break label178;
      }
      ((ayoz)localObject).c();
      if (((ayoz)localObject).a() != null) {
        this.jdField_b_of_type_JavaUtilArrayList.add(((ayoz)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend key:" + ((ayoz)localObject).a());
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
      Object localObject = (bbmi)((Map.Entry)localIterator.next()).getValue();
      bool1 = bool2;
      if (a((bbmi)localObject))
      {
        localObject = (ayoz)localObject;
        bool1 = bool2;
        if (paramString.equals(((ayoz)localObject).a.jdField_c_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (!((ayoz)localObject).k)
          {
            ((ayoz)localObject).c();
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("cancelpic", 2, "pause pic:" + ((ayoz)localObject).a.jdField_a_of_type_Long);
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
          paramString = (bbmi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
      paramString2 = (aypf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
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
      if ((localObject != null) && ((localObject instanceof ayoz)))
      {
        localObject = (ayoz)localObject;
        if (((ayoz)localObject).k)
        {
          ((ayoz)localObject).b();
          localStringBuilder.append(((ayoz)localObject).a());
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
        Object localObject = (bbmi)((Map.Entry)localIterator.next()).getValue();
        if (d((bbmi)localObject))
        {
          localObject = (ayoz)localObject;
          if ((paramString.equals(((ayoz)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((ayoz)localObject).a.jdField_a_of_type_Long))
          {
            ((ayoz)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "PttSliceUploadProcessor cancelVoiceTextTask:" + ((ayoz)localObject).a.jdField_a_of_type_Long);
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
        bbmi localbbmi = (bbmi)((Map.Entry)localIterator.next()).getValue();
        if ((!a(localbbmi)) || (!paramString.equals(((ayoz)localbbmi).a.jdField_c_of_type_JavaLangString))) {
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
          bbmi localbbmi = (bbmi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (localbbmi != null)
          {
            if ((localbbmi instanceof ShortVideoUploadProcessor)) {
              ((ShortVideoUploadProcessor)localbbmi).c();
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
            bool = true;
            return bool;
          }
          if (!(localbbmi instanceof ayuu)) {
            continue;
          }
          ((ayuu)localbbmi).c();
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
      bbmi localbbmi = (bbmi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localbbmi instanceof ayur))
      {
        ((ayur)localbbmi).c();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     ayvv
 * JD-Core Version:    0.7.0.1
 */