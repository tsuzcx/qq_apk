import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class asqe
  extends AsyncTask<Void, Void, Void>
{
  asqe(asqd paramasqd) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = asqd.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    asqd.a(this.a).clear();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asqe
 * JD-Core Version:    0.7.0.1
 */