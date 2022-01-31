import android.content.Intent;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.jubao.JubaoMsgData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class arpg
{
  public static List<ChatMessage> a(List<ChatMessage> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramList.next();
        if ((!akpy.j(localChatMessage.msgtype)) && (!acus.a(localChatMessage))) {
          localArrayList.add(localChatMessage);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("jubaoApiPlugin", 0, "filterMsgSize = " + localArrayList.size());
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    asty.a().jdField_a_of_type_Int = 7;
    Object localObject2 = paramIntent.getStringExtra("uin");
    int j = paramIntent.getIntExtra("uintype", 0);
    paramIntent = paramIntent.getSerializableExtra("msgs");
    Object localObject3;
    if (paramIntent != null)
    {
      localObject3 = (ArrayList)paramIntent;
      if (((ArrayList)localObject3).size() != 0) {
        break label50;
      }
    }
    label50:
    label206:
    label237:
    do
    {
      return;
      Object localObject1 = (JubaoMsgData)((ArrayList)localObject3).get(0);
      int i = 1;
      JubaoMsgData localJubaoMsgData;
      if (i < ((ArrayList)localObject3).size())
      {
        localJubaoMsgData = (JubaoMsgData)((ArrayList)localObject3).get(i);
        if ((j == 3000) || (j == 1))
        {
          paramIntent = (Intent)localObject1;
          if (((JubaoMsgData)localObject1).msgSeq > localJubaoMsgData.msgSeq) {
            paramIntent = localJubaoMsgData;
          }
        }
        for (;;)
        {
          i += 1;
          localObject1 = paramIntent;
          break;
          paramIntent = (Intent)localObject1;
          if (((JubaoMsgData)localObject1).msgTime > localJubaoMsgData.msgTime) {
            paramIntent = localJubaoMsgData;
          }
        }
      }
      long l;
      if ((j == 3000) || (j == 1))
      {
        l = ((JubaoMsgData)localObject1).msgSeq;
        paramIntent = new ArrayList();
        paramQQAppInterface = paramQQAppInterface.a().a((String)localObject2, j, l);
        if ((paramQQAppInterface == null) || (paramQQAppInterface.size() <= 0)) {
          break label356;
        }
        localObject1 = ((ArrayList)localObject3).iterator();
        break label237;
      }
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label356;
        }
        localJubaoMsgData = (JubaoMsgData)((Iterator)localObject1).next();
        localObject2 = paramQQAppInterface.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ChatMessage)((Iterator)localObject2).next();
          i = (int)((ChatMessage)localObject3).time;
          if ((j == 3000) || (j == 1))
          {
            i = (int)((ChatMessage)localObject3).shmsgseq;
            if (localJubaoMsgData.msgSeq != i) {
              break label206;
            }
            paramIntent.add(localObject3);
            continue;
            l = ((JubaoMsgData)localObject1).msgTime;
            break;
          }
          int k = (short)(int)((ChatMessage)localObject3).shmsgseq;
          if ((localJubaoMsgData.msgSeq != (0xFFFF & k)) || (localJubaoMsgData.msgTime != i)) {
            break label206;
          }
          paramIntent.add(localObject3);
        }
      }
      if (paramIntent.size() > 0)
      {
        paramQQAppInterface = paramIntent.iterator();
        while (paramQQAppInterface.hasNext())
        {
          localObject1 = (ChatMessage)paramQQAppInterface.next();
          asty.a().jdField_a_of_type_JavaUtilHashMap.put(localObject1, Boolean.valueOf(true));
        }
      }
    } while (!QLog.isColorLevel());
    label356:
    QLog.d("jubaoApiPlugin", 0, "handleOpenAIO = " + paramIntent.size());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arpg
 * JD-Core Version:    0.7.0.1
 */