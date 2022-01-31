import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

class bhse
  extends Handler
{
  bhse(bhsc parambhsc) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      return;
    } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof String[])));
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = (String[])paramMessage.obj;
    localArrayList.add(bhsc.a(this.a, arrayOfString));
    this.a.a(localArrayList, paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhse
 * JD-Core Version:    0.7.0.1
 */