import android.annotation.TargetApi;
import android.os.Handler;

class bial
  extends biht
{
  bial(biak parambiak) {}
  
  @TargetApi(9)
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    biak.a(this.a).sendMessage(biak.a(this.a).obtainMessage(10002, parambihu.a(), 0, parambihu.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bial
 * JD-Core Version:    0.7.0.1
 */