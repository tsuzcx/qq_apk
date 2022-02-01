import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;

class atsk
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
  protected String h;
  
  atsk(atsi paramatsi, MessageRecord paramMessageRecord)
  {
    super(paramatsi);
    this.jdField_a_of_type_JavaLangString = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    this.jdField_a_of_type_Long = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    this.b = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    this.c = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
    this.d = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
    this.e = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFilePath");
    this.f = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    this.g = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    this.h = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardStatusPaused");
  }
  
  void a(String paramString, int paramInt) {}
  
  void a(String paramString, int paramInt, atte paramatte)
  {
    if ("1".equals(this.h))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Buddy2BuddyTaskExcuter:" + this.jdField_a_of_type_JavaLangString + " faild, file is upload paused");
      }
      paramatte.a(atsi.a(this.jdField_a_of_type_Long, false), false);
      return;
    }
    if ((this.b == null) || (this.b.length() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start Buddy2BuddyTaskExcuter:" + this.jdField_a_of_type_JavaLangString + " faild, file uuid is null");
      }
      paramatte.a(atsi.a(this.jdField_a_of_type_Long, true), false);
      return;
    }
    atqr localatqr = atsi.a(this.jdField_a_of_type_Atsi).a().a();
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgManager<FileAssistant>", 1, "start forwardOfflineFileToX[" + this.jdField_a_of_type_JavaLangString + "]");
    }
    localatqr.a(paramString, paramInt, this.b, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Long, 3, new atsl(this, paramString, paramatte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsk
 * JD-Core Version:    0.7.0.1
 */