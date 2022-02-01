import android.annotation.TargetApi;
import android.os.Handler;

class bhaf
  extends bhhe
{
  bhaf(bhae parambhae) {}
  
  @TargetApi(9)
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    bhae.a(this.a).sendMessage(bhae.a(this.a).obtainMessage(10002, parambhhf.a(), 0, parambhhf.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhaf
 * JD-Core Version:    0.7.0.1
 */