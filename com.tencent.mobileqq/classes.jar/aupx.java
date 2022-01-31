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

public class aupx
{
  public int a;
  public arpy a;
  public awjl a;
  public azdx a;
  public CopyOnWriteArrayList<auqb> a;
  
  public aupx()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public static aupx a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    aupx localaupx = new aupx();
    localaupx.jdField_a_of_type_Arpy = new arpy(paramQQAppInterface, paramChatMessage);
    return localaupx;
  }
  
  public static aupx a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    aupx localaupx = new aupx();
    localaupx.jdField_a_of_type_Azdx = azdd.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localaupx.jdField_a_of_type_Int = 2;
    return localaupx;
  }
  
  public static aupx a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (paramMessageForPic.fileSizeFlag == 1) {
      i = 7;
    }
    aupx localaupx = new aupx();
    awjl localawjl = awjb.a(i, 1);
    localawjl.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
    localaupx.jdField_a_of_type_Awjl = localawjl;
    localaupx.jdField_a_of_type_Int = 1;
    return localaupx;
  }
  
  public static List<aupx> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, afpy paramafpy, auqb paramauqb)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramafpy == null)) {
      return null;
    }
    paramafpy = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      switch (afpy.a(paramQQAppInterface, paramList))
      {
      default: 
        paramList = null;
      }
    }
    while (paramList != null)
    {
      paramList.a(paramauqb);
      paramafpy.add(paramList);
      break;
      if (((paramList instanceof MessageForPic)) && (!ahbf.a((MessageForPic)paramList)))
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
                    return paramafpy;
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
  
  public static aupx b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    aupx localaupx = new aupx();
    localaupx.jdField_a_of_type_Azdx = azdd.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localaupx.jdField_a_of_type_Int = 3;
    return localaupx;
  }
  
  public void a(auqb paramauqb)
  {
    if ((paramauqb != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramauqb))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramauqb);
    }
  }
  
  public void b(auqb paramauqb)
  {
    if ((paramauqb != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramauqb))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramauqb);
      return;
    }
    catch (Exception paramauqb)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveReq", 2, "removeSaveCallBack exception = " + paramauqb.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aupx
 * JD-Core Version:    0.7.0.1
 */