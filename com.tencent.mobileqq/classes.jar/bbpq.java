import android.os.AsyncTask;
import com.tencent.mobileqq.widget.ksong.KSongProsBar;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;

public class bbpq
  extends AsyncTask<String, Void, bbpn>
{
  public bbpq(KSongView paramKSongView) {}
  
  protected bbpn a(String... paramVarArgs)
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
  
  protected void a(bbpn parambbpn)
  {
    boolean bool = false;
    if (parambbpn != null)
    {
      if (KSongView.a(this.a) != null) {
        KSongView.a(this.a).a(parambbpn);
      }
      KSongView.a(this.a).notifyDataSetChanged();
      KSongView.a(this.a, 0);
    }
    QLog.i("KSongView", 2, "InitTask config = " + parambbpn);
    if (KSongView.a(this.a) != null)
    {
      bbpp localbbpp = KSongView.a(this.a);
      if (parambbpn != null) {
        bool = true;
      }
      localbbpp.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbpq
 * JD-Core Version:    0.7.0.1
 */