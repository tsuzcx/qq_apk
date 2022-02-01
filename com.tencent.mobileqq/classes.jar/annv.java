public class annv
  implements anny
{
  public void a(amwl paramamwl, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, amwm paramamwm)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6005: 
      paramamwl.getOfflineFinish(paramBoolean);
      return;
    case 6004: 
      paramamwl.pushReadedNotify(paramBoolean, paramObject);
      return;
    case 6006: 
      paramamwl.getOfflineStart(paramBoolean);
      return;
    case 6003: 
      paramamwl.sendResult(paramBoolean, paramArrayOfObject);
      return;
    case 6001: 
      paramamwl.reqInsertBlacklist(paramBoolean, paramObject);
      return;
    case 6002: 
      paramamwl.reqDeleteBlacklist(paramBoolean, (Object[])paramObject);
      return;
    case 6007: 
      paramamwl.pcOnlinesStatus(paramArrayOfObject);
      return;
    case 5006: 
      paramamwl.richSendNotifyMsg(paramBoolean, paramArrayOfObject, paramamwm);
      return;
    case 5012: 
      paramamwl.c2cOnlineFile(paramBoolean, paramArrayOfObject);
      return;
    }
    paramamwl.updateSecretfileStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annv
 * JD-Core Version:    0.7.0.1
 */