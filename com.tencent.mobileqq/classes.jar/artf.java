import android.content.Context;
import android.os.AsyncTask;

final class artf
  extends da
{
  artf(Context paramContext) {}
  
  protected void a(AsyncTask<Integer, Integer, String> paramAsyncTask, int paramInt)
  {
    try
    {
      cx.a(this.a, paramAsyncTask, paramInt, new artg(this));
      super.a(paramAsyncTask, paramInt);
      return;
    }
    catch (Exception paramAsyncTask)
    {
      paramAsyncTask.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     artf
 * JD-Core Version:    0.7.0.1
 */