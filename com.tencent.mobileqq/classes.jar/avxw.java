import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.QLog;

class avxw
  extends beke
{
  avxw(avxv paramavxv) {}
  
  protected void a(boolean paramBoolean, bekh parambekh, int paramInt, String paramString)
  {
    if ((!paramBoolean) || (parambekh == null)) {}
    do
    {
      do
      {
        return;
        QLog.i("WatchTogetherManager", 1, "onGetPlayState  groupuin = " + parambekh.e);
      } while (!(parambekh instanceof WatchTogetherSession));
      paramString = avxv.a(this.a, (WatchTogetherSession)parambekh);
    } while (paramString == null);
    this.a.b(parambekh.e, paramString);
    paramInt = paramString.a;
    this.a.a("100", paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxw
 * JD-Core Version:    0.7.0.1
 */