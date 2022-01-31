import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class aryf
  extends arxk
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajjy.a(2131650520);
  }
  
  public aryf(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(HashMap<String, ArrayList<MessageRecord>> paramHashMap, ArrayList<MessageForShortVideo> paramArrayList, ArrayList<awel> paramArrayList1, awey paramawey, arya paramarya, arxn paramarxn)
  {
    awey localawey = paramawey;
    if (paramawey == null) {
      localawey = aweg.a(5, 5);
    }
    localawey.a(paramArrayList1);
    localawey.a(new aryg(this, paramArrayList, paramHashMap, paramarxn, paramarya));
    aweg.a(localawey, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(arya paramarya, HashMap<String, ArrayList<MessageRecord>> paramHashMap, arxn paramarxn)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject2 = null;
    Iterator localIterator1 = paramHashMap.keySet().iterator();
    Object localObject1;
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((ArrayList)paramHashMap.get((String)localIterator1.next())).iterator();
      localObject1 = localObject2;
      do
      {
        localObject2 = localObject1;
        if (!localIterator2.hasNext()) {
          break;
        }
        localObject2 = (MessageRecord)localIterator2.next();
      } while ((!(localObject2 instanceof MessageForShortVideo)) && ((!(localObject2 instanceof MessageForReplyText)) || (((MessageForReplyText)localObject2).getSourceMessage() == null) || (!(((MessageForReplyText)localObject2).getSourceMessage() instanceof MessageForShortVideo))));
      if ((localObject2 instanceof MessageForReplyText))
      {
        if (QLog.isColorLevel()) {
          QLog.e("VideoMultiMsgProcessor", 2, "[requestSendMultiMsg]MessageForReplyText source");
        }
        localObject2 = ((MessageForReplyText)localObject2).getSourceMessage();
        ((MessageRecord)localObject2).createMessageUniseq();
        localObject2 = (MessageForShortVideo)localObject2;
        label179:
        ((MessageForShortVideo)localObject2).videoFileName = ShortVideoUtils.c((MessageForShortVideo)localObject2);
        if (localObject1 != null) {
          break label343;
        }
        localObject1 = aweg.a(5, 5);
      }
    }
    label343:
    for (;;)
    {
      awel localawel = aweg.a(5, localObject2, (awey)localObject1);
      if (localawel != null)
      {
        localArrayList1.add(localawel);
        localArrayList2.add(localObject2);
        break;
        localObject2 = (MessageForShortVideo)localObject2;
        break label179;
      }
      if (QLog.isColorLevel()) {
        QLog.e("VideoMultiMsgProcessor", 2, "[requestSendMultiMsg]createShortVideoForwardInfo failed");
      }
      break;
      if ((localArrayList1.size() > 0) && (localArrayList2.size() > 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoMultiMsgProcessor", 2, "[requestSendMultiMsg]Upload videos, count is [" + localArrayList1.size() + "], goto requestUploadVideos");
        }
        a(paramHashMap, localArrayList2, localArrayList1, (awey)localObject2, paramarya, paramarxn);
        return;
      }
      paramarxn.a(0, 8, paramarya);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aryf
 * JD-Core Version:    0.7.0.1
 */