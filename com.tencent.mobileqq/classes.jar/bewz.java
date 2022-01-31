import android.os.AsyncTask;
import com.tencent.mobileqq.widget.ksong.KSongProsBar;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;

public class bewz
  extends AsyncTask<String, Void, beww>
{
  public bewz(KSongView paramKSongView) {}
  
  protected beww a(String... paramVarArgs)
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
  
  protected void a(beww parambeww)
  {
    boolean bool = false;
    if (parambeww != null)
    {
      if (KSongView.a(this.a) != null) {
        KSongView.a(this.a).a(parambeww);
      }
      KSongView.a(this.a).notifyDataSetChanged();
      KSongView.a(this.a, 0);
    }
    QLog.i("KSongView", 2, "InitTask config = " + parambeww);
    if (KSongView.a(this.a) != null)
    {
      bewy localbewy = KSongView.a(this.a);
      if (parambeww != null) {
        bool = true;
      }
      localbewy.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewz
 * JD-Core Version:    0.7.0.1
 */