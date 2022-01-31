import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class awan
  implements awau, Manager
{
  private akav jdField_a_of_type_Akav;
  private awal jdField_a_of_type_Awal;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, awar> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public awan(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private awal a()
  {
    if (this.jdField_a_of_type_Awal == null) {
      this.jdField_a_of_type_Awal = new awal(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_Awal;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    ((awan)paramQQAppInterface.getManager(326)).b(paramString, paramLong);
  }
  
  public awar a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          paramString = (awar)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          return paramString;
        }
      }
      awar localawar = new awar(paramString, a());
      localawar.a(this);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localawar);
      paramString = localawar;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akav == null)
    {
      this.jdField_a_of_type_Akav = new awao(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akav);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, akav paramakav)
  {
    a(paramMessageRecord, paramakav, null);
  }
  
  public void a(MessageRecord paramMessageRecord, akav paramakav, awap paramawap)
  {
    awar localawar = a(paramMessageRecord.frienduin);
    String str = null;
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      str = ((MessageForShortVideo)paramMessageRecord).videoFileName;
    }
    while (localawar.a(paramMessageRecord.uniseq, str))
    {
      localawar.a(paramMessageRecord, paramakav, paramawap);
      return;
      if ((paramMessageRecord instanceof MessageForPic)) {
        str = ((MessageForPic)paramMessageRecord).path;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("OrderMediaMsgManager", 2, "sendOrderMsg but not in queue, uniseq:" + paramMessageRecord.uniseq);
    }
    a().a(paramMessageRecord, paramakav, paramawap);
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = a(paramMessageRecord.frienduin);
    if (((awar)localObject).a(paramMessageRecord.uniseq, paramString))
    {
      ((awar)localObject).a(paramMessageRecord, paramMessageRecord.uniseq, paramString, true);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addOrderMsg but not in queue, uniseq:").append(paramMessageRecord.uniseq).append(", path:").append(paramString);
      QLog.d("OrderMediaMsgManager", 2, ((StringBuilder)localObject).toString());
    }
    a().a(paramMessageRecord);
  }
  
  public void a(String paramString)
  {
    awar localawar = null;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localawar = (awar)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          StringBuilder localStringBuilder = ((StringBuilder)???).append("remove orderSession, suin = ").append(paramString).append(", addr = ");
          if (localawar != null)
          {
            paramString = localawar.toString();
            localStringBuilder.append(paramString);
            QLog.d("OrderMediaMsgManager", 2, ((StringBuilder)???).toString());
          }
        }
        else
        {
          return;
        }
      }
      paramString = Integer.valueOf(0);
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    a(paramString).a(paramLong, "");
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    a(paramString).a(paramLong1, paramLong2);
  }
  
  public void a(String paramString1, MessageRecord paramMessageRecord, String paramString2)
  {
    awar localawar = a(paramMessageRecord.frienduin);
    if (!localawar.a(paramMessageRecord.uniseq, paramString2)) {
      a(paramString1, paramMessageRecord.uniseq);
    }
    localawar.a(paramMessageRecord, paramMessageRecord.uniseq, paramString2, false);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (a().a(paramString2)) {
      return;
    }
    a(paramString1).a(0L, paramString2);
  }
  
  public void a(String paramString, ArrayList<ChatMessage> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      int k;
      for (int j = 0; paramArrayList.hasNext(); j = k)
      {
        ChatMessage localChatMessage = (ChatMessage)paramArrayList.next();
        k = j + 1;
        j = i;
        if (awal.a(localChatMessage.msgtype))
        {
          j = i + 1;
          a(paramString).a(localChatMessage.uniseq, "", a().a(localChatMessage));
        }
        i = j;
      }
      awaq.b(j, i);
    }
  }
  
  public boolean a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {}
    while (a(paramString).a()) {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {}
    while (a(paramString).a().a(paramLong) == 0) {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, long paramLong, View paramView, acwf paramacwf)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return false;
    }
    return a(paramString).a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, paramView, paramacwf);
  }
  
  public void b(String paramString, long paramLong)
  {
    a(paramString).a(paramLong);
  }
  
  public boolean b(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {}
    while (a(paramString).a().a(paramLong) != 2) {
      return false;
    }
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.values().iterator();
      while (localIterator.hasNext()) {
        ((awar)localIterator.next()).a();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (this.jdField_a_of_type_Akav != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akav);
      this.jdField_a_of_type_Akav = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awan
 * JD-Core Version:    0.7.0.1
 */