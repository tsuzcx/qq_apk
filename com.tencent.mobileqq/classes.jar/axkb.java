import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

class axkb
  extends AsyncTask<String, Integer, Boolean>
{
  axkb(axjs paramaxjs) {}
  
  protected Boolean a(String... paramVarArgs)
  {
    if (axjs.a(this.a) != null)
    {
      axjs.a(this.a).h = 1;
      long l = axjs.a(this.a).a;
      paramVarArgs = axjs.a(this.a).e;
      int i = axjs.a(this.a).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", paramVarArgs);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", axjs.a(this.a).c);
      axkd.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
    return Boolean.valueOf(true);
  }
  
  protected void a(Boolean paramBoolean)
  {
    this.a.b(axjs.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axkb
 * JD-Core Version:    0.7.0.1
 */