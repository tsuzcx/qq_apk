import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.QLog;

class awfb
  extends bekg
{
  awfb(awfa paramawfa) {}
  
  protected void a(boolean paramBoolean, bekj parambekj, int paramInt, String paramString)
  {
    if ((!paramBoolean) || (parambekj == null)) {}
    do
    {
      do
      {
        return;
        QLog.i("WatchTogetherManager", 1, "onGetPlayState  groupuin = " + parambekj.e);
      } while (!(parambekj instanceof WatchTogetherSession));
      paramString = awfa.a(this.a, (WatchTogetherSession)parambekj);
    } while (paramString == null);
    this.a.b(parambekj.e, paramString);
    paramInt = paramString.a;
    this.a.a("100", paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awfb
 * JD-Core Version:    0.7.0.1
 */