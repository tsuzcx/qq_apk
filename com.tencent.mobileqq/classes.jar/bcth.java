import android.os.AsyncTask;
import com.tencent.mobileqq.widget.ksong.KSongProsBar;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;

public class bcth
  extends AsyncTask<String, Void, bcte>
{
  public bcth(KSongView paramKSongView) {}
  
  protected bcte a(String... paramVarArgs)
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
  
  protected void a(bcte parambcte)
  {
    boolean bool = false;
    if (parambcte != null)
    {
      if (KSongView.a(this.a) != null) {
        KSongView.a(this.a).a(parambcte);
      }
      KSongView.a(this.a).notifyDataSetChanged();
      KSongView.a(this.a, 0);
    }
    QLog.i("KSongView", 2, "InitTask config = " + parambcte);
    if (KSongView.a(this.a) != null)
    {
      bctg localbctg = KSongView.a(this.a);
      if (parambcte != null) {
        bool = true;
      }
      localbctg.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcth
 * JD-Core Version:    0.7.0.1
 */