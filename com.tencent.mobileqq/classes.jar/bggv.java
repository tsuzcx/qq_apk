import android.annotation.TargetApi;
import android.os.Handler;

class bggv
  extends bgod
{
  bggv(bggu parambggu) {}
  
  @TargetApi(9)
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    bggu.a(this.a).sendMessage(bggu.a(this.a).obtainMessage(10002, parambgoe.a(), 0, parambgoe.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bggv
 * JD-Core Version:    0.7.0.1
 */