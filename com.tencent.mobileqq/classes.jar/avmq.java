import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.QLog;

class avmq
  extends bdrk
{
  avmq(avmp paramavmp) {}
  
  protected void a(boolean paramBoolean, bdrn parambdrn, int paramInt, String paramString)
  {
    if ((!paramBoolean) || (parambdrn == null)) {}
    do
    {
      do
      {
        return;
        QLog.i("WatchTogetherManager", 1, "onGetPlayState  groupuin = " + parambdrn.e);
      } while (!(parambdrn instanceof WatchTogetherSession));
      paramString = avmp.a(this.a, (WatchTogetherSession)parambdrn);
    } while (paramString == null);
    this.a.b(parambdrn.e, paramString);
    paramInt = paramString.a;
    this.a.a("100", paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmq
 * JD-Core Version:    0.7.0.1
 */