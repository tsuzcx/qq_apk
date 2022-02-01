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

public class awxd
{
  public int a;
  public attv a;
  public ayxx a;
  public bcev a;
  public CopyOnWriteArrayList<awxh> a;
  
  public awxd()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public static awxd a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    awxd localawxd = new awxd();
    localawxd.jdField_a_of_type_Attv = new attv(paramQQAppInterface, paramChatMessage);
    return localawxd;
  }
  
  public static awxd a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    awxd localawxd = new awxd();
    localawxd.jdField_a_of_type_Bcev = bcec.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localawxd.jdField_a_of_type_Int = 2;
    return localawxd;
  }
  
  public static awxd a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (paramMessageForPic.fileSizeFlag == 1) {
      i = 7;
    }
    awxd localawxd = new awxd();
    ayxx localayxx = ayxn.a(i, 1);
    localayxx.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
    localawxd.jdField_a_of_type_Ayxx = localayxx;
    localawxd.jdField_a_of_type_Int = 1;
    return localawxd;
  }
  
  public static List<awxd> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, agwz paramagwz, awxh paramawxh)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramagwz == null)) {
      return null;
    }
    paramagwz = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      switch (agwz.a(paramQQAppInterface, paramList))
      {
      default: 
        paramList = null;
      }
    }
    while (paramList != null)
    {
      paramList.a(paramawxh);
      paramagwz.add(paramList);
      break;
      if (((paramList instanceof MessageForPic)) && (!ains.a((MessageForPic)paramList)))
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
                    return paramagwz;
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
  
  public static awxd b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    awxd localawxd = new awxd();
    localawxd.jdField_a_of_type_Bcev = bcec.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localawxd.jdField_a_of_type_Int = 3;
    return localawxd;
  }
  
  public void a(awxh paramawxh)
  {
    if ((paramawxh != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramawxh))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramawxh);
    }
  }
  
  public void b(awxh paramawxh)
  {
    if ((paramawxh != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramawxh))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramawxh);
      return;
    }
    catch (Exception paramawxh)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveReq", 2, "removeSaveCallBack exception = " + paramawxh.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awxd
 * JD-Core Version:    0.7.0.1
 */