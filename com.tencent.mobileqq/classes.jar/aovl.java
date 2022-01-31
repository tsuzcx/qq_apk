import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class aovl
  extends aovw
{
  protected long a;
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  
  public aovl(aouy paramaouy, MessageRecord paramMessageRecord)
  {
    super(paramaouy);
    this.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.jdField_a_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.b = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    this.c = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
    this.d = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
    this.e = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    this.f = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.g = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(String paramString, int paramInt, aovv paramaovv)
  {
    if ("1".equals(this.g))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Disc2DiscTaskExcuter:" + this.jdField_a_of_type_JavaLangString + " faild, file is upload paused");
      }
      paramaovv.a(aouy.a(this.jdField_a_of_type_Long, false), false);
      return;
    }
    if ((this.b == null) || (this.b.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_JavaLangString + " Disc2DiscTaskExcuter send faild uuid is null");
      }
      paramaovv.a(aouy.a(this.jdField_a_of_type_Long, true), false);
      return;
    }
    aouy.a(this.jdField_a_of_type_Aouy).a().a().a(paramString, paramInt, this.d, 106, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, this.c, new aovm(this, paramString, paramaovv));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovl
 * JD-Core Version:    0.7.0.1
 */