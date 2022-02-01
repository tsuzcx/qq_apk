import android.os.AsyncTask;
import com.tencent.mobileqq.widget.ksong.KSongProsBar;
import com.tencent.mobileqq.widget.ksong.KSongView;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;

public class bhlb
  extends AsyncTask<String, Void, bhky>
{
  public bhlb(KSongView paramKSongView) {}
  
  protected bhky a(String... paramVarArgs)
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
  
  protected void a(bhky parambhky)
  {
    boolean bool = false;
    if (parambhky != null)
    {
      if (KSongView.a(this.a) != null) {
        KSongView.a(this.a).a(parambhky);
      }
      KSongView.a(this.a).notifyDataSetChanged();
      KSongView.a(this.a, 0);
    }
    QLog.i("KSongView", 2, "InitTask config = " + parambhky);
    if (KSongView.a(this.a) != null)
    {
      bhla localbhla = KSongView.a(this.a);
      if (parambhky != null) {
        bool = true;
      }
      localbhla.a(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhlb
 * JD-Core Version:    0.7.0.1
 */