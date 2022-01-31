import android.content.Context;
import android.os.AsyncTask;

final class apvs
  extends er
{
  apvs(Context paramContext) {}
  
  protected void a(AsyncTask<Integer, Integer, String> paramAsyncTask, int paramInt)
  {
    try
    {
      eo.a(this.a, paramAsyncTask, paramInt, new apvt(this));
      super.a(paramAsyncTask, paramInt);
      return;
    }
    catch (Exception paramAsyncTask)
    {
      paramAsyncTask.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apvs
 * JD-Core Version:    0.7.0.1
 */