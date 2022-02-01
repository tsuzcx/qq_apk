import com.tencent.qphone.base.util.QLog;

class atxn
  extends anyz
{
  atxn(atxi paramatxi) {}
  
  protected void onSelfPcOnlineStatusUpdateNotify(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      if (atxi.a(this.a)) {
        audr.a(2131694106);
      }
      atxi.a(this.a, false);
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 2, "PC offline!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atxn
 * JD-Core Version:    0.7.0.1
 */