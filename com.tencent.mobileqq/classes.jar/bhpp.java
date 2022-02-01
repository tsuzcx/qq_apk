import android.annotation.TargetApi;
import android.os.Handler;

class bhpp
  extends bhyn
{
  bhpp(bhpo parambhpo) {}
  
  @TargetApi(9)
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    bhpo.a(this.a).sendMessage(bhpo.a(this.a).obtainMessage(10002, parambhyo.a(), 0, parambhyo.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhpp
 * JD-Core Version:    0.7.0.1
 */