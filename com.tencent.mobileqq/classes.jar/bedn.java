import android.content.Context;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.1;
import com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.2;
import com.tencent.mobileqq.teamwork.spread.DataLineMessageSpreadManager.3;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class bedn
  implements Manager
{
  private int jdField_a_of_type_Int = -1;
  public long a;
  private bedf jdField_a_of_type_Bedf;
  private bedl jdField_a_of_type_Bedl;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<MessageRecord> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bedn(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Bedl = new bedl(paramQQAppInterface);
  }
  
  private void a(DataLineMsgRecord paramDataLineMsgRecord, String paramString1, String paramString2, String paramString3, arqa paramarqa)
  {
    if (!this.jdField_a_of_type_Bedl.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("DataLineMessageSpreadManager", 1, "last insert time less");
      }
      return;
    }
    if (QLog.isDebugVersion()) {
      QLog.i("DataLineMessageSpreadManager", 1, "insertGaryTips:" + paramString1 + " link:" + paramString2);
    }
    this.jdField_a_of_type_Bedl.a(paramDataLineMsgRecord);
    new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new DataLineMessageSpreadManager.2(this, paramDataLineMsgRecord, paramString1, paramarqa, paramString2, paramString3), 1000L);
  }
  
  private boolean a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    int i = this.jdField_a_of_type_Bedl.a();
    int j = arqb.a().a();
    if (j == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("DataLineMessageSpreadManager", 1, "config is max: 0, return");
      }
    }
    do
    {
      return false;
      if (i <= j) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("DataLineMessageSpreadManager", 1, "file count over[" + i + "], return");
    return false;
    return true;
  }
  
  public void a(arpy paramarpy)
  {
    this.jdField_a_of_type_Bedl.a(paramarpy);
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (QLog.isDebugVersion())
    {
      QLog.i("DataLineMessageSpreadManager", 4, "ready to post to SubThread Process， msgUid[" + paramDataLineMsgRecord.msgUid + "], hashCode:" + paramDataLineMsgRecord.hashCode());
      if (paramDataLineMsgRecord.msgUid == 0L) {
        aunj.a();
      }
    }
    ThreadManager.executeOnSubThread(new DataLineMessageSpreadManager.1(this, paramDataLineMsgRecord));
  }
  
  public void a(DataLineMsgRecord paramDataLineMsgRecord, Context paramContext)
  {
    paramDataLineMsgRecord = paramDataLineMsgRecord.getExtInfoFromExtStr("tim_aio_file_msg_uiniseq");
    try
    {
      l = Long.parseLong(paramDataLineMsgRecord);
      i = DataLineMsgRecord.getDevTypeBySeId(l);
      paramDataLineMsgRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i).a(l);
      if (paramDataLineMsgRecord == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DataLineMessageSpreadManager", 1, "garyTips not find fileMsg");
        }
        return;
      }
    }
    catch (Exception paramDataLineMsgRecord)
    {
      long l;
      int i;
      for (;;)
      {
        QLog.e("DataLineMessageSpreadManager", 1, paramDataLineMsgRecord.toString());
        l = 0L;
      }
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80098F8", "0X80098F8", 0, 0, "", "", "", "");
      paramDataLineMsgRecord = paramDataLineMsgRecord.trans2Entity();
      if (paramDataLineMsgRecord == null)
      {
        QLog.e("DataLineMessageSpreadManager", 1, "query Entity is nyll!!!, uniseq[" + l + "]");
        return;
      }
      beaj.a(paramDataLineMsgRecord, paramContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 6, i);
    }
  }
  
  public void a(MessageRecord paramMessageRecord, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramMessageRecord == null)
    {
      QLog.e("DataLineMessageSpreadManager", 1, aunj.a());
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DataLineMessageSpreadManager", 1, "send file:" + paramMessageRecord.msgUid);
    }
    ThreadManager.getUIHandler().postDelayed(new DataLineMessageSpreadManager.3(this), 1000L);
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("DataLineMessageSpreadManager", 1, "lastInsertTime[" + this.jdField_a_of_type_Long + "],lstCache size[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
      }
      return;
    }
    finally {}
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedn
 * JD-Core Version:    0.7.0.1
 */