import com.tencent.qphone.base.util.QLog;

class apba
  extends aouj
{
  apba(apay paramapay) {}
  
  protected void a(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileProgressDirectDone sessionid error.return");
    }
    apbe localapbe;
    do
    {
      return;
      localapbe = this.a.a(paramLong);
      if (localapbe == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileProgressDirectDone");
        return;
      }
      localapbe.h();
    } while (!localapbe.c());
    this.a.c(paramLong);
  }
  
  protected void b(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileRecvButSenderReplayTimeOut sessionid error.return");
    }
    apbe localapbe;
    do
    {
      return;
      localapbe = this.a.a(paramLong);
      if (localapbe == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileRecvButSenderReplayTimeOut");
        return;
      }
      localapbe.j();
    } while (!localapbe.c());
    this.a.c(paramLong);
  }
  
  protected void c(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileQueryUpProgressTimeOut sessionid error.return");
    }
    apbe localapbe;
    do
    {
      return;
      localapbe = this.a.a(paramLong);
      if (localapbe == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileQueryUpProgressTimeOut");
        return;
      }
      localapbe.l();
    } while (!localapbe.c());
    this.a.c(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apba
 * JD-Core Version:    0.7.0.1
 */