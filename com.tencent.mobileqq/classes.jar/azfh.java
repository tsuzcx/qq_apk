import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

class azfh
  extends AsyncTask<String, Integer, Boolean>
{
  azfh(azey paramazey) {}
  
  protected Boolean a(String... paramVarArgs)
  {
    if (azey.a(this.a) != null)
    {
      azey.a(this.a).h = 1;
      long l = azey.a(this.a).a;
      paramVarArgs = azey.a(this.a).e;
      int i = azey.a(this.a).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", paramVarArgs);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", azey.a(this.a).c);
      azfj.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
    return Boolean.valueOf(true);
  }
  
  protected void a(Boolean paramBoolean)
  {
    this.a.b(azey.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azfh
 * JD-Core Version:    0.7.0.1
 */