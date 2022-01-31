import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.QLog;

class atbr
  extends balh
{
  atbr(atbq paramatbq) {}
  
  protected void a(boolean paramBoolean, balk parambalk, int paramInt, String paramString)
  {
    if ((!paramBoolean) || (parambalk == null)) {}
    do
    {
      do
      {
        return;
        QLog.i("WatchTogetherManager", 1, "onGetPlayState  groupuin = " + parambalk.e);
      } while (!(parambalk instanceof WatchTogetherSession));
      paramString = atbq.a(this.a, (WatchTogetherSession)parambalk);
    } while (paramString == null);
    this.a.b(parambalk.e, paramString);
    paramInt = paramString.a;
    this.a.a("100", paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atbr
 * JD-Core Version:    0.7.0.1
 */