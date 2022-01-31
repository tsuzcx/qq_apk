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

public class asup
{
  public int a;
  public apsj a;
  public aunt a;
  public axeg a;
  public CopyOnWriteArrayList<asut> a;
  
  public asup()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public static asup a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    asup localasup = new asup();
    localasup.jdField_a_of_type_Apsj = new apsj(paramQQAppInterface, paramChatMessage);
    return localasup;
  }
  
  public static asup a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    asup localasup = new asup();
    localasup.jdField_a_of_type_Axeg = axdo.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localasup.jdField_a_of_type_Int = 2;
    return localasup;
  }
  
  public static asup a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (paramMessageForPic.fileSizeFlag == 1) {
      i = 7;
    }
    asup localasup = new asup();
    aunt localaunt = aunj.a(i, 1);
    localaunt.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
    localasup.jdField_a_of_type_Aunt = localaunt;
    localasup.jdField_a_of_type_Int = 1;
    return localasup;
  }
  
  public static List<asup> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, adtg paramadtg, asut paramasut)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramadtg == null)) {
      return null;
    }
    paramadtg = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      switch (adtg.a(paramQQAppInterface, paramList))
      {
      default: 
        paramList = null;
      }
    }
    while (paramList != null)
    {
      paramList.a(paramasut);
      paramadtg.add(paramList);
      break;
      if (((paramList instanceof MessageForPic)) && (!aezn.a((MessageForPic)paramList)))
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
                    return paramadtg;
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
  
  public static asup b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    asup localasup = new asup();
    localasup.jdField_a_of_type_Axeg = axdo.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localasup.jdField_a_of_type_Int = 3;
    return localasup;
  }
  
  public void a(asut paramasut)
  {
    if ((paramasut != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramasut))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramasut);
    }
  }
  
  public void b(asut paramasut)
  {
    if ((paramasut != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramasut))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramasut);
      return;
    }
    catch (Exception paramasut)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveReq", 2, "removeSaveCallBack exception = " + paramasut.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     asup
 * JD-Core Version:    0.7.0.1
 */