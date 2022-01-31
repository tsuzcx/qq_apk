import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.qphone.base.util.QLog;

class arld
  extends aynl
{
  arld(arlc paramarlc) {}
  
  protected void a(boolean paramBoolean, ayno paramayno, int paramInt, String paramString)
  {
    if ((!paramBoolean) || (paramayno == null)) {}
    do
    {
      do
      {
        return;
        QLog.i("WatchTogetherManager", 1, "onGetPlayState  groupuin = " + paramayno.e);
      } while (!(paramayno instanceof WatchTogetherSession));
      paramString = arlc.a(this.a, (WatchTogetherSession)paramayno);
    } while (paramString == null);
    this.a.b(paramayno.e, paramString);
    paramInt = paramString.a;
    this.a.a("100", paramInt, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arld
 * JD-Core Version:    0.7.0.1
 */