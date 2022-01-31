import android.annotation.TargetApi;
import android.os.Handler;

class bapq
  extends batl
{
  bapq(bapp parambapp) {}
  
  @TargetApi(9)
  public void onDone(batm parambatm)
  {
    super.onDone(parambatm);
    bapp.a(this.a).sendMessage(bapp.a(this.a).obtainMessage(10002, parambatm.a(), 0, parambatm.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bapq
 * JD-Core Version:    0.7.0.1
 */