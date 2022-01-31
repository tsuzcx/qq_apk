import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
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

public class astz
  implements Handler.Callback, astt, auna, auoq
{
  protected QQAppInterface a;
  protected List<asts> a;
  protected Map<String, asug> a;
  protected AtomicBoolean a;
  protected MqqHandler a;
  
  public astz(QQAppInterface paramQQAppInterface)
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
    paramQQAppInterface = new asui(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = new asul(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    asuk localasuk = new asuk(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    astr localastr = new astr(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localasuk);
    this.jdField_a_of_type_JavaUtilList.add(localastr);
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
      asuh.a(paramArrayList, (String)paramHashMap.get(akpx.c(paramArrayList)), paramMessageForStructing);
      j = i;
      if (asuh.a((ChatMessage)paramArrayList))
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
                paramArrayList = asua.a().a(localMessageRecord.senderuin, localMessageRecord.msgseq, paramQQAppInterface);
              }
              if (paramArrayList != null)
              {
                localObject2 = paramArrayList;
                if (paramArrayList.trim().length() != 0) {}
              }
              else
              {
                localObject2 = asuh.a(localMessageRecord.senderuin);
              }
              asuh.a(localMessageRecord, (String)localObject2, paramMessageForStructing);
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
    asuh.b("step.preHandle.mTSum = %d", new Object[] { Integer.valueOf(i) });
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(int paramInt1, int paramInt2, asug paramasug)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    paramasug.a(paramInt2);
    paramasug.a(paramInt1, paramInt2);
    if (paramasug.a() == 0)
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3);
      localMessage.obj = paramasug;
      localMessage.sendToTarget();
    }
    asuh.a("step.onUploadFinish:resultCode = %d,richMask = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramasug.a()), Integer.valueOf(paramasug.b()) });
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  protected void a(asug paramasug)
  {
    Object localObject1 = paramasug.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (ArrayList)paramasug.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
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
              if ((paramasug.g > 0) || (paramasug.jdField_b_of_type_Int == 0) || (paramasug.jdField_b_of_type_Int == 9))
              {
                ((MessageForReplyText)localObject3).mSourceMsgInfo.mSourceMsgTroopName = null;
                axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A5D2", "0X800A5D2", 0, 0, "", "", "", "");
              }
              try
              {
                ((MessageForReplyText)localObject3).saveExtInfoToExtStr("sens_msg_source_msg_info", bbea.a(akwa.a(((MessageForReplyText)localObject3).mSourceMsgInfo)));
                if (apug.a(((MessageForReplyText)localObject3).getSourceMessage()))
                {
                  String str = ((MessageForReplyText)localObject3).getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
                  ChatMessage localChatMessage = apug.a((ChatMessage)((MessageForReplyText)localObject3).getSourceMessage());
                  apvm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, ((MessageForReplyText)localObject3).getSourceMessage());
                  if ((!TextUtils.isEmpty(str)) && (localChatMessage != null))
                  {
                    int i = Integer.parseInt(str);
                    if ((i == 1) || (i == 2)) {
                      apug.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)((MessageForReplyText)localObject3).getSourceMessage());
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
    if (paramasug.jdField_a_of_type_JavaUtilHashMap.containsKey("reply_msg")) {
      paramasug.jdField_a_of_type_JavaUtilHashMap.remove("reply_msg");
    }
    b(paramasug);
    if (paramasug.b() != 0)
    {
      c(paramasug);
      return;
    }
    localObject1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
    ((Message)localObject1).obj = paramasug;
    ((Message)localObject1).sendToTarget();
  }
  
  public void a(aunb paramaunb)
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    QQAppInterface localQQAppInterface;
    Object localObject2;
    long l;
    asug localasug;
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
        localObject2 = paramaunb.d;
        l = paramaunb.jdField_a_of_type_Long;
        localasug = (asug)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        asuh.b("onDownloadResp: mUniseq = %d,resIdStr = %s,errcode = %d", new Object[] { Long.valueOf(l), paramaunb.e, Integer.valueOf(paramaunb.jdField_b_of_type_Int) });
      } while (localasug == null);
      localList = localasug.jdField_b_of_type_JavaUtilList;
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
      if (paramaunb.jdField_b_of_type_Int == 0)
      {
        localList.remove(localObject1);
        localObject2 = new HashMap();
        localQQAppInterface.a().a().a(paramaunb.jdField_a_of_type_ArrayOfByte, (HashMap)localObject2, localObject1, null);
      }
      for (;;)
      {
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        e(localasug);
        return;
        paramaunb = localQQAppInterface.a().a(localObject1, asty.jdField_b_of_type_JavaLangString, false);
        int i = localasug.jdField_a_of_type_JavaUtilList.indexOf(localObject1);
        if (i >= 0) {
          localasug.jdField_a_of_type_JavaUtilList.set(i, (ChatMessage)paramaunb);
        }
      }
    }
  }
  
  public void a(auor paramauor) {}
  
  public void a(QQAppInterface paramQQAppInterface, asug paramasug)
  {
    List localList = paramasug.jdField_b_of_type_JavaUtilList;
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)localIterator.next();
      aywc localaywc = new aywc();
      localaywc.jdField_a_of_type_Boolean = false;
      localaywc.jdField_b_of_type_Int = 131078;
      localaywc.l = localMessageForStructing.structingMsg.mResid;
      localaywc.jdField_b_of_type_JavaLangString = localMessageForStructing.selfuin;
      localaywc.c = localMessageForStructing.frienduin;
      localaywc.d = localMessageForStructing.frienduin;
      localaywc.jdField_a_of_type_Int = localMessageForStructing.istroop;
      localaywc.jdField_a_of_type_Long = localMessageForStructing.uniseq;
      localaywc.e = 1035;
      localaywc.jdField_a_of_type_Auna = this;
      localaywc.jdField_a_of_type_JavaLangString = paramasug.a();
      paramQQAppInterface.a().a(localaywc);
      asuh.b("downloadNestMultiMsg mUniseq = %d,resIdStr = %s", new Object[] { Long.valueOf(localaywc.jdField_a_of_type_Long), localaywc.l });
    }
    asuh.b("downloadNestMultiMsg msgSize = %d ", new Object[] { Integer.valueOf(localList.size()) });
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, asug paramasug)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramasug.jdField_a_of_type_JavaUtilList;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (asuh.a(localChatMessage))
      {
        Object localObject = (MessageForStructing)localChatMessage;
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mResid == null))
        {
          localObject = paramQQAppInterface.a().a(localChatMessage, asty.jdField_a_of_type_JavaLangString, false);
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
      paramasug.jdField_b_of_type_JavaUtilList = localArrayList;
      return true;
    }
    return false;
  }
  
  protected void b(asug paramasug)
  {
    akqa localakqa = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Iterator localIterator = paramasug.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ArrayList)paramasug.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord instanceof MessageForReplyText))
          {
            if (localakqa != null) {
              localakqa.a(localMessageRecord, null);
            }
          }
          else if (((localMessageRecord instanceof MessageForMixedMsg)) && (((MessageForMixedMsg)localMessageRecord).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) && (localakqa != null)) {
            localakqa.a(localMessageRecord, null);
          }
        }
      }
    }
  }
  
  public void b(auor paramauor)
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
        long l = ((Long)paramauor.jdField_a_of_type_JavaLangObject).longValue();
        localObject1 = null;
        localObject2 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (((asug)this.jdField_a_of_type_JavaUtilMap.get(localObject3)).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq != l) {
            break label769;
          }
          localObject1 = (asug)this.jdField_a_of_type_JavaUtilMap.get(localObject3);
          continue;
        }
        if (localObject1 == null) {
          break;
        }
      }
      catch (Exception paramauor)
      {
        QLog.e("MultiMsg_TAG", 1, paramauor, new Object[0]);
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(((asug)localObject1).a());
      Object localObject2 = ((asug)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
      Object localObject3 = ((asug)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
      int i = ((asug)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
      if (((asug)localObject1).jdField_b_of_type_Int == 2)
      {
        if (paramauor.jdField_a_of_type_Int == 0)
        {
          ((MessageForStructing)localObject2).structingMsg.mResid = paramauor.c;
          ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
        }
        i = ((asug)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.g;
        new asud(localQQAppInterface, (MessageRecord)localObject2, (String)localObject3, i, (ArrayList)((asug)localObject1).jdField_a_of_type_JavaUtilHashMap.get("MultiMsg"), (HashMap)((asug)localObject1).jdField_a_of_type_JavaUtilMap).b(paramauor);
        asuh.a("step.onUploadPbFinish:resultCode = %d,uniseq = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(paramauor.jdField_a_of_type_Int), Long.valueOf(((MessageForStructing)localObject2).uniseq), Integer.valueOf(((asug)localObject1).a()), Integer.valueOf(((asug)localObject1).b()) });
        if (i != 0) {
          break label563;
        }
        i = 1;
      }
      for (;;)
      {
        label331:
        paramauor = ((MessageForStructing)localObject2).frienduin;
        int m = ((MessageForStructing)localObject2).structingMsg.mTSum;
        int n = ((asug)localObject1).c;
        int i1 = ((asug)localObject1).d;
        int i2 = ((asug)localObject1).e;
        int i3 = ((asug)localObject1).f;
        localObject1 = ((asug)localObject1).jdField_a_of_type_JavaUtilHashMap;
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
              if (paramauor.jdField_a_of_type_Int == 0)
              {
                ((MessageForStructing)localObject2).structingMsg.mResid = paramauor.c;
                ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
                localQQAppInterface.a().a((String)localObject3, i, ((MessageForStructing)localObject2).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
                localQQAppInterface.a().b((MessageRecord)localObject2, null);
                break;
              }
              ((asug)localObject1).a(1, 65536);
              c((asug)localObject1);
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
              if (!ChatActivityUtils.a(localQQAppInterface, ((asug)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
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
        axqy.b(localQQAppInterface, "CliOper", "", paramauor, "0X8009AC0", "0X8009AC0", i, 0, m + "", n + i1 + i2 + i3 + "", "" + j, "" + k);
        return;
        label764:
        i = 1;
      }
    }
  }
  
  protected void c(asug paramasug)
  {
    if (paramasug == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    MessageForStructing localMessageForStructing = paramasug.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
    String str = paramasug.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    int i = paramasug.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    localMessageForStructing.extraflag = 32768;
    localQQAppInterface.a().a(str, i, localMessageForStructing.uniseq);
    paramasug = localQQAppInterface.a().a(str, i);
    if ((paramasug != null) && (paramasug.uniseq == localMessageForStructing.uniseq)) {
      paramasug.extraflag = 32768;
    }
    long l = localMessageForStructing.uniseq;
    ((MessageHandler)localQQAppInterface.a(0)).notifyUI(MessageHandler.a(i), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  protected void d(asug paramasug) {}
  
  public void e(asug paramasug)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localObject == null);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramasug.a())) {
      this.jdField_a_of_type_JavaUtilMap.put(paramasug.a(), paramasug);
    }
    if (a((QQAppInterface)localObject, paramasug))
    {
      a((QQAppInterface)localObject, paramasug);
      return;
    }
    if (paramasug.jdField_a_of_type_Int == 0) {}
    for (int i = 0;; i = 2)
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(i);
      ((Message)localObject).obj = paramasug;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  public void f(asug paramasug)
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
      Object localObject3 = paramasug.jdField_a_of_type_JavaUtilList;
      HashMap localHashMap = (HashMap)paramasug.jdField_a_of_type_JavaUtilMap;
      localObject2 = paramasug.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
      localObject3 = a((QQAppInterface)localObject1, (MessageForStructing)localObject2, (ArrayList)localObject3, localHashMap, null);
      localObject1 = ((QQAppInterface)localObject1).a().a().a((MessageRecord)localObject2, (HashMap)localObject3, null, true, true);
      paramasug.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localObject1);
    } while (((HashMap)localObject1).size() == 0);
    paramasug.a(15);
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((asts)((Iterator)localObject2).next()).a(paramasug, (HashMap)localObject1, this);
    }
    asuh.b("step.uploadRichStart", new Object[0]);
  }
  
  protected void g(asug paramasug)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    byte[] arrayOfByte = localQQAppInterface.a().a().a(paramasug.jdField_a_of_type_JavaUtilHashMap, (HashMap)paramasug.jdField_a_of_type_JavaUtilMap, true);
    if (arrayOfByte == null)
    {
      paramasug.a(99, 99);
      c(paramasug);
      return;
    }
    String str1 = localQQAppInterface.getAccount();
    String str2 = paramasug.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    String str3 = paramasug.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_b_of_type_JavaLangString;
    int i = paramasug.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    long l = paramasug.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq;
    paramasug.c = arrayOfByte.length;
    paramasug = new aywc();
    paramasug.jdField_a_of_type_Boolean = true;
    paramasug.jdField_b_of_type_Int = 131078;
    paramasug.h = 0;
    paramasug.jdField_b_of_type_ArrayOfByte = arrayOfByte;
    paramasug.jdField_b_of_type_JavaLangString = str1;
    paramasug.c = str2;
    paramasug.d = str3;
    paramasug.jdField_a_of_type_Int = i;
    paramasug.jdField_a_of_type_Long = l;
    paramasug.e = 1035;
    paramasug.jdField_a_of_type_Auoq = this;
    localQQAppInterface.a().a(paramasug);
    asuh.b("step.uploadPb.uniseq = %d,fileSize = %d", new Object[] { Long.valueOf(l), Integer.valueOf(arrayOfByte.length) });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    asug localasug = (asug)paramMessage.obj;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      d(localasug);
      continue;
      f(localasug);
      continue;
      g(localasug);
      continue;
      a(localasug);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     astz
 * JD-Core Version:    0.7.0.1
 */