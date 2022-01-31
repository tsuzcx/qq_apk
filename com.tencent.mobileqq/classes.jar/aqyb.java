import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class aqyb
  extends aqya
{
  private aukq jdField_a_of_type_Aukq;
  private auld jdField_a_of_type_Auld;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForReplyText jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText;
  private String jdField_a_of_type_JavaLangString;
  HashMap<String, ArrayList<MessageRecord>> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, ArrayList<MessageRecord>> b;
  
  public aqyb(QQAppInterface paramQQAppInterface, auld paramauld, HashMap<String, ArrayList<MessageRecord>> paramHashMap, aukq paramaukq)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Auld = paramauld;
    this.jdField_a_of_type_Aukq = paramaukq;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty()))
    {
      paramQQAppInterface = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      do
      {
        if (!paramQQAppInterface.hasNext()) {
          break;
        }
        paramauld = (String)paramQQAppInterface.next();
        paramHashMap = ((ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(paramauld)).iterator();
        while (paramHashMap.hasNext())
        {
          paramaukq = (MessageRecord)paramHashMap.next();
          if ((paramaukq instanceof MessageForReplyText))
          {
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText = ((MessageForReplyText)paramaukq);
            this.jdField_a_of_type_JavaLangString = paramauld;
          }
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText == null);
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Auld == null) {}
    while (this.jdField_a_of_type_Auld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return -1;
    }
    return this.jdField_a_of_type_Auld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Auld == null) {
      return "";
    }
    if (this.jdField_a_of_type_Auld.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing == null) {
      return "";
    }
    return String.valueOf(this.jdField_a_of_type_Auld.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq);
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a()
  {
    if (this.b == null)
    {
      this.b = new HashMap();
      if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText != null) && (this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.getSourceMessage() != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)))
      {
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.getSourceMessage();
        Object localObject2;
        if ((localObject1 instanceof MessageForFile))
        {
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageRecord)localObject1).uniseq, ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).istroop);
          if ((localObject2 != null) && (((FileManagerEntity)localObject2).getCloudType() == 0))
          {
            QLog.i("ReplyMsgForwardRequest<QFile>", 1, "getForwardMessageList. init UploadSourceMsgList, find online file.");
            localObject2 = alpo.a(2131713782) + ((MessageRecord)localObject1).getExtInfoFromExtStr("_m_ForwardFileName");
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((MessageRecord)localObject1, (String)localObject2, true);
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.setSourceMessageRecord((MessageRecord)localObject2);
          }
        }
        if (arni.a((MessageRecord)localObject1))
        {
          int i = a();
          if ((i != 0) && (i != 3000) && (i != 1))
          {
            QLog.i("ReplyMsgForwardRequest<QFile>", 1, "getForwardMessageList. init UploadSourceMsgList, find unsupport chatType file.");
            localObject2 = alpo.a(2131713779) + ((MessageRecord)localObject1).getExtInfoFromExtStr("_m_ForwardFileName");
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a((MessageRecord)localObject1, (String)localObject2, true);
            this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.setSourceMessageRecord((MessageRecord)localObject1);
          }
        }
        localObject1 = new ArrayList(1);
        ((ArrayList)localObject1).add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.getSourceMessage());
        this.b.put(this.jdField_a_of_type_JavaLangString, localObject1);
      }
    }
    return this.b;
  }
  
  public void a(int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    a(this.b, this.jdField_a_of_type_JavaUtilHashMap);
    if (paramInt == 1)
    {
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.getSourceMessage();
      paramList2 = alpo.a(2131713781) + paramList1.getExtInfoFromExtStr("_m_ForwardFileName");
      paramList1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramList1, paramList2, false);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.setSourceMessageRecord(paramList1);
      this.jdField_a_of_type_Aukq.a(1, 2, this.jdField_a_of_type_Auld);
      return;
    }
    paramList2 = new ArrayList();
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      paramList2.addAll(paramList1);
    }
    this.jdField_a_of_type_Aukq.a(0, 2, this.jdField_a_of_type_Auld);
  }
  
  public void a(String paramString, List<MessageRecord> paramList, MessageRecord paramMessageRecord, int paramInt)
  {
    paramString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason");
    paramList = alpo.a(2131713780) + paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    paramMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramMessageRecord, paramList, false);
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.setSourceMessageRecord(paramMessageRecord);
    QLog.i("ReplyMsgForwardRequest<QFile>", 1, "replaceDropForwardMsg hint[ + " + paramList + "reason[" + paramString + "]");
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Auld == null) {
      return "";
    }
    if (this.jdField_a_of_type_Auld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return "";
    }
    return String.valueOf(this.jdField_a_of_type_Auld.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqyb
 * JD-Core Version:    0.7.0.1
 */