import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class atqc
  extends atqd
{
  private axif jdField_a_of_type_Axif;
  private axiu jdField_a_of_type_Axiu;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HashMap<String, ArrayList<MessageRecord>> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, ArrayList<MessageRecord>> b;
  
  public atqc(QQAppInterface paramQQAppInterface, axiu paramaxiu, HashMap<String, ArrayList<MessageRecord>> paramHashMap, axif paramaxif)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Axiu = paramaxiu;
    this.jdField_a_of_type_Axif = paramaxif;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Axiu == null) {}
    while (this.jdField_a_of_type_Axiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return -1;
    }
    return this.jdField_a_of_type_Axiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Axiu == null) {
      return "";
    }
    if (this.jdField_a_of_type_Axiu.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing == null) {
      return "";
    }
    return String.valueOf(this.jdField_a_of_type_Axiu.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq);
  }
  
  public HashMap<String, ArrayList<MessageRecord>> a()
  {
    if (this.b == null)
    {
      this.b = new HashMap();
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        ArrayList localArrayList = new ArrayList();
        this.b.put(localObject, localArrayList);
        localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
        int i = 0;
        label86:
        MessageRecord localMessageRecord1;
        if (i < ((ArrayList)localObject).size())
        {
          localMessageRecord1 = (MessageRecord)((ArrayList)localObject).get(i);
          if (!(localMessageRecord1 instanceof MessageForReplyText)) {
            break label175;
          }
          MessageForReplyText localMessageForReplyText = (MessageForReplyText)localMessageRecord1;
          MessageRecord localMessageRecord2 = localMessageForReplyText.getSourceMessage();
          if ((localMessageRecord2 == null) || (!auea.a(localMessageRecord2))) {
            break label165;
          }
          localMessageRecord2.isMultiMsg = localMessageForReplyText.isMultiMsg;
          localArrayList.add(localMessageRecord2);
        }
        for (;;)
        {
          i += 1;
          break label86;
          break;
          label165:
          localArrayList.add(localMessageRecord1);
          continue;
          label175:
          localArrayList.add(localMessageRecord1);
        }
      }
    }
    return this.b;
  }
  
  public void a(int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    a(this.b, this.jdField_a_of_type_JavaUtilHashMap);
    paramList2 = new ArrayList();
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      paramList2.addAll(paramList1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramList2, null);
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Axif.a(1, 2, this.jdField_a_of_type_Axiu);
      return;
    }
    this.jdField_a_of_type_Axif.a(0, 2, this.jdField_a_of_type_Axiu);
  }
  
  public void a(String paramString, List<MessageRecord> paramList, MessageRecord paramMessageRecord, int paramInt)
  {
    if ((paramList == null) || (paramMessageRecord == null)) {}
    do
    {
      return;
      paramList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      paramString = null;
      if (paramList != null) {
        paramString = (MessageRecord)paramList.get(paramInt);
      }
    } while (paramString == null);
    if ((paramString instanceof MessageForReplyText))
    {
      paramList = anvx.a(2131706487) + paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramMessageRecord, paramList, true);
      ((MessageForReplyText)paramString).setSourceMessageRecord(paramList);
      return;
    }
    paramString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFaildReason");
    paramList.set(paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramMessageRecord, paramString, true));
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Axiu == null) {
      return "";
    }
    if (this.jdField_a_of_type_Axiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) {
      return "";
    }
    return String.valueOf(this.jdField_a_of_type_Axiu.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqc
 * JD-Core Version:    0.7.0.1
 */