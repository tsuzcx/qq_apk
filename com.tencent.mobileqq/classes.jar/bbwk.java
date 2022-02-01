import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

class bbwk
  extends AsyncTask<String, Integer, Boolean>
{
  bbwk(bbwb parambbwb) {}
  
  protected Boolean a(String... paramVarArgs)
  {
    if (bbwb.a(this.a) != null)
    {
      bbwb.a(this.a).h = 1;
      long l = bbwb.a(this.a).a;
      paramVarArgs = bbwb.a(this.a).e;
      int i = bbwb.a(this.a).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", paramVarArgs);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", bbwb.a(this.a).c);
      bbwm.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
    return Boolean.valueOf(true);
  }
  
  protected void a(Boolean paramBoolean)
  {
    this.a.b(bbwb.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwk
 * JD-Core Version:    0.7.0.1
 */