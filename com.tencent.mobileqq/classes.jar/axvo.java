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

public class axvo
  extends axos
{
  public QQAppInterface a;
  ArrayList<String> a;
  ArrayList<String> b;
  public ConcurrentHashMap<String, byte[]> b;
  
  public axvo(QQAppInterface paramQQAppInterface)
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
  
  public static String a(axvt paramaxvt)
  {
    return a(paramaxvt.f, paramaxvt.jdField_e_of_type_JavaLangString, paramaxvt.b);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1))) {
      return paramString1 + "_" + paramInt;
    }
    return paramString2 + "_" + paramInt;
  }
  
  private void a(axvt paramaxvt, axou paramaxou)
  {
    try
    {
      if (paramaxvt.jdField_a_of_type_Axwa.jdField_a_of_type_Int == -2)
      {
        axub.a(paramaxvt.jdField_a_of_type_Int, paramaxvt.jdField_a_of_type_Boolean, paramaxvt.b, String.valueOf(paramaxvt.jdField_a_of_type_Long), "callwait", "");
        paramaxou.wait();
        axub.a(paramaxvt.jdField_a_of_type_Int, paramaxvt.jdField_a_of_type_Boolean, paramaxvt.b, String.valueOf(paramaxvt.jdField_a_of_type_Long), "waitfin", "");
      }
      return;
    }
    catch (InterruptedException paramaxvt)
    {
      paramaxvt.printStackTrace();
    }
  }
  
  private void a(axvt paramaxvt, axou paramaxou, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "sync ";
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
      }
      ??? = (baky)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (??? == null) {
        break label418;
      }
      if (!(??? instanceof axoo)) {}
    }
    label418:
    do
    {
      do
      {
        long l;
        axvt localaxvt;
        do
        {
          synchronized ((axoo)???)
          {
            l = ((axoo)???).c();
            localaxvt = ((axoo)???).a();
            axub.a(paramaxvt.jdField_a_of_type_Int, paramaxvt.jdField_a_of_type_Boolean, paramaxvt.b, String.valueOf(paramaxvt.jdField_a_of_type_Long), str + "startDownloadProcessor", "status:" + l + ",key:" + paramString);
            if ((l == -1L) || (l == 2002L) || (l == 2001L))
            {
              paramaxvt.jdField_a_of_type_Axwa = localaxvt.jdField_a_of_type_Axwa;
              if (paramaxvt.jdField_a_of_type_Atpa != null) {
                ((axoo)???).jdField_b_of_type_JavaUtilArrayList.add(paramaxvt.jdField_a_of_type_Atpa);
              }
              if (paramBoolean) {
                a(paramaxvt, (axou)???);
              }
            }
            for (;;)
            {
              return;
              str = "aync ";
              break;
              if ((l == 2004L) || (l == 2005L))
              {
                if (paramaxou == null) {
                  continue;
                }
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramaxou);
                paramaxou.c(paramString);
                if (paramaxou.c() != 0) {
                  continue;
                }
                atps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaxvt);
                paramaxou.aU_();
                if (!paramBoolean) {
                  continue;
                }
                try
                {
                  axub.a(paramaxvt.jdField_a_of_type_Int, paramaxvt.jdField_a_of_type_Boolean, paramaxvt.b, String.valueOf(paramaxvt.jdField_a_of_type_Long), "callwait", "");
                  ???.wait();
                }
                catch (InterruptedException paramaxvt)
                {
                  paramaxvt.printStackTrace();
                }
              }
            }
          }
        } while (l != 2003L);
        paramaxvt.jdField_a_of_type_Axwa = localaxvt.jdField_a_of_type_Axwa;
        if (paramaxvt.jdField_a_of_type_Atpa != null)
        {
          paramaxou = new atpb();
          paramaxou.jdField_a_of_type_Int = 0;
          paramaxou.b = paramaxvt.h;
          paramaxou.jdField_c_of_type_JavaLangString = paramaxvt.f;
          paramaxou.jdField_c_of_type_Int = paramaxvt.b;
          paramaxou.d = paramaxvt.g;
          paramaxvt.jdField_a_of_type_Atpa.a(paramaxou);
        }
        return;
        axub.a(paramaxvt.jdField_a_of_type_Int, paramaxvt.jdField_a_of_type_Boolean, paramaxvt.b, String.valueOf(paramaxvt.jdField_a_of_type_Long), str + "startDownloadProcessor", "firs time ,key:" + paramString);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramaxou);
        paramaxou.c(paramString);
      } while (paramaxou.c() != 0);
      atps.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaxvt);
      paramaxou.aU_();
    } while (!paramBoolean);
    try
    {
      a(paramaxvt, paramaxou);
      return;
    }
    finally {}
  }
  
  private boolean a(baky parambaky)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambaky != null) {
      if (!(parambaky instanceof axpc))
      {
        bool1 = bool2;
        if (!(parambaky instanceof axqw)) {}
      }
      else
      {
        parambaky = (axou)parambaky;
        bool1 = bool2;
        if (parambaky.c() != 1003L)
        {
          bool1 = bool2;
          if (parambaky.d() != 1003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b(baky parambaky)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambaky != null)
    {
      bool1 = bool2;
      if ((parambaky instanceof StructLongMessageDownloadProcessor))
      {
        bool1 = bool2;
        if (((axou)parambaky).c() != 2003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean c(baky parambaky)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambaky != null) {
      if (!(parambaky instanceof axrw))
      {
        bool1 = bool2;
        if (!(parambaky instanceof axrv)) {}
      }
      else
      {
        parambaky = (axou)parambaky;
        bool1 = bool2;
        if (parambaky.c() != 1003L)
        {
          bool1 = bool2;
          if (parambaky.d() != 2003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean d(baky parambaky)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambaky != null)
    {
      bool1 = bool2;
      if ((parambaky instanceof axtf))
      {
        bool1 = bool2;
        if (((axou)parambaky).c() != 1003L) {
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
      paramString1 = (baky)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof axou)) {
        return ((axou)paramString1).f();
      }
    }
    return 0;
  }
  
  public axou a(axvt paramaxvt)
  {
    if (paramaxvt == null) {
      return null;
    }
    if (paramaxvt.b == 131078)
    {
      if (paramaxvt.jdField_a_of_type_Boolean) {
        return new axsi(this, paramaxvt);
      }
      return new axsh(this, paramaxvt);
    }
    if (paramaxvt.b == 262153)
    {
      if (paramaxvt.jdField_a_of_type_Boolean) {
        return new axue(this, paramaxvt);
      }
      return new axud(this, paramaxvt);
    }
    if (paramaxvt.b == 327689) {
      return new axrz(this, paramaxvt);
    }
    if (paramaxvt.b == 327696) {
      return new axtf(this, paramaxvt);
    }
    if (paramaxvt.b == 66) {
      return new axui(this, paramaxvt);
    }
    if ((paramaxvt.b == 52) && (paramaxvt.jdField_a_of_type_Boolean)) {
      return new axqk(this, paramaxvt);
    }
    if (paramaxvt.jdField_a_of_type_Int == 1026)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "getProcessor UIN_TYPE_HOTCHAT_TOPIC  isUp = " + paramaxvt.jdField_a_of_type_Boolean);
      }
      if (paramaxvt.jdField_a_of_type_Boolean) {
        return new axqw(this, paramaxvt);
      }
      if (paramaxvt.b == 2) {
        return new GroupPttDownloadProcessor(this, paramaxvt);
      }
      return null;
    }
    if ((paramaxvt.jdField_a_of_type_Int == 1) || (paramaxvt.jdField_a_of_type_Int == 3000))
    {
      if (paramaxvt.jdField_a_of_type_Boolean)
      {
        if ((paramaxvt.b == 6) || (paramaxvt.b == 17) || (paramaxvt.b == 9)) {
          return new ShortVideoUploadProcessor(this, paramaxvt);
        }
        if (paramaxvt.b == 20) {
          return new axun(this, paramaxvt);
        }
        if (paramaxvt.b == 55) {
          return new axwc(this, paramaxvt);
        }
        if (paramaxvt.jdField_e_of_type_Int == 1045) {
          return new axre(this, paramaxvt);
        }
        if (paramaxvt.b == 2) {
          return new axra(this, paramaxvt);
        }
        return new axqw(this, paramaxvt);
      }
      if (paramaxvt.b == 2) {
        return new GroupPttDownloadProcessor(this, paramaxvt);
      }
      if ((paramaxvt.b == 1) || (paramaxvt.b == 65537) || (paramaxvt.b == 131075)) {
        return new axqv(this, paramaxvt);
      }
      if ((paramaxvt.b == 6) || (paramaxvt.b == 7) || (paramaxvt.b == 17) || (paramaxvt.b == 18) || (paramaxvt.b == 9) || (paramaxvt.b == 16)) {
        return new axuk(this, paramaxvt);
      }
    }
    else
    {
      if (paramaxvt.jdField_a_of_type_Boolean)
      {
        if (paramaxvt.b == 2) {
          return new axpg(this, paramaxvt);
        }
        if (paramaxvt.b == 32) {
          return new axrw(this, paramaxvt);
        }
        if ((paramaxvt.b == 6) || (paramaxvt.b == 17) || (paramaxvt.b == 9)) {
          return new ShortVideoUploadProcessor(this, paramaxvt);
        }
        if ((paramaxvt.b == 8) || (paramaxvt.b == 64) || (paramaxvt.b == 22) || (paramaxvt.b == 21) || (paramaxvt.b == 34) || (paramaxvt.b == 35) || (paramaxvt.b == 36) || (paramaxvt.b == 37) || (paramaxvt.b == 38) || (paramaxvt.b == 48) || (paramaxvt.b == 23) || (paramaxvt.b == 39) || (paramaxvt.b == 40) || (paramaxvt.b == 41) || (paramaxvt.b == 50) || (paramaxvt.b == 51) || (paramaxvt.b == 56)) {
          return new axsm(this, paramaxvt);
        }
        if (paramaxvt.b == 20) {
          return new axun(this, paramaxvt);
        }
        if (paramaxvt.b == 24) {
          return new axom(this, paramaxvt);
        }
        if ((paramaxvt.b == 196609) || (paramaxvt.b == 196610) || (paramaxvt.b == 327681)) {
          return new axvg(this, paramaxvt);
        }
        if (paramaxvt.jdField_e_of_type_Int == 1045) {
          return new axpk(this, paramaxvt);
        }
        return new axpc(this, paramaxvt);
      }
      if (paramaxvt.b == 2) {
        return new C2CPttDownloadProcessor(this, paramaxvt);
      }
      if (paramaxvt.b == 32) {
        return new axrv(this, paramaxvt);
      }
      if (paramaxvt.b == 33) {
        return new axsu(this, paramaxvt);
      }
      if ((paramaxvt.b == 6) || (paramaxvt.b == 7) || (paramaxvt.b == 17) || (paramaxvt.b == 18) || (paramaxvt.b == 9) || (paramaxvt.b == 16)) {
        return new axuk(this, paramaxvt);
      }
      if ((paramaxvt.b == 1) || (paramaxvt.b == 65537) || (paramaxvt.b == 131075)) {
        return new axpb(this, paramaxvt);
      }
      if (paramaxvt.b == 131079) {
        return new StructLongMessageDownloadProcessor(this, paramaxvt);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, paramaxvt.toString());
    }
    return null;
  }
  
  public axwa a(axvt paramaxvt)
  {
    paramaxvt.jdField_a_of_type_Boolean = false;
    paramaxvt.jdField_a_of_type_Axwa = new axwa();
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (paramaxvt.b == 131076)
      {
        localObject = new axwf(this, paramaxvt);
        a(paramaxvt, (axou)localObject, a(paramaxvt), true);
      }
    }
    for (;;)
    {
      return paramaxvt.jdField_a_of_type_Axwa;
      if ((paramaxvt.jdField_a_of_type_Int == 1) || (paramaxvt.jdField_a_of_type_Int == 3000))
      {
        localObject = new axqv(this, paramaxvt);
        break;
      }
      localObject = new axpb(this, paramaxvt);
      break;
      localObject = paramaxvt.jdField_a_of_type_Axwa;
      ((axwa)localObject).jdField_a_of_type_Int = -1;
      ((axwa)localObject).jdField_a_of_type_Long = 9366L;
      ((axwa)localObject).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public baky a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (baky)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public baky a(String paramString1, String paramString2, long paramLong)
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
      baky localbaky = a(paramString2, paramLong1);
      if ((localbaky instanceof axqi)) {
        ((axqi)localbaky).a();
      }
    }
    paramString1 = new axqi(paramLong1, paramString1, paramQQAppInterface, paramInt1, paramString2, paramString3, paramString4, paramString5, paramLong2, paramInt2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ptt_reserve.ReserveStruct paramReserveStruct)
  {
    Object localObject2 = awuc.a(paramStreamInfo.iMsgId, 1);
    long l1 = paramStreamInfo.lFromUIN;
    long l2 = paramStreamInfo.lToUIN;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = axoy.a(String.valueOf(l2), null, 2, null);
      int i = azzz.a(paramStreamInfo.pttFormat);
      localObject2 = MessageForPtt.getLocalFilePath(i, (String)localObject1);
      awuc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject2, 1, paramStreamInfo.iMsgId);
      awuc.a((String)localObject2, (short)paramStreamInfo.msgSeq);
      awuc.b((String)localObject2, paramStreamInfo.random);
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
          localObject = (aryq)((QQAppInterface)localObject).getManager(324);
        } while (!((aryq)localObject).a(paramChatMessage));
        ((aryq)localObject).b(paramChatMessage, 0L, 0, 256);
        return;
      } while (!(paramChatMessage instanceof MessageForPic));
      paramChatMessage = (MessageForPic)paramChatMessage;
      a(paramChatMessage, 131075);
      a(paramChatMessage, 1);
      a(paramChatMessage, 131075);
      localObject = (aryq)((QQAppInterface)localObject).getManager(324);
    } while (!((aryq)localObject).a(paramChatMessage));
    ((aryq)localObject).b(paramChatMessage, 0L, 0, 24);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    paramMessageForPic = a(a(paramMessageForPic.md5, paramMessageForPic.uuid, paramInt));
    if ((paramMessageForPic != null) && ((paramMessageForPic instanceof axou))) {
      ((axou)paramMessageForPic).a();
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
        Object localObject = (baky)((Map.Entry)localIterator.next()).getValue();
        if (a((baky)localObject))
        {
          localObject = (axou)localObject;
          if ((paramString.equals(((axou)localObject).a.jdField_c_of_type_JavaLangString)) && (((axou)localObject).k))
          {
            ((axou)localObject).b();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "resume pic:" + ((axou)localObject).a.jdField_a_of_type_Long);
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
      baky localbaky = (baky)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        if (((localbaky instanceof axoy)) && (paramString.equals(((axoy)localbaky).a.p)))
        {
          ((axou)localbaky).j();
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
        Object localObject = (baky)((Map.Entry)localIterator.next()).getValue();
        if (a((baky)localObject))
        {
          localObject = (axou)localObject;
          if ((paramString.equals(((axou)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((axou)localObject).a.jdField_a_of_type_Long))
          {
            ((axou)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((axou)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, axvr paramaxvr)
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
        Object localObject = (baky)((Map.Entry)localIterator.next()).getValue();
        if (a((baky)localObject))
        {
          localObject = (axou)localObject;
          if ((paramString.equals(((axou)localObject).a.jdField_c_of_type_JavaLangString)) && (((axou)localObject).d()))
          {
            ((axou)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((axou)localObject).a.jdField_a_of_type_Long);
            }
            if (((axou)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              localArrayList.add(((axou)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          }
        }
      }
    } while (paramaxvr == null);
    paramaxvr.a(localArrayList);
  }
  
  public void a(String paramString, baky parambaky)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambaky);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (baky)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof axou))) {
        break label171;
      }
      localObject = (axou)localObject;
      if ((!((axou)localObject).m) || (((axou)localObject).k)) {
        break label171;
      }
      ((axou)localObject).c();
      if (((axou)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((axou)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend key:" + ((axou)localObject).a());
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
      Object localObject = (baky)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof axox))) {
        break label175;
      }
      localObject = (axox)localObject;
      if ((((axox)localObject).a == null) || (!((axox)localObject).a.i)) {
        break label175;
      }
      ((axox)localObject).u = paramLong;
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
  
  public boolean a(axvt paramaxvt)
  {
    try
    {
      boolean bool = super.a(paramaxvt);
      return bool;
    }
    finally
    {
      paramaxvt = finally;
      throw paramaxvt;
    }
  }
  
  public boolean a(axvt paramaxvt, MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = a(paramaxvt);
      return bool;
    }
    finally
    {
      paramaxvt = finally;
      throw paramaxvt;
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
    //   22: getfield 147	axvo:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +31 -> 60
    //   32: aload_0
    //   33: getfield 147	axvo:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: aload_1
    //   37: invokevirtual 151	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 334	axuk
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 684	axuk:c	()V
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
    //   0	71	0	this	axvo
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
        axoy localaxoy = new axoy(paramString1, paramString2, false, null, null, 2, -1, false, this, paramLong1);
        localaxoy.a(paramLong1);
        localaxoy.a().jdField_c_of_type_JavaLangString = paramString2;
        localaxoy.c(paramString1 + paramString2 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramString2 + paramLong1, localaxoy);
        localaxoy.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (axoy)a(paramString1 + paramString2 + paramLong1);
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
        paramString2 = new axoy(paramString1, paramString2, true, null, null, 2, -1, false, this, paramLong1);
        paramString2.a(paramLong1);
        paramString2.f();
        paramString2.c(paramString1 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramLong1, paramString2);
        paramString2.a(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (axoy)a(paramString1, paramString2, paramLong1);
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
      paramString1 = (baky)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof axou)) {
        return (int)((axou)paramString1).c();
      }
    }
    return -1;
  }
  
  public axwa b(axvt paramaxvt)
  {
    paramaxvt.jdField_a_of_type_Boolean = false;
    paramaxvt.jdField_a_of_type_Axwa = new axwa();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        Object localObject1;
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
        {
          localObject1 = paramaxvt.jdField_a_of_type_Axwa;
          ((axwa)localObject1).jdField_a_of_type_Int = -1;
          ((axwa)localObject1).jdField_a_of_type_Long = 9366L;
          ((axwa)localObject1).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          paramaxvt = paramaxvt.jdField_a_of_type_Axwa;
          return paramaxvt;
        }
        try
        {
          if (paramaxvt.b == 131076)
          {
            localObject1 = new axwf(this, paramaxvt);
            a(paramaxvt, (axou)localObject1, a(paramaxvt), false);
            return paramaxvt.jdField_a_of_type_Axwa;
          }
          if ((paramaxvt.jdField_a_of_type_Int == 1) || (paramaxvt.jdField_a_of_type_Int == 3000))
          {
            localObject1 = new axqv(this, paramaxvt);
            continue;
            paramaxvt = finally;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          localObject2 = paramaxvt.jdField_a_of_type_Axwa;
          ((axwa)localObject2).jdField_a_of_type_Int = -1;
          ((axwa)localObject2).jdField_a_of_type_Long = 9366L;
          ((axwa)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          paramaxvt = paramaxvt.jdField_a_of_type_Axwa;
          return paramaxvt;
        }
      }
      Object localObject2 = new axpb(this, paramaxvt);
      continue;
      localObject2 = paramaxvt.jdField_a_of_type_Axwa;
      ((axwa)localObject2).jdField_a_of_type_Int = -1;
      ((axwa)localObject2).jdField_a_of_type_Long = 9366L;
      ((axwa)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
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
        Object localObject = (baky)((Map.Entry)localIterator.next()).getValue();
        if (c((baky)localObject))
        {
          localObject = (axou)localObject;
          if ((paramString.equals(((axou)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((axou)localObject).a.jdField_a_of_type_Long))
          {
            ((axou)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel JSPTT:" + ((axou)localObject).a.jdField_a_of_type_Long);
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
      Object localObject = (baky)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof axou))) {
        break label211;
      }
      localObject = (axou)localObject;
      if ((!((axou)localObject).n) || (((axou)localObject).k)) {
        break label211;
      }
      ((axou)localObject).c();
      if (((axou)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((axou)localObject).a());
      }
      localStringBuilder.append(((axou)localObject).a());
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
    if ((paramString != null) && ((paramString instanceof axou)))
    {
      paramString = (axou)paramString;
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
    //   25: getfield 147	axvo:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +36 -> 68
    //   35: aload_0
    //   36: getfield 147	axvo:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_1
    //   40: invokevirtual 151	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 153	baky
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
    //   81: checkcast 315	axun
    //   84: invokevirtual 738	axun:c	()V
    //   87: goto -22 -> 65
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	axvo
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
      paramString2 = (axoy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
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
      Object localObject = (baky)((Map.Entry)localIterator.next()).getValue();
      if (b((baky)localObject))
      {
        ThreadManager.getSubThreadHandler().removeCallbacks((StructLongMessageDownloadProcessor)localObject);
        localObject = (axou)localObject;
        if ((paramString.equals(((axou)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((axou)localObject).a.jdField_a_of_type_Long))
        {
          ((axou)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("cancelpic", 2, "cancel PALongMsg:" + ((axou)localObject).a.jdField_a_of_type_Long);
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
      Object localObject = (baky)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof axou))) {
        break label178;
      }
      localObject = (axou)localObject;
      if ((!((axou)localObject).l) || (((axou)localObject).k)) {
        break label178;
      }
      ((axou)localObject).c();
      if (((axou)localObject).a() != null) {
        this.jdField_b_of_type_JavaUtilArrayList.add(((axou)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend key:" + ((axou)localObject).a());
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
      Object localObject = (baky)((Map.Entry)localIterator.next()).getValue();
      bool1 = bool2;
      if (a((baky)localObject))
      {
        localObject = (axou)localObject;
        bool1 = bool2;
        if (paramString.equals(((axou)localObject).a.jdField_c_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (!((axou)localObject).k)
          {
            ((axou)localObject).c();
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("cancelpic", 2, "pause pic:" + ((axou)localObject).a.jdField_a_of_type_Long);
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
          paramString = (baky)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
      paramString2 = (axoy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
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
      if ((localObject != null) && ((localObject instanceof axou)))
      {
        localObject = (axou)localObject;
        if (((axou)localObject).k)
        {
          ((axou)localObject).b();
          localStringBuilder.append(((axou)localObject).a());
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
        Object localObject = (baky)((Map.Entry)localIterator.next()).getValue();
        if (d((baky)localObject))
        {
          localObject = (axou)localObject;
          if ((paramString.equals(((axou)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((axou)localObject).a.jdField_a_of_type_Long))
          {
            ((axou)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "PttSliceUploadProcessor cancelVoiceTextTask:" + ((axou)localObject).a.jdField_a_of_type_Long);
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
        baky localbaky = (baky)((Map.Entry)localIterator.next()).getValue();
        if ((!a(localbaky)) || (!paramString.equals(((axou)localbaky).a.jdField_c_of_type_JavaLangString))) {
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
          baky localbaky = (baky)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (localbaky != null)
          {
            if ((localbaky instanceof ShortVideoUploadProcessor)) {
              ((ShortVideoUploadProcessor)localbaky).c();
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
            bool = true;
            return bool;
          }
          if (!(localbaky instanceof axun)) {
            continue;
          }
          ((axun)localbaky).c();
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
      baky localbaky = (baky)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localbaky instanceof axuk))
      {
        ((axuk)localbaky).c();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axvo
 * JD-Core Version:    0.7.0.1
 */