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

public class axjf
{
  public int a;
  public auch a;
  public azke a;
  public bcxr a;
  public CopyOnWriteArrayList<axjj> a;
  
  public axjf()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public static axjf a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    axjf localaxjf = new axjf();
    localaxjf.jdField_a_of_type_Auch = new auch(paramQQAppInterface, paramChatMessage);
    return localaxjf;
  }
  
  public static axjf a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    axjf localaxjf = new axjf();
    localaxjf.jdField_a_of_type_Bcxr = bcwz.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localaxjf.jdField_a_of_type_Int = 2;
    return localaxjf;
  }
  
  public static axjf a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (paramMessageForPic.fileSizeFlag == 1) {
      i = 7;
    }
    axjf localaxjf = new axjf();
    azke localazke = azjv.a(i, 1);
    localazke.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
    localaxjf.jdField_a_of_type_Azke = localazke;
    localaxjf.jdField_a_of_type_Int = 1;
    return localaxjf;
  }
  
  public static List<axjf> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, agvm paramagvm, axjj paramaxjj)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramagvm == null)) {
      return null;
    }
    paramagvm = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      switch (agvm.a(paramQQAppInterface, paramList))
      {
      default: 
        paramList = null;
      }
    }
    while (paramList != null)
    {
      paramList.a(paramaxjj);
      paramagvm.add(paramList);
      break;
      if (((paramList instanceof MessageForPic)) && (!aioi.a((MessageForPic)paramList)))
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
                    return paramagvm;
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
  
  public static axjf b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    axjf localaxjf = new axjf();
    localaxjf.jdField_a_of_type_Bcxr = bcwz.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localaxjf.jdField_a_of_type_Int = 3;
    return localaxjf;
  }
  
  public void a(axjj paramaxjj)
  {
    if ((paramaxjj != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramaxjj))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramaxjj);
    }
  }
  
  public void b(axjj paramaxjj)
  {
    if ((paramaxjj != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramaxjj))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramaxjj);
      return;
    }
    catch (Exception paramaxjj)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveReq", 2, "removeSaveCallBack exception = " + paramaxjj.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axjf
 * JD-Core Version:    0.7.0.1
 */