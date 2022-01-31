import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

class awkt
  extends AsyncTask<String, Integer, Boolean>
{
  awkt(awkk paramawkk) {}
  
  protected Boolean a(String... paramVarArgs)
  {
    if (awkk.a(this.a) != null)
    {
      awkk.a(this.a).h = 1;
      long l = awkk.a(this.a).a;
      paramVarArgs = awkk.a(this.a).e;
      int i = awkk.a(this.a).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", paramVarArgs);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", awkk.a(this.a).c);
      awkv.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
    return Boolean.valueOf(true);
  }
  
  protected void a(Boolean paramBoolean)
  {
    this.a.b(awkk.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awkt
 * JD-Core Version:    0.7.0.1
 */