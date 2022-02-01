import android.os.Handler.Callback;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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

public class axin
  implements Handler.Callback, axif, azjj, azla
{
  protected QQAppInterface a;
  protected List<axie> a;
  protected Map<String, axiu> a;
  protected AtomicBoolean a;
  protected MqqHandler a;
  
  public axin(QQAppInterface paramQQAppInterface)
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
    paramQQAppInterface = new axiw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject = new axiz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    axiy localaxiy = new axiy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    axid localaxid = new axid(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    this.jdField_a_of_type_JavaUtilList.add(localaxiy);
    this.jdField_a_of_type_JavaUtilList.add(localaxid);
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
      axiv.a(paramArrayList, (String)paramHashMap.get(acnh.c(paramArrayList)), paramMessageForStructing);
      j = i;
      if (axiv.a((ChatMessage)paramArrayList))
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
                paramArrayList = axio.a().a(localMessageRecord.senderuin, localMessageRecord.msgseq, paramQQAppInterface);
              }
              if (paramArrayList != null)
              {
                localObject2 = paramArrayList;
                if (paramArrayList.trim().length() != 0) {}
              }
              else
              {
                localObject2 = axiv.a(localMessageRecord.senderuin);
              }
              axiv.a(localMessageRecord, (String)localObject2, paramMessageForStructing);
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
    axiv.b("step.preHandle.mTSum = %d", new Object[] { Integer.valueOf(i) });
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(int paramInt1, int paramInt2, axiu paramaxiu)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    paramaxiu.a(paramInt2);
    paramaxiu.a(paramInt1, paramInt2);
    if (paramaxiu.a() == 0)
    {
      Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(3);
      localMessage.obj = paramaxiu;
      localMessage.sendToTarget();
    }
    axiv.a("step.onUploadFinish:resultCode = %d,richMask = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramaxiu.a()), Integer.valueOf(paramaxiu.b()) });
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  protected void a(axiu paramaxiu)
  {
    Object localObject1 = paramaxiu.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (ArrayList)paramaxiu.jdField_a_of_type_JavaUtilHashMap.get(localObject2);
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
              if ((paramaxiu.g > 0) || (paramaxiu.jdField_b_of_type_Int == 0) || (paramaxiu.jdField_b_of_type_Int == 9))
              {
                ((MessageForReplyText)localObject3).mSourceMsgInfo.mSourceMsgTroopName = null;
                bdla.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X800A5D2", "0X800A5D2", 0, 0, "", "", "", "");
              }
              try
              {
                ((MessageForReplyText)localObject3).saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(apab.a(((MessageForReplyText)localObject3).mSourceMsgInfo)));
                if (auea.a(((MessageForReplyText)localObject3).getSourceMessage()))
                {
                  String str = ((MessageForReplyText)localObject3).getSourceMessage().getExtInfoFromExtStr("_m_ForwardFileType");
                  ChatMessage localChatMessage = auea.a((ChatMessage)((MessageForReplyText)localObject3).getSourceMessage());
                  aufd.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage, ((MessageForReplyText)localObject3).getSourceMessage());
                  if ((!TextUtils.isEmpty(str)) && (localChatMessage != null))
                  {
                    int i = Integer.parseInt(str);
                    if ((i == 1) || (i == 2)) {
                      auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.uniseq, localChatMessage.frienduin, localChatMessage.istroop, (ChatMessage)((MessageForReplyText)localObject3).getSourceMessage());
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
    if (paramaxiu.jdField_a_of_type_JavaUtilHashMap.containsKey("reply_msg")) {
      paramaxiu.jdField_a_of_type_JavaUtilHashMap.remove("reply_msg");
    }
    b(paramaxiu);
    if (paramaxiu.b() != 0)
    {
      c(paramaxiu);
      return;
    }
    localObject1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(1);
    ((Message)localObject1).obj = paramaxiu;
    ((Message)localObject1).sendToTarget();
  }
  
  public void a(azjk paramazjk)
  {
    Object localObject1 = null;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    QQAppInterface localQQAppInterface;
    Object localObject2;
    long l;
    axiu localaxiu;
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
        localObject2 = paramazjk.d;
        l = paramazjk.jdField_a_of_type_Long;
        localaxiu = (axiu)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
        axiv.b("onDownloadResp: mUniseq = %d,resIdStr = %s,errcode = %d", new Object[] { Long.valueOf(l), paramazjk.e, Integer.valueOf(paramazjk.jdField_b_of_type_Int) });
      } while (localaxiu == null);
      localList = localaxiu.jdField_b_of_type_JavaUtilList;
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
      if (paramazjk.jdField_b_of_type_Int == 0)
      {
        localList.remove(localObject1);
        localObject2 = new HashMap();
        localQQAppInterface.getProxyManager().a().a(paramazjk.jdField_a_of_type_ArrayOfByte, (HashMap)localObject2, localObject1, null);
      }
      for (;;)
      {
        if ((localList != null) && (localList.size() != 0)) {
          break;
        }
        e(localaxiu);
        return;
        paramazjk = localQQAppInterface.getMultiMessageProxy().a(localObject1, axim.b, false);
        int i = localaxiu.jdField_a_of_type_JavaUtilList.indexOf(localObject1);
        if (i >= 0) {
          localaxiu.jdField_a_of_type_JavaUtilList.set(i, (ChatMessage)paramazjk);
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, axiu paramaxiu)
  {
    List localList = paramaxiu.jdField_b_of_type_JavaUtilList;
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
      localTransferRequest.mRichTag = paramaxiu.a();
      paramQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
      axiv.b("downloadNestMultiMsg mUniseq = %d,resIdStr = %s", new Object[] { Long.valueOf(localTransferRequest.mUniseq), localTransferRequest.resIdStr });
    }
    axiv.b("downloadNestMultiMsg msgSize = %d ", new Object[] { Integer.valueOf(localList.size()) });
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, axiu paramaxiu)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = paramaxiu.jdField_a_of_type_JavaUtilList;
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)localIterator.next();
      if (axiv.a(localChatMessage))
      {
        Object localObject = (MessageForStructing)localChatMessage;
        if ((((MessageForStructing)localObject).structingMsg != null) && (((MessageForStructing)localObject).structingMsg.mResid == null))
        {
          localObject = paramQQAppInterface.getMultiMessageProxy().a(localChatMessage, axim.a, false);
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
      paramaxiu.jdField_b_of_type_JavaUtilList = localArrayList;
      return true;
    }
    return false;
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  protected void b(axiu paramaxiu)
  {
    aooh localaooh = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMultiMessageProxy();
    Iterator localIterator = paramaxiu.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (ArrayList)paramaxiu.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((ArrayList)localObject).size() != 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if ((localMessageRecord instanceof MessageForReplyText))
          {
            if (localaooh != null) {
              localaooh.a(localMessageRecord, null);
            }
          }
          else if (((localMessageRecord instanceof MessageForMixedMsg)) && (((MessageForMixedMsg)localMessageRecord).getReplyMessage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != null) && (localaooh != null)) {
            localaooh.a(localMessageRecord, null);
          }
        }
      }
    }
  }
  
  protected void c(axiu paramaxiu)
  {
    if (paramaxiu == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    MessageForStructing localMessageForStructing = paramaxiu.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
    String str = paramaxiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    int i = paramaxiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
    localMessageForStructing.extraflag = 32768;
    localQQAppInterface.getMsgCache().a(str, i, localMessageForStructing.uniseq);
    paramaxiu = localQQAppInterface.getMessageFacade().getLastMessage(str, i);
    if ((paramaxiu != null) && (paramaxiu.uniseq == localMessageForStructing.uniseq)) {
      paramaxiu.extraflag = 32768;
    }
    long l = localMessageForStructing.uniseq;
    ((MessageHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).notifyUI(MessageHandler.a(i), false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  protected void d(axiu paramaxiu) {}
  
  public void e(axiu paramaxiu)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    Object localObject;
    do
    {
      return;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localObject == null);
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramaxiu.a())) {
      this.jdField_a_of_type_JavaUtilMap.put(paramaxiu.a(), paramaxiu);
    }
    if (a((QQAppInterface)localObject, paramaxiu))
    {
      a((QQAppInterface)localObject, paramaxiu);
      return;
    }
    if (paramaxiu.jdField_a_of_type_Int == 0) {}
    for (int i = 0;; i = 2)
    {
      localObject = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(i);
      ((Message)localObject).obj = paramaxiu;
      ((Message)localObject).sendToTarget();
      return;
    }
  }
  
  public void f(axiu paramaxiu)
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
      Object localObject3 = paramaxiu.jdField_a_of_type_JavaUtilList;
      HashMap localHashMap = (HashMap)paramaxiu.jdField_a_of_type_JavaUtilMap;
      localObject2 = paramaxiu.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
      localObject3 = a((QQAppInterface)localObject1, (MessageForStructing)localObject2, (ArrayList)localObject3, localHashMap, null);
      localObject1 = ((QQAppInterface)localObject1).getProxyManager().a().a((MessageRecord)localObject2, (HashMap)localObject3, null, true, true);
      paramaxiu.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localObject1);
    } while (((HashMap)localObject1).size() == 0);
    paramaxiu.a(15);
    Object localObject2 = this.jdField_a_of_type_JavaUtilList.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((axie)((Iterator)localObject2).next()).a(paramaxiu, (HashMap)localObject1, this);
    }
    axiv.b("step.uploadRichStart", new Object[0]);
  }
  
  protected void g(axiu paramaxiu)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    } while (localQQAppInterface == null);
    byte[] arrayOfByte = localQQAppInterface.getProxyManager().a().a(paramaxiu.jdField_a_of_type_JavaUtilHashMap, (HashMap)paramaxiu.jdField_a_of_type_JavaUtilMap, true);
    if (arrayOfByte == null)
    {
      paramaxiu.a(99, 99);
      c(paramaxiu);
      return;
    }
    String str1 = localQQAppInterface.getAccount();
    String str2 = paramaxiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
    String str3 = paramaxiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin;
    int i = paramaxiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
    long l = paramaxiu.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq;
    paramaxiu.c = arrayOfByte.length;
    paramaxiu = new TransferRequest();
    paramaxiu.mIsUp = true;
    paramaxiu.mFileType = 131078;
    paramaxiu.multiMsgType = 0;
    paramaxiu.toSendData = arrayOfByte;
    paramaxiu.mSelfUin = str1;
    paramaxiu.mPeerUin = str2;
    paramaxiu.mSecondId = str3;
    paramaxiu.mUinType = i;
    paramaxiu.mUniseq = l;
    paramaxiu.mBusiType = 1035;
    paramaxiu.mUpCallBack = this;
    paramaxiu.upMsgBusiType = a();
    localQQAppInterface.getTransFileController().transferAsync(paramaxiu);
    axiv.b("step.uploadPb.uniseq = %d,fileSize = %d", new Object[] { Long.valueOf(l), Integer.valueOf(arrayOfByte.length) });
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    axiu localaxiu = (axiu)paramMessage.obj;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      d(localaxiu);
      continue;
      f(localaxiu);
      continue;
      g(localaxiu);
      continue;
      a(localaxiu);
    }
  }
  
  public void onSend(azlb paramazlb)
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
        long l = ((Long)paramazlb.jdField_a_of_type_JavaLangObject).longValue();
        localObject1 = null;
        localObject2 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          if (((axiu)this.jdField_a_of_type_JavaUtilMap.get(localObject3)).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq != l) {
            break label769;
          }
          localObject1 = (axiu)this.jdField_a_of_type_JavaUtilMap.get(localObject3);
          continue;
        }
        if (localObject1 == null) {
          break;
        }
      }
      catch (Exception paramazlb)
      {
        QLog.e("MultiMsg_TAG", 1, paramazlb, new Object[0]);
        return;
      }
      this.jdField_a_of_type_JavaUtilMap.remove(((axiu)localObject1).a());
      Object localObject2 = ((axiu)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageForStructing;
      Object localObject3 = ((axiu)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin;
      int i = ((axiu)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
      if (((axiu)localObject1).jdField_b_of_type_Int == 2)
      {
        if (paramazlb.jdField_a_of_type_Int == 0)
        {
          ((MessageForStructing)localObject2).structingMsg.mResid = paramazlb.c;
          ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
        }
        i = ((axiu)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.extraUintype;
        new axir(localQQAppInterface, (MessageRecord)localObject2, (String)localObject3, i, (ArrayList)((axiu)localObject1).jdField_a_of_type_JavaUtilHashMap.get("MultiMsg"), (HashMap)((axiu)localObject1).jdField_a_of_type_JavaUtilMap).onSend(paramazlb);
        axiv.a("step.onUploadPbFinish:resultCode = %d,uniseq = %d,request.finishMask = %d,request.result = %d ", new Object[] { Integer.valueOf(paramazlb.jdField_a_of_type_Int), Long.valueOf(((MessageForStructing)localObject2).uniseq), Integer.valueOf(((axiu)localObject1).a()), Integer.valueOf(((axiu)localObject1).b()) });
        if (i != 0) {
          break label563;
        }
        i = 1;
      }
      for (;;)
      {
        label331:
        paramazlb = ((MessageForStructing)localObject2).frienduin;
        int m = ((MessageForStructing)localObject2).structingMsg.mTSum;
        int n = ((axiu)localObject1).c;
        int i1 = ((axiu)localObject1).d;
        int i2 = ((axiu)localObject1).e;
        int i3 = ((axiu)localObject1).f;
        localObject1 = ((axiu)localObject1).jdField_a_of_type_JavaUtilHashMap;
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
              if (paramazlb.jdField_a_of_type_Int == 0)
              {
                ((MessageForStructing)localObject2).structingMsg.mResid = paramazlb.c;
                ((MessageForStructing)localObject2).structingMsg.mFileName = String.valueOf(((MessageForStructing)localObject2).uniseq);
                localQQAppInterface.getMessageFacade().updateMsgContentByUniseq((String)localObject3, i, ((MessageForStructing)localObject2).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
                localQQAppInterface.getMessageFacade().sendMessage((MessageRecord)localObject2, null);
                break;
              }
              ((axiu)localObject1).a(1, 65536);
              c((axiu)localObject1);
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
              if (!ChatActivityUtils.a(localQQAppInterface, ((axiu)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo)) {
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
        bdla.b(localQQAppInterface, "CliOper", "", paramazlb, "0X8009AC0", "0X8009AC0", i, 0, m + "", n + i1 + i2 + i3 + "", "" + j, "" + k);
        return;
        label764:
        i = 1;
      }
    }
  }
  
  public void updateMsg(azlb paramazlb) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axin
 * JD-Core Version:    0.7.0.1
 */