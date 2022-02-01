import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class awsq
  extends AsyncTask<Void, Void, Void>
{
  awsq(awsp paramawsp) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = awsp.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    awsp.a(this.a).clear();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsq
 * JD-Core Version:    0.7.0.1
 */