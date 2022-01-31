import android.annotation.TargetApi;
import android.os.Handler;

class bbrn
  extends bbwf
{
  bbrn(bbrm parambbrm) {}
  
  @TargetApi(9)
  public void onDone(bbwg parambbwg)
  {
    super.onDone(parambbwg);
    bbrm.a(this.a).sendMessage(bbrm.a(this.a).obtainMessage(10002, parambbwg.a(), 0, parambbwg.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbrn
 * JD-Core Version:    0.7.0.1
 */