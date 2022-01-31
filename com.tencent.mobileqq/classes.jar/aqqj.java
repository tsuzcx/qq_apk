import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.QLog;

class aqqj
  extends axnc
{
  aqqj(aqqi paramaqqi) {}
  
  protected void a(boolean paramBoolean, axnf paramaxnf, int paramInt, String paramString)
  {
    if ((!paramBoolean) || (paramaxnf == null)) {}
    do
    {
      do
      {
        return;
        QLog.i("WatchTogetherManager", 1, "onGetPlayState  groupuin = " + paramaxnf.e);
      } while (!(paramaxnf instanceof WatchTogetherSession));
      paramString = aqqi.a(this.a, (WatchTogetherSession)paramaxnf);
    } while (paramString == null);
    this.a.b(paramaxnf.e, paramString);
    paramInt = paramString.a;
    this.a.a("100", paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqqj
 * JD-Core Version:    0.7.0.1
 */