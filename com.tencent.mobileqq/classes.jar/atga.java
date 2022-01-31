import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.QLog;

class atga
  extends bapq
{
  atga(atfz paramatfz) {}
  
  protected void a(boolean paramBoolean, bapt parambapt, int paramInt, String paramString)
  {
    if ((!paramBoolean) || (parambapt == null)) {}
    do
    {
      do
      {
        return;
        QLog.i("WatchTogetherManager", 1, "onGetPlayState  groupuin = " + parambapt.e);
      } while (!(parambapt instanceof WatchTogetherSession));
      paramString = atfz.a(this.a, (WatchTogetherSession)parambapt);
    } while (paramString == null);
    this.a.b(parambapt.e, paramString);
    paramInt = paramString.a;
    this.a.a("100", paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atga
 * JD-Core Version:    0.7.0.1
 */