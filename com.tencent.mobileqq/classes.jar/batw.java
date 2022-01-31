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

public class batw
  extends bamu
{
  public QQAppInterface a;
  ArrayList<String> a;
  ArrayList<String> b;
  public ConcurrentHashMap<String, byte[]> b;
  
  public batw(QQAppInterface paramQQAppInterface)
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
  
  public static String a(baub parambaub)
  {
    return a(parambaub.f, parambaub.jdField_e_of_type_JavaLangString, parambaub.b);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1))) {
      return paramString1 + "_" + paramInt;
    }
    return paramString2 + "_" + paramInt;
  }
  
  private void a(baub parambaub, bamw parambamw)
  {
    try
    {
      if (parambaub.jdField_a_of_type_Baui.jdField_a_of_type_Int == -2)
      {
        basj.a(parambaub.jdField_a_of_type_Int, parambaub.jdField_a_of_type_Boolean, parambaub.b, String.valueOf(parambaub.jdField_a_of_type_Long), "callwait", "");
        parambamw.wait();
        basj.a(parambaub.jdField_a_of_type_Int, parambaub.jdField_a_of_type_Boolean, parambaub.b, String.valueOf(parambaub.jdField_a_of_type_Long), "waitfin", "");
      }
      return;
    }
    catch (InterruptedException parambaub)
    {
      parambaub.printStackTrace();
    }
  }
  
  private void a(baub parambaub, bamw parambamw, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "sync ";
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
      }
      ??? = (bdlq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (??? == null) {
        break label418;
      }
      if (!(??? instanceof bamr)) {}
    }
    label418:
    do
    {
      do
      {
        long l;
        baub localbaub;
        do
        {
          synchronized ((bamr)???)
          {
            l = ((bamr)???).c();
            localbaub = ((bamr)???).a();
            basj.a(parambaub.jdField_a_of_type_Int, parambaub.jdField_a_of_type_Boolean, parambaub.b, String.valueOf(parambaub.jdField_a_of_type_Long), str + "startDownloadProcessor", "status:" + l + ",key:" + paramString);
            if ((l == -1L) || (l == 2002L) || (l == 2001L))
            {
              parambaub.jdField_a_of_type_Baui = localbaub.jdField_a_of_type_Baui;
              if (parambaub.jdField_a_of_type_Aweh != null) {
                ((bamr)???).jdField_b_of_type_JavaUtilArrayList.add(parambaub.jdField_a_of_type_Aweh);
              }
              if (paramBoolean) {
                a(parambaub, (bamw)???);
              }
            }
            for (;;)
            {
              return;
              str = "aync ";
              break;
              if ((l == 2004L) || (l == 2005L))
              {
                if (parambamw == null) {
                  continue;
                }
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambamw);
                parambamw.c(paramString);
                if (parambamw.c() != 0) {
                  continue;
                }
                awez.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambaub);
                parambamw.aS_();
                if (!paramBoolean) {
                  continue;
                }
                try
                {
                  basj.a(parambaub.jdField_a_of_type_Int, parambaub.jdField_a_of_type_Boolean, parambaub.b, String.valueOf(parambaub.jdField_a_of_type_Long), "callwait", "");
                  ???.wait();
                }
                catch (InterruptedException parambaub)
                {
                  parambaub.printStackTrace();
                }
              }
            }
          }
        } while (l != 2003L);
        parambaub.jdField_a_of_type_Baui = localbaub.jdField_a_of_type_Baui;
        if (parambaub.jdField_a_of_type_Aweh != null)
        {
          parambamw = new awei();
          parambamw.jdField_a_of_type_Int = 0;
          parambamw.b = parambaub.h;
          parambamw.jdField_c_of_type_JavaLangString = parambaub.f;
          parambamw.jdField_c_of_type_Int = parambaub.b;
          parambamw.d = parambaub.g;
          parambaub.jdField_a_of_type_Aweh.a(parambamw);
        }
        return;
        basj.a(parambaub.jdField_a_of_type_Int, parambaub.jdField_a_of_type_Boolean, parambaub.b, String.valueOf(parambaub.jdField_a_of_type_Long), str + "startDownloadProcessor", "firs time ,key:" + paramString);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambamw);
        parambamw.c(paramString);
      } while (parambamw.c() != 0);
      awez.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambaub);
      parambamw.aS_();
    } while (!paramBoolean);
    try
    {
      a(parambaub, parambamw);
      return;
    }
    finally {}
  }
  
  private boolean a(bdlq parambdlq)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambdlq != null) {
      if (!(parambdlq instanceof bang))
      {
        bool1 = bool2;
        if (!(parambdlq instanceof bapa)) {}
      }
      else
      {
        parambdlq = (bamw)parambdlq;
        bool1 = bool2;
        if (parambdlq.c() != 1003L)
        {
          bool1 = bool2;
          if (parambdlq.d() != 1003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b(bdlq parambdlq)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambdlq != null)
    {
      bool1 = bool2;
      if ((parambdlq instanceof StructLongMessageDownloadProcessor))
      {
        bool1 = bool2;
        if (((bamw)parambdlq).c() != 2003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean c(bdlq parambdlq)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambdlq != null) {
      if (!(parambdlq instanceof baqc))
      {
        bool1 = bool2;
        if (!(parambdlq instanceof baqb)) {}
      }
      else
      {
        parambdlq = (bamw)parambdlq;
        bool1 = bool2;
        if (parambdlq.c() != 1003L)
        {
          bool1 = bool2;
          if (parambdlq.d() != 2003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean d(bdlq parambdlq)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambdlq != null)
    {
      bool1 = bool2;
      if ((parambdlq instanceof barl))
      {
        bool1 = bool2;
        if (((bamw)parambdlq).c() != 1003L) {
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
      paramString1 = (bdlq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof bamw)) {
        return ((bamw)paramString1).f();
      }
    }
    return 0;
  }
  
  public bamw a(baub parambaub)
  {
    if (parambaub == null) {
      return null;
    }
    if (parambaub.b == 131078)
    {
      if (parambaub.jdField_a_of_type_Boolean) {
        return new baqo(this, parambaub);
      }
      return new baqn(this, parambaub);
    }
    if (parambaub.b == 262153)
    {
      if (parambaub.jdField_a_of_type_Boolean) {
        return new basm(this, parambaub);
      }
      return new basl(this, parambaub);
    }
    if (parambaub.b == 327689) {
      return new baqf(this, parambaub);
    }
    if (parambaub.b == 327696) {
      return new barl(this, parambaub);
    }
    if (parambaub.b == 66) {
      return new basq(this, parambaub);
    }
    if ((parambaub.b == 52) && (parambaub.jdField_a_of_type_Boolean)) {
      return new baoo(this, parambaub);
    }
    if (parambaub.jdField_a_of_type_Int == 1026)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PttShow", 2, "getProcessor UIN_TYPE_HOTCHAT_TOPIC  isUp = " + parambaub.jdField_a_of_type_Boolean);
      }
      if (parambaub.jdField_a_of_type_Boolean) {
        return new bapa(this, parambaub);
      }
      if (parambaub.b == 2) {
        return new GroupPttDownloadProcessor(this, parambaub);
      }
      return null;
    }
    if ((parambaub.jdField_a_of_type_Int == 1) || (parambaub.jdField_a_of_type_Int == 3000))
    {
      if (parambaub.jdField_a_of_type_Boolean)
      {
        if ((parambaub.b == 6) || (parambaub.b == 17) || (parambaub.b == 9)) {
          return new ShortVideoUploadProcessor(this, parambaub);
        }
        if (parambaub.b == 20) {
          return new basv(this, parambaub);
        }
        if (parambaub.b == 55) {
          return new bauk(this, parambaub);
        }
        if (parambaub.jdField_e_of_type_Int == 1045) {
          return new bapi(this, parambaub);
        }
        if (parambaub.b == 2) {
          return new bape(this, parambaub);
        }
        return new bapa(this, parambaub);
      }
      if (parambaub.b == 2) {
        return new GroupPttDownloadProcessor(this, parambaub);
      }
      if ((parambaub.b == 1) || (parambaub.b == 65537) || (parambaub.b == 131075)) {
        return new baoz(this, parambaub);
      }
      if ((parambaub.b == 6) || (parambaub.b == 7) || (parambaub.b == 17) || (parambaub.b == 18) || (parambaub.b == 9) || (parambaub.b == 16)) {
        return new bass(this, parambaub);
      }
    }
    else
    {
      if (parambaub.jdField_a_of_type_Boolean)
      {
        if (parambaub.b == 2) {
          return new bank(this, parambaub);
        }
        if (parambaub.b == 32) {
          return new baqc(this, parambaub);
        }
        if ((parambaub.b == 6) || (parambaub.b == 17) || (parambaub.b == 9)) {
          return new ShortVideoUploadProcessor(this, parambaub);
        }
        if ((parambaub.b == 8) || (parambaub.b == 64) || (parambaub.b == 22) || (parambaub.b == 21) || (parambaub.b == 34) || (parambaub.b == 35) || (parambaub.b == 36) || (parambaub.b == 37) || (parambaub.b == 38) || (parambaub.b == 48) || (parambaub.b == 23) || (parambaub.b == 39) || (parambaub.b == 40) || (parambaub.b == 41) || (parambaub.b == 50) || (parambaub.b == 51) || (parambaub.b == 56)) {
          return new baqs(this, parambaub);
        }
        if (parambaub.b == 20) {
          return new basv(this, parambaub);
        }
        if (parambaub.b == 24) {
          return new bamp(this, parambaub);
        }
        if ((parambaub.b == 196609) || (parambaub.b == 196610) || (parambaub.b == 327681)) {
          return new bato(this, parambaub);
        }
        if (parambaub.jdField_e_of_type_Int == 1045) {
          return new bano(this, parambaub);
        }
        return new bang(this, parambaub);
      }
      if (parambaub.b == 2) {
        return new C2CPttDownloadProcessor(this, parambaub);
      }
      if (parambaub.b == 32) {
        return new baqb(this, parambaub);
      }
      if (parambaub.b == 33) {
        return new bara(this, parambaub);
      }
      if ((parambaub.b == 6) || (parambaub.b == 7) || (parambaub.b == 17) || (parambaub.b == 18) || (parambaub.b == 9) || (parambaub.b == 16)) {
        return new bass(this, parambaub);
      }
      if ((parambaub.b == 1) || (parambaub.b == 65537) || (parambaub.b == 131075)) {
        return new banf(this, parambaub);
      }
      if (parambaub.b == 131079) {
        return new StructLongMessageDownloadProcessor(this, parambaub);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, parambaub.toString());
    }
    return null;
  }
  
  public baui a(baub parambaub)
  {
    parambaub.jdField_a_of_type_Boolean = false;
    parambaub.jdField_a_of_type_Baui = new baui();
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (parambaub.b == 131076)
      {
        localObject = new baun(this, parambaub);
        a(parambaub, (bamw)localObject, a(parambaub), true);
      }
    }
    for (;;)
    {
      return parambaub.jdField_a_of_type_Baui;
      if ((parambaub.jdField_a_of_type_Int == 1) || (parambaub.jdField_a_of_type_Int == 3000))
      {
        localObject = new baoz(this, parambaub);
        break;
      }
      localObject = new banf(this, parambaub);
      break;
      localObject = parambaub.jdField_a_of_type_Baui;
      ((baui)localObject).jdField_a_of_type_Int = -1;
      ((baui)localObject).jdField_a_of_type_Long = 9366L;
      ((baui)localObject).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public bdlq a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (bdlq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public bdlq a(String paramString1, String paramString2, long paramLong)
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
      bdlq localbdlq = a(paramString2, paramLong1);
      if ((localbdlq instanceof baom)) {
        ((baom)localbdlq).a();
      }
    }
    paramString1 = new baom(paramLong1, paramString1, paramQQAppInterface, paramInt1, paramString2, paramString3, paramString4, paramString5, paramLong2, paramInt2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ptt_reserve.ReserveStruct paramReserveStruct)
  {
    Object localObject2 = azqa.a(paramStreamInfo.iMsgId, 1);
    long l1 = paramStreamInfo.lFromUIN;
    long l2 = paramStreamInfo.lToUIN;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = banc.a(String.valueOf(l2), null, 2, null);
      int i = bdal.a(paramStreamInfo.pttFormat);
      localObject2 = MessageForPtt.getLocalFilePath(i, (String)localObject1);
      azqa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject2, 1, paramStreamInfo.iMsgId);
      azqa.a((String)localObject2, (short)paramStreamInfo.msgSeq);
      azqa.b((String)localObject2, paramStreamInfo.random);
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
          localObject = (ault)((QQAppInterface)localObject).getManager(324);
        } while (!((ault)localObject).a(paramChatMessage));
        ((ault)localObject).b(paramChatMessage, 0L, 0, 256);
        return;
      } while (!(paramChatMessage instanceof MessageForPic));
      paramChatMessage = (MessageForPic)paramChatMessage;
      a(paramChatMessage, 131075);
      a(paramChatMessage, 1);
      a(paramChatMessage, 131075);
      localObject = (ault)((QQAppInterface)localObject).getManager(324);
    } while (!((ault)localObject).a(paramChatMessage));
    ((ault)localObject).b(paramChatMessage, 0L, 0, 24);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    paramMessageForPic = a(a(paramMessageForPic.md5, paramMessageForPic.uuid, paramInt));
    if ((paramMessageForPic != null) && ((paramMessageForPic instanceof bamw))) {
      ((bamw)paramMessageForPic).a();
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
        Object localObject = (bdlq)((Map.Entry)localIterator.next()).getValue();
        if (a((bdlq)localObject))
        {
          localObject = (bamw)localObject;
          if ((paramString.equals(((bamw)localObject).a.jdField_c_of_type_JavaLangString)) && (((bamw)localObject).k))
          {
            ((bamw)localObject).b();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "resume pic:" + ((bamw)localObject).a.jdField_a_of_type_Long);
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
      bdlq localbdlq = (bdlq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        if (((localbdlq instanceof banc)) && (paramString.equals(((banc)localbdlq).a.p)))
        {
          ((bamw)localbdlq).j();
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
        Object localObject = (bdlq)((Map.Entry)localIterator.next()).getValue();
        if (a((bdlq)localObject))
        {
          localObject = (bamw)localObject;
          if ((paramString.equals(((bamw)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((bamw)localObject).a.jdField_a_of_type_Long))
          {
            ((bamw)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((bamw)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, batz parambatz)
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
        Object localObject = (bdlq)((Map.Entry)localIterator.next()).getValue();
        if (a((bdlq)localObject))
        {
          localObject = (bamw)localObject;
          if ((paramString.equals(((bamw)localObject).a.jdField_c_of_type_JavaLangString)) && (((bamw)localObject).d()))
          {
            ((bamw)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((bamw)localObject).a.jdField_a_of_type_Long);
            }
            if (((bamw)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              localArrayList.add(((bamw)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          }
        }
      }
    } while (parambatz == null);
    parambatz.a(localArrayList);
  }
  
  public void a(String paramString, bdlq parambdlq)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambdlq);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bdlq)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof bamw))) {
        break label171;
      }
      localObject = (bamw)localObject;
      if ((!((bamw)localObject).m) || (((bamw)localObject).k)) {
        break label171;
      }
      ((bamw)localObject).c();
      if (((bamw)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((bamw)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend key:" + ((bamw)localObject).a());
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
      Object localObject = (bdlq)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof banb))) {
        break label175;
      }
      localObject = (banb)localObject;
      if ((((banb)localObject).a == null) || (!((banb)localObject).a.i)) {
        break label175;
      }
      ((banb)localObject).u = paramLong;
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
  
  public boolean a(baub parambaub)
  {
    try
    {
      boolean bool = super.a(parambaub);
      return bool;
    }
    finally
    {
      parambaub = finally;
      throw parambaub;
    }
  }
  
  public boolean a(baub parambaub, MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = a(parambaub);
      return bool;
    }
    finally
    {
      parambaub = finally;
      throw parambaub;
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
    //   22: getfield 147	batw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +31 -> 60
    //   32: aload_0
    //   33: getfield 147	batw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: aload_1
    //   37: invokevirtual 151	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 334	bass
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 684	bass:c	()V
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
    //   0	71	0	this	batw
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
        banc localbanc = new banc(paramString1, paramString2, false, null, null, 2, -1, false, this, paramLong1);
        localbanc.a(paramLong1);
        localbanc.a().jdField_c_of_type_JavaLangString = paramString2;
        localbanc.c(paramString1 + paramString2 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramString2 + paramLong1, localbanc);
        localbanc.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (banc)a(paramString1 + paramString2 + paramLong1);
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
        paramString2 = new banc(paramString1, paramString2, true, null, null, 2, -1, false, this, paramLong1);
        paramString2.a(paramLong1);
        paramString2.f();
        paramString2.c(paramString1 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramLong1, paramString2);
        paramString2.a(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (banc)a(paramString1, paramString2, paramLong1);
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
      paramString1 = (bdlq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof bamw)) {
        return (int)((bamw)paramString1).c();
      }
    }
    return -1;
  }
  
  public baui b(baub parambaub)
  {
    parambaub.jdField_a_of_type_Boolean = false;
    parambaub.jdField_a_of_type_Baui = new baui();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        Object localObject1;
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
        {
          localObject1 = parambaub.jdField_a_of_type_Baui;
          ((baui)localObject1).jdField_a_of_type_Int = -1;
          ((baui)localObject1).jdField_a_of_type_Long = 9366L;
          ((baui)localObject1).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          parambaub = parambaub.jdField_a_of_type_Baui;
          return parambaub;
        }
        try
        {
          if (parambaub.b == 131076)
          {
            localObject1 = new baun(this, parambaub);
            a(parambaub, (bamw)localObject1, a(parambaub), false);
            return parambaub.jdField_a_of_type_Baui;
          }
          if ((parambaub.jdField_a_of_type_Int == 1) || (parambaub.jdField_a_of_type_Int == 3000))
          {
            localObject1 = new baoz(this, parambaub);
            continue;
            parambaub = finally;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          localObject2 = parambaub.jdField_a_of_type_Baui;
          ((baui)localObject2).jdField_a_of_type_Int = -1;
          ((baui)localObject2).jdField_a_of_type_Long = 9366L;
          ((baui)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          parambaub = parambaub.jdField_a_of_type_Baui;
          return parambaub;
        }
      }
      Object localObject2 = new banf(this, parambaub);
      continue;
      localObject2 = parambaub.jdField_a_of_type_Baui;
      ((baui)localObject2).jdField_a_of_type_Int = -1;
      ((baui)localObject2).jdField_a_of_type_Long = 9366L;
      ((baui)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
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
        Object localObject = (bdlq)((Map.Entry)localIterator.next()).getValue();
        if (c((bdlq)localObject))
        {
          localObject = (bamw)localObject;
          if ((paramString.equals(((bamw)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((bamw)localObject).a.jdField_a_of_type_Long))
          {
            ((bamw)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel JSPTT:" + ((bamw)localObject).a.jdField_a_of_type_Long);
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
      Object localObject = (bdlq)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof bamw))) {
        break label211;
      }
      localObject = (bamw)localObject;
      if ((!((bamw)localObject).n) || (((bamw)localObject).k)) {
        break label211;
      }
      ((bamw)localObject).c();
      if (((bamw)localObject).a() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((bamw)localObject).a());
      }
      localStringBuilder.append(((bamw)localObject).a());
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
    if ((paramString != null) && ((paramString instanceof bamw)))
    {
      paramString = (bamw)paramString;
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
    //   25: getfield 147	batw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 263	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +36 -> 68
    //   35: aload_0
    //   36: getfield 147	batw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_1
    //   40: invokevirtual 151	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 153	bdlq
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
    //   81: checkcast 315	basv
    //   84: invokevirtual 738	basv:c	()V
    //   87: goto -22 -> 65
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	batw
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
      paramString2 = (banc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
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
      Object localObject = (bdlq)((Map.Entry)localIterator.next()).getValue();
      if (b((bdlq)localObject))
      {
        ThreadManager.getSubThreadHandler().removeCallbacks((StructLongMessageDownloadProcessor)localObject);
        localObject = (bamw)localObject;
        if ((paramString.equals(((bamw)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((bamw)localObject).a.jdField_a_of_type_Long))
        {
          ((bamw)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("cancelpic", 2, "cancel PALongMsg:" + ((bamw)localObject).a.jdField_a_of_type_Long);
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
      Object localObject = (bdlq)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof bamw))) {
        break label178;
      }
      localObject = (bamw)localObject;
      if ((!((bamw)localObject).l) || (((bamw)localObject).k)) {
        break label178;
      }
      ((bamw)localObject).c();
      if (((bamw)localObject).a() != null) {
        this.jdField_b_of_type_JavaUtilArrayList.add(((bamw)localObject).a());
      }
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend key:" + ((bamw)localObject).a());
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
      Object localObject = (bdlq)((Map.Entry)localIterator.next()).getValue();
      bool1 = bool2;
      if (a((bdlq)localObject))
      {
        localObject = (bamw)localObject;
        bool1 = bool2;
        if (paramString.equals(((bamw)localObject).a.jdField_c_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (!((bamw)localObject).k)
          {
            ((bamw)localObject).c();
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("cancelpic", 2, "pause pic:" + ((bamw)localObject).a.jdField_a_of_type_Long);
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
          paramString = (bdlq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
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
      paramString2 = (banc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
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
      if ((localObject != null) && ((localObject instanceof bamw)))
      {
        localObject = (bamw)localObject;
        if (((bamw)localObject).k)
        {
          ((bamw)localObject).b();
          localStringBuilder.append(((bamw)localObject).a());
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
        Object localObject = (bdlq)((Map.Entry)localIterator.next()).getValue();
        if (d((bdlq)localObject))
        {
          localObject = (bamw)localObject;
          if ((paramString.equals(((bamw)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((bamw)localObject).a.jdField_a_of_type_Long))
          {
            ((bamw)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "PttSliceUploadProcessor cancelVoiceTextTask:" + ((bamw)localObject).a.jdField_a_of_type_Long);
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
        bdlq localbdlq = (bdlq)((Map.Entry)localIterator.next()).getValue();
        if ((!a(localbdlq)) || (!paramString.equals(((bamw)localbdlq).a.jdField_c_of_type_JavaLangString))) {
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
          bdlq localbdlq = (bdlq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (localbdlq != null)
          {
            if ((localbdlq instanceof ShortVideoUploadProcessor)) {
              ((ShortVideoUploadProcessor)localbdlq).c();
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
            bool = true;
            return bool;
          }
          if (!(localbdlq instanceof basv)) {
            continue;
          }
          ((basv)localbdlq).c();
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
      bdlq localbdlq = (bdlq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localbdlq instanceof bass))
      {
        ((bass)localbdlq).c();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     batw
 * JD-Core Version:    0.7.0.1
 */