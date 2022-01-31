import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.data.ChatMessage;>;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public class aukw
  implements Handler.Callback, aukq, aweh, awfy
{
  protected QQAppInterface a;
  protected List<aukp> a;
  protected Map<String, auld> a;
  protected AtomicBoolean a;
  protected MqqHandler a;
  
  public aukw(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localObject = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1) {
        localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)localObject);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(ThreadManager.getSubThreadLooper(), this);
    paramQQAppInterface = new aulf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = new auli(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    aulh localaulh = new aulh(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    auko localauko = new auko(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localaulh);
    this.jdField_a_of_type_JavaUtilList.add(localauko);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, @NonNull ArrayList<ChatMessage> paramArrayList, HashMap<String, String> paramHashMap, HashMap<String, ArrayList<MessageRecord>> paramHashMap1)
  {
    Object localObject1 = paramHashMap1;
    if (paramHashMap1 == null) {
      localObject1 = new HashMap();
    }
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1 = paramArrayList.iterator();
    int j;
    for (int i = 0; localIterator1.hasNext(); i = j + 1)
    {
      paramArrayList = (MessageRecord)localIterator1.next();
      localArrayList1.add(paramArrayList);
      aule.a(paramArrayList, (String)paramHashMap.get(abot.c(paramArrayList)), paramMessageForStructing);
      j = i;
      if (aule.a((ChatMessage)paramArrayList))
      {
        j = 0;
        int k = 0;
        MessageForStructing localMessageForStructing = (MessageForStructing)paramArrayList;
        HashMap localHashMap = paramQQAppInterface.a().a(localMessageForStructing);
        if (localHashMap.size() > 0)
        {
          Iterator localIterator2 = localHashMap.keySet().iterator();
          j = k;
          while (localIterator2.hasNext())
          {
            paramArrayList = (String)localIterator2.next();
            ArrayList localArrayList2 = (ArrayList)localHashMap.get(paramArrayList);
            j = localArrayList2.size();
            paramHashMap1 = paramArrayList;
            if (paramArrayList.equalsIgnoreCase("MultiMsg"))
            {
              paramHashMap1 = String.valueOf(((HashMap)localObject1).size());
              localMessageForStructing.structingMsg.mFileName = paramHashMap1;
              localMessageForStructing.doPrewrite();
            }
            Iterator localIterator3 = localArrayList2.iterator();
            while (localIterator3.hasNext())
            {
              MessageRecord localMessageRecord = (MessageRecord)localIterator3.next();
              Object localObject2 = localMessageRecord.getExtInfoFromExtStr("self_nickname");
              paramArrayList = (ArrayList<ChatMessage>)localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                paramArrayList = aukx.a().a(localMessageRecord.senderuin, localMessageRecord.msgseq, paramQQAppInterface);
              }
              if (paramArrayList != null)
              {
                localObject2 = paramArrayList;
                if (paramArrayList.trim().length() != 0) {}
              }
              else
              {
                localObject2 = aule.a(localMessageRecord.senderuin);
              }
              aule.a(localMessageRecord, (String)localObject2, paramMessageForStructing);
            }
            ((HashMap)localObject1).put(paramHashMap1, localArrayList2);
          }
        }
        j = i + j;
      }
    }
    paramMessageForStructing.structingMsg.mTSum = i;
    paramMessageForStructing.doPrewrite();
    ((HashMap)localObject1).put("MultiMsg", localArrayList1);
    aule.b("step.preHandle.mTSum = %d", new Object[] { Integer.valueOf(i) });
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(int paramInt1, int paramInt2, auld paramauld)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    paramauld.a(paramInt2);
    paramauld.a(paramInt1, paramInt2);
    if (paramauld.a() == 0)
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3);
      localMessage.obj = paramauld;
      localMessage.sendToTarget();
    }
    aule.a("step.onUploadFinish:resultCode = %d,richMask = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramauld.a()), Integer.valueOf(paramauld.b()) });
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  protected void a(auld paramauld)
  {
    Object localObject1 = paramauld.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (ArrayList)paramauld.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
      if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
          if ((localObject3 instanceof MessageForReplyText))
          {
            localObject3 = (MessageForReplyText)localObject3;
            if ((((MessageForReplyText)localObject3).getSourceMessage() != null) && (((MessageForReplyText)localObject3).mSourceMsgInfo != null))
            {
              ((MessageForReplyText)localObject3).getSourceMessage().createMessageUniseq();
              ((MessageForReplyText)localObject3).mSourceMsgInfo.setUniSeq(((MessageForReplyText)localObject3).getSourceMessage().uniseq, true);
              ((MessageForReplyText)localObject3).mSourceMsgInfo.packSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((MessageForReplyText)localObject3).getSourceMessage());
              if ((paramauld.g > 0) || (paramauld.jdField_b_of_type_Int == 0) || (paramauld.jdField_b_of_type_Int == 9))
              {
                ((MessageForReplyText)localObject3).mSourceMsgInfo.mSourceMsgTroopName = null;
                azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A5D2", "0X800A5D2", 0, 0, "", "", "", "");
              }
              try
              {
                ((MessageForReplyText)localObject3).saveExtInfoToExtStr("sens_msg_source_msg_info", bdcv.a(ammq.a(((MessageForReplyText)localObject3).mSourceMsgInfo)));
                if (arni.a(((MessageForReplyText)localObject3).getSourceMessage()))
                {
                  String str = ((MessageForReplyText)localObject3).getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
                  ChatMessage localChatMessage = arni.a((ChatMessage)((MessageForReplyText)localObject3).getSourceMessage());
                  aroo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, ((MessageForReplyText)localObject3).getSourceMessage());
                  if ((!TextUtils.isEmpty(str)) && (localChatMessage != null))
                  {
                    int i = Integer.parseInt(str);
                    if ((i == 1) || (i == 2)) {
                      arni.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)((MessageForReplyText)localObject3).getSourceMessage());
                    }
                  }
                }
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
          }
        }
      }
    }
    if (paramauld.jdField_a_of_type_JavaUtilHashMap.containsKey("reply_msg")) {
      paramauld.jdField_a_of_type_JavaUtilHashMap.remove("reply_msg");
    }
    b(paramauld);
    if (paramauld.b() != 0)
    {
      c(paramauld);
      return;
    }
    localObject1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
    ((Message)localObject1).obj = paramauld;
    ((Message)localObject1).sendToTarget();
  }
  
  public void a(awei paramawei)
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    QQAppInterface localQQAppInterface;
    Object localObject2;
    long l;
    auld localauld;
    List localList;
    do
    {
      do
      {
        do
        {
          return;
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        } while (localQQAppInterface == null);
        localObject2 = paramawei.d;
        l = paramawei.jdField_a_of_type_Long;
        localauld = (auld)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        aule.b("onDownloadResp: mUniseq = %d,resIdStr = %s,errcode = %d", new Object[] { Long.valueOf(l), paramawei.e, Integer.valueOf(paramawei.jdField_b_of_type_Int) });
      } while (localauld == null);
      localList = localauld.jdField_b_of_type_JavaUtilList;
    } while (localList == null);
    label288:
    for (;;)
    {
      try
      {
        Iterator localIterator = localList.iterator();
        if (localIterator.hasNext())
        {
          localObject2 = (MessageForStructing)localIterator.next();
          if (((MessageForStructing)localObject2).uniseq != l) {
            break label288;
          }
          localObject1 = localObject2;
          break label288;
        }
        if (localObject1 == null) {
          return;
        }
      }
      finally {}
      if (paramawei.jdField_b_of_type_Int == 0)
      {
        localList.remove(localObject1);
        localObject2 = new HashMap();
        localQQAppInterface.a().a().a(paramawei.jdField_a_of_type_ArrayOfByte, (HashMap)localObject2, localObject1, null);
      }
      for (;;)
      {
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        e(localauld);
        return;
        paramawei = localQQAppInterface.a().a(localObject1, aukv.jdField_b_of_type_JavaLangString, false);
        int i = localauld.jdField_a_of_type_JavaUtilList.indexOf(localObject1);
        if (i >= 0) {
          localauld.jdField_a_of_type_JavaUtilList.set(i, (ChatMessage)paramawei);
        }
      }
    }
  }
  
  public void a(awfz paramawfz) {}
  
  public void a(QQAppInterface paramQQAppInterface, auld paramauld)
  {
    List localList = paramauld.jdField_b_of_type_JavaUtilList;
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)localIterator.next();
      baub localbaub = new baub();
      localbaub.jdField_a_of_type_Boolean = false;
      localbaub.jdField_b_of_type_Int = 131078;
      localbaub.l = localMessageForStructing.structingMsg.mResid;
      localbaub.jdField_b_of_type_JavaLangString = localMessageForStructing.selfuin;
      localbaub.c = localMessageForStructing.frienduin;
      localbaub.d = localMessageForStructing.frienduin;
      localbaub.jdField_a_of_type_Int = localMessageForStructing.istroop;
      localbaub.jdField_a_of_type_Long = localMessageForStructing.uniseq;
      localbaub.e = 1035;
      localbaub.jdField_a_of_type_Aweh = this;
      localbaub.jdField_a_of_type_JavaLangString = paramauld.a();
      paramQQAppInterface.a().a(localbaub);
      aule.b("downloadNestMultiMsg mUniseq = %d,resIdStr = %s", new Object[] { Long.valueOf(localbaub.jdField_a_of_type_Long), localbaub.l });
    }
    aule.b("downloadNestMultiMsg msgSize = %d ", new Object[] { Integer.valueOf(localList.size()) });
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, auld paramauld)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramauld.jdField_a_of_type_JavaUtilList;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (aule.a(localChatMessage))
      {
        Object localObject = (MessageForStructing)localChatMessage;
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mResid == null))
        {
          localObject = paramQQAppInterface.a().a(localChatMessage, aukv.jdField_a_of_type_JavaLangString, false);
          localList.set(localList.indexOf(localChatMessage), (ChatMessage)localObject);
        }
        else if (paramQQAppInterface.a().a((MessageRecord)localObject).size() == 0)
        {
          localArrayList.add((MessageForStructing)localChatMessage);
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      paramauld.jdField_b_of_type_JavaUtilList = localArrayList;
      return true;
    }
    return false;
  }
  
  protected void b(auld paramauld)
  {
    amgm localamgm = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Iterator localIterator = paramauld.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ArrayList)paramauld.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord instanceof MessageForReplyText))
          {
            if (localamgm != null) {
              localamgm.a(localMessageRecord, null);
            }
          }
          else if (((localMessageRecord instanceof MessageForMixedMsg)) && (((MessageForMixedMsg)localMessageRecord).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) && (localamgm != null)) {
            localamgm.a(localMessageRecord, null);
          }
        }
      }
    }
  }
  
  public void b(awfz paramawfz)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    label769:
    for (;;)
    {
      Object localObject1;
      try
      {
        long l = ((Long)paramawfz.jdField_a_of_type_JavaLangObject).longValue();
        localObject1 = null;
        localObject2 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (((auld)this.jdField_a_of_type_JavaUtilMap.get(localObject3)).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq != l) {
            break label769;
          }
          localObject1 = (auld)this.jdField_a_of_type_JavaUtilMap.get(localObject3);
          continue;
        }
        if (localObject1 == null) {
          break;
        }
      }
      catch (Exception paramawfz)
      {
        QLog.e("MultiMsg_TAG", 1, paramawfz, new Object[0]);
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(((auld)localObject1).a());
      Object localObject2 = ((auld)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
      Object localObject3 = ((auld)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int i = ((auld)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (((auld)localObject1).jdField_b_of_type_Int == 2)
      {
        if (paramawfz.jdField_a_of_type_Int == 0)
        {
          ((MessageForStructing)localObject2).structingMsg.mResid = paramawfz.c;
          ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
        }
        i = ((auld)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.g;
        new aula(localQQAppInterface, (MessageRecord)localObject2, (String)localObject3, i, (ArrayList)((auld)localObject1).jdField_a_of_type_JavaUtilHashMap.get("MultiMsg"), (HashMap)((auld)localObject1).jdField_a_of_type_JavaUtilMap).b(paramawfz);
        aule.a("step.onUploadPbFinish:resultCode = %d,uniseq = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(paramawfz.jdField_a_of_type_Int), Long.valueOf(((MessageForStructing)localObject2).uniseq), Integer.valueOf(((auld)localObject1).a()), Integer.valueOf(((auld)localObject1).b()) });
        if (i != 0) {
          break label563;
        }
        i = 1;
      }
      for (;;)
      {
        label331:
        paramawfz = ((MessageForStructing)localObject2).frienduin;
        int m = ((MessageForStructing)localObject2).structingMsg.mTSum;
        int n = ((auld)localObject1).c;
        int i1 = ((auld)localObject1).d;
        int i2 = ((auld)localObject1).e;
        int i3 = ((auld)localObject1).f;
        localObject1 = ((auld)localObject1).jdField_a_of_type_JavaUtilHashMap;
        localObject2 = ((HashMap)localObject1).keySet().iterator();
        int k = 0;
        int j = 0;
        label648:
        for (;;)
        {
          if (!((Iterator)localObject2).hasNext()) {
            break label651;
          }
          localObject3 = ((ArrayList)((HashMap)localObject1).get((String)((Iterator)localObject2).next())).iterator();
          for (;;)
          {
            if (!((Iterator)localObject3).hasNext()) {
              break label648;
            }
            MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
            if (localMessageRecord.msgtype == -2022)
            {
              j += 1;
              continue;
              if (paramawfz.jdField_a_of_type_Int == 0)
              {
                ((MessageForStructing)localObject2).structingMsg.mResid = paramawfz.c;
                ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
                localQQAppInterface.a().a((String)localObject3, i, ((MessageForStructing)localObject2).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
                localQQAppInterface.a().b((MessageRecord)localObject2, null);
                break;
              }
              ((auld)localObject1).a(1, 65536);
              c((auld)localObject1);
              break;
              label563:
              if ((i == 3000) || (i == 1))
              {
                i = 2;
                break label331;
              }
              if ((i == 1000) || (i == 1004))
              {
                i = 3;
                break label331;
              }
              if (!ChatActivityUtils.a(localQQAppInterface, ((auld)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
                break label764;
              }
              i = 4;
              break label331;
            }
            if ((localMessageRecord.msgtype == -2005) || (localMessageRecord.msgtype == -2017)) {
              k += 1;
            }
          }
        }
        label651:
        azmj.b(localQQAppInterface, "CliOper", "", paramawfz, "0X8009AC0", "0X8009AC0", i, 0, m + "", n + i1 + i2 + i3 + "", "" + j, "" + k);
        return;
        label764:
        i = 1;
      }
    }
  }
  
  protected void c(auld paramauld)
  {
    if (paramauld == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    MessageForStructing localMessageForStructing = paramauld.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
    String str = paramauld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i = paramauld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localMessageForStructing.extraflag = 32768;
    localQQAppInterface.a().a(str, i, localMessageForStructing.uniseq);
    paramauld = localQQAppInterface.a().a(str, i);
    if ((paramauld != null) && (paramauld.uniseq == localMessageForStructing.uniseq)) {
      paramauld.extraflag = 32768;
    }
    long l = localMessageForStructing.uniseq;
    ((MessageHandler)localQQAppInterface.a(0)).notifyUI(MessageHandler.a(i), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  protected void d(auld paramauld) {}
  
  public void e(auld paramauld)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localObject == null);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramauld.a())) {
      this.jdField_a_of_type_JavaUtilMap.put(paramauld.a(), paramauld);
    }
    if (a((QQAppInterface)localObject, paramauld))
    {
      a((QQAppInterface)localObject, paramauld);
      return;
    }
    if (paramauld.jdField_a_of_type_Int == 0) {}
    for (int i = 0;; i = 2)
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(i);
      ((Message)localObject).obj = paramauld;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  public void f(auld paramauld)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      } while (localObject1 == null);
      Object localObject3 = paramauld.jdField_a_of_type_JavaUtilList;
      HashMap localHashMap = (HashMap)paramauld.jdField_a_of_type_JavaUtilMap;
      localObject2 = paramauld.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
      localObject3 = a((QQAppInterface)localObject1, (MessageForStructing)localObject2, (ArrayList)localObject3, localHashMap, null);
      localObject1 = ((QQAppInterface)localObject1).a().a().a((MessageRecord)localObject2, (HashMap)localObject3, null, true, true);
      paramauld.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localObject1);
    } while (((HashMap)localObject1).size() == 0);
    paramauld.a(15);
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((aukp)((Iterator)localObject2).next()).a(paramauld, (HashMap)localObject1, this);
    }
    aule.b("step.uploadRichStart", new Object[0]);
  }
  
  protected void g(auld paramauld)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    byte[] arrayOfByte = localQQAppInterface.a().a().a(paramauld.jdField_a_of_type_JavaUtilHashMap, (HashMap)paramauld.jdField_a_of_type_JavaUtilMap, true);
    if (arrayOfByte == null)
    {
      paramauld.a(99, 99);
      c(paramauld);
      return;
    }
    String str1 = localQQAppInterface.getAccount();
    String str2 = paramauld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    String str3 = paramauld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
    int i = paramauld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramauld.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq;
    paramauld.c = arrayOfByte.length;
    paramauld = new baub();
    paramauld.jdField_a_of_type_Boolean = true;
    paramauld.jdField_b_of_type_Int = 131078;
    paramauld.h = 0;
    paramauld.jdField_b_of_type_ArrayOfByte = arrayOfByte;
    paramauld.jdField_b_of_type_JavaLangString = str1;
    paramauld.c = str2;
    paramauld.d = str3;
    paramauld.jdField_a_of_type_Int = i;
    paramauld.jdField_a_of_type_Long = l;
    paramauld.e = 1035;
    paramauld.jdField_a_of_type_Awfy = this;
    localQQAppInterface.a().a(paramauld);
    aule.b("step.uploadPb.uniseq = %d,fileSize = %d", new Object[] { Long.valueOf(l), Integer.valueOf(arrayOfByte.length) });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    auld localauld = (auld)paramMessage.obj;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      d(localauld);
      continue;
      f(localauld);
      continue;
      g(localauld);
      continue;
      a(localauld);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aukw
 * JD-Core Version:    0.7.0.1
 */