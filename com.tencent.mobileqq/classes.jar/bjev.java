import android.os.AsyncTask;
import com.tencent.mobileqq.widget.ksong.KSongProsBar;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;

public class bjev
  extends AsyncTask<String, Void, bjes>
{
  public bjev(KSongView paramKSongView) {}
  
  protected bjes a(String... paramVarArgs)
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
  
  protected void a(bjes parambjes)
  {
    boolean bool = false;
    if (parambjes != null)
    {
      if (KSongView.a(this.a) != null) {
        KSongView.a(this.a).a(parambjes);
      }
      KSongView.a(this.a).notifyDataSetChanged();
      KSongView.a(this.a, 0);
    }
    QLog.i("KSongView", 2, "InitTask config = " + parambjes);
    if (KSongView.a(this.a) != null)
    {
      bjeu localbjeu = KSongView.a(this.a);
      if (parambjes != null) {
        bool = true;
      }
      localbjeu.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjev
 * JD-Core Version:    0.7.0.1
 */