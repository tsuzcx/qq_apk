import android.os.AsyncTask;
import com.tencent.mobileqq.widget.ksong.KSongProsBar;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;

public class bidx
  extends AsyncTask<String, Void, bidu>
{
  public bidx(KSongView paramKSongView) {}
  
  protected bidu a(String... paramVarArgs)
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
  
  protected void a(bidu parambidu)
  {
    boolean bool = false;
    if (parambidu != null)
    {
      if (KSongView.a(this.a) != null) {
        KSongView.a(this.a).a(parambidu);
      }
      KSongView.a(this.a).notifyDataSetChanged();
      KSongView.a(this.a, 0);
    }
    QLog.i("KSongView", 2, "InitTask config = " + parambidu);
    if (KSongView.a(this.a) != null)
    {
      bidw localbidw = KSongView.a(this.a);
      if (parambidu != null) {
        bool = true;
      }
      localbidw.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidx
 * JD-Core Version:    0.7.0.1
 */