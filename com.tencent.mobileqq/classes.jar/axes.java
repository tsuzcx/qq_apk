import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class axes
  extends AsyncTask<Void, Void, Void>
{
  axes(axer paramaxer) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = axer.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    axer.a(this.a).clear();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axes
 * JD-Core Version:    0.7.0.1
 */