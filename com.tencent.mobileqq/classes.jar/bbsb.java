import android.annotation.TargetApi;
import android.os.Handler;

class bbsb
  extends bbwt
{
  bbsb(bbsa parambbsa) {}
  
  @TargetApi(9)
  public void onDone(bbwu parambbwu)
  {
    super.onDone(parambbwu);
    bbsa.a(this.a).sendMessage(bbsa.a(this.a).obtainMessage(10002, parambbwu.a(), 0, parambbwu.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bbsb
 * JD-Core Version:    0.7.0.1
 */