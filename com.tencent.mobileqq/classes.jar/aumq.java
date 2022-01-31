import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

class aumq
  extends Handler
{
  aumq(aump paramaump, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    aune.a(this.a.b, this.a.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.a.jdField_a_of_type_Auol == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        i = paramMessage.arg1;
        paramMessage = (aunu)paramMessage.obj;
        this.a.jdField_a_of_type_Auol.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (aunu)paramMessage.obj;
      }
    } while (!(paramMessage.a instanceof Integer));
    this.a.jdField_a_of_type_Auol.a_(((Integer)paramMessage.a).intValue(), paramMessage.c);
    return;
    int i = paramMessage.arg1;
    paramMessage = (aunu)paramMessage.obj;
    this.a.jdField_a_of_type_Auol.b(i, paramMessage);
    return;
    i = paramMessage.arg1;
    paramMessage = (aunu)paramMessage.obj;
    this.a.jdField_a_of_type_Auol.c(i, paramMessage);
    return;
    i = paramMessage.arg1;
    paramMessage = (aunu)paramMessage.obj;
    this.a.jdField_a_of_type_Auol.d(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)paramMessage.obj;
        this.a.jdField_a_of_type_Auol.a(paramMessage.arg1, localArrayList);
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        localObject = null;
        continue;
      }
      paramMessage = (aunu)paramMessage.obj;
      this.a.jdField_a_of_type_Auol.a(((Integer)paramMessage.a).intValue());
      return;
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aumq
 * JD-Core Version:    0.7.0.1
 */