import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import java.util.Iterator;
import java.util.List;

public class aqli
  extends AsyncTask<Void, Void, Integer>
{
  public aqli(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(arrj.b(this.a));
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.stopTitleProgress();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      arbw localarbw = (arbw)localIterator.next();
      if (localarbw.e == 4)
      {
        localarbw.d = paramInteger.intValue();
        this.a.jdField_a_of_type_Arbu.notifyDataSetChanged();
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
 * Qualified Name:     aqli
 * JD-Core Version:    0.7.0.1
 */