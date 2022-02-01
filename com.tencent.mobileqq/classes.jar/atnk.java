import com.tencent.qphone.base.util.QLog;

class atnk
  extends atfq
{
  atnk(atni paramatni) {}
  
  protected void a(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileProgressDirectDone sessionid error.return");
    }
    atno localatno;
    do
    {
      return;
      localatno = this.a.a(paramLong);
      if (localatno == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileProgressDirectDone");
        return;
      }
      localatno.h();
    } while (!localatno.c());
    this.a.c(paramLong);
  }
  
  protected void b(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileRecvButSenderReplayTimeOut sessionid error.return");
    }
    atno localatno;
    do
    {
      return;
      localatno = this.a.a(paramLong);
      if (localatno == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileRecvButSenderReplayTimeOut");
        return;
      }
      localatno.j();
    } while (!localatno.c());
    this.a.c(paramLong);
  }
  
  protected void c(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileQueryUpProgressTimeOut sessionid error.return");
    }
    atno localatno;
    do
    {
      return;
      localatno = this.a.a(paramLong);
      if (localatno == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileQueryUpProgressTimeOut");
        return;
      }
      localatno.l();
    } while (!localatno.c());
    this.a.c(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     atnk
 * JD-Core Version:    0.7.0.1
 */