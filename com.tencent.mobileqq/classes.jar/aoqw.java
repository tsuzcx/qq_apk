public class aoqw
  implements aoqr
{
  public void a(anyz paramanyz, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, anza paramanza)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 999: 
      paramanyz.commenMsgContentChanged(paramBoolean, paramObject);
      return;
    case 1000: 
      paramanyz.comenMsgReceived();
      return;
    case 1003: 
      paramanyz.delRoamChatFriend(paramBoolean);
      return;
    case 1004: 
      paramanyz.getRoamChat(paramBoolean, paramObject);
      return;
    case 1005: 
      paramanyz.setRoamChat(paramBoolean);
      return;
    case 2000: 
      paramanyz.friendsListRefresh();
      return;
    case 2001: 
      paramanyz.troopListRefresh();
      return;
    case 2002: 
      paramanyz.recentListRefresh();
      return;
    case 1002: 
      paramanyz.msgDelFriend(paramArrayOfObject);
      return;
    case 3012: 
      paramanyz.transserviceTempChatDownloadPic(paramBoolean, paramArrayOfObject);
      return;
    }
    paramanyz.transserviceC2CUploadStreamPtt(paramBoolean, paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqw
 * JD-Core Version:    0.7.0.1
 */