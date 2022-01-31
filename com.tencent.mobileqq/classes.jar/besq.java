import android.os.AsyncTask;
import com.tencent.mobileqq.widget.ksong.KSongProsBar;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;

public class besq
  extends AsyncTask<String, Void, besn>
{
  public besq(KSongView paramKSongView) {}
  
  protected besn a(String... paramVarArgs)
  {
    String str = paramVarArgs[0];
    paramVarArgs = paramVarArgs[1];
    for (;;)
    {
      try
      {
        KSongView.a(this.a, KSongView.a(this.a, paramVarArgs));
        if ((KSongView.a(this.a) != null) && (KSongView.a(this.a, str)))
        {
          paramVarArgs = KSongView.a(this.a);
          return paramVarArgs;
        }
      }
      finally {}
      paramVarArgs = null;
    }
  }
  
  protected void a(besn parambesn)
  {
    boolean bool = false;
    if (parambesn != null)
    {
      if (KSongView.a(this.a) != null) {
        KSongView.a(this.a).a(parambesn);
      }
      KSongView.a(this.a).notifyDataSetChanged();
      KSongView.a(this.a, 0);
    }
    QLog.i("KSongView", 2, "InitTask config = " + parambesn);
    if (KSongView.a(this.a) != null)
    {
      besp localbesp = KSongView.a(this.a);
      if (parambesn != null) {
        bool = true;
      }
      localbesp.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     besq
 * JD-Core Version:    0.7.0.1
 */