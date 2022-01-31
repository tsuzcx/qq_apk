import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import java.util.Iterator;
import java.util.List;

public class anxd
  extends AsyncTask<Void, Void, Integer>
{
  public anxd(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(apcc.b(this.a));
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.stopTitleProgress();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      aonq localaonq = (aonq)localIterator.next();
      if (localaonq.e == 4)
      {
        localaonq.d = paramInteger.intValue();
        this.a.jdField_a_of_type_Aono.notifyDataSetChanged();
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.startTitleProgress();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     anxd
 * JD-Core Version:    0.7.0.1
 */