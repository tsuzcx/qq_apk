public class aoqo
  implements aoqr
{
  public void a(anyz paramanyz, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, anza paramanza)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6005: 
      paramanyz.getOfflineFinish(paramBoolean);
      return;
    case 6004: 
      paramanyz.pushReadedNotify(paramBoolean, paramObject);
      return;
    case 6006: 
      paramanyz.getOfflineStart(paramBoolean);
      return;
    case 6003: 
      paramanyz.sendResult(paramBoolean, paramArrayOfObject);
      return;
    case 6001: 
      paramanyz.reqInsertBlacklist(paramBoolean, paramObject);
      return;
    case 6002: 
      paramanyz.reqDeleteBlacklist(paramBoolean, (Object[])paramObject);
      return;
    case 6007: 
      paramanyz.pcOnlinesStatus(paramArrayOfObject);
      return;
    case 5006: 
      paramanyz.richSendNotifyMsg(paramBoolean, paramArrayOfObject, paramanza);
      return;
    case 5012: 
      paramanyz.c2cOnlineFile(paramBoolean, paramArrayOfObject);
      return;
    }
    paramanyz.updateSecretfileStatus();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqo
 * JD-Core Version:    0.7.0.1
 */