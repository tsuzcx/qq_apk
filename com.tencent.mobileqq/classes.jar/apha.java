import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class apha
{
  protected long a;
  protected apgv a;
  protected final QQAppInterface a;
  protected ExcitingTransferOneSlotComplete a;
  
  public apha(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  protected String a()
  {
    return "actGroupPDSlot";
  }
  
  public void a()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Apgv == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete == null))
    {
      QLog.e("ExtfGroupDownloaderDataReport<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] GroupDownloaderDataReport err. param err");
      return;
    }
    HashMap localHashMap = this.jdField_a_of_type_Apgv.a();
    localHashMap.putAll(this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete.getReportData());
    QLog.i("ExtfGroupDownloaderDataReport<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Long + "] >>> GroupDownloaderDataReport:act=" + a() + localHashMap.toString());
    axrl localaxrl = axrl.a(BaseApplication.getContext());
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str2 = a();
    if (this.jdField_a_of_type_Apgv.jdField_b_of_type_Long == 0L) {}
    for (;;)
    {
      localaxrl.a(str1, str2, bool, 0L, 0L, localHashMap, "");
      this.jdField_a_of_type_Apgv = null;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete = null;
      return;
      bool = false;
    }
  }
  
  public void a(int paramInt, long paramLong1, String paramString, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_Apgv = new apgv();
    this.jdField_a_of_type_Apgv.jdField_a_of_type_Long = paramInt;
    this.jdField_a_of_type_Apgv.jdField_b_of_type_Long = paramLong1;
    this.jdField_a_of_type_Apgv.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Apgv.d = paramLong2;
    this.jdField_a_of_type_Apgv.c = paramLong3;
    this.jdField_a_of_type_Apgv.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Apgv.jdField_b_of_type_Int = 1;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferOneSlotComplete = paramExcitingTransferOneSlotComplete;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apha
 * JD-Core Version:    0.7.0.1
 */