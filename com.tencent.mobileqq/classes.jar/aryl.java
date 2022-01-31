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

public class aryl
{
  public int a;
  public apap a;
  public atpv a;
  public awey a;
  public CopyOnWriteArrayList<aryp> a;
  
  public aryl()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  }
  
  public static aryl a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    aryl localaryl = new aryl();
    localaryl.jdField_a_of_type_Apap = new apap(paramQQAppInterface, paramChatMessage);
    return localaryl;
  }
  
  public static aryl a(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    aryl localaryl = new aryl();
    localaryl.jdField_a_of_type_Awey = aweg.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localaryl.jdField_a_of_type_Int = 2;
    return localaryl;
  }
  
  public static aryl a(MessageForPic paramMessageForPic)
  {
    int i = 6;
    if (paramMessageForPic.fileSizeFlag == 1) {
      i = 7;
    }
    aryl localaryl = new aryl();
    atpv localatpv = atpl.a(i, 1);
    localatpv.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
    localaryl.jdField_a_of_type_Atpv = localatpv;
    localaryl.jdField_a_of_type_Int = 1;
    return localaryl;
  }
  
  public static List<aryl> a(QQAppInterface paramQQAppInterface, List<ChatMessage> paramList, adie paramadie, aryp paramaryp)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramadie == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (ChatMessage)localIterator.next();
      switch (paramadie.a(paramList))
      {
      default: 
        paramList = null;
      }
    }
    while (paramList != null)
    {
      paramList.a(paramaryp);
      localArrayList.add(paramList);
      break;
      if (((paramList instanceof MessageForPic)) && (!aeor.a((MessageForPic)paramList)))
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
                    return localArrayList;
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
  
  public static aryl b(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo)
  {
    aryl localaryl = new aryl();
    localaryl.jdField_a_of_type_Awey = aweg.a(paramQQAppInterface, paramMessageForShortVideo, 1);
    localaryl.jdField_a_of_type_Int = 3;
    return localaryl;
  }
  
  public void a(aryp paramaryp)
  {
    if ((paramaryp != null) && (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramaryp))) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramaryp);
    }
  }
  
  public void b(aryp paramaryp)
  {
    if ((paramaryp != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramaryp))) {}
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramaryp);
      return;
    }
    catch (Exception paramaryp)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FileSaveReq", 2, "removeSaveCallBack exception = " + paramaryp.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aryl
 * JD-Core Version:    0.7.0.1
 */