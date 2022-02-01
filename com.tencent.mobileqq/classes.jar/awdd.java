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

public class awdd
{
  public int a;
  public asya a;
  public ayds a;
  public bbqx a;
  public CopyOnWriteArrayList<awdh> a;
  
  public awdd()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public static awdd a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    awdd localawdd = new awdd();
    localawdd.jdField_a_of_type_Asya = new asya(paramQQAppInterface, paramChatMessage);
    return localawdd;
  }
  
  public static awdd a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    awdd localawdd = new awdd();
    localawdd.jdField_a_of_type_Bbqx = bbqf.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localawdd.jdField_a_of_type_Int = 2;
    return localawdd;
  }
  
  public static awdd a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (paramMessageForPic.fileSizeFlag == 1) {
      i = 7;
    }
    awdd localawdd = new awdd();
    ayds localayds = aydj.a(i, 1);
    localayds.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
    localawdd.jdField_a_of_type_Ayds = localayds;
    localawdd.jdField_a_of_type_Int = 1;
    return localawdd;
  }
  
  public static List<awdd> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, agcw paramagcw, awdh paramawdh)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramagcw == null)) {
      return null;
    }
    paramagcw = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      switch (agcw.a(paramQQAppInterface, paramList))
      {
      default: 
        paramList = null;
      }
    }
    while (paramList != null)
    {
      paramList.a(paramawdh);
      paramagcw.add(paramList);
      break;
      if (((paramList instanceof MessageForPic)) && (!ahtj.a((MessageForPic)paramList)))
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
                    return paramagcw;
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
  
  public static awdd b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    awdd localawdd = new awdd();
    localawdd.jdField_a_of_type_Bbqx = bbqf.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localawdd.jdField_a_of_type_Int = 3;
    return localawdd;
  }
  
  public void a(awdh paramawdh)
  {
    if ((paramawdh != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramawdh))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramawdh);
    }
  }
  
  public void b(awdh paramawdh)
  {
    if ((paramawdh != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramawdh))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramawdh);
      return;
    }
    catch (Exception paramawdh)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveReq", 2, "removeSaveCallBack exception = " + paramawdh.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awdd
 * JD-Core Version:    0.7.0.1
 */