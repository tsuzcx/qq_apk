import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import java.util.Iterator;
import java.util.List;

public class asyb
  extends AsyncTask<Void, Void, Integer>
{
  public asyb(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(auds.b(this.a));
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.stopTitleProgress();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      atpr localatpr = (atpr)localIterator.next();
      if (localatpr.e == 4)
      {
        localatpr.d = paramInteger.intValue();
        this.a.jdField_a_of_type_Atpp.notifyDataSetChanged();
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.startTitleProgress();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyb
 * JD-Core Version:    0.7.0.1
 */