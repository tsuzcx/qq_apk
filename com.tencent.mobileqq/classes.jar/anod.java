public class anod
  implements anny
{
  public void a(amwl paramamwl, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, amwm paramamwm)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 999: 
      paramamwl.commenMsgContentChanged(paramBoolean, paramObject);
      return;
    case 1000: 
      paramamwl.comenMsgReceived();
      return;
    case 1003: 
      paramamwl.delRoamChatFriend(paramBoolean);
      return;
    case 1004: 
      paramamwl.getRoamChat(paramBoolean, paramObject);
      return;
    case 1005: 
      paramamwl.setRoamChat(paramBoolean);
      return;
    case 2000: 
      paramamwl.friendsListRefresh();
      return;
    case 2001: 
      paramamwl.troopListRefresh();
      return;
    case 2002: 
      paramamwl.recentListRefresh();
      return;
    case 1002: 
      paramamwl.msgDelFriend(paramArrayOfObject);
      return;
    case 3012: 
      paramamwl.transserviceTempChatDownloadPic(paramBoolean, paramArrayOfObject);
      return;
    }
    paramamwl.transserviceC2CUploadStreamPtt(paramBoolean, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anod
 * JD-Core Version:    0.7.0.1
 */