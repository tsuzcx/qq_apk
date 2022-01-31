import android.os.Message;
import mqq.os.MqqHandler;

class aqnn
  extends MqqHandler
{
  aqnn(aqnm paramaqnm) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      bcql.a(this.a.a.a, 2131719565, 0).a();
      return;
    }
    paramMessage = (String)paramMessage.obj;
    bbef.a(this.a.a.a, paramMessage);
    bcql.a(this.a.a.a, 2, ajya.a(2131700029), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqnn
 * JD-Core Version:    0.7.0.1
 */