import android.content.Intent;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;

public class aswq
  implements aswu
{
  public aswq(HuayangLoadbackgroudActivity paramHuayangLoadbackgroudActivity) {}
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(aswm.d(HuayangLoadbackgroudActivity.a(this.a)));
    localIntent.putExtra("key_state", 4);
    localIntent.putExtra("key_progress", paramInt);
    localIntent.putExtra("key_totalSize", 100L);
    this.a.sendBroadcast(localIntent);
  }
  
  public void a(boolean paramBoolean, Throwable paramThrowable)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswq
 * JD-Core Version:    0.7.0.1
 */