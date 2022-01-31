import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

class bhrn
  extends Handler
{
  bhrn(bhrl parambhrl) {}
  
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
    localArrayList.add(bhrl.a(this.a, arrayOfString));
    this.a.a(localArrayList, paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhrn
 * JD-Core Version:    0.7.0.1
 */