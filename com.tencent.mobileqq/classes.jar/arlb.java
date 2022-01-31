import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.QLog;

class arlb
  extends aynj
{
  arlb(arla paramarla) {}
  
  protected void a(boolean paramBoolean, aynm paramaynm, int paramInt, String paramString)
  {
    if ((!paramBoolean) || (paramaynm == null)) {}
    do
    {
      do
      {
        return;
        QLog.i("WatchTogetherManager", 1, "onGetPlayState  groupuin = " + paramaynm.e);
      } while (!(paramaynm instanceof WatchTogetherSession));
      paramString = arla.a(this.a, (WatchTogetherSession)paramaynm);
    } while (paramString == null);
    this.a.b(paramaynm.e, paramString);
    paramInt = paramString.a;
    this.a.a("100", paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arlb
 * JD-Core Version:    0.7.0.1
 */