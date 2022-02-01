import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

class bnnk
  extends Handler
{
  bnnk(bnni parambnni) {}
  
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
    localArrayList.add(bnni.a(this.a, arrayOfString));
    this.a.a(localArrayList, paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnnk
 * JD-Core Version:    0.7.0.1
 */