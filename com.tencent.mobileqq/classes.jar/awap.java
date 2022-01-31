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

public class awap
  implements awaw, Manager
{
  private akat jdField_a_of_type_Akat;
  private awan jdField_a_of_type_Awan;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, awat> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public awap(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private awan a()
  {
    if (this.jdField_a_of_type_Awan == null) {
      this.jdField_a_of_type_Awan = new awan(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_Awan;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    ((awap)paramQQAppInterface.getManager(326)).b(paramString, paramLong);
  }
  
  public awat a(String paramString)
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
          paramString = (awat)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          return paramString;
        }
      }
      awat localawat = new awat(paramString, a());
      localawat.a(this);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localawat);
      paramString = localawat;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Akat == null)
    {
      this.jdField_a_of_type_Akat = new awaq(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akat);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, akat paramakat)
  {
    a(paramMessageRecord, paramakat, null);
  }
  
  public void a(MessageRecord paramMessageRecord, akat paramakat, awar paramawar)
  {
    awat localawat = a(paramMessageRecord.frienduin);
    String str = null;
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      str = ((MessageForShortVideo)paramMessageRecord).videoFileName;
    }
    while (localawat.a(paramMessageRecord.uniseq, str))
    {
      localawat.a(paramMessageRecord, paramakat, paramawar);
      return;
      if ((paramMessageRecord instanceof MessageForPic)) {
        str = ((MessageForPic)paramMessageRecord).path;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("OrderMediaMsgManager", 2, "sendOrderMsg but not in queue, uniseq:" + paramMessageRecord.uniseq);
    }
    a().a(paramMessageRecord, paramakat, paramawar);
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = a(paramMessageRecord.frienduin);
    if (((awat)localObject).a(paramMessageRecord.uniseq, paramString))
    {
      ((awat)localObject).a(paramMessageRecord, paramMessageRecord.uniseq, paramString, true);
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
    awat localawat = null;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localawat = (awat)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          StringBuilder localStringBuilder = ((StringBuilder)???).append("remove orderSession, suin = ").append(paramString).append(", addr = ");
          if (localawat != null)
          {
            paramString = localawat.toString();
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
    awat localawat = a(paramMessageRecord.frienduin);
    if (!localawat.a(paramMessageRecord.uniseq, paramString2)) {
      a(paramString1, paramMessageRecord.uniseq);
    }
    localawat.a(paramMessageRecord, paramMessageRecord.uniseq, paramString2, false);
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
        if (awan.a(localChatMessage.msgtype))
        {
          j = i + 1;
          a(paramString).a(localChatMessage.uniseq, "", a().a(localChatMessage));
        }
        i = j;
      }
      awas.b(j, i);
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
  
  public boolean a(String paramString, long paramLong, View paramView, acwb paramacwb)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return false;
    }
    return a(paramString).a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, paramView, paramacwb);
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
        ((awat)localIterator.next()).a();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (this.jdField_a_of_type_Akat != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akat);
      this.jdField_a_of_type_Akat = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awap
 * JD-Core Version:    0.7.0.1
 */