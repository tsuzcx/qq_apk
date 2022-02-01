import com.tencent.qphone.base.util.QLog;

class asje
  extends asbj
{
  asje(asjc paramasjc) {}
  
  protected void onOnlineFileProgressDirectDone(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileProgressDirectDone sessionid error.return");
    }
    asji localasji;
    do
    {
      return;
      localasji = this.a.a(paramLong);
      if (localasji == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileProgressDirectDone");
        return;
      }
      localasji.h();
    } while (!localasji.c());
    this.a.c(paramLong);
  }
  
  protected void onOnlineFileQueryUpProgressTimeOut(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileQueryUpProgressTimeOut sessionid error.return");
    }
    asji localasji;
    do
    {
      return;
      localasji = this.a.a(paramLong);
      if (localasji == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileQueryUpProgressTimeOut");
        return;
      }
      localasji.l();
    } while (!localasji.c());
    this.a.c(paramLong);
  }
  
  protected void onOnlineFileRecvButSenderReplayTimeOut(long paramLong)
  {
    if (0L == paramLong) {
      QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "] OnOnlineFileRecvButSenderReplayTimeOut sessionid error.return");
    }
    asji localasji;
    do
    {
      return;
      localasji = this.a.a(paramLong);
      if (localasji == null)
      {
        QLog.e("OnlineFileSessionCenter<FileAssistant>", 1, "OLfilesession[" + paramLong + "]. not find worker.OnOnlineFileRecvButSenderReplayTimeOut");
        return;
      }
      localasji.j();
    } while (!localasji.c());
    this.a.c(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     asje
 * JD-Core Version:    0.7.0.1
 */