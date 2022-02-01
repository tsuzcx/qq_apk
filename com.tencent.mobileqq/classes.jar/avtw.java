import android.content.Intent;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;

public class avtw
  implements avua
{
  public avtw(HuayangLoadbackgroudActivity paramHuayangLoadbackgroudActivity) {}
  
  public void a(int paramInt)
  {
    Intent localIntent = new Intent(avts.d(HuayangLoadbackgroudActivity.a(this.a)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avtw
 * JD-Core Version:    0.7.0.1
 */