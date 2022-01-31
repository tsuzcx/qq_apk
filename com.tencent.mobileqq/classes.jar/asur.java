import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class asur
{
  public int a;
  public apsn a;
  public aunv a;
  public axei a;
  public CopyOnWriteArrayList<asuv> a;
  
  public asur()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public static asur a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    asur localasur = new asur();
    localasur.jdField_a_of_type_Apsn = new apsn(paramQQAppInterface, paramChatMessage);
    return localasur;
  }
  
  public static asur a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    asur localasur = new asur();
    localasur.jdField_a_of_type_Axei = axdq.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localasur.jdField_a_of_type_Int = 2;
    return localasur;
  }
  
  public static asur a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (paramMessageForPic.fileSizeFlag == 1) {
      i = 7;
    }
    asur localasur = new asur();
    aunv localaunv = aunl.a(i, 1);
    localaunv.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
    localasur.jdField_a_of_type_Aunv = localaunv;
    localasur.jdField_a_of_type_Int = 1;
    return localasur;
  }
  
  public static List<asur> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, adte paramadte, asuv paramasuv)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramadte == null)) {
      return null;
    }
    paramadte = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      switch (adte.a(paramQQAppInterface, paramList))
      {
      default: 
        paramList = null;
      }
    }
    while (paramList != null)
    {
      paramList.a(paramasuv);
      paramadte.add(paramList);
      break;
      if (((paramList instanceof MessageForPic)) && (!aezl.a((MessageForPic)paramList)))
      {
        paramList = a((MessageForPic)paramList);
        continue;
        if ((paramList instanceof MessageForShortVideo))
        {
          paramList = a(paramQQAppInterface, (MessageForShortVideo)paramList);
          continue;
          if ((paramList instanceof MessageForShortVideo))
          {
            paramList = b(paramQQAppInterface, (MessageForShortVideo)paramList);
            continue;
            if ((paramList instanceof MessageForFile))
            {
              paramList = a(paramQQAppInterface, paramList);
              paramList.jdField_a_of_type_Int = 4;
              continue;
              if ((paramList instanceof MessageForFile))
              {
                paramList = a(paramQQAppInterface, paramList);
                paramList.jdField_a_of_type_Int = 5;
                continue;
                if ((paramList instanceof MessageForTroopFile))
                {
                  paramList = a(paramQQAppInterface, paramList);
                  paramList.jdField_a_of_type_Int = 6;
                  continue;
                  if ((paramList instanceof MessageForTroopFile))
                  {
                    paramList = a(paramQQAppInterface, paramList);
                    paramList.jdField_a_of_type_Int = 7;
                    continue;
                    return paramadte;
                  }
                }
              }
            }
          }
        }
      }
      paramList = null;
    }
  }
  
  public static asur b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    asur localasur = new asur();
    localasur.jdField_a_of_type_Axei = axdq.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localasur.jdField_a_of_type_Int = 3;
    return localasur;
  }
  
  public void a(asuv paramasuv)
  {
    if ((paramasuv != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramasuv))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramasuv);
    }
  }
  
  public void b(asuv paramasuv)
  {
    if ((paramasuv != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramasuv))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramasuv);
      return;
    }
    catch (Exception paramasuv)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveReq", 2, "removeSaveCallBack exception = " + paramasuv.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asur
 * JD-Core Version:    0.7.0.1
 */