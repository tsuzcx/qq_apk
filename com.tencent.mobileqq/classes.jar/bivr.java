import android.os.AsyncTask;
import com.tencent.mobileqq.widget.ksong.KSongProsBar;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;

public class bivr
  extends AsyncTask<String, Void, bivo>
{
  public bivr(KSongView paramKSongView) {}
  
  protected bivo a(String... paramVarArgs)
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
  
  protected void a(bivo parambivo)
  {
    boolean bool = false;
    if (parambivo != null)
    {
      if (KSongView.a(this.a) != null) {
        KSongView.a(this.a).a(parambivo);
      }
      KSongView.a(this.a).notifyDataSetChanged();
      KSongView.a(this.a, 0);
    }
    QLog.i("KSongView", 2, "InitTask config = " + parambivo);
    if (KSongView.a(this.a) != null)
    {
      bivq localbivq = KSongView.a(this.a);
      if (parambivo != null) {
        bool = true;
      }
      localbivq.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bivr
 * JD-Core Version:    0.7.0.1
 */