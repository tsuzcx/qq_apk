import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.QLog;

class ausb
  extends bddc
{
  ausb(ausa paramausa) {}
  
  protected void a(boolean paramBoolean, bddf parambddf, int paramInt, String paramString)
  {
    if ((!paramBoolean) || (parambddf == null)) {}
    do
    {
      do
      {
        return;
        QLog.i("WatchTogetherManager", 1, "onGetPlayState  groupuin = " + parambddf.e);
      } while (!(parambddf instanceof WatchTogetherSession));
      paramString = ausa.a(this.a, (WatchTogetherSession)parambddf);
    } while (paramString == null);
    this.a.b(parambddf.e, paramString);
    paramInt = paramString.a;
    this.a.a("100", paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ausb
 * JD-Core Version:    0.7.0.1
 */