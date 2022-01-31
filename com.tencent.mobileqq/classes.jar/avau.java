import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;

public class avau
  implements avbb, Manager
{
  private ajmm jdField_a_of_type_Ajmm;
  private avas jdField_a_of_type_Avas;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HashMap<String, avay> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public avau(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private avas a()
  {
    if (this.jdField_a_of_type_Avas == null) {
      this.jdField_a_of_type_Avas = new avas(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_Avas;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    ((avau)paramQQAppInterface.getManager(326)).b(paramString, paramLong);
  }
  
  public avay a(String paramString)
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
          paramString = (avay)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          return paramString;
        }
      }
      avay localavay = new avay(paramString, a());
      localavay.a(this);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localavay);
      paramString = localavay;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ajmm == null)
    {
      this.jdField_a_of_type_Ajmm = new avav(this);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajmm);
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      return;
      long l = System.currentTimeMillis();
      if (((paramMessageRecord instanceof MessageForMixedMsg)) || ((paramMessageRecord instanceof MessageForLightVideo))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      }
      while (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("addMsg cost:").append(System.currentTimeMillis() - l).append(" uniseq = ").append(paramMessageRecord.uniseq).append(", msgtype = ").append(paramMessageRecord.msgtype);
        QLog.d("OrderMediaMsgManager", 2, localStringBuilder.toString());
        return;
        ((ajrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramMessageRecord);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, ajmm paramajmm)
  {
    b(paramMessageRecord, paramajmm, null);
  }
  
  public void a(MessageRecord paramMessageRecord, ajmm paramajmm, avaw paramavaw)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramavaw != null) {
      paramavaw.a(paramMessageRecord);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord, paramajmm);
  }
  
  public void a(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = a(paramMessageRecord.frienduin);
    if (((avay)localObject).a(paramMessageRecord.uniseq, paramString))
    {
      ((avay)localObject).a(paramMessageRecord, paramMessageRecord.uniseq, paramString, true);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addOrderMsg but not in queue, uniseq:").append(paramMessageRecord.uniseq).append(", path:").append(paramString);
      QLog.d("OrderMediaMsgManager", 2, ((StringBuilder)localObject).toString());
    }
    a(paramMessageRecord);
  }
  
  public void a(String paramString)
  {
    avay localavay = null;
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        localavay = (avay)this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          StringBuilder localStringBuilder = ((StringBuilder)???).append("remove orderSession, suin = ").append(paramString).append(", addr = ");
          if (localavay != null)
          {
            paramString = localavay.toString();
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
    avay localavay = a(paramMessageRecord.frienduin);
    if (!localavay.a(paramMessageRecord.uniseq, paramString2)) {
      a(paramString1, paramMessageRecord.uniseq);
    }
    localavay.a(paramMessageRecord, paramMessageRecord.uniseq, paramString2, false);
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
        if (avas.a(localChatMessage.msgtype))
        {
          j = i + 1;
          a(paramString).a(localChatMessage.uniseq, "", a().a(localChatMessage));
        }
        i = j;
      }
      avax.b(j, i);
    }
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    if (a().b(paramMessageRecord))
    {
      awfz localawfz = new awfz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), (MessageForShortVideo)paramMessageRecord, null);
      awfy.a().a(paramMessageRecord.uniseq, localawfz);
      bool = true;
    }
    return bool;
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
  
  public boolean a(String paramString, long paramLong, View paramView, aclm paramaclm)
  {
    if ((TextUtils.isEmpty(paramString)) || (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))) {
      return false;
    }
    return a(paramString).a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLong, paramView, paramaclm);
  }
  
  public void b(MessageRecord paramMessageRecord, ajmm paramajmm, avaw paramavaw)
  {
    avay localavay = a(paramMessageRecord.frienduin);
    String str = null;
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      str = ((MessageForShortVideo)paramMessageRecord).videoFileName;
    }
    while (localavay.a(paramMessageRecord.uniseq, str))
    {
      localavay.a(paramMessageRecord, paramajmm, paramavaw);
      return;
      if ((paramMessageRecord instanceof MessageForPic)) {
        str = ((MessageForPic)paramMessageRecord).path;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("OrderMediaMsgManager", 2, "sendOrderMsg but not in queue, uniseq:" + paramMessageRecord.uniseq);
    }
    a(paramMessageRecord, paramajmm, paramavaw);
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
        ((avay)localIterator.next()).a();
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (this.jdField_a_of_type_Ajmm != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajmm);
      this.jdField_a_of_type_Ajmm = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avau
 * JD-Core Version:    0.7.0.1
 */