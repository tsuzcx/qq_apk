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

public class aulo
{
  public int a;
  public arlp a;
  public awfc a;
  public ayzo a;
  public CopyOnWriteArrayList<auls> a;
  
  public aulo()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public static aulo a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    aulo localaulo = new aulo();
    localaulo.jdField_a_of_type_Arlp = new arlp(paramQQAppInterface, paramChatMessage);
    return localaulo;
  }
  
  public static aulo a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    aulo localaulo = new aulo();
    localaulo.jdField_a_of_type_Ayzo = ayyu.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localaulo.jdField_a_of_type_Int = 2;
    return localaulo;
  }
  
  public static aulo a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (paramMessageForPic.fileSizeFlag == 1) {
      i = 7;
    }
    aulo localaulo = new aulo();
    awfc localawfc = awes.a(i, 1);
    localawfc.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
    localaulo.jdField_a_of_type_Awfc = localawfc;
    localaulo.jdField_a_of_type_Int = 1;
    return localaulo;
  }
  
  public static List<aulo> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, aflj paramaflj, auls paramauls)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramaflj == null)) {
      return null;
    }
    paramaflj = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      switch (aflj.a(paramQQAppInterface, paramList))
      {
      default: 
        paramList = null;
      }
    }
    while (paramList != null)
    {
      paramList.a(paramauls);
      paramaflj.add(paramList);
      break;
      if (((paramList instanceof MessageForPic)) && (!agwq.a((MessageForPic)paramList)))
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
                    return paramaflj;
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
  
  public static aulo b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    aulo localaulo = new aulo();
    localaulo.jdField_a_of_type_Ayzo = ayyu.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localaulo.jdField_a_of_type_Int = 3;
    return localaulo;
  }
  
  public void a(auls paramauls)
  {
    if ((paramauls != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramauls))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramauls);
    }
  }
  
  public void b(auls paramauls)
  {
    if ((paramauls != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramauls))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramauls);
      return;
    }
    catch (Exception paramauls)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveReq", 2, "removeSaveCallBack exception = " + paramauls.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aulo
 * JD-Core Version:    0.7.0.1
 */