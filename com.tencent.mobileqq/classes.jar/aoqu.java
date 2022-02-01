public class aoqu
  implements aoqr
{
  public void a(anyz paramanyz, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, anza paramanza)
  {
    switch (paramInt)
    {
    case 8037: 
    case 8040: 
    case 8041: 
    case 8042: 
    case 8043: 
    case 8044: 
    case 8045: 
    default: 
      return;
    case 8033: 
      paramanyz.macOnlinesStatus(paramArrayOfObject);
      return;
    case 8038: 
      paramanyz.watchOnlineStatus(paramArrayOfObject);
      return;
    case 8034: 
      paramanyz.danceMachine(paramObject);
      return;
    case 8035: 
      paramanyz.handle_NOTIFY_TYPE_CONFESS_TMP(paramBoolean, paramArrayOfObject);
      return;
    case 8036: 
      paramanyz.hiboomAuth(paramArrayOfObject);
      return;
    case 8039: 
      paramanyz.deleteAllSystemMsg(paramBoolean, paramArrayOfObject);
      return;
    }
    paramanyz.sendResultWithTransinfo(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqu
 * JD-Core Version:    0.7.0.1
 */