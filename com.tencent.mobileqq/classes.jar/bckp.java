import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;

class bckp
  extends AsyncTask<String, Integer, Boolean>
{
  bckp(bckg parambckg) {}
  
  protected Boolean a(String... paramVarArgs)
  {
    if (bckg.a(this.a) != null)
    {
      bckg.a(this.a).h = 1;
      long l = bckg.a(this.a).a;
      paramVarArgs = bckg.a(this.a).e;
      int i = bckg.a(this.a).g;
      Bundle localBundle = new Bundle();
      localBundle.putLong("VALUE_MSG_UINSEQ", l);
      localBundle.putString("VALUE_MSG_FRIENDUIN", paramVarArgs);
      localBundle.putInt("VALUE_MSG_ISTROOP", i);
      localBundle.putString("VALUE_MSG_VIDEO_ID", bckg.a(this.a).c);
      bckr.a().a("CMD_UPDATE_MSG_FOR_VIDEO_REDBAG_STAT", localBundle);
    }
    return Boolean.valueOf(true);
  }
  
  protected void a(Boolean paramBoolean)
  {
    this.a.b(bckg.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bckp
 * JD-Core Version:    0.7.0.1
 */