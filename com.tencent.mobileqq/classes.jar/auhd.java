import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class auhd
  extends AsyncTask<Void, Void, Void>
{
  auhd(auhc paramauhc) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = auhc.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    auhc.a(this.a).clear();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auhd
 * JD-Core Version:    0.7.0.1
 */