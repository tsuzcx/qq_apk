import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

class bgkd
  extends anrc
{
  bgkd(bgkc parambgkc) {}
  
  protected void a(Object paramObject)
  {
    if (this.a.a == null) {}
    for (;;)
    {
      return;
      paramObject = (bfjs)paramObject;
      if (paramObject.jdField_b_of_type_Int == 12)
      {
        long l = paramObject.jdField_b_of_type_Long;
        Iterator localIterator = this.a.a.getMessageFacade().getAIOList(String.valueOf(l), 1).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (ChatMessage)localIterator.next();
          if ((((ChatMessage)localObject).msgtype == -2017) && ((((ChatMessage)localObject).extraflag == 32772) || (((ChatMessage)localObject).extraflag == 32768)) && (((ChatMessage)localObject).isSendFromLocal()))
          {
            localObject = (MessageForTroopFile)localObject;
            if ((((MessageForTroopFile)localObject).uuid != null) && (((MessageForTroopFile)localObject).uuid.equals(paramObject.a.toString()))) {
              this.a.a.getMessageFacade().removeMsgByUniseq(((MessageForTroopFile)localObject).frienduin, ((MessageForTroopFile)localObject).istroop, ((MessageForTroopFile)localObject).uniseq);
            } else if ((!TextUtils.isEmpty(((MessageForTroopFile)localObject).url)) && (!TextUtils.isEmpty(paramObject.e)) && (((MessageForTroopFile)localObject).url.equals(paramObject.e))) {
              this.a.a.getMessageFacade().removeMsgByUniseq(((MessageForTroopFile)localObject).frienduin, ((MessageForTroopFile)localObject).istroop, ((MessageForTroopFile)localObject).uniseq);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgkd
 * JD-Core Version:    0.7.0.1
 */