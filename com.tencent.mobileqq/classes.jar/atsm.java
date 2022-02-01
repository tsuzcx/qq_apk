import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class atsm
  extends attg
{
  protected long a;
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  protected String g;
  
  atsm(atsi paramatsi, MessageRecord paramMessageRecord)
  {
    super(paramatsi);
    this.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.jdField_a_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.b = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    this.c = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
    this.d = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
    this.e = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    this.f = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.g = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(String paramString, int paramInt, atte paramatte)
  {
    if ("1".equals(this.g))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Buddy2DiscTaskExcuter:" + this.jdField_a_of_type_JavaLangString + " faild, file is upload paused");
      }
      paramatte.a(atsi.a(this.jdField_a_of_type_Long, false), false);
      return;
    }
    if ((this.b == null) || (this.b.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_JavaLangString + " Buddy2DiscTaskExcuter faild,文件不存在或已失效");
      }
      paramatte.a(atsi.a(this.jdField_a_of_type_Long, true), false);
      return;
    }
    atsi.a(this.jdField_a_of_type_Atsi).a().a().a(paramString, paramInt, this.b, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, 106, new atsn(this, paramString, paramatte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsm
 * JD-Core Version:    0.7.0.1
 */