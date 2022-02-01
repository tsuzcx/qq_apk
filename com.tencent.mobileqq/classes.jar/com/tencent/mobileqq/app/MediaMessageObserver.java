package com.tencent.mobileqq.app;

public class MediaMessageObserver
  extends BaseMessageObserver
{
  private void richSendNotifyMsg(boolean paramBoolean, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    long l;
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 2))
    {
      l = ((Long)paramArrayOfObject[0]).longValue();
      paramStatictisInfo = (StatictisInfo)paramArrayOfObject[1];
    }
    else
    {
      l = 0L;
    }
    onNotifyResultAfterSendRich(paramBoolean, l, paramStatictisInfo);
  }
  
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, StatictisInfo paramStatictisInfo) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      paramObject = (Object[])paramObject;
    } else {
      paramObject = null;
    }
    if (paramInt != 5006) {
      return;
    }
    richSendNotifyMsg(paramBoolean, paramObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.MediaMessageObserver
 * JD-Core Version:    0.7.0.1
 */