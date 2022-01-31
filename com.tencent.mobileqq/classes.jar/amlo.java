import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class amlo
  extends absi
{
  public amlo(QQAppInterface paramQQAppInterface, QQMessageFacade paramQQMessageFacade, abtf paramabtf)
  {
    super(paramQQAppInterface, paramQQMessageFacade, paramabtf);
  }
  
  public long a(MessageRecord paramMessageRecord)
  {
    return 0L;
  }
  
  public void a(MessageRecord paramMessageRecord, awgf paramawgf, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, absj paramabsj)
  {
    if (paramMessageRecord == null) {
      return;
    }
    if (paramMessageRecord.time == 0L) {
      paramMessageRecord.time = ayzl.a();
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
      if (!alof.x.equals(paramString)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded return : clean all");
      }
      paramString = (badd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
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
  
  public void b(String paramString, int paramInt1, int paramInt2, abts paramabts) {}
  
  public void c(String paramString, int paramInt)
  {
    super.c(paramString, paramInt);
    aors localaors = (aors)aoks.a().a(607);
    if ((localaors == null) || (localaors.a)) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt, 0);
  }
  
  public void c(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, paramInt) > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setReaded clean one uin = " + paramString);
      }
      localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt).a(paramString, paramInt);
      localabta = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      if (localMessageRecord != null)
      {
        l = a(localMessageRecord);
        localabta.a(paramString, paramInt, l, paramBoolean1, paramBoolean2);
        c(paramString, paramInt);
        this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.a(paramString, paramInt));
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, paramInt) <= 0) {
      for (;;)
      {
        MessageRecord localMessageRecord;
        abta localabta;
        return;
        long l = 0L;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageManager", 2, "SubMessageManager setTroopReaded clean one uin = " + paramString);
    }
    c(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amlo
 * JD-Core Version:    0.7.0.1
 */