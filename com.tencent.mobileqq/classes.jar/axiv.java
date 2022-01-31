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

public class axiv
  extends aukw
{
  public axiv(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private acfe a(MessageForReplyText paramMessageForReplyText, auld paramauld)
  {
    SessionInfo localSessionInfo = paramauld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    int i = paramauld.g;
    acfe localacfe = new acfe();
    localacfe.jdField_c_of_type_Int = bdee.a(BaseApplication.getContext());
    localacfe.jdField_a_of_type_Long = System.currentTimeMillis();
    String str1 = paramMessageForReplyText.getExtInfoFromExtStr("sens_reply_special_msg");
    Object localObject = paramMessageForReplyText.getExtInfoFromExtStr("sens_reply_special_at_list");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (i <= 0))
    {
      localacfe.jdField_b_of_type_JavaLangString = ((String)localObject);
      localObject = MessageForText.getTroopMemberInfoFromExtrJson((String)localObject);
      String str2 = acex.a(str1, (ArrayList)localObject);
      if (!TextUtils.isEmpty(str2)) {
        str1 = ayvy.a(str2, true, (ArrayList)localObject);
      }
      localacfe.jdField_a_of_type_JavaLangString = str1;
      paramMessageForReplyText.removeExtInfoToExtStr("sens_reply_special_msg");
      paramMessageForReplyText.removeExtInfoToExtStr("sens_reply_special_at_list");
    }
    if (paramMessageForReplyText.mSourceMsgInfo != null)
    {
      localacfe.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramMessageForReplyText.mSourceMsgInfo);
      if (paramMessageForReplyText.getSourceMessage() != null) {
        localacfe.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.packSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForReplyText.getSourceMessage());
      }
      if (i > 0)
      {
        localacfe.jdField_c_of_type_Long = paramMessageForReplyText.uniseq;
        localacfe.e = i;
        paramMessageForReplyText.atInfoList = null;
      }
      localacfe.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
    }
    if ((paramMessageForReplyText.istroop == 1) && (localSessionInfo.jdField_a_of_type_Int == 1) && (localSessionInfo.jdField_a_of_type_JavaLangString.equals(paramMessageForReplyText.frienduin))) {}
    for (i = 1;; i = 0)
    {
      if ((!paramauld.jdField_a_of_type_Boolean) || (i != 0))
      {
        localacfe.jdField_d_of_type_Boolean = paramMessageForReplyText.isBarrageMsg;
        localacfe.jdField_b_of_type_Long = paramMessageForReplyText.barrageTimeLocation;
        localacfe.jdField_d_of_type_Int = paramMessageForReplyText.barrageSourceMsgType;
      }
      return localacfe;
    }
  }
  
  private void h(auld paramauld)
  {
    HashMap localHashMap = paramauld.jdField_a_of_type_JavaUtilHashMap;
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
      acfe localacfe = a(localMessageForReplyText, paramauld);
      acex.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, paramauld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject, localMessageForReplyText.atInfoList, localacfe);
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
      if (arni.a(paramList)) {
        paramQQAppInterface.a().a().a(localMessageRecord, paramList);
      }
      MessageForReplyText localMessageForReplyText1;
      MessageForReplyText localMessageForReplyText2;
      if ((paramList instanceof MessageForReplyText))
      {
        localMessageForReplyText1 = (MessageForReplyText)localMessageRecord;
        localMessageForReplyText2 = (MessageForReplyText)paramList;
        if ((localMessageForReplyText2.getSourceMessage() != null) && (arni.a(localMessageForReplyText2.getSourceMessage()))) {
          paramQQAppInterface.a().a().a(localMessageForReplyText1.getSourceMessage(), localMessageForReplyText2.getSourceMessage());
        }
      }
      if ((paramList instanceof MessageForMixedMsg))
      {
        localMessageForReplyText1 = ((MessageForMixedMsg)paramList).getReplyMessage(paramQQAppInterface);
        localMessageForReplyText2 = ((MessageForMixedMsg)localMessageRecord).getReplyMessage(paramQQAppInterface);
        if ((localMessageForReplyText1 != null) && (localMessageForReplyText2 != null) && (localMessageForReplyText1.getSourceMessage() != null) && (arni.a(localMessageForReplyText1.getSourceMessage()))) {
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
  
  protected void b(auld paramauld) {}
  
  public void b(awfz paramawfz)
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
          QLog.d("ReplyMsgController", 2, "onSend result.data=" + paramawfz.a);
        }
      } while ((paramawfz.a == null) || (!(paramawfz.a instanceof String)));
      paramawfz = (String)paramawfz.a;
      paramawfz = (auld)this.jdField_a_of_type_JavaUtilMap.get(paramawfz);
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgController", 2, "onSend request=" + paramawfz);
      }
    } while (paramawfz == null);
    this.jdField_a_of_type_JavaUtilMap.remove(paramawfz.a());
    h(paramawfz);
  }
  
  protected void c(auld paramauld)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReplyMsgController", 2, "onFailed");
    }
    awfz localawfz = new awfz();
    localawfz.a = paramauld.a();
    b(localawfz);
  }
  
  protected void d(auld paramauld)
  {
    int i = 0;
    Object localObject1 = paramauld.jdField_a_of_type_JavaUtilList;
    Object localObject2 = (HashMap)paramauld.jdField_a_of_type_JavaUtilMap;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramauld.jdField_a_of_type_Int != 2) {}
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
    paramauld.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localObject1);
    if (paramauld.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(i);
      ((Message)localObject1).obj = paramauld;
      ((Message)localObject1).sendToTarget();
      return;
      if (paramauld.jdField_a_of_type_Int == 2) {
        i = 1;
      }
    }
  }
  
  public void e(auld paramauld)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramauld.a())) {
      this.jdField_a_of_type_JavaUtilMap.put(paramauld.a(), paramauld);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(-1);
    localMessage.obj = paramauld;
    localMessage.sendToTarget();
  }
  
  public void f(auld paramauld)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      if (paramauld.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReplyMsgController", 2, "uploadRichMsg dstMsgMap is empty");
    return;
    paramauld.a(15);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((aukp)localIterator.next()).a(paramauld, paramauld.jdField_a_of_type_JavaUtilHashMap, this);
    }
    aule.b("ReplyMsgController step.uploadRichStart", new Object[0]);
  }
  
  protected void g(auld paramauld)
  {
    awfz localawfz = new awfz();
    localawfz.a = paramauld.a();
    b(localawfz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axiv
 * JD-Core Version:    0.7.0.1
 */