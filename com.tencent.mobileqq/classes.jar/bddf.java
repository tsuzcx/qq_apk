import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

class bddf
  extends AsyncTask<String, Integer, Boolean>
{
  bddf(bdcw parambdcw) {}
  
  protected Boolean a(String... paramVarArgs)
  {
    if (bdcw.a(this.a) != null)
    {
      bdcw.a(this.a).h = 1;
      long l = bdcw.a(this.a).a;
      paramVarArgs = bdcw.a(this.a).e;
      int i = bdcw.a(this.a).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", paramVarArgs);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", bdcw.a(this.a).c);
      bddh.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
    return Boolean.valueOf(true);
  }
  
  protected void a(Boolean paramBoolean)
  {
    this.a.b(bdcw.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddf
 * JD-Core Version:    0.7.0.1
 */