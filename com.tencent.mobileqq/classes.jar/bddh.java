import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

class bddh
  extends AsyncTask<String, Integer, Boolean>
{
  bddh(bdcy parambdcy) {}
  
  protected Boolean a(String... paramVarArgs)
  {
    if (bdcy.a(this.a) != null)
    {
      bdcy.a(this.a).h = 1;
      long l = bdcy.a(this.a).a;
      paramVarArgs = bdcy.a(this.a).e;
      int i = bdcy.a(this.a).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", paramVarArgs);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", bdcy.a(this.a).c);
      bddj.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
    return Boolean.valueOf(true);
  }
  
  protected void a(Boolean paramBoolean)
  {
    this.a.b(bdcy.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddh
 * JD-Core Version:    0.7.0.1
 */