import com.tencent.mobileqq.app.BusinessObserver;

public class bhow
  implements BusinessObserver
{
  private void setColorNick(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 1))
    {
      onSetColorNick(paramBoolean, ((Integer)paramArrayOfObject[0]).intValue(), (String)paramArrayOfObject[1]);
      return;
    }
    onSetColorNick(paramBoolean, 0, "");
  }
  
  protected void handlePendantAuth(boolean paramBoolean, Object paramObject) {}
  
  protected void onApolloDressChange(boolean paramBoolean, Object paramObject) {}
  
  protected void onAuthResponse(boolean paramBoolean, Object paramObject) {}
  
  protected void onChangeUserApolloStatus(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetApolloSign(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetExploreMsg(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetGameCenterPubAccountFeeds(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetGameCenterPubAccountGetFriends(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetGameKey(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetGameOnlineCount(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetMyTroopEffect(boolean paramBoolean, Object paramObject) {}
  
  protected void onGetZanCount(boolean paramBoolean, Object paramObject) {}
  
  protected void onJDCheckRsp(boolean paramBoolean, Object paramObject) {}
  
  protected void onJDCodeRsp(boolean paramBoolean, Object paramObject) {}
  
  protected void onJDHongbaoRsp(boolean paramBoolean, Object paramObject) {}
  
  protected void onPokeAuth(boolean paramBoolean, Object paramObject) {}
  
  protected void onQueryApolloPandora(boolean paramBoolean, Object paramObject) {}
  
  protected void onQueryUserApolloAction(boolean paramBoolean, Object paramObject) {}
  
  protected void onQuickUpdateGetUrl(boolean paramBoolean, Object paramObject) {}
  
  protected void onQuickUpdateSync(boolean paramBoolean, Object paramObject) {}
  
  protected void onSetColorNick(boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void onSetUserFlag(boolean paramBoolean, Object paramObject) {}
  
  protected void onSetZanCount(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 4: 
    case 11: 
    case 12: 
    case 15: 
    case 19: 
    case 20: 
    case 24: 
    case 30: 
    default: 
      return;
    case 1: 
      handlePendantAuth(paramBoolean, paramObject);
      return;
    case 3: 
      onChangeUserApolloStatus(paramBoolean, paramObject);
      return;
    case 5: 
      onAuthResponse(paramBoolean, paramObject);
      return;
    case 2: 
      onApolloDressChange(paramBoolean, paramObject);
      return;
    case 6: 
      onGetZanCount(paramBoolean, paramObject);
      return;
    case 7: 
      onSetZanCount(paramBoolean, paramObject);
      return;
    case 8: 
      onQueryApolloPandora(paramBoolean, paramObject);
      return;
    case 9: 
      onQueryUserApolloAction(paramBoolean, paramObject);
      return;
    case 16: 
      onQuickUpdateSync(paramBoolean, paramObject);
      return;
    case 17: 
      onQuickUpdateGetUrl(paramBoolean, paramObject);
      return;
    case 10: 
      onGetApolloSign(paramBoolean, paramObject);
      return;
    case 13: 
      onJDHongbaoRsp(paramBoolean, paramObject);
      return;
    case 14: 
      onJDCheckRsp(paramBoolean, paramObject);
      return;
    case 18: 
      onJDCodeRsp(paramBoolean, paramObject);
      return;
    case 21: 
      onGetGameKey(paramBoolean, paramObject);
      return;
    case 22: 
      onSetUserFlag(paramBoolean, paramObject);
      return;
    case 23: 
      onPokeAuth(paramBoolean, paramObject);
      return;
    case 25: 
      onGetGameOnlineCount(paramBoolean, paramObject);
      return;
    case 26: 
      onGetMyTroopEffect(paramBoolean, paramObject);
      return;
    case 29: 
      onGetGameCenterPubAccountFeeds(paramBoolean, paramObject);
      return;
    case 31: 
      onGetGameCenterPubAccountGetFriends(paramBoolean, paramObject);
      return;
    case 28: 
      onGetExploreMsg(paramBoolean, paramObject);
      return;
    }
    setColorNick(paramBoolean, (Object[])paramObject);
  }
  
  protected void onWeatherGet(boolean paramBoolean, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhow
 * JD-Core Version:    0.7.0.1
 */