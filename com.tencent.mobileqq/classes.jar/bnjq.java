import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bnjq
  extends Handler
{
  bnjq(bnjl parambnjl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      aaxb.a("mystatus_shoot", "comp_recomm", 0, 0, new String[0]);
      paramMessage = paramMessage.getData();
      int i = paramMessage.getInt("sceneLvOne");
      paramMessage = paramMessage.getString("sceneName");
      this.a.a(i, paramMessage, true);
      return;
    }
    aaxb.a("mystatus_shoot", "exp_recomm", 0, 0, new String[0]);
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjq
 * JD-Core Version:    0.7.0.1
 */