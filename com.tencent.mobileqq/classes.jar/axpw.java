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

public class axpw
{
  public int a;
  public aulq a;
  public azqk a;
  public bcxn a;
  public CopyOnWriteArrayList<axqa> a;
  
  public axpw()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public static axpw a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    axpw localaxpw = new axpw();
    localaxpw.jdField_a_of_type_Aulq = new aulq(paramQQAppInterface, paramChatMessage);
    return localaxpw;
  }
  
  public static axpw a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    axpw localaxpw = new axpw();
    localaxpw.jdField_a_of_type_Bcxn = bcwu.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localaxpw.jdField_a_of_type_Int = 2;
    return localaxpw;
  }
  
  public static axpw a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (paramMessageForPic.fileSizeFlag == 1) {
      i = 7;
    }
    axpw localaxpw = new axpw();
    azqk localazqk = azqb.a(i, 1);
    localazqk.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
    localaxpw.jdField_a_of_type_Azqk = localazqk;
    localaxpw.jdField_a_of_type_Int = 1;
    return localaxpw;
  }
  
  public static List<axpw> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, ahgk paramahgk, axqa paramaxqa)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramahgk == null)) {
      return null;
    }
    paramahgk = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      switch (ahgk.a(paramQQAppInterface, paramList))
      {
      default: 
        paramList = null;
      }
    }
    while (paramList != null)
    {
      paramList.a(paramaxqa);
      paramahgk.add(paramList);
      break;
      if (((paramList instanceof MessageForPic)) && (!aiyz.a((MessageForPic)paramList)))
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
                    return paramahgk;
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
  
  public static axpw b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    axpw localaxpw = new axpw();
    localaxpw.jdField_a_of_type_Bcxn = bcwu.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localaxpw.jdField_a_of_type_Int = 3;
    return localaxpw;
  }
  
  public void a(axqa paramaxqa)
  {
    if ((paramaxqa != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramaxqa))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramaxqa);
    }
  }
  
  public void b(axqa paramaxqa)
  {
    if ((paramaxqa != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramaxqa))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramaxqa);
      return;
    }
    catch (Exception paramaxqa)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveReq", 2, "removeSaveCallBack exception = " + paramaxqa.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axpw
 * JD-Core Version:    0.7.0.1
 */