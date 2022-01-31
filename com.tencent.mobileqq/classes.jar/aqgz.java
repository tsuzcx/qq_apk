import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import java.util.Iterator;
import java.util.List;

public class aqgz
  extends AsyncTask<Void, Void, Integer>
{
  public aqgz(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(arna.b(this.a));
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.stopTitleProgress();
    Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      aqxn localaqxn = (aqxn)localIterator.next();
      if (localaqxn.e == 4)
      {
        localaqxn.d = paramInteger.intValue();
        this.a.jdField_a_of_type_Aqxl.notifyDataSetChanged();
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
 * Qualified Name:     aqgz
 * JD-Core Version:    0.7.0.1
 */