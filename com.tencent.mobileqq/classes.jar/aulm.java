import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class aulm
  extends AsyncTask<Void, Void, Void>
{
  aulm(aull paramaull) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = aull.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    aull.a(this.a).clear();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aulm
 * JD-Core Version:    0.7.0.1
 */