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
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.HexUtil;
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

public class awcl
  implements Handler.Callback, awcd, aycx, ayeo
{
  protected QQAppInterface a;
  protected List<awcc> a;
  protected Map<String, awcs> a;
  protected AtomicBoolean a;
  protected MqqHandler a;
  
  public awcl(QQAppInterface paramQQAppInterface)
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
    paramQQAppInterface = new awcu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = new awcx(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    awcw localawcw = new awcw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    awcb localawcb = new awcb(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localawcw);
    this.jdField_a_of_type_JavaUtilList.add(localawcb);
  }
  
  public int a()
  {
    return 0;
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
      awct.a(paramArrayList, (String)paramHashMap.get(abwz.c(paramArrayList)), paramMessageForStructing);
      j = i;
      if (awct.a((ChatMessage)paramArrayList))
      {
        j = 0;
        int k = 0;
        MessageForStructing localMessageForStructing = (MessageForStructing)paramArrayList;
        HashMap localHashMap = paramQQAppInterface.getMultiMessageProxy().a(localMessageForStructing);
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
                paramArrayList = awcm.a().a(localMessageRecord.senderuin, localMessageRecord.msgseq, paramQQAppInterface);
              }
              if (paramArrayList != null)
              {
                localObject2 = paramArrayList;
                if (paramArrayList.trim().length() != 0) {}
              }
              else
              {
                localObject2 = awct.a(localMessageRecord.senderuin);
              }
              awct.a(localMessageRecord, (String)localObject2, paramMessageForStructing);
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
    awct.b("step.preHandle.mTSum = %d", new Object[] { Integer.valueOf(i) });
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(int paramInt1, int paramInt2, awcs paramawcs)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    paramawcs.a(paramInt2);
    paramawcs.a(paramInt1, paramInt2);
    if (paramawcs.a() == 0)
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3);
      localMessage.obj = paramawcs;
      localMessage.sendToTarget();
    }
    awct.a("step.onUploadFinish:resultCode = %d,richMask = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramawcs.a()), Integer.valueOf(paramawcs.b()) });
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  protected void a(awcs paramawcs)
  {
    Object localObject1 = paramawcs.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (ArrayList)paramawcs.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
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
              if ((paramawcs.g > 0) || (paramawcs.jdField_b_of_type_Int == 0) || (paramawcs.jdField_b_of_type_Int == 9))
              {
                ((MessageForReplyText)localObject3).mSourceMsgInfo.mSourceMsgTroopName = null;
                bcef.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A5D2", "0X800A5D2", 0, 0, "", "", "", "");
              }
              try
              {
                ((MessageForReplyText)localObject3).saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(anwz.a(((MessageForReplyText)localObject3).mSourceMsgInfo)));
                if (aszt.a(((MessageForReplyText)localObject3).getSourceMessage()))
                {
                  String str = ((MessageForReplyText)localObject3).getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
                  ChatMessage localChatMessage = aszt.a((ChatMessage)((MessageForReplyText)localObject3).getSourceMessage());
                  ataw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, ((MessageForReplyText)localObject3).getSourceMessage());
                  if ((!TextUtils.isEmpty(str)) && (localChatMessage != null))
                  {
                    int i = Integer.parseInt(str);
                    if ((i == 1) || (i == 2)) {
                      aszt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)((MessageForReplyText)localObject3).getSourceMessage());
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
    if (paramawcs.jdField_a_of_type_JavaUtilHashMap.containsKey("reply_msg")) {
      paramawcs.jdField_a_of_type_JavaUtilHashMap.remove("reply_msg");
    }
    b(paramawcs);
    if (paramawcs.b() != 0)
    {
      c(paramawcs);
      return;
    }
    localObject1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
    ((Message)localObject1).obj = paramawcs;
    ((Message)localObject1).sendToTarget();
  }
  
  public void a(aycy paramaycy)
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    QQAppInterface localQQAppInterface;
    Object localObject2;
    long l;
    awcs localawcs;
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
        localObject2 = paramaycy.d;
        l = paramaycy.jdField_a_of_type_Long;
        localawcs = (awcs)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        awct.b("onDownloadResp: mUniseq = %d,resIdStr = %s,errcode = %d", new Object[] { Long.valueOf(l), paramaycy.e, Integer.valueOf(paramaycy.jdField_b_of_type_Int) });
      } while (localawcs == null);
      localList = localawcs.jdField_b_of_type_JavaUtilList;
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
      if (paramaycy.jdField_b_of_type_Int == 0)
      {
        localList.remove(localObject1);
        localObject2 = new HashMap();
        localQQAppInterface.getProxyManager().a().a(paramaycy.jdField_a_of_type_ArrayOfByte, (HashMap)localObject2, localObject1, null);
      }
      for (;;)
      {
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        e(localawcs);
        return;
        paramaycy = localQQAppInterface.getMultiMessageProxy().a(localObject1, awck.b, false);
        int i = localawcs.jdField_a_of_type_JavaUtilList.indexOf(localObject1);
        if (i >= 0) {
          localawcs.jdField_a_of_type_JavaUtilList.set(i, (ChatMessage)paramaycy);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, awcs paramawcs)
  {
    List localList = paramawcs.jdField_b_of_type_JavaUtilList;
    if ((localList == null) || (localList.size() == 0)) {
      return;
    }
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)localIterator.next();
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mIsUp = false;
      localTransferRequest.mFileType = 131078;
      localTransferRequest.resIdStr = localMessageForStructing.structingMsg.mResid;
      localTransferRequest.mSelfUin = localMessageForStructing.selfuin;
      localTransferRequest.mPeerUin = localMessageForStructing.frienduin;
      localTransferRequest.mSecondId = localMessageForStructing.frienduin;
      localTransferRequest.mUinType = localMessageForStructing.istroop;
      localTransferRequest.mUniseq = localMessageForStructing.uniseq;
      localTransferRequest.mBusiType = 1035;
      localTransferRequest.mDownCallBack = this;
      localTransferRequest.mRichTag = paramawcs.a();
      paramQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
      awct.b("downloadNestMultiMsg mUniseq = %d,resIdStr = %s", new Object[] { Long.valueOf(localTransferRequest.mUniseq), localTransferRequest.resIdStr });
    }
    awct.b("downloadNestMultiMsg msgSize = %d ", new Object[] { Integer.valueOf(localList.size()) });
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, awcs paramawcs)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramawcs.jdField_a_of_type_JavaUtilList;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (awct.a(localChatMessage))
      {
        Object localObject = (MessageForStructing)localChatMessage;
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mResid == null))
        {
          localObject = paramQQAppInterface.getMultiMessageProxy().a(localChatMessage, awck.a, false);
          localList.set(localList.indexOf(localChatMessage), (ChatMessage)localObject);
        }
        else if (paramQQAppInterface.getMultiMessageProxy().a((MessageRecord)localObject).size() == 0)
        {
          localArrayList.add((MessageForStructing)localChatMessage);
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      paramawcs.jdField_b_of_type_JavaUtilList = localArrayList;
      return true;
    }
    return false;
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  protected void b(awcs paramawcs)
  {
    anlo localanlo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy();
    Iterator localIterator = paramawcs.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ArrayList)paramawcs.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord instanceof MessageForReplyText))
          {
            if (localanlo != null) {
              localanlo.a(localMessageRecord, null);
            }
          }
          else if (((localMessageRecord instanceof MessageForMixedMsg)) && (((MessageForMixedMsg)localMessageRecord).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) && (localanlo != null)) {
            localanlo.a(localMessageRecord, null);
          }
        }
      }
    }
  }
  
  protected void c(awcs paramawcs)
  {
    if (paramawcs == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    MessageForStructing localMessageForStructing = paramawcs.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
    String str = paramawcs.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    int i = paramawcs.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
    localMessageForStructing.extraflag = 32768;
    localQQAppInterface.getMsgCache().a(str, i, localMessageForStructing.uniseq);
    paramawcs = localQQAppInterface.getMessageFacade().getLastMessage(str, i);
    if ((paramawcs != null) && (paramawcs.uniseq == localMessageForStructing.uniseq)) {
      paramawcs.extraflag = 32768;
    }
    long l = localMessageForStructing.uniseq;
    ((MessageHandler)localQQAppInterface.getBusinessHandler(0)).notifyUI(MessageHandler.a(i), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  protected void d(awcs paramawcs) {}
  
  public void e(awcs paramawcs)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localObject == null);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramawcs.a())) {
      this.jdField_a_of_type_JavaUtilMap.put(paramawcs.a(), paramawcs);
    }
    if (a((QQAppInterface)localObject, paramawcs))
    {
      a((QQAppInterface)localObject, paramawcs);
      return;
    }
    if (paramawcs.jdField_a_of_type_Int == 0) {}
    for (int i = 0;; i = 2)
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(i);
      ((Message)localObject).obj = paramawcs;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  public void f(awcs paramawcs)
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
      Object localObject3 = paramawcs.jdField_a_of_type_JavaUtilList;
      HashMap localHashMap = (HashMap)paramawcs.jdField_a_of_type_JavaUtilMap;
      localObject2 = paramawcs.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
      localObject3 = a((QQAppInterface)localObject1, (MessageForStructing)localObject2, (ArrayList)localObject3, localHashMap, null);
      localObject1 = ((QQAppInterface)localObject1).getProxyManager().a().a((MessageRecord)localObject2, (HashMap)localObject3, null, true, true);
      paramawcs.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localObject1);
    } while (((HashMap)localObject1).size() == 0);
    paramawcs.a(15);
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((awcc)((Iterator)localObject2).next()).a(paramawcs, (HashMap)localObject1, this);
    }
    awct.b("step.uploadRichStart", new Object[0]);
  }
  
  protected void g(awcs paramawcs)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    byte[] arrayOfByte = localQQAppInterface.getProxyManager().a().a(paramawcs.jdField_a_of_type_JavaUtilHashMap, (HashMap)paramawcs.jdField_a_of_type_JavaUtilMap, true);
    if (arrayOfByte == null)
    {
      paramawcs.a(99, 99);
      c(paramawcs);
      return;
    }
    String str1 = localQQAppInterface.getAccount();
    String str2 = paramawcs.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    String str3 = paramawcs.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin;
    int i = paramawcs.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
    long l = paramawcs.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq;
    paramawcs.c = arrayOfByte.length;
    paramawcs = new TransferRequest();
    paramawcs.mIsUp = true;
    paramawcs.mFileType = 131078;
    paramawcs.multiMsgType = 0;
    paramawcs.toSendData = arrayOfByte;
    paramawcs.mSelfUin = str1;
    paramawcs.mPeerUin = str2;
    paramawcs.mSecondId = str3;
    paramawcs.mUinType = i;
    paramawcs.mUniseq = l;
    paramawcs.mBusiType = 1035;
    paramawcs.mUpCallBack = this;
    paramawcs.upMsgBusiType = a();
    localQQAppInterface.getTransFileController().transferAsync(paramawcs);
    awct.b("step.uploadPb.uniseq = %d,fileSize = %d", new Object[] { Long.valueOf(l), Integer.valueOf(arrayOfByte.length) });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    awcs localawcs = (awcs)paramMessage.obj;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      d(localawcs);
      continue;
      f(localawcs);
      continue;
      g(localawcs);
      continue;
      a(localawcs);
    }
  }
  
  public void onSend(ayep paramayep)
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
        long l = ((Long)paramayep.jdField_a_of_type_JavaLangObject).longValue();
        localObject1 = null;
        localObject2 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (((awcs)this.jdField_a_of_type_JavaUtilMap.get(localObject3)).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq != l) {
            break label769;
          }
          localObject1 = (awcs)this.jdField_a_of_type_JavaUtilMap.get(localObject3);
          continue;
        }
        if (localObject1 == null) {
          break;
        }
      }
      catch (Exception paramayep)
      {
        QLog.e("MultiMsg_TAG", 1, paramayep, new Object[0]);
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(((awcs)localObject1).a());
      Object localObject2 = ((awcs)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
      Object localObject3 = ((awcs)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      int i = ((awcs)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
      if (((awcs)localObject1).jdField_b_of_type_Int == 2)
      {
        if (paramayep.jdField_a_of_type_Int == 0)
        {
          ((MessageForStructing)localObject2).structingMsg.mResid = paramayep.c;
          ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
        }
        i = ((awcs)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.extraUintype;
        new awcp(localQQAppInterface, (MessageRecord)localObject2, (String)localObject3, i, (ArrayList)((awcs)localObject1).jdField_a_of_type_JavaUtilHashMap.get("MultiMsg"), (HashMap)((awcs)localObject1).jdField_a_of_type_JavaUtilMap).onSend(paramayep);
        awct.a("step.onUploadPbFinish:resultCode = %d,uniseq = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(paramayep.jdField_a_of_type_Int), Long.valueOf(((MessageForStructing)localObject2).uniseq), Integer.valueOf(((awcs)localObject1).a()), Integer.valueOf(((awcs)localObject1).b()) });
        if (i != 0) {
          break label563;
        }
        i = 1;
      }
      for (;;)
      {
        label331:
        paramayep = ((MessageForStructing)localObject2).frienduin;
        int m = ((MessageForStructing)localObject2).structingMsg.mTSum;
        int n = ((awcs)localObject1).c;
        int i1 = ((awcs)localObject1).d;
        int i2 = ((awcs)localObject1).e;
        int i3 = ((awcs)localObject1).f;
        localObject1 = ((awcs)localObject1).jdField_a_of_type_JavaUtilHashMap;
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
              if (paramayep.jdField_a_of_type_Int == 0)
              {
                ((MessageForStructing)localObject2).structingMsg.mResid = paramayep.c;
                ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
                localQQAppInterface.getMessageFacade().updateMsgContentByUniseq((String)localObject3, i, ((MessageForStructing)localObject2).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
                localQQAppInterface.getMessageFacade().sendMessage((MessageRecord)localObject2, null);
                break;
              }
              ((awcs)localObject1).a(1, 65536);
              c((awcs)localObject1);
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
              if (!ChatActivityUtils.a(localQQAppInterface, ((awcs)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
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
        bcef.b(localQQAppInterface, "CliOper", "", paramayep, "0X8009AC0", "0X8009AC0", i, 0, m + "", n + i1 + i2 + i3 + "", "" + j, "" + k);
        return;
        label764:
        i = 1;
      }
    }
  }
  
  public void updateMsg(ayep paramayep) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awcl
 * JD-Core Version:    0.7.0.1
 */