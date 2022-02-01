import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class aoth
  extends BaseMessageManager
{
  public aoth(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, adah paramadah)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramadah);
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return 0L;
  }
  
  public void a(MessageRecord paramMessageRecord, EntityManager paramEntityManager, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, aczl paramaczl)
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
      if (!antf.x.equals(paramString)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded return : clean all");
      }
      paramString = (bdxc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
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
    arjg localarjg = (arjg)aran.a().a(607);
    if ((localarjg == null) || (localarjg.a)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, 0);
  }
  
  public void b(String paramString, int paramInt1, int paramInt2, aday paramaday) {}
  
  public void c(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded clean one uin = " + paramString);
      }
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt);
      localadab = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localMessageRecord != null)
      {
        l = a(localMessageRecord);
        localadab.a(paramString, paramInt, l, paramBoolean1, paramBoolean2);
        b(paramString, paramInt);
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramString, paramInt));
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt) <= 0) {
      for (;;)
      {
        MessageRecord localMessageRecord;
        adab localadab;
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
 * Qualified Name:     aoth
 * JD-Core Version:    0.7.0.1
 */