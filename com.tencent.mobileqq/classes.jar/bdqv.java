import android.annotation.TargetApi;
import android.os.Handler;

class bdqv
  extends bdvu
{
  bdqv(bdqu parambdqu) {}
  
  @TargetApi(9)
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    bdqu.a(this.a).sendMessage(bdqu.a(this.a).obtainMessage(10002, parambdvv.a(), 0, parambdvv.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdqv
 * JD-Core Version:    0.7.0.1
 */