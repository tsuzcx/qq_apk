import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

class azjq
  extends AsyncTask<String, Integer, Boolean>
{
  azjq(azjh paramazjh) {}
  
  protected Boolean a(String... paramVarArgs)
  {
    if (azjh.a(this.a) != null)
    {
      azjh.a(this.a).h = 1;
      long l = azjh.a(this.a).a;
      paramVarArgs = azjh.a(this.a).e;
      int i = azjh.a(this.a).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", paramVarArgs);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", azjh.a(this.a).c);
      azjs.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
    return Boolean.valueOf(true);
  }
  
  protected void a(Boolean paramBoolean)
  {
    this.a.b(azjh.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjq
 * JD-Core Version:    0.7.0.1
 */