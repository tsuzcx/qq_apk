import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;

class aycp
  extends Handler
{
  aycp(ayco paramayco, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    ayde.a(this.a.b, this.a.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.a.jdField_a_of_type_Ayel == null) {}
    do
    {
      return;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        i = paramMessage.arg1;
        paramMessage = (aydt)paramMessage.obj;
        this.a.jdField_a_of_type_Ayel.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (aydt)paramMessage.obj;
      }
    } while (!(paramMessage.a instanceof Integer));
    this.a.jdField_a_of_type_Ayel.a_(((Integer)paramMessage.a).intValue(), paramMessage.c);
    return;
    int i = paramMessage.arg1;
    paramMessage = (aydt)paramMessage.obj;
    this.a.jdField_a_of_type_Ayel.b(i, paramMessage);
    return;
    i = paramMessage.arg1;
    paramMessage = (aydt)paramMessage.obj;
    this.a.jdField_a_of_type_Ayel.c(i, paramMessage);
    return;
    i = paramMessage.arg1;
    paramMessage = (aydt)paramMessage.obj;
    this.a.jdField_a_of_type_Ayel.d(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        ArrayList localArrayList = (ArrayList)paramMessage.obj;
        this.a.jdField_a_of_type_Ayel.a(paramMessage.arg1, localArrayList);
        return;
      }
      catch (ClassCastException localClassCastException)
      {
        localObject = null;
        continue;
      }
      paramMessage = (aydt)paramMessage.obj;
      this.a.jdField_a_of_type_Ayel.a(((Integer)paramMessage.a).intValue());
      return;
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycp
 * JD-Core Version:    0.7.0.1
 */