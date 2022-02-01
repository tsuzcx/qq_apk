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
import com.tencent.mobileqq.transfile.StructLongMessageDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController.1;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import tencent.im.cs.ptt_reserve.ptt_reserve.ReserveStruct;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class beyb
  extends bern
{
  public static HashSet<Integer> a;
  public QQAppInterface a;
  ArrayList<String> a;
  ArrayList<String> b;
  public ConcurrentHashMap<String, byte[]> b;
  
  static
  {
    jdField_a_of_type_JavaUtilHashSet = new HashSet();
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(8));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(64));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(22));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(21));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(34));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(35));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(36));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(37));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(38));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(48));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(23));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(39));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(40));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(41));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(50));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(51));
    jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(56));
  }
  
  public beyb()
  {
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(20);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public beyb(QQAppInterface paramQQAppInterface)
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
  
  public static String a(beyg parambeyg)
  {
    return a(parambeyg.f, parambeyg.jdField_e_of_type_JavaLangString, parambeyg.b);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1))) {
      return paramString1 + "_" + paramInt;
    }
    return paramString2 + "_" + paramInt;
  }
  
  private void a(beyg parambeyg, berp paramberp)
  {
    try
    {
      if (parambeyg.jdField_a_of_type_Beyn.jdField_a_of_type_Int == -2)
      {
        bews.a(parambeyg.jdField_a_of_type_Int, parambeyg.jdField_a_of_type_Boolean, parambeyg.b, String.valueOf(parambeyg.jdField_a_of_type_Long), "callwait", "");
        paramberp.wait();
        bews.a(parambeyg.jdField_a_of_type_Int, parambeyg.jdField_a_of_type_Boolean, parambeyg.b, String.valueOf(parambeyg.jdField_a_of_type_Long), "waitfin", "");
      }
      return;
    }
    catch (InterruptedException parambeyg)
    {
      parambeyg.printStackTrace();
    }
  }
  
  private void a(beyg parambeyg, berp paramberp, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "sync ";
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
      }
      ??? = (bhvc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (??? == null) {
        break label418;
      }
      if (!(??? instanceof berj)) {}
    }
    label418:
    do
    {
      do
      {
        long l;
        beyg localbeyg;
        do
        {
          synchronized ((berj)???)
          {
            l = ((berj)???).c();
            localbeyg = ((berj)???).a();
            bews.a(parambeyg.jdField_a_of_type_Int, parambeyg.jdField_a_of_type_Boolean, parambeyg.b, String.valueOf(parambeyg.jdField_a_of_type_Long), str + "startDownloadProcessor", "status:" + l + ",key:" + paramString);
            if ((l == -1L) || (l == 2002L) || (l == 2001L))
            {
              parambeyg.jdField_a_of_type_Beyn = localbeyg.jdField_a_of_type_Beyn;
              if (parambeyg.jdField_a_of_type_Azpp != null) {
                ((berj)???).jdField_b_of_type_JavaUtilArrayList.add(parambeyg.jdField_a_of_type_Azpp);
              }
              if (paramBoolean) {
                a(parambeyg, (berp)???);
              }
            }
            for (;;)
            {
              return;
              str = "aync ";
              break;
              if ((l == 2004L) || (l == 2005L))
              {
                if (paramberp == null) {
                  continue;
                }
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramberp);
                paramberp.c(paramString);
                if (paramberp.c() != 0) {
                  continue;
                }
                azqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambeyg);
                paramberp.aN_();
                if (!paramBoolean) {
                  continue;
                }
                try
                {
                  bews.a(parambeyg.jdField_a_of_type_Int, parambeyg.jdField_a_of_type_Boolean, parambeyg.b, String.valueOf(parambeyg.jdField_a_of_type_Long), "callwait", "");
                  ???.wait();
                }
                catch (InterruptedException parambeyg)
                {
                  parambeyg.printStackTrace();
                }
              }
            }
          }
        } while (l != 2003L);
        parambeyg.jdField_a_of_type_Beyn = localbeyg.jdField_a_of_type_Beyn;
        if (parambeyg.jdField_a_of_type_Azpp != null)
        {
          paramberp = new azpq();
          paramberp.jdField_a_of_type_Int = 0;
          paramberp.b = parambeyg.h;
          paramberp.jdField_c_of_type_JavaLangString = parambeyg.f;
          paramberp.jdField_c_of_type_Int = parambeyg.b;
          paramberp.d = parambeyg.g;
          parambeyg.jdField_a_of_type_Azpp.a(paramberp);
        }
        return;
        bews.a(parambeyg.jdField_a_of_type_Int, parambeyg.jdField_a_of_type_Boolean, parambeyg.b, String.valueOf(parambeyg.jdField_a_of_type_Long), str + "startDownloadProcessor", "firs time ,key:" + paramString);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramberp);
        paramberp.c(paramString);
      } while (paramberp.c() != 0);
      azqi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambeyg);
      paramberp.aN_();
    } while (!paramBoolean);
    try
    {
      a(parambeyg, paramberp);
      return;
    }
    finally {}
  }
  
  private boolean a(bhvc parambhvc)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambhvc != null) {
      if (!(parambhvc instanceof besa))
      {
        bool1 = bool2;
        if (!(parambhvc instanceof betv)) {}
      }
      else
      {
        parambhvc = (berp)parambhvc;
        bool1 = bool2;
        if (parambhvc.c() != 1003L)
        {
          bool1 = bool2;
          if (parambhvc.d() != 1003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b(bhvc parambhvc)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambhvc != null)
    {
      bool1 = bool2;
      if ((parambhvc instanceof StructLongMessageDownloadProcessor))
      {
        bool1 = bool2;
        if (((berp)parambhvc).c() != 2003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean c(bhvc parambhvc)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambhvc != null) {
      if (!(parambhvc instanceof beuu))
      {
        bool1 = bool2;
        if (!(parambhvc instanceof beut)) {}
      }
      else
      {
        parambhvc = (berp)parambhvc;
        bool1 = bool2;
        if (parambhvc.c() != 1003L)
        {
          bool1 = bool2;
          if (parambhvc.d() != 2003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean d(bhvc parambhvc)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambhvc != null)
    {
      bool1 = bool2;
      if ((parambhvc instanceof bewb))
      {
        bool1 = bool2;
        if (((berp)parambhvc).c() != 1003L) {
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
      paramString1 = (bhvc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof berp)) {
        return ((berp)paramString1).f();
      }
    }
    return 0;
  }
  
  public berp a(beyg parambeyg)
  {
    if (parambeyg == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, parambeyg.toString());
    }
    if (parambeyg.b == 131078)
    {
      if (parambeyg.jdField_a_of_type_Boolean) {
        return new beve(this, parambeyg);
      }
      return new bevd(this, parambeyg);
    }
    if (parambeyg.b == 262153)
    {
      if (parambeyg.jdField_a_of_type_Boolean) {
        return new bewv(this, parambeyg);
      }
      return new bewu(this, parambeyg);
    }
    if (parambeyg.b == 327689) {
      return new beuw(this, parambeyg);
    }
    if (parambeyg.b == 327696) {
      return new bewb(this, parambeyg);
    }
    if (parambeyg.b == 66) {
      return new bewz(this, parambeyg);
    }
    if ((parambeyg.b == 52) && (parambeyg.jdField_a_of_type_Boolean)) {
      return new betj(this, parambeyg);
    }
    if (parambeyg.jdField_a_of_type_Int == 1026) {
      return b(parambeyg);
    }
    if ((parambeyg.jdField_a_of_type_Int == 1) || (parambeyg.jdField_a_of_type_Int == 3000)) {
      return c(parambeyg);
    }
    return f(parambeyg);
  }
  
  public beyn a(beyg parambeyg)
  {
    parambeyg.jdField_a_of_type_Boolean = false;
    parambeyg.jdField_a_of_type_Beyn = new beyn();
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (parambeyg.b == 131076)
      {
        localObject = new beys(this, parambeyg);
        a(parambeyg, (berp)localObject, a(parambeyg), true);
      }
    }
    for (;;)
    {
      return parambeyg.jdField_a_of_type_Beyn;
      if ((parambeyg.jdField_a_of_type_Int == 1) || (parambeyg.jdField_a_of_type_Int == 3000))
      {
        localObject = new betu(this, parambeyg);
        break;
      }
      localObject = new berz(this, parambeyg);
      break;
      localObject = parambeyg.jdField_a_of_type_Beyn;
      ((beyn)localObject).jdField_a_of_type_Int = -1;
      ((beyn)localObject).jdField_a_of_type_Long = 9366L;
      ((beyn)localObject).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public bhvc a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (bhvc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public bhvc a(String paramString1, String paramString2, long paramLong)
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
      bhvc localbhvc = a(paramString2, paramLong1);
      if ((localbhvc instanceof beth)) {
        ((beth)localbhvc).a();
      }
    }
    paramString1 = new beth(paramLong1, paramString1, paramQQAppInterface, paramInt1, paramString2, paramString3, paramString4, paramString5, paramLong2, paramInt2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ptt_reserve.ReserveStruct paramReserveStruct)
  {
    Object localObject2 = bdoc.a(paramStreamInfo.iMsgId, 1);
    long l1 = paramStreamInfo.lFromUIN;
    long l2 = paramStreamInfo.lToUIN;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = berv.a(String.valueOf(l2), null, 2, null);
      int i = bhjx.a(paramStreamInfo.pttFormat);
      localObject2 = MessageForPtt.getLocalFilePath(i, (String)localObject1);
      bdoc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject2, 1, paramStreamInfo.iMsgId);
      bdoc.a((String)localObject2, (short)paramStreamInfo.msgSeq);
      bdoc.b((String)localObject2, paramStreamInfo.random);
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
          localObject = (axqb)((QQAppInterface)localObject).getManager(324);
        } while (!((axqb)localObject).a(paramChatMessage));
        ((axqb)localObject).b(paramChatMessage, 0L, 0, 256);
        return;
      } while (!(paramChatMessage instanceof MessageForPic));
      paramChatMessage = (MessageForPic)paramChatMessage;
      a(paramChatMessage, 131075);
      a(paramChatMessage, 1);
      a(paramChatMessage, 131075);
      localObject = (axqb)((QQAppInterface)localObject).getManager(324);
    } while (!((axqb)localObject).a(paramChatMessage));
    ((axqb)localObject).b(paramChatMessage, 0L, 0, 24);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    paramMessageForPic = a(a(paramMessageForPic.md5, paramMessageForPic.uuid, paramInt));
    if ((paramMessageForPic != null) && ((paramMessageForPic instanceof berp))) {
      ((berp)paramMessageForPic).a();
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
        Object localObject = (bhvc)((Map.Entry)localIterator.next()).getValue();
        if (a((bhvc)localObject))
        {
          localObject = (berp)localObject;
          if ((paramString.equals(((berp)localObject).a.jdField_c_of_type_JavaLangString)) && (((berp)localObject).m))
          {
            ((berp)localObject).b();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "resume pic:" + ((berp)localObject).a.jdField_a_of_type_Long);
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
      bhvc localbhvc = (bhvc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        if (((localbhvc instanceof berv)) && (paramString.equals(((berv)localbhvc).a.p)))
        {
          ((berp)localbhvc).k();
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
        Object localObject = (bhvc)((Map.Entry)localIterator.next()).getValue();
        if (a((bhvc)localObject))
        {
          localObject = (berp)localObject;
          if ((paramString.equals(((berp)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((berp)localObject).a.jdField_a_of_type_Long))
          {
            ((berp)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((berp)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, beye parambeye)
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
        Object localObject = (bhvc)((Map.Entry)localIterator.next()).getValue();
        if (a((bhvc)localObject))
        {
          localObject = (berp)localObject;
          if ((paramString.equals(((berp)localObject).a.jdField_c_of_type_JavaLangString)) && (((berp)localObject).d()))
          {
            ((berp)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((berp)localObject).a.jdField_a_of_type_Long);
            }
            if (((berp)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              localArrayList.add(((berp)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          }
        }
      }
    } while (parambeye == null);
    parambeye.a(localArrayList);
  }
  
  public void a(String paramString, bhvc parambhvc)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambhvc);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bhvc)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof berp))) {
        break label171;
      }
      localObject = (berp)localObject;
      if ((!((berp)localObject).o) || (((berp)localObject).m)) {
        break label171;
      }
      ((berp)localObject).c();
      if (((berp)localObject).b() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((berp)localObject).b());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend key:" + ((berp)localObject).b());
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
      Object localObject = (bhvc)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof beru))) {
        break label175;
      }
      localObject = (beru)localObject;
      if ((((beru)localObject).a == null) || (!((beru)localObject).a.j)) {
        break label175;
      }
      ((beru)localObject).u = paramLong;
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
  
  public boolean a(beyg parambeyg)
  {
    try
    {
      boolean bool = super.a(parambeyg);
      return bool;
    }
    finally
    {
      parambeyg = finally;
      throw parambeyg;
    }
  }
  
  public boolean a(beyg parambeyg, MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = a(parambeyg);
      return bool;
    }
    finally
    {
      parambeyg = finally;
      throw parambeyg;
    }
  }
  
  /* Error */
  public boolean a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 62	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: lload_2
    //   14: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 164	beyb:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 278	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +31 -> 60
    //   32: aload_0
    //   33: getfield 164	beyb:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: aload_1
    //   37: invokevirtual 168	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 646	bexb
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 647	bexb:c	()V
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
    //   0	71	0	this	beyb
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
        berv localberv = new berv(paramString1, paramString2, false, null, null, 2, -1, false, this, paramLong1);
        localberv.a(paramLong1);
        localberv.a().jdField_c_of_type_JavaLangString = paramString2;
        localberv.c(paramString1 + paramString2 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramString2 + paramLong1, localberv);
        localberv.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (berv)a(paramString1 + paramString2 + paramLong1);
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
        paramString2 = new berv(paramString1, paramString2, true, null, null, 2, -1, false, this, paramLong1);
        paramString2.a(paramLong1);
        paramString2.f();
        paramString2.c(paramString1 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramLong1, paramString2);
        paramString2.a(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (berv)a(paramString1, paramString2, paramLong1);
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
      paramString1 = (bhvc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof berp)) {
        return (int)((berp)paramString1).c();
      }
    }
    return -1;
  }
  
  public berp b(beyg parambeyg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PttShow", 2, "getProcessor UIN_TYPE_HOTCHAT_TOPIC  isUp = " + parambeyg.jdField_a_of_type_Boolean);
    }
    if (parambeyg.jdField_a_of_type_Boolean) {
      return new betv(this, parambeyg);
    }
    if (parambeyg.b == 2) {
      return new GroupPttDownloadProcessor(this, parambeyg);
    }
    return null;
  }
  
  public beyn b(beyg parambeyg)
  {
    parambeyg.jdField_a_of_type_Boolean = false;
    parambeyg.jdField_a_of_type_Beyn = new beyn();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        Object localObject1;
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
        {
          localObject1 = parambeyg.jdField_a_of_type_Beyn;
          ((beyn)localObject1).jdField_a_of_type_Int = -1;
          ((beyn)localObject1).jdField_a_of_type_Long = 9366L;
          ((beyn)localObject1).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          parambeyg = parambeyg.jdField_a_of_type_Beyn;
          return parambeyg;
        }
        try
        {
          if (parambeyg.b == 131076)
          {
            localObject1 = new beys(this, parambeyg);
            a(parambeyg, (berp)localObject1, a(parambeyg), false);
            return parambeyg.jdField_a_of_type_Beyn;
          }
          if ((parambeyg.jdField_a_of_type_Int == 1) || (parambeyg.jdField_a_of_type_Int == 3000))
          {
            localObject1 = new betu(this, parambeyg);
            continue;
            parambeyg = finally;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          localObject2 = parambeyg.jdField_a_of_type_Beyn;
          ((beyn)localObject2).jdField_a_of_type_Int = -1;
          ((beyn)localObject2).jdField_a_of_type_Long = 9366L;
          ((beyn)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          parambeyg = parambeyg.jdField_a_of_type_Beyn;
          return parambeyg;
        }
      }
      Object localObject2 = new berz(this, parambeyg);
      continue;
      localObject2 = parambeyg.jdField_a_of_type_Beyn;
      ((beyn)localObject2).jdField_a_of_type_Int = -1;
      ((beyn)localObject2).jdField_a_of_type_Long = 9366L;
      ((beyn)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public void b()
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
  
  public void b(String paramString, long paramLong)
  {
    if ((paramString == null) || (paramLong == 0L)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (bhvc)((Map.Entry)localIterator.next()).getValue();
        if (c((bhvc)localObject))
        {
          localObject = (berp)localObject;
          if ((paramString.equals(((berp)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((berp)localObject).a.jdField_a_of_type_Long))
          {
            ((berp)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel JSPTT:" + ((berp)localObject).a.jdField_a_of_type_Long);
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
      Object localObject = (bhvc)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof berp))) {
        break label211;
      }
      localObject = (berp)localObject;
      if ((!((berp)localObject).p) || (((berp)localObject).m)) {
        break label211;
      }
      ((berp)localObject).c();
      if (((berp)localObject).b() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((berp)localObject).b());
      }
      localStringBuilder.append(((berp)localObject).b());
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
    if ((paramString != null) && ((paramString instanceof berp)))
    {
      paramString = (berp)paramString;
      if ((paramString.n) && (paramString.m))
      {
        paramString.b();
        if (QLog.isColorLevel()) {
          QLog.d("raw_photo", 2, "resumeRawSend ,key:" + paramString.b());
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
    //   5: new 62	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: lload_2
    //   17: invokevirtual 186	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 164	beyb:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 278	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +36 -> 68
    //   35: aload_0
    //   36: getfield 164	beyb:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_1
    //   40: invokevirtual 168	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 170	bhvc
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +17 -> 65
    //   51: aload_1
    //   52: instanceof 733
    //   55: ifeq +18 -> 73
    //   58: aload_1
    //   59: checkcast 733	bexk
    //   62: invokevirtual 734	bexk:c	()V
    //   65: iconst_1
    //   66: istore 4
    //   68: aload_0
    //   69: monitorexit
    //   70: iload 4
    //   72: ireturn
    //   73: aload_1
    //   74: instanceof 736
    //   77: ifeq -12 -> 65
    //   80: aload_1
    //   81: checkcast 736	bexd
    //   84: invokevirtual 737	bexd:c	()V
    //   87: goto -22 -> 65
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	beyb
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
      paramString2 = (berv)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.k();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public berp c(beyg parambeyg)
  {
    if (parambeyg.jdField_a_of_type_Boolean)
    {
      if ((parambeyg.b == 6) || (parambeyg.b == 17) || (parambeyg.b == 9)) {
        return new bexk(this, parambeyg);
      }
      if (parambeyg.b == 20) {
        return new bexd(this, parambeyg);
      }
      if (parambeyg.b == 55) {
        return new beyp(this, parambeyg);
      }
      if (parambeyg.jdField_e_of_type_Int == 1045) {
        return new beud(this, parambeyg);
      }
      if (parambeyg.b == 2) {
        return new betz(this, parambeyg);
      }
      return new betv(this, parambeyg);
    }
    if (parambeyg.b == 2) {
      return new GroupPttDownloadProcessor(this, parambeyg);
    }
    if ((parambeyg.b == 1) || (parambeyg.b == 65537) || (parambeyg.b == 131075)) {
      return new betu(this, parambeyg);
    }
    if ((parambeyg.b == 6) || (parambeyg.b == 7) || (parambeyg.b == 17) || (parambeyg.b == 18) || (parambeyg.b == 9) || (parambeyg.b == 16)) {
      return new bexb(this, parambeyg);
    }
    return null;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend keys size:" + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = a((String)localIterator.next());
      if ((localObject != null) && ((localObject instanceof berp)))
      {
        localObject = (berp)localObject;
        if (((berp)localObject).m)
        {
          ((berp)localObject).b();
          localStringBuilder.append(((berp)localObject).b());
          localStringBuilder.append(",");
        }
      }
    }
    if ((localStringBuilder.length() > 0) && (QLog.isColorLevel())) {
      QLog.d("short_video", 2, "resumeLastShortVideoSend , key: " + localStringBuilder);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void c(String paramString, long paramLong)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (bhvc)((Map.Entry)localIterator.next()).getValue();
      if (b((bhvc)localObject))
      {
        ThreadManager.getSubThreadHandler().removeCallbacks((StructLongMessageDownloadProcessor)localObject);
        localObject = (berp)localObject;
        if ((paramString.equals(((berp)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((berp)localObject).a.jdField_a_of_type_Long))
        {
          ((berp)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("cancelpic", 2, "cancel PALongMsg:" + ((berp)localObject).a.jdField_a_of_type_Long);
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
      Object localObject = (bhvc)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof berp))) {
        break label178;
      }
      localObject = (berp)localObject;
      if ((!((berp)localObject).n) || (((berp)localObject).m)) {
        break label178;
      }
      ((berp)localObject).c();
      if (((berp)localObject).b() != null) {
        this.jdField_b_of_type_JavaUtilArrayList.add(((berp)localObject).b());
      }
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend key:" + ((berp)localObject).b());
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
      Object localObject = (bhvc)((Map.Entry)localIterator.next()).getValue();
      bool1 = bool2;
      if (a((bhvc)localObject))
      {
        localObject = (berp)localObject;
        bool1 = bool2;
        if (paramString.equals(((berp)localObject).a.jdField_c_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (!((berp)localObject).m)
          {
            ((berp)localObject).c();
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("cancelpic", 2, "pause pic:" + ((berp)localObject).a.jdField_a_of_type_Long);
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
          paramString = (bhvc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (((paramString instanceof bexk)) && (((bexk)paramString).d()))
          {
            ((bexk)paramString).b();
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
      paramString2 = (berv)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.k();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public berp d(beyg parambeyg)
  {
    if (parambeyg.b == 2) {
      return new bese(this, parambeyg);
    }
    if (parambeyg.b == 32) {
      return new beuu(this, parambeyg);
    }
    if ((parambeyg.b == 6) || (parambeyg.b == 17) || (parambeyg.b == 9)) {
      return new bexk(this, parambeyg);
    }
    if (jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(parambeyg.b))) {
      return new bevi(this, parambeyg);
    }
    if (parambeyg.b == 20) {
      return new bexd(this, parambeyg);
    }
    if (parambeyg.b == 24) {
      return new berh(this, parambeyg);
    }
    if ((parambeyg.b == 196609) || (parambeyg.b == 196610) || (parambeyg.b == 327681)) {
      return new bext(this, parambeyg);
    }
    if (parambeyg.jdField_e_of_type_Int == 1045) {
      return new besi(this, parambeyg);
    }
    return new besa(this, parambeyg);
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("raw_photo", 2, "resumeLastRawSend keys size:" + this.jdField_b_of_type_JavaUtilArrayList.size());
    }
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      b((String)localIterator.next());
    }
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
        Object localObject = (bhvc)((Map.Entry)localIterator.next()).getValue();
        if (d((bhvc)localObject))
        {
          localObject = (berp)localObject;
          if ((paramString.equals(((berp)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((berp)localObject).a.jdField_a_of_type_Long))
          {
            ((berp)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "PttSliceUploadProcessor cancelVoiceTextTask:" + ((berp)localObject).a.jdField_a_of_type_Long);
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
        bhvc localbhvc = (bhvc)((Map.Entry)localIterator.next()).getValue();
        if ((!a(localbhvc)) || (!paramString.equals(((berp)localbhvc).a.jdField_c_of_type_JavaLangString))) {
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
          bhvc localbhvc = (bhvc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (localbhvc != null)
          {
            if ((localbhvc instanceof bexk)) {
              ((bexk)localbhvc).c();
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
            bool = true;
            return bool;
          }
          if (!(localbhvc instanceof bexd)) {
            continue;
          }
          ((bexd)localbhvc).c();
          continue;
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  public berp e(beyg parambeyg)
  {
    if (parambeyg.b == 2) {
      return new C2CPttDownloadProcessor(this, parambeyg);
    }
    if (parambeyg.b == 32) {
      return new beut(this, parambeyg);
    }
    if (parambeyg.b == 33) {
      return new bevq(this, parambeyg);
    }
    if ((parambeyg.b == 6) || (parambeyg.b == 7) || (parambeyg.b == 17) || (parambeyg.b == 18) || (parambeyg.b == 9) || (parambeyg.b == 16)) {
      return new bexb(this, parambeyg);
    }
    if ((parambeyg.b == 1) || (parambeyg.b == 65537) || (parambeyg.b == 131075)) {
      return new berz(this, parambeyg);
    }
    if (parambeyg.b == 131079) {
      return new StructLongMessageDownloadProcessor(this, parambeyg);
    }
    return null;
  }
  
  public boolean e(String paramString, long paramLong)
  {
    paramString = paramString + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      bhvc localbhvc = (bhvc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localbhvc instanceof bexb))
      {
        ((bexb)localbhvc).c();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return true;
      }
    }
    return false;
  }
  
  public berp f(beyg parambeyg)
  {
    if (parambeyg.jdField_a_of_type_Boolean) {
      return d(parambeyg);
    }
    return e(parambeyg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     beyb
 * JD-Core Version:    0.7.0.1
 */