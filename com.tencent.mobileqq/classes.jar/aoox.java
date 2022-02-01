import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class aoox
  extends BaseMessageManager
{
  public aoox(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, acne paramacne)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramacne);
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return 0L;
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, acmb paramacmb)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = bcrg.a();
    }
    if (paramMessageRecord.msgseq == 0L) {
      paramMessageRecord.msgseq = ((int)paramMessageRecord.time);
    }
    a(paramMessageRecord, true, 1);
  }
  
  public void a(String paramString, int paramInt, List<MessageRecord> paramList1, List<MessageRecord> paramList2, Bundle paramBundle) {}
  
  public void a(String paramString, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded uin=" + paramString + ",type=" + paramInt1 + ",needDelMark=" + paramBoolean2);
    }
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded return : uin=null");
      }
    }
    for (;;)
    {
      return;
      if (!AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramString)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded return : clean all");
      }
      paramString = (bdxs)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SUB_ACCOUNT_MANAGER);
      if (paramString != null)
      {
        paramString = paramString.a().iterator();
        while (paramString.hasNext())
        {
          String str = (String)paramString.next();
          if (!TextUtils.isEmpty(str)) {
            c(str, paramInt1, paramBoolean1, paramBoolean1);
          }
        }
      }
    }
    c(paramString, paramInt1, paramBoolean1, paramBoolean2);
  }
  
  public void b(String paramString, int paramInt)
  {
    super.b(paramString, paramInt);
    argg localargg = (argg)aqxe.a().a(607);
    if ((localargg == null) || (localargg.a)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().b(paramString, paramInt, 0);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, QQMessageFacade.RefreshMessageContext paramRefreshMessageContext) {}
  
  public void c(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().a(paramString, paramInt) > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded clean one uin = " + paramString);
      }
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageProxy(paramInt).a(paramString, paramInt);
      localacmw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade();
      if (localMessageRecord != null)
      {
        l = a(localMessageRecord);
        localacmw.a(paramString, paramInt, l, paramBoolean1, paramBoolean2);
        b(paramString, paramInt);
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.setChangeAndNotify(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getLastMessage(paramString, paramInt));
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getConversationFacade().b(paramString, paramInt) <= 0) {
      for (;;)
      {
        MessageRecord localMessageRecord;
        acmw localacmw;
        return;
        long l = 0L;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setTroopReaded clean one uin = " + paramString);
    }
    b(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoox
 * JD-Core Version:    0.7.0.1
 */