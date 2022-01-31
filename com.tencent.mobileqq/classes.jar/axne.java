import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.os.MqqHandler;

public class axne
  extends aupf
{
  public axne(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private acjt a(MessageForReplyText paramMessageForReplyText, aupm paramaupm)
  {
    SessionInfo localSessionInfo = paramaupm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    int i = paramaupm.g;
    acjt localacjt = new acjt();
    localacjt.jdField_c_of_type_Int = bdin.a(BaseApplication.getContext());
    localacjt.jdField_a_of_type_Long = System.currentTimeMillis();
    String str1 = paramMessageForReplyText.getExtInfoFromExtStr("sens_reply_special_msg");
    Object localObject = paramMessageForReplyText.getExtInfoFromExtStr("sens_reply_special_at_list");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (i <= 0))
    {
      localacjt.jdField_b_of_type_JavaLangString = ((String)localObject);
      localObject = MessageForText.getTroopMemberInfoFromExtrJson((String)localObject);
      String str2 = acjm.a(str1, (ArrayList)localObject);
      if (!TextUtils.isEmpty(str2)) {
        str1 = azah.a(str2, true, (ArrayList)localObject);
      }
      localacjt.jdField_a_of_type_JavaLangString = str1;
      paramMessageForReplyText.removeExtInfoToExtStr("sens_reply_special_msg");
      paramMessageForReplyText.removeExtInfoToExtStr("sens_reply_special_at_list");
    }
    if (paramMessageForReplyText.mSourceMsgInfo != null)
    {
      localacjt.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramMessageForReplyText.mSourceMsgInfo);
      if (paramMessageForReplyText.getSourceMessage() != null) {
        localacjt.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.packSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForReplyText.getSourceMessage());
      }
      if (i > 0)
      {
        localacjt.jdField_c_of_type_Long = paramMessageForReplyText.uniseq;
        localacjt.e = i;
        paramMessageForReplyText.atInfoList = null;
      }
      localacjt.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
    }
    if ((paramMessageForReplyText.istroop == 1) && (localSessionInfo.jdField_a_of_type_Int == 1) && (localSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageForReplyText.frienduin))) {}
    for (i = 1;; i = 0)
    {
      if ((!paramaupm.jdField_a_of_type_Boolean) || (i != 0))
      {
        localacjt.jdField_d_of_type_Boolean = paramMessageForReplyText.isBarrageMsg;
        localacjt.jdField_b_of_type_Long = paramMessageForReplyText.barrageTimeLocation;
        localacjt.jdField_d_of_type_Int = paramMessageForReplyText.barrageSourceMsgType;
      }
      return localacjt;
    }
  }
  
  private void h(aupm paramaupm)
  {
    HashMap localHashMap = paramaupm.jdField_a_of_type_JavaUtilHashMap;
    Iterator localIterator1 = localHashMap.keySet().iterator();
    if (localIterator1.hasNext())
    {
      localObject = (ArrayList)localHashMap.get((String)localIterator1.next());
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    Iterator localIterator2 = ((ArrayList)localObject).iterator();
    label55:
    MessageForReplyText localMessageForReplyText;
    while (localIterator2.hasNext())
    {
      localObject = (MessageRecord)localIterator2.next();
      if ((localObject instanceof MessageForReplyText))
      {
        localMessageForReplyText = (MessageForReplyText)localObject;
        if (((MessageRecord)localObject).msg != null) {
          break label132;
        }
      }
    }
    label132:
    for (Object localObject = "";; localObject = ((MessageRecord)localObject).msg)
    {
      acjt localacjt = a(localMessageForReplyText, paramaupm);
      acjm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, paramaupm.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject, localMessageForReplyText.atInfoList, localacjt);
      break label55;
      break;
    }
  }
  
  public ArrayList<MessageRecord> a(QQAppInterface paramQQAppInterface, List<? extends MessageRecord> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (paramBoolean)
      {
        if (localMessageRecord.msgtype == -1037) {
          paramList = ((MessageForLongMsg)localMessageRecord).rebuildLongMsg(true);
        }
        while (paramList == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ReplyMsgController", 2, "preAddMultiMsg.mrTemp is null ,not normal...");
          }
          return null;
          if (localMessageRecord.msgtype == -1036)
          {
            paramList = (MessageForMixedMsg)((MessageForLongMsg)localMessageRecord).rebuildLongMsg();
          }
          else if (localMessageRecord.msgtype == -1035)
          {
            paramList = ((MessageForMixedMsg)localMessageRecord).rebuildMixedMsg();
          }
          else if (localMessageRecord.msgtype == -2011)
          {
            paramList = new MessageForStructing(localMessageRecord);
          }
          else if (localMessageRecord.msgtype == -1049)
          {
            paramList = (MessageRecord)localMessageRecord.deepCopyByReflect();
            ((MessageForReplyText)paramList).deepCopySourceMsg((MessageForReplyText)localMessageRecord);
          }
          else
          {
            paramList = (MessageRecord)localMessageRecord.deepCopyByReflect();
          }
        }
        if (!TextUtils.isEmpty(paramList.getExtInfoFromExtStr("troop_at_info_list"))) {
          paramList.removeExtInfoToExtStr("troop_at_info_list");
        }
        if (!TextUtils.isEmpty(paramList.getExtInfoFromExtStr("disc_at_info_list"))) {
          paramList.removeExtInfoToExtStr("disc_at_info_list");
        }
        paramList.atInfoList = null;
        paramList.extLong = localMessageRecord.extLong;
      }
      while (paramList == null)
      {
        return null;
        paramList = localMessageRecord;
      }
      paramList.uniseq = localMessageRecord.uniseq;
      paramList.msgseq = localMessageRecord.msgseq;
      if (arrr.a(paramList)) {
        paramQQAppInterface.a().a().a(localMessageRecord, paramList);
      }
      MessageForReplyText localMessageForReplyText1;
      MessageForReplyText localMessageForReplyText2;
      if ((paramList instanceof MessageForReplyText))
      {
        localMessageForReplyText1 = (MessageForReplyText)localMessageRecord;
        localMessageForReplyText2 = (MessageForReplyText)paramList;
        if ((localMessageForReplyText2.getSourceMessage() != null) && (arrr.a(localMessageForReplyText2.getSourceMessage()))) {
          paramQQAppInterface.a().a().a(localMessageForReplyText1.getSourceMessage(), localMessageForReplyText2.getSourceMessage());
        }
      }
      if ((paramList instanceof MessageForMixedMsg))
      {
        localMessageForReplyText1 = ((MessageForMixedMsg)paramList).getReplyMessage(paramQQAppInterface);
        localMessageForReplyText2 = ((MessageForMixedMsg)localMessageRecord).getReplyMessage(paramQQAppInterface);
        if ((localMessageForReplyText1 != null) && (localMessageForReplyText2 != null) && (localMessageForReplyText1.getSourceMessage() != null) && (arrr.a(localMessageForReplyText1.getSourceMessage()))) {
          paramQQAppInterface.a().a().a(localMessageForReplyText2.getSourceMessage(), localMessageForReplyText1.getSourceMessage());
        }
      }
      if (paramList.msgtype == -2022) {
        ((MessageForShortVideo)paramList).redBagType = 0;
      }
      localArrayList.add(paramList);
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgController", 2, "preAddMultiMsg, MessageRecord:" + localMessageRecord.toString());
      }
    }
    return localArrayList;
  }
  
  protected void b(aupm paramaupm) {}
  
  public void b(awki paramawki)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
        if (QLog.isColorLevel()) {
          QLog.d("ReplyMsgController", 2, "onSend result.data=" + paramawki.a);
        }
      } while ((paramawki.a == null) || (!(paramawki.a instanceof String)));
      paramawki = (String)paramawki.a;
      paramawki = (aupm)this.jdField_a_of_type_JavaUtilMap.get(paramawki);
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgController", 2, "onSend request=" + paramawki);
      }
    } while (paramawki == null);
    this.jdField_a_of_type_JavaUtilMap.remove(paramawki.a());
    h(paramawki);
  }
  
  protected void c(aupm paramaupm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReplyMsgController", 2, "onFailed");
    }
    awki localawki = new awki();
    localawki.a = paramaupm.a();
    b(localawki);
  }
  
  protected void d(aupm paramaupm)
  {
    int i = 0;
    Object localObject1 = paramaupm.jdField_a_of_type_JavaUtilList;
    Object localObject2 = (HashMap)paramaupm.jdField_a_of_type_JavaUtilMap;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramaupm.jdField_a_of_type_Int != 2) {}
    for (boolean bool = true;; bool = false)
    {
      localObject2 = a((QQAppInterface)localObject2, (List)localObject1, bool);
      localObject1 = new HashMap(1);
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject2).next();
        long l = localMessageRecord.uniseq;
        ArrayList localArrayList = new ArrayList(1);
        localArrayList.add(localMessageRecord);
        ((HashMap)localObject1).put(String.valueOf(l), localArrayList);
      }
    }
    paramaupm.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localObject1);
    if (paramaupm.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(i);
      ((Message)localObject1).obj = paramaupm;
      ((Message)localObject1).sendToTarget();
      return;
      if (paramaupm.jdField_a_of_type_Int == 2) {
        i = 1;
      }
    }
  }
  
  public void e(aupm paramaupm)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramaupm.a())) {
      this.jdField_a_of_type_JavaUtilMap.put(paramaupm.a(), paramaupm);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(-1);
    localMessage.obj = paramaupm;
    localMessage.sendToTarget();
  }
  
  public void f(aupm paramaupm)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      if (paramaupm.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReplyMsgController", 2, "uploadRichMsg dstMsgMap is empty");
    return;
    paramaupm.a(15);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((auoy)localIterator.next()).a(paramaupm, paramaupm.jdField_a_of_type_JavaUtilHashMap, this);
    }
    aupn.b("ReplyMsgController step.uploadRichStart", new Object[0]);
  }
  
  protected void g(aupm paramaupm)
  {
    awki localawki = new awki();
    localawki.a = paramaupm.a();
    b(localawki);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axne
 * JD-Core Version:    0.7.0.1
 */