import com.tencent.qphone.base.util.QLog;

class aqyl
  extends aqru
{
  aqyl(aqyj paramaqyj) {}
  
  protected void a(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileProgressDirectDone sessionid error.return");
    }
    aqyp localaqyp;
    do
    {
      return;
      localaqyp = this.a.a(paramLong);
      if (localaqyp == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileProgressDirectDone");
        return;
      }
      localaqyp.h();
    } while (!localaqyp.c());
    this.a.c(paramLong);
  }
  
  protected void b(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileRecvButSenderReplayTimeOut sessionid error.return");
    }
    aqyp localaqyp;
    do
    {
      return;
      localaqyp = this.a.a(paramLong);
      if (localaqyp == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileRecvButSenderReplayTimeOut");
        return;
      }
      localaqyp.j();
    } while (!localaqyp.c());
    this.a.c(paramLong);
  }
  
  protected void c(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileQueryUpProgressTimeOut sessionid error.return");
    }
    aqyp localaqyp;
    do
    {
      return;
      localaqyp = this.a.a(paramLong);
      if (localaqyp == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileQueryUpProgressTimeOut");
        return;
      }
      localaqyp.l();
    } while (!localaqyp.c());
    this.a.c(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyl
 * JD-Core Version:    0.7.0.1
 */