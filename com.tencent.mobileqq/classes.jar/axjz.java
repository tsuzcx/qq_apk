import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

class axjz
  extends AsyncTask<String, Integer, Boolean>
{
  axjz(axjq paramaxjq) {}
  
  protected Boolean a(String... paramVarArgs)
  {
    if (axjq.a(this.a) != null)
    {
      axjq.a(this.a).h = 1;
      long l = axjq.a(this.a).a;
      paramVarArgs = axjq.a(this.a).e;
      int i = axjq.a(this.a).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", paramVarArgs);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", axjq.a(this.a).c);
      axkb.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
    return Boolean.valueOf(true);
  }
  
  protected void a(Boolean paramBoolean)
  {
    this.a.b(axjq.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axjz
 * JD-Core Version:    0.7.0.1
 */