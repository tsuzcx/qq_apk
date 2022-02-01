import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class bjgy
  extends Handler
{
  bjgy(bjgx parambjgx, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    case 1000: 
      bjgx localbjgx = this.a;
      if (paramMessage.obj == null) {}
      for (localObject = null;; localObject = (String)paramMessage.obj)
      {
        localbjgx.a((String)localObject);
        break;
      }
    }
    Object localObject = this.a;
    if (((paramMessage.obj instanceof Boolean)) && (((Boolean)paramMessage.obj).booleanValue())) {}
    for (boolean bool = true;; bool = false)
    {
      ((bjgx)localObject).a(bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjgy
 * JD-Core Version:    0.7.0.1
 */