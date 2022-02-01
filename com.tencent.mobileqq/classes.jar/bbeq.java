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
import com.tencent.mobileqq.utils.NetworkUtil;
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

public class bbeq
  extends axin
{
  public bbeq(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private admo a(MessageForReplyText paramMessageForReplyText, axiu paramaxiu)
  {
    SessionInfo localSessionInfo = paramaxiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
    int i = paramaxiu.g;
    admo localadmo = new admo();
    localadmo.jdField_c_of_type_Int = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    localadmo.jdField_a_of_type_Long = System.currentTimeMillis();
    String str1 = paramMessageForReplyText.getExtInfoFromExtStr("sens_reply_special_msg");
    Object localObject = paramMessageForReplyText.getExtInfoFromExtStr("sens_reply_special_at_list");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (i <= 0))
    {
      localadmo.jdField_b_of_type_JavaLangString = ((String)localObject);
      localObject = MessageForText.getTroopMemberInfoFromExtrJson((String)localObject);
      String str2 = admh.a(str1, (ArrayList)localObject);
      if (!TextUtils.isEmpty(str2)) {
        str1 = bcsc.a(str2, true, (ArrayList)localObject);
      }
      localadmo.jdField_a_of_type_JavaLangString = str1;
      paramMessageForReplyText.removeExtInfoToExtStr("sens_reply_special_msg");
      paramMessageForReplyText.removeExtInfoToExtStr("sens_reply_special_at_list");
    }
    if (paramMessageForReplyText.mSourceMsgInfo != null)
    {
      localadmo.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramMessageForReplyText.mSourceMsgInfo);
      if (paramMessageForReplyText.getSourceMessage() != null) {
        localadmo.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.packSourceMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForReplyText.getSourceMessage());
      }
      if (i > 0)
      {
        localadmo.jdField_c_of_type_Long = paramMessageForReplyText.uniseq;
        localadmo.e = i;
        paramMessageForReplyText.atInfoList = null;
      }
      localadmo.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mType = 0;
    }
    if ((paramMessageForReplyText.istroop == 1) && (localSessionInfo.curType == 1) && (localSessionInfo.curFriendUin.equals(paramMessageForReplyText.frienduin))) {}
    for (i = 1;; i = 0)
    {
      if ((!paramaxiu.jdField_a_of_type_Boolean) || (i != 0))
      {
        localadmo.jdField_d_of_type_Boolean = paramMessageForReplyText.isBarrageMsg;
        localadmo.jdField_b_of_type_Long = paramMessageForReplyText.barrageTimeLocation;
        localadmo.jdField_d_of_type_Int = paramMessageForReplyText.barrageSourceMsgType;
      }
      return localadmo;
    }
  }
  
  private void a(MessageForReplyText paramMessageForReplyText1, MessageForReplyText paramMessageForReplyText2)
  {
    if (paramMessageForReplyText2.getSourceMessage() == null)
    {
      QLog.d("ReplyMsgController", 1, "originMsg is null");
      return;
    }
    paramMessageForReplyText1.mSourceMsgInfo = new MessageForReplyText.SourceMsgInfo(paramMessageForReplyText2.mSourceMsgInfo);
    paramMessageForReplyText2 = paramMessageForReplyText2.getSourceMessage();
    if (paramMessageForReplyText2 != null) {
      if (paramMessageForReplyText2.msgtype == -1037) {
        paramMessageForReplyText2 = ((MessageForLongMsg)paramMessageForReplyText2).rebuildLongMsg(true);
      }
    }
    for (;;)
    {
      if ((paramMessageForReplyText2 == null) && (QLog.isColorLevel())) {
        QLog.d("ReplyMsgController", 2, "MessageForReplyText deepCopySourceMsg is null");
      }
      paramMessageForReplyText1.setSourceMessageRecord(paramMessageForReplyText2);
      return;
      if (paramMessageForReplyText2.msgtype == -1036)
      {
        paramMessageForReplyText2 = (MessageForMixedMsg)((MessageForLongMsg)paramMessageForReplyText2).rebuildLongMsg();
      }
      else if (paramMessageForReplyText2.msgtype == -1035)
      {
        paramMessageForReplyText2 = ((MessageForMixedMsg)paramMessageForReplyText2).rebuildMixedMsg();
      }
      else if (paramMessageForReplyText2.msgtype == -2011)
      {
        paramMessageForReplyText2 = new MessageForStructing(paramMessageForReplyText2);
      }
      else if (paramMessageForReplyText2.msgtype == -2000)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramMessageForReplyText2.deepCopyByReflect();
        paramMessageForReplyText2 = localMessageRecord;
        if (!TextUtils.isEmpty(paramMessageForReplyText1.mSourceMsgInfo.mSourceMsgTroopName))
        {
          localMessageRecord.istroop = paramMessageForReplyText1.istroop;
          paramMessageForReplyText2 = localMessageRecord;
        }
      }
      else
      {
        paramMessageForReplyText2 = (MessageRecord)paramMessageForReplyText2.deepCopyByReflect();
        continue;
        paramMessageForReplyText2 = null;
      }
    }
  }
  
  private void h(axiu paramaxiu)
  {
    HashMap localHashMap = paramaxiu.jdField_a_of_type_JavaUtilHashMap;
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
      admo localadmo = a(localMessageForReplyText, paramaxiu);
      admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null, paramaxiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, (String)localObject, localMessageForReplyText.atInfoList, localadmo);
      break label55;
      break;
    }
  }
  
  public ArrayList<MessageRecord> a(QQAppInterface paramQQAppInterface, List<? extends MessageRecord> paramList, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    label210:
    label510:
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (paramBoolean)
      {
        if (localMessageRecord.msgtype == -1037) {
          paramList = ((MessageForLongMsg)localMessageRecord).rebuildLongMsg(true);
        }
        for (;;)
        {
          if (paramList != null) {
            break label210;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ReplyMsgController", 2, "preAddMultiMsg.mrTemp is null ,not normal...");
          break;
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
            a((MessageForReplyText)paramList, (MessageForReplyText)localMessageRecord);
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
      for (;;)
      {
        if (paramList == null) {
          break label510;
        }
        paramList.uniseq = localMessageRecord.uniseq;
        paramList.msgseq = localMessageRecord.msgseq;
        if (auea.a(paramList)) {
          paramQQAppInterface.getFileManagerEngine().a().a(localMessageRecord, paramList);
        }
        MessageForReplyText localMessageForReplyText1;
        MessageForReplyText localMessageForReplyText2;
        if ((paramList instanceof MessageForReplyText))
        {
          localMessageForReplyText1 = (MessageForReplyText)localMessageRecord;
          localMessageForReplyText2 = (MessageForReplyText)paramList;
          if ((localMessageForReplyText2.getSourceMessage() != null) && (auea.a(localMessageForReplyText2.getSourceMessage()))) {
            paramQQAppInterface.getFileManagerEngine().a().a(localMessageForReplyText1.getSourceMessage(), localMessageForReplyText2.getSourceMessage());
          }
        }
        if ((paramList instanceof MessageForMixedMsg))
        {
          localMessageForReplyText1 = ((MessageForMixedMsg)paramList).getReplyMessage(paramQQAppInterface);
          localMessageForReplyText2 = ((MessageForMixedMsg)localMessageRecord).getReplyMessage(paramQQAppInterface);
          if ((localMessageForReplyText1 != null) && (localMessageForReplyText2 != null) && (localMessageForReplyText1.getSourceMessage() != null) && (auea.a(localMessageForReplyText1.getSourceMessage()))) {
            paramQQAppInterface.getFileManagerEngine().a().a(localMessageForReplyText2.getSourceMessage(), localMessageForReplyText1.getSourceMessage());
          }
        }
        if (paramList.msgtype == -2022) {
          ((MessageForShortVideo)paramList).redBagType = 0;
        }
        localArrayList.add(paramList);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("ReplyMsgController", 2, "preAddMultiMsg, MessageRecord:" + localMessageRecord.toString());
        break;
        paramList = localMessageRecord;
      }
    }
    return localArrayList;
  }
  
  protected void b(axiu paramaxiu) {}
  
  protected void c(axiu paramaxiu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReplyMsgController", 2, "onFailed");
    }
    azlb localazlb = new azlb();
    localazlb.a = paramaxiu.a();
    onSend(localazlb);
  }
  
  protected void d(axiu paramaxiu)
  {
    int i = 0;
    Object localObject1 = paramaxiu.jdField_a_of_type_JavaUtilList;
    Object localObject2 = (HashMap)paramaxiu.jdField_a_of_type_JavaUtilMap;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramaxiu.jdField_a_of_type_Int != 2) {}
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
    paramaxiu.jdField_a_of_type_JavaUtilHashMap = ((HashMap)localObject1);
    if (paramaxiu.jdField_a_of_type_Int == 0) {}
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(i);
      ((Message)localObject1).obj = paramaxiu;
      ((Message)localObject1).sendToTarget();
      return;
      if (paramaxiu.jdField_a_of_type_Int == 2) {
        i = 1;
      }
    }
  }
  
  public void e(axiu paramaxiu)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramaxiu.a())) {
      this.jdField_a_of_type_JavaUtilMap.put(paramaxiu.a(), paramaxiu);
    }
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage(-1);
    localMessage.obj = paramaxiu;
    localMessage.sendToTarget();
  }
  
  public void f(axiu paramaxiu)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
      if (paramaxiu.jdField_a_of_type_JavaUtilHashMap.size() != 0) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReplyMsgController", 2, "uploadRichMsg dstMsgMap is empty");
    return;
    paramaxiu.a(15);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((axie)localIterator.next()).a(paramaxiu, paramaxiu.jdField_a_of_type_JavaUtilHashMap, this);
    }
    axiv.b("ReplyMsgController step.uploadRichStart", new Object[0]);
  }
  
  protected void g(axiu paramaxiu)
  {
    azlb localazlb = new azlb();
    localazlb.a = paramaxiu.a();
    onSend(localazlb);
  }
  
  public void onSend(azlb paramazlb)
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
          QLog.d("ReplyMsgController", 2, "onSend result.data=" + paramazlb.a);
        }
      } while ((paramazlb.a == null) || (!(paramazlb.a instanceof String)));
      paramazlb = (String)paramazlb.a;
      paramazlb = (axiu)this.jdField_a_of_type_JavaUtilMap.get(paramazlb);
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgController", 2, "onSend request=" + paramazlb);
      }
    } while (paramazlb == null);
    this.jdField_a_of_type_JavaUtilMap.remove(paramazlb.a());
    h(paramazlb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbeq
 * JD-Core Version:    0.7.0.1
 */