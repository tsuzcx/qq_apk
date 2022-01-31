import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class aqoc
  extends aqou
{
  protected long a;
  protected String a;
  protected String b;
  protected String c;
  protected String d;
  protected String e;
  protected String f;
  
  public aqoc(aqnw paramaqnw, MessageRecord paramMessageRecord)
  {
    super(paramaqnw);
    this.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.jdField_a_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.b = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    this.c = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
    this.d = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    this.e = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.f = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(String paramString, int paramInt, aqot paramaqot)
  {
    if ("1".equals(this.f))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Buddy2TroopTaskExcuter:" + this.jdField_a_of_type_JavaLangString + " faild, file is upload paused");
      }
      paramaqot.a(aqnw.a(this.jdField_a_of_type_Long, false), false);
      return;
    }
    if ((this.b == null) || (this.b.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgManager<FileAssistant>", 1, this.jdField_a_of_type_JavaLangString + " Buddy2TroopTaskExcuter faild uuid is null");
      }
      paramaqot.a(aqnw.a(this.jdField_a_of_type_Long, true), false);
      return;
    }
    aqnw.a(this.jdField_a_of_type_Aqnw).a().a().a(paramString, paramInt, this.b, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, 102, new aqod(this, paramString, paramaqot));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqoc
 * JD-Core Version:    0.7.0.1
 */