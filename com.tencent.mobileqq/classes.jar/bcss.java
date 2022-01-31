import android.os.AsyncTask;
import com.tencent.mobileqq.widget.ksong.KSongProsBar;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;

public class bcss
  extends AsyncTask<String, Void, bcsp>
{
  public bcss(KSongView paramKSongView) {}
  
  protected bcsp a(String... paramVarArgs)
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
  
  protected void a(bcsp parambcsp)
  {
    boolean bool = false;
    if (parambcsp != null)
    {
      if (KSongView.a(this.a) != null) {
        KSongView.a(this.a).a(parambcsp);
      }
      KSongView.a(this.a).notifyDataSetChanged();
      KSongView.a(this.a, 0);
    }
    QLog.i("KSongView", 2, "InitTask config = " + parambcsp);
    if (KSongView.a(this.a) != null)
    {
      bcsr localbcsr = KSongView.a(this.a);
      if (parambcsp != null) {
        bool = true;
      }
      localbcsr.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcss
 * JD-Core Version:    0.7.0.1
 */