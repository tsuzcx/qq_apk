import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

class azjb
  extends Handler
{
  azjb(azja paramazja, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    azjq.a(this.a.b, this.a.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.a.jdField_a_of_type_Azkx == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        i = paramMessage.arg1;
        paramMessage = (azkf)paramMessage.obj;
        this.a.jdField_a_of_type_Azkx.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (azkf)paramMessage.obj;
      }
    } while (!(paramMessage.a instanceof Integer));
    this.a.jdField_a_of_type_Azkx.a_(((Integer)paramMessage.a).intValue(), paramMessage.c);
    return;
    int i = paramMessage.arg1;
    paramMessage = (azkf)paramMessage.obj;
    this.a.jdField_a_of_type_Azkx.b(i, paramMessage);
    return;
    i = paramMessage.arg1;
    paramMessage = (azkf)paramMessage.obj;
    this.a.jdField_a_of_type_Azkx.c(i, paramMessage);
    return;
    i = paramMessage.arg1;
    paramMessage = (azkf)paramMessage.obj;
    this.a.jdField_a_of_type_Azkx.d(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)paramMessage.obj;
        this.a.jdField_a_of_type_Azkx.a(paramMessage.arg1, localArrayList);
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        localObject = null;
        continue;
      }
      paramMessage = (azkf)paramMessage.obj;
      this.a.jdField_a_of_type_Azkx.a(((Integer)paramMessage.a).intValue());
      return;
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjb
 * JD-Core Version:    0.7.0.1
 */