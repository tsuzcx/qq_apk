import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

class awii
  extends Handler
{
  awii(awih paramawih, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    awiw.a(this.a.b, this.a.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.a.jdField_a_of_type_Awke == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        i = paramMessage.arg1;
        paramMessage = (awjm)paramMessage.obj;
        this.a.jdField_a_of_type_Awke.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (awjm)paramMessage.obj;
      }
    } while (!(paramMessage.a instanceof Integer));
    this.a.jdField_a_of_type_Awke.a_(((Integer)paramMessage.a).intValue(), paramMessage.c);
    return;
    int i = paramMessage.arg1;
    paramMessage = (awjm)paramMessage.obj;
    this.a.jdField_a_of_type_Awke.b(i, paramMessage);
    return;
    i = paramMessage.arg1;
    paramMessage = (awjm)paramMessage.obj;
    this.a.jdField_a_of_type_Awke.c(i, paramMessage);
    return;
    i = paramMessage.arg1;
    paramMessage = (awjm)paramMessage.obj;
    this.a.jdField_a_of_type_Awke.d(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)paramMessage.obj;
        this.a.jdField_a_of_type_Awke.a(paramMessage.arg1, localArrayList);
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        localObject = null;
        continue;
      }
      paramMessage = (awjm)paramMessage.obj;
      this.a.jdField_a_of_type_Awke.a(((Integer)paramMessage.a).intValue());
      return;
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awii
 * JD-Core Version:    0.7.0.1
 */