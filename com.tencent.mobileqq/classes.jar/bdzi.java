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

public class bdzi
  extends bdsv
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
  
  public bdzi(QQAppInterface paramQQAppInterface)
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
  
  public static String a(bdzn parambdzn)
  {
    return a(parambdzn.f, parambdzn.jdField_e_of_type_JavaLangString, parambdzn.b);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 != null) && (!"null".equals(paramString1)) && (!"".equals(paramString1))) {
      return paramString1 + "_" + paramInt;
    }
    return paramString2 + "_" + paramInt;
  }
  
  private void a(bdzn parambdzn, bdsx parambdsx)
  {
    try
    {
      if (parambdzn.jdField_a_of_type_Bdzu.jdField_a_of_type_Int == -2)
      {
        bdxz.a(parambdzn.jdField_a_of_type_Int, parambdzn.jdField_a_of_type_Boolean, parambdzn.b, String.valueOf(parambdzn.jdField_a_of_type_Long), "callwait", "");
        parambdsx.wait();
        bdxz.a(parambdzn.jdField_a_of_type_Int, parambdzn.jdField_a_of_type_Boolean, parambdzn.b, String.valueOf(parambdzn.jdField_a_of_type_Long), "waitfin", "");
      }
      return;
    }
    catch (InterruptedException parambdzn)
    {
      parambdzn.printStackTrace();
    }
  }
  
  private void a(bdzn parambdzn, bdsx parambdsx, String paramString, boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      str = "sync ";
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString);
      }
      ??? = (bguz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (??? == null) {
        break label418;
      }
      if (!(??? instanceof bdsr)) {}
    }
    label418:
    do
    {
      do
      {
        long l;
        bdzn localbdzn;
        do
        {
          synchronized ((bdsr)???)
          {
            l = ((bdsr)???).c();
            localbdzn = ((bdsr)???).a();
            bdxz.a(parambdzn.jdField_a_of_type_Int, parambdzn.jdField_a_of_type_Boolean, parambdzn.b, String.valueOf(parambdzn.jdField_a_of_type_Long), str + "startDownloadProcessor", "status:" + l + ",key:" + paramString);
            if ((l == -1L) || (l == 2002L) || (l == 2001L))
            {
              parambdzn.jdField_a_of_type_Bdzu = localbdzn.jdField_a_of_type_Bdzu;
              if (parambdzn.jdField_a_of_type_Ayxc != null) {
                ((bdsr)???).jdField_b_of_type_JavaUtilArrayList.add(parambdzn.jdField_a_of_type_Ayxc);
              }
              if (paramBoolean) {
                a(parambdzn, (bdsx)???);
              }
            }
            for (;;)
            {
              return;
              str = "aync ";
              break;
              if ((l == 2004L) || (l == 2005L))
              {
                if (parambdsx == null) {
                  continue;
                }
                this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambdsx);
                parambdsx.c(paramString);
                if (parambdsx.c() != 0) {
                  continue;
                }
                ayxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambdzn);
                parambdsx.aN_();
                if (!paramBoolean) {
                  continue;
                }
                try
                {
                  bdxz.a(parambdzn.jdField_a_of_type_Int, parambdzn.jdField_a_of_type_Boolean, parambdzn.b, String.valueOf(parambdzn.jdField_a_of_type_Long), "callwait", "");
                  ???.wait();
                }
                catch (InterruptedException parambdzn)
                {
                  parambdzn.printStackTrace();
                }
              }
            }
          }
        } while (l != 2003L);
        parambdzn.jdField_a_of_type_Bdzu = localbdzn.jdField_a_of_type_Bdzu;
        if (parambdzn.jdField_a_of_type_Ayxc != null)
        {
          parambdsx = new ayxd();
          parambdsx.jdField_a_of_type_Int = 0;
          parambdsx.b = parambdzn.h;
          parambdsx.jdField_c_of_type_JavaLangString = parambdzn.f;
          parambdsx.jdField_c_of_type_Int = parambdzn.b;
          parambdsx.d = parambdzn.g;
          parambdzn.jdField_a_of_type_Ayxc.a(parambdsx);
        }
        return;
        bdxz.a(parambdzn.jdField_a_of_type_Int, parambdzn.jdField_a_of_type_Boolean, parambdzn.b, String.valueOf(parambdzn.jdField_a_of_type_Long), str + "startDownloadProcessor", "firs time ,key:" + paramString);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambdsx);
        parambdsx.c(paramString);
      } while (parambdsx.c() != 0);
      ayxu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, parambdzn);
      parambdsx.aN_();
    } while (!paramBoolean);
    try
    {
      a(parambdzn, parambdsx);
      return;
    }
    finally {}
  }
  
  private boolean a(bguz parambguz)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambguz != null) {
      if (!(parambguz instanceof bdth))
      {
        bool1 = bool2;
        if (!(parambguz instanceof bdvb)) {}
      }
      else
      {
        parambguz = (bdsx)parambguz;
        bool1 = bool2;
        if (parambguz.c() != 1003L)
        {
          bool1 = bool2;
          if (parambguz.d() != 1003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean b(bguz parambguz)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambguz != null)
    {
      bool1 = bool2;
      if ((parambguz instanceof StructLongMessageDownloadProcessor))
      {
        bool1 = bool2;
        if (((bdsx)parambguz).c() != 2003L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private boolean c(bguz parambguz)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambguz != null) {
      if (!(parambguz instanceof bdwb))
      {
        bool1 = bool2;
        if (!(parambguz instanceof bdwa)) {}
      }
      else
      {
        parambguz = (bdsx)parambguz;
        bool1 = bool2;
        if (parambguz.c() != 1003L)
        {
          bool1 = bool2;
          if (parambguz.d() != 2003L) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private boolean d(bguz parambguz)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (parambguz != null)
    {
      bool1 = bool2;
      if ((parambguz instanceof bdxi))
      {
        bool1 = bool2;
        if (((bdsx)parambguz).c() != 1003L) {
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
      paramString1 = (bguz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof bdsx)) {
        return ((bdsx)paramString1).f();
      }
    }
    return 0;
  }
  
  public bdsx a(bdzn parambdzn)
  {
    if (parambdzn == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.e("Q.richmedia.TransFileController", 2, parambdzn.toString());
    }
    if (parambdzn.b == 131078)
    {
      if (parambdzn.jdField_a_of_type_Boolean) {
        return new bdwl(this, parambdzn);
      }
      return new bdwk(this, parambdzn);
    }
    if (parambdzn.b == 262153)
    {
      if (parambdzn.jdField_a_of_type_Boolean) {
        return new bdyc(this, parambdzn);
      }
      return new bdyb(this, parambdzn);
    }
    if (parambdzn.b == 327689) {
      return new bdwd(this, parambdzn);
    }
    if (parambdzn.b == 327696) {
      return new bdxi(this, parambdzn);
    }
    if (parambdzn.b == 66) {
      return new bdyg(this, parambdzn);
    }
    if ((parambdzn.b == 52) && (parambdzn.jdField_a_of_type_Boolean)) {
      return new bdup(this, parambdzn);
    }
    if (parambdzn.jdField_a_of_type_Int == 1026) {
      return b(parambdzn);
    }
    if ((parambdzn.jdField_a_of_type_Int == 1) || (parambdzn.jdField_a_of_type_Int == 3000)) {
      return c(parambdzn);
    }
    return f(parambdzn);
  }
  
  public bdzu a(bdzn parambdzn)
  {
    parambdzn.jdField_a_of_type_Boolean = false;
    parambdzn.jdField_a_of_type_Bdzu = new bdzu();
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      if (parambdzn.b == 131076)
      {
        localObject = new bdzz(this, parambdzn);
        a(parambdzn, (bdsx)localObject, a(parambdzn), true);
      }
    }
    for (;;)
    {
      return parambdzn.jdField_a_of_type_Bdzu;
      if ((parambdzn.jdField_a_of_type_Int == 1) || (parambdzn.jdField_a_of_type_Int == 3000))
      {
        localObject = new bdva(this, parambdzn);
        break;
      }
      localObject = new bdtg(this, parambdzn);
      break;
      localObject = parambdzn.jdField_a_of_type_Bdzu;
      ((bdzu)localObject).jdField_a_of_type_Int = -1;
      ((bdzu)localObject).jdField_a_of_type_Long = 9366L;
      ((bdzu)localObject).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
    }
  }
  
  public bguz a(String paramString)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      return (bguz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    }
    return null;
  }
  
  public bguz a(String paramString1, String paramString2, long paramLong)
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
      bguz localbguz = a(paramString2, paramLong1);
      if ((localbguz instanceof bdun)) {
        ((bdun)localbguz).a();
      }
    }
    paramString1 = new bdun(paramLong1, paramString1, paramQQAppInterface, paramInt1, paramString2, paramString3, paramString4, paramString5, paramLong2, paramInt2);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramString1);
  }
  
  public void a(StreamInfo paramStreamInfo, StreamData paramStreamData, long paramLong1, long paramLong2, long paramLong3, long paramLong4, ptt_reserve.ReserveStruct paramReserveStruct)
  {
    Object localObject2 = bcvj.a(paramStreamInfo.iMsgId, 1);
    long l1 = paramStreamInfo.lFromUIN;
    long l2 = paramStreamInfo.lToUIN;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = bdtd.a(String.valueOf(l2), null, 2, null);
      int i = bgjw.a(paramStreamInfo.pttFormat);
      localObject2 = MessageForPtt.getLocalFilePath(i, (String)localObject1);
      bcvj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, i, (String)localObject2, 1, paramStreamInfo.iMsgId);
      bcvj.a((String)localObject2, (short)paramStreamInfo.msgSeq);
      bcvj.b((String)localObject2, paramStreamInfo.random);
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
          localObject = (awxi)((QQAppInterface)localObject).getManager(324);
        } while (!((awxi)localObject).a(paramChatMessage));
        ((awxi)localObject).b(paramChatMessage, 0L, 0, 256);
        return;
      } while (!(paramChatMessage instanceof MessageForPic));
      paramChatMessage = (MessageForPic)paramChatMessage;
      a(paramChatMessage, 131075);
      a(paramChatMessage, 1);
      a(paramChatMessage, 131075);
      localObject = (awxi)((QQAppInterface)localObject).getManager(324);
    } while (!((awxi)localObject).a(paramChatMessage));
    ((awxi)localObject).b(paramChatMessage, 0L, 0, 24);
  }
  
  public void a(MessageForPic paramMessageForPic, int paramInt)
  {
    paramMessageForPic = a(a(paramMessageForPic.md5, paramMessageForPic.uuid, paramInt));
    if ((paramMessageForPic != null) && ((paramMessageForPic instanceof bdsx))) {
      ((bdsx)paramMessageForPic).a();
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
        Object localObject = (bguz)((Map.Entry)localIterator.next()).getValue();
        if (a((bguz)localObject))
        {
          localObject = (bdsx)localObject;
          if ((paramString.equals(((bdsx)localObject).a.jdField_c_of_type_JavaLangString)) && (((bdsx)localObject).m))
          {
            ((bdsx)localObject).b();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "resume pic:" + ((bdsx)localObject).a.jdField_a_of_type_Long);
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
      bguz localbguz = (bguz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      switch (paramInt)
      {
      case 1: 
      case 2: 
      default: 
        break;
      case 0: 
        if (((localbguz instanceof bdtd)) && (paramString.equals(((bdtd)localbguz).a.p)))
        {
          ((bdsx)localbguz).k();
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
        Object localObject = (bguz)((Map.Entry)localIterator.next()).getValue();
        if (a((bguz)localObject))
        {
          localObject = (bdsx)localObject;
          if ((paramString.equals(((bdsx)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((bdsx)localObject).a.jdField_a_of_type_Long))
          {
            ((bdsx)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((bdsx)localObject).a.jdField_a_of_type_Long);
            }
          }
        }
      }
    }
  }
  
  public void a(String paramString, bdzl parambdzl)
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
        Object localObject = (bguz)((Map.Entry)localIterator.next()).getValue();
        if (a((bguz)localObject))
        {
          localObject = (bdsx)localObject;
          if ((paramString.equals(((bdsx)localObject).a.jdField_c_of_type_JavaLangString)) && (((bdsx)localObject).d()))
          {
            ((bdsx)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel pic:" + ((bdsx)localObject).a.jdField_a_of_type_Long);
            }
            if (((bdsx)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
              localArrayList.add(((bdsx)localObject).a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
            }
          }
        }
      }
    } while (parambdzl == null);
    parambdzl.a(localArrayList);
  }
  
  public void a(String paramString, bguz parambguz)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, parambguz);
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    boolean bool = false;
    if (localIterator.hasNext())
    {
      Object localObject = (bguz)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof bdsx))) {
        break label171;
      }
      localObject = (bdsx)localObject;
      if ((!((bdsx)localObject).o) || (((bdsx)localObject).m)) {
        break label171;
      }
      ((bdsx)localObject).c();
      if (((bdsx)localObject).b() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((bdsx)localObject).b());
      }
      if (QLog.isColorLevel()) {
        QLog.d("short_video", 2, "pauseAllShortVideoSend key:" + ((bdsx)localObject).b());
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
      Object localObject = (bguz)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof bdtc))) {
        break label175;
      }
      localObject = (bdtc)localObject;
      if ((((bdtc)localObject).a == null) || (!((bdtc)localObject).a.i)) {
        break label175;
      }
      ((bdtc)localObject).u = paramLong;
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
  
  public boolean a(bdzn parambdzn)
  {
    try
    {
      boolean bool = super.a(parambdzn);
      return bool;
    }
    finally
    {
      parambdzn = finally;
      throw parambdzn;
    }
  }
  
  public boolean a(bdzn parambdzn, MessageRecord paramMessageRecord)
  {
    try
    {
      boolean bool = a(parambdzn);
      return bool;
    }
    finally
    {
      parambdzn = finally;
      throw parambdzn;
    }
  }
  
  /* Error */
  public boolean a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 61	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   9: aload_1
    //   10: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: lload_2
    //   14: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   17: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 163	bdzi:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   25: aload_1
    //   26: invokevirtual 277	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   29: ifeq +31 -> 60
    //   32: aload_0
    //   33: getfield 163	bdzi:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   36: aload_1
    //   37: invokevirtual 167	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 645	bdyi
    //   43: astore_1
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 646	bdyi:c	()V
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
    //   0	71	0	this	bdzi
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
        bdtd localbdtd = new bdtd(paramString1, paramString2, false, null, null, 2, -1, false, this, paramLong1);
        localbdtd.a(paramLong1);
        localbdtd.a().jdField_c_of_type_JavaLangString = paramString2;
        localbdtd.c(paramString1 + paramString2 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramString2 + paramLong1, localbdtd);
        localbdtd.a(paramStreamInfo, paramStreamData, paramLong2, paramLong3, paramLong4, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (bdtd)a(paramString1 + paramString2 + paramLong1);
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
        paramString2 = new bdtd(paramString1, paramString2, true, null, null, 2, -1, false, this, paramLong1);
        paramString2.a(paramLong1);
        paramString2.f();
        paramString2.c(paramString1 + paramLong1);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1 + paramLong1, paramString2);
        paramString2.a(paramShort, false, paramInt1, paramInt2, paramLong2, paramBundle);
        return true;
      }
      return false;
    }
    paramString1 = (bdtd)a(paramString1, paramString2, paramLong1);
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
      paramString1 = (bguz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if ((paramString1 instanceof bdsx)) {
        return (int)((bdsx)paramString1).c();
      }
    }
    return -1;
  }
  
  public bdsx b(bdzn parambdzn)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PttShow", 2, "getProcessor UIN_TYPE_HOTCHAT_TOPIC  isUp = " + parambdzn.jdField_a_of_type_Boolean);
    }
    if (parambdzn.jdField_a_of_type_Boolean) {
      return new bdvb(this, parambdzn);
    }
    if (parambdzn.b == 2) {
      return new GroupPttDownloadProcessor(this, parambdzn);
    }
    return null;
  }
  
  public bdzu b(bdzn parambdzn)
  {
    parambdzn.jdField_a_of_type_Boolean = false;
    parambdzn.jdField_a_of_type_Bdzu = new bdzu();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean)
      {
        Object localObject1;
        if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null))
        {
          localObject1 = parambdzn.jdField_a_of_type_Bdzu;
          ((bdzu)localObject1).jdField_a_of_type_Int = -1;
          ((bdzu)localObject1).jdField_a_of_type_Long = 9366L;
          ((bdzu)localObject1).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          parambdzn = parambdzn.jdField_a_of_type_Bdzu;
          return parambdzn;
        }
        try
        {
          if (parambdzn.b == 131076)
          {
            localObject1 = new bdzz(this, parambdzn);
            a(parambdzn, (bdsx)localObject1, a(parambdzn), false);
            return parambdzn.jdField_a_of_type_Bdzu;
          }
          if ((parambdzn.jdField_a_of_type_Int == 1) || (parambdzn.jdField_a_of_type_Int == 3000))
          {
            localObject1 = new bdva(this, parambdzn);
            continue;
            parambdzn = finally;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          localObject2 = parambdzn.jdField_a_of_type_Bdzu;
          ((bdzu)localObject2).jdField_a_of_type_Int = -1;
          ((bdzu)localObject2).jdField_a_of_type_Long = 9366L;
          ((bdzu)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
          parambdzn = parambdzn.jdField_a_of_type_Bdzu;
          return parambdzn;
        }
      }
      Object localObject2 = new bdtg(this, parambdzn);
      continue;
      localObject2 = parambdzn.jdField_a_of_type_Bdzu;
      ((bdzu)localObject2).jdField_a_of_type_Int = -1;
      ((bdzu)localObject2).jdField_a_of_type_Long = 9366L;
      ((bdzu)localObject2).jdField_a_of_type_JavaLangString = "transfilecontroller closed";
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
        Object localObject = (bguz)((Map.Entry)localIterator.next()).getValue();
        if (c((bguz)localObject))
        {
          localObject = (bdsx)localObject;
          if ((paramString.equals(((bdsx)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((bdsx)localObject).a.jdField_a_of_type_Long))
          {
            ((bdsx)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "cancel JSPTT:" + ((bdsx)localObject).a.jdField_a_of_type_Long);
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
      Object localObject = (bguz)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof bdsx))) {
        break label211;
      }
      localObject = (bdsx)localObject;
      if ((!((bdsx)localObject).p) || (((bdsx)localObject).m)) {
        break label211;
      }
      ((bdsx)localObject).c();
      if (((bdsx)localObject).b() != null) {
        this.jdField_a_of_type_JavaUtilArrayList.add(((bdsx)localObject).b());
      }
      localStringBuilder.append(((bdsx)localObject).b());
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
    if ((paramString != null) && ((paramString instanceof bdsx)))
    {
      paramString = (bdsx)paramString;
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
    //   5: new 61	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   12: aload_1
    //   13: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: lload_2
    //   17: invokevirtual 185	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   20: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   23: astore_1
    //   24: aload_0
    //   25: getfield 163	bdzi:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   28: aload_1
    //   29: invokevirtual 277	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   32: ifeq +36 -> 68
    //   35: aload_0
    //   36: getfield 163	bdzi:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   39: aload_1
    //   40: invokevirtual 167	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   43: checkcast 169	bguz
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +17 -> 65
    //   51: aload_1
    //   52: instanceof 731
    //   55: ifeq +18 -> 73
    //   58: aload_1
    //   59: checkcast 731	bdyr
    //   62: invokevirtual 732	bdyr:c	()V
    //   65: iconst_1
    //   66: istore 4
    //   68: aload_0
    //   69: monitorexit
    //   70: iload 4
    //   72: ireturn
    //   73: aload_1
    //   74: instanceof 734
    //   77: ifeq -12 -> 65
    //   80: aload_1
    //   81: checkcast 734	bdyk
    //   84: invokevirtual 735	bdyk:c	()V
    //   87: goto -22 -> 65
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	bdzi
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
      paramString2 = (bdtd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.k();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public bdsx c(bdzn parambdzn)
  {
    if (parambdzn.jdField_a_of_type_Boolean)
    {
      if ((parambdzn.b == 6) || (parambdzn.b == 17) || (parambdzn.b == 9)) {
        return new bdyr(this, parambdzn);
      }
      if (parambdzn.b == 20) {
        return new bdyk(this, parambdzn);
      }
      if (parambdzn.b == 55) {
        return new bdzw(this, parambdzn);
      }
      if (parambdzn.jdField_e_of_type_Int == 1045) {
        return new bdvj(this, parambdzn);
      }
      if (parambdzn.b == 2) {
        return new bdvf(this, parambdzn);
      }
      return new bdvb(this, parambdzn);
    }
    if (parambdzn.b == 2) {
      return new GroupPttDownloadProcessor(this, parambdzn);
    }
    if ((parambdzn.b == 1) || (parambdzn.b == 65537) || (parambdzn.b == 131075)) {
      return new bdva(this, parambdzn);
    }
    if ((parambdzn.b == 6) || (parambdzn.b == 7) || (parambdzn.b == 17) || (parambdzn.b == 18) || (parambdzn.b == 9) || (parambdzn.b == 16)) {
      return new bdyi(this, parambdzn);
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
      if ((localObject != null) && ((localObject instanceof bdsx)))
      {
        localObject = (bdsx)localObject;
        if (((bdsx)localObject).m)
        {
          ((bdsx)localObject).b();
          localStringBuilder.append(((bdsx)localObject).b());
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
      Object localObject = (bguz)((Map.Entry)localIterator.next()).getValue();
      if (b((bguz)localObject))
      {
        ThreadManager.getSubThreadHandler().removeCallbacks((StructLongMessageDownloadProcessor)localObject);
        localObject = (bdsx)localObject;
        if ((paramString.equals(((bdsx)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((bdsx)localObject).a.jdField_a_of_type_Long))
        {
          ((bdsx)localObject).a();
          if (QLog.isColorLevel()) {
            QLog.d("cancelpic", 2, "cancel PALongMsg:" + ((bdsx)localObject).a.jdField_a_of_type_Long);
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
      Object localObject = (bguz)((Map.Entry)localIterator.next()).getValue();
      if ((localObject == null) || (!(localObject instanceof bdsx))) {
        break label178;
      }
      localObject = (bdsx)localObject;
      if ((!((bdsx)localObject).n) || (((bdsx)localObject).m)) {
        break label178;
      }
      ((bdsx)localObject).c();
      if (((bdsx)localObject).b() != null) {
        this.jdField_b_of_type_JavaUtilArrayList.add(((bdsx)localObject).b());
      }
      if (QLog.isColorLevel()) {
        QLog.d("raw_photo", 2, "pauseAllRawSend key:" + ((bdsx)localObject).b());
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
      Object localObject = (bguz)((Map.Entry)localIterator.next()).getValue();
      bool1 = bool2;
      if (a((bguz)localObject))
      {
        localObject = (bdsx)localObject;
        bool1 = bool2;
        if (paramString.equals(((bdsx)localObject).a.jdField_c_of_type_JavaLangString))
        {
          bool1 = bool2;
          if (!((bdsx)localObject).m)
          {
            ((bdsx)localObject).c();
            bool2 = true;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("cancelpic", 2, "pause pic:" + ((bdsx)localObject).a.jdField_a_of_type_Long);
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
          paramString = (bguz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (((paramString instanceof bdyr)) && (((bdyr)paramString).d()))
          {
            ((bdyr)paramString).b();
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
      paramString2 = (bdtd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.k();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      return true;
    }
    return false;
  }
  
  public bdsx d(bdzn parambdzn)
  {
    if (parambdzn.b == 2) {
      return new bdtl(this, parambdzn);
    }
    if (parambdzn.b == 32) {
      return new bdwb(this, parambdzn);
    }
    if ((parambdzn.b == 6) || (parambdzn.b == 17) || (parambdzn.b == 9)) {
      return new bdyr(this, parambdzn);
    }
    if (jdField_a_of_type_JavaUtilHashSet.contains(Integer.valueOf(parambdzn.b))) {
      return new bdwp(this, parambdzn);
    }
    if (parambdzn.b == 20) {
      return new bdyk(this, parambdzn);
    }
    if (parambdzn.b == 24) {
      return new bdsp(this, parambdzn);
    }
    if ((parambdzn.b == 196609) || (parambdzn.b == 196610) || (parambdzn.b == 327681)) {
      return new bdza(this, parambdzn);
    }
    if (parambdzn.jdField_e_of_type_Int == 1045) {
      return new bdtp(this, parambdzn);
    }
    return new bdth(this, parambdzn);
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
        Object localObject = (bguz)((Map.Entry)localIterator.next()).getValue();
        if (d((bguz)localObject))
        {
          localObject = (bdsx)localObject;
          if ((paramString.equals(((bdsx)localObject).a.jdField_c_of_type_JavaLangString)) && (paramLong == ((bdsx)localObject).a.jdField_a_of_type_Long))
          {
            ((bdsx)localObject).a();
            if (QLog.isColorLevel()) {
              QLog.d("cancelpic", 2, "PttSliceUploadProcessor cancelVoiceTextTask:" + ((bdsx)localObject).a.jdField_a_of_type_Long);
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
        bguz localbguz = (bguz)((Map.Entry)localIterator.next()).getValue();
        if ((!a(localbguz)) || (!paramString.equals(((bdsx)localbguz).a.jdField_c_of_type_JavaLangString))) {
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
          bguz localbguz = (bguz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
          if (localbguz != null)
          {
            if ((localbguz instanceof bdyr)) {
              ((bdyr)localbguz).c();
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
            bool = true;
            return bool;
          }
          if (!(localbguz instanceof bdyk)) {
            continue;
          }
          ((bdyk)localbguz).c();
          continue;
        }
        boolean bool = false;
      }
      finally {}
    }
  }
  
  public bdsx e(bdzn parambdzn)
  {
    if (parambdzn.b == 2) {
      return new C2CPttDownloadProcessor(this, parambdzn);
    }
    if (parambdzn.b == 32) {
      return new bdwa(this, parambdzn);
    }
    if (parambdzn.b == 33) {
      return new bdwx(this, parambdzn);
    }
    if ((parambdzn.b == 6) || (parambdzn.b == 7) || (parambdzn.b == 17) || (parambdzn.b == 18) || (parambdzn.b == 9) || (parambdzn.b == 16)) {
      return new bdyi(this, parambdzn);
    }
    if ((parambdzn.b == 1) || (parambdzn.b == 65537) || (parambdzn.b == 131075)) {
      return new bdtg(this, parambdzn);
    }
    if (parambdzn.b == 131079) {
      return new StructLongMessageDownloadProcessor(this, parambdzn);
    }
    return null;
  }
  
  public boolean e(String paramString, long paramLong)
  {
    paramString = paramString + paramLong;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      bguz localbguz = (bguz)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if ((localbguz instanceof bdyi))
      {
        ((bdyi)localbguz).c();
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
        return true;
      }
    }
    return false;
  }
  
  public bdsx f(bdzn parambdzn)
  {
    if (parambdzn.jdField_a_of_type_Boolean) {
      return d(parambdzn);
    }
    return e(parambdzn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdzi
 * JD-Core Version:    0.7.0.1
 */